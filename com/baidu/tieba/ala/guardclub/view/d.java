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
    private CommonEmptyView bsN;
    private BaseActivity byl;
    CustomMessageListener fTe;
    private LoadMoreFooter geH;
    private e ged;
    private BdListView ggP;
    private f ggQ;
    private l ggR;
    private View mRootView;
    private String otherParams;

    public View getView() {
        return this.mRootView;
    }

    public d(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity.getPageContext());
        this.fTe = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.view.d.3
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
        this.byl = baseActivity;
        this.mRootView = LayoutInflater.from(this.byl).inflate(a.h.layout_guard_club_join_list, (ViewGroup) null);
        this.ggP = (BdListView) this.mRootView.findViewById(a.g.list_guard_club_join);
        this.ggQ = new f(baseActivity, bdUniqueId);
        this.ggQ.a(new AnonymousClass1(baseActivity));
        this.ggP.setAdapter((ListAdapter) this.ggQ);
        this.geH = new LoadMoreFooter(this.byl);
        this.geH.setBackgroundColor(-1);
        this.geH.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_b));
        this.geH.createView();
        this.ggP.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.view.d.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (!d.this.geH.isLoading() && d.this.ged.bLw() && i + i2 > i3 - 2 && d.this.ged.bLw()) {
                    d.this.ged.bLy();
                }
            }
        });
        MessageManager.getInstance().registerListener(this.fTe);
        this.bsN = (CommonEmptyView) this.mRootView.findViewById(a.g.guard_club_join_empty_view);
    }

    /* renamed from: com.baidu.tieba.ala.guardclub.view.d$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    class AnonymousClass1 implements f.b {
        final /* synthetic */ BaseActivity ggS;

        AnonymousClass1(BaseActivity baseActivity) {
            this.ggS = baseActivity;
        }

        @Override // com.baidu.tieba.ala.guardclub.f.b
        public void a(com.baidu.tieba.ala.guardclub.model.d dVar, int i) {
            if (dVar != null && d.this.ged != null) {
                if (d.this.ggR == null) {
                    d.this.ggR = new l(this.ggS.getPageContext());
                    d.this.ggR.a(new l.a() { // from class: com.baidu.tieba.ala.guardclub.view.d.1.1
                        @Override // com.baidu.tieba.ala.guardclub.l.a
                        public void c(final com.baidu.tieba.ala.guardclub.model.d dVar2, final int i2) {
                            LogManager.getGuardClubLogger().doClickLiveLeaveGuardLog();
                            if (d.this.ged != null && dVar2 != null) {
                                d.this.ged.a(dVar2.id, new e.b() { // from class: com.baidu.tieba.ala.guardclub.view.d.1.1.1
                                    @Override // com.baidu.tieba.ala.guardclub.model.e.b
                                    public void b(int i3, String str, Object obj) {
                                        d.this.ggQ.tI(i2);
                                        if (d.this.ggQ.getCount() <= 0) {
                                            d.this.bHr();
                                        }
                                        d.this.showToast(dVar2.bag);
                                    }
                                });
                            }
                        }
                    });
                }
                d.this.ggR.b(dVar, i);
                LogManager.getGuardClubLogger().doDisplayLiveLeaveGuardLog();
            }
        }
    }

    public void completePullRefresh() {
        if (this.ggP != null) {
            this.ggP.completePullRefresh();
        }
    }

    public void bLs() {
        if (this.geH != null) {
            this.geH.endLoadData();
            this.ggP.setNextPage(null);
        }
    }

    public void lv(boolean z) {
        if (z) {
            if (this.geH != null) {
                this.ggP.setNextPage(null);
            }
        } else if (this.geH != null) {
            if (this.geH.getView().getParent() == null) {
                this.ggP.setNextPage(this.geH);
            }
            this.geH.showNoMoreData();
        }
    }

    public void bHj() {
        if (this.geH != null) {
            if (this.geH.getView().getParent() == null) {
                this.ggP.setNextPage(this.geH);
            }
            this.geH.showLoadView();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.ggQ != null) {
            this.ggQ.notifyDataSetInvalidated();
        }
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHr() {
        bG(8, 0);
    }

    public void f(e eVar) {
        this.ged = eVar;
        this.ged.bLx();
    }

    public void bR(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (this.ggQ != null && list != null && !list.isEmpty()) {
            bG(0, 8);
            this.ggQ.bR(list);
            return;
        }
        bHr();
    }

    private void bG(int i, int i2) {
        this.ggP.setVisibility(i);
        if (i2 == 0) {
            this.bsN.reset();
            this.bsN.setTitle(a.i.guard_join_list_empty);
            this.bsN.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.LIGHT);
            this.bsN.setVisibility(0);
            return;
        }
        this.bsN.setVisibility(8);
    }

    public void bS(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (this.ggQ != null) {
            this.ggQ.bS(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showToast(String str) {
        Toast makeText = Toast.makeText(this.mContext.getPageActivity(), (CharSequence) null, 0);
        makeText.setGravity(17, 0, 0);
        makeText.setText(String.format(this.mContext.getResources().getString(a.i.guard_club_exit_success_toast), str));
        makeText.show();
    }

    public void bLq() {
        if (this.ggQ != null) {
            this.ggQ.bLq();
        }
        MessageManager.getInstance().unRegisterListener(this.fTe);
    }

    public void bET() {
        this.bsN.reset();
        this.bsN.setTitle(a.i.sdk_net_fail_tip_rank);
        this.bsN.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.view.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.bsN.setVisibility(8);
                if (d.this.ged != null) {
                    d.this.ged.bLx();
                }
            }
        });
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.bsN.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
        } else {
            this.bsN.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
        }
        this.bsN.setVisibility(0);
        this.ggP.setVisibility(8);
    }
}
