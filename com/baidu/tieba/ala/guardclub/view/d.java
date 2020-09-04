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
    private CommonEmptyView bpE;
    private BaseActivity buW;
    CustomMessageListener fPT;
    private e gaQ;
    private LoadMoreFooter gbu;
    private BdListView gdD;
    private f gdE;
    private l gdF;
    private View mRootView;
    private String otherParams;

    public View getView() {
        return this.mRootView;
    }

    public d(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity.getPageContext());
        this.fPT = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.view.d.3
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
        this.buW = baseActivity;
        this.mRootView = LayoutInflater.from(this.buW).inflate(a.h.layout_guard_club_join_list, (ViewGroup) null);
        this.gdD = (BdListView) this.mRootView.findViewById(a.g.list_guard_club_join);
        this.gdE = new f(baseActivity, bdUniqueId);
        this.gdE.a(new AnonymousClass1(baseActivity));
        this.gdD.setAdapter((ListAdapter) this.gdE);
        this.gbu = new LoadMoreFooter(this.buW);
        this.gbu.setBackgroundColor(-1);
        this.gbu.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_b));
        this.gbu.createView();
        this.gdD.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.view.d.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (!d.this.gbu.isLoading() && d.this.gaQ.bKm() && i + i2 > i3 - 2 && d.this.gaQ.bKm()) {
                    d.this.gaQ.bKo();
                }
            }
        });
        MessageManager.getInstance().registerListener(this.fPT);
        this.bpE = (CommonEmptyView) this.mRootView.findViewById(a.g.guard_club_join_empty_view);
    }

    /* renamed from: com.baidu.tieba.ala.guardclub.view.d$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    class AnonymousClass1 implements f.b {
        final /* synthetic */ BaseActivity gdG;

        AnonymousClass1(BaseActivity baseActivity) {
            this.gdG = baseActivity;
        }

        @Override // com.baidu.tieba.ala.guardclub.f.b
        public void a(com.baidu.tieba.ala.guardclub.model.d dVar, int i) {
            if (dVar != null && d.this.gaQ != null) {
                if (d.this.gdF == null) {
                    d.this.gdF = new l(this.gdG.getPageContext());
                    d.this.gdF.a(new l.a() { // from class: com.baidu.tieba.ala.guardclub.view.d.1.1
                        @Override // com.baidu.tieba.ala.guardclub.l.a
                        public void c(final com.baidu.tieba.ala.guardclub.model.d dVar2, final int i2) {
                            LogManager.getGuardClubLogger().doClickLiveLeaveGuardLog();
                            if (d.this.gaQ != null && dVar2 != null) {
                                d.this.gaQ.a(dVar2.id, new e.b() { // from class: com.baidu.tieba.ala.guardclub.view.d.1.1.1
                                    @Override // com.baidu.tieba.ala.guardclub.model.e.b
                                    public void b(int i3, String str, Object obj) {
                                        d.this.gdE.tp(i2);
                                        if (d.this.gdE.getCount() <= 0) {
                                            d.this.bGb();
                                        }
                                        d.this.showToast(dVar2.aXJ);
                                    }
                                });
                            }
                        }
                    });
                }
                d.this.gdF.b(dVar, i);
                LogManager.getGuardClubLogger().doDisplayLiveLeaveGuardLog();
            }
        }
    }

    public void completePullRefresh() {
        if (this.gdD != null) {
            this.gdD.completePullRefresh();
        }
    }

    public void bKi() {
        if (this.gbu != null) {
            this.gbu.endLoadData();
            this.gdD.setNextPage(null);
        }
    }

    public void lt(boolean z) {
        if (z) {
            if (this.gbu != null) {
                this.gdD.setNextPage(null);
            }
        } else if (this.gbu != null) {
            if (this.gbu.getView().getParent() == null) {
                this.gdD.setNextPage(this.gbu);
            }
            this.gbu.showNoMoreData();
        }
    }

    public void bFT() {
        if (this.gbu != null) {
            if (this.gbu.getView().getParent() == null) {
                this.gdD.setNextPage(this.gbu);
            }
            this.gbu.showLoadView();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.gdE != null) {
            this.gdE.notifyDataSetInvalidated();
        }
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGb() {
        bG(8, 0);
    }

    public void f(e eVar) {
        this.gaQ = eVar;
        this.gaQ.bKn();
    }

    public void bM(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (this.gdE != null && list != null && !list.isEmpty()) {
            bG(0, 8);
            this.gdE.bM(list);
            return;
        }
        bGb();
    }

    private void bG(int i, int i2) {
        this.gdD.setVisibility(i);
        if (i2 == 0) {
            this.bpE.reset();
            this.bpE.setTitle(a.i.guard_join_list_empty);
            this.bpE.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.LIGHT);
            this.bpE.setVisibility(0);
            return;
        }
        this.bpE.setVisibility(8);
    }

    public void bN(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (this.gdE != null) {
            this.gdE.bN(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showToast(String str) {
        Toast makeText = Toast.makeText(this.mContext.getPageActivity(), (CharSequence) null, 0);
        makeText.setGravity(17, 0, 0);
        makeText.setText(String.format(this.mContext.getResources().getString(a.i.guard_club_exit_success_toast), str));
        makeText.show();
    }

    public void bKg() {
        if (this.gdE != null) {
            this.gdE.bKg();
        }
        MessageManager.getInstance().unRegisterListener(this.fPT);
    }

    public void bDG() {
        this.bpE.reset();
        this.bpE.setTitle(a.i.sdk_net_fail_tip_rank);
        this.bpE.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.view.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.bpE.setVisibility(8);
                if (d.this.gaQ != null) {
                    d.this.gaQ.bKn();
                }
            }
        });
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.bpE.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
        } else {
            this.bpE.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
        }
        this.bpE.setVisibility(0);
        this.gdD.setVisibility(8);
    }
}
