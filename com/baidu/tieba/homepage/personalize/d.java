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
    private com.baidu.tbadk.j.f bXd;
    private final CustomMessageListener bjn;
    private PbListView cbb;
    private boolean dET;
    private CustomMessageListener dFy;
    private View dGb;
    private BdTypeListView efB;
    private View.OnClickListener efW;
    private l eja;
    private com.baidu.tieba.homepage.framework.b ejb;
    private f ejc;
    private a ejd;
    private com.baidu.tieba.homepage.personalize.model.e eje;
    private long ejf;
    private com.baidu.tieba.homepage.personalize.view.b ejg;
    private boolean ejh;
    private c.a eji;
    private f.a ejj;
    private k mPullView;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private com.baidu.tbadk.j.g refreshView;

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.ejc != null) {
            this.ejc.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.ejd != null) {
            this.ejd.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void completePullRefresh() {
        if (this.efB != null) {
            this.efB.completePullRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.eja != null) {
            this.eja.setPageUniqueId(bdUniqueId);
        }
        if (this.ejc != null) {
            this.ejc.j(bdUniqueId);
        }
        if (this.eje != null) {
            this.eje.m(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.bjn != null) {
            this.bjn.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bjn);
        }
        if (this.ejd != null) {
            this.ejd.setBdUniqueId(bdUniqueId);
        }
    }

    public d(Context context) {
        super(context);
        this.ejf = 0L;
        this.mSkinType = 3;
        this.dET = false;
        this.ejh = false;
        this.eji = new c.a() { // from class: com.baidu.tieba.homepage.personalize.d.1
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
        this.ejj = new f.a() { // from class: com.baidu.tieba.homepage.personalize.d.6
            @Override // com.baidu.tieba.homepage.personalize.f.a
            public void bM(int i, int i2) {
                if (d.this.ejb == null) {
                    d.this.showNetRefreshView(d.this, TbadkCoreApplication.getInst().getString(d.j.neterror), true);
                    d.this.VV();
                    return;
                }
                boolean aCg = d.this.aCg();
                d.this.XN();
                if (aCg) {
                    d.this.k(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
                }
                d.this.ejb.bL(i, i2);
            }

            @Override // com.baidu.tieba.homepage.personalize.f.a
            public void O(int i, int i2, int i3) {
                if (d.this.ejb != null) {
                    d.this.ejb.N(i, i2, i3);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.f.a
            public void onError(int i, String str) {
                d.this.VV();
                if (i != 1) {
                    d.this.efB.setVisibility(8);
                    d.this.showNetRefreshView(d.this, str, true);
                } else if (j.oJ()) {
                    d.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.f.a
            public void onSuccess() {
                d.this.efB.setVisibility(0);
                d.this.VV();
                d.this.XN();
                FloatInfo aCX = d.this.ejc.aCX();
                if (aCX != null) {
                    d.this.ejg.setData(aCX);
                    d.this.ejg.setVisibility(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_quiz_floating_switch", 0L) != aCX.start_time.longValue() ? 0 : 8);
                    return;
                }
                d.this.ejg.setVisibility(8);
            }
        };
        this.bjn = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.homepage.personalize.d.3
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
        this.efW = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.WO();
            }
        };
        this.dFy = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.homepage.personalize.d.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        d.this.dET = true;
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.efB = new BdTypeListView(context);
        this.efB.setDividerHeight(0);
        this.efB.setSelector(17170445);
        this.cbb = new PbListView(context);
        this.cbb.getView();
        this.cbb.gw(d.C0141d.cp_bg_line_e);
        this.cbb.Ed();
        this.cbb.setTextColor(aj.getColor(d.C0141d.cp_cont_j));
        this.cbb.setTextSize(d.e.tbfontsize33);
        this.cbb.gv(d.C0141d.cp_cont_e);
        this.cbb.setHeight(com.baidu.adp.lib.util.l.t(context, d.e.tbds182));
        this.cbb.setOnClickListener(this.efW);
        this.efB.setNextPage(this.cbb);
        com.baidu.adp.base.e<?> ak = i.ak(context);
        if (ak instanceof TbPageContext) {
            this.pageContext = (TbPageContext) ak;
        }
        this.mPullView = new k(this.pageContext);
        this.efB.setPullRefresh(this.mPullView);
        this.mPullView.aG(true);
        this.dGb = BdListViewHelper.a(context, this.efB, BdListViewHelper.HeadType.DEFAULT);
        this.eje = new com.baidu.tieba.homepage.personalize.model.e();
        this.eja = new l(context, this.efB);
        this.eja.b(this.eje);
        this.eja.setCardShowType(TbadkCoreApplication.getInst().getCardShowType());
        this.ejc = new f(this.pageContext, this.efB, this.eja);
        this.ejd = new a(this.pageContext);
        addView(this.efB);
        this.ejg = new com.baidu.tieba.homepage.personalize.view.b(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(com.baidu.adp.lib.util.l.t(context, d.e.tbds182), com.baidu.adp.lib.util.l.t(context, d.e.tbds182));
        layoutParams.gravity = 85;
        layoutParams.rightMargin = com.baidu.adp.lib.util.l.t(context, d.e.tbds18);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.l.t(context, d.e.tbds238);
        addView(this.ejg, layoutParams);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        MessageManager.getInstance().registerListener(this.dFy);
        this.ejg.setCallback(new b.a() { // from class: com.baidu.tieba.homepage.personalize.d.7
            @Override // com.baidu.tieba.homepage.personalize.view.b.a
            public void aCL() {
                TiebaStatic.log(new ak("c12913").s("obj_locate", 2));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaQuestionHomeActivityConfig(d.this.getContext())));
            }

            @Override // com.baidu.tieba.homepage.personalize.view.b.a
            public void aCM() {
                TiebaStatic.log(new ak("c12913").s("obj_locate", 3));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_quiz_floating_switch", d.this.ejc.aCX() == null ? 0L : d.this.ejc.aCX().start_time.longValue());
                d.this.ejg.setVisibility(8);
                com.baidu.adp.lib.util.l.showToast(d.this.getContext(), d.j.quiz_entrance_close_tips);
            }
        });
        this.ejg.setVisibility(8);
    }

    public void ayg() {
        this.eja.a(this.eji);
        this.ejc.a(this.ejj);
        this.ejd.a(this);
        this.mPullView.a(new j.b() { // from class: com.baidu.tieba.homepage.personalize.d.8
            @Override // com.baidu.tbadk.core.view.j.b
            public void bw(boolean z) {
                d.this.eja.setCardShowType(TbadkCoreApplication.getInst().getCardShowType());
                d.this.ejc.update();
            }
        });
        this.mPullView.a(new j.c() { // from class: com.baidu.tieba.homepage.personalize.d.9
            @Override // com.baidu.tbadk.core.view.j.c
            public void bx(boolean z) {
                if (d.this.ejc != null) {
                    if (d.this.ejc.avF() != null) {
                        d.this.ejc.avF().aEa();
                    }
                    d.this.ejc.gV(false);
                }
            }
        });
        this.efB.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.personalize.d.10
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                d.this.WO();
            }
        });
        this.efB.setOnScrollStopDelayedListener(new BdListView.d() { // from class: com.baidu.tieba.homepage.personalize.d.11
            @Override // com.baidu.adp.widget.ListView.BdListView.d
            public void onScrollStop(int i, int i2) {
                if (System.currentTimeMillis() - d.this.ejf >= TbConfig.NOTIFY_SOUND_INTERVAL) {
                    d.this.ejc.bN(i, i2);
                }
            }
        }, 1L);
        this.mPullView.a(new j.a() { // from class: com.baidu.tieba.homepage.personalize.d.12
            @Override // com.baidu.tbadk.core.view.j.a
            public void i(View view, boolean z) {
                if (d.this.ejc != null) {
                    d.this.ejc.gV(true);
                    d.this.ejc.aCQ();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, true));
            }
        });
        this.efB.setRecyclerListener(new AbsListView.RecyclerListener() { // from class: com.baidu.tieba.homepage.personalize.d.13
            @Override // android.widget.AbsListView.RecyclerListener
            public void onMovedToScrapHeap(View view) {
                if (view != null) {
                    if (d.this.ejc != null && d.this.ejc.avF() != null) {
                        d.this.ejc.avF().cg(view);
                    }
                    if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.d) {
                        ((com.baidu.tieba.homepage.personalize.a.d) view.getTag()).alY().stopPlay();
                    }
                }
            }
        });
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.ejb = bVar;
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        if (this.cbb != null) {
            this.cbb.Eh();
            this.cbb.gy(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.ejc.a(z, z2, dataRes, 0, null);
    }

    public void setIsUnreadTipShow(boolean z) {
        if (this.ejc != null) {
            this.ejc.gT(!z);
        }
        this.ejh = z;
    }

    public boolean getIsUnreadTipShow() {
        return this.ejh;
    }

    public void e(Long l) {
        this.ejc.e(l);
    }

    public void setHeaderViewHeight(int i) {
        if (this.dGb != null && this.dGb.getLayoutParams() != null) {
            if (this.ejc != null) {
                this.ejc.setHeaderViewHeight(i);
            }
            if (this.ejd != null) {
                this.ejd.setHeaderViewHeight(i);
            }
            this.dGb.getLayoutParams().height = i;
            this.dGb.setLayoutParams(this.dGb.getLayoutParams());
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        if (this.ejc != null) {
            this.ejc.setRecommendFrsNavigationAnimDispatcher(sVar);
        }
    }

    public void showFloatingView() {
        if (this.ejc != null) {
            this.ejc.showFloatingView();
        }
    }

    public void aCJ() {
        if (this.ejc != null) {
            this.ejc.aCJ();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.bXd != null) {
                this.bXd.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.mPullView != null) {
                this.mPullView.gx(i);
            }
            if (this.cbb != null) {
                this.cbb.setTextColor(aj.getColor(d.C0141d.cp_cont_d));
                this.cbb.gx(i);
            }
            this.eja.onChangeSkinType(i);
            aj.t(this, d.C0141d.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void Y(String str, int i) {
        if (this.cbb != null) {
            this.cbb.Eh();
            this.cbb.gy(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.ejc.a(true, false, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.j.g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.ejc != null) {
                        d.this.ejc.update();
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
        if (this.bXd != null) {
            this.bXd.bk(this);
            this.bXd = null;
            this.efB.setNextPage(this.cbb);
        }
        if (this.ejb != null) {
            this.ejb.aCu();
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
        if (this.bXd == null) {
            if (i < 0) {
                this.bXd = new com.baidu.tbadk.j.f(getContext());
            } else {
                this.bXd = new com.baidu.tbadk.j.f(getContext(), i);
            }
            this.bXd.onChangeSkinType();
        }
        this.bXd.j(this, z);
        this.efB.setNextPage(null);
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.ejc != null) {
            this.ejc.setTabInForeBackgroundState(z);
        }
    }

    public void aCi() {
        setViewForeground(false);
        if (this.ejc != null) {
            this.ejc.fS(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("show_is_uninterest_tag", 0);
        if (i < 1 && TbadkCoreApplication.getInst().isNoInterestTag() && this.pageContext != null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("show_is_uninterest_tag", i + 1);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(this.pageContext.getContext(), 2)));
        }
    }

    public void setViewForeground(boolean z) {
        if (this.ejc != null) {
            this.ejc.gO(z);
        }
    }

    public void aCe() {
        if (this.ejc != null) {
            k(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
            this.ejc.update();
        }
    }

    public void reload() {
        if (this.efB != null) {
            showFloatingView();
            this.efB.setSelection(0);
            if (this.efB.isRefreshDone()) {
                if (this.ejc != null && this.ejc.avF() != null) {
                    this.ejc.avF().aEa();
                    this.ejc.gV(false);
                }
                this.efB.startPullRefresh();
            }
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dFy);
        this.ejc.onDestroy();
        this.eja.a((c.a) null);
        this.ejc.a((f.a) null);
        this.mPullView.a((j.b) null);
        this.mPullView.a((j.c) null);
        this.efB.setOnSrollToBottomListener(null);
        this.mPullView.a((j.a) null);
        this.mPullView.release();
        if (this.bXd != null) {
            this.bXd.release();
        }
        this.efB.setRecyclerListener(null);
        if (this.ejd != null) {
            this.ejd.onDestroy();
        }
    }

    public void onPause() {
        this.ejc.onPause();
    }

    public void onResume() {
        this.ejc.onResume();
        if (this.dET) {
            reload();
            this.dET = false;
        }
    }

    public void aCK() {
        if (this.eja != null) {
            this.eja.notifyDataSetChanged();
        }
    }

    public void aCj() {
        if (this.ejc != null) {
            this.ejc.fS(true);
        }
        r.alt().dk(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
    }

    public void aCH() {
        this.ejc.aCW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WO() {
        if (this.cbb != null && !this.cbb.El()) {
            this.cbb.Eg();
            this.cbb.gy(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.ejc.WO();
    }
}
