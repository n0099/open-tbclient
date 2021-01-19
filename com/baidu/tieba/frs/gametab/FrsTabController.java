package com.baidu.tieba.frs.gametab;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
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
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
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
import com.baidu.tieba.flutter.util.OpenFlutter;
import com.baidu.tieba.frs.CubeOutViewPagerTransformer;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsBaseViewPager;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.FrsNoListItemViewHolder;
import com.baidu.tieba.frs.FrsRecommendResMsg;
import com.baidu.tieba.frs.FrsTabHostFragment;
import com.baidu.tieba.frs.FrsTabViewPager;
import com.baidu.tieba.frs.ai;
import com.baidu.tieba.frs.ap;
import com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment;
import com.baidu.tieba.frs.view.FrsForumToolDialogView;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.tbadkCore.FRSPageSocketResponsedMessage;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsPageHttpResponseMessage;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.m;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.tieba.view.ScreenTopToast;
import com.kwad.sdk.collector.AppStatusRules;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsPage.TipInfo;
import tbclient.FrsTabInfo;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes2.dex */
public class FrsTabController implements VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, FrsCommonImageLayout.c {
    public static final String jwx = FrsFragment.class.getSimpleName();
    public static final String jwy = FrsTabHostFragment.class.getSimpleName();
    private LinearLayout jaE;
    private ai jeO;
    private FrsFragment jeP;
    private m jeQ;
    private int jeS;
    private FRSRefreshButton jeU;
    private FrsTabHostFragment jwA;
    private ShareSuccessReplyToServerModel jwD;
    private FrsBaseViewPager jwF;
    private FragmentAdapter jwG;
    private OvalActionButton jwH;
    private boolean jwI;
    private boolean jwJ;
    private NavigationBarCoverTip jwK;
    private com.baidu.tieba.c.e jwN;
    private com.baidu.tieba.frs.d.e jwO;
    private Runnable jwP;
    private boolean jwQ;
    private FrsActivity jwz;
    private String mForumName;
    private String mFrom;
    private boolean jwB = false;
    private final Handler mHandler = new Handler();
    private int jeR = 0;
    private boolean jwE = false;
    private boolean jwL = false;
    private boolean jwM = false;
    private boolean jwR = false;
    private boolean jwS = false;
    private HttpMessageListener jwT = new HttpMessageListener(CmdConfigHttp.CMD_FRS_RECOMMEND) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof FrsRecommendResMsg) {
                if (httpResponsedMessage.getError() != 0) {
                    new BdTopToast(FrsTabController.this.jwz).yS(false).TQ(httpResponsedMessage.getErrorString()).aR((ViewGroup) FrsTabController.this.jwz.findViewById(R.id.frs));
                    return;
                }
                int pushStatus = ((FrsRecommendResMsg) httpResponsedMessage).getPushStatus();
                String pushMsg = ((FrsRecommendResMsg) httpResponsedMessage).getPushMsg();
                if (pushStatus == 1) {
                    new ScreenTopToast(FrsTabController.this.jwz).TU(FrsTabController.this.jwz.getString(R.string.frs_recommend_suc_tip_title)).TV(FrsTabController.this.jwz.getString(R.string.frs_recommend_suc_tip_content)).TW(FrsTabController.this.jwz.getString(R.string.dialog_confirm_see)).an(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.1.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("_forumId", FrsTabController.this.jeQ.getForum().getId());
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new com.baidu.tieba.tbadkCore.data.m(FrsTabController.this.jwz, "RecommendHistoryPage", hashMap)));
                        }
                    }).aR((ViewGroup) FrsTabController.this.jwz.findViewById(R.id.frs));
                } else {
                    new BdTopToast(FrsTabController.this.jwz).yS(false).TQ(pushMsg).aR((ViewGroup) FrsTabController.this.jwz.findViewById(R.id.frs));
                }
            }
        }
    };
    private CustomMessageListener jwU = new CustomMessageListener(2921465) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            new ScreenTopToast(FrsTabController.this.jwz).TU(FrsTabController.this.jwz.getString(R.string.frs_recommend_fail_month_tip)).TW(FrsTabController.this.jwz.getString(R.string.frs_recommend_fail_tip_btn)).an(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.12.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("_forumId", FrsTabController.this.jeQ.getForum().getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new com.baidu.tieba.tbadkCore.data.m(FrsTabController.this.jwz, "ForumGradePage", hashMap)));
                }
            }).aR((ViewGroup) FrsTabController.this.jwz.findViewById(R.id.frs));
        }
    };
    private com.baidu.adp.framework.listener.a jwV = new com.baidu.adp.framework.listener.a(1001703, CmdConfigSocket.CMD_FRS_PAGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.21
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            m mVar = null;
            int i = -1;
            if (!FrsTabController.this.jwB && !responsedMessage.hasError() && responsedMessage.getError() == 0) {
                if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                    mVar = ((FrsPageHttpResponseMessage) responsedMessage).getResponseData();
                    i = ((FrsPageHttpResponseMessage) responsedMessage).getUpdateType();
                } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                    mVar = ((FRSPageSocketResponsedMessage) responsedMessage).getResponseData();
                    i = ((FRSPageSocketResponsedMessage) responsedMessage).getUpdateType();
                }
                if (mVar != null) {
                    FrsTabController.this.jwB = true;
                    FrsTabController.this.a(mVar, true, i);
                    if (mVar != null && mVar.getForum() != null && !StringUtils.isNull(mVar.getForum().getId())) {
                        com.baidu.tbadk.core.business.b.bkP().dI("2", mVar.getForum().getId());
                    }
                }
                if (mVar != null && mVar.getUserData() != null && mVar.getUserData().getNewGodData() != null) {
                    if (mVar.getForum() != null) {
                        v.bFj().setFid(mVar.getForum().getId());
                    }
                    v.bFj().b(2, mVar.getUserData().getNewGodData());
                }
            }
        }
    };
    private CustomMessageListener jwW = new CustomMessageListener(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!FrsTabController.this.jwB && FrsTabController.this.jeQ == null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof m)) {
                m mVar = (m) customResponsedMessage.getData();
                if (mVar.getForum() != null && FrsTabController.this.mForumName != null && FrsTabController.this.mForumName.equals(mVar.getForum().getName())) {
                    FrsTabController.this.a(mVar, false, -1);
                }
            }
        }
    };
    private CustomMessageListener jwX = new CustomMessageListener(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsTabController.this.cHy();
        }
    };
    private CustomMessageListener jwY = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int yI;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (10001 == intValue) {
                    yI = FrsTabController.this.yI(9);
                    if (yI == -1) {
                        yI = FrsTabController.this.yI(2);
                    }
                } else {
                    yI = FrsTabController.this.yI(intValue);
                }
                if (yI != -1 && FrsTabController.this.cHz() && FrsTabController.this.jwA != null) {
                    FrsTabController.this.jwA.setCurrentTab(yI);
                    if (FrsTabController.this.yK(yI) != 1) {
                        FrsTabController.this.jeP.qp(false);
                    }
                }
            }
        }
    };
    private HttpMessageListener jwZ = new HttpMessageListener(0) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && 1021074 == httpResponsedMessage.getCmd() && (httpResponsedMessage instanceof AlaGameTabGetNewNotifyResponsedMessage)) {
                List<a> newNotifyData = ((AlaGameTabGetNewNotifyResponsedMessage) httpResponsedMessage).getNewNotifyData();
                if (!x.isEmpty(newNotifyData) && FrsTabController.this.jwA != null) {
                    for (a aVar : newNotifyData) {
                        if (aVar != null) {
                            for (int i = 0; i < FrsTabController.this.jeO.bAA().size(); i++) {
                                FragmentTabHost.b oo = FrsTabController.this.jwA.oo(i);
                                if (oo != null && oo.mType != 1 && oo.mType != FrsTabController.this.jwA.getCurrentTabType() && oo.mType == aVar.getTabId() && aVar.cHn() && oo.eWU.CW(String.valueOf(oo.mType)) != null) {
                                    oo.eWU.CW(String.valueOf(oo.mType)).view.setVisibility(0);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener jxa = new CustomMessageListener(2921518) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            new BdTopToast(FrsTabController.this.jwz, 2000).yS(false).TQ(FrsTabController.this.jwz.getString(R.string.frs_top_forum_rules_click_toast)).aR((ViewGroup) FrsTabController.this.jwz.findViewById(R.id.frs));
        }
    };
    private Runnable jxb = new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.27
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.adp.lib.f.e.mB().removeCallbacks(this);
            FrsTabController.this.cHx();
            com.baidu.adp.lib.f.e.mB().postDelayed(this, 30000L);
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                FrsTabController.this.jwE = true;
            }
        }
    };
    private CustomMessageListener jxc = new CustomMessageListener(2921369) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.jwF != null && FrsTabController.this.jwG != null && (customResponsedMessage.getData() instanceof FrsTabViewPager.a)) {
                FrsTabViewPager.a aVar = (FrsTabViewPager.a) customResponsedMessage.getData();
                FrsTabController.this.jwI = aVar.cDq();
                FrsTabController.this.jwJ = aVar.cDr();
            }
        }
    };
    private CustomMessageListener jxd = new CustomMessageListener(2921370) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.jwF != null && FrsTabController.this.jwG != null && (customResponsedMessage.getData() instanceof Boolean)) {
                FrsTabController.this.jwF.setForceIntercept(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };
    private CustomMessageListener jxe = new CustomMessageListener(CmdConfigCustom.CMD_NEW_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                FrsTabController.this.e((ForumData) null);
            }
        }
    };
    private CustomMessageListener jxf = new CustomMessageListener(2921498) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsTabController.this.jwO != null && customResponsedMessage != null && customResponsedMessage.getData() != null) {
                if (customResponsedMessage.getData() instanceof ForumData) {
                    FrsTabController.this.e((ForumData) customResponsedMessage.getData());
                } else if (customResponsedMessage.getData() instanceof Long) {
                    long longValue = ((Long) customResponsedMessage.getData()).longValue();
                    if (FrsTabController.this.gq(longValue) && FrsTabController.this.jwO.gr(longValue) >= 3) {
                        FrsTabController.this.jwO.gs(longValue);
                        FrsTabController.this.jwR = true;
                    }
                }
            }
        }
    };
    private CustomMessageListener jxg = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.e)) {
                com.baidu.tieba.tbadkCore.writeModel.e eVar = (com.baidu.tieba.tbadkCore.writeModel.e) customResponsedMessage.getData();
                if (FrsTabController.this.jwO != null && eVar != null && TbadkCoreApplication.isLogin()) {
                    FrsTabController.this.jwO.fe(TbadkCoreApplication.getCurrentAccount(), String.valueOf(eVar.forumId));
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener jxh = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.8
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i != 1) {
                FrsTabController.this.jwH.setVisibility(0);
                if (FrsTabController.this.cAt() != null) {
                    FrsTabController.this.cAt().qj(false);
                }
                FrsTabController.this.jeP.cBM();
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            switch (i) {
                case 0:
                    FrsTabController.this.jwJ = false;
                    FrsTabController.this.jwF.setForceIntercept(false);
                    return;
                default:
                    return;
            }
        }
    };
    private FrsBaseViewPager.a jxi = new FrsBaseViewPager.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.9
        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public void cAP() {
            if (FrsTabController.this.jwF != null) {
                if (FrsTabController.this.jwF.getCurrentItem() == 0) {
                    FrsTabController.this.jwF.setmDisallowSlip(true);
                } else {
                    FrsTabController.this.jwF.setmDisallowSlip(false);
                }
            }
        }

        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public boolean cAQ() {
            if (FrsTabController.this.jwF.getCurrentItem() == 0) {
                if (FrsTabController.this.jwI && FrsTabController.this.jwJ) {
                    FrsTabController.this.jwF.setmDisallowSlip(false);
                }
                if (!FrsTabController.this.jwJ) {
                    FrsTabController.this.jwF.setmDisallowSlip(true);
                }
                FrsTabController.this.jwF.setmDisallowSlip(true);
            } else {
                FrsTabController.this.jwF.setmDisallowSlip(true);
            }
            return true;
        }
    };
    private String jwC = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.SHOW_GAME_FOREM_TAB_HOT_POINT);

    public FrsTabController(FrsActivity frsActivity) {
        this.jwz = frsActivity;
    }

    public void init(Bundle bundle) {
        if (this.jwz != null) {
            this.jwz.setContentView(R.layout.frs_base_layout);
            this.jwF = (FrsBaseViewPager) this.jwz.findViewById(R.id.frs_base_viewpager);
            this.jwG = new FragmentAdapter(this.jwz.getSupportFragmentManager());
            this.jwF.setAdapter(this.jwG);
            this.jwF.setPageTransformer(true, new CubeOutViewPagerTransformer());
            this.jwF.addOnPageChangeListener(this.jxh);
            this.jwF.setmDisallowSlip(true);
            this.jwF.setOnTouchEventListener(this.jxi);
            this.jwH = (OvalActionButton) this.jwz.findViewById(R.id.frs_post_forum_button);
            this.jwH.setIsCircle(true);
            this.jwH.setHasShadow(false);
            this.jeU = (FRSRefreshButton) this.jwz.findViewById(R.id.frs_refresh_forum_button);
            this.jaE = (LinearLayout) this.jwz.findViewById(R.id.frs_ll_redpack);
            this.jwz.registerListener(this.jxc);
            this.jwz.registerListener(this.jxd);
            this.jwV.getHttpMessageListener().setPriority(-1);
            this.jwV.getSocketMessageListener().setPriority(-1);
            this.jwz.registerListener(this.jwW);
            this.jwY.setSelfListener(true);
            this.jwz.registerListener(this.jwY);
            this.jwX.setSelfListener(true);
            this.jwz.registerListener(this.jwX);
            this.jwz.registerListener(this.mAccountChangedListener);
            if (bundle == null) {
                this.mForumName = this.jwz.getIntent().getStringExtra("name");
                this.mFrom = this.jwz.getIntent().getStringExtra("from");
                this.jeR = this.jwz.getIntent().getIntExtra(FrsActivityConfig.FRS_GAME_DEFAULT_TAB_ID, 0);
            } else {
                this.mForumName = bundle.getString("name");
                this.mFrom = bundle.getString("from");
                this.jeR = bundle.getInt("default_tab_id", 0);
            }
            ap(bundle);
            this.jwG.notifyDataSetChanged();
            this.jwD = new ShareSuccessReplyToServerModel();
            this.jwz.registerListener(this.jwV);
            this.jwz.registerListener(this.jwT);
            this.jwz.registerListener(this.jwU);
            this.jwz.registerListener(this.jxa);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.mForumName);
        bundle.putInt("default_tab_id", this.jeR);
        bundle.putString("from", this.mFrom);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap(Bundle bundle) {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.jwG != null) {
            try {
                FrsFragment frsFragment = (FrsFragment) this.jwG.Kd(jwx);
                if (frsFragment == null) {
                    frsFragment = aq(bundle);
                }
                frsFragment.b(this.jwH);
                frsFragment.a(this.jeU);
                frsFragment.c(this.jaE);
                if (!jwx.equals(this.jwG.zK(0))) {
                    if (jwy.equals(this.jwG.zK(0))) {
                        this.jwG.zJ(0);
                    }
                    this.jwG.a(0, frsFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHs() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.jwG != null) {
            try {
                FrsTabHostFragment frsTabHostFragment = (FrsTabHostFragment) this.jwG.Kd(jwy);
                if (frsTabHostFragment == null) {
                    frsTabHostFragment = cHt();
                }
                frsTabHostFragment.b(this.jwH);
                frsTabHostFragment.b(this.jeU);
                if (!jwy.equals(this.jwG.zK(0))) {
                    if (jwx.equals(this.jwG.zK(0))) {
                        this.jwG.zJ(0);
                    }
                    this.jwG.a(0, frsTabHostFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private FrsFragment aq(Bundle bundle) {
        if (this.jeP == null) {
            this.jeP = new FrsFragment();
            this.jeP.setArguments(bundle);
            this.jeP.setBaseTag(jwx);
        }
        this.jeP.jaL = false;
        return this.jeP;
    }

    private FrsTabHostFragment cHt() {
        if (this.jwA == null) {
            this.jwA = new FrsTabHostFragment(this);
            this.jwA.setBaseTag(jwy);
            this.jwA.yM(this.jeR);
        }
        return this.jwA;
    }

    private FragmentManager getFragmentManager() {
        if (this.jwz != null) {
            return this.jwz.getSupportFragmentManager();
        }
        return null;
    }

    private void cHu() {
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.jeQ != null && (themeColorInfo = this.jeQ.getForum().getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            this.jwH.setStartAndEndColor(themeElement.light_color, themeElement.dark_color);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(m mVar, boolean z, int i) {
        if (mVar != null && mVar.getForum() != null) {
            this.jeQ = mVar;
            ForumData forum = mVar.getForum();
            if (!e(mVar)) {
                if (z) {
                    a(forum, mVar.getAnti());
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921476));
            }
            if (forum.getIsShowBawuTask() && com.baidu.tbadk.core.sharedPref.b.brx().getInt("key_bawu_task_toast", 0) == 0 && !this.jwL) {
                this.jwL = true;
                com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.10
                    @Override // java.lang.Runnable
                    public void run() {
                        FrsTabController.this.cHA();
                    }
                }, 30000L);
            }
            if (mVar.bazhuExam != null && !this.jwM && z) {
                com.baidu.tieba.frs.m.a(this.jwz.getPageContext(), mVar.bazhuExam, forum.getId(), forum.getName());
                this.jwM = true;
            }
            if (x.getCount(mVar.getGameTabInfo()) > 0) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.11
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean dC = FrsTabController.this.dC(FrsTabController.this.jeQ.getGameTabInfo());
                        if (dC) {
                            FrsTabController.this.jwG.notifyDataSetChanged();
                            if (dC && FrsTabController.this.jwA != null) {
                                FrsTabController.this.jwA.Y(FrsTabController.this.jeP);
                                FrsTabController.this.jwA.a(FrsTabController.this.jeQ, FrsTabController.this.jeO);
                            }
                        }
                        if (FrsTabController.this.jwz.isLoadingViewAttached()) {
                            FrsTabController.this.jwz.hideLoadingView(FrsTabController.this.jwz.findViewById(16908290));
                        }
                    }
                });
            } else if (cHz()) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.13
                    @Override // java.lang.Runnable
                    public void run() {
                        Bundle bundle;
                        FrsTabController.this.jeP.jaL = true;
                        if (FrsTabController.this.jeP != null) {
                            bundle = FrsTabController.this.jeP.getArguments();
                        } else {
                            bundle = null;
                        }
                        FrsTabController.this.ap(bundle);
                        FrsTabController.this.jwG.notifyDataSetChanged();
                        if (FrsTabController.this.jwz.isLoadingViewAttached()) {
                            FrsTabController.this.jwz.hideLoadingView(FrsTabController.this.jwz.findViewById(16908290));
                        }
                    }
                });
            }
            cHu();
            cHB();
            if (z) {
                if ((!this.jwQ || i == 4) && forum.isLike() == 0 && com.baidu.tbadk.a.d.biQ() && TbadkCoreApplication.isLogin()) {
                    this.jwO = new com.baidu.tieba.frs.d.e();
                    this.jwz.registerListener(this.jxf);
                    this.jwz.registerListener(this.jxe);
                    this.jwz.registerListener(this.jxg);
                    d(forum);
                }
            }
        }
    }

    private boolean e(m mVar) {
        if (mVar == null || mVar.getUserData() == null) {
            return false;
        }
        int is_manager = mVar.getUserData().getIs_manager();
        boolean z = com.baidu.tbadk.core.sharedPref.b.brx().getBoolean("key_forum_tool_find_dialog_show", false);
        if (is_manager == 1 && !z) {
            f(1, this.jwz.getString(R.string.forum_tool_first_bazhu_content), String.valueOf(R.drawable.pic_mask_update), "");
            com.baidu.tbadk.core.sharedPref.b.brx().putBoolean("key_forum_tool_find_dialog_show", true);
            return true;
        } else if (!z && is_manager == 2) {
            f(2, this.jwz.getString(R.string.forum_tool_first_bawu_content), String.valueOf(R.drawable.pic_mask_update), "");
            com.baidu.tbadk.core.sharedPref.b.brx().putBoolean("key_forum_tool_find_dialog_show", true);
            return true;
        } else if (mVar.bawuPopInfo != null) {
            f(3, mVar.bawuPopInfo.content, mVar.bawuPopInfo.img_url, mVar.bawuPopInfo.jump_url);
            return true;
        } else {
            return false;
        }
    }

    private void f(final int i, String str, String str2, final String str3) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jwz);
        aVar.nx(2);
        aVar.jE(false);
        FrsForumToolDialogView frsForumToolDialogView = new FrsForumToolDialogView(this.jwz);
        frsForumToolDialogView.setStartLoadUrl(i, str2);
        frsForumToolDialogView.setContent(str);
        frsForumToolDialogView.setCancleButtonListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aVar != null) {
                    aVar.dismiss();
                }
            }
        });
        frsForumToolDialogView.setConfirmButtonListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.15
            /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.frs.FrsActivity */
            /* JADX DEBUG: Multi-variable search result rejected for r2v6, resolved type: com.baidu.tieba.frs.FrsActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aVar != null) {
                    aVar.dismiss();
                }
                if (i == 1) {
                    be.bsB().b(FrsTabController.this.jwz.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/bawuteam?fn=" + FrsTabController.this.cAt().getForumName() + "&fid=" + FrsTabController.this.cAt().getForumId()});
                } else if (i == 2) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("forum_id", FrsTabController.this.cAt().getForumId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new com.baidu.tieba.tbadkCore.data.m(FrsTabController.this.jwz, OpenFlutter.ACTIVITY_FORUM_DETAIL, hashMap)));
                } else if (i == 3 && !TextUtils.isEmpty(str3)) {
                    be.bsB().b(FrsTabController.this.jwz.getPageContext(), new String[]{str3});
                }
            }
        });
        aVar.br(frsForumToolDialogView);
        aVar.b(this.jwz.getPageContext()).bqe();
    }

    private void a(ForumData forumData, AntiData antiData) {
        if (forumData != null && !com.baidu.tbadk.youngster.b.a.a(this.jwz.getPageContext(), antiData, R.id.frs) && !c(forumData)) {
            List<TipInfo> tipInfos = forumData.getTipInfos();
            if (!x.isEmpty(tipInfos)) {
                com.baidu.tbadk.youngster.b.a.a(this.jwz.getPageContext(), tipInfos.get(0), TbadkCoreApplication.getCurrentAccount(), forumData.getId(), this.jwz.getString(R.string.frs_risk_dialog_button_text));
            }
        }
    }

    private boolean c(ForumData forumData) {
        if (at.isEmpty(forumData.getRiskTipPop()) || at.isEmpty(forumData.getRiskTipPopTitle())) {
            return false;
        }
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jwz);
        aVar.Ac(forumData.getRiskTipPopTitle());
        aVar.setTitleShowCenter(true);
        aVar.setMessageShowCenter(true);
        aVar.Ad(forumData.getRiskTipPop());
        aVar.a(R.string.frs_risk_dialog_button_text, new a.b() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.16
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar.dismiss();
            }
        });
        aVar.b(this.jwz.getPageContext()).bqe();
        return true;
    }

    public m cHv() {
        return this.jeQ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dC(List<FrsTabInfo> list) {
        if (this.jwz.isLoadingViewAttached()) {
            this.jwz.hideLoadingView(this.jwz.findViewById(16908290));
        }
        if (cHz()) {
            return false;
        }
        this.jeP.jaL = true;
        cHw();
        if (com.baidu.tbadk.core.sharedPref.b.brx().getBoolean("frs_game_login_tip", true)) {
            com.baidu.tbadk.core.sharedPref.b.brx().putBoolean(SharedPrefConfig.FRS_LOGIN_TIP, true);
            com.baidu.tbadk.core.sharedPref.b.brx().putBoolean("frs_game_login_tip", false);
        }
        dD(list);
        return true;
    }

    private void cHw() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021074, TbConfig.SERVER_ADDRESS + "game/forum/getNewNotify");
        tbHttpMessageTask.setResponsedClass(AlaGameTabGetNewNotifyResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.jwz.registerListener(1021074, this.jwZ);
    }

    private void dD(List<FrsTabInfo> list) {
        boolean z;
        if (!x.isEmpty(list)) {
            CustomMessageListener customMessageListener = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.17
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ai)) {
                        if (!com.baidu.tbadk.core.sharedPref.b.brx().getBoolean(FrsTabController.this.jwC, true)) {
                            com.baidu.adp.lib.f.e.mB().post(FrsTabController.this.jxb);
                        }
                        ((ai) customResponsedMessage.getData()).b(new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.17.1
                            @Override // com.baidu.tbadk.mainTab.b
                            public boolean isAvailable() {
                                return true;
                            }

                            @Override // com.baidu.tbadk.mainTab.b
                            public com.baidu.tbadk.mainTab.c createFragmentTabStructure() {
                                FrsSportsRecommendFragment frsSportsRecommendFragment = new FrsSportsRecommendFragment();
                                Bundle bundle = new Bundle();
                                bundle.putString("name", FrsTabController.this.jeP.getForumName());
                                bundle.putString("from", FrsTabController.this.jeP.getFrom());
                                bundle.putString("forum_id", FrsTabController.this.jeP.getForumId());
                                bundle.putInt("tab_id", 503);
                                bundle.putBoolean("can_auto_play_video", FrsTabController.this.jeQ.isFrsVideoAutoPlay);
                                bundle.putBoolean("need_log", FrsTabController.this.jeQ.needLog == 1);
                                bundle.putBoolean("is_brand_forum", FrsTabController.this.jeQ.isBrandForum);
                                FrsViewData frsViewData = new FrsViewData();
                                frsViewData.receiveData(FrsTabController.this.jeQ);
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
                        FrsTabController.this.cHs();
                    }
                }
            };
            customMessageListener.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            customMessageListener.setSelfListener(true);
            this.jwz.registerListener(customMessageListener);
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
            this.jeO = new ai(this.jwz.getActivity(), arrayList);
            if (cAt() != null) {
                this.jeO.setForumId(cAt().getForumId());
                this.jeO.setForumName(cAt().getForumName());
                if (cAt().cBN() != null && cAt().cBN().getForum() != null) {
                    ForumData forum = cAt().cBN().getForum();
                    this.jeO.setForumGameLabel(forum.getForumGameLabel());
                    this.jeO.HI(forum.getSpecialForumType());
                }
            }
            this.jeP.jaL = false;
            new e(this.jeP).a(this.jeO);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB, this.jeO);
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB);
            customMessage.setTag(this.jwz.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHx() {
        if (this.jeO != null && !TextUtils.isEmpty(this.jeO.getForumId())) {
            HttpMessage httpMessage = new HttpMessage(1021074);
            httpMessage.addParam("forum_id", this.jeQ.getForum().getId());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    private void a(Fragment fragment, int i) {
        NavigationBar bUz;
        if ((fragment instanceof ap) && this.jeQ != null && this.jeQ.getForum() != null && (bUz = ((ap) fragment).bUz()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.jeQ.getForum().getName(), 5, true, true) + this.jwz.getActivity().getString(R.string.forum));
            bUz.setCenterTextTitle(sb.toString());
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.jeP instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.jeP.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a sH(int i) {
        if (this.jeP instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.jeP.sH(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.jeP instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.jeP.a(bVar);
        }
    }

    public void onNewIntent(Intent intent) {
        if (this.jeP != null) {
            this.jeP.onNewIntent(intent);
        }
    }

    public void onResume() {
        if (!cHz()) {
            this.jeP.setPrimary(true);
        } else if (this.jwA != null) {
            Fragment currentFragment = this.jwA.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(true);
            }
        }
        if (this.jwE) {
            this.jwE = false;
            if (this.jeP != null) {
                this.jeP.refresh();
            }
        }
        if (this.jeQ != null && this.jeQ.getUserData() != null && this.jeQ.getUserData().getNewGodData() != null) {
            if (this.jeQ.getForum() != null) {
                v.bFj().setFid(this.jeQ.getForum().getId());
            }
            v.bFj().b(2, this.jeQ.getUserData().getNewGodData());
        }
        this.jwS = true;
        if (this.jwR) {
            e((ForumData) null);
        }
    }

    public void onPause() {
        this.jwS = false;
        if (this.jwO != null) {
            this.jwO.cJo();
        }
        if (!cHz()) {
            this.jeP.setPrimary(false);
        } else if (this.jwA != null) {
            Fragment currentFragment = this.jwA.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(false);
            }
        }
        v.bFj().removeCallbacks();
    }

    public void onChangeSkinType(int i) {
        UtilHelper.changeStatusBarIconAndTextColor(true, this.jwz);
        if (this.jeP != null) {
            this.jeP.onChangeSkinType(i);
        }
        if (this.jwA != null) {
            this.jwA.onChangeSkinType(i);
        }
        cHu();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (cHz() && this.jwA != null && this.jwA.cCT()) {
                this.jwA.cDl();
                UtilHelper.setNavigationBarBackground(this.jwz, this.jwA.cDg());
            } else if (this.jeP != null && this.jeP.isAdded()) {
                if (this.jeP.onKeyDown(i, keyEvent)) {
                    return true;
                }
                cHy();
            } else {
                return this.jwz.b(i, keyEvent);
            }
        } else if (i == 24) {
            if (this.jeP != null && this.jeP.isAdded()) {
                return this.jeP.onKeyDown(i, keyEvent);
            }
        } else {
            return this.jwz.b(i, keyEvent);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHy() {
        if (this.jeS != this.jeR && cHz()) {
            this.jwA.setCurrentTab(this.jeR);
            if (yK(this.jeR) != 1) {
                this.jeP.qp(false);
            }
            this.jeS = this.jeR;
            a(this.jwA.getCurrentFragment(), this.jeR);
            return;
        }
        this.jeP.closeActivity();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!cHz()) {
            this.jeP.onActivityResult(i, i2, intent);
        } else if (this.jwA != null) {
            if (1 == this.jwA.getCurrentTabType()) {
                this.jeP.onActivityResult(i, i2, intent);
            } else {
                this.jwA.getCurrentFragment().onActivityResult(i, i2, intent);
            }
        }
        if (i2 == -1) {
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1) {
                    com.baidu.tieba.o.a.dAJ().E(this.jwz.getPageContext());
                    ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.linkUrl != null && this.jwD != null) {
                        this.jwD.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.18
                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void byn() {
                            }

                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void a(final CustomDialogData customDialogData) {
                                com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.18.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (FrsTabController.this.jwz != null) {
                                            com.baidu.tieba.pb.interactionpopupwindow.c.a(FrsTabController.this.jwz.getPageContext(), customDialogData).show();
                                        }
                                    }
                                }, 1000L);
                            }
                        });
                    }
                }
            } else if (i == 13011) {
                com.baidu.tieba.o.a.dAJ().E(this.jwz.getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (!cHz()) {
            return this.jeP.getVoiceManager();
        }
        if (this.jwA == null) {
            return null;
        }
        Fragment currentFragment = this.jwA.getCurrentFragment();
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
    public int yI(int i) {
        if (this.jeO == null) {
            return -1;
        }
        int count = x.getCount(this.jeO.bAA());
        for (int i2 = 0; i2 < count; i2++) {
            if (this.jeO.bAA().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int yK(int i) {
        if (this.jeO != null && i < x.getCount(this.jeO.bAA())) {
            return this.jeO.bAA().get(i).tab_id.intValue();
        }
        return -1;
    }

    public FrsFragment cAt() {
        return this.jeP;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> cAu() {
        if (!cHz()) {
            if (this.jeP instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) this.jeP).cAu();
            }
        } else if (this.jwA == null) {
            return null;
        } else {
            Fragment currentFragment = this.jwA.getCurrentFragment();
            if (currentFragment instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) currentFragment).cAu();
            }
        }
        return null;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(FrsNoListItemViewHolder.jea);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.jwz.isLoadingViewAttached()) {
            this.jwz.hideLoadingView(this.jwz.findViewById(16908290));
        }
        if (this.jxb != null) {
            com.baidu.adp.lib.f.e.mB().removeCallbacks(this.jxb);
        }
        com.baidu.tbadk.core.sharedPref.b.brx().putBoolean(this.jwC, false);
        if (this.jwD != null) {
            this.jwD.cancelLoadData();
        }
        if (this.jeP != null && this.jeP.cBd() != null) {
            this.jeP.cBd().cHM();
        }
        if (this.jwK != null) {
            this.jwK.onDestroy();
        }
        if (FrsActivityConfig.FRS_FROM_FLUTTER_BCASTEDIT.equals(this.mFrom)) {
            new o(TbadkCoreApplication.getInst()).brN();
        }
        if (FrsActivityConfig.FRS_FROM_FORUM_RULE_EDIT.equals(this.mFrom)) {
            com.baidu.tbadk.k.d.bCj().la(false);
        }
        if (this.jwP != null) {
            com.baidu.adp.lib.f.e.mB().removeCallbacks(this.jwP);
        }
        if (this.jeQ != null && this.jeQ.getForum() != null && this.jwO != null) {
            this.jwO.gs(com.baidu.adp.lib.f.b.toLong(this.jeQ.getForum().getId(), 0L));
        }
    }

    public FragmentTabHost cDj() {
        if (this.jwA == null) {
            return null;
        }
        return this.jwA.cDj();
    }

    public boolean cHz() {
        if (this.jwG == null) {
            return false;
        }
        return this.jwG.getItem(0) instanceof FrsTabHostFragment;
    }

    public void yM(int i) {
        this.jeR = i;
    }

    public void zH(int i) {
        this.jeS = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHA() {
        if (this.jwz != null) {
            if (this.jwK == null) {
                this.jwK = (NavigationBarCoverTip) this.jwz.findViewById(R.id.navigation_cover_tip);
            }
            if (this.jwK != null) {
                View inflate = View.inflate(this.jwz, R.layout.write_thread_share_guide, null);
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
                cVar.buE();
                tBSpecificationBtn.setConfig(cVar);
                tBSpecificationBtn.btV();
                ao.setViewTextColor(textView, R.color.CAM_X0101);
                ao.setBackgroundColor(this.jwK, R.color.cp_link_tip_a_alpha95);
                tBSpecificationBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.19
                    /* JADX DEBUG: Multi-variable search result rejected for r4v9, resolved type: com.baidu.tieba.frs.FrsActivity */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        new aq("c13439").bsu();
                        if (FrsTabController.this.cAt() != null && !TextUtils.isEmpty(FrsTabController.this.cAt().getForumId()) && !TextUtils.isEmpty(FrsTabController.this.mForumName) && FrsTabController.this.jwz != null) {
                            if (FrsTabController.this.jwK != null) {
                                FrsTabController.this.jwK.hideTip();
                            }
                            be.bsB().b(FrsTabController.this.jwz.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/bawutask?fid=" + FrsTabController.this.cAt().getForumId() + "&fn=" + FrsTabController.this.mForumName + "&noread=" + (com.baidu.tbadk.core.sharedPref.b.brx().getInt("key_bawu_task_toast", 0) == -1 ? 1 : 0)});
                        }
                    }
                });
                this.jwK.a(this.jwz, inflate, 30000);
                new aq("c13438").bsu();
                int i = com.baidu.tbadk.core.sharedPref.b.brx().getInt("key_bawu_task_toast", 0);
                if (i >= 0) {
                    com.baidu.tbadk.core.sharedPref.b.brx().putInt("key_bawu_task_toast", i + 1);
                }
            }
        }
    }

    private void cHB() {
        boolean z;
        if (this.jeQ != null && this.jeQ.getEntelechyTabInfo() != null && this.jeQ.getEntelechyTabInfo().tab != null) {
            Iterator<FrsTabInfo> it = this.jeQ.getEntelechyTabInfo().tab.iterator();
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
                if (this.jwN == null) {
                    this.jwN = new com.baidu.tieba.c.e(this.jwz.getPageContext(), this.jwH);
                    this.jwN.ej(R.drawable.pic_sign_tip_down);
                    this.jwN.wX(2);
                    this.jwN.setUseDirectOffset(true);
                    this.jwN.xb(-l.getDimens(this.jwz, R.dimen.tbds20));
                    this.jwN.setYOffset(-l.getDimens(this.jwz, R.dimen.tbds20));
                    this.jwN.setTextColor(R.color.CAM_X0101);
                    this.jwN.setHeight(R.dimen.tbds54);
                    this.jwN.wZ(l.getDimens(this.jwz, R.dimen.tbds44));
                }
                this.jwN.aJ(this.jwz.getString(R.string.frs_evaluate_tip), "first_into_frs_with_evaluate_tab");
            }
        }
    }

    private void d(final ForumData forumData) {
        boolean z = false;
        if (i(forumData.getName(), forumData.getId(), forumData.getImage_url(), false)) {
            if (this.jwP != null) {
                com.baidu.adp.lib.f.e.mB().removeCallbacks(this.jwP);
            }
            z = true;
        }
        if (!this.jwQ) {
            this.jwO.cJn().j(TbadkCoreApplication.getCurrentAccount(), forumData.getId(), System.currentTimeMillis());
            this.jwQ = true;
        }
        if (!z) {
            this.jwP = this.jwP != null ? this.jwP : new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.20
                @Override // java.lang.Runnable
                public void run() {
                    if (FrsTabController.this.jwO != null) {
                        if (FrsTabController.this.jwS) {
                            FrsTabController.this.i(forumData.getName(), forumData.getId(), forumData.getImage_url(), true);
                        } else {
                            FrsTabController.this.jwR = true;
                        }
                    }
                }
            };
            com.baidu.adp.lib.f.e.mB().postDelayed(this.jwP, AppStatusRules.DEFAULT_GRANULARITY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ForumData forumData) {
        if (this.jeP.cBf() != null && this.jwO != null) {
            if (forumData == null) {
                forumData = this.jeQ.getForum();
            }
            if (forumData != null && forumData.isLike() != 1) {
                if (!this.jwS) {
                    this.jwR = true;
                } else if (i(forumData.getName(), forumData.getId(), forumData.getImage_url(), false) && this.jwP != null) {
                    com.baidu.adp.lib.f.e.mB().removeCallbacks(this.jwP);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i(String str, String str2, String str3, boolean z) {
        if (!this.jwO.ff(TbadkCoreApplication.getCurrentAccount(), str2) || this.jeP == null || this.jeP.cBf() == null) {
            return false;
        }
        this.jwR = false;
        this.jwO.a(this.jwz, str, str2, str3, this.jeP.cBf().cKg());
        this.jwO.cJn().e(TbadkCoreApplication.getCurrentAccount(), str2, System.currentTimeMillis(), z);
        return true;
    }

    public boolean gq(long j) {
        ForumData forum;
        return (this.jeQ == null || j == 0 || (forum = this.jeQ.getForum()) == null || com.baidu.adp.lib.f.b.toLong(forum.getId(), 0L) != j) ? false : true;
    }

    /* loaded from: classes2.dex */
    public class FragmentAdapter extends FragmentStatePagerAdapter {
        private List<BaseFragment> mFragments;

        public FragmentAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.mFragments = new ArrayList(2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.fragment.app.FragmentStatePagerAdapter
        /* renamed from: zI */
        public BaseFragment getItem(int i) {
            return (BaseFragment) x.getItem(this.mFragments, i);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.mFragments.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }

        public boolean a(int i, BaseFragment baseFragment) {
            return x.add(this.mFragments, i, baseFragment);
        }

        public BaseFragment Kd(String str) {
            if (at.isEmpty(str)) {
                return null;
            }
            for (BaseFragment baseFragment : this.mFragments) {
                if (baseFragment != null && str.equals(baseFragment.getBaseTag())) {
                    return baseFragment;
                }
            }
            return null;
        }

        public BaseFragment zJ(int i) {
            return (BaseFragment) x.remove(this.mFragments, i);
        }

        public String zK(int i) {
            if (getItem(i) != null) {
                return getItem(i).getBaseTag();
            }
            return null;
        }
    }

    public TbPageTag getTbPageTag() {
        if (!cHz()) {
            return this.jeP.getTbPageTag();
        }
        if (this.jwA != null) {
            if (1 == this.jwA.getCurrentTabType()) {
                return this.jeP.getTbPageTag();
            }
            Fragment currentFragment = this.jwA.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                return ((BaseFragment) currentFragment).getTbPageTag();
            }
        }
        return null;
    }

    public void onScreenShot(String str) {
        if (this.jeQ != null && this.jeQ.getForum() != null) {
            TiebaStatic.log(new aq("c13848").dW("uid", TbadkCoreApplication.getCurrentAccount()).dW("fid", this.jeQ.getForum().getId()).an("obj_type", 2));
        }
    }
}
