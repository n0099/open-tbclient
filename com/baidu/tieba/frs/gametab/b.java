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
import com.baidu.tieba.tbadkCore.i;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class b implements VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, FrsCommonImageLayout.c {
    private FragmentTabHost bdg;
    private FrsActivity cDM;
    private f cDN;
    private com.baidu.tieba.write.b cDO;
    private ImageView cDP;
    private Animation cDQ;
    private Animation cDR;
    private g cDS;
    private ae cDT;
    private FrameLayout cuT;
    private String mForumName;
    private boolean cDU = false;
    private Handler mHandler = new Handler();
    private com.baidu.adp.framework.listener.a cDV = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FRS_HTTP_CMD, 301001) { // from class: com.baidu.tieba.frs.gametab.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            g gVar = null;
            if (!b.this.cDU && !responsedMessage.hasError()) {
                if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                    gVar = ((FrsPageHttpResponseMessage) responsedMessage).getResponseData();
                } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                    gVar = ((FRSPageSocketResponsedMessage) responsedMessage).getResponseData();
                }
                if (gVar != null) {
                    b.this.cDU = true;
                    b.this.c(gVar);
                }
            }
        }
    };
    private CustomMessageListener cDW = new CustomMessageListener(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE) { // from class: com.baidu.tieba.frs.gametab.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!b.this.cDU && customResponsedMessage != null && (customResponsedMessage.getData() instanceof g)) {
                g gVar = (g) customResponsedMessage.getData();
                if (gVar.aMU() != null && b.this.mForumName != null && b.this.mForumName.equals(gVar.aMU().getName())) {
                    b.this.c(gVar);
                }
            }
        }
    };
    private CustomMessageListener cDX = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_SHOW_TAB) { // from class: com.baidu.tieba.frs.gametab.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof Boolean) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    b.this.akz();
                } else if (b.this.bdg != null) {
                    b.this.bdg.getTabWrapper().setVisibility(0);
                }
            }
        }
    };
    private CustomMessageListener cDY = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_HIDE_TAB) { // from class: com.baidu.tieba.frs.gametab.b.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof Boolean) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    b.this.akA();
                } else if (b.this.bdg != null) {
                    b.this.bdg.getTabWrapper().setVisibility(8);
                }
            }
        }
    };

    public b(FrsActivity frsActivity) {
        this.cDM = frsActivity;
    }

    public void init(Bundle bundle) {
        this.cDV.getHttpMessageListener().setPriority(-1);
        this.cDV.getSocketMessageListener().setPriority(-1);
        this.cDM.registerListener(this.cDV);
        this.cDM.registerListener(this.cDW);
        if (bundle == null) {
            this.mForumName = this.cDM.getIntent().getStringExtra("name");
        } else {
            this.mForumName = bundle.getString("name");
        }
        k(bundle);
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.mForumName);
    }

    private void k(Bundle bundle) {
        if (this.cDN == null) {
            this.cDN = new f();
            this.cDN.setArguments(bundle);
        }
        FragmentTransaction beginTransaction = this.cDM.getSupportFragmentManager().beginTransaction();
        beginTransaction.add(16908290, this.cDN);
        beginTransaction.commitAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(g gVar) {
        if (v.t(gVar.bpZ()) > 0) {
            this.cDS = gVar;
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.b.8
                @Override // java.lang.Runnable
                public void run() {
                    b.this.aS(b.this.cDS.bpZ());
                }
            });
        } else if (this.bdg != null) {
            this.cuT.removeView(this.bdg);
            this.bdg = null;
            this.cDT = null;
            if (this.cDP != null && this.cDP.getParent() != null) {
                ((ViewGroup) this.cDP.getParent()).removeView(this.cDP);
            }
            k(null);
        }
    }

    private boolean akt() {
        FragmentManager supportFragmentManager = this.cDM.getSupportFragmentManager();
        try {
            supportFragmentManager.beginTransaction().remove(this.cDN).commitAllowingStateLoss();
            supportFragmentManager.executePendingTransactions();
            return true;
        } catch (IllegalStateException e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aS(List<FrsTabInfo> list) {
        if (this.bdg == null && akt()) {
            aT(list);
        }
    }

    private void aT(List<FrsTabInfo> list) {
        if (!v.u(list)) {
            CustomMessageListener customMessageListener = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB) { // from class: com.baidu.tieba.frs.gametab.b.9
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ae)) {
                        b.this.akv();
                    }
                }
            };
            customMessageListener.setPriority(Integer.MAX_VALUE);
            this.cDM.registerListener(customMessageListener);
            List arrayList = new ArrayList(list);
            FrsTabInfo.Builder builder = new FrsTabInfo.Builder();
            builder.tab_id = 99;
            builder.tab_name = this.cDM.getResources().getString(d.l.send);
            builder.tab_type = 0;
            int t = v.t(arrayList);
            if (t > 4) {
                arrayList = arrayList.subList(0, 4);
                arrayList.add(2, builder.build(false));
            } else if (t < 2) {
                arrayList.add(builder.build(false));
            } else {
                arrayList.add(t / 2, builder.build(false));
            }
            this.cDT = new ae(this.cDM.getActivity(), arrayList);
            if (agt() != null) {
                this.cDT.setForumId(agt().getForumId());
                this.cDT.setForumName(agt().getForumName());
                if (agt().ahf() != null && agt().ahf().aMU() != null) {
                    this.cDT.setForumGameLabel(agt().ahf().aMU().getForumGameLabel());
                }
            }
            new c(this.cDN).a(this.cDT);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB, this.cDT));
        }
    }

    private void aku() {
        int akB = akB();
        if (akB >= 0) {
            a(this.cDN, akB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akv() {
        if (this.cDT != null) {
            this.cDT.aia();
            if (!v.u(this.cDT.aib())) {
                aku();
                if (this.bdg == null) {
                    this.bdg = new FragmentTabHost(this.cDM.getActivity());
                    this.bdg.setClipChildren(false);
                    this.bdg.setClipToPadding(false);
                    this.bdg.setup(this.cDM.getSupportFragmentManager());
                    this.bdg.setShouldDrawIndicatorLine(false);
                    this.bdg.setShouldDrawTopLine(true);
                    this.bdg.f(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds10), 0, 0);
                    this.bdg.aA(true);
                    this.bdg.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    this.cuT = new FrameLayout(this.cDM.getActivity());
                    this.cuT.setClipChildren(false);
                    this.cuT.setClipToPadding(false);
                    this.cuT.addView(this.bdg);
                    this.cDM.setContentView(this.cuT);
                    this.bdg.setOnTabSelectionListener(new FragmentTabHost.b() { // from class: com.baidu.tieba.frs.gametab.b.10
                        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
                        public void e(int i, boolean z) {
                            b.this.a(b.this.bdg.getCurrentFragment(), i);
                        }

                        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
                        public boolean f(int i, boolean z) {
                            String str = null;
                            FragmentTabHost.c cA = b.this.bdg.cA(i);
                            if (b.this.cDS != null && b.this.cDS.aMU() != null) {
                                str = b.this.cDS.aMU().getId();
                            }
                            if (cA.mType != 99) {
                                TiebaStatic.log(new ak("c12334").r("obj_locate", b.this.b(cA)).ac("fid", str));
                                return true;
                            }
                            b.this.akx();
                            TiebaStatic.log(new ak("c12342").r("obj_locate", b.this.b(b.this.bdg.cA(b.this.bdg.getCurrentTabIndex()))).ac("fid", str));
                            TiebaStatic.log(new ak("c12334").r("obj_locate", b.this.b(cA)).ac("fid", str));
                            return false;
                        }
                    });
                } else {
                    this.bdg.reset();
                }
                List<com.baidu.tbadk.mainTab.b> aib = this.cDT.aib();
                List<FrsTabInfo> ahZ = this.cDT.ahZ();
                if (ahZ.size() == aib.size()) {
                    int size = ahZ.size();
                    for (int i = 0; i < size; i++) {
                        com.baidu.tbadk.mainTab.b bVar = aib.get(i);
                        if (bVar != null) {
                            FrsTabInfo frsTabInfo = ahZ.get(i);
                            if (frsTabInfo == null || TextUtils.isEmpty(frsTabInfo.tab_name)) {
                                a(bVar, bVar.Eu(), bVar.aY(this.cDM.getActivity()), null);
                            } else {
                                a(bVar, bVar.Eu(), bVar.aY(this.cDM.getActivity()), frsTabInfo.tab_name);
                            }
                        }
                    }
                } else {
                    for (com.baidu.tbadk.mainTab.b bVar2 : aib) {
                        a(bVar2, bVar2.Eu(), bVar2.aY(this.cDM.getActivity()), null);
                    }
                }
                this.bdg.tV();
                this.bdg.cy(1);
                this.bdg.az(true);
                this.bdg.setViewPagerScrollable(false);
                int akB = akB();
                if (akB >= 0) {
                    this.bdg.setCurrentTab(akB);
                } else {
                    this.bdg.setCurrentTab(0);
                }
                akw();
                this.cDX.setSelfListener(true);
                this.cDM.registerListener(this.cDX);
                this.cDY.setSelfListener(true);
                this.cDM.registerListener(this.cDY);
                this.bdg.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    private void akw() {
        if (this.bdg != null && this.bdg.cB(99) != null) {
            if (this.cDP == null || this.cDP.getParent() == null) {
                if (this.cDP == null) {
                    this.cDP = new ImageView(this.cDM.getActivity());
                }
                int f = l.f(this.cDM.getActivity(), d.f.ds80);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(f, f);
                layoutParams.gravity = 81;
                layoutParams.bottomMargin = l.f(this.cDM.getActivity(), d.f.ds5);
                this.cDP.setLayoutParams(layoutParams);
                aj.c(this.cDP, d.g.icon_tabbar_add_n);
                aj.j(this.cDP, d.g.icon_tabbar_chaticon_n);
                this.cDP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.b.11
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        String str = null;
                        b.this.akx();
                        if (b.this.bdg != null) {
                            if (b.this.cDS != null && b.this.cDS.aMU() != null) {
                                str = b.this.cDS.aMU().getId();
                            }
                            TiebaStatic.log(new ak("c12342").r("obj_locate", b.this.b(b.this.bdg.cA(b.this.bdg.getCurrentTabIndex()))).ac("fid", str));
                            TiebaStatic.log(new ak("c12334").r("obj_locate", 99).ac("fid", str));
                        }
                    }
                });
                if (this.cDP.getParent() == null) {
                    this.cuT.addView(this.cDP);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(FragmentTabHost.c cVar) {
        if (cVar.mType == 4) {
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
        NavigationBar ahe;
        if ((fragment instanceof com.baidu.tieba.frs.ak) && this.cDS != null && this.cDS.aMU() != null && (ahe = ((com.baidu.tieba.frs.ak) fragment).ahe()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.cDS.aMU().getName(), 5, true, true) + this.cDM.getActivity().getString(d.l.forum));
            FrsTabInfo frsTabInfo = (FrsTabInfo) v.c(this.cDT.ahZ(), i);
            if (frsTabInfo != null) {
                sb.append(" · ");
                sb.append(frsTabInfo.tab_name);
            }
            ahe.setCenterTextTitle(sb.toString());
        }
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, e eVar, String str) {
        if (cVar != null) {
            FragmentTabHost.c cVar2 = new FragmentTabHost.c();
            cVar2.adS = cVar.aGi;
            if (cVar2.adS.getArguments() == null) {
                Bundle bundle = new Bundle();
                bundle.putString("name", this.cDS.aMU().getName());
                bundle.putString("from", "game_frs");
                bundle.putString("fid", this.cDS.aMU().getId());
                cVar2.adS.setArguments(bundle);
            } else {
                cVar2.adS.getArguments().putString("fid", this.cDS.aMU().getId());
            }
            cVar2.mType = cVar.type;
            if (cVar.aGq == com.baidu.tbadk.mainTab.c.aGn && cVar.type == 99) {
                eVar.L(9, -((int) this.cDM.getResources().getDimension(d.f.ds12)));
            } else if (!TextUtils.isEmpty(str)) {
                eVar.setText(str);
            } else {
                eVar.setText(cVar.aGj);
            }
            eVar.setTextSize(0, this.cDM.getResources().getDimension(d.f.ds30));
            eVar.setTextColorResId(d.e.s_game_frs_tabbar_text_color);
            eVar.setCompoundDrawablesTopResId(cVar.aGk);
            eVar.setContentTvTopMargin(this.cDM.getResources().getDimensionPixelSize(d.f.ds2));
            eVar.dD(TbadkCoreApplication.getInst().getSkinType());
            eVar.setTipPosType(1);
            eVar.setIsContentSelectBold(true);
            cVar2.adR = eVar;
            cVar2.adT = bVar;
            this.bdg.a(cVar2);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.cDN instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.cDN.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a fV(int i) {
        if (this.cDN instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.cDN.fV(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.cDN instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.cDN.a(bVar);
        }
    }

    public void onNewIntent(Intent intent) {
        if (this.cDN != null) {
            this.cDN.onNewIntent(intent);
        }
    }

    public void onResume() {
        if (this.bdg == null) {
            this.cDN.setPrimary(true);
            return;
        }
        Fragment currentFragment = this.bdg.getCurrentFragment();
        if (currentFragment instanceof BaseFragment) {
            ((BaseFragment) currentFragment).setPrimary(true);
        }
    }

    public void onPause() {
        if (this.bdg == null) {
            this.cDN.setPrimary(false);
            return;
        }
        Fragment currentFragment = this.bdg.getCurrentFragment();
        if (currentFragment instanceof BaseFragment) {
            ((BaseFragment) currentFragment).setPrimary(false);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bdg == null) {
            this.cDN.onChangeSkinType(i);
        } else {
            this.bdg.az(true);
            this.bdg.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.cDP != null) {
            aj.c(this.cDP, d.g.icon_tabbar_add_n);
            aj.j(this.cDP, d.g.icon_tabbar_chaticon_n);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.bdg != null && this.cDO != null && this.cDO.isShowing()) {
                this.cDO.byL();
            } else if (this.cDN != null && this.cDN.isAdded()) {
                if (this.cDN.onKeyDown(i, keyEvent)) {
                    return true;
                }
                this.cDN.closeActivity();
            } else {
                return this.cDM.a(i, keyEvent);
            }
            return false;
        }
        return this.cDM.a(i, keyEvent);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.bdg == null) {
            this.cDN.onActivityResult(i, i2, intent);
        } else {
            this.bdg.getCurrentFragment().onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.bdg == null) {
            return this.cDN.getVoiceManager();
        }
        Fragment currentFragment = this.bdg.getCurrentFragment();
        if (currentFragment instanceof VoiceManager.c) {
            return ((VoiceManager.c) currentFragment).getVoiceManager();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void akx() {
        if (!aky()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE));
            if (this.cDO == null) {
                this.cDO = new com.baidu.tieba.write.b(this.cDM.getPageContext(), this.cuT, "frs");
                this.cDO.sW("1");
            }
            this.cDO.a(this.cDN.ahj());
            this.cDO.nm(false);
        }
    }

    public boolean aky() {
        String fixedText;
        if (this.cDN == null || !this.cDN.isAdded() || this.cDN.getPageContext() == null) {
            return false;
        }
        i ahf = this.cDN.ahf();
        if (ahf == null) {
            return false;
        }
        if (ax.aT(this.cDN.getPageContext().getPageActivity())) {
            AntiData qa = ahf.qa();
            if (qa != null) {
                if (a(qa.getBlock_stat(), qa.mFrsForbidenDialogInfo)) {
                    return true;
                }
                if (qa.getIfpost() == 0 && !StringUtils.isNull(qa.getForbid_info())) {
                    String forbid_info = qa.getForbid_info();
                    if (am.dN(forbid_info) > 14) {
                        forbid_info = am.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                    }
                    BdToast b = BdToast.b(this.cDN.getPageContext().getPageActivity(), forbid_info, d.g.icon_toast_game_error);
                    b.F(1.25f);
                    b.tj();
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.cDN.getResources().getString(d.l.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast b = BdToast.b(this.cDN.getPageContext().getPageActivity(), string, d.g.icon_toast_game_error);
            b.F(1.25f);
            b.tj();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cDN.getPageContext().getPageActivity());
        aVar.cL(am.getFixedText(string, 50, true));
        aVar.b(am.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.cDN.getResources().getString(d.l.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.gametab.b.12
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (aVar2 != null) {
                    aVar2.dismiss();
                }
            }
        });
        if (!StringUtils.isNull(blockPopInfoData.ahead_info) && !StringUtils.isNull(blockPopInfoData.ahead_url)) {
            aVar.a(am.getFixedText(blockPopInfoData.ahead_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.gametab.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    av.vA().c(b.this.cDN.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.cDN.getPageContext()).tb();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akz() {
        if (this.bdg != null) {
            final FrameLayout tabWrapper = this.bdg.getTabWrapper();
            if (tabWrapper.getVisibility() != 0) {
                if (this.cDQ == null) {
                    this.cDQ = AnimationUtils.loadAnimation(this.cDM.getActivity(), d.a.translate_in);
                    this.cDQ.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.gametab.b.3
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
                tabWrapper.startAnimation(this.cDQ);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akA() {
        if (this.bdg != null) {
            final FrameLayout tabWrapper = this.bdg.getTabWrapper();
            if (tabWrapper.getVisibility() == 0) {
                if (this.cDR == null) {
                    this.cDR = AnimationUtils.loadAnimation(this.cDM.getActivity(), d.a.translate_out);
                    this.cDR.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.gametab.b.4
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
                tabWrapper.startAnimation(this.cDR);
            }
        }
    }

    private int akB() {
        if (this.cDT == null) {
            return -1;
        }
        int t = v.t(this.cDT.ahZ());
        for (int i = 0; i < t; i++) {
            if (this.cDT.ahZ().get(i).tab_id.intValue() == 1) {
                return i;
            }
        }
        return -1;
    }

    public f agt() {
        return this.cDN;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> agu() {
        if (this.bdg == null) {
            if (this.cDN instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) this.cDN).agu();
            }
        } else {
            Fragment currentFragment = this.bdg.getCurrentFragment();
            if (currentFragment instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) currentFragment).agu();
            }
        }
        return null;
    }
}
