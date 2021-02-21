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
    CustomMessageListener gNG;
    private LoadMoreFooter gZJ;
    private com.baidu.tieba.ala.guardclub.model.e gZh;
    private BdListView hbV;
    private g hbW;
    private m hbX;
    private View mRootView;
    private String otherParams;

    public View getView() {
        return this.mRootView;
    }

    public d(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity.getPageContext());
        this.gNG = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.view.d.3
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
        this.hbV = (BdListView) this.mRootView.findViewById(a.f.list_guard_club_join);
        this.hbW = new g(baseActivity, bdUniqueId);
        this.hbW.a(new AnonymousClass1(baseActivity));
        this.hbV.setAdapter((ListAdapter) this.hbW);
        this.gZJ = new LoadMoreFooter(this.bVA);
        this.gZJ.setBackgroundColor(-1);
        this.gZJ.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_b));
        this.gZJ.createView();
        this.hbV.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.view.d.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (!d.this.gZJ.isLoading() && d.this.gZh.bVO() && i + i2 > i3 - 2 && d.this.gZh.bVO()) {
                    d.this.gZh.bVQ();
                }
            }
        });
        MessageManager.getInstance().registerListener(this.gNG);
        this.bMk = (CommonEmptyView) this.mRootView.findViewById(a.f.guard_club_join_empty_view);
    }

    /* renamed from: com.baidu.tieba.ala.guardclub.view.d$1  reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass1 implements g.b {
        final /* synthetic */ BaseActivity hbY;

        AnonymousClass1(BaseActivity baseActivity) {
            this.hbY = baseActivity;
        }

        @Override // com.baidu.tieba.ala.guardclub.g.b
        public void a(com.baidu.tieba.ala.guardclub.model.d dVar, int i) {
            if (dVar != null && d.this.gZh != null) {
                if (d.this.hbX == null) {
                    d.this.hbX = new m(this.hbY.getPageContext());
                    d.this.hbX.a(new m.a() { // from class: com.baidu.tieba.ala.guardclub.view.d.1.1
                        @Override // com.baidu.tieba.ala.guardclub.m.a
                        public void c(final com.baidu.tieba.ala.guardclub.model.d dVar2, final int i2) {
                            LogManager.getGuardClubLogger().doClickLiveLeaveGuardLog();
                            if (d.this.gZh != null && dVar2 != null) {
                                d.this.gZh.a(dVar2.id, new e.b() { // from class: com.baidu.tieba.ala.guardclub.view.d.1.1.1
                                    @Override // com.baidu.tieba.ala.guardclub.model.e.b
                                    public void b(int i3, String str, Object obj) {
                                        d.this.hbW.uy(i2);
                                        if (d.this.hbW.getCount() <= 0) {
                                            d.this.bRF();
                                        }
                                        d.this.showToast(dVar2.biL);
                                    }
                                });
                            }
                        }
                    });
                }
                d.this.hbX.b(dVar, i);
                LogManager.getGuardClubLogger().doDisplayLiveLeaveGuardLog();
            }
        }
    }

    public void completePullRefresh() {
        if (this.hbV != null) {
            this.hbV.completePullRefresh();
        }
    }

    public void bVL() {
        if (this.gZJ != null) {
            this.gZJ.endLoadData();
            this.hbV.setNextPage(null);
        }
    }

    public void np(boolean z) {
        if (z) {
            if (this.gZJ != null) {
                this.hbV.setNextPage(null);
            }
        } else if (this.gZJ != null) {
            if (this.gZJ.getView().getParent() == null) {
                this.hbV.setNextPage(this.gZJ);
            }
            this.gZJ.showNoMoreData();
        }
    }

    public void bRy() {
        if (this.gZJ != null) {
            if (this.gZJ.getView().getParent() == null) {
                this.hbV.setNextPage(this.gZJ);
            }
            this.gZJ.showLoadView();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.hbW != null) {
            this.hbW.notifyDataSetInvalidated();
        }
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRF() {
        bI(8, 0);
    }

    public void f(com.baidu.tieba.ala.guardclub.model.e eVar) {
        this.gZh = eVar;
        this.gZh.bVP();
    }

    public void cr(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (this.hbW != null && list != null && !list.isEmpty()) {
            bI(0, 8);
            this.hbW.cr(list);
            return;
        }
        bRF();
    }

    private void bI(int i, int i2) {
        this.hbV.setVisibility(i);
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
        if (this.hbW != null) {
            this.hbW.cs(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showToast(String str) {
        Toast makeText = Toast.makeText(this.mContext.getPageActivity(), (CharSequence) null, 0);
        makeText.setGravity(17, 0, 0);
        makeText.setText(String.format(this.mContext.getResources().getString(a.h.guard_club_exit_success_toast), str));
        makeText.show();
    }

    public void bVJ() {
        if (this.hbW != null) {
            this.hbW.bVJ();
        }
        MessageManager.getInstance().unRegisterListener(this.gNG);
    }

    public void bOp() {
        this.bMk.reset();
        this.bMk.setTitle(a.h.sdk_net_fail_tip_rank);
        this.bMk.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.view.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.bMk.setVisibility(8);
                if (d.this.gZh != null) {
                    d.this.gZh.bVP();
                }
            }
        });
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.bMk.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
        } else {
            this.bMk.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
        }
        this.bMk.setVisibility(0);
        this.hbV.setVisibility(8);
    }
}
