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
    private CommonEmptyView beq;
    private BaseActivity bjI;
    private BdListView fAN;
    private f fAO;
    private l fAP;
    CustomMessageListener fnT;
    private e fxX;
    private LoadMoreFooter fyB;
    private View mRootView;
    private String otherParams;

    public View getView() {
        return this.mRootView;
    }

    public d(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity.getPageContext());
        this.fnT = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.view.d.3
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
        this.bjI = baseActivity;
        this.mRootView = LayoutInflater.from(this.bjI).inflate(a.h.layout_guard_club_join_list, (ViewGroup) null);
        this.fAN = (BdListView) this.mRootView.findViewById(a.g.list_guard_club_join);
        this.fAO = new f(baseActivity, bdUniqueId);
        this.fAO.a(new AnonymousClass1(baseActivity));
        this.fAN.setAdapter((ListAdapter) this.fAO);
        this.fyB = new LoadMoreFooter(this.bjI);
        this.fyB.setBackgroundColor(-1);
        this.fyB.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_b));
        this.fyB.createView();
        this.fAN.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.view.d.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (!d.this.fyB.isLoading() && d.this.fxX.buD() && i + i2 > i3 - 2 && d.this.fxX.buD()) {
                    d.this.fxX.buF();
                }
            }
        });
        MessageManager.getInstance().registerListener(this.fnT);
        this.beq = (CommonEmptyView) this.mRootView.findViewById(a.g.guard_club_join_empty_view);
    }

    /* renamed from: com.baidu.tieba.ala.guardclub.view.d$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass1 implements f.b {
        final /* synthetic */ BaseActivity fAQ;

        AnonymousClass1(BaseActivity baseActivity) {
            this.fAQ = baseActivity;
        }

        @Override // com.baidu.tieba.ala.guardclub.f.b
        public void a(com.baidu.tieba.ala.guardclub.model.d dVar, int i) {
            if (dVar != null && d.this.fxX != null) {
                if (d.this.fAP == null) {
                    d.this.fAP = new l(this.fAQ.getPageContext());
                    d.this.fAP.a(new l.a() { // from class: com.baidu.tieba.ala.guardclub.view.d.1.1
                        @Override // com.baidu.tieba.ala.guardclub.l.a
                        public void c(final com.baidu.tieba.ala.guardclub.model.d dVar2, final int i2) {
                            LogManager.getGuardClubLogger().doClickLiveLeaveGuardLog();
                            if (d.this.fxX != null && dVar2 != null) {
                                d.this.fxX.a(dVar2.id, new e.b() { // from class: com.baidu.tieba.ala.guardclub.view.d.1.1.1
                                    @Override // com.baidu.tieba.ala.guardclub.model.e.b
                                    public void b(int i3, String str, Object obj) {
                                        d.this.fAO.qm(i2);
                                        if (d.this.fAO.getCount() <= 0) {
                                            d.this.bqS();
                                        }
                                        d.this.showToast(dVar2.aOu);
                                    }
                                });
                            }
                        }
                    });
                }
                d.this.fAP.b(dVar, i);
                LogManager.getGuardClubLogger().doDisplayLiveLeaveGuardLog();
            }
        }
    }

    public void completePullRefresh() {
        if (this.fAN != null) {
            this.fAN.completePullRefresh();
        }
    }

    public void buy() {
        if (this.fyB != null) {
            this.fyB.endLoadData();
            this.fAN.setNextPage(null);
        }
    }

    public void jZ(boolean z) {
        if (z) {
            if (this.fyB != null) {
                this.fAN.setNextPage(null);
            }
        } else if (this.fyB != null) {
            if (this.fyB.getView().getParent() == null) {
                this.fAN.setNextPage(this.fyB);
            }
            this.fyB.showNoMoreData();
        }
    }

    public void bqK() {
        if (this.fyB != null) {
            if (this.fyB.getView().getParent() == null) {
                this.fAN.setNextPage(this.fyB);
            }
            this.fyB.showLoadView();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.fAO != null) {
            this.fAO.notifyDataSetInvalidated();
        }
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqS() {
        br(8, 0);
    }

    public void f(e eVar) {
        this.fxX = eVar;
        this.fxX.buE();
    }

    public void by(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (this.fAO != null && list != null && !list.isEmpty()) {
            br(0, 8);
            this.fAO.by(list);
            return;
        }
        bqS();
    }

    private void br(int i, int i2) {
        this.fAN.setVisibility(i);
        if (i2 == 0) {
            this.beq.reset();
            this.beq.setTitle(a.i.guard_join_list_empty);
            this.beq.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.LIGHT);
            this.beq.setVisibility(0);
            return;
        }
        this.beq.setVisibility(8);
    }

    public void bz(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (this.fAO != null) {
            this.fAO.bz(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showToast(String str) {
        Toast makeText = Toast.makeText(this.mContext.getPageActivity(), (CharSequence) null, 0);
        makeText.setGravity(17, 0, 0);
        makeText.setText(String.format(this.mContext.getResources().getString(a.i.guard_club_exit_success_toast), str));
        makeText.show();
    }

    public void buw() {
        if (this.fAO != null) {
            this.fAO.buw();
        }
        MessageManager.getInstance().unRegisterListener(this.fnT);
    }

    public void bpb() {
        this.beq.reset();
        this.beq.setTitle(a.i.sdk_net_fail_tip_rank);
        this.beq.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.view.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.beq.setVisibility(8);
                if (d.this.fxX != null) {
                    d.this.fxX.buE();
                }
            }
        });
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.beq.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
        } else {
            this.beq.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
        }
        this.beq.setVisibility(0);
        this.fAN.setVisibility(8);
    }
}
