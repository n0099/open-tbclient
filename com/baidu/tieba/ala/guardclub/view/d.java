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
    private CommonEmptyView aCW;
    private BaseActivity aGd;
    private LoadMoreFooter eFL;
    private e eFh;
    private BdListView eIa;
    private f eIb;
    private l eIc;
    CustomMessageListener evK;
    private View mRootView;
    private String otherParams;

    public View getView() {
        return this.mRootView;
    }

    public d(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity.getPageContext());
        this.evK = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.view.d.3
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
        this.aGd = baseActivity;
        this.mRootView = LayoutInflater.from(this.aGd).inflate(a.h.layout_guard_club_join_list, (ViewGroup) null);
        this.eIa = (BdListView) this.mRootView.findViewById(a.g.list_guard_club_join);
        this.eIb = new f(baseActivity, bdUniqueId);
        this.eIb.a(new AnonymousClass1(baseActivity));
        this.eIa.setAdapter((ListAdapter) this.eIb);
        this.eFL = new LoadMoreFooter(this.aGd);
        this.eFL.setBackgroundColor(-1);
        this.eFL.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_b));
        this.eFL.createView();
        this.eIa.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.view.d.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (!d.this.eFL.isLoading() && d.this.eFh.bfo() && i + i2 > i3 - 2 && d.this.eFh.bfo()) {
                    d.this.eFh.bfq();
                }
            }
        });
        MessageManager.getInstance().registerListener(this.evK);
        this.aCW = (CommonEmptyView) this.mRootView.findViewById(a.g.guard_club_join_empty_view);
    }

    /* renamed from: com.baidu.tieba.ala.guardclub.view.d$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass1 implements f.b {
        final /* synthetic */ BaseActivity eId;

        AnonymousClass1(BaseActivity baseActivity) {
            this.eId = baseActivity;
        }

        @Override // com.baidu.tieba.ala.guardclub.f.b
        public void a(com.baidu.tieba.ala.guardclub.model.d dVar, int i) {
            if (dVar != null && d.this.eFh != null) {
                if (d.this.eIc == null) {
                    d.this.eIc = new l(this.eId.getPageContext());
                    d.this.eIc.a(new l.a() { // from class: com.baidu.tieba.ala.guardclub.view.d.1.1
                        @Override // com.baidu.tieba.ala.guardclub.l.a
                        public void c(final com.baidu.tieba.ala.guardclub.model.d dVar2, final int i2) {
                            LogManager.getGuardClubLogger().doClickLiveLeaveGuardLog();
                            if (d.this.eFh != null && dVar2 != null) {
                                d.this.eFh.a(dVar2.id, new e.b() { // from class: com.baidu.tieba.ala.guardclub.view.d.1.1.1
                                    @Override // com.baidu.tieba.ala.guardclub.model.e.b
                                    public void b(int i3, String str, Object obj) {
                                        d.this.eIb.pp(i2);
                                        if (d.this.eIb.getCount() <= 0) {
                                            d.this.ais();
                                        }
                                        d.this.showToast(dVar2.apL);
                                    }
                                });
                            }
                        }
                    });
                }
                d.this.eIc.b(dVar, i);
                LogManager.getGuardClubLogger().doDisplayLiveLeaveGuardLog();
            }
        }
    }

    public void completePullRefresh() {
        if (this.eIa != null) {
            this.eIa.completePullRefresh();
        }
    }

    public void bfj() {
        if (this.eFL != null) {
            this.eFL.endLoadData();
            this.eIa.setNextPage(null);
        }
    }

    public void iD(boolean z) {
        if (z) {
            if (this.eFL != null) {
                this.eIa.setNextPage(null);
            }
        } else if (this.eFL != null) {
            if (this.eFL.getView().getParent() == null) {
                this.eIa.setNextPage(this.eFL);
            }
            this.eFL.showNoMoreData();
        }
    }

    public void bcs() {
        if (this.eFL != null) {
            if (this.eFL.getView().getParent() == null) {
                this.eIa.setNextPage(this.eFL);
            }
            this.eFL.showLoadView();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.eIb != null) {
            this.eIb.notifyDataSetInvalidated();
        }
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ais() {
        bi(8, 0);
    }

    public void f(e eVar) {
        this.eFh = eVar;
        this.eFh.bfp();
    }

    public void bs(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (this.eIb != null && list != null && !list.isEmpty()) {
            bi(0, 8);
            this.eIb.bs(list);
            return;
        }
        ais();
    }

    private void bi(int i, int i2) {
        this.eIa.setVisibility(i);
        if (i2 == 0) {
            this.aCW.reset();
            this.aCW.setTitle(a.i.guard_join_list_empty);
            this.aCW.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.LIGHT);
            this.aCW.setVisibility(0);
            return;
        }
        this.aCW.setVisibility(8);
    }

    public void bt(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (this.eIb != null) {
            this.eIb.bt(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showToast(String str) {
        Toast makeText = Toast.makeText(this.mContext.getPageActivity(), (CharSequence) null, 0);
        makeText.setGravity(17, 0, 0);
        makeText.setText(String.format(this.mContext.getResources().getString(a.i.guard_club_exit_success_toast), str));
        makeText.show();
    }

    public void bfh() {
        if (this.eIb != null) {
            this.eIb.bfh();
        }
        MessageManager.getInstance().unRegisterListener(this.evK);
    }

    public void bbz() {
        this.aCW.reset();
        this.aCW.setTitle(a.i.sdk_net_fail_tip_rank);
        this.aCW.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.view.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.aCW.setVisibility(8);
                if (d.this.eFh != null) {
                    d.this.eFh.bfp();
                }
            }
        });
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.aCW.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
        } else {
            this.aCW.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
        }
        this.aCW.setVisibility(0);
        this.eIa.setVisibility(8);
    }
}
