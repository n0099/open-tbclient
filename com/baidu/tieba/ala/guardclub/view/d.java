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
/* loaded from: classes3.dex */
public class d extends BdBaseView<GuardClubMemberListActivity> {
    private CommonEmptyView bjC;
    private BaseActivity boL;
    private LoadMoreFooter fJW;
    private e fJs;
    private BdListView fMh;
    private f fMi;
    private l fMj;
    CustomMessageListener fzr;
    private View mRootView;
    private String otherParams;

    public View getView() {
        return this.mRootView;
    }

    public d(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity.getPageContext());
        this.fzr = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.view.d.3
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
        this.boL = baseActivity;
        this.mRootView = LayoutInflater.from(this.boL).inflate(a.h.layout_guard_club_join_list, (ViewGroup) null);
        this.fMh = (BdListView) this.mRootView.findViewById(a.g.list_guard_club_join);
        this.fMi = new f(baseActivity, bdUniqueId);
        this.fMi.a(new AnonymousClass1(baseActivity));
        this.fMh.setAdapter((ListAdapter) this.fMi);
        this.fJW = new LoadMoreFooter(this.boL);
        this.fJW.setBackgroundColor(-1);
        this.fJW.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_b));
        this.fJW.createView();
        this.fMh.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.view.d.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (!d.this.fJW.isLoading() && d.this.fJs.bxB() && i + i2 > i3 - 2 && d.this.fJs.bxB()) {
                    d.this.fJs.bxD();
                }
            }
        });
        MessageManager.getInstance().registerListener(this.fzr);
        this.bjC = (CommonEmptyView) this.mRootView.findViewById(a.g.guard_club_join_empty_view);
    }

    /* renamed from: com.baidu.tieba.ala.guardclub.view.d$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass1 implements f.b {
        final /* synthetic */ BaseActivity fMk;

        AnonymousClass1(BaseActivity baseActivity) {
            this.fMk = baseActivity;
        }

        @Override // com.baidu.tieba.ala.guardclub.f.b
        public void a(com.baidu.tieba.ala.guardclub.model.d dVar, int i) {
            if (dVar != null && d.this.fJs != null) {
                if (d.this.fMj == null) {
                    d.this.fMj = new l(this.fMk.getPageContext());
                    d.this.fMj.a(new l.a() { // from class: com.baidu.tieba.ala.guardclub.view.d.1.1
                        @Override // com.baidu.tieba.ala.guardclub.l.a
                        public void c(final com.baidu.tieba.ala.guardclub.model.d dVar2, final int i2) {
                            LogManager.getGuardClubLogger().doClickLiveLeaveGuardLog();
                            if (d.this.fJs != null && dVar2 != null) {
                                d.this.fJs.a(dVar2.id, new e.b() { // from class: com.baidu.tieba.ala.guardclub.view.d.1.1.1
                                    @Override // com.baidu.tieba.ala.guardclub.model.e.b
                                    public void b(int i3, String str, Object obj) {
                                        d.this.fMi.qN(i2);
                                        if (d.this.fMi.getCount() <= 0) {
                                            d.this.btS();
                                        }
                                        d.this.showToast(dVar2.aRa);
                                    }
                                });
                            }
                        }
                    });
                }
                d.this.fMj.b(dVar, i);
                LogManager.getGuardClubLogger().doDisplayLiveLeaveGuardLog();
            }
        }
    }

    public void completePullRefresh() {
        if (this.fMh != null) {
            this.fMh.completePullRefresh();
        }
    }

    public void bxw() {
        if (this.fJW != null) {
            this.fJW.endLoadData();
            this.fMh.setNextPage(null);
        }
    }

    public void kn(boolean z) {
        if (z) {
            if (this.fJW != null) {
                this.fMh.setNextPage(null);
            }
        } else if (this.fJW != null) {
            if (this.fJW.getView().getParent() == null) {
                this.fMh.setNextPage(this.fJW);
            }
            this.fJW.showNoMoreData();
        }
    }

    public void btK() {
        if (this.fJW != null) {
            if (this.fJW.getView().getParent() == null) {
                this.fMh.setNextPage(this.fJW);
            }
            this.fJW.showLoadView();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.fMi != null) {
            this.fMi.notifyDataSetInvalidated();
        }
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btS() {
        bv(8, 0);
    }

    public void f(e eVar) {
        this.fJs = eVar;
        this.fJs.bxC();
    }

    public void bH(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (this.fMi != null && list != null && !list.isEmpty()) {
            bv(0, 8);
            this.fMi.bH(list);
            return;
        }
        btS();
    }

    private void bv(int i, int i2) {
        this.fMh.setVisibility(i);
        if (i2 == 0) {
            this.bjC.reset();
            this.bjC.setTitle(a.i.guard_join_list_empty);
            this.bjC.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.LIGHT);
            this.bjC.setVisibility(0);
            return;
        }
        this.bjC.setVisibility(8);
    }

    public void bI(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (this.fMi != null) {
            this.fMi.bI(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showToast(String str) {
        Toast makeText = Toast.makeText(this.mContext.getPageActivity(), (CharSequence) null, 0);
        makeText.setGravity(17, 0, 0);
        makeText.setText(String.format(this.mContext.getResources().getString(a.i.guard_club_exit_success_toast), str));
        makeText.show();
    }

    public void bxu() {
        if (this.fMi != null) {
            this.fMi.bxu();
        }
        MessageManager.getInstance().unRegisterListener(this.fzr);
    }

    public void brE() {
        this.bjC.reset();
        this.bjC.setTitle(a.i.sdk_net_fail_tip_rank);
        this.bjC.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.view.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.bjC.setVisibility(8);
                if (d.this.fJs != null) {
                    d.this.fJs.bxC();
                }
            }
        });
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.bjC.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
        } else {
            this.bjC.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
        }
        this.bjC.setVisibility(0);
        this.fMh.setVisibility(8);
    }
}
