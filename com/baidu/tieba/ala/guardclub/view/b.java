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
import com.baidu.live.q.a;
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
    private BaseActivity aBe;
    private CommonEmptyView axX;
    private LoadMoreFooter eAm;
    private BdListView eCV;
    private d eCW;
    private j eCX;
    CustomMessageListener eqn;
    private h ezI;
    private View mRootView;
    private String otherParams;

    public View getView() {
        return this.mRootView;
    }

    public b(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity.getPageContext());
        this.eqn = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.view.b.3
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
        this.aBe = baseActivity;
        this.mRootView = LayoutInflater.from(this.aBe).inflate(a.h.layout_guard_club_join_list, (ViewGroup) null);
        this.eCV = (BdListView) this.mRootView.findViewById(a.g.list_guard_club_join);
        this.eCW = new d(baseActivity, bdUniqueId);
        this.eCW.a(new AnonymousClass1(baseActivity));
        this.eCV.setAdapter((ListAdapter) this.eCW);
        this.eAm = new LoadMoreFooter(this.aBe);
        this.eAm.setBackgroundColor(-1);
        this.eAm.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_b));
        this.eAm.createView();
        this.eCV.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.view.b.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (!b.this.eAm.isLoading() && b.this.ezI.bcL() && i + i2 > i3 - 2 && b.this.ezI.bcL()) {
                    b.this.ezI.bcN();
                }
            }
        });
        MessageManager.getInstance().registerListener(this.eqn);
        this.axX = (CommonEmptyView) this.mRootView.findViewById(a.g.guard_club_join_empty_view);
    }

    /* renamed from: com.baidu.tieba.ala.guardclub.view.b$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    class AnonymousClass1 implements d.b {
        final /* synthetic */ BaseActivity eCY;

        AnonymousClass1(BaseActivity baseActivity) {
            this.eCY = baseActivity;
        }

        @Override // com.baidu.tieba.ala.guardclub.d.b
        public void a(g gVar, int i) {
            if (gVar != null && b.this.ezI != null) {
                if (b.this.eCX == null) {
                    b.this.eCX = new j(this.eCY.getPageContext());
                    b.this.eCX.a(new j.a() { // from class: com.baidu.tieba.ala.guardclub.view.b.1.1
                        @Override // com.baidu.tieba.ala.guardclub.j.a
                        public void c(final g gVar2, final int i2) {
                            LogManager.getGuardClubLogger().doClickLiveLeaveGuardLog();
                            if (b.this.ezI != null && gVar2 != null) {
                                b.this.ezI.a(gVar2.id, new h.b() { // from class: com.baidu.tieba.ala.guardclub.view.b.1.1.1
                                    @Override // com.baidu.tieba.ala.guardclub.model.h.b
                                    public void b(int i3, String str, Object obj) {
                                        b.this.eCW.oX(i2);
                                        if (b.this.eCW.getCount() <= 0) {
                                            b.this.afL();
                                        }
                                        b.this.showToast(gVar2.eBo);
                                    }
                                });
                            }
                        }
                    });
                }
                b.this.eCX.b(gVar, i);
                LogManager.getGuardClubLogger().doDisplayLiveLeaveGuardLog();
            }
        }
    }

    public void completePullRefresh() {
        if (this.eCV != null) {
            this.eCV.completePullRefresh();
        }
    }

    public void bcz() {
        if (this.eAm != null) {
            this.eAm.endLoadData();
            this.eCV.setNextPage(null);
        }
    }

    public void im(boolean z) {
        if (z) {
            if (this.eAm != null) {
                this.eCV.setNextPage(null);
            }
        } else if (this.eAm != null) {
            if (this.eAm.getView().getParent() == null) {
                this.eCV.setNextPage(this.eAm);
            }
            this.eAm.showNoMoreData();
        }
    }

    public void aZH() {
        if (this.eAm != null) {
            if (this.eAm.getView().getParent() == null) {
                this.eCV.setNextPage(this.eAm);
            }
            this.eAm.showLoadView();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.eCW != null) {
            this.eCW.notifyDataSetInvalidated();
        }
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afL() {
        be(8, 0);
    }

    public void f(h hVar) {
        this.ezI = hVar;
        this.ezI.bcM();
    }

    public void bs(List<g> list) {
        if (this.eCW != null && list != null && !list.isEmpty()) {
            be(0, 8);
            this.eCW.bs(list);
            return;
        }
        afL();
    }

    private void be(int i, int i2) {
        this.eCV.setVisibility(i);
        if (i2 == 0) {
            this.axX.reset();
            this.axX.setTitle(a.i.guard_join_list_empty);
            this.axX.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.LIGHT);
            this.axX.setVisibility(0);
            return;
        }
        this.axX.setVisibility(8);
    }

    public void bt(List<g> list) {
        if (this.eCW != null) {
            this.eCW.bt(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showToast(String str) {
        Toast makeText = Toast.makeText(this.mContext.getPageActivity(), (CharSequence) null, 0);
        makeText.setGravity(17, 0, 0);
        makeText.setText(String.format(this.mContext.getResources().getString(a.i.guard_club_exit_success_toast), str));
        makeText.show();
    }

    public void bcx() {
        if (this.eCW != null) {
            this.eCW.bcx();
        }
        MessageManager.getInstance().unRegisterListener(this.eqn);
    }

    public void aYQ() {
        this.axX.reset();
        this.axX.setTitle(a.i.sdk_net_fail_tip_rank);
        this.axX.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.view.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.axX.setVisibility(8);
                if (b.this.ezI != null) {
                    b.this.ezI.bcM();
                }
            }
        });
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.axX.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
        } else {
            this.axX.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
        }
        this.axX.setVisibility(0);
        this.eCV.setVisibility(8);
    }
}
