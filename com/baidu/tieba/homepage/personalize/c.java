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
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LabelRecommendActivityConfig;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.s;
import com.baidu.tieba.NEGFeedBack.c;
import com.baidu.tieba.card.u;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.a.l;
import com.baidu.tieba.homepage.personalize.e;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class c extends FrameLayout {
    private BdTypeListView aUn;
    private com.baidu.tbadk.k.f bed;
    private PbListView bgE;
    private final CustomMessageListener cyD;
    private CustomMessageListener cyG;
    private boolean cyg;
    private View czh;
    private View.OnClickListener ddJ;
    private l dgH;
    private com.baidu.tieba.homepage.framework.b dgI;
    private e dgJ;
    private com.baidu.tieba.homepage.personalize.model.e dgK;
    private long dgL;
    private c.a dgM;
    private e.a dgN;
    private h mPullView;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private g refreshView;

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.dgJ != null) {
            this.dgJ.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void completePullRefresh() {
        if (this.aUn != null) {
            this.aUn.completePullRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dgH != null) {
            this.dgH.setPageUniqueId(bdUniqueId);
        }
        if (this.dgJ != null) {
            this.dgJ.k(bdUniqueId);
        }
        if (this.dgK != null) {
            this.dgK.o(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.cyD != null) {
            this.cyD.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cyD);
        }
    }

    public c(Context context) {
        super(context);
        this.dgL = 0L;
        this.mSkinType = 3;
        this.cyg = false;
        this.dgM = new c.a() { // from class: com.baidu.tieba.homepage.personalize.c.1
            @Override // com.baidu.tieba.NEGFeedBack.c.a
            public void a(al alVar) {
                if (alVar != null) {
                    TiebaStatic.log(new ak("c11693").ac("obj_locate", "1").ac(ImageViewerConfig.FORUM_ID, alVar.getFid()).ac("tid", alVar.getTid()).ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
                    TiebaStatic.log(new ak("c11989").ac(ImageViewerConfig.FORUM_ID, alVar.getFid()).ac("tid", alVar.getTid()).ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
                }
            }

            @Override // com.baidu.tieba.NEGFeedBack.c.a
            public void a(al alVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.c.a
            public void a(ArrayList<Integer> arrayList, al alVar) {
                if (arrayList != null && alVar != null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < arrayList.size(); i++) {
                        sb.append(arrayList.get(i) + Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    TiebaStatic.log(new ak("c11693").ac("obj_locate", sb.toString()).ac(ImageViewerConfig.FORUM_ID, alVar.getFid()).ac("tid", alVar.getTid()).ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
                }
            }
        };
        this.dgN = new e.a() { // from class: com.baidu.tieba.homepage.personalize.c.5
            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void aP(int i, int i2) {
                if (c.this.dgI == null) {
                    c.this.showNetRefreshView(c.this, TbadkCoreApplication.getInst().getString(d.j.neterror), true);
                    c.this.MZ();
                    return;
                }
                boolean ari = c.this.ari();
                c.this.Oc();
                if (ari) {
                    c.this.g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
                }
                c.this.dgI.aO(i, i2);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void D(int i, int i2, int i3) {
                if (c.this.dgI != null) {
                    c.this.dgI.C(i, i2, i3);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                c.this.MZ();
                if (i != 1) {
                    c.this.aUn.setVisibility(8);
                    c.this.showNetRefreshView(c.this, str, true);
                } else if (j.hh()) {
                    c.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                c.this.aUn.setVisibility(0);
                c.this.MZ();
                c.this.Oc();
            }
        };
        this.cyD = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.c.2
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
                                c.this.arO();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.ddJ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.NF();
            }
        };
        this.cyG = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        c.this.cyg = true;
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.aUn = new BdTypeListView(context);
        this.aUn.setDividerHeight(0);
        this.aUn.setSelector(17170445);
        this.bgE = new PbListView(context);
        this.bgE.getView();
        this.bgE.dy(d.C0080d.cp_bg_line_d);
        this.bgE.wq();
        this.bgE.setTextColor(aj.getColor(d.C0080d.cp_cont_d));
        this.bgE.dx(d.C0080d.cp_cont_e);
        this.bgE.setHeight(com.baidu.adp.lib.util.l.f(context, d.e.ds140));
        this.bgE.setOnClickListener(this.ddJ);
        this.aUn.setNextPage(this.bgE);
        com.baidu.adp.base.e<?> Y = i.Y(context);
        if (Y instanceof TbPageContext) {
            this.pageContext = (TbPageContext) Y;
        }
        this.mPullView = new h(this.pageContext);
        this.aUn.setPullRefresh(this.mPullView);
        this.mPullView.W(true);
        this.czh = BdListViewHelper.a(context, this.aUn, BdListViewHelper.HeadType.DEFAULT);
        this.dgK = new com.baidu.tieba.homepage.personalize.model.e();
        this.dgH = new l(context, this.aUn);
        this.dgH.b(this.dgK);
        this.dgJ = new e(this.pageContext, this.aUn, this.dgH);
        addView(this.aUn);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        MessageManager.getInstance().registerListener(this.cyG);
    }

    public void amI() {
        this.dgH.a(this.dgM);
        this.dgJ.a(this.dgN);
        this.mPullView.a(new g.b() { // from class: com.baidu.tieba.homepage.personalize.c.6
            @Override // com.baidu.tbadk.core.view.g.b
            public void onListPullRefresh(boolean z) {
                c.this.dgJ.update();
            }
        });
        this.mPullView.a(new g.c() { // from class: com.baidu.tieba.homepage.personalize.c.7
            @Override // com.baidu.tbadk.core.view.g.c
            public void aK(boolean z) {
                if (c.this.dgJ != null) {
                    if (c.this.dgJ.ajv() != null) {
                        c.this.dgJ.ajv().atu();
                    }
                    c.this.dgJ.fA(false);
                }
            }
        });
        this.aUn.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.personalize.c.8
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                c.this.NF();
            }
        });
        this.aUn.setOnScrollStopDelayedListener(new BdListView.d() { // from class: com.baidu.tieba.homepage.personalize.c.9
            @Override // com.baidu.adp.widget.ListView.BdListView.d
            public void onScrollStop(int i, int i2) {
                if (System.currentTimeMillis() - c.this.dgL >= TbConfig.NOTIFY_SOUND_INTERVAL) {
                    c.this.dgJ.aQ(i, i2);
                }
            }
        }, 1L);
        this.mPullView.a(new g.a() { // from class: com.baidu.tieba.homepage.personalize.c.10
            @Override // com.baidu.tbadk.core.view.g.a
            public void b(View view, boolean z) {
                if (c.this.dgJ != null) {
                    c.this.dgJ.fA(true);
                    c.this.dgJ.arS();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
            }
        });
        this.aUn.setRecyclerListener(new AbsListView.RecyclerListener() { // from class: com.baidu.tieba.homepage.personalize.c.11
            @Override // android.widget.AbsListView.RecyclerListener
            public void onMovedToScrapHeap(View view) {
                if (view != null) {
                    if (c.this.dgJ != null && c.this.dgJ.ajv() != null) {
                        c.this.dgJ.ajv().aY(view);
                    }
                    if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.d) {
                        ((com.baidu.tieba.homepage.personalize.a.d) view.getTag()).aax().stopPlay();
                    }
                }
            }
        });
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.dgI = bVar;
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        if (this.bgE != null) {
            this.bgE.wu();
            this.bgE.dA(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dgJ.a(z, z2, dataRes, 0, null);
    }

    public void setHeaderViewHeight(int i) {
        if (this.czh != null && this.czh.getLayoutParams() != null) {
            if (this.dgJ != null) {
                this.dgJ.setHeaderViewHeight(i);
            }
            this.czh.getLayoutParams().height = i;
            this.czh.setLayoutParams(this.czh.getLayoutParams());
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        if (this.dgJ != null) {
            this.dgJ.setRecommendFrsNavigationAnimDispatcher(sVar);
        }
    }

    public void showFloatingView() {
        if (this.dgJ != null) {
            this.dgJ.showFloatingView();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.bed != null) {
                this.bed.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.mPullView != null) {
                this.mPullView.dz(i);
            }
            if (this.bgE != null) {
                this.bgE.setTextColor(aj.getColor(d.C0080d.cp_cont_d));
                this.bgE.dz(i);
            }
            this.dgH.onChangeSkinType(i);
            aj.k(this, d.C0080d.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void T(String str, int i) {
        if (this.bgE != null) {
            this.bgE.wu();
            this.bgE.dA(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dgJ.a(true, false, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.k.g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.c.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.dgJ != null) {
                        c.this.dgJ.update();
                    }
                }
            });
        }
        this.refreshView.fk(getContext().getResources().getDimensionPixelSize(d.e.ds280));
        this.refreshView.gy(str);
        this.refreshView.c(view, z);
        this.refreshView.EC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oc() {
        if (this.refreshView != null) {
            this.refreshView.O(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MZ() {
        if (this.bed != null) {
            this.bed.O(this);
            this.bed = null;
            this.aUn.setNextPage(this.bgE);
        }
        if (this.dgI != null) {
            this.dgI.ary();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ari() {
        if (this.refreshView != null) {
            return this.refreshView.Eu();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, int i) {
        if (this.bed == null) {
            if (i < 0) {
                this.bed = new com.baidu.tbadk.k.f(getContext());
            } else {
                this.bed = new com.baidu.tbadk.k.f(getContext(), i);
            }
            this.bed.onChangeSkinType();
        }
        this.bed.c(this, z);
        this.aUn.setNextPage(null);
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.dgJ != null) {
            this.dgJ.setTabInForeBackgroundState(z);
        }
    }

    public void ark() {
        setViewForeground(false);
        if (this.dgJ != null) {
            this.dgJ.eA(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("show_is_uninterest_tag", 0);
        if (i < 1 && TbadkCoreApplication.getInst().isNoInterestTag() && this.pageContext != null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("show_is_uninterest_tag", i + 1);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(this.pageContext.getContext(), 2)));
        }
    }

    public void setViewForeground(boolean z) {
        if (this.dgJ != null) {
            this.dgJ.fw(z);
        }
    }

    public void arg() {
        if (this.dgJ != null) {
            g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
            this.dgJ.update();
        }
    }

    public void reload() {
        if (this.aUn != null) {
            showFloatingView();
            this.aUn.setSelection(0);
            if (this.aUn.isRefreshDone()) {
                if (this.dgJ != null && this.dgJ.ajv() != null) {
                    this.dgJ.ajv().atu();
                    this.dgJ.fA(false);
                }
                this.aUn.startPullRefresh();
            }
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.cyG);
        this.dgJ.onDestroy();
        this.dgH.a((c.a) null);
        this.dgJ.a((e.a) null);
        this.mPullView.a((g.b) null);
        this.mPullView.a((g.c) null);
        this.aUn.setOnSrollToBottomListener(null);
        this.mPullView.a((g.a) null);
        this.mPullView.release();
        if (this.bed != null) {
            this.bed.release();
        }
        this.aUn.setRecyclerListener(null);
    }

    public void onPause() {
        this.dgJ.onPause();
    }

    public void onResume() {
        this.dgJ.onResume();
        if (this.cyg) {
            reload();
            this.cyg = false;
        }
    }

    public void arO() {
        if (this.dgH != null) {
            this.dgH.notifyDataSetChanged();
        }
    }

    public void arl() {
        if (this.dgJ != null) {
            this.dgJ.eA(true);
        }
        u.ZX().cv(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void arM() {
        this.dgJ.arY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NF() {
        if (this.bgE != null && !this.bgE.wz()) {
            this.bgE.wt();
            this.bgE.dA(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dgJ.NF();
    }
}
