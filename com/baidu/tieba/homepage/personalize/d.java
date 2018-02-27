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
    private com.baidu.tbadk.j.f bXa;
    private final CustomMessageListener bjk;
    private PbListView caY;
    private boolean dEQ;
    private View dFW;
    private CustomMessageListener dFu;
    private View.OnClickListener efG;
    private BdTypeListView efl;
    private l eiK;
    private com.baidu.tieba.homepage.framework.b eiL;
    private f eiM;
    private a eiN;
    private com.baidu.tieba.homepage.personalize.model.e eiO;
    private long eiP;
    private com.baidu.tieba.homepage.personalize.view.b eiQ;
    private boolean eiR;
    private c.a eiS;
    private f.a eiT;
    private k mPullView;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private com.baidu.tbadk.j.g refreshView;

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.eiM != null) {
            this.eiM.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.eiN != null) {
            this.eiN.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void completePullRefresh() {
        if (this.efl != null) {
            this.efl.completePullRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.eiK != null) {
            this.eiK.setPageUniqueId(bdUniqueId);
        }
        if (this.eiM != null) {
            this.eiM.j(bdUniqueId);
        }
        if (this.eiO != null) {
            this.eiO.m(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.bjk != null) {
            this.bjk.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bjk);
        }
        if (this.eiN != null) {
            this.eiN.setBdUniqueId(bdUniqueId);
        }
    }

    public d(Context context) {
        super(context);
        this.eiP = 0L;
        this.mSkinType = 3;
        this.dEQ = false;
        this.eiR = false;
        this.eiS = new c.a() { // from class: com.baidu.tieba.homepage.personalize.d.1
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
        this.eiT = new f.a() { // from class: com.baidu.tieba.homepage.personalize.d.6
            @Override // com.baidu.tieba.homepage.personalize.f.a
            public void bM(int i, int i2) {
                if (d.this.eiL == null) {
                    d.this.showNetRefreshView(d.this, TbadkCoreApplication.getInst().getString(d.j.neterror), true);
                    d.this.VU();
                    return;
                }
                boolean aCf = d.this.aCf();
                d.this.XM();
                if (aCf) {
                    d.this.k(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
                }
                d.this.eiL.bL(i, i2);
            }

            @Override // com.baidu.tieba.homepage.personalize.f.a
            public void O(int i, int i2, int i3) {
                if (d.this.eiL != null) {
                    d.this.eiL.N(i, i2, i3);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.f.a
            public void onError(int i, String str) {
                d.this.VU();
                if (i != 1) {
                    d.this.efl.setVisibility(8);
                    d.this.showNetRefreshView(d.this, str, true);
                } else if (j.oJ()) {
                    d.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.f.a
            public void onSuccess() {
                d.this.efl.setVisibility(0);
                d.this.VU();
                d.this.XM();
                FloatInfo aCW = d.this.eiM.aCW();
                if (aCW != null) {
                    d.this.eiQ.setData(aCW);
                    d.this.eiQ.setVisibility(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_quiz_floating_switch", 0L) != aCW.start_time.longValue() ? 0 : 8);
                    return;
                }
                d.this.eiQ.setVisibility(8);
            }
        };
        this.bjk = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.homepage.personalize.d.3
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
                                d.this.aCJ();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.efG = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.WN();
            }
        };
        this.dFu = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.homepage.personalize.d.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        d.this.dEQ = true;
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.efl = new BdTypeListView(context);
        this.efl.setDividerHeight(0);
        this.efl.setSelector(17170445);
        this.caY = new PbListView(context);
        this.caY.getView();
        this.caY.gw(d.C0141d.cp_bg_line_e);
        this.caY.Ec();
        this.caY.setTextColor(aj.getColor(d.C0141d.cp_cont_j));
        this.caY.setTextSize(d.e.tbfontsize33);
        this.caY.gv(d.C0141d.cp_cont_e);
        this.caY.setHeight(com.baidu.adp.lib.util.l.t(context, d.e.tbds182));
        this.caY.setOnClickListener(this.efG);
        this.efl.setNextPage(this.caY);
        com.baidu.adp.base.e<?> ak = i.ak(context);
        if (ak instanceof TbPageContext) {
            this.pageContext = (TbPageContext) ak;
        }
        this.mPullView = new k(this.pageContext);
        this.efl.setPullRefresh(this.mPullView);
        this.mPullView.aG(true);
        this.dFW = BdListViewHelper.a(context, this.efl, BdListViewHelper.HeadType.DEFAULT);
        this.eiO = new com.baidu.tieba.homepage.personalize.model.e();
        this.eiK = new l(context, this.efl);
        this.eiK.b(this.eiO);
        this.eiK.setCardShowType(TbadkCoreApplication.getInst().getCardShowType());
        this.eiM = new f(this.pageContext, this.efl, this.eiK);
        this.eiN = new a(this.pageContext);
        addView(this.efl);
        this.eiQ = new com.baidu.tieba.homepage.personalize.view.b(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(com.baidu.adp.lib.util.l.t(context, d.e.tbds182), com.baidu.adp.lib.util.l.t(context, d.e.tbds182));
        layoutParams.gravity = 85;
        layoutParams.rightMargin = com.baidu.adp.lib.util.l.t(context, d.e.tbds18);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.l.t(context, d.e.tbds238);
        addView(this.eiQ, layoutParams);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        MessageManager.getInstance().registerListener(this.dFu);
        this.eiQ.setCallback(new b.a() { // from class: com.baidu.tieba.homepage.personalize.d.7
            @Override // com.baidu.tieba.homepage.personalize.view.b.a
            public void aCK() {
                TiebaStatic.log(new ak("c12913").s("obj_locate", 2));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaQuestionHomeActivityConfig(d.this.getContext())));
            }

            @Override // com.baidu.tieba.homepage.personalize.view.b.a
            public void aCL() {
                TiebaStatic.log(new ak("c12913").s("obj_locate", 3));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_quiz_floating_switch", d.this.eiM.aCW() == null ? 0L : d.this.eiM.aCW().start_time.longValue());
                d.this.eiQ.setVisibility(8);
                com.baidu.adp.lib.util.l.showToast(d.this.getContext(), d.j.quiz_entrance_close_tips);
            }
        });
        this.eiQ.setVisibility(8);
    }

    public void aye() {
        this.eiK.a(this.eiS);
        this.eiM.a(this.eiT);
        this.eiN.a(this);
        this.mPullView.a(new j.b() { // from class: com.baidu.tieba.homepage.personalize.d.8
            @Override // com.baidu.tbadk.core.view.j.b
            public void bw(boolean z) {
                d.this.eiK.setCardShowType(TbadkCoreApplication.getInst().getCardShowType());
                d.this.eiM.update();
            }
        });
        this.mPullView.a(new j.c() { // from class: com.baidu.tieba.homepage.personalize.d.9
            @Override // com.baidu.tbadk.core.view.j.c
            public void bx(boolean z) {
                if (d.this.eiM != null) {
                    if (d.this.eiM.avD() != null) {
                        d.this.eiM.avD().aDZ();
                    }
                    d.this.eiM.gQ(false);
                }
            }
        });
        this.efl.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.personalize.d.10
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                d.this.WN();
            }
        });
        this.efl.setOnScrollStopDelayedListener(new BdListView.d() { // from class: com.baidu.tieba.homepage.personalize.d.11
            @Override // com.baidu.adp.widget.ListView.BdListView.d
            public void onScrollStop(int i, int i2) {
                if (System.currentTimeMillis() - d.this.eiP >= TbConfig.NOTIFY_SOUND_INTERVAL) {
                    d.this.eiM.bN(i, i2);
                }
            }
        }, 1L);
        this.mPullView.a(new j.a() { // from class: com.baidu.tieba.homepage.personalize.d.12
            @Override // com.baidu.tbadk.core.view.j.a
            public void i(View view, boolean z) {
                if (d.this.eiM != null) {
                    d.this.eiM.gQ(true);
                    d.this.eiM.aCP();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, true));
            }
        });
        this.efl.setRecyclerListener(new AbsListView.RecyclerListener() { // from class: com.baidu.tieba.homepage.personalize.d.13
            @Override // android.widget.AbsListView.RecyclerListener
            public void onMovedToScrapHeap(View view) {
                if (view != null) {
                    if (d.this.eiM != null && d.this.eiM.avD() != null) {
                        d.this.eiM.avD().cg(view);
                    }
                    if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.d) {
                        ((com.baidu.tieba.homepage.personalize.a.d) view.getTag()).alX().stopPlay();
                    }
                }
            }
        });
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.eiL = bVar;
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        if (this.caY != null) {
            this.caY.Eg();
            this.caY.gy(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.eiM.a(z, z2, dataRes, 0, null);
    }

    public void setIsUnreadTipShow(boolean z) {
        if (this.eiM != null) {
            this.eiM.gO(!z);
        }
        this.eiR = z;
    }

    public boolean getIsUnreadTipShow() {
        return this.eiR;
    }

    public void e(Long l) {
        this.eiM.e(l);
    }

    public void setHeaderViewHeight(int i) {
        if (this.dFW != null && this.dFW.getLayoutParams() != null) {
            if (this.eiM != null) {
                this.eiM.setHeaderViewHeight(i);
            }
            if (this.eiN != null) {
                this.eiN.setHeaderViewHeight(i);
            }
            this.dFW.getLayoutParams().height = i;
            this.dFW.setLayoutParams(this.dFW.getLayoutParams());
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        if (this.eiM != null) {
            this.eiM.setRecommendFrsNavigationAnimDispatcher(sVar);
        }
    }

    public void showFloatingView() {
        if (this.eiM != null) {
            this.eiM.showFloatingView();
        }
    }

    public void aCI() {
        if (this.eiM != null) {
            this.eiM.aCI();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.bXa != null) {
                this.bXa.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.mPullView != null) {
                this.mPullView.gx(i);
            }
            if (this.caY != null) {
                this.caY.setTextColor(aj.getColor(d.C0141d.cp_cont_d));
                this.caY.gx(i);
            }
            this.eiK.onChangeSkinType(i);
            aj.t(this, d.C0141d.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void Y(String str, int i) {
        if (this.caY != null) {
            this.caY.Eg();
            this.caY.gy(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.eiM.a(true, false, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.j.g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.eiM != null) {
                        d.this.eiM.update();
                    }
                }
            });
        }
        this.refreshView.ib(getContext().getResources().getDimensionPixelSize(d.e.ds280));
        this.refreshView.gW(str);
        this.refreshView.j(view, z);
        this.refreshView.MQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XM() {
        if (this.refreshView != null) {
            this.refreshView.bk(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VU() {
        if (this.bXa != null) {
            this.bXa.bk(this);
            this.bXa = null;
            this.efl.setNextPage(this.caY);
        }
        if (this.eiL != null) {
            this.eiL.aCt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aCf() {
        if (this.refreshView != null) {
            return this.refreshView.MI();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(boolean z, int i) {
        if (this.bXa == null) {
            if (i < 0) {
                this.bXa = new com.baidu.tbadk.j.f(getContext());
            } else {
                this.bXa = new com.baidu.tbadk.j.f(getContext(), i);
            }
            this.bXa.onChangeSkinType();
        }
        this.bXa.j(this, z);
        this.efl.setNextPage(null);
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.eiM != null) {
            this.eiM.setTabInForeBackgroundState(z);
        }
    }

    public void aCh() {
        setViewForeground(false);
        if (this.eiM != null) {
            this.eiM.fS(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("show_is_uninterest_tag", 0);
        if (i < 1 && TbadkCoreApplication.getInst().isNoInterestTag() && this.pageContext != null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("show_is_uninterest_tag", i + 1);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(this.pageContext.getContext(), 2)));
        }
    }

    public void setViewForeground(boolean z) {
        if (this.eiM != null) {
            this.eiM.gJ(z);
        }
    }

    public void aCd() {
        if (this.eiM != null) {
            k(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
            this.eiM.update();
        }
    }

    public void reload() {
        if (this.efl != null) {
            showFloatingView();
            this.efl.setSelection(0);
            if (this.efl.isRefreshDone()) {
                if (this.eiM != null && this.eiM.avD() != null) {
                    this.eiM.avD().aDZ();
                    this.eiM.gQ(false);
                }
                this.efl.startPullRefresh();
            }
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dFu);
        this.eiM.onDestroy();
        this.eiK.a((c.a) null);
        this.eiM.a((f.a) null);
        this.mPullView.a((j.b) null);
        this.mPullView.a((j.c) null);
        this.efl.setOnSrollToBottomListener(null);
        this.mPullView.a((j.a) null);
        this.mPullView.release();
        if (this.bXa != null) {
            this.bXa.release();
        }
        this.efl.setRecyclerListener(null);
        if (this.eiN != null) {
            this.eiN.onDestroy();
        }
    }

    public void onPause() {
        this.eiM.onPause();
    }

    public void onResume() {
        this.eiM.onResume();
        if (this.dEQ) {
            reload();
            this.dEQ = false;
        }
    }

    public void aCJ() {
        if (this.eiK != null) {
            this.eiK.notifyDataSetChanged();
        }
    }

    public void aCi() {
        if (this.eiM != null) {
            this.eiM.fS(true);
        }
        r.als().dk(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
    }

    public void aCG() {
        this.eiM.aCV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WN() {
        if (this.caY != null && !this.caY.Ek()) {
            this.caY.Ef();
            this.caY.gy(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.eiM.WN();
    }
}
