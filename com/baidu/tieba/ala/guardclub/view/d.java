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
    private CommonEmptyView bFa;
    private BaseActivity bNs;
    private LoadMoreFooter gGO;
    private e gGm;
    private BdListView gIW;
    private f gIX;
    private l gIY;
    CustomMessageListener gvo;
    private View mRootView;
    private String otherParams;

    public View getView() {
        return this.mRootView;
    }

    public d(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity.getPageContext());
        this.gvo = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.view.d.3
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
        this.bNs = baseActivity;
        this.mRootView = LayoutInflater.from(this.bNs).inflate(a.g.layout_guard_club_join_list, (ViewGroup) null);
        this.gIW = (BdListView) this.mRootView.findViewById(a.f.list_guard_club_join);
        this.gIX = new f(baseActivity, bdUniqueId);
        this.gIX.a(new AnonymousClass1(baseActivity));
        this.gIW.setAdapter((ListAdapter) this.gIX);
        this.gGO = new LoadMoreFooter(this.bNs);
        this.gGO.setBackgroundColor(-1);
        this.gGO.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_b));
        this.gGO.createView();
        this.gIW.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.view.d.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (!d.this.gGO.isLoading() && d.this.gGm.bTk() && i + i2 > i3 - 2 && d.this.gGm.bTk()) {
                    d.this.gGm.bTm();
                }
            }
        });
        MessageManager.getInstance().registerListener(this.gvo);
        this.bFa = (CommonEmptyView) this.mRootView.findViewById(a.f.guard_club_join_empty_view);
    }

    /* renamed from: com.baidu.tieba.ala.guardclub.view.d$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    class AnonymousClass1 implements f.b {
        final /* synthetic */ BaseActivity gIZ;

        AnonymousClass1(BaseActivity baseActivity) {
            this.gIZ = baseActivity;
        }

        @Override // com.baidu.tieba.ala.guardclub.f.b
        public void a(com.baidu.tieba.ala.guardclub.model.d dVar, int i) {
            if (dVar != null && d.this.gGm != null) {
                if (d.this.gIY == null) {
                    d.this.gIY = new l(this.gIZ.getPageContext());
                    d.this.gIY.a(new l.a() { // from class: com.baidu.tieba.ala.guardclub.view.d.1.1
                        @Override // com.baidu.tieba.ala.guardclub.l.a
                        public void c(final com.baidu.tieba.ala.guardclub.model.d dVar2, final int i2) {
                            LogManager.getGuardClubLogger().doClickLiveLeaveGuardLog();
                            if (d.this.gGm != null && dVar2 != null) {
                                d.this.gGm.a(dVar2.id, new e.b() { // from class: com.baidu.tieba.ala.guardclub.view.d.1.1.1
                                    @Override // com.baidu.tieba.ala.guardclub.model.e.b
                                    public void b(int i3, String str, Object obj) {
                                        d.this.gIX.uI(i2);
                                        if (d.this.gIX.getCount() <= 0) {
                                            d.this.bPe();
                                        }
                                        d.this.showToast(dVar2.bgm);
                                    }
                                });
                            }
                        }
                    });
                }
                d.this.gIY.b(dVar, i);
                LogManager.getGuardClubLogger().doDisplayLiveLeaveGuardLog();
            }
        }
    }

    public void completePullRefresh() {
        if (this.gIW != null) {
            this.gIW.completePullRefresh();
        }
    }

    public void bTh() {
        if (this.gGO != null) {
            this.gGO.endLoadData();
            this.gIW.setNextPage(null);
        }
    }

    public void ms(boolean z) {
        if (z) {
            if (this.gGO != null) {
                this.gIW.setNextPage(null);
            }
        } else if (this.gGO != null) {
            if (this.gGO.getView().getParent() == null) {
                this.gIW.setNextPage(this.gGO);
            }
            this.gGO.showNoMoreData();
        }
    }

    public void bOX() {
        if (this.gGO != null) {
            if (this.gGO.getView().getParent() == null) {
                this.gIW.setNextPage(this.gGO);
            }
            this.gGO.showLoadView();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.gIX != null) {
            this.gIX.notifyDataSetInvalidated();
        }
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPe() {
        bH(8, 0);
    }

    public void f(e eVar) {
        this.gGm = eVar;
        this.gGm.bTl();
    }

    public void cl(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (this.gIX != null && list != null && !list.isEmpty()) {
            bH(0, 8);
            this.gIX.cl(list);
            return;
        }
        bPe();
    }

    private void bH(int i, int i2) {
        this.gIW.setVisibility(i);
        if (i2 == 0) {
            this.bFa.reset();
            this.bFa.setTitle(a.h.guard_join_list_empty);
            this.bFa.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.LIGHT);
            this.bFa.setVisibility(0);
            return;
        }
        this.bFa.setVisibility(8);
    }

    public void cm(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (this.gIX != null) {
            this.gIX.cm(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showToast(String str) {
        Toast makeText = Toast.makeText(this.mContext.getPageActivity(), (CharSequence) null, 0);
        makeText.setGravity(17, 0, 0);
        makeText.setText(String.format(this.mContext.getResources().getString(a.h.guard_club_exit_success_toast), str));
        makeText.show();
    }

    public void bTf() {
        if (this.gIX != null) {
            this.gIX.bTf();
        }
        MessageManager.getInstance().unRegisterListener(this.gvo);
    }

    public void bLV() {
        this.bFa.reset();
        this.bFa.setTitle(a.h.sdk_net_fail_tip_rank);
        this.bFa.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.view.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.bFa.setVisibility(8);
                if (d.this.gGm != null) {
                    d.this.gGm.bTl();
                }
            }
        });
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.bFa.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
        } else {
            this.bFa.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
        }
        this.bFa.setVisibility(0);
        this.gIW.setVisibility(8);
    }
}
