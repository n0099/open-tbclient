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
    private BaseActivity bHN;
    private CommonEmptyView byP;
    private e gAy;
    private LoadMoreFooter gBa;
    private BdListView gDi;
    private f gDj;
    private l gDk;
    CustomMessageListener gpA;
    private View mRootView;
    private String otherParams;

    public View getView() {
        return this.mRootView;
    }

    public d(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity.getPageContext());
        this.gpA = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.view.d.3
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
        this.bHN = baseActivity;
        this.mRootView = LayoutInflater.from(this.bHN).inflate(a.h.layout_guard_club_join_list, (ViewGroup) null);
        this.gDi = (BdListView) this.mRootView.findViewById(a.g.list_guard_club_join);
        this.gDj = new f(baseActivity, bdUniqueId);
        this.gDj.a(new AnonymousClass1(baseActivity));
        this.gDi.setAdapter((ListAdapter) this.gDj);
        this.gBa = new LoadMoreFooter(this.bHN);
        this.gBa.setBackgroundColor(-1);
        this.gBa.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_b));
        this.gBa.createView();
        this.gDi.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.view.d.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (!d.this.gBa.isLoading() && d.this.gAy.bQL() && i + i2 > i3 - 2 && d.this.gAy.bQL()) {
                    d.this.gAy.bQN();
                }
            }
        });
        MessageManager.getInstance().registerListener(this.gpA);
        this.byP = (CommonEmptyView) this.mRootView.findViewById(a.g.guard_club_join_empty_view);
    }

    /* renamed from: com.baidu.tieba.ala.guardclub.view.d$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    class AnonymousClass1 implements f.b {
        final /* synthetic */ BaseActivity gDl;

        AnonymousClass1(BaseActivity baseActivity) {
            this.gDl = baseActivity;
        }

        @Override // com.baidu.tieba.ala.guardclub.f.b
        public void a(com.baidu.tieba.ala.guardclub.model.d dVar, int i) {
            if (dVar != null && d.this.gAy != null) {
                if (d.this.gDk == null) {
                    d.this.gDk = new l(this.gDl.getPageContext());
                    d.this.gDk.a(new l.a() { // from class: com.baidu.tieba.ala.guardclub.view.d.1.1
                        @Override // com.baidu.tieba.ala.guardclub.l.a
                        public void c(final com.baidu.tieba.ala.guardclub.model.d dVar2, final int i2) {
                            LogManager.getGuardClubLogger().doClickLiveLeaveGuardLog();
                            if (d.this.gAy != null && dVar2 != null) {
                                d.this.gAy.a(dVar2.id, new e.b() { // from class: com.baidu.tieba.ala.guardclub.view.d.1.1.1
                                    @Override // com.baidu.tieba.ala.guardclub.model.e.b
                                    public void b(int i3, String str, Object obj) {
                                        d.this.gDj.uy(i2);
                                        if (d.this.gDj.getCount() <= 0) {
                                            d.this.bME();
                                        }
                                        d.this.showToast(dVar2.beR);
                                    }
                                });
                            }
                        }
                    });
                }
                d.this.gDk.b(dVar, i);
                LogManager.getGuardClubLogger().doDisplayLiveLeaveGuardLog();
            }
        }
    }

    public void completePullRefresh() {
        if (this.gDi != null) {
            this.gDi.completePullRefresh();
        }
    }

    public void bQH() {
        if (this.gBa != null) {
            this.gBa.endLoadData();
            this.gDi.setNextPage(null);
        }
    }

    public void mj(boolean z) {
        if (z) {
            if (this.gBa != null) {
                this.gDi.setNextPage(null);
            }
        } else if (this.gBa != null) {
            if (this.gBa.getView().getParent() == null) {
                this.gDi.setNextPage(this.gBa);
            }
            this.gBa.showNoMoreData();
        }
    }

    public void bMx() {
        if (this.gBa != null) {
            if (this.gBa.getView().getParent() == null) {
                this.gDi.setNextPage(this.gBa);
            }
            this.gBa.showLoadView();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.gDj != null) {
            this.gDj.notifyDataSetInvalidated();
        }
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bME() {
        bH(8, 0);
    }

    public void f(e eVar) {
        this.gAy = eVar;
        this.gAy.bQM();
    }

    public void ce(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (this.gDj != null && list != null && !list.isEmpty()) {
            bH(0, 8);
            this.gDj.ce(list);
            return;
        }
        bME();
    }

    private void bH(int i, int i2) {
        this.gDi.setVisibility(i);
        if (i2 == 0) {
            this.byP.reset();
            this.byP.setTitle(a.i.guard_join_list_empty);
            this.byP.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.LIGHT);
            this.byP.setVisibility(0);
            return;
        }
        this.byP.setVisibility(8);
    }

    public void cf(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (this.gDj != null) {
            this.gDj.cf(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showToast(String str) {
        Toast makeText = Toast.makeText(this.mContext.getPageActivity(), (CharSequence) null, 0);
        makeText.setGravity(17, 0, 0);
        makeText.setText(String.format(this.mContext.getResources().getString(a.i.guard_club_exit_success_toast), str));
        makeText.show();
    }

    public void bQF() {
        if (this.gDj != null) {
            this.gDj.bQF();
        }
        MessageManager.getInstance().unRegisterListener(this.gpA);
    }

    public void bJw() {
        this.byP.reset();
        this.byP.setTitle(a.i.sdk_net_fail_tip_rank);
        this.byP.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.view.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.byP.setVisibility(8);
                if (d.this.gAy != null) {
                    d.this.gAy.bQM();
                }
            }
        });
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.byP.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
        } else {
            this.byP.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
        }
        this.byP.setVisibility(0);
        this.gDi.setVisibility(8);
    }
}
