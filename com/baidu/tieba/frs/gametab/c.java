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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.e;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.af;
import com.baidu.tieba.frs.al;
import com.baidu.tieba.frs.g;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.tbadkCore.FRSPageSocketResponsedMessage;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsPageHttpResponseMessage;
import com.baidu.tieba.tbadkCore.h;
import com.baidu.tieba.tbadkCore.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class c implements VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, FrsCommonImageLayout.c {
    private FragmentTabHost bht;
    private FrameLayout bln;
    private FrsActivity cWM;
    private g cWN;
    private com.baidu.tieba.write.c cWO;
    private ImageView cWP;
    private h cWQ;
    private af cWR;
    private ShareSuccessReplyToServerModel cWV;
    private String mForumName;
    private boolean cWS = false;
    private Handler mHandler = new Handler();
    private int cWT = 0;
    private com.baidu.adp.framework.listener.a cWW = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FRS_HTTP_CMD, 301001) { // from class: com.baidu.tieba.frs.gametab.c.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            h hVar = null;
            if (!c.this.cWS && !responsedMessage.hasError()) {
                if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                    hVar = ((FrsPageHttpResponseMessage) responsedMessage).getResponseData();
                } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                    hVar = ((FRSPageSocketResponsedMessage) responsedMessage).getResponseData();
                }
                if (hVar != null) {
                    c.this.cWS = true;
                    c.this.c(hVar);
                }
            }
        }
    };
    private CustomMessageListener cWX = new CustomMessageListener(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE) { // from class: com.baidu.tieba.frs.gametab.c.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!c.this.cWS && customResponsedMessage != null && (customResponsedMessage.getData() instanceof h)) {
                h hVar = (h) customResponsedMessage.getData();
                if (hVar.aRo() != null && c.this.mForumName != null && c.this.mForumName.equals(hVar.aRo().getName())) {
                    c.this.c(hVar);
                }
            }
        }
    };
    private HttpMessageListener cWY = new HttpMessageListener(0) { // from class: com.baidu.tieba.frs.gametab.c.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && 1003275 == httpResponsedMessage.getCmd() && (httpResponsedMessage instanceof AlaGameTabGetNewNotifyResponsedMessage)) {
                List<a> newNotifyData = ((AlaGameTabGetNewNotifyResponsedMessage) httpResponsedMessage).getNewNotifyData();
                if (!v.w(newNotifyData)) {
                    for (a aVar : newNotifyData) {
                        if (aVar != null) {
                            for (int i = 0; i < c.this.cWR.amA().size(); i++) {
                                FragmentTabHost.c cB = c.this.bht.cB(i);
                                if (cB.mType != 99 && cB.mType != 1 && cB.mType != c.this.bht.getCurrentTabType() && cB.mType == aVar.getTabId() && aVar.apt() && cB.aeF.gC(String.valueOf(cB.mType)) != null) {
                                    cB.aeF.gC(String.valueOf(cB.mType)).view.setVisibility(0);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private Runnable cWZ = new Runnable() { // from class: com.baidu.tieba.frs.gametab.c.7
        @Override // java.lang.Runnable
        public void run() {
            e.fP().removeCallbacks(this);
            c.this.apx();
            e.fP().postDelayed(this, 30000L);
        }
    };
    private String cWU = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_game_forem_tab_hot_point");

    public c(FrsActivity frsActivity) {
        this.cWM = frsActivity;
    }

    public void init(Bundle bundle) {
        this.cWW.getHttpMessageListener().setPriority(-1);
        this.cWW.getSocketMessageListener().setPriority(-1);
        this.cWM.registerListener(this.cWX);
        if (bundle == null) {
            this.mForumName = this.cWM.getIntent().getStringExtra("name");
            this.cWT = this.cWM.getIntent().getIntExtra(FrsActivityConfig.FRS_GAME_DEFAULT_TAB_ID, 0);
        } else {
            this.mForumName = bundle.getString("name");
            this.cWT = bundle.getInt("default_tab_id", 0);
        }
        j(bundle);
        this.cWV = new ShareSuccessReplyToServerModel();
        this.cWM.registerListener(this.cWW);
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.mForumName);
        bundle.putInt("default_tab_id", this.cWT);
    }

    private void j(Bundle bundle) {
        if (this.cWN == null) {
            this.cWN = new g();
            this.cWN.setArguments(bundle);
        }
        FragmentTransaction beginTransaction = this.cWM.getSupportFragmentManager().beginTransaction();
        beginTransaction.add(16908290, this.cWN);
        beginTransaction.commitAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(h hVar) {
        if (v.v(hVar.bvB()) > 0) {
            this.cWQ = hVar;
            if (!this.cWM.isLoadingViewAttached() && this.bht == null) {
                this.cWM.showLoadingView(this.cWM.findViewById(16908290));
            }
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.c.8
                @Override // java.lang.Runnable
                public void run() {
                    c.this.bh(c.this.cWQ.bvB());
                }
            });
        } else if (this.bht != null) {
            this.bln.removeView(this.bht);
            this.bht = null;
            this.cWR = null;
            if (this.cWP != null && this.cWP.getParent() != null) {
                ((ViewGroup) this.cWP.getParent()).removeView(this.cWP);
            }
            j((Bundle) null);
        }
    }

    private boolean apu() {
        FragmentManager supportFragmentManager = this.cWM.getSupportFragmentManager();
        try {
            supportFragmentManager.beginTransaction().remove(this.cWN).commitAllowingStateLoss();
            supportFragmentManager.executePendingTransactions();
            return true;
        } catch (IllegalStateException e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bh(List<FrsTabInfo> list) {
        if (this.bht == null && apu()) {
            apv();
            bi(list);
        }
        if (this.cWM.isLoadingViewAttached()) {
            this.cWM.hideLoadingView(this.cWM.findViewById(16908290));
        }
    }

    private void apv() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003275, TbConfig.SERVER_ADDRESS + "game/forum/getNewNotify");
        tbHttpMessageTask.setResponsedClass(AlaGameTabGetNewNotifyResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.cWM.registerListener(1003275, this.cWY);
    }

    private void bi(List<FrsTabInfo> list) {
        List list2;
        boolean z;
        if (!v.w(list)) {
            CustomMessageListener customMessageListener = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB) { // from class: com.baidu.tieba.frs.gametab.c.9
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof af)) {
                        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(c.this.cWU, true)) {
                            e.fP().post(c.this.cWZ);
                        }
                        c.this.apy();
                    }
                }
            };
            customMessageListener.setPriority(Integer.MAX_VALUE);
            customMessageListener.setSelfListener(true);
            this.cWM.registerListener(customMessageListener);
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
            builder.tab_name = this.cWM.getResources().getString(d.j.send);
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
            this.cWR = new af(this.cWM.getActivity(), list2);
            if (akP() != null) {
                this.cWR.setForumId(akP().getForumId());
                this.cWR.setForumName(akP().getForumName());
                if (akP().alE() != null && akP().alE().aRo() != null) {
                    this.cWR.setForumGameLabel(akP().alE().aRo().getForumGameLabel());
                }
            }
            new d(this.cWN).a(this.cWR);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB, this.cWR);
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB);
            customMessage.setTag(this.cWM.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    private void apw() {
        int apC = apC();
        if (apC >= 0) {
            a(this.cWN, apC);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apx() {
        if (this.cWR != null && !TextUtils.isEmpty(this.cWR.getForumId())) {
            HttpMessage httpMessage = new HttpMessage(1003275);
            httpMessage.addParam("forum_id", this.cWQ.aRo().getId());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apy() {
        if (this.cWR != null) {
            this.cWR.amB();
            if (!v.w(this.cWR.amC())) {
                apw();
                if (this.bht == null) {
                    this.bht = new FragmentTabHost(this.cWM.getActivity());
                    this.bht.setClipChildren(false);
                    this.bht.setClipToPadding(false);
                    this.bht.setup(this.cWM.getSupportFragmentManager());
                    this.bht.setShouldDrawIndicatorLine(false);
                    this.bht.setShouldDrawTopLine(true);
                    this.bht.f(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds10), 0, 0);
                    this.bht.ay(true);
                    this.bht.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    this.bln = new FrameLayout(this.cWM.getActivity());
                    this.bln.setClipChildren(false);
                    this.bln.setClipToPadding(false);
                    this.bln.addView(this.bht);
                    this.cWM.setContentView(this.bln);
                    this.bht.setOnTabSelectionListener(new FragmentTabHost.b() { // from class: com.baidu.tieba.frs.gametab.c.10
                        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
                        public void e(int i, boolean z) {
                            c.this.a(c.this.bht.getCurrentFragment(), i);
                        }

                        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
                        public boolean f(int i, boolean z) {
                            String str = null;
                            FragmentTabHost.c cB = c.this.bht.cB(i);
                            if (c.this.cWQ != null && c.this.cWQ.aRo() != null) {
                                str = c.this.cWQ.aRo().getId();
                            }
                            if (cB.mType != 99) {
                                TiebaStatic.log(new ak("c12334").r("obj_locate", c.this.b(cB)).ac(ImageViewerConfig.FORUM_ID, str));
                                if (cB.mType != 1 && cB.aeF.gC(String.valueOf(cB.mType)) != null) {
                                    if (!(cB.aeF.gC(String.valueOf(cB.mType)).view.getVisibility() == 0)) {
                                        return true;
                                    }
                                    cB.aeF.gC(String.valueOf(cB.mType)).view.setVisibility(8);
                                    if (cB.mType == 2 && (cB.aeG instanceof com.baidu.tieba.frs.gametab.livetab.b)) {
                                        ((com.baidu.tieba.frs.gametab.livetab.b) cB.aeG).Qo();
                                    } else if (cB.mType == 3) {
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FORCE_REFRESH, "GoodsTab_3"));
                                    } else if (cB.mType == 101) {
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FORCE_REFRESH, "InfoTab_101"));
                                    }
                                }
                                return true;
                            }
                            c.this.apA();
                            TiebaStatic.log(new ak("c12342").r("obj_locate", c.this.b(c.this.bht.cB(c.this.bht.getCurrentTabIndex()))).ac(ImageViewerConfig.FORUM_ID, str));
                            TiebaStatic.log(new ak("c12334").r("obj_locate", c.this.b(cB)).ac(ImageViewerConfig.FORUM_ID, str));
                            return false;
                        }
                    });
                } else {
                    this.bht.reset();
                }
                List<com.baidu.tbadk.mainTab.b> amC = this.cWR.amC();
                List<FrsTabInfo> amA = this.cWR.amA();
                if (amA.size() == amC.size()) {
                    int size = amA.size();
                    for (int i = 0; i < size; i++) {
                        com.baidu.tbadk.mainTab.b bVar = amC.get(i);
                        if (bVar != null) {
                            FrsTabInfo frsTabInfo = amA.get(i);
                            if (frsTabInfo == null || TextUtils.isEmpty(frsTabInfo.tab_name)) {
                                a(bVar, bVar.Fa(), bVar.ba(this.cWM.getActivity()), null);
                            } else {
                                a(bVar, bVar.Fa(), bVar.ba(this.cWM.getActivity()), frsTabInfo.tab_name);
                            }
                        }
                    }
                } else {
                    for (com.baidu.tbadk.mainTab.b bVar2 : amC) {
                        a(bVar2, bVar2.Fa(), bVar2.ba(this.cWM.getActivity()), null);
                    }
                }
                this.bht.uc();
                this.bht.cz(2);
                this.bht.ax(true);
                this.bht.setViewPagerScrollable(false);
                final int kE = kE(this.cWT);
                if (kE < 0) {
                    kE = kE(this.cWQ.bvC());
                }
                if (kE < 0) {
                    kE = apC();
                }
                if (kE < 0) {
                    kE = 0;
                }
                this.bht.setCurrentTab(kE);
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.c.11
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.this.bht != null) {
                            c.this.a(c.this.bht.getCurrentFragment(), kE);
                        }
                    }
                });
                apz();
                this.bht.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    private void apz() {
        if (this.bht != null && this.bht.cC(99) != null) {
            if (this.cWP == null || this.cWP.getParent() == null) {
                if (this.cWP == null) {
                    this.cWP = new ImageView(this.cWM.getActivity());
                }
                int f = l.f(this.cWM.getActivity(), d.e.ds80);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(f, f);
                layoutParams.gravity = 81;
                layoutParams.bottomMargin = l.f(this.cWM.getActivity(), d.e.ds5);
                this.cWP.setLayoutParams(layoutParams);
                aj.c(this.cWP, d.f.icon_tabbar_add_n);
                aj.j(this.cWP, d.f.icon_tabbar_chaticon_n);
                this.cWP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.c.12
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        String str = null;
                        c.this.apA();
                        if (c.this.bht != null) {
                            if (c.this.cWQ != null && c.this.cWQ.aRo() != null) {
                                str = c.this.cWQ.aRo().getId();
                            }
                            TiebaStatic.log(new ak("c12342").r("obj_locate", c.this.b(c.this.bht.cB(c.this.bht.getCurrentTabIndex()))).ac(ImageViewerConfig.FORUM_ID, str));
                            TiebaStatic.log(new ak("c12334").r("obj_locate", 99).ac(ImageViewerConfig.FORUM_ID, str));
                        }
                    }
                });
                if (this.cWP.getParent() == null) {
                    this.bln.addView(this.cWP);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(FragmentTabHost.c cVar) {
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
        return cVar.mType == 99 ? 5 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Fragment fragment, int i) {
        NavigationBar alD;
        if ((fragment instanceof al) && this.cWQ != null && this.cWQ.aRo() != null && (alD = ((al) fragment).alD()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.cWQ.aRo().getName(), 5, true, true) + this.cWM.getActivity().getString(d.j.forum));
            FrsTabInfo frsTabInfo = (FrsTabInfo) v.c(this.cWR.amA(), i);
            if (frsTabInfo != null) {
                sb.append(" · ");
                sb.append(frsTabInfo.tab_name);
            }
            alD.setCenterTextTitle(sb.toString());
        }
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, com.baidu.tbadk.mainTab.e eVar, String str) {
        if (cVar != null) {
            FragmentTabHost.c cVar2 = new FragmentTabHost.c();
            cVar2.aeG = cVar.aHJ;
            if (cVar2.aeG.getArguments() == null) {
                Bundle bundle = new Bundle();
                bundle.putString("name", this.cWQ.aRo().getName());
                bundle.putString("from", "game_frs");
                bundle.putString(ImageViewerConfig.FORUM_ID, this.cWQ.aRo().getId());
                cVar2.aeG.setArguments(bundle);
            } else {
                cVar2.aeG.getArguments().putString(ImageViewerConfig.FORUM_ID, this.cWQ.aRo().getId());
            }
            cVar2.mType = cVar.type;
            if (cVar.aHR == com.baidu.tbadk.mainTab.c.aHO && cVar.type == 99) {
                eVar.K(9, -((int) this.cWM.getResources().getDimension(d.e.ds12)));
            } else if (!TextUtils.isEmpty(str)) {
                eVar.setText(str);
            } else {
                eVar.setText(cVar.aHK);
            }
            eVar.setTextSize(0, this.cWM.getResources().getDimension(d.e.ds30));
            eVar.setTextColorResId(d.C0095d.s_game_frs_tabbar_text_color);
            eVar.setCompoundDrawablesTopResId(cVar.aHL);
            eVar.setContentTvTopMargin(this.cWM.getResources().getDimensionPixelSize(d.e.ds2));
            eVar.dE(TbadkCoreApplication.getInst().getSkinType());
            eVar.setTipPosType(1);
            eVar.setIsContentSelectBold(true);
            boolean z = cVar.aHR == com.baidu.tbadk.mainTab.c.aHO && cVar.type == 99;
            boolean z2 = cVar.type == 1;
            if (!z && !z2 && (eVar instanceof FragmentTabIndicator)) {
                eVar.a(String.valueOf(cVar2.mType), a((FragmentTabIndicator) eVar));
            }
            cVar2.aeF = eVar;
            cVar2.aeH = bVar;
            this.bht.a(cVar2);
        }
    }

    private e.a a(FragmentTabIndicator fragmentTabIndicator) {
        int dimensionPixelSize = this.cWM.getResources().getDimensionPixelSize(d.e.ds12);
        ImageView imageView = new ImageView(this.cWM);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        imageView.setImageResource(d.f.icon_frs_tab_new_notify_red_point);
        e.a aVar = new e.a();
        fragmentTabIndicator.setTipPosType(1);
        fragmentTabIndicator.setTipTopMargin(this.cWM.getResources().getDimensionPixelSize(d.e.ds12));
        aVar.aIe = fragmentTabIndicator;
        aVar.up = this.cWM.getResources().getDimensionPixelSize(d.e.ds12);
        aVar.view = imageView;
        aVar.view.setVisibility(8);
        return aVar;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.cWN instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.cWN.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a gl(int i) {
        if (this.cWN instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.cWN.gl(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.cWN instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.cWN.a(bVar);
        }
    }

    public void onNewIntent(Intent intent) {
        if (this.cWN != null) {
            this.cWN.onNewIntent(intent);
        }
    }

    public void onResume() {
        if (this.bht == null) {
            this.cWN.setPrimary(true);
            return;
        }
        Fragment currentFragment = this.bht.getCurrentFragment();
        if (currentFragment instanceof BaseFragment) {
            ((BaseFragment) currentFragment).setPrimary(true);
        }
    }

    public void onPause() {
        if (this.bht == null) {
            this.cWN.setPrimary(false);
            return;
        }
        Fragment currentFragment = this.bht.getCurrentFragment();
        if (currentFragment instanceof BaseFragment) {
            ((BaseFragment) currentFragment).setPrimary(false);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bht == null) {
            this.cWN.onChangeSkinType(i);
        } else {
            this.bht.ax(true);
            this.bht.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.cWP != null) {
            aj.c(this.cWP, d.f.icon_tabbar_add_n);
            aj.j(this.cWP, d.f.icon_tabbar_chaticon_n);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.bht != null && this.cWO != null && this.cWO.isShowing()) {
                this.cWO.bFL();
            } else if (this.cWN != null && this.cWN.isAdded()) {
                if (this.cWN.onKeyDown(i, keyEvent)) {
                    return true;
                }
                this.cWN.closeActivity();
            } else {
                return this.cWM.b(i, keyEvent);
            }
            return false;
        }
        return this.cWM.b(i, keyEvent);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        com.baidu.tbadk.coreExtra.c.d shareItem;
        if (this.bht == null) {
            this.cWN.onActivityResult(i, i2, intent);
        } else {
            this.bht.getCurrentFragment().onActivityResult(i, i2, intent);
        }
        if (i2 == -1 && i == 24007) {
            int intExtra = intent.getIntExtra("extra_share_status", 2);
            int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
            if (intExtra == 1 && (shareItem = TbadkCoreApplication.getInst().getShareItem()) != null && shareItem.linkUrl != null && this.cWV != null) {
                this.cWV.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.frs.gametab.c.2
                    @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                    public void zM() {
                    }

                    @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                    public void a(final CustomDialogData customDialogData) {
                        com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.c.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (c.this.cWM != null) {
                                    com.baidu.tieba.pb.interactionpopupwindow.c.a(c.this.cWM.getPageContext(), customDialogData).show();
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
        if (this.bht == null) {
            return this.cWN.getVoiceManager();
        }
        Fragment currentFragment = this.bht.getCurrentFragment();
        if (currentFragment instanceof VoiceManager.c) {
            return ((VoiceManager.c) currentFragment).getVoiceManager();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void apA() {
        if (!apB()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE));
            if (this.cWO == null) {
                this.cWO = new com.baidu.tieba.write.c(this.cWM.getPageContext(), this.bln, "frs");
                this.cWO.uC("2");
            }
            this.cWO.a(this.cWN.alI());
            this.cWO.nV(false);
        }
    }

    public boolean apB() {
        String fixedText;
        if (this.cWN == null || !this.cWN.isAdded() || this.cWN.getPageContext() == null) {
            return false;
        }
        k alE = this.cWN.alE();
        if (alE == null) {
            return false;
        }
        if (ax.aS(this.cWN.getPageContext().getPageActivity())) {
            AntiData qg = alE.qg();
            if (qg != null) {
                if (a(qg.getBlock_stat(), qg.mFrsForbidenDialogInfo)) {
                    return true;
                }
                if (qg.getIfpost() == 0 && !StringUtils.isNull(qg.getForbid_info())) {
                    String forbid_info = qg.getForbid_info();
                    if (am.dV(forbid_info) > 14) {
                        forbid_info = am.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                    }
                    BdToast b = BdToast.b(this.cWN.getPageContext().getPageActivity(), forbid_info, d.f.icon_toast_game_error);
                    b.E(1.25f);
                    b.tq();
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.cWN.getResources().getString(d.j.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast b = BdToast.b(this.cWN.getPageContext().getPageActivity(), string, d.f.icon_toast_game_error);
            b.E(1.25f);
            b.tq();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cWN.getPageContext().getPageActivity());
        aVar.cS(am.getFixedText(string, 50, true));
        aVar.b(am.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.cWN.getResources().getString(d.j.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.gametab.c.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (aVar2 != null) {
                    aVar2.dismiss();
                }
            }
        });
        if (!StringUtils.isNull(blockPopInfoData.ahead_info) && !StringUtils.isNull(blockPopInfoData.ahead_url)) {
            aVar.a(am.getFixedText(blockPopInfoData.ahead_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.gametab.c.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    av.vI().c(c.this.cWN.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.cWN.getPageContext()).th();
        return true;
    }

    private int apC() {
        if (this.cWR == null) {
            return -1;
        }
        int v = v.v(this.cWR.amA());
        for (int i = 0; i < v; i++) {
            if (this.cWR.amA().get(i).tab_id.intValue() == 1) {
                return i;
            }
        }
        return -1;
    }

    private int kE(int i) {
        if (this.cWR == null) {
            return -1;
        }
        int v = v.v(this.cWR.amA());
        for (int i2 = 0; i2 < v; i2++) {
            if (this.cWR.amA().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    public g akP() {
        return this.cWN;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> akQ() {
        if (this.bht == null) {
            if (this.cWN instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) this.cWN).akQ();
            }
        } else {
            Fragment currentFragment = this.bht.getCurrentFragment();
            if (currentFragment instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) currentFragment).akQ();
            }
        }
        return null;
    }

    public void onDestroy() {
        if (this.cWM.isLoadingViewAttached()) {
            this.cWM.hideLoadingView(this.cWM.findViewById(16908290));
        }
        if (this.cWZ != null) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.cWZ);
        }
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(this.cWU, false);
        if (this.cWV != null) {
            this.cWV.cancelLoadData();
        }
    }
}
