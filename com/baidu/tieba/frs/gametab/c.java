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
import com.baidu.tieba.frs.ae;
import com.baidu.tieba.frs.f;
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
    private FragmentTabHost bho;
    private FrameLayout bli;
    private ImageView cWA;
    private h cWB;
    private ae cWC;
    private ShareSuccessReplyToServerModel cWG;
    private FrsActivity cWx;
    private f cWy;
    private com.baidu.tieba.write.c cWz;
    private String mForumName;
    private boolean cWD = false;
    private Handler mHandler = new Handler();
    private int cWE = 0;
    private com.baidu.adp.framework.listener.a cWH = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FRS_HTTP_CMD, 301001) { // from class: com.baidu.tieba.frs.gametab.c.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            h hVar = null;
            if (!c.this.cWD && !responsedMessage.hasError()) {
                if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                    hVar = ((FrsPageHttpResponseMessage) responsedMessage).getResponseData();
                } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                    hVar = ((FRSPageSocketResponsedMessage) responsedMessage).getResponseData();
                }
                if (hVar != null) {
                    c.this.cWD = true;
                    c.this.c(hVar);
                }
            }
        }
    };
    private CustomMessageListener cWI = new CustomMessageListener(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE) { // from class: com.baidu.tieba.frs.gametab.c.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!c.this.cWD && customResponsedMessage != null && (customResponsedMessage.getData() instanceof h)) {
                h hVar = (h) customResponsedMessage.getData();
                if (hVar.aRf() != null && c.this.mForumName != null && c.this.mForumName.equals(hVar.aRf().getName())) {
                    c.this.c(hVar);
                }
            }
        }
    };
    private HttpMessageListener cWJ = new HttpMessageListener(0) { // from class: com.baidu.tieba.frs.gametab.c.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && 1003275 == httpResponsedMessage.getCmd() && (httpResponsedMessage instanceof AlaGameTabGetNewNotifyResponsedMessage)) {
                List<a> newNotifyData = ((AlaGameTabGetNewNotifyResponsedMessage) httpResponsedMessage).getNewNotifyData();
                if (!v.w(newNotifyData)) {
                    for (a aVar : newNotifyData) {
                        if (aVar != null) {
                            for (int i = 0; i < c.this.cWC.amr().size(); i++) {
                                FragmentTabHost.c cB = c.this.bho.cB(i);
                                if (cB.mType != 99 && cB.mType != 1 && cB.mType != c.this.bho.getCurrentTabType() && cB.mType == aVar.getTabId() && aVar.apk() && cB.aeI.gD(String.valueOf(cB.mType)) != null) {
                                    cB.aeI.gD(String.valueOf(cB.mType)).view.setVisibility(0);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private Runnable cWK = new Runnable() { // from class: com.baidu.tieba.frs.gametab.c.7
        @Override // java.lang.Runnable
        public void run() {
            e.fP().removeCallbacks(this);
            c.this.apo();
            e.fP().postDelayed(this, 30000L);
        }
    };
    private String cWF = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_game_forem_tab_hot_point");

    public c(FrsActivity frsActivity) {
        this.cWx = frsActivity;
    }

    public void init(Bundle bundle) {
        this.cWH.getHttpMessageListener().setPriority(-1);
        this.cWH.getSocketMessageListener().setPriority(-1);
        this.cWx.registerListener(this.cWI);
        if (bundle == null) {
            this.mForumName = this.cWx.getIntent().getStringExtra("name");
            this.cWE = this.cWx.getIntent().getIntExtra(FrsActivityConfig.FRS_GAME_DEFAULT_TAB_ID, 0);
        } else {
            this.mForumName = bundle.getString("name");
            this.cWE = bundle.getInt("default_tab_id", 0);
        }
        j(bundle);
        this.cWG = new ShareSuccessReplyToServerModel();
        this.cWx.registerListener(this.cWH);
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.mForumName);
        bundle.putInt("default_tab_id", this.cWE);
    }

    private void j(Bundle bundle) {
        if (this.cWy == null) {
            this.cWy = new f();
            this.cWy.setArguments(bundle);
        }
        FragmentTransaction beginTransaction = this.cWx.getSupportFragmentManager().beginTransaction();
        beginTransaction.add(16908290, this.cWy);
        beginTransaction.commitAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(h hVar) {
        if (v.v(hVar.buU()) > 0) {
            this.cWB = hVar;
            if (!this.cWx.isLoadingViewAttached() && this.bho == null) {
                this.cWx.showLoadingView(this.cWx.findViewById(16908290));
            }
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.c.8
                @Override // java.lang.Runnable
                public void run() {
                    c.this.bh(c.this.cWB.buU());
                }
            });
        } else if (this.bho != null) {
            this.bli.removeView(this.bho);
            this.bho = null;
            this.cWC = null;
            if (this.cWA != null && this.cWA.getParent() != null) {
                ((ViewGroup) this.cWA.getParent()).removeView(this.cWA);
            }
            j((Bundle) null);
        }
    }

    private boolean apl() {
        FragmentManager supportFragmentManager = this.cWx.getSupportFragmentManager();
        try {
            supportFragmentManager.beginTransaction().remove(this.cWy).commitAllowingStateLoss();
            supportFragmentManager.executePendingTransactions();
            return true;
        } catch (IllegalStateException e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bh(List<FrsTabInfo> list) {
        if (this.bho == null && apl()) {
            apm();
            bi(list);
        }
        if (this.cWx.isLoadingViewAttached()) {
            this.cWx.hideLoadingView(this.cWx.findViewById(16908290));
        }
    }

    private void apm() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003275, TbConfig.SERVER_ADDRESS + "game/forum/getNewNotify");
        tbHttpMessageTask.setResponsedClass(AlaGameTabGetNewNotifyResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.cWx.registerListener(1003275, this.cWJ);
    }

    private void bi(List<FrsTabInfo> list) {
        List list2;
        boolean z;
        if (!v.w(list)) {
            CustomMessageListener customMessageListener = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB) { // from class: com.baidu.tieba.frs.gametab.c.9
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ae)) {
                        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(c.this.cWF, true)) {
                            e.fP().post(c.this.cWK);
                        }
                        c.this.app();
                    }
                }
            };
            customMessageListener.setPriority(Integer.MAX_VALUE);
            customMessageListener.setSelfListener(true);
            this.cWx.registerListener(customMessageListener);
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
            builder.tab_name = this.cWx.getResources().getString(d.j.send);
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
            this.cWC = new ae(this.cWx.getActivity(), list2);
            if (akI() != null) {
                this.cWC.setForumId(akI().getForumId());
                this.cWC.setForumName(akI().getForumName());
                if (akI().alv() != null && akI().alv().aRf() != null) {
                    this.cWC.setForumGameLabel(akI().alv().aRf().getForumGameLabel());
                }
            }
            new d(this.cWy).a(this.cWC);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB, this.cWC);
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB);
            customMessage.setTag(this.cWx.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    private void apn() {
        int apt = apt();
        if (apt >= 0) {
            a(this.cWy, apt);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apo() {
        if (this.cWC != null && !TextUtils.isEmpty(this.cWC.getForumId())) {
            HttpMessage httpMessage = new HttpMessage(1003275);
            httpMessage.addParam("forum_id", this.cWB.aRf().getId());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void app() {
        if (this.cWC != null) {
            this.cWC.ams();
            if (!v.w(this.cWC.amt())) {
                apn();
                if (this.bho == null) {
                    this.bho = new FragmentTabHost(this.cWx.getActivity());
                    this.bho.setClipChildren(false);
                    this.bho.setClipToPadding(false);
                    this.bho.setup(this.cWx.getSupportFragmentManager());
                    this.bho.setShouldDrawIndicatorLine(false);
                    this.bho.setShouldDrawTopLine(true);
                    this.bho.f(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds10), 0, 0);
                    this.bho.ay(true);
                    this.bho.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    this.bli = new FrameLayout(this.cWx.getActivity());
                    this.bli.setClipChildren(false);
                    this.bli.setClipToPadding(false);
                    this.bli.addView(this.bho);
                    this.cWx.setContentView(this.bli);
                    this.bho.setOnTabSelectionListener(new FragmentTabHost.b() { // from class: com.baidu.tieba.frs.gametab.c.10
                        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
                        public void e(int i, boolean z) {
                            c.this.a(c.this.bho.getCurrentFragment(), i);
                        }

                        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
                        public boolean f(int i, boolean z) {
                            String str = null;
                            FragmentTabHost.c cB = c.this.bho.cB(i);
                            if (c.this.cWB != null && c.this.cWB.aRf() != null) {
                                str = c.this.cWB.aRf().getId();
                            }
                            if (cB.mType != 99) {
                                TiebaStatic.log(new ak("c12334").r("obj_locate", c.this.b(cB)).ac(ImageViewerConfig.FORUM_ID, str));
                                if (cB.mType != 1 && cB.aeI.gD(String.valueOf(cB.mType)) != null) {
                                    if (!(cB.aeI.gD(String.valueOf(cB.mType)).view.getVisibility() == 0)) {
                                        return true;
                                    }
                                    cB.aeI.gD(String.valueOf(cB.mType)).view.setVisibility(8);
                                    if (cB.mType == 2 && (cB.aeJ instanceof com.baidu.tieba.frs.gametab.livetab.b)) {
                                        ((com.baidu.tieba.frs.gametab.livetab.b) cB.aeJ).Qo();
                                    } else if (cB.mType == 3) {
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FORCE_REFRESH, "GoodsTab_3"));
                                    } else if (cB.mType == 101) {
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FORCE_REFRESH, "InfoTab_101"));
                                    }
                                }
                                return true;
                            }
                            c.this.apr();
                            TiebaStatic.log(new ak("c12342").r("obj_locate", c.this.b(c.this.bho.cB(c.this.bho.getCurrentTabIndex()))).ac(ImageViewerConfig.FORUM_ID, str));
                            TiebaStatic.log(new ak("c12334").r("obj_locate", c.this.b(cB)).ac(ImageViewerConfig.FORUM_ID, str));
                            return false;
                        }
                    });
                } else {
                    this.bho.reset();
                }
                List<com.baidu.tbadk.mainTab.b> amt = this.cWC.amt();
                List<FrsTabInfo> amr = this.cWC.amr();
                if (amr.size() == amt.size()) {
                    int size = amr.size();
                    for (int i = 0; i < size; i++) {
                        com.baidu.tbadk.mainTab.b bVar = amt.get(i);
                        if (bVar != null) {
                            FrsTabInfo frsTabInfo = amr.get(i);
                            if (frsTabInfo == null || TextUtils.isEmpty(frsTabInfo.tab_name)) {
                                a(bVar, bVar.EZ(), bVar.bd(this.cWx.getActivity()), null);
                            } else {
                                a(bVar, bVar.EZ(), bVar.bd(this.cWx.getActivity()), frsTabInfo.tab_name);
                            }
                        }
                    }
                } else {
                    for (com.baidu.tbadk.mainTab.b bVar2 : amt) {
                        a(bVar2, bVar2.EZ(), bVar2.bd(this.cWx.getActivity()), null);
                    }
                }
                this.bho.uf();
                this.bho.cz(2);
                this.bho.ax(true);
                this.bho.setViewPagerScrollable(false);
                final int kC = kC(this.cWE);
                if (kC < 0) {
                    kC = kC(this.cWB.buV());
                }
                if (kC < 0) {
                    kC = apt();
                }
                if (kC < 0) {
                    kC = 0;
                }
                this.bho.setCurrentTab(kC);
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.c.11
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.this.bho != null) {
                            c.this.a(c.this.bho.getCurrentFragment(), kC);
                        }
                    }
                });
                apq();
                this.bho.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    private void apq() {
        if (this.bho != null && this.bho.cC(99) != null) {
            if (this.cWA == null || this.cWA.getParent() == null) {
                if (this.cWA == null) {
                    this.cWA = new ImageView(this.cWx.getActivity());
                }
                int f = l.f(this.cWx.getActivity(), d.e.ds80);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(f, f);
                layoutParams.gravity = 81;
                layoutParams.bottomMargin = l.f(this.cWx.getActivity(), d.e.ds5);
                this.cWA.setLayoutParams(layoutParams);
                aj.c(this.cWA, d.f.icon_tabbar_add_n);
                aj.j(this.cWA, d.f.icon_tabbar_chaticon_n);
                this.cWA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.c.12
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        String str = null;
                        c.this.apr();
                        if (c.this.bho != null) {
                            if (c.this.cWB != null && c.this.cWB.aRf() != null) {
                                str = c.this.cWB.aRf().getId();
                            }
                            TiebaStatic.log(new ak("c12342").r("obj_locate", c.this.b(c.this.bho.cB(c.this.bho.getCurrentTabIndex()))).ac(ImageViewerConfig.FORUM_ID, str));
                            TiebaStatic.log(new ak("c12334").r("obj_locate", 99).ac(ImageViewerConfig.FORUM_ID, str));
                        }
                    }
                });
                if (this.cWA.getParent() == null) {
                    this.bli.addView(this.cWA);
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
        NavigationBar alu;
        if ((fragment instanceof com.baidu.tieba.frs.ak) && this.cWB != null && this.cWB.aRf() != null && (alu = ((com.baidu.tieba.frs.ak) fragment).alu()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.cWB.aRf().getName(), 5, true, true) + this.cWx.getActivity().getString(d.j.forum));
            FrsTabInfo frsTabInfo = (FrsTabInfo) v.c(this.cWC.amr(), i);
            if (frsTabInfo != null) {
                sb.append(" · ");
                sb.append(frsTabInfo.tab_name);
            }
            alu.setCenterTextTitle(sb.toString());
        }
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, com.baidu.tbadk.mainTab.e eVar, String str) {
        if (cVar != null) {
            FragmentTabHost.c cVar2 = new FragmentTabHost.c();
            cVar2.aeJ = cVar.aHC;
            if (cVar2.aeJ.getArguments() == null) {
                Bundle bundle = new Bundle();
                bundle.putString("name", this.cWB.aRf().getName());
                bundle.putString("from", "game_frs");
                bundle.putString(ImageViewerConfig.FORUM_ID, this.cWB.aRf().getId());
                cVar2.aeJ.setArguments(bundle);
            } else {
                cVar2.aeJ.getArguments().putString(ImageViewerConfig.FORUM_ID, this.cWB.aRf().getId());
            }
            cVar2.mType = cVar.type;
            if (cVar.aHK == com.baidu.tbadk.mainTab.c.aHH && cVar.type == 99) {
                eVar.J(9, -((int) this.cWx.getResources().getDimension(d.e.ds12)));
            } else if (!TextUtils.isEmpty(str)) {
                eVar.setText(str);
            } else {
                eVar.setText(cVar.aHD);
            }
            eVar.setTextSize(0, this.cWx.getResources().getDimension(d.e.ds30));
            eVar.setTextColorResId(d.C0082d.s_game_frs_tabbar_text_color);
            eVar.setCompoundDrawablesTopResId(cVar.aHE);
            eVar.setContentTvTopMargin(this.cWx.getResources().getDimensionPixelSize(d.e.ds2));
            eVar.dE(TbadkCoreApplication.getInst().getSkinType());
            eVar.setTipPosType(1);
            eVar.setIsContentSelectBold(true);
            boolean z = cVar.aHK == com.baidu.tbadk.mainTab.c.aHH && cVar.type == 99;
            boolean z2 = cVar.type == 1;
            if (!z && !z2 && (eVar instanceof FragmentTabIndicator)) {
                eVar.a(String.valueOf(cVar2.mType), a((FragmentTabIndicator) eVar));
            }
            cVar2.aeI = eVar;
            cVar2.aeK = bVar;
            this.bho.a(cVar2);
        }
    }

    private e.a a(FragmentTabIndicator fragmentTabIndicator) {
        int dimensionPixelSize = this.cWx.getResources().getDimensionPixelSize(d.e.ds12);
        ImageView imageView = new ImageView(this.cWx);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        imageView.setImageResource(d.f.icon_frs_tab_new_notify_red_point);
        e.a aVar = new e.a();
        fragmentTabIndicator.setTipPosType(1);
        fragmentTabIndicator.setTipTopMargin(this.cWx.getResources().getDimensionPixelSize(d.e.ds12));
        aVar.aHX = fragmentTabIndicator;
        aVar.ur = this.cWx.getResources().getDimensionPixelSize(d.e.ds12);
        aVar.view = imageView;
        aVar.view.setVisibility(8);
        return aVar;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.cWy instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.cWy.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a gl(int i) {
        if (this.cWy instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.cWy.gl(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.cWy instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.cWy.a(bVar);
        }
    }

    public void onNewIntent(Intent intent) {
        if (this.cWy != null) {
            this.cWy.onNewIntent(intent);
        }
    }

    public void onResume() {
        if (this.bho == null) {
            this.cWy.setPrimary(true);
            return;
        }
        Fragment currentFragment = this.bho.getCurrentFragment();
        if (currentFragment instanceof BaseFragment) {
            ((BaseFragment) currentFragment).setPrimary(true);
        }
    }

    public void onPause() {
        if (this.bho == null) {
            this.cWy.setPrimary(false);
            return;
        }
        Fragment currentFragment = this.bho.getCurrentFragment();
        if (currentFragment instanceof BaseFragment) {
            ((BaseFragment) currentFragment).setPrimary(false);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bho == null) {
            this.cWy.onChangeSkinType(i);
        } else {
            this.bho.ax(true);
            this.bho.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.cWA != null) {
            aj.c(this.cWA, d.f.icon_tabbar_add_n);
            aj.j(this.cWA, d.f.icon_tabbar_chaticon_n);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.bho != null && this.cWz != null && this.cWz.isShowing()) {
                this.cWz.bEZ();
            } else if (this.cWy != null && this.cWy.isAdded()) {
                if (this.cWy.onKeyDown(i, keyEvent)) {
                    return true;
                }
                this.cWy.closeActivity();
            } else {
                return this.cWx.b(i, keyEvent);
            }
            return false;
        }
        return this.cWx.b(i, keyEvent);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        com.baidu.tbadk.coreExtra.c.d shareItem;
        if (this.bho == null) {
            this.cWy.onActivityResult(i, i2, intent);
        } else {
            this.bho.getCurrentFragment().onActivityResult(i, i2, intent);
        }
        if (i2 == -1 && i == 24007) {
            int intExtra = intent.getIntExtra("extra_share_status", 2);
            int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
            if (intExtra == 1 && (shareItem = TbadkCoreApplication.getInst().getShareItem()) != null && shareItem.linkUrl != null && this.cWG != null) {
                this.cWG.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.frs.gametab.c.2
                    @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                    public void zL() {
                    }

                    @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                    public void a(final CustomDialogData customDialogData) {
                        com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.c.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (c.this.cWx != null) {
                                    com.baidu.tieba.pb.interactionpopupwindow.c.a(c.this.cWx.getPageContext(), customDialogData).show();
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
        if (this.bho == null) {
            return this.cWy.getVoiceManager();
        }
        Fragment currentFragment = this.bho.getCurrentFragment();
        if (currentFragment instanceof VoiceManager.c) {
            return ((VoiceManager.c) currentFragment).getVoiceManager();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void apr() {
        if (!aps()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE));
            if (this.cWz == null) {
                this.cWz = new com.baidu.tieba.write.c(this.cWx.getPageContext(), this.bli, "frs");
                this.cWz.ux("2");
            }
            this.cWz.a(this.cWy.alz());
            this.cWz.nU(false);
        }
    }

    public boolean aps() {
        String fixedText;
        if (this.cWy == null || !this.cWy.isAdded() || this.cWy.getPageContext() == null) {
            return false;
        }
        k alv = this.cWy.alv();
        if (alv == null) {
            return false;
        }
        if (ax.aV(this.cWy.getPageContext().getPageActivity())) {
            AntiData qi = alv.qi();
            if (qi != null) {
                if (a(qi.getBlock_stat(), qi.mFrsForbidenDialogInfo)) {
                    return true;
                }
                if (qi.getIfpost() == 0 && !StringUtils.isNull(qi.getForbid_info())) {
                    String forbid_info = qi.getForbid_info();
                    if (am.dV(forbid_info) > 14) {
                        forbid_info = am.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                    }
                    BdToast b = BdToast.b(this.cWy.getPageContext().getPageActivity(), forbid_info, d.f.icon_toast_game_error);
                    b.E(1.25f);
                    b.tt();
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.cWy.getResources().getString(d.j.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast b = BdToast.b(this.cWy.getPageContext().getPageActivity(), string, d.f.icon_toast_game_error);
            b.E(1.25f);
            b.tt();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cWy.getPageContext().getPageActivity());
        aVar.cS(am.getFixedText(string, 50, true));
        aVar.b(am.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.cWy.getResources().getString(d.j.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.gametab.c.3
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
                    av.vL().c(c.this.cWy.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.cWy.getPageContext()).tk();
        return true;
    }

    private int apt() {
        if (this.cWC == null) {
            return -1;
        }
        int v = v.v(this.cWC.amr());
        for (int i = 0; i < v; i++) {
            if (this.cWC.amr().get(i).tab_id.intValue() == 1) {
                return i;
            }
        }
        return -1;
    }

    private int kC(int i) {
        if (this.cWC == null) {
            return -1;
        }
        int v = v.v(this.cWC.amr());
        for (int i2 = 0; i2 < v; i2++) {
            if (this.cWC.amr().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    public f akI() {
        return this.cWy;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> akJ() {
        if (this.bho == null) {
            if (this.cWy instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) this.cWy).akJ();
            }
        } else {
            Fragment currentFragment = this.bho.getCurrentFragment();
            if (currentFragment instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) currentFragment).akJ();
            }
        }
        return null;
    }

    public void onDestroy() {
        if (this.cWx.isLoadingViewAttached()) {
            this.cWx.hideLoadingView(this.cWx.findViewById(16908290));
        }
        if (this.cWK != null) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.cWK);
        }
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(this.cWF, false);
        if (this.cWG != null) {
            this.cWG.cancelLoadData();
        }
    }
}
