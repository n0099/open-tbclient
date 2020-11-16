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
    private CommonEmptyView bDp;
    private BaseActivity bLI;
    private e gFT;
    private LoadMoreFooter gGv;
    private BdListView gID;
    private f gIE;
    private l gIF;
    CustomMessageListener guV;
    private View mRootView;
    private String otherParams;

    public View getView() {
        return this.mRootView;
    }

    public d(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity.getPageContext());
        this.guV = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.view.d.3
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
        this.bLI = baseActivity;
        this.mRootView = LayoutInflater.from(this.bLI).inflate(a.g.layout_guard_club_join_list, (ViewGroup) null);
        this.gID = (BdListView) this.mRootView.findViewById(a.f.list_guard_club_join);
        this.gIE = new f(baseActivity, bdUniqueId);
        this.gIE.a(new AnonymousClass1(baseActivity));
        this.gID.setAdapter((ListAdapter) this.gIE);
        this.gGv = new LoadMoreFooter(this.bLI);
        this.gGv.setBackgroundColor(-1);
        this.gGv.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_b));
        this.gGv.createView();
        this.gID.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.view.d.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (!d.this.gGv.isLoading() && d.this.gFT.bSD() && i + i2 > i3 - 2 && d.this.gFT.bSD()) {
                    d.this.gFT.bSF();
                }
            }
        });
        MessageManager.getInstance().registerListener(this.guV);
        this.bDp = (CommonEmptyView) this.mRootView.findViewById(a.f.guard_club_join_empty_view);
    }

    /* renamed from: com.baidu.tieba.ala.guardclub.view.d$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    class AnonymousClass1 implements f.b {
        final /* synthetic */ BaseActivity gIG;

        AnonymousClass1(BaseActivity baseActivity) {
            this.gIG = baseActivity;
        }

        @Override // com.baidu.tieba.ala.guardclub.f.b
        public void a(com.baidu.tieba.ala.guardclub.model.d dVar, int i) {
            if (dVar != null && d.this.gFT != null) {
                if (d.this.gIF == null) {
                    d.this.gIF = new l(this.gIG.getPageContext());
                    d.this.gIF.a(new l.a() { // from class: com.baidu.tieba.ala.guardclub.view.d.1.1
                        @Override // com.baidu.tieba.ala.guardclub.l.a
                        public void c(final com.baidu.tieba.ala.guardclub.model.d dVar2, final int i2) {
                            LogManager.getGuardClubLogger().doClickLiveLeaveGuardLog();
                            if (d.this.gFT != null && dVar2 != null) {
                                d.this.gFT.a(dVar2.id, new e.b() { // from class: com.baidu.tieba.ala.guardclub.view.d.1.1.1
                                    @Override // com.baidu.tieba.ala.guardclub.model.e.b
                                    public void b(int i3, String str, Object obj) {
                                        d.this.gIE.vg(i2);
                                        if (d.this.gIE.getCount() <= 0) {
                                            d.this.bOx();
                                        }
                                        d.this.showToast(dVar2.bez);
                                    }
                                });
                            }
                        }
                    });
                }
                d.this.gIF.b(dVar, i);
                LogManager.getGuardClubLogger().doDisplayLiveLeaveGuardLog();
            }
        }
    }

    public void completePullRefresh() {
        if (this.gID != null) {
            this.gID.completePullRefresh();
        }
    }

    public void bSA() {
        if (this.gGv != null) {
            this.gGv.endLoadData();
            this.gID.setNextPage(null);
        }
    }

    public void mt(boolean z) {
        if (z) {
            if (this.gGv != null) {
                this.gID.setNextPage(null);
            }
        } else if (this.gGv != null) {
            if (this.gGv.getView().getParent() == null) {
                this.gID.setNextPage(this.gGv);
            }
            this.gGv.showNoMoreData();
        }
    }

    public void bOq() {
        if (this.gGv != null) {
            if (this.gGv.getView().getParent() == null) {
                this.gID.setNextPage(this.gGv);
            }
            this.gGv.showLoadView();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.gIE != null) {
            this.gIE.notifyDataSetInvalidated();
        }
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOx() {
        bH(8, 0);
    }

    public void f(e eVar) {
        this.gFT = eVar;
        this.gFT.bSE();
    }

    public void cl(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (this.gIE != null && list != null && !list.isEmpty()) {
            bH(0, 8);
            this.gIE.cl(list);
            return;
        }
        bOx();
    }

    private void bH(int i, int i2) {
        this.gID.setVisibility(i);
        if (i2 == 0) {
            this.bDp.reset();
            this.bDp.setTitle(a.h.guard_join_list_empty);
            this.bDp.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.LIGHT);
            this.bDp.setVisibility(0);
            return;
        }
        this.bDp.setVisibility(8);
    }

    public void cm(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (this.gIE != null) {
            this.gIE.cm(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showToast(String str) {
        Toast makeText = Toast.makeText(this.mContext.getPageActivity(), (CharSequence) null, 0);
        makeText.setGravity(17, 0, 0);
        makeText.setText(String.format(this.mContext.getResources().getString(a.h.guard_club_exit_success_toast), str));
        makeText.show();
    }

    public void bSy() {
        if (this.gIE != null) {
            this.gIE.bSy();
        }
        MessageManager.getInstance().unRegisterListener(this.guV);
    }

    public void bLo() {
        this.bDp.reset();
        this.bDp.setTitle(a.h.sdk_net_fail_tip_rank);
        this.bDp.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.view.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.bDp.setVisibility(8);
                if (d.this.gFT != null) {
                    d.this.gFT.bSE();
                }
            }
        });
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.bDp.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
        } else {
            this.bDp.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
        }
        this.bDp.setVisibility(0);
        this.gID.setVisibility(8);
    }
}
