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
import com.baidu.live.k.a;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.core.view.LoadMoreFooter;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.tieba.ala.guardclub.GuardClubMemberListActivity;
import com.baidu.tieba.ala.guardclub.d;
import com.baidu.tieba.ala.guardclub.j;
import com.baidu.tieba.ala.guardclub.model.g;
import com.baidu.tieba.ala.guardclub.model.h;
import java.util.List;
/* loaded from: classes6.dex */
public class b extends BdBaseView<GuardClubMemberListActivity> {
    private CommonEmptyView aqz;
    private BaseActivity atC;
    CustomMessageListener dFq;
    private LoadMoreFooter dMR;
    private h dMn;
    private BdListView dPG;
    private d dPH;
    private j dPI;
    private View mRootView;
    private String otherParams;

    public View getView() {
        return this.mRootView;
    }

    public b(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity.getPageContext());
        this.dFq = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.view.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (str == null) {
                        str = "";
                    }
                    b.this.otherParams = str;
                }
            }
        };
        this.atC = baseActivity;
        this.mRootView = LayoutInflater.from(this.atC).inflate(a.h.layout_guard_club_join_list, (ViewGroup) null);
        this.dPG = (BdListView) this.mRootView.findViewById(a.g.list_guard_club_join);
        this.dPH = new d(baseActivity, bdUniqueId);
        this.dPH.a(new AnonymousClass1(baseActivity));
        this.dPG.setAdapter((ListAdapter) this.dPH);
        this.dMR = new LoadMoreFooter(this.atC);
        this.dMR.setBackgroundColor(-1);
        this.dMR.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_b));
        this.dMR.createView();
        this.dPG.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.view.b.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (!b.this.dMR.isLoading() && b.this.dMn.aLE() && i + i2 > i3 - 2 && b.this.dMn.aLE()) {
                    b.this.dMn.aLG();
                }
            }
        });
        MessageManager.getInstance().registerListener(this.dFq);
        this.aqz = (CommonEmptyView) this.mRootView.findViewById(a.g.guard_club_join_empty_view);
    }

    /* renamed from: com.baidu.tieba.ala.guardclub.view.b$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    class AnonymousClass1 implements d.b {
        final /* synthetic */ BaseActivity dPJ;

        AnonymousClass1(BaseActivity baseActivity) {
            this.dPJ = baseActivity;
        }

        @Override // com.baidu.tieba.ala.guardclub.d.b
        public void a(g gVar, int i) {
            if (gVar != null && b.this.dMn != null) {
                if (b.this.dPI == null) {
                    b.this.dPI = new j(this.dPJ.getPageContext());
                    b.this.dPI.a(new j.a() { // from class: com.baidu.tieba.ala.guardclub.view.b.1.1
                        @Override // com.baidu.tieba.ala.guardclub.j.a
                        public void c(final g gVar2, final int i2) {
                            LogManager.getGuardClubLogger().doClickLiveLeaveGuardLog();
                            if (b.this.dMn != null && gVar2 != null) {
                                b.this.dMn.a(gVar2.id, new h.b() { // from class: com.baidu.tieba.ala.guardclub.view.b.1.1.1
                                    @Override // com.baidu.tieba.ala.guardclub.model.h.b
                                    public void b(int i3, String str, Object obj) {
                                        b.this.dPH.mI(i2);
                                        if (b.this.dPH.getCount() <= 0) {
                                            b.this.aFU();
                                        }
                                        b.this.showToast(gVar2.dNX);
                                    }
                                });
                            }
                        }
                    });
                }
                b.this.dPI.b(gVar, i);
                LogManager.getGuardClubLogger().doDisplayLiveLeaveGuardLog();
            }
        }
    }

    public void completePullRefresh() {
        if (this.dPG != null) {
            this.dPG.completePullRefresh();
        }
    }

    public void aLr() {
        if (this.dMR != null) {
            this.dMR.endLoadData();
            this.dPG.setNextPage(null);
        }
    }

    public void hf(boolean z) {
        if (z) {
            if (this.dMR != null) {
                this.dPG.setNextPage(null);
            }
        } else if (this.dMR != null) {
            if (this.dMR.getView().getParent() == null) {
                this.dPG.setNextPage(this.dMR);
            }
            this.dMR.showNoMoreData();
        }
    }

    public void aJl() {
        if (this.dMR != null) {
            if (this.dMR.getView().getParent() == null) {
                this.dPG.setNextPage(this.dMR);
            }
            this.dMR.showLoadView();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.dPH != null) {
            this.dPH.notifyDataSetInvalidated();
        }
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFU() {
        aQ(8, 0);
    }

    public void f(h hVar) {
        this.dMn = hVar;
        this.dMn.aLF();
    }

    public void bt(List<g> list) {
        if (this.dPH != null && list != null && !list.isEmpty()) {
            aQ(0, 8);
            this.dPH.bt(list);
            return;
        }
        aFU();
    }

    private void aQ(int i, int i2) {
        this.dPG.setVisibility(i);
        if (i2 == 0) {
            this.aqz.reset();
            this.aqz.setTitle(a.i.guard_join_list_empty);
            this.aqz.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            this.aqz.setVisibility(0);
            return;
        }
        this.aqz.setVisibility(8);
    }

    public void bu(List<g> list) {
        if (this.dPH != null) {
            this.dPH.bu(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showToast(String str) {
        Toast makeText = Toast.makeText(this.mContext.getPageActivity(), (CharSequence) null, 0);
        makeText.setGravity(17, 0, 0);
        makeText.setText(String.format(this.mContext.getResources().getString(a.i.guard_club_exit_success_toast), str));
        makeText.show();
    }

    public void aLp() {
        if (this.dPH != null) {
            this.dPH.aLp();
        }
        MessageManager.getInstance().unRegisterListener(this.dFq);
    }

    public void aLt() {
        this.aqz.reset();
        this.aqz.setTitle(a.i.sdk_net_fail_tip_rank);
        this.aqz.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.view.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.aqz.setVisibility(8);
                if (b.this.dMn != null) {
                    b.this.dMn.aLF();
                }
            }
        });
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.aqz.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        } else {
            this.aqz.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        }
        this.aqz.setVisibility(0);
        this.dPG.setVisibility(8);
    }
}
