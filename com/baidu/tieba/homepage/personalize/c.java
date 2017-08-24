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
    private BdTypeListView aTP;
    private PbListView beu;
    private com.baidu.tbadk.k.f bfZ;
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
    private final CustomMessageListener ckM;
    private CustomMessageListener ckP;
    private boolean ckr;
    private View clr;
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
        if (this.aTP != null) {
            this.aTP.completePullRefresh();
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
        if (this.ckM != null) {
            this.ckM.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.ckM);
        }
    }

    public c(Context context) {
        super(context);
        this.cUR = false;
        this.cUT = 0L;
        this.ckr = false;
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
                boolean aos = c.this.aos();
                c.this.Nq();
                if (aos) {
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
                    c.this.aTP.setVisibility(8);
                    c.this.showNetRefreshView(c.this, str, true);
                } else if (i.hr()) {
                    c.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                c.this.aTP.setVisibility(0);
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
        this.ckM = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.c.2
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
                                c.this.anQ();
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
        this.ckP = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        c.this.ckr = true;
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.aTP = new BdTypeListView(context);
        this.aTP.setDividerHeight(0);
        this.aTP.setSelector(17170445);
        this.beu = new PbListView(context);
        this.beu.lj();
        this.beu.m10do(d.e.cp_bg_line_c);
        this.beu.setTextColor(ai.getColor(d.e.cp_cont_d));
        this.beu.dp(TbadkCoreApplication.getInst().getSkinType());
        this.beu.setOnClickListener(this.cRT);
        this.aTP.setNextPage(this.beu);
        com.baidu.adp.base.e<?> aa = com.baidu.adp.base.i.aa(context);
        if (aa instanceof TbPageContext) {
            this.pageContext = (TbPageContext) aa;
        }
        this.mPullView = new l(this.pageContext);
        this.aTP.setPullRefresh(this.mPullView);
        this.mPullView.V(true);
        this.clr = BdListViewHelper.a(context, this.aTP, BdListViewHelper.HeadType.DEFAULT);
        this.cUP = new com.baidu.tieba.homepage.personalize.model.e();
        this.cUM = new o(context, this.aTP);
        this.cUM.b(this.cUP);
        this.cUO = new e(this.pageContext, this.aTP, this.cUM);
        addView(this.aTP);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        MessageManager.getInstance().registerListener(this.ckP);
    }

    public void aop() {
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
                    if (c.this.cUO.afQ() != null) {
                        c.this.cUO.afQ().aqz();
                    }
                    c.this.cUO.fK(false);
                }
            }
        });
        this.aTP.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.personalize.c.8
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                c.this.MS();
            }
        });
        this.aTP.setOnScrollStopDelayedListener(new BdListView.d() { // from class: com.baidu.tieba.homepage.personalize.c.9
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
                    c.this.cUO.aoX();
                }
                if (c.this.cUN != null && c.this.cUR) {
                    c.this.cUN.k(c.this.cUh, c.this.cUS);
                }
                c.this.cUR = false;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
            }
        });
        this.aTP.setRecyclerListener(new AbsListView.RecyclerListener() { // from class: com.baidu.tieba.homepage.personalize.c.11
            @Override // android.widget.AbsListView.RecyclerListener
            public void onMovedToScrapHeap(View view) {
                if (view != null) {
                    if (c.this.cUO != null && c.this.cUO.afQ() != null) {
                        c.this.cUO.afQ().aR(view);
                    }
                    if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.b.d) {
                        ((com.baidu.tieba.homepage.personalize.b.d) view.getTag()).Xv().stopPlay();
                    }
                }
            }
        });
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.cUN = bVar;
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        if (this.beu != null) {
            this.beu.wY();
            this.beu.dq(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.cUO.a(z, z2, dataRes, 0, null);
    }

    public void setHeaderViewHeight(int i) {
        if (this.clr != null && this.clr.getLayoutParams() != null) {
            if (this.cUO != null) {
                this.cUO.setHeaderViewHeight(i);
            }
            this.clr.getLayoutParams().height = i;
            this.clr.setLayoutParams(this.clr.getLayoutParams());
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
        if (this.bfZ != null) {
            this.bfZ.onChangeSkinType();
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
        if (this.mPullView != null) {
            this.mPullView.dp(i);
        }
        if (this.beu != null) {
            this.beu.setTextColor(ai.getColor(d.e.cp_cont_d));
            this.beu.dp(i);
        }
        this.cUM.onChangeSkinType(i);
        ai.k(this, d.e.cp_bg_line_d);
    }

    public long getTagCode() {
        return 0L;
    }

    public void N(String str, int i) {
        if (this.beu != null) {
            this.beu.wY();
            this.beu.dq(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
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
        this.refreshView.gz(str);
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
        if (this.bfZ != null) {
            this.bfZ.I(this);
            this.bfZ = null;
            this.aTP.setNextPage(this.beu);
        }
        if (this.cUN != null) {
            this.cUN.aoF();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aos() {
        if (this.refreshView != null) {
            return this.refreshView.EK();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, int i) {
        if (this.bfZ == null) {
            if (i < 0) {
                this.bfZ = new com.baidu.tbadk.k.f(getContext());
            } else {
                this.bfZ = new com.baidu.tbadk.k.f(getContext(), i);
            }
            this.bfZ.onChangeSkinType();
        }
        this.bfZ.c(this, z);
        this.aTP.setNextPage(null);
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.cUO != null) {
            this.cUO.setTabInForeBackgroundState(z);
        }
    }

    public void aot() {
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

    public void aoo() {
        if (this.cUO != null) {
            g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds520));
            this.cUO.update();
        }
    }

    public void reload() {
        if (this.aTP != null) {
            showFloatingView();
            this.aTP.setSelection(0);
            if (this.aTP.isRefreshDone()) {
                if (this.cUO != null && this.cUO.afQ() != null) {
                    this.cUO.afQ().aqz();
                    this.cUO.fK(false);
                }
                this.aTP.startPullRefresh();
            }
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.ckP);
        this.cUO.onDestroy();
        this.cUM.a((h.a) null);
        this.cUO.a((e.a) null);
        this.mPullView.a((k.b) null);
        this.mPullView.a((k.c) null);
        this.aTP.setOnSrollToBottomListener(null);
        this.mPullView.a((k.a) null);
        this.mPullView.release();
        this.aTP.setRecyclerListener(null);
    }

    public void onPause() {
        this.cUO.onPause();
    }

    public void onResume() {
        this.cUO.onResume();
        if (this.ckr) {
            reload();
            this.ckr = false;
        }
    }

    public void anQ() {
        if (this.cUM != null) {
            this.cUM.notifyDataSetChanged();
        }
    }

    public void aou() {
        if (this.cUO != null) {
            this.cUO.eL(true);
        }
        u.WU().cA(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void aoS() {
        this.cUO.ape();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MS() {
        if (this.beu != null && !this.beu.xc()) {
            this.beu.wX();
            this.beu.dq(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.cUO.MS();
    }
}
