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
import com.baidu.tieba.ala.guardclub.f;
import com.baidu.tieba.ala.guardclub.l;
import com.baidu.tieba.ala.guardclub.model.e;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends BdBaseView<GuardClubMemberListActivity> {
    private CommonEmptyView bjW;
    private BaseActivity bpg;
    CustomMessageListener fEy;
    private e fON;
    private LoadMoreFooter fPr;
    private BdListView fRB;
    private f fRC;
    private l fRD;
    private View mRootView;
    private String otherParams;

    public View getView() {
        return this.mRootView;
    }

    public d(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity.getPageContext());
        this.fEy = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.view.d.3
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
        this.bpg = baseActivity;
        this.mRootView = LayoutInflater.from(this.bpg).inflate(a.h.layout_guard_club_join_list, (ViewGroup) null);
        this.fRB = (BdListView) this.mRootView.findViewById(a.g.list_guard_club_join);
        this.fRC = new f(baseActivity, bdUniqueId);
        this.fRC.a(new AnonymousClass1(baseActivity));
        this.fRB.setAdapter((ListAdapter) this.fRC);
        this.fPr = new LoadMoreFooter(this.bpg);
        this.fPr.setBackgroundColor(-1);
        this.fPr.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_b));
        this.fPr.createView();
        this.fRB.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.view.d.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (!d.this.fPr.isLoading() && d.this.fON.bAR() && i + i2 > i3 - 2 && d.this.fON.bAR()) {
                    d.this.fON.bAT();
                }
            }
        });
        MessageManager.getInstance().registerListener(this.fEy);
        this.bjW = (CommonEmptyView) this.mRootView.findViewById(a.g.guard_club_join_empty_view);
    }

    /* renamed from: com.baidu.tieba.ala.guardclub.view.d$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    class AnonymousClass1 implements f.b {
        final /* synthetic */ BaseActivity fRE;

        AnonymousClass1(BaseActivity baseActivity) {
            this.fRE = baseActivity;
        }

        @Override // com.baidu.tieba.ala.guardclub.f.b
        public void a(com.baidu.tieba.ala.guardclub.model.d dVar, int i) {
            if (dVar != null && d.this.fON != null) {
                if (d.this.fRD == null) {
                    d.this.fRD = new l(this.fRE.getPageContext());
                    d.this.fRD.a(new l.a() { // from class: com.baidu.tieba.ala.guardclub.view.d.1.1
                        @Override // com.baidu.tieba.ala.guardclub.l.a
                        public void c(final com.baidu.tieba.ala.guardclub.model.d dVar2, final int i2) {
                            LogManager.getGuardClubLogger().doClickLiveLeaveGuardLog();
                            if (d.this.fON != null && dVar2 != null) {
                                d.this.fON.a(dVar2.id, new e.b() { // from class: com.baidu.tieba.ala.guardclub.view.d.1.1.1
                                    @Override // com.baidu.tieba.ala.guardclub.model.e.b
                                    public void b(int i3, String str, Object obj) {
                                        d.this.fRC.rd(i2);
                                        if (d.this.fRC.getCount() <= 0) {
                                            d.this.bxb();
                                        }
                                        d.this.showToast(dVar2.aSt);
                                    }
                                });
                            }
                        }
                    });
                }
                d.this.fRD.b(dVar, i);
                LogManager.getGuardClubLogger().doDisplayLiveLeaveGuardLog();
            }
        }
    }

    public void completePullRefresh() {
        if (this.fRB != null) {
            this.fRB.completePullRefresh();
        }
    }

    public void bAM() {
        if (this.fPr != null) {
            this.fPr.endLoadData();
            this.fRB.setNextPage(null);
        }
    }

    public void kR(boolean z) {
        if (z) {
            if (this.fPr != null) {
                this.fRB.setNextPage(null);
            }
        } else if (this.fPr != null) {
            if (this.fPr.getView().getParent() == null) {
                this.fRB.setNextPage(this.fPr);
            }
            this.fPr.showNoMoreData();
        }
    }

    public void bwT() {
        if (this.fPr != null) {
            if (this.fPr.getView().getParent() == null) {
                this.fRB.setNextPage(this.fPr);
            }
            this.fPr.showLoadView();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.fRC != null) {
            this.fRC.notifyDataSetInvalidated();
        }
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxb() {
        by(8, 0);
    }

    public void f(e eVar) {
        this.fON = eVar;
        this.fON.bAS();
    }

    public void bL(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (this.fRC != null && list != null && !list.isEmpty()) {
            by(0, 8);
            this.fRC.bL(list);
            return;
        }
        bxb();
    }

    private void by(int i, int i2) {
        this.fRB.setVisibility(i);
        if (i2 == 0) {
            this.bjW.reset();
            this.bjW.setTitle(a.i.guard_join_list_empty);
            this.bjW.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.LIGHT);
            this.bjW.setVisibility(0);
            return;
        }
        this.bjW.setVisibility(8);
    }

    public void bM(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (this.fRC != null) {
            this.fRC.bM(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showToast(String str) {
        Toast makeText = Toast.makeText(this.mContext.getPageActivity(), (CharSequence) null, 0);
        makeText.setGravity(17, 0, 0);
        makeText.setText(String.format(this.mContext.getResources().getString(a.i.guard_club_exit_success_toast), str));
        makeText.show();
    }

    public void bAK() {
        if (this.fRC != null) {
            this.fRC.bAK();
        }
        MessageManager.getInstance().unRegisterListener(this.fEy);
    }

    public void buK() {
        this.bjW.reset();
        this.bjW.setTitle(a.i.sdk_net_fail_tip_rank);
        this.bjW.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.view.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.bjW.setVisibility(8);
                if (d.this.fON != null) {
                    d.this.fON.bAS();
                }
            }
        });
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.bjW.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
        } else {
            this.bjW.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
        }
        this.bjW.setVisibility(0);
        this.fRB.setVisibility(8);
    }
}
