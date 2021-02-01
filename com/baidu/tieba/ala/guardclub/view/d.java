package com.baidu.tieba.ala.guardclub.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.Toast;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.core.view.LoadMoreFooter;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.tieba.ala.guardclub.GuardClubMemberListActivity;
import com.baidu.tieba.ala.guardclub.g;
import com.baidu.tieba.ala.guardclub.m;
import com.baidu.tieba.ala.guardclub.model.e;
import java.util.List;
/* loaded from: classes11.dex */
public class d extends BdBaseView<GuardClubMemberListActivity> {
    private CommonEmptyView bMk;
    private BaseActivity bVA;
    CustomMessageListener gNs;
    private com.baidu.tieba.ala.guardclub.model.e gYT;
    private LoadMoreFooter gZv;
    private BdListView hbH;
    private g hbI;
    private m hbJ;
    private View mRootView;
    private String otherParams;

    public View getView() {
        return this.mRootView;
    }

    public d(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity.getPageContext());
        this.gNs = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.view.d.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (str == null) {
                        str = "";
                    }
                    d.this.otherParams = str;
                }
            }
        };
        this.bVA = baseActivity;
        this.mRootView = LayoutInflater.from(this.bVA).inflate(a.g.layout_guard_club_join_list, (ViewGroup) null);
        this.hbH = (BdListView) this.mRootView.findViewById(a.f.list_guard_club_join);
        this.hbI = new g(baseActivity, bdUniqueId);
        this.hbI.a(new AnonymousClass1(baseActivity));
        this.hbH.setAdapter((ListAdapter) this.hbI);
        this.gZv = new LoadMoreFooter(this.bVA);
        this.gZv.setBackgroundColor(-1);
        this.gZv.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_b));
        this.gZv.createView();
        this.hbH.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.view.d.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (!d.this.gZv.isLoading() && d.this.gYT.bVH() && i + i2 > i3 - 2 && d.this.gYT.bVH()) {
                    d.this.gYT.bVJ();
                }
            }
        });
        MessageManager.getInstance().registerListener(this.gNs);
        this.bMk = (CommonEmptyView) this.mRootView.findViewById(a.f.guard_club_join_empty_view);
    }

    /* renamed from: com.baidu.tieba.ala.guardclub.view.d$1  reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass1 implements g.b {
        final /* synthetic */ BaseActivity hbK;

        AnonymousClass1(BaseActivity baseActivity) {
            this.hbK = baseActivity;
        }

        @Override // com.baidu.tieba.ala.guardclub.g.b
        public void a(com.baidu.tieba.ala.guardclub.model.d dVar, int i) {
            if (dVar != null && d.this.gYT != null) {
                if (d.this.hbJ == null) {
                    d.this.hbJ = new m(this.hbK.getPageContext());
                    d.this.hbJ.a(new m.a() { // from class: com.baidu.tieba.ala.guardclub.view.d.1.1
                        @Override // com.baidu.tieba.ala.guardclub.m.a
                        public void c(final com.baidu.tieba.ala.guardclub.model.d dVar2, final int i2) {
                            LogManager.getGuardClubLogger().doClickLiveLeaveGuardLog();
                            if (d.this.gYT != null && dVar2 != null) {
                                d.this.gYT.a(dVar2.id, new e.b() { // from class: com.baidu.tieba.ala.guardclub.view.d.1.1.1
                                    @Override // com.baidu.tieba.ala.guardclub.model.e.b
                                    public void b(int i3, String str, Object obj) {
                                        d.this.hbI.uy(i2);
                                        if (d.this.hbI.getCount() <= 0) {
                                            d.this.bRy();
                                        }
                                        d.this.showToast(dVar2.biL);
                                    }
                                });
                            }
                        }
                    });
                }
                d.this.hbJ.b(dVar, i);
                LogManager.getGuardClubLogger().doDisplayLiveLeaveGuardLog();
            }
        }
    }

    public void completePullRefresh() {
        if (this.hbH != null) {
            this.hbH.completePullRefresh();
        }
    }

    public void bVE() {
        if (this.gZv != null) {
            this.gZv.endLoadData();
            this.hbH.setNextPage(null);
        }
    }

    public void np(boolean z) {
        if (z) {
            if (this.gZv != null) {
                this.hbH.setNextPage(null);
            }
        } else if (this.gZv != null) {
            if (this.gZv.getView().getParent() == null) {
                this.hbH.setNextPage(this.gZv);
            }
            this.gZv.showNoMoreData();
        }
    }

    public void bRr() {
        if (this.gZv != null) {
            if (this.gZv.getView().getParent() == null) {
                this.hbH.setNextPage(this.gZv);
            }
            this.gZv.showLoadView();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.hbI != null) {
            this.hbI.notifyDataSetInvalidated();
        }
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRy() {
        bH(8, 0);
    }

    public void f(com.baidu.tieba.ala.guardclub.model.e eVar) {
        this.gYT = eVar;
        this.gYT.bVI();
    }

    public void cr(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (this.hbI != null && list != null && !list.isEmpty()) {
            bH(0, 8);
            this.hbI.cr(list);
            return;
        }
        bRy();
    }

    private void bH(int i, int i2) {
        this.hbH.setVisibility(i);
        if (i2 == 0) {
            this.bMk.reset();
            this.bMk.setTitle(a.h.guard_join_list_empty);
            this.bMk.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.LIGHT);
            this.bMk.setVisibility(0);
            return;
        }
        this.bMk.setVisibility(8);
    }

    public void cs(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (this.hbI != null) {
            this.hbI.cs(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showToast(String str) {
        Toast makeText = Toast.makeText(this.mContext.getPageActivity(), (CharSequence) null, 0);
        makeText.setGravity(17, 0, 0);
        makeText.setText(String.format(this.mContext.getResources().getString(a.h.guard_club_exit_success_toast), str));
        makeText.show();
    }

    public void bVC() {
        if (this.hbI != null) {
            this.hbI.bVC();
        }
        MessageManager.getInstance().unRegisterListener(this.gNs);
    }

    public void bOi() {
        this.bMk.reset();
        this.bMk.setTitle(a.h.sdk_net_fail_tip_rank);
        this.bMk.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.view.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.bMk.setVisibility(8);
                if (d.this.gYT != null) {
                    d.this.gYT.bVI();
                }
            }
        });
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.bMk.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
        } else {
            this.bMk.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
        }
        this.bMk.setVisibility(0);
        this.hbH.setVisibility(8);
    }
}
