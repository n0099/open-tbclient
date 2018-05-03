package com.baidu.tieba.frs.gametab;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.ActivityChooserView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.ab;
import com.baidu.tieba.frs.ai;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.tbadkCore.FRSPageSocketResponsedMessage;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsPageHttpResponseMessage;
import com.baidu.tieba.tbadkCore.i;
import com.sina.weibo.sdk.statistic.StatisticConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes2.dex */
public class c implements VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, FrsCommonImageLayout.c {
    private FragmentTabHost bgN;
    private FrameLayout bkN;
    private FrsActivity dkY;
    private FrsFragment dkZ;
    private com.baidu.tieba.write.c dla;
    private ImageView dlb;
    private i dlc;
    private ab dld;
    private int dlh;
    private ShareSuccessReplyToServerModel dli;
    private com.baidu.tieba.q.a dlj;
    private String mForumName;
    private boolean dle = false;
    private Handler mHandler = new Handler();
    private int dlf = 0;
    private com.baidu.adp.framework.listener.a dlk = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FRS_HTTP_CMD, 301001) { // from class: com.baidu.tieba.frs.gametab.c.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            i iVar = null;
            if (!c.this.dle && !responsedMessage.hasError()) {
                if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                    iVar = ((FrsPageHttpResponseMessage) responsedMessage).getResponseData();
                } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                    iVar = ((FRSPageSocketResponsedMessage) responsedMessage).getResponseData();
                }
                if (iVar != null) {
                    c.this.dle = true;
                    c.this.c(iVar);
                }
            }
        }
    };
    private CustomMessageListener dll = new CustomMessageListener(2001615) { // from class: com.baidu.tieba.frs.gametab.c.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!c.this.dle && customResponsedMessage != null && (customResponsedMessage.getData() instanceof i)) {
                i iVar = (i) customResponsedMessage.getData();
                if (iVar.aVq() != null && c.this.mForumName != null && c.this.mForumName.equals(iVar.aVq().getName())) {
                    c.this.c(iVar);
                }
            }
        }
    };
    private CustomMessageListener dlm = new CustomMessageListener(2921342) { // from class: com.baidu.tieba.frs.gametab.c.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.atw();
        }
    };
    private CustomMessageListener dln = new CustomMessageListener(2001627) { // from class: com.baidu.tieba.frs.gametab.c.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                int kO = c.this.kO(((Integer) customResponsedMessage.getData()).intValue());
                if (kO != -1 && c.this.bgN != null) {
                    c.this.bgN.setCurrentTab(kO);
                    if (c.this.kP(kO) != 1) {
                        c.this.dkZ.fq(false);
                    }
                }
            }
        }
    };
    private HttpMessageListener dlo = new HttpMessageListener(0) { // from class: com.baidu.tieba.frs.gametab.c.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && 1021074 == httpResponsedMessage.getCmd() && (httpResponsedMessage instanceof AlaGameTabGetNewNotifyResponsedMessage)) {
                List<a> newNotifyData = ((AlaGameTabGetNewNotifyResponsedMessage) httpResponsedMessage).getNewNotifyData();
                if (!v.w(newNotifyData)) {
                    for (a aVar : newNotifyData) {
                        if (aVar != null) {
                            for (int i = 0; i < c.this.dld.aqI().size(); i++) {
                                FragmentTabHost.b cw = c.this.bgN.cw(i);
                                if (cw.mType != 99 && cw.mType != 1 && cw.mType != c.this.bgN.getCurrentTabType() && cw.mType == aVar.getTabId() && aVar.atp() && cw.afI.gM(String.valueOf(cw.mType)) != null) {
                                    cw.afI.gM(String.valueOf(cw.mType)).f7view.setVisibility(0);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private Runnable dlp = new Runnable() { // from class: com.baidu.tieba.frs.gametab.c.11
        @Override // java.lang.Runnable
        public void run() {
            e.fw().removeCallbacks(this);
            c.this.att();
            e.fw().postDelayed(this, StatisticConfig.MIN_UPLOAD_INTERVAL);
        }
    };
    private String dlg = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_game_forem_tab_hot_point");

    public c(FrsActivity frsActivity) {
        this.dkY = frsActivity;
    }

    public void init(Bundle bundle) {
        this.dlk.getHttpMessageListener().setPriority(-1);
        this.dlk.getSocketMessageListener().setPriority(-1);
        this.dkY.registerListener(this.dll);
        this.dln.setSelfListener(true);
        this.dkY.registerListener(this.dln);
        this.dlm.setSelfListener(true);
        this.dkY.registerListener(this.dlm);
        if (bundle == null) {
            this.mForumName = this.dkY.getIntent().getStringExtra("name");
            this.dlf = this.dkY.getIntent().getIntExtra(FrsActivityConfig.FRS_GAME_DEFAULT_TAB_ID, 0);
        } else {
            this.mForumName = bundle.getString("name");
            this.dlf = bundle.getInt("default_tab_id", 0);
        }
        k(bundle);
        this.dli = new ShareSuccessReplyToServerModel();
        this.dkY.registerListener(this.dlk);
        this.dlj = new com.baidu.tieba.q.a(this.dkY.getPageContext());
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.mForumName);
        bundle.putInt("default_tab_id", this.dlf);
    }

    private void k(Bundle bundle) {
        if (this.dkZ == null) {
            this.dkZ = new FrsFragment();
            this.dkZ.setArguments(bundle);
        }
        FragmentManager supportFragmentManager = this.dkY.getSupportFragmentManager();
        if (!supportFragmentManager.isDestroyed()) {
            FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
            beginTransaction.add(16908290, this.dkZ);
            beginTransaction.commitAllowingStateLoss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(i iVar) {
        if (v.v(iVar.bqG()) > 0) {
            this.dlc = iVar;
            if (!this.dkY.isLoadingViewAttached() && this.bgN == null) {
                this.dkY.showLoadingView(this.dkY.findViewById(16908290));
            }
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.c.12
                @Override // java.lang.Runnable
                public void run() {
                    c.this.bl(c.this.dlc.bqG());
                }
            });
        } else if (this.bgN != null) {
            this.bkN.removeView(this.bgN);
            this.bgN = null;
            this.dld = null;
            if (this.dlb != null && this.dlb.getParent() != null) {
                ((ViewGroup) this.dlb.getParent()).removeView(this.dlb);
            }
            k((Bundle) null);
        }
    }

    private boolean atq() {
        FragmentManager supportFragmentManager = this.dkY.getSupportFragmentManager();
        try {
            supportFragmentManager.beginTransaction().remove(this.dkZ).commitAllowingStateLoss();
            supportFragmentManager.executePendingTransactions();
            return true;
        } catch (IllegalStateException e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bl(List<FrsTabInfo> list) {
        if (this.dkY.isLoadingViewAttached()) {
            this.dkY.hideLoadingView(this.dkY.findViewById(16908290));
        }
        if (this.bgN == null && atq()) {
            atr();
            bm(list);
        }
    }

    private void atr() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021074, TbConfig.SERVER_ADDRESS + "game/forum/getNewNotify");
        tbHttpMessageTask.setResponsedClass(AlaGameTabGetNewNotifyResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.dkY.registerListener(1021074, this.dlo);
    }

    private void bm(List<FrsTabInfo> list) {
        List list2;
        boolean z;
        if (!v.w(list)) {
            CustomMessageListener customMessageListener = new CustomMessageListener(2001616) { // from class: com.baidu.tieba.frs.gametab.c.13
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ab)) {
                        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(c.this.dlg, true)) {
                            e.fw().post(c.this.dlp);
                        }
                        c.this.atu();
                    }
                }
            };
            customMessageListener.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            customMessageListener.setSelfListener(true);
            this.dkY.registerListener(customMessageListener);
            ArrayList arrayList = new ArrayList();
            for (FrsTabInfo frsTabInfo : list) {
                if (frsTabInfo != null) {
                    Iterator it = arrayList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = false;
                            break;
                        }
                        FrsTabInfo frsTabInfo2 = (FrsTabInfo) it.next();
                        if (frsTabInfo2 != null && frsTabInfo2.tab_id == frsTabInfo.tab_id) {
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        arrayList.add(frsTabInfo);
                    }
                }
            }
            FrsTabInfo.Builder builder = new FrsTabInfo.Builder();
            builder.tab_id = 99;
            builder.tab_name = this.dkY.getResources().getString(d.k.send);
            builder.tab_type = 0;
            int v = v.v(arrayList);
            if (v > 4) {
                list2 = arrayList.subList(0, 4);
                list2.add(2, builder.build(false));
            } else if (v < 2) {
                arrayList.add(builder.build(false));
                list2 = arrayList;
            } else {
                arrayList.add(v / 2, builder.build(false));
                list2 = arrayList;
            }
            this.dld = new ab(this.dkY.getActivity(), list2);
            if (aoL() != null) {
                this.dld.setForumId(aoL().getForumId());
                this.dld.setForumName(aoL().getForumName());
                if (aoL().apE() != null && aoL().apE().aVq() != null) {
                    this.dld.setForumGameLabel(aoL().apE().aVq().getForumGameLabel());
                    this.dld.lM(aoL().apE().aVq().getSpecialForumType());
                }
            }
            new d(this.dkZ).a(this.dld);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001616, this.dld);
            CustomMessage customMessage = new CustomMessage(2001616);
            customMessage.setTag(this.dkY.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    private void ats() {
        int atz = atz();
        if (atz >= 0) {
            a(this.dkZ, atz);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void att() {
        if (this.dld != null && !TextUtils.isEmpty(this.dld.getForumId())) {
            HttpMessage httpMessage = new HttpMessage(1021074);
            httpMessage.addParam("forum_id", this.dlc.aVq().getId());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atu() {
        if (this.dld != null) {
            this.dld.aqJ();
            if (!v.w(this.dld.aoX())) {
                ats();
                if (this.bgN == null) {
                    this.bgN = new FragmentTabHost(this.dkY.getActivity());
                    this.bgN.setClipChildren(false);
                    this.bgN.setClipToPadding(false);
                    this.bgN.setup(this.dkY.getSupportFragmentManager());
                    this.bgN.getFragmentTabWidget().setAbsoluteWeight(true);
                    this.bgN.setShouldDrawIndicatorLine(false);
                    this.bgN.setShouldDrawTopLine(true);
                    this.bgN.setTabWidgetViewPadding(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds10), 0, 0);
                    this.bgN.aC(true);
                    this.bgN.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    this.bkN = new FrameLayout(this.dkY.getActivity());
                    this.bkN.setClipChildren(false);
                    this.bkN.setClipToPadding(false);
                    this.bkN.addView(this.bgN);
                    this.dkY.setContentView(this.bkN);
                    this.bgN.setOnTabSelectionListener(new FragmentTabHost.a() { // from class: com.baidu.tieba.frs.gametab.c.14
                        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
                        public void i(int i, boolean z) {
                            c.this.a(c.this.bgN.getCurrentFragment(), i);
                            if (c.this.kP(i) != 1) {
                                c.this.dkZ.fq(false);
                            }
                        }

                        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
                        public boolean j(int i, boolean z) {
                            String str = null;
                            FragmentTabHost.b cw = c.this.bgN.cw(i);
                            if (c.this.dlc != null && c.this.dlc.aVq() != null) {
                                str = c.this.dlc.aVq().getId();
                            }
                            if (cw.mType == 99) {
                                c.this.atx();
                                TiebaStatic.log(new al("c12342").r("obj_locate", c.this.c(c.this.bgN.cw(c.this.bgN.getCurrentTabIndex()))).ac(ImageViewerConfig.FORUM_ID, str));
                                TiebaStatic.log(new al("c12334").r("obj_locate", c.this.c(cw)).ac(ImageViewerConfig.FORUM_ID, str));
                                return false;
                            } else if (cw.mType != 5 || TbadkCoreApplication.isLogin()) {
                                TiebaStatic.log(new al("c12334").r("obj_locate", c.this.c(cw)).ac(ImageViewerConfig.FORUM_ID, str));
                                if (cw.afI.gM(String.valueOf(cw.mType)) != null) {
                                    if (!(cw.afI.gM(String.valueOf(cw.mType)).f7view.getVisibility() == 0)) {
                                        if (c.this.dlh == i) {
                                            c.this.b(cw);
                                        }
                                    } else {
                                        cw.afI.gM(String.valueOf(cw.mType)).f7view.setVisibility(8);
                                        c.this.b(cw);
                                    }
                                }
                                c.this.dlh = i;
                                return true;
                            } else {
                                az.aJ(c.this.dkY.getPageContext().getPageActivity());
                                return false;
                            }
                        }
                    });
                } else {
                    this.bgN.reset();
                }
                List<com.baidu.tbadk.mainTab.b> aoX = this.dld.aoX();
                List<FrsTabInfo> aqI = this.dld.aqI();
                if (aqI.size() == aoX.size()) {
                    int size = aqI.size();
                    for (int i = 0; i < size; i++) {
                        com.baidu.tbadk.mainTab.b bVar = aoX.get(i);
                        if (bVar != null) {
                            FrsTabInfo frsTabInfo = aqI.get(i);
                            if (frsTabInfo == null || TextUtils.isEmpty(frsTabInfo.tab_name)) {
                                a(bVar, bVar.Fy(), bVar.aT(this.dkY.getActivity()), null);
                            } else {
                                a(bVar, bVar.Fy(), bVar.aT(this.dkY.getActivity()), frsTabInfo.tab_name);
                            }
                        }
                    }
                } else {
                    for (com.baidu.tbadk.mainTab.b bVar2 : aoX) {
                        a(bVar2, bVar2.Fy(), bVar2.aT(this.dkY.getActivity()), null);
                    }
                }
                this.bgN.uw();
                this.bgN.cu(2);
                this.bgN.aB(true);
                this.bgN.setViewPagerScrollable(false);
                final int kO = kO(this.dlf);
                if (kO < 0) {
                    kO = kO(this.dlc.bqH());
                }
                if (kO < 0) {
                    kO = atz();
                }
                if (kO < 0) {
                    kO = 0;
                }
                this.dlf = kO;
                this.dlh = kO;
                this.bgN.setCurrentTab(kO);
                if (kP(kO) != 1) {
                    this.dkZ.fq(false);
                }
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.c.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.this.bgN != null) {
                            c.this.a(c.this.bgN.getCurrentFragment(), kO);
                        }
                    }
                });
                atv();
                this.bgN.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(FragmentTabHost.b bVar) {
        if (bVar.mType == 2) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsGameLive_2"));
        } else if (bVar.mType == 3) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsGoodsTab_3"));
        } else if (bVar.mType == 101) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsInfoTab_101"));
        } else if (bVar.mType == 305) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsRankList_305"));
        } else if (bVar.mType == 4) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsLiveLive_4"));
        } else if (bVar.mType == 1) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsGameLive_1"));
        } else if (bVar.mType == 5) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsLivePersonal_5"));
        } else if (bVar.mType == 8) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsGameLive_8"));
        } else if (bVar.mType == 9) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsGameLive_9"));
        } else if (bVar.mType == 11) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsGameRecommend_11"));
        }
    }

    private void atv() {
        if (this.bgN != null && this.bgN.cx(99) != null) {
            if (this.dlb == null || this.dlb.getParent() == null) {
                if (this.dlb == null) {
                    this.dlb = new ImageView(this.dkY.getActivity());
                }
                int e = l.e(this.dkY.getActivity(), d.e.ds80);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(e, e);
                layoutParams.gravity = 81;
                layoutParams.bottomMargin = l.e(this.dkY.getActivity(), d.e.ds5);
                this.dlb.setLayoutParams(layoutParams);
                ak.c(this.dlb, d.f.icon_tabbar_add_n);
                ak.i(this.dlb, d.f.icon_tabbar_chaticon_n);
                this.dlb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.c.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        String str = null;
                        c.this.atx();
                        if (c.this.bgN != null) {
                            if (c.this.dlc != null && c.this.dlc.aVq() != null) {
                                str = c.this.dlc.aVq().getId();
                            }
                            TiebaStatic.log(new al("c12342").r("obj_locate", c.this.c(c.this.bgN.cw(c.this.bgN.getCurrentTabIndex()))).ac(ImageViewerConfig.FORUM_ID, str));
                            TiebaStatic.log(new al("c12334").r("obj_locate", 99).ac(ImageViewerConfig.FORUM_ID, str));
                        }
                    }
                });
                if (this.dlb.getParent() == null) {
                    this.bkN.addView(this.dlb);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c(FragmentTabHost.b bVar) {
        if (bVar.mType == 101) {
            return 1;
        }
        if (bVar.mType == 1) {
            return 2;
        }
        if (bVar.mType == 2) {
            return 3;
        }
        if (bVar.mType == 3) {
            return 4;
        }
        if (bVar.mType == 99) {
            return 5;
        }
        if (bVar.mType == 4) {
            return 6;
        }
        if (bVar.mType == 305) {
            return 7;
        }
        if (bVar.mType == 5) {
            return 8;
        }
        if (bVar.mType == 11) {
            return 11;
        }
        if (bVar.mType == 9) {
            return 9;
        }
        return bVar.mType == 8 ? 10 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Fragment fragment, int i) {
        NavigationBar Rg;
        if ((fragment instanceof ai) && this.dlc != null && this.dlc.aVq() != null && (Rg = ((ai) fragment).Rg()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.dlc.aVq().getName(), 5, true, true) + this.dkY.getActivity().getString(d.k.forum));
            Rg.setCenterTextTitle(sb.toString());
        }
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator, String str) {
        boolean z = true;
        if (cVar != null) {
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.afJ = cVar.aIm;
            if (bVar2.afJ.getArguments() == null) {
                Bundle bundle = new Bundle();
                bundle.putString("name", this.dlc.aVq().getName());
                bundle.putString("from", this.dlc.aVq().getSpecialForumType());
                bundle.putString(ImageViewerConfig.FORUM_ID, this.dlc.aVq().getId());
                bVar2.afJ.setArguments(bundle);
            } else {
                bVar2.afJ.getArguments().putString(ImageViewerConfig.FORUM_ID, this.dlc.aVq().getId());
            }
            bVar2.mType = cVar.type;
            if (cVar.aIu == com.baidu.tbadk.mainTab.c.aIr && cVar.type == 99) {
                tbFragmentTabIndicator.setIconViewWithoutText(9, -((int) this.dkY.getResources().getDimension(d.e.ds12)));
            } else if (!TextUtils.isEmpty(str)) {
                tbFragmentTabIndicator.setText(str);
            } else {
                tbFragmentTabIndicator.setText(cVar.aIn);
            }
            tbFragmentTabIndicator.setTextSize(0, this.dkY.getResources().getDimension(d.e.ds30));
            tbFragmentTabIndicator.setTextColorResId(d.C0126d.s_game_frs_tabbar_text_color);
            tbFragmentTabIndicator.setCompoundDrawablesTopResId(cVar.aIo);
            tbFragmentTabIndicator.setContentTvTopMargin(this.dkY.getResources().getDimensionPixelSize(d.e.ds2));
            tbFragmentTabIndicator.dz(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            tbFragmentTabIndicator.setIsContentSelectBold(false);
            if (cVar.aIu != com.baidu.tbadk.mainTab.c.aIr || cVar.type != 99) {
                z = false;
            }
            if (!z && (tbFragmentTabIndicator instanceof FragmentTabIndicator)) {
                tbFragmentTabIndicator.a(String.valueOf(bVar2.mType), a((FragmentTabIndicator) tbFragmentTabIndicator));
            }
            bVar2.afI = tbFragmentTabIndicator;
            bVar2.afK = bVar;
            this.bgN.a(bVar2);
        }
    }

    private TbFragmentTabIndicator.a a(FragmentTabIndicator fragmentTabIndicator) {
        int dimensionPixelSize = this.dkY.getResources().getDimensionPixelSize(d.e.ds12);
        ImageView imageView = new ImageView(this.dkY);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        imageView.setImageResource(d.f.icon_frs_tab_new_notify_red_point);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        fragmentTabIndicator.setTipPosType(1);
        fragmentTabIndicator.setTipTopMargin(this.dkY.getResources().getDimensionPixelSize(d.e.ds12));
        aVar.aIH = fragmentTabIndicator;
        aVar.sU = this.dkY.getResources().getDimensionPixelSize(d.e.ds12);
        aVar.f7view = imageView;
        aVar.f7view.setVisibility(8);
        return aVar;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.dkZ instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.dkZ.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a ga(int i) {
        if (this.dkZ instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.dkZ.ga(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.dkZ instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.dkZ.a(bVar);
        }
    }

    public void onNewIntent(Intent intent) {
        if (this.dkZ != null) {
            this.dkZ.onNewIntent(intent);
        }
    }

    public void onResume() {
        if (this.bgN == null) {
            this.dkZ.setPrimary(true);
            return;
        }
        Fragment currentFragment = this.bgN.getCurrentFragment();
        if (currentFragment instanceof BaseFragment) {
            ((BaseFragment) currentFragment).setPrimary(true);
        }
    }

    public void onPause() {
        if (this.bgN == null) {
            this.dkZ.setPrimary(false);
            return;
        }
        Fragment currentFragment = this.bgN.getCurrentFragment();
        if (currentFragment instanceof BaseFragment) {
            ((BaseFragment) currentFragment).setPrimary(false);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bgN == null) {
            this.dkZ.onChangeSkinType(i);
        } else {
            this.bgN.aB(true);
            this.bgN.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.dlb != null) {
            ak.c(this.dlb, d.f.icon_tabbar_add_n);
            ak.i(this.dlb, d.f.icon_tabbar_chaticon_n);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.bgN != null && this.dla != null && this.dla.isShowing()) {
                this.dla.bBb();
            } else if (this.dkZ != null && this.dkZ.isAdded()) {
                if (this.dkZ.onKeyDown(i, keyEvent)) {
                    return true;
                }
                atw();
            } else {
                return this.dkY.b(i, keyEvent);
            }
            return false;
        }
        return this.dkY.b(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atw() {
        if (this.dlh != this.dlf && this.bgN != null) {
            this.bgN.setCurrentTab(this.dlf);
            if (kP(this.dlf) != 1) {
                this.dkZ.fq(false);
            }
            this.dlh = this.dlf;
            a(this.bgN.getCurrentFragment(), this.dlf);
            return;
        }
        this.dkZ.closeActivity();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        com.baidu.tbadk.coreExtra.c.d shareItem;
        if (this.bgN == null) {
            this.dkZ.onActivityResult(i, i2, intent);
        } else {
            this.bgN.getCurrentFragment().onActivityResult(i, i2, intent);
        }
        if (i2 == -1 && i == 24007) {
            int intExtra = intent.getIntExtra("extra_share_status", 2);
            int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
            if (intExtra == 1 && (shareItem = TbadkCoreApplication.getInst().getShareItem()) != null && shareItem.linkUrl != null && this.dli != null) {
                this.dli.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.frs.gametab.c.4
                    @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                    public void AF() {
                    }

                    @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                    public void a(final CustomDialogData customDialogData) {
                        e.fw().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.c.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (c.this.dkY != null) {
                                    com.baidu.tieba.pb.interactionpopupwindow.c.a(c.this.dkY.getPageContext(), customDialogData).show();
                                }
                            }
                        }, 1000L);
                    }
                });
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.bgN == null) {
            return this.dkZ.getVoiceManager();
        }
        Fragment currentFragment = this.bgN.getCurrentFragment();
        if (currentFragment instanceof VoiceManager.c) {
            return ((VoiceManager.c) currentFragment).getVoiceManager();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void atx() {
        if (az.aK(this.dkY) && !this.dlj.bvD() && !aty()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921032));
            if (this.dla == null) {
                this.dla = new com.baidu.tieba.write.c(this.dkY.getPageContext(), this.bkN, "frs");
                this.dla.uD("2");
            }
            this.dla.a(this.dkZ.apH());
            this.dla.nk(false);
        }
    }

    public boolean aty() {
        String fixedText;
        if (this.dkZ == null || !this.dkZ.isAdded() || this.dkZ.getPageContext() == null) {
            return false;
        }
        com.baidu.tieba.tbadkCore.l apE = this.dkZ.apE();
        if (apE == null) {
            return false;
        }
        if (az.aK(this.dkZ.getPageContext().getPageActivity())) {
            AntiData qT = apE.qT();
            if (qT != null) {
                if (a(qT.getBlock_stat(), qT.mFrsForbidenDialogInfo)) {
                    return true;
                }
                if (qT.getIfpost() == 0 && !StringUtils.isNull(qT.getForbid_info())) {
                    String forbid_info = qT.getForbid_info();
                    if (an.ek(forbid_info) > 14) {
                        forbid_info = an.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                    }
                    BdToast b = BdToast.b(this.dkZ.getPageContext().getPageActivity(), forbid_info, d.f.icon_toast_game_error);
                    b.O(1.25f);
                    b.tL();
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    private boolean a(int i, final BlockPopInfoData blockPopInfoData) {
        if (blockPopInfoData == null || blockPopInfoData.can_post.intValue() == 1 || !TbadkCoreApplication.isLogin()) {
            return false;
        }
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.dkZ.getResources().getString(d.k.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast b = BdToast.b(this.dkZ.getPageContext().getPageActivity(), string, d.f.icon_toast_game_error);
            b.O(1.25f);
            b.tL();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dkZ.getPageContext().getPageActivity());
        aVar.dc(an.getFixedText(string, 50, true));
        aVar.b(an.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.dkZ.getResources().getString(d.k.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.gametab.c.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (aVar2 != null) {
                    aVar2.dismiss();
                }
            }
        });
        if (!StringUtils.isNull(blockPopInfoData.ahead_info) && !StringUtils.isNull(blockPopInfoData.ahead_url)) {
            aVar.a(an.getFixedText(blockPopInfoData.ahead_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.gametab.c.6
                /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    ax.wg().c(c.this.dkZ.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.dkZ.getPageContext()).tD();
        return true;
    }

    private int atz() {
        if (this.dld == null) {
            return -1;
        }
        int v = v.v(this.dld.aqI());
        for (int i = 0; i < v; i++) {
            if (this.dld.aqI().get(i).tab_id.intValue() == 1) {
                return i;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int kO(int i) {
        if (this.dld == null) {
            return -1;
        }
        int v = v.v(this.dld.aqI());
        for (int i2 = 0; i2 < v; i2++) {
            if (this.dld.aqI().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int kP(int i) {
        if (this.dld != null && i < v.v(this.dld.aqI())) {
            return this.dld.aqI().get(i).tab_id.intValue();
        }
        return -1;
    }

    public FrsFragment aoL() {
        return this.dkZ;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> aoM() {
        if (this.bgN == null) {
            if (this.dkZ instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) this.dkZ).aoM();
            }
        } else {
            Fragment currentFragment = this.bgN.getCurrentFragment();
            if (currentFragment instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) currentFragment).aoM();
            }
        }
        return null;
    }

    public void onDestroy() {
        if (this.dkY.isLoadingViewAttached()) {
            this.dkY.hideLoadingView(this.dkY.findViewById(16908290));
        }
        if (this.dlp != null) {
            e.fw().removeCallbacks(this.dlp);
        }
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(this.dlg, false);
        if (this.dli != null) {
            this.dli.cancelLoadData();
        }
    }
}
