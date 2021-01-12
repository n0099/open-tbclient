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
/* loaded from: classes10.dex */
public class d extends BdBaseView<GuardClubMemberListActivity> {
    private CommonEmptyView bIA;
    private BaseActivity bRI;
    CustomMessageListener gKM;
    private LoadMoreFooter gWL;
    private com.baidu.tieba.ala.guardclub.model.e gWj;
    private BdListView gYX;
    private g gYY;
    private m gYZ;
    private View mRootView;
    private String otherParams;

    public View getView() {
        return this.mRootView;
    }

    public d(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity.getPageContext());
        this.gKM = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.view.d.3
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
        this.bRI = baseActivity;
        this.mRootView = LayoutInflater.from(this.bRI).inflate(a.g.layout_guard_club_join_list, (ViewGroup) null);
        this.gYX = (BdListView) this.mRootView.findViewById(a.f.list_guard_club_join);
        this.gYY = new g(baseActivity, bdUniqueId);
        this.gYY.a(new AnonymousClass1(baseActivity));
        this.gYX.setAdapter((ListAdapter) this.gYY);
        this.gWL = new LoadMoreFooter(this.bRI);
        this.gWL.setBackgroundColor(-1);
        this.gWL.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_b));
        this.gWL.createView();
        this.gYX.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.view.d.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (!d.this.gWL.isLoading() && d.this.gWj.bVc() && i + i2 > i3 - 2 && d.this.gWj.bVc()) {
                    d.this.gWj.bVe();
                }
            }
        });
        MessageManager.getInstance().registerListener(this.gKM);
        this.bIA = (CommonEmptyView) this.mRootView.findViewById(a.f.guard_club_join_empty_view);
    }

    /* renamed from: com.baidu.tieba.ala.guardclub.view.d$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    class AnonymousClass1 implements g.b {
        final /* synthetic */ BaseActivity gZa;

        AnonymousClass1(BaseActivity baseActivity) {
            this.gZa = baseActivity;
        }

        @Override // com.baidu.tieba.ala.guardclub.g.b
        public void a(com.baidu.tieba.ala.guardclub.model.d dVar, int i) {
            if (dVar != null && d.this.gWj != null) {
                if (d.this.gYZ == null) {
                    d.this.gYZ = new m(this.gZa.getPageContext());
                    d.this.gYZ.a(new m.a() { // from class: com.baidu.tieba.ala.guardclub.view.d.1.1
                        @Override // com.baidu.tieba.ala.guardclub.m.a
                        public void c(final com.baidu.tieba.ala.guardclub.model.d dVar2, final int i2) {
                            LogManager.getGuardClubLogger().doClickLiveLeaveGuardLog();
                            if (d.this.gWj != null && dVar2 != null) {
                                d.this.gWj.a(dVar2.id, new e.b() { // from class: com.baidu.tieba.ala.guardclub.view.d.1.1.1
                                    @Override // com.baidu.tieba.ala.guardclub.model.e.b
                                    public void b(int i3, String str, Object obj) {
                                        d.this.gYY.us(i2);
                                        if (d.this.gYY.getCount() <= 0) {
                                            d.this.bQU();
                                        }
                                        d.this.showToast(dVar2.bfC);
                                    }
                                });
                            }
                        }
                    });
                }
                d.this.gYZ.b(dVar, i);
                LogManager.getGuardClubLogger().doDisplayLiveLeaveGuardLog();
            }
        }
    }

    public void completePullRefresh() {
        if (this.gYX != null) {
            this.gYX.completePullRefresh();
        }
    }

    public void bUZ() {
        if (this.gWL != null) {
            this.gWL.endLoadData();
            this.gYX.setNextPage(null);
        }
    }

    public void nk(boolean z) {
        if (z) {
            if (this.gWL != null) {
                this.gYX.setNextPage(null);
            }
        } else if (this.gWL != null) {
            if (this.gWL.getView().getParent() == null) {
                this.gYX.setNextPage(this.gWL);
            }
            this.gWL.showNoMoreData();
        }
    }

    public void bQN() {
        if (this.gWL != null) {
            if (this.gWL.getView().getParent() == null) {
                this.gYX.setNextPage(this.gWL);
            }
            this.gWL.showLoadView();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.gYY != null) {
            this.gYY.notifyDataSetInvalidated();
        }
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQU() {
        bK(8, 0);
    }

    public void f(com.baidu.tieba.ala.guardclub.model.e eVar) {
        this.gWj = eVar;
        this.gWj.bVd();
    }

    public void cw(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (this.gYY != null && list != null && !list.isEmpty()) {
            bK(0, 8);
            this.gYY.cw(list);
            return;
        }
        bQU();
    }

    private void bK(int i, int i2) {
        this.gYX.setVisibility(i);
        if (i2 == 0) {
            this.bIA.reset();
            this.bIA.setTitle(a.h.guard_join_list_empty);
            this.bIA.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.LIGHT);
            this.bIA.setVisibility(0);
            return;
        }
        this.bIA.setVisibility(8);
    }

    public void cx(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (this.gYY != null) {
            this.gYY.cx(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showToast(String str) {
        Toast makeText = Toast.makeText(this.mContext.getPageActivity(), (CharSequence) null, 0);
        makeText.setGravity(17, 0, 0);
        makeText.setText(String.format(this.mContext.getResources().getString(a.h.guard_club_exit_success_toast), str));
        makeText.show();
    }

    public void bUX() {
        if (this.gYY != null) {
            this.gYY.bUX();
        }
        MessageManager.getInstance().unRegisterListener(this.gKM);
    }

    public void bNH() {
        this.bIA.reset();
        this.bIA.setTitle(a.h.sdk_net_fail_tip_rank);
        this.bIA.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.view.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.bIA.setVisibility(8);
                if (d.this.gWj != null) {
                    d.this.gWj.bVd();
                }
            }
        });
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.bIA.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
        } else {
            this.bIA.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
        }
        this.bIA.setVisibility(0);
        this.gYX.setVisibility(8);
    }
}
