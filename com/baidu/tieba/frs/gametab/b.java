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
    private FragmentTabHost bbL;
    private FrsActivity cCn;
    private f cCo;
    private com.baidu.tieba.write.b cCp;
    private ImageView cCq;
    private Animation cCr;
    private Animation cCs;
    private g cCt;
    private ad cCu;
    private FrameLayout ctJ;
    private String mForumName;
    private boolean cCv = false;
    private Handler mHandler = new Handler();
    private com.baidu.adp.framework.listener.a cCw = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FRS_HTTP_CMD, 301001) { // from class: com.baidu.tieba.frs.gametab.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            g gVar = null;
            if (!b.this.cCv && !responsedMessage.hasError()) {
                if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                    gVar = ((FrsPageHttpResponseMessage) responsedMessage).getResponseData();
                } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                    gVar = ((FRSPageSocketResponsedMessage) responsedMessage).getResponseData();
                }
                if (gVar != null) {
                    b.this.cCv = true;
                    b.this.c(gVar);
                }
            }
        }
    };
    private CustomMessageListener cCx = new CustomMessageListener(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE) { // from class: com.baidu.tieba.frs.gametab.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!b.this.cCv && customResponsedMessage != null && (customResponsedMessage.getData() instanceof g)) {
                g gVar = (g) customResponsedMessage.getData();
                if (gVar.aOV() != null && b.this.mForumName != null && b.this.mForumName.equals(gVar.aOV().getName())) {
                    b.this.c(gVar);
                }
            }
        }
    };
    private CustomMessageListener cCy = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_SHOW_TAB) { // from class: com.baidu.tieba.frs.gametab.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof Boolean) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    b.this.akp();
                } else if (b.this.bbL != null) {
                    b.this.bbL.getTabWrapper().setVisibility(0);
                }
            }
        }
    };
    private CustomMessageListener cCz = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_HIDE_TAB) { // from class: com.baidu.tieba.frs.gametab.b.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof Boolean) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    b.this.akq();
                } else if (b.this.bbL != null) {
                    b.this.bbL.getTabWrapper().setVisibility(8);
                }
            }
        }
    };

    public b(FrsActivity frsActivity) {
        this.cCn = frsActivity;
    }

    public void init(Bundle bundle) {
        this.cCw.getHttpMessageListener().setPriority(-1);
        this.cCw.getSocketMessageListener().setPriority(-1);
        this.cCn.registerListener(this.cCw);
        this.cCn.registerListener(this.cCx);
        if (bundle == null) {
            this.mForumName = this.cCn.getIntent().getStringExtra("name");
        } else {
            this.mForumName = bundle.getString("name");
        }
        k(bundle);
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.mForumName);
    }

    private void k(Bundle bundle) {
        if (this.cCo == null) {
            this.cCo = new f();
            this.cCo.setArguments(bundle);
        }
        FragmentTransaction beginTransaction = this.cCn.getSupportFragmentManager().beginTransaction();
        beginTransaction.add(16908290, this.cCo);
        beginTransaction.commitAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(g gVar) {
        if (v.u(gVar.bra()) > 0) {
            this.cCt = gVar;
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.b.8
                @Override // java.lang.Runnable
                public void run() {
                    b.this.aS(b.this.cCt.bra());
                }
            });
        } else if (this.bbL != null) {
            this.ctJ.removeView(this.bbL);
            this.bbL = null;
            this.cCu = null;
            if (this.cCq != null && this.cCq.getParent() != null) {
                ((ViewGroup) this.cCq.getParent()).removeView(this.cCq);
            }
            k(null);
        }
    }

    private boolean akj() {
        FragmentManager supportFragmentManager = this.cCn.getSupportFragmentManager();
        try {
            supportFragmentManager.beginTransaction().remove(this.cCo).commitAllowingStateLoss();
            supportFragmentManager.executePendingTransactions();
            return true;
        } catch (IllegalStateException e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aS(List<FrsTabInfo> list) {
        if (this.bbL == null && akj()) {
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
                        b.this.akl();
                    }
                }
            };
            customMessageListener.setPriority(Integer.MAX_VALUE);
            this.cCn.registerListener(customMessageListener);
            List arrayList = new ArrayList(list);
            FrsTabInfo.Builder builder = new FrsTabInfo.Builder();
            builder.tab_id = 99;
            builder.tab_name = this.cCn.getResources().getString(d.l.send);
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
            this.cCu = new ad(this.cCn.getActivity(), arrayList);
            if (agq() != null) {
                this.cCu.setForumId(agq().getForumId());
                this.cCu.setForumName(agq().getForumName());
                if (agq().ahf() != null && agq().ahf().aOV() != null) {
                    this.cCu.setForumGameLabel(agq().ahf().aOV().getForumGameLabel());
                }
            }
            new c(this.cCo).a(this.cCu);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB, this.cCu));
        }
    }

    private void akk() {
        int akr = akr();
        if (akr >= 0) {
            a(this.cCo, akr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akl() {
        if (this.cCu != null) {
            this.cCu.ahW();
            if (!v.v(this.cCu.ahX())) {
                akk();
                if (this.bbL == null) {
                    this.bbL = new FragmentTabHost(this.cCn.getActivity());
                    this.bbL.setClipChildren(false);
                    this.bbL.setClipToPadding(false);
                    this.bbL.setup(this.cCn.getSupportFragmentManager());
                    this.bbL.setShouldDrawIndicatorLine(false);
                    this.bbL.setShouldDrawTopLine(true);
                    this.bbL.f(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds10), 0, 0);
                    this.bbL.aB(true);
                    this.bbL.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    this.ctJ = new FrameLayout(this.cCn.getActivity());
                    this.ctJ.setClipChildren(false);
                    this.ctJ.setClipToPadding(false);
                    this.ctJ.addView(this.bbL);
                    this.cCn.setContentView(this.ctJ);
                    this.bbL.setOnTabSelectionListener(new FragmentTabHost.b() { // from class: com.baidu.tieba.frs.gametab.b.10
                        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
                        public void e(int i, boolean z) {
                            b.this.a(b.this.bbL.getCurrentFragment(), i);
                        }

                        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
                        public boolean f(int i, boolean z) {
                            String str = null;
                            FragmentTabHost.c cD = b.this.bbL.cD(i);
                            if (b.this.cCt != null && b.this.cCt.aOV() != null) {
                                str = b.this.cCt.aOV().getId();
                            }
                            if (cD.mType != 99) {
                                TiebaStatic.log(new ak("c12334").r("obj_locate", b.this.b(cD)).ad("fid", str));
                                return true;
                            }
                            b.this.akn();
                            TiebaStatic.log(new ak("c12342").r("obj_locate", b.this.b(b.this.bbL.cD(b.this.bbL.getCurrentTabIndex()))).ad("fid", str));
                            TiebaStatic.log(new ak("c12334").r("obj_locate", b.this.b(cD)).ad("fid", str));
                            return false;
                        }
                    });
                } else {
                    this.bbL.reset();
                }
                List<com.baidu.tbadk.mainTab.b> ahX = this.cCu.ahX();
                List<FrsTabInfo> ahV = this.cCu.ahV();
                if (ahV.size() == ahX.size()) {
                    int size = ahV.size();
                    for (int i = 0; i < size; i++) {
                        com.baidu.tbadk.mainTab.b bVar = ahX.get(i);
                        if (bVar != null) {
                            FrsTabInfo frsTabInfo = ahV.get(i);
                            if (frsTabInfo == null || TextUtils.isEmpty(frsTabInfo.tab_name)) {
                                a(bVar, bVar.EV(), bVar.aY(this.cCn.getActivity()), null);
                            } else {
                                a(bVar, bVar.EV(), bVar.aY(this.cCn.getActivity()), frsTabInfo.tab_name);
                            }
                        }
                    }
                } else {
                    for (com.baidu.tbadk.mainTab.b bVar2 : ahX) {
                        a(bVar2, bVar2.EV(), bVar2.aY(this.cCn.getActivity()), null);
                    }
                }
                this.bbL.uz();
                this.bbL.cB(1);
                this.bbL.aA(true);
                this.bbL.setViewPagerScrollable(false);
                int akr = akr();
                if (akr >= 0) {
                    this.bbL.setCurrentTab(akr);
                } else {
                    this.bbL.setCurrentTab(0);
                }
                akm();
                this.cCy.setSelfListener(true);
                this.cCn.registerListener(this.cCy);
                this.cCz.setSelfListener(true);
                this.cCn.registerListener(this.cCz);
                this.bbL.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    private void akm() {
        if (this.bbL != null && this.bbL.cE(99) != null) {
            if (this.cCq == null || this.cCq.getParent() == null) {
                if (this.cCq == null) {
                    this.cCq = new ImageView(this.cCn.getActivity());
                }
                int g = k.g(this.cCn.getActivity(), d.f.ds80);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(g, g);
                layoutParams.gravity = 81;
                layoutParams.bottomMargin = k.g(this.cCn.getActivity(), d.f.ds5);
                this.cCq.setLayoutParams(layoutParams);
                aj.c(this.cCq, d.g.icon_tabbar_add_n);
                aj.j(this.cCq, d.g.icon_tabbar_chaticon_n);
                this.cCq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.b.11
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        String str = null;
                        b.this.akn();
                        if (b.this.bbL != null) {
                            if (b.this.cCt != null && b.this.cCt.aOV() != null) {
                                str = b.this.cCt.aOV().getId();
                            }
                            TiebaStatic.log(new ak("c12342").r("obj_locate", b.this.b(b.this.bbL.cD(b.this.bbL.getCurrentTabIndex()))).ad("fid", str));
                            TiebaStatic.log(new ak("c12334").r("obj_locate", 99).ad("fid", str));
                        }
                    }
                });
                if (this.cCq.getParent() == null) {
                    this.ctJ.addView(this.cCq);
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
        if ((fragment instanceof com.baidu.tieba.frs.aj) && this.cCt != null && this.cCt.aOV() != null && (ahe = ((com.baidu.tieba.frs.aj) fragment).ahe()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.cCt.aOV().getName(), 5, true, true) + this.cCn.getActivity().getString(d.l.forum));
            FrsTabInfo frsTabInfo = (FrsTabInfo) v.c(this.cCu.ahV(), i);
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
            cVar2.aeH = cVar.aGX;
            if (cVar2.aeH.getArguments() == null) {
                Bundle bundle = new Bundle();
                bundle.putString("name", this.cCt.aOV().getName());
                bundle.putString("from", "game_frs");
                bundle.putString("fid", this.cCt.aOV().getId());
                cVar2.aeH.setArguments(bundle);
            } else {
                cVar2.aeH.getArguments().putString("fid", this.cCt.aOV().getId());
            }
            cVar2.mType = cVar.type;
            if (cVar.aHf == com.baidu.tbadk.mainTab.c.aHc && cVar.type == 99) {
                eVar.K(9, -((int) this.cCn.getResources().getDimension(d.f.ds12)));
            } else if (!TextUtils.isEmpty(str)) {
                eVar.setText(str);
            } else {
                eVar.setText(cVar.aGY);
            }
            eVar.setTextSize(0, this.cCn.getResources().getDimension(d.f.ds30));
            eVar.setTextColorResId(d.e.s_game_frs_tabbar_text_color);
            eVar.setCompoundDrawablesTopResId(cVar.aGZ);
            eVar.setContentTvTopMargin(this.cCn.getResources().getDimensionPixelSize(d.f.ds2));
            eVar.du(TbadkCoreApplication.getInst().getSkinType());
            eVar.setTipPosType(1);
            eVar.setIsContentSelectBold(true);
            cVar2.aeG = eVar;
            cVar2.aeI = bVar;
            this.bbL.a(cVar2);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.cCo instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.cCo.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a fJ(int i) {
        if (this.cCo instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.cCo.fJ(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.cCo instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.cCo.a(bVar);
        }
    }

    public void onNewIntent(Intent intent) {
        if (this.cCo != null) {
            this.cCo.onNewIntent(intent);
        }
    }

    public void onResume() {
        if (this.bbL == null) {
            this.cCo.setPrimary(true);
            return;
        }
        Fragment currentFragment = this.bbL.getCurrentFragment();
        if (currentFragment instanceof BaseFragment) {
            ((BaseFragment) currentFragment).setPrimary(true);
        }
    }

    public void onPause() {
        if (this.bbL == null) {
            this.cCo.setPrimary(false);
            return;
        }
        Fragment currentFragment = this.bbL.getCurrentFragment();
        if (currentFragment instanceof BaseFragment) {
            ((BaseFragment) currentFragment).setPrimary(false);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bbL == null) {
            this.cCo.onChangeSkinType(i);
        } else {
            this.bbL.aA(true);
            this.bbL.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.cCq != null) {
            aj.c(this.cCq, d.g.icon_tabbar_add_n);
            aj.j(this.cCq, d.g.icon_tabbar_chaticon_n);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.bbL != null && this.cCp != null && this.cCp.isShowing()) {
                this.cCp.bxs();
            } else if (this.cCo != null && this.cCo.isAdded()) {
                if (this.cCo.onKeyDown(i, keyEvent)) {
                    return true;
                }
                this.cCo.closeActivity();
            } else {
                return this.cCn.a(i, keyEvent);
            }
            return false;
        }
        return this.cCn.a(i, keyEvent);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.bbL == null) {
            this.cCo.onActivityResult(i, i2, intent);
        } else {
            this.bbL.getCurrentFragment().onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.bbL == null) {
            return this.cCo.getVoiceManager();
        }
        Fragment currentFragment = this.bbL.getCurrentFragment();
        if (currentFragment instanceof VoiceManager.c) {
            return ((VoiceManager.c) currentFragment).getVoiceManager();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void akn() {
        if (!ako()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE));
            if (this.cCp == null) {
                this.cCp = new com.baidu.tieba.write.b(this.cCn.getPageContext(), this.ctJ);
                this.cCp.sR("1");
            }
            this.cCp.a(this.cCo.ahk());
            this.cCp.nh(false);
        }
    }

    public boolean ako() {
        String fixedText;
        if (this.cCo == null || !this.cCo.isAdded() || this.cCo.getPageContext() == null) {
            return false;
        }
        i ahf = this.cCo.ahf();
        if (ahf == null) {
            return false;
        }
        if (ax.aT(this.cCo.getPageContext().getPageActivity())) {
            AntiData qn = ahf.qn();
            if (qn != null) {
                if (a(qn.getBlock_stat(), qn.mFrsForbidenDialogInfo)) {
                    return true;
                }
                if (qn.getIfpost() == 0 && !StringUtils.isNull(qn.getForbid_info())) {
                    String forbid_info = qn.getForbid_info();
                    if (am.dV(forbid_info) > 14) {
                        forbid_info = am.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                    }
                    BdToast b = BdToast.b(this.cCo.getPageContext().getPageActivity(), forbid_info, d.g.icon_toast_game_error);
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.cCo.getResources().getString(d.l.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast b = BdToast.b(this.cCo.getPageContext().getPageActivity(), string, d.g.icon_toast_game_error);
            b.E(1.25f);
            b.tw();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cCo.getPageContext().getPageActivity());
        aVar.cM(am.getFixedText(string, 50, true));
        aVar.b(am.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.cCo.getResources().getString(d.l.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.gametab.b.12
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
                    au.wd().c(b.this.cCo.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.cCo.getPageContext()).to();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akp() {
        if (this.bbL != null) {
            final FrameLayout tabWrapper = this.bbL.getTabWrapper();
            if (tabWrapper.getVisibility() != 0) {
                if (this.cCr == null) {
                    this.cCr = AnimationUtils.loadAnimation(this.cCn.getActivity(), d.a.translate_in);
                    this.cCr.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.gametab.b.3
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
                tabWrapper.startAnimation(this.cCr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akq() {
        if (this.bbL != null) {
            final FrameLayout tabWrapper = this.bbL.getTabWrapper();
            if (tabWrapper.getVisibility() == 0) {
                if (this.cCs == null) {
                    this.cCs = AnimationUtils.loadAnimation(this.cCn.getActivity(), d.a.translate_out);
                    this.cCs.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.gametab.b.4
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
                tabWrapper.startAnimation(this.cCs);
            }
        }
    }

    private int akr() {
        if (this.cCu == null) {
            return -1;
        }
        int u = v.u(this.cCu.ahV());
        for (int i = 0; i < u; i++) {
            if (this.cCu.ahV().get(i).tab_id.intValue() == 1) {
                return i;
            }
        }
        return -1;
    }

    public f agq() {
        return this.cCo;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> agr() {
        if (this.bbL == null) {
            if (this.cCo instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) this.cCo).agr();
            }
        } else {
            Fragment currentFragment = this.bbL.getCurrentFragment();
            if (currentFragment instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) currentFragment).agr();
            }
        }
        return null;
    }
}
