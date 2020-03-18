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
    private CommonEmptyView aDm;
    private BaseActivity aGt;
    private e eFR;
    private LoadMoreFooter eGv;
    private BdListView eIK;
    private f eIL;
    private l eIM;
    CustomMessageListener ewu;
    private View mRootView;
    private String otherParams;

    public View getView() {
        return this.mRootView;
    }

    public d(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity.getPageContext());
        this.ewu = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.view.d.3
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
        this.aGt = baseActivity;
        this.mRootView = LayoutInflater.from(this.aGt).inflate(a.h.layout_guard_club_join_list, (ViewGroup) null);
        this.eIK = (BdListView) this.mRootView.findViewById(a.g.list_guard_club_join);
        this.eIL = new f(baseActivity, bdUniqueId);
        this.eIL.a(new AnonymousClass1(baseActivity));
        this.eIK.setAdapter((ListAdapter) this.eIL);
        this.eGv = new LoadMoreFooter(this.aGt);
        this.eGv.setBackgroundColor(-1);
        this.eGv.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_b));
        this.eGv.createView();
        this.eIK.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.view.d.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (!d.this.eGv.isLoading() && d.this.eFR.bfw() && i + i2 > i3 - 2 && d.this.eFR.bfw()) {
                    d.this.eFR.bfy();
                }
            }
        });
        MessageManager.getInstance().registerListener(this.ewu);
        this.aDm = (CommonEmptyView) this.mRootView.findViewById(a.g.guard_club_join_empty_view);
    }

    /* renamed from: com.baidu.tieba.ala.guardclub.view.d$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass1 implements f.b {
        final /* synthetic */ BaseActivity eIN;

        AnonymousClass1(BaseActivity baseActivity) {
            this.eIN = baseActivity;
        }

        @Override // com.baidu.tieba.ala.guardclub.f.b
        public void a(com.baidu.tieba.ala.guardclub.model.d dVar, int i) {
            if (dVar != null && d.this.eFR != null) {
                if (d.this.eIM == null) {
                    d.this.eIM = new l(this.eIN.getPageContext());
                    d.this.eIM.a(new l.a() { // from class: com.baidu.tieba.ala.guardclub.view.d.1.1
                        @Override // com.baidu.tieba.ala.guardclub.l.a
                        public void c(final com.baidu.tieba.ala.guardclub.model.d dVar2, final int i2) {
                            LogManager.getGuardClubLogger().doClickLiveLeaveGuardLog();
                            if (d.this.eFR != null && dVar2 != null) {
                                d.this.eFR.a(dVar2.id, new e.b() { // from class: com.baidu.tieba.ala.guardclub.view.d.1.1.1
                                    @Override // com.baidu.tieba.ala.guardclub.model.e.b
                                    public void b(int i3, String str, Object obj) {
                                        d.this.eIL.pr(i2);
                                        if (d.this.eIL.getCount() <= 0) {
                                            d.this.aix();
                                        }
                                        d.this.showToast(dVar2.apW);
                                    }
                                });
                            }
                        }
                    });
                }
                d.this.eIM.b(dVar, i);
                LogManager.getGuardClubLogger().doDisplayLiveLeaveGuardLog();
            }
        }
    }

    public void completePullRefresh() {
        if (this.eIK != null) {
            this.eIK.completePullRefresh();
        }
    }

    public void bfr() {
        if (this.eGv != null) {
            this.eGv.endLoadData();
            this.eIK.setNextPage(null);
        }
    }

    public void iF(boolean z) {
        if (z) {
            if (this.eGv != null) {
                this.eIK.setNextPage(null);
            }
        } else if (this.eGv != null) {
            if (this.eGv.getView().getParent() == null) {
                this.eIK.setNextPage(this.eGv);
            }
            this.eGv.showNoMoreData();
        }
    }

    public void bcz() {
        if (this.eGv != null) {
            if (this.eGv.getView().getParent() == null) {
                this.eIK.setNextPage(this.eGv);
            }
            this.eGv.showLoadView();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.eIL != null) {
            this.eIL.notifyDataSetInvalidated();
        }
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aix() {
        bj(8, 0);
    }

    public void f(e eVar) {
        this.eFR = eVar;
        this.eFR.bfx();
    }

    public void bs(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (this.eIL != null && list != null && !list.isEmpty()) {
            bj(0, 8);
            this.eIL.bs(list);
            return;
        }
        aix();
    }

    private void bj(int i, int i2) {
        this.eIK.setVisibility(i);
        if (i2 == 0) {
            this.aDm.reset();
            this.aDm.setTitle(a.i.guard_join_list_empty);
            this.aDm.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.LIGHT);
            this.aDm.setVisibility(0);
            return;
        }
        this.aDm.setVisibility(8);
    }

    public void bt(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (this.eIL != null) {
            this.eIL.bt(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showToast(String str) {
        Toast makeText = Toast.makeText(this.mContext.getPageActivity(), (CharSequence) null, 0);
        makeText.setGravity(17, 0, 0);
        makeText.setText(String.format(this.mContext.getResources().getString(a.i.guard_club_exit_success_toast), str));
        makeText.show();
    }

    public void bfp() {
        if (this.eIL != null) {
            this.eIL.bfp();
        }
        MessageManager.getInstance().unRegisterListener(this.ewu);
    }

    public void bbG() {
        this.aDm.reset();
        this.aDm.setTitle(a.i.sdk_net_fail_tip_rank);
        this.aDm.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.view.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.aDm.setVisibility(8);
                if (d.this.eFR != null) {
                    d.this.eFR.bfx();
                }
            }
        });
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.aDm.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
        } else {
            this.aDm.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
        }
        this.aDm.setVisibility(0);
        this.eIK.setVisibility(8);
    }
}
