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
import com.baidu.tieba.tbadkCore.j;
import com.baidu.tieba.tbadkCore.m;
import com.sina.weibo.sdk.statistic.StatisticConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes2.dex */
public class c implements VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b {
    private FragmentTabHost bWQ;
    private FrameLayout caN;
    private FrsActivity dQN;
    private i dQO;
    private com.baidu.tieba.write.c dQP;
    private ImageView dQQ;
    private j dQR;
    private af dQS;
    private int dQW;
    private ShareSuccessReplyToServerModel dQX;
    private com.baidu.tieba.p.a dQY;
    private String mForumName;
    private boolean dQT = false;
    private Handler mHandler = new Handler();
    private int dQU = 0;
    private com.baidu.adp.framework.listener.a dQZ = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FRS_HTTP_CMD, 301001) { // from class: com.baidu.tieba.frs.gametab.c.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            j jVar = null;
            if (!c.this.dQT && !responsedMessage.hasError()) {
                if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                    jVar = ((FrsPageHttpResponseMessage) responsedMessage).getResponseData();
                } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                    jVar = ((FRSPageSocketResponsedMessage) responsedMessage).getResponseData();
                }
                if (jVar != null) {
                    c.this.dQT = true;
                    c.this.c(jVar);
                }
            }
        }
    };
    private CustomMessageListener dRa = new CustomMessageListener(2001615) { // from class: com.baidu.tieba.frs.gametab.c.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!c.this.dQT && customResponsedMessage != null && (customResponsedMessage.getData() instanceof j)) {
                j jVar = (j) customResponsedMessage.getData();
                if (jVar.bas() != null && c.this.mForumName != null && c.this.mForumName.equals(jVar.bas().getName())) {
                    c.this.c(jVar);
                }
            }
        }
    };
    private HttpMessageListener dRb = new HttpMessageListener(0) { // from class: com.baidu.tieba.frs.gametab.c.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && 1003275 == httpResponsedMessage.getCmd() && (httpResponsedMessage instanceof AlaGameTabGetNewNotifyResponsedMessage)) {
                List<a> newNotifyData = ((AlaGameTabGetNewNotifyResponsedMessage) httpResponsedMessage).getNewNotifyData();
                if (!v.E(newNotifyData)) {
                    for (a aVar : newNotifyData) {
                        if (aVar != null) {
                            for (int i = 0; i < c.this.dQS.awp().size(); i++) {
                                FragmentTabHost.c fy = c.this.bWQ.fy(i);
                                if (fy.mType != 99 && fy.mType != 1 && fy.mType != c.this.bWQ.getCurrentTabType() && fy.mType == aVar.getTabId() && aVar.ayA() && fy.aUo.gX(String.valueOf(fy.mType)) != null) {
                                    fy.aUo.gX(String.valueOf(fy.mType)).view.setVisibility(0);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private Runnable dRc = new Runnable() { // from class: com.baidu.tieba.frs.gametab.c.7
        @Override // java.lang.Runnable
        public void run() {
            e.ns().removeCallbacks(this);
            c.this.ayE();
            e.ns().postDelayed(this, StatisticConfig.MIN_UPLOAD_INTERVAL);
        }
    };
    private String dQV = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_game_forem_tab_hot_point");

    public c(FrsActivity frsActivity) {
        this.dQN = frsActivity;
    }

    public void init(Bundle bundle) {
        this.dQZ.getHttpMessageListener().setPriority(-1);
        this.dQZ.getSocketMessageListener().setPriority(-1);
        this.dQN.registerListener(this.dRa);
        if (bundle == null) {
            this.mForumName = this.dQN.getIntent().getStringExtra("name");
            this.dQU = this.dQN.getIntent().getIntExtra(FrsActivityConfig.FRS_GAME_DEFAULT_TAB_ID, 0);
        } else {
            this.mForumName = bundle.getString("name");
            this.dQU = bundle.getInt("default_tab_id", 0);
        }
        n(bundle);
        this.dQX = new ShareSuccessReplyToServerModel();
        this.dQN.registerListener(this.dQZ);
        this.dQY = new com.baidu.tieba.p.a(this.dQN.getPageContext());
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.mForumName);
        bundle.putInt("default_tab_id", this.dQU);
    }

    private void n(Bundle bundle) {
        if (this.dQO == null) {
            this.dQO = new i();
            this.dQO.setArguments(bundle);
        }
        FragmentManager supportFragmentManager = this.dQN.getSupportFragmentManager();
        if (!supportFragmentManager.isDestroyed()) {
            FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
            beginTransaction.add(16908290, this.dQO);
            beginTransaction.commitAllowingStateLoss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(j jVar) {
        if (v.D(jVar.bvC()) > 0) {
            this.dQR = jVar;
            if (!this.dQN.isLoadingViewAttached() && this.bWQ == null) {
                this.dQN.showLoadingView(this.dQN.findViewById(16908290));
            }
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.c.8
                @Override // java.lang.Runnable
                public void run() {
                    c.this.bs(c.this.dQR.bvC());
                }
            });
        } else if (this.bWQ != null) {
            this.caN.removeView(this.bWQ);
            this.bWQ = null;
            this.dQS = null;
            if (this.dQQ != null && this.dQQ.getParent() != null) {
                ((ViewGroup) this.dQQ.getParent()).removeView(this.dQQ);
            }
            n(null);
        }
    }

    private boolean ayB() {
        FragmentManager supportFragmentManager = this.dQN.getSupportFragmentManager();
        try {
            supportFragmentManager.beginTransaction().remove(this.dQO).commitAllowingStateLoss();
            supportFragmentManager.executePendingTransactions();
            return true;
        } catch (IllegalStateException e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bs(List<FrsTabInfo> list) {
        if (this.dQN.isLoadingViewAttached()) {
            this.dQN.hideLoadingView(this.dQN.findViewById(16908290));
        }
        if (this.bWQ == null && ayB()) {
            ayC();
            bt(list);
        }
    }

    private void ayC() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003275, TbConfig.SERVER_ADDRESS + "game/forum/getNewNotify");
        tbHttpMessageTask.setResponsedClass(AlaGameTabGetNewNotifyResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.dQN.registerListener(1003275, this.dRb);
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
                        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(c.this.dQV, true)) {
                            e.ns().post(c.this.dRc);
                        }
                        c.this.ayF();
                    }
                }
            };
            customMessageListener.setPriority(Integer.MAX_VALUE);
            customMessageListener.setSelfListener(true);
            this.dQN.registerListener(customMessageListener);
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
            builder.tab_name = this.dQN.getResources().getString(d.j.send);
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
            this.dQS = new af(this.dQN.getActivity(), list2);
            if (ayK() != null) {
                this.dQS.setForumId(ayK().getForumId());
                this.dQS.setForumName(ayK().getForumName());
                if (ayK().avl() != null && ayK().avl().bas() != null) {
                    this.dQS.setForumGameLabel(ayK().avl().bas().getForumGameLabel());
                    this.dQS.lJ(ayK().avl().bas().getSpecialForumType());
                }
            }
            new d(this.dQO).a(this.dQS);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001616, this.dQS);
            CustomMessage customMessage = new CustomMessage(2001616);
            customMessage.setTag(this.dQN.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    private void ayD() {
        int ayJ = ayJ();
        if (ayJ >= 0) {
            a(this.dQO, ayJ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayE() {
        if (this.dQS != null && !TextUtils.isEmpty(this.dQS.getForumId())) {
            HttpMessage httpMessage = new HttpMessage(1003275);
            httpMessage.addParam("forum_id", this.dQR.bas().getId());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayF() {
        if (this.dQS != null) {
            this.dQS.awq();
            if (!v.E(this.dQS.auE())) {
                ayD();
                if (this.bWQ == null) {
                    this.bWQ = new FragmentTabHost(this.dQN.getActivity());
                    this.bWQ.setClipChildren(false);
                    this.bWQ.setClipToPadding(false);
                    this.bWQ.setup(this.dQN.getSupportFragmentManager());
                    this.bWQ.getFragmentTabWidget().setAbsoluteWeight(true);
                    this.bWQ.setShouldDrawIndicatorLine(false);
                    this.bWQ.setShouldDrawTopLine(true);
                    this.bWQ.n(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds10), 0, 0);
                    this.bWQ.bk(true);
                    this.bWQ.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    this.caN = new FrameLayout(this.dQN.getActivity());
                    this.caN.setClipChildren(false);
                    this.caN.setClipToPadding(false);
                    this.caN.addView(this.bWQ);
                    this.dQN.setContentView(this.caN);
                    this.bWQ.setOnTabSelectionListener(new FragmentTabHost.b() { // from class: com.baidu.tieba.frs.gametab.c.10
                        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
                        public void u(int i, boolean z) {
                            c.this.a(c.this.bWQ.getCurrentFragment(), i);
                        }

                        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
                        public boolean v(int i, boolean z) {
                            String str = null;
                            FragmentTabHost.c fy = c.this.bWQ.fy(i);
                            if (c.this.dQR != null && c.this.dQR.bas() != null) {
                                str = c.this.dQR.bas().getId();
                            }
                            if (fy.mType == 99) {
                                c.this.ayH();
                                TiebaStatic.log(new ak("c12342").s("obj_locate", c.this.c(c.this.bWQ.fy(c.this.bWQ.getCurrentTabIndex()))).ab(ImageViewerConfig.FORUM_ID, str));
                                TiebaStatic.log(new ak("c12334").s("obj_locate", c.this.c(fy)).ab(ImageViewerConfig.FORUM_ID, str));
                                return false;
                            } else if (fy.mType != 5 || TbadkCoreApplication.isLogin()) {
                                TiebaStatic.log(new ak("c12334").s("obj_locate", c.this.c(fy)).ab(ImageViewerConfig.FORUM_ID, str));
                                if (fy.aUo.gX(String.valueOf(fy.mType)) != null) {
                                    if (!(fy.aUo.gX(String.valueOf(fy.mType)).view.getVisibility() == 0)) {
                                        if (c.this.dQW == i) {
                                            c.this.b(fy);
                                        }
                                    } else {
                                        fy.aUo.gX(String.valueOf(fy.mType)).view.setVisibility(8);
                                        c.this.b(fy);
                                    }
                                }
                                c.this.dQW = i;
                                return true;
                            } else {
                                ay.aZ(c.this.dQN.getPageContext().getPageActivity());
                                return false;
                            }
                        }
                    });
                } else {
                    this.bWQ.reset();
                }
                List<com.baidu.tbadk.mainTab.b> auE = this.dQS.auE();
                List<FrsTabInfo> awp = this.dQS.awp();
                if (awp.size() == auE.size()) {
                    int size = awp.size();
                    for (int i = 0; i < size; i++) {
                        com.baidu.tbadk.mainTab.b bVar = auE.get(i);
                        if (bVar != null) {
                            FrsTabInfo frsTabInfo = awp.get(i);
                            if (frsTabInfo == null || TextUtils.isEmpty(frsTabInfo.tab_name)) {
                                a(bVar, bVar.MV(), bVar.bi(this.dQN.getActivity()), null);
                            } else {
                                a(bVar, bVar.MV(), bVar.bi(this.dQN.getActivity()), frsTabInfo.tab_name);
                            }
                        }
                    }
                } else {
                    for (com.baidu.tbadk.mainTab.b bVar2 : auE) {
                        a(bVar2, bVar2.MV(), bVar2.bi(this.dQN.getActivity()), null);
                    }
                }
                this.bWQ.BO();
                this.bWQ.fw(2);
                this.bWQ.bj(true);
                this.bWQ.setViewPagerScrollable(false);
                final int nA = nA(this.dQU);
                if (nA < 0) {
                    nA = nA(this.dQR.bvD());
                }
                if (nA < 0) {
                    nA = ayJ();
                }
                if (nA < 0) {
                    nA = 0;
                }
                this.dQW = nA;
                this.bWQ.setCurrentTab(nA);
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.c.11
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.this.bWQ != null) {
                            c.this.a(c.this.bWQ.getCurrentFragment(), nA);
                        }
                    }
                });
                this.dQO.fL(this.dQN.getResources().getString(d.j.ala_follow_live_enter_live_square_txt).equals(this.mForumName));
                ayG();
                this.bWQ.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(FragmentTabHost.c cVar) {
        if (cVar.mType == 2 && (cVar.aUp instanceof com.baidu.tieba.frs.gametab.livetab.b)) {
            ((com.baidu.tieba.frs.gametab.livetab.b) cVar.aUp).lY("FrsGameLive");
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

    private void ayG() {
        if (this.bWQ != null && this.bWQ.fz(99) != null) {
            if (this.dQQ == null || this.dQQ.getParent() == null) {
                if (this.dQQ == null) {
                    this.dQQ = new ImageView(this.dQN.getActivity());
                }
                int t = l.t(this.dQN.getActivity(), d.e.ds80);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(t, t);
                layoutParams.gravity = 81;
                layoutParams.bottomMargin = l.t(this.dQN.getActivity(), d.e.ds5);
                this.dQQ.setLayoutParams(layoutParams);
                aj.c(this.dQQ, d.f.icon_tabbar_add_n);
                aj.s(this.dQQ, d.f.icon_tabbar_chaticon_n);
                this.dQQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.c.12
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        String str = null;
                        c.this.ayH();
                        if (c.this.bWQ != null) {
                            if (c.this.dQR != null && c.this.dQR.bas() != null) {
                                str = c.this.dQR.bas().getId();
                            }
                            TiebaStatic.log(new ak("c12342").s("obj_locate", c.this.c(c.this.bWQ.fy(c.this.bWQ.getCurrentTabIndex()))).ab(ImageViewerConfig.FORUM_ID, str));
                            TiebaStatic.log(new ak("c12334").s("obj_locate", 99).ab(ImageViewerConfig.FORUM_ID, str));
                        }
                    }
                });
                if (this.dQQ.getParent() == null) {
                    this.caN.addView(this.dQQ);
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
        if ((fragment instanceof am) && this.dQR != null && this.dQR.bas() != null && (avk = ((am) fragment).avk()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.dQR.bas().getName(), 5, true, true) + this.dQN.getActivity().getString(d.j.forum));
            avk.setCenterTextTitle(sb.toString());
        }
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, com.baidu.tbadk.mainTab.e eVar, String str) {
        boolean z = true;
        if (cVar != null) {
            FragmentTabHost.c cVar2 = new FragmentTabHost.c();
            cVar2.aUp = cVar.bxP;
            if (cVar2.aUp.getArguments() == null) {
                Bundle bundle = new Bundle();
                bundle.putString("name", this.dQR.bas().getName());
                bundle.putString("from", this.dQR.bas().getSpecialForumType());
                bundle.putString(ImageViewerConfig.FORUM_ID, this.dQR.bas().getId());
                cVar2.aUp.setArguments(bundle);
            } else {
                cVar2.aUp.getArguments().putString(ImageViewerConfig.FORUM_ID, this.dQR.bas().getId());
            }
            cVar2.mType = cVar.type;
            if (cVar.bxX == com.baidu.tbadk.mainTab.c.bxU && cVar.type == 99) {
                eVar.aJ(9, -((int) this.dQN.getResources().getDimension(d.e.ds12)));
            } else if (!TextUtils.isEmpty(str)) {
                eVar.setText(str);
            } else {
                eVar.setText(cVar.bxQ);
            }
            eVar.setTextSize(0, this.dQN.getResources().getDimension(d.e.ds30));
            eVar.setTextColorResId(d.C0141d.s_game_frs_tabbar_text_color);
            eVar.setCompoundDrawablesTopResId(cVar.bxR);
            eVar.setContentTvTopMargin(this.dQN.getResources().getDimensionPixelSize(d.e.ds2));
            eVar.gB(TbadkCoreApplication.getInst().getSkinType());
            eVar.setTipPosType(1);
            eVar.setIsContentSelectBold(false);
            if (cVar.bxX != com.baidu.tbadk.mainTab.c.bxU || cVar.type != 99) {
                z = false;
            }
            if (!z && (eVar instanceof FragmentTabIndicator)) {
                eVar.a(String.valueOf(cVar2.mType), a((FragmentTabIndicator) eVar));
            }
            cVar2.aUo = eVar;
            cVar2.aUq = bVar;
            this.bWQ.a(cVar2);
        }
    }

    private e.a a(FragmentTabIndicator fragmentTabIndicator) {
        int dimensionPixelSize = this.dQN.getResources().getDimensionPixelSize(d.e.ds12);
        ImageView imageView = new ImageView(this.dQN);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        imageView.setImageResource(d.f.icon_frs_tab_new_notify_red_point);
        e.a aVar = new e.a();
        fragmentTabIndicator.setTipPosType(1);
        fragmentTabIndicator.setTipTopMargin(this.dQN.getResources().getDimensionPixelSize(d.e.ds12));
        aVar.byk = fragmentTabIndicator;
        aVar.aiy = this.dQN.getResources().getDimensionPixelSize(d.e.ds12);
        aVar.view = imageView;
        aVar.view.setVisibility(8);
        return aVar;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.dQO instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.dQO.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a jc(int i) {
        if (this.dQO instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.dQO.jc(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.dQO instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.dQO.a(bVar);
        }
    }

    public void onNewIntent(Intent intent) {
        if (this.dQO != null) {
            this.dQO.onNewIntent(intent);
        }
    }

    public void onResume() {
        if (this.bWQ == null) {
            this.dQO.setPrimary(true);
            return;
        }
        Fragment currentFragment = this.bWQ.getCurrentFragment();
        if (currentFragment instanceof BaseFragment) {
            ((BaseFragment) currentFragment).setPrimary(true);
        }
    }

    public void onPause() {
        if (this.bWQ == null) {
            this.dQO.setPrimary(false);
            return;
        }
        Fragment currentFragment = this.bWQ.getCurrentFragment();
        if (currentFragment instanceof BaseFragment) {
            ((BaseFragment) currentFragment).setPrimary(false);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bWQ == null) {
            this.dQO.onChangeSkinType(i);
        } else {
            this.bWQ.bj(true);
            this.bWQ.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.dQQ != null) {
            aj.c(this.dQQ, d.f.icon_tabbar_add_n);
            aj.s(this.dQQ, d.f.icon_tabbar_chaticon_n);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.bWQ != null && this.dQP != null && this.dQP.isShowing()) {
                this.dQP.bFN();
            } else if (this.dQO != null && this.dQO.isAdded()) {
                if (this.dQO.onKeyDown(i, keyEvent)) {
                    return true;
                }
                this.dQO.closeActivity();
            } else {
                return this.dQN.e(i, keyEvent);
            }
            return false;
        }
        return this.dQN.e(i, keyEvent);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        com.baidu.tbadk.coreExtra.c.d shareItem;
        if (this.bWQ == null) {
            this.dQO.onActivityResult(i, i2, intent);
        } else {
            this.bWQ.getCurrentFragment().onActivityResult(i, i2, intent);
        }
        if (i2 == -1 && i == 24007) {
            int intExtra = intent.getIntExtra("extra_share_status", 2);
            int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
            if (intExtra == 1 && (shareItem = TbadkCoreApplication.getInst().getShareItem()) != null && shareItem.linkUrl != null && this.dQX != null) {
                this.dQX.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.frs.gametab.c.2
                    @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                    public void HR() {
                    }

                    @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                    public void a(final CustomDialogData customDialogData) {
                        com.baidu.adp.lib.g.e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.c.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (c.this.dQN != null) {
                                    com.baidu.tieba.pb.interactionpopupwindow.c.a(c.this.dQN.getPageContext(), customDialogData).show();
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
        if (this.bWQ == null) {
            return this.dQO.getVoiceManager();
        }
        Fragment currentFragment = this.bWQ.getCurrentFragment();
        if (currentFragment instanceof VoiceManager.c) {
            return ((VoiceManager.c) currentFragment).getVoiceManager();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void ayH() {
        if (ay.ba(this.dQN) && !this.dQY.bAB() && !ayI()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921032));
            if (this.dQP == null) {
                this.dQP = new com.baidu.tieba.write.c(this.dQN.getPageContext(), this.caN, "frs");
                this.dQP.uo("2");
            }
            this.dQP.a(this.dQO.avo());
            this.dQP.nH(false);
        }
    }

    public boolean ayI() {
        String fixedText;
        if (this.dQO == null || !this.dQO.isAdded() || this.dQO.getPageContext() == null) {
            return false;
        }
        m avl = this.dQO.avl();
        if (avl == null) {
            return false;
        }
        if (ay.ba(this.dQO.getPageContext().getPageActivity())) {
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
                    BdToast b = BdToast.b(this.dQO.getPageContext().getPageActivity(), forbid_info, d.f.icon_toast_game_error);
                    b.aa(1.25f);
                    b.Bd();
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.dQO.getResources().getString(d.j.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast b = BdToast.b(this.dQO.getPageContext().getPageActivity(), string, d.f.icon_toast_game_error);
            b.aa(1.25f);
            b.Bd();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dQO.getPageContext().getPageActivity());
        aVar.dk(com.baidu.tbadk.core.util.am.getFixedText(string, 50, true));
        aVar.b(com.baidu.tbadk.core.util.am.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.dQO.getResources().getString(d.j.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.gametab.c.3
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
                    aw.Du().c(c.this.dQO.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.dQO.getPageContext()).AV();
        return true;
    }

    private int ayJ() {
        if (this.dQS == null) {
            return -1;
        }
        int D = v.D(this.dQS.awp());
        for (int i = 0; i < D; i++) {
            if (this.dQS.awp().get(i).tab_id.intValue() == 1) {
                return i;
            }
        }
        return -1;
    }

    private int nA(int i) {
        if (this.dQS == null) {
            return -1;
        }
        int D = v.D(this.dQS.awp());
        for (int i2 = 0; i2 < D; i2++) {
            if (this.dQS.awp().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    public i ayK() {
        return this.dQO;
    }

    public void onDestroy() {
        if (this.dQN.isLoadingViewAttached()) {
            this.dQN.hideLoadingView(this.dQN.findViewById(16908290));
        }
        if (this.dRc != null) {
            com.baidu.adp.lib.g.e.ns().removeCallbacks(this.dRc);
        }
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(this.dQV, false);
        if (this.dQX != null) {
            this.dQX.cancelLoadData();
        }
    }
}
