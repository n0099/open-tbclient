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
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaQuestionHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LabelRecommendActivityConfig;
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.core.view.k;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.s;
import com.baidu.tieba.NEGFeedBack.c;
import com.baidu.tieba.card.r;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.a.l;
import com.baidu.tieba.homepage.personalize.f;
import com.baidu.tieba.homepage.personalize.view.b;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.FloatInfo;
/* loaded from: classes2.dex */
public class d extends FrameLayout {
    private com.baidu.tbadk.j.f bXm;
    private final CustomMessageListener bjx;
    private PbListView cbk;
    private CustomMessageListener dFG;
    private boolean dFc;
    private View dGi;
    private View.OnClickListener efS;
    private BdTypeListView efx;
    private l eiW;
    private com.baidu.tieba.homepage.framework.b eiX;
    private f eiY;
    private a eiZ;
    private com.baidu.tieba.homepage.personalize.model.e eja;
    private long ejb;
    private com.baidu.tieba.homepage.personalize.view.b ejc;
    private boolean ejd;
    private c.a eje;
    private f.a ejf;
    private k mPullView;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private com.baidu.tbadk.j.g refreshView;

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.eiY != null) {
            this.eiY.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.eiZ != null) {
            this.eiZ.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void completePullRefresh() {
        if (this.efx != null) {
            this.efx.completePullRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.eiW != null) {
            this.eiW.setPageUniqueId(bdUniqueId);
        }
        if (this.eiY != null) {
            this.eiY.j(bdUniqueId);
        }
        if (this.eja != null) {
            this.eja.m(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.bjx != null) {
            this.bjx.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bjx);
        }
        if (this.eiZ != null) {
            this.eiZ.setBdUniqueId(bdUniqueId);
        }
    }

    public d(Context context) {
        super(context);
        this.ejb = 0L;
        this.mSkinType = 3;
        this.dFc = false;
        this.ejd = false;
        this.eje = new c.a() { // from class: com.baidu.tieba.homepage.personalize.d.1
            @Override // com.baidu.tieba.NEGFeedBack.c.a
            public void a(ah ahVar) {
                if (ahVar != null) {
                    TiebaStatic.log(new ak("c11693").ab("obj_locate", "1").ab(ImageViewerConfig.FORUM_ID, ahVar.getFid()).ab("tid", ahVar.getTid()).ab("uid", TbadkCoreApplication.getCurrentAccount()));
                    TiebaStatic.log(new ak("c11989").ab(ImageViewerConfig.FORUM_ID, ahVar.getFid()).ab("tid", ahVar.getTid()).ab("uid", TbadkCoreApplication.getCurrentAccount()));
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
                    TiebaStatic.log(new ak("c11693").ab("obj_locate", sb.toString()).ab(ImageViewerConfig.FORUM_ID, ahVar.getFid()).ab("tid", ahVar.getTid()).ab("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }
        };
        this.ejf = new f.a() { // from class: com.baidu.tieba.homepage.personalize.d.6
            @Override // com.baidu.tieba.homepage.personalize.f.a
            public void bM(int i, int i2) {
                if (d.this.eiX == null) {
                    d.this.showNetRefreshView(d.this, TbadkCoreApplication.getInst().getString(d.j.neterror), true);
                    d.this.VV();
                    return;
                }
                boolean aCg = d.this.aCg();
                d.this.XN();
                if (aCg) {
                    d.this.k(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
                }
                d.this.eiX.bL(i, i2);
            }

            @Override // com.baidu.tieba.homepage.personalize.f.a
            public void O(int i, int i2, int i3) {
                if (d.this.eiX != null) {
                    d.this.eiX.N(i, i2, i3);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.f.a
            public void onError(int i, String str) {
                d.this.VV();
                if (i != 1) {
                    d.this.efx.setVisibility(8);
                    d.this.showNetRefreshView(d.this, str, true);
                } else if (j.oJ()) {
                    d.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.f.a
            public void onSuccess() {
                d.this.efx.setVisibility(0);
                d.this.VV();
                d.this.XN();
                FloatInfo aCX = d.this.eiY.aCX();
                if (aCX != null) {
                    d.this.ejc.setData(aCX);
                    d.this.ejc.setVisibility(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_quiz_floating_switch", 0L) != aCX.start_time.longValue() ? 0 : 8);
                    return;
                }
                d.this.ejc.setVisibility(8);
            }
        };
        this.bjx = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.homepage.personalize.d.3
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
                        com.baidu.adp.lib.g.e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.d.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                d.this.aCK();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.efS = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.WO();
            }
        };
        this.dFG = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.homepage.personalize.d.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        d.this.dFc = true;
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.efx = new BdTypeListView(context);
        this.efx.setDividerHeight(0);
        this.efx.setSelector(17170445);
        this.cbk = new PbListView(context);
        this.cbk.getView();
        this.cbk.gw(d.C0140d.cp_bg_line_e);
        this.cbk.Ed();
        this.cbk.setTextColor(aj.getColor(d.C0140d.cp_cont_j));
        this.cbk.setTextSize(d.e.tbfontsize33);
        this.cbk.gv(d.C0140d.cp_cont_e);
        this.cbk.setHeight(com.baidu.adp.lib.util.l.t(context, d.e.tbds182));
        this.cbk.setOnClickListener(this.efS);
        this.efx.setNextPage(this.cbk);
        com.baidu.adp.base.e<?> ak = i.ak(context);
        if (ak instanceof TbPageContext) {
            this.pageContext = (TbPageContext) ak;
        }
        this.mPullView = new k(this.pageContext);
        this.efx.setPullRefresh(this.mPullView);
        this.mPullView.aG(true);
        this.dGi = BdListViewHelper.a(context, this.efx, BdListViewHelper.HeadType.DEFAULT);
        this.eja = new com.baidu.tieba.homepage.personalize.model.e();
        this.eiW = new l(context, this.efx);
        this.eiW.b(this.eja);
        this.eiW.setCardShowType(TbadkCoreApplication.getInst().getCardShowType());
        this.eiY = new f(this.pageContext, this.efx, this.eiW);
        this.eiZ = new a(this.pageContext);
        addView(this.efx);
        this.ejc = new com.baidu.tieba.homepage.personalize.view.b(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(com.baidu.adp.lib.util.l.t(context, d.e.tbds182), com.baidu.adp.lib.util.l.t(context, d.e.tbds182));
        layoutParams.gravity = 85;
        layoutParams.rightMargin = com.baidu.adp.lib.util.l.t(context, d.e.tbds18);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.l.t(context, d.e.tbds238);
        addView(this.ejc, layoutParams);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        MessageManager.getInstance().registerListener(this.dFG);
        this.ejc.setCallback(new b.a() { // from class: com.baidu.tieba.homepage.personalize.d.7
            @Override // com.baidu.tieba.homepage.personalize.view.b.a
            public void aCL() {
                TiebaStatic.log(new ak("c12913").s("obj_locate", 2));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaQuestionHomeActivityConfig(d.this.getContext())));
            }

            @Override // com.baidu.tieba.homepage.personalize.view.b.a
            public void aCM() {
                TiebaStatic.log(new ak("c12913").s("obj_locate", 3));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_quiz_floating_switch", d.this.eiY.aCX() == null ? 0L : d.this.eiY.aCX().start_time.longValue());
                d.this.ejc.setVisibility(8);
                com.baidu.adp.lib.util.l.showToast(d.this.getContext(), d.j.quiz_entrance_close_tips);
            }
        });
        this.ejc.setVisibility(8);
    }

    public void ayf() {
        this.eiW.a(this.eje);
        this.eiY.a(this.ejf);
        this.eiZ.a(this);
        this.mPullView.a(new j.b() { // from class: com.baidu.tieba.homepage.personalize.d.8
            @Override // com.baidu.tbadk.core.view.j.b
            public void bw(boolean z) {
                d.this.eiW.setCardShowType(TbadkCoreApplication.getInst().getCardShowType());
                d.this.eiY.update();
            }
        });
        this.mPullView.a(new j.c() { // from class: com.baidu.tieba.homepage.personalize.d.9
            @Override // com.baidu.tbadk.core.view.j.c
            public void bx(boolean z) {
                if (d.this.eiY != null) {
                    if (d.this.eiY.avE() != null) {
                        d.this.eiY.avE().aEa();
                    }
                    d.this.eiY.gQ(false);
                }
            }
        });
        this.efx.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.personalize.d.10
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                d.this.WO();
            }
        });
        this.efx.setOnScrollStopDelayedListener(new BdListView.d() { // from class: com.baidu.tieba.homepage.personalize.d.11
            @Override // com.baidu.adp.widget.ListView.BdListView.d
            public void onScrollStop(int i, int i2) {
                if (System.currentTimeMillis() - d.this.ejb >= TbConfig.NOTIFY_SOUND_INTERVAL) {
                    d.this.eiY.bN(i, i2);
                }
            }
        }, 1L);
        this.mPullView.a(new j.a() { // from class: com.baidu.tieba.homepage.personalize.d.12
            @Override // com.baidu.tbadk.core.view.j.a
            public void i(View view, boolean z) {
                if (d.this.eiY != null) {
                    d.this.eiY.gQ(true);
                    d.this.eiY.aCQ();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, true));
            }
        });
        this.efx.setRecyclerListener(new AbsListView.RecyclerListener() { // from class: com.baidu.tieba.homepage.personalize.d.13
            @Override // android.widget.AbsListView.RecyclerListener
            public void onMovedToScrapHeap(View view) {
                if (view != null) {
                    if (d.this.eiY != null && d.this.eiY.avE() != null) {
                        d.this.eiY.avE().cg(view);
                    }
                    if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.d) {
                        ((com.baidu.tieba.homepage.personalize.a.d) view.getTag()).alY().stopPlay();
                    }
                }
            }
        });
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.eiX = bVar;
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        if (this.cbk != null) {
            this.cbk.Eh();
            this.cbk.gy(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.eiY.a(z, z2, dataRes, 0, null);
    }

    public void setIsUnreadTipShow(boolean z) {
        if (this.eiY != null) {
            this.eiY.gO(!z);
        }
        this.ejd = z;
    }

    public boolean getIsUnreadTipShow() {
        return this.ejd;
    }

    public void e(Long l) {
        this.eiY.e(l);
    }

    public void setHeaderViewHeight(int i) {
        if (this.dGi != null && this.dGi.getLayoutParams() != null) {
            if (this.eiY != null) {
                this.eiY.setHeaderViewHeight(i);
            }
            if (this.eiZ != null) {
                this.eiZ.setHeaderViewHeight(i);
            }
            this.dGi.getLayoutParams().height = i;
            this.dGi.setLayoutParams(this.dGi.getLayoutParams());
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        if (this.eiY != null) {
            this.eiY.setRecommendFrsNavigationAnimDispatcher(sVar);
        }
    }

    public void showFloatingView() {
        if (this.eiY != null) {
            this.eiY.showFloatingView();
        }
    }

    public void aCJ() {
        if (this.eiY != null) {
            this.eiY.aCJ();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.bXm != null) {
                this.bXm.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.mPullView != null) {
                this.mPullView.gx(i);
            }
            if (this.cbk != null) {
                this.cbk.setTextColor(aj.getColor(d.C0140d.cp_cont_d));
                this.cbk.gx(i);
            }
            this.eiW.onChangeSkinType(i);
            aj.t(this, d.C0140d.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void Y(String str, int i) {
        if (this.cbk != null) {
            this.cbk.Eh();
            this.cbk.gy(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.eiY.a(true, false, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.j.g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.eiY != null) {
                        d.this.eiY.update();
                    }
                }
            });
        }
        this.refreshView.ib(getContext().getResources().getDimensionPixelSize(d.e.ds280));
        this.refreshView.gW(str);
        this.refreshView.j(view, z);
        this.refreshView.MR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XN() {
        if (this.refreshView != null) {
            this.refreshView.bk(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VV() {
        if (this.bXm != null) {
            this.bXm.bk(this);
            this.bXm = null;
            this.efx.setNextPage(this.cbk);
        }
        if (this.eiX != null) {
            this.eiX.aCu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aCg() {
        if (this.refreshView != null) {
            return this.refreshView.MJ();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(boolean z, int i) {
        if (this.bXm == null) {
            if (i < 0) {
                this.bXm = new com.baidu.tbadk.j.f(getContext());
            } else {
                this.bXm = new com.baidu.tbadk.j.f(getContext(), i);
            }
            this.bXm.onChangeSkinType();
        }
        this.bXm.j(this, z);
        this.efx.setNextPage(null);
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.eiY != null) {
            this.eiY.setTabInForeBackgroundState(z);
        }
    }

    public void aCi() {
        setViewForeground(false);
        if (this.eiY != null) {
            this.eiY.fS(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("show_is_uninterest_tag", 0);
        if (i < 1 && TbadkCoreApplication.getInst().isNoInterestTag() && this.pageContext != null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("show_is_uninterest_tag", i + 1);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(this.pageContext.getContext(), 2)));
        }
    }

    public void setViewForeground(boolean z) {
        if (this.eiY != null) {
            this.eiY.gJ(z);
        }
    }

    public void aCe() {
        if (this.eiY != null) {
            k(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
            this.eiY.update();
        }
    }

    public void reload() {
        if (this.efx != null) {
            showFloatingView();
            this.efx.setSelection(0);
            if (this.efx.isRefreshDone()) {
                if (this.eiY != null && this.eiY.avE() != null) {
                    this.eiY.avE().aEa();
                    this.eiY.gQ(false);
                }
                this.efx.startPullRefresh();
            }
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dFG);
        this.eiY.onDestroy();
        this.eiW.a((c.a) null);
        this.eiY.a((f.a) null);
        this.mPullView.a((j.b) null);
        this.mPullView.a((j.c) null);
        this.efx.setOnSrollToBottomListener(null);
        this.mPullView.a((j.a) null);
        this.mPullView.release();
        if (this.bXm != null) {
            this.bXm.release();
        }
        this.efx.setRecyclerListener(null);
        if (this.eiZ != null) {
            this.eiZ.onDestroy();
        }
    }

    public void onPause() {
        this.eiY.onPause();
    }

    public void onResume() {
        this.eiY.onResume();
        if (this.dFc) {
            reload();
            this.dFc = false;
        }
    }

    public void aCK() {
        if (this.eiW != null) {
            this.eiW.notifyDataSetChanged();
        }
    }

    public void aCj() {
        if (this.eiY != null) {
            this.eiY.fS(true);
        }
        r.alt().dk(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
    }

    public void aCH() {
        this.eiY.aCW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WO() {
        if (this.cbk != null && !this.cbk.El()) {
            this.cbk.Eg();
            this.cbk.gy(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.eiY.WO();
    }
}
