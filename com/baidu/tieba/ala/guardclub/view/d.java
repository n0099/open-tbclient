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
    CustomMessageListener gDE;
    private LoadMoreFooter gPC;
    private com.baidu.tieba.ala.guardclub.model.e gPa;
    private BdListView gRO;
    private g gRP;
    private m gRQ;
    private View mRootView;
    private String otherParams;

    public View getView() {
        return this.mRootView;
    }

    public d(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity.getPageContext());
        this.gDE = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.view.d.3
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
        this.gRO = (BdListView) this.mRootView.findViewById(a.f.list_guard_club_join);
        this.gRP = new g(baseActivity, bdUniqueId);
        this.gRP.a(new AnonymousClass1(baseActivity));
        this.gRO.setAdapter((ListAdapter) this.gRP);
        this.gPC = new LoadMoreFooter(this.bQN);
        this.gPC.setBackgroundColor(-1);
        this.gPC.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_b));
        this.gPC.createView();
        this.gRO.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.view.d.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (!d.this.gPC.isLoading() && d.this.gPa.bWn() && i + i2 > i3 - 2 && d.this.gPa.bWn()) {
                    d.this.gPa.bWp();
                }
            }
        });
        MessageManager.getInstance().registerListener(this.gDE);
        this.bIx = (CommonEmptyView) this.mRootView.findViewById(a.f.guard_club_join_empty_view);
    }

    /* renamed from: com.baidu.tieba.ala.guardclub.view.d$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    class AnonymousClass1 implements g.b {
        final /* synthetic */ BaseActivity gRR;

        AnonymousClass1(BaseActivity baseActivity) {
            this.gRR = baseActivity;
        }

        @Override // com.baidu.tieba.ala.guardclub.g.b
        public void a(com.baidu.tieba.ala.guardclub.model.d dVar, int i) {
            if (dVar != null && d.this.gPa != null) {
                if (d.this.gRQ == null) {
                    d.this.gRQ = new m(this.gRR.getPageContext());
                    d.this.gRQ.a(new m.a() { // from class: com.baidu.tieba.ala.guardclub.view.d.1.1
                        @Override // com.baidu.tieba.ala.guardclub.m.a
                        public void c(final com.baidu.tieba.ala.guardclub.model.d dVar2, final int i2) {
                            LogManager.getGuardClubLogger().doClickLiveLeaveGuardLog();
                            if (d.this.gPa != null && dVar2 != null) {
                                d.this.gPa.a(dVar2.id, new e.b() { // from class: com.baidu.tieba.ala.guardclub.view.d.1.1.1
                                    @Override // com.baidu.tieba.ala.guardclub.model.e.b
                                    public void b(int i3, String str, Object obj) {
                                        d.this.gRP.vN(i2);
                                        if (d.this.gRP.getCount() <= 0) {
                                            d.this.bSi();
                                        }
                                        d.this.showToast(dVar2.biN);
                                    }
                                });
                            }
                        }
                    });
                }
                d.this.gRQ.b(dVar, i);
                LogManager.getGuardClubLogger().doDisplayLiveLeaveGuardLog();
            }
        }
    }

    public void completePullRefresh() {
        if (this.gRO != null) {
            this.gRO.completePullRefresh();
        }
    }

    public void bWk() {
        if (this.gPC != null) {
            this.gPC.endLoadData();
            this.gRO.setNextPage(null);
        }
    }

    public void mO(boolean z) {
        if (z) {
            if (this.gPC != null) {
                this.gRO.setNextPage(null);
            }
        } else if (this.gPC != null) {
            if (this.gPC.getView().getParent() == null) {
                this.gRO.setNextPage(this.gPC);
            }
            this.gPC.showNoMoreData();
        }
    }

    public void bSb() {
        if (this.gPC != null) {
            if (this.gPC.getView().getParent() == null) {
                this.gRO.setNextPage(this.gPC);
            }
            this.gPC.showLoadView();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.gRP != null) {
            this.gRP.notifyDataSetInvalidated();
        }
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSi() {
        bL(8, 0);
    }

    public void f(com.baidu.tieba.ala.guardclub.model.e eVar) {
        this.gPa = eVar;
        this.gPa.bWo();
    }

    public void cp(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (this.gRP != null && list != null && !list.isEmpty()) {
            bL(0, 8);
            this.gRP.cp(list);
            return;
        }
        bSi();
    }

    private void bL(int i, int i2) {
        this.gRO.setVisibility(i);
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
        if (this.gRP != null) {
            this.gRP.cq(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showToast(String str) {
        Toast makeText = Toast.makeText(this.mContext.getPageActivity(), (CharSequence) null, 0);
        makeText.setGravity(17, 0, 0);
        makeText.setText(String.format(this.mContext.getResources().getString(a.h.guard_club_exit_success_toast), str));
        makeText.show();
    }

    public void bWi() {
        if (this.gRP != null) {
            this.gRP.bWi();
        }
        MessageManager.getInstance().unRegisterListener(this.gDE);
    }

    public void bOX() {
        this.bIx.reset();
        this.bIx.setTitle(a.h.sdk_net_fail_tip_rank);
        this.bIx.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.view.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.bIx.setVisibility(8);
                if (d.this.gPa != null) {
                    d.this.gPa.bWo();
                }
            }
        });
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.bIx.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
        } else {
            this.bIx.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
        }
        this.bIx.setVisibility(0);
        this.gRO.setVisibility(8);
    }
}
