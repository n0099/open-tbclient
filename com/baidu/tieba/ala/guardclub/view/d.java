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
    private CommonEmptyView aWT;
    private BaseActivity bcd;
    CustomMessageListener fal;
    private LoadMoreFooter fkQ;
    private e fkm;
    private BdListView fnb;
    private f fnc;
    private l fnd;
    private View mRootView;
    private String otherParams;

    public View getView() {
        return this.mRootView;
    }

    public d(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity.getPageContext());
        this.fal = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.view.d.3
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
        this.bcd = baseActivity;
        this.mRootView = LayoutInflater.from(this.bcd).inflate(a.h.layout_guard_club_join_list, (ViewGroup) null);
        this.fnb = (BdListView) this.mRootView.findViewById(a.g.list_guard_club_join);
        this.fnc = new f(baseActivity, bdUniqueId);
        this.fnc.a(new AnonymousClass1(baseActivity));
        this.fnb.setAdapter((ListAdapter) this.fnc);
        this.fkQ = new LoadMoreFooter(this.bcd);
        this.fkQ.setBackgroundColor(-1);
        this.fkQ.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_b));
        this.fkQ.createView();
        this.fnb.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.view.d.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (!d.this.fkQ.isLoading() && d.this.fkm.boN() && i + i2 > i3 - 2 && d.this.fkm.boN()) {
                    d.this.fkm.boP();
                }
            }
        });
        MessageManager.getInstance().registerListener(this.fal);
        this.aWT = (CommonEmptyView) this.mRootView.findViewById(a.g.guard_club_join_empty_view);
    }

    /* renamed from: com.baidu.tieba.ala.guardclub.view.d$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass1 implements f.b {
        final /* synthetic */ BaseActivity fne;

        AnonymousClass1(BaseActivity baseActivity) {
            this.fne = baseActivity;
        }

        @Override // com.baidu.tieba.ala.guardclub.f.b
        public void a(com.baidu.tieba.ala.guardclub.model.d dVar, int i) {
            if (dVar != null && d.this.fkm != null) {
                if (d.this.fnd == null) {
                    d.this.fnd = new l(this.fne.getPageContext());
                    d.this.fnd.a(new l.a() { // from class: com.baidu.tieba.ala.guardclub.view.d.1.1
                        @Override // com.baidu.tieba.ala.guardclub.l.a
                        public void c(final com.baidu.tieba.ala.guardclub.model.d dVar2, final int i2) {
                            LogManager.getGuardClubLogger().doClickLiveLeaveGuardLog();
                            if (d.this.fkm != null && dVar2 != null) {
                                d.this.fkm.a(dVar2.id, new e.b() { // from class: com.baidu.tieba.ala.guardclub.view.d.1.1.1
                                    @Override // com.baidu.tieba.ala.guardclub.model.e.b
                                    public void b(int i3, String str, Object obj) {
                                        d.this.fnc.pL(i2);
                                        if (d.this.fnc.getCount() <= 0) {
                                            d.this.aqF();
                                        }
                                        d.this.showToast(dVar2.aIF);
                                    }
                                });
                            }
                        }
                    });
                }
                d.this.fnd.b(dVar, i);
                LogManager.getGuardClubLogger().doDisplayLiveLeaveGuardLog();
            }
        }
    }

    public void completePullRefresh() {
        if (this.fnb != null) {
            this.fnb.completePullRefresh();
        }
    }

    public void boI() {
        if (this.fkQ != null) {
            this.fkQ.endLoadData();
            this.fnb.setNextPage(null);
        }
    }

    public void jG(boolean z) {
        if (z) {
            if (this.fkQ != null) {
                this.fnb.setNextPage(null);
            }
        } else if (this.fkQ != null) {
            if (this.fkQ.getView().getParent() == null) {
                this.fnb.setNextPage(this.fkQ);
            }
            this.fkQ.showNoMoreData();
        }
    }

    public void blq() {
        if (this.fkQ != null) {
            if (this.fkQ.getView().getParent() == null) {
                this.fnb.setNextPage(this.fkQ);
            }
            this.fkQ.showLoadView();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.fnc != null) {
            this.fnc.notifyDataSetInvalidated();
        }
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqF() {
        bo(8, 0);
    }

    public void f(e eVar) {
        this.fkm = eVar;
        this.fkm.boO();
    }

    public void bB(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (this.fnc != null && list != null && !list.isEmpty()) {
            bo(0, 8);
            this.fnc.bB(list);
            return;
        }
        aqF();
    }

    private void bo(int i, int i2) {
        this.fnb.setVisibility(i);
        if (i2 == 0) {
            this.aWT.reset();
            this.aWT.setTitle(a.i.guard_join_list_empty);
            this.aWT.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.LIGHT);
            this.aWT.setVisibility(0);
            return;
        }
        this.aWT.setVisibility(8);
    }

    public void bC(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (this.fnc != null) {
            this.fnc.bC(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showToast(String str) {
        Toast makeText = Toast.makeText(this.mContext.getPageActivity(), (CharSequence) null, 0);
        makeText.setGravity(17, 0, 0);
        makeText.setText(String.format(this.mContext.getResources().getString(a.i.guard_club_exit_success_toast), str));
        makeText.show();
    }

    public void boG() {
        if (this.fnc != null) {
            this.fnc.boG();
        }
        MessageManager.getInstance().unRegisterListener(this.fal);
    }

    public void bjJ() {
        this.aWT.reset();
        this.aWT.setTitle(a.i.sdk_net_fail_tip_rank);
        this.aWT.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.view.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.aWT.setVisibility(8);
                if (d.this.fkm != null) {
                    d.this.fkm.boO();
                }
            }
        });
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.aWT.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
        } else {
            this.aWT.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
        }
        this.aWT.setVisibility(0);
        this.fnb.setVisibility(8);
    }
}
