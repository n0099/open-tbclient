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
/* loaded from: classes7.dex */
public class d extends BdBaseView<GuardClubMemberListActivity> {
    private CommonEmptyView bpB;
    private BaseActivity buT;
    CustomMessageListener fPP;
    private e gaM;
    private LoadMoreFooter gbq;
    private f gdA;
    private l gdB;
    private BdListView gdz;
    private View mRootView;
    private String otherParams;

    public View getView() {
        return this.mRootView;
    }

    public d(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity.getPageContext());
        this.fPP = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.view.d.3
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
        this.buT = baseActivity;
        this.mRootView = LayoutInflater.from(this.buT).inflate(a.h.layout_guard_club_join_list, (ViewGroup) null);
        this.gdz = (BdListView) this.mRootView.findViewById(a.g.list_guard_club_join);
        this.gdA = new f(baseActivity, bdUniqueId);
        this.gdA.a(new AnonymousClass1(baseActivity));
        this.gdz.setAdapter((ListAdapter) this.gdA);
        this.gbq = new LoadMoreFooter(this.buT);
        this.gbq.setBackgroundColor(-1);
        this.gbq.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_b));
        this.gbq.createView();
        this.gdz.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.view.d.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (!d.this.gbq.isLoading() && d.this.gaM.bKl() && i + i2 > i3 - 2 && d.this.gaM.bKl()) {
                    d.this.gaM.bKn();
                }
            }
        });
        MessageManager.getInstance().registerListener(this.fPP);
        this.bpB = (CommonEmptyView) this.mRootView.findViewById(a.g.guard_club_join_empty_view);
    }

    /* renamed from: com.baidu.tieba.ala.guardclub.view.d$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    class AnonymousClass1 implements f.b {
        final /* synthetic */ BaseActivity gdC;

        AnonymousClass1(BaseActivity baseActivity) {
            this.gdC = baseActivity;
        }

        @Override // com.baidu.tieba.ala.guardclub.f.b
        public void a(com.baidu.tieba.ala.guardclub.model.d dVar, int i) {
            if (dVar != null && d.this.gaM != null) {
                if (d.this.gdB == null) {
                    d.this.gdB = new l(this.gdC.getPageContext());
                    d.this.gdB.a(new l.a() { // from class: com.baidu.tieba.ala.guardclub.view.d.1.1
                        @Override // com.baidu.tieba.ala.guardclub.l.a
                        public void c(final com.baidu.tieba.ala.guardclub.model.d dVar2, final int i2) {
                            LogManager.getGuardClubLogger().doClickLiveLeaveGuardLog();
                            if (d.this.gaM != null && dVar2 != null) {
                                d.this.gaM.a(dVar2.id, new e.b() { // from class: com.baidu.tieba.ala.guardclub.view.d.1.1.1
                                    @Override // com.baidu.tieba.ala.guardclub.model.e.b
                                    public void b(int i3, String str, Object obj) {
                                        d.this.gdA.tp(i2);
                                        if (d.this.gdA.getCount() <= 0) {
                                            d.this.bGa();
                                        }
                                        d.this.showToast(dVar2.aXH);
                                    }
                                });
                            }
                        }
                    });
                }
                d.this.gdB.b(dVar, i);
                LogManager.getGuardClubLogger().doDisplayLiveLeaveGuardLog();
            }
        }
    }

    public void completePullRefresh() {
        if (this.gdz != null) {
            this.gdz.completePullRefresh();
        }
    }

    public void bKh() {
        if (this.gbq != null) {
            this.gbq.endLoadData();
            this.gdz.setNextPage(null);
        }
    }

    public void lr(boolean z) {
        if (z) {
            if (this.gbq != null) {
                this.gdz.setNextPage(null);
            }
        } else if (this.gbq != null) {
            if (this.gbq.getView().getParent() == null) {
                this.gdz.setNextPage(this.gbq);
            }
            this.gbq.showNoMoreData();
        }
    }

    public void bFS() {
        if (this.gbq != null) {
            if (this.gbq.getView().getParent() == null) {
                this.gdz.setNextPage(this.gbq);
            }
            this.gbq.showLoadView();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.gdA != null) {
            this.gdA.notifyDataSetInvalidated();
        }
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGa() {
        bG(8, 0);
    }

    public void f(e eVar) {
        this.gaM = eVar;
        this.gaM.bKm();
    }

    public void bM(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (this.gdA != null && list != null && !list.isEmpty()) {
            bG(0, 8);
            this.gdA.bM(list);
            return;
        }
        bGa();
    }

    private void bG(int i, int i2) {
        this.gdz.setVisibility(i);
        if (i2 == 0) {
            this.bpB.reset();
            this.bpB.setTitle(a.i.guard_join_list_empty);
            this.bpB.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.LIGHT);
            this.bpB.setVisibility(0);
            return;
        }
        this.bpB.setVisibility(8);
    }

    public void bN(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (this.gdA != null) {
            this.gdA.bN(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showToast(String str) {
        Toast makeText = Toast.makeText(this.mContext.getPageActivity(), (CharSequence) null, 0);
        makeText.setGravity(17, 0, 0);
        makeText.setText(String.format(this.mContext.getResources().getString(a.i.guard_club_exit_success_toast), str));
        makeText.show();
    }

    public void bKf() {
        if (this.gdA != null) {
            this.gdA.bKf();
        }
        MessageManager.getInstance().unRegisterListener(this.fPP);
    }

    public void bDF() {
        this.bpB.reset();
        this.bpB.setTitle(a.i.sdk_net_fail_tip_rank);
        this.bpB.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.view.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.bpB.setVisibility(8);
                if (d.this.gaM != null) {
                    d.this.gaM.bKm();
                }
            }
        });
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.bpB.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
        } else {
            this.bpB.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
        }
        this.bpB.setVisibility(0);
        this.gdz.setVisibility(8);
    }
}
