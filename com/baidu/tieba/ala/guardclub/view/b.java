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
    private CommonEmptyView aqh;
    private BaseActivity atk;
    CustomMessageListener dEz;
    private h dLw;
    private LoadMoreFooter dMa;
    private BdListView dOP;
    private d dOQ;
    private j dOR;
    private View mRootView;
    private String otherParams;

    public View getView() {
        return this.mRootView;
    }

    public b(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity.getPageContext());
        this.dEz = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.view.b.3
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
        this.atk = baseActivity;
        this.mRootView = LayoutInflater.from(this.atk).inflate(a.h.layout_guard_club_join_list, (ViewGroup) null);
        this.dOP = (BdListView) this.mRootView.findViewById(a.g.list_guard_club_join);
        this.dOQ = new d(baseActivity, bdUniqueId);
        this.dOQ.a(new AnonymousClass1(baseActivity));
        this.dOP.setAdapter((ListAdapter) this.dOQ);
        this.dMa = new LoadMoreFooter(this.atk);
        this.dMa.setBackgroundColor(-1);
        this.dMa.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_b));
        this.dMa.createView();
        this.dOP.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.view.b.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (!b.this.dMa.isLoading() && b.this.dLw.aLC() && i + i2 > i3 - 2 && b.this.dLw.aLC()) {
                    b.this.dLw.aLE();
                }
            }
        });
        MessageManager.getInstance().registerListener(this.dEz);
        this.aqh = (CommonEmptyView) this.mRootView.findViewById(a.g.guard_club_join_empty_view);
    }

    /* renamed from: com.baidu.tieba.ala.guardclub.view.b$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    class AnonymousClass1 implements d.b {
        final /* synthetic */ BaseActivity dOS;

        AnonymousClass1(BaseActivity baseActivity) {
            this.dOS = baseActivity;
        }

        @Override // com.baidu.tieba.ala.guardclub.d.b
        public void a(g gVar, int i) {
            if (gVar != null && b.this.dLw != null) {
                if (b.this.dOR == null) {
                    b.this.dOR = new j(this.dOS.getPageContext());
                    b.this.dOR.a(new j.a() { // from class: com.baidu.tieba.ala.guardclub.view.b.1.1
                        @Override // com.baidu.tieba.ala.guardclub.j.a
                        public void c(final g gVar2, final int i2) {
                            LogManager.getGuardClubLogger().doClickLiveLeaveGuardLog();
                            if (b.this.dLw != null && gVar2 != null) {
                                b.this.dLw.a(gVar2.id, new h.b() { // from class: com.baidu.tieba.ala.guardclub.view.b.1.1.1
                                    @Override // com.baidu.tieba.ala.guardclub.model.h.b
                                    public void b(int i3, String str, Object obj) {
                                        b.this.dOQ.mH(i2);
                                        if (b.this.dOQ.getCount() <= 0) {
                                            b.this.aFS();
                                        }
                                        b.this.showToast(gVar2.dNg);
                                    }
                                });
                            }
                        }
                    });
                }
                b.this.dOR.b(gVar, i);
                LogManager.getGuardClubLogger().doDisplayLiveLeaveGuardLog();
            }
        }
    }

    public void completePullRefresh() {
        if (this.dOP != null) {
            this.dOP.completePullRefresh();
        }
    }

    public void aLp() {
        if (this.dMa != null) {
            this.dMa.endLoadData();
            this.dOP.setNextPage(null);
        }
    }

    public void hf(boolean z) {
        if (z) {
            if (this.dMa != null) {
                this.dOP.setNextPage(null);
            }
        } else if (this.dMa != null) {
            if (this.dMa.getView().getParent() == null) {
                this.dOP.setNextPage(this.dMa);
            }
            this.dMa.showNoMoreData();
        }
    }

    public void aJj() {
        if (this.dMa != null) {
            if (this.dMa.getView().getParent() == null) {
                this.dOP.setNextPage(this.dMa);
            }
            this.dMa.showLoadView();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.dOQ != null) {
            this.dOQ.notifyDataSetInvalidated();
        }
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFS() {
        aO(8, 0);
    }

    public void f(h hVar) {
        this.dLw = hVar;
        this.dLw.aLD();
    }

    public void bt(List<g> list) {
        if (this.dOQ != null && list != null && !list.isEmpty()) {
            aO(0, 8);
            this.dOQ.bt(list);
            return;
        }
        aFS();
    }

    private void aO(int i, int i2) {
        this.dOP.setVisibility(i);
        if (i2 == 0) {
            this.aqh.reset();
            this.aqh.setTitle(a.i.guard_join_list_empty);
            this.aqh.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            this.aqh.setVisibility(0);
            return;
        }
        this.aqh.setVisibility(8);
    }

    public void bu(List<g> list) {
        if (this.dOQ != null) {
            this.dOQ.bu(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showToast(String str) {
        Toast makeText = Toast.makeText(this.mContext.getPageActivity(), (CharSequence) null, 0);
        makeText.setGravity(17, 0, 0);
        makeText.setText(String.format(this.mContext.getResources().getString(a.i.guard_club_exit_success_toast), str));
        makeText.show();
    }

    public void aLn() {
        if (this.dOQ != null) {
            this.dOQ.aLn();
        }
        MessageManager.getInstance().unRegisterListener(this.dEz);
    }

    public void aLr() {
        this.aqh.reset();
        this.aqh.setTitle(a.i.sdk_net_fail_tip_rank);
        this.aqh.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.view.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.aqh.setVisibility(8);
                if (b.this.dLw != null) {
                    b.this.dLw.aLD();
                }
            }
        });
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.aqh.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        } else {
            this.aqh.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        }
        this.aqh.setVisibility(0);
        this.dOP.setVisibility(8);
    }
}
