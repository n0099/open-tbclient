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
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.core.util.x;
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
/* loaded from: classes16.dex */
public class FrsTabController implements VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, FrsCommonImageLayout.c {
    public static final String hXG = FrsFragment.class.getSimpleName();
    public static final String hXH = FrsTabHostFragment.class.getSimpleName();
    private LinearLayout hFC;
    private ak hJE;
    private FrsFragment hJF;
    private m hJG;
    private int hJI;
    private FRSRefreshButton hJK;
    private FrsActivity hXI;
    private FrsTabHostFragment hXJ;
    private ShareSuccessReplyToServerModel hXM;
    private FrsBaseViewPager hXO;
    private FragmentAdapter hXP;
    private OvalActionButton hXQ;
    private boolean hXR;
    private boolean hXS;
    private NavigationBarCoverTip hXT;
    private e hXW;
    private String mForumName;
    private String mFrom;
    private boolean hXK = false;
    private final Handler mHandler = new Handler();
    private int hJH = 0;
    private boolean hXN = false;
    private boolean hXU = false;
    private boolean hXV = false;
    private HttpMessageListener hXX = new HttpMessageListener(CmdConfigHttp.CMD_FRS_RECOMMEND) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof FrsRecommendResMsg) {
                if (httpResponsedMessage.getError() != 0) {
                    new BdTopToast(FrsTabController.this.hXI).wd(false).Pr(httpResponsedMessage.getErrorString()).aF((ViewGroup) FrsTabController.this.hXI.findViewById(R.id.frs));
                    return;
                }
                int pushStatus = ((FrsRecommendResMsg) httpResponsedMessage).getPushStatus();
                String pushMsg = ((FrsRecommendResMsg) httpResponsedMessage).getPushMsg();
                if (pushStatus == 1) {
                    new ScreenTopToast(FrsTabController.this.hXI).Pv(FrsTabController.this.hXI.getString(R.string.frs_recommend_suc_tip_title)).Pw(FrsTabController.this.hXI.getString(R.string.frs_recommend_suc_tip_content)).Px(FrsTabController.this.hXI.getString(R.string.dialog_confirm_see)).aj(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.1.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("_forumId", FrsTabController.this.hJG.getForum().getId());
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new com.baidu.tieba.tbadkCore.data.m(FrsTabController.this.hXI, "RecommendHistoryPage", hashMap)));
                        }
                    }).aF((ViewGroup) FrsTabController.this.hXI.findViewById(R.id.frs));
                } else {
                    new BdTopToast(FrsTabController.this.hXI).wd(false).Pr(pushMsg).aF((ViewGroup) FrsTabController.this.hXI.findViewById(R.id.frs));
                }
            }
        }
    };
    private CustomMessageListener hXY = new CustomMessageListener(2921465) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            new ScreenTopToast(FrsTabController.this.hXI).Pv(FrsTabController.this.hXI.getString(R.string.frs_recommend_fail_month_tip)).Px(FrsTabController.this.hXI.getString(R.string.frs_recommend_fail_tip_btn)).aj(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.12.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("_forumId", FrsTabController.this.hJG.getForum().getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new com.baidu.tieba.tbadkCore.data.m(FrsTabController.this.hXI, "ForumGradePage", hashMap)));
                }
            }).aF((ViewGroup) FrsTabController.this.hXI.findViewById(R.id.frs));
        }
    };
    private com.baidu.adp.framework.listener.a hXZ = new com.baidu.adp.framework.listener.a(1001703, CmdConfigSocket.CMD_FRS_PAGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.13
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            m mVar = null;
            if (!FrsTabController.this.hXK && !responsedMessage.hasError() && responsedMessage.getError() == 0) {
                if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                    mVar = ((FrsPageHttpResponseMessage) responsedMessage).getResponseData();
                } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                    mVar = ((FRSPageSocketResponsedMessage) responsedMessage).getResponseData();
                }
                if (mVar != null) {
                    FrsTabController.this.hXK = true;
                    FrsTabController.this.a(mVar, true);
                    if (mVar != null && mVar.getForum() != null && !StringUtils.isNull(mVar.getForum().getId())) {
                        com.baidu.tbadk.core.business.a.aTH().dd("2", mVar.getForum().getId());
                    }
                }
                if (mVar != null && mVar.getUserData() != null && mVar.getUserData().getNewGodData() != null) {
                    if (mVar.getForum() != null) {
                        v.bmO().setFid(mVar.getForum().getId());
                    }
                    v.bmO().b(2, mVar.getUserData().getNewGodData());
                }
            }
        }
    };
    private CustomMessageListener hYa = new CustomMessageListener(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!FrsTabController.this.hXK && FrsTabController.this.hJG == null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof m)) {
                m mVar = (m) customResponsedMessage.getData();
                if (mVar.getForum() != null && FrsTabController.this.mForumName != null && FrsTabController.this.mForumName.equals(mVar.getForum().getName())) {
                    FrsTabController.this.a(mVar, false);
                }
            }
        }
    };
    private CustomMessageListener hYb = new CustomMessageListener(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsTabController.this.cgx();
        }
    };
    private CustomMessageListener hYc = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int uX;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (10001 == intValue) {
                    uX = FrsTabController.this.uX(9);
                    if (uX == -1) {
                        uX = FrsTabController.this.uX(2);
                    }
                } else {
                    uX = FrsTabController.this.uX(intValue);
                }
                if (uX != -1 && FrsTabController.this.cgy() && FrsTabController.this.hXJ != null) {
                    FrsTabController.this.hXJ.setCurrentTab(uX);
                    if (FrsTabController.this.uZ(uX) != 1) {
                        FrsTabController.this.hJF.nE(false);
                    }
                }
            }
        }
    };
    private HttpMessageListener hYd = new HttpMessageListener(0) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && 1021074 == httpResponsedMessage.getCmd() && (httpResponsedMessage instanceof AlaGameTabGetNewNotifyResponsedMessage)) {
                List<a> newNotifyData = ((AlaGameTabGetNewNotifyResponsedMessage) httpResponsedMessage).getNewNotifyData();
                if (!x.isEmpty(newNotifyData) && FrsTabController.this.hXJ != null) {
                    for (a aVar : newNotifyData) {
                        if (aVar != null) {
                            for (int i = 0; i < FrsTabController.this.hJE.cba().size(); i++) {
                                FragmentTabHost.b lF = FrsTabController.this.hXJ.lF(i);
                                if (lF != null && lF.mType != 1 && lF.mType != FrsTabController.this.hXJ.getCurrentTabType() && lF.mType == aVar.getTabId() && aVar.cgq() && lF.dYX.zY(String.valueOf(lF.mType)) != null) {
                                    lF.dYX.zY(String.valueOf(lF.mType)).view.setVisibility(0);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private Runnable hYe = new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.18
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.adp.lib.f.e.lt().removeCallbacks(this);
            FrsTabController.this.cgw();
            com.baidu.adp.lib.f.e.lt().postDelayed(this, 30000L);
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                FrsTabController.this.hXN = true;
            }
        }
    };
    private CustomMessageListener hYf = new CustomMessageListener(2921369) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.hXO != null && FrsTabController.this.hXP != null && (customResponsedMessage.getData() instanceof FrsTabViewPager.a)) {
                FrsTabViewPager.a aVar = (FrsTabViewPager.a) customResponsedMessage.getData();
                FrsTabController.this.hXR = aVar.cdz();
                FrsTabController.this.hXS = aVar.cdA();
            }
        }
    };
    private CustomMessageListener hYg = new CustomMessageListener(2921370) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.hXO != null && FrsTabController.this.hXP != null && (customResponsedMessage.getData() instanceof Boolean)) {
                FrsTabController.this.hXO.setForceIntercept(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };
    private ViewPager.OnPageChangeListener hYh = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.4
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i != 1) {
                FrsTabController.this.hXQ.setVisibility(0);
                if (FrsTabController.this.caI() != null) {
                    FrsTabController.this.caI().ny(false);
                }
                FrsTabController.this.hJF.cbY();
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            switch (i) {
                case 0:
                    FrsTabController.this.hXS = false;
                    FrsTabController.this.hXO.setForceIntercept(false);
                    return;
                default:
                    return;
            }
        }
    };
    private FrsBaseViewPager.a hYi = new FrsBaseViewPager.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.5
        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public void cbe() {
            if (FrsTabController.this.hXO != null) {
                if (FrsTabController.this.hXO.getCurrentItem() == 0) {
                    FrsTabController.this.hXO.setmDisallowSlip(true);
                } else {
                    FrsTabController.this.hXO.setmDisallowSlip(false);
                }
            }
        }

        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public boolean cbf() {
            if (FrsTabController.this.hXO.getCurrentItem() == 0) {
                if (FrsTabController.this.hXR && FrsTabController.this.hXS) {
                    FrsTabController.this.hXO.setmDisallowSlip(false);
                }
                if (!FrsTabController.this.hXS) {
                    FrsTabController.this.hXO.setmDisallowSlip(true);
                }
                FrsTabController.this.hXO.setmDisallowSlip(true);
            } else {
                FrsTabController.this.hXO.setmDisallowSlip(true);
            }
            return true;
        }
    };
    private String hXL = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.SHOW_GAME_FOREM_TAB_HOT_POINT);

    public FrsTabController(FrsActivity frsActivity) {
        this.hXI = frsActivity;
    }

    public void init(Bundle bundle) {
        if (this.hXI != null) {
            this.hXI.setContentView(R.layout.frs_base_layout);
            this.hXO = (FrsBaseViewPager) this.hXI.findViewById(R.id.frs_base_viewpager);
            this.hXP = new FragmentAdapter(this.hXI.getSupportFragmentManager());
            this.hXO.setAdapter(this.hXP);
            this.hXO.setPageTransformer(true, new CubeOutViewPagerTransformer());
            this.hXO.addOnPageChangeListener(this.hYh);
            this.hXO.setmDisallowSlip(true);
            this.hXO.setOnTouchEventListener(this.hYi);
            this.hXQ = (OvalActionButton) this.hXI.findViewById(R.id.frs_post_forum_button);
            this.hXQ.setIsCircle(true);
            this.hXQ.setHasShadow(false);
            this.hJK = (FRSRefreshButton) this.hXI.findViewById(R.id.frs_refresh_forum_button);
            this.hFC = (LinearLayout) this.hXI.findViewById(R.id.frs_ll_redpack);
            this.hXI.registerListener(this.hYf);
            this.hXI.registerListener(this.hYg);
            this.hXZ.getHttpMessageListener().setPriority(-1);
            this.hXZ.getSocketMessageListener().setPriority(-1);
            this.hXI.registerListener(this.hYa);
            this.hYc.setSelfListener(true);
            this.hXI.registerListener(this.hYc);
            this.hYb.setSelfListener(true);
            this.hXI.registerListener(this.hYb);
            this.hXI.registerListener(this.mAccountChangedListener);
            if (bundle == null) {
                this.mForumName = this.hXI.getIntent().getStringExtra("name");
                this.mFrom = this.hXI.getIntent().getStringExtra("from");
                this.hJH = this.hXI.getIntent().getIntExtra(FrsActivityConfig.FRS_GAME_DEFAULT_TAB_ID, 0);
            } else {
                this.mForumName = bundle.getString("name");
                this.mFrom = bundle.getString("from");
                this.hJH = bundle.getInt("default_tab_id", 0);
            }
            ao(bundle);
            this.hXP.notifyDataSetChanged();
            this.hXM = new ShareSuccessReplyToServerModel();
            this.hXI.registerListener(this.hXZ);
            this.hXI.registerListener(this.hXX);
            this.hXI.registerListener(this.hXY);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.mForumName);
        bundle.putInt("default_tab_id", this.hJH);
        bundle.putString("from", this.mFrom);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ao(Bundle bundle) {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.hXP != null) {
            try {
                FrsFragment frsFragment = (FrsFragment) this.hXP.Gc(hXG);
                if (frsFragment == null) {
                    frsFragment = ap(bundle);
                }
                frsFragment.b(this.hXQ);
                frsFragment.a(this.hJK);
                frsFragment.c(this.hFC);
                if (!hXG.equals(this.hXP.vO(0))) {
                    if (hXH.equals(this.hXP.vO(0))) {
                        this.hXP.vN(0);
                    }
                    this.hXP.a(0, frsFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgr() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.hXP != null) {
            try {
                FrsTabHostFragment frsTabHostFragment = (FrsTabHostFragment) this.hXP.Gc(hXH);
                if (frsTabHostFragment == null) {
                    frsTabHostFragment = cgs();
                }
                frsTabHostFragment.b(this.hXQ);
                frsTabHostFragment.b(this.hJK);
                if (!hXH.equals(this.hXP.vO(0))) {
                    if (hXG.equals(this.hXP.vO(0))) {
                        this.hXP.vN(0);
                    }
                    this.hXP.a(0, frsTabHostFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private FrsFragment ap(Bundle bundle) {
        if (this.hJF == null) {
            this.hJF = new FrsFragment();
            this.hJF.setArguments(bundle);
            this.hJF.setBaseTag(hXG);
        }
        this.hJF.hFJ = false;
        return this.hJF;
    }

    private FrsTabHostFragment cgs() {
        if (this.hXJ == null) {
            this.hXJ = new FrsTabHostFragment(this);
            this.hXJ.setBaseTag(hXH);
            this.hXJ.vb(this.hJH);
        }
        return this.hXJ;
    }

    private FragmentManager getFragmentManager() {
        if (this.hXI != null) {
            return this.hXI.getSupportFragmentManager();
        }
        return null;
    }

    private void cgt() {
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.hJG != null && (themeColorInfo = this.hJG.getForum().getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            this.hXQ.setStartAndEndColor(themeElement.light_color, themeElement.dark_color);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(m mVar, boolean z) {
        if (mVar != null && mVar.getForum() != null) {
            ForumData forum = mVar.getForum();
            if (forum.getIsShowBawuTask() && com.baidu.tbadk.core.sharedPref.b.aZP().getInt("key_bawu_task_toast", 0) == 0 && !this.hXU) {
                this.hXU = true;
                com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.6
                    @Override // java.lang.Runnable
                    public void run() {
                        FrsTabController.this.cgz();
                    }
                }, 30000L);
            }
            if (mVar.bazhuExam != null && !this.hXV && z) {
                l.a(this.hXI.getPageContext(), mVar.bazhuExam, forum.getId(), forum.getName());
                this.hXV = true;
            }
            this.hJG = mVar;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921476));
            if (x.getCount(mVar.getGameTabInfo()) > 0) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.7
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean cJ = FrsTabController.this.cJ(FrsTabController.this.hJG.getGameTabInfo());
                        if (cJ) {
                            FrsTabController.this.hXP.notifyDataSetChanged();
                            if (cJ && FrsTabController.this.hXJ != null) {
                                FrsTabController.this.hXJ.Y(FrsTabController.this.hJF);
                                FrsTabController.this.hXJ.a(FrsTabController.this.hJG, FrsTabController.this.hJE);
                            }
                        }
                        if (FrsTabController.this.hXI.isLoadingViewAttached()) {
                            FrsTabController.this.hXI.hideLoadingView(FrsTabController.this.hXI.findViewById(16908290));
                        }
                    }
                });
            } else if (cgy()) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.8
                    @Override // java.lang.Runnable
                    public void run() {
                        Bundle bundle;
                        FrsTabController.this.hJF.hFJ = true;
                        if (FrsTabController.this.hJF != null) {
                            bundle = FrsTabController.this.hJF.getArguments();
                        } else {
                            bundle = null;
                        }
                        FrsTabController.this.ao(bundle);
                        FrsTabController.this.hXP.notifyDataSetChanged();
                        if (FrsTabController.this.hXI.isLoadingViewAttached()) {
                            FrsTabController.this.hXI.hideLoadingView(FrsTabController.this.hXI.findViewById(16908290));
                        }
                    }
                });
            }
            cgt();
            cgA();
        }
    }

    public m cgu() {
        return this.hJG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cJ(List<FrsTabInfo> list) {
        if (this.hXI.isLoadingViewAttached()) {
            this.hXI.hideLoadingView(this.hXI.findViewById(16908290));
        }
        if (cgy()) {
            return false;
        }
        this.hJF.hFJ = true;
        cgv();
        if (com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean("frs_game_login_tip", true)) {
            com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean(SharedPrefConfig.FRS_LOGIN_TIP, true);
            com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean("frs_game_login_tip", false);
        }
        cK(list);
        return true;
    }

    private void cgv() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021074, TbConfig.SERVER_ADDRESS + "game/forum/getNewNotify");
        tbHttpMessageTask.setResponsedClass(AlaGameTabGetNewNotifyResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.hXI.registerListener(1021074, this.hYd);
    }

    private void cK(List<FrsTabInfo> list) {
        boolean z;
        if (!x.isEmpty(list)) {
            CustomMessageListener customMessageListener = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.9
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ak)) {
                        if (!com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean(FrsTabController.this.hXL, true)) {
                            com.baidu.adp.lib.f.e.lt().post(FrsTabController.this.hYe);
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
                                bundle.putString("name", FrsTabController.this.hJF.getForumName());
                                bundle.putString("from", FrsTabController.this.hJF.getFrom());
                                bundle.putString("forum_id", FrsTabController.this.hJF.getForumId());
                                bundle.putInt("tab_id", 503);
                                bundle.putBoolean("can_auto_play_video", FrsTabController.this.hJG.isFrsVideoAutoPlay);
                                bundle.putBoolean("need_log", FrsTabController.this.hJG.needLog == 1);
                                bundle.putBoolean("is_brand_forum", FrsTabController.this.hJG.isBrandForum);
                                FrsViewData frsViewData = new FrsViewData();
                                frsViewData.receiveData(FrsTabController.this.hJG);
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
                        FrsTabController.this.cgr();
                    }
                }
            };
            customMessageListener.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            customMessageListener.setSelfListener(true);
            this.hXI.registerListener(customMessageListener);
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
            this.hJE = new ak(this.hXI.getActivity(), arrayList);
            if (caI() != null) {
                this.hJE.setForumId(caI().getForumId());
                this.hJE.setForumName(caI().getForumName());
                if (caI().cbZ() != null && caI().cbZ().getForum() != null) {
                    ForumData forum = caI().cbZ().getForum();
                    this.hJE.setForumGameLabel(forum.getForumGameLabel());
                    this.hJE.Ej(forum.getSpecialForumType());
                }
            }
            this.hJF.hFJ = false;
            new d(this.hJF).a(this.hJE);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB, this.hJE);
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB);
            customMessage.setTag(this.hXI.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgw() {
        if (this.hJE != null && !TextUtils.isEmpty(this.hJE.getForumId())) {
            HttpMessage httpMessage = new HttpMessage(1021074);
            httpMessage.addParam("forum_id", this.hJG.getForum().getId());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    private void a(Fragment fragment, int i) {
        NavigationBar bAm;
        if ((fragment instanceof ar) && this.hJG != null && this.hJG.getForum() != null && (bAm = ((ar) fragment).bAm()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.hJG.getForum().getName(), 5, true, true) + this.hXI.getActivity().getString(R.string.forum));
            bAm.setCenterTextTitle(sb.toString());
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.hJF instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.hJF.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a pE(int i) {
        if (this.hJF instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.hJF.pE(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.hJF instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.hJF.a(bVar);
        }
    }

    public void onNewIntent(Intent intent) {
        if (this.hJF != null) {
            this.hJF.onNewIntent(intent);
        }
    }

    public void onResume() {
        if (!cgy()) {
            this.hJF.setPrimary(true);
        } else if (this.hXJ != null) {
            Fragment currentFragment = this.hXJ.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(true);
            }
        }
        if (this.hXN) {
            this.hXN = false;
            if (this.hJF != null) {
                this.hJF.refresh();
            }
        }
        if (this.hJG != null && this.hJG.getUserData() != null && this.hJG.getUserData().getNewGodData() != null) {
            if (this.hJG.getForum() != null) {
                v.bmO().setFid(this.hJG.getForum().getId());
            }
            v.bmO().b(2, this.hJG.getUserData().getNewGodData());
        }
    }

    public void onPause() {
        if (!cgy()) {
            this.hJF.setPrimary(false);
        } else if (this.hXJ != null) {
            Fragment currentFragment = this.hXJ.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(false);
            }
        }
        v.bmO().removeCallbacks();
    }

    public void onChangeSkinType(int i) {
        UtilHelper.changeStatusBarIconAndTextColor(true, this.hXI);
        if (this.hJF != null) {
            this.hJF.onChangeSkinType(i);
        }
        if (this.hXJ != null) {
            this.hXJ.onChangeSkinType(i);
        }
        cgt();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (cgy() && this.hXJ != null && this.hXJ.cdg()) {
                this.hXJ.cdu();
                UtilHelper.setNavigationBarBackground(this.hXI, this.hXJ.cdp());
            } else if (this.hJF != null && this.hJF.isAdded()) {
                if (this.hJF.onKeyDown(i, keyEvent)) {
                    return true;
                }
                cgx();
            } else {
                return this.hXI.b(i, keyEvent);
            }
        } else if (i == 24) {
            if (this.hJF != null && this.hJF.isAdded()) {
                return this.hJF.onKeyDown(i, keyEvent);
            }
        } else {
            return this.hXI.b(i, keyEvent);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgx() {
        if (this.hJI != this.hJH && cgy()) {
            this.hXJ.setCurrentTab(this.hJH);
            if (uZ(this.hJH) != 1) {
                this.hJF.nE(false);
            }
            this.hJI = this.hJH;
            a(this.hXJ.getCurrentFragment(), this.hJH);
            return;
        }
        this.hJF.closeActivity();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!cgy()) {
            this.hJF.onActivityResult(i, i2, intent);
        } else if (this.hXJ != null) {
            if (1 == this.hXJ.getCurrentTabType()) {
                this.hJF.onActivityResult(i, i2, intent);
            } else {
                this.hXJ.getCurrentFragment().onActivityResult(i, i2, intent);
            }
        }
        if (i2 == -1) {
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1) {
                    com.baidu.tieba.o.a.dbG().F(this.hXI.getPageContext());
                    ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.linkUrl != null && this.hXM != null) {
                        this.hXM.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.10
                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void bgn() {
                            }

                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void a(final CustomDialogData customDialogData) {
                                com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.10.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (FrsTabController.this.hXI != null) {
                                            com.baidu.tieba.pb.interactionpopupwindow.c.a(FrsTabController.this.hXI.getPageContext(), customDialogData).show();
                                        }
                                    }
                                }, 1000L);
                            }
                        });
                    }
                }
            } else if (i == 13011) {
                com.baidu.tieba.o.a.dbG().F(this.hXI.getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (!cgy()) {
            return this.hJF.getVoiceManager();
        }
        if (this.hXJ == null) {
            return null;
        }
        Fragment currentFragment = this.hXJ.getCurrentFragment();
        if (currentFragment instanceof VoiceManager.c) {
            return ((VoiceManager.c) currentFragment).getVoiceManager();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int uX(int i) {
        if (this.hJE == null) {
            return -1;
        }
        int count = x.getCount(this.hJE.cba());
        for (int i2 = 0; i2 < count; i2++) {
            if (this.hJE.cba().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int uZ(int i) {
        if (this.hJE != null && i < x.getCount(this.hJE.cba())) {
            return this.hJE.cba().get(i).tab_id.intValue();
        }
        return -1;
    }

    public FrsFragment caI() {
        return this.hJF;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> caJ() {
        if (!cgy()) {
            if (this.hJF instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) this.hJF).caJ();
            }
        } else if (this.hXJ == null) {
            return null;
        } else {
            Fragment currentFragment = this.hXJ.getCurrentFragment();
            if (currentFragment instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) currentFragment).caJ();
            }
        }
        return null;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(s.hIX);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.hXI.isLoadingViewAttached()) {
            this.hXI.hideLoadingView(this.hXI.findViewById(16908290));
        }
        if (this.hYe != null) {
            com.baidu.adp.lib.f.e.lt().removeCallbacks(this.hYe);
        }
        com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean(this.hXL, false);
        if (this.hXM != null) {
            this.hXM.cancelLoadData();
        }
        if (this.hJF != null && this.hJF.cbr() != null) {
            this.hJF.cbr().cgL();
        }
        if (this.hXT != null) {
            this.hXT.onDestroy();
        }
        if (FrsActivityConfig.FRS_FROM_FLUTTER_BCASTEDIT.equals(this.mFrom)) {
            new o(TbadkCoreApplication.getInst()).bae();
        }
    }

    public FragmentTabHost cds() {
        if (this.hXJ == null) {
            return null;
        }
        return this.hXJ.cds();
    }

    public boolean cgy() {
        if (this.hXP == null) {
            return false;
        }
        return this.hXP.getItem(0) instanceof FrsTabHostFragment;
    }

    public void vb(int i) {
        this.hJH = i;
    }

    public void vL(int i) {
        this.hJI = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgz() {
        if (this.hXI != null) {
            if (this.hXT == null) {
                this.hXT = (NavigationBarCoverTip) this.hXI.findViewById(R.id.navigation_cover_tip);
            }
            if (this.hXT != null) {
                View inflate = View.inflate(this.hXI, R.layout.write_thread_share_guide, null);
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
                dVar.bcS();
                tBSpecificationBtn.setConfig(dVar);
                tBSpecificationBtn.bci();
                ao.setViewTextColor(textView, R.color.cp_cont_a);
                ao.setBackgroundColor(this.hXT, R.color.cp_link_tip_a_alpha95);
                tBSpecificationBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.11
                    /* JADX DEBUG: Multi-variable search result rejected for r4v9, resolved type: com.baidu.tieba.frs.FrsActivity */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        new ap("c13439").baO();
                        if (FrsTabController.this.caI() != null && !TextUtils.isEmpty(FrsTabController.this.caI().getForumId()) && !TextUtils.isEmpty(FrsTabController.this.mForumName) && FrsTabController.this.hXI != null) {
                            if (FrsTabController.this.hXT != null) {
                                FrsTabController.this.hXT.hideTip();
                            }
                            bd.baV().b(FrsTabController.this.hXI.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/bawutask?fid=" + FrsTabController.this.caI().getForumId() + "&fn=" + FrsTabController.this.mForumName + "&noread=" + (com.baidu.tbadk.core.sharedPref.b.aZP().getInt("key_bawu_task_toast", 0) == -1 ? 1 : 0)});
                        }
                    }
                });
                this.hXT.a(this.hXI, inflate, 30000);
                new ap("c13438").baO();
                int i = com.baidu.tbadk.core.sharedPref.b.aZP().getInt("key_bawu_task_toast", 0);
                if (i >= 0) {
                    com.baidu.tbadk.core.sharedPref.b.aZP().putInt("key_bawu_task_toast", i + 1);
                }
            }
        }
    }

    private void cgA() {
        boolean z;
        if (this.hJG != null && this.hJG.getEntelechyTabInfo() != null && this.hJG.getEntelechyTabInfo().tab != null) {
            Iterator<FrsTabInfo> it = this.hJG.getEntelechyTabInfo().tab.iterator();
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
                if (this.hXW == null) {
                    this.hXW = new e(this.hXI.getPageContext(), this.hXQ);
                    this.hXW.cS(R.drawable.pic_sign_tip_down);
                    this.hXW.tn(2);
                    this.hXW.setUseDirectOffset(true);
                    this.hXW.tr(-com.baidu.adp.lib.util.l.getDimens(this.hXI, R.dimen.tbds20));
                    this.hXW.setYOffset(-com.baidu.adp.lib.util.l.getDimens(this.hXI, R.dimen.tbds20));
                    this.hXW.setTextColor(R.color.cp_cont_a);
                    this.hXW.setHeight(R.dimen.tbds54);
                    this.hXW.tp(com.baidu.adp.lib.util.l.getDimens(this.hXI, R.dimen.tbds44));
                }
                this.hXW.aC(this.hXI.getString(R.string.frs_evaluate_tip), "first_into_frs_with_evaluate_tab");
            }
        }
    }

    /* loaded from: classes16.dex */
    public class FragmentAdapter extends FragmentStatePagerAdapter {
        private List<BaseFragment> mFragments;

        public FragmentAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.mFragments = new ArrayList(2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v4.app.FragmentStatePagerAdapter
        /* renamed from: vM */
        public BaseFragment getItem(int i) {
            return (BaseFragment) x.getItem(this.mFragments, i);
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
            return x.add(this.mFragments, i, baseFragment);
        }

        public BaseFragment Gc(String str) {
            if (as.isEmpty(str)) {
                return null;
            }
            for (BaseFragment baseFragment : this.mFragments) {
                if (baseFragment != null && str.equals(baseFragment.getBaseTag())) {
                    return baseFragment;
                }
            }
            return null;
        }

        public BaseFragment vN(int i) {
            return (BaseFragment) x.remove(this.mFragments, i);
        }

        public String vO(int i) {
            if (getItem(i) != null) {
                return getItem(i).getBaseTag();
            }
            return null;
        }
    }

    public TbPageTag getTbPageTag() {
        if (!cgy()) {
            return this.hJF.getTbPageTag();
        }
        if (this.hXJ != null) {
            if (1 == this.hXJ.getCurrentTabType()) {
                return this.hJF.getTbPageTag();
            }
            Fragment currentFragment = this.hXJ.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                return ((BaseFragment) currentFragment).getTbPageTag();
            }
        }
        return null;
    }
}
