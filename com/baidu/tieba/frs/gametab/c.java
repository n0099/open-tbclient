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
    private FragmentTabHost bUD;
    private FrameLayout bYy;
    private FrsActivity dIX;
    private i dIY;
    private com.baidu.tieba.write.c dIZ;
    private ImageView dJa;
    private com.baidu.tieba.tbadkCore.i dJb;
    private af dJc;
    private ShareSuccessReplyToServerModel dJg;
    private com.baidu.tieba.p.a dJh;
    private String mForumName;
    private boolean dJd = false;
    private Handler mHandler = new Handler();
    private int dJe = 0;
    private com.baidu.adp.framework.listener.a dJi = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FRS_HTTP_CMD, 301001) { // from class: com.baidu.tieba.frs.gametab.c.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            com.baidu.tieba.tbadkCore.i iVar = null;
            if (!c.this.dJd && !responsedMessage.hasError()) {
                if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                    iVar = ((FrsPageHttpResponseMessage) responsedMessage).getResponseData();
                } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                    iVar = ((FRSPageSocketResponsedMessage) responsedMessage).getResponseData();
                }
                if (iVar != null) {
                    c.this.dJd = true;
                    c.this.c(iVar);
                }
            }
        }
    };
    private CustomMessageListener dJj = new CustomMessageListener(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE) { // from class: com.baidu.tieba.frs.gametab.c.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!c.this.dJd && customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.i)) {
                com.baidu.tieba.tbadkCore.i iVar = (com.baidu.tieba.tbadkCore.i) customResponsedMessage.getData();
                if (iVar.aYy() != null && c.this.mForumName != null && c.this.mForumName.equals(iVar.aYy().getName())) {
                    c.this.c(iVar);
                }
            }
        }
    };
    private HttpMessageListener dJk = new HttpMessageListener(0) { // from class: com.baidu.tieba.frs.gametab.c.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && 1003275 == httpResponsedMessage.getCmd() && (httpResponsedMessage instanceof AlaGameTabGetNewNotifyResponsedMessage)) {
                List<a> newNotifyData = ((AlaGameTabGetNewNotifyResponsedMessage) httpResponsedMessage).getNewNotifyData();
                if (!v.G(newNotifyData)) {
                    for (a aVar : newNotifyData) {
                        if (aVar != null) {
                            for (int i = 0; i < c.this.dJc.aui().size(); i++) {
                                FragmentTabHost.c fA = c.this.bUD.fA(i);
                                if (fA.mType != 99 && fA.mType != 1 && fA.mType != c.this.bUD.getCurrentTabType() && fA.mType == aVar.getTabId() && aVar.awt() && fA.aSR.gF(String.valueOf(fA.mType)) != null) {
                                    fA.aSR.gF(String.valueOf(fA.mType)).view.setVisibility(0);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private Runnable dJl = new Runnable() { // from class: com.baidu.tieba.frs.gametab.c.7
        @Override // java.lang.Runnable
        public void run() {
            e.nr().removeCallbacks(this);
            c.this.awx();
            e.nr().postDelayed(this, 30000L);
        }
    };
    private String dJf = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_game_forem_tab_hot_point");

    public c(FrsActivity frsActivity) {
        this.dIX = frsActivity;
    }

    public void init(Bundle bundle) {
        this.dJi.getHttpMessageListener().setPriority(-1);
        this.dJi.getSocketMessageListener().setPriority(-1);
        this.dIX.registerListener(this.dJj);
        if (bundle == null) {
            this.mForumName = this.dIX.getIntent().getStringExtra("name");
            this.dJe = this.dIX.getIntent().getIntExtra(FrsActivityConfig.FRS_GAME_DEFAULT_TAB_ID, 0);
        } else {
            this.mForumName = bundle.getString("name");
            this.dJe = bundle.getInt("default_tab_id", 0);
        }
        m(bundle);
        this.dJg = new ShareSuccessReplyToServerModel();
        this.dIX.registerListener(this.dJi);
        this.dJh = new com.baidu.tieba.p.a(this.dIX.getPageContext());
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.mForumName);
        bundle.putInt("default_tab_id", this.dJe);
    }

    private void m(Bundle bundle) {
        if (this.dIY == null) {
            this.dIY = new i();
            this.dIY.setArguments(bundle);
        }
        FragmentTransaction beginTransaction = this.dIX.getSupportFragmentManager().beginTransaction();
        beginTransaction.add(16908290, this.dIY);
        beginTransaction.commitAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.i iVar) {
        if (v.F(iVar.bAN()) > 0) {
            this.dJb = iVar;
            if (!this.dIX.isLoadingViewAttached() && this.bUD == null) {
                this.dIX.showLoadingView(this.dIX.findViewById(16908290));
            }
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.c.8
                @Override // java.lang.Runnable
                public void run() {
                    c.this.bs(c.this.dJb.bAN());
                }
            });
        } else if (this.bUD != null) {
            this.bYy.removeView(this.bUD);
            this.bUD = null;
            this.dJc = null;
            if (this.dJa != null && this.dJa.getParent() != null) {
                ((ViewGroup) this.dJa.getParent()).removeView(this.dJa);
            }
            m(null);
        }
    }

    private boolean awu() {
        FragmentManager supportFragmentManager = this.dIX.getSupportFragmentManager();
        try {
            supportFragmentManager.beginTransaction().remove(this.dIY).commitAllowingStateLoss();
            supportFragmentManager.executePendingTransactions();
            return true;
        } catch (IllegalStateException e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bs(List<FrsTabInfo> list) {
        if (this.bUD == null && awu()) {
            awv();
            bt(list);
        }
        if (this.dIX.isLoadingViewAttached()) {
            this.dIX.hideLoadingView(this.dIX.findViewById(16908290));
        }
    }

    private void awv() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003275, TbConfig.SERVER_ADDRESS + "game/forum/getNewNotify");
        tbHttpMessageTask.setResponsedClass(AlaGameTabGetNewNotifyResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.dIX.registerListener(1003275, this.dJk);
    }

    private void bt(List<FrsTabInfo> list) {
        List list2;
        boolean z;
        if (!v.G(list)) {
            CustomMessageListener customMessageListener = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB) { // from class: com.baidu.tieba.frs.gametab.c.9
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof af)) {
                        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(c.this.dJf, true)) {
                            e.nr().post(c.this.dJl);
                        }
                        c.this.awy();
                    }
                }
            };
            customMessageListener.setPriority(Integer.MAX_VALUE);
            customMessageListener.setSelfListener(true);
            this.dIX.registerListener(customMessageListener);
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
            builder.tab_name = this.dIX.getResources().getString(d.j.send);
            builder.tab_type = 0;
            int F = v.F(arrayList);
            if (F > 4) {
                list2 = arrayList.subList(0, 4);
                list2.add(2, builder.build(false));
            } else if (F < 2) {
                arrayList.add(builder.build(false));
                list2 = arrayList;
            } else {
                arrayList.add(F / 2, builder.build(false));
                list2 = arrayList;
            }
            this.dJc = new af(this.dIX.getActivity(), list2);
            if (awD() != null) {
                this.dJc.setForumId(awD().getForumId());
                this.dJc.setForumName(awD().getForumName());
                if (awD().atn() != null && awD().atn().aYy() != null) {
                    this.dJc.setForumGameLabel(awD().atn().aYy().getForumGameLabel());
                }
            }
            new d(this.dIY).a(this.dJc);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB, this.dJc);
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB);
            customMessage.setTag(this.dIX.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    private void aww() {
        int awC = awC();
        if (awC >= 0) {
            a(this.dIY, awC);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awx() {
        if (this.dJc != null && !TextUtils.isEmpty(this.dJc.getForumId())) {
            HttpMessage httpMessage = new HttpMessage(1003275);
            httpMessage.addParam("forum_id", this.dJb.aYy().getId());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awy() {
        if (this.dJc != null) {
            this.dJc.auj();
            if (!v.G(this.dJc.asG())) {
                aww();
                if (this.bUD == null) {
                    this.bUD = new FragmentTabHost(this.dIX.getActivity());
                    this.bUD.setClipChildren(false);
                    this.bUD.setClipToPadding(false);
                    this.bUD.setup(this.dIX.getSupportFragmentManager());
                    this.bUD.setShouldDrawIndicatorLine(false);
                    this.bUD.setShouldDrawTopLine(true);
                    this.bUD.n(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds10), 0, 0);
                    this.bUD.bg(true);
                    this.bUD.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    this.bYy = new FrameLayout(this.dIX.getActivity());
                    this.bYy.setClipChildren(false);
                    this.bYy.setClipToPadding(false);
                    this.bYy.addView(this.bUD);
                    this.dIX.setContentView(this.bYy);
                    this.bUD.setOnTabSelectionListener(new FragmentTabHost.b() { // from class: com.baidu.tieba.frs.gametab.c.10
                        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
                        public void p(int i, boolean z) {
                            c.this.a(c.this.bUD.getCurrentFragment(), i);
                        }

                        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
                        public boolean q(int i, boolean z) {
                            String str = null;
                            FragmentTabHost.c fA = c.this.bUD.fA(i);
                            if (c.this.dJb != null && c.this.dJb.aYy() != null) {
                                str = c.this.dJb.aYy().getId();
                            }
                            if (fA.mType != 99) {
                                TiebaStatic.log(new ak("c12334").s("obj_locate", c.this.b(fA)).ab(ImageViewerConfig.FORUM_ID, str));
                                if (fA.mType != 1 && fA.aSR.gF(String.valueOf(fA.mType)) != null) {
                                    if (!(fA.aSR.gF(String.valueOf(fA.mType)).view.getVisibility() == 0)) {
                                        return true;
                                    }
                                    fA.aSR.gF(String.valueOf(fA.mType)).view.setVisibility(8);
                                    if (fA.mType == 2 && (fA.aSS instanceof com.baidu.tieba.frs.gametab.livetab.b)) {
                                        ((com.baidu.tieba.frs.gametab.livetab.b) fA.aSS).XM();
                                    } else if (fA.mType == 3) {
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FORCE_REFRESH, "GoodsTab_3"));
                                    } else if (fA.mType == 101) {
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FORCE_REFRESH, "InfoTab_101"));
                                    }
                                }
                                return true;
                            }
                            c.this.awA();
                            TiebaStatic.log(new ak("c12342").s("obj_locate", c.this.b(c.this.bUD.fA(c.this.bUD.getCurrentTabIndex()))).ab(ImageViewerConfig.FORUM_ID, str));
                            TiebaStatic.log(new ak("c12334").s("obj_locate", c.this.b(fA)).ab(ImageViewerConfig.FORUM_ID, str));
                            return false;
                        }
                    });
                } else {
                    this.bUD.reset();
                }
                List<com.baidu.tbadk.mainTab.b> asG = this.dJc.asG();
                List<FrsTabInfo> aui = this.dJc.aui();
                if (aui.size() == asG.size()) {
                    int size = aui.size();
                    for (int i = 0; i < size; i++) {
                        com.baidu.tbadk.mainTab.b bVar = asG.get(i);
                        if (bVar != null) {
                            FrsTabInfo frsTabInfo = aui.get(i);
                            if (frsTabInfo == null || TextUtils.isEmpty(frsTabInfo.tab_name)) {
                                a(bVar, bVar.Mz(), bVar.bm(this.dIX.getActivity()), null);
                            } else {
                                a(bVar, bVar.Mz(), bVar.bm(this.dIX.getActivity()), frsTabInfo.tab_name);
                            }
                        }
                    }
                } else {
                    for (com.baidu.tbadk.mainTab.b bVar2 : asG) {
                        a(bVar2, bVar2.Mz(), bVar2.bm(this.dIX.getActivity()), null);
                    }
                }
                this.bUD.BC();
                this.bUD.fy(2);
                this.bUD.bf(true);
                this.bUD.setViewPagerScrollable(false);
                final int ny = ny(this.dJe);
                if (ny < 0) {
                    ny = ny(this.dJb.bAO());
                }
                if (ny < 0) {
                    ny = awC();
                }
                if (ny < 0) {
                    ny = 0;
                }
                this.bUD.setCurrentTab(ny);
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.c.11
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.this.bUD != null) {
                            c.this.a(c.this.bUD.getCurrentFragment(), ny);
                        }
                    }
                });
                awz();
                this.bUD.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    private void awz() {
        if (this.bUD != null && this.bUD.fB(99) != null) {
            if (this.dJa == null || this.dJa.getParent() == null) {
                if (this.dJa == null) {
                    this.dJa = new ImageView(this.dIX.getActivity());
                }
                int s = l.s(this.dIX.getActivity(), d.e.ds80);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(s, s);
                layoutParams.gravity = 81;
                layoutParams.bottomMargin = l.s(this.dIX.getActivity(), d.e.ds5);
                this.dJa.setLayoutParams(layoutParams);
                aj.c(this.dJa, d.f.icon_tabbar_add_n);
                aj.s(this.dJa, d.f.icon_tabbar_chaticon_n);
                this.dJa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.c.12
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        String str = null;
                        c.this.awA();
                        if (c.this.bUD != null) {
                            if (c.this.dJb != null && c.this.dJb.aYy() != null) {
                                str = c.this.dJb.aYy().getId();
                            }
                            TiebaStatic.log(new ak("c12342").s("obj_locate", c.this.b(c.this.bUD.fA(c.this.bUD.getCurrentTabIndex()))).ab(ImageViewerConfig.FORUM_ID, str));
                            TiebaStatic.log(new ak("c12334").s("obj_locate", 99).ab(ImageViewerConfig.FORUM_ID, str));
                        }
                    }
                });
                if (this.dJa.getParent() == null) {
                    this.bYy.addView(this.dJa);
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
        NavigationBar atm;
        if ((fragment instanceof am) && this.dJb != null && this.dJb.aYy() != null && (atm = ((am) fragment).atm()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.dJb.aYy().getName(), 5, true, true) + this.dIX.getActivity().getString(d.j.forum));
            FrsTabInfo frsTabInfo = (FrsTabInfo) v.f(this.dJc.aui(), i);
            if (frsTabInfo != null) {
                sb.append(" · ");
                sb.append(frsTabInfo.tab_name);
            }
            atm.setCenterTextTitle(sb.toString());
        }
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, com.baidu.tbadk.mainTab.e eVar, String str) {
        if (cVar != null) {
            FragmentTabHost.c cVar2 = new FragmentTabHost.c();
            cVar2.aSS = cVar.bvx;
            if (cVar2.aSS.getArguments() == null) {
                Bundle bundle = new Bundle();
                bundle.putString("name", this.dJb.aYy().getName());
                bundle.putString("from", "game_frs");
                bundle.putString(ImageViewerConfig.FORUM_ID, this.dJb.aYy().getId());
                cVar2.aSS.setArguments(bundle);
            } else {
                cVar2.aSS.getArguments().putString(ImageViewerConfig.FORUM_ID, this.dJb.aYy().getId());
            }
            cVar2.mType = cVar.type;
            if (cVar.bvF == com.baidu.tbadk.mainTab.c.bvC && cVar.type == 99) {
                eVar.aJ(9, -((int) this.dIX.getResources().getDimension(d.e.ds12)));
            } else if (!TextUtils.isEmpty(str)) {
                eVar.setText(str);
            } else {
                eVar.setText(cVar.bvy);
            }
            eVar.setTextSize(0, this.dIX.getResources().getDimension(d.e.ds30));
            eVar.setTextColorResId(d.C0108d.s_game_frs_tabbar_text_color);
            eVar.setCompoundDrawablesTopResId(cVar.bvz);
            eVar.setContentTvTopMargin(this.dIX.getResources().getDimensionPixelSize(d.e.ds2));
            eVar.gC(TbadkCoreApplication.getInst().getSkinType());
            eVar.setTipPosType(1);
            eVar.setIsContentSelectBold(true);
            boolean z = cVar.bvF == com.baidu.tbadk.mainTab.c.bvC && cVar.type == 99;
            boolean z2 = cVar.type == 1;
            if (!z && !z2 && (eVar instanceof FragmentTabIndicator)) {
                eVar.a(String.valueOf(cVar2.mType), a((FragmentTabIndicator) eVar));
            }
            cVar2.aSR = eVar;
            cVar2.aST = bVar;
            this.bUD.a(cVar2);
        }
    }

    private e.a a(FragmentTabIndicator fragmentTabIndicator) {
        int dimensionPixelSize = this.dIX.getResources().getDimensionPixelSize(d.e.ds12);
        ImageView imageView = new ImageView(this.dIX);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        imageView.setImageResource(d.f.icon_frs_tab_new_notify_red_point);
        e.a aVar = new e.a();
        fragmentTabIndicator.setTipPosType(1);
        fragmentTabIndicator.setTipTopMargin(this.dIX.getResources().getDimensionPixelSize(d.e.ds12));
        aVar.bvS = fragmentTabIndicator;
        aVar.aiC = this.dIX.getResources().getDimensionPixelSize(d.e.ds12);
        aVar.view = imageView;
        aVar.view.setVisibility(8);
        return aVar;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.dIY instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.dIY.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a jk(int i) {
        if (this.dIY instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.dIY.jk(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.dIY instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.dIY.a(bVar);
        }
    }

    public void onNewIntent(Intent intent) {
        if (this.dIY != null) {
            this.dIY.onNewIntent(intent);
        }
    }

    public void onResume() {
        if (this.bUD == null) {
            this.dIY.setPrimary(true);
            return;
        }
        Fragment currentFragment = this.bUD.getCurrentFragment();
        if (currentFragment instanceof BaseFragment) {
            ((BaseFragment) currentFragment).setPrimary(true);
        }
    }

    public void onPause() {
        if (this.bUD == null) {
            this.dIY.setPrimary(false);
            return;
        }
        Fragment currentFragment = this.bUD.getCurrentFragment();
        if (currentFragment instanceof BaseFragment) {
            ((BaseFragment) currentFragment).setPrimary(false);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bUD == null) {
            this.dIY.onChangeSkinType(i);
        } else {
            this.bUD.bf(true);
            this.bUD.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.dJa != null) {
            aj.c(this.dJa, d.f.icon_tabbar_add_n);
            aj.s(this.dJa, d.f.icon_tabbar_chaticon_n);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.bUD != null && this.dIZ != null && this.dIZ.isShowing()) {
                this.dIZ.bLt();
            } else if (this.dIY != null && this.dIY.isAdded()) {
                if (this.dIY.onKeyDown(i, keyEvent)) {
                    return true;
                }
                this.dIY.closeActivity();
            } else {
                return this.dIX.e(i, keyEvent);
            }
            return false;
        }
        return this.dIX.e(i, keyEvent);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        com.baidu.tbadk.coreExtra.c.d shareItem;
        if (this.bUD == null) {
            this.dIY.onActivityResult(i, i2, intent);
        } else {
            this.bUD.getCurrentFragment().onActivityResult(i, i2, intent);
        }
        if (i2 == -1 && i == 24007) {
            int intExtra = intent.getIntExtra("extra_share_status", 2);
            int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
            if (intExtra == 1 && (shareItem = TbadkCoreApplication.getInst().getShareItem()) != null && shareItem.linkUrl != null && this.dJg != null) {
                this.dJg.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.frs.gametab.c.2
                    @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                    public void Hl() {
                    }

                    @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                    public void a(final CustomDialogData customDialogData) {
                        com.baidu.adp.lib.g.e.nr().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.c.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (c.this.dIX != null) {
                                    com.baidu.tieba.pb.interactionpopupwindow.c.a(c.this.dIX.getPageContext(), customDialogData).show();
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
        if (this.bUD == null) {
            return this.dIY.getVoiceManager();
        }
        Fragment currentFragment = this.bUD.getCurrentFragment();
        if (currentFragment instanceof VoiceManager.c) {
            return ((VoiceManager.c) currentFragment).getVoiceManager();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void awA() {
        if (!this.dJh.bGo() && !awB()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE));
            if (this.dIZ == null) {
                this.dIZ = new com.baidu.tieba.write.c(this.dIX.getPageContext(), this.bYy, "frs");
                this.dIZ.uF("2");
            }
            this.dIZ.a(this.dIY.atr());
            this.dIZ.op(false);
        }
    }

    public boolean awB() {
        String fixedText;
        if (this.dIY == null || !this.dIY.isAdded() || this.dIY.getPageContext() == null) {
            return false;
        }
        com.baidu.tieba.tbadkCore.l atn = this.dIY.atn();
        if (atn == null) {
            return false;
        }
        if (ax.be(this.dIY.getPageContext().getPageActivity())) {
            AntiData xJ = atn.xJ();
            if (xJ != null) {
                if (a(xJ.getBlock_stat(), xJ.mFrsForbidenDialogInfo)) {
                    return true;
                }
                if (xJ.getIfpost() == 0 && !StringUtils.isNull(xJ.getForbid_info())) {
                    String forbid_info = xJ.getForbid_info();
                    if (com.baidu.tbadk.core.util.am.ec(forbid_info) > 14) {
                        forbid_info = com.baidu.tbadk.core.util.am.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                    }
                    BdToast b = BdToast.b(this.dIY.getPageContext().getPageActivity(), forbid_info, d.f.icon_toast_game_error);
                    b.U(1.25f);
                    b.AQ();
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.dIY.getResources().getString(d.j.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast b = BdToast.b(this.dIY.getPageContext().getPageActivity(), string, d.f.icon_toast_game_error);
            b.U(1.25f);
            b.AQ();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dIY.getPageContext().getPageActivity());
        aVar.cZ(com.baidu.tbadk.core.util.am.getFixedText(string, 50, true));
        aVar.b(com.baidu.tbadk.core.util.am.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.dIY.getResources().getString(d.j.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.gametab.c.3
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
                    av.Di().c(c.this.dIY.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.dIY.getPageContext()).AI();
        return true;
    }

    private int awC() {
        if (this.dJc == null) {
            return -1;
        }
        int F = v.F(this.dJc.aui());
        for (int i = 0; i < F; i++) {
            if (this.dJc.aui().get(i).tab_id.intValue() == 1) {
                return i;
            }
        }
        return -1;
    }

    private int ny(int i) {
        if (this.dJc == null) {
            return -1;
        }
        int F = v.F(this.dJc.aui());
        for (int i2 = 0; i2 < F; i2++) {
            if (this.dJc.aui().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    public i awD() {
        return this.dIY;
    }

    public void onDestroy() {
        if (this.dIX.isLoadingViewAttached()) {
            this.dIX.hideLoadingView(this.dIX.findViewById(16908290));
        }
        if (this.dJl != null) {
            com.baidu.adp.lib.g.e.nr().removeCallbacks(this.dJl);
        }
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(this.dJf, false);
        if (this.dJg != null) {
            this.dJg.cancelLoadData();
        }
    }
}
