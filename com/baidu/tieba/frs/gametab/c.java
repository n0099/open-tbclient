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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes2.dex */
public class c implements VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b {
    private FragmentTabHost bUS;
    private FrameLayout bYN;
    private FrsActivity dNU;
    private i dNV;
    private com.baidu.tieba.write.c dNW;
    private ImageView dNX;
    private com.baidu.tieba.tbadkCore.i dNY;
    private af dNZ;
    private ShareSuccessReplyToServerModel dOd;
    private com.baidu.tieba.p.a dOe;
    private String mForumName;
    private boolean dOa = false;
    private Handler mHandler = new Handler();
    private int dOb = 0;
    private com.baidu.adp.framework.listener.a dOf = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FRS_HTTP_CMD, 301001) { // from class: com.baidu.tieba.frs.gametab.c.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            com.baidu.tieba.tbadkCore.i iVar = null;
            if (!c.this.dOa && !responsedMessage.hasError()) {
                if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                    iVar = ((FrsPageHttpResponseMessage) responsedMessage).getResponseData();
                } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                    iVar = ((FRSPageSocketResponsedMessage) responsedMessage).getResponseData();
                }
                if (iVar != null) {
                    c.this.dOa = true;
                    c.this.c(iVar);
                }
            }
        }
    };
    private CustomMessageListener dOg = new CustomMessageListener(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE) { // from class: com.baidu.tieba.frs.gametab.c.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!c.this.dOa && customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.i)) {
                com.baidu.tieba.tbadkCore.i iVar = (com.baidu.tieba.tbadkCore.i) customResponsedMessage.getData();
                if (iVar.aYJ() != null && c.this.mForumName != null && c.this.mForumName.equals(iVar.aYJ().getName())) {
                    c.this.c(iVar);
                }
            }
        }
    };
    private HttpMessageListener dOh = new HttpMessageListener(0) { // from class: com.baidu.tieba.frs.gametab.c.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && 1003275 == httpResponsedMessage.getCmd() && (httpResponsedMessage instanceof AlaGameTabGetNewNotifyResponsedMessage)) {
                List<a> newNotifyData = ((AlaGameTabGetNewNotifyResponsedMessage) httpResponsedMessage).getNewNotifyData();
                if (!v.E(newNotifyData)) {
                    for (a aVar : newNotifyData) {
                        if (aVar != null) {
                            for (int i = 0; i < c.this.dNZ.avq().size(); i++) {
                                FragmentTabHost.c fy = c.this.bUS.fy(i);
                                if (fy.mType != 99 && fy.mType != 1 && fy.mType != c.this.bUS.getCurrentTabType() && fy.mType == aVar.getTabId() && aVar.axB() && fy.aST.gN(String.valueOf(fy.mType)) != null) {
                                    fy.aST.gN(String.valueOf(fy.mType)).view.setVisibility(0);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private Runnable dOi = new Runnable() { // from class: com.baidu.tieba.frs.gametab.c.7
        @Override // java.lang.Runnable
        public void run() {
            e.ns().removeCallbacks(this);
            c.this.axF();
            e.ns().postDelayed(this, 30000L);
        }
    };
    private String dOc = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_game_forem_tab_hot_point");

    public c(FrsActivity frsActivity) {
        this.dNU = frsActivity;
    }

    public void init(Bundle bundle) {
        this.dOf.getHttpMessageListener().setPriority(-1);
        this.dOf.getSocketMessageListener().setPriority(-1);
        this.dNU.registerListener(this.dOg);
        if (bundle == null) {
            this.mForumName = this.dNU.getIntent().getStringExtra("name");
            this.dOb = this.dNU.getIntent().getIntExtra(FrsActivityConfig.FRS_GAME_DEFAULT_TAB_ID, 0);
        } else {
            this.mForumName = bundle.getString("name");
            this.dOb = bundle.getInt("default_tab_id", 0);
        }
        m(bundle);
        this.dOd = new ShareSuccessReplyToServerModel();
        this.dNU.registerListener(this.dOf);
        this.dOe = new com.baidu.tieba.p.a(this.dNU.getPageContext());
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.mForumName);
        bundle.putInt("default_tab_id", this.dOb);
    }

    private void m(Bundle bundle) {
        if (this.dNV == null) {
            this.dNV = new i();
            this.dNV.setArguments(bundle);
        }
        FragmentTransaction beginTransaction = this.dNU.getSupportFragmentManager().beginTransaction();
        beginTransaction.add(16908290, this.dNV);
        beginTransaction.commitAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.i iVar) {
        if (v.D(iVar.bul()) > 0) {
            this.dNY = iVar;
            if (!this.dNU.isLoadingViewAttached() && this.bUS == null) {
                this.dNU.showLoadingView(this.dNU.findViewById(16908290));
            }
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.c.8
                @Override // java.lang.Runnable
                public void run() {
                    c.this.bq(c.this.dNY.bul());
                }
            });
        } else if (this.bUS != null) {
            this.bYN.removeView(this.bUS);
            this.bUS = null;
            this.dNZ = null;
            if (this.dNX != null && this.dNX.getParent() != null) {
                ((ViewGroup) this.dNX.getParent()).removeView(this.dNX);
            }
            m(null);
        }
    }

    private boolean axC() {
        FragmentManager supportFragmentManager = this.dNU.getSupportFragmentManager();
        try {
            supportFragmentManager.beginTransaction().remove(this.dNV).commitAllowingStateLoss();
            supportFragmentManager.executePendingTransactions();
            return true;
        } catch (IllegalStateException e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bq(List<FrsTabInfo> list) {
        if (this.bUS == null && axC()) {
            axD();
            br(list);
        }
        if (this.dNU.isLoadingViewAttached()) {
            this.dNU.hideLoadingView(this.dNU.findViewById(16908290));
        }
    }

    private void axD() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003275, TbConfig.SERVER_ADDRESS + "game/forum/getNewNotify");
        tbHttpMessageTask.setResponsedClass(AlaGameTabGetNewNotifyResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.dNU.registerListener(1003275, this.dOh);
    }

    private void br(List<FrsTabInfo> list) {
        List list2;
        boolean z;
        if (!v.E(list)) {
            CustomMessageListener customMessageListener = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB) { // from class: com.baidu.tieba.frs.gametab.c.9
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof af)) {
                        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(c.this.dOc, true)) {
                            e.ns().post(c.this.dOi);
                        }
                        c.this.axG();
                    }
                }
            };
            customMessageListener.setPriority(Integer.MAX_VALUE);
            customMessageListener.setSelfListener(true);
            this.dNU.registerListener(customMessageListener);
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
            builder.tab_name = this.dNU.getResources().getString(d.j.send);
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
            this.dNZ = new af(this.dNU.getActivity(), list2);
            if (axL() != null) {
                this.dNZ.setForumId(axL().getForumId());
                this.dNZ.setForumName(axL().getForumName());
                if (axL().auv() != null && axL().auv().aYJ() != null) {
                    this.dNZ.setForumGameLabel(axL().auv().aYJ().getForumGameLabel());
                }
            }
            new d(this.dNV).a(this.dNZ);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB, this.dNZ);
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB);
            customMessage.setTag(this.dNU.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    private void axE() {
        int axK = axK();
        if (axK >= 0) {
            a(this.dNV, axK);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axF() {
        if (this.dNZ != null && !TextUtils.isEmpty(this.dNZ.getForumId())) {
            HttpMessage httpMessage = new HttpMessage(1003275);
            httpMessage.addParam("forum_id", this.dNY.aYJ().getId());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axG() {
        if (this.dNZ != null) {
            this.dNZ.avr();
            if (!v.E(this.dNZ.atO())) {
                axE();
                if (this.bUS == null) {
                    this.bUS = new FragmentTabHost(this.dNU.getActivity());
                    this.bUS.setClipChildren(false);
                    this.bUS.setClipToPadding(false);
                    this.bUS.setup(this.dNU.getSupportFragmentManager());
                    this.bUS.setShouldDrawIndicatorLine(false);
                    this.bUS.setShouldDrawTopLine(true);
                    this.bUS.n(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds10), 0, 0);
                    this.bUS.bh(true);
                    this.bUS.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    this.bYN = new FrameLayout(this.dNU.getActivity());
                    this.bYN.setClipChildren(false);
                    this.bYN.setClipToPadding(false);
                    this.bYN.addView(this.bUS);
                    this.dNU.setContentView(this.bYN);
                    this.bUS.setOnTabSelectionListener(new FragmentTabHost.b() { // from class: com.baidu.tieba.frs.gametab.c.10
                        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
                        public void p(int i, boolean z) {
                            c.this.a(c.this.bUS.getCurrentFragment(), i);
                        }

                        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
                        public boolean q(int i, boolean z) {
                            String str = null;
                            FragmentTabHost.c fy = c.this.bUS.fy(i);
                            if (c.this.dNY != null && c.this.dNY.aYJ() != null) {
                                str = c.this.dNY.aYJ().getId();
                            }
                            if (fy.mType != 99) {
                                TiebaStatic.log(new ak("c12334").s("obj_locate", c.this.b(fy)).aa(ImageViewerConfig.FORUM_ID, str));
                                if (fy.mType != 1 && fy.aST.gN(String.valueOf(fy.mType)) != null) {
                                    if (!(fy.aST.gN(String.valueOf(fy.mType)).view.getVisibility() == 0)) {
                                        return true;
                                    }
                                    fy.aST.gN(String.valueOf(fy.mType)).view.setVisibility(8);
                                    if (fy.mType == 2 && (fy.aSU instanceof com.baidu.tieba.frs.gametab.livetab.b)) {
                                        ((com.baidu.tieba.frs.gametab.livetab.b) fy.aSU).XC();
                                    } else if (fy.mType == 3) {
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FORCE_REFRESH, "GoodsTab_3"));
                                    } else if (fy.mType == 101) {
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FORCE_REFRESH, "InfoTab_101"));
                                    }
                                }
                                return true;
                            }
                            c.this.axI();
                            TiebaStatic.log(new ak("c12342").s("obj_locate", c.this.b(c.this.bUS.fy(c.this.bUS.getCurrentTabIndex()))).aa(ImageViewerConfig.FORUM_ID, str));
                            TiebaStatic.log(new ak("c12334").s("obj_locate", c.this.b(fy)).aa(ImageViewerConfig.FORUM_ID, str));
                            return false;
                        }
                    });
                } else {
                    this.bUS.reset();
                }
                List<com.baidu.tbadk.mainTab.b> atO = this.dNZ.atO();
                List<FrsTabInfo> avq = this.dNZ.avq();
                if (avq.size() == atO.size()) {
                    int size = avq.size();
                    for (int i = 0; i < size; i++) {
                        com.baidu.tbadk.mainTab.b bVar = atO.get(i);
                        if (bVar != null) {
                            FrsTabInfo frsTabInfo = avq.get(i);
                            if (frsTabInfo == null || TextUtils.isEmpty(frsTabInfo.tab_name)) {
                                a(bVar, bVar.Mp(), bVar.bj(this.dNU.getActivity()), null);
                            } else {
                                a(bVar, bVar.Mp(), bVar.bj(this.dNU.getActivity()), frsTabInfo.tab_name);
                            }
                        }
                    }
                } else {
                    for (com.baidu.tbadk.mainTab.b bVar2 : atO) {
                        a(bVar2, bVar2.Mp(), bVar2.bj(this.dNU.getActivity()), null);
                    }
                }
                this.bUS.Bv();
                this.bUS.fw(2);
                this.bUS.bg(true);
                this.bUS.setViewPagerScrollable(false);
                final int nB = nB(this.dOb);
                if (nB < 0) {
                    nB = nB(this.dNY.bum());
                }
                if (nB < 0) {
                    nB = axK();
                }
                if (nB < 0) {
                    nB = 0;
                }
                this.bUS.setCurrentTab(nB);
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.c.11
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.this.bUS != null) {
                            c.this.a(c.this.bUS.getCurrentFragment(), nB);
                        }
                    }
                });
                axH();
                this.bUS.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    private void axH() {
        if (this.bUS != null && this.bUS.fz(99) != null) {
            if (this.dNX == null || this.dNX.getParent() == null) {
                if (this.dNX == null) {
                    this.dNX = new ImageView(this.dNU.getActivity());
                }
                int s = l.s(this.dNU.getActivity(), d.e.ds80);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(s, s);
                layoutParams.gravity = 81;
                layoutParams.bottomMargin = l.s(this.dNU.getActivity(), d.e.ds5);
                this.dNX.setLayoutParams(layoutParams);
                aj.c(this.dNX, d.f.icon_tabbar_add_n);
                aj.s(this.dNX, d.f.icon_tabbar_chaticon_n);
                this.dNX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.c.12
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        String str = null;
                        c.this.axI();
                        if (c.this.bUS != null) {
                            if (c.this.dNY != null && c.this.dNY.aYJ() != null) {
                                str = c.this.dNY.aYJ().getId();
                            }
                            TiebaStatic.log(new ak("c12342").s("obj_locate", c.this.b(c.this.bUS.fy(c.this.bUS.getCurrentTabIndex()))).aa(ImageViewerConfig.FORUM_ID, str));
                            TiebaStatic.log(new ak("c12334").s("obj_locate", 99).aa(ImageViewerConfig.FORUM_ID, str));
                        }
                    }
                });
                if (this.dNX.getParent() == null) {
                    this.bYN.addView(this.dNX);
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
        NavigationBar auu;
        if ((fragment instanceof am) && this.dNY != null && this.dNY.aYJ() != null && (auu = ((am) fragment).auu()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.dNY.aYJ().getName(), 5, true, true) + this.dNU.getActivity().getString(d.j.forum));
            FrsTabInfo frsTabInfo = (FrsTabInfo) v.f(this.dNZ.avq(), i);
            if (frsTabInfo != null) {
                sb.append(" · ");
                sb.append(frsTabInfo.tab_name);
            }
            auu.setCenterTextTitle(sb.toString());
        }
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, com.baidu.tbadk.mainTab.e eVar, String str) {
        if (cVar != null) {
            FragmentTabHost.c cVar2 = new FragmentTabHost.c();
            cVar2.aSU = cVar.bvP;
            if (cVar2.aSU.getArguments() == null) {
                Bundle bundle = new Bundle();
                bundle.putString("name", this.dNY.aYJ().getName());
                bundle.putString("from", "game_frs");
                bundle.putString(ImageViewerConfig.FORUM_ID, this.dNY.aYJ().getId());
                cVar2.aSU.setArguments(bundle);
            } else {
                cVar2.aSU.getArguments().putString(ImageViewerConfig.FORUM_ID, this.dNY.aYJ().getId());
            }
            cVar2.mType = cVar.type;
            if (cVar.bvX == com.baidu.tbadk.mainTab.c.bvU && cVar.type == 99) {
                eVar.aJ(9, -((int) this.dNU.getResources().getDimension(d.e.ds12)));
            } else if (!TextUtils.isEmpty(str)) {
                eVar.setText(str);
            } else {
                eVar.setText(cVar.bvQ);
            }
            eVar.setTextSize(0, this.dNU.getResources().getDimension(d.e.ds30));
            eVar.setTextColorResId(d.C0108d.s_game_frs_tabbar_text_color);
            eVar.setCompoundDrawablesTopResId(cVar.bvR);
            eVar.setContentTvTopMargin(this.dNU.getResources().getDimensionPixelSize(d.e.ds2));
            eVar.gz(TbadkCoreApplication.getInst().getSkinType());
            eVar.setTipPosType(1);
            eVar.setIsContentSelectBold(true);
            boolean z = cVar.bvX == com.baidu.tbadk.mainTab.c.bvU && cVar.type == 99;
            boolean z2 = cVar.type == 1;
            if (!z && !z2 && (eVar instanceof FragmentTabIndicator)) {
                eVar.a(String.valueOf(cVar2.mType), a((FragmentTabIndicator) eVar));
            }
            cVar2.aST = eVar;
            cVar2.aSV = bVar;
            this.bUS.a(cVar2);
        }
    }

    private e.a a(FragmentTabIndicator fragmentTabIndicator) {
        int dimensionPixelSize = this.dNU.getResources().getDimensionPixelSize(d.e.ds12);
        ImageView imageView = new ImageView(this.dNU);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        imageView.setImageResource(d.f.icon_frs_tab_new_notify_red_point);
        e.a aVar = new e.a();
        fragmentTabIndicator.setTipPosType(1);
        fragmentTabIndicator.setTipTopMargin(this.dNU.getResources().getDimensionPixelSize(d.e.ds12));
        aVar.bwk = fragmentTabIndicator;
        aVar.aiF = this.dNU.getResources().getDimensionPixelSize(d.e.ds12);
        aVar.view = imageView;
        aVar.view.setVisibility(8);
        return aVar;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.dNV instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.dNV.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a jg(int i) {
        if (this.dNV instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.dNV.jg(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.dNV instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.dNV.a(bVar);
        }
    }

    public void onNewIntent(Intent intent) {
        if (this.dNV != null) {
            this.dNV.onNewIntent(intent);
        }
    }

    public void onResume() {
        if (this.bUS == null) {
            this.dNV.setPrimary(true);
            return;
        }
        Fragment currentFragment = this.bUS.getCurrentFragment();
        if (currentFragment instanceof BaseFragment) {
            ((BaseFragment) currentFragment).setPrimary(true);
        }
    }

    public void onPause() {
        if (this.bUS == null) {
            this.dNV.setPrimary(false);
            return;
        }
        Fragment currentFragment = this.bUS.getCurrentFragment();
        if (currentFragment instanceof BaseFragment) {
            ((BaseFragment) currentFragment).setPrimary(false);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bUS == null) {
            this.dNV.onChangeSkinType(i);
        } else {
            this.bUS.bg(true);
            this.bUS.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.dNX != null) {
            aj.c(this.dNX, d.f.icon_tabbar_add_n);
            aj.s(this.dNX, d.f.icon_tabbar_chaticon_n);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.bUS != null && this.dNW != null && this.dNW.isShowing()) {
                this.dNW.bEV();
            } else if (this.dNV != null && this.dNV.isAdded()) {
                if (this.dNV.onKeyDown(i, keyEvent)) {
                    return true;
                }
                this.dNV.closeActivity();
            } else {
                return this.dNU.e(i, keyEvent);
            }
            return false;
        }
        return this.dNU.e(i, keyEvent);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        com.baidu.tbadk.coreExtra.c.d shareItem;
        if (this.bUS == null) {
            this.dNV.onActivityResult(i, i2, intent);
        } else {
            this.bUS.getCurrentFragment().onActivityResult(i, i2, intent);
        }
        if (i2 == -1 && i == 24007) {
            int intExtra = intent.getIntExtra("extra_share_status", 2);
            int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
            if (intExtra == 1 && (shareItem = TbadkCoreApplication.getInst().getShareItem()) != null && shareItem.linkUrl != null && this.dOd != null) {
                this.dOd.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.frs.gametab.c.2
                    @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                    public void Hg() {
                    }

                    @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                    public void a(final CustomDialogData customDialogData) {
                        com.baidu.adp.lib.g.e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.c.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (c.this.dNU != null) {
                                    com.baidu.tieba.pb.interactionpopupwindow.c.a(c.this.dNU.getPageContext(), customDialogData).show();
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
        if (this.bUS == null) {
            return this.dNV.getVoiceManager();
        }
        Fragment currentFragment = this.bUS.getCurrentFragment();
        if (currentFragment instanceof VoiceManager.c) {
            return ((VoiceManager.c) currentFragment).getVoiceManager();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void axI() {
        if (!this.dOe.bzN() && !axJ()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE));
            if (this.dNW == null) {
                this.dNW = new com.baidu.tieba.write.c(this.dNU.getPageContext(), this.bYN, "frs");
                this.dNW.uh("2");
            }
            this.dNW.a(this.dNV.auz());
            this.dNW.nu(false);
        }
    }

    public boolean axJ() {
        String fixedText;
        if (this.dNV == null || !this.dNV.isAdded() || this.dNV.getPageContext() == null) {
            return false;
        }
        com.baidu.tieba.tbadkCore.l auv = this.dNV.auv();
        if (auv == null) {
            return false;
        }
        if (ax.bb(this.dNV.getPageContext().getPageActivity())) {
            AntiData xH = auv.xH();
            if (xH != null) {
                if (a(xH.getBlock_stat(), xH.mFrsForbidenDialogInfo)) {
                    return true;
                }
                if (xH.getIfpost() == 0 && !StringUtils.isNull(xH.getForbid_info())) {
                    String forbid_info = xH.getForbid_info();
                    if (com.baidu.tbadk.core.util.am.eg(forbid_info) > 14) {
                        forbid_info = com.baidu.tbadk.core.util.am.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                    }
                    BdToast b = BdToast.b(this.dNV.getPageContext().getPageActivity(), forbid_info, d.f.icon_toast_game_error);
                    b.U(1.25f);
                    b.AJ();
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.dNV.getResources().getString(d.j.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast b = BdToast.b(this.dNV.getPageContext().getPageActivity(), string, d.f.icon_toast_game_error);
            b.U(1.25f);
            b.AJ();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dNV.getPageContext().getPageActivity());
        aVar.cZ(com.baidu.tbadk.core.util.am.getFixedText(string, 50, true));
        aVar.b(com.baidu.tbadk.core.util.am.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.dNV.getResources().getString(d.j.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.gametab.c.3
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
                    av.Da().c(c.this.dNV.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.dNV.getPageContext()).AB();
        return true;
    }

    private int axK() {
        if (this.dNZ == null) {
            return -1;
        }
        int D = v.D(this.dNZ.avq());
        for (int i = 0; i < D; i++) {
            if (this.dNZ.avq().get(i).tab_id.intValue() == 1) {
                return i;
            }
        }
        return -1;
    }

    private int nB(int i) {
        if (this.dNZ == null) {
            return -1;
        }
        int D = v.D(this.dNZ.avq());
        for (int i2 = 0; i2 < D; i2++) {
            if (this.dNZ.avq().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    public i axL() {
        return this.dNV;
    }

    public void onDestroy() {
        if (this.dNU.isLoadingViewAttached()) {
            this.dNU.hideLoadingView(this.dNU.findViewById(16908290));
        }
        if (this.dOi != null) {
            com.baidu.adp.lib.g.e.ns().removeCallbacks(this.dOi);
        }
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(this.dOc, false);
        if (this.dOd != null) {
            this.dOd.cancelLoadData();
        }
    }
}
