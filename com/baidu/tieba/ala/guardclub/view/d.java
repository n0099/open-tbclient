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
/* loaded from: classes4.dex */
public class d extends BdBaseView<GuardClubMemberListActivity> {
    private CommonEmptyView bIx;
    private BaseActivity bQN;
    CustomMessageListener gDG;
    private LoadMoreFooter gPE;
    private com.baidu.tieba.ala.guardclub.model.e gPc;
    private BdListView gRQ;
    private g gRR;
    private m gRS;
    private View mRootView;
    private String otherParams;

    public View getView() {
        return this.mRootView;
    }

    public d(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity.getPageContext());
        this.gDG = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.view.d.3
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
        this.bQN = baseActivity;
        this.mRootView = LayoutInflater.from(this.bQN).inflate(a.g.layout_guard_club_join_list, (ViewGroup) null);
        this.gRQ = (BdListView) this.mRootView.findViewById(a.f.list_guard_club_join);
        this.gRR = new g(baseActivity, bdUniqueId);
        this.gRR.a(new AnonymousClass1(baseActivity));
        this.gRQ.setAdapter((ListAdapter) this.gRR);
        this.gPE = new LoadMoreFooter(this.bQN);
        this.gPE.setBackgroundColor(-1);
        this.gPE.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_b));
        this.gPE.createView();
        this.gRQ.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.view.d.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (!d.this.gPE.isLoading() && d.this.gPc.bWo() && i + i2 > i3 - 2 && d.this.gPc.bWo()) {
                    d.this.gPc.bWq();
                }
            }
        });
        MessageManager.getInstance().registerListener(this.gDG);
        this.bIx = (CommonEmptyView) this.mRootView.findViewById(a.f.guard_club_join_empty_view);
    }

    /* renamed from: com.baidu.tieba.ala.guardclub.view.d$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    class AnonymousClass1 implements g.b {
        final /* synthetic */ BaseActivity gRT;

        AnonymousClass1(BaseActivity baseActivity) {
            this.gRT = baseActivity;
        }

        @Override // com.baidu.tieba.ala.guardclub.g.b
        public void a(com.baidu.tieba.ala.guardclub.model.d dVar, int i) {
            if (dVar != null && d.this.gPc != null) {
                if (d.this.gRS == null) {
                    d.this.gRS = new m(this.gRT.getPageContext());
                    d.this.gRS.a(new m.a() { // from class: com.baidu.tieba.ala.guardclub.view.d.1.1
                        @Override // com.baidu.tieba.ala.guardclub.m.a
                        public void c(final com.baidu.tieba.ala.guardclub.model.d dVar2, final int i2) {
                            LogManager.getGuardClubLogger().doClickLiveLeaveGuardLog();
                            if (d.this.gPc != null && dVar2 != null) {
                                d.this.gPc.a(dVar2.id, new e.b() { // from class: com.baidu.tieba.ala.guardclub.view.d.1.1.1
                                    @Override // com.baidu.tieba.ala.guardclub.model.e.b
                                    public void b(int i3, String str, Object obj) {
                                        d.this.gRR.vN(i2);
                                        if (d.this.gRR.getCount() <= 0) {
                                            d.this.bSj();
                                        }
                                        d.this.showToast(dVar2.biN);
                                    }
                                });
                            }
                        }
                    });
                }
                d.this.gRS.b(dVar, i);
                LogManager.getGuardClubLogger().doDisplayLiveLeaveGuardLog();
            }
        }
    }

    public void completePullRefresh() {
        if (this.gRQ != null) {
            this.gRQ.completePullRefresh();
        }
    }

    public void bWl() {
        if (this.gPE != null) {
            this.gPE.endLoadData();
            this.gRQ.setNextPage(null);
        }
    }

    public void mO(boolean z) {
        if (z) {
            if (this.gPE != null) {
                this.gRQ.setNextPage(null);
            }
        } else if (this.gPE != null) {
            if (this.gPE.getView().getParent() == null) {
                this.gRQ.setNextPage(this.gPE);
            }
            this.gPE.showNoMoreData();
        }
    }

    public void bSc() {
        if (this.gPE != null) {
            if (this.gPE.getView().getParent() == null) {
                this.gRQ.setNextPage(this.gPE);
            }
            this.gPE.showLoadView();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.gRR != null) {
            this.gRR.notifyDataSetInvalidated();
        }
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSj() {
        bL(8, 0);
    }

    public void f(com.baidu.tieba.ala.guardclub.model.e eVar) {
        this.gPc = eVar;
        this.gPc.bWp();
    }

    public void cp(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (this.gRR != null && list != null && !list.isEmpty()) {
            bL(0, 8);
            this.gRR.cp(list);
            return;
        }
        bSj();
    }

    private void bL(int i, int i2) {
        this.gRQ.setVisibility(i);
        if (i2 == 0) {
            this.bIx.reset();
            this.bIx.setTitle(a.h.guard_join_list_empty);
            this.bIx.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.LIGHT);
            this.bIx.setVisibility(0);
            return;
        }
        this.bIx.setVisibility(8);
    }

    public void cq(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (this.gRR != null) {
            this.gRR.cq(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showToast(String str) {
        Toast makeText = Toast.makeText(this.mContext.getPageActivity(), (CharSequence) null, 0);
        makeText.setGravity(17, 0, 0);
        makeText.setText(String.format(this.mContext.getResources().getString(a.h.guard_club_exit_success_toast), str));
        makeText.show();
    }

    public void bWj() {
        if (this.gRR != null) {
            this.gRR.bWj();
        }
        MessageManager.getInstance().unRegisterListener(this.gDG);
    }

    public void bOY() {
        this.bIx.reset();
        this.bIx.setTitle(a.h.sdk_net_fail_tip_rank);
        this.bIx.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.view.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.bIx.setVisibility(8);
                if (d.this.gPc != null) {
                    d.this.gPc.bWp();
                }
            }
        });
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.bIx.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
        } else {
            this.bIx.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
        }
        this.bIx.setVisibility(0);
        this.gRQ.setVisibility(8);
    }
}
