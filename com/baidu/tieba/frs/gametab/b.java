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
import com.baidu.adp.lib.util.k;
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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.mainTab.e;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.ad;
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
    private FragmentTabHost bbI;
    private FrsActivity cDf;
    private f cDg;
    private com.baidu.tieba.write.b cDh;
    private ImageView cDi;
    private Animation cDj;
    private Animation cDk;
    private g cDl;
    private ad cDm;
    private FrameLayout cuB;
    private String mForumName;
    private boolean cDn = false;
    private Handler mHandler = new Handler();
    private com.baidu.adp.framework.listener.a cDo = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FRS_HTTP_CMD, 301001) { // from class: com.baidu.tieba.frs.gametab.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            g gVar = null;
            if (!b.this.cDn && !responsedMessage.hasError()) {
                if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                    gVar = ((FrsPageHttpResponseMessage) responsedMessage).getResponseData();
                } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                    gVar = ((FRSPageSocketResponsedMessage) responsedMessage).getResponseData();
                }
                if (gVar != null) {
                    b.this.cDn = true;
                    b.this.c(gVar);
                }
            }
        }
    };
    private CustomMessageListener cDp = new CustomMessageListener(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE) { // from class: com.baidu.tieba.frs.gametab.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!b.this.cDn && customResponsedMessage != null && (customResponsedMessage.getData() instanceof g)) {
                g gVar = (g) customResponsedMessage.getData();
                if (gVar.aPg() != null && b.this.mForumName != null && b.this.mForumName.equals(gVar.aPg().getName())) {
                    b.this.c(gVar);
                }
            }
        }
    };
    private CustomMessageListener cDq = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_SHOW_TAB) { // from class: com.baidu.tieba.frs.gametab.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof Boolean) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    b.this.akA();
                } else if (b.this.bbI != null) {
                    b.this.bbI.getTabWrapper().setVisibility(0);
                }
            }
        }
    };
    private CustomMessageListener cDr = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_HIDE_TAB) { // from class: com.baidu.tieba.frs.gametab.b.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof Boolean) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    b.this.akB();
                } else if (b.this.bbI != null) {
                    b.this.bbI.getTabWrapper().setVisibility(8);
                }
            }
        }
    };

    public b(FrsActivity frsActivity) {
        this.cDf = frsActivity;
    }

    public void init(Bundle bundle) {
        this.cDo.getHttpMessageListener().setPriority(-1);
        this.cDo.getSocketMessageListener().setPriority(-1);
        this.cDf.registerListener(this.cDo);
        this.cDf.registerListener(this.cDp);
        if (bundle == null) {
            this.mForumName = this.cDf.getIntent().getStringExtra("name");
        } else {
            this.mForumName = bundle.getString("name");
        }
        k(bundle);
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.mForumName);
    }

    private void k(Bundle bundle) {
        if (this.cDg == null) {
            this.cDg = new f();
            this.cDg.setArguments(bundle);
        }
        FragmentTransaction beginTransaction = this.cDf.getSupportFragmentManager().beginTransaction();
        beginTransaction.add(16908290, this.cDg);
        beginTransaction.commitAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(g gVar) {
        if (v.u(gVar.brl()) > 0) {
            this.cDl = gVar;
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.b.8
                @Override // java.lang.Runnable
                public void run() {
                    b.this.aS(b.this.cDl.brl());
                }
            });
        } else if (this.bbI != null) {
            this.cuB.removeView(this.bbI);
            this.bbI = null;
            this.cDm = null;
            if (this.cDi != null && this.cDi.getParent() != null) {
                ((ViewGroup) this.cDi.getParent()).removeView(this.cDi);
            }
            k(null);
        }
    }

    private boolean aku() {
        FragmentManager supportFragmentManager = this.cDf.getSupportFragmentManager();
        try {
            supportFragmentManager.beginTransaction().remove(this.cDg).commitAllowingStateLoss();
            supportFragmentManager.executePendingTransactions();
            return true;
        } catch (IllegalStateException e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aS(List<FrsTabInfo> list) {
        if (this.bbI == null && aku()) {
            aT(list);
        }
    }

    private void aT(List<FrsTabInfo> list) {
        if (!v.v(list)) {
            CustomMessageListener customMessageListener = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB) { // from class: com.baidu.tieba.frs.gametab.b.9
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ad)) {
                        b.this.akw();
                    }
                }
            };
            customMessageListener.setPriority(Integer.MAX_VALUE);
            this.cDf.registerListener(customMessageListener);
            List arrayList = new ArrayList(list);
            FrsTabInfo.Builder builder = new FrsTabInfo.Builder();
            builder.tab_id = 99;
            builder.tab_name = this.cDf.getResources().getString(d.l.send);
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
            this.cDm = new ad(this.cDf.getActivity(), arrayList);
            if (agB() != null) {
                this.cDm.setForumId(agB().getForumId());
                this.cDm.setForumName(agB().getForumName());
                if (agB().ahq() != null && agB().ahq().aPg() != null) {
                    this.cDm.setForumGameLabel(agB().ahq().aPg().getForumGameLabel());
                }
            }
            new c(this.cDg).a(this.cDm);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB, this.cDm));
        }
    }

    private void akv() {
        int akC = akC();
        if (akC >= 0) {
            a(this.cDg, akC);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akw() {
        if (this.cDm != null) {
            this.cDm.aih();
            if (!v.v(this.cDm.aii())) {
                akv();
                if (this.bbI == null) {
                    this.bbI = new FragmentTabHost(this.cDf.getActivity());
                    this.bbI.setClipChildren(false);
                    this.bbI.setClipToPadding(false);
                    this.bbI.setup(this.cDf.getSupportFragmentManager());
                    this.bbI.setShouldDrawIndicatorLine(false);
                    this.bbI.setShouldDrawTopLine(true);
                    this.bbI.f(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds10), 0, 0);
                    this.bbI.aB(true);
                    this.bbI.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    this.cuB = new FrameLayout(this.cDf.getActivity());
                    this.cuB.setClipChildren(false);
                    this.cuB.setClipToPadding(false);
                    this.cuB.addView(this.bbI);
                    this.cDf.setContentView(this.cuB);
                    this.bbI.setOnTabSelectionListener(new FragmentTabHost.b() { // from class: com.baidu.tieba.frs.gametab.b.10
                        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
                        public void e(int i, boolean z) {
                            b.this.a(b.this.bbI.getCurrentFragment(), i);
                        }

                        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
                        public boolean f(int i, boolean z) {
                            String str = null;
                            FragmentTabHost.c cD = b.this.bbI.cD(i);
                            if (b.this.cDl != null && b.this.cDl.aPg() != null) {
                                str = b.this.cDl.aPg().getId();
                            }
                            if (cD.mType != 99) {
                                TiebaStatic.log(new ak("c12334").r("obj_locate", b.this.b(cD)).ad("fid", str));
                                return true;
                            }
                            b.this.aky();
                            TiebaStatic.log(new ak("c12342").r("obj_locate", b.this.b(b.this.bbI.cD(b.this.bbI.getCurrentTabIndex()))).ad("fid", str));
                            TiebaStatic.log(new ak("c12334").r("obj_locate", b.this.b(cD)).ad("fid", str));
                            return false;
                        }
                    });
                } else {
                    this.bbI.reset();
                }
                List<com.baidu.tbadk.mainTab.b> aii = this.cDm.aii();
                List<FrsTabInfo> aig = this.cDm.aig();
                if (aig.size() == aii.size()) {
                    int size = aig.size();
                    for (int i = 0; i < size; i++) {
                        com.baidu.tbadk.mainTab.b bVar = aii.get(i);
                        if (bVar != null) {
                            FrsTabInfo frsTabInfo = aig.get(i);
                            if (frsTabInfo == null || TextUtils.isEmpty(frsTabInfo.tab_name)) {
                                a(bVar, bVar.EV(), bVar.aZ(this.cDf.getActivity()), null);
                            } else {
                                a(bVar, bVar.EV(), bVar.aZ(this.cDf.getActivity()), frsTabInfo.tab_name);
                            }
                        }
                    }
                } else {
                    for (com.baidu.tbadk.mainTab.b bVar2 : aii) {
                        a(bVar2, bVar2.EV(), bVar2.aZ(this.cDf.getActivity()), null);
                    }
                }
                this.bbI.uz();
                this.bbI.cB(1);
                this.bbI.aA(true);
                this.bbI.setViewPagerScrollable(false);
                int akC = akC();
                if (akC >= 0) {
                    this.bbI.setCurrentTab(akC);
                } else {
                    this.bbI.setCurrentTab(0);
                }
                akx();
                this.cDq.setSelfListener(true);
                this.cDf.registerListener(this.cDq);
                this.cDr.setSelfListener(true);
                this.cDf.registerListener(this.cDr);
                this.bbI.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    private void akx() {
        if (this.bbI != null && this.bbI.cE(99) != null) {
            if (this.cDi == null || this.cDi.getParent() == null) {
                if (this.cDi == null) {
                    this.cDi = new ImageView(this.cDf.getActivity());
                }
                int f = k.f(this.cDf.getActivity(), d.f.ds80);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(f, f);
                layoutParams.gravity = 81;
                layoutParams.bottomMargin = k.f(this.cDf.getActivity(), d.f.ds5);
                this.cDi.setLayoutParams(layoutParams);
                aj.c(this.cDi, d.g.icon_tabbar_add_n);
                aj.j(this.cDi, d.g.icon_tabbar_chaticon_n);
                this.cDi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.b.11
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        String str = null;
                        b.this.aky();
                        if (b.this.bbI != null) {
                            if (b.this.cDl != null && b.this.cDl.aPg() != null) {
                                str = b.this.cDl.aPg().getId();
                            }
                            TiebaStatic.log(new ak("c12342").r("obj_locate", b.this.b(b.this.bbI.cD(b.this.bbI.getCurrentTabIndex()))).ad("fid", str));
                            TiebaStatic.log(new ak("c12334").r("obj_locate", 99).ad("fid", str));
                        }
                    }
                });
                if (this.cDi.getParent() == null) {
                    this.cuB.addView(this.cDi);
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
        NavigationBar ahp;
        if ((fragment instanceof com.baidu.tieba.frs.aj) && this.cDl != null && this.cDl.aPg() != null && (ahp = ((com.baidu.tieba.frs.aj) fragment).ahp()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.cDl.aPg().getName(), 5, true, true) + this.cDf.getActivity().getString(d.l.forum));
            FrsTabInfo frsTabInfo = (FrsTabInfo) v.c(this.cDm.aig(), i);
            if (frsTabInfo != null) {
                sb.append(" · ");
                sb.append(frsTabInfo.tab_name);
            }
            ahp.setCenterTextTitle(sb.toString());
        }
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, e eVar, String str) {
        if (cVar != null) {
            FragmentTabHost.c cVar2 = new FragmentTabHost.c();
            cVar2.aeH = cVar.aGU;
            if (cVar2.aeH.getArguments() == null) {
                Bundle bundle = new Bundle();
                bundle.putString("name", this.cDl.aPg().getName());
                bundle.putString("from", "game_frs");
                bundle.putString("fid", this.cDl.aPg().getId());
                cVar2.aeH.setArguments(bundle);
            } else {
                cVar2.aeH.getArguments().putString("fid", this.cDl.aPg().getId());
            }
            cVar2.mType = cVar.type;
            if (cVar.aHc == com.baidu.tbadk.mainTab.c.aGZ && cVar.type == 99) {
                eVar.K(9, -((int) this.cDf.getResources().getDimension(d.f.ds12)));
            } else if (!TextUtils.isEmpty(str)) {
                eVar.setText(str);
            } else {
                eVar.setText(cVar.aGV);
            }
            eVar.setTextSize(0, this.cDf.getResources().getDimension(d.f.ds30));
            eVar.setTextColorResId(d.e.s_game_frs_tabbar_text_color);
            eVar.setCompoundDrawablesTopResId(cVar.aGW);
            eVar.setContentTvTopMargin(this.cDf.getResources().getDimensionPixelSize(d.f.ds2));
            eVar.du(TbadkCoreApplication.getInst().getSkinType());
            eVar.setTipPosType(1);
            eVar.setIsContentSelectBold(true);
            cVar2.aeG = eVar;
            cVar2.aeI = bVar;
            this.bbI.a(cVar2);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.cDg instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.cDg.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a fJ(int i) {
        if (this.cDg instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.cDg.fJ(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.cDg instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.cDg.a(bVar);
        }
    }

    public void onNewIntent(Intent intent) {
        if (this.cDg != null) {
            this.cDg.onNewIntent(intent);
        }
    }

    public void onResume() {
        if (this.bbI == null) {
            this.cDg.setPrimary(true);
            return;
        }
        Fragment currentFragment = this.bbI.getCurrentFragment();
        if (currentFragment instanceof BaseFragment) {
            ((BaseFragment) currentFragment).setPrimary(true);
        }
    }

    public void onPause() {
        if (this.bbI == null) {
            this.cDg.setPrimary(false);
            return;
        }
        Fragment currentFragment = this.bbI.getCurrentFragment();
        if (currentFragment instanceof BaseFragment) {
            ((BaseFragment) currentFragment).setPrimary(false);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bbI == null) {
            this.cDg.onChangeSkinType(i);
        } else {
            this.bbI.aA(true);
            this.bbI.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.cDi != null) {
            aj.c(this.cDi, d.g.icon_tabbar_add_n);
            aj.j(this.cDi, d.g.icon_tabbar_chaticon_n);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.bbI != null && this.cDh != null && this.cDh.isShowing()) {
                this.cDh.bxD();
            } else if (this.cDg != null && this.cDg.isAdded()) {
                if (this.cDg.onKeyDown(i, keyEvent)) {
                    return true;
                }
                this.cDg.closeActivity();
            } else {
                return this.cDf.a(i, keyEvent);
            }
            return false;
        }
        return this.cDf.a(i, keyEvent);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.bbI == null) {
            this.cDg.onActivityResult(i, i2, intent);
        } else {
            this.bbI.getCurrentFragment().onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.bbI == null) {
            return this.cDg.getVoiceManager();
        }
        Fragment currentFragment = this.bbI.getCurrentFragment();
        if (currentFragment instanceof VoiceManager.c) {
            return ((VoiceManager.c) currentFragment).getVoiceManager();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void aky() {
        if (!akz()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE));
            if (this.cDh == null) {
                this.cDh = new com.baidu.tieba.write.b(this.cDf.getPageContext(), this.cuB);
                this.cDh.sT("1");
            }
            this.cDh.a(this.cDg.ahv());
            this.cDh.ni(false);
        }
    }

    public boolean akz() {
        String fixedText;
        if (this.cDg == null || !this.cDg.isAdded() || this.cDg.getPageContext() == null) {
            return false;
        }
        i ahq = this.cDg.ahq();
        if (ahq == null) {
            return false;
        }
        if (ax.aU(this.cDg.getPageContext().getPageActivity())) {
            AntiData qn = ahq.qn();
            if (qn != null) {
                if (a(qn.getBlock_stat(), qn.mFrsForbidenDialogInfo)) {
                    return true;
                }
                if (qn.getIfpost() == 0 && !StringUtils.isNull(qn.getForbid_info())) {
                    String forbid_info = qn.getForbid_info();
                    if (am.dV(forbid_info) > 14) {
                        forbid_info = am.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                    }
                    BdToast b = BdToast.b(this.cDg.getPageContext().getPageActivity(), forbid_info, d.g.icon_toast_game_error);
                    b.E(1.25f);
                    b.tw();
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.cDg.getResources().getString(d.l.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast b = BdToast.b(this.cDg.getPageContext().getPageActivity(), string, d.g.icon_toast_game_error);
            b.E(1.25f);
            b.tw();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cDg.getPageContext().getPageActivity());
        aVar.cM(am.getFixedText(string, 50, true));
        aVar.b(am.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.cDg.getResources().getString(d.l.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.gametab.b.12
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
                    au.wd().c(b.this.cDg.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.cDg.getPageContext()).to();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akA() {
        if (this.bbI != null) {
            final FrameLayout tabWrapper = this.bbI.getTabWrapper();
            if (tabWrapper.getVisibility() != 0) {
                if (this.cDj == null) {
                    this.cDj = AnimationUtils.loadAnimation(this.cDf.getActivity(), d.a.translate_in);
                    this.cDj.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.gametab.b.3
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
                tabWrapper.startAnimation(this.cDj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akB() {
        if (this.bbI != null) {
            final FrameLayout tabWrapper = this.bbI.getTabWrapper();
            if (tabWrapper.getVisibility() == 0) {
                if (this.cDk == null) {
                    this.cDk = AnimationUtils.loadAnimation(this.cDf.getActivity(), d.a.translate_out);
                    this.cDk.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.gametab.b.4
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
                tabWrapper.startAnimation(this.cDk);
            }
        }
    }

    private int akC() {
        if (this.cDm == null) {
            return -1;
        }
        int u = v.u(this.cDm.aig());
        for (int i = 0; i < u; i++) {
            if (this.cDm.aig().get(i).tab_id.intValue() == 1) {
                return i;
            }
        }
        return -1;
    }

    public f agB() {
        return this.cDg;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> agC() {
        if (this.bbI == null) {
            if (this.cDg instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) this.cDg).agC();
            }
        } else {
            Fragment currentFragment = this.bbI.getCurrentFragment();
            if (currentFragment instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) currentFragment).agC();
            }
        }
        return null;
    }
}
