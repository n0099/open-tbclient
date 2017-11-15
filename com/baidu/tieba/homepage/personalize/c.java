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
    private BdTypeListView aUv;
    private com.baidu.tbadk.k.f bem;
    private PbListView bgN;
    private final CustomMessageListener cyW;
    private CustomMessageListener cyZ;
    private boolean cyz;
    private View czA;
    private View.OnClickListener ded;
    private l dhb;
    private com.baidu.tieba.homepage.framework.b dhc;
    private e dhd;
    private com.baidu.tieba.homepage.personalize.model.e dhe;
    private long dhf;
    private c.a dhg;
    private e.a dhh;
    private h mPullView;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private g refreshView;

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.dhd != null) {
            this.dhd.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void completePullRefresh() {
        if (this.aUv != null) {
            this.aUv.completePullRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dhb != null) {
            this.dhb.setPageUniqueId(bdUniqueId);
        }
        if (this.dhd != null) {
            this.dhd.k(bdUniqueId);
        }
        if (this.dhe != null) {
            this.dhe.o(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.cyW != null) {
            this.cyW.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cyW);
        }
    }

    public c(Context context) {
        super(context);
        this.dhf = 0L;
        this.mSkinType = 3;
        this.cyz = false;
        this.dhg = new c.a() { // from class: com.baidu.tieba.homepage.personalize.c.1
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
        this.dhh = new e.a() { // from class: com.baidu.tieba.homepage.personalize.c.5
            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void aP(int i, int i2) {
                if (c.this.dhc == null) {
                    c.this.showNetRefreshView(c.this, TbadkCoreApplication.getInst().getString(d.j.neterror), true);
                    c.this.Nk();
                    return;
                }
                boolean ary = c.this.ary();
                c.this.On();
                if (ary) {
                    c.this.g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
                }
                c.this.dhc.aO(i, i2);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void D(int i, int i2, int i3) {
                if (c.this.dhc != null) {
                    c.this.dhc.C(i, i2, i3);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                c.this.Nk();
                if (i != 1) {
                    c.this.aUv.setVisibility(8);
                    c.this.showNetRefreshView(c.this, str, true);
                } else if (j.hh()) {
                    c.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                c.this.aUv.setVisibility(0);
                c.this.Nk();
                c.this.On();
            }
        };
        this.cyW = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.c.2
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
                                c.this.asf();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.ded = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.NQ();
            }
        };
        this.cyZ = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        c.this.cyz = true;
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.aUv = new BdTypeListView(context);
        this.aUv.setDividerHeight(0);
        this.aUv.setSelector(17170445);
        this.bgN = new PbListView(context);
        this.bgN.getView();
        this.bgN.dx(d.C0080d.cp_bg_line_d);
        this.bgN.wq();
        this.bgN.setTextColor(aj.getColor(d.C0080d.cp_cont_d));
        this.bgN.dw(d.C0080d.cp_cont_e);
        this.bgN.setHeight(com.baidu.adp.lib.util.l.f(context, d.e.ds140));
        this.bgN.setOnClickListener(this.ded);
        this.aUv.setNextPage(this.bgN);
        com.baidu.adp.base.e<?> Y = i.Y(context);
        if (Y instanceof TbPageContext) {
            this.pageContext = (TbPageContext) Y;
        }
        this.mPullView = new h(this.pageContext);
        this.aUv.setPullRefresh(this.mPullView);
        this.mPullView.W(true);
        this.czA = BdListViewHelper.a(context, this.aUv, BdListViewHelper.HeadType.DEFAULT);
        this.dhe = new com.baidu.tieba.homepage.personalize.model.e();
        this.dhb = new l(context, this.aUv);
        this.dhb.b(this.dhe);
        this.dhd = new e(this.pageContext, this.aUv, this.dhb);
        addView(this.aUv);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        MessageManager.getInstance().registerListener(this.cyZ);
    }

    public void amW() {
        this.dhb.a(this.dhg);
        this.dhd.a(this.dhh);
        this.mPullView.a(new g.b() { // from class: com.baidu.tieba.homepage.personalize.c.6
            @Override // com.baidu.tbadk.core.view.g.b
            public void onListPullRefresh(boolean z) {
                c.this.dhd.update();
            }
        });
        this.mPullView.a(new g.c() { // from class: com.baidu.tieba.homepage.personalize.c.7
            @Override // com.baidu.tbadk.core.view.g.c
            public void aK(boolean z) {
                if (c.this.dhd != null) {
                    if (c.this.dhd.ajJ() != null) {
                        c.this.dhd.ajJ().atL();
                    }
                    c.this.dhd.fG(false);
                }
            }
        });
        this.aUv.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.personalize.c.8
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                c.this.NQ();
            }
        });
        this.aUv.setOnScrollStopDelayedListener(new BdListView.d() { // from class: com.baidu.tieba.homepage.personalize.c.9
            @Override // com.baidu.adp.widget.ListView.BdListView.d
            public void onScrollStop(int i, int i2) {
                if (System.currentTimeMillis() - c.this.dhf >= TbConfig.NOTIFY_SOUND_INTERVAL) {
                    c.this.dhd.aQ(i, i2);
                }
            }
        }, 1L);
        this.mPullView.a(new g.a() { // from class: com.baidu.tieba.homepage.personalize.c.10
            @Override // com.baidu.tbadk.core.view.g.a
            public void b(View view, boolean z) {
                if (c.this.dhd != null) {
                    c.this.dhd.fG(true);
                    c.this.dhd.asj();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
            }
        });
        this.aUv.setRecyclerListener(new AbsListView.RecyclerListener() { // from class: com.baidu.tieba.homepage.personalize.c.11
            @Override // android.widget.AbsListView.RecyclerListener
            public void onMovedToScrapHeap(View view) {
                if (view != null) {
                    if (c.this.dhd != null && c.this.dhd.ajJ() != null) {
                        c.this.dhd.ajJ().aZ(view);
                    }
                    if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.d) {
                        ((com.baidu.tieba.homepage.personalize.a.d) view.getTag()).aaJ().stopPlay();
                    }
                }
            }
        });
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.dhc = bVar;
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        if (this.bgN != null) {
            this.bgN.wu();
            this.bgN.dz(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dhd.a(z, z2, dataRes, 0, null);
    }

    public void setHeaderViewHeight(int i) {
        if (this.czA != null && this.czA.getLayoutParams() != null) {
            if (this.dhd != null) {
                this.dhd.setHeaderViewHeight(i);
            }
            this.czA.getLayoutParams().height = i;
            this.czA.setLayoutParams(this.czA.getLayoutParams());
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        if (this.dhd != null) {
            this.dhd.setRecommendFrsNavigationAnimDispatcher(sVar);
        }
    }

    public void showFloatingView() {
        if (this.dhd != null) {
            this.dhd.showFloatingView();
        }
    }

    public void ase() {
        if (this.dhd != null) {
            this.dhd.ase();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.bem != null) {
                this.bem.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.mPullView != null) {
                this.mPullView.dy(i);
            }
            if (this.bgN != null) {
                this.bgN.setTextColor(aj.getColor(d.C0080d.cp_cont_d));
                this.bgN.dy(i);
            }
            this.dhb.onChangeSkinType(i);
            aj.k(this, d.C0080d.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void T(String str, int i) {
        if (this.bgN != null) {
            this.bgN.wu();
            this.bgN.dz(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dhd.a(true, false, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.k.g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.c.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.dhd != null) {
                        c.this.dhd.update();
                    }
                }
            });
        }
        this.refreshView.fj(getContext().getResources().getDimensionPixelSize(d.e.ds280));
        this.refreshView.gz(str);
        this.refreshView.c(view, z);
        this.refreshView.EO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void On() {
        if (this.refreshView != null) {
            this.refreshView.O(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nk() {
        if (this.bem != null) {
            this.bem.O(this);
            this.bem = null;
            this.aUv.setNextPage(this.bgN);
        }
        if (this.dhc != null) {
            this.dhc.arO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ary() {
        if (this.refreshView != null) {
            return this.refreshView.EG();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, int i) {
        if (this.bem == null) {
            if (i < 0) {
                this.bem = new com.baidu.tbadk.k.f(getContext());
            } else {
                this.bem = new com.baidu.tbadk.k.f(getContext(), i);
            }
            this.bem.onChangeSkinType();
        }
        this.bem.c(this, z);
        this.aUv.setNextPage(null);
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.dhd != null) {
            this.dhd.setTabInForeBackgroundState(z);
        }
    }

    public void arA() {
        setViewForeground(false);
        if (this.dhd != null) {
            this.dhd.eF(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("show_is_uninterest_tag", 0);
        if (i < 1 && TbadkCoreApplication.getInst().isNoInterestTag() && this.pageContext != null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("show_is_uninterest_tag", i + 1);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(this.pageContext.getContext(), 2)));
        }
    }

    public void setViewForeground(boolean z) {
        if (this.dhd != null) {
            this.dhd.fC(z);
        }
    }

    public void arw() {
        if (this.dhd != null) {
            g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
            this.dhd.update();
        }
    }

    public void reload() {
        if (this.aUv != null) {
            showFloatingView();
            this.aUv.setSelection(0);
            if (this.aUv.isRefreshDone()) {
                if (this.dhd != null && this.dhd.ajJ() != null) {
                    this.dhd.ajJ().atL();
                    this.dhd.fG(false);
                }
                this.aUv.startPullRefresh();
            }
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.cyZ);
        this.dhd.onDestroy();
        this.dhb.a((c.a) null);
        this.dhd.a((e.a) null);
        this.mPullView.a((g.b) null);
        this.mPullView.a((g.c) null);
        this.aUv.setOnSrollToBottomListener(null);
        this.mPullView.a((g.a) null);
        this.mPullView.release();
        if (this.bem != null) {
            this.bem.release();
        }
        this.aUv.setRecyclerListener(null);
    }

    public void onPause() {
        this.dhd.onPause();
    }

    public void onResume() {
        this.dhd.onResume();
        if (this.cyz) {
            reload();
            this.cyz = false;
        }
    }

    public void asf() {
        if (this.dhb != null) {
            this.dhb.notifyDataSetChanged();
        }
    }

    public void arB() {
        if (this.dhd != null) {
            this.dhd.eF(true);
        }
        u.aaj().cw(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void asc() {
        this.dhd.asp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NQ() {
        if (this.bgN != null && !this.bgN.wz()) {
            this.bgN.wt();
            this.bgN.dz(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dhd.NQ();
    }
}
