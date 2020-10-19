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
    private BaseActivity bEO;
    private CommonEmptyView bwB;
    CustomMessageListener gfx;
    private LoadMoreFooter gqW;
    private e gqt;
    private BdListView gte;
    private f gtf;
    private l gtg;
    private View mRootView;
    private String otherParams;

    public View getView() {
        return this.mRootView;
    }

    public d(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity.getPageContext());
        this.gfx = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.view.d.3
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
        this.bEO = baseActivity;
        this.mRootView = LayoutInflater.from(this.bEO).inflate(a.h.layout_guard_club_join_list, (ViewGroup) null);
        this.gte = (BdListView) this.mRootView.findViewById(a.g.list_guard_club_join);
        this.gtf = new f(baseActivity, bdUniqueId);
        this.gtf.a(new AnonymousClass1(baseActivity));
        this.gte.setAdapter((ListAdapter) this.gtf);
        this.gqW = new LoadMoreFooter(this.bEO);
        this.gqW.setBackgroundColor(-1);
        this.gqW.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_b));
        this.gqW.createView();
        this.gte.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.view.d.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (!d.this.gqW.isLoading() && d.this.gqt.bOg() && i + i2 > i3 - 2 && d.this.gqt.bOg()) {
                    d.this.gqt.bOi();
                }
            }
        });
        MessageManager.getInstance().registerListener(this.gfx);
        this.bwB = (CommonEmptyView) this.mRootView.findViewById(a.g.guard_club_join_empty_view);
    }

    /* renamed from: com.baidu.tieba.ala.guardclub.view.d$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    class AnonymousClass1 implements f.b {
        final /* synthetic */ BaseActivity gth;

        AnonymousClass1(BaseActivity baseActivity) {
            this.gth = baseActivity;
        }

        @Override // com.baidu.tieba.ala.guardclub.f.b
        public void a(com.baidu.tieba.ala.guardclub.model.d dVar, int i) {
            if (dVar != null && d.this.gqt != null) {
                if (d.this.gtg == null) {
                    d.this.gtg = new l(this.gth.getPageContext());
                    d.this.gtg.a(new l.a() { // from class: com.baidu.tieba.ala.guardclub.view.d.1.1
                        @Override // com.baidu.tieba.ala.guardclub.l.a
                        public void c(final com.baidu.tieba.ala.guardclub.model.d dVar2, final int i2) {
                            LogManager.getGuardClubLogger().doClickLiveLeaveGuardLog();
                            if (d.this.gqt != null && dVar2 != null) {
                                d.this.gqt.a(dVar2.id, new e.b() { // from class: com.baidu.tieba.ala.guardclub.view.d.1.1.1
                                    @Override // com.baidu.tieba.ala.guardclub.model.e.b
                                    public void b(int i3, String str, Object obj) {
                                        d.this.gtf.ug(i2);
                                        if (d.this.gtf.getCount() <= 0) {
                                            d.this.bKc();
                                        }
                                        d.this.showToast(dVar2.bdB);
                                    }
                                });
                            }
                        }
                    });
                }
                d.this.gtg.b(dVar, i);
                LogManager.getGuardClubLogger().doDisplayLiveLeaveGuardLog();
            }
        }
    }

    public void completePullRefresh() {
        if (this.gte != null) {
            this.gte.completePullRefresh();
        }
    }

    public void bOc() {
        if (this.gqW != null) {
            this.gqW.endLoadData();
            this.gte.setNextPage(null);
        }
    }

    public void lT(boolean z) {
        if (z) {
            if (this.gqW != null) {
                this.gte.setNextPage(null);
            }
        } else if (this.gqW != null) {
            if (this.gqW.getView().getParent() == null) {
                this.gte.setNextPage(this.gqW);
            }
            this.gqW.showNoMoreData();
        }
    }

    public void bJV() {
        if (this.gqW != null) {
            if (this.gqW.getView().getParent() == null) {
                this.gte.setNextPage(this.gqW);
            }
            this.gqW.showLoadView();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.gtf != null) {
            this.gtf.notifyDataSetInvalidated();
        }
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKc() {
        bF(8, 0);
    }

    public void f(e eVar) {
        this.gqt = eVar;
        this.gqt.bOh();
    }

    public void bU(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (this.gtf != null && list != null && !list.isEmpty()) {
            bF(0, 8);
            this.gtf.bU(list);
            return;
        }
        bKc();
    }

    private void bF(int i, int i2) {
        this.gte.setVisibility(i);
        if (i2 == 0) {
            this.bwB.reset();
            this.bwB.setTitle(a.i.guard_join_list_empty);
            this.bwB.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.LIGHT);
            this.bwB.setVisibility(0);
            return;
        }
        this.bwB.setVisibility(8);
    }

    public void bV(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (this.gtf != null) {
            this.gtf.bV(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showToast(String str) {
        Toast makeText = Toast.makeText(this.mContext.getPageActivity(), (CharSequence) null, 0);
        makeText.setGravity(17, 0, 0);
        makeText.setText(String.format(this.mContext.getResources().getString(a.i.guard_club_exit_success_toast), str));
        makeText.show();
    }

    public void bOa() {
        if (this.gtf != null) {
            this.gtf.bOa();
        }
        MessageManager.getInstance().unRegisterListener(this.gfx);
    }

    public void bHF() {
        this.bwB.reset();
        this.bwB.setTitle(a.i.sdk_net_fail_tip_rank);
        this.bwB.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.view.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.bwB.setVisibility(8);
                if (d.this.gqt != null) {
                    d.this.gqt.bOh();
                }
            }
        });
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.bwB.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
        } else {
            this.bwB.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
        }
        this.bwB.setVisibility(0);
        this.gte.setVisibility(8);
    }
}
