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
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.e;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.ae;
import com.baidu.tieba.frs.f;
import com.baidu.tieba.tbadkCore.FRSPageSocketResponsedMessage;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsPageHttpResponseMessage;
import com.baidu.tieba.tbadkCore.g;
import com.baidu.tieba.tbadkCore.j;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class c implements VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, FrsCommonImageLayout.c {
    private FrameLayout bIr;
    private FragmentTabHost beb;
    private FrsActivity cNl;
    private f cNm;
    private com.baidu.tieba.write.c cNn;
    private ImageView cNo;
    private g cNp;
    private ae cNq;
    private String mForumName;
    private boolean cNr = false;
    private Handler mHandler = new Handler();
    private int cNs = 0;
    private com.baidu.adp.framework.listener.a cNu = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FRS_HTTP_CMD, 301001) { // from class: com.baidu.tieba.frs.gametab.c.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            g gVar = null;
            if (!c.this.cNr && !responsedMessage.hasError()) {
                if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                    gVar = ((FrsPageHttpResponseMessage) responsedMessage).getResponseData();
                } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                    gVar = ((FRSPageSocketResponsedMessage) responsedMessage).getResponseData();
                }
                if (gVar != null) {
                    c.this.cNr = true;
                    c.this.c(gVar);
                }
            }
        }
    };
    private CustomMessageListener cNv = new CustomMessageListener(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE) { // from class: com.baidu.tieba.frs.gametab.c.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!c.this.cNr && customResponsedMessage != null && (customResponsedMessage.getData() instanceof g)) {
                g gVar = (g) customResponsedMessage.getData();
                if (gVar.aPU() != null && c.this.mForumName != null && c.this.mForumName.equals(gVar.aPU().getName())) {
                    c.this.c(gVar);
                }
            }
        }
    };
    private HttpMessageListener cNw = new HttpMessageListener(0) { // from class: com.baidu.tieba.frs.gametab.c.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && 1003275 == httpResponsedMessage.getCmd() && (httpResponsedMessage instanceof AlaGameTabGetNewNotifyResponsedMessage)) {
                List<a> newNotifyData = ((AlaGameTabGetNewNotifyResponsedMessage) httpResponsedMessage).getNewNotifyData();
                if (!v.v(newNotifyData)) {
                    for (a aVar : newNotifyData) {
                        if (aVar != null) {
                            for (int i = 0; i < c.this.cNq.akv().size(); i++) {
                                FragmentTabHost.c cA = c.this.beb.cA(i);
                                if (cA.mType != 99 && cA.mType != 1 && cA.mType != c.this.beb.getCurrentTabType() && cA.mType == aVar.getTabId() && aVar.anq() && cA.aen.gA(String.valueOf(cA.mType)) != null) {
                                    cA.aen.gA(String.valueOf(cA.mType)).view.setVisibility(0);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private Runnable cNx = new Runnable() { // from class: com.baidu.tieba.frs.gametab.c.6
        @Override // java.lang.Runnable
        public void run() {
            e.fP().removeCallbacks(this);
            c.this.anu();
            e.fP().postDelayed(this, 30000L);
        }
    };
    private String cNt = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_game_forem_tab_hot_point");

    public c(FrsActivity frsActivity) {
        this.cNl = frsActivity;
    }

    public void init(Bundle bundle) {
        this.cNu.getHttpMessageListener().setPriority(-1);
        this.cNu.getSocketMessageListener().setPriority(-1);
        this.cNl.registerListener(this.cNv);
        if (bundle == null) {
            this.mForumName = this.cNl.getIntent().getStringExtra("name");
            this.cNs = this.cNl.getIntent().getIntExtra(FrsActivityConfig.FRS_GAME_DEFAULT_TAB_ID, 0);
        } else {
            this.mForumName = bundle.getString("name");
            this.cNs = bundle.getInt("default_tab_id", 0);
        }
        j(bundle);
        this.cNl.registerListener(this.cNu);
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.mForumName);
        bundle.putInt("default_tab_id", this.cNs);
    }

    private void j(Bundle bundle) {
        if (this.cNm == null) {
            this.cNm = new f();
            this.cNm.setArguments(bundle);
        }
        FragmentTransaction beginTransaction = this.cNl.getSupportFragmentManager().beginTransaction();
        beginTransaction.add(16908290, this.cNm);
        beginTransaction.commitAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(g gVar) {
        if (v.u(gVar.bto()) > 0) {
            this.cNp = gVar;
            if (!this.cNl.isLoadingViewAttached() && this.beb == null) {
                this.cNl.showLoadingView(this.cNl.findViewById(16908290));
            }
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.c.7
                @Override // java.lang.Runnable
                public void run() {
                    c.this.aV(c.this.cNp.bto());
                }
            });
        } else if (this.beb != null) {
            this.bIr.removeView(this.beb);
            this.beb = null;
            this.cNq = null;
            if (this.cNo != null && this.cNo.getParent() != null) {
                ((ViewGroup) this.cNo.getParent()).removeView(this.cNo);
            }
            j((Bundle) null);
        }
    }

    private boolean anr() {
        FragmentManager supportFragmentManager = this.cNl.getSupportFragmentManager();
        try {
            supportFragmentManager.beginTransaction().remove(this.cNm).commitAllowingStateLoss();
            supportFragmentManager.executePendingTransactions();
            return true;
        } catch (IllegalStateException e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aV(List<FrsTabInfo> list) {
        if (this.beb == null && anr()) {
            ans();
            aW(list);
        }
        if (this.cNl.isLoadingViewAttached()) {
            this.cNl.hideLoadingView(this.cNl.findViewById(16908290));
        }
    }

    private void ans() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003275, TbConfig.SERVER_ADDRESS + "game/forum/getNewNotify");
        tbHttpMessageTask.setResponsedClass(AlaGameTabGetNewNotifyResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.cNl.registerListener(1003275, this.cNw);
    }

    private void aW(List<FrsTabInfo> list) {
        if (!v.v(list)) {
            CustomMessageListener customMessageListener = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB) { // from class: com.baidu.tieba.frs.gametab.c.8
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ae)) {
                        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(c.this.cNt, true)) {
                            e.fP().post(c.this.cNx);
                        }
                        c.this.anv();
                    }
                }
            };
            customMessageListener.setPriority(Integer.MAX_VALUE);
            customMessageListener.setSelfListener(true);
            this.cNl.registerListener(customMessageListener);
            List arrayList = new ArrayList(list);
            FrsTabInfo.Builder builder = new FrsTabInfo.Builder();
            builder.tab_id = 99;
            builder.tab_name = this.cNl.getResources().getString(d.j.send);
            builder.tab_type = 0;
            int u = v.u(arrayList);
            if (u > 4) {
                arrayList = arrayList.subList(0, 4);
                arrayList.add(2, builder.build(false));
            } else if (u < 2) {
                arrayList.add(builder.build(false));
            } else {
                arrayList.add(u / 2, builder.build(false));
            }
            this.cNq = new ae(this.cNl.getActivity(), arrayList);
            if (aiO() != null) {
                this.cNq.setForumId(aiO().getForumId());
                this.cNq.setForumName(aiO().getForumName());
                if (aiO().ajB() != null && aiO().ajB().aPU() != null) {
                    this.cNq.setForumGameLabel(aiO().ajB().aPU().getForumGameLabel());
                }
            }
            new d(this.cNm).a(this.cNq);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB, this.cNq);
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB);
            customMessage.setTag(this.cNl.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    private void ant() {
        int anz = anz();
        if (anz >= 0) {
            a(this.cNm, anz);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anu() {
        if (this.cNq != null && !TextUtils.isEmpty(this.cNq.getForumId())) {
            HttpMessage httpMessage = new HttpMessage(1003275);
            httpMessage.addParam("forum_id", this.cNp.aPU().getId());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anv() {
        if (this.cNq != null) {
            this.cNq.akw();
            if (!v.v(this.cNq.akx())) {
                ant();
                if (this.beb == null) {
                    this.beb = new FragmentTabHost(this.cNl.getActivity());
                    this.beb.setClipChildren(false);
                    this.beb.setClipToPadding(false);
                    this.beb.setup(this.cNl.getSupportFragmentManager());
                    this.beb.setShouldDrawIndicatorLine(false);
                    this.beb.setShouldDrawTopLine(true);
                    this.beb.f(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds10), 0, 0);
                    this.beb.ay(true);
                    this.beb.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    this.bIr = new FrameLayout(this.cNl.getActivity());
                    this.bIr.setClipChildren(false);
                    this.bIr.setClipToPadding(false);
                    this.bIr.addView(this.beb);
                    this.cNl.setContentView(this.bIr);
                    this.beb.setOnTabSelectionListener(new FragmentTabHost.b() { // from class: com.baidu.tieba.frs.gametab.c.9
                        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
                        public void e(int i, boolean z) {
                            c.this.a(c.this.beb.getCurrentFragment(), i);
                        }

                        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
                        public boolean f(int i, boolean z) {
                            String str = null;
                            FragmentTabHost.c cA = c.this.beb.cA(i);
                            if (c.this.cNp != null && c.this.cNp.aPU() != null) {
                                str = c.this.cNp.aPU().getId();
                            }
                            if (cA.mType != 99) {
                                TiebaStatic.log(new ak("c12334").r("obj_locate", c.this.b(cA)).ac(ImageViewerConfig.FORUM_ID, str));
                                if (cA.mType != 1 && cA.aen.gA(String.valueOf(cA.mType)) != null) {
                                    if (!(cA.aen.gA(String.valueOf(cA.mType)).view.getVisibility() == 0)) {
                                        return true;
                                    }
                                    cA.aen.gA(String.valueOf(cA.mType)).view.setVisibility(8);
                                    if (cA.mType == 2 && (cA.aeo instanceof com.baidu.tieba.frs.gametab.livetab.b)) {
                                        ((com.baidu.tieba.frs.gametab.livetab.b) cA.aeo).Pb();
                                    } else if (cA.mType == 3) {
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FORCE_REFRESH, "GoodsTab_3"));
                                    } else if (cA.mType == 101) {
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FORCE_REFRESH, "InfoTab_101"));
                                    }
                                }
                                return true;
                            }
                            c.this.anx();
                            TiebaStatic.log(new ak("c12342").r("obj_locate", c.this.b(c.this.beb.cA(c.this.beb.getCurrentTabIndex()))).ac(ImageViewerConfig.FORUM_ID, str));
                            TiebaStatic.log(new ak("c12334").r("obj_locate", c.this.b(cA)).ac(ImageViewerConfig.FORUM_ID, str));
                            return false;
                        }
                    });
                } else {
                    this.beb.reset();
                }
                List<com.baidu.tbadk.mainTab.b> akx = this.cNq.akx();
                List<FrsTabInfo> akv = this.cNq.akv();
                if (akv.size() == akx.size()) {
                    int size = akv.size();
                    for (int i = 0; i < size; i++) {
                        com.baidu.tbadk.mainTab.b bVar = akx.get(i);
                        if (bVar != null) {
                            FrsTabInfo frsTabInfo = akv.get(i);
                            if (frsTabInfo == null || TextUtils.isEmpty(frsTabInfo.tab_name)) {
                                a(bVar, bVar.ES(), bVar.aY(this.cNl.getActivity()), null);
                            } else {
                                a(bVar, bVar.ES(), bVar.aY(this.cNl.getActivity()), frsTabInfo.tab_name);
                            }
                        }
                    }
                } else {
                    for (com.baidu.tbadk.mainTab.b bVar2 : akx) {
                        a(bVar2, bVar2.ES(), bVar2.aY(this.cNl.getActivity()), null);
                    }
                }
                this.beb.uc();
                this.beb.cy(2);
                this.beb.ax(true);
                this.beb.setViewPagerScrollable(false);
                final int ke = ke(this.cNs);
                if (ke <= 0) {
                    ke = ke(this.cNp.btp());
                }
                if (ke <= 0) {
                    ke = anz();
                }
                if (ke < 0) {
                    ke = 0;
                }
                this.beb.setCurrentTab(ke);
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.c.10
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.a(c.this.beb.getCurrentFragment(), ke);
                    }
                });
                anw();
                this.beb.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    private void anw() {
        if (this.beb != null && this.beb.cB(99) != null) {
            if (this.cNo == null || this.cNo.getParent() == null) {
                if (this.cNo == null) {
                    this.cNo = new ImageView(this.cNl.getActivity());
                }
                int f = l.f(this.cNl.getActivity(), d.e.ds80);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(f, f);
                layoutParams.gravity = 81;
                layoutParams.bottomMargin = l.f(this.cNl.getActivity(), d.e.ds5);
                this.cNo.setLayoutParams(layoutParams);
                aj.c(this.cNo, d.f.icon_tabbar_add_n);
                aj.j(this.cNo, d.f.icon_tabbar_chaticon_n);
                this.cNo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.c.11
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        String str = null;
                        c.this.anx();
                        if (c.this.beb != null) {
                            if (c.this.cNp != null && c.this.cNp.aPU() != null) {
                                str = c.this.cNp.aPU().getId();
                            }
                            TiebaStatic.log(new ak("c12342").r("obj_locate", c.this.b(c.this.beb.cA(c.this.beb.getCurrentTabIndex()))).ac(ImageViewerConfig.FORUM_ID, str));
                            TiebaStatic.log(new ak("c12334").r("obj_locate", 99).ac(ImageViewerConfig.FORUM_ID, str));
                        }
                    }
                });
                if (this.cNo.getParent() == null) {
                    this.bIr.addView(this.cNo);
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
        NavigationBar ajA;
        if ((fragment instanceof com.baidu.tieba.frs.ak) && this.cNp != null && this.cNp.aPU() != null && (ajA = ((com.baidu.tieba.frs.ak) fragment).ajA()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.cNp.aPU().getName(), 5, true, true) + this.cNl.getActivity().getString(d.j.forum));
            FrsTabInfo frsTabInfo = (FrsTabInfo) v.c(this.cNq.akv(), i);
            if (frsTabInfo != null) {
                sb.append(" · ");
                sb.append(frsTabInfo.tab_name);
            }
            ajA.setCenterTextTitle(sb.toString());
        }
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, com.baidu.tbadk.mainTab.e eVar, String str) {
        if (cVar != null) {
            FragmentTabHost.c cVar2 = new FragmentTabHost.c();
            cVar2.aeo = cVar.aHa;
            if (cVar2.aeo.getArguments() == null) {
                Bundle bundle = new Bundle();
                bundle.putString("name", this.cNp.aPU().getName());
                bundle.putString("from", "game_frs");
                bundle.putString(ImageViewerConfig.FORUM_ID, this.cNp.aPU().getId());
                cVar2.aeo.setArguments(bundle);
            } else {
                cVar2.aeo.getArguments().putString(ImageViewerConfig.FORUM_ID, this.cNp.aPU().getId());
            }
            cVar2.mType = cVar.type;
            if (cVar.aHi == com.baidu.tbadk.mainTab.c.aHf && cVar.type == 99) {
                eVar.L(9, -((int) this.cNl.getResources().getDimension(d.e.ds12)));
            } else if (!TextUtils.isEmpty(str)) {
                eVar.setText(str);
            } else {
                eVar.setText(cVar.aHb);
            }
            eVar.setTextSize(0, this.cNl.getResources().getDimension(d.e.ds30));
            eVar.setTextColorResId(d.C0080d.s_game_frs_tabbar_text_color);
            eVar.setCompoundDrawablesTopResId(cVar.aHc);
            eVar.setContentTvTopMargin(this.cNl.getResources().getDimensionPixelSize(d.e.ds2));
            eVar.dD(TbadkCoreApplication.getInst().getSkinType());
            eVar.setTipPosType(1);
            eVar.setIsContentSelectBold(true);
            boolean z = cVar.aHi == com.baidu.tbadk.mainTab.c.aHf && cVar.type == 99;
            boolean z2 = cVar.type == 1;
            if (!z && !z2 && (eVar instanceof FragmentTabIndicator)) {
                eVar.a(String.valueOf(cVar2.mType), a((FragmentTabIndicator) eVar));
            }
            cVar2.aen = eVar;
            cVar2.aep = bVar;
            this.beb.a(cVar2);
        }
    }

    private e.a a(FragmentTabIndicator fragmentTabIndicator) {
        int dimensionPixelSize = this.cNl.getResources().getDimensionPixelSize(d.e.ds12);
        ImageView imageView = new ImageView(this.cNl);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        imageView.setImageResource(d.f.icon_frs_tab_new_notify_red_point);
        e.a aVar = new e.a();
        fragmentTabIndicator.setTipPosType(1);
        fragmentTabIndicator.setTipTopMargin(this.cNl.getResources().getDimensionPixelSize(d.e.ds12));
        aVar.aHv = fragmentTabIndicator;
        aVar.ur = this.cNl.getResources().getDimensionPixelSize(d.e.ds12);
        aVar.view = imageView;
        aVar.view.setVisibility(8);
        return aVar;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.cNm instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.cNm.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a gd(int i) {
        if (this.cNm instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.cNm.gd(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.cNm instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.cNm.a(bVar);
        }
    }

    public void onNewIntent(Intent intent) {
        if (this.cNm != null) {
            this.cNm.onNewIntent(intent);
        }
    }

    public void onResume() {
        if (this.beb == null) {
            this.cNm.setPrimary(true);
            return;
        }
        Fragment currentFragment = this.beb.getCurrentFragment();
        if (currentFragment instanceof BaseFragment) {
            ((BaseFragment) currentFragment).setPrimary(true);
        }
    }

    public void onPause() {
        if (this.beb == null) {
            this.cNm.setPrimary(false);
            return;
        }
        Fragment currentFragment = this.beb.getCurrentFragment();
        if (currentFragment instanceof BaseFragment) {
            ((BaseFragment) currentFragment).setPrimary(false);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.beb == null) {
            this.cNm.onChangeSkinType(i);
        } else {
            this.beb.ax(true);
            this.beb.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.cNo != null) {
            aj.c(this.cNo, d.f.icon_tabbar_add_n);
            aj.j(this.cNo, d.f.icon_tabbar_chaticon_n);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.beb != null && this.cNn != null && this.cNn.isShowing()) {
                this.cNn.bCv();
            } else if (this.cNm != null && this.cNm.isAdded()) {
                if (this.cNm.onKeyDown(i, keyEvent)) {
                    return true;
                }
                this.cNm.closeActivity();
            } else {
                return this.cNl.b(i, keyEvent);
            }
            return false;
        }
        return this.cNl.b(i, keyEvent);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.beb == null) {
            this.cNm.onActivityResult(i, i2, intent);
        } else {
            this.beb.getCurrentFragment().onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.beb == null) {
            return this.cNm.getVoiceManager();
        }
        Fragment currentFragment = this.beb.getCurrentFragment();
        if (currentFragment instanceof VoiceManager.c) {
            return ((VoiceManager.c) currentFragment).getVoiceManager();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void anx() {
        if (!any()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE));
            if (this.cNn == null) {
                this.cNn = new com.baidu.tieba.write.c(this.cNl.getPageContext(), this.bIr, "frs");
                this.cNn.tP("2");
            }
            this.cNn.a(this.cNm.ajF());
            this.cNn.ns(false);
        }
    }

    public boolean any() {
        String fixedText;
        if (this.cNm == null || !this.cNm.isAdded() || this.cNm.getPageContext() == null) {
            return false;
        }
        j ajB = this.cNm.ajB();
        if (ajB == null) {
            return false;
        }
        if (ax.aT(this.cNm.getPageContext().getPageActivity())) {
            AntiData qf = ajB.qf();
            if (qf != null) {
                if (a(qf.getBlock_stat(), qf.mFrsForbidenDialogInfo)) {
                    return true;
                }
                if (qf.getIfpost() == 0 && !StringUtils.isNull(qf.getForbid_info())) {
                    String forbid_info = qf.getForbid_info();
                    if (am.dT(forbid_info) > 14) {
                        forbid_info = am.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                    }
                    BdToast b = BdToast.b(this.cNm.getPageContext().getPageActivity(), forbid_info, d.f.icon_toast_game_error);
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.cNm.getResources().getString(d.j.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast b = BdToast.b(this.cNm.getPageContext().getPageActivity(), string, d.f.icon_toast_game_error);
            b.E(1.25f);
            b.tq();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cNm.getPageContext().getPageActivity());
        aVar.cS(am.getFixedText(string, 50, true));
        aVar.b(am.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.cNm.getResources().getString(d.j.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.gametab.c.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (aVar2 != null) {
                    aVar2.dismiss();
                }
            }
        });
        if (!StringUtils.isNull(blockPopInfoData.ahead_info) && !StringUtils.isNull(blockPopInfoData.ahead_url)) {
            aVar.a(am.getFixedText(blockPopInfoData.ahead_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.gametab.c.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    av.vI().c(c.this.cNm.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.cNm.getPageContext()).th();
        return true;
    }

    private int anz() {
        if (this.cNq == null) {
            return -1;
        }
        int u = v.u(this.cNq.akv());
        for (int i = 0; i < u; i++) {
            if (this.cNq.akv().get(i).tab_id.intValue() == 1) {
                return i;
            }
        }
        return -1;
    }

    private int ke(int i) {
        if (this.cNq == null) {
            return -1;
        }
        int u = v.u(this.cNq.akv());
        for (int i2 = 0; i2 < u; i2++) {
            if (this.cNq.akv().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    public f aiO() {
        return this.cNm;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> aiP() {
        if (this.beb == null) {
            if (this.cNm instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) this.cNm).aiP();
            }
        } else {
            Fragment currentFragment = this.beb.getCurrentFragment();
            if (currentFragment instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) currentFragment).aiP();
            }
        }
        return null;
    }

    public void onDestroy() {
        if (this.cNl.isLoadingViewAttached()) {
            this.cNl.hideLoadingView(this.cNl.findViewById(16908290));
        }
        if (this.cNx != null) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.cNx);
        }
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(this.cNt, false);
    }
}
