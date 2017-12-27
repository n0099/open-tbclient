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
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LabelRecommendActivityConfig;
import com.baidu.tbadk.core.data.ai;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.i;
import com.baidu.tbadk.core.view.j;
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
/* loaded from: classes2.dex */
public class d extends FrameLayout {
    private com.baidu.tbadk.j.f bUO;
    private PbListView bYK;
    private BdTypeListView dZF;
    private final CustomMessageListener dxK;
    private CustomMessageListener dxN;
    private boolean dxm;
    private View dyp;
    private View.OnClickListener eab;
    private k ede;
    private com.baidu.tieba.homepage.framework.b edf;
    private f edg;
    private a edh;
    private com.baidu.tieba.homepage.personalize.model.e edi;
    private long edj;
    private boolean edk;
    private c.a edl;
    private f.a edm;
    private j mPullView;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private com.baidu.tbadk.j.g refreshView;

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.edg != null) {
            this.edg.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.edh != null) {
            this.edh.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void completePullRefresh() {
        if (this.dZF != null) {
            this.dZF.completePullRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.ede != null) {
            this.ede.setPageUniqueId(bdUniqueId);
        }
        if (this.edg != null) {
            this.edg.j(bdUniqueId);
        }
        if (this.edi != null) {
            this.edi.m(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.dxK != null) {
            this.dxK.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dxK);
        }
    }

    public d(Context context) {
        super(context);
        this.edj = 0L;
        this.mSkinType = 3;
        this.dxm = false;
        this.edk = false;
        this.edl = new c.a() { // from class: com.baidu.tieba.homepage.personalize.d.1
            @Override // com.baidu.tieba.NEGFeedBack.c.a
            public void a(ai aiVar) {
                if (aiVar != null) {
                    TiebaStatic.log(new ak("c11693").ab("obj_locate", "1").ab(ImageViewerConfig.FORUM_ID, aiVar.getFid()).ab("tid", aiVar.getTid()).ab("uid", TbadkCoreApplication.getCurrentAccount()));
                    TiebaStatic.log(new ak("c11989").ab(ImageViewerConfig.FORUM_ID, aiVar.getFid()).ab("tid", aiVar.getTid()).ab("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }

            @Override // com.baidu.tieba.NEGFeedBack.c.a
            public void a(ai aiVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.c.a
            public void a(ArrayList<Integer> arrayList, ai aiVar) {
                if (arrayList != null && aiVar != null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < arrayList.size(); i++) {
                        sb.append(arrayList.get(i) + Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    TiebaStatic.log(new ak("c11693").ab("obj_locate", sb.toString()).ab(ImageViewerConfig.FORUM_ID, aiVar.getFid()).ab("tid", aiVar.getTid()).ab("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }
        };
        this.edm = new f.a() { // from class: com.baidu.tieba.homepage.personalize.d.5
            @Override // com.baidu.tieba.homepage.personalize.f.a
            public void bO(int i, int i2) {
                if (d.this.edf == null) {
                    d.this.showNetRefreshView(d.this, TbadkCoreApplication.getInst().getString(d.j.neterror), true);
                    d.this.Vn();
                    return;
                }
                boolean aAF = d.this.aAF();
                d.this.WQ();
                if (aAF) {
                    d.this.j(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
                }
                d.this.edf.bN(i, i2);
            }

            @Override // com.baidu.tieba.homepage.personalize.f.a
            public void N(int i, int i2, int i3) {
                if (d.this.edf != null) {
                    d.this.edf.M(i, i2, i3);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.f.a
            public void onError(int i, String str) {
                d.this.Vn();
                if (i != 1) {
                    d.this.dZF.setVisibility(8);
                    d.this.showNetRefreshView(d.this, str, true);
                } else if (com.baidu.adp.lib.util.j.oI()) {
                    d.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.f.a
            public void onSuccess() {
                d.this.dZF.setVisibility(0);
                d.this.Vn();
                d.this.WQ();
            }
        };
        this.dxK = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.d.2
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
                        com.baidu.adp.lib.g.e.nr().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.d.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                d.this.aBj();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.eab = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.Wh();
            }
        };
        this.dxN = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.d.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        d.this.dxm = true;
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.dZF = new BdTypeListView(context);
        this.dZF.setDividerHeight(0);
        this.dZF.setSelector(17170445);
        this.bYK = new PbListView(context);
        this.bYK.getView();
        this.bYK.gx(d.C0108d.cp_bg_line_e);
        this.bYK.DQ();
        this.bYK.setTextColor(aj.getColor(d.C0108d.cp_cont_j));
        this.bYK.setTextSize(d.e.tbfontsize33);
        this.bYK.gw(d.C0108d.cp_cont_e);
        this.bYK.setHeight(l.s(context, d.e.tbds182));
        this.bYK.setOnClickListener(this.eab);
        this.dZF.setNextPage(this.bYK);
        com.baidu.adp.base.e<?> ak = i.ak(context);
        if (ak instanceof TbPageContext) {
            this.pageContext = (TbPageContext) ak;
        }
        this.mPullView = new j(this.pageContext);
        this.dZF.setPullRefresh(this.mPullView);
        this.mPullView.aC(true);
        this.dyp = BdListViewHelper.a(context, this.dZF, BdListViewHelper.HeadType.DEFAULT);
        this.edi = new com.baidu.tieba.homepage.personalize.model.e();
        this.ede = new k(context, this.dZF);
        this.ede.b(this.edi);
        this.edg = new f(this.pageContext, this.dZF, this.ede);
        this.edh = new a(this.pageContext);
        addView(this.dZF);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        MessageManager.getInstance().registerListener(this.dxN);
    }

    public void avZ() {
        this.ede.a(this.edl);
        this.edg.a(this.edm);
        this.edh.a(this);
        this.mPullView.a(new i.b() { // from class: com.baidu.tieba.homepage.personalize.d.6
            @Override // com.baidu.tbadk.core.view.i.b
            public void onListPullRefresh(boolean z) {
                d.this.edg.update();
            }
        });
        this.mPullView.a(new i.c() { // from class: com.baidu.tieba.homepage.personalize.d.7
            @Override // com.baidu.tbadk.core.view.i.c
            public void br(boolean z) {
                if (d.this.edg != null) {
                    if (d.this.edg.atw() != null) {
                        d.this.edg.atw().aCw();
                    }
                    d.this.edg.gA(false);
                }
            }
        });
        this.dZF.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.personalize.d.8
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                d.this.Wh();
            }
        });
        this.dZF.setOnScrollStopDelayedListener(new BdListView.d() { // from class: com.baidu.tieba.homepage.personalize.d.9
            @Override // com.baidu.adp.widget.ListView.BdListView.d
            public void onScrollStop(int i, int i2) {
                if (System.currentTimeMillis() - d.this.edj >= TbConfig.NOTIFY_SOUND_INTERVAL) {
                    d.this.edg.bP(i, i2);
                }
            }
        }, 1L);
        this.mPullView.a(new i.a() { // from class: com.baidu.tieba.homepage.personalize.d.10
            @Override // com.baidu.tbadk.core.view.i.a
            public void i(View view, boolean z) {
                if (d.this.edg != null) {
                    d.this.edg.gA(true);
                    d.this.edg.aBn();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
            }
        });
        this.dZF.setRecyclerListener(new AbsListView.RecyclerListener() { // from class: com.baidu.tieba.homepage.personalize.d.11
            @Override // android.widget.AbsListView.RecyclerListener
            public void onMovedToScrapHeap(View view) {
                if (view != null) {
                    if (d.this.edg != null && d.this.edg.atw() != null) {
                        d.this.edg.atw().cf(view);
                    }
                    if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.d) {
                        ((com.baidu.tieba.homepage.personalize.a.d) view.getTag()).akh().stopPlay();
                    }
                }
            }
        });
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.edf = bVar;
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        if (this.bYK != null) {
            this.bYK.DU();
            this.bYK.gz(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.edg.a(z, z2, dataRes, 0, null);
    }

    public void setIsUnreadTipShow(boolean z) {
        if (this.edg != null) {
            this.edg.gy(!z);
        }
        this.edk = z;
    }

    public boolean getIsUnreadTipShow() {
        return this.edk;
    }

    public void e(Long l) {
        this.edg.e(l);
    }

    public void setHeaderViewHeight(int i) {
        if (this.dyp != null && this.dyp.getLayoutParams() != null) {
            if (this.edg != null) {
                this.edg.setHeaderViewHeight(i);
            }
            if (this.edh != null) {
                this.edh.setHeaderViewHeight(i);
            }
            this.dyp.getLayoutParams().height = i;
            this.dyp.setLayoutParams(this.dyp.getLayoutParams());
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        if (this.edg != null) {
            this.edg.setRecommendFrsNavigationAnimDispatcher(sVar);
        }
    }

    public void showFloatingView() {
        if (this.edg != null) {
            this.edg.showFloatingView();
        }
    }

    public void aBi() {
        if (this.edg != null) {
            this.edg.aBi();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.bUO != null) {
                this.bUO.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.mPullView != null) {
                this.mPullView.gy(i);
            }
            if (this.bYK != null) {
                this.bYK.setTextColor(aj.getColor(d.C0108d.cp_cont_d));
                this.bYK.gy(i);
            }
            this.ede.onChangeSkinType(i);
            aj.t(this, d.C0108d.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void Y(String str, int i) {
        if (this.bYK != null) {
            this.bYK.DU();
            this.bYK.gz(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.edg.a(true, false, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.j.g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.d.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.edg != null) {
                        d.this.edg.update();
                    }
                }
            });
        }
        this.refreshView.ih(getContext().getResources().getDimensionPixelSize(d.e.ds280));
        this.refreshView.gE(str);
        this.refreshView.j(view, z);
        this.refreshView.Mv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WQ() {
        if (this.refreshView != null) {
            this.refreshView.bi(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vn() {
        if (this.bUO != null) {
            this.bUO.bi(this);
            this.bUO = null;
            this.dZF.setNextPage(this.bYK);
        }
        if (this.edf != null) {
            this.edf.aAT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aAF() {
        if (this.refreshView != null) {
            return this.refreshView.Mn();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(boolean z, int i) {
        if (this.bUO == null) {
            if (i < 0) {
                this.bUO = new com.baidu.tbadk.j.f(getContext());
            } else {
                this.bUO = new com.baidu.tbadk.j.f(getContext(), i);
            }
            this.bUO.onChangeSkinType();
        }
        this.bUO.j(this, z);
        this.dZF.setNextPage(null);
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.edg != null) {
            this.edg.setTabInForeBackgroundState(z);
        }
    }

    public void aAH() {
        setViewForeground(false);
        if (this.edg != null) {
            this.edg.fD(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("show_is_uninterest_tag", 0);
        if (i < 1 && TbadkCoreApplication.getInst().isNoInterestTag() && this.pageContext != null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("show_is_uninterest_tag", i + 1);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(this.pageContext.getContext(), 2)));
        }
    }

    public void setViewForeground(boolean z) {
        if (this.edg != null) {
            this.edg.gt(z);
        }
    }

    public void aAD() {
        if (this.edg != null) {
            j(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
            this.edg.update();
        }
    }

    public void reload() {
        if (this.dZF != null) {
            showFloatingView();
            this.dZF.setSelection(0);
            if (this.dZF.isRefreshDone()) {
                if (this.edg != null && this.edg.atw() != null) {
                    this.edg.atw().aCw();
                    this.edg.gA(false);
                }
                this.dZF.startPullRefresh();
            }
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dxN);
        this.edg.onDestroy();
        this.ede.a((c.a) null);
        this.edg.a((f.a) null);
        this.mPullView.a((i.b) null);
        this.mPullView.a((i.c) null);
        this.dZF.setOnSrollToBottomListener(null);
        this.mPullView.a((i.a) null);
        this.mPullView.release();
        if (this.bUO != null) {
            this.bUO.release();
        }
        this.dZF.setRecyclerListener(null);
        if (this.edh != null) {
            this.edh.onDestroy();
        }
    }

    public void onPause() {
        this.edg.onPause();
    }

    public void onResume() {
        this.edg.onResume();
        if (this.dxm) {
            reload();
            this.dxm = false;
        }
    }

    public void aBj() {
        if (this.ede != null) {
            this.ede.notifyDataSetChanged();
        }
    }

    public void aAI() {
        if (this.edg != null) {
            this.edg.fD(true);
        }
        com.baidu.tieba.card.s.ajC().df(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void aBg() {
        this.edg.aBt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wh() {
        if (this.bYK != null && !this.bYK.DY()) {
            this.bYK.DT();
            this.bYK.gz(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.edg.Wh();
    }
}
