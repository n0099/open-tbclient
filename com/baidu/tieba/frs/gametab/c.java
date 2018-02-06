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
    private FragmentTabHost bWZ;
    private FrameLayout caW;
    private FrsActivity dQU;
    private i dQV;
    private com.baidu.tieba.write.c dQW;
    private ImageView dQX;
    private com.baidu.tieba.tbadkCore.i dQY;
    private af dQZ;
    private int dRd;
    private ShareSuccessReplyToServerModel dRe;
    private com.baidu.tieba.p.a dRf;
    private String mForumName;
    private boolean dRa = false;
    private Handler mHandler = new Handler();
    private int dRb = 0;
    private com.baidu.adp.framework.listener.a dRg = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FRS_HTTP_CMD, 301001) { // from class: com.baidu.tieba.frs.gametab.c.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            com.baidu.tieba.tbadkCore.i iVar = null;
            if (!c.this.dRa && !responsedMessage.hasError()) {
                if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                    iVar = ((FrsPageHttpResponseMessage) responsedMessage).getResponseData();
                } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                    iVar = ((FRSPageSocketResponsedMessage) responsedMessage).getResponseData();
                }
                if (iVar != null) {
                    c.this.dRa = true;
                    c.this.c(iVar);
                }
            }
        }
    };
    private CustomMessageListener dRh = new CustomMessageListener(2001615) { // from class: com.baidu.tieba.frs.gametab.c.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!c.this.dRa && customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.i)) {
                com.baidu.tieba.tbadkCore.i iVar = (com.baidu.tieba.tbadkCore.i) customResponsedMessage.getData();
                if (iVar.bas() != null && c.this.mForumName != null && c.this.mForumName.equals(iVar.bas().getName())) {
                    c.this.c(iVar);
                }
            }
        }
    };
    private HttpMessageListener dRi = new HttpMessageListener(0) { // from class: com.baidu.tieba.frs.gametab.c.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && 1003275 == httpResponsedMessage.getCmd() && (httpResponsedMessage instanceof AlaGameTabGetNewNotifyResponsedMessage)) {
                List<a> newNotifyData = ((AlaGameTabGetNewNotifyResponsedMessage) httpResponsedMessage).getNewNotifyData();
                if (!v.E(newNotifyData)) {
                    for (a aVar : newNotifyData) {
                        if (aVar != null) {
                            for (int i = 0; i < c.this.dQZ.awo().size(); i++) {
                                FragmentTabHost.c fy = c.this.bWZ.fy(i);
                                if (fy.mType != 99 && fy.mType != 1 && fy.mType != c.this.bWZ.getCurrentTabType() && fy.mType == aVar.getTabId() && aVar.ayz() && fy.aUy.gX(String.valueOf(fy.mType)) != null) {
                                    fy.aUy.gX(String.valueOf(fy.mType)).view.setVisibility(0);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private Runnable dRj = new Runnable() { // from class: com.baidu.tieba.frs.gametab.c.7
        @Override // java.lang.Runnable
        public void run() {
            e.ns().removeCallbacks(this);
            c.this.ayD();
            e.ns().postDelayed(this, StatisticConfig.MIN_UPLOAD_INTERVAL);
        }
    };
    private String dRc = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_game_forem_tab_hot_point");

    public c(FrsActivity frsActivity) {
        this.dQU = frsActivity;
    }

    public void init(Bundle bundle) {
        this.dRg.getHttpMessageListener().setPriority(-1);
        this.dRg.getSocketMessageListener().setPriority(-1);
        this.dQU.registerListener(this.dRh);
        if (bundle == null) {
            this.mForumName = this.dQU.getIntent().getStringExtra("name");
            this.dRb = this.dQU.getIntent().getIntExtra(FrsActivityConfig.FRS_GAME_DEFAULT_TAB_ID, 0);
        } else {
            this.mForumName = bundle.getString("name");
            this.dRb = bundle.getInt("default_tab_id", 0);
        }
        n(bundle);
        this.dRe = new ShareSuccessReplyToServerModel();
        this.dQU.registerListener(this.dRg);
        this.dRf = new com.baidu.tieba.p.a(this.dQU.getPageContext());
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.mForumName);
        bundle.putInt("default_tab_id", this.dRb);
    }

    private void n(Bundle bundle) {
        if (this.dQV == null) {
            this.dQV = new i();
            this.dQV.setArguments(bundle);
        }
        FragmentManager supportFragmentManager = this.dQU.getSupportFragmentManager();
        if (!supportFragmentManager.isDestroyed()) {
            FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
            beginTransaction.add(16908290, this.dQV);
            beginTransaction.commitAllowingStateLoss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.i iVar) {
        if (v.D(iVar.bvA()) > 0) {
            this.dQY = iVar;
            if (!this.dQU.isLoadingViewAttached() && this.bWZ == null) {
                this.dQU.showLoadingView(this.dQU.findViewById(16908290));
            }
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.c.8
                @Override // java.lang.Runnable
                public void run() {
                    c.this.bs(c.this.dQY.bvA());
                }
            });
        } else if (this.bWZ != null) {
            this.caW.removeView(this.bWZ);
            this.bWZ = null;
            this.dQZ = null;
            if (this.dQX != null && this.dQX.getParent() != null) {
                ((ViewGroup) this.dQX.getParent()).removeView(this.dQX);
            }
            n(null);
        }
    }

    private boolean ayA() {
        FragmentManager supportFragmentManager = this.dQU.getSupportFragmentManager();
        try {
            supportFragmentManager.beginTransaction().remove(this.dQV).commitAllowingStateLoss();
            supportFragmentManager.executePendingTransactions();
            return true;
        } catch (IllegalStateException e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bs(List<FrsTabInfo> list) {
        if (this.dQU.isLoadingViewAttached()) {
            this.dQU.hideLoadingView(this.dQU.findViewById(16908290));
        }
        if (this.bWZ == null && ayA()) {
            ayB();
            bt(list);
        }
    }

    private void ayB() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003275, TbConfig.SERVER_ADDRESS + "game/forum/getNewNotify");
        tbHttpMessageTask.setResponsedClass(AlaGameTabGetNewNotifyResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.dQU.registerListener(1003275, this.dRi);
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
                        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(c.this.dRc, true)) {
                            e.ns().post(c.this.dRj);
                        }
                        c.this.ayE();
                    }
                }
            };
            customMessageListener.setPriority(Integer.MAX_VALUE);
            customMessageListener.setSelfListener(true);
            this.dQU.registerListener(customMessageListener);
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
            builder.tab_name = this.dQU.getResources().getString(d.j.send);
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
            this.dQZ = new af(this.dQU.getActivity(), list2);
            if (ayJ() != null) {
                this.dQZ.setForumId(ayJ().getForumId());
                this.dQZ.setForumName(ayJ().getForumName());
                if (ayJ().avl() != null && ayJ().avl().bas() != null) {
                    this.dQZ.setForumGameLabel(ayJ().avl().bas().getForumGameLabel());
                    this.dQZ.lJ(ayJ().avl().bas().getSpecialForumType());
                }
            }
            new d(this.dQV).a(this.dQZ);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001616, this.dQZ);
            CustomMessage customMessage = new CustomMessage(2001616);
            customMessage.setTag(this.dQU.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    private void ayC() {
        int ayI = ayI();
        if (ayI >= 0) {
            a(this.dQV, ayI);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayD() {
        if (this.dQZ != null && !TextUtils.isEmpty(this.dQZ.getForumId())) {
            HttpMessage httpMessage = new HttpMessage(1003275);
            httpMessage.addParam("forum_id", this.dQY.bas().getId());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayE() {
        if (this.dQZ != null) {
            this.dQZ.awp();
            if (!v.E(this.dQZ.auE())) {
                ayC();
                if (this.bWZ == null) {
                    this.bWZ = new FragmentTabHost(this.dQU.getActivity());
                    this.bWZ.setClipChildren(false);
                    this.bWZ.setClipToPadding(false);
                    this.bWZ.setup(this.dQU.getSupportFragmentManager());
                    this.bWZ.getFragmentTabWidget().setAbsoluteWeight(true);
                    this.bWZ.setShouldDrawIndicatorLine(false);
                    this.bWZ.setShouldDrawTopLine(true);
                    this.bWZ.n(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds10), 0, 0);
                    this.bWZ.bk(true);
                    this.bWZ.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    this.caW = new FrameLayout(this.dQU.getActivity());
                    this.caW.setClipChildren(false);
                    this.caW.setClipToPadding(false);
                    this.caW.addView(this.bWZ);
                    this.dQU.setContentView(this.caW);
                    this.bWZ.setOnTabSelectionListener(new FragmentTabHost.b() { // from class: com.baidu.tieba.frs.gametab.c.10
                        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
                        public void u(int i, boolean z) {
                            c.this.a(c.this.bWZ.getCurrentFragment(), i);
                        }

                        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
                        public boolean v(int i, boolean z) {
                            String str = null;
                            FragmentTabHost.c fy = c.this.bWZ.fy(i);
                            if (c.this.dQY != null && c.this.dQY.bas() != null) {
                                str = c.this.dQY.bas().getId();
                            }
                            if (fy.mType == 99) {
                                c.this.ayG();
                                TiebaStatic.log(new ak("c12342").s("obj_locate", c.this.c(c.this.bWZ.fy(c.this.bWZ.getCurrentTabIndex()))).ab(ImageViewerConfig.FORUM_ID, str));
                                TiebaStatic.log(new ak("c12334").s("obj_locate", c.this.c(fy)).ab(ImageViewerConfig.FORUM_ID, str));
                                return false;
                            } else if (fy.mType != 5 || TbadkCoreApplication.isLogin()) {
                                TiebaStatic.log(new ak("c12334").s("obj_locate", c.this.c(fy)).ab(ImageViewerConfig.FORUM_ID, str));
                                if (fy.aUy.gX(String.valueOf(fy.mType)) != null) {
                                    if (!(fy.aUy.gX(String.valueOf(fy.mType)).view.getVisibility() == 0)) {
                                        if (c.this.dRd == i) {
                                            c.this.b(fy);
                                        }
                                    } else {
                                        fy.aUy.gX(String.valueOf(fy.mType)).view.setVisibility(8);
                                        c.this.b(fy);
                                    }
                                }
                                c.this.dRd = i;
                                return true;
                            } else {
                                ay.aZ(c.this.dQU.getPageContext().getPageActivity());
                                return false;
                            }
                        }
                    });
                } else {
                    this.bWZ.reset();
                }
                List<com.baidu.tbadk.mainTab.b> auE = this.dQZ.auE();
                List<FrsTabInfo> awo = this.dQZ.awo();
                if (awo.size() == auE.size()) {
                    int size = awo.size();
                    for (int i = 0; i < size; i++) {
                        com.baidu.tbadk.mainTab.b bVar = auE.get(i);
                        if (bVar != null) {
                            FrsTabInfo frsTabInfo = awo.get(i);
                            if (frsTabInfo == null || TextUtils.isEmpty(frsTabInfo.tab_name)) {
                                a(bVar, bVar.MV(), bVar.bi(this.dQU.getActivity()), null);
                            } else {
                                a(bVar, bVar.MV(), bVar.bi(this.dQU.getActivity()), frsTabInfo.tab_name);
                            }
                        }
                    }
                } else {
                    for (com.baidu.tbadk.mainTab.b bVar2 : auE) {
                        a(bVar2, bVar2.MV(), bVar2.bi(this.dQU.getActivity()), null);
                    }
                }
                this.bWZ.BO();
                this.bWZ.fw(2);
                this.bWZ.bj(true);
                this.bWZ.setViewPagerScrollable(false);
                final int nA = nA(this.dRb);
                if (nA < 0) {
                    nA = nA(this.dQY.bvB());
                }
                if (nA < 0) {
                    nA = ayI();
                }
                if (nA < 0) {
                    nA = 0;
                }
                this.dRd = nA;
                this.bWZ.setCurrentTab(nA);
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.c.11
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.this.bWZ != null) {
                            c.this.a(c.this.bWZ.getCurrentFragment(), nA);
                        }
                    }
                });
                this.dQV.fL(this.dQU.getResources().getString(d.j.ala_follow_live_enter_live_square_txt).equals(this.mForumName));
                ayF();
                this.bWZ.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(FragmentTabHost.c cVar) {
        if (cVar.mType == 2 && (cVar.aUz instanceof com.baidu.tieba.frs.gametab.livetab.b)) {
            ((com.baidu.tieba.frs.gametab.livetab.b) cVar.aUz).lY("FrsGameLive");
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

    private void ayF() {
        if (this.bWZ != null && this.bWZ.fz(99) != null) {
            if (this.dQX == null || this.dQX.getParent() == null) {
                if (this.dQX == null) {
                    this.dQX = new ImageView(this.dQU.getActivity());
                }
                int t = l.t(this.dQU.getActivity(), d.e.ds80);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(t, t);
                layoutParams.gravity = 81;
                layoutParams.bottomMargin = l.t(this.dQU.getActivity(), d.e.ds5);
                this.dQX.setLayoutParams(layoutParams);
                aj.c(this.dQX, d.f.icon_tabbar_add_n);
                aj.s(this.dQX, d.f.icon_tabbar_chaticon_n);
                this.dQX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.c.12
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        String str = null;
                        c.this.ayG();
                        if (c.this.bWZ != null) {
                            if (c.this.dQY != null && c.this.dQY.bas() != null) {
                                str = c.this.dQY.bas().getId();
                            }
                            TiebaStatic.log(new ak("c12342").s("obj_locate", c.this.c(c.this.bWZ.fy(c.this.bWZ.getCurrentTabIndex()))).ab(ImageViewerConfig.FORUM_ID, str));
                            TiebaStatic.log(new ak("c12334").s("obj_locate", 99).ab(ImageViewerConfig.FORUM_ID, str));
                        }
                    }
                });
                if (this.dQX.getParent() == null) {
                    this.caW.addView(this.dQX);
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
        NavigationBar avk;
        if ((fragment instanceof am) && this.dQY != null && this.dQY.bas() != null && (avk = ((am) fragment).avk()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.dQY.bas().getName(), 5, true, true) + this.dQU.getActivity().getString(d.j.forum));
            avk.setCenterTextTitle(sb.toString());
        }
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, com.baidu.tbadk.mainTab.e eVar, String str) {
        boolean z = true;
        if (cVar != null) {
            FragmentTabHost.c cVar2 = new FragmentTabHost.c();
            cVar2.aUz = cVar.bxZ;
            if (cVar2.aUz.getArguments() == null) {
                Bundle bundle = new Bundle();
                bundle.putString("name", this.dQY.bas().getName());
                bundle.putString("from", this.dQY.bas().getSpecialForumType());
                bundle.putString(ImageViewerConfig.FORUM_ID, this.dQY.bas().getId());
                cVar2.aUz.setArguments(bundle);
            } else {
                cVar2.aUz.getArguments().putString(ImageViewerConfig.FORUM_ID, this.dQY.bas().getId());
            }
            cVar2.mType = cVar.type;
            if (cVar.byh == com.baidu.tbadk.mainTab.c.bye && cVar.type == 99) {
                eVar.aJ(9, -((int) this.dQU.getResources().getDimension(d.e.ds12)));
            } else if (!TextUtils.isEmpty(str)) {
                eVar.setText(str);
            } else {
                eVar.setText(cVar.bya);
            }
            eVar.setTextSize(0, this.dQU.getResources().getDimension(d.e.ds30));
            eVar.setTextColorResId(d.C0140d.s_game_frs_tabbar_text_color);
            eVar.setCompoundDrawablesTopResId(cVar.byb);
            eVar.setContentTvTopMargin(this.dQU.getResources().getDimensionPixelSize(d.e.ds2));
            eVar.gB(TbadkCoreApplication.getInst().getSkinType());
            eVar.setTipPosType(1);
            eVar.setIsContentSelectBold(false);
            if (cVar.byh != com.baidu.tbadk.mainTab.c.bye || cVar.type != 99) {
                z = false;
            }
            if (!z && (eVar instanceof FragmentTabIndicator)) {
                eVar.a(String.valueOf(cVar2.mType), a((FragmentTabIndicator) eVar));
            }
            cVar2.aUy = eVar;
            cVar2.aUA = bVar;
            this.bWZ.a(cVar2);
        }
    }

    private e.a a(FragmentTabIndicator fragmentTabIndicator) {
        int dimensionPixelSize = this.dQU.getResources().getDimensionPixelSize(d.e.ds12);
        ImageView imageView = new ImageView(this.dQU);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        imageView.setImageResource(d.f.icon_frs_tab_new_notify_red_point);
        e.a aVar = new e.a();
        fragmentTabIndicator.setTipPosType(1);
        fragmentTabIndicator.setTipTopMargin(this.dQU.getResources().getDimensionPixelSize(d.e.ds12));
        aVar.byu = fragmentTabIndicator;
        aVar.aiE = this.dQU.getResources().getDimensionPixelSize(d.e.ds12);
        aVar.view = imageView;
        aVar.view.setVisibility(8);
        return aVar;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.dQV instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.dQV.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a jc(int i) {
        if (this.dQV instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.dQV.jc(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.dQV instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.dQV.a(bVar);
        }
    }

    public void onNewIntent(Intent intent) {
        if (this.dQV != null) {
            this.dQV.onNewIntent(intent);
        }
    }

    public void onResume() {
        if (this.bWZ == null) {
            this.dQV.setPrimary(true);
            return;
        }
        Fragment currentFragment = this.bWZ.getCurrentFragment();
        if (currentFragment instanceof BaseFragment) {
            ((BaseFragment) currentFragment).setPrimary(true);
        }
    }

    public void onPause() {
        if (this.bWZ == null) {
            this.dQV.setPrimary(false);
            return;
        }
        Fragment currentFragment = this.bWZ.getCurrentFragment();
        if (currentFragment instanceof BaseFragment) {
            ((BaseFragment) currentFragment).setPrimary(false);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bWZ == null) {
            this.dQV.onChangeSkinType(i);
        } else {
            this.bWZ.bj(true);
            this.bWZ.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.dQX != null) {
            aj.c(this.dQX, d.f.icon_tabbar_add_n);
            aj.s(this.dQX, d.f.icon_tabbar_chaticon_n);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.bWZ != null && this.dQW != null && this.dQW.isShowing()) {
                this.dQW.bFJ();
            } else if (this.dQV != null && this.dQV.isAdded()) {
                if (this.dQV.onKeyDown(i, keyEvent)) {
                    return true;
                }
                this.dQV.closeActivity();
            } else {
                return this.dQU.e(i, keyEvent);
            }
            return false;
        }
        return this.dQU.e(i, keyEvent);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        com.baidu.tbadk.coreExtra.c.d shareItem;
        if (this.bWZ == null) {
            this.dQV.onActivityResult(i, i2, intent);
        } else {
            this.bWZ.getCurrentFragment().onActivityResult(i, i2, intent);
        }
        if (i2 == -1 && i == 24007) {
            int intExtra = intent.getIntExtra("extra_share_status", 2);
            int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
            if (intExtra == 1 && (shareItem = TbadkCoreApplication.getInst().getShareItem()) != null && shareItem.linkUrl != null && this.dRe != null) {
                this.dRe.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.frs.gametab.c.2
                    @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                    public void HR() {
                    }

                    @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                    public void a(final CustomDialogData customDialogData) {
                        com.baidu.adp.lib.g.e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.c.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (c.this.dQU != null) {
                                    com.baidu.tieba.pb.interactionpopupwindow.c.a(c.this.dQU.getPageContext(), customDialogData).show();
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
        if (this.bWZ == null) {
            return this.dQV.getVoiceManager();
        }
        Fragment currentFragment = this.bWZ.getCurrentFragment();
        if (currentFragment instanceof VoiceManager.c) {
            return ((VoiceManager.c) currentFragment).getVoiceManager();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void ayG() {
        if (ay.ba(this.dQU) && !this.dRf.bAx() && !ayH()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921032));
            if (this.dQW == null) {
                this.dQW = new com.baidu.tieba.write.c(this.dQU.getPageContext(), this.caW, "frs");
                this.dQW.uo("2");
            }
            this.dQW.a(this.dQV.avo());
            this.dQW.nC(false);
        }
    }

    public boolean ayH() {
        String fixedText;
        if (this.dQV == null || !this.dQV.isAdded() || this.dQV.getPageContext() == null) {
            return false;
        }
        com.baidu.tieba.tbadkCore.l avl = this.dQV.avl();
        if (avl == null) {
            return false;
        }
        if (ay.ba(this.dQV.getPageContext().getPageActivity())) {
            AntiData yn = avl.yn();
            if (yn != null) {
                if (a(yn.getBlock_stat(), yn.mFrsForbidenDialogInfo)) {
                    return true;
                }
                if (yn.getIfpost() == 0 && !StringUtils.isNull(yn.getForbid_info())) {
                    String forbid_info = yn.getForbid_info();
                    if (com.baidu.tbadk.core.util.am.es(forbid_info) > 14) {
                        forbid_info = com.baidu.tbadk.core.util.am.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                    }
                    BdToast b = BdToast.b(this.dQV.getPageContext().getPageActivity(), forbid_info, d.f.icon_toast_game_error);
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.dQV.getResources().getString(d.j.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast b = BdToast.b(this.dQV.getPageContext().getPageActivity(), string, d.f.icon_toast_game_error);
            b.aa(1.25f);
            b.Bc();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dQV.getPageContext().getPageActivity());
        aVar.dk(com.baidu.tbadk.core.util.am.getFixedText(string, 50, true));
        aVar.b(com.baidu.tbadk.core.util.am.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.dQV.getResources().getString(d.j.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.gametab.c.3
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
                    aw.Du().c(c.this.dQV.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.dQV.getPageContext()).AU();
        return true;
    }

    private int ayI() {
        if (this.dQZ == null) {
            return -1;
        }
        int D = v.D(this.dQZ.awo());
        for (int i = 0; i < D; i++) {
            if (this.dQZ.awo().get(i).tab_id.intValue() == 1) {
                return i;
            }
        }
        return -1;
    }

    private int nA(int i) {
        if (this.dQZ == null) {
            return -1;
        }
        int D = v.D(this.dQZ.awo());
        for (int i2 = 0; i2 < D; i2++) {
            if (this.dQZ.awo().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    public i ayJ() {
        return this.dQV;
    }

    public void onDestroy() {
        if (this.dQU.isLoadingViewAttached()) {
            this.dQU.hideLoadingView(this.dQU.findViewById(16908290));
        }
        if (this.dRj != null) {
            com.baidu.adp.lib.g.e.ns().removeCallbacks(this.dRj);
        }
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(this.dRc, false);
        if (this.dRe != null) {
            this.dRe.cancelLoadData();
        }
    }
}
