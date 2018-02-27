package com.baidu.tieba.frs.gametab;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.e;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.af;
import com.baidu.tieba.frs.am;
import com.baidu.tieba.frs.i;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.tbadkCore.FRSPageSocketResponsedMessage;
import com.baidu.tieba.tbadkCore.FrsPageHttpResponseMessage;
import com.sina.weibo.sdk.statistic.StatisticConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes2.dex */
public class c implements VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b {
    private FragmentTabHost bWN;
    private FrameLayout caK;
    private FrsActivity dQI;
    private i dQJ;
    private com.baidu.tieba.write.c dQK;
    private ImageView dQL;
    private com.baidu.tieba.tbadkCore.i dQM;
    private af dQN;
    private int dQR;
    private ShareSuccessReplyToServerModel dQS;
    private com.baidu.tieba.p.a dQT;
    private String mForumName;
    private boolean dQO = false;
    private Handler mHandler = new Handler();
    private int dQP = 0;
    private com.baidu.adp.framework.listener.a dQU = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FRS_HTTP_CMD, 301001) { // from class: com.baidu.tieba.frs.gametab.c.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            com.baidu.tieba.tbadkCore.i iVar = null;
            if (!c.this.dQO && !responsedMessage.hasError()) {
                if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                    iVar = ((FrsPageHttpResponseMessage) responsedMessage).getResponseData();
                } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                    iVar = ((FRSPageSocketResponsedMessage) responsedMessage).getResponseData();
                }
                if (iVar != null) {
                    c.this.dQO = true;
                    c.this.c(iVar);
                }
            }
        }
    };
    private CustomMessageListener dQV = new CustomMessageListener(2001615) { // from class: com.baidu.tieba.frs.gametab.c.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!c.this.dQO && customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.i)) {
                com.baidu.tieba.tbadkCore.i iVar = (com.baidu.tieba.tbadkCore.i) customResponsedMessage.getData();
                if (iVar.bar() != null && c.this.mForumName != null && c.this.mForumName.equals(iVar.bar().getName())) {
                    c.this.c(iVar);
                }
            }
        }
    };
    private HttpMessageListener dQW = new HttpMessageListener(0) { // from class: com.baidu.tieba.frs.gametab.c.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && 1003275 == httpResponsedMessage.getCmd() && (httpResponsedMessage instanceof AlaGameTabGetNewNotifyResponsedMessage)) {
                List<a> newNotifyData = ((AlaGameTabGetNewNotifyResponsedMessage) httpResponsedMessage).getNewNotifyData();
                if (!v.E(newNotifyData)) {
                    for (a aVar : newNotifyData) {
                        if (aVar != null) {
                            for (int i = 0; i < c.this.dQN.awn().size(); i++) {
                                FragmentTabHost.c fy = c.this.bWN.fy(i);
                                if (fy.mType != 99 && fy.mType != 1 && fy.mType != c.this.bWN.getCurrentTabType() && fy.mType == aVar.getTabId() && aVar.ayy() && fy.aUm.gX(String.valueOf(fy.mType)) != null) {
                                    fy.aUm.gX(String.valueOf(fy.mType)).view.setVisibility(0);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private Runnable dQX = new Runnable() { // from class: com.baidu.tieba.frs.gametab.c.7
        @Override // java.lang.Runnable
        public void run() {
            e.ns().removeCallbacks(this);
            c.this.ayC();
            e.ns().postDelayed(this, StatisticConfig.MIN_UPLOAD_INTERVAL);
        }
    };
    private String dQQ = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_game_forem_tab_hot_point");

    public c(FrsActivity frsActivity) {
        this.dQI = frsActivity;
    }

    public void init(Bundle bundle) {
        this.dQU.getHttpMessageListener().setPriority(-1);
        this.dQU.getSocketMessageListener().setPriority(-1);
        this.dQI.registerListener(this.dQV);
        if (bundle == null) {
            this.mForumName = this.dQI.getIntent().getStringExtra("name");
            this.dQP = this.dQI.getIntent().getIntExtra(FrsActivityConfig.FRS_GAME_DEFAULT_TAB_ID, 0);
        } else {
            this.mForumName = bundle.getString("name");
            this.dQP = bundle.getInt("default_tab_id", 0);
        }
        n(bundle);
        this.dQS = new ShareSuccessReplyToServerModel();
        this.dQI.registerListener(this.dQU);
        this.dQT = new com.baidu.tieba.p.a(this.dQI.getPageContext());
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.mForumName);
        bundle.putInt("default_tab_id", this.dQP);
    }

    private void n(Bundle bundle) {
        if (this.dQJ == null) {
            this.dQJ = new i();
            this.dQJ.setArguments(bundle);
        }
        FragmentManager supportFragmentManager = this.dQI.getSupportFragmentManager();
        if (!supportFragmentManager.isDestroyed()) {
            FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
            beginTransaction.add(16908290, this.dQJ);
            beginTransaction.commitAllowingStateLoss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.i iVar) {
        if (v.D(iVar.bvz()) > 0) {
            this.dQM = iVar;
            if (!this.dQI.isLoadingViewAttached() && this.bWN == null) {
                this.dQI.showLoadingView(this.dQI.findViewById(16908290));
            }
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.c.8
                @Override // java.lang.Runnable
                public void run() {
                    c.this.bs(c.this.dQM.bvz());
                }
            });
        } else if (this.bWN != null) {
            this.caK.removeView(this.bWN);
            this.bWN = null;
            this.dQN = null;
            if (this.dQL != null && this.dQL.getParent() != null) {
                ((ViewGroup) this.dQL.getParent()).removeView(this.dQL);
            }
            n(null);
        }
    }

    private boolean ayz() {
        FragmentManager supportFragmentManager = this.dQI.getSupportFragmentManager();
        try {
            supportFragmentManager.beginTransaction().remove(this.dQJ).commitAllowingStateLoss();
            supportFragmentManager.executePendingTransactions();
            return true;
        } catch (IllegalStateException e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bs(List<FrsTabInfo> list) {
        if (this.dQI.isLoadingViewAttached()) {
            this.dQI.hideLoadingView(this.dQI.findViewById(16908290));
        }
        if (this.bWN == null && ayz()) {
            ayA();
            bt(list);
        }
    }

    private void ayA() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003275, TbConfig.SERVER_ADDRESS + "game/forum/getNewNotify");
        tbHttpMessageTask.setResponsedClass(AlaGameTabGetNewNotifyResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.dQI.registerListener(1003275, this.dQW);
    }

    private void bt(List<FrsTabInfo> list) {
        List list2;
        boolean z;
        if (!v.E(list)) {
            CustomMessageListener customMessageListener = new CustomMessageListener(2001616) { // from class: com.baidu.tieba.frs.gametab.c.9
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof af)) {
                        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(c.this.dQQ, true)) {
                            e.ns().post(c.this.dQX);
                        }
                        c.this.ayD();
                    }
                }
            };
            customMessageListener.setPriority(Integer.MAX_VALUE);
            customMessageListener.setSelfListener(true);
            this.dQI.registerListener(customMessageListener);
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
            builder.tab_name = this.dQI.getResources().getString(d.j.send);
            builder.tab_type = 0;
            int D = v.D(arrayList);
            if (D > 4) {
                list2 = arrayList.subList(0, 4);
                list2.add(2, builder.build(false));
            } else if (D < 2) {
                arrayList.add(builder.build(false));
                list2 = arrayList;
            } else {
                arrayList.add(D / 2, builder.build(false));
                list2 = arrayList;
            }
            this.dQN = new af(this.dQI.getActivity(), list2);
            if (ayI() != null) {
                this.dQN.setForumId(ayI().getForumId());
                this.dQN.setForumName(ayI().getForumName());
                if (ayI().avk() != null && ayI().avk().bar() != null) {
                    this.dQN.setForumGameLabel(ayI().avk().bar().getForumGameLabel());
                    this.dQN.lJ(ayI().avk().bar().getSpecialForumType());
                }
            }
            new d(this.dQJ).a(this.dQN);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001616, this.dQN);
            CustomMessage customMessage = new CustomMessage(2001616);
            customMessage.setTag(this.dQI.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    private void ayB() {
        int ayH = ayH();
        if (ayH >= 0) {
            a(this.dQJ, ayH);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayC() {
        if (this.dQN != null && !TextUtils.isEmpty(this.dQN.getForumId())) {
            HttpMessage httpMessage = new HttpMessage(1003275);
            httpMessage.addParam("forum_id", this.dQM.bar().getId());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayD() {
        if (this.dQN != null) {
            this.dQN.awo();
            if (!v.E(this.dQN.auD())) {
                ayB();
                if (this.bWN == null) {
                    this.bWN = new FragmentTabHost(this.dQI.getActivity());
                    this.bWN.setClipChildren(false);
                    this.bWN.setClipToPadding(false);
                    this.bWN.setup(this.dQI.getSupportFragmentManager());
                    this.bWN.getFragmentTabWidget().setAbsoluteWeight(true);
                    this.bWN.setShouldDrawIndicatorLine(false);
                    this.bWN.setShouldDrawTopLine(true);
                    this.bWN.n(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds10), 0, 0);
                    this.bWN.bk(true);
                    this.bWN.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    this.caK = new FrameLayout(this.dQI.getActivity());
                    this.caK.setClipChildren(false);
                    this.caK.setClipToPadding(false);
                    this.caK.addView(this.bWN);
                    this.dQI.setContentView(this.caK);
                    this.bWN.setOnTabSelectionListener(new FragmentTabHost.b() { // from class: com.baidu.tieba.frs.gametab.c.10
                        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
                        public void u(int i, boolean z) {
                            c.this.a(c.this.bWN.getCurrentFragment(), i);
                        }

                        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
                        public boolean v(int i, boolean z) {
                            String str = null;
                            FragmentTabHost.c fy = c.this.bWN.fy(i);
                            if (c.this.dQM != null && c.this.dQM.bar() != null) {
                                str = c.this.dQM.bar().getId();
                            }
                            if (fy.mType == 99) {
                                c.this.ayF();
                                TiebaStatic.log(new ak("c12342").s("obj_locate", c.this.c(c.this.bWN.fy(c.this.bWN.getCurrentTabIndex()))).ab(ImageViewerConfig.FORUM_ID, str));
                                TiebaStatic.log(new ak("c12334").s("obj_locate", c.this.c(fy)).ab(ImageViewerConfig.FORUM_ID, str));
                                return false;
                            } else if (fy.mType != 5 || TbadkCoreApplication.isLogin()) {
                                TiebaStatic.log(new ak("c12334").s("obj_locate", c.this.c(fy)).ab(ImageViewerConfig.FORUM_ID, str));
                                if (fy.aUm.gX(String.valueOf(fy.mType)) != null) {
                                    if (!(fy.aUm.gX(String.valueOf(fy.mType)).view.getVisibility() == 0)) {
                                        if (c.this.dQR == i) {
                                            c.this.b(fy);
                                        }
                                    } else {
                                        fy.aUm.gX(String.valueOf(fy.mType)).view.setVisibility(8);
                                        c.this.b(fy);
                                    }
                                }
                                c.this.dQR = i;
                                return true;
                            } else {
                                ay.aZ(c.this.dQI.getPageContext().getPageActivity());
                                return false;
                            }
                        }
                    });
                } else {
                    this.bWN.reset();
                }
                List<com.baidu.tbadk.mainTab.b> auD = this.dQN.auD();
                List<FrsTabInfo> awn = this.dQN.awn();
                if (awn.size() == auD.size()) {
                    int size = awn.size();
                    for (int i = 0; i < size; i++) {
                        com.baidu.tbadk.mainTab.b bVar = auD.get(i);
                        if (bVar != null) {
                            FrsTabInfo frsTabInfo = awn.get(i);
                            if (frsTabInfo == null || TextUtils.isEmpty(frsTabInfo.tab_name)) {
                                a(bVar, bVar.MU(), bVar.bi(this.dQI.getActivity()), null);
                            } else {
                                a(bVar, bVar.MU(), bVar.bi(this.dQI.getActivity()), frsTabInfo.tab_name);
                            }
                        }
                    }
                } else {
                    for (com.baidu.tbadk.mainTab.b bVar2 : auD) {
                        a(bVar2, bVar2.MU(), bVar2.bi(this.dQI.getActivity()), null);
                    }
                }
                this.bWN.BN();
                this.bWN.fw(2);
                this.bWN.bj(true);
                this.bWN.setViewPagerScrollable(false);
                final int nA = nA(this.dQP);
                if (nA < 0) {
                    nA = nA(this.dQM.bvA());
                }
                if (nA < 0) {
                    nA = ayH();
                }
                if (nA < 0) {
                    nA = 0;
                }
                this.dQR = nA;
                this.bWN.setCurrentTab(nA);
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.c.11
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.this.bWN != null) {
                            c.this.a(c.this.bWN.getCurrentFragment(), nA);
                        }
                    }
                });
                this.dQJ.fL(this.dQI.getResources().getString(d.j.ala_follow_live_enter_live_square_txt).equals(this.mForumName));
                ayE();
                this.bWN.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(FragmentTabHost.c cVar) {
        if (cVar.mType == 2 && (cVar.aUn instanceof com.baidu.tieba.frs.gametab.livetab.b)) {
            ((com.baidu.tieba.frs.gametab.livetab.b) cVar.aUn).lY("FrsGameLive");
        } else if (cVar.mType == 3) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsGoodsTab_3"));
        } else if (cVar.mType == 101) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsInfoTab_101"));
        } else if (cVar.mType == 305) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsRankList_305"));
        } else if (cVar.mType == 4) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsLiveLive_4"));
        } else if (cVar.mType == 1) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsGameLive_1"));
        } else if (cVar.mType == 5) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsLivePersonal_5"));
        }
    }

    private void ayE() {
        if (this.bWN != null && this.bWN.fz(99) != null) {
            if (this.dQL == null || this.dQL.getParent() == null) {
                if (this.dQL == null) {
                    this.dQL = new ImageView(this.dQI.getActivity());
                }
                int t = l.t(this.dQI.getActivity(), d.e.ds80);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(t, t);
                layoutParams.gravity = 81;
                layoutParams.bottomMargin = l.t(this.dQI.getActivity(), d.e.ds5);
                this.dQL.setLayoutParams(layoutParams);
                aj.c(this.dQL, d.f.icon_tabbar_add_n);
                aj.s(this.dQL, d.f.icon_tabbar_chaticon_n);
                this.dQL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.c.12
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        String str = null;
                        c.this.ayF();
                        if (c.this.bWN != null) {
                            if (c.this.dQM != null && c.this.dQM.bar() != null) {
                                str = c.this.dQM.bar().getId();
                            }
                            TiebaStatic.log(new ak("c12342").s("obj_locate", c.this.c(c.this.bWN.fy(c.this.bWN.getCurrentTabIndex()))).ab(ImageViewerConfig.FORUM_ID, str));
                            TiebaStatic.log(new ak("c12334").s("obj_locate", 99).ab(ImageViewerConfig.FORUM_ID, str));
                        }
                    }
                });
                if (this.dQL.getParent() == null) {
                    this.caK.addView(this.dQL);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c(FragmentTabHost.c cVar) {
        if (cVar.mType == 101) {
            return 1;
        }
        if (cVar.mType == 1) {
            return 2;
        }
        if (cVar.mType == 2) {
            return 3;
        }
        if (cVar.mType == 3) {
            return 4;
        }
        if (cVar.mType == 99) {
            return 5;
        }
        if (cVar.mType == 4) {
            return 6;
        }
        if (cVar.mType == 305) {
            return 7;
        }
        return cVar.mType == 5 ? 8 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Fragment fragment, int i) {
        NavigationBar avj;
        if ((fragment instanceof am) && this.dQM != null && this.dQM.bar() != null && (avj = ((am) fragment).avj()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.dQM.bar().getName(), 5, true, true) + this.dQI.getActivity().getString(d.j.forum));
            avj.setCenterTextTitle(sb.toString());
        }
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, com.baidu.tbadk.mainTab.e eVar, String str) {
        boolean z = true;
        if (cVar != null) {
            FragmentTabHost.c cVar2 = new FragmentTabHost.c();
            cVar2.aUn = cVar.bxM;
            if (cVar2.aUn.getArguments() == null) {
                Bundle bundle = new Bundle();
                bundle.putString("name", this.dQM.bar().getName());
                bundle.putString("from", this.dQM.bar().getSpecialForumType());
                bundle.putString(ImageViewerConfig.FORUM_ID, this.dQM.bar().getId());
                cVar2.aUn.setArguments(bundle);
            } else {
                cVar2.aUn.getArguments().putString(ImageViewerConfig.FORUM_ID, this.dQM.bar().getId());
            }
            cVar2.mType = cVar.type;
            if (cVar.bxU == com.baidu.tbadk.mainTab.c.bxR && cVar.type == 99) {
                eVar.aJ(9, -((int) this.dQI.getResources().getDimension(d.e.ds12)));
            } else if (!TextUtils.isEmpty(str)) {
                eVar.setText(str);
            } else {
                eVar.setText(cVar.bxN);
            }
            eVar.setTextSize(0, this.dQI.getResources().getDimension(d.e.ds30));
            eVar.setTextColorResId(d.C0141d.s_game_frs_tabbar_text_color);
            eVar.setCompoundDrawablesTopResId(cVar.bxO);
            eVar.setContentTvTopMargin(this.dQI.getResources().getDimensionPixelSize(d.e.ds2));
            eVar.gB(TbadkCoreApplication.getInst().getSkinType());
            eVar.setTipPosType(1);
            eVar.setIsContentSelectBold(false);
            if (cVar.bxU != com.baidu.tbadk.mainTab.c.bxR || cVar.type != 99) {
                z = false;
            }
            if (!z && (eVar instanceof FragmentTabIndicator)) {
                eVar.a(String.valueOf(cVar2.mType), a((FragmentTabIndicator) eVar));
            }
            cVar2.aUm = eVar;
            cVar2.aUo = bVar;
            this.bWN.a(cVar2);
        }
    }

    private e.a a(FragmentTabIndicator fragmentTabIndicator) {
        int dimensionPixelSize = this.dQI.getResources().getDimensionPixelSize(d.e.ds12);
        ImageView imageView = new ImageView(this.dQI);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        imageView.setImageResource(d.f.icon_frs_tab_new_notify_red_point);
        e.a aVar = new e.a();
        fragmentTabIndicator.setTipPosType(1);
        fragmentTabIndicator.setTipTopMargin(this.dQI.getResources().getDimensionPixelSize(d.e.ds12));
        aVar.byh = fragmentTabIndicator;
        aVar.aiy = this.dQI.getResources().getDimensionPixelSize(d.e.ds12);
        aVar.view = imageView;
        aVar.view.setVisibility(8);
        return aVar;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.dQJ instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.dQJ.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a jc(int i) {
        if (this.dQJ instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.dQJ.jc(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.dQJ instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.dQJ.a(bVar);
        }
    }

    public void onNewIntent(Intent intent) {
        if (this.dQJ != null) {
            this.dQJ.onNewIntent(intent);
        }
    }

    public void onResume() {
        if (this.bWN == null) {
            this.dQJ.setPrimary(true);
            return;
        }
        Fragment currentFragment = this.bWN.getCurrentFragment();
        if (currentFragment instanceof BaseFragment) {
            ((BaseFragment) currentFragment).setPrimary(true);
        }
    }

    public void onPause() {
        if (this.bWN == null) {
            this.dQJ.setPrimary(false);
            return;
        }
        Fragment currentFragment = this.bWN.getCurrentFragment();
        if (currentFragment instanceof BaseFragment) {
            ((BaseFragment) currentFragment).setPrimary(false);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bWN == null) {
            this.dQJ.onChangeSkinType(i);
        } else {
            this.bWN.bj(true);
            this.bWN.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.dQL != null) {
            aj.c(this.dQL, d.f.icon_tabbar_add_n);
            aj.s(this.dQL, d.f.icon_tabbar_chaticon_n);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.bWN != null && this.dQK != null && this.dQK.isShowing()) {
                this.dQK.bFI();
            } else if (this.dQJ != null && this.dQJ.isAdded()) {
                if (this.dQJ.onKeyDown(i, keyEvent)) {
                    return true;
                }
                this.dQJ.closeActivity();
            } else {
                return this.dQI.e(i, keyEvent);
            }
            return false;
        }
        return this.dQI.e(i, keyEvent);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        com.baidu.tbadk.coreExtra.c.d shareItem;
        if (this.bWN == null) {
            this.dQJ.onActivityResult(i, i2, intent);
        } else {
            this.bWN.getCurrentFragment().onActivityResult(i, i2, intent);
        }
        if (i2 == -1 && i == 24007) {
            int intExtra = intent.getIntExtra("extra_share_status", 2);
            int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
            if (intExtra == 1 && (shareItem = TbadkCoreApplication.getInst().getShareItem()) != null && shareItem.linkUrl != null && this.dQS != null) {
                this.dQS.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.frs.gametab.c.2
                    @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                    public void HQ() {
                    }

                    @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                    public void a(final CustomDialogData customDialogData) {
                        com.baidu.adp.lib.g.e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.c.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (c.this.dQI != null) {
                                    com.baidu.tieba.pb.interactionpopupwindow.c.a(c.this.dQI.getPageContext(), customDialogData).show();
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
        if (this.bWN == null) {
            return this.dQJ.getVoiceManager();
        }
        Fragment currentFragment = this.bWN.getCurrentFragment();
        if (currentFragment instanceof VoiceManager.c) {
            return ((VoiceManager.c) currentFragment).getVoiceManager();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void ayF() {
        if (ay.ba(this.dQI) && !this.dQT.bAw() && !ayG()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921032));
            if (this.dQK == null) {
                this.dQK = new com.baidu.tieba.write.c(this.dQI.getPageContext(), this.caK, "frs");
                this.dQK.uo("2");
            }
            this.dQK.a(this.dQJ.avn());
            this.dQK.nC(false);
        }
    }

    public boolean ayG() {
        String fixedText;
        if (this.dQJ == null || !this.dQJ.isAdded() || this.dQJ.getPageContext() == null) {
            return false;
        }
        com.baidu.tieba.tbadkCore.l avk = this.dQJ.avk();
        if (avk == null) {
            return false;
        }
        if (ay.ba(this.dQJ.getPageContext().getPageActivity())) {
            AntiData yn = avk.yn();
            if (yn != null) {
                if (a(yn.getBlock_stat(), yn.mFrsForbidenDialogInfo)) {
                    return true;
                }
                if (yn.getIfpost() == 0 && !StringUtils.isNull(yn.getForbid_info())) {
                    String forbid_info = yn.getForbid_info();
                    if (com.baidu.tbadk.core.util.am.es(forbid_info) > 14) {
                        forbid_info = com.baidu.tbadk.core.util.am.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                    }
                    BdToast b = BdToast.b(this.dQJ.getPageContext().getPageActivity(), forbid_info, d.f.icon_toast_game_error);
                    b.aa(1.25f);
                    b.Bc();
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.dQJ.getResources().getString(d.j.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast b = BdToast.b(this.dQJ.getPageContext().getPageActivity(), string, d.f.icon_toast_game_error);
            b.aa(1.25f);
            b.Bc();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dQJ.getPageContext().getPageActivity());
        aVar.dk(com.baidu.tbadk.core.util.am.getFixedText(string, 50, true));
        aVar.b(com.baidu.tbadk.core.util.am.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.dQJ.getResources().getString(d.j.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.gametab.c.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (aVar2 != null) {
                    aVar2.dismiss();
                }
            }
        });
        if (!StringUtils.isNull(blockPopInfoData.ahead_info) && !StringUtils.isNull(blockPopInfoData.ahead_url)) {
            aVar.a(com.baidu.tbadk.core.util.am.getFixedText(blockPopInfoData.ahead_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.gametab.c.4
                /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.i */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aw.Dt().c(c.this.dQJ.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.dQJ.getPageContext()).AU();
        return true;
    }

    private int ayH() {
        if (this.dQN == null) {
            return -1;
        }
        int D = v.D(this.dQN.awn());
        for (int i = 0; i < D; i++) {
            if (this.dQN.awn().get(i).tab_id.intValue() == 1) {
                return i;
            }
        }
        return -1;
    }

    private int nA(int i) {
        if (this.dQN == null) {
            return -1;
        }
        int D = v.D(this.dQN.awn());
        for (int i2 = 0; i2 < D; i2++) {
            if (this.dQN.awn().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    public i ayI() {
        return this.dQJ;
    }

    public void onDestroy() {
        if (this.dQI.isLoadingViewAttached()) {
            this.dQI.hideLoadingView(this.dQI.findViewById(16908290));
        }
        if (this.dQX != null) {
            com.baidu.adp.lib.g.e.ns().removeCallbacks(this.dQX);
        }
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(this.dQQ, false);
        if (this.dQS != null) {
            this.dQS.cancelLoadData();
        }
    }
}
