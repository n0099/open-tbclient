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
import com.baidu.live.r.a;
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
/* loaded from: classes2.dex */
public class b extends BdBaseView<GuardClubMemberListActivity> {
    private BaseActivity aBW;
    private CommonEmptyView ayG;
    private h eAT;
    private LoadMoreFooter eBx;
    private BdListView eEg;
    private d eEh;
    private j eEi;
    CustomMessageListener erA;
    private View mRootView;
    private String otherParams;

    public View getView() {
        return this.mRootView;
    }

    public b(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity.getPageContext());
        this.erA = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.view.b.3
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
        this.aBW = baseActivity;
        this.mRootView = LayoutInflater.from(this.aBW).inflate(a.h.layout_guard_club_join_list, (ViewGroup) null);
        this.eEg = (BdListView) this.mRootView.findViewById(a.g.list_guard_club_join);
        this.eEh = new d(baseActivity, bdUniqueId);
        this.eEh.a(new AnonymousClass1(baseActivity));
        this.eEg.setAdapter((ListAdapter) this.eEh);
        this.eBx = new LoadMoreFooter(this.aBW);
        this.eBx.setBackgroundColor(-1);
        this.eBx.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_b));
        this.eBx.createView();
        this.eEg.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.view.b.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (!b.this.eBx.isLoading() && b.this.eAT.bdg() && i + i2 > i3 - 2 && b.this.eAT.bdg()) {
                    b.this.eAT.bdi();
                }
            }
        });
        MessageManager.getInstance().registerListener(this.erA);
        this.ayG = (CommonEmptyView) this.mRootView.findViewById(a.g.guard_club_join_empty_view);
    }

    /* renamed from: com.baidu.tieba.ala.guardclub.view.b$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    class AnonymousClass1 implements d.b {
        final /* synthetic */ BaseActivity eEj;

        AnonymousClass1(BaseActivity baseActivity) {
            this.eEj = baseActivity;
        }

        @Override // com.baidu.tieba.ala.guardclub.d.b
        public void a(g gVar, int i) {
            if (gVar != null && b.this.eAT != null) {
                if (b.this.eEi == null) {
                    b.this.eEi = new j(this.eEj.getPageContext());
                    b.this.eEi.a(new j.a() { // from class: com.baidu.tieba.ala.guardclub.view.b.1.1
                        @Override // com.baidu.tieba.ala.guardclub.j.a
                        public void c(final g gVar2, final int i2) {
                            LogManager.getGuardClubLogger().doClickLiveLeaveGuardLog();
                            if (b.this.eAT != null && gVar2 != null) {
                                b.this.eAT.a(gVar2.id, new h.b() { // from class: com.baidu.tieba.ala.guardclub.view.b.1.1.1
                                    @Override // com.baidu.tieba.ala.guardclub.model.h.b
                                    public void b(int i3, String str, Object obj) {
                                        b.this.eEh.oY(i2);
                                        if (b.this.eEh.getCount() <= 0) {
                                            b.this.age();
                                        }
                                        b.this.showToast(gVar2.eCz);
                                    }
                                });
                            }
                        }
                    });
                }
                b.this.eEi.b(gVar, i);
                LogManager.getGuardClubLogger().doDisplayLiveLeaveGuardLog();
            }
        }
    }

    public void completePullRefresh() {
        if (this.eEg != null) {
            this.eEg.completePullRefresh();
        }
    }

    public void bcU() {
        if (this.eBx != null) {
            this.eBx.endLoadData();
            this.eEg.setNextPage(null);
        }
    }

    public void iw(boolean z) {
        if (z) {
            if (this.eBx != null) {
                this.eEg.setNextPage(null);
            }
        } else if (this.eBx != null) {
            if (this.eBx.getView().getParent() == null) {
                this.eEg.setNextPage(this.eBx);
            }
            this.eBx.showNoMoreData();
        }
    }

    public void bac() {
        if (this.eBx != null) {
            if (this.eBx.getView().getParent() == null) {
                this.eEg.setNextPage(this.eBx);
            }
            this.eBx.showLoadView();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.eEh != null) {
            this.eEh.notifyDataSetInvalidated();
        }
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void age() {
        bi(8, 0);
    }

    public void f(h hVar) {
        this.eAT = hVar;
        this.eAT.bdh();
    }

    public void bs(List<g> list) {
        if (this.eEh != null && list != null && !list.isEmpty()) {
            bi(0, 8);
            this.eEh.bs(list);
            return;
        }
        age();
    }

    private void bi(int i, int i2) {
        this.eEg.setVisibility(i);
        if (i2 == 0) {
            this.ayG.reset();
            this.ayG.setTitle(a.i.guard_join_list_empty);
            this.ayG.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.LIGHT);
            this.ayG.setVisibility(0);
            return;
        }
        this.ayG.setVisibility(8);
    }

    public void bt(List<g> list) {
        if (this.eEh != null) {
            this.eEh.bt(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showToast(String str) {
        Toast makeText = Toast.makeText(this.mContext.getPageActivity(), (CharSequence) null, 0);
        makeText.setGravity(17, 0, 0);
        makeText.setText(String.format(this.mContext.getResources().getString(a.i.guard_club_exit_success_toast), str));
        makeText.show();
    }

    public void bcS() {
        if (this.eEh != null) {
            this.eEh.bcS();
        }
        MessageManager.getInstance().unRegisterListener(this.erA);
    }

    public void aZk() {
        this.ayG.reset();
        this.ayG.setTitle(a.i.sdk_net_fail_tip_rank);
        this.ayG.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.view.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.ayG.setVisibility(8);
                if (b.this.eAT != null) {
                    b.this.eAT.bdh();
                }
            }
        });
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.ayG.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
        } else {
            this.ayG.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
        }
        this.ayG.setVisibility(0);
        this.eEg.setVisibility(8);
    }
}
