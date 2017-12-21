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
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LabelRecommendActivityConfig;
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.view.i;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.s;
import com.baidu.tieba.NEGFeedBack.c;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.a.k;
import com.baidu.tieba.homepage.personalize.f;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class d extends FrameLayout {
    private BdTypeListView aXC;
    private com.baidu.tbadk.j.f bhE;
    private PbListView blz;
    private boolean cHR;
    private View cIS;
    private final CustomMessageListener cIo;
    private CustomMessageListener cIr;
    private View.OnClickListener dnS;
    private k dqY;
    private com.baidu.tieba.homepage.framework.b dqZ;
    private f dra;
    private a drb;
    private com.baidu.tieba.homepage.personalize.model.e drc;
    private long drd;
    private boolean dre;
    private c.a drf;
    private f.a drg;
    private i mPullView;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private com.baidu.tbadk.j.g refreshView;

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.dra != null) {
            this.dra.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.drb != null) {
            this.drb.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void completePullRefresh() {
        if (this.aXC != null) {
            this.aXC.completePullRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dqY != null) {
            this.dqY.setPageUniqueId(bdUniqueId);
        }
        if (this.dra != null) {
            this.dra.k(bdUniqueId);
        }
        if (this.drc != null) {
            this.drc.o(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.cIo != null) {
            this.cIo.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cIo);
        }
    }

    public d(Context context) {
        super(context);
        this.drd = 0L;
        this.mSkinType = 3;
        this.cHR = false;
        this.dre = false;
        this.drf = new c.a() { // from class: com.baidu.tieba.homepage.personalize.d.1
            @Override // com.baidu.tieba.NEGFeedBack.c.a
            public void a(ah ahVar) {
                if (ahVar != null) {
                    TiebaStatic.log(new ak("c11693").ac("obj_locate", "1").ac(ImageViewerConfig.FORUM_ID, ahVar.getFid()).ac("tid", ahVar.getTid()).ac("uid", TbadkCoreApplication.getCurrentAccount()));
                    TiebaStatic.log(new ak("c11989").ac(ImageViewerConfig.FORUM_ID, ahVar.getFid()).ac("tid", ahVar.getTid()).ac("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }

            @Override // com.baidu.tieba.NEGFeedBack.c.a
            public void a(ah ahVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.c.a
            public void a(ArrayList<Integer> arrayList, ah ahVar) {
                if (arrayList != null && ahVar != null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < arrayList.size(); i++) {
                        sb.append(arrayList.get(i) + Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    TiebaStatic.log(new ak("c11693").ac("obj_locate", sb.toString()).ac(ImageViewerConfig.FORUM_ID, ahVar.getFid()).ac("tid", ahVar.getTid()).ac("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }
        };
        this.drg = new f.a() { // from class: com.baidu.tieba.homepage.personalize.d.5
            @Override // com.baidu.tieba.homepage.personalize.f.a
            public void aQ(int i, int i2) {
                if (d.this.dqZ == null) {
                    d.this.showNetRefreshView(d.this, TbadkCoreApplication.getInst().getString(d.j.neterror), true);
                    d.this.NO();
                    return;
                }
                boolean atA = d.this.atA();
                d.this.Pr();
                if (atA) {
                    d.this.g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
                }
                d.this.dqZ.aP(i, i2);
            }

            @Override // com.baidu.tieba.homepage.personalize.f.a
            public void E(int i, int i2, int i3) {
                if (d.this.dqZ != null) {
                    d.this.dqZ.D(i, i2, i3);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.f.a
            public void onError(int i, String str) {
                d.this.NO();
                if (i != 1) {
                    d.this.aXC.setVisibility(8);
                    d.this.showNetRefreshView(d.this, str, true);
                } else if (j.hh()) {
                    d.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.f.a
            public void onSuccess() {
                d.this.aXC.setVisibility(0);
                d.this.NO();
                d.this.Pr();
            }
        };
        this.cIo = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.d.2
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
                        com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.d.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                d.this.atD();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.dnS = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.OI();
            }
        };
        this.cIr = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.d.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        d.this.cHR = true;
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.aXC = new BdTypeListView(context);
        this.aXC.setDividerHeight(0);
        this.aXC.setSelector(17170445);
        this.blz = new PbListView(context);
        this.blz.getView();
        this.blz.dy(d.C0095d.cp_bg_line_e);
        this.blz.ws();
        this.blz.setTextColor(aj.getColor(d.C0095d.cp_cont_j));
        this.blz.setTextSize(d.e.tbds30);
        this.blz.dx(d.C0095d.cp_cont_e);
        this.blz.setHeight(l.f(context, d.e.tbds182));
        this.blz.setOnClickListener(this.dnS);
        this.aXC.setNextPage(this.blz);
        com.baidu.adp.base.e<?> Y = com.baidu.adp.base.i.Y(context);
        if (Y instanceof TbPageContext) {
            this.pageContext = (TbPageContext) Y;
        }
        this.mPullView = new i(this.pageContext);
        this.aXC.setPullRefresh(this.mPullView);
        this.mPullView.W(true);
        this.cIS = BdListViewHelper.a(context, this.aXC, BdListViewHelper.HeadType.DEFAULT);
        this.drc = new com.baidu.tieba.homepage.personalize.model.e();
        this.dqY = new k(context, this.aXC);
        this.dqY.b(this.drc);
        this.dra = new f(this.pageContext, this.aXC, this.dqY);
        this.drb = new a(this.pageContext);
        addView(this.aXC);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        MessageManager.getInstance().registerListener(this.cIr);
    }

    public void aoZ() {
        this.dqY.a(this.drf);
        this.dra.a(this.drg);
        this.drb.a(this);
        this.mPullView.a(new h.b() { // from class: com.baidu.tieba.homepage.personalize.d.6
            @Override // com.baidu.tbadk.core.view.h.b
            public void onListPullRefresh(boolean z) {
                d.this.dra.update();
            }
        });
        this.mPullView.a(new h.c() { // from class: com.baidu.tieba.homepage.personalize.d.7
            @Override // com.baidu.tbadk.core.view.h.c
            public void aL(boolean z) {
                if (d.this.dra != null) {
                    if (d.this.dra.alM() != null) {
                        d.this.dra.alM().avu();
                    }
                    d.this.dra.gb(false);
                }
            }
        });
        this.aXC.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.personalize.d.8
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                d.this.OI();
            }
        });
        this.aXC.setOnScrollStopDelayedListener(new BdListView.d() { // from class: com.baidu.tieba.homepage.personalize.d.9
            @Override // com.baidu.adp.widget.ListView.BdListView.d
            public void onScrollStop(int i, int i2) {
                if (System.currentTimeMillis() - d.this.drd >= TbConfig.NOTIFY_SOUND_INTERVAL) {
                    d.this.dra.aR(i, i2);
                }
            }
        }, 1L);
        this.mPullView.a(new h.a() { // from class: com.baidu.tieba.homepage.personalize.d.10
            @Override // com.baidu.tbadk.core.view.h.a
            public void b(View view, boolean z) {
                if (d.this.dra != null) {
                    d.this.dra.gb(true);
                    d.this.dra.auk();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
            }
        });
        this.aXC.setRecyclerListener(new AbsListView.RecyclerListener() { // from class: com.baidu.tieba.homepage.personalize.d.11
            @Override // android.widget.AbsListView.RecyclerListener
            public void onMovedToScrapHeap(View view) {
                if (view != null) {
                    if (d.this.dra != null && d.this.dra.alM() != null) {
                        d.this.dra.alM().aU(view);
                    }
                    if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.d) {
                        ((com.baidu.tieba.homepage.personalize.a.d) view.getTag()).acB().stopPlay();
                    }
                }
            }
        });
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.dqZ = bVar;
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        if (this.blz != null) {
            this.blz.ww();
            this.blz.dA(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dra.a(z, z2, dataRes, 0, null);
    }

    public void setIsUnreadTipShow(boolean z) {
        if (this.dra != null) {
            this.dra.fZ(!z);
        }
        this.dre = z;
    }

    public boolean getIsUnreadTipShow() {
        return this.dre;
    }

    public void e(Long l) {
        this.dra.e(l);
    }

    public void setHeaderViewHeight(int i) {
        if (this.cIS != null && this.cIS.getLayoutParams() != null) {
            if (this.dra != null) {
                this.dra.setHeaderViewHeight(i);
            }
            if (this.drb != null) {
                this.drb.setHeaderViewHeight(i);
            }
            this.cIS.getLayoutParams().height = i;
            this.cIS.setLayoutParams(this.cIS.getLayoutParams());
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        if (this.dra != null) {
            this.dra.setRecommendFrsNavigationAnimDispatcher(sVar);
        }
    }

    public void showFloatingView() {
        if (this.dra != null) {
            this.dra.showFloatingView();
        }
    }

    public void aug() {
        if (this.dra != null) {
            this.dra.aug();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.bhE != null) {
                this.bhE.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.mPullView != null) {
                this.mPullView.dz(i);
            }
            if (this.blz != null) {
                this.blz.setTextColor(aj.getColor(d.C0095d.cp_cont_d));
                this.blz.dz(i);
            }
            this.dqY.onChangeSkinType(i);
            aj.k(this, d.C0095d.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void W(String str, int i) {
        if (this.blz != null) {
            this.blz.ww();
            this.blz.dA(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dra.a(true, false, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.j.g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.d.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.dra != null) {
                        d.this.dra.update();
                    }
                }
            });
        }
        this.refreshView.fi(getContext().getResources().getDimensionPixelSize(d.e.ds280));
        this.refreshView.gB(str);
        this.refreshView.c(view, z);
        this.refreshView.EW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pr() {
        if (this.refreshView != null) {
            this.refreshView.P(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NO() {
        if (this.bhE != null) {
            this.bhE.P(this);
            this.bhE = null;
            this.aXC.setNextPage(this.blz);
        }
        if (this.dqZ != null) {
            this.dqZ.atQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean atA() {
        if (this.refreshView != null) {
            return this.refreshView.EO();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, int i) {
        if (this.bhE == null) {
            if (i < 0) {
                this.bhE = new com.baidu.tbadk.j.f(getContext());
            } else {
                this.bhE = new com.baidu.tbadk.j.f(getContext(), i);
            }
            this.bhE.onChangeSkinType();
        }
        this.bhE.c(this, z);
        this.aXC.setNextPage(null);
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.dra != null) {
            this.dra.setTabInForeBackgroundState(z);
        }
    }

    public void atC() {
        setViewForeground(false);
        if (this.dra != null) {
            this.dra.eX(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("show_is_uninterest_tag", 0);
        if (i < 1 && TbadkCoreApplication.getInst().isNoInterestTag() && this.pageContext != null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("show_is_uninterest_tag", i + 1);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(this.pageContext.getContext(), 2)));
        }
    }

    public void setViewForeground(boolean z) {
        if (this.dra != null) {
            this.dra.fU(z);
        }
    }

    public void aty() {
        if (this.dra != null) {
            g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
            this.dra.update();
        }
    }

    public void reload() {
        if (this.aXC != null) {
            showFloatingView();
            this.aXC.setSelection(0);
            if (this.aXC.isRefreshDone()) {
                if (this.dra != null && this.dra.alM() != null) {
                    this.dra.alM().avu();
                    this.dra.gb(false);
                }
                this.aXC.startPullRefresh();
            }
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.cIr);
        this.dra.onDestroy();
        this.dqY.a((c.a) null);
        this.dra.a((f.a) null);
        this.mPullView.a((h.b) null);
        this.mPullView.a((h.c) null);
        this.aXC.setOnSrollToBottomListener(null);
        this.mPullView.a((h.a) null);
        this.mPullView.release();
        if (this.bhE != null) {
            this.bhE.release();
        }
        this.aXC.setRecyclerListener(null);
        if (this.drb != null) {
            this.drb.onDestroy();
        }
    }

    public void onPause() {
        this.dra.onPause();
    }

    public void onResume() {
        this.dra.onResume();
        if (this.cHR) {
            reload();
            this.cHR = false;
        }
        atD();
    }

    public void atD() {
        if (this.dqY != null) {
            this.dqY.notifyDataSetChanged();
        }
    }

    public void atE() {
        if (this.dra != null) {
            this.dra.eX(true);
        }
        com.baidu.tieba.card.s.abW().cC(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void aue() {
        this.dra.auq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OI() {
        if (this.blz != null && !this.blz.wA()) {
            this.blz.wv();
            this.blz.dA(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dra.OI();
    }
}
