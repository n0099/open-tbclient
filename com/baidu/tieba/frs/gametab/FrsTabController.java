package com.baidu.tieba.frs.gametab;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.k;
import com.baidu.tbadk.widget.FRSRefreshButton;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.CubeOutViewPagerTransformer;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsBaseViewPager;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.FrsTabHostFragment;
import com.baidu.tieba.frs.FrsTabViewPager;
import com.baidu.tieba.frs.ac;
import com.baidu.tieba.frs.ai;
import com.baidu.tieba.frs.o;
import com.baidu.tieba.frs.smartapp.FrsLiteProgramListFragment;
import com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.tbadkCore.FRSPageSocketResponsedMessage;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsPageHttpResponseMessage;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.l;
import com.baidu.tieba.view.NavigationBarCoverTip;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.SmartApp;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes7.dex */
public class FrsTabController implements VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, FrsCommonImageLayout.c {
    public static final String gCk = FrsFragment.class.getSimpleName();
    public static final String gCl = FrsLiteProgramListFragment.class.getSimpleName();
    public static final String gCm = FrsTabHostFragment.class.getSimpleName();
    private FrsActivity gCn;
    private FrsLiteProgramListFragment gCo;
    private FrsTabHostFragment gCp;
    private ShareSuccessReplyToServerModel gCs;
    private FrsBaseViewPager gCu;
    private FragmentAdapter gCv;
    private OvalActionButton gCw;
    private boolean gCx;
    private boolean gCy;
    private NavigationBarCoverTip gCz;
    private ac gpC;
    private FrsFragment gpD;
    private l gpE;
    private int gpG;
    private FRSRefreshButton gpI;
    private String mForumName;
    private boolean gCq = false;
    private final Handler mHandler = new Handler();
    private int gpF = 0;
    private boolean gCt = false;
    private boolean gCA = false;
    private com.baidu.adp.framework.listener.a gCB = new com.baidu.adp.framework.listener.a(1001703, CmdConfigSocket.CMD_FRS_PAGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            l lVar = null;
            if (!FrsTabController.this.gCq && !responsedMessage.hasError() && responsedMessage.getError() == 0) {
                if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                    lVar = ((FrsPageHttpResponseMessage) responsedMessage).getResponseData();
                } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                    lVar = ((FRSPageSocketResponsedMessage) responsedMessage).getResponseData();
                }
                if (lVar != null) {
                    FrsTabController.this.gCq = true;
                    FrsTabController.this.e(lVar);
                    if (lVar != null && lVar.getForum() != null && !StringUtils.isNull(lVar.getForum().getId())) {
                        com.baidu.tbadk.core.business.a.axK().cf("2", lVar.getForum().getId());
                    }
                }
            }
        }
    };
    private CustomMessageListener gCC = new CustomMessageListener(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!FrsTabController.this.gCq && FrsTabController.this.gpE == null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof l)) {
                l lVar = (l) customResponsedMessage.getData();
                if (lVar.getForum() != null && FrsTabController.this.mForumName != null && FrsTabController.this.mForumName.equals(lVar.getForum().getName())) {
                    FrsTabController.this.e(lVar);
                }
            }
        }
    };
    private CustomMessageListener gCD = new CustomMessageListener(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsTabController.this.bGU();
        }
    };
    private CustomMessageListener gCE = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int sM;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (10001 == intValue) {
                    sM = FrsTabController.this.sM(9);
                    if (sM == -1) {
                        sM = FrsTabController.this.sM(2);
                    }
                } else {
                    sM = FrsTabController.this.sM(intValue);
                }
                if (sM != -1 && FrsTabController.this.bGV() && FrsTabController.this.gCp != null) {
                    FrsTabController.this.gCp.setCurrentTab(sM);
                    if (FrsTabController.this.sO(sM) != 1) {
                        FrsTabController.this.gpD.lf(false);
                    }
                }
            }
        }
    };
    private HttpMessageListener gCF = new HttpMessageListener(0) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && 1021074 == httpResponsedMessage.getCmd() && (httpResponsedMessage instanceof AlaGameTabGetNewNotifyResponsedMessage)) {
                List<a> newNotifyData = ((AlaGameTabGetNewNotifyResponsedMessage) httpResponsedMessage).getNewNotifyData();
                if (!v.isEmpty(newNotifyData) && FrsTabController.this.gCp != null) {
                    for (a aVar : newNotifyData) {
                        if (aVar != null) {
                            for (int i = 0; i < FrsTabController.this.gpC.bEf().size(); i++) {
                                FragmentTabHost.b jX = FrsTabController.this.gCp.jX(i);
                                if (jX != null && jX.mType != 1 && jX.mType != FrsTabController.this.gCp.getCurrentTabType() && jX.mType == aVar.getTabId() && aVar.bGM() && jX.cUe.vi(String.valueOf(jX.mType)) != null) {
                                    jX.cUe.vi(String.valueOf(jX.mType)).view.setVisibility(0);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private Runnable gCG = new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.17
        @Override // java.lang.Runnable
        public void run() {
            e.gx().removeCallbacks(this);
            FrsTabController.this.bGT();
            e.gx().postDelayed(this, 30000L);
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                FrsTabController.this.gCt = true;
            }
        }
    };
    private CustomMessageListener gCH = new CustomMessageListener(2921371) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!k.isFastDoubleClick() && customResponsedMessage != null && FrsTabController.this.gCu != null && FrsTabController.this.gCv != null && FrsTabController.this.gCv.Bc(FrsTabController.gCl) != null) {
                if (!j.isNetWorkAvailable()) {
                    FrsTabController.this.gCn.showToast(FrsTabController.this.gCn.getString(R.string.neterror));
                } else if ((FrsTabController.this.bBD().bCK().smartAppAvatar == null || FrsTabController.this.bBD().bCK().smartAppAvatar.size() != 1) && (FrsTabController.this.bBD().bCK().smartAppAvatar != null || FrsTabController.this.bBD().bCK().smartApp == null)) {
                    FrsTabController.this.gCu.setCurrentItem(1);
                } else {
                    SmartApp smartApp = FrsTabController.this.bBD().bCK().smartApp;
                    if (smartApp == null || !com.baidu.tieba.aiapps.a.b(smartApp.id, smartApp.link, "1191003700000000", smartApp.is_game)) {
                        FrsTabController.this.gCu.setCurrentItem(1);
                    } else {
                        TiebaStatic.log(new an("c13274").cp("fid", FrsTabController.this.bBD().getForumId()).cp("uid", TbadkCoreApplication.getCurrentAccount()).cp("obj_name", FrsTabController.this.bBD().bCK().smartApp.name).s("obj_id", FrsTabController.this.bBD().bCK().smartApp.swan_app_id.longValue()).cp("obj_source", "frs_Bside").Z("obj_param1", FrsTabController.this.bBD().bCK().smartApp.is_game.intValue()));
                    }
                }
            }
        }
    };
    private CustomMessageListener gCI = new CustomMessageListener(2921374) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.gCu != null && FrsTabController.this.gCv != null && FrsTabController.this.gCv.Bc(FrsTabController.gCl) != null) {
                FrsTabController.this.gCu.setCurrentItem(0);
            }
        }
    };
    private CustomMessageListener gCJ = new CustomMessageListener(2921369) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.gCu != null && FrsTabController.this.gCv != null && (customResponsedMessage.getData() instanceof FrsTabViewPager.a)) {
                FrsTabViewPager.a aVar = (FrsTabViewPager.a) customResponsedMessage.getData();
                FrsTabController.this.gCx = aVar.bEc();
                FrsTabController.this.gCy = aVar.bEd();
            }
        }
    };
    private CustomMessageListener gCK = new CustomMessageListener(2921370) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.gCu != null && FrsTabController.this.gCv != null && (customResponsedMessage.getData() instanceof Boolean)) {
                FrsTabController.this.gCu.setForceIntercept(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };
    private ViewPager.OnPageChangeListener gCL = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.4
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i == 1) {
                FrsTabController.this.gpD.bCI();
                FrsTabController.this.bGN();
                if (FrsTabController.this.bBD() != null) {
                    FrsTabController.this.bBD().kZ(true);
                }
                FrsTabController.this.gCw.setVisibility(8);
                return;
            }
            FrsTabController.this.gCw.setVisibility(0);
            if (FrsTabController.this.bBD() != null) {
                FrsTabController.this.bBD().kZ(false);
            }
            FrsTabController.this.gpD.bCJ();
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            switch (i) {
                case 0:
                    FrsTabController.this.gCy = false;
                    FrsTabController.this.gCu.setForceIntercept(false);
                    return;
                default:
                    return;
            }
        }
    };
    private FrsBaseViewPager.a gCM = new FrsBaseViewPager.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.5
        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public void bBS() {
            if (FrsTabController.this.gCu != null) {
                if (FrsTabController.this.gCu.getCurrentItem() == 0) {
                    FrsTabController.this.gCu.setmDisallowSlip(true);
                } else {
                    FrsTabController.this.gCu.setmDisallowSlip(false);
                }
            }
        }

        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public boolean bBT() {
            SmartApp smartApp;
            if (FrsTabController.this.gCu.getCurrentItem() == 0) {
                if (FrsTabController.this.gCx && FrsTabController.this.gCy) {
                    FrsTabController.this.gCu.setmDisallowSlip(false);
                }
                if (!FrsTabController.this.gCy) {
                    FrsTabController.this.gCu.setmDisallowSlip(true);
                }
                FrsTabController.this.gCu.setmDisallowSlip(true);
            } else {
                FrsTabController.this.gCu.setmDisallowSlip(true);
            }
            if (((FrsTabController.this.bBD().bCK().smartAppAvatar == null || FrsTabController.this.bBD().bCK().smartAppAvatar.size() != 1) && (FrsTabController.this.bBD().bCK().smartAppAvatar != null || FrsTabController.this.bBD().bCK().smartApp == null)) || (smartApp = FrsTabController.this.bBD().bCK().smartApp) == null || !com.baidu.tieba.aiapps.a.b(smartApp.id, smartApp.link, "1191003700000000", smartApp.is_game)) {
                return true;
            }
            TiebaStatic.log(new an("c13274").cp("fid", FrsTabController.this.bBD().getForumId()).cp("uid", TbadkCoreApplication.getCurrentAccount()).cp("obj_name", FrsTabController.this.bBD().bCK().smartApp.name).s("obj_id", FrsTabController.this.bBD().bCK().smartApp.swan_app_id.longValue()).cp("obj_source", "frs_Bside").Z("obj_param1", FrsTabController.this.bBD().bCK().smartApp.is_game.intValue()));
            return false;
        }
    };
    private String gCr = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.SHOW_GAME_FOREM_TAB_HOT_POINT);

    /* JADX INFO: Access modifiers changed from: private */
    public void bGN() {
        if (this.gCo != null && bBD() != null) {
            this.gCo.gGG = true;
            this.gCo.clear();
            if (!j.isNetWorkAvailable()) {
                this.gCo.Bt(bBD().getForumId());
            } else if ((bBD().bCK().smartAppAvatar != null && bBD().bCK().smartAppAvatar.size() == 1) || (bBD().bCK().smartAppAvatar == null && bBD().bCK().smartApp != null)) {
                SmartApp smartApp = bBD().bCK().smartApp;
                if (smartApp != null && !com.baidu.tieba.aiapps.a.b(smartApp.id, smartApp.link, "1191003700000000", smartApp.is_game)) {
                    String str = null;
                    if (bBD().bCK() != null && bBD().bCK().smartApp != null) {
                        str = bBD().bCK().smartApp.h5_url;
                    }
                    this.gCo.Bu(str);
                }
                TiebaStatic.log(new an("c13274").cp("fid", bBD().getForumId()).cp("uid", TbadkCoreApplication.getCurrentAccount()).cp("obj_name", bBD().bCK().smartApp.name).s("obj_id", bBD().bCK().smartApp.swan_app_id.longValue()).cp("obj_source", "frs_Bside").Z("obj_param1", bBD().bCK().smartApp.is_game.intValue()));
            } else {
                this.gCo.showLoadingView();
                FrsLiteProgramListFragment frsLiteProgramListFragment = this.gCo;
                String forumId = bBD().getForumId();
                FrsLiteProgramListFragment frsLiteProgramListFragment2 = this.gCo;
                FrsLiteProgramListFragment frsLiteProgramListFragment3 = this.gCo;
                frsLiteProgramListFragment.u(forumId, 1, 10);
                TiebaStatic.log(new an("c13273").cp("fid", bBD().getForumId()).cp("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    public FrsTabController(FrsActivity frsActivity) {
        this.gCn = frsActivity;
    }

    public void init(Bundle bundle) {
        if (this.gCn != null) {
            this.gCn.setContentView(R.layout.frs_base_layout);
            this.gCu = (FrsBaseViewPager) this.gCn.findViewById(R.id.frs_base_viewpager);
            this.gCv = new FragmentAdapter(this.gCn.getSupportFragmentManager());
            this.gCu.setAdapter(this.gCv);
            this.gCu.setPageTransformer(true, new CubeOutViewPagerTransformer());
            this.gCu.addOnPageChangeListener(this.gCL);
            this.gCu.setmDisallowSlip(true);
            this.gCu.setOnTouchEventListener(this.gCM);
            this.gCw = (OvalActionButton) this.gCn.findViewById(R.id.frs_post_forum_button);
            this.gCw.setIsCircle(true);
            this.gpI = (FRSRefreshButton) this.gCn.findViewById(R.id.frs_refresh_forum_button);
            this.gCn.registerListener(this.gCJ);
            this.gCn.registerListener(this.gCK);
            this.gCn.registerListener(this.gCH);
            this.gCn.registerListener(this.gCI);
            this.gCB.getHttpMessageListener().setPriority(-1);
            this.gCB.getSocketMessageListener().setPriority(-1);
            this.gCn.registerListener(this.gCC);
            this.gCE.setSelfListener(true);
            this.gCn.registerListener(this.gCE);
            this.gCD.setSelfListener(true);
            this.gCn.registerListener(this.gCD);
            this.gCn.registerListener(this.mAccountChangedListener);
            if (bundle == null) {
                this.mForumName = this.gCn.getIntent().getStringExtra("name");
                this.gpF = this.gCn.getIntent().getIntExtra(FrsActivityConfig.FRS_GAME_DEFAULT_TAB_ID, 0);
            } else {
                this.mForumName = bundle.getString("name");
                this.gpF = bundle.getInt("default_tab_id", 0);
            }
            ah(bundle);
            this.gCv.notifyDataSetChanged();
            this.gCs = new ShareSuccessReplyToServerModel();
            this.gCn.registerListener(this.gCB);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.mForumName);
        bundle.putInt("default_tab_id", this.gpF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ah(Bundle bundle) {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.gCv != null) {
            try {
                FrsFragment frsFragment = (FrsFragment) this.gCv.Bc(gCk);
                if (frsFragment == null) {
                    frsFragment = ai(bundle);
                }
                frsFragment.b(this.gCw);
                frsFragment.a(this.gpI);
                if (!gCk.equals(this.gCv.tA(0))) {
                    if (gCm.equals(this.gCv.tA(0))) {
                        this.gCv.tz(0);
                    }
                    this.gCv.a(0, frsFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(l lVar) {
        if (lVar != null && (lVar.smartApp != null || !v.isEmpty(lVar.smartAppAvatar))) {
            FragmentManager fragmentManager = getFragmentManager();
            if (fragmentManager == null || fragmentManager.isDestroyed() || this.gCv == null) {
                return false;
            }
            if (gCl.equals(this.gCv.tA(1))) {
                return false;
            }
            try {
                FrsLiteProgramListFragment frsLiteProgramListFragment = (FrsLiteProgramListFragment) this.gCv.Bc(gCl);
                if (frsLiteProgramListFragment == null) {
                    frsLiteProgramListFragment = bGP();
                }
                this.gCv.a(1, frsLiteProgramListFragment);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGO() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.gCv != null) {
            try {
                FrsTabHostFragment frsTabHostFragment = (FrsTabHostFragment) this.gCv.Bc(gCm);
                if (frsTabHostFragment == null) {
                    frsTabHostFragment = bGQ();
                }
                frsTabHostFragment.b(this.gCw);
                frsTabHostFragment.b(this.gpI);
                if (!gCm.equals(this.gCv.tA(0))) {
                    if (gCk.equals(this.gCv.tA(0))) {
                        this.gCv.tz(0);
                    }
                    this.gCv.a(0, frsTabHostFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private FrsFragment ai(Bundle bundle) {
        if (this.gpD == null) {
            this.gpD = new FrsFragment();
            this.gpD.setArguments(bundle);
            this.gpD.setBaseTag(gCk);
        }
        this.gpD.gmr = false;
        return this.gpD;
    }

    private FrsLiteProgramListFragment bGP() {
        if (this.gCo == null) {
            this.gCo = new FrsLiteProgramListFragment();
            this.gCo.setBaseTag(gCl);
        }
        return this.gCo;
    }

    private FrsTabHostFragment bGQ() {
        if (this.gCp == null) {
            this.gCp = new FrsTabHostFragment(this);
            this.gCp.setBaseTag(gCm);
            this.gCp.sR(this.gpF);
        }
        return this.gCp;
    }

    private FragmentManager getFragmentManager() {
        if (this.gCn != null) {
            return this.gCn.getSupportFragmentManager();
        }
        return null;
    }

    private void bGR() {
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.gpE != null && (themeColorInfo = this.gpE.getForum().getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            this.gCw.setStartAndEndColor(themeElement.light_color, themeElement.dark_color);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(final l lVar) {
        if (lVar != null && lVar.getForum() != null) {
            if (lVar.getForum().getIsShowBawuTask()) {
                int i = com.baidu.tbadk.core.sharedPref.b.aDr().getInt("key_bawu_task_toast", 0);
                if (i >= 0 && i < 1 && !this.gCA) {
                    this.gCA = true;
                    e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.6
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsTabController.this.bGX();
                        }
                    }, 30000L);
                } else {
                    return;
                }
            }
            this.gpE = lVar;
            if (v.getCount(lVar.getGameTabInfo()) > 0) {
                if (!this.gCn.isLoadingViewAttached() && !bGV()) {
                    this.gCn.showLoadingView(this.gCn.findViewById(16908290));
                }
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.7
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean d = FrsTabController.this.d(lVar);
                        FrsTabController.this.f(lVar);
                        boolean co = FrsTabController.this.co(FrsTabController.this.gpE.getGameTabInfo());
                        if (d || co) {
                            FrsTabController.this.gCv.notifyDataSetChanged();
                            if (co && FrsTabController.this.gCp != null) {
                                FrsTabController.this.gCp.M(FrsTabController.this.gpD);
                                FrsTabController.this.gCp.a(FrsTabController.this.gpE, FrsTabController.this.gpC);
                            }
                        }
                    }
                });
            } else if (bGV()) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.8
                    @Override // java.lang.Runnable
                    public void run() {
                        Bundle bundle;
                        FrsTabController.this.d(lVar);
                        FrsTabController.this.gpD.gmr = true;
                        if (FrsTabController.this.gpD != null) {
                            bundle = FrsTabController.this.gpD.getArguments();
                        } else {
                            bundle = null;
                        }
                        FrsTabController.this.ah(bundle);
                        FrsTabController.this.gCv.notifyDataSetChanged();
                        FrsTabController.this.f(lVar);
                    }
                });
            } else if (lVar != null && (lVar.smartApp != null || !v.isEmpty(lVar.smartAppAvatar))) {
                if (!this.gCn.isLoadingViewAttached() && !bGW()) {
                    this.gCn.showLoadingView(this.gCn.findViewById(16908290));
                }
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.9
                    @Override // java.lang.Runnable
                    public void run() {
                        if (FrsTabController.this.d(lVar)) {
                            FrsTabController.this.f(lVar);
                            FrsTabController.this.gCv.notifyDataSetChanged();
                        }
                        if (FrsTabController.this.gCn.isLoadingViewAttached()) {
                            FrsTabController.this.gCn.hideLoadingView(FrsTabController.this.gCn.findViewById(16908290));
                        }
                    }
                });
            }
            bGR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(l lVar) {
        if (lVar != null) {
            if (lVar.smartApp != null || !v.isEmpty(lVar.smartAppAvatar)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean co(List<FrsTabInfo> list) {
        if (this.gCn.isLoadingViewAttached()) {
            this.gCn.hideLoadingView(this.gCn.findViewById(16908290));
        }
        if (bGV()) {
            return false;
        }
        this.gpD.gmr = true;
        bGS();
        if (com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean("frs_game_login_tip", true)) {
            com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean(SharedPrefConfig.FRS_LOGIN_TIP, true);
            com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean("frs_game_login_tip", false);
        }
        cp(list);
        return true;
    }

    private void bGS() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021074, TbConfig.SERVER_ADDRESS + "game/forum/getNewNotify");
        tbHttpMessageTask.setResponsedClass(AlaGameTabGetNewNotifyResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.gCn.registerListener(1021074, this.gCF);
    }

    private void cp(List<FrsTabInfo> list) {
        boolean z;
        if (!v.isEmpty(list)) {
            CustomMessageListener customMessageListener = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.10
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ac)) {
                        if (!com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean(FrsTabController.this.gCr, true)) {
                            e.gx().post(FrsTabController.this.gCG);
                        }
                        ((ac) customResponsedMessage.getData()).b(new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.10.1
                            @Override // com.baidu.tbadk.mainTab.b
                            public boolean isAvailable() {
                                return true;
                            }

                            @Override // com.baidu.tbadk.mainTab.b
                            public com.baidu.tbadk.mainTab.c aNx() {
                                FrsSportsRecommendFragment frsSportsRecommendFragment = new FrsSportsRecommendFragment();
                                Bundle bundle = new Bundle();
                                bundle.putString("name", FrsTabController.this.gpD.getForumName());
                                bundle.putString("from", FrsTabController.this.gpD.getFrom());
                                bundle.putString("forum_id", FrsTabController.this.gpD.getForumId());
                                bundle.putInt("tab_id", 503);
                                bundle.putBoolean("can_auto_play_video", FrsTabController.this.gpE.isFrsVideoAutoPlay);
                                bundle.putBoolean("need_log", FrsTabController.this.gpE.needLog == 1);
                                bundle.putBoolean("is_brand_forum", FrsTabController.this.gpE.isBrandForum);
                                FrsViewData frsViewData = new FrsViewData();
                                frsViewData.receiveData(FrsTabController.this.gpE);
                                bundle.putSerializable("view_data", frsViewData);
                                frsSportsRecommendFragment.setArguments(bundle);
                                com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                                cVar.frag = frsSportsRecommendFragment;
                                cVar.type = 25;
                                cVar.showIconType = com.baidu.tbadk.mainTab.c.SHOWTEXT;
                                return cVar;
                            }

                            @Override // com.baidu.tbadk.mainTab.b
                            public TbFragmentTabIndicator dW(Context context) {
                                this.dxc = (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
                                this.dxc.setTextSize(2.0f);
                                return this.dxc;
                            }
                        });
                        FrsTabController.this.bGO();
                    }
                }
            };
            customMessageListener.setPriority(Integer.MAX_VALUE);
            customMessageListener.setSelfListener(true);
            this.gCn.registerListener(customMessageListener);
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
            this.gpC = new ac(this.gCn.getActivity(), arrayList);
            if (bBD() != null) {
                this.gpC.setForumId(bBD().getForumId());
                this.gpC.setForumName(bBD().getForumName());
                if (bBD().bCK() != null && bBD().bCK().getForum() != null) {
                    ForumData forum = bBD().bCK().getForum();
                    this.gpC.setForumGameLabel(forum.getForumGameLabel());
                    this.gpC.AQ(forum.getSpecialForumType());
                }
            }
            this.gpD.gmr = false;
            new d(this.gpD).a(this.gpC);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB, this.gpC);
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB);
            customMessage.setTag(this.gCn.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGT() {
        if (this.gpC != null && !TextUtils.isEmpty(this.gpC.getForumId())) {
            HttpMessage httpMessage = new HttpMessage(1021074);
            httpMessage.addParam("forum_id", this.gpE.getForum().getId());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    private void a(Fragment fragment, int i) {
        NavigationBar bcw;
        if ((fragment instanceof ai) && this.gpE != null && this.gpE.getForum() != null && (bcw = ((ai) fragment).bcw()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.gpE.getForum().getName(), 5, true, true) + this.gCn.getActivity().getString(R.string.forum));
            bcw.setCenterTextTitle(sb.toString());
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.gpD instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.gpD.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a nB(int i) {
        if (this.gpD instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.gpD.nB(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.gpD instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.gpD.a(bVar);
        }
    }

    public void onNewIntent(Intent intent) {
        if (this.gpD != null) {
            this.gpD.onNewIntent(intent);
        }
    }

    public void onResume() {
        if (!bGV()) {
            this.gpD.setPrimary(true);
        } else if (this.gCp != null) {
            Fragment currentFragment = this.gCp.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(true);
            }
        }
        if (this.gCt) {
            this.gCt = false;
            if (this.gpD != null) {
                this.gpD.refresh();
            }
        }
    }

    public void onPause() {
        if (!bGV()) {
            this.gpD.setPrimary(false);
        } else if (this.gCp != null) {
            Fragment currentFragment = this.gCp.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(false);
            }
        }
    }

    public void onChangeSkinType(int i) {
        UtilHelper.changeStatusBarIconAndTextColor(true, this.gCn);
        if (this.gpD != null) {
            this.gpD.onChangeSkinType(i);
        }
        if (this.gCp != null) {
            this.gCp.onChangeSkinType(i);
        }
        bGR();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.gCo != null && this.gCo.gGG) {
                this.gCo.gGG = false;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921374));
                return true;
            } else if (bGV() && this.gCp != null && this.gCp.bDK()) {
                this.gCp.bDX();
                UtilHelper.setNavigationBarBackground(this.gCn, this.gCp.bDS());
            } else if (this.gpD != null && this.gpD.isAdded()) {
                if (this.gpD.onKeyDown(i, keyEvent)) {
                    return true;
                }
                bGU();
            } else {
                return this.gCn.b(i, keyEvent);
            }
        } else if (i == 24) {
            if (this.gpD != null && this.gpD.isAdded()) {
                return this.gpD.onKeyDown(i, keyEvent);
            }
        } else {
            return this.gCn.b(i, keyEvent);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGU() {
        if (this.gpG != this.gpF && bGV()) {
            this.gCp.setCurrentTab(this.gpF);
            if (sO(this.gpF) != 1) {
                this.gpD.lf(false);
            }
            this.gpG = this.gpF;
            a(this.gCp.getCurrentFragment(), this.gpF);
            return;
        }
        this.gpD.closeActivity();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!bGV()) {
            this.gpD.onActivityResult(i, i2, intent);
        } else if (this.gCp != null) {
            if (1 == this.gCp.getCurrentTabType()) {
                this.gpD.onActivityResult(i, i2, intent);
            } else {
                this.gCp.getCurrentFragment().onActivityResult(i, i2, intent);
            }
        }
        if (i2 == -1) {
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1) {
                    com.baidu.tieba.n.a.cAC().A(this.gCn.getPageContext());
                    ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.linkUrl != null && this.gCs != null) {
                        this.gCs.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.11
                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void aJp() {
                            }

                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void a(final CustomDialogData customDialogData) {
                                e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.11.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (FrsTabController.this.gCn != null) {
                                            com.baidu.tieba.pb.interactionpopupwindow.c.a(FrsTabController.this.gCn.getPageContext(), customDialogData).show();
                                        }
                                    }
                                }, 1000L);
                            }
                        });
                    }
                }
            } else if (i == 13011) {
                com.baidu.tieba.n.a.cAC().A(this.gCn.getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (!bGV()) {
            return this.gpD.getVoiceManager();
        }
        if (this.gCp == null) {
            return null;
        }
        Fragment currentFragment = this.gCp.getCurrentFragment();
        if (currentFragment instanceof VoiceManager.c) {
            return ((VoiceManager.c) currentFragment).getVoiceManager();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int sM(int i) {
        if (this.gpC == null) {
            return -1;
        }
        int count = v.getCount(this.gpC.bEf());
        for (int i2 = 0; i2 < count; i2++) {
            if (this.gpC.bEf().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int sO(int i) {
        if (this.gpC != null && i < v.getCount(this.gpC.bEf())) {
            return this.gpC.bEf().get(i).tab_id.intValue();
        }
        return -1;
    }

    public FrsFragment bBD() {
        return this.gpD;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> bBE() {
        if (!bGV()) {
            if (this.gpD instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) this.gpD).bBE();
            }
        } else if (this.gCp == null) {
            return null;
        } else {
            Fragment currentFragment = this.gCp.getCurrentFragment();
            if (currentFragment instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) currentFragment).bBE();
            }
        }
        return null;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(o.goZ);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.gCn.isLoadingViewAttached()) {
            this.gCn.hideLoadingView(this.gCn.findViewById(16908290));
        }
        if (this.gCG != null) {
            e.gx().removeCallbacks(this.gCG);
        }
        com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean(this.gCr, false);
        if (this.gCs != null) {
            this.gCs.cancelLoadData();
        }
        if (this.gpD != null && this.gpD.bCf() != null) {
            this.gpD.bCf().ags();
        }
        if (this.gCz != null) {
            this.gCz.onDestroy();
        }
    }

    public FragmentTabHost bDV() {
        if (this.gCp == null) {
            return null;
        }
        return this.gCp.bDV();
    }

    public boolean bGV() {
        if (this.gCv == null) {
            return false;
        }
        return this.gCv.getItem(0) instanceof FrsTabHostFragment;
    }

    private boolean bGW() {
        if (this.gCv == null) {
            return false;
        }
        return this.gCv.getItem(1) instanceof FrsLiteProgramListFragment;
    }

    public void sR(int i) {
        this.gpF = i;
    }

    public void tx(int i) {
        this.gpG = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGX() {
        if (this.gCn != null) {
            if (this.gCz == null) {
                this.gCz = (NavigationBarCoverTip) this.gCn.findViewById(R.id.navigation_cover_tip);
            }
            if (this.gCz != null) {
                View inflate = View.inflate(this.gCn, R.layout.write_thread_share_guide, null);
                TextView textView = (TextView) inflate.findViewById(R.id.write_thread_success_tips);
                TextView textView2 = (TextView) inflate.findViewById(R.id.share_icon);
                if (TextUtils.isEmpty(this.mForumName)) {
                    textView.setText("吧主您好，本吧考核新制度上线啦");
                } else {
                    textView.setText(this.mForumName + "吧吧主您好，本吧考核新制度上线啦");
                }
                textView2.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.check_immediately));
                am.setViewTextColor(textView, (int) R.color.cp_cont_a);
                am.setViewTextColor(textView2, (int) R.color.cp_cont_a);
                am.setBackgroundResource(textView2, R.drawable.share_now_bg);
                am.setBackgroundColor(this.gCz, R.color.cp_link_tip_a_alpha95);
                textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.13
                    /* JADX DEBUG: Multi-variable search result rejected for r4v9, resolved type: com.baidu.tieba.frs.FrsActivity */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        new an("c13439").aEm();
                        if (FrsTabController.this.bBD() != null && !TextUtils.isEmpty(FrsTabController.this.bBD().getForumId()) && !TextUtils.isEmpty(FrsTabController.this.mForumName) && FrsTabController.this.gCn != null) {
                            if (FrsTabController.this.gCz != null) {
                                FrsTabController.this.gCz.hideTip();
                            }
                            ba.aEt().b(FrsTabController.this.gCn.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/bawutask?fid=" + FrsTabController.this.bBD().getForumId() + "&fn=" + FrsTabController.this.mForumName + "&noread=" + (com.baidu.tbadk.core.sharedPref.b.aDr().getInt("key_bawu_task_toast", 0) == -1 ? 1 : 0)});
                        }
                    }
                });
                this.gCz.a(this.gCn, inflate, 30000);
                new an("c13438").aEm();
                int i = com.baidu.tbadk.core.sharedPref.b.aDr().getInt("key_bawu_task_toast", 0);
                if (i >= 0) {
                    com.baidu.tbadk.core.sharedPref.b.aDr().putInt("key_bawu_task_toast", i + 1);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class FragmentAdapter extends FragmentStatePagerAdapter {
        private List<BaseFragment> mFragments;

        public FragmentAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.mFragments = new ArrayList(2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v4.app.FragmentStatePagerAdapter
        /* renamed from: ty */
        public BaseFragment getItem(int i) {
            return (BaseFragment) v.getItem(this.mFragments, i);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.mFragments.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }

        public boolean a(int i, BaseFragment baseFragment) {
            return v.add(this.mFragments, i, baseFragment);
        }

        public BaseFragment Bc(String str) {
            if (aq.isEmpty(str)) {
                return null;
            }
            for (BaseFragment baseFragment : this.mFragments) {
                if (baseFragment != null && str.equals(baseFragment.getBaseTag())) {
                    return baseFragment;
                }
            }
            return null;
        }

        public BaseFragment tz(int i) {
            return (BaseFragment) v.remove(this.mFragments, i);
        }

        public String tA(int i) {
            if (getItem(i) != null) {
                return getItem(i).getBaseTag();
            }
            return null;
        }
    }

    public TbPageTag getTbPageTag() {
        if (!bGV()) {
            return this.gpD.getTbPageTag();
        }
        if (this.gCp != null) {
            if (1 == this.gCp.getCurrentTabType()) {
                return this.gpD.getTbPageTag();
            }
            Fragment currentFragment = this.gCp.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                return ((BaseFragment) currentFragment).getTbPageTag();
            }
        }
        return null;
    }
}
