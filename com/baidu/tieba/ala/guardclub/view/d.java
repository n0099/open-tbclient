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
    private CommonEmptyView aCY;
    private BaseActivity aGf;
    private LoadMoreFooter eFZ;
    private e eFv;
    private BdListView eIo;
    private f eIp;
    private l eIq;
    CustomMessageListener evY;
    private View mRootView;
    private String otherParams;

    public View getView() {
        return this.mRootView;
    }

    public d(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity.getPageContext());
        this.evY = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.view.d.3
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
        this.aGf = baseActivity;
        this.mRootView = LayoutInflater.from(this.aGf).inflate(a.h.layout_guard_club_join_list, (ViewGroup) null);
        this.eIo = (BdListView) this.mRootView.findViewById(a.g.list_guard_club_join);
        this.eIp = new f(baseActivity, bdUniqueId);
        this.eIp.a(new AnonymousClass1(baseActivity));
        this.eIo.setAdapter((ListAdapter) this.eIp);
        this.eFZ = new LoadMoreFooter(this.aGf);
        this.eFZ.setBackgroundColor(-1);
        this.eFZ.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_b));
        this.eFZ.createView();
        this.eIo.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.view.d.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (!d.this.eFZ.isLoading() && d.this.eFv.bfr() && i + i2 > i3 - 2 && d.this.eFv.bfr()) {
                    d.this.eFv.bft();
                }
            }
        });
        MessageManager.getInstance().registerListener(this.evY);
        this.aCY = (CommonEmptyView) this.mRootView.findViewById(a.g.guard_club_join_empty_view);
    }

    /* renamed from: com.baidu.tieba.ala.guardclub.view.d$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass1 implements f.b {
        final /* synthetic */ BaseActivity eIr;

        AnonymousClass1(BaseActivity baseActivity) {
            this.eIr = baseActivity;
        }

        @Override // com.baidu.tieba.ala.guardclub.f.b
        public void a(com.baidu.tieba.ala.guardclub.model.d dVar, int i) {
            if (dVar != null && d.this.eFv != null) {
                if (d.this.eIq == null) {
                    d.this.eIq = new l(this.eIr.getPageContext());
                    d.this.eIq.a(new l.a() { // from class: com.baidu.tieba.ala.guardclub.view.d.1.1
                        @Override // com.baidu.tieba.ala.guardclub.l.a
                        public void c(final com.baidu.tieba.ala.guardclub.model.d dVar2, final int i2) {
                            LogManager.getGuardClubLogger().doClickLiveLeaveGuardLog();
                            if (d.this.eFv != null && dVar2 != null) {
                                d.this.eFv.a(dVar2.id, new e.b() { // from class: com.baidu.tieba.ala.guardclub.view.d.1.1.1
                                    @Override // com.baidu.tieba.ala.guardclub.model.e.b
                                    public void b(int i3, String str, Object obj) {
                                        d.this.eIp.pp(i2);
                                        if (d.this.eIp.getCount() <= 0) {
                                            d.this.aiu();
                                        }
                                        d.this.showToast(dVar2.apM);
                                    }
                                });
                            }
                        }
                    });
                }
                d.this.eIq.b(dVar, i);
                LogManager.getGuardClubLogger().doDisplayLiveLeaveGuardLog();
            }
        }
    }

    public void completePullRefresh() {
        if (this.eIo != null) {
            this.eIo.completePullRefresh();
        }
    }

    public void bfm() {
        if (this.eFZ != null) {
            this.eFZ.endLoadData();
            this.eIo.setNextPage(null);
        }
    }

    public void iD(boolean z) {
        if (z) {
            if (this.eFZ != null) {
                this.eIo.setNextPage(null);
            }
        } else if (this.eFZ != null) {
            if (this.eFZ.getView().getParent() == null) {
                this.eIo.setNextPage(this.eFZ);
            }
            this.eFZ.showNoMoreData();
        }
    }

    public void bcv() {
        if (this.eFZ != null) {
            if (this.eFZ.getView().getParent() == null) {
                this.eIo.setNextPage(this.eFZ);
            }
            this.eFZ.showLoadView();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.eIp != null) {
            this.eIp.notifyDataSetInvalidated();
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
        this.eFv = eVar;
        this.eFv.bfs();
    }

    public void bs(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (this.eIp != null && list != null && !list.isEmpty()) {
            bi(0, 8);
            this.eIp.bs(list);
            return;
        }
        aiu();
    }

    private void bi(int i, int i2) {
        this.eIo.setVisibility(i);
        if (i2 == 0) {
            this.aCY.reset();
            this.aCY.setTitle(a.i.guard_join_list_empty);
            this.aCY.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.LIGHT);
            this.aCY.setVisibility(0);
            return;
        }
        this.aCY.setVisibility(8);
    }

    public void bt(List<com.baidu.tieba.ala.guardclub.model.d> list) {
        if (this.eIp != null) {
            this.eIp.bt(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showToast(String str) {
        Toast makeText = Toast.makeText(this.mContext.getPageActivity(), (CharSequence) null, 0);
        makeText.setGravity(17, 0, 0);
        makeText.setText(String.format(this.mContext.getResources().getString(a.i.guard_club_exit_success_toast), str));
        makeText.show();
    }

    public void bfk() {
        if (this.eIp != null) {
            this.eIp.bfk();
        }
        MessageManager.getInstance().unRegisterListener(this.evY);
    }

    public void bbC() {
        this.aCY.reset();
        this.aCY.setTitle(a.i.sdk_net_fail_tip_rank);
        this.aCY.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.view.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.aCY.setVisibility(8);
                if (d.this.eFv != null) {
                    d.this.eFv.bfs();
                }
            }
        });
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.aCY.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
        } else {
            this.aCY.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
        }
        this.aCY.setVisibility(0);
        this.eIo.setVisibility(8);
    }
}
