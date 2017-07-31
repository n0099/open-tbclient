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
    private BdTypeListView aTN;
    private PbListView ber;
    private com.baidu.tbadk.k.f bfY;
    private View.OnClickListener cPU;
    private o cSN;
    private com.baidu.tieba.homepage.framework.b cSO;
    private e cSP;
    private com.baidu.tieba.homepage.personalize.model.e cSQ;
    private ScrollFragmentTabHost cSR;
    private boolean cSS;
    private boolean cST;
    private long cSU;
    private h.a cSV;
    private e.a cSW;
    private List<com.baidu.tieba.homepage.b.a.a> cSi;
    private boolean cjD;
    private final CustomMessageListener cjY;
    private View ckF;
    private CustomMessageListener ckb;
    private l mPullView;
    private TbPageContext<?> pageContext;
    private g refreshView;

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.cSP != null) {
            this.cSR = scrollFragmentTabHost;
            this.cSP.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void completePullRefresh() {
        if (this.aTN != null) {
            this.aTN.completePullRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cSN != null) {
            this.cSN.setPageUniqueId(bdUniqueId);
        }
        if (this.cSP != null) {
            this.cSP.j(bdUniqueId);
        }
        if (this.cSQ != null) {
            this.cSQ.m(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.cjY != null) {
            this.cjY.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cjY);
        }
    }

    public c(Context context) {
        super(context);
        this.cSS = false;
        this.cSU = 0L;
        this.cjD = false;
        this.cSV = new h.a() { // from class: com.baidu.tieba.homepage.personalize.c.1
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
        this.cSW = new e.a() { // from class: com.baidu.tieba.homepage.personalize.c.5
            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void ax(int i, int i2) {
                if (c.this.cSO == null) {
                    c.this.showNetRefreshView(c.this, TbadkCoreApplication.getInst().getString(d.l.neterror), true);
                    c.this.Nn();
                    return;
                }
                boolean anR = c.this.anR();
                c.this.Nq();
                if (anR) {
                    c.this.g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds520));
                }
                c.this.cSO.aw(i, i2);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void v(int i, int i2, int i3) {
                if (c.this.cSO != null) {
                    c.this.cSO.u(i, i2, i3);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                c.this.Nn();
                if (i != 1) {
                    c.this.aTN.setVisibility(8);
                    c.this.showNetRefreshView(c.this, str, true);
                } else if (i.hr()) {
                    c.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                c.this.aTN.setVisibility(0);
                c.this.Nn();
                c.this.Nq();
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void k(List<com.baidu.tieba.homepage.b.a.a> list, boolean z) {
                if (c.this.cSO != null && !c.this.cSS) {
                    c.this.cSO.j(list, z);
                }
                c.this.cSi = list;
                c.this.cST = z;
            }
        };
        this.cjY = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.c.2
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
                                c.this.anq();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.cPU = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.MS();
            }
        };
        this.ckb = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        c.this.cjD = true;
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.aTN = new BdTypeListView(context);
        this.aTN.setDividerHeight(0);
        this.aTN.setSelector(17170445);
        this.ber = new PbListView(context);
        this.ber.lk();
        this.ber.m10do(d.e.cp_bg_line_c);
        this.ber.setTextColor(ai.getColor(d.e.cp_cont_d));
        this.ber.dp(TbadkCoreApplication.getInst().getSkinType());
        this.ber.setOnClickListener(this.cPU);
        this.aTN.setNextPage(this.ber);
        com.baidu.adp.base.e<?> aa = com.baidu.adp.base.i.aa(context);
        if (aa instanceof TbPageContext) {
            this.pageContext = (TbPageContext) aa;
        }
        this.mPullView = new l(this.pageContext);
        this.aTN.setPullRefresh(this.mPullView);
        this.mPullView.V(true);
        this.ckF = BdListViewHelper.a(context, this.aTN, BdListViewHelper.HeadType.DEFAULT);
        this.cSQ = new com.baidu.tieba.homepage.personalize.model.e();
        this.cSN = new o(context, this.aTN);
        this.cSN.b(this.cSQ);
        this.cSP = new e(this.pageContext, this.aTN, this.cSN);
        addView(this.aTN);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        MessageManager.getInstance().registerListener(this.ckb);
    }

    public void anP() {
        this.cSN.a(this.cSV);
        this.cSP.a(this.cSW);
        this.mPullView.a(new k.b() { // from class: com.baidu.tieba.homepage.personalize.c.6
            @Override // com.baidu.tbadk.core.view.k.b
            public void onListPullRefresh(boolean z) {
                c.this.cSS = true;
                c.this.cSP.update();
            }
        });
        this.mPullView.a(new k.c() { // from class: com.baidu.tieba.homepage.personalize.c.7
            @Override // com.baidu.tbadk.core.view.k.c
            public void aN(boolean z) {
                if (c.this.cSP != null) {
                    if (c.this.cSP.afz() != null) {
                        c.this.cSP.afz().apY();
                    }
                    c.this.cSP.fH(false);
                }
            }
        });
        this.aTN.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.personalize.c.8
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                c.this.MS();
            }
        });
        this.aTN.setOnScrollStopDelayedListener(new BdListView.d() { // from class: com.baidu.tieba.homepage.personalize.c.9
            @Override // com.baidu.adp.widget.ListView.BdListView.d
            public void onScrollStop(int i, int i2) {
                if (System.currentTimeMillis() - c.this.cSU >= TbConfig.NOTIFY_SOUND_INTERVAL) {
                    c.this.cSP.ay(i, i2);
                }
            }
        }, 1L);
        this.mPullView.a(new k.a() { // from class: com.baidu.tieba.homepage.personalize.c.10
            @Override // com.baidu.tbadk.core.view.k.a
            public void b(View view, boolean z) {
                if (c.this.cSP != null) {
                    c.this.cSP.fH(true);
                    c.this.cSP.aow();
                }
                if (c.this.cSO != null && c.this.cSS) {
                    c.this.cSO.j(c.this.cSi, c.this.cST);
                }
                c.this.cSS = false;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
            }
        });
        this.aTN.setRecyclerListener(new AbsListView.RecyclerListener() { // from class: com.baidu.tieba.homepage.personalize.c.11
            @Override // android.widget.AbsListView.RecyclerListener
            public void onMovedToScrapHeap(View view) {
                if (view != null) {
                    if (c.this.cSP != null && c.this.cSP.afz() != null) {
                        c.this.cSP.afz().aQ(view);
                    }
                    if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.b.d) {
                        ((com.baidu.tieba.homepage.personalize.b.d) view.getTag()).Xc().stopPlay();
                    }
                }
            }
        });
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.cSO = bVar;
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        if (this.ber != null) {
            this.ber.wX();
            this.ber.dq(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.cSP.a(z, z2, dataRes, 0, null);
    }

    public void setHeaderViewHeight(int i) {
        if (this.ckF != null && this.ckF.getLayoutParams() != null) {
            if (this.cSP != null) {
                this.cSP.setHeaderViewHeight(i);
            }
            this.ckF.getLayoutParams().height = i;
            this.ckF.setLayoutParams(this.ckF.getLayoutParams());
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(r rVar) {
        if (this.cSP != null) {
            this.cSP.setRecommendFrsNavigationAnimDispatcher(rVar);
        }
    }

    public void showFloatingView() {
        if (this.cSP != null) {
            this.cSP.showFloatingView();
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
        if (this.ber != null) {
            this.ber.setTextColor(ai.getColor(d.e.cp_cont_d));
            this.ber.dp(i);
        }
        this.cSN.onChangeSkinType(i);
        ai.k(this, d.e.cp_bg_line_d);
    }

    public long getTagCode() {
        return 0L;
    }

    public void N(String str, int i) {
        if (this.ber != null) {
            this.ber.wX();
            this.ber.dq(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.cSP.a(true, false, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.c.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.cSP != null) {
                        c.this.cSP.update();
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
            this.aTN.setNextPage(this.ber);
        }
        if (this.cSO != null) {
            this.cSO.aoe();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean anR() {
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
        this.aTN.setNextPage(null);
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.cSP != null) {
            this.cSP.setTabInForeBackgroundState(z);
        }
    }

    public void anS() {
        setViewForeground(false);
        if (this.cSP != null) {
            this.cSP.eJ(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("show_is_uninterest_tag", 0);
        if (i < 1 && TbadkCoreApplication.getInst().isNoInterestTag() && this.pageContext != null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("show_is_uninterest_tag", i + 1);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(this.pageContext.getContext(), 2)));
        }
    }

    public void setViewForeground(boolean z) {
        if (this.cSP != null) {
            this.cSP.fC(z);
        }
    }

    public void anO() {
        if (this.cSP != null) {
            g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds520));
            this.cSP.update();
        }
    }

    public void reload() {
        if (this.aTN != null) {
            showFloatingView();
            this.aTN.setSelection(0);
            if (this.aTN.isRefreshDone()) {
                if (this.cSP != null && this.cSP.afz() != null) {
                    this.cSP.afz().apY();
                    this.cSP.fH(false);
                }
                this.aTN.startPullRefresh();
            }
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.ckb);
        this.cSP.onDestroy();
        this.cSN.a((h.a) null);
        this.cSP.a((e.a) null);
        this.mPullView.a((k.b) null);
        this.mPullView.a((k.c) null);
        this.aTN.setOnSrollToBottomListener(null);
        this.mPullView.a((k.a) null);
        this.mPullView.release();
        this.aTN.setRecyclerListener(null);
    }

    public void onPause() {
        this.cSP.onPause();
    }

    public void onResume() {
        this.cSP.onResume();
        if (this.cjD) {
            reload();
            this.cjD = false;
        }
    }

    public void anq() {
        if (this.cSN != null) {
            this.cSN.notifyDataSetChanged();
        }
    }

    public void anT() {
        if (this.cSP != null) {
            this.cSP.eJ(true);
        }
        u.WB().cA(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void aor() {
        this.cSP.aoD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MS() {
        if (this.ber != null && !this.ber.xc()) {
            this.ber.wW();
            this.ber.dq(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.cSP.MS();
    }
}
