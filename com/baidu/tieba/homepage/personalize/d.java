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
    private com.baidu.tbadk.j.f bUV;
    private PbListView bYR;
    private boolean dBN;
    private View dCQ;
    private final CustomMessageListener dCl;
    private CustomMessageListener dCo;
    private BdTypeListView eaQ;
    private View.OnClickListener ebl;
    private l eep;
    private com.baidu.tieba.homepage.framework.b eeq;
    private f eer;
    private a ees;
    private com.baidu.tieba.homepage.personalize.model.e eet;
    private long eeu;
    private com.baidu.tieba.homepage.personalize.view.b eev;
    private boolean eew;
    private c.a eex;
    private f.a eey;
    private k mPullView;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private com.baidu.tbadk.j.g refreshView;

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.eer != null) {
            this.eer.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.ees != null) {
            this.ees.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void completePullRefresh() {
        if (this.eaQ != null) {
            this.eaQ.completePullRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.eep != null) {
            this.eep.setPageUniqueId(bdUniqueId);
        }
        if (this.eer != null) {
            this.eer.j(bdUniqueId);
        }
        if (this.eet != null) {
            this.eet.m(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.dCl != null) {
            this.dCl.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dCl);
        }
    }

    public d(Context context) {
        super(context);
        this.eeu = 0L;
        this.mSkinType = 3;
        this.dBN = false;
        this.eew = false;
        this.eex = new c.a() { // from class: com.baidu.tieba.homepage.personalize.d.1
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
        this.eey = new f.a() { // from class: com.baidu.tieba.homepage.personalize.d.6
            @Override // com.baidu.tieba.homepage.personalize.f.a
            public void bO(int i, int i2) {
                if (d.this.eeq == null) {
                    d.this.showNetRefreshView(d.this, TbadkCoreApplication.getInst().getString(d.j.neterror), true);
                    d.this.Vb();
                    return;
                }
                boolean aAH = d.this.aAH();
                d.this.WE();
                if (aAH) {
                    d.this.j(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
                }
                d.this.eeq.bN(i, i2);
            }

            @Override // com.baidu.tieba.homepage.personalize.f.a
            public void N(int i, int i2, int i3) {
                if (d.this.eeq != null) {
                    d.this.eeq.M(i, i2, i3);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.f.a
            public void onError(int i, String str) {
                d.this.Vb();
                if (i != 1) {
                    d.this.eaQ.setVisibility(8);
                    d.this.showNetRefreshView(d.this, str, true);
                } else if (j.oI()) {
                    d.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.f.a
            public void onSuccess() {
                d.this.eaQ.setVisibility(0);
                d.this.Vb();
                d.this.WE();
                FloatInfo aBy = d.this.eer.aBy();
                if (aBy != null) {
                    d.this.eev.setData(aBy);
                    d.this.eev.setVisibility(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_quiz_floating_switch", 0L) != aBy.start_time.longValue() ? 0 : 8);
                    return;
                }
                d.this.eev.setVisibility(8);
            }
        };
        this.dCl = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.d.3
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
                        com.baidu.adp.lib.g.e.nr().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.d.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                d.this.aBl();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.ebl = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.VV();
            }
        };
        this.dCo = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.d.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        d.this.dBN = true;
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.eaQ = new BdTypeListView(context);
        this.eaQ.setDividerHeight(0);
        this.eaQ.setSelector(17170445);
        this.bYR = new PbListView(context);
        this.bYR.getView();
        this.bYR.gu(d.C0107d.cp_bg_line_e);
        this.bYR.DH();
        this.bYR.setTextColor(aj.getColor(d.C0107d.cp_cont_j));
        this.bYR.setTextSize(d.e.tbfontsize33);
        this.bYR.gt(d.C0107d.cp_cont_e);
        this.bYR.setHeight(com.baidu.adp.lib.util.l.s(context, d.e.tbds182));
        this.bYR.setOnClickListener(this.ebl);
        this.eaQ.setNextPage(this.bYR);
        com.baidu.adp.base.e<?> ak = i.ak(context);
        if (ak instanceof TbPageContext) {
            this.pageContext = (TbPageContext) ak;
        }
        this.mPullView = new k(this.pageContext);
        this.eaQ.setPullRefresh(this.mPullView);
        this.mPullView.aC(true);
        this.dCQ = BdListViewHelper.a(context, this.eaQ, BdListViewHelper.HeadType.DEFAULT);
        this.eet = new com.baidu.tieba.homepage.personalize.model.e();
        this.eep = new l(context, this.eaQ);
        this.eep.b(this.eet);
        this.eep.setCardShowType(TbadkCoreApplication.getInst().getCardShowType());
        this.eer = new f(this.pageContext, this.eaQ, this.eep);
        this.ees = new a(this.pageContext);
        addView(this.eaQ);
        this.eev = new com.baidu.tieba.homepage.personalize.view.b(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(com.baidu.adp.lib.util.l.s(context, d.e.tbds182), com.baidu.adp.lib.util.l.s(context, d.e.tbds182));
        layoutParams.gravity = 85;
        layoutParams.rightMargin = com.baidu.adp.lib.util.l.s(context, d.e.tbds18);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.l.s(context, d.e.tbds238);
        addView(this.eev, layoutParams);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        MessageManager.getInstance().registerListener(this.dCo);
        this.eev.setCallback(new b.a() { // from class: com.baidu.tieba.homepage.personalize.d.7
            @Override // com.baidu.tieba.homepage.personalize.view.b.a
            public void aBm() {
                TiebaStatic.log(new ak("c12913").s("obj_locate", 2));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaQuestionHomeActivityConfig(d.this.getContext())));
            }

            @Override // com.baidu.tieba.homepage.personalize.view.b.a
            public void aBn() {
                TiebaStatic.log(new ak("c12913").s("obj_locate", 3));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_quiz_floating_switch", d.this.eer.aBy() == null ? 0L : d.this.eer.aBy().start_time.longValue());
                d.this.eev.setVisibility(8);
                com.baidu.adp.lib.util.l.showToast(d.this.getContext(), d.j.quiz_entrance_close_tips);
            }
        });
        this.eev.setVisibility(8);
    }

    public void axc() {
        this.eep.a(this.eex);
        this.eer.a(this.eey);
        this.ees.a(this);
        this.mPullView.a(new j.b() { // from class: com.baidu.tieba.homepage.personalize.d.8
            @Override // com.baidu.tbadk.core.view.j.b
            public void onListPullRefresh(boolean z) {
                d.this.eep.setCardShowType(TbadkCoreApplication.getInst().getCardShowType());
                d.this.eer.update();
            }
        });
        this.mPullView.a(new j.c() { // from class: com.baidu.tieba.homepage.personalize.d.9
            @Override // com.baidu.tbadk.core.view.j.c
            public void br(boolean z) {
                if (d.this.eer != null) {
                    if (d.this.eer.auz() != null) {
                        d.this.eer.auz().aCB();
                    }
                    d.this.eer.gD(false);
                }
            }
        });
        this.eaQ.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.personalize.d.10
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                d.this.VV();
            }
        });
        this.eaQ.setOnScrollStopDelayedListener(new BdListView.d() { // from class: com.baidu.tieba.homepage.personalize.d.11
            @Override // com.baidu.adp.widget.ListView.BdListView.d
            public void onScrollStop(int i, int i2) {
                if (System.currentTimeMillis() - d.this.eeu >= TbConfig.NOTIFY_SOUND_INTERVAL) {
                    d.this.eer.bP(i, i2);
                }
            }
        }, 1L);
        this.mPullView.a(new j.a() { // from class: com.baidu.tieba.homepage.personalize.d.12
            @Override // com.baidu.tbadk.core.view.j.a
            public void i(View view, boolean z) {
                if (d.this.eer != null) {
                    d.this.eer.gD(true);
                    d.this.eer.aBr();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
            }
        });
        this.eaQ.setRecyclerListener(new AbsListView.RecyclerListener() { // from class: com.baidu.tieba.homepage.personalize.d.13
            @Override // android.widget.AbsListView.RecyclerListener
            public void onMovedToScrapHeap(View view) {
                if (view != null) {
                    if (d.this.eer != null && d.this.eer.auz() != null) {
                        d.this.eer.auz().ch(view);
                    }
                    if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.d) {
                        ((com.baidu.tieba.homepage.personalize.a.d) view.getTag()).alk().stopPlay();
                    }
                }
            }
        });
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.eeq = bVar;
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        if (this.bYR != null) {
            this.bYR.DL();
            this.bYR.gw(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.eer.a(z, z2, dataRes, 0, null);
    }

    public void setIsUnreadTipShow(boolean z) {
        if (this.eer != null) {
            this.eer.gB(!z);
        }
        this.eew = z;
    }

    public boolean getIsUnreadTipShow() {
        return this.eew;
    }

    public void e(Long l) {
        this.eer.e(l);
    }

    public void setHeaderViewHeight(int i) {
        if (this.dCQ != null && this.dCQ.getLayoutParams() != null) {
            if (this.eer != null) {
                this.eer.setHeaderViewHeight(i);
            }
            if (this.ees != null) {
                this.ees.setHeaderViewHeight(i);
            }
            this.dCQ.getLayoutParams().height = i;
            this.dCQ.setLayoutParams(this.dCQ.getLayoutParams());
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        if (this.eer != null) {
            this.eer.setRecommendFrsNavigationAnimDispatcher(sVar);
        }
    }

    public void showFloatingView() {
        if (this.eer != null) {
            this.eer.showFloatingView();
        }
    }

    public void aBk() {
        if (this.eer != null) {
            this.eer.aBk();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.bUV != null) {
                this.bUV.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.mPullView != null) {
                this.mPullView.gv(i);
            }
            if (this.bYR != null) {
                this.bYR.setTextColor(aj.getColor(d.C0107d.cp_cont_d));
                this.bYR.gv(i);
            }
            this.eep.onChangeSkinType(i);
            aj.t(this, d.C0107d.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void aa(String str, int i) {
        if (this.bYR != null) {
            this.bYR.DL();
            this.bYR.gw(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.eer.a(true, false, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.j.g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.eer != null) {
                        d.this.eer.update();
                    }
                }
            });
        }
        this.refreshView.id(getContext().getResources().getDimensionPixelSize(d.e.ds280));
        this.refreshView.gF(str);
        this.refreshView.j(view, z);
        this.refreshView.Mj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WE() {
        if (this.refreshView != null) {
            this.refreshView.bk(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vb() {
        if (this.bUV != null) {
            this.bUV.bk(this);
            this.bUV = null;
            this.eaQ.setNextPage(this.bYR);
        }
        if (this.eeq != null) {
            this.eeq.aAV();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aAH() {
        if (this.refreshView != null) {
            return this.refreshView.Mb();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(boolean z, int i) {
        if (this.bUV == null) {
            if (i < 0) {
                this.bUV = new com.baidu.tbadk.j.f(getContext());
            } else {
                this.bUV = new com.baidu.tbadk.j.f(getContext(), i);
            }
            this.bUV.onChangeSkinType();
        }
        this.bUV.j(this, z);
        this.eaQ.setNextPage(null);
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.eer != null) {
            this.eer.setTabInForeBackgroundState(z);
        }
    }

    public void aAJ() {
        setViewForeground(false);
        if (this.eer != null) {
            this.eer.fH(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("show_is_uninterest_tag", 0);
        if (i < 1 && TbadkCoreApplication.getInst().isNoInterestTag() && this.pageContext != null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("show_is_uninterest_tag", i + 1);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(this.pageContext.getContext(), 2)));
        }
    }

    public void setViewForeground(boolean z) {
        if (this.eer != null) {
            this.eer.gw(z);
        }
    }

    public void aAF() {
        if (this.eer != null) {
            j(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
            this.eer.update();
        }
    }

    public void reload() {
        if (this.eaQ != null) {
            showFloatingView();
            this.eaQ.setSelection(0);
            if (this.eaQ.isRefreshDone()) {
                if (this.eer != null && this.eer.auz() != null) {
                    this.eer.auz().aCB();
                    this.eer.gD(false);
                }
                this.eaQ.startPullRefresh();
            }
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dCo);
        this.eer.onDestroy();
        this.eep.a((c.a) null);
        this.eer.a((f.a) null);
        this.mPullView.a((j.b) null);
        this.mPullView.a((j.c) null);
        this.eaQ.setOnSrollToBottomListener(null);
        this.mPullView.a((j.a) null);
        this.mPullView.release();
        if (this.bUV != null) {
            this.bUV.release();
        }
        this.eaQ.setRecyclerListener(null);
        if (this.ees != null) {
            this.ees.onDestroy();
        }
    }

    public void onPause() {
        this.eer.onPause();
    }

    public void onResume() {
        this.eer.onResume();
        if (this.dBN) {
            reload();
            this.dBN = false;
        }
    }

    public void aBl() {
        if (this.eep != null) {
            this.eep.notifyDataSetChanged();
        }
    }

    public void aAK() {
        if (this.eer != null) {
            this.eer.fH(true);
        }
        com.baidu.tieba.card.s.akF().de(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void aBi() {
        this.eer.aBx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VV() {
        if (this.bYR != null && !this.bYR.DP()) {
            this.bYR.DK();
            this.bYR.gw(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.eer.VV();
    }
}
