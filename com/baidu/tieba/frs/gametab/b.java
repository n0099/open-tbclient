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
    private FragmentTabHost bdu;
    private FrsActivity cDY;
    private f cDZ;
    private com.baidu.tieba.write.b cEa;
    private ImageView cEb;
    private Animation cEc;
    private Animation cEd;
    private g cEe;
    private ae cEf;
    private FrameLayout cvf;
    private String mForumName;
    private boolean cEg = false;
    private Handler mHandler = new Handler();
    private com.baidu.adp.framework.listener.a cEh = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FRS_HTTP_CMD, 301001) { // from class: com.baidu.tieba.frs.gametab.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            g gVar = null;
            if (!b.this.cEg && !responsedMessage.hasError()) {
                if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                    gVar = ((FrsPageHttpResponseMessage) responsedMessage).getResponseData();
                } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                    gVar = ((FRSPageSocketResponsedMessage) responsedMessage).getResponseData();
                }
                if (gVar != null) {
                    b.this.cEg = true;
                    b.this.c(gVar);
                }
            }
        }
    };
    private CustomMessageListener cEi = new CustomMessageListener(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE) { // from class: com.baidu.tieba.frs.gametab.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!b.this.cEg && customResponsedMessage != null && (customResponsedMessage.getData() instanceof g)) {
                g gVar = (g) customResponsedMessage.getData();
                if (gVar.aMZ() != null && b.this.mForumName != null && b.this.mForumName.equals(gVar.aMZ().getName())) {
                    b.this.c(gVar);
                }
            }
        }
    };
    private CustomMessageListener cEj = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_SHOW_TAB) { // from class: com.baidu.tieba.frs.gametab.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof Boolean) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    b.this.akE();
                } else if (b.this.bdu != null) {
                    b.this.bdu.getTabWrapper().setVisibility(0);
                }
            }
        }
    };
    private CustomMessageListener cEk = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_HIDE_TAB) { // from class: com.baidu.tieba.frs.gametab.b.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof Boolean) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    b.this.akF();
                } else if (b.this.bdu != null) {
                    b.this.bdu.getTabWrapper().setVisibility(8);
                }
            }
        }
    };

    public b(FrsActivity frsActivity) {
        this.cDY = frsActivity;
    }

    public void init(Bundle bundle) {
        this.cEh.getHttpMessageListener().setPriority(-1);
        this.cEh.getSocketMessageListener().setPriority(-1);
        this.cDY.registerListener(this.cEh);
        this.cDY.registerListener(this.cEi);
        if (bundle == null) {
            this.mForumName = this.cDY.getIntent().getStringExtra("name");
        } else {
            this.mForumName = bundle.getString("name");
        }
        k(bundle);
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.mForumName);
    }

    private void k(Bundle bundle) {
        if (this.cDZ == null) {
            this.cDZ = new f();
            this.cDZ.setArguments(bundle);
        }
        FragmentTransaction beginTransaction = this.cDY.getSupportFragmentManager().beginTransaction();
        beginTransaction.add(16908290, this.cDZ);
        beginTransaction.commitAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(g gVar) {
        if (v.t(gVar.bqh()) > 0) {
            this.cEe = gVar;
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.b.8
                @Override // java.lang.Runnable
                public void run() {
                    b.this.aS(b.this.cEe.bqh());
                }
            });
        } else if (this.bdu != null) {
            this.cvf.removeView(this.bdu);
            this.bdu = null;
            this.cEf = null;
            if (this.cEb != null && this.cEb.getParent() != null) {
                ((ViewGroup) this.cEb.getParent()).removeView(this.cEb);
            }
            k(null);
        }
    }

    private boolean aky() {
        FragmentManager supportFragmentManager = this.cDY.getSupportFragmentManager();
        try {
            supportFragmentManager.beginTransaction().remove(this.cDZ).commitAllowingStateLoss();
            supportFragmentManager.executePendingTransactions();
            return true;
        } catch (IllegalStateException e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aS(List<FrsTabInfo> list) {
        if (this.bdu == null && aky()) {
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
                        b.this.akA();
                    }
                }
            };
            customMessageListener.setPriority(Integer.MAX_VALUE);
            this.cDY.registerListener(customMessageListener);
            List arrayList = new ArrayList(list);
            FrsTabInfo.Builder builder = new FrsTabInfo.Builder();
            builder.tab_id = 99;
            builder.tab_name = this.cDY.getResources().getString(d.l.send);
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
            this.cEf = new ae(this.cDY.getActivity(), arrayList);
            if (agy() != null) {
                this.cEf.setForumId(agy().getForumId());
                this.cEf.setForumName(agy().getForumName());
                if (agy().ahk() != null && agy().ahk().aMZ() != null) {
                    this.cEf.setForumGameLabel(agy().ahk().aMZ().getForumGameLabel());
                }
            }
            new c(this.cDZ).a(this.cEf);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB, this.cEf));
        }
    }

    private void akz() {
        int akG = akG();
        if (akG >= 0) {
            a(this.cDZ, akG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akA() {
        if (this.cEf != null) {
            this.cEf.aif();
            if (!v.u(this.cEf.aig())) {
                akz();
                if (this.bdu == null) {
                    this.bdu = new FragmentTabHost(this.cDY.getActivity());
                    this.bdu.setClipChildren(false);
                    this.bdu.setClipToPadding(false);
                    this.bdu.setup(this.cDY.getSupportFragmentManager());
                    this.bdu.setShouldDrawIndicatorLine(false);
                    this.bdu.setShouldDrawTopLine(true);
                    this.bdu.f(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds10), 0, 0);
                    this.bdu.aB(true);
                    this.bdu.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    this.cvf = new FrameLayout(this.cDY.getActivity());
                    this.cvf.setClipChildren(false);
                    this.cvf.setClipToPadding(false);
                    this.cvf.addView(this.bdu);
                    this.cDY.setContentView(this.cvf);
                    this.bdu.setOnTabSelectionListener(new FragmentTabHost.b() { // from class: com.baidu.tieba.frs.gametab.b.10
                        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
                        public void e(int i, boolean z) {
                            b.this.a(b.this.bdu.getCurrentFragment(), i);
                        }

                        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
                        public boolean f(int i, boolean z) {
                            String str = null;
                            FragmentTabHost.c cB = b.this.bdu.cB(i);
                            if (b.this.cEe != null && b.this.cEe.aMZ() != null) {
                                str = b.this.cEe.aMZ().getId();
                            }
                            if (cB.mType != 99) {
                                TiebaStatic.log(new ak("c12334").r("obj_locate", b.this.b(cB)).ad("fid", str));
                                return true;
                            }
                            b.this.akC();
                            TiebaStatic.log(new ak("c12342").r("obj_locate", b.this.b(b.this.bdu.cB(b.this.bdu.getCurrentTabIndex()))).ad("fid", str));
                            TiebaStatic.log(new ak("c12334").r("obj_locate", b.this.b(cB)).ad("fid", str));
                            return false;
                        }
                    });
                } else {
                    this.bdu.reset();
                }
                List<com.baidu.tbadk.mainTab.b> aig = this.cEf.aig();
                List<FrsTabInfo> aie = this.cEf.aie();
                if (aie.size() == aig.size()) {
                    int size = aie.size();
                    for (int i = 0; i < size; i++) {
                        com.baidu.tbadk.mainTab.b bVar = aig.get(i);
                        if (bVar != null) {
                            FrsTabInfo frsTabInfo = aie.get(i);
                            if (frsTabInfo == null || TextUtils.isEmpty(frsTabInfo.tab_name)) {
                                a(bVar, bVar.EA(), bVar.aZ(this.cDY.getActivity()), null);
                            } else {
                                a(bVar, bVar.EA(), bVar.aZ(this.cDY.getActivity()), frsTabInfo.tab_name);
                            }
                        }
                    }
                } else {
                    for (com.baidu.tbadk.mainTab.b bVar2 : aig) {
                        a(bVar2, bVar2.EA(), bVar2.aZ(this.cDY.getActivity()), null);
                    }
                }
                this.bdu.uc();
                this.bdu.cz(1);
                this.bdu.aA(true);
                this.bdu.setViewPagerScrollable(false);
                int akG = akG();
                if (akG >= 0) {
                    this.bdu.setCurrentTab(akG);
                } else {
                    this.bdu.setCurrentTab(0);
                }
                akB();
                this.cEj.setSelfListener(true);
                this.cDY.registerListener(this.cEj);
                this.cEk.setSelfListener(true);
                this.cDY.registerListener(this.cEk);
                this.bdu.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    private void akB() {
        if (this.bdu != null && this.bdu.cC(99) != null) {
            if (this.cEb == null || this.cEb.getParent() == null) {
                if (this.cEb == null) {
                    this.cEb = new ImageView(this.cDY.getActivity());
                }
                int f = l.f(this.cDY.getActivity(), d.f.ds80);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(f, f);
                layoutParams.gravity = 81;
                layoutParams.bottomMargin = l.f(this.cDY.getActivity(), d.f.ds5);
                this.cEb.setLayoutParams(layoutParams);
                aj.c(this.cEb, d.g.icon_tabbar_add_n);
                aj.j(this.cEb, d.g.icon_tabbar_chaticon_n);
                this.cEb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.b.11
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        String str = null;
                        b.this.akC();
                        if (b.this.bdu != null) {
                            if (b.this.cEe != null && b.this.cEe.aMZ() != null) {
                                str = b.this.cEe.aMZ().getId();
                            }
                            TiebaStatic.log(new ak("c12342").r("obj_locate", b.this.b(b.this.bdu.cB(b.this.bdu.getCurrentTabIndex()))).ad("fid", str));
                            TiebaStatic.log(new ak("c12334").r("obj_locate", 99).ad("fid", str));
                        }
                    }
                });
                if (this.cEb.getParent() == null) {
                    this.cvf.addView(this.cEb);
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
        NavigationBar ahj;
        if ((fragment instanceof com.baidu.tieba.frs.ak) && this.cEe != null && this.cEe.aMZ() != null && (ahj = ((com.baidu.tieba.frs.ak) fragment).ahj()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.cEe.aMZ().getName(), 5, true, true) + this.cDY.getActivity().getString(d.l.forum));
            FrsTabInfo frsTabInfo = (FrsTabInfo) v.c(this.cEf.aie(), i);
            if (frsTabInfo != null) {
                sb.append(" · ");
                sb.append(frsTabInfo.tab_name);
            }
            ahj.setCenterTextTitle(sb.toString());
        }
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, e eVar, String str) {
        if (cVar != null) {
            FragmentTabHost.c cVar2 = new FragmentTabHost.c();
            cVar2.aee = cVar.aGv;
            if (cVar2.aee.getArguments() == null) {
                Bundle bundle = new Bundle();
                bundle.putString("name", this.cEe.aMZ().getName());
                bundle.putString("from", "game_frs");
                bundle.putString("fid", this.cEe.aMZ().getId());
                cVar2.aee.setArguments(bundle);
            } else {
                cVar2.aee.getArguments().putString("fid", this.cEe.aMZ().getId());
            }
            cVar2.mType = cVar.type;
            if (cVar.aGD == com.baidu.tbadk.mainTab.c.aGA && cVar.type == 99) {
                eVar.L(9, -((int) this.cDY.getResources().getDimension(d.f.ds12)));
            } else if (!TextUtils.isEmpty(str)) {
                eVar.setText(str);
            } else {
                eVar.setText(cVar.aGw);
            }
            eVar.setTextSize(0, this.cDY.getResources().getDimension(d.f.ds30));
            eVar.setTextColorResId(d.e.s_game_frs_tabbar_text_color);
            eVar.setCompoundDrawablesTopResId(cVar.aGx);
            eVar.setContentTvTopMargin(this.cDY.getResources().getDimensionPixelSize(d.f.ds2));
            eVar.dE(TbadkCoreApplication.getInst().getSkinType());
            eVar.setTipPosType(1);
            eVar.setIsContentSelectBold(true);
            cVar2.aed = eVar;
            cVar2.aef = bVar;
            this.bdu.a(cVar2);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.cDZ instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.cDZ.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a fW(int i) {
        if (this.cDZ instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.cDZ.fW(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.cDZ instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.cDZ.a(bVar);
        }
    }

    public void onNewIntent(Intent intent) {
        if (this.cDZ != null) {
            this.cDZ.onNewIntent(intent);
        }
    }

    public void onResume() {
        if (this.bdu == null) {
            this.cDZ.setPrimary(true);
            return;
        }
        Fragment currentFragment = this.bdu.getCurrentFragment();
        if (currentFragment instanceof BaseFragment) {
            ((BaseFragment) currentFragment).setPrimary(true);
        }
    }

    public void onPause() {
        if (this.bdu == null) {
            this.cDZ.setPrimary(false);
            return;
        }
        Fragment currentFragment = this.bdu.getCurrentFragment();
        if (currentFragment instanceof BaseFragment) {
            ((BaseFragment) currentFragment).setPrimary(false);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bdu == null) {
            this.cDZ.onChangeSkinType(i);
        } else {
            this.bdu.aA(true);
            this.bdu.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.cEb != null) {
            aj.c(this.cEb, d.g.icon_tabbar_add_n);
            aj.j(this.cEb, d.g.icon_tabbar_chaticon_n);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.bdu != null && this.cEa != null && this.cEa.isShowing()) {
                this.cEa.byS();
            } else if (this.cDZ != null && this.cDZ.isAdded()) {
                if (this.cDZ.onKeyDown(i, keyEvent)) {
                    return true;
                }
                this.cDZ.closeActivity();
            } else {
                return this.cDY.a(i, keyEvent);
            }
            return false;
        }
        return this.cDY.a(i, keyEvent);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.bdu == null) {
            this.cDZ.onActivityResult(i, i2, intent);
        } else {
            this.bdu.getCurrentFragment().onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.bdu == null) {
            return this.cDZ.getVoiceManager();
        }
        Fragment currentFragment = this.bdu.getCurrentFragment();
        if (currentFragment instanceof VoiceManager.c) {
            return ((VoiceManager.c) currentFragment).getVoiceManager();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void akC() {
        if (!akD()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE));
            if (this.cEa == null) {
                this.cEa = new com.baidu.tieba.write.b(this.cDY.getPageContext(), this.cvf, "frs");
                this.cEa.sX("1");
            }
            this.cEa.a(this.cDZ.aho());
            this.cEa.nn(false);
        }
    }

    public boolean akD() {
        String fixedText;
        if (this.cDZ == null || !this.cDZ.isAdded() || this.cDZ.getPageContext() == null) {
            return false;
        }
        i ahk = this.cDZ.ahk();
        if (ahk == null) {
            return false;
        }
        if (ax.aU(this.cDZ.getPageContext().getPageActivity())) {
            AntiData qh = ahk.qh();
            if (qh != null) {
                if (a(qh.getBlock_stat(), qh.mFrsForbidenDialogInfo)) {
                    return true;
                }
                if (qh.getIfpost() == 0 && !StringUtils.isNull(qh.getForbid_info())) {
                    String forbid_info = qh.getForbid_info();
                    if (am.dO(forbid_info) > 14) {
                        forbid_info = am.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                    }
                    BdToast b = BdToast.b(this.cDZ.getPageContext().getPageActivity(), forbid_info, d.g.icon_toast_game_error);
                    b.F(1.25f);
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.cDZ.getResources().getString(d.l.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast b = BdToast.b(this.cDZ.getPageContext().getPageActivity(), string, d.g.icon_toast_game_error);
            b.F(1.25f);
            b.tq();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cDZ.getPageContext().getPageActivity());
        aVar.cM(am.getFixedText(string, 50, true));
        aVar.b(am.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.cDZ.getResources().getString(d.l.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.gametab.b.12
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
                    av.vH().c(b.this.cDZ.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.cDZ.getPageContext()).ti();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akE() {
        if (this.bdu != null) {
            final FrameLayout tabWrapper = this.bdu.getTabWrapper();
            if (tabWrapper.getVisibility() != 0) {
                if (this.cEc == null) {
                    this.cEc = AnimationUtils.loadAnimation(this.cDY.getActivity(), d.a.translate_in);
                    this.cEc.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.gametab.b.3
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
                tabWrapper.startAnimation(this.cEc);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akF() {
        if (this.bdu != null) {
            final FrameLayout tabWrapper = this.bdu.getTabWrapper();
            if (tabWrapper.getVisibility() == 0) {
                if (this.cEd == null) {
                    this.cEd = AnimationUtils.loadAnimation(this.cDY.getActivity(), d.a.translate_out);
                    this.cEd.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.gametab.b.4
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
                tabWrapper.startAnimation(this.cEd);
            }
        }
    }

    private int akG() {
        if (this.cEf == null) {
            return -1;
        }
        int t = v.t(this.cEf.aie());
        for (int i = 0; i < t; i++) {
            if (this.cEf.aie().get(i).tab_id.intValue() == 1) {
                return i;
            }
        }
        return -1;
    }

    public f agy() {
        return this.cDZ;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> agz() {
        if (this.bdu == null) {
            if (this.cDZ instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) this.cDZ).agz();
            }
        } else {
            Fragment currentFragment = this.bdu.getCurrentFragment();
            if (currentFragment instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) currentFragment).agz();
            }
        }
        return null;
    }
}
