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
    private BdTypeListView aSB;
    private PbListView bdh;
    private com.baidu.tbadk.k.f beN;
    private View.OnClickListener cOB;
    private List<com.baidu.tieba.homepage.b.a.a> cQP;
    private boolean cRA;
    private long cRB;
    private h.a cRC;
    private e.a cRD;
    private o cRu;
    private com.baidu.tieba.homepage.framework.b cRv;
    private e cRw;
    private com.baidu.tieba.homepage.personalize.model.e cRx;
    private ScrollFragmentTabHost cRy;
    private boolean cRz;
    private final CustomMessageListener ciS;
    private CustomMessageListener ciV;
    private boolean cix;
    private View cjx;
    private l mPullView;
    private TbPageContext<?> pageContext;
    private g refreshView;

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.cRw != null) {
            this.cRy = scrollFragmentTabHost;
            this.cRw.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void completePullRefresh() {
        if (this.aSB != null) {
            this.aSB.completePullRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cRu != null) {
            this.cRu.setPageUniqueId(bdUniqueId);
        }
        if (this.cRw != null) {
            this.cRw.j(bdUniqueId);
        }
        if (this.cRx != null) {
            this.cRx.m(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.ciS != null) {
            this.ciS.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.ciS);
        }
    }

    public c(Context context) {
        super(context);
        this.cRz = false;
        this.cRB = 0L;
        this.cix = false;
        this.cRC = new h.a() { // from class: com.baidu.tieba.homepage.personalize.c.1
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
        this.cRD = new e.a() { // from class: com.baidu.tieba.homepage.personalize.c.5
            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void aw(int i, int i2) {
                if (c.this.cRv == null) {
                    c.this.showNetRefreshView(c.this, TbadkCoreApplication.getInst().getString(d.l.neterror), true);
                    c.this.Ni();
                    return;
                }
                boolean anF = c.this.anF();
                c.this.Nl();
                if (anF) {
                    c.this.g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds520));
                }
                c.this.cRv.av(i, i2);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void v(int i, int i2, int i3) {
                if (c.this.cRv != null) {
                    c.this.cRv.u(i, i2, i3);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                c.this.Ni();
                if (i != 1) {
                    c.this.aSB.setVisibility(8);
                    c.this.showNetRefreshView(c.this, str, true);
                } else if (i.hh()) {
                    c.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                c.this.aSB.setVisibility(0);
                c.this.Ni();
                c.this.Nl();
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void k(List<com.baidu.tieba.homepage.b.a.a> list, boolean z) {
                if (c.this.cRv != null && !c.this.cRz) {
                    c.this.cRv.j(list, z);
                }
                c.this.cQP = list;
                c.this.cRA = z;
            }
        };
        this.ciS = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.c.2
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
                                c.this.and();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.cOB = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.MN();
            }
        };
        this.ciV = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        c.this.cix = true;
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.aSB = new BdTypeListView(context);
        this.aSB.setDividerHeight(0);
        this.aSB.setSelector(17170445);
        this.bdh = new PbListView(context);
        this.bdh.la();
        this.bdh.dm(d.e.cp_bg_line_c);
        this.bdh.setTextColor(ai.getColor(d.e.cp_cont_d));
        this.bdh.dn(TbadkCoreApplication.getInst().getSkinType());
        this.bdh.setOnClickListener(this.cOB);
        this.aSB.setNextPage(this.bdh);
        com.baidu.adp.base.e<?> Z = com.baidu.adp.base.i.Z(context);
        if (Z instanceof TbPageContext) {
            this.pageContext = (TbPageContext) Z;
        }
        this.mPullView = new l(this.pageContext);
        this.aSB.setPullRefresh(this.mPullView);
        this.mPullView.V(true);
        this.cjx = BdListViewHelper.a(context, this.aSB, BdListViewHelper.HeadType.DEFAULT);
        this.cRx = new com.baidu.tieba.homepage.personalize.model.e();
        this.cRu = new o(context, this.aSB);
        this.cRu.b(this.cRx);
        this.cRw = new e(this.pageContext, this.aSB, this.cRu);
        addView(this.aSB);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        MessageManager.getInstance().registerListener(this.ciV);
    }

    public void anC() {
        this.cRu.a(this.cRC);
        this.cRw.a(this.cRD);
        this.mPullView.a(new k.b() { // from class: com.baidu.tieba.homepage.personalize.c.6
            @Override // com.baidu.tbadk.core.view.k.b
            public void onListPullRefresh(boolean z) {
                c.this.cRz = true;
                c.this.cRw.update();
            }
        });
        this.mPullView.a(new k.c() { // from class: com.baidu.tieba.homepage.personalize.c.7
            @Override // com.baidu.tbadk.core.view.k.c
            public void aN(boolean z) {
                if (c.this.cRw != null) {
                    if (c.this.cRw.afu() != null) {
                        c.this.cRw.afu().apM();
                    }
                    c.this.cRw.fH(false);
                }
            }
        });
        this.aSB.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.personalize.c.8
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                c.this.MN();
            }
        });
        this.aSB.setOnScrollStopDelayedListener(new BdListView.d() { // from class: com.baidu.tieba.homepage.personalize.c.9
            @Override // com.baidu.adp.widget.ListView.BdListView.d
            public void onScrollStop(int i, int i2) {
                if (System.currentTimeMillis() - c.this.cRB >= TbConfig.NOTIFY_SOUND_INTERVAL) {
                    c.this.cRw.ax(i, i2);
                }
            }
        }, 1L);
        this.mPullView.a(new k.a() { // from class: com.baidu.tieba.homepage.personalize.c.10
            @Override // com.baidu.tbadk.core.view.k.a
            public void b(View view, boolean z) {
                if (c.this.cRw != null) {
                    c.this.cRw.fH(true);
                    c.this.cRw.aok();
                }
                if (c.this.cRv != null && c.this.cRz) {
                    c.this.cRv.j(c.this.cQP, c.this.cRA);
                }
                c.this.cRz = false;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
            }
        });
        this.aSB.setRecyclerListener(new AbsListView.RecyclerListener() { // from class: com.baidu.tieba.homepage.personalize.c.11
            @Override // android.widget.AbsListView.RecyclerListener
            public void onMovedToScrapHeap(View view) {
                if (view != null) {
                    if (c.this.cRw != null && c.this.cRw.afu() != null) {
                        c.this.cRw.afu().aQ(view);
                    }
                    if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.b.d) {
                        ((com.baidu.tieba.homepage.personalize.b.d) view.getTag()).WX().stopPlay();
                    }
                }
            }
        });
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.cRv = bVar;
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        if (this.bdh != null) {
            this.bdh.wO();
            this.bdh.m10do(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.cRw.a(z, z2, dataRes, 0, null);
    }

    public void setHeaderViewHeight(int i) {
        if (this.cjx != null && this.cjx.getLayoutParams() != null) {
            if (this.cRw != null) {
                this.cRw.setHeaderViewHeight(i);
            }
            this.cjx.getLayoutParams().height = i;
            this.cjx.setLayoutParams(this.cjx.getLayoutParams());
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(r rVar) {
        if (this.cRw != null) {
            this.cRw.setRecommendFrsNavigationAnimDispatcher(rVar);
        }
    }

    public void showFloatingView() {
        if (this.cRw != null) {
            this.cRw.showFloatingView();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.beN != null) {
            this.beN.onChangeSkinType();
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
        if (this.mPullView != null) {
            this.mPullView.dn(i);
        }
        if (this.bdh != null) {
            this.bdh.setTextColor(ai.getColor(d.e.cp_cont_d));
            this.bdh.dn(i);
        }
        this.cRu.onChangeSkinType(i);
        ai.k(this, d.e.cp_bg_line_d);
    }

    public long getTagCode() {
        return 0L;
    }

    public void N(String str, int i) {
        if (this.bdh != null) {
            this.bdh.wO();
            this.bdh.m10do(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.cRw.a(true, false, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.c.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.cRw != null) {
                        c.this.cRw.update();
                    }
                }
            });
        }
        this.refreshView.eX(getContext().getResources().getDimensionPixelSize(d.f.ds280));
        this.refreshView.gq(str);
        this.refreshView.c(view, z);
        this.refreshView.EL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nl() {
        if (this.refreshView != null) {
            this.refreshView.I(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ni() {
        if (this.beN != null) {
            this.beN.I(this);
            this.beN = null;
            this.aSB.setNextPage(this.bdh);
        }
        if (this.cRv != null) {
            this.cRv.anS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean anF() {
        if (this.refreshView != null) {
            return this.refreshView.EC();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, int i) {
        if (this.beN == null) {
            if (i < 0) {
                this.beN = new com.baidu.tbadk.k.f(getContext());
            } else {
                this.beN = new com.baidu.tbadk.k.f(getContext(), i);
            }
            this.beN.onChangeSkinType();
        }
        this.beN.c(this, z);
        this.aSB.setNextPage(null);
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.cRw != null) {
            this.cRw.setTabInForeBackgroundState(z);
        }
    }

    public void anG() {
        setViewForeground(false);
        if (this.cRw != null) {
            this.cRw.eJ(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("show_is_uninterest_tag", 0);
        if (i < 1 && TbadkCoreApplication.getInst().isNoInterestTag() && this.pageContext != null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("show_is_uninterest_tag", i + 1);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(this.pageContext.getContext(), 2)));
        }
    }

    public void setViewForeground(boolean z) {
        if (this.cRw != null) {
            this.cRw.fC(z);
        }
    }

    public void anB() {
        if (this.cRw != null) {
            g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds520));
            this.cRw.update();
        }
    }

    public void reload() {
        if (this.aSB != null) {
            showFloatingView();
            this.aSB.setSelection(0);
            if (this.aSB.isRefreshDone()) {
                if (this.cRw != null && this.cRw.afu() != null) {
                    this.cRw.afu().apM();
                    this.cRw.fH(false);
                }
                this.aSB.startPullRefresh();
            }
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.ciV);
        this.cRw.onDestroy();
        this.cRu.a((h.a) null);
        this.cRw.a((e.a) null);
        this.mPullView.a((k.b) null);
        this.mPullView.a((k.c) null);
        this.aSB.setOnSrollToBottomListener(null);
        this.mPullView.a((k.a) null);
        this.mPullView.release();
        this.aSB.setRecyclerListener(null);
    }

    public void onPause() {
        this.cRw.onPause();
    }

    public void onResume() {
        this.cRw.onResume();
        if (this.cix) {
            reload();
            this.cix = false;
        }
    }

    public void and() {
        if (this.cRu != null) {
            this.cRu.notifyDataSetChanged();
        }
    }

    public void anH() {
        if (this.cRw != null) {
            this.cRw.eJ(true);
        }
        u.Ww().cA(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void aof() {
        this.cRw.aor();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MN() {
        if (this.bdh != null && !this.bdh.wT()) {
            this.bdh.wN();
            this.bdh.m10do(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.cRw.MN();
    }
}
