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
/* loaded from: classes10.dex */
public class d extends BdBaseView<GuardClubMemberListActivity> {
    private CommonEmptyView bNK;
    private BaseActivity bXa;
    CustomMessageListener gPp;
    private com.baidu.tieba.ala.guardclub.model.e haQ;
    private LoadMoreFooter hbs;
    private BdListView hdE;
    private g hdF;
    private m hdG;
    private View mRootView;
    private String otherParams;

    public View getView() {
        return this.mRootView;
    }

    public d(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity.getPageContext());
        this.gPp = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.view.d.3
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
        this.bXa = baseActivity;
        this.mRootView = LayoutInflater.from(this.bXa).inflate(a.g.layout_guard_club_join_list, (ViewGroup) null);
        this.hdE = (BdListView) this.mRootView.findViewById(a.f.list_guard_club_join);
        this.hdF = new g(baseActivity, bdUniqueId);
        this.hdF.a(new AnonymousClass1(baseActivity));
        this.hdE.setAdapter((ListAdapter) this.hdF);
        this.hbs = new LoadMoreFooter(this.bXa);
        this.hbs.setBackgroundColor(-1);
        this.hbs.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_b));
        this.hbs.createView();
        this.hdE.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.view.d.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (!d.this.hbs.isLoading() && d.this.haQ.bVU() && i + i2 > i3 - 2 && d.this.haQ.bVU()) {
                    d.this.haQ.bVW();
                }
            }
        });
        MessageManager.getInstance().registerListener(this.gPp);
        this.bNK = (CommonEmptyView) this.mRootView.findViewById(a.f.guard_club_join_empty_view);
    }

    /* renamed from: com.baidu.tieba.ala.guardclub.view.d$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    class AnonymousClass1 implements g.b {
        final /* synthetic */ BaseActivity hdH;

        AnonymousClass1(BaseActivity baseActivity) {
            this.hdH = baseActivity;
        }

        @Override // com.baidu.tieba.ala.guardclub.g.b
        public void a(com.baidu.tieba.ala.guardclub.model.d dVar, int i) {
            if (dVar != null && d.this.haQ != null) {
                if (d.this.hdG == null) {
                    d.this.hdG = new m(this.hdH.getPageContext());
                    d.this.hdG.a(new m.a() { // from class: com.baidu.tieba.ala.guardclub.view.d.1.1
                        @Override // com.baidu.tieba.ala.guardclub.m.a
                        public void c(final com.baidu.tieba.ala.guardclub.model.d dVar2, final int i2) {
                            LogManager.getGuardClubLogger().doClickLiveLeaveGuardLog();
                            if (d.this.haQ != null && dVar2 != null) {
                                d.this.haQ.a(dVar2.id, new e.b() { // from class: com.baidu.tieba.ala.guardclub.view.d.1.1.1
                                    @Override // com.baidu.tieba.ala.guardclub.model.e.b
                                    public void b(int i3, String str, Object obj) {
                                        d.this.hdF.uA(i2);
                                        if (d.this.hdF.getCount() <= 0) {
                                            d.this.bRL();
                                        }
                                        d.this.showToast(dVar2.bkl);
                                    }
                                });
                            }
                        }
                    });
                }
                d.this.hdG.b(dVar, i);
                LogManager.getGuardClubLogger().doDisplayLiveLeaveGuardLog();
            }
        }
    }

    public void completePullRefresh() {
        if (this.hdE != null) {
            this.hdE.completePullRefresh();
        }
    }

    public void bVR() {
        if (this.hbs != null) {
            this.hbs.endLoadData();
            this.hdE.setNextPage(null);
        }
    }

    public void np(boolean z) {
        if (z) {
            if (this.hbs != null) {
                this.hdE.setNextPage(null);
            }
        } else if (this.hbs != null) {
            if (this.hbs.getView().getParent() == null) {
                this.hdE.setNextPage(this.hbs);
            }
            this.hbs.showNoMoreData();
        }
    }

    public void bRE() {
        if (this.hbs != null) {
            if (this.hbs.getView().getParent() == null) {
                this.hdE.setNextPage(this.hbs);
            }
            this.hbs.showLoadView();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.hdF != null) {
            this.hdF.notifyDataSetInvalidated();
        }
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRL() {
        bI(8, 0);
    }

    public void f(com.baidu.tieba.ala.guardclub.model.e eVar) {
        this.haQ = eVar;
        this.haQ.bVV();
    }

    public void cr(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (this.hdF != null && list != null && !list.isEmpty()) {
            bI(0, 8);
            this.hdF.cr(list);
            return;
        }
        bRL();
    }

    private void bI(int i, int i2) {
        this.hdE.setVisibility(i);
        if (i2 == 0) {
            this.bNK.reset();
            this.bNK.setTitle(a.h.guard_join_list_empty);
            this.bNK.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.LIGHT);
            this.bNK.setVisibility(0);
            return;
        }
        this.bNK.setVisibility(8);
    }

    public void cs(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (this.hdF != null) {
            this.hdF.cs(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showToast(String str) {
        Toast makeText = Toast.makeText(this.mContext.getPageActivity(), (CharSequence) null, 0);
        makeText.setGravity(17, 0, 0);
        makeText.setText(String.format(this.mContext.getResources().getString(a.h.guard_club_exit_success_toast), str));
        makeText.show();
    }

    public void bVP() {
        if (this.hdF != null) {
            this.hdF.bVP();
        }
        MessageManager.getInstance().unRegisterListener(this.gPp);
    }

    public void bOv() {
        this.bNK.reset();
        this.bNK.setTitle(a.h.sdk_net_fail_tip_rank);
        this.bNK.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.view.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.bNK.setVisibility(8);
                if (d.this.haQ != null) {
                    d.this.haQ.bVV();
                }
            }
        });
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.bNK.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
        } else {
            this.bNK.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
        }
        this.bNK.setVisibility(0);
        this.hdE.setVisibility(8);
    }
}
