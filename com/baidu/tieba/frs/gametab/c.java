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
    private FragmentTabHost bhp;
    private FrameLayout blj;
    private FrsActivity cWI;
    private g cWJ;
    private com.baidu.tieba.write.c cWK;
    private ImageView cWL;
    private h cWM;
    private af cWN;
    private ShareSuccessReplyToServerModel cWR;
    private String mForumName;
    private boolean cWO = false;
    private Handler mHandler = new Handler();
    private int cWP = 0;
    private com.baidu.adp.framework.listener.a cWS = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FRS_HTTP_CMD, 301001) { // from class: com.baidu.tieba.frs.gametab.c.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            h hVar = null;
            if (!c.this.cWO && !responsedMessage.hasError()) {
                if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                    hVar = ((FrsPageHttpResponseMessage) responsedMessage).getResponseData();
                } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                    hVar = ((FRSPageSocketResponsedMessage) responsedMessage).getResponseData();
                }
                if (hVar != null) {
                    c.this.cWO = true;
                    c.this.c(hVar);
                }
            }
        }
    };
    private CustomMessageListener cWT = new CustomMessageListener(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE) { // from class: com.baidu.tieba.frs.gametab.c.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!c.this.cWO && customResponsedMessage != null && (customResponsedMessage.getData() instanceof h)) {
                h hVar = (h) customResponsedMessage.getData();
                if (hVar.aRn() != null && c.this.mForumName != null && c.this.mForumName.equals(hVar.aRn().getName())) {
                    c.this.c(hVar);
                }
            }
        }
    };
    private HttpMessageListener cWU = new HttpMessageListener(0) { // from class: com.baidu.tieba.frs.gametab.c.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && 1003275 == httpResponsedMessage.getCmd() && (httpResponsedMessage instanceof AlaGameTabGetNewNotifyResponsedMessage)) {
                List<a> newNotifyData = ((AlaGameTabGetNewNotifyResponsedMessage) httpResponsedMessage).getNewNotifyData();
                if (!v.w(newNotifyData)) {
                    for (a aVar : newNotifyData) {
                        if (aVar != null) {
                            for (int i = 0; i < c.this.cWN.amz().size(); i++) {
                                FragmentTabHost.c cB = c.this.bhp.cB(i);
                                if (cB.mType != 99 && cB.mType != 1 && cB.mType != c.this.bhp.getCurrentTabType() && cB.mType == aVar.getTabId() && aVar.aps() && cB.aeC.gC(String.valueOf(cB.mType)) != null) {
                                    cB.aeC.gC(String.valueOf(cB.mType)).view.setVisibility(0);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private Runnable cWV = new Runnable() { // from class: com.baidu.tieba.frs.gametab.c.7
        @Override // java.lang.Runnable
        public void run() {
            e.fP().removeCallbacks(this);
            c.this.apw();
            e.fP().postDelayed(this, 30000L);
        }
    };
    private String cWQ = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_game_forem_tab_hot_point");

    public c(FrsActivity frsActivity) {
        this.cWI = frsActivity;
    }

    public void init(Bundle bundle) {
        this.cWS.getHttpMessageListener().setPriority(-1);
        this.cWS.getSocketMessageListener().setPriority(-1);
        this.cWI.registerListener(this.cWT);
        if (bundle == null) {
            this.mForumName = this.cWI.getIntent().getStringExtra("name");
            this.cWP = this.cWI.getIntent().getIntExtra(FrsActivityConfig.FRS_GAME_DEFAULT_TAB_ID, 0);
        } else {
            this.mForumName = bundle.getString("name");
            this.cWP = bundle.getInt("default_tab_id", 0);
        }
        j(bundle);
        this.cWR = new ShareSuccessReplyToServerModel();
        this.cWI.registerListener(this.cWS);
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.mForumName);
        bundle.putInt("default_tab_id", this.cWP);
    }

    private void j(Bundle bundle) {
        if (this.cWJ == null) {
            this.cWJ = new g();
            this.cWJ.setArguments(bundle);
        }
        FragmentTransaction beginTransaction = this.cWI.getSupportFragmentManager().beginTransaction();
        beginTransaction.add(16908290, this.cWJ);
        beginTransaction.commitAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(h hVar) {
        if (v.v(hVar.bvA()) > 0) {
            this.cWM = hVar;
            if (!this.cWI.isLoadingViewAttached() && this.bhp == null) {
                this.cWI.showLoadingView(this.cWI.findViewById(16908290));
            }
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.c.8
                @Override // java.lang.Runnable
                public void run() {
                    c.this.bh(c.this.cWM.bvA());
                }
            });
        } else if (this.bhp != null) {
            this.blj.removeView(this.bhp);
            this.bhp = null;
            this.cWN = null;
            if (this.cWL != null && this.cWL.getParent() != null) {
                ((ViewGroup) this.cWL.getParent()).removeView(this.cWL);
            }
            j((Bundle) null);
        }
    }

    private boolean apt() {
        FragmentManager supportFragmentManager = this.cWI.getSupportFragmentManager();
        try {
            supportFragmentManager.beginTransaction().remove(this.cWJ).commitAllowingStateLoss();
            supportFragmentManager.executePendingTransactions();
            return true;
        } catch (IllegalStateException e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bh(List<FrsTabInfo> list) {
        if (this.bhp == null && apt()) {
            apu();
            bi(list);
        }
        if (this.cWI.isLoadingViewAttached()) {
            this.cWI.hideLoadingView(this.cWI.findViewById(16908290));
        }
    }

    private void apu() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003275, TbConfig.SERVER_ADDRESS + "game/forum/getNewNotify");
        tbHttpMessageTask.setResponsedClass(AlaGameTabGetNewNotifyResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.cWI.registerListener(1003275, this.cWU);
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
                        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(c.this.cWQ, true)) {
                            e.fP().post(c.this.cWV);
                        }
                        c.this.apx();
                    }
                }
            };
            customMessageListener.setPriority(Integer.MAX_VALUE);
            customMessageListener.setSelfListener(true);
            this.cWI.registerListener(customMessageListener);
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
            builder.tab_name = this.cWI.getResources().getString(d.j.send);
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
            this.cWN = new af(this.cWI.getActivity(), list2);
            if (akP() != null) {
                this.cWN.setForumId(akP().getForumId());
                this.cWN.setForumName(akP().getForumName());
                if (akP().alE() != null && akP().alE().aRn() != null) {
                    this.cWN.setForumGameLabel(akP().alE().aRn().getForumGameLabel());
                }
            }
            new d(this.cWJ).a(this.cWN);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB, this.cWN);
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB);
            customMessage.setTag(this.cWI.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    private void apv() {
        int apB = apB();
        if (apB >= 0) {
            a(this.cWJ, apB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apw() {
        if (this.cWN != null && !TextUtils.isEmpty(this.cWN.getForumId())) {
            HttpMessage httpMessage = new HttpMessage(1003275);
            httpMessage.addParam("forum_id", this.cWM.aRn().getId());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apx() {
        if (this.cWN != null) {
            this.cWN.amA();
            if (!v.w(this.cWN.amB())) {
                apv();
                if (this.bhp == null) {
                    this.bhp = new FragmentTabHost(this.cWI.getActivity());
                    this.bhp.setClipChildren(false);
                    this.bhp.setClipToPadding(false);
                    this.bhp.setup(this.cWI.getSupportFragmentManager());
                    this.bhp.setShouldDrawIndicatorLine(false);
                    this.bhp.setShouldDrawTopLine(true);
                    this.bhp.f(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds10), 0, 0);
                    this.bhp.ay(true);
                    this.bhp.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    this.blj = new FrameLayout(this.cWI.getActivity());
                    this.blj.setClipChildren(false);
                    this.blj.setClipToPadding(false);
                    this.blj.addView(this.bhp);
                    this.cWI.setContentView(this.blj);
                    this.bhp.setOnTabSelectionListener(new FragmentTabHost.b() { // from class: com.baidu.tieba.frs.gametab.c.10
                        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
                        public void e(int i, boolean z) {
                            c.this.a(c.this.bhp.getCurrentFragment(), i);
                        }

                        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
                        public boolean f(int i, boolean z) {
                            String str = null;
                            FragmentTabHost.c cB = c.this.bhp.cB(i);
                            if (c.this.cWM != null && c.this.cWM.aRn() != null) {
                                str = c.this.cWM.aRn().getId();
                            }
                            if (cB.mType != 99) {
                                TiebaStatic.log(new ak("c12334").r("obj_locate", c.this.b(cB)).ac(ImageViewerConfig.FORUM_ID, str));
                                if (cB.mType != 1 && cB.aeC.gC(String.valueOf(cB.mType)) != null) {
                                    if (!(cB.aeC.gC(String.valueOf(cB.mType)).view.getVisibility() == 0)) {
                                        return true;
                                    }
                                    cB.aeC.gC(String.valueOf(cB.mType)).view.setVisibility(8);
                                    if (cB.mType == 2 && (cB.aeD instanceof com.baidu.tieba.frs.gametab.livetab.b)) {
                                        ((com.baidu.tieba.frs.gametab.livetab.b) cB.aeD).Qo();
                                    } else if (cB.mType == 3) {
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FORCE_REFRESH, "GoodsTab_3"));
                                    } else if (cB.mType == 101) {
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FORCE_REFRESH, "InfoTab_101"));
                                    }
                                }
                                return true;
                            }
                            c.this.apz();
                            TiebaStatic.log(new ak("c12342").r("obj_locate", c.this.b(c.this.bhp.cB(c.this.bhp.getCurrentTabIndex()))).ac(ImageViewerConfig.FORUM_ID, str));
                            TiebaStatic.log(new ak("c12334").r("obj_locate", c.this.b(cB)).ac(ImageViewerConfig.FORUM_ID, str));
                            return false;
                        }
                    });
                } else {
                    this.bhp.reset();
                }
                List<com.baidu.tbadk.mainTab.b> amB = this.cWN.amB();
                List<FrsTabInfo> amz = this.cWN.amz();
                if (amz.size() == amB.size()) {
                    int size = amz.size();
                    for (int i = 0; i < size; i++) {
                        com.baidu.tbadk.mainTab.b bVar = amB.get(i);
                        if (bVar != null) {
                            FrsTabInfo frsTabInfo = amz.get(i);
                            if (frsTabInfo == null || TextUtils.isEmpty(frsTabInfo.tab_name)) {
                                a(bVar, bVar.Fa(), bVar.ba(this.cWI.getActivity()), null);
                            } else {
                                a(bVar, bVar.Fa(), bVar.ba(this.cWI.getActivity()), frsTabInfo.tab_name);
                            }
                        }
                    }
                } else {
                    for (com.baidu.tbadk.mainTab.b bVar2 : amB) {
                        a(bVar2, bVar2.Fa(), bVar2.ba(this.cWI.getActivity()), null);
                    }
                }
                this.bhp.uc();
                this.bhp.cz(2);
                this.bhp.ax(true);
                this.bhp.setViewPagerScrollable(false);
                final int kE = kE(this.cWP);
                if (kE < 0) {
                    kE = kE(this.cWM.bvB());
                }
                if (kE < 0) {
                    kE = apB();
                }
                if (kE < 0) {
                    kE = 0;
                }
                this.bhp.setCurrentTab(kE);
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.c.11
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.this.bhp != null) {
                            c.this.a(c.this.bhp.getCurrentFragment(), kE);
                        }
                    }
                });
                apy();
                this.bhp.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    private void apy() {
        if (this.bhp != null && this.bhp.cC(99) != null) {
            if (this.cWL == null || this.cWL.getParent() == null) {
                if (this.cWL == null) {
                    this.cWL = new ImageView(this.cWI.getActivity());
                }
                int f = l.f(this.cWI.getActivity(), d.e.ds80);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(f, f);
                layoutParams.gravity = 81;
                layoutParams.bottomMargin = l.f(this.cWI.getActivity(), d.e.ds5);
                this.cWL.setLayoutParams(layoutParams);
                aj.c(this.cWL, d.f.icon_tabbar_add_n);
                aj.j(this.cWL, d.f.icon_tabbar_chaticon_n);
                this.cWL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.c.12
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        String str = null;
                        c.this.apz();
                        if (c.this.bhp != null) {
                            if (c.this.cWM != null && c.this.cWM.aRn() != null) {
                                str = c.this.cWM.aRn().getId();
                            }
                            TiebaStatic.log(new ak("c12342").r("obj_locate", c.this.b(c.this.bhp.cB(c.this.bhp.getCurrentTabIndex()))).ac(ImageViewerConfig.FORUM_ID, str));
                            TiebaStatic.log(new ak("c12334").r("obj_locate", 99).ac(ImageViewerConfig.FORUM_ID, str));
                        }
                    }
                });
                if (this.cWL.getParent() == null) {
                    this.blj.addView(this.cWL);
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
        if ((fragment instanceof al) && this.cWM != null && this.cWM.aRn() != null && (alD = ((al) fragment).alD()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.cWM.aRn().getName(), 5, true, true) + this.cWI.getActivity().getString(d.j.forum));
            FrsTabInfo frsTabInfo = (FrsTabInfo) v.c(this.cWN.amz(), i);
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
            cVar2.aeD = cVar.aHG;
            if (cVar2.aeD.getArguments() == null) {
                Bundle bundle = new Bundle();
                bundle.putString("name", this.cWM.aRn().getName());
                bundle.putString("from", "game_frs");
                bundle.putString(ImageViewerConfig.FORUM_ID, this.cWM.aRn().getId());
                cVar2.aeD.setArguments(bundle);
            } else {
                cVar2.aeD.getArguments().putString(ImageViewerConfig.FORUM_ID, this.cWM.aRn().getId());
            }
            cVar2.mType = cVar.type;
            if (cVar.aHO == com.baidu.tbadk.mainTab.c.aHL && cVar.type == 99) {
                eVar.K(9, -((int) this.cWI.getResources().getDimension(d.e.ds12)));
            } else if (!TextUtils.isEmpty(str)) {
                eVar.setText(str);
            } else {
                eVar.setText(cVar.aHH);
            }
            eVar.setTextSize(0, this.cWI.getResources().getDimension(d.e.ds30));
            eVar.setTextColorResId(d.C0096d.s_game_frs_tabbar_text_color);
            eVar.setCompoundDrawablesTopResId(cVar.aHI);
            eVar.setContentTvTopMargin(this.cWI.getResources().getDimensionPixelSize(d.e.ds2));
            eVar.dE(TbadkCoreApplication.getInst().getSkinType());
            eVar.setTipPosType(1);
            eVar.setIsContentSelectBold(true);
            boolean z = cVar.aHO == com.baidu.tbadk.mainTab.c.aHL && cVar.type == 99;
            boolean z2 = cVar.type == 1;
            if (!z && !z2 && (eVar instanceof FragmentTabIndicator)) {
                eVar.a(String.valueOf(cVar2.mType), a((FragmentTabIndicator) eVar));
            }
            cVar2.aeC = eVar;
            cVar2.aeE = bVar;
            this.bhp.a(cVar2);
        }
    }

    private e.a a(FragmentTabIndicator fragmentTabIndicator) {
        int dimensionPixelSize = this.cWI.getResources().getDimensionPixelSize(d.e.ds12);
        ImageView imageView = new ImageView(this.cWI);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        imageView.setImageResource(d.f.icon_frs_tab_new_notify_red_point);
        e.a aVar = new e.a();
        fragmentTabIndicator.setTipPosType(1);
        fragmentTabIndicator.setTipTopMargin(this.cWI.getResources().getDimensionPixelSize(d.e.ds12));
        aVar.aIb = fragmentTabIndicator;
        aVar.uo = this.cWI.getResources().getDimensionPixelSize(d.e.ds12);
        aVar.view = imageView;
        aVar.view.setVisibility(8);
        return aVar;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.cWJ instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.cWJ.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a gl(int i) {
        if (this.cWJ instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.cWJ.gl(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.cWJ instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.cWJ.a(bVar);
        }
    }

    public void onNewIntent(Intent intent) {
        if (this.cWJ != null) {
            this.cWJ.onNewIntent(intent);
        }
    }

    public void onResume() {
        if (this.bhp == null) {
            this.cWJ.setPrimary(true);
            return;
        }
        Fragment currentFragment = this.bhp.getCurrentFragment();
        if (currentFragment instanceof BaseFragment) {
            ((BaseFragment) currentFragment).setPrimary(true);
        }
    }

    public void onPause() {
        if (this.bhp == null) {
            this.cWJ.setPrimary(false);
            return;
        }
        Fragment currentFragment = this.bhp.getCurrentFragment();
        if (currentFragment instanceof BaseFragment) {
            ((BaseFragment) currentFragment).setPrimary(false);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bhp == null) {
            this.cWJ.onChangeSkinType(i);
        } else {
            this.bhp.ax(true);
            this.bhp.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.cWL != null) {
            aj.c(this.cWL, d.f.icon_tabbar_add_n);
            aj.j(this.cWL, d.f.icon_tabbar_chaticon_n);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.bhp != null && this.cWK != null && this.cWK.isShowing()) {
                this.cWK.bFK();
            } else if (this.cWJ != null && this.cWJ.isAdded()) {
                if (this.cWJ.onKeyDown(i, keyEvent)) {
                    return true;
                }
                this.cWJ.closeActivity();
            } else {
                return this.cWI.b(i, keyEvent);
            }
            return false;
        }
        return this.cWI.b(i, keyEvent);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        com.baidu.tbadk.coreExtra.c.d shareItem;
        if (this.bhp == null) {
            this.cWJ.onActivityResult(i, i2, intent);
        } else {
            this.bhp.getCurrentFragment().onActivityResult(i, i2, intent);
        }
        if (i2 == -1 && i == 24007) {
            int intExtra = intent.getIntExtra("extra_share_status", 2);
            int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
            if (intExtra == 1 && (shareItem = TbadkCoreApplication.getInst().getShareItem()) != null && shareItem.linkUrl != null && this.cWR != null) {
                this.cWR.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.frs.gametab.c.2
                    @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                    public void zM() {
                    }

                    @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                    public void a(final CustomDialogData customDialogData) {
                        com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.c.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (c.this.cWI != null) {
                                    com.baidu.tieba.pb.interactionpopupwindow.c.a(c.this.cWI.getPageContext(), customDialogData).show();
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
        if (this.bhp == null) {
            return this.cWJ.getVoiceManager();
        }
        Fragment currentFragment = this.bhp.getCurrentFragment();
        if (currentFragment instanceof VoiceManager.c) {
            return ((VoiceManager.c) currentFragment).getVoiceManager();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void apz() {
        if (!apA()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE));
            if (this.cWK == null) {
                this.cWK = new com.baidu.tieba.write.c(this.cWI.getPageContext(), this.blj, "frs");
                this.cWK.uC("2");
            }
            this.cWK.a(this.cWJ.alH());
            this.cWK.nV(false);
        }
    }

    public boolean apA() {
        String fixedText;
        if (this.cWJ == null || !this.cWJ.isAdded() || this.cWJ.getPageContext() == null) {
            return false;
        }
        k alE = this.cWJ.alE();
        if (alE == null) {
            return false;
        }
        if (ax.aS(this.cWJ.getPageContext().getPageActivity())) {
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
                    BdToast b = BdToast.b(this.cWJ.getPageContext().getPageActivity(), forbid_info, d.f.icon_toast_game_error);
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.cWJ.getResources().getString(d.j.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast b = BdToast.b(this.cWJ.getPageContext().getPageActivity(), string, d.f.icon_toast_game_error);
            b.E(1.25f);
            b.tq();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cWJ.getPageContext().getPageActivity());
        aVar.cS(am.getFixedText(string, 50, true));
        aVar.b(am.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.cWJ.getResources().getString(d.j.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.gametab.c.3
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
                    av.vI().c(c.this.cWJ.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.cWJ.getPageContext()).th();
        return true;
    }

    private int apB() {
        if (this.cWN == null) {
            return -1;
        }
        int v = v.v(this.cWN.amz());
        for (int i = 0; i < v; i++) {
            if (this.cWN.amz().get(i).tab_id.intValue() == 1) {
                return i;
            }
        }
        return -1;
    }

    private int kE(int i) {
        if (this.cWN == null) {
            return -1;
        }
        int v = v.v(this.cWN.amz());
        for (int i2 = 0; i2 < v; i2++) {
            if (this.cWN.amz().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    public g akP() {
        return this.cWJ;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> akQ() {
        if (this.bhp == null) {
            if (this.cWJ instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) this.cWJ).akQ();
            }
        } else {
            Fragment currentFragment = this.bhp.getCurrentFragment();
            if (currentFragment instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) currentFragment).akQ();
            }
        }
        return null;
    }

    public void onDestroy() {
        if (this.cWI.isLoadingViewAttached()) {
            this.cWI.hideLoadingView(this.cWI.findViewById(16908290));
        }
        if (this.cWV != null) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.cWV);
        }
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(this.cWQ, false);
        if (this.cWR != null) {
            this.cWR.cancelLoadData();
        }
    }
}
