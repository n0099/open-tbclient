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
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
import com.baidu.tbadk.mainTab.e;
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
    private FrameLayout bIe;
    private FragmentTabHost bdS;
    private FrsActivity cMS;
    private f cMT;
    private com.baidu.tieba.write.c cMU;
    private ImageView cMV;
    private Animation cMW;
    private Animation cMX;
    private g cMY;
    private ae cMZ;
    private String mForumName;
    private boolean cNa = false;
    private Handler mHandler = new Handler();
    private com.baidu.adp.framework.listener.a cNb = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FRS_HTTP_CMD, 301001) { // from class: com.baidu.tieba.frs.gametab.c.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            g gVar = null;
            if (!c.this.cNa && !responsedMessage.hasError()) {
                if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                    gVar = ((FrsPageHttpResponseMessage) responsedMessage).getResponseData();
                } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                    gVar = ((FRSPageSocketResponsedMessage) responsedMessage).getResponseData();
                }
                if (gVar != null) {
                    c.this.cNa = true;
                    c.this.c(gVar);
                }
            }
        }
    };
    private CustomMessageListener cNc = new CustomMessageListener(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE) { // from class: com.baidu.tieba.frs.gametab.c.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!c.this.cNa && customResponsedMessage != null && (customResponsedMessage.getData() instanceof g)) {
                g gVar = (g) customResponsedMessage.getData();
                if (gVar.aPM() != null && c.this.mForumName != null && c.this.mForumName.equals(gVar.aPM().getName())) {
                    c.this.c(gVar);
                }
            }
        }
    };
    private CustomMessageListener cNd = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_SHOW_TAB) { // from class: com.baidu.tieba.frs.gametab.c.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof Boolean) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    c.this.ani();
                } else if (c.this.bdS != null) {
                    c.this.bdS.getTabWrapper().setVisibility(0);
                }
            }
        }
    };
    private CustomMessageListener cNe = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_HIDE_TAB) { // from class: com.baidu.tieba.frs.gametab.c.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof Boolean) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    c.this.anj();
                } else if (c.this.bdS != null) {
                    c.this.bdS.getTabWrapper().setVisibility(8);
                }
            }
        }
    };

    public c(FrsActivity frsActivity) {
        this.cMS = frsActivity;
    }

    public void init(Bundle bundle) {
        this.cNb.getHttpMessageListener().setPriority(-1);
        this.cNb.getSocketMessageListener().setPriority(-1);
        this.cMS.registerListener(this.cNb);
        this.cMS.registerListener(this.cNc);
        if (bundle == null) {
            this.mForumName = this.cMS.getIntent().getStringExtra("name");
        } else {
            this.mForumName = bundle.getString("name");
        }
        j(bundle);
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.mForumName);
    }

    private void j(Bundle bundle) {
        if (this.cMT == null) {
            this.cMT = new f();
            this.cMT.setArguments(bundle);
        }
        FragmentTransaction beginTransaction = this.cMS.getSupportFragmentManager().beginTransaction();
        beginTransaction.add(16908290, this.cMT);
        beginTransaction.commitAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(g gVar) {
        if (v.u(gVar.btd()) > 0) {
            this.cMY = gVar;
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.c.8
                @Override // java.lang.Runnable
                public void run() {
                    c.this.aV(c.this.cMY.btd());
                }
            });
        } else if (this.bdS != null) {
            this.bIe.removeView(this.bdS);
            this.bdS = null;
            this.cMZ = null;
            if (this.cMV != null && this.cMV.getParent() != null) {
                ((ViewGroup) this.cMV.getParent()).removeView(this.cMV);
            }
            j(null);
        }
    }

    private boolean anc() {
        FragmentManager supportFragmentManager = this.cMS.getSupportFragmentManager();
        try {
            supportFragmentManager.beginTransaction().remove(this.cMT).commitAllowingStateLoss();
            supportFragmentManager.executePendingTransactions();
            return true;
        } catch (IllegalStateException e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aV(List<FrsTabInfo> list) {
        if (this.bdS == null && anc()) {
            aW(list);
        }
    }

    private void aW(List<FrsTabInfo> list) {
        if (!v.v(list)) {
            CustomMessageListener customMessageListener = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB) { // from class: com.baidu.tieba.frs.gametab.c.9
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ae)) {
                        c.this.ane();
                    }
                }
            };
            customMessageListener.setPriority(Integer.MAX_VALUE);
            this.cMS.registerListener(customMessageListener);
            List arrayList = new ArrayList(list);
            FrsTabInfo.Builder builder = new FrsTabInfo.Builder();
            builder.tab_id = 99;
            builder.tab_name = this.cMS.getResources().getString(d.j.send);
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
            this.cMZ = new ae(this.cMS.getActivity(), arrayList);
            if (aiA() != null) {
                this.cMZ.setForumId(aiA().getForumId());
                this.cMZ.setForumName(aiA().getForumName());
                if (aiA().ajn() != null && aiA().ajn().aPM() != null) {
                    this.cMZ.setForumGameLabel(aiA().ajn().aPM().getForumGameLabel());
                }
            }
            new d(this.cMT).a(this.cMZ);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB, this.cMZ));
        }
    }

    private void and() {
        int ank = ank();
        if (ank >= 0) {
            a(this.cMT, ank);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ane() {
        if (this.cMZ != null) {
            this.cMZ.aki();
            if (!v.v(this.cMZ.akj())) {
                and();
                if (this.bdS == null) {
                    this.bdS = new FragmentTabHost(this.cMS.getActivity());
                    this.bdS.setClipChildren(false);
                    this.bdS.setClipToPadding(false);
                    this.bdS.setup(this.cMS.getSupportFragmentManager());
                    this.bdS.setShouldDrawIndicatorLine(false);
                    this.bdS.setShouldDrawTopLine(true);
                    this.bdS.f(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds10), 0, 0);
                    this.bdS.ay(true);
                    this.bdS.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    this.bIe = new FrameLayout(this.cMS.getActivity());
                    this.bIe.setClipChildren(false);
                    this.bIe.setClipToPadding(false);
                    this.bIe.addView(this.bdS);
                    this.cMS.setContentView(this.bIe);
                    this.bdS.setOnTabSelectionListener(new FragmentTabHost.b() { // from class: com.baidu.tieba.frs.gametab.c.10
                        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
                        public void e(int i, boolean z) {
                            c.this.a(c.this.bdS.getCurrentFragment(), i);
                        }

                        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
                        public boolean f(int i, boolean z) {
                            String str = null;
                            FragmentTabHost.c cB = c.this.bdS.cB(i);
                            if (c.this.cMY != null && c.this.cMY.aPM() != null) {
                                str = c.this.cMY.aPM().getId();
                            }
                            if (cB.mType != 99) {
                                TiebaStatic.log(new ak("c12334").r("obj_locate", c.this.b(cB)).ac(ImageViewerConfig.FORUM_ID, str));
                                return true;
                            }
                            c.this.ang();
                            TiebaStatic.log(new ak("c12342").r("obj_locate", c.this.b(c.this.bdS.cB(c.this.bdS.getCurrentTabIndex()))).ac(ImageViewerConfig.FORUM_ID, str));
                            TiebaStatic.log(new ak("c12334").r("obj_locate", c.this.b(cB)).ac(ImageViewerConfig.FORUM_ID, str));
                            return false;
                        }
                    });
                } else {
                    this.bdS.reset();
                }
                List<com.baidu.tbadk.mainTab.b> akj = this.cMZ.akj();
                List<FrsTabInfo> akh = this.cMZ.akh();
                if (akh.size() == akj.size()) {
                    int size = akh.size();
                    for (int i = 0; i < size; i++) {
                        com.baidu.tbadk.mainTab.b bVar = akj.get(i);
                        if (bVar != null) {
                            FrsTabInfo frsTabInfo = akh.get(i);
                            if (frsTabInfo == null || TextUtils.isEmpty(frsTabInfo.tab_name)) {
                                a(bVar, bVar.EG(), bVar.aY(this.cMS.getActivity()), null);
                            } else {
                                a(bVar, bVar.EG(), bVar.aY(this.cMS.getActivity()), frsTabInfo.tab_name);
                            }
                        }
                    }
                } else {
                    for (com.baidu.tbadk.mainTab.b bVar2 : akj) {
                        a(bVar2, bVar2.EG(), bVar2.aY(this.cMS.getActivity()), null);
                    }
                }
                this.bdS.uc();
                this.bdS.cz(2);
                this.bdS.ax(true);
                this.bdS.setViewPagerScrollable(false);
                int ank = ank();
                if (ank >= 0) {
                    this.bdS.setCurrentTab(ank);
                } else {
                    this.bdS.setCurrentTab(0);
                }
                anf();
                this.bdS.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    private void anf() {
        if (this.bdS != null && this.bdS.cC(99) != null) {
            if (this.cMV == null || this.cMV.getParent() == null) {
                if (this.cMV == null) {
                    this.cMV = new ImageView(this.cMS.getActivity());
                }
                int f = l.f(this.cMS.getActivity(), d.e.ds80);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(f, f);
                layoutParams.gravity = 81;
                layoutParams.bottomMargin = l.f(this.cMS.getActivity(), d.e.ds5);
                this.cMV.setLayoutParams(layoutParams);
                aj.c(this.cMV, d.f.icon_tabbar_add_n);
                aj.j(this.cMV, d.f.icon_tabbar_chaticon_n);
                this.cMV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.c.11
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        String str = null;
                        c.this.ang();
                        if (c.this.bdS != null) {
                            if (c.this.cMY != null && c.this.cMY.aPM() != null) {
                                str = c.this.cMY.aPM().getId();
                            }
                            TiebaStatic.log(new ak("c12342").r("obj_locate", c.this.b(c.this.bdS.cB(c.this.bdS.getCurrentTabIndex()))).ac(ImageViewerConfig.FORUM_ID, str));
                            TiebaStatic.log(new ak("c12334").r("obj_locate", 99).ac(ImageViewerConfig.FORUM_ID, str));
                        }
                    }
                });
                if (this.cMV.getParent() == null) {
                    this.bIe.addView(this.cMV);
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
        NavigationBar ajm;
        if ((fragment instanceof com.baidu.tieba.frs.ak) && this.cMY != null && this.cMY.aPM() != null && (ajm = ((com.baidu.tieba.frs.ak) fragment).ajm()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.cMY.aPM().getName(), 5, true, true) + this.cMS.getActivity().getString(d.j.forum));
            FrsTabInfo frsTabInfo = (FrsTabInfo) v.c(this.cMZ.akh(), i);
            if (frsTabInfo != null) {
                sb.append(" · ");
                sb.append(frsTabInfo.tab_name);
            }
            ajm.setCenterTextTitle(sb.toString());
        }
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, e eVar, String str) {
        if (cVar != null) {
            FragmentTabHost.c cVar2 = new FragmentTabHost.c();
            cVar2.aeo = cVar.aGS;
            if (cVar2.aeo.getArguments() == null) {
                Bundle bundle = new Bundle();
                bundle.putString("name", this.cMY.aPM().getName());
                bundle.putString("from", "game_frs");
                bundle.putString(ImageViewerConfig.FORUM_ID, this.cMY.aPM().getId());
                cVar2.aeo.setArguments(bundle);
            } else {
                cVar2.aeo.getArguments().putString(ImageViewerConfig.FORUM_ID, this.cMY.aPM().getId());
            }
            cVar2.mType = cVar.type;
            if (cVar.aHa == com.baidu.tbadk.mainTab.c.aGX && cVar.type == 99) {
                eVar.L(9, -((int) this.cMS.getResources().getDimension(d.e.ds12)));
            } else if (!TextUtils.isEmpty(str)) {
                eVar.setText(str);
            } else {
                eVar.setText(cVar.aGT);
            }
            eVar.setTextSize(0, this.cMS.getResources().getDimension(d.e.ds30));
            eVar.setTextColorResId(d.C0080d.s_game_frs_tabbar_text_color);
            eVar.setCompoundDrawablesTopResId(cVar.aGU);
            eVar.setContentTvTopMargin(this.cMS.getResources().getDimensionPixelSize(d.e.ds2));
            eVar.dE(TbadkCoreApplication.getInst().getSkinType());
            eVar.setTipPosType(1);
            eVar.setIsContentSelectBold(true);
            cVar2.aen = eVar;
            cVar2.aep = bVar;
            this.bdS.a(cVar2);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.cMT instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.cMT.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a ge(int i) {
        if (this.cMT instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.cMT.ge(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.cMT instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.cMT.a(bVar);
        }
    }

    public void onNewIntent(Intent intent) {
        if (this.cMT != null) {
            this.cMT.onNewIntent(intent);
        }
    }

    public void onResume() {
        if (this.bdS == null) {
            this.cMT.setPrimary(true);
            return;
        }
        Fragment currentFragment = this.bdS.getCurrentFragment();
        if (currentFragment instanceof BaseFragment) {
            ((BaseFragment) currentFragment).setPrimary(true);
        }
    }

    public void onPause() {
        if (this.bdS == null) {
            this.cMT.setPrimary(false);
            return;
        }
        Fragment currentFragment = this.bdS.getCurrentFragment();
        if (currentFragment instanceof BaseFragment) {
            ((BaseFragment) currentFragment).setPrimary(false);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bdS == null) {
            this.cMT.onChangeSkinType(i);
        } else {
            this.bdS.ax(true);
            this.bdS.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.cMV != null) {
            aj.c(this.cMV, d.f.icon_tabbar_add_n);
            aj.j(this.cMV, d.f.icon_tabbar_chaticon_n);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.bdS != null && this.cMU != null && this.cMU.isShowing()) {
                this.cMU.bCj();
            } else if (this.cMT != null && this.cMT.isAdded()) {
                if (this.cMT.onKeyDown(i, keyEvent)) {
                    return true;
                }
                this.cMT.closeActivity();
            } else {
                return this.cMS.b(i, keyEvent);
            }
            return false;
        }
        return this.cMS.b(i, keyEvent);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.bdS == null) {
            this.cMT.onActivityResult(i, i2, intent);
        } else {
            this.bdS.getCurrentFragment().onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.bdS == null) {
            return this.cMT.getVoiceManager();
        }
        Fragment currentFragment = this.bdS.getCurrentFragment();
        if (currentFragment instanceof VoiceManager.c) {
            return ((VoiceManager.c) currentFragment).getVoiceManager();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void ang() {
        if (!anh()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE));
            if (this.cMU == null) {
                this.cMU = new com.baidu.tieba.write.c(this.cMS.getPageContext(), this.bIe, "frs");
                this.cMU.tJ("1");
            }
            this.cMU.a(this.cMT.ajr());
            this.cMU.nk(false);
        }
    }

    public boolean anh() {
        String fixedText;
        if (this.cMT == null || !this.cMT.isAdded() || this.cMT.getPageContext() == null) {
            return false;
        }
        j ajn = this.cMT.ajn();
        if (ajn == null) {
            return false;
        }
        if (ax.aT(this.cMT.getPageContext().getPageActivity())) {
            AntiData qf = ajn.qf();
            if (qf != null) {
                if (a(qf.getBlock_stat(), qf.mFrsForbidenDialogInfo)) {
                    return true;
                }
                if (qf.getIfpost() == 0 && !StringUtils.isNull(qf.getForbid_info())) {
                    String forbid_info = qf.getForbid_info();
                    if (am.dT(forbid_info) > 14) {
                        forbid_info = am.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                    }
                    BdToast b = BdToast.b(this.cMT.getPageContext().getPageActivity(), forbid_info, d.f.icon_toast_game_error);
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.cMT.getResources().getString(d.j.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast b = BdToast.b(this.cMT.getPageContext().getPageActivity(), string, d.f.icon_toast_game_error);
            b.E(1.25f);
            b.tq();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cMT.getPageContext().getPageActivity());
        aVar.cS(am.getFixedText(string, 50, true));
        aVar.b(am.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.cMT.getResources().getString(d.j.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.gametab.c.12
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (aVar2 != null) {
                    aVar2.dismiss();
                }
            }
        });
        if (!StringUtils.isNull(blockPopInfoData.ahead_info) && !StringUtils.isNull(blockPopInfoData.ahead_url)) {
            aVar.a(am.getFixedText(blockPopInfoData.ahead_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.gametab.c.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    av.vI().c(c.this.cMT.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.cMT.getPageContext()).th();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ani() {
        if (this.bdS != null) {
            final FrameLayout tabWrapper = this.bdS.getTabWrapper();
            if (tabWrapper.getVisibility() != 0) {
                if (this.cMW == null) {
                    this.cMW = AnimationUtils.loadAnimation(this.cMS.getActivity(), d.a.translate_in);
                    this.cMW.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.gametab.c.3
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                            tabWrapper.setVisibility(0);
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            tabWrapper.clearAnimation();
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }
                    });
                }
                tabWrapper.clearAnimation();
                tabWrapper.startAnimation(this.cMW);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anj() {
        if (this.bdS != null) {
            final FrameLayout tabWrapper = this.bdS.getTabWrapper();
            if (tabWrapper.getVisibility() == 0) {
                if (this.cMX == null) {
                    this.cMX = AnimationUtils.loadAnimation(this.cMS.getActivity(), d.a.translate_out);
                    this.cMX.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.gametab.c.4
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                            tabWrapper.setVisibility(8);
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            tabWrapper.clearAnimation();
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }
                    });
                }
                tabWrapper.clearAnimation();
                tabWrapper.startAnimation(this.cMX);
            }
        }
    }

    private int ank() {
        if (this.cMZ == null) {
            return -1;
        }
        int u = v.u(this.cMZ.akh());
        for (int i = 0; i < u; i++) {
            if (this.cMZ.akh().get(i).tab_id.intValue() == 1) {
                return i;
            }
        }
        return -1;
    }

    public f aiA() {
        return this.cMT;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> aiB() {
        if (this.bdS == null) {
            if (this.cMT instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) this.cMT).aiB();
            }
        } else {
            Fragment currentFragment = this.bdS.getCurrentFragment();
            if (currentFragment instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) currentFragment).aiB();
            }
        }
        return null;
    }
}
