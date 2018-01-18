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
    private FragmentTabHost bUK;
    private FrameLayout bYF;
    private i dNA;
    private com.baidu.tieba.write.c dNB;
    private ImageView dNC;
    private com.baidu.tieba.tbadkCore.i dND;
    private af dNE;
    private ShareSuccessReplyToServerModel dNI;
    private com.baidu.tieba.p.a dNJ;
    private FrsActivity dNz;
    private String mForumName;
    private boolean dNF = false;
    private Handler mHandler = new Handler();
    private int dNG = 0;
    private com.baidu.adp.framework.listener.a dNK = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FRS_HTTP_CMD, 301001) { // from class: com.baidu.tieba.frs.gametab.c.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            com.baidu.tieba.tbadkCore.i iVar = null;
            if (!c.this.dNF && !responsedMessage.hasError()) {
                if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                    iVar = ((FrsPageHttpResponseMessage) responsedMessage).getResponseData();
                } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                    iVar = ((FRSPageSocketResponsedMessage) responsedMessage).getResponseData();
                }
                if (iVar != null) {
                    c.this.dNF = true;
                    c.this.c(iVar);
                }
            }
        }
    };
    private CustomMessageListener dNL = new CustomMessageListener(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE) { // from class: com.baidu.tieba.frs.gametab.c.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!c.this.dNF && customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.i)) {
                com.baidu.tieba.tbadkCore.i iVar = (com.baidu.tieba.tbadkCore.i) customResponsedMessage.getData();
                if (iVar.aYE() != null && c.this.mForumName != null && c.this.mForumName.equals(iVar.aYE().getName())) {
                    c.this.c(iVar);
                }
            }
        }
    };
    private HttpMessageListener dNM = new HttpMessageListener(0) { // from class: com.baidu.tieba.frs.gametab.c.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && 1003275 == httpResponsedMessage.getCmd() && (httpResponsedMessage instanceof AlaGameTabGetNewNotifyResponsedMessage)) {
                List<a> newNotifyData = ((AlaGameTabGetNewNotifyResponsedMessage) httpResponsedMessage).getNewNotifyData();
                if (!v.E(newNotifyData)) {
                    for (a aVar : newNotifyData) {
                        if (aVar != null) {
                            for (int i = 0; i < c.this.dNE.avl().size(); i++) {
                                FragmentTabHost.c fy = c.this.bUK.fy(i);
                                if (fy.mType != 99 && fy.mType != 1 && fy.mType != c.this.bUK.getCurrentTabType() && fy.mType == aVar.getTabId() && aVar.axw() && fy.aSQ.gG(String.valueOf(fy.mType)) != null) {
                                    fy.aSQ.gG(String.valueOf(fy.mType)).view.setVisibility(0);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private Runnable dNN = new Runnable() { // from class: com.baidu.tieba.frs.gametab.c.7
        @Override // java.lang.Runnable
        public void run() {
            e.nr().removeCallbacks(this);
            c.this.axA();
            e.nr().postDelayed(this, 30000L);
        }
    };
    private String dNH = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_game_forem_tab_hot_point");

    public c(FrsActivity frsActivity) {
        this.dNz = frsActivity;
    }

    public void init(Bundle bundle) {
        this.dNK.getHttpMessageListener().setPriority(-1);
        this.dNK.getSocketMessageListener().setPriority(-1);
        this.dNz.registerListener(this.dNL);
        if (bundle == null) {
            this.mForumName = this.dNz.getIntent().getStringExtra("name");
            this.dNG = this.dNz.getIntent().getIntExtra(FrsActivityConfig.FRS_GAME_DEFAULT_TAB_ID, 0);
        } else {
            this.mForumName = bundle.getString("name");
            this.dNG = bundle.getInt("default_tab_id", 0);
        }
        m(bundle);
        this.dNI = new ShareSuccessReplyToServerModel();
        this.dNz.registerListener(this.dNK);
        this.dNJ = new com.baidu.tieba.p.a(this.dNz.getPageContext());
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.mForumName);
        bundle.putInt("default_tab_id", this.dNG);
    }

    private void m(Bundle bundle) {
        if (this.dNA == null) {
            this.dNA = new i();
            this.dNA.setArguments(bundle);
        }
        FragmentTransaction beginTransaction = this.dNz.getSupportFragmentManager().beginTransaction();
        beginTransaction.add(16908290, this.dNA);
        beginTransaction.commitAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.i iVar) {
        if (v.D(iVar.buj()) > 0) {
            this.dND = iVar;
            if (!this.dNz.isLoadingViewAttached() && this.bUK == null) {
                this.dNz.showLoadingView(this.dNz.findViewById(16908290));
            }
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.c.8
                @Override // java.lang.Runnable
                public void run() {
                    c.this.bq(c.this.dND.buj());
                }
            });
        } else if (this.bUK != null) {
            this.bYF.removeView(this.bUK);
            this.bUK = null;
            this.dNE = null;
            if (this.dNC != null && this.dNC.getParent() != null) {
                ((ViewGroup) this.dNC.getParent()).removeView(this.dNC);
            }
            m(null);
        }
    }

    private boolean axx() {
        FragmentManager supportFragmentManager = this.dNz.getSupportFragmentManager();
        try {
            supportFragmentManager.beginTransaction().remove(this.dNA).commitAllowingStateLoss();
            supportFragmentManager.executePendingTransactions();
            return true;
        } catch (IllegalStateException e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bq(List<FrsTabInfo> list) {
        if (this.bUK == null && axx()) {
            axy();
            br(list);
        }
        if (this.dNz.isLoadingViewAttached()) {
            this.dNz.hideLoadingView(this.dNz.findViewById(16908290));
        }
    }

    private void axy() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003275, TbConfig.SERVER_ADDRESS + "game/forum/getNewNotify");
        tbHttpMessageTask.setResponsedClass(AlaGameTabGetNewNotifyResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.dNz.registerListener(1003275, this.dNM);
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
                        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(c.this.dNH, true)) {
                            e.nr().post(c.this.dNN);
                        }
                        c.this.axB();
                    }
                }
            };
            customMessageListener.setPriority(Integer.MAX_VALUE);
            customMessageListener.setSelfListener(true);
            this.dNz.registerListener(customMessageListener);
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
            builder.tab_name = this.dNz.getResources().getString(d.j.send);
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
            this.dNE = new af(this.dNz.getActivity(), list2);
            if (axG() != null) {
                this.dNE.setForumId(axG().getForumId());
                this.dNE.setForumName(axG().getForumName());
                if (axG().auq() != null && axG().auq().aYE() != null) {
                    this.dNE.setForumGameLabel(axG().auq().aYE().getForumGameLabel());
                }
            }
            new d(this.dNA).a(this.dNE);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB, this.dNE);
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB);
            customMessage.setTag(this.dNz.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    private void axz() {
        int axF = axF();
        if (axF >= 0) {
            a(this.dNA, axF);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axA() {
        if (this.dNE != null && !TextUtils.isEmpty(this.dNE.getForumId())) {
            HttpMessage httpMessage = new HttpMessage(1003275);
            httpMessage.addParam("forum_id", this.dND.aYE().getId());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axB() {
        if (this.dNE != null) {
            this.dNE.avm();
            if (!v.E(this.dNE.atJ())) {
                axz();
                if (this.bUK == null) {
                    this.bUK = new FragmentTabHost(this.dNz.getActivity());
                    this.bUK.setClipChildren(false);
                    this.bUK.setClipToPadding(false);
                    this.bUK.setup(this.dNz.getSupportFragmentManager());
                    this.bUK.setShouldDrawIndicatorLine(false);
                    this.bUK.setShouldDrawTopLine(true);
                    this.bUK.n(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds10), 0, 0);
                    this.bUK.bg(true);
                    this.bUK.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    this.bYF = new FrameLayout(this.dNz.getActivity());
                    this.bYF.setClipChildren(false);
                    this.bYF.setClipToPadding(false);
                    this.bYF.addView(this.bUK);
                    this.dNz.setContentView(this.bYF);
                    this.bUK.setOnTabSelectionListener(new FragmentTabHost.b() { // from class: com.baidu.tieba.frs.gametab.c.10
                        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
                        public void p(int i, boolean z) {
                            c.this.a(c.this.bUK.getCurrentFragment(), i);
                        }

                        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
                        public boolean q(int i, boolean z) {
                            String str = null;
                            FragmentTabHost.c fy = c.this.bUK.fy(i);
                            if (c.this.dND != null && c.this.dND.aYE() != null) {
                                str = c.this.dND.aYE().getId();
                            }
                            if (fy.mType != 99) {
                                TiebaStatic.log(new ak("c12334").s("obj_locate", c.this.b(fy)).ab(ImageViewerConfig.FORUM_ID, str));
                                if (fy.mType != 1 && fy.aSQ.gG(String.valueOf(fy.mType)) != null) {
                                    if (!(fy.aSQ.gG(String.valueOf(fy.mType)).view.getVisibility() == 0)) {
                                        return true;
                                    }
                                    fy.aSQ.gG(String.valueOf(fy.mType)).view.setVisibility(8);
                                    if (fy.mType == 2 && (fy.aSR instanceof com.baidu.tieba.frs.gametab.livetab.b)) {
                                        ((com.baidu.tieba.frs.gametab.livetab.b) fy.aSR).XA();
                                    } else if (fy.mType == 3) {
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FORCE_REFRESH, "GoodsTab_3"));
                                    } else if (fy.mType == 101) {
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FORCE_REFRESH, "InfoTab_101"));
                                    }
                                }
                                return true;
                            }
                            c.this.axD();
                            TiebaStatic.log(new ak("c12342").s("obj_locate", c.this.b(c.this.bUK.fy(c.this.bUK.getCurrentTabIndex()))).ab(ImageViewerConfig.FORUM_ID, str));
                            TiebaStatic.log(new ak("c12334").s("obj_locate", c.this.b(fy)).ab(ImageViewerConfig.FORUM_ID, str));
                            return false;
                        }
                    });
                } else {
                    this.bUK.reset();
                }
                List<com.baidu.tbadk.mainTab.b> atJ = this.dNE.atJ();
                List<FrsTabInfo> avl = this.dNE.avl();
                if (avl.size() == atJ.size()) {
                    int size = avl.size();
                    for (int i = 0; i < size; i++) {
                        com.baidu.tbadk.mainTab.b bVar = atJ.get(i);
                        if (bVar != null) {
                            FrsTabInfo frsTabInfo = avl.get(i);
                            if (frsTabInfo == null || TextUtils.isEmpty(frsTabInfo.tab_name)) {
                                a(bVar, bVar.Mn(), bVar.bm(this.dNz.getActivity()), null);
                            } else {
                                a(bVar, bVar.Mn(), bVar.bm(this.dNz.getActivity()), frsTabInfo.tab_name);
                            }
                        }
                    }
                } else {
                    for (com.baidu.tbadk.mainTab.b bVar2 : atJ) {
                        a(bVar2, bVar2.Mn(), bVar2.bm(this.dNz.getActivity()), null);
                    }
                }
                this.bUK.Bu();
                this.bUK.fw(2);
                this.bUK.bf(true);
                this.bUK.setViewPagerScrollable(false);
                final int nB = nB(this.dNG);
                if (nB < 0) {
                    nB = nB(this.dND.buk());
                }
                if (nB < 0) {
                    nB = axF();
                }
                if (nB < 0) {
                    nB = 0;
                }
                this.bUK.setCurrentTab(nB);
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.c.11
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.this.bUK != null) {
                            c.this.a(c.this.bUK.getCurrentFragment(), nB);
                        }
                    }
                });
                axC();
                this.bUK.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    private void axC() {
        if (this.bUK != null && this.bUK.fz(99) != null) {
            if (this.dNC == null || this.dNC.getParent() == null) {
                if (this.dNC == null) {
                    this.dNC = new ImageView(this.dNz.getActivity());
                }
                int s = l.s(this.dNz.getActivity(), d.e.ds80);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(s, s);
                layoutParams.gravity = 81;
                layoutParams.bottomMargin = l.s(this.dNz.getActivity(), d.e.ds5);
                this.dNC.setLayoutParams(layoutParams);
                aj.c(this.dNC, d.f.icon_tabbar_add_n);
                aj.s(this.dNC, d.f.icon_tabbar_chaticon_n);
                this.dNC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.c.12
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        String str = null;
                        c.this.axD();
                        if (c.this.bUK != null) {
                            if (c.this.dND != null && c.this.dND.aYE() != null) {
                                str = c.this.dND.aYE().getId();
                            }
                            TiebaStatic.log(new ak("c12342").s("obj_locate", c.this.b(c.this.bUK.fy(c.this.bUK.getCurrentTabIndex()))).ab(ImageViewerConfig.FORUM_ID, str));
                            TiebaStatic.log(new ak("c12334").s("obj_locate", 99).ab(ImageViewerConfig.FORUM_ID, str));
                        }
                    }
                });
                if (this.dNC.getParent() == null) {
                    this.bYF.addView(this.dNC);
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
        NavigationBar aup;
        if ((fragment instanceof am) && this.dND != null && this.dND.aYE() != null && (aup = ((am) fragment).aup()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.dND.aYE().getName(), 5, true, true) + this.dNz.getActivity().getString(d.j.forum));
            FrsTabInfo frsTabInfo = (FrsTabInfo) v.f(this.dNE.avl(), i);
            if (frsTabInfo != null) {
                sb.append(" · ");
                sb.append(frsTabInfo.tab_name);
            }
            aup.setCenterTextTitle(sb.toString());
        }
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, com.baidu.tbadk.mainTab.e eVar, String str) {
        if (cVar != null) {
            FragmentTabHost.c cVar2 = new FragmentTabHost.c();
            cVar2.aSR = cVar.bvG;
            if (cVar2.aSR.getArguments() == null) {
                Bundle bundle = new Bundle();
                bundle.putString("name", this.dND.aYE().getName());
                bundle.putString("from", "game_frs");
                bundle.putString(ImageViewerConfig.FORUM_ID, this.dND.aYE().getId());
                cVar2.aSR.setArguments(bundle);
            } else {
                cVar2.aSR.getArguments().putString(ImageViewerConfig.FORUM_ID, this.dND.aYE().getId());
            }
            cVar2.mType = cVar.type;
            if (cVar.bvO == com.baidu.tbadk.mainTab.c.bvL && cVar.type == 99) {
                eVar.aJ(9, -((int) this.dNz.getResources().getDimension(d.e.ds12)));
            } else if (!TextUtils.isEmpty(str)) {
                eVar.setText(str);
            } else {
                eVar.setText(cVar.bvH);
            }
            eVar.setTextSize(0, this.dNz.getResources().getDimension(d.e.ds30));
            eVar.setTextColorResId(d.C0107d.s_game_frs_tabbar_text_color);
            eVar.setCompoundDrawablesTopResId(cVar.bvI);
            eVar.setContentTvTopMargin(this.dNz.getResources().getDimensionPixelSize(d.e.ds2));
            eVar.gz(TbadkCoreApplication.getInst().getSkinType());
            eVar.setTipPosType(1);
            eVar.setIsContentSelectBold(true);
            boolean z = cVar.bvO == com.baidu.tbadk.mainTab.c.bvL && cVar.type == 99;
            boolean z2 = cVar.type == 1;
            if (!z && !z2 && (eVar instanceof FragmentTabIndicator)) {
                eVar.a(String.valueOf(cVar2.mType), a((FragmentTabIndicator) eVar));
            }
            cVar2.aSQ = eVar;
            cVar2.aSS = bVar;
            this.bUK.a(cVar2);
        }
    }

    private e.a a(FragmentTabIndicator fragmentTabIndicator) {
        int dimensionPixelSize = this.dNz.getResources().getDimensionPixelSize(d.e.ds12);
        ImageView imageView = new ImageView(this.dNz);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        imageView.setImageResource(d.f.icon_frs_tab_new_notify_red_point);
        e.a aVar = new e.a();
        fragmentTabIndicator.setTipPosType(1);
        fragmentTabIndicator.setTipTopMargin(this.dNz.getResources().getDimensionPixelSize(d.e.ds12));
        aVar.bwb = fragmentTabIndicator;
        aVar.aiC = this.dNz.getResources().getDimensionPixelSize(d.e.ds12);
        aVar.view = imageView;
        aVar.view.setVisibility(8);
        return aVar;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.dNA instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.dNA.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a jg(int i) {
        if (this.dNA instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.dNA.jg(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.dNA instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.dNA.a(bVar);
        }
    }

    public void onNewIntent(Intent intent) {
        if (this.dNA != null) {
            this.dNA.onNewIntent(intent);
        }
    }

    public void onResume() {
        if (this.bUK == null) {
            this.dNA.setPrimary(true);
            return;
        }
        Fragment currentFragment = this.bUK.getCurrentFragment();
        if (currentFragment instanceof BaseFragment) {
            ((BaseFragment) currentFragment).setPrimary(true);
        }
    }

    public void onPause() {
        if (this.bUK == null) {
            this.dNA.setPrimary(false);
            return;
        }
        Fragment currentFragment = this.bUK.getCurrentFragment();
        if (currentFragment instanceof BaseFragment) {
            ((BaseFragment) currentFragment).setPrimary(false);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bUK == null) {
            this.dNA.onChangeSkinType(i);
        } else {
            this.bUK.bf(true);
            this.bUK.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.dNC != null) {
            aj.c(this.dNC, d.f.icon_tabbar_add_n);
            aj.s(this.dNC, d.f.icon_tabbar_chaticon_n);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.bUK != null && this.dNB != null && this.dNB.isShowing()) {
                this.dNB.bET();
            } else if (this.dNA != null && this.dNA.isAdded()) {
                if (this.dNA.onKeyDown(i, keyEvent)) {
                    return true;
                }
                this.dNA.closeActivity();
            } else {
                return this.dNz.e(i, keyEvent);
            }
            return false;
        }
        return this.dNz.e(i, keyEvent);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        com.baidu.tbadk.coreExtra.c.d shareItem;
        if (this.bUK == null) {
            this.dNA.onActivityResult(i, i2, intent);
        } else {
            this.bUK.getCurrentFragment().onActivityResult(i, i2, intent);
        }
        if (i2 == -1 && i == 24007) {
            int intExtra = intent.getIntExtra("extra_share_status", 2);
            int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
            if (intExtra == 1 && (shareItem = TbadkCoreApplication.getInst().getShareItem()) != null && shareItem.linkUrl != null && this.dNI != null) {
                this.dNI.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.frs.gametab.c.2
                    @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                    public void He() {
                    }

                    @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                    public void a(final CustomDialogData customDialogData) {
                        com.baidu.adp.lib.g.e.nr().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.c.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (c.this.dNz != null) {
                                    com.baidu.tieba.pb.interactionpopupwindow.c.a(c.this.dNz.getPageContext(), customDialogData).show();
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
        if (this.bUK == null) {
            return this.dNA.getVoiceManager();
        }
        Fragment currentFragment = this.bUK.getCurrentFragment();
        if (currentFragment instanceof VoiceManager.c) {
            return ((VoiceManager.c) currentFragment).getVoiceManager();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void axD() {
        if (!this.dNJ.bzL() && !axE()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE));
            if (this.dNB == null) {
                this.dNB = new com.baidu.tieba.write.c(this.dNz.getPageContext(), this.bYF, "frs");
                this.dNB.ua("2");
            }
            this.dNB.a(this.dNA.auu());
            this.dNB.ns(false);
        }
    }

    public boolean axE() {
        String fixedText;
        if (this.dNA == null || !this.dNA.isAdded() || this.dNA.getPageContext() == null) {
            return false;
        }
        com.baidu.tieba.tbadkCore.l auq = this.dNA.auq();
        if (auq == null) {
            return false;
        }
        if (ax.be(this.dNA.getPageContext().getPageActivity())) {
            AntiData xG = auq.xG();
            if (xG != null) {
                if (a(xG.getBlock_stat(), xG.mFrsForbidenDialogInfo)) {
                    return true;
                }
                if (xG.getIfpost() == 0 && !StringUtils.isNull(xG.getForbid_info())) {
                    String forbid_info = xG.getForbid_info();
                    if (com.baidu.tbadk.core.util.am.ec(forbid_info) > 14) {
                        forbid_info = com.baidu.tbadk.core.util.am.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                    }
                    BdToast b = BdToast.b(this.dNA.getPageContext().getPageActivity(), forbid_info, d.f.icon_toast_game_error);
                    b.U(1.25f);
                    b.AI();
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.dNA.getResources().getString(d.j.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast b = BdToast.b(this.dNA.getPageContext().getPageActivity(), string, d.f.icon_toast_game_error);
            b.U(1.25f);
            b.AI();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dNA.getPageContext().getPageActivity());
        aVar.cZ(com.baidu.tbadk.core.util.am.getFixedText(string, 50, true));
        aVar.b(com.baidu.tbadk.core.util.am.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.dNA.getResources().getString(d.j.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.gametab.c.3
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
                    av.CZ().c(c.this.dNA.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.dNA.getPageContext()).AA();
        return true;
    }

    private int axF() {
        if (this.dNE == null) {
            return -1;
        }
        int D = v.D(this.dNE.avl());
        for (int i = 0; i < D; i++) {
            if (this.dNE.avl().get(i).tab_id.intValue() == 1) {
                return i;
            }
        }
        return -1;
    }

    private int nB(int i) {
        if (this.dNE == null) {
            return -1;
        }
        int D = v.D(this.dNE.avl());
        for (int i2 = 0; i2 < D; i2++) {
            if (this.dNE.avl().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    public i axG() {
        return this.dNA;
    }

    public void onDestroy() {
        if (this.dNz.isLoadingViewAttached()) {
            this.dNz.hideLoadingView(this.dNz.findViewById(16908290));
        }
        if (this.dNN != null) {
            com.baidu.adp.lib.g.e.nr().removeCallbacks(this.dNN);
        }
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(this.dNH, false);
        if (this.dNI != null) {
            this.dNI.cancelLoadData();
        }
    }
}
