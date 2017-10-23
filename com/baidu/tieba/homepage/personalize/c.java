package com.baidu.tieba.homepage.personalize;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.AbsListView;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.i;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LabelRecommendActivityConfig;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.j.g;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.q;
import com.baidu.tieba.NEGFeedBack.c;
import com.baidu.tieba.card.u;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.a.o;
import com.baidu.tieba.homepage.personalize.e;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class c extends FrameLayout {
    private BdTypeListView aUi;
    private PbListView bfN;
    private com.baidu.tbadk.j.f bhx;
    private View.OnClickListener cVq;
    private o cYp;
    private com.baidu.tieba.homepage.framework.b cYq;
    private e cYr;
    private com.baidu.tieba.homepage.personalize.model.e cYs;
    private long cYt;
    private c.a cYu;
    private e.a cYv;
    private boolean cqL;
    private View crN;
    private final CustomMessageListener cri;
    private CustomMessageListener crl;
    private h mPullView;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private g refreshView;

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.cYr != null) {
            this.cYr.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void completePullRefresh() {
        if (this.aUi != null) {
            this.aUi.completePullRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cYp != null) {
            this.cYp.setPageUniqueId(bdUniqueId);
        }
        if (this.cYr != null) {
            this.cYr.k(bdUniqueId);
        }
        if (this.cYs != null) {
            this.cYs.o(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.cri != null) {
            this.cri.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cri);
        }
    }

    public c(Context context) {
        super(context);
        this.cYt = 0L;
        this.mSkinType = 3;
        this.cqL = false;
        this.cYu = new c.a() { // from class: com.baidu.tieba.homepage.personalize.c.1
            @Override // com.baidu.tieba.NEGFeedBack.c.a
            public void a(al alVar) {
                if (alVar != null) {
                    TiebaStatic.log(new ak("c11693").ac("obj_locate", "1").ac("fid", alVar.getFid()).ac("tid", alVar.getTid()).ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
                    TiebaStatic.log(new ak("c11989").ac("fid", alVar.getFid()).ac("tid", alVar.getTid()).ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
                }
            }

            @Override // com.baidu.tieba.NEGFeedBack.c.a
            public void a(al alVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.c.a
            public void a(ArrayList<Integer> arrayList, al alVar) {
                if (arrayList != null && alVar != null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < arrayList.size(); i++) {
                        sb.append(arrayList.get(i) + Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    TiebaStatic.log(new ak("c11693").ac("obj_locate", sb.toString()).ac("fid", alVar.getFid()).ac("tid", alVar.getTid()).ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
                }
            }
        };
        this.cYv = new e.a() { // from class: com.baidu.tieba.homepage.personalize.c.5
            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void aO(int i, int i2) {
                if (c.this.cYq == null) {
                    c.this.showNetRefreshView(c.this, TbadkCoreApplication.getInst().getString(d.l.neterror), true);
                    c.this.NT();
                    return;
                }
                boolean aoJ = c.this.aoJ();
                c.this.NW();
                if (aoJ) {
                    c.this.h(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds520));
                }
                c.this.cYq.aN(i, i2);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void A(int i, int i2, int i3) {
                if (c.this.cYq != null) {
                    c.this.cYq.z(i, i2, i3);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                c.this.NT();
                if (i != 1) {
                    c.this.aUi.setVisibility(8);
                    c.this.showNetRefreshView(c.this, str, true);
                } else if (j.hh()) {
                    c.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                c.this.aUi.setVisibility(0);
                c.this.NT();
                c.this.NW();
            }
        };
        this.cri = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                List<DownloadData> data;
                if (customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
                    boolean z = false;
                    for (DownloadData downloadData : data) {
                        z = downloadData.getStatus() == 0 ? true : z;
                    }
                    if (z) {
                        com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.c.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                c.this.app();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.cVq = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.Ns();
            }
        };
        this.crl = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        c.this.cqL = true;
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.aUi = new BdTypeListView(context);
        this.aUi.setDividerHeight(0);
        this.aUi.setSelector(17170445);
        this.bfN = new PbListView(context);
        this.bfN.getView();
        this.bfN.dx(d.e.cp_bg_line_d);
        this.bfN.wj();
        this.bfN.setTextColor(aj.getColor(d.e.cp_cont_d));
        this.bfN.dw(d.e.cp_cont_e);
        this.bfN.setHeight(l.f(context, d.f.ds140));
        this.bfN.setOnClickListener(this.cVq);
        this.aUi.setNextPage(this.bfN);
        com.baidu.adp.base.e<?> Y = i.Y(context);
        if (Y instanceof TbPageContext) {
            this.pageContext = (TbPageContext) Y;
        }
        this.mPullView = new h(this.pageContext);
        this.aUi.setPullRefresh(this.mPullView);
        this.mPullView.X(true);
        this.crN = BdListViewHelper.a(context, this.aUi, BdListViewHelper.HeadType.DEFAULT);
        this.cYs = new com.baidu.tieba.homepage.personalize.model.e();
        this.cYp = new o(context, this.aUi);
        this.cYp.b(this.cYs);
        this.cYr = new e(this.pageContext, this.aUi, this.cYp);
        addView(this.aUi);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        MessageManager.getInstance().registerListener(this.crl);
    }

    public void aoH() {
        this.cYp.a(this.cYu);
        this.cYr.a(this.cYv);
        this.mPullView.a(new g.b() { // from class: com.baidu.tieba.homepage.personalize.c.6
            @Override // com.baidu.tbadk.core.view.g.b
            public void onListPullRefresh(boolean z) {
                c.this.cYr.update();
            }
        });
        this.mPullView.a(new g.c() { // from class: com.baidu.tieba.homepage.personalize.c.7
            @Override // com.baidu.tbadk.core.view.g.c
            public void aM(boolean z) {
                if (c.this.cYr != null) {
                    if (c.this.cYr.ahn() != null) {
                        c.this.cYr.ahn().aqY();
                    }
                    c.this.cYr.fE(false);
                }
            }
        });
        this.aUi.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.personalize.c.8
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                c.this.Ns();
            }
        });
        this.aUi.setOnScrollStopDelayedListener(new BdListView.d() { // from class: com.baidu.tieba.homepage.personalize.c.9
            @Override // com.baidu.adp.widget.ListView.BdListView.d
            public void onScrollStop(int i, int i2) {
                if (System.currentTimeMillis() - c.this.cYt >= TbConfig.NOTIFY_SOUND_INTERVAL) {
                    c.this.cYr.aP(i, i2);
                }
            }
        }, 1L);
        this.mPullView.a(new g.a() { // from class: com.baidu.tieba.homepage.personalize.c.10
            @Override // com.baidu.tbadk.core.view.g.a
            public void b(View view, boolean z) {
                if (c.this.cYr != null) {
                    c.this.cYr.fE(true);
                    c.this.cYr.apt();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
            }
        });
        this.aUi.setRecyclerListener(new AbsListView.RecyclerListener() { // from class: com.baidu.tieba.homepage.personalize.c.11
            @Override // android.widget.AbsListView.RecyclerListener
            public void onMovedToScrapHeap(View view) {
                if (view != null) {
                    if (c.this.cYr != null && c.this.cYr.ahn() != null) {
                        c.this.cYr.ahn().aU(view);
                    }
                    if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.d) {
                        ((com.baidu.tieba.homepage.personalize.a.d) view.getTag()).Yn().stopPlay();
                    }
                }
            }
        });
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.cYq = bVar;
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        if (this.bfN != null) {
            this.bfN.wn();
            this.bfN.dz(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.cYr.a(z, z2, dataRes, 0, null);
    }

    public void setHeaderViewHeight(int i) {
        if (this.crN != null && this.crN.getLayoutParams() != null) {
            if (this.cYr != null) {
                this.cYr.setHeaderViewHeight(i);
            }
            this.crN.getLayoutParams().height = i;
            this.crN.setLayoutParams(this.crN.getLayoutParams());
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(q qVar) {
        if (this.cYr != null) {
            this.cYr.setRecommendFrsNavigationAnimDispatcher(qVar);
        }
    }

    public void showFloatingView() {
        if (this.cYr != null) {
            this.cYr.showFloatingView();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.bhx != null) {
                this.bhx.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.mPullView != null) {
                this.mPullView.dy(i);
            }
            if (this.bfN != null) {
                this.bfN.setTextColor(aj.getColor(d.e.cp_cont_d));
                this.bfN.dy(i);
            }
            this.cYp.onChangeSkinType(i);
            aj.k(this, d.e.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void N(String str, int i) {
        if (this.bfN != null) {
            this.bfN.wn();
            this.bfN.dz(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.cYr.a(true, false, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.j.g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.c.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.cYr != null) {
                        c.this.cYr.update();
                    }
                }
            });
        }
        this.refreshView.fj(getContext().getResources().getDimensionPixelSize(d.f.ds280));
        this.refreshView.gq(str);
        this.refreshView.c(view, z);
        this.refreshView.Eq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NW() {
        if (this.refreshView != null) {
            this.refreshView.O(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NT() {
        if (this.bhx != null) {
            this.bhx.O(this);
            this.bhx = null;
            this.aUi.setNextPage(this.bfN);
        }
        if (this.cYq != null) {
            this.cYq.aoZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aoJ() {
        if (this.refreshView != null) {
            return this.refreshView.Eh();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(boolean z, int i) {
        if (this.bhx == null) {
            if (i < 0) {
                this.bhx = new com.baidu.tbadk.j.f(getContext());
            } else {
                this.bhx = new com.baidu.tbadk.j.f(getContext(), i);
            }
            this.bhx.onChangeSkinType();
        }
        this.bhx.c(this, z);
        this.aUi.setNextPage(null);
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.cYr != null) {
            this.cYr.setTabInForeBackgroundState(z);
        }
    }

    public void aoL() {
        setViewForeground(false);
        if (this.cYr != null) {
            this.cYr.eE(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("show_is_uninterest_tag", 0);
        if (i < 1 && TbadkCoreApplication.getInst().isNoInterestTag() && this.pageContext != null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("show_is_uninterest_tag", i + 1);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(this.pageContext.getContext(), 2)));
        }
    }

    public void setViewForeground(boolean z) {
        if (this.cYr != null) {
            this.cYr.fz(z);
        }
    }

    public void aoG() {
        if (this.cYr != null) {
            h(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds520));
            this.cYr.update();
        }
    }

    public void reload() {
        if (this.aUi != null) {
            showFloatingView();
            this.aUi.setSelection(0);
            if (this.aUi.isRefreshDone()) {
                if (this.cYr != null && this.cYr.ahn() != null) {
                    this.cYr.ahn().aqY();
                    this.cYr.fE(false);
                }
                this.aUi.startPullRefresh();
            }
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.crl);
        this.cYr.onDestroy();
        this.cYp.a((c.a) null);
        this.cYr.a((e.a) null);
        this.mPullView.a((g.b) null);
        this.mPullView.a((g.c) null);
        this.aUi.setOnSrollToBottomListener(null);
        this.mPullView.a((g.a) null);
        this.mPullView.release();
        if (this.bhx != null) {
            this.bhx.release();
        }
        this.aUi.setRecyclerListener(null);
    }

    public void onPause() {
        this.cYr.onPause();
    }

    public void onResume() {
        this.cYr.onResume();
        if (this.cqL) {
            reload();
            this.cqL = false;
        }
    }

    public void app() {
        if (this.cYp != null) {
            this.cYp.notifyDataSetChanged();
        }
    }

    public void aoM() {
        if (this.cYr != null) {
            this.cYr.eE(true);
        }
        u.XN().cA(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void apn() {
        this.cYr.apA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ns() {
        if (this.bfN != null && !this.bfN.ws()) {
            this.bfN.wm();
            this.bfN.dz(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.cYr.Ns();
    }
}
