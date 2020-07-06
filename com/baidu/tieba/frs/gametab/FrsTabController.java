package com.baidu.tieba.frs.gametab;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.ActivityChooserView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.v;
import com.baidu.tbadk.widget.FRSRefreshButton;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.c.e;
import com.baidu.tieba.frs.CubeOutViewPagerTransformer;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsBaseViewPager;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.FrsRecommendResMsg;
import com.baidu.tieba.frs.FrsTabHostFragment;
import com.baidu.tieba.frs.FrsTabViewPager;
import com.baidu.tieba.frs.ak;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.frs.l;
import com.baidu.tieba.frs.s;
import com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.tbadkCore.FRSPageSocketResponsedMessage;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsPageHttpResponseMessage;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.m;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.tieba.view.ScreenTopToast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes9.dex */
public class FrsTabController implements VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, FrsCommonImageLayout.c {
    public static final String hRH = FrsFragment.class.getSimpleName();
    public static final String hRI = FrsTabHostFragment.class.getSimpleName();
    private ak hDG;
    private FrsFragment hDH;
    private m hDI;
    private int hDK;
    private FRSRefreshButton hDM;
    private FrsActivity hRJ;
    private FrsTabHostFragment hRK;
    private ShareSuccessReplyToServerModel hRN;
    private FrsBaseViewPager hRP;
    private FragmentAdapter hRQ;
    private OvalActionButton hRR;
    private boolean hRS;
    private boolean hRT;
    private NavigationBarCoverTip hRU;
    private e hRX;
    private LinearLayout hzN;
    private String mForumName;
    private boolean hRL = false;
    private final Handler mHandler = new Handler();
    private int hDJ = 0;
    private boolean hRO = false;
    private boolean hRV = false;
    private boolean hRW = false;
    private HttpMessageListener hRY = new HttpMessageListener(CmdConfigHttp.CMD_FRS_RECOMMEND) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof FrsRecommendResMsg) {
                if (httpResponsedMessage.getError() != 0) {
                    new BdTopToast(FrsTabController.this.hRJ).vz(false).OJ(httpResponsedMessage.getErrorString()).aE((ViewGroup) FrsTabController.this.hRJ.findViewById(R.id.frs));
                    return;
                }
                int pushStatus = ((FrsRecommendResMsg) httpResponsedMessage).getPushStatus();
                String pushMsg = ((FrsRecommendResMsg) httpResponsedMessage).getPushMsg();
                if (pushStatus == 1) {
                    new ScreenTopToast(FrsTabController.this.hRJ).OK(FrsTabController.this.hRJ.getString(R.string.frs_recommend_suc_tip_title)).OL(FrsTabController.this.hRJ.getString(R.string.frs_recommend_suc_tip_content)).OM(FrsTabController.this.hRJ.getString(R.string.dialog_confirm_see)).ai(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.1.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("_forumId", FrsTabController.this.hDI.getForum().getId());
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new com.baidu.tieba.tbadkCore.data.m(FrsTabController.this.hRJ, "RecommendHistoryPage", hashMap)));
                        }
                    }).aE((ViewGroup) FrsTabController.this.hRJ.findViewById(R.id.frs));
                } else {
                    new BdTopToast(FrsTabController.this.hRJ).vz(false).OJ(pushMsg).aE((ViewGroup) FrsTabController.this.hRJ.findViewById(R.id.frs));
                }
            }
        }
    };
    private CustomMessageListener hRZ = new CustomMessageListener(2921465) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            new ScreenTopToast(FrsTabController.this.hRJ).OK(FrsTabController.this.hRJ.getString(R.string.frs_recommend_fail_tip_content)).OM(FrsTabController.this.hRJ.getString(R.string.frs_recommend_fail_tip_btn)).ai(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.12.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("_forumId", FrsTabController.this.hDI.getForum().getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new com.baidu.tieba.tbadkCore.data.m(FrsTabController.this.hRJ, "ForumGradePage", hashMap)));
                }
            }).aE((ViewGroup) FrsTabController.this.hRJ.findViewById(R.id.frs));
        }
    };
    private com.baidu.adp.framework.listener.a hSa = new com.baidu.adp.framework.listener.a(1001703, CmdConfigSocket.CMD_FRS_PAGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.13
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            m mVar = null;
            if (!FrsTabController.this.hRL && !responsedMessage.hasError() && responsedMessage.getError() == 0) {
                if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                    mVar = ((FrsPageHttpResponseMessage) responsedMessage).getResponseData();
                } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                    mVar = ((FRSPageSocketResponsedMessage) responsedMessage).getResponseData();
                }
                if (mVar != null) {
                    FrsTabController.this.hRL = true;
                    FrsTabController.this.a(mVar, true);
                    if (mVar != null && mVar.getForum() != null && !StringUtils.isNull(mVar.getForum().getId())) {
                        com.baidu.tbadk.core.business.a.aPM().da("2", mVar.getForum().getId());
                    }
                }
                if (mVar != null && mVar.getUserData() != null && mVar.getUserData().getNewGodData() != null) {
                    if (mVar.getForum() != null) {
                        v.biV().setFid(mVar.getForum().getId());
                    }
                    v.biV().b(2, mVar.getUserData().getNewGodData());
                }
            }
        }
    };
    private CustomMessageListener hSb = new CustomMessageListener(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!FrsTabController.this.hRL && FrsTabController.this.hDI == null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof m)) {
                m mVar = (m) customResponsedMessage.getData();
                if (mVar.getForum() != null && FrsTabController.this.mForumName != null && FrsTabController.this.mForumName.equals(mVar.getForum().getName())) {
                    FrsTabController.this.a(mVar, false);
                }
            }
        }
    };
    private CustomMessageListener hSc = new CustomMessageListener(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsTabController.this.ccY();
        }
    };
    private CustomMessageListener hSd = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int uF;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (10001 == intValue) {
                    uF = FrsTabController.this.uF(9);
                    if (uF == -1) {
                        uF = FrsTabController.this.uF(2);
                    }
                } else {
                    uF = FrsTabController.this.uF(intValue);
                }
                if (uF != -1 && FrsTabController.this.ccZ() && FrsTabController.this.hRK != null) {
                    FrsTabController.this.hRK.setCurrentTab(uF);
                    if (FrsTabController.this.uH(uF) != 1) {
                        FrsTabController.this.hDH.mZ(false);
                    }
                }
            }
        }
    };
    private HttpMessageListener hSe = new HttpMessageListener(0) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && 1021074 == httpResponsedMessage.getCmd() && (httpResponsedMessage instanceof AlaGameTabGetNewNotifyResponsedMessage)) {
                List<a> newNotifyData = ((AlaGameTabGetNewNotifyResponsedMessage) httpResponsedMessage).getNewNotifyData();
                if (!w.isEmpty(newNotifyData) && FrsTabController.this.hRK != null) {
                    for (a aVar : newNotifyData) {
                        if (aVar != null) {
                            for (int i = 0; i < FrsTabController.this.hDG.bXE().size(); i++) {
                                FragmentTabHost.b ll = FrsTabController.this.hRK.ll(i);
                                if (ll != null && ll.mType != 1 && ll.mType != FrsTabController.this.hRK.getCurrentTabType() && ll.mType == aVar.getTabId() && aVar.ccS() && ll.dSF.yR(String.valueOf(ll.mType)) != null) {
                                    ll.dSF.yR(String.valueOf(ll.mType)).view.setVisibility(0);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private Runnable hSf = new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.18
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.adp.lib.f.e.lt().removeCallbacks(this);
            FrsTabController.this.ccX();
            com.baidu.adp.lib.f.e.lt().postDelayed(this, 30000L);
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                FrsTabController.this.hRO = true;
            }
        }
    };
    private CustomMessageListener hSg = new CustomMessageListener(2921369) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.hRP != null && FrsTabController.this.hRQ != null && (customResponsedMessage.getData() instanceof FrsTabViewPager.a)) {
                FrsTabViewPager.a aVar = (FrsTabViewPager.a) customResponsedMessage.getData();
                FrsTabController.this.hRS = aVar.cac();
                FrsTabController.this.hRT = aVar.cad();
            }
        }
    };
    private CustomMessageListener hSh = new CustomMessageListener(2921370) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.hRP != null && FrsTabController.this.hRQ != null && (customResponsedMessage.getData() instanceof Boolean)) {
                FrsTabController.this.hRP.setForceIntercept(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };
    private ViewPager.OnPageChangeListener hSi = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.4
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i != 1) {
                FrsTabController.this.hRR.setVisibility(0);
                if (FrsTabController.this.bXn() != null) {
                    FrsTabController.this.bXn().mT(false);
                }
                FrsTabController.this.hDH.bYB();
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            switch (i) {
                case 0:
                    FrsTabController.this.hRT = false;
                    FrsTabController.this.hRP.setForceIntercept(false);
                    return;
                default:
                    return;
            }
        }
    };
    private FrsBaseViewPager.a hSj = new FrsBaseViewPager.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.5
        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public void bXI() {
            if (FrsTabController.this.hRP != null) {
                if (FrsTabController.this.hRP.getCurrentItem() == 0) {
                    FrsTabController.this.hRP.setmDisallowSlip(true);
                } else {
                    FrsTabController.this.hRP.setmDisallowSlip(false);
                }
            }
        }

        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public boolean bXJ() {
            if (FrsTabController.this.hRP.getCurrentItem() == 0) {
                if (FrsTabController.this.hRS && FrsTabController.this.hRT) {
                    FrsTabController.this.hRP.setmDisallowSlip(false);
                }
                if (!FrsTabController.this.hRT) {
                    FrsTabController.this.hRP.setmDisallowSlip(true);
                }
                FrsTabController.this.hRP.setmDisallowSlip(true);
            } else {
                FrsTabController.this.hRP.setmDisallowSlip(true);
            }
            return true;
        }
    };
    private String hRM = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.SHOW_GAME_FOREM_TAB_HOT_POINT);

    public FrsTabController(FrsActivity frsActivity) {
        this.hRJ = frsActivity;
    }

    public void init(Bundle bundle) {
        if (this.hRJ != null) {
            this.hRJ.setContentView(R.layout.frs_base_layout);
            this.hRP = (FrsBaseViewPager) this.hRJ.findViewById(R.id.frs_base_viewpager);
            this.hRQ = new FragmentAdapter(this.hRJ.getSupportFragmentManager());
            this.hRP.setAdapter(this.hRQ);
            this.hRP.setPageTransformer(true, new CubeOutViewPagerTransformer());
            this.hRP.addOnPageChangeListener(this.hSi);
            this.hRP.setmDisallowSlip(true);
            this.hRP.setOnTouchEventListener(this.hSj);
            this.hRR = (OvalActionButton) this.hRJ.findViewById(R.id.frs_post_forum_button);
            this.hRR.setIsCircle(true);
            this.hRR.setHasShadow(false);
            this.hDM = (FRSRefreshButton) this.hRJ.findViewById(R.id.frs_refresh_forum_button);
            this.hzN = (LinearLayout) this.hRJ.findViewById(R.id.frs_ll_redpack);
            this.hRJ.registerListener(this.hSg);
            this.hRJ.registerListener(this.hSh);
            this.hSa.getHttpMessageListener().setPriority(-1);
            this.hSa.getSocketMessageListener().setPriority(-1);
            this.hRJ.registerListener(this.hSb);
            this.hSd.setSelfListener(true);
            this.hRJ.registerListener(this.hSd);
            this.hSc.setSelfListener(true);
            this.hRJ.registerListener(this.hSc);
            this.hRJ.registerListener(this.mAccountChangedListener);
            if (bundle == null) {
                this.mForumName = this.hRJ.getIntent().getStringExtra("name");
                this.hDJ = this.hRJ.getIntent().getIntExtra(FrsActivityConfig.FRS_GAME_DEFAULT_TAB_ID, 0);
            } else {
                this.mForumName = bundle.getString("name");
                this.hDJ = bundle.getInt("default_tab_id", 0);
            }
            an(bundle);
            this.hRQ.notifyDataSetChanged();
            this.hRN = new ShareSuccessReplyToServerModel();
            this.hRJ.registerListener(this.hSa);
            this.hRJ.registerListener(this.hRY);
            this.hRJ.registerListener(this.hRZ);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.mForumName);
        bundle.putInt("default_tab_id", this.hDJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void an(Bundle bundle) {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.hRQ != null) {
            try {
                FrsFragment frsFragment = (FrsFragment) this.hRQ.Fq(hRH);
                if (frsFragment == null) {
                    frsFragment = ao(bundle);
                }
                frsFragment.b(this.hRR);
                frsFragment.a(this.hDM);
                frsFragment.c(this.hzN);
                if (!hRH.equals(this.hRQ.vw(0))) {
                    if (hRI.equals(this.hRQ.vw(0))) {
                        this.hRQ.vv(0);
                    }
                    this.hRQ.a(0, frsFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccT() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.hRQ != null) {
            try {
                FrsTabHostFragment frsTabHostFragment = (FrsTabHostFragment) this.hRQ.Fq(hRI);
                if (frsTabHostFragment == null) {
                    frsTabHostFragment = ccU();
                }
                frsTabHostFragment.b(this.hRR);
                frsTabHostFragment.b(this.hDM);
                if (!hRI.equals(this.hRQ.vw(0))) {
                    if (hRH.equals(this.hRQ.vw(0))) {
                        this.hRQ.vv(0);
                    }
                    this.hRQ.a(0, frsTabHostFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private FrsFragment ao(Bundle bundle) {
        if (this.hDH == null) {
            this.hDH = new FrsFragment();
            this.hDH.setArguments(bundle);
            this.hDH.setBaseTag(hRH);
        }
        this.hDH.hzU = false;
        return this.hDH;
    }

    private FrsTabHostFragment ccU() {
        if (this.hRK == null) {
            this.hRK = new FrsTabHostFragment(this);
            this.hRK.setBaseTag(hRI);
            this.hRK.uJ(this.hDJ);
        }
        return this.hRK;
    }

    private FragmentManager getFragmentManager() {
        if (this.hRJ != null) {
            return this.hRJ.getSupportFragmentManager();
        }
        return null;
    }

    private void ccV() {
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.hDI != null && (themeColorInfo = this.hDI.getForum().getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            this.hRR.setStartAndEndColor(themeElement.light_color, themeElement.dark_color);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(m mVar, boolean z) {
        if (mVar != null && mVar.getForum() != null) {
            ForumData forum = mVar.getForum();
            if (forum.getIsShowBawuTask() && com.baidu.tbadk.core.sharedPref.b.aVP().getInt("key_bawu_task_toast", 0) == 0 && !this.hRV) {
                this.hRV = true;
                com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.6
                    @Override // java.lang.Runnable
                    public void run() {
                        FrsTabController.this.cda();
                    }
                }, 30000L);
            }
            if (mVar.bazhuExam != null && !this.hRW && z) {
                l.a(this.hRJ.getPageContext(), mVar.bazhuExam, forum.getId(), forum.getName());
                this.hRW = true;
            }
            this.hDI = mVar;
            if (this.hRJ.getIntent() == null || this.hRJ.getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null) {
            }
            if (w.getCount(mVar.getGameTabInfo()) > 0) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.7
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean cE = FrsTabController.this.cE(FrsTabController.this.hDI.getGameTabInfo());
                        if (cE) {
                            FrsTabController.this.hRQ.notifyDataSetChanged();
                            if (cE && FrsTabController.this.hRK != null) {
                                FrsTabController.this.hRK.U(FrsTabController.this.hDH);
                                FrsTabController.this.hRK.a(FrsTabController.this.hDI, FrsTabController.this.hDG);
                            }
                        }
                        if (FrsTabController.this.hRJ.isLoadingViewAttached()) {
                            FrsTabController.this.hRJ.hideLoadingView(FrsTabController.this.hRJ.findViewById(16908290));
                        }
                    }
                });
            } else if (ccZ()) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.8
                    @Override // java.lang.Runnable
                    public void run() {
                        Bundle bundle;
                        FrsTabController.this.hDH.hzU = true;
                        if (FrsTabController.this.hDH != null) {
                            bundle = FrsTabController.this.hDH.getArguments();
                        } else {
                            bundle = null;
                        }
                        FrsTabController.this.an(bundle);
                        FrsTabController.this.hRQ.notifyDataSetChanged();
                        if (FrsTabController.this.hRJ.isLoadingViewAttached()) {
                            FrsTabController.this.hRJ.hideLoadingView(FrsTabController.this.hRJ.findViewById(16908290));
                        }
                    }
                });
            }
            ccV();
            cdb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cE(List<FrsTabInfo> list) {
        if (this.hRJ.isLoadingViewAttached()) {
            this.hRJ.hideLoadingView(this.hRJ.findViewById(16908290));
        }
        if (ccZ()) {
            return false;
        }
        this.hDH.hzU = true;
        ccW();
        if (com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean("frs_game_login_tip", true)) {
            com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean(SharedPrefConfig.FRS_LOGIN_TIP, true);
            com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean("frs_game_login_tip", false);
        }
        cF(list);
        return true;
    }

    private void ccW() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021074, TbConfig.SERVER_ADDRESS + "game/forum/getNewNotify");
        tbHttpMessageTask.setResponsedClass(AlaGameTabGetNewNotifyResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.hRJ.registerListener(1021074, this.hSe);
    }

    private void cF(List<FrsTabInfo> list) {
        boolean z;
        if (!w.isEmpty(list)) {
            CustomMessageListener customMessageListener = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.9
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ak)) {
                        if (!com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean(FrsTabController.this.hRM, true)) {
                            com.baidu.adp.lib.f.e.lt().post(FrsTabController.this.hSf);
                        }
                        ((ak) customResponsedMessage.getData()).b(new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.9.1
                            @Override // com.baidu.tbadk.mainTab.b
                            public boolean isAvailable() {
                                return true;
                            }

                            @Override // com.baidu.tbadk.mainTab.b
                            public com.baidu.tbadk.mainTab.c createFragmentTabStructure() {
                                FrsSportsRecommendFragment frsSportsRecommendFragment = new FrsSportsRecommendFragment();
                                Bundle bundle = new Bundle();
                                bundle.putString("name", FrsTabController.this.hDH.getForumName());
                                bundle.putString("from", FrsTabController.this.hDH.getFrom());
                                bundle.putString("forum_id", FrsTabController.this.hDH.getForumId());
                                bundle.putInt("tab_id", 503);
                                bundle.putBoolean("can_auto_play_video", FrsTabController.this.hDI.isFrsVideoAutoPlay);
                                bundle.putBoolean("need_log", FrsTabController.this.hDI.needLog == 1);
                                bundle.putBoolean("is_brand_forum", FrsTabController.this.hDI.isBrandForum);
                                FrsViewData frsViewData = new FrsViewData();
                                frsViewData.receiveData(FrsTabController.this.hDI);
                                bundle.putSerializable("view_data", frsViewData);
                                frsSportsRecommendFragment.setArguments(bundle);
                                com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                                cVar.frag = frsSportsRecommendFragment;
                                cVar.type = 25;
                                cVar.showIconType = com.baidu.tbadk.mainTab.c.SHOWTEXT;
                                return cVar;
                            }

                            @Override // com.baidu.tbadk.mainTab.b
                            public TbFragmentTabIndicator getTabIndicator(Context context) {
                                this.mIndicator = (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
                                this.mIndicator.setTextSize(2.0f);
                                return this.mIndicator;
                            }
                        });
                        FrsTabController.this.ccT();
                    }
                }
            };
            customMessageListener.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            customMessageListener.setSelfListener(true);
            this.hRJ.registerListener(customMessageListener);
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
            this.hDG = new ak(this.hRJ.getActivity(), arrayList);
            if (bXn() != null) {
                this.hDG.setForumId(bXn().getForumId());
                this.hDG.setForumName(bXn().getForumName());
                if (bXn().bYC() != null && bXn().bYC().getForum() != null) {
                    ForumData forum = bXn().bYC().getForum();
                    this.hDG.setForumGameLabel(forum.getForumGameLabel());
                    this.hDG.Dy(forum.getSpecialForumType());
                }
            }
            this.hDH.hzU = false;
            new d(this.hDH).a(this.hDG);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB, this.hDG);
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB);
            customMessage.setTag(this.hRJ.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccX() {
        if (this.hDG != null && !TextUtils.isEmpty(this.hDG.getForumId())) {
            HttpMessage httpMessage = new HttpMessage(1021074);
            httpMessage.addParam("forum_id", this.hDI.getForum().getId());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    private void a(Fragment fragment, int i) {
        NavigationBar bwW;
        if ((fragment instanceof ar) && this.hDI != null && this.hDI.getForum() != null && (bwW = ((ar) fragment).bwW()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.hDI.getForum().getName(), 5, true, true) + this.hRJ.getActivity().getString(R.string.forum));
            bwW.setCenterTextTitle(sb.toString());
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.hDH instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.hDH.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a pm(int i) {
        if (this.hDH instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.hDH.pm(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.hDH instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.hDH.a(bVar);
        }
    }

    public void onNewIntent(Intent intent) {
        if (this.hDH != null) {
            this.hDH.onNewIntent(intent);
        }
    }

    public void onResume() {
        if (!ccZ()) {
            this.hDH.setPrimary(true);
        } else if (this.hRK != null) {
            Fragment currentFragment = this.hRK.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(true);
            }
        }
        if (this.hRO) {
            this.hRO = false;
            if (this.hDH != null) {
                this.hDH.refresh();
            }
        }
        if (this.hDI != null && this.hDI.getUserData() != null && this.hDI.getUserData().getNewGodData() != null) {
            if (this.hDI.getForum() != null) {
                v.biV().setFid(this.hDI.getForum().getId());
            }
            v.biV().b(2, this.hDI.getUserData().getNewGodData());
        }
    }

    public void onPause() {
        if (!ccZ()) {
            this.hDH.setPrimary(false);
        } else if (this.hRK != null) {
            Fragment currentFragment = this.hRK.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(false);
            }
        }
        v.biV().removeCallbacks();
    }

    public void onChangeSkinType(int i) {
        UtilHelper.changeStatusBarIconAndTextColor(true, this.hRJ);
        if (this.hDH != null) {
            this.hDH.onChangeSkinType(i);
        }
        if (this.hRK != null) {
            this.hRK.onChangeSkinType(i);
        }
        ccV();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (ccZ() && this.hRK != null && this.hRK.bZJ()) {
                this.hRK.bZX();
                UtilHelper.setNavigationBarBackground(this.hRJ, this.hRK.bZS());
            } else if (this.hDH != null && this.hDH.isAdded()) {
                if (this.hDH.onKeyDown(i, keyEvent)) {
                    return true;
                }
                ccY();
            } else {
                return this.hRJ.b(i, keyEvent);
            }
        } else if (i == 24) {
            if (this.hDH != null && this.hDH.isAdded()) {
                return this.hDH.onKeyDown(i, keyEvent);
            }
        } else {
            return this.hRJ.b(i, keyEvent);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccY() {
        if (this.hDK != this.hDJ && ccZ()) {
            this.hRK.setCurrentTab(this.hDJ);
            if (uH(this.hDJ) != 1) {
                this.hDH.mZ(false);
            }
            this.hDK = this.hDJ;
            a(this.hRK.getCurrentFragment(), this.hDJ);
            return;
        }
        this.hDH.closeActivity();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!ccZ()) {
            this.hDH.onActivityResult(i, i2, intent);
        } else if (this.hRK != null) {
            if (1 == this.hRK.getCurrentTabType()) {
                this.hDH.onActivityResult(i, i2, intent);
            } else {
                this.hRK.getCurrentFragment().onActivityResult(i, i2, intent);
            }
        }
        if (i2 == -1) {
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1) {
                    com.baidu.tieba.o.a.cYz().G(this.hRJ.getPageContext());
                    ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.linkUrl != null && this.hRN != null) {
                        this.hRN.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.10
                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void bcu() {
                            }

                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void a(final CustomDialogData customDialogData) {
                                com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.10.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (FrsTabController.this.hRJ != null) {
                                            com.baidu.tieba.pb.interactionpopupwindow.c.a(FrsTabController.this.hRJ.getPageContext(), customDialogData).show();
                                        }
                                    }
                                }, 1000L);
                            }
                        });
                    }
                }
            } else if (i == 13011) {
                com.baidu.tieba.o.a.cYz().G(this.hRJ.getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (!ccZ()) {
            return this.hDH.getVoiceManager();
        }
        if (this.hRK == null) {
            return null;
        }
        Fragment currentFragment = this.hRK.getCurrentFragment();
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
    public int uF(int i) {
        if (this.hDG == null) {
            return -1;
        }
        int count = w.getCount(this.hDG.bXE());
        for (int i2 = 0; i2 < count; i2++) {
            if (this.hDG.bXE().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int uH(int i) {
        if (this.hDG != null && i < w.getCount(this.hDG.bXE())) {
            return this.hDG.bXE().get(i).tab_id.intValue();
        }
        return -1;
    }

    public FrsFragment bXn() {
        return this.hDH;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> bXo() {
        if (!ccZ()) {
            if (this.hDH instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) this.hDH).bXo();
            }
        } else if (this.hRK == null) {
            return null;
        } else {
            Fragment currentFragment = this.hRK.getCurrentFragment();
            if (currentFragment instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) currentFragment).bXo();
            }
        }
        return null;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(s.hCZ);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.hRJ.isLoadingViewAttached()) {
            this.hRJ.hideLoadingView(this.hRJ.findViewById(16908290));
        }
        if (this.hSf != null) {
            com.baidu.adp.lib.f.e.lt().removeCallbacks(this.hSf);
        }
        com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean(this.hRM, false);
        if (this.hRN != null) {
            this.hRN.cancelLoadData();
        }
        if (this.hDH != null && this.hDH.bXV() != null) {
            this.hDH.bXV().cdm();
        }
        if (this.hRU != null) {
            this.hRU.onDestroy();
        }
    }

    public FragmentTabHost bZV() {
        if (this.hRK == null) {
            return null;
        }
        return this.hRK.bZV();
    }

    public boolean ccZ() {
        if (this.hRQ == null) {
            return false;
        }
        return this.hRQ.getItem(0) instanceof FrsTabHostFragment;
    }

    public void uJ(int i) {
        this.hDJ = i;
    }

    public void vt(int i) {
        this.hDK = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cda() {
        if (this.hRJ != null) {
            if (this.hRU == null) {
                this.hRU = (NavigationBarCoverTip) this.hRJ.findViewById(R.id.navigation_cover_tip);
            }
            if (this.hRU != null) {
                View inflate = View.inflate(this.hRJ, R.layout.write_thread_share_guide, null);
                TextView textView = (TextView) inflate.findViewById(R.id.write_thread_success_tips);
                TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) inflate.findViewById(R.id.share_icon);
                if (TextUtils.isEmpty(this.mForumName)) {
                    textView.setText("吧主您好，本吧考核新制度上线啦");
                } else {
                    textView.setText(this.mForumName + "吧吧主您好，本吧考核新制度上线啦");
                }
                tBSpecificationBtn.setTextSize(R.dimen.tbds34);
                tBSpecificationBtn.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.check_immediately));
                com.baidu.tbadk.core.view.commonBtn.d dVar = new com.baidu.tbadk.core.view.commonBtn.d();
                dVar.aYV();
                tBSpecificationBtn.setConfig(dVar);
                tBSpecificationBtn.aYj();
                an.setViewTextColor(textView, (int) R.color.cp_cont_a);
                an.setBackgroundColor(this.hRU, R.color.cp_link_tip_a_alpha95);
                tBSpecificationBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.11
                    /* JADX DEBUG: Multi-variable search result rejected for r4v9, resolved type: com.baidu.tieba.frs.FrsActivity */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        new ao("c13439").aWN();
                        if (FrsTabController.this.bXn() != null && !TextUtils.isEmpty(FrsTabController.this.bXn().getForumId()) && !TextUtils.isEmpty(FrsTabController.this.mForumName) && FrsTabController.this.hRJ != null) {
                            if (FrsTabController.this.hRU != null) {
                                FrsTabController.this.hRU.hideTip();
                            }
                            bc.aWU().b(FrsTabController.this.hRJ.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/bawutask?fid=" + FrsTabController.this.bXn().getForumId() + "&fn=" + FrsTabController.this.mForumName + "&noread=" + (com.baidu.tbadk.core.sharedPref.b.aVP().getInt("key_bawu_task_toast", 0) == -1 ? 1 : 0)});
                        }
                    }
                });
                this.hRU.a(this.hRJ, inflate, 30000);
                new ao("c13438").aWN();
                int i = com.baidu.tbadk.core.sharedPref.b.aVP().getInt("key_bawu_task_toast", 0);
                if (i >= 0) {
                    com.baidu.tbadk.core.sharedPref.b.aVP().putInt("key_bawu_task_toast", i + 1);
                }
            }
        }
    }

    private void cdb() {
        boolean z;
        if (this.hDI != null && this.hDI.getEntelechyTabInfo() != null && this.hDI.getEntelechyTabInfo().tab != null) {
            Iterator<FrsTabInfo> it = this.hDI.getEntelechyTabInfo().tab.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (it.next().tab_type.intValue() == 16) {
                    z = true;
                    break;
                }
            }
            if (z) {
                if (this.hRX == null) {
                    this.hRX = new e(this.hRJ.getPageContext(), this.hRR);
                    this.hRX.cS(R.drawable.pic_sign_tip_down);
                    this.hRX.sV(2);
                    this.hRX.setUseDirectOffset(true);
                    this.hRX.sZ(-com.baidu.adp.lib.util.l.getDimens(this.hRJ, R.dimen.tbds20));
                    this.hRX.setYOffset(-com.baidu.adp.lib.util.l.getDimens(this.hRJ, R.dimen.tbds20));
                    this.hRX.setTextColor(R.color.cp_cont_a);
                    this.hRX.setHeight(R.dimen.tbds54);
                    this.hRX.sX(com.baidu.adp.lib.util.l.getDimens(this.hRJ, R.dimen.tbds44));
                }
                this.hRX.aC(this.hRJ.getString(R.string.frs_evaluate_tip), "first_into_frs_with_evaluate_tab");
            }
        }
    }

    /* loaded from: classes9.dex */
    public class FragmentAdapter extends FragmentStatePagerAdapter {
        private List<BaseFragment> mFragments;

        public FragmentAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.mFragments = new ArrayList(2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v4.app.FragmentStatePagerAdapter
        /* renamed from: vu */
        public BaseFragment getItem(int i) {
            return (BaseFragment) w.getItem(this.mFragments, i);
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
            return w.add(this.mFragments, i, baseFragment);
        }

        public BaseFragment Fq(String str) {
            if (com.baidu.tbadk.core.util.ar.isEmpty(str)) {
                return null;
            }
            for (BaseFragment baseFragment : this.mFragments) {
                if (baseFragment != null && str.equals(baseFragment.getBaseTag())) {
                    return baseFragment;
                }
            }
            return null;
        }

        public BaseFragment vv(int i) {
            return (BaseFragment) w.remove(this.mFragments, i);
        }

        public String vw(int i) {
            if (getItem(i) != null) {
                return getItem(i).getBaseTag();
            }
            return null;
        }
    }

    public TbPageTag getTbPageTag() {
        if (!ccZ()) {
            return this.hDH.getTbPageTag();
        }
        if (this.hRK != null) {
            if (1 == this.hRK.getCurrentTabType()) {
                return this.hDH.getTbPageTag();
            }
            Fragment currentFragment = this.hRK.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                return ((BaseFragment) currentFragment).getTbPageTag();
            }
        }
        return null;
    }
}
