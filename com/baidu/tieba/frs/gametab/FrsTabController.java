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
    public static final String ilP = FrsFragment.class.getSimpleName();
    public static final String ilQ = FrsTabHostFragment.class.getSimpleName();
    private LinearLayout hSS;
    private am hXd;
    private FrsFragment hXe;
    private m hXf;
    private int hXh;
    private FRSRefreshButton hXj;
    private FrsActivity ilR;
    private FrsTabHostFragment ilS;
    private ShareSuccessReplyToServerModel ilV;
    private FrsBaseViewPager ilX;
    private FragmentAdapter ilY;
    private OvalActionButton ilZ;
    private boolean ima;
    private boolean imb;
    private NavigationBarCoverTip imc;
    private e imf;
    private String mForumName;
    private String mFrom;
    private boolean ilT = false;
    private final Handler mHandler = new Handler();
    private int hXg = 0;
    private boolean ilW = false;
    private boolean imd = false;
    private boolean ime = false;
    private HttpMessageListener imh = new HttpMessageListener(CmdConfigHttp.CMD_FRS_RECOMMEND) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof FrsRecommendResMsg) {
                if (httpResponsedMessage.getError() != 0) {
                    new BdTopToast(FrsTabController.this.ilR).wS(false).Sp(httpResponsedMessage.getErrorString()).aE((ViewGroup) FrsTabController.this.ilR.findViewById(R.id.frs));
                    return;
                }
                int pushStatus = ((FrsRecommendResMsg) httpResponsedMessage).getPushStatus();
                String pushMsg = ((FrsRecommendResMsg) httpResponsedMessage).getPushMsg();
                if (pushStatus == 1) {
                    new ScreenTopToast(FrsTabController.this.ilR).St(FrsTabController.this.ilR.getString(R.string.frs_recommend_suc_tip_title)).Su(FrsTabController.this.ilR.getString(R.string.frs_recommend_suc_tip_content)).Sv(FrsTabController.this.ilR.getString(R.string.dialog_confirm_see)).ak(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.1.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("_forumId", FrsTabController.this.hXf.getForum().getId());
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new com.baidu.tieba.tbadkCore.data.m(FrsTabController.this.ilR, "RecommendHistoryPage", hashMap)));
                        }
                    }).aE((ViewGroup) FrsTabController.this.ilR.findViewById(R.id.frs));
                } else {
                    new BdTopToast(FrsTabController.this.ilR).wS(false).Sp(pushMsg).aE((ViewGroup) FrsTabController.this.ilR.findViewById(R.id.frs));
                }
            }
        }
    };
    private CustomMessageListener imi = new CustomMessageListener(2921465) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            new ScreenTopToast(FrsTabController.this.ilR).St(FrsTabController.this.ilR.getString(R.string.frs_recommend_fail_month_tip)).Sv(FrsTabController.this.ilR.getString(R.string.frs_recommend_fail_tip_btn)).ak(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.12.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("_forumId", FrsTabController.this.hXf.getForum().getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new com.baidu.tieba.tbadkCore.data.m(FrsTabController.this.ilR, "ForumGradePage", hashMap)));
                }
            }).aE((ViewGroup) FrsTabController.this.ilR.findViewById(R.id.frs));
        }
    };
    private com.baidu.adp.framework.listener.a imj = new com.baidu.adp.framework.listener.a(1001703, CmdConfigSocket.CMD_FRS_PAGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.13
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            m mVar = null;
            if (!FrsTabController.this.ilT && !responsedMessage.hasError() && responsedMessage.getError() == 0) {
                if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                    mVar = ((FrsPageHttpResponseMessage) responsedMessage).getResponseData();
                } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                    mVar = ((FRSPageSocketResponsedMessage) responsedMessage).getResponseData();
                }
                if (mVar != null) {
                    FrsTabController.this.ilT = true;
                    FrsTabController.this.a(mVar, true);
                    if (mVar != null && mVar.getForum() != null && !StringUtils.isNull(mVar.getForum().getId())) {
                        com.baidu.tbadk.core.business.a.bbY().dt("2", mVar.getForum().getId());
                    }
                }
                if (mVar != null && mVar.getUserData() != null && mVar.getUserData().getNewGodData() != null) {
                    if (mVar.getForum() != null) {
                        v.bvB().setFid(mVar.getForum().getId());
                    }
                    v.bvB().b(2, mVar.getUserData().getNewGodData());
                }
            }
        }
    };
    private CustomMessageListener imk = new CustomMessageListener(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!FrsTabController.this.ilT && FrsTabController.this.hXf == null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof m)) {
                m mVar = (m) customResponsedMessage.getData();
                if (mVar.getForum() != null && FrsTabController.this.mForumName != null && FrsTabController.this.mForumName.equals(mVar.getForum().getName())) {
                    FrsTabController.this.a(mVar, false);
                }
            }
        }
    };
    private CustomMessageListener iml = new CustomMessageListener(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsTabController.this.crc();
        }
    };
    private CustomMessageListener imm = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.16
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
                if (xo != -1 && FrsTabController.this.crd() && FrsTabController.this.ilS != null) {
                    FrsTabController.this.ilS.setCurrentTab(xo);
                    if (FrsTabController.this.xq(xo) != 1) {
                        FrsTabController.this.hXe.oi(false);
                    }
                }
            }
        }
    };
    private HttpMessageListener imn = new HttpMessageListener(0) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && 1021074 == httpResponsedMessage.getCmd() && (httpResponsedMessage instanceof AlaGameTabGetNewNotifyResponsedMessage)) {
                List<a> newNotifyData = ((AlaGameTabGetNewNotifyResponsedMessage) httpResponsedMessage).getNewNotifyData();
                if (!y.isEmpty(newNotifyData) && FrsTabController.this.ilS != null) {
                    for (a aVar : newNotifyData) {
                        if (aVar != null) {
                            for (int i = 0; i < FrsTabController.this.hXd.clw().size(); i++) {
                                FragmentTabHost.b nL = FrsTabController.this.ilS.nL(i);
                                if (nL != null && nL.mType != 1 && nL.mType != FrsTabController.this.ilS.getCurrentTabType() && nL.mType == aVar.getTabId() && aVar.cqV() && nL.eiD.Co(String.valueOf(nL.mType)) != null) {
                                    nL.eiD.Co(String.valueOf(nL.mType)).view.setVisibility(0);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private Runnable imo = new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.18
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.adp.lib.f.e.mS().removeCallbacks(this);
            FrsTabController.this.crb();
            com.baidu.adp.lib.f.e.mS().postDelayed(this, 30000L);
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                FrsTabController.this.ilW = true;
            }
        }
    };
    private CustomMessageListener imp = new CustomMessageListener(2921369) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.ilX != null && FrsTabController.this.ilY != null && (customResponsedMessage.getData() instanceof FrsTabViewPager.a)) {
                FrsTabViewPager.a aVar = (FrsTabViewPager.a) customResponsedMessage.getData();
                FrsTabController.this.ima = aVar.cnY();
                FrsTabController.this.imb = aVar.cnZ();
            }
        }
    };
    private CustomMessageListener imq = new CustomMessageListener(2921370) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.ilX != null && FrsTabController.this.ilY != null && (customResponsedMessage.getData() instanceof Boolean)) {
                FrsTabController.this.ilX.setForceIntercept(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };
    private ViewPager.OnPageChangeListener imr = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.4
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i != 1) {
                FrsTabController.this.ilZ.setVisibility(0);
                if (FrsTabController.this.cle() != null) {
                    FrsTabController.this.cle().oc(false);
                }
                FrsTabController.this.hXe.cmv();
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            switch (i) {
                case 0:
                    FrsTabController.this.imb = false;
                    FrsTabController.this.ilX.setForceIntercept(false);
                    return;
                default:
                    return;
            }
        }
    };
    private FrsBaseViewPager.a ims = new FrsBaseViewPager.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.5
        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public void clA() {
            if (FrsTabController.this.ilX != null) {
                if (FrsTabController.this.ilX.getCurrentItem() == 0) {
                    FrsTabController.this.ilX.setmDisallowSlip(true);
                } else {
                    FrsTabController.this.ilX.setmDisallowSlip(false);
                }
            }
        }

        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public boolean clB() {
            if (FrsTabController.this.ilX.getCurrentItem() == 0) {
                if (FrsTabController.this.ima && FrsTabController.this.imb) {
                    FrsTabController.this.ilX.setmDisallowSlip(false);
                }
                if (!FrsTabController.this.imb) {
                    FrsTabController.this.ilX.setmDisallowSlip(true);
                }
                FrsTabController.this.ilX.setmDisallowSlip(true);
            } else {
                FrsTabController.this.ilX.setmDisallowSlip(true);
            }
            return true;
        }
    };
    private String ilU = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.SHOW_GAME_FOREM_TAB_HOT_POINT);

    public FrsTabController(FrsActivity frsActivity) {
        this.ilR = frsActivity;
    }

    public void init(Bundle bundle) {
        if (this.ilR != null) {
            this.ilR.setContentView(R.layout.frs_base_layout);
            this.ilX = (FrsBaseViewPager) this.ilR.findViewById(R.id.frs_base_viewpager);
            this.ilY = new FragmentAdapter(this.ilR.getSupportFragmentManager());
            this.ilX.setAdapter(this.ilY);
            this.ilX.setPageTransformer(true, new CubeOutViewPagerTransformer());
            this.ilX.addOnPageChangeListener(this.imr);
            this.ilX.setmDisallowSlip(true);
            this.ilX.setOnTouchEventListener(this.ims);
            this.ilZ = (OvalActionButton) this.ilR.findViewById(R.id.frs_post_forum_button);
            this.ilZ.setIsCircle(true);
            this.ilZ.setHasShadow(false);
            this.hXj = (FRSRefreshButton) this.ilR.findViewById(R.id.frs_refresh_forum_button);
            this.hSS = (LinearLayout) this.ilR.findViewById(R.id.frs_ll_redpack);
            this.ilR.registerListener(this.imp);
            this.ilR.registerListener(this.imq);
            this.imj.getHttpMessageListener().setPriority(-1);
            this.imj.getSocketMessageListener().setPriority(-1);
            this.ilR.registerListener(this.imk);
            this.imm.setSelfListener(true);
            this.ilR.registerListener(this.imm);
            this.iml.setSelfListener(true);
            this.ilR.registerListener(this.iml);
            this.ilR.registerListener(this.mAccountChangedListener);
            if (bundle == null) {
                this.mForumName = this.ilR.getIntent().getStringExtra("name");
                this.mFrom = this.ilR.getIntent().getStringExtra("from");
                this.hXg = this.ilR.getIntent().getIntExtra(FrsActivityConfig.FRS_GAME_DEFAULT_TAB_ID, 0);
            } else {
                this.mForumName = bundle.getString("name");
                this.mFrom = bundle.getString("from");
                this.hXg = bundle.getInt("default_tab_id", 0);
            }
            an(bundle);
            this.ilY.notifyDataSetChanged();
            this.ilV = new ShareSuccessReplyToServerModel();
            this.ilR.registerListener(this.imj);
            this.ilR.registerListener(this.imh);
            this.ilR.registerListener(this.imi);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.mForumName);
        bundle.putInt("default_tab_id", this.hXg);
        bundle.putString("from", this.mFrom);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void an(Bundle bundle) {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.ilY != null) {
            try {
                FrsFragment frsFragment = (FrsFragment) this.ilY.IE(ilP);
                if (frsFragment == null) {
                    frsFragment = ao(bundle);
                }
                frsFragment.b(this.ilZ);
                frsFragment.a(this.hXj);
                frsFragment.c(this.hSS);
                if (!ilP.equals(this.ilY.yh(0))) {
                    if (ilQ.equals(this.ilY.yh(0))) {
                        this.ilY.yg(0);
                    }
                    this.ilY.a(0, frsFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqW() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.ilY != null) {
            try {
                FrsTabHostFragment frsTabHostFragment = (FrsTabHostFragment) this.ilY.IE(ilQ);
                if (frsTabHostFragment == null) {
                    frsTabHostFragment = cqX();
                }
                frsTabHostFragment.b(this.ilZ);
                frsTabHostFragment.b(this.hXj);
                if (!ilQ.equals(this.ilY.yh(0))) {
                    if (ilP.equals(this.ilY.yh(0))) {
                        this.ilY.yg(0);
                    }
                    this.ilY.a(0, frsTabHostFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private FrsFragment ao(Bundle bundle) {
        if (this.hXe == null) {
            this.hXe = new FrsFragment();
            this.hXe.setArguments(bundle);
            this.hXe.setBaseTag(ilP);
        }
        this.hXe.hSZ = false;
        return this.hXe;
    }

    private FrsTabHostFragment cqX() {
        if (this.ilS == null) {
            this.ilS = new FrsTabHostFragment(this);
            this.ilS.setBaseTag(ilQ);
            this.ilS.xs(this.hXg);
        }
        return this.ilS;
    }

    private FragmentManager getFragmentManager() {
        if (this.ilR != null) {
            return this.ilR.getSupportFragmentManager();
        }
        return null;
    }

    private void cqY() {
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.hXf != null && (themeColorInfo = this.hXf.getForum().getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            this.ilZ.setStartAndEndColor(themeElement.light_color, themeElement.dark_color);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(m mVar, boolean z) {
        if (mVar != null && mVar.getForum() != null) {
            ForumData forum = mVar.getForum();
            if (z) {
                com.baidu.tbadk.youngster.b.a.a(this.ilR.getPageContext(), mVar.getAnti(), R.id.frs);
            }
            if (forum.getIsShowBawuTask() && com.baidu.tbadk.core.sharedPref.b.bik().getInt("key_bawu_task_toast", 0) == 0 && !this.imd) {
                this.imd = true;
                com.baidu.adp.lib.f.e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.6
                    @Override // java.lang.Runnable
                    public void run() {
                        FrsTabController.this.cre();
                    }
                }, 30000L);
            }
            if (mVar.bazhuExam != null && !this.ime && z) {
                com.baidu.tieba.frs.m.a(this.ilR.getPageContext(), mVar.bazhuExam, forum.getId(), forum.getName());
                this.ime = true;
            }
            this.hXf = mVar;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921476));
            if (y.getCount(mVar.getGameTabInfo()) > 0) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.7
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean cL = FrsTabController.this.cL(FrsTabController.this.hXf.getGameTabInfo());
                        if (cL) {
                            FrsTabController.this.ilY.notifyDataSetChanged();
                            if (cL && FrsTabController.this.ilS != null) {
                                FrsTabController.this.ilS.Z(FrsTabController.this.hXe);
                                FrsTabController.this.ilS.a(FrsTabController.this.hXf, FrsTabController.this.hXd);
                            }
                        }
                        if (FrsTabController.this.ilR.isLoadingViewAttached()) {
                            FrsTabController.this.ilR.hideLoadingView(FrsTabController.this.ilR.findViewById(16908290));
                        }
                    }
                });
            } else if (crd()) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.8
                    @Override // java.lang.Runnable
                    public void run() {
                        Bundle bundle;
                        FrsTabController.this.hXe.hSZ = true;
                        if (FrsTabController.this.hXe != null) {
                            bundle = FrsTabController.this.hXe.getArguments();
                        } else {
                            bundle = null;
                        }
                        FrsTabController.this.an(bundle);
                        FrsTabController.this.ilY.notifyDataSetChanged();
                        if (FrsTabController.this.ilR.isLoadingViewAttached()) {
                            FrsTabController.this.ilR.hideLoadingView(FrsTabController.this.ilR.findViewById(16908290));
                        }
                    }
                });
            }
            cqY();
            crf();
        }
    }

    public m cqZ() {
        return this.hXf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cL(List<FrsTabInfo> list) {
        if (this.ilR.isLoadingViewAttached()) {
            this.ilR.hideLoadingView(this.ilR.findViewById(16908290));
        }
        if (crd()) {
            return false;
        }
        this.hXe.hSZ = true;
        cra();
        if (com.baidu.tbadk.core.sharedPref.b.bik().getBoolean("frs_game_login_tip", true)) {
            com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.FRS_LOGIN_TIP, true);
            com.baidu.tbadk.core.sharedPref.b.bik().putBoolean("frs_game_login_tip", false);
        }
        cM(list);
        return true;
    }

    private void cra() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021074, TbConfig.SERVER_ADDRESS + "game/forum/getNewNotify");
        tbHttpMessageTask.setResponsedClass(AlaGameTabGetNewNotifyResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.ilR.registerListener(1021074, this.imn);
    }

    private void cM(List<FrsTabInfo> list) {
        boolean z;
        if (!y.isEmpty(list)) {
            CustomMessageListener customMessageListener = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.9
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof am)) {
                        if (!com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(FrsTabController.this.ilU, true)) {
                            com.baidu.adp.lib.f.e.mS().post(FrsTabController.this.imo);
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
                                bundle.putString("name", FrsTabController.this.hXe.getForumName());
                                bundle.putString("from", FrsTabController.this.hXe.getFrom());
                                bundle.putString("forum_id", FrsTabController.this.hXe.getForumId());
                                bundle.putInt("tab_id", 503);
                                bundle.putBoolean("can_auto_play_video", FrsTabController.this.hXf.isFrsVideoAutoPlay);
                                bundle.putBoolean("need_log", FrsTabController.this.hXf.needLog == 1);
                                bundle.putBoolean("is_brand_forum", FrsTabController.this.hXf.isBrandForum);
                                FrsViewData frsViewData = new FrsViewData();
                                frsViewData.receiveData(FrsTabController.this.hXf);
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
                        FrsTabController.this.cqW();
                    }
                }
            };
            customMessageListener.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            customMessageListener.setSelfListener(true);
            this.ilR.registerListener(customMessageListener);
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
            this.hXd = new am(this.ilR.getActivity(), arrayList);
            if (cle() != null) {
                this.hXd.setForumId(cle().getForumId());
                this.hXd.setForumName(cle().getForumName());
                if (cle().cmw() != null && cle().cmw().getForum() != null) {
                    ForumData forum = cle().cmw().getForum();
                    this.hXd.setForumGameLabel(forum.getForumGameLabel());
                    this.hXd.GI(forum.getSpecialForumType());
                }
            }
            this.hXe.hSZ = false;
            new d(this.hXe).a(this.hXd);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB, this.hXd);
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB);
            customMessage.setTag(this.ilR.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crb() {
        if (this.hXd != null && !TextUtils.isEmpty(this.hXd.getForumId())) {
            HttpMessage httpMessage = new HttpMessage(1021074);
            httpMessage.addParam("forum_id", this.hXf.getForum().getId());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    private void a(Fragment fragment, int i) {
        NavigationBar bJH;
        if ((fragment instanceof at) && this.hXf != null && this.hXf.getForum() != null && (bJH = ((at) fragment).bJH()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.hXf.getForum().getName(), 5, true, true) + this.ilR.getActivity().getString(R.string.forum));
            bJH.setCenterTextTitle(sb.toString());
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.hXe instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.hXe.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a rQ(int i) {
        if (this.hXe instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.hXe.rQ(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.hXe instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.hXe.a(bVar);
        }
    }

    public void onNewIntent(Intent intent) {
        if (this.hXe != null) {
            this.hXe.onNewIntent(intent);
        }
    }

    public void onResume() {
        if (!crd()) {
            this.hXe.setPrimary(true);
        } else if (this.ilS != null) {
            Fragment currentFragment = this.ilS.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(true);
            }
        }
        if (this.ilW) {
            this.ilW = false;
            if (this.hXe != null) {
                this.hXe.refresh();
            }
        }
        if (this.hXf != null && this.hXf.getUserData() != null && this.hXf.getUserData().getNewGodData() != null) {
            if (this.hXf.getForum() != null) {
                v.bvB().setFid(this.hXf.getForum().getId());
            }
            v.bvB().b(2, this.hXf.getUserData().getNewGodData());
        }
    }

    public void onPause() {
        if (!crd()) {
            this.hXe.setPrimary(false);
        } else if (this.ilS != null) {
            Fragment currentFragment = this.ilS.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(false);
            }
        }
        v.bvB().removeCallbacks();
    }

    public void onChangeSkinType(int i) {
        UtilHelper.changeStatusBarIconAndTextColor(true, this.ilR);
        if (this.hXe != null) {
            this.hXe.onChangeSkinType(i);
        }
        if (this.ilS != null) {
            this.ilS.onChangeSkinType(i);
        }
        cqY();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (crd() && this.ilS != null && this.ilS.cnD()) {
                this.ilS.cnT();
                UtilHelper.setNavigationBarBackground(this.ilR, this.ilS.cnO());
            } else if (this.hXe != null && this.hXe.isAdded()) {
                if (this.hXe.onKeyDown(i, keyEvent)) {
                    return true;
                }
                crc();
            } else {
                return this.ilR.b(i, keyEvent);
            }
        } else if (i == 24) {
            if (this.hXe != null && this.hXe.isAdded()) {
                return this.hXe.onKeyDown(i, keyEvent);
            }
        } else {
            return this.ilR.b(i, keyEvent);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crc() {
        if (this.hXh != this.hXg && crd()) {
            this.ilS.setCurrentTab(this.hXg);
            if (xq(this.hXg) != 1) {
                this.hXe.oi(false);
            }
            this.hXh = this.hXg;
            a(this.ilS.getCurrentFragment(), this.hXg);
            return;
        }
        this.hXe.closeActivity();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!crd()) {
            this.hXe.onActivityResult(i, i2, intent);
        } else if (this.ilS != null) {
            if (1 == this.ilS.getCurrentTabType()) {
                this.hXe.onActivityResult(i, i2, intent);
            } else {
                this.ilS.getCurrentFragment().onActivityResult(i, i2, intent);
            }
        }
        if (i2 == -1) {
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1) {
                    com.baidu.tieba.o.a.dmM().F(this.ilR.getPageContext());
                    ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.linkUrl != null && this.ilV != null) {
                        this.ilV.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.10
                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void boY() {
                            }

                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void a(final CustomDialogData customDialogData) {
                                com.baidu.adp.lib.f.e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.10.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (FrsTabController.this.ilR != null) {
                                            com.baidu.tieba.pb.interactionpopupwindow.c.a(FrsTabController.this.ilR.getPageContext(), customDialogData).show();
                                        }
                                    }
                                }, 1000L);
                            }
                        });
                    }
                }
            } else if (i == 13011) {
                com.baidu.tieba.o.a.dmM().F(this.ilR.getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (!crd()) {
            return this.hXe.getVoiceManager();
        }
        if (this.ilS == null) {
            return null;
        }
        Fragment currentFragment = this.ilS.getCurrentFragment();
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
        if (this.hXd == null) {
            return -1;
        }
        int count = y.getCount(this.hXd.clw());
        for (int i2 = 0; i2 < count; i2++) {
            if (this.hXd.clw().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int xq(int i) {
        if (this.hXd != null && i < y.getCount(this.hXd.clw())) {
            return this.hXd.clw().get(i).tab_id.intValue();
        }
        return -1;
    }

    public FrsFragment cle() {
        return this.hXe;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> clf() {
        if (!crd()) {
            if (this.hXe instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) this.hXe).clf();
            }
        } else if (this.ilS == null) {
            return null;
        } else {
            Fragment currentFragment = this.ilS.getCurrentFragment();
            if (currentFragment instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) currentFragment).clf();
            }
        }
        return null;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(t.hWn);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.ilR.isLoadingViewAttached()) {
            this.ilR.hideLoadingView(this.ilR.findViewById(16908290));
        }
        if (this.imo != null) {
            com.baidu.adp.lib.f.e.mS().removeCallbacks(this.imo);
        }
        com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(this.ilU, false);
        if (this.ilV != null) {
            this.ilV.cancelLoadData();
        }
        if (this.hXe != null && this.hXe.clN() != null) {
            this.hXe.clN().crq();
        }
        if (this.imc != null) {
            this.imc.onDestroy();
        }
        if (FrsActivityConfig.FRS_FROM_FLUTTER_BCASTEDIT.equals(this.mFrom)) {
            new o(TbadkCoreApplication.getInst()).biz();
        }
    }

    public FragmentTabHost cnR() {
        if (this.ilS == null) {
            return null;
        }
        return this.ilS.cnR();
    }

    public boolean crd() {
        if (this.ilY == null) {
            return false;
        }
        return this.ilY.getItem(0) instanceof FrsTabHostFragment;
    }

    public void xs(int i) {
        this.hXg = i;
    }

    public void ye(int i) {
        this.hXh = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cre() {
        if (this.ilR != null) {
            if (this.imc == null) {
                this.imc = (NavigationBarCoverTip) this.ilR.findViewById(R.id.navigation_cover_tip);
            }
            if (this.imc != null) {
                View inflate = View.inflate(this.ilR, R.layout.write_thread_share_guide, null);
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
                ap.setBackgroundColor(this.imc, R.color.cp_link_tip_a_alpha95);
                tBSpecificationBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.11
                    /* JADX DEBUG: Multi-variable search result rejected for r4v9, resolved type: com.baidu.tieba.frs.FrsActivity */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        new aq("c13439").bjn();
                        if (FrsTabController.this.cle() != null && !TextUtils.isEmpty(FrsTabController.this.cle().getForumId()) && !TextUtils.isEmpty(FrsTabController.this.mForumName) && FrsTabController.this.ilR != null) {
                            if (FrsTabController.this.imc != null) {
                                FrsTabController.this.imc.hideTip();
                            }
                            be.bju().b(FrsTabController.this.ilR.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/bawutask?fid=" + FrsTabController.this.cle().getForumId() + "&fn=" + FrsTabController.this.mForumName + "&noread=" + (com.baidu.tbadk.core.sharedPref.b.bik().getInt("key_bawu_task_toast", 0) == -1 ? 1 : 0)});
                        }
                    }
                });
                this.imc.a(this.ilR, inflate, 30000);
                new aq("c13438").bjn();
                int i = com.baidu.tbadk.core.sharedPref.b.bik().getInt("key_bawu_task_toast", 0);
                if (i >= 0) {
                    com.baidu.tbadk.core.sharedPref.b.bik().putInt("key_bawu_task_toast", i + 1);
                }
            }
        }
    }

    private void crf() {
        boolean z;
        if (this.hXf != null && this.hXf.getEntelechyTabInfo() != null && this.hXf.getEntelechyTabInfo().tab != null) {
            Iterator<FrsTabInfo> it = this.hXf.getEntelechyTabInfo().tab.iterator();
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
                if (this.imf == null) {
                    this.imf = new e(this.ilR.getPageContext(), this.ilZ);
                    this.imf.eL(R.drawable.pic_sign_tip_down);
                    this.imf.setAnchor(2);
                    this.imf.setUseDirectOffset(true);
                    this.imf.vF(-l.getDimens(this.ilR, R.dimen.tbds20));
                    this.imf.setYOffset(-l.getDimens(this.ilR, R.dimen.tbds20));
                    this.imf.setTextColor(R.color.cp_cont_a);
                    this.imf.setHeight(R.dimen.tbds54);
                    this.imf.vD(l.getDimens(this.ilR, R.dimen.tbds44));
                }
                this.imf.aG(this.ilR.getString(R.string.frs_evaluate_tip), "first_into_frs_with_evaluate_tab");
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

        public BaseFragment IE(String str) {
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
        if (!crd()) {
            return this.hXe.getTbPageTag();
        }
        if (this.ilS != null) {
            if (1 == this.ilS.getCurrentTabType()) {
                return this.hXe.getTbPageTag();
            }
            Fragment currentFragment = this.ilS.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                return ((BaseFragment) currentFragment).getTbPageTag();
            }
        }
        return null;
    }
}
