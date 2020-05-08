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
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.core.view.LoadMoreFooter;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.guardclub.GuardClubMemberListActivity;
import com.baidu.tieba.ala.guardclub.f;
import com.baidu.tieba.ala.guardclub.l;
import com.baidu.tieba.ala.guardclub.model.e;
import java.util.List;
/* loaded from: classes3.dex */
public class d extends BdBaseView<GuardClubMemberListActivity> {
    private CommonEmptyView aWY;
    private BaseActivity bci;
    CustomMessageListener faq;
    private LoadMoreFooter fkV;
    private e fkr;
    private BdListView fng;
    private f fnh;
    private l fni;
    private View mRootView;
    private String otherParams;

    public View getView() {
        return this.mRootView;
    }

    public d(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity.getPageContext());
        this.faq = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.view.d.3
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
        this.bci = baseActivity;
        this.mRootView = LayoutInflater.from(this.bci).inflate(a.h.layout_guard_club_join_list, (ViewGroup) null);
        this.fng = (BdListView) this.mRootView.findViewById(a.g.list_guard_club_join);
        this.fnh = new f(baseActivity, bdUniqueId);
        this.fnh.a(new AnonymousClass1(baseActivity));
        this.fng.setAdapter((ListAdapter) this.fnh);
        this.fkV = new LoadMoreFooter(this.bci);
        this.fkV.setBackgroundColor(-1);
        this.fkV.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_b));
        this.fkV.createView();
        this.fng.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.view.d.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (!d.this.fkV.isLoading() && d.this.fkr.boL() && i + i2 > i3 - 2 && d.this.fkr.boL()) {
                    d.this.fkr.boN();
                }
            }
        });
        MessageManager.getInstance().registerListener(this.faq);
        this.aWY = (CommonEmptyView) this.mRootView.findViewById(a.g.guard_club_join_empty_view);
    }

    /* renamed from: com.baidu.tieba.ala.guardclub.view.d$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass1 implements f.b {
        final /* synthetic */ BaseActivity fnj;

        AnonymousClass1(BaseActivity baseActivity) {
            this.fnj = baseActivity;
        }

        @Override // com.baidu.tieba.ala.guardclub.f.b
        public void a(com.baidu.tieba.ala.guardclub.model.d dVar, int i) {
            if (dVar != null && d.this.fkr != null) {
                if (d.this.fni == null) {
                    d.this.fni = new l(this.fnj.getPageContext());
                    d.this.fni.a(new l.a() { // from class: com.baidu.tieba.ala.guardclub.view.d.1.1
                        @Override // com.baidu.tieba.ala.guardclub.l.a
                        public void c(final com.baidu.tieba.ala.guardclub.model.d dVar2, final int i2) {
                            LogManager.getGuardClubLogger().doClickLiveLeaveGuardLog();
                            if (d.this.fkr != null && dVar2 != null) {
                                d.this.fkr.a(dVar2.id, new e.b() { // from class: com.baidu.tieba.ala.guardclub.view.d.1.1.1
                                    @Override // com.baidu.tieba.ala.guardclub.model.e.b
                                    public void b(int i3, String str, Object obj) {
                                        d.this.fnh.pL(i2);
                                        if (d.this.fnh.getCount() <= 0) {
                                            d.this.aqE();
                                        }
                                        d.this.showToast(dVar2.aIL);
                                    }
                                });
                            }
                        }
                    });
                }
                d.this.fni.b(dVar, i);
                LogManager.getGuardClubLogger().doDisplayLiveLeaveGuardLog();
            }
        }
    }

    public void completePullRefresh() {
        if (this.fng != null) {
            this.fng.completePullRefresh();
        }
    }

    public void boG() {
        if (this.fkV != null) {
            this.fkV.endLoadData();
            this.fng.setNextPage(null);
        }
    }

    public void jG(boolean z) {
        if (z) {
            if (this.fkV != null) {
                this.fng.setNextPage(null);
            }
        } else if (this.fkV != null) {
            if (this.fkV.getView().getParent() == null) {
                this.fng.setNextPage(this.fkV);
            }
            this.fkV.showNoMoreData();
        }
    }

    public void blo() {
        if (this.fkV != null) {
            if (this.fkV.getView().getParent() == null) {
                this.fng.setNextPage(this.fkV);
            }
            this.fkV.showLoadView();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.fnh != null) {
            this.fnh.notifyDataSetInvalidated();
        }
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqE() {
        bo(8, 0);
    }

    public void f(e eVar) {
        this.fkr = eVar;
        this.fkr.boM();
    }

    public void bB(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (this.fnh != null && list != null && !list.isEmpty()) {
            bo(0, 8);
            this.fnh.bB(list);
            return;
        }
        aqE();
    }

    private void bo(int i, int i2) {
        this.fng.setVisibility(i);
        if (i2 == 0) {
            this.aWY.reset();
            this.aWY.setTitle(a.i.guard_join_list_empty);
            this.aWY.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.LIGHT);
            this.aWY.setVisibility(0);
            return;
        }
        this.aWY.setVisibility(8);
    }

    public void bC(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (this.fnh != null) {
            this.fnh.bC(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showToast(String str) {
        Toast makeText = Toast.makeText(this.mContext.getPageActivity(), (CharSequence) null, 0);
        makeText.setGravity(17, 0, 0);
        makeText.setText(String.format(this.mContext.getResources().getString(a.i.guard_club_exit_success_toast), str));
        makeText.show();
    }

    public void boE() {
        if (this.fnh != null) {
            this.fnh.boE();
        }
        MessageManager.getInstance().unRegisterListener(this.faq);
    }

    public void bjH() {
        this.aWY.reset();
        this.aWY.setTitle(a.i.sdk_net_fail_tip_rank);
        this.aWY.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.view.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.aWY.setVisibility(8);
                if (d.this.fkr != null) {
                    d.this.fkr.boM();
                }
            }
        });
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.aWY.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
        } else {
            this.aWY.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
        }
        this.aWY.setVisibility(0);
        this.fng.setVisibility(8);
    }
}
