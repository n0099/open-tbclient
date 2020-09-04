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
import com.baidu.adp.lib.util.l;
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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.core.util.y;
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
import com.baidu.tieba.frs.am;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment;
import com.baidu.tieba.frs.t;
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
    public static final String ilV = FrsFragment.class.getSimpleName();
    public static final String ilW = FrsTabHostFragment.class.getSimpleName();
    private LinearLayout hSY;
    private am hXj;
    private FrsFragment hXk;
    private m hXl;
    private int hXn;
    private FRSRefreshButton hXp;
    private FrsActivity ilX;
    private FrsTabHostFragment ilY;
    private ShareSuccessReplyToServerModel imb;
    private FrsBaseViewPager imd;
    private FragmentAdapter ime;
    private OvalActionButton imf;
    private boolean imh;
    private boolean imi;
    private NavigationBarCoverTip imj;
    private e imm;
    private String mForumName;
    private String mFrom;
    private boolean ilZ = false;
    private final Handler mHandler = new Handler();
    private int hXm = 0;
    private boolean imc = false;
    private boolean imk = false;
    private boolean iml = false;
    private HttpMessageListener imn = new HttpMessageListener(CmdConfigHttp.CMD_FRS_RECOMMEND) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof FrsRecommendResMsg) {
                if (httpResponsedMessage.getError() != 0) {
                    new BdTopToast(FrsTabController.this.ilX).wU(false).Sp(httpResponsedMessage.getErrorString()).aE((ViewGroup) FrsTabController.this.ilX.findViewById(R.id.frs));
                    return;
                }
                int pushStatus = ((FrsRecommendResMsg) httpResponsedMessage).getPushStatus();
                String pushMsg = ((FrsRecommendResMsg) httpResponsedMessage).getPushMsg();
                if (pushStatus == 1) {
                    new ScreenTopToast(FrsTabController.this.ilX).St(FrsTabController.this.ilX.getString(R.string.frs_recommend_suc_tip_title)).Su(FrsTabController.this.ilX.getString(R.string.frs_recommend_suc_tip_content)).Sv(FrsTabController.this.ilX.getString(R.string.dialog_confirm_see)).ak(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.1.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("_forumId", FrsTabController.this.hXl.getForum().getId());
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new com.baidu.tieba.tbadkCore.data.m(FrsTabController.this.ilX, "RecommendHistoryPage", hashMap)));
                        }
                    }).aE((ViewGroup) FrsTabController.this.ilX.findViewById(R.id.frs));
                } else {
                    new BdTopToast(FrsTabController.this.ilX).wU(false).Sp(pushMsg).aE((ViewGroup) FrsTabController.this.ilX.findViewById(R.id.frs));
                }
            }
        }
    };
    private CustomMessageListener imo = new CustomMessageListener(2921465) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            new ScreenTopToast(FrsTabController.this.ilX).St(FrsTabController.this.ilX.getString(R.string.frs_recommend_fail_month_tip)).Sv(FrsTabController.this.ilX.getString(R.string.frs_recommend_fail_tip_btn)).ak(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.12.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("_forumId", FrsTabController.this.hXl.getForum().getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new com.baidu.tieba.tbadkCore.data.m(FrsTabController.this.ilX, "ForumGradePage", hashMap)));
                }
            }).aE((ViewGroup) FrsTabController.this.ilX.findViewById(R.id.frs));
        }
    };
    private com.baidu.adp.framework.listener.a imp = new com.baidu.adp.framework.listener.a(1001703, CmdConfigSocket.CMD_FRS_PAGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.13
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            m mVar = null;
            if (!FrsTabController.this.ilZ && !responsedMessage.hasError() && responsedMessage.getError() == 0) {
                if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                    mVar = ((FrsPageHttpResponseMessage) responsedMessage).getResponseData();
                } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                    mVar = ((FRSPageSocketResponsedMessage) responsedMessage).getResponseData();
                }
                if (mVar != null) {
                    FrsTabController.this.ilZ = true;
                    FrsTabController.this.a(mVar, true);
                    if (mVar != null && mVar.getForum() != null && !StringUtils.isNull(mVar.getForum().getId())) {
                        com.baidu.tbadk.core.business.a.bbY().dt("2", mVar.getForum().getId());
                    }
                }
                if (mVar != null && mVar.getUserData() != null && mVar.getUserData().getNewGodData() != null) {
                    if (mVar.getForum() != null) {
                        v.bvC().setFid(mVar.getForum().getId());
                    }
                    v.bvC().b(2, mVar.getUserData().getNewGodData());
                }
            }
        }
    };
    private CustomMessageListener imq = new CustomMessageListener(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!FrsTabController.this.ilZ && FrsTabController.this.hXl == null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof m)) {
                m mVar = (m) customResponsedMessage.getData();
                if (mVar.getForum() != null && FrsTabController.this.mForumName != null && FrsTabController.this.mForumName.equals(mVar.getForum().getName())) {
                    FrsTabController.this.a(mVar, false);
                }
            }
        }
    };
    private CustomMessageListener imr = new CustomMessageListener(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsTabController.this.crd();
        }
    };
    private CustomMessageListener ims = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int xo;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (10001 == intValue) {
                    xo = FrsTabController.this.xo(9);
                    if (xo == -1) {
                        xo = FrsTabController.this.xo(2);
                    }
                } else {
                    xo = FrsTabController.this.xo(intValue);
                }
                if (xo != -1 && FrsTabController.this.cre() && FrsTabController.this.ilY != null) {
                    FrsTabController.this.ilY.setCurrentTab(xo);
                    if (FrsTabController.this.xq(xo) != 1) {
                        FrsTabController.this.hXk.ok(false);
                    }
                }
            }
        }
    };
    private HttpMessageListener imt = new HttpMessageListener(0) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && 1021074 == httpResponsedMessage.getCmd() && (httpResponsedMessage instanceof AlaGameTabGetNewNotifyResponsedMessage)) {
                List<a> newNotifyData = ((AlaGameTabGetNewNotifyResponsedMessage) httpResponsedMessage).getNewNotifyData();
                if (!y.isEmpty(newNotifyData) && FrsTabController.this.ilY != null) {
                    for (a aVar : newNotifyData) {
                        if (aVar != null) {
                            for (int i = 0; i < FrsTabController.this.hXj.clx().size(); i++) {
                                FragmentTabHost.b nL = FrsTabController.this.ilY.nL(i);
                                if (nL != null && nL.mType != 1 && nL.mType != FrsTabController.this.ilY.getCurrentTabType() && nL.mType == aVar.getTabId() && aVar.cqW() && nL.eiH.Cp(String.valueOf(nL.mType)) != null) {
                                    nL.eiH.Cp(String.valueOf(nL.mType)).view.setVisibility(0);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private Runnable imu = new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.18
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.adp.lib.f.e.mS().removeCallbacks(this);
            FrsTabController.this.crc();
            com.baidu.adp.lib.f.e.mS().postDelayed(this, 30000L);
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                FrsTabController.this.imc = true;
            }
        }
    };
    private CustomMessageListener imv = new CustomMessageListener(2921369) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.imd != null && FrsTabController.this.ime != null && (customResponsedMessage.getData() instanceof FrsTabViewPager.a)) {
                FrsTabViewPager.a aVar = (FrsTabViewPager.a) customResponsedMessage.getData();
                FrsTabController.this.imh = aVar.cnZ();
                FrsTabController.this.imi = aVar.coa();
            }
        }
    };
    private CustomMessageListener imw = new CustomMessageListener(2921370) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.imd != null && FrsTabController.this.ime != null && (customResponsedMessage.getData() instanceof Boolean)) {
                FrsTabController.this.imd.setForceIntercept(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };
    private ViewPager.OnPageChangeListener imx = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.4
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i != 1) {
                FrsTabController.this.imf.setVisibility(0);
                if (FrsTabController.this.clf() != null) {
                    FrsTabController.this.clf().oe(false);
                }
                FrsTabController.this.hXk.cmw();
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            switch (i) {
                case 0:
                    FrsTabController.this.imi = false;
                    FrsTabController.this.imd.setForceIntercept(false);
                    return;
                default:
                    return;
            }
        }
    };
    private FrsBaseViewPager.a imy = new FrsBaseViewPager.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.5
        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public void clB() {
            if (FrsTabController.this.imd != null) {
                if (FrsTabController.this.imd.getCurrentItem() == 0) {
                    FrsTabController.this.imd.setmDisallowSlip(true);
                } else {
                    FrsTabController.this.imd.setmDisallowSlip(false);
                }
            }
        }

        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public boolean clC() {
            if (FrsTabController.this.imd.getCurrentItem() == 0) {
                if (FrsTabController.this.imh && FrsTabController.this.imi) {
                    FrsTabController.this.imd.setmDisallowSlip(false);
                }
                if (!FrsTabController.this.imi) {
                    FrsTabController.this.imd.setmDisallowSlip(true);
                }
                FrsTabController.this.imd.setmDisallowSlip(true);
            } else {
                FrsTabController.this.imd.setmDisallowSlip(true);
            }
            return true;
        }
    };
    private String ima = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.SHOW_GAME_FOREM_TAB_HOT_POINT);

    public FrsTabController(FrsActivity frsActivity) {
        this.ilX = frsActivity;
    }

    public void init(Bundle bundle) {
        if (this.ilX != null) {
            this.ilX.setContentView(R.layout.frs_base_layout);
            this.imd = (FrsBaseViewPager) this.ilX.findViewById(R.id.frs_base_viewpager);
            this.ime = new FragmentAdapter(this.ilX.getSupportFragmentManager());
            this.imd.setAdapter(this.ime);
            this.imd.setPageTransformer(true, new CubeOutViewPagerTransformer());
            this.imd.addOnPageChangeListener(this.imx);
            this.imd.setmDisallowSlip(true);
            this.imd.setOnTouchEventListener(this.imy);
            this.imf = (OvalActionButton) this.ilX.findViewById(R.id.frs_post_forum_button);
            this.imf.setIsCircle(true);
            this.imf.setHasShadow(false);
            this.hXp = (FRSRefreshButton) this.ilX.findViewById(R.id.frs_refresh_forum_button);
            this.hSY = (LinearLayout) this.ilX.findViewById(R.id.frs_ll_redpack);
            this.ilX.registerListener(this.imv);
            this.ilX.registerListener(this.imw);
            this.imp.getHttpMessageListener().setPriority(-1);
            this.imp.getSocketMessageListener().setPriority(-1);
            this.ilX.registerListener(this.imq);
            this.ims.setSelfListener(true);
            this.ilX.registerListener(this.ims);
            this.imr.setSelfListener(true);
            this.ilX.registerListener(this.imr);
            this.ilX.registerListener(this.mAccountChangedListener);
            if (bundle == null) {
                this.mForumName = this.ilX.getIntent().getStringExtra("name");
                this.mFrom = this.ilX.getIntent().getStringExtra("from");
                this.hXm = this.ilX.getIntent().getIntExtra(FrsActivityConfig.FRS_GAME_DEFAULT_TAB_ID, 0);
            } else {
                this.mForumName = bundle.getString("name");
                this.mFrom = bundle.getString("from");
                this.hXm = bundle.getInt("default_tab_id", 0);
            }
            an(bundle);
            this.ime.notifyDataSetChanged();
            this.imb = new ShareSuccessReplyToServerModel();
            this.ilX.registerListener(this.imp);
            this.ilX.registerListener(this.imn);
            this.ilX.registerListener(this.imo);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.mForumName);
        bundle.putInt("default_tab_id", this.hXm);
        bundle.putString("from", this.mFrom);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void an(Bundle bundle) {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.ime != null) {
            try {
                FrsFragment frsFragment = (FrsFragment) this.ime.IF(ilV);
                if (frsFragment == null) {
                    frsFragment = ao(bundle);
                }
                frsFragment.b(this.imf);
                frsFragment.a(this.hXp);
                frsFragment.c(this.hSY);
                if (!ilV.equals(this.ime.yh(0))) {
                    if (ilW.equals(this.ime.yh(0))) {
                        this.ime.yg(0);
                    }
                    this.ime.a(0, frsFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqX() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.ime != null) {
            try {
                FrsTabHostFragment frsTabHostFragment = (FrsTabHostFragment) this.ime.IF(ilW);
                if (frsTabHostFragment == null) {
                    frsTabHostFragment = cqY();
                }
                frsTabHostFragment.b(this.imf);
                frsTabHostFragment.b(this.hXp);
                if (!ilW.equals(this.ime.yh(0))) {
                    if (ilV.equals(this.ime.yh(0))) {
                        this.ime.yg(0);
                    }
                    this.ime.a(0, frsTabHostFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private FrsFragment ao(Bundle bundle) {
        if (this.hXk == null) {
            this.hXk = new FrsFragment();
            this.hXk.setArguments(bundle);
            this.hXk.setBaseTag(ilV);
        }
        this.hXk.hTf = false;
        return this.hXk;
    }

    private FrsTabHostFragment cqY() {
        if (this.ilY == null) {
            this.ilY = new FrsTabHostFragment(this);
            this.ilY.setBaseTag(ilW);
            this.ilY.xs(this.hXm);
        }
        return this.ilY;
    }

    private FragmentManager getFragmentManager() {
        if (this.ilX != null) {
            return this.ilX.getSupportFragmentManager();
        }
        return null;
    }

    private void cqZ() {
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.hXl != null && (themeColorInfo = this.hXl.getForum().getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            this.imf.setStartAndEndColor(themeElement.light_color, themeElement.dark_color);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(m mVar, boolean z) {
        if (mVar != null && mVar.getForum() != null) {
            ForumData forum = mVar.getForum();
            if (z) {
                com.baidu.tbadk.youngster.b.a.a(this.ilX.getPageContext(), mVar.getAnti(), R.id.frs);
            }
            if (forum.getIsShowBawuTask() && com.baidu.tbadk.core.sharedPref.b.bik().getInt("key_bawu_task_toast", 0) == 0 && !this.imk) {
                this.imk = true;
                com.baidu.adp.lib.f.e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.6
                    @Override // java.lang.Runnable
                    public void run() {
                        FrsTabController.this.crf();
                    }
                }, 30000L);
            }
            if (mVar.bazhuExam != null && !this.iml && z) {
                com.baidu.tieba.frs.m.a(this.ilX.getPageContext(), mVar.bazhuExam, forum.getId(), forum.getName());
                this.iml = true;
            }
            this.hXl = mVar;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921476));
            if (y.getCount(mVar.getGameTabInfo()) > 0) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.7
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean cL = FrsTabController.this.cL(FrsTabController.this.hXl.getGameTabInfo());
                        if (cL) {
                            FrsTabController.this.ime.notifyDataSetChanged();
                            if (cL && FrsTabController.this.ilY != null) {
                                FrsTabController.this.ilY.Z(FrsTabController.this.hXk);
                                FrsTabController.this.ilY.a(FrsTabController.this.hXl, FrsTabController.this.hXj);
                            }
                        }
                        if (FrsTabController.this.ilX.isLoadingViewAttached()) {
                            FrsTabController.this.ilX.hideLoadingView(FrsTabController.this.ilX.findViewById(16908290));
                        }
                    }
                });
            } else if (cre()) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.8
                    @Override // java.lang.Runnable
                    public void run() {
                        Bundle bundle;
                        FrsTabController.this.hXk.hTf = true;
                        if (FrsTabController.this.hXk != null) {
                            bundle = FrsTabController.this.hXk.getArguments();
                        } else {
                            bundle = null;
                        }
                        FrsTabController.this.an(bundle);
                        FrsTabController.this.ime.notifyDataSetChanged();
                        if (FrsTabController.this.ilX.isLoadingViewAttached()) {
                            FrsTabController.this.ilX.hideLoadingView(FrsTabController.this.ilX.findViewById(16908290));
                        }
                    }
                });
            }
            cqZ();
            crg();
        }
    }

    public m cra() {
        return this.hXl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cL(List<FrsTabInfo> list) {
        if (this.ilX.isLoadingViewAttached()) {
            this.ilX.hideLoadingView(this.ilX.findViewById(16908290));
        }
        if (cre()) {
            return false;
        }
        this.hXk.hTf = true;
        crb();
        if (com.baidu.tbadk.core.sharedPref.b.bik().getBoolean("frs_game_login_tip", true)) {
            com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.FRS_LOGIN_TIP, true);
            com.baidu.tbadk.core.sharedPref.b.bik().putBoolean("frs_game_login_tip", false);
        }
        cM(list);
        return true;
    }

    private void crb() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021074, TbConfig.SERVER_ADDRESS + "game/forum/getNewNotify");
        tbHttpMessageTask.setResponsedClass(AlaGameTabGetNewNotifyResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.ilX.registerListener(1021074, this.imt);
    }

    private void cM(List<FrsTabInfo> list) {
        boolean z;
        if (!y.isEmpty(list)) {
            CustomMessageListener customMessageListener = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.9
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof am)) {
                        if (!com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(FrsTabController.this.ima, true)) {
                            com.baidu.adp.lib.f.e.mS().post(FrsTabController.this.imu);
                        }
                        ((am) customResponsedMessage.getData()).b(new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.9.1
                            @Override // com.baidu.tbadk.mainTab.b
                            public boolean isAvailable() {
                                return true;
                            }

                            @Override // com.baidu.tbadk.mainTab.b
                            public com.baidu.tbadk.mainTab.c createFragmentTabStructure() {
                                FrsSportsRecommendFragment frsSportsRecommendFragment = new FrsSportsRecommendFragment();
                                Bundle bundle = new Bundle();
                                bundle.putString("name", FrsTabController.this.hXk.getForumName());
                                bundle.putString("from", FrsTabController.this.hXk.getFrom());
                                bundle.putString("forum_id", FrsTabController.this.hXk.getForumId());
                                bundle.putInt("tab_id", 503);
                                bundle.putBoolean("can_auto_play_video", FrsTabController.this.hXl.isFrsVideoAutoPlay);
                                bundle.putBoolean("need_log", FrsTabController.this.hXl.needLog == 1);
                                bundle.putBoolean("is_brand_forum", FrsTabController.this.hXl.isBrandForum);
                                FrsViewData frsViewData = new FrsViewData();
                                frsViewData.receiveData(FrsTabController.this.hXl);
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
                        FrsTabController.this.cqX();
                    }
                }
            };
            customMessageListener.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            customMessageListener.setSelfListener(true);
            this.ilX.registerListener(customMessageListener);
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
            this.hXj = new am(this.ilX.getActivity(), arrayList);
            if (clf() != null) {
                this.hXj.setForumId(clf().getForumId());
                this.hXj.setForumName(clf().getForumName());
                if (clf().cmx() != null && clf().cmx().getForum() != null) {
                    ForumData forum = clf().cmx().getForum();
                    this.hXj.setForumGameLabel(forum.getForumGameLabel());
                    this.hXj.GJ(forum.getSpecialForumType());
                }
            }
            this.hXk.hTf = false;
            new d(this.hXk).a(this.hXj);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB, this.hXj);
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB);
            customMessage.setTag(this.ilX.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crc() {
        if (this.hXj != null && !TextUtils.isEmpty(this.hXj.getForumId())) {
            HttpMessage httpMessage = new HttpMessage(1021074);
            httpMessage.addParam("forum_id", this.hXl.getForum().getId());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    private void a(Fragment fragment, int i) {
        NavigationBar bJI;
        if ((fragment instanceof at) && this.hXl != null && this.hXl.getForum() != null && (bJI = ((at) fragment).bJI()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.hXl.getForum().getName(), 5, true, true) + this.ilX.getActivity().getString(R.string.forum));
            bJI.setCenterTextTitle(sb.toString());
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.hXk instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.hXk.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a rQ(int i) {
        if (this.hXk instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.hXk.rQ(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.hXk instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.hXk.a(bVar);
        }
    }

    public void onNewIntent(Intent intent) {
        if (this.hXk != null) {
            this.hXk.onNewIntent(intent);
        }
    }

    public void onResume() {
        if (!cre()) {
            this.hXk.setPrimary(true);
        } else if (this.ilY != null) {
            Fragment currentFragment = this.ilY.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(true);
            }
        }
        if (this.imc) {
            this.imc = false;
            if (this.hXk != null) {
                this.hXk.refresh();
            }
        }
        if (this.hXl != null && this.hXl.getUserData() != null && this.hXl.getUserData().getNewGodData() != null) {
            if (this.hXl.getForum() != null) {
                v.bvC().setFid(this.hXl.getForum().getId());
            }
            v.bvC().b(2, this.hXl.getUserData().getNewGodData());
        }
    }

    public void onPause() {
        if (!cre()) {
            this.hXk.setPrimary(false);
        } else if (this.ilY != null) {
            Fragment currentFragment = this.ilY.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(false);
            }
        }
        v.bvC().removeCallbacks();
    }

    public void onChangeSkinType(int i) {
        UtilHelper.changeStatusBarIconAndTextColor(true, this.ilX);
        if (this.hXk != null) {
            this.hXk.onChangeSkinType(i);
        }
        if (this.ilY != null) {
            this.ilY.onChangeSkinType(i);
        }
        cqZ();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (cre() && this.ilY != null && this.ilY.cnE()) {
                this.ilY.cnU();
                UtilHelper.setNavigationBarBackground(this.ilX, this.ilY.cnP());
            } else if (this.hXk != null && this.hXk.isAdded()) {
                if (this.hXk.onKeyDown(i, keyEvent)) {
                    return true;
                }
                crd();
            } else {
                return this.ilX.b(i, keyEvent);
            }
        } else if (i == 24) {
            if (this.hXk != null && this.hXk.isAdded()) {
                return this.hXk.onKeyDown(i, keyEvent);
            }
        } else {
            return this.ilX.b(i, keyEvent);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crd() {
        if (this.hXn != this.hXm && cre()) {
            this.ilY.setCurrentTab(this.hXm);
            if (xq(this.hXm) != 1) {
                this.hXk.ok(false);
            }
            this.hXn = this.hXm;
            a(this.ilY.getCurrentFragment(), this.hXm);
            return;
        }
        this.hXk.closeActivity();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!cre()) {
            this.hXk.onActivityResult(i, i2, intent);
        } else if (this.ilY != null) {
            if (1 == this.ilY.getCurrentTabType()) {
                this.hXk.onActivityResult(i, i2, intent);
            } else {
                this.ilY.getCurrentFragment().onActivityResult(i, i2, intent);
            }
        }
        if (i2 == -1) {
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1) {
                    com.baidu.tieba.o.a.dmP().F(this.ilX.getPageContext());
                    ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.linkUrl != null && this.imb != null) {
                        this.imb.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.10
                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void boZ() {
                            }

                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void a(final CustomDialogData customDialogData) {
                                com.baidu.adp.lib.f.e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.10.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (FrsTabController.this.ilX != null) {
                                            com.baidu.tieba.pb.interactionpopupwindow.c.a(FrsTabController.this.ilX.getPageContext(), customDialogData).show();
                                        }
                                    }
                                }, 1000L);
                            }
                        });
                    }
                }
            } else if (i == 13011) {
                com.baidu.tieba.o.a.dmP().F(this.ilX.getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (!cre()) {
            return this.hXk.getVoiceManager();
        }
        if (this.ilY == null) {
            return null;
        }
        Fragment currentFragment = this.ilY.getCurrentFragment();
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
    public int xo(int i) {
        if (this.hXj == null) {
            return -1;
        }
        int count = y.getCount(this.hXj.clx());
        for (int i2 = 0; i2 < count; i2++) {
            if (this.hXj.clx().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int xq(int i) {
        if (this.hXj != null && i < y.getCount(this.hXj.clx())) {
            return this.hXj.clx().get(i).tab_id.intValue();
        }
        return -1;
    }

    public FrsFragment clf() {
        return this.hXk;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> clg() {
        if (!cre()) {
            if (this.hXk instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) this.hXk).clg();
            }
        } else if (this.ilY == null) {
            return null;
        } else {
            Fragment currentFragment = this.ilY.getCurrentFragment();
            if (currentFragment instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) currentFragment).clg();
            }
        }
        return null;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(t.hWt);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.ilX.isLoadingViewAttached()) {
            this.ilX.hideLoadingView(this.ilX.findViewById(16908290));
        }
        if (this.imu != null) {
            com.baidu.adp.lib.f.e.mS().removeCallbacks(this.imu);
        }
        com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(this.ima, false);
        if (this.imb != null) {
            this.imb.cancelLoadData();
        }
        if (this.hXk != null && this.hXk.clO() != null) {
            this.hXk.clO().crr();
        }
        if (this.imj != null) {
            this.imj.onDestroy();
        }
        if (FrsActivityConfig.FRS_FROM_FLUTTER_BCASTEDIT.equals(this.mFrom)) {
            new o(TbadkCoreApplication.getInst()).biz();
        }
    }

    public FragmentTabHost cnS() {
        if (this.ilY == null) {
            return null;
        }
        return this.ilY.cnS();
    }

    public boolean cre() {
        if (this.ime == null) {
            return false;
        }
        return this.ime.getItem(0) instanceof FrsTabHostFragment;
    }

    public void xs(int i) {
        this.hXm = i;
    }

    public void ye(int i) {
        this.hXn = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crf() {
        if (this.ilX != null) {
            if (this.imj == null) {
                this.imj = (NavigationBarCoverTip) this.ilX.findViewById(R.id.navigation_cover_tip);
            }
            if (this.imj != null) {
                View inflate = View.inflate(this.ilX, R.layout.write_thread_share_guide, null);
                TextView textView = (TextView) inflate.findViewById(R.id.write_thread_success_tips);
                TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) inflate.findViewById(R.id.share_icon);
                if (TextUtils.isEmpty(this.mForumName)) {
                    textView.setText("吧主您好，本吧考核新制度上线啦");
                } else {
                    textView.setText(this.mForumName + "吧吧主您好，本吧考核新制度上线啦");
                }
                tBSpecificationBtn.setTextSize(R.dimen.tbds34);
                tBSpecificationBtn.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.check_immediately));
                com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
                cVar.blp();
                tBSpecificationBtn.setConfig(cVar);
                tBSpecificationBtn.bkF();
                ap.setViewTextColor(textView, R.color.cp_cont_a);
                ap.setBackgroundColor(this.imj, R.color.cp_link_tip_a_alpha95);
                tBSpecificationBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.11
                    /* JADX DEBUG: Multi-variable search result rejected for r4v9, resolved type: com.baidu.tieba.frs.FrsActivity */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        new aq("c13439").bjn();
                        if (FrsTabController.this.clf() != null && !TextUtils.isEmpty(FrsTabController.this.clf().getForumId()) && !TextUtils.isEmpty(FrsTabController.this.mForumName) && FrsTabController.this.ilX != null) {
                            if (FrsTabController.this.imj != null) {
                                FrsTabController.this.imj.hideTip();
                            }
                            be.bju().b(FrsTabController.this.ilX.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/bawutask?fid=" + FrsTabController.this.clf().getForumId() + "&fn=" + FrsTabController.this.mForumName + "&noread=" + (com.baidu.tbadk.core.sharedPref.b.bik().getInt("key_bawu_task_toast", 0) == -1 ? 1 : 0)});
                        }
                    }
                });
                this.imj.a(this.ilX, inflate, 30000);
                new aq("c13438").bjn();
                int i = com.baidu.tbadk.core.sharedPref.b.bik().getInt("key_bawu_task_toast", 0);
                if (i >= 0) {
                    com.baidu.tbadk.core.sharedPref.b.bik().putInt("key_bawu_task_toast", i + 1);
                }
            }
        }
    }

    private void crg() {
        boolean z;
        if (this.hXl != null && this.hXl.getEntelechyTabInfo() != null && this.hXl.getEntelechyTabInfo().tab != null) {
            Iterator<FrsTabInfo> it = this.hXl.getEntelechyTabInfo().tab.iterator();
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
                if (this.imm == null) {
                    this.imm = new e(this.ilX.getPageContext(), this.imf);
                    this.imm.eL(R.drawable.pic_sign_tip_down);
                    this.imm.setAnchor(2);
                    this.imm.setUseDirectOffset(true);
                    this.imm.vF(-l.getDimens(this.ilX, R.dimen.tbds20));
                    this.imm.setYOffset(-l.getDimens(this.ilX, R.dimen.tbds20));
                    this.imm.setTextColor(R.color.cp_cont_a);
                    this.imm.setHeight(R.dimen.tbds54);
                    this.imm.vD(l.getDimens(this.ilX, R.dimen.tbds44));
                }
                this.imm.aG(this.ilX.getString(R.string.frs_evaluate_tip), "first_into_frs_with_evaluate_tab");
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
        /* renamed from: yf */
        public BaseFragment getItem(int i) {
            return (BaseFragment) y.getItem(this.mFragments, i);
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
            return y.add(this.mFragments, i, baseFragment);
        }

        public BaseFragment IF(String str) {
            if (com.baidu.tbadk.core.util.at.isEmpty(str)) {
                return null;
            }
            for (BaseFragment baseFragment : this.mFragments) {
                if (baseFragment != null && str.equals(baseFragment.getBaseTag())) {
                    return baseFragment;
                }
            }
            return null;
        }

        public BaseFragment yg(int i) {
            return (BaseFragment) y.remove(this.mFragments, i);
        }

        public String yh(int i) {
            if (getItem(i) != null) {
                return getItem(i).getBaseTag();
            }
            return null;
        }
    }

    public TbPageTag getTbPageTag() {
        if (!cre()) {
            return this.hXk.getTbPageTag();
        }
        if (this.ilY != null) {
            if (1 == this.ilY.getCurrentTabType()) {
                return this.hXk.getTbPageTag();
            }
            Fragment currentFragment = this.ilY.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                return ((BaseFragment) currentFragment).getTbPageTag();
            }
        }
        return null;
    }
}
