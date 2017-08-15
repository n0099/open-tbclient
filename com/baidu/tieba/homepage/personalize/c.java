package com.baidu.tieba.homepage.personalize;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.AbsListView;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.i;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LabelRecommendActivityConfig;
import com.baidu.tbadk.core.data.an;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.view.k;
import com.baidu.tbadk.core.view.l;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.r;
import com.baidu.tieba.card.u;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.b.o;
import com.baidu.tieba.homepage.personalize.e;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class c extends FrameLayout {
    private BdTypeListView aTO;
    private PbListView bes;
    private com.baidu.tbadk.k.f bfY;
    private View.OnClickListener cRT;
    private o cUM;
    private com.baidu.tieba.homepage.framework.b cUN;
    private e cUO;
    private com.baidu.tieba.homepage.personalize.model.e cUP;
    private ScrollFragmentTabHost cUQ;
    private boolean cUR;
    private boolean cUS;
    private long cUT;
    private h.a cUU;
    private e.a cUV;
    private List<com.baidu.tieba.homepage.b.a.a> cUh;
    private final CustomMessageListener ckL;
    private CustomMessageListener ckO;
    private boolean ckq;
    private View clq;
    private l mPullView;
    private TbPageContext<?> pageContext;
    private g refreshView;

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.cUO != null) {
            this.cUQ = scrollFragmentTabHost;
            this.cUO.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void completePullRefresh() {
        if (this.aTO != null) {
            this.aTO.completePullRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cUM != null) {
            this.cUM.setPageUniqueId(bdUniqueId);
        }
        if (this.cUO != null) {
            this.cUO.j(bdUniqueId);
        }
        if (this.cUP != null) {
            this.cUP.m(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.ckL != null) {
            this.ckL.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.ckL);
        }
    }

    public c(Context context) {
        super(context);
        this.cUR = false;
        this.cUT = 0L;
        this.ckq = false;
        this.cUU = new h.a() { // from class: com.baidu.tieba.homepage.personalize.c.1
            @Override // com.baidu.tbadk.core.view.h.a
            public void a(an anVar) {
                if (anVar != null) {
                    TiebaStatic.log(new aj("c11693").aa("obj_locate", "1").aa("fid", anVar.getFid()).aa("tid", anVar.getTid()).aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
                    TiebaStatic.log(new aj("c11989").aa("fid", anVar.getFid()).aa("tid", anVar.getTid()).aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
                }
            }

            @Override // com.baidu.tbadk.core.view.h.a
            public void a(an anVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tbadk.core.view.h.a
            public void a(ArrayList<Integer> arrayList, an anVar) {
                if (arrayList != null && anVar != null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < arrayList.size(); i++) {
                        sb.append(arrayList.get(i) + Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    TiebaStatic.log(new aj("c11693").aa("obj_locate", sb.toString()).aa("fid", anVar.getFid()).aa("tid", anVar.getTid()).aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
                }
            }
        };
        this.cUV = new e.a() { // from class: com.baidu.tieba.homepage.personalize.c.5
            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void aF(int i, int i2) {
                if (c.this.cUN == null) {
                    c.this.showNetRefreshView(c.this, TbadkCoreApplication.getInst().getString(d.l.neterror), true);
                    c.this.Nn();
                    return;
                }
                boolean aoy = c.this.aoy();
                c.this.Nq();
                if (aoy) {
                    c.this.g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds520));
                }
                c.this.cUN.aE(i, i2);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void v(int i, int i2, int i3) {
                if (c.this.cUN != null) {
                    c.this.cUN.u(i, i2, i3);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                c.this.Nn();
                if (i != 1) {
                    c.this.aTO.setVisibility(8);
                    c.this.showNetRefreshView(c.this, str, true);
                } else if (i.hr()) {
                    c.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                c.this.aTO.setVisibility(0);
                c.this.Nn();
                c.this.Nq();
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void l(List<com.baidu.tieba.homepage.b.a.a> list, boolean z) {
                if (c.this.cUN != null && !c.this.cUR) {
                    c.this.cUN.k(list, z);
                }
                c.this.cUh = list;
                c.this.cUS = z;
            }
        };
        this.ckL = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.c.2
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
                        com.baidu.adp.lib.g.e.ga().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.c.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                c.this.anW();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.cRT = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.MS();
            }
        };
        this.ckO = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        c.this.ckq = true;
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.aTO = new BdTypeListView(context);
        this.aTO.setDividerHeight(0);
        this.aTO.setSelector(17170445);
        this.bes = new PbListView(context);
        this.bes.lk();
        this.bes.m10do(d.e.cp_bg_line_c);
        this.bes.setTextColor(ai.getColor(d.e.cp_cont_d));
        this.bes.dp(TbadkCoreApplication.getInst().getSkinType());
        this.bes.setOnClickListener(this.cRT);
        this.aTO.setNextPage(this.bes);
        com.baidu.adp.base.e<?> aa = com.baidu.adp.base.i.aa(context);
        if (aa instanceof TbPageContext) {
            this.pageContext = (TbPageContext) aa;
        }
        this.mPullView = new l(this.pageContext);
        this.aTO.setPullRefresh(this.mPullView);
        this.mPullView.V(true);
        this.clq = BdListViewHelper.a(context, this.aTO, BdListViewHelper.HeadType.DEFAULT);
        this.cUP = new com.baidu.tieba.homepage.personalize.model.e();
        this.cUM = new o(context, this.aTO);
        this.cUM.b(this.cUP);
        this.cUO = new e(this.pageContext, this.aTO, this.cUM);
        addView(this.aTO);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        MessageManager.getInstance().registerListener(this.ckO);
    }

    public void aov() {
        this.cUM.a(this.cUU);
        this.cUO.a(this.cUV);
        this.mPullView.a(new k.b() { // from class: com.baidu.tieba.homepage.personalize.c.6
            @Override // com.baidu.tbadk.core.view.k.b
            public void onListPullRefresh(boolean z) {
                c.this.cUR = true;
                c.this.cUO.update();
            }
        });
        this.mPullView.a(new k.c() { // from class: com.baidu.tieba.homepage.personalize.c.7
            @Override // com.baidu.tbadk.core.view.k.c
            public void aN(boolean z) {
                if (c.this.cUO != null) {
                    if (c.this.cUO.afW() != null) {
                        c.this.cUO.afW().aqF();
                    }
                    c.this.cUO.fK(false);
                }
            }
        });
        this.aTO.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.personalize.c.8
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                c.this.MS();
            }
        });
        this.aTO.setOnScrollStopDelayedListener(new BdListView.d() { // from class: com.baidu.tieba.homepage.personalize.c.9
            @Override // com.baidu.adp.widget.ListView.BdListView.d
            public void onScrollStop(int i, int i2) {
                if (System.currentTimeMillis() - c.this.cUT >= TbConfig.NOTIFY_SOUND_INTERVAL) {
                    c.this.cUO.aG(i, i2);
                }
            }
        }, 1L);
        this.mPullView.a(new k.a() { // from class: com.baidu.tieba.homepage.personalize.c.10
            @Override // com.baidu.tbadk.core.view.k.a
            public void b(View view, boolean z) {
                if (c.this.cUO != null) {
                    c.this.cUO.fK(true);
                    c.this.cUO.apd();
                }
                if (c.this.cUN != null && c.this.cUR) {
                    c.this.cUN.k(c.this.cUh, c.this.cUS);
                }
                c.this.cUR = false;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
            }
        });
        this.aTO.setRecyclerListener(new AbsListView.RecyclerListener() { // from class: com.baidu.tieba.homepage.personalize.c.11
            @Override // android.widget.AbsListView.RecyclerListener
            public void onMovedToScrapHeap(View view) {
                if (view != null) {
                    if (c.this.cUO != null && c.this.cUO.afW() != null) {
                        c.this.cUO.afW().aS(view);
                    }
                    if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.b.d) {
                        ((com.baidu.tieba.homepage.personalize.b.d) view.getTag()).Xy().stopPlay();
                    }
                }
            }
        });
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.cUN = bVar;
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        if (this.bes != null) {
            this.bes.wX();
            this.bes.dq(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.cUO.a(z, z2, dataRes, 0, null);
    }

    public void setHeaderViewHeight(int i) {
        if (this.clq != null && this.clq.getLayoutParams() != null) {
            if (this.cUO != null) {
                this.cUO.setHeaderViewHeight(i);
            }
            this.clq.getLayoutParams().height = i;
            this.clq.setLayoutParams(this.clq.getLayoutParams());
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(r rVar) {
        if (this.cUO != null) {
            this.cUO.setRecommendFrsNavigationAnimDispatcher(rVar);
        }
    }

    public void showFloatingView() {
        if (this.cUO != null) {
            this.cUO.showFloatingView();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bfY != null) {
            this.bfY.onChangeSkinType();
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
        if (this.mPullView != null) {
            this.mPullView.dp(i);
        }
        if (this.bes != null) {
            this.bes.setTextColor(ai.getColor(d.e.cp_cont_d));
            this.bes.dp(i);
        }
        this.cUM.onChangeSkinType(i);
        ai.k(this, d.e.cp_bg_line_d);
    }

    public long getTagCode() {
        return 0L;
    }

    public void N(String str, int i) {
        if (this.bes != null) {
            this.bes.wX();
            this.bes.dq(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.cUO.a(true, false, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.c.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.cUO != null) {
                        c.this.cUO.update();
                    }
                }
            });
        }
        this.refreshView.eZ(getContext().getResources().getDimensionPixelSize(d.f.ds280));
        this.refreshView.gv(str);
        this.refreshView.c(view, z);
        this.refreshView.ET();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nq() {
        if (this.refreshView != null) {
            this.refreshView.I(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nn() {
        if (this.bfY != null) {
            this.bfY.I(this);
            this.bfY = null;
            this.aTO.setNextPage(this.bes);
        }
        if (this.cUN != null) {
            this.cUN.aoL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aoy() {
        if (this.refreshView != null) {
            return this.refreshView.EK();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, int i) {
        if (this.bfY == null) {
            if (i < 0) {
                this.bfY = new com.baidu.tbadk.k.f(getContext());
            } else {
                this.bfY = new com.baidu.tbadk.k.f(getContext(), i);
            }
            this.bfY.onChangeSkinType();
        }
        this.bfY.c(this, z);
        this.aTO.setNextPage(null);
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.cUO != null) {
            this.cUO.setTabInForeBackgroundState(z);
        }
    }

    public void aoz() {
        setViewForeground(false);
        if (this.cUO != null) {
            this.cUO.eL(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("show_is_uninterest_tag", 0);
        if (i < 1 && TbadkCoreApplication.getInst().isNoInterestTag() && this.pageContext != null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("show_is_uninterest_tag", i + 1);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(this.pageContext.getContext(), 2)));
        }
    }

    public void setViewForeground(boolean z) {
        if (this.cUO != null) {
            this.cUO.fF(z);
        }
    }

    public void aou() {
        if (this.cUO != null) {
            g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds520));
            this.cUO.update();
        }
    }

    public void reload() {
        if (this.aTO != null) {
            showFloatingView();
            this.aTO.setSelection(0);
            if (this.aTO.isRefreshDone()) {
                if (this.cUO != null && this.cUO.afW() != null) {
                    this.cUO.afW().aqF();
                    this.cUO.fK(false);
                }
                this.aTO.startPullRefresh();
            }
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.ckO);
        this.cUO.onDestroy();
        this.cUM.a((h.a) null);
        this.cUO.a((e.a) null);
        this.mPullView.a((k.b) null);
        this.mPullView.a((k.c) null);
        this.aTO.setOnSrollToBottomListener(null);
        this.mPullView.a((k.a) null);
        this.mPullView.release();
        this.aTO.setRecyclerListener(null);
    }

    public void onPause() {
        this.cUO.onPause();
    }

    public void onResume() {
        this.cUO.onResume();
        if (this.ckq) {
            reload();
            this.ckq = false;
        }
    }

    public void anW() {
        if (this.cUM != null) {
            this.cUM.notifyDataSetChanged();
        }
    }

    public void aoA() {
        if (this.cUO != null) {
            this.cUO.eL(true);
        }
        u.WX().cA(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void aoY() {
        this.cUO.apk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MS() {
        if (this.bes != null && !this.bes.xc()) {
            this.bes.wW();
            this.bes.dq(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.cUO.MS();
    }
}
