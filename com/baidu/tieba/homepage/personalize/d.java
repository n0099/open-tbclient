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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
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
    private com.baidu.tbadk.j.f bVd;
    private PbListView bYZ;
    private final CustomMessageListener dCG;
    private CustomMessageListener dCJ;
    private boolean dCi;
    private View dDl;
    private View.OnClickListener ebG;
    private BdTypeListView ebl;
    private l eeK;
    private com.baidu.tieba.homepage.framework.b eeL;
    private f eeM;
    private a eeN;
    private com.baidu.tieba.homepage.personalize.model.e eeO;
    private long eeP;
    private com.baidu.tieba.homepage.personalize.view.b eeQ;
    private boolean eeR;
    private c.a eeS;
    private f.a eeT;
    private k mPullView;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private com.baidu.tbadk.j.g refreshView;

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.eeM != null) {
            this.eeM.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.eeN != null) {
            this.eeN.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void completePullRefresh() {
        if (this.ebl != null) {
            this.ebl.completePullRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.eeK != null) {
            this.eeK.setPageUniqueId(bdUniqueId);
        }
        if (this.eeM != null) {
            this.eeM.j(bdUniqueId);
        }
        if (this.eeO != null) {
            this.eeO.m(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.dCG != null) {
            this.dCG.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dCG);
        }
    }

    public d(Context context) {
        super(context);
        this.eeP = 0L;
        this.mSkinType = 3;
        this.dCi = false;
        this.eeR = false;
        this.eeS = new c.a() { // from class: com.baidu.tieba.homepage.personalize.d.1
            @Override // com.baidu.tieba.NEGFeedBack.c.a
            public void a(ah ahVar) {
                if (ahVar != null) {
                    TiebaStatic.log(new ak("c11693").aa("obj_locate", "1").aa(ImageViewerConfig.FORUM_ID, ahVar.getFid()).aa("tid", ahVar.getTid()).aa("uid", TbadkCoreApplication.getCurrentAccount()));
                    TiebaStatic.log(new ak("c11989").aa(ImageViewerConfig.FORUM_ID, ahVar.getFid()).aa("tid", ahVar.getTid()).aa("uid", TbadkCoreApplication.getCurrentAccount()));
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
                    TiebaStatic.log(new ak("c11693").aa("obj_locate", sb.toString()).aa(ImageViewerConfig.FORUM_ID, ahVar.getFid()).aa("tid", ahVar.getTid()).aa("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }
        };
        this.eeT = new f.a() { // from class: com.baidu.tieba.homepage.personalize.d.6
            @Override // com.baidu.tieba.homepage.personalize.f.a
            public void bO(int i, int i2) {
                if (d.this.eeL == null) {
                    d.this.showNetRefreshView(d.this, TbadkCoreApplication.getInst().getString(d.j.neterror), true);
                    d.this.Vd();
                    return;
                }
                boolean aAM = d.this.aAM();
                d.this.WG();
                if (aAM) {
                    d.this.j(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
                }
                d.this.eeL.bN(i, i2);
            }

            @Override // com.baidu.tieba.homepage.personalize.f.a
            public void N(int i, int i2, int i3) {
                if (d.this.eeL != null) {
                    d.this.eeL.M(i, i2, i3);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.f.a
            public void onError(int i, String str) {
                d.this.Vd();
                if (i != 1) {
                    d.this.ebl.setVisibility(8);
                    d.this.showNetRefreshView(d.this, str, true);
                } else if (j.oJ()) {
                    d.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.f.a
            public void onSuccess() {
                d.this.ebl.setVisibility(0);
                d.this.Vd();
                d.this.WG();
                FloatInfo aBD = d.this.eeM.aBD();
                if (aBD != null) {
                    d.this.eeQ.setData(aBD);
                    d.this.eeQ.setVisibility(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_quiz_floating_switch", 0L) != aBD.start_time.longValue() ? 0 : 8);
                    return;
                }
                d.this.eeQ.setVisibility(8);
            }
        };
        this.dCG = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.d.3
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
                                d.this.aBq();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.ebG = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.VX();
            }
        };
        this.dCJ = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.d.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        d.this.dCi = true;
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.ebl = new BdTypeListView(context);
        this.ebl.setDividerHeight(0);
        this.ebl.setSelector(17170445);
        this.bYZ = new PbListView(context);
        this.bYZ.getView();
        this.bYZ.gu(d.C0108d.cp_bg_line_e);
        this.bYZ.DJ();
        this.bYZ.setTextColor(aj.getColor(d.C0108d.cp_cont_j));
        this.bYZ.setTextSize(d.e.tbfontsize33);
        this.bYZ.gt(d.C0108d.cp_cont_e);
        this.bYZ.setHeight(com.baidu.adp.lib.util.l.s(context, d.e.tbds182));
        this.bYZ.setOnClickListener(this.ebG);
        this.ebl.setNextPage(this.bYZ);
        com.baidu.adp.base.e<?> ak = i.ak(context);
        if (ak instanceof TbPageContext) {
            this.pageContext = (TbPageContext) ak;
        }
        this.mPullView = new k(this.pageContext);
        this.ebl.setPullRefresh(this.mPullView);
        this.mPullView.aD(true);
        this.dDl = BdListViewHelper.a(context, this.ebl, BdListViewHelper.HeadType.DEFAULT);
        this.eeO = new com.baidu.tieba.homepage.personalize.model.e();
        this.eeK = new l(context, this.ebl);
        this.eeK.b(this.eeO);
        this.eeK.setCardShowType(TbadkCoreApplication.getInst().getCardShowType());
        this.eeM = new f(this.pageContext, this.ebl, this.eeK);
        this.eeN = new a(this.pageContext);
        addView(this.ebl);
        this.eeQ = new com.baidu.tieba.homepage.personalize.view.b(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(com.baidu.adp.lib.util.l.s(context, d.e.tbds182), com.baidu.adp.lib.util.l.s(context, d.e.tbds182));
        layoutParams.gravity = 85;
        layoutParams.rightMargin = com.baidu.adp.lib.util.l.s(context, d.e.tbds18);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.l.s(context, d.e.tbds238);
        addView(this.eeQ, layoutParams);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        MessageManager.getInstance().registerListener(this.dCJ);
        this.eeQ.setCallback(new b.a() { // from class: com.baidu.tieba.homepage.personalize.d.7
            @Override // com.baidu.tieba.homepage.personalize.view.b.a
            public void aBr() {
                TiebaStatic.log(new ak("c12913").s("obj_locate", 2));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaQuestionHomeActivityConfig(d.this.getContext())));
            }

            @Override // com.baidu.tieba.homepage.personalize.view.b.a
            public void aBs() {
                TiebaStatic.log(new ak("c12913").s("obj_locate", 3));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_quiz_floating_switch", d.this.eeM.aBD() == null ? 0L : d.this.eeM.aBD().start_time.longValue());
                d.this.eeQ.setVisibility(8);
                com.baidu.adp.lib.util.l.showToast(d.this.getContext(), d.j.quiz_entrance_close_tips);
            }
        });
        this.eeQ.setVisibility(8);
    }

    public void axh() {
        this.eeK.a(this.eeS);
        this.eeM.a(this.eeT);
        this.eeN.a(this);
        this.mPullView.a(new j.b() { // from class: com.baidu.tieba.homepage.personalize.d.8
            @Override // com.baidu.tbadk.core.view.j.b
            public void onListPullRefresh(boolean z) {
                d.this.eeK.setCardShowType(TbadkCoreApplication.getInst().getCardShowType());
                d.this.eeM.update();
            }
        });
        this.mPullView.a(new j.c() { // from class: com.baidu.tieba.homepage.personalize.d.9
            @Override // com.baidu.tbadk.core.view.j.c
            public void bs(boolean z) {
                if (d.this.eeM != null) {
                    if (d.this.eeM.auE() != null) {
                        d.this.eeM.auE().aCG();
                    }
                    d.this.eeM.gG(false);
                }
            }
        });
        this.ebl.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.personalize.d.10
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                d.this.VX();
            }
        });
        this.ebl.setOnScrollStopDelayedListener(new BdListView.d() { // from class: com.baidu.tieba.homepage.personalize.d.11
            @Override // com.baidu.adp.widget.ListView.BdListView.d
            public void onScrollStop(int i, int i2) {
                if (System.currentTimeMillis() - d.this.eeP >= TbConfig.NOTIFY_SOUND_INTERVAL) {
                    d.this.eeM.bP(i, i2);
                }
            }
        }, 1L);
        this.mPullView.a(new j.a() { // from class: com.baidu.tieba.homepage.personalize.d.12
            @Override // com.baidu.tbadk.core.view.j.a
            public void i(View view, boolean z) {
                if (d.this.eeM != null) {
                    d.this.eeM.gG(true);
                    d.this.eeM.aBw();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
            }
        });
        this.ebl.setRecyclerListener(new AbsListView.RecyclerListener() { // from class: com.baidu.tieba.homepage.personalize.d.13
            @Override // android.widget.AbsListView.RecyclerListener
            public void onMovedToScrapHeap(View view) {
                if (view != null) {
                    if (d.this.eeM != null && d.this.eeM.auE() != null) {
                        d.this.eeM.auE().ch(view);
                    }
                    if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.d) {
                        ((com.baidu.tieba.homepage.personalize.a.d) view.getTag()).alp().stopPlay();
                    }
                }
            }
        });
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.eeL = bVar;
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        if (this.bYZ != null) {
            this.bYZ.DN();
            this.bYZ.gw(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.eeM.a(z, z2, dataRes, 0, null);
    }

    public void setIsUnreadTipShow(boolean z) {
        if (this.eeM != null) {
            this.eeM.gE(!z);
        }
        this.eeR = z;
    }

    public boolean getIsUnreadTipShow() {
        return this.eeR;
    }

    public void e(Long l) {
        this.eeM.e(l);
    }

    public void setHeaderViewHeight(int i) {
        if (this.dDl != null && this.dDl.getLayoutParams() != null) {
            if (this.eeM != null) {
                this.eeM.setHeaderViewHeight(i);
            }
            if (this.eeN != null) {
                this.eeN.setHeaderViewHeight(i);
            }
            this.dDl.getLayoutParams().height = i;
            this.dDl.setLayoutParams(this.dDl.getLayoutParams());
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        if (this.eeM != null) {
            this.eeM.setRecommendFrsNavigationAnimDispatcher(sVar);
        }
    }

    public void showFloatingView() {
        if (this.eeM != null) {
            this.eeM.showFloatingView();
        }
    }

    public void aBp() {
        if (this.eeM != null) {
            this.eeM.aBp();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.bVd != null) {
                this.bVd.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.mPullView != null) {
                this.mPullView.gv(i);
            }
            if (this.bYZ != null) {
                this.bYZ.setTextColor(aj.getColor(d.C0108d.cp_cont_d));
                this.bYZ.gv(i);
            }
            this.eeK.onChangeSkinType(i);
            aj.t(this, d.C0108d.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void aa(String str, int i) {
        if (this.bYZ != null) {
            this.bYZ.DN();
            this.bYZ.gw(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.eeM.a(true, false, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.j.g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.eeM != null) {
                        d.this.eeM.update();
                    }
                }
            });
        }
        this.refreshView.id(getContext().getResources().getDimensionPixelSize(d.e.ds280));
        this.refreshView.gN(str);
        this.refreshView.j(view, z);
        this.refreshView.Ml();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WG() {
        if (this.refreshView != null) {
            this.refreshView.bk(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vd() {
        if (this.bVd != null) {
            this.bVd.bk(this);
            this.bVd = null;
            this.ebl.setNextPage(this.bYZ);
        }
        if (this.eeL != null) {
            this.eeL.aBa();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aAM() {
        if (this.refreshView != null) {
            return this.refreshView.Md();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(boolean z, int i) {
        if (this.bVd == null) {
            if (i < 0) {
                this.bVd = new com.baidu.tbadk.j.f(getContext());
            } else {
                this.bVd = new com.baidu.tbadk.j.f(getContext(), i);
            }
            this.bVd.onChangeSkinType();
        }
        this.bVd.j(this, z);
        this.ebl.setNextPage(null);
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.eeM != null) {
            this.eeM.setTabInForeBackgroundState(z);
        }
    }

    public void aAO() {
        setViewForeground(false);
        if (this.eeM != null) {
            this.eeM.fK(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("show_is_uninterest_tag", 0);
        if (i < 1 && TbadkCoreApplication.getInst().isNoInterestTag() && this.pageContext != null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("show_is_uninterest_tag", i + 1);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(this.pageContext.getContext(), 2)));
        }
    }

    public void setViewForeground(boolean z) {
        if (this.eeM != null) {
            this.eeM.gz(z);
        }
    }

    public void aAK() {
        if (this.eeM != null) {
            j(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
            this.eeM.update();
        }
    }

    public void reload() {
        if (this.ebl != null) {
            showFloatingView();
            this.ebl.setSelection(0);
            if (this.ebl.isRefreshDone()) {
                if (this.eeM != null && this.eeM.auE() != null) {
                    this.eeM.auE().aCG();
                    this.eeM.gG(false);
                }
                this.ebl.startPullRefresh();
            }
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dCJ);
        this.eeM.onDestroy();
        this.eeK.a((c.a) null);
        this.eeM.a((f.a) null);
        this.mPullView.a((j.b) null);
        this.mPullView.a((j.c) null);
        this.ebl.setOnSrollToBottomListener(null);
        this.mPullView.a((j.a) null);
        this.mPullView.release();
        if (this.bVd != null) {
            this.bVd.release();
        }
        this.ebl.setRecyclerListener(null);
        if (this.eeN != null) {
            this.eeN.onDestroy();
        }
    }

    public void onPause() {
        this.eeM.onPause();
    }

    public void onResume() {
        this.eeM.onResume();
        if (this.dCi) {
            reload();
            this.dCi = false;
        }
    }

    public void aBq() {
        if (this.eeK != null) {
            this.eeK.notifyDataSetChanged();
        }
    }

    public void aAP() {
        if (this.eeM != null) {
            this.eeM.fK(true);
        }
        com.baidu.tieba.card.s.akK().dg(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void aBn() {
        this.eeM.aBC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VX() {
        if (this.bYZ != null && !this.bYZ.DR()) {
            this.bYZ.DM();
            this.bYZ.gw(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.eeM.VX();
    }
}
