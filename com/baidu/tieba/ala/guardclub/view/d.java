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
/* loaded from: classes11.dex */
public class d extends BdBaseView<GuardClubMemberListActivity> {
    private CommonEmptyView bNm;
    private BaseActivity bWu;
    CustomMessageListener gPs;
    private com.baidu.tieba.ala.guardclub.model.e haP;
    private LoadMoreFooter hbr;
    private BdListView hdD;
    private g hdE;
    private m hdF;
    private View mRootView;
    private String otherParams;

    public View getView() {
        return this.mRootView;
    }

    public d(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity.getPageContext());
        this.gPs = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.view.d.3
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
        this.bWu = baseActivity;
        this.mRootView = LayoutInflater.from(this.bWu).inflate(a.g.layout_guard_club_join_list, (ViewGroup) null);
        this.hdD = (BdListView) this.mRootView.findViewById(a.f.list_guard_club_join);
        this.hdE = new g(baseActivity, bdUniqueId);
        this.hdE.a(new AnonymousClass1(baseActivity));
        this.hdD.setAdapter((ListAdapter) this.hdE);
        this.hbr = new LoadMoreFooter(this.bWu);
        this.hbr.setBackgroundColor(-1);
        this.hbr.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_b));
        this.hbr.createView();
        this.hdD.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.view.d.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (!d.this.hbr.isLoading() && d.this.haP.bYT() && i + i2 > i3 - 2 && d.this.haP.bYT()) {
                    d.this.haP.bYV();
                }
            }
        });
        MessageManager.getInstance().registerListener(this.gPs);
        this.bNm = (CommonEmptyView) this.mRootView.findViewById(a.f.guard_club_join_empty_view);
    }

    /* renamed from: com.baidu.tieba.ala.guardclub.view.d$1  reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass1 implements g.b {
        final /* synthetic */ BaseActivity hdG;

        AnonymousClass1(BaseActivity baseActivity) {
            this.hdG = baseActivity;
        }

        @Override // com.baidu.tieba.ala.guardclub.g.b
        public void a(com.baidu.tieba.ala.guardclub.model.d dVar, int i) {
            if (dVar != null && d.this.haP != null) {
                if (d.this.hdF == null) {
                    d.this.hdF = new m(this.hdG.getPageContext());
                    d.this.hdF.a(new m.a() { // from class: com.baidu.tieba.ala.guardclub.view.d.1.1
                        @Override // com.baidu.tieba.ala.guardclub.m.a
                        public void c(final com.baidu.tieba.ala.guardclub.model.d dVar2, final int i2) {
                            LogManager.getGuardClubLogger().doClickLiveLeaveGuardLog();
                            if (d.this.haP != null && dVar2 != null) {
                                d.this.haP.a(dVar2.id, new e.b() { // from class: com.baidu.tieba.ala.guardclub.view.d.1.1.1
                                    @Override // com.baidu.tieba.ala.guardclub.model.e.b
                                    public void b(int i3, String str, Object obj) {
                                        d.this.hdE.vY(i2);
                                        if (d.this.hdE.getCount() <= 0) {
                                            d.this.bUL();
                                        }
                                        d.this.showToast(dVar2.bks);
                                    }
                                });
                            }
                        }
                    });
                }
                d.this.hdF.b(dVar, i);
                LogManager.getGuardClubLogger().doDisplayLiveLeaveGuardLog();
            }
        }
    }

    public void completePullRefresh() {
        if (this.hdD != null) {
            this.hdD.completePullRefresh();
        }
    }

    public void bYQ() {
        if (this.hbr != null) {
            this.hbr.endLoadData();
            this.hdD.setNextPage(null);
        }
    }

    public void no(boolean z) {
        if (z) {
            if (this.hbr != null) {
                this.hdD.setNextPage(null);
            }
        } else if (this.hbr != null) {
            if (this.hbr.getView().getParent() == null) {
                this.hdD.setNextPage(this.hbr);
            }
            this.hbr.showNoMoreData();
        }
    }

    public void bUE() {
        if (this.hbr != null) {
            if (this.hbr.getView().getParent() == null) {
                this.hdD.setNextPage(this.hbr);
            }
            this.hbr.showLoadView();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.hdE != null) {
            this.hdE.notifyDataSetInvalidated();
        }
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUL() {
        bK(8, 0);
    }

    public void f(com.baidu.tieba.ala.guardclub.model.e eVar) {
        this.haP = eVar;
        this.haP.bYU();
    }

    public void cw(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (this.hdE != null && list != null && !list.isEmpty()) {
            bK(0, 8);
            this.hdE.cw(list);
            return;
        }
        bUL();
    }

    private void bK(int i, int i2) {
        this.hdD.setVisibility(i);
        if (i2 == 0) {
            this.bNm.reset();
            this.bNm.setTitle(a.h.guard_join_list_empty);
            this.bNm.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.LIGHT);
            this.bNm.setVisibility(0);
            return;
        }
        this.bNm.setVisibility(8);
    }

    public void cx(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (this.hdE != null) {
            this.hdE.cx(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showToast(String str) {
        Toast makeText = Toast.makeText(this.mContext.getPageActivity(), (CharSequence) null, 0);
        makeText.setGravity(17, 0, 0);
        makeText.setText(String.format(this.mContext.getResources().getString(a.h.guard_club_exit_success_toast), str));
        makeText.show();
    }

    public void bYO() {
        if (this.hdE != null) {
            this.hdE.bYO();
        }
        MessageManager.getInstance().unRegisterListener(this.gPs);
    }

    public void bRy() {
        this.bNm.reset();
        this.bNm.setTitle(a.h.sdk_net_fail_tip_rank);
        this.bNm.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.view.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.bNm.setVisibility(8);
                if (d.this.haP != null) {
                    d.this.haP.bYU();
                }
            }
        });
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.bNm.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
        } else {
            this.bNm.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
        }
        this.bNm.setVisibility(0);
        this.hdD.setVisibility(8);
    }
}
