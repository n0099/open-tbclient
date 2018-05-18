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
    private FragmentTabHost bgO;
    private FrameLayout blc;
    private FrsActivity dmf;
    private FrsFragment dmg;
    private com.baidu.tieba.write.c dmh;
    private ImageView dmi;
    private i dmj;
    private ab dmk;
    private int dmo;
    private ShareSuccessReplyToServerModel dmp;
    private com.baidu.tieba.q.a dmq;
    private String mForumName;
    private boolean dml = false;
    private Handler mHandler = new Handler();
    private int dmm = 0;
    private com.baidu.adp.framework.listener.a dmr = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FRS_HTTP_CMD, 301001) { // from class: com.baidu.tieba.frs.gametab.c.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            i iVar = null;
            if (!c.this.dml && !responsedMessage.hasError()) {
                if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                    iVar = ((FrsPageHttpResponseMessage) responsedMessage).getResponseData();
                } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                    iVar = ((FRSPageSocketResponsedMessage) responsedMessage).getResponseData();
                }
                if (iVar != null) {
                    c.this.dml = true;
                    c.this.c(iVar);
                }
            }
        }
    };
    private CustomMessageListener dms = new CustomMessageListener(2001615) { // from class: com.baidu.tieba.frs.gametab.c.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!c.this.dml && customResponsedMessage != null && (customResponsedMessage.getData() instanceof i)) {
                i iVar = (i) customResponsedMessage.getData();
                if (iVar.aVq() != null && c.this.mForumName != null && c.this.mForumName.equals(iVar.aVq().getName())) {
                    c.this.c(iVar);
                }
            }
        }
    };
    private CustomMessageListener dmt = new CustomMessageListener(2921342) { // from class: com.baidu.tieba.frs.gametab.c.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.atv();
        }
    };
    private CustomMessageListener dmu = new CustomMessageListener(2001627) { // from class: com.baidu.tieba.frs.gametab.c.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                int kN = c.this.kN(((Integer) customResponsedMessage.getData()).intValue());
                if (kN != -1 && c.this.bgO != null) {
                    c.this.bgO.setCurrentTab(kN);
                    if (c.this.kO(kN) != 1) {
                        c.this.dmg.fr(false);
                    }
                }
            }
        }
    };
    private HttpMessageListener dmv = new HttpMessageListener(0) { // from class: com.baidu.tieba.frs.gametab.c.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && 1021074 == httpResponsedMessage.getCmd() && (httpResponsedMessage instanceof AlaGameTabGetNewNotifyResponsedMessage)) {
                List<a> newNotifyData = ((AlaGameTabGetNewNotifyResponsedMessage) httpResponsedMessage).getNewNotifyData();
                if (!v.w(newNotifyData)) {
                    for (a aVar : newNotifyData) {
                        if (aVar != null) {
                            for (int i = 0; i < c.this.dmk.aqH().size(); i++) {
                                FragmentTabHost.b cx = c.this.bgO.cx(i);
                                if (cx.mType != 99 && cx.mType != 1 && cx.mType != c.this.bgO.getCurrentTabType() && cx.mType == aVar.getTabId() && aVar.ato() && cx.afI.gM(String.valueOf(cx.mType)) != null) {
                                    cx.afI.gM(String.valueOf(cx.mType)).f7view.setVisibility(0);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private Runnable dmw = new Runnable() { // from class: com.baidu.tieba.frs.gametab.c.11
        @Override // java.lang.Runnable
        public void run() {
            e.fw().removeCallbacks(this);
            c.this.ats();
            e.fw().postDelayed(this, StatisticConfig.MIN_UPLOAD_INTERVAL);
        }
    };
    private String dmn = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_game_forem_tab_hot_point");

    public c(FrsActivity frsActivity) {
        this.dmf = frsActivity;
    }

    public void init(Bundle bundle) {
        this.dmr.getHttpMessageListener().setPriority(-1);
        this.dmr.getSocketMessageListener().setPriority(-1);
        this.dmf.registerListener(this.dms);
        this.dmu.setSelfListener(true);
        this.dmf.registerListener(this.dmu);
        this.dmt.setSelfListener(true);
        this.dmf.registerListener(this.dmt);
        if (bundle == null) {
            this.mForumName = this.dmf.getIntent().getStringExtra("name");
            this.dmm = this.dmf.getIntent().getIntExtra(FrsActivityConfig.FRS_GAME_DEFAULT_TAB_ID, 0);
        } else {
            this.mForumName = bundle.getString("name");
            this.dmm = bundle.getInt("default_tab_id", 0);
        }
        k(bundle);
        this.dmp = new ShareSuccessReplyToServerModel();
        this.dmf.registerListener(this.dmr);
        this.dmq = new com.baidu.tieba.q.a(this.dmf.getPageContext());
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.mForumName);
        bundle.putInt("default_tab_id", this.dmm);
    }

    private void k(Bundle bundle) {
        if (this.dmg == null) {
            this.dmg = new FrsFragment();
            this.dmg.setArguments(bundle);
        }
        FragmentManager supportFragmentManager = this.dmf.getSupportFragmentManager();
        if (!supportFragmentManager.isDestroyed()) {
            FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
            beginTransaction.add(16908290, this.dmg);
            beginTransaction.commitAllowingStateLoss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(i iVar) {
        if (v.v(iVar.bqE()) > 0) {
            this.dmj = iVar;
            if (!this.dmf.isLoadingViewAttached() && this.bgO == null) {
                this.dmf.showLoadingView(this.dmf.findViewById(16908290));
            }
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.c.12
                @Override // java.lang.Runnable
                public void run() {
                    c.this.bo(c.this.dmj.bqE());
                }
            });
        } else if (this.bgO != null) {
            this.blc.removeView(this.bgO);
            this.bgO = null;
            this.dmk = null;
            if (this.dmi != null && this.dmi.getParent() != null) {
                ((ViewGroup) this.dmi.getParent()).removeView(this.dmi);
            }
            k((Bundle) null);
        }
    }

    private boolean atp() {
        FragmentManager supportFragmentManager = this.dmf.getSupportFragmentManager();
        try {
            supportFragmentManager.beginTransaction().remove(this.dmg).commitAllowingStateLoss();
            supportFragmentManager.executePendingTransactions();
            return true;
        } catch (IllegalStateException e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bo(List<FrsTabInfo> list) {
        if (this.dmf.isLoadingViewAttached()) {
            this.dmf.hideLoadingView(this.dmf.findViewById(16908290));
        }
        if (this.bgO == null && atp()) {
            atq();
            bp(list);
        }
    }

    private void atq() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021074, TbConfig.SERVER_ADDRESS + "game/forum/getNewNotify");
        tbHttpMessageTask.setResponsedClass(AlaGameTabGetNewNotifyResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.dmf.registerListener(1021074, this.dmv);
    }

    private void bp(List<FrsTabInfo> list) {
        List list2;
        boolean z;
        if (!v.w(list)) {
            CustomMessageListener customMessageListener = new CustomMessageListener(2001616) { // from class: com.baidu.tieba.frs.gametab.c.13
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ab)) {
                        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(c.this.dmn, true)) {
                            e.fw().post(c.this.dmw);
                        }
                        c.this.att();
                    }
                }
            };
            customMessageListener.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            customMessageListener.setSelfListener(true);
            this.dmf.registerListener(customMessageListener);
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
            builder.tab_name = this.dmf.getResources().getString(d.k.send);
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
            this.dmk = new ab(this.dmf.getActivity(), list2);
            if (aoK() != null) {
                this.dmk.setForumId(aoK().getForumId());
                this.dmk.setForumName(aoK().getForumName());
                if (aoK().apD() != null && aoK().apD().aVq() != null) {
                    this.dmk.setForumGameLabel(aoK().apD().aVq().getForumGameLabel());
                    this.dmk.lP(aoK().apD().aVq().getSpecialForumType());
                }
            }
            new d(this.dmg).a(this.dmk);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001616, this.dmk);
            CustomMessage customMessage = new CustomMessage(2001616);
            customMessage.setTag(this.dmf.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    private void atr() {
        int aty = aty();
        if (aty >= 0) {
            a(this.dmg, aty);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ats() {
        if (this.dmk != null && !TextUtils.isEmpty(this.dmk.getForumId())) {
            HttpMessage httpMessage = new HttpMessage(1021074);
            httpMessage.addParam("forum_id", this.dmj.aVq().getId());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void att() {
        if (this.dmk != null) {
            this.dmk.aqI();
            if (!v.w(this.dmk.aoW())) {
                atr();
                if (this.bgO == null) {
                    this.bgO = new FragmentTabHost(this.dmf.getActivity());
                    this.bgO.setClipChildren(false);
                    this.bgO.setClipToPadding(false);
                    this.bgO.setup(this.dmf.getSupportFragmentManager());
                    this.bgO.getFragmentTabWidget().setAbsoluteWeight(true);
                    this.bgO.setShouldDrawIndicatorLine(false);
                    this.bgO.setShouldDrawTopLine(true);
                    this.bgO.setTabWidgetViewPadding(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds10), 0, 0);
                    this.bgO.aC(true);
                    this.bgO.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    this.blc = new FrameLayout(this.dmf.getActivity());
                    this.blc.setClipChildren(false);
                    this.blc.setClipToPadding(false);
                    this.blc.addView(this.bgO);
                    this.dmf.setContentView(this.blc);
                    this.bgO.setOnTabSelectionListener(new FragmentTabHost.a() { // from class: com.baidu.tieba.frs.gametab.c.14
                        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
                        public void i(int i, boolean z) {
                            c.this.a(c.this.bgO.getCurrentFragment(), i);
                            if (c.this.kO(i) != 1) {
                                c.this.dmg.fr(false);
                            }
                        }

                        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
                        public boolean j(int i, boolean z) {
                            String str = null;
                            FragmentTabHost.b cx = c.this.bgO.cx(i);
                            if (c.this.dmj != null && c.this.dmj.aVq() != null) {
                                str = c.this.dmj.aVq().getId();
                            }
                            if (cx.mType == 99) {
                                c.this.atw();
                                TiebaStatic.log(new al("c12342").r("obj_locate", c.this.c(c.this.bgO.cx(c.this.bgO.getCurrentTabIndex()))).ac(ImageViewerConfig.FORUM_ID, str));
                                TiebaStatic.log(new al("c12334").r("obj_locate", c.this.c(cx)).ac(ImageViewerConfig.FORUM_ID, str));
                                return false;
                            } else if (cx.mType != 5 || TbadkCoreApplication.isLogin()) {
                                TiebaStatic.log(new al("c12334").r("obj_locate", c.this.c(cx)).ac(ImageViewerConfig.FORUM_ID, str));
                                if (cx.afI.gM(String.valueOf(cx.mType)) != null) {
                                    if (!(cx.afI.gM(String.valueOf(cx.mType)).f7view.getVisibility() == 0)) {
                                        if (c.this.dmo == i) {
                                            c.this.b(cx);
                                        }
                                    } else {
                                        cx.afI.gM(String.valueOf(cx.mType)).f7view.setVisibility(8);
                                        c.this.b(cx);
                                    }
                                }
                                c.this.dmo = i;
                                return true;
                            } else {
                                az.aJ(c.this.dmf.getPageContext().getPageActivity());
                                return false;
                            }
                        }
                    });
                } else {
                    this.bgO.reset();
                }
                List<com.baidu.tbadk.mainTab.b> aoW = this.dmk.aoW();
                List<FrsTabInfo> aqH = this.dmk.aqH();
                if (aqH.size() == aoW.size()) {
                    int size = aqH.size();
                    for (int i = 0; i < size; i++) {
                        com.baidu.tbadk.mainTab.b bVar = aoW.get(i);
                        if (bVar != null) {
                            FrsTabInfo frsTabInfo = aqH.get(i);
                            if (frsTabInfo == null || TextUtils.isEmpty(frsTabInfo.tab_name)) {
                                a(bVar, bVar.Fw(), bVar.aT(this.dmf.getActivity()), null);
                            } else {
                                a(bVar, bVar.Fw(), bVar.aT(this.dmf.getActivity()), frsTabInfo.tab_name);
                            }
                        }
                    }
                } else {
                    for (com.baidu.tbadk.mainTab.b bVar2 : aoW) {
                        a(bVar2, bVar2.Fw(), bVar2.aT(this.dmf.getActivity()), null);
                    }
                }
                this.bgO.uv();
                this.bgO.cv(2);
                this.bgO.aB(true);
                this.bgO.setViewPagerScrollable(false);
                final int kN = kN(this.dmm);
                if (kN < 0) {
                    kN = kN(this.dmj.bqF());
                }
                if (kN < 0) {
                    kN = aty();
                }
                if (kN < 0) {
                    kN = 0;
                }
                this.dmm = kN;
                this.dmo = kN;
                this.bgO.setCurrentTab(kN);
                if (kO(kN) != 1) {
                    this.dmg.fr(false);
                }
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.c.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.this.bgO != null) {
                            c.this.a(c.this.bgO.getCurrentFragment(), kN);
                        }
                    }
                });
                atu();
                this.bgO.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
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

    private void atu() {
        if (this.bgO != null && this.bgO.cy(99) != null) {
            if (this.dmi == null || this.dmi.getParent() == null) {
                if (this.dmi == null) {
                    this.dmi = new ImageView(this.dmf.getActivity());
                }
                int e = l.e(this.dmf.getActivity(), d.e.ds80);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(e, e);
                layoutParams.gravity = 81;
                layoutParams.bottomMargin = l.e(this.dmf.getActivity(), d.e.ds5);
                this.dmi.setLayoutParams(layoutParams);
                ak.c(this.dmi, d.f.icon_tabbar_add_n);
                ak.i(this.dmi, d.f.icon_tabbar_chaticon_n);
                this.dmi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.c.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        String str = null;
                        c.this.atw();
                        if (c.this.bgO != null) {
                            if (c.this.dmj != null && c.this.dmj.aVq() != null) {
                                str = c.this.dmj.aVq().getId();
                            }
                            TiebaStatic.log(new al("c12342").r("obj_locate", c.this.c(c.this.bgO.cx(c.this.bgO.getCurrentTabIndex()))).ac(ImageViewerConfig.FORUM_ID, str));
                            TiebaStatic.log(new al("c12334").r("obj_locate", 99).ac(ImageViewerConfig.FORUM_ID, str));
                        }
                    }
                });
                if (this.dmi.getParent() == null) {
                    this.blc.addView(this.dmi);
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
        NavigationBar Rd;
        if ((fragment instanceof ai) && this.dmj != null && this.dmj.aVq() != null && (Rd = ((ai) fragment).Rd()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.dmj.aVq().getName(), 5, true, true) + this.dmf.getActivity().getString(d.k.forum));
            Rd.setCenterTextTitle(sb.toString());
        }
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator, String str) {
        boolean z = true;
        if (cVar != null) {
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.afJ = cVar.aIn;
            if (bVar2.afJ.getArguments() == null) {
                Bundle bundle = new Bundle();
                bundle.putString("name", this.dmj.aVq().getName());
                bundle.putString("from", this.dmj.aVq().getSpecialForumType());
                bundle.putString(ImageViewerConfig.FORUM_ID, this.dmj.aVq().getId());
                bVar2.afJ.setArguments(bundle);
            } else {
                bVar2.afJ.getArguments().putString(ImageViewerConfig.FORUM_ID, this.dmj.aVq().getId());
            }
            bVar2.mType = cVar.type;
            if (cVar.aIv == com.baidu.tbadk.mainTab.c.aIs && cVar.type == 99) {
                tbFragmentTabIndicator.setIconViewWithoutText(9, -((int) this.dmf.getResources().getDimension(d.e.ds12)));
            } else if (!TextUtils.isEmpty(str)) {
                tbFragmentTabIndicator.setText(str);
            } else {
                tbFragmentTabIndicator.setText(cVar.aIo);
            }
            tbFragmentTabIndicator.setTextSize(0, this.dmf.getResources().getDimension(d.e.ds30));
            tbFragmentTabIndicator.setTextColorResId(d.C0126d.s_game_frs_tabbar_text_color);
            tbFragmentTabIndicator.setCompoundDrawablesTopResId(cVar.aIp);
            tbFragmentTabIndicator.setContentTvTopMargin(this.dmf.getResources().getDimensionPixelSize(d.e.ds2));
            tbFragmentTabIndicator.dA(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            tbFragmentTabIndicator.setIsContentSelectBold(false);
            if (cVar.aIv != com.baidu.tbadk.mainTab.c.aIs || cVar.type != 99) {
                z = false;
            }
            if (!z && (tbFragmentTabIndicator instanceof FragmentTabIndicator)) {
                tbFragmentTabIndicator.a(String.valueOf(bVar2.mType), a((FragmentTabIndicator) tbFragmentTabIndicator));
            }
            bVar2.afI = tbFragmentTabIndicator;
            bVar2.afK = bVar;
            this.bgO.a(bVar2);
        }
    }

    private TbFragmentTabIndicator.a a(FragmentTabIndicator fragmentTabIndicator) {
        int dimensionPixelSize = this.dmf.getResources().getDimensionPixelSize(d.e.ds12);
        ImageView imageView = new ImageView(this.dmf);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        imageView.setImageResource(d.f.icon_frs_tab_new_notify_red_point);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        fragmentTabIndicator.setTipPosType(1);
        fragmentTabIndicator.setTipTopMargin(this.dmf.getResources().getDimensionPixelSize(d.e.ds12));
        aVar.aII = fragmentTabIndicator;
        aVar.sT = this.dmf.getResources().getDimensionPixelSize(d.e.ds12);
        aVar.f7view = imageView;
        aVar.f7view.setVisibility(8);
        return aVar;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.dmg instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.dmg.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a gb(int i) {
        if (this.dmg instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.dmg.gb(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.dmg instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.dmg.a(bVar);
        }
    }

    public void onNewIntent(Intent intent) {
        if (this.dmg != null) {
            this.dmg.onNewIntent(intent);
        }
    }

    public void onResume() {
        if (this.bgO == null) {
            this.dmg.setPrimary(true);
            return;
        }
        Fragment currentFragment = this.bgO.getCurrentFragment();
        if (currentFragment instanceof BaseFragment) {
            ((BaseFragment) currentFragment).setPrimary(true);
        }
    }

    public void onPause() {
        if (this.bgO == null) {
            this.dmg.setPrimary(false);
            return;
        }
        Fragment currentFragment = this.bgO.getCurrentFragment();
        if (currentFragment instanceof BaseFragment) {
            ((BaseFragment) currentFragment).setPrimary(false);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bgO == null) {
            this.dmg.onChangeSkinType(i);
        } else {
            this.bgO.aB(true);
            this.bgO.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.dmi != null) {
            ak.c(this.dmi, d.f.icon_tabbar_add_n);
            ak.i(this.dmi, d.f.icon_tabbar_chaticon_n);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.bgO != null && this.dmh != null && this.dmh.isShowing()) {
                this.dmh.bAZ();
            } else if (this.dmg != null && this.dmg.isAdded()) {
                if (this.dmg.onKeyDown(i, keyEvent)) {
                    return true;
                }
                atv();
            } else {
                return this.dmf.b(i, keyEvent);
            }
            return false;
        }
        return this.dmf.b(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atv() {
        if (this.dmo != this.dmm && this.bgO != null) {
            this.bgO.setCurrentTab(this.dmm);
            if (kO(this.dmm) != 1) {
                this.dmg.fr(false);
            }
            this.dmo = this.dmm;
            a(this.bgO.getCurrentFragment(), this.dmm);
            return;
        }
        this.dmg.closeActivity();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        com.baidu.tbadk.coreExtra.c.d shareItem;
        if (this.bgO == null) {
            this.dmg.onActivityResult(i, i2, intent);
        } else {
            this.bgO.getCurrentFragment().onActivityResult(i, i2, intent);
        }
        if (i2 == -1 && i == 24007) {
            int intExtra = intent.getIntExtra("extra_share_status", 2);
            int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
            if (intExtra == 1 && (shareItem = TbadkCoreApplication.getInst().getShareItem()) != null && shareItem.linkUrl != null && this.dmp != null) {
                this.dmp.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.frs.gametab.c.4
                    @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                    public void AD() {
                    }

                    @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                    public void a(final CustomDialogData customDialogData) {
                        e.fw().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.c.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (c.this.dmf != null) {
                                    com.baidu.tieba.pb.interactionpopupwindow.c.a(c.this.dmf.getPageContext(), customDialogData).show();
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
        if (this.bgO == null) {
            return this.dmg.getVoiceManager();
        }
        Fragment currentFragment = this.bgO.getCurrentFragment();
        if (currentFragment instanceof VoiceManager.c) {
            return ((VoiceManager.c) currentFragment).getVoiceManager();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void atw() {
        if (az.aK(this.dmf) && !this.dmq.bvB() && !atx()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921032));
            if (this.dmh == null) {
                this.dmh = new com.baidu.tieba.write.c(this.dmf.getPageContext(), this.blc, "frs");
                this.dmh.uG("2");
            }
            this.dmh.a(this.dmg.apG());
            this.dmh.nl(false);
        }
    }

    public boolean atx() {
        String fixedText;
        if (this.dmg == null || !this.dmg.isAdded() || this.dmg.getPageContext() == null) {
            return false;
        }
        com.baidu.tieba.tbadkCore.l apD = this.dmg.apD();
        if (apD == null) {
            return false;
        }
        if (az.aK(this.dmg.getPageContext().getPageActivity())) {
            AntiData qS = apD.qS();
            if (qS != null) {
                if (a(qS.getBlock_stat(), qS.mFrsForbidenDialogInfo)) {
                    return true;
                }
                if (qS.getIfpost() == 0 && !StringUtils.isNull(qS.getForbid_info())) {
                    String forbid_info = qS.getForbid_info();
                    if (an.ek(forbid_info) > 14) {
                        forbid_info = an.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                    }
                    BdToast b = BdToast.b(this.dmg.getPageContext().getPageActivity(), forbid_info, d.f.icon_toast_game_error);
                    b.O(1.25f);
                    b.tK();
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.dmg.getResources().getString(d.k.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast b = BdToast.b(this.dmg.getPageContext().getPageActivity(), string, d.f.icon_toast_game_error);
            b.O(1.25f);
            b.tK();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dmg.getPageContext().getPageActivity());
        aVar.dc(an.getFixedText(string, 50, true));
        aVar.b(an.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.dmg.getResources().getString(d.k.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.gametab.c.5
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
                    ax.wf().c(c.this.dmg.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.dmg.getPageContext()).tC();
        return true;
    }

    private int aty() {
        if (this.dmk == null) {
            return -1;
        }
        int v = v.v(this.dmk.aqH());
        for (int i = 0; i < v; i++) {
            if (this.dmk.aqH().get(i).tab_id.intValue() == 1) {
                return i;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int kN(int i) {
        if (this.dmk == null) {
            return -1;
        }
        int v = v.v(this.dmk.aqH());
        for (int i2 = 0; i2 < v; i2++) {
            if (this.dmk.aqH().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int kO(int i) {
        if (this.dmk != null && i < v.v(this.dmk.aqH())) {
            return this.dmk.aqH().get(i).tab_id.intValue();
        }
        return -1;
    }

    public FrsFragment aoK() {
        return this.dmg;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> aoL() {
        if (this.bgO == null) {
            if (this.dmg instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) this.dmg).aoL();
            }
        } else {
            Fragment currentFragment = this.bgO.getCurrentFragment();
            if (currentFragment instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) currentFragment).aoL();
            }
        }
        return null;
    }

    public void onDestroy() {
        if (this.dmf.isLoadingViewAttached()) {
            this.dmf.hideLoadingView(this.dmf.findViewById(16908290));
        }
        if (this.dmw != null) {
            e.fw().removeCallbacks(this.dmw);
        }
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(this.dmn, false);
        if (this.dmp != null) {
            this.dmp.cancelLoadData();
        }
    }
}
