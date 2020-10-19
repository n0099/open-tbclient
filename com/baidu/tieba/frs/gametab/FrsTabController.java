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
    public static final String iHX = FrsFragment.class.getSimpleName();
    public static final String iHY = FrsTabHostFragment.class.getSimpleName();
    private FrsActivity iHZ;
    private FrsTabHostFragment iIa;
    private ShareSuccessReplyToServerModel iId;
    private FrsBaseViewPager iIf;
    private FragmentAdapter iIg;
    private OvalActionButton iIh;
    private boolean iIi;
    private boolean iIj;
    private NavigationBarCoverTip iIk;
    private com.baidu.tieba.c.e iIn;
    private com.baidu.tieba.frs.f.d iIo;
    private Runnable iIp;
    private boolean iIq;
    private LinearLayout ioZ;
    private am itk;
    private FrsFragment itl;
    private m itm;
    private int ito;
    private FRSRefreshButton itq;
    private String mForumName;
    private String mFrom;
    private boolean iIb = false;
    private final Handler mHandler = new Handler();
    private int itn = 0;
    private boolean iIe = false;
    private boolean iIl = false;
    private boolean iIm = false;
    private boolean iIr = false;
    private boolean iIs = false;
    private HttpMessageListener iIt = new HttpMessageListener(CmdConfigHttp.CMD_FRS_RECOMMEND) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof FrsRecommendResMsg) {
                if (httpResponsedMessage.getError() != 0) {
                    new BdTopToast(FrsTabController.this.iHZ).xK(false).TD(httpResponsedMessage.getErrorString()).aH((ViewGroup) FrsTabController.this.iHZ.findViewById(R.id.frs));
                    return;
                }
                int pushStatus = ((FrsRecommendResMsg) httpResponsedMessage).getPushStatus();
                String pushMsg = ((FrsRecommendResMsg) httpResponsedMessage).getPushMsg();
                if (pushStatus == 1) {
                    new ScreenTopToast(FrsTabController.this.iHZ).TH(FrsTabController.this.iHZ.getString(R.string.frs_recommend_suc_tip_title)).TI(FrsTabController.this.iHZ.getString(R.string.frs_recommend_suc_tip_content)).TJ(FrsTabController.this.iHZ.getString(R.string.dialog_confirm_see)).ak(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.1.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("_forumId", FrsTabController.this.itm.getForum().getId());
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new com.baidu.tieba.tbadkCore.data.m(FrsTabController.this.iHZ, "RecommendHistoryPage", hashMap)));
                        }
                    }).aH((ViewGroup) FrsTabController.this.iHZ.findViewById(R.id.frs));
                } else {
                    new BdTopToast(FrsTabController.this.iHZ).xK(false).TD(pushMsg).aH((ViewGroup) FrsTabController.this.iHZ.findViewById(R.id.frs));
                }
            }
        }
    };
    private CustomMessageListener iIu = new CustomMessageListener(2921465) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            new ScreenTopToast(FrsTabController.this.iHZ).TH(FrsTabController.this.iHZ.getString(R.string.frs_recommend_fail_month_tip)).TJ(FrsTabController.this.iHZ.getString(R.string.frs_recommend_fail_tip_btn)).ak(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.12.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("_forumId", FrsTabController.this.itm.getForum().getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new com.baidu.tieba.tbadkCore.data.m(FrsTabController.this.iHZ, "ForumGradePage", hashMap)));
                }
            }).aH((ViewGroup) FrsTabController.this.iHZ.findViewById(R.id.frs));
        }
    };
    private com.baidu.adp.framework.listener.a iIv = new com.baidu.adp.framework.listener.a(1001703, CmdConfigSocket.CMD_FRS_PAGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.18
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            m mVar = null;
            int i = -1;
            if (!FrsTabController.this.iIb && !responsedMessage.hasError() && responsedMessage.getError() == 0) {
                if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                    mVar = ((FrsPageHttpResponseMessage) responsedMessage).getResponseData();
                    i = ((FrsPageHttpResponseMessage) responsedMessage).getUpdateType();
                } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                    mVar = ((FRSPageSocketResponsedMessage) responsedMessage).getResponseData();
                    i = ((FRSPageSocketResponsedMessage) responsedMessage).getUpdateType();
                }
                if (mVar != null) {
                    FrsTabController.this.iIb = true;
                    FrsTabController.this.a(mVar, true, i);
                    if (mVar != null && mVar.getForum() != null && !StringUtils.isNull(mVar.getForum().getId())) {
                        com.baidu.tbadk.core.business.a.bfA().dy("2", mVar.getForum().getId());
                    }
                }
                if (mVar != null && mVar.getUserData() != null && mVar.getUserData().getNewGodData() != null) {
                    if (mVar.getForum() != null) {
                        w.bzv().setFid(mVar.getForum().getId());
                    }
                    w.bzv().b(2, mVar.getUserData().getNewGodData());
                }
            }
        }
    };
    private CustomMessageListener iIw = new CustomMessageListener(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!FrsTabController.this.iIb && FrsTabController.this.itm == null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof m)) {
                m mVar = (m) customResponsedMessage.getData();
                if (mVar.getForum() != null && FrsTabController.this.mForumName != null && FrsTabController.this.mForumName.equals(mVar.getForum().getName())) {
                    FrsTabController.this.a(mVar, false, -1);
                }
            }
        }
    };
    private CustomMessageListener iIx = new CustomMessageListener(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsTabController.this.cxP();
        }
    };
    private CustomMessageListener iIy = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int yt;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (10001 == intValue) {
                    yt = FrsTabController.this.yt(9);
                    if (yt == -1) {
                        yt = FrsTabController.this.yt(2);
                    }
                } else {
                    yt = FrsTabController.this.yt(intValue);
                }
                if (yt != -1 && FrsTabController.this.cxQ() && FrsTabController.this.iIa != null) {
                    FrsTabController.this.iIa.setCurrentTab(yt);
                    if (FrsTabController.this.yv(yt) != 1) {
                        FrsTabController.this.itl.oV(false);
                    }
                }
            }
        }
    };
    private HttpMessageListener iIz = new HttpMessageListener(0) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && 1021074 == httpResponsedMessage.getCmd() && (httpResponsedMessage instanceof AlaGameTabGetNewNotifyResponsedMessage)) {
                List<a> newNotifyData = ((AlaGameTabGetNewNotifyResponsedMessage) httpResponsedMessage).getNewNotifyData();
                if (!y.isEmpty(newNotifyData) && FrsTabController.this.iIa != null) {
                    for (a aVar : newNotifyData) {
                        if (aVar != null) {
                            for (int i = 0; i < FrsTabController.this.itk.buQ().size(); i++) {
                                FragmentTabHost.b ou = FrsTabController.this.iIa.ou(i);
                                if (ou != null && ou.mType != 1 && ou.mType != FrsTabController.this.iIa.getCurrentTabType() && ou.mType == aVar.getTabId() && aVar.cxG() && ou.exe.Dx(String.valueOf(ou.mType)) != null) {
                                    ou.exe.Dx(String.valueOf(ou.mType)).view.setVisibility(0);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private Runnable iIA = new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.23
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this);
            FrsTabController.this.cxO();
            com.baidu.adp.lib.f.e.mY().postDelayed(this, 30000L);
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                FrsTabController.this.iIe = true;
            }
        }
    };
    private CustomMessageListener iIB = new CustomMessageListener(2921369) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.iIf != null && FrsTabController.this.iIg != null && (customResponsedMessage.getData() instanceof FrsTabViewPager.a)) {
                FrsTabViewPager.a aVar = (FrsTabViewPager.a) customResponsedMessage.getData();
                FrsTabController.this.iIi = aVar.cuK();
                FrsTabController.this.iIj = aVar.cuL();
            }
        }
    };
    private CustomMessageListener iIC = new CustomMessageListener(2921370) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.iIf != null && FrsTabController.this.iIg != null && (customResponsedMessage.getData() instanceof Boolean)) {
                FrsTabController.this.iIf.setForceIntercept(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };
    private CustomMessageListener iID = new CustomMessageListener(CmdConfigCustom.CMD_NEW_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                FrsTabController.this.e((ForumData) null);
            }
        }
    };
    private CustomMessageListener iIE = new CustomMessageListener(2921498) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsTabController.this.iIo != null && customResponsedMessage != null && customResponsedMessage.getData() != null) {
                if (customResponsedMessage.getData() instanceof ForumData) {
                    FrsTabController.this.e((ForumData) customResponsedMessage.getData());
                } else if (customResponsedMessage.getData() instanceof Long) {
                    long longValue = ((Long) customResponsedMessage.getData()).longValue();
                    if (FrsTabController.this.fl(longValue) && FrsTabController.this.iIo.fm(longValue) >= 3) {
                        FrsTabController.this.iIo.fn(longValue);
                        FrsTabController.this.iIr = true;
                    }
                }
            }
        }
    };
    private CustomMessageListener iIF = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                if (FrsTabController.this.iIo != null && aVar != null && TbadkCoreApplication.isLogin()) {
                    FrsTabController.this.iIo.eT(TbadkCoreApplication.getCurrentAccount(), String.valueOf(aVar.forumId));
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener iIG = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.7
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i != 1) {
                FrsTabController.this.iIh.setVisibility(0);
                if (FrsTabController.this.crQ() != null) {
                    FrsTabController.this.crQ().oP(false);
                }
                FrsTabController.this.itl.ctg();
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            switch (i) {
                case 0:
                    FrsTabController.this.iIj = false;
                    FrsTabController.this.iIf.setForceIntercept(false);
                    return;
                default:
                    return;
            }
        }
    };
    private FrsBaseViewPager.a iIH = new FrsBaseViewPager.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.8
        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public void csl() {
            if (FrsTabController.this.iIf != null) {
                if (FrsTabController.this.iIf.getCurrentItem() == 0) {
                    FrsTabController.this.iIf.setmDisallowSlip(true);
                } else {
                    FrsTabController.this.iIf.setmDisallowSlip(false);
                }
            }
        }

        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public boolean csm() {
            if (FrsTabController.this.iIf.getCurrentItem() == 0) {
                if (FrsTabController.this.iIi && FrsTabController.this.iIj) {
                    FrsTabController.this.iIf.setmDisallowSlip(false);
                }
                if (!FrsTabController.this.iIj) {
                    FrsTabController.this.iIf.setmDisallowSlip(true);
                }
                FrsTabController.this.iIf.setmDisallowSlip(true);
            } else {
                FrsTabController.this.iIf.setmDisallowSlip(true);
            }
            return true;
        }
    };
    private String iIc = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.SHOW_GAME_FOREM_TAB_HOT_POINT);

    public FrsTabController(FrsActivity frsActivity) {
        this.iHZ = frsActivity;
    }

    public void init(Bundle bundle) {
        if (this.iHZ != null) {
            this.iHZ.setContentView(R.layout.frs_base_layout);
            this.iIf = (FrsBaseViewPager) this.iHZ.findViewById(R.id.frs_base_viewpager);
            this.iIg = new FragmentAdapter(this.iHZ.getSupportFragmentManager());
            this.iIf.setAdapter(this.iIg);
            this.iIf.setPageTransformer(true, new CubeOutViewPagerTransformer());
            this.iIf.addOnPageChangeListener(this.iIG);
            this.iIf.setmDisallowSlip(true);
            this.iIf.setOnTouchEventListener(this.iIH);
            this.iIh = (OvalActionButton) this.iHZ.findViewById(R.id.frs_post_forum_button);
            this.iIh.setIsCircle(true);
            this.iIh.setHasShadow(false);
            this.itq = (FRSRefreshButton) this.iHZ.findViewById(R.id.frs_refresh_forum_button);
            this.ioZ = (LinearLayout) this.iHZ.findViewById(R.id.frs_ll_redpack);
            this.iHZ.registerListener(this.iIB);
            this.iHZ.registerListener(this.iIC);
            this.iIv.getHttpMessageListener().setPriority(-1);
            this.iIv.getSocketMessageListener().setPriority(-1);
            this.iHZ.registerListener(this.iIw);
            this.iIy.setSelfListener(true);
            this.iHZ.registerListener(this.iIy);
            this.iIx.setSelfListener(true);
            this.iHZ.registerListener(this.iIx);
            this.iHZ.registerListener(this.mAccountChangedListener);
            if (bundle == null) {
                this.mForumName = this.iHZ.getIntent().getStringExtra("name");
                this.mFrom = this.iHZ.getIntent().getStringExtra("from");
                this.itn = this.iHZ.getIntent().getIntExtra(FrsActivityConfig.FRS_GAME_DEFAULT_TAB_ID, 0);
            } else {
                this.mForumName = bundle.getString("name");
                this.mFrom = bundle.getString("from");
                this.itn = bundle.getInt("default_tab_id", 0);
            }
            an(bundle);
            this.iIg.notifyDataSetChanged();
            this.iId = new ShareSuccessReplyToServerModel();
            this.iHZ.registerListener(this.iIv);
            this.iHZ.registerListener(this.iIt);
            this.iHZ.registerListener(this.iIu);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.mForumName);
        bundle.putInt("default_tab_id", this.itn);
        bundle.putString("from", this.mFrom);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void an(Bundle bundle) {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.iIg != null) {
            try {
                FrsFragment frsFragment = (FrsFragment) this.iIg.JQ(iHX);
                if (frsFragment == null) {
                    frsFragment = ao(bundle);
                }
                frsFragment.b(this.iIh);
                frsFragment.a(this.itq);
                frsFragment.c(this.ioZ);
                if (!iHX.equals(this.iIg.zm(0))) {
                    if (iHY.equals(this.iIg.zm(0))) {
                        this.iIg.zl(0);
                    }
                    this.iIg.a(0, frsFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxJ() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.iIg != null) {
            try {
                FrsTabHostFragment frsTabHostFragment = (FrsTabHostFragment) this.iIg.JQ(iHY);
                if (frsTabHostFragment == null) {
                    frsTabHostFragment = cxK();
                }
                frsTabHostFragment.b(this.iIh);
                frsTabHostFragment.b(this.itq);
                if (!iHY.equals(this.iIg.zm(0))) {
                    if (iHX.equals(this.iIg.zm(0))) {
                        this.iIg.zl(0);
                    }
                    this.iIg.a(0, frsTabHostFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private FrsFragment ao(Bundle bundle) {
        if (this.itl == null) {
            this.itl = new FrsFragment();
            this.itl.setArguments(bundle);
            this.itl.setBaseTag(iHX);
        }
        this.itl.ipg = false;
        return this.itl;
    }

    private FrsTabHostFragment cxK() {
        if (this.iIa == null) {
            this.iIa = new FrsTabHostFragment(this);
            this.iIa.setBaseTag(iHY);
            this.iIa.yx(this.itn);
        }
        return this.iIa;
    }

    private FragmentManager getFragmentManager() {
        if (this.iHZ != null) {
            return this.iHZ.getSupportFragmentManager();
        }
        return null;
    }

    private void cxL() {
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.itm != null && (themeColorInfo = this.itm.getForum().getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            this.iIh.setStartAndEndColor(themeElement.light_color, themeElement.dark_color);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(m mVar, boolean z, int i) {
        if (mVar != null && mVar.getForum() != null) {
            ForumData forum = mVar.getForum();
            if (z) {
                a(forum, mVar.getAnti());
            }
            if (forum.getIsShowBawuTask() && com.baidu.tbadk.core.sharedPref.b.blO().getInt("key_bawu_task_toast", 0) == 0 && !this.iIl) {
                this.iIl = true;
                com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.9
                    @Override // java.lang.Runnable
                    public void run() {
                        FrsTabController.this.cxR();
                    }
                }, 30000L);
            }
            if (mVar.bazhuExam != null && !this.iIm && z) {
                com.baidu.tieba.frs.m.a(this.iHZ.getPageContext(), mVar.bazhuExam, forum.getId(), forum.getName());
                this.iIm = true;
            }
            this.itm = mVar;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921476));
            if (y.getCount(mVar.getGameTabInfo()) > 0) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.10
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean cU = FrsTabController.this.cU(FrsTabController.this.itm.getGameTabInfo());
                        if (cU) {
                            FrsTabController.this.iIg.notifyDataSetChanged();
                            if (cU && FrsTabController.this.iIa != null) {
                                FrsTabController.this.iIa.Z(FrsTabController.this.itl);
                                FrsTabController.this.iIa.a(FrsTabController.this.itm, FrsTabController.this.itk);
                            }
                        }
                        if (FrsTabController.this.iHZ.isLoadingViewAttached()) {
                            FrsTabController.this.iHZ.hideLoadingView(FrsTabController.this.iHZ.findViewById(16908290));
                        }
                    }
                });
            } else if (cxQ()) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.11
                    @Override // java.lang.Runnable
                    public void run() {
                        Bundle bundle;
                        FrsTabController.this.itl.ipg = true;
                        if (FrsTabController.this.itl != null) {
                            bundle = FrsTabController.this.itl.getArguments();
                        } else {
                            bundle = null;
                        }
                        FrsTabController.this.an(bundle);
                        FrsTabController.this.iIg.notifyDataSetChanged();
                        if (FrsTabController.this.iHZ.isLoadingViewAttached()) {
                            FrsTabController.this.iHZ.hideLoadingView(FrsTabController.this.iHZ.findViewById(16908290));
                        }
                    }
                });
            }
            cxL();
            cxS();
            if (z) {
                if ((!this.iIq || i == 4) && forum.isLike() == 0 && com.baidu.tbadk.a.d.bdG() && TbadkCoreApplication.isLogin()) {
                    this.iIo = new com.baidu.tieba.frs.f.d();
                    this.iHZ.registerListener(this.iIE);
                    this.iHZ.registerListener(this.iID);
                    this.iHZ.registerListener(this.iIF);
                    d(forum);
                }
            }
        }
    }

    private void a(ForumData forumData, AntiData antiData) {
        if (forumData != null && !com.baidu.tbadk.youngster.b.a.a(this.iHZ.getPageContext(), antiData, R.id.frs) && !c(forumData)) {
            List<TipInfo> tipInfos = forumData.getTipInfos();
            if (!y.isEmpty(tipInfos)) {
                com.baidu.tbadk.youngster.b.a.a(this.iHZ.getPageContext(), tipInfos.get(0), TbadkCoreApplication.getCurrentAccount(), forumData.getId(), this.iHZ.getString(R.string.frs_risk_dialog_button_text));
            }
        }
    }

    private boolean c(ForumData forumData) {
        if (at.isEmpty(forumData.getRiskTipPop()) || at.isEmpty(forumData.getRiskTipPopTitle())) {
            return false;
        }
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iHZ);
        aVar.AG(forumData.getRiskTipPopTitle());
        aVar.setTitleShowCenter(true);
        aVar.setMessageShowCenter(true);
        aVar.AH(forumData.getRiskTipPop());
        aVar.a(R.string.frs_risk_dialog_button_text, new a.b() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.13
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar.dismiss();
            }
        });
        aVar.b(this.iHZ.getPageContext()).bkJ();
        return true;
    }

    public m cxM() {
        return this.itm;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cU(List<FrsTabInfo> list) {
        if (this.iHZ.isLoadingViewAttached()) {
            this.iHZ.hideLoadingView(this.iHZ.findViewById(16908290));
        }
        if (cxQ()) {
            return false;
        }
        this.itl.ipg = true;
        cxN();
        if (com.baidu.tbadk.core.sharedPref.b.blO().getBoolean("frs_game_login_tip", true)) {
            com.baidu.tbadk.core.sharedPref.b.blO().putBoolean(SharedPrefConfig.FRS_LOGIN_TIP, true);
            com.baidu.tbadk.core.sharedPref.b.blO().putBoolean("frs_game_login_tip", false);
        }
        cV(list);
        return true;
    }

    private void cxN() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021074, TbConfig.SERVER_ADDRESS + "game/forum/getNewNotify");
        tbHttpMessageTask.setResponsedClass(AlaGameTabGetNewNotifyResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.iHZ.registerListener(1021074, this.iIz);
    }

    private void cV(List<FrsTabInfo> list) {
        boolean z;
        if (!y.isEmpty(list)) {
            CustomMessageListener customMessageListener = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.14
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof am)) {
                        if (!com.baidu.tbadk.core.sharedPref.b.blO().getBoolean(FrsTabController.this.iIc, true)) {
                            com.baidu.adp.lib.f.e.mY().post(FrsTabController.this.iIA);
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
                                bundle.putString("name", FrsTabController.this.itl.getForumName());
                                bundle.putString("from", FrsTabController.this.itl.getFrom());
                                bundle.putString("forum_id", FrsTabController.this.itl.getForumId());
                                bundle.putInt("tab_id", 503);
                                bundle.putBoolean("can_auto_play_video", FrsTabController.this.itm.isFrsVideoAutoPlay);
                                bundle.putBoolean("need_log", FrsTabController.this.itm.needLog == 1);
                                bundle.putBoolean("is_brand_forum", FrsTabController.this.itm.isBrandForum);
                                FrsViewData frsViewData = new FrsViewData();
                                frsViewData.receiveData(FrsTabController.this.itm);
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
                        FrsTabController.this.cxJ();
                    }
                }
            };
            customMessageListener.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            customMessageListener.setSelfListener(true);
            this.iHZ.registerListener(customMessageListener);
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
            this.itk = new am(this.iHZ.getActivity(), arrayList);
            if (crQ() != null) {
                this.itk.setForumId(crQ().getForumId());
                this.itk.setForumName(crQ().getForumName());
                if (crQ().cth() != null && crQ().cth().getForum() != null) {
                    ForumData forum = crQ().cth().getForum();
                    this.itk.setForumGameLabel(forum.getForumGameLabel());
                    this.itk.HQ(forum.getSpecialForumType());
                }
            }
            this.itl.ipg = false;
            new e(this.itl).a(this.itk);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB, this.itk);
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB);
            customMessage.setTag(this.iHZ.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxO() {
        if (this.itk != null && !TextUtils.isEmpty(this.itk.getForumId())) {
            HttpMessage httpMessage = new HttpMessage(1021074);
            httpMessage.addParam("forum_id", this.itm.getForum().getId());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    private void a(Fragment fragment, int i) {
        NavigationBar bNC;
        if ((fragment instanceof com.baidu.tieba.frs.at) && this.itm != null && this.itm.getForum() != null && (bNC = ((com.baidu.tieba.frs.at) fragment).bNC()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.itm.getForum().getName(), 5, true, true) + this.iHZ.getActivity().getString(R.string.forum));
            bNC.setCenterTextTitle(sb.toString());
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.itl instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.itl.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a sF(int i) {
        if (this.itl instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.itl.sF(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.itl instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.itl.a(bVar);
        }
    }

    public void onNewIntent(Intent intent) {
        if (this.itl != null) {
            this.itl.onNewIntent(intent);
        }
    }

    public void onResume() {
        if (!cxQ()) {
            this.itl.setPrimary(true);
        } else if (this.iIa != null) {
            Fragment currentFragment = this.iIa.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(true);
            }
        }
        if (this.iIe) {
            this.iIe = false;
            if (this.itl != null) {
                this.itl.refresh();
            }
        }
        if (this.itm != null && this.itm.getUserData() != null && this.itm.getUserData().getNewGodData() != null) {
            if (this.itm.getForum() != null) {
                w.bzv().setFid(this.itm.getForum().getId());
            }
            w.bzv().b(2, this.itm.getUserData().getNewGodData());
        }
        this.iIs = true;
        if (this.iIr) {
            e((ForumData) null);
        }
    }

    public void onPause() {
        this.iIs = false;
        if (this.iIo != null) {
            this.iIo.czB();
        }
        if (!cxQ()) {
            this.itl.setPrimary(false);
        } else if (this.iIa != null) {
            Fragment currentFragment = this.iIa.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(false);
            }
        }
        w.bzv().removeCallbacks();
    }

    public void onChangeSkinType(int i) {
        UtilHelper.changeStatusBarIconAndTextColor(true, this.iHZ);
        if (this.itl != null) {
            this.itl.onChangeSkinType(i);
        }
        if (this.iIa != null) {
            this.iIa.onChangeSkinType(i);
        }
        cxL();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (cxQ() && this.iIa != null && this.iIa.cuo()) {
                this.iIa.cuF();
                UtilHelper.setNavigationBarBackground(this.iHZ, this.iIa.cuA());
            } else if (this.itl != null && this.itl.isAdded()) {
                if (this.itl.onKeyDown(i, keyEvent)) {
                    return true;
                }
                cxP();
            } else {
                return this.iHZ.b(i, keyEvent);
            }
        } else if (i == 24) {
            if (this.itl != null && this.itl.isAdded()) {
                return this.itl.onKeyDown(i, keyEvent);
            }
        } else {
            return this.iHZ.b(i, keyEvent);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxP() {
        if (this.ito != this.itn && cxQ()) {
            this.iIa.setCurrentTab(this.itn);
            if (yv(this.itn) != 1) {
                this.itl.oV(false);
            }
            this.ito = this.itn;
            a(this.iIa.getCurrentFragment(), this.itn);
            return;
        }
        this.itl.closeActivity();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!cxQ()) {
            this.itl.onActivityResult(i, i2, intent);
        } else if (this.iIa != null) {
            if (1 == this.iIa.getCurrentTabType()) {
                this.itl.onActivityResult(i, i2, intent);
            } else {
                this.iIa.getCurrentFragment().onActivityResult(i, i2, intent);
            }
        }
        if (i2 == -1) {
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1) {
                    com.baidu.tieba.o.a.duk().F(this.iHZ.getPageContext());
                    ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.linkUrl != null && this.iId != null) {
                        this.iId.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.15
                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void bsD() {
                            }

                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void a(final CustomDialogData customDialogData) {
                                com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.15.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (FrsTabController.this.iHZ != null) {
                                            com.baidu.tieba.pb.interactionpopupwindow.c.a(FrsTabController.this.iHZ.getPageContext(), customDialogData).show();
                                        }
                                    }
                                }, 1000L);
                            }
                        });
                    }
                }
            } else if (i == 13011) {
                com.baidu.tieba.o.a.duk().F(this.iHZ.getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (!cxQ()) {
            return this.itl.getVoiceManager();
        }
        if (this.iIa == null) {
            return null;
        }
        Fragment currentFragment = this.iIa.getCurrentFragment();
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
    public int yt(int i) {
        if (this.itk == null) {
            return -1;
        }
        int count = y.getCount(this.itk.buQ());
        for (int i2 = 0; i2 < count; i2++) {
            if (this.itk.buQ().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int yv(int i) {
        if (this.itk != null && i < y.getCount(this.itk.buQ())) {
            return this.itk.buQ().get(i).tab_id.intValue();
        }
        return -1;
    }

    public FrsFragment crQ() {
        return this.itl;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> crR() {
        if (!cxQ()) {
            if (this.itl instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) this.itl).crR();
            }
        } else if (this.iIa == null) {
            return null;
        } else {
            Fragment currentFragment = this.iIa.getCurrentFragment();
            if (currentFragment instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) currentFragment).crR();
            }
        }
        return null;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(t.isu);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.iHZ.isLoadingViewAttached()) {
            this.iHZ.hideLoadingView(this.iHZ.findViewById(16908290));
        }
        if (this.iIA != null) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.iIA);
        }
        com.baidu.tbadk.core.sharedPref.b.blO().putBoolean(this.iIc, false);
        if (this.iId != null) {
            this.iId.cancelLoadData();
        }
        if (this.itl != null && this.itl.csy() != null) {
            this.itl.csy().cyd();
        }
        if (this.iIk != null) {
            this.iIk.onDestroy();
        }
        if (FrsActivityConfig.FRS_FROM_FLUTTER_BCASTEDIT.equals(this.mFrom)) {
            new o(TbadkCoreApplication.getInst()).bmd();
        }
        if (this.iIp != null) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.iIp);
        }
        if (this.itm != null && this.itm.getForum() != null && this.iIo != null) {
            this.iIo.fn(com.baidu.adp.lib.f.b.toLong(this.itm.getForum().getId(), 0L));
        }
    }

    public FragmentTabHost cuD() {
        if (this.iIa == null) {
            return null;
        }
        return this.iIa.cuD();
    }

    public boolean cxQ() {
        if (this.iIg == null) {
            return false;
        }
        return this.iIg.getItem(0) instanceof FrsTabHostFragment;
    }

    public void yx(int i) {
        this.itn = i;
    }

    public void zj(int i) {
        this.ito = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxR() {
        if (this.iHZ != null) {
            if (this.iIk == null) {
                this.iIk = (NavigationBarCoverTip) this.iHZ.findViewById(R.id.navigation_cover_tip);
            }
            if (this.iIk != null) {
                View inflate = View.inflate(this.iHZ, R.layout.write_thread_share_guide, null);
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
                cVar.boU();
                tBSpecificationBtn.setConfig(cVar);
                tBSpecificationBtn.bok();
                ap.setViewTextColor(textView, R.color.cp_cont_a);
                ap.setBackgroundColor(this.iIk, R.color.cp_link_tip_a_alpha95);
                tBSpecificationBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.16
                    /* JADX DEBUG: Multi-variable search result rejected for r4v9, resolved type: com.baidu.tieba.frs.FrsActivity */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        new aq("c13439").bmR();
                        if (FrsTabController.this.crQ() != null && !TextUtils.isEmpty(FrsTabController.this.crQ().getForumId()) && !TextUtils.isEmpty(FrsTabController.this.mForumName) && FrsTabController.this.iHZ != null) {
                            if (FrsTabController.this.iIk != null) {
                                FrsTabController.this.iIk.hideTip();
                            }
                            be.bmY().b(FrsTabController.this.iHZ.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/bawutask?fid=" + FrsTabController.this.crQ().getForumId() + "&fn=" + FrsTabController.this.mForumName + "&noread=" + (com.baidu.tbadk.core.sharedPref.b.blO().getInt("key_bawu_task_toast", 0) == -1 ? 1 : 0)});
                        }
                    }
                });
                this.iIk.a(this.iHZ, inflate, 30000);
                new aq("c13438").bmR();
                int i = com.baidu.tbadk.core.sharedPref.b.blO().getInt("key_bawu_task_toast", 0);
                if (i >= 0) {
                    com.baidu.tbadk.core.sharedPref.b.blO().putInt("key_bawu_task_toast", i + 1);
                }
            }
        }
    }

    private void cxS() {
        boolean z;
        if (this.itm != null && this.itm.getEntelechyTabInfo() != null && this.itm.getEntelechyTabInfo().tab != null) {
            Iterator<FrsTabInfo> it = this.itm.getEntelechyTabInfo().tab.iterator();
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
                if (this.iIn == null) {
                    this.iIn = new com.baidu.tieba.c.e(this.iHZ.getPageContext(), this.iIh);
                    this.iIn.ff(R.drawable.pic_sign_tip_down);
                    this.iIn.setAnchor(2);
                    this.iIn.setUseDirectOffset(true);
                    this.iIn.wK(-l.getDimens(this.iHZ, R.dimen.tbds20));
                    this.iIn.setYOffset(-l.getDimens(this.iHZ, R.dimen.tbds20));
                    this.iIn.setTextColor(R.color.cp_cont_a);
                    this.iIn.setHeight(R.dimen.tbds54);
                    this.iIn.wI(l.getDimens(this.iHZ, R.dimen.tbds44));
                }
                this.iIn.aJ(this.iHZ.getString(R.string.frs_evaluate_tip), "first_into_frs_with_evaluate_tab");
            }
        }
    }

    private void d(final ForumData forumData) {
        boolean z = false;
        if (g(forumData.getName(), forumData.getId(), forumData.getImage_url(), false)) {
            if (this.iIp != null) {
                com.baidu.adp.lib.f.e.mY().removeCallbacks(this.iIp);
            }
            z = true;
        }
        if (!this.iIq) {
            this.iIo.czA().i(TbadkCoreApplication.getCurrentAccount(), forumData.getId(), System.currentTimeMillis());
            this.iIq = true;
        }
        if (!z) {
            this.iIp = this.iIp != null ? this.iIp : new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.17
                @Override // java.lang.Runnable
                public void run() {
                    if (FrsTabController.this.iIo != null) {
                        if (FrsTabController.this.iIs) {
                            FrsTabController.this.g(forumData.getName(), forumData.getId(), forumData.getImage_url(), true);
                        } else {
                            FrsTabController.this.iIr = true;
                        }
                    }
                }
            };
            com.baidu.adp.lib.f.e.mY().postDelayed(this.iIp, 60000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ForumData forumData) {
        if (this.itl.csA() != null && this.iIo != null) {
            if (forumData == null) {
                forumData = this.itm.getForum();
            }
            if (forumData != null && forumData.isLike() != 1) {
                if (!this.iIs) {
                    this.iIr = true;
                } else if (g(forumData.getName(), forumData.getId(), forumData.getImage_url(), false) && this.iIp != null) {
                    com.baidu.adp.lib.f.e.mY().removeCallbacks(this.iIp);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(String str, String str2, String str3, boolean z) {
        if (!this.iIo.eU(TbadkCoreApplication.getCurrentAccount(), str2) || this.itl == null || this.itl.csA() == null) {
            return false;
        }
        this.iIr = false;
        this.iIo.a(this.iHZ, str, str2, str3, this.itl.csA().cAt());
        this.iIo.czA().a(TbadkCoreApplication.getCurrentAccount(), str2, System.currentTimeMillis(), z);
        return true;
    }

    public boolean fl(long j) {
        ForumData forum;
        return (this.itm == null || j == 0 || (forum = this.itm.getForum()) == null || com.baidu.adp.lib.f.b.toLong(forum.getId(), 0L) != j) ? false : true;
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
        /* renamed from: zk */
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

        public BaseFragment JQ(String str) {
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

        public BaseFragment zl(int i) {
            return (BaseFragment) y.remove(this.mFragments, i);
        }

        public String zm(int i) {
            if (getItem(i) != null) {
                return getItem(i).getBaseTag();
            }
            return null;
        }
    }

    public TbPageTag getTbPageTag() {
        if (!cxQ()) {
            return this.itl.getTbPageTag();
        }
        if (this.iIa != null) {
            if (1 == this.iIa.getCurrentTabType()) {
                return this.itl.getTbPageTag();
            }
            Fragment currentFragment = this.iIa.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                return ((BaseFragment) currentFragment).getTbPageTag();
            }
        }
        return null;
    }
}
