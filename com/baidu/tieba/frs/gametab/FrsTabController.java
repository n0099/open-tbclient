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
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
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
import com.baidu.tbadk.util.w;
import com.baidu.tbadk.widget.FRSRefreshButton;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.CubeOutViewPagerTransformer;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsBaseViewPager;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.FrsRecommendResMsg;
import com.baidu.tieba.frs.FrsTabHostFragment;
import com.baidu.tieba.frs.FrsTabViewPager;
import com.baidu.tieba.frs.am;
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
import tbclient.FrsPage.TipInfo;
import tbclient.FrsTabInfo;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes22.dex */
public class FrsTabController implements VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, FrsCommonImageLayout.c {
    public static final String iUt = FrsFragment.class.getSimpleName();
    public static final String iUu = FrsTabHostFragment.class.getSimpleName();
    private LinearLayout iBv;
    private am iFG;
    private FrsFragment iFH;
    private m iFI;
    private int iFK;
    private FRSRefreshButton iFM;
    private FrsBaseViewPager iUB;
    private FragmentAdapter iUC;
    private OvalActionButton iUD;
    private boolean iUE;
    private boolean iUF;
    private NavigationBarCoverTip iUG;
    private com.baidu.tieba.c.e iUJ;
    private com.baidu.tieba.frs.f.d iUK;
    private Runnable iUL;
    private boolean iUM;
    private FrsActivity iUv;
    private FrsTabHostFragment iUw;
    private ShareSuccessReplyToServerModel iUz;
    private String mForumName;
    private String mFrom;
    private boolean iUx = false;
    private final Handler mHandler = new Handler();
    private int iFJ = 0;
    private boolean iUA = false;
    private boolean iUH = false;
    private boolean iUI = false;
    private boolean iUN = false;
    private boolean iUO = false;
    private HttpMessageListener iUP = new HttpMessageListener(CmdConfigHttp.CMD_FRS_RECOMMEND) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof FrsRecommendResMsg) {
                if (httpResponsedMessage.getError() != 0) {
                    new BdTopToast(FrsTabController.this.iUv).yb(false).Uc(httpResponsedMessage.getErrorString()).aH((ViewGroup) FrsTabController.this.iUv.findViewById(R.id.frs));
                    return;
                }
                int pushStatus = ((FrsRecommendResMsg) httpResponsedMessage).getPushStatus();
                String pushMsg = ((FrsRecommendResMsg) httpResponsedMessage).getPushMsg();
                if (pushStatus == 1) {
                    new ScreenTopToast(FrsTabController.this.iUv).Ug(FrsTabController.this.iUv.getString(R.string.frs_recommend_suc_tip_title)).Uh(FrsTabController.this.iUv.getString(R.string.frs_recommend_suc_tip_content)).Ui(FrsTabController.this.iUv.getString(R.string.dialog_confirm_see)).ak(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.1.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("_forumId", FrsTabController.this.iFI.getForum().getId());
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new com.baidu.tieba.tbadkCore.data.m(FrsTabController.this.iUv, "RecommendHistoryPage", hashMap)));
                        }
                    }).aH((ViewGroup) FrsTabController.this.iUv.findViewById(R.id.frs));
                } else {
                    new BdTopToast(FrsTabController.this.iUv).yb(false).Uc(pushMsg).aH((ViewGroup) FrsTabController.this.iUv.findViewById(R.id.frs));
                }
            }
        }
    };
    private CustomMessageListener iUQ = new CustomMessageListener(2921465) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            new ScreenTopToast(FrsTabController.this.iUv).Ug(FrsTabController.this.iUv.getString(R.string.frs_recommend_fail_month_tip)).Ui(FrsTabController.this.iUv.getString(R.string.frs_recommend_fail_tip_btn)).ak(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.12.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("_forumId", FrsTabController.this.iFI.getForum().getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new com.baidu.tieba.tbadkCore.data.m(FrsTabController.this.iUv, "ForumGradePage", hashMap)));
                }
            }).aH((ViewGroup) FrsTabController.this.iUv.findViewById(R.id.frs));
        }
    };
    private com.baidu.adp.framework.listener.a iUR = new com.baidu.adp.framework.listener.a(1001703, CmdConfigSocket.CMD_FRS_PAGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.18
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            m mVar = null;
            int i = -1;
            if (!FrsTabController.this.iUx && !responsedMessage.hasError() && responsedMessage.getError() == 0) {
                if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                    mVar = ((FrsPageHttpResponseMessage) responsedMessage).getResponseData();
                    i = ((FrsPageHttpResponseMessage) responsedMessage).getUpdateType();
                } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                    mVar = ((FRSPageSocketResponsedMessage) responsedMessage).getResponseData();
                    i = ((FRSPageSocketResponsedMessage) responsedMessage).getUpdateType();
                }
                if (mVar != null) {
                    FrsTabController.this.iUx = true;
                    FrsTabController.this.a(mVar, true, i);
                    if (mVar != null && mVar.getForum() != null && !StringUtils.isNull(mVar.getForum().getId())) {
                        com.baidu.tbadk.core.business.a.bht().dF("2", mVar.getForum().getId());
                    }
                }
                if (mVar != null && mVar.getUserData() != null && mVar.getUserData().getNewGodData() != null) {
                    if (mVar.getForum() != null) {
                        w.bBo().setFid(mVar.getForum().getId());
                    }
                    w.bBo().b(2, mVar.getUserData().getNewGodData());
                }
            }
        }
    };
    private CustomMessageListener iUS = new CustomMessageListener(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!FrsTabController.this.iUx && FrsTabController.this.iFI == null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof m)) {
                m mVar = (m) customResponsedMessage.getData();
                if (mVar.getForum() != null && FrsTabController.this.mForumName != null && FrsTabController.this.mForumName.equals(mVar.getForum().getName())) {
                    FrsTabController.this.a(mVar, false, -1);
                }
            }
        }
    };
    private CustomMessageListener iUT = new CustomMessageListener(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsTabController.this.cAW();
        }
    };
    private CustomMessageListener iUU = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int yM;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (10001 == intValue) {
                    yM = FrsTabController.this.yM(9);
                    if (yM == -1) {
                        yM = FrsTabController.this.yM(2);
                    }
                } else {
                    yM = FrsTabController.this.yM(intValue);
                }
                if (yM != -1 && FrsTabController.this.cAX() && FrsTabController.this.iUw != null) {
                    FrsTabController.this.iUw.setCurrentTab(yM);
                    if (FrsTabController.this.yO(yM) != 1) {
                        FrsTabController.this.iFH.pn(false);
                    }
                }
            }
        }
    };
    private HttpMessageListener iUV = new HttpMessageListener(0) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && 1021074 == httpResponsedMessage.getCmd() && (httpResponsedMessage instanceof AlaGameTabGetNewNotifyResponsedMessage)) {
                List<a> newNotifyData = ((AlaGameTabGetNewNotifyResponsedMessage) httpResponsedMessage).getNewNotifyData();
                if (!y.isEmpty(newNotifyData) && FrsTabController.this.iUw != null) {
                    for (a aVar : newNotifyData) {
                        if (aVar != null) {
                            for (int i = 0; i < FrsTabController.this.iFG.bwJ().size(); i++) {
                                FragmentTabHost.b oF = FrsTabController.this.iUw.oF(i);
                                if (oF != null && oF.mType != 1 && oF.mType != FrsTabController.this.iUw.getCurrentTabType() && oF.mType == aVar.getTabId() && aVar.cAN() && oF.eFD.DQ(String.valueOf(oF.mType)) != null) {
                                    oF.eFD.DQ(String.valueOf(oF.mType)).view.setVisibility(0);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private Runnable iUW = new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.23
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this);
            FrsTabController.this.cAV();
            com.baidu.adp.lib.f.e.mY().postDelayed(this, 30000L);
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                FrsTabController.this.iUA = true;
            }
        }
    };
    private CustomMessageListener iUX = new CustomMessageListener(2921369) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.iUB != null && FrsTabController.this.iUC != null && (customResponsedMessage.getData() instanceof FrsTabViewPager.a)) {
                FrsTabViewPager.a aVar = (FrsTabViewPager.a) customResponsedMessage.getData();
                FrsTabController.this.iUE = aVar.cxR();
                FrsTabController.this.iUF = aVar.cxS();
            }
        }
    };
    private CustomMessageListener iUY = new CustomMessageListener(2921370) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.iUB != null && FrsTabController.this.iUC != null && (customResponsedMessage.getData() instanceof Boolean)) {
                FrsTabController.this.iUB.setForceIntercept(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };
    private CustomMessageListener iUZ = new CustomMessageListener(CmdConfigCustom.CMD_NEW_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                FrsTabController.this.e((ForumData) null);
            }
        }
    };
    private CustomMessageListener iVa = new CustomMessageListener(2921498) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsTabController.this.iUK != null && customResponsedMessage != null && customResponsedMessage.getData() != null) {
                if (customResponsedMessage.getData() instanceof ForumData) {
                    FrsTabController.this.e((ForumData) customResponsedMessage.getData());
                } else if (customResponsedMessage.getData() instanceof Long) {
                    long longValue = ((Long) customResponsedMessage.getData()).longValue();
                    if (FrsTabController.this.fm(longValue) && FrsTabController.this.iUK.fn(longValue) >= 3) {
                        FrsTabController.this.iUK.fo(longValue);
                        FrsTabController.this.iUN = true;
                    }
                }
            }
        }
    };
    private CustomMessageListener iVb = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                if (FrsTabController.this.iUK != null && aVar != null && TbadkCoreApplication.isLogin()) {
                    FrsTabController.this.iUK.eY(TbadkCoreApplication.getCurrentAccount(), String.valueOf(aVar.forumId));
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener iVc = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.7
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i != 1) {
                FrsTabController.this.iUD.setVisibility(0);
                if (FrsTabController.this.cuX() != null) {
                    FrsTabController.this.cuX().ph(false);
                }
                FrsTabController.this.iFH.cwn();
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            switch (i) {
                case 0:
                    FrsTabController.this.iUF = false;
                    FrsTabController.this.iUB.setForceIntercept(false);
                    return;
                default:
                    return;
            }
        }
    };
    private FrsBaseViewPager.a iVd = new FrsBaseViewPager.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.8
        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public void cvs() {
            if (FrsTabController.this.iUB != null) {
                if (FrsTabController.this.iUB.getCurrentItem() == 0) {
                    FrsTabController.this.iUB.setmDisallowSlip(true);
                } else {
                    FrsTabController.this.iUB.setmDisallowSlip(false);
                }
            }
        }

        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public boolean cvt() {
            if (FrsTabController.this.iUB.getCurrentItem() == 0) {
                if (FrsTabController.this.iUE && FrsTabController.this.iUF) {
                    FrsTabController.this.iUB.setmDisallowSlip(false);
                }
                if (!FrsTabController.this.iUF) {
                    FrsTabController.this.iUB.setmDisallowSlip(true);
                }
                FrsTabController.this.iUB.setmDisallowSlip(true);
            } else {
                FrsTabController.this.iUB.setmDisallowSlip(true);
            }
            return true;
        }
    };
    private String iUy = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.SHOW_GAME_FOREM_TAB_HOT_POINT);

    public FrsTabController(FrsActivity frsActivity) {
        this.iUv = frsActivity;
    }

    public void init(Bundle bundle) {
        if (this.iUv != null) {
            this.iUv.setContentView(R.layout.frs_base_layout);
            this.iUB = (FrsBaseViewPager) this.iUv.findViewById(R.id.frs_base_viewpager);
            this.iUC = new FragmentAdapter(this.iUv.getSupportFragmentManager());
            this.iUB.setAdapter(this.iUC);
            this.iUB.setPageTransformer(true, new CubeOutViewPagerTransformer());
            this.iUB.addOnPageChangeListener(this.iVc);
            this.iUB.setmDisallowSlip(true);
            this.iUB.setOnTouchEventListener(this.iVd);
            this.iUD = (OvalActionButton) this.iUv.findViewById(R.id.frs_post_forum_button);
            this.iUD.setIsCircle(true);
            this.iUD.setHasShadow(false);
            this.iFM = (FRSRefreshButton) this.iUv.findViewById(R.id.frs_refresh_forum_button);
            this.iBv = (LinearLayout) this.iUv.findViewById(R.id.frs_ll_redpack);
            this.iUv.registerListener(this.iUX);
            this.iUv.registerListener(this.iUY);
            this.iUR.getHttpMessageListener().setPriority(-1);
            this.iUR.getSocketMessageListener().setPriority(-1);
            this.iUv.registerListener(this.iUS);
            this.iUU.setSelfListener(true);
            this.iUv.registerListener(this.iUU);
            this.iUT.setSelfListener(true);
            this.iUv.registerListener(this.iUT);
            this.iUv.registerListener(this.mAccountChangedListener);
            if (bundle == null) {
                this.mForumName = this.iUv.getIntent().getStringExtra("name");
                this.mFrom = this.iUv.getIntent().getStringExtra("from");
                this.iFJ = this.iUv.getIntent().getIntExtra(FrsActivityConfig.FRS_GAME_DEFAULT_TAB_ID, 0);
            } else {
                this.mForumName = bundle.getString("name");
                this.mFrom = bundle.getString("from");
                this.iFJ = bundle.getInt("default_tab_id", 0);
            }
            an(bundle);
            this.iUC.notifyDataSetChanged();
            this.iUz = new ShareSuccessReplyToServerModel();
            this.iUv.registerListener(this.iUR);
            this.iUv.registerListener(this.iUP);
            this.iUv.registerListener(this.iUQ);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.mForumName);
        bundle.putInt("default_tab_id", this.iFJ);
        bundle.putString("from", this.mFrom);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void an(Bundle bundle) {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.iUC != null) {
            try {
                FrsFragment frsFragment = (FrsFragment) this.iUC.Kp(iUt);
                if (frsFragment == null) {
                    frsFragment = ao(bundle);
                }
                frsFragment.b(this.iUD);
                frsFragment.a(this.iFM);
                frsFragment.c(this.iBv);
                if (!iUt.equals(this.iUC.zF(0))) {
                    if (iUu.equals(this.iUC.zF(0))) {
                        this.iUC.zE(0);
                    }
                    this.iUC.a(0, frsFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAQ() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.iUC != null) {
            try {
                FrsTabHostFragment frsTabHostFragment = (FrsTabHostFragment) this.iUC.Kp(iUu);
                if (frsTabHostFragment == null) {
                    frsTabHostFragment = cAR();
                }
                frsTabHostFragment.b(this.iUD);
                frsTabHostFragment.b(this.iFM);
                if (!iUu.equals(this.iUC.zF(0))) {
                    if (iUt.equals(this.iUC.zF(0))) {
                        this.iUC.zE(0);
                    }
                    this.iUC.a(0, frsTabHostFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private FrsFragment ao(Bundle bundle) {
        if (this.iFH == null) {
            this.iFH = new FrsFragment();
            this.iFH.setArguments(bundle);
            this.iFH.setBaseTag(iUt);
        }
        this.iFH.iBC = false;
        return this.iFH;
    }

    private FrsTabHostFragment cAR() {
        if (this.iUw == null) {
            this.iUw = new FrsTabHostFragment(this);
            this.iUw.setBaseTag(iUu);
            this.iUw.yQ(this.iFJ);
        }
        return this.iUw;
    }

    private FragmentManager getFragmentManager() {
        if (this.iUv != null) {
            return this.iUv.getSupportFragmentManager();
        }
        return null;
    }

    private void cAS() {
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.iFI != null && (themeColorInfo = this.iFI.getForum().getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            this.iUD.setStartAndEndColor(themeElement.light_color, themeElement.dark_color);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(m mVar, boolean z, int i) {
        if (mVar != null && mVar.getForum() != null) {
            ForumData forum = mVar.getForum();
            if (z) {
                a(forum, mVar.getAnti());
            }
            if (forum.getIsShowBawuTask() && com.baidu.tbadk.core.sharedPref.b.bnH().getInt("key_bawu_task_toast", 0) == 0 && !this.iUH) {
                this.iUH = true;
                com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.9
                    @Override // java.lang.Runnable
                    public void run() {
                        FrsTabController.this.cAY();
                    }
                }, 30000L);
            }
            if (mVar.bazhuExam != null && !this.iUI && z) {
                com.baidu.tieba.frs.m.a(this.iUv.getPageContext(), mVar.bazhuExam, forum.getId(), forum.getName());
                this.iUI = true;
            }
            this.iFI = mVar;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921476));
            if (y.getCount(mVar.getGameTabInfo()) > 0) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.10
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean dd = FrsTabController.this.dd(FrsTabController.this.iFI.getGameTabInfo());
                        if (dd) {
                            FrsTabController.this.iUC.notifyDataSetChanged();
                            if (dd && FrsTabController.this.iUw != null) {
                                FrsTabController.this.iUw.Z(FrsTabController.this.iFH);
                                FrsTabController.this.iUw.a(FrsTabController.this.iFI, FrsTabController.this.iFG);
                            }
                        }
                        if (FrsTabController.this.iUv.isLoadingViewAttached()) {
                            FrsTabController.this.iUv.hideLoadingView(FrsTabController.this.iUv.findViewById(16908290));
                        }
                    }
                });
            } else if (cAX()) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.11
                    @Override // java.lang.Runnable
                    public void run() {
                        Bundle bundle;
                        FrsTabController.this.iFH.iBC = true;
                        if (FrsTabController.this.iFH != null) {
                            bundle = FrsTabController.this.iFH.getArguments();
                        } else {
                            bundle = null;
                        }
                        FrsTabController.this.an(bundle);
                        FrsTabController.this.iUC.notifyDataSetChanged();
                        if (FrsTabController.this.iUv.isLoadingViewAttached()) {
                            FrsTabController.this.iUv.hideLoadingView(FrsTabController.this.iUv.findViewById(16908290));
                        }
                    }
                });
            }
            cAS();
            cAZ();
            if (z) {
                if ((!this.iUM || i == 4) && forum.isLike() == 0 && com.baidu.tbadk.a.d.bfz() && TbadkCoreApplication.isLogin()) {
                    this.iUK = new com.baidu.tieba.frs.f.d();
                    this.iUv.registerListener(this.iVa);
                    this.iUv.registerListener(this.iUZ);
                    this.iUv.registerListener(this.iVb);
                    d(forum);
                }
            }
        }
    }

    private void a(ForumData forumData, AntiData antiData) {
        if (forumData != null && !com.baidu.tbadk.youngster.b.a.a(this.iUv.getPageContext(), antiData, R.id.frs) && !c(forumData)) {
            List<TipInfo> tipInfos = forumData.getTipInfos();
            if (!y.isEmpty(tipInfos)) {
                com.baidu.tbadk.youngster.b.a.a(this.iUv.getPageContext(), tipInfos.get(0), TbadkCoreApplication.getCurrentAccount(), forumData.getId(), this.iUv.getString(R.string.frs_risk_dialog_button_text));
            }
        }
    }

    private boolean c(ForumData forumData) {
        if (at.isEmpty(forumData.getRiskTipPop()) || at.isEmpty(forumData.getRiskTipPopTitle())) {
            return false;
        }
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iUv);
        aVar.AZ(forumData.getRiskTipPopTitle());
        aVar.setTitleShowCenter(true);
        aVar.setMessageShowCenter(true);
        aVar.Ba(forumData.getRiskTipPop());
        aVar.a(R.string.frs_risk_dialog_button_text, new a.b() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.13
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar.dismiss();
            }
        });
        aVar.b(this.iUv.getPageContext()).bmC();
        return true;
    }

    public m cAT() {
        return this.iFI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dd(List<FrsTabInfo> list) {
        if (this.iUv.isLoadingViewAttached()) {
            this.iUv.hideLoadingView(this.iUv.findViewById(16908290));
        }
        if (cAX()) {
            return false;
        }
        this.iFH.iBC = true;
        cAU();
        if (com.baidu.tbadk.core.sharedPref.b.bnH().getBoolean("frs_game_login_tip", true)) {
            com.baidu.tbadk.core.sharedPref.b.bnH().putBoolean(SharedPrefConfig.FRS_LOGIN_TIP, true);
            com.baidu.tbadk.core.sharedPref.b.bnH().putBoolean("frs_game_login_tip", false);
        }
        de(list);
        return true;
    }

    private void cAU() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021074, TbConfig.SERVER_ADDRESS + "game/forum/getNewNotify");
        tbHttpMessageTask.setResponsedClass(AlaGameTabGetNewNotifyResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.iUv.registerListener(1021074, this.iUV);
    }

    private void de(List<FrsTabInfo> list) {
        boolean z;
        if (!y.isEmpty(list)) {
            CustomMessageListener customMessageListener = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.14
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof am)) {
                        if (!com.baidu.tbadk.core.sharedPref.b.bnH().getBoolean(FrsTabController.this.iUy, true)) {
                            com.baidu.adp.lib.f.e.mY().post(FrsTabController.this.iUW);
                        }
                        ((am) customResponsedMessage.getData()).b(new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.14.1
                            @Override // com.baidu.tbadk.mainTab.b
                            public boolean isAvailable() {
                                return true;
                            }

                            @Override // com.baidu.tbadk.mainTab.b
                            public com.baidu.tbadk.mainTab.c createFragmentTabStructure() {
                                FrsSportsRecommendFragment frsSportsRecommendFragment = new FrsSportsRecommendFragment();
                                Bundle bundle = new Bundle();
                                bundle.putString("name", FrsTabController.this.iFH.getForumName());
                                bundle.putString("from", FrsTabController.this.iFH.getFrom());
                                bundle.putString("forum_id", FrsTabController.this.iFH.getForumId());
                                bundle.putInt("tab_id", 503);
                                bundle.putBoolean("can_auto_play_video", FrsTabController.this.iFI.isFrsVideoAutoPlay);
                                bundle.putBoolean("need_log", FrsTabController.this.iFI.needLog == 1);
                                bundle.putBoolean("is_brand_forum", FrsTabController.this.iFI.isBrandForum);
                                FrsViewData frsViewData = new FrsViewData();
                                frsViewData.receiveData(FrsTabController.this.iFI);
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
                        FrsTabController.this.cAQ();
                    }
                }
            };
            customMessageListener.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            customMessageListener.setSelfListener(true);
            this.iUv.registerListener(customMessageListener);
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
            this.iFG = new am(this.iUv.getActivity(), arrayList);
            if (cuX() != null) {
                this.iFG.setForumId(cuX().getForumId());
                this.iFG.setForumName(cuX().getForumName());
                if (cuX().cwo() != null && cuX().cwo().getForum() != null) {
                    ForumData forum = cuX().cwo().getForum();
                    this.iFG.setForumGameLabel(forum.getForumGameLabel());
                    this.iFG.Ip(forum.getSpecialForumType());
                }
            }
            this.iFH.iBC = false;
            new e(this.iFH).a(this.iFG);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB, this.iFG);
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB);
            customMessage.setTag(this.iUv.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAV() {
        if (this.iFG != null && !TextUtils.isEmpty(this.iFG.getForumId())) {
            HttpMessage httpMessage = new HttpMessage(1021074);
            httpMessage.addParam("forum_id", this.iFI.getForum().getId());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    private void a(Fragment fragment, int i) {
        NavigationBar bQh;
        if ((fragment instanceof com.baidu.tieba.frs.at) && this.iFI != null && this.iFI.getForum() != null && (bQh = ((com.baidu.tieba.frs.at) fragment).bQh()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.iFI.getForum().getName(), 5, true, true) + this.iUv.getActivity().getString(R.string.forum));
            bQh.setCenterTextTitle(sb.toString());
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.iFH instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.iFH.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a sQ(int i) {
        if (this.iFH instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.iFH.sQ(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.iFH instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.iFH.a(bVar);
        }
    }

    public void onNewIntent(Intent intent) {
        if (this.iFH != null) {
            this.iFH.onNewIntent(intent);
        }
    }

    public void onResume() {
        if (!cAX()) {
            this.iFH.setPrimary(true);
        } else if (this.iUw != null) {
            Fragment currentFragment = this.iUw.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(true);
            }
        }
        if (this.iUA) {
            this.iUA = false;
            if (this.iFH != null) {
                this.iFH.refresh();
            }
        }
        if (this.iFI != null && this.iFI.getUserData() != null && this.iFI.getUserData().getNewGodData() != null) {
            if (this.iFI.getForum() != null) {
                w.bBo().setFid(this.iFI.getForum().getId());
            }
            w.bBo().b(2, this.iFI.getUserData().getNewGodData());
        }
        this.iUO = true;
        if (this.iUN) {
            e((ForumData) null);
        }
    }

    public void onPause() {
        this.iUO = false;
        if (this.iUK != null) {
            this.iUK.cCI();
        }
        if (!cAX()) {
            this.iFH.setPrimary(false);
        } else if (this.iUw != null) {
            Fragment currentFragment = this.iUw.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(false);
            }
        }
        w.bBo().removeCallbacks();
    }

    public void onChangeSkinType(int i) {
        UtilHelper.changeStatusBarIconAndTextColor(true, this.iUv);
        if (this.iFH != null) {
            this.iFH.onChangeSkinType(i);
        }
        if (this.iUw != null) {
            this.iUw.onChangeSkinType(i);
        }
        cAS();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (cAX() && this.iUw != null && this.iUw.cxv()) {
                this.iUw.cxM();
                UtilHelper.setNavigationBarBackground(this.iUv, this.iUw.cxH());
            } else if (this.iFH != null && this.iFH.isAdded()) {
                if (this.iFH.onKeyDown(i, keyEvent)) {
                    return true;
                }
                cAW();
            } else {
                return this.iUv.b(i, keyEvent);
            }
        } else if (i == 24) {
            if (this.iFH != null && this.iFH.isAdded()) {
                return this.iFH.onKeyDown(i, keyEvent);
            }
        } else {
            return this.iUv.b(i, keyEvent);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAW() {
        if (this.iFK != this.iFJ && cAX()) {
            this.iUw.setCurrentTab(this.iFJ);
            if (yO(this.iFJ) != 1) {
                this.iFH.pn(false);
            }
            this.iFK = this.iFJ;
            a(this.iUw.getCurrentFragment(), this.iFJ);
            return;
        }
        this.iFH.closeActivity();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!cAX()) {
            this.iFH.onActivityResult(i, i2, intent);
        } else if (this.iUw != null) {
            if (1 == this.iUw.getCurrentTabType()) {
                this.iFH.onActivityResult(i, i2, intent);
            } else {
                this.iUw.getCurrentFragment().onActivityResult(i, i2, intent);
            }
        }
        if (i2 == -1) {
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1) {
                    com.baidu.tieba.o.a.dxr().F(this.iUv.getPageContext());
                    ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.linkUrl != null && this.iUz != null) {
                        this.iUz.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.15
                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void buw() {
                            }

                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void a(final CustomDialogData customDialogData) {
                                com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.15.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (FrsTabController.this.iUv != null) {
                                            com.baidu.tieba.pb.interactionpopupwindow.c.a(FrsTabController.this.iUv.getPageContext(), customDialogData).show();
                                        }
                                    }
                                }, 1000L);
                            }
                        });
                    }
                }
            } else if (i == 13011) {
                com.baidu.tieba.o.a.dxr().F(this.iUv.getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (!cAX()) {
            return this.iFH.getVoiceManager();
        }
        if (this.iUw == null) {
            return null;
        }
        Fragment currentFragment = this.iUw.getCurrentFragment();
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
    public int yM(int i) {
        if (this.iFG == null) {
            return -1;
        }
        int count = y.getCount(this.iFG.bwJ());
        for (int i2 = 0; i2 < count; i2++) {
            if (this.iFG.bwJ().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int yO(int i) {
        if (this.iFG != null && i < y.getCount(this.iFG.bwJ())) {
            return this.iFG.bwJ().get(i).tab_id.intValue();
        }
        return -1;
    }

    public FrsFragment cuX() {
        return this.iFH;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> cuY() {
        if (!cAX()) {
            if (this.iFH instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) this.iFH).cuY();
            }
        } else if (this.iUw == null) {
            return null;
        } else {
            Fragment currentFragment = this.iUw.getCurrentFragment();
            if (currentFragment instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) currentFragment).cuY();
            }
        }
        return null;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(t.iEQ);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.iUv.isLoadingViewAttached()) {
            this.iUv.hideLoadingView(this.iUv.findViewById(16908290));
        }
        if (this.iUW != null) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.iUW);
        }
        com.baidu.tbadk.core.sharedPref.b.bnH().putBoolean(this.iUy, false);
        if (this.iUz != null) {
            this.iUz.cancelLoadData();
        }
        if (this.iFH != null && this.iFH.cvF() != null) {
            this.iFH.cvF().cBk();
        }
        if (this.iUG != null) {
            this.iUG.onDestroy();
        }
        if (FrsActivityConfig.FRS_FROM_FLUTTER_BCASTEDIT.equals(this.mFrom)) {
            new o(TbadkCoreApplication.getInst()).bnW();
        }
        if (this.iUL != null) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.iUL);
        }
        if (this.iFI != null && this.iFI.getForum() != null && this.iUK != null) {
            this.iUK.fo(com.baidu.adp.lib.f.b.toLong(this.iFI.getForum().getId(), 0L));
        }
    }

    public FragmentTabHost cxK() {
        if (this.iUw == null) {
            return null;
        }
        return this.iUw.cxK();
    }

    public boolean cAX() {
        if (this.iUC == null) {
            return false;
        }
        return this.iUC.getItem(0) instanceof FrsTabHostFragment;
    }

    public void yQ(int i) {
        this.iFJ = i;
    }

    public void zC(int i) {
        this.iFK = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAY() {
        if (this.iUv != null) {
            if (this.iUG == null) {
                this.iUG = (NavigationBarCoverTip) this.iUv.findViewById(R.id.navigation_cover_tip);
            }
            if (this.iUG != null) {
                View inflate = View.inflate(this.iUv, R.layout.write_thread_share_guide, null);
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
                cVar.bqN();
                tBSpecificationBtn.setConfig(cVar);
                tBSpecificationBtn.bqd();
                ap.setViewTextColor(textView, R.color.cp_cont_a);
                ap.setBackgroundColor(this.iUG, R.color.cp_link_tip_a_alpha95);
                tBSpecificationBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.16
                    /* JADX DEBUG: Multi-variable search result rejected for r4v9, resolved type: com.baidu.tieba.frs.FrsActivity */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        new aq("c13439").boK();
                        if (FrsTabController.this.cuX() != null && !TextUtils.isEmpty(FrsTabController.this.cuX().getForumId()) && !TextUtils.isEmpty(FrsTabController.this.mForumName) && FrsTabController.this.iUv != null) {
                            if (FrsTabController.this.iUG != null) {
                                FrsTabController.this.iUG.hideTip();
                            }
                            be.boR().b(FrsTabController.this.iUv.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/bawutask?fid=" + FrsTabController.this.cuX().getForumId() + "&fn=" + FrsTabController.this.mForumName + "&noread=" + (com.baidu.tbadk.core.sharedPref.b.bnH().getInt("key_bawu_task_toast", 0) == -1 ? 1 : 0)});
                        }
                    }
                });
                this.iUG.a(this.iUv, inflate, 30000);
                new aq("c13438").boK();
                int i = com.baidu.tbadk.core.sharedPref.b.bnH().getInt("key_bawu_task_toast", 0);
                if (i >= 0) {
                    com.baidu.tbadk.core.sharedPref.b.bnH().putInt("key_bawu_task_toast", i + 1);
                }
            }
        }
    }

    private void cAZ() {
        boolean z;
        if (this.iFI != null && this.iFI.getEntelechyTabInfo() != null && this.iFI.getEntelechyTabInfo().tab != null) {
            Iterator<FrsTabInfo> it = this.iFI.getEntelechyTabInfo().tab.iterator();
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
                if (this.iUJ == null) {
                    this.iUJ = new com.baidu.tieba.c.e(this.iUv.getPageContext(), this.iUD);
                    this.iUJ.fh(R.drawable.pic_sign_tip_down);
                    this.iUJ.setAnchor(2);
                    this.iUJ.setUseDirectOffset(true);
                    this.iUJ.xd(-l.getDimens(this.iUv, R.dimen.tbds20));
                    this.iUJ.setYOffset(-l.getDimens(this.iUv, R.dimen.tbds20));
                    this.iUJ.setTextColor(R.color.cp_cont_a);
                    this.iUJ.setHeight(R.dimen.tbds54);
                    this.iUJ.xb(l.getDimens(this.iUv, R.dimen.tbds44));
                }
                this.iUJ.aL(this.iUv.getString(R.string.frs_evaluate_tip), "first_into_frs_with_evaluate_tab");
            }
        }
    }

    private void d(final ForumData forumData) {
        boolean z = false;
        if (g(forumData.getName(), forumData.getId(), forumData.getImage_url(), false)) {
            if (this.iUL != null) {
                com.baidu.adp.lib.f.e.mY().removeCallbacks(this.iUL);
            }
            z = true;
        }
        if (!this.iUM) {
            this.iUK.cCH().i(TbadkCoreApplication.getCurrentAccount(), forumData.getId(), System.currentTimeMillis());
            this.iUM = true;
        }
        if (!z) {
            this.iUL = this.iUL != null ? this.iUL : new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.17
                @Override // java.lang.Runnable
                public void run() {
                    if (FrsTabController.this.iUK != null) {
                        if (FrsTabController.this.iUO) {
                            FrsTabController.this.g(forumData.getName(), forumData.getId(), forumData.getImage_url(), true);
                        } else {
                            FrsTabController.this.iUN = true;
                        }
                    }
                }
            };
            com.baidu.adp.lib.f.e.mY().postDelayed(this.iUL, 60000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ForumData forumData) {
        if (this.iFH.cvH() != null && this.iUK != null) {
            if (forumData == null) {
                forumData = this.iFI.getForum();
            }
            if (forumData != null && forumData.isLike() != 1) {
                if (!this.iUO) {
                    this.iUN = true;
                } else if (g(forumData.getName(), forumData.getId(), forumData.getImage_url(), false) && this.iUL != null) {
                    com.baidu.adp.lib.f.e.mY().removeCallbacks(this.iUL);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(String str, String str2, String str3, boolean z) {
        if (!this.iUK.eZ(TbadkCoreApplication.getCurrentAccount(), str2) || this.iFH == null || this.iFH.cvH() == null) {
            return false;
        }
        this.iUN = false;
        this.iUK.a(this.iUv, str, str2, str3, this.iFH.cvH().cDA());
        this.iUK.cCH().a(TbadkCoreApplication.getCurrentAccount(), str2, System.currentTimeMillis(), z);
        return true;
    }

    public boolean fm(long j) {
        ForumData forum;
        return (this.iFI == null || j == 0 || (forum = this.iFI.getForum()) == null || com.baidu.adp.lib.f.b.toLong(forum.getId(), 0L) != j) ? false : true;
    }

    /* loaded from: classes22.dex */
    public class FragmentAdapter extends FragmentStatePagerAdapter {
        private List<BaseFragment> mFragments;

        public FragmentAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.mFragments = new ArrayList(2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v4.app.FragmentStatePagerAdapter
        /* renamed from: zD */
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

        public BaseFragment Kp(String str) {
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

        public BaseFragment zE(int i) {
            return (BaseFragment) y.remove(this.mFragments, i);
        }

        public String zF(int i) {
            if (getItem(i) != null) {
                return getItem(i).getBaseTag();
            }
            return null;
        }
    }

    public TbPageTag getTbPageTag() {
        if (!cAX()) {
            return this.iFH.getTbPageTag();
        }
        if (this.iUw != null) {
            if (1 == this.iUw.getCurrentTabType()) {
                return this.iFH.getTbPageTag();
            }
            Fragment currentFragment = this.iUw.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                return ((BaseFragment) currentFragment).getTbPageTag();
            }
        }
        return null;
    }
}
