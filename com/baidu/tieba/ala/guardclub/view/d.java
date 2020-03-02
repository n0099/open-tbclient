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
    private CommonEmptyView aCX;
    private BaseActivity aGe;
    private LoadMoreFooter eFM;
    private e eFi;
    private BdListView eIb;
    private f eIc;
    private l eId;
    CustomMessageListener evL;
    private View mRootView;
    private String otherParams;

    public View getView() {
        return this.mRootView;
    }

    public d(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity.getPageContext());
        this.evL = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.view.d.3
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
        this.aGe = baseActivity;
        this.mRootView = LayoutInflater.from(this.aGe).inflate(a.h.layout_guard_club_join_list, (ViewGroup) null);
        this.eIb = (BdListView) this.mRootView.findViewById(a.g.list_guard_club_join);
        this.eIc = new f(baseActivity, bdUniqueId);
        this.eIc.a(new AnonymousClass1(baseActivity));
        this.eIb.setAdapter((ListAdapter) this.eIc);
        this.eFM = new LoadMoreFooter(this.aGe);
        this.eFM.setBackgroundColor(-1);
        this.eFM.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_b));
        this.eFM.createView();
        this.eIb.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.view.d.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (!d.this.eFM.isLoading() && d.this.eFi.bfq() && i + i2 > i3 - 2 && d.this.eFi.bfq()) {
                    d.this.eFi.bfs();
                }
            }
        });
        MessageManager.getInstance().registerListener(this.evL);
        this.aCX = (CommonEmptyView) this.mRootView.findViewById(a.g.guard_club_join_empty_view);
    }

    /* renamed from: com.baidu.tieba.ala.guardclub.view.d$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass1 implements f.b {
        final /* synthetic */ BaseActivity eIe;

        AnonymousClass1(BaseActivity baseActivity) {
            this.eIe = baseActivity;
        }

        @Override // com.baidu.tieba.ala.guardclub.f.b
        public void a(com.baidu.tieba.ala.guardclub.model.d dVar, int i) {
            if (dVar != null && d.this.eFi != null) {
                if (d.this.eId == null) {
                    d.this.eId = new l(this.eIe.getPageContext());
                    d.this.eId.a(new l.a() { // from class: com.baidu.tieba.ala.guardclub.view.d.1.1
                        @Override // com.baidu.tieba.ala.guardclub.l.a
                        public void c(final com.baidu.tieba.ala.guardclub.model.d dVar2, final int i2) {
                            LogManager.getGuardClubLogger().doClickLiveLeaveGuardLog();
                            if (d.this.eFi != null && dVar2 != null) {
                                d.this.eFi.a(dVar2.id, new e.b() { // from class: com.baidu.tieba.ala.guardclub.view.d.1.1.1
                                    @Override // com.baidu.tieba.ala.guardclub.model.e.b
                                    public void b(int i3, String str, Object obj) {
                                        d.this.eIc.pp(i2);
                                        if (d.this.eIc.getCount() <= 0) {
                                            d.this.aiu();
                                        }
                                        d.this.showToast(dVar2.apL);
                                    }
                                });
                            }
                        }
                    });
                }
                d.this.eId.b(dVar, i);
                LogManager.getGuardClubLogger().doDisplayLiveLeaveGuardLog();
            }
        }
    }

    public void completePullRefresh() {
        if (this.eIb != null) {
            this.eIb.completePullRefresh();
        }
    }

    public void bfl() {
        if (this.eFM != null) {
            this.eFM.endLoadData();
            this.eIb.setNextPage(null);
        }
    }

    public void iD(boolean z) {
        if (z) {
            if (this.eFM != null) {
                this.eIb.setNextPage(null);
            }
        } else if (this.eFM != null) {
            if (this.eFM.getView().getParent() == null) {
                this.eIb.setNextPage(this.eFM);
            }
            this.eFM.showNoMoreData();
        }
    }

    public void bcu() {
        if (this.eFM != null) {
            if (this.eFM.getView().getParent() == null) {
                this.eIb.setNextPage(this.eFM);
            }
            this.eFM.showLoadView();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.eIc != null) {
            this.eIc.notifyDataSetInvalidated();
        }
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiu() {
        bi(8, 0);
    }

    public void f(e eVar) {
        this.eFi = eVar;
        this.eFi.bfr();
    }

    public void bs(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (this.eIc != null && list != null && !list.isEmpty()) {
            bi(0, 8);
            this.eIc.bs(list);
            return;
        }
        aiu();
    }

    private void bi(int i, int i2) {
        this.eIb.setVisibility(i);
        if (i2 == 0) {
            this.aCX.reset();
            this.aCX.setTitle(a.i.guard_join_list_empty);
            this.aCX.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.LIGHT);
            this.aCX.setVisibility(0);
            return;
        }
        this.aCX.setVisibility(8);
    }

    public void bt(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (this.eIc != null) {
            this.eIc.bt(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showToast(String str) {
        Toast makeText = Toast.makeText(this.mContext.getPageActivity(), (CharSequence) null, 0);
        makeText.setGravity(17, 0, 0);
        makeText.setText(String.format(this.mContext.getResources().getString(a.i.guard_club_exit_success_toast), str));
        makeText.show();
    }

    public void bfj() {
        if (this.eIc != null) {
            this.eIc.bfj();
        }
        MessageManager.getInstance().unRegisterListener(this.evL);
    }

    public void bbB() {
        this.aCX.reset();
        this.aCX.setTitle(a.i.sdk_net_fail_tip_rank);
        this.aCX.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.view.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.aCX.setVisibility(8);
                if (d.this.eFi != null) {
                    d.this.eFi.bfr();
                }
            }
        });
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.aCX.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
        } else {
            this.aCX.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
        }
        this.aCX.setVisibility(0);
        this.eIb.setVisibility(8);
    }
}
