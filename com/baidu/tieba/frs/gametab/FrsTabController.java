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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bf;
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
import tbclient.FrsPage.TipInfo;
import tbclient.FrsTabInfo;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes21.dex */
public class FrsTabController implements VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, FrsCommonImageLayout.c {
    public static final String jbc = FrsFragment.class.getSimpleName();
    public static final String jbd = FrsTabHostFragment.class.getSimpleName();
    private LinearLayout iIg;
    private am iMq;
    private FrsFragment iMr;
    private m iMs;
    private int iMu;
    private FRSRefreshButton iMw;
    private FrsActivity jbe;
    private FrsTabHostFragment jbf;
    private ShareSuccessReplyToServerModel jbi;
    private FrsBaseViewPager jbk;
    private FragmentAdapter jbl;
    private OvalActionButton jbm;
    private boolean jbn;
    private boolean jbo;
    private NavigationBarCoverTip jbp;
    private com.baidu.tieba.d.e jbs;
    private com.baidu.tieba.frs.f.d jbt;
    private Runnable jbu;
    private boolean jbv;
    private String mForumName;
    private String mFrom;
    private boolean jbg = false;
    private final Handler mHandler = new Handler();
    private int iMt = 0;
    private boolean jbj = false;
    private boolean jbq = false;
    private boolean jbr = false;
    private boolean jbw = false;
    private boolean jbx = false;
    private HttpMessageListener jby = new HttpMessageListener(CmdConfigHttp.CMD_FRS_RECOMMEND) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof FrsRecommendResMsg) {
                if (httpResponsedMessage.getError() != 0) {
                    new BdTopToast(FrsTabController.this.jbe).yr(false).Ue(httpResponsedMessage.getErrorString()).aF((ViewGroup) FrsTabController.this.jbe.findViewById(R.id.frs));
                    return;
                }
                int pushStatus = ((FrsRecommendResMsg) httpResponsedMessage).getPushStatus();
                String pushMsg = ((FrsRecommendResMsg) httpResponsedMessage).getPushMsg();
                if (pushStatus == 1) {
                    new ScreenTopToast(FrsTabController.this.jbe).Ui(FrsTabController.this.jbe.getString(R.string.frs_recommend_suc_tip_title)).Uj(FrsTabController.this.jbe.getString(R.string.frs_recommend_suc_tip_content)).Uk(FrsTabController.this.jbe.getString(R.string.dialog_confirm_see)).al(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.1.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("_forumId", FrsTabController.this.iMs.getForum().getId());
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new com.baidu.tieba.tbadkCore.data.m(FrsTabController.this.jbe, "RecommendHistoryPage", hashMap)));
                        }
                    }).aF((ViewGroup) FrsTabController.this.jbe.findViewById(R.id.frs));
                } else {
                    new BdTopToast(FrsTabController.this.jbe).yr(false).Ue(pushMsg).aF((ViewGroup) FrsTabController.this.jbe.findViewById(R.id.frs));
                }
            }
        }
    };
    private CustomMessageListener jbz = new CustomMessageListener(2921465) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            new ScreenTopToast(FrsTabController.this.jbe).Ui(FrsTabController.this.jbe.getString(R.string.frs_recommend_fail_month_tip)).Uk(FrsTabController.this.jbe.getString(R.string.frs_recommend_fail_tip_btn)).al(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.12.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("_forumId", FrsTabController.this.iMs.getForum().getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new com.baidu.tieba.tbadkCore.data.m(FrsTabController.this.jbe, "ForumGradePage", hashMap)));
                }
            }).aF((ViewGroup) FrsTabController.this.jbe.findViewById(R.id.frs));
        }
    };
    private com.baidu.adp.framework.listener.a jbA = new com.baidu.adp.framework.listener.a(1001703, CmdConfigSocket.CMD_FRS_PAGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.18
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            m mVar = null;
            int i = -1;
            if (!FrsTabController.this.jbg && !responsedMessage.hasError() && responsedMessage.getError() == 0) {
                if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                    mVar = ((FrsPageHttpResponseMessage) responsedMessage).getResponseData();
                    i = ((FrsPageHttpResponseMessage) responsedMessage).getUpdateType();
                } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                    mVar = ((FRSPageSocketResponsedMessage) responsedMessage).getResponseData();
                    i = ((FRSPageSocketResponsedMessage) responsedMessage).getUpdateType();
                }
                if (mVar != null) {
                    FrsTabController.this.jbg = true;
                    FrsTabController.this.a(mVar, true, i);
                    if (mVar != null && mVar.getForum() != null && !StringUtils.isNull(mVar.getForum().getId())) {
                        com.baidu.tbadk.core.business.a.biX().dD("2", mVar.getForum().getId());
                    }
                }
                if (mVar != null && mVar.getUserData() != null && mVar.getUserData().getNewGodData() != null) {
                    if (mVar.getForum() != null) {
                        w.bDg().setFid(mVar.getForum().getId());
                    }
                    w.bDg().b(2, mVar.getUserData().getNewGodData());
                }
            }
        }
    };
    private CustomMessageListener jbB = new CustomMessageListener(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!FrsTabController.this.jbg && FrsTabController.this.iMs == null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof m)) {
                m mVar = (m) customResponsedMessage.getData();
                if (mVar.getForum() != null && FrsTabController.this.mForumName != null && FrsTabController.this.mForumName.equals(mVar.getForum().getName())) {
                    FrsTabController.this.a(mVar, false, -1);
                }
            }
        }
    };
    private CustomMessageListener jbC = new CustomMessageListener(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsTabController.this.cDb();
        }
    };
    private CustomMessageListener jbD = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int zx;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (10001 == intValue) {
                    zx = FrsTabController.this.zx(9);
                    if (zx == -1) {
                        zx = FrsTabController.this.zx(2);
                    }
                } else {
                    zx = FrsTabController.this.zx(intValue);
                }
                if (zx != -1 && FrsTabController.this.cDc() && FrsTabController.this.jbf != null) {
                    FrsTabController.this.jbf.setCurrentTab(zx);
                    if (FrsTabController.this.zz(zx) != 1) {
                        FrsTabController.this.iMr.pz(false);
                    }
                }
            }
        }
    };
    private HttpMessageListener jbE = new HttpMessageListener(0) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && 1021074 == httpResponsedMessage.getCmd() && (httpResponsedMessage instanceof AlaGameTabGetNewNotifyResponsedMessage)) {
                List<a> newNotifyData = ((AlaGameTabGetNewNotifyResponsedMessage) httpResponsedMessage).getNewNotifyData();
                if (!y.isEmpty(newNotifyData) && FrsTabController.this.jbf != null) {
                    for (a aVar : newNotifyData) {
                        if (aVar != null) {
                            for (int i = 0; i < FrsTabController.this.iMq.byy().size(); i++) {
                                FragmentTabHost.b pk = FrsTabController.this.jbf.pk(i);
                                if (pk != null && pk.mType != 1 && pk.mType != FrsTabController.this.jbf.getCurrentTabType() && pk.mType == aVar.getTabId() && aVar.cCS() && pk.eKr.DD(String.valueOf(pk.mType)) != null) {
                                    pk.eKr.DD(String.valueOf(pk.mType)).view.setVisibility(0);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private Runnable jbF = new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.23
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this);
            FrsTabController.this.cDa();
            com.baidu.adp.lib.f.e.mY().postDelayed(this, 30000L);
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                FrsTabController.this.jbj = true;
            }
        }
    };
    private CustomMessageListener jbG = new CustomMessageListener(2921369) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.jbk != null && FrsTabController.this.jbl != null && (customResponsedMessage.getData() instanceof FrsTabViewPager.a)) {
                FrsTabViewPager.a aVar = (FrsTabViewPager.a) customResponsedMessage.getData();
                FrsTabController.this.jbn = aVar.czV();
                FrsTabController.this.jbo = aVar.czW();
            }
        }
    };
    private CustomMessageListener jbH = new CustomMessageListener(2921370) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.jbk != null && FrsTabController.this.jbl != null && (customResponsedMessage.getData() instanceof Boolean)) {
                FrsTabController.this.jbk.setForceIntercept(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };
    private CustomMessageListener jbI = new CustomMessageListener(CmdConfigCustom.CMD_NEW_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                FrsTabController.this.e((ForumData) null);
            }
        }
    };
    private CustomMessageListener jbJ = new CustomMessageListener(2921498) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsTabController.this.jbt != null && customResponsedMessage != null && customResponsedMessage.getData() != null) {
                if (customResponsedMessage.getData() instanceof ForumData) {
                    FrsTabController.this.e((ForumData) customResponsedMessage.getData());
                } else if (customResponsedMessage.getData() instanceof Long) {
                    long longValue = ((Long) customResponsedMessage.getData()).longValue();
                    if (FrsTabController.this.fL(longValue) && FrsTabController.this.jbt.fM(longValue) >= 3) {
                        FrsTabController.this.jbt.fN(longValue);
                        FrsTabController.this.jbw = true;
                    }
                }
            }
        }
    };
    private CustomMessageListener jbK = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                if (FrsTabController.this.jbt != null && aVar != null && TbadkCoreApplication.isLogin()) {
                    FrsTabController.this.jbt.eY(TbadkCoreApplication.getCurrentAccount(), String.valueOf(aVar.forumId));
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener jbL = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.7
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i != 1) {
                FrsTabController.this.jbm.setVisibility(0);
                if (FrsTabController.this.cxb() != null) {
                    FrsTabController.this.cxb().pt(false);
                }
                FrsTabController.this.iMr.cyr();
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            switch (i) {
                case 0:
                    FrsTabController.this.jbo = false;
                    FrsTabController.this.jbk.setForceIntercept(false);
                    return;
                default:
                    return;
            }
        }
    };
    private FrsBaseViewPager.a jbM = new FrsBaseViewPager.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.8
        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public void cxw() {
            if (FrsTabController.this.jbk != null) {
                if (FrsTabController.this.jbk.getCurrentItem() == 0) {
                    FrsTabController.this.jbk.setmDisallowSlip(true);
                } else {
                    FrsTabController.this.jbk.setmDisallowSlip(false);
                }
            }
        }

        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public boolean cxx() {
            if (FrsTabController.this.jbk.getCurrentItem() == 0) {
                if (FrsTabController.this.jbn && FrsTabController.this.jbo) {
                    FrsTabController.this.jbk.setmDisallowSlip(false);
                }
                if (!FrsTabController.this.jbo) {
                    FrsTabController.this.jbk.setmDisallowSlip(true);
                }
                FrsTabController.this.jbk.setmDisallowSlip(true);
            } else {
                FrsTabController.this.jbk.setmDisallowSlip(true);
            }
            return true;
        }
    };
    private String jbh = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.SHOW_GAME_FOREM_TAB_HOT_POINT);

    public FrsTabController(FrsActivity frsActivity) {
        this.jbe = frsActivity;
    }

    public void init(Bundle bundle) {
        if (this.jbe != null) {
            this.jbe.setContentView(R.layout.frs_base_layout);
            this.jbk = (FrsBaseViewPager) this.jbe.findViewById(R.id.frs_base_viewpager);
            this.jbl = new FragmentAdapter(this.jbe.getSupportFragmentManager());
            this.jbk.setAdapter(this.jbl);
            this.jbk.setPageTransformer(true, new CubeOutViewPagerTransformer());
            this.jbk.addOnPageChangeListener(this.jbL);
            this.jbk.setmDisallowSlip(true);
            this.jbk.setOnTouchEventListener(this.jbM);
            this.jbm = (OvalActionButton) this.jbe.findViewById(R.id.frs_post_forum_button);
            this.jbm.setIsCircle(true);
            this.jbm.setHasShadow(false);
            this.iMw = (FRSRefreshButton) this.jbe.findViewById(R.id.frs_refresh_forum_button);
            this.iIg = (LinearLayout) this.jbe.findViewById(R.id.frs_ll_redpack);
            this.jbe.registerListener(this.jbG);
            this.jbe.registerListener(this.jbH);
            this.jbA.getHttpMessageListener().setPriority(-1);
            this.jbA.getSocketMessageListener().setPriority(-1);
            this.jbe.registerListener(this.jbB);
            this.jbD.setSelfListener(true);
            this.jbe.registerListener(this.jbD);
            this.jbC.setSelfListener(true);
            this.jbe.registerListener(this.jbC);
            this.jbe.registerListener(this.mAccountChangedListener);
            if (bundle == null) {
                this.mForumName = this.jbe.getIntent().getStringExtra("name");
                this.mFrom = this.jbe.getIntent().getStringExtra("from");
                this.iMt = this.jbe.getIntent().getIntExtra(FrsActivityConfig.FRS_GAME_DEFAULT_TAB_ID, 0);
            } else {
                this.mForumName = bundle.getString("name");
                this.mFrom = bundle.getString("from");
                this.iMt = bundle.getInt("default_tab_id", 0);
            }
            an(bundle);
            this.jbl.notifyDataSetChanged();
            this.jbi = new ShareSuccessReplyToServerModel();
            this.jbe.registerListener(this.jbA);
            this.jbe.registerListener(this.jby);
            this.jbe.registerListener(this.jbz);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.mForumName);
        bundle.putInt("default_tab_id", this.iMt);
        bundle.putString("from", this.mFrom);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void an(Bundle bundle) {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.jbl != null) {
            try {
                FrsFragment frsFragment = (FrsFragment) this.jbl.Kh(jbc);
                if (frsFragment == null) {
                    frsFragment = ao(bundle);
                }
                frsFragment.b(this.jbm);
                frsFragment.a(this.iMw);
                frsFragment.c(this.iIg);
                if (!jbc.equals(this.jbl.Aq(0))) {
                    if (jbd.equals(this.jbl.Aq(0))) {
                        this.jbl.Ap(0);
                    }
                    this.jbl.a(0, frsFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCV() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.jbl != null) {
            try {
                FrsTabHostFragment frsTabHostFragment = (FrsTabHostFragment) this.jbl.Kh(jbd);
                if (frsTabHostFragment == null) {
                    frsTabHostFragment = cCW();
                }
                frsTabHostFragment.b(this.jbm);
                frsTabHostFragment.b(this.iMw);
                if (!jbd.equals(this.jbl.Aq(0))) {
                    if (jbc.equals(this.jbl.Aq(0))) {
                        this.jbl.Ap(0);
                    }
                    this.jbl.a(0, frsTabHostFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private FrsFragment ao(Bundle bundle) {
        if (this.iMr == null) {
            this.iMr = new FrsFragment();
            this.iMr.setArguments(bundle);
            this.iMr.setBaseTag(jbc);
        }
        this.iMr.iIn = false;
        return this.iMr;
    }

    private FrsTabHostFragment cCW() {
        if (this.jbf == null) {
            this.jbf = new FrsTabHostFragment(this);
            this.jbf.setBaseTag(jbd);
            this.jbf.zB(this.iMt);
        }
        return this.jbf;
    }

    private FragmentManager getFragmentManager() {
        if (this.jbe != null) {
            return this.jbe.getSupportFragmentManager();
        }
        return null;
    }

    private void cCX() {
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.iMs != null && (themeColorInfo = this.iMs.getForum().getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            this.jbm.setStartAndEndColor(themeElement.light_color, themeElement.dark_color);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(m mVar, boolean z, int i) {
        if (mVar != null && mVar.getForum() != null) {
            ForumData forum = mVar.getForum();
            if (z) {
                a(forum, mVar.getAnti());
            }
            if (forum.getIsShowBawuTask() && com.baidu.tbadk.core.sharedPref.b.bpu().getInt("key_bawu_task_toast", 0) == 0 && !this.jbq) {
                this.jbq = true;
                com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.9
                    @Override // java.lang.Runnable
                    public void run() {
                        FrsTabController.this.cDd();
                    }
                }, 30000L);
            }
            if (mVar.bazhuExam != null && !this.jbr && z) {
                com.baidu.tieba.frs.m.a(this.jbe.getPageContext(), mVar.bazhuExam, forum.getId(), forum.getName());
                this.jbr = true;
            }
            this.iMs = mVar;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921476));
            if (y.getCount(mVar.getGameTabInfo()) > 0) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.10
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean dl = FrsTabController.this.dl(FrsTabController.this.iMs.getGameTabInfo());
                        if (dl) {
                            FrsTabController.this.jbl.notifyDataSetChanged();
                            if (dl && FrsTabController.this.jbf != null) {
                                FrsTabController.this.jbf.Z(FrsTabController.this.iMr);
                                FrsTabController.this.jbf.a(FrsTabController.this.iMs, FrsTabController.this.iMq);
                            }
                        }
                        if (FrsTabController.this.jbe.isLoadingViewAttached()) {
                            FrsTabController.this.jbe.hideLoadingView(FrsTabController.this.jbe.findViewById(16908290));
                        }
                    }
                });
            } else if (cDc()) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.11
                    @Override // java.lang.Runnable
                    public void run() {
                        Bundle bundle;
                        FrsTabController.this.iMr.iIn = true;
                        if (FrsTabController.this.iMr != null) {
                            bundle = FrsTabController.this.iMr.getArguments();
                        } else {
                            bundle = null;
                        }
                        FrsTabController.this.an(bundle);
                        FrsTabController.this.jbl.notifyDataSetChanged();
                        if (FrsTabController.this.jbe.isLoadingViewAttached()) {
                            FrsTabController.this.jbe.hideLoadingView(FrsTabController.this.jbe.findViewById(16908290));
                        }
                    }
                });
            }
            cCX();
            cDe();
            if (z) {
                if ((!this.jbv || i == 4) && forum.isLike() == 0 && com.baidu.tbadk.a.d.bhr() && TbadkCoreApplication.isLogin()) {
                    this.jbt = new com.baidu.tieba.frs.f.d();
                    this.jbe.registerListener(this.jbJ);
                    this.jbe.registerListener(this.jbI);
                    this.jbe.registerListener(this.jbK);
                    d(forum);
                }
            }
        }
    }

    private void a(ForumData forumData, AntiData antiData) {
        if (forumData != null && !com.baidu.tbadk.youngster.b.a.a(this.jbe.getPageContext(), antiData, R.id.frs) && !c(forumData)) {
            List<TipInfo> tipInfos = forumData.getTipInfos();
            if (!y.isEmpty(tipInfos)) {
                com.baidu.tbadk.youngster.b.a.a(this.jbe.getPageContext(), tipInfos.get(0), TbadkCoreApplication.getCurrentAccount(), forumData.getId(), this.jbe.getString(R.string.frs_risk_dialog_button_text));
            }
        }
    }

    private boolean c(ForumData forumData) {
        if (au.isEmpty(forumData.getRiskTipPop()) || au.isEmpty(forumData.getRiskTipPopTitle())) {
            return false;
        }
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jbe);
        aVar.AI(forumData.getRiskTipPopTitle());
        aVar.setTitleShowCenter(true);
        aVar.setMessageShowCenter(true);
        aVar.AJ(forumData.getRiskTipPop());
        aVar.a(R.string.frs_risk_dialog_button_text, new a.b() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.13
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar.dismiss();
            }
        });
        aVar.b(this.jbe.getPageContext()).bog();
        return true;
    }

    public m cCY() {
        return this.iMs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dl(List<FrsTabInfo> list) {
        if (this.jbe.isLoadingViewAttached()) {
            this.jbe.hideLoadingView(this.jbe.findViewById(16908290));
        }
        if (cDc()) {
            return false;
        }
        this.iMr.iIn = true;
        cCZ();
        if (com.baidu.tbadk.core.sharedPref.b.bpu().getBoolean("frs_game_login_tip", true)) {
            com.baidu.tbadk.core.sharedPref.b.bpu().putBoolean(SharedPrefConfig.FRS_LOGIN_TIP, true);
            com.baidu.tbadk.core.sharedPref.b.bpu().putBoolean("frs_game_login_tip", false);
        }
        dm(list);
        return true;
    }

    private void cCZ() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021074, TbConfig.SERVER_ADDRESS + "game/forum/getNewNotify");
        tbHttpMessageTask.setResponsedClass(AlaGameTabGetNewNotifyResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.jbe.registerListener(1021074, this.jbE);
    }

    private void dm(List<FrsTabInfo> list) {
        boolean z;
        if (!y.isEmpty(list)) {
            CustomMessageListener customMessageListener = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.14
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof am)) {
                        if (!com.baidu.tbadk.core.sharedPref.b.bpu().getBoolean(FrsTabController.this.jbh, true)) {
                            com.baidu.adp.lib.f.e.mY().post(FrsTabController.this.jbF);
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
                                bundle.putString("name", FrsTabController.this.iMr.getForumName());
                                bundle.putString("from", FrsTabController.this.iMr.getFrom());
                                bundle.putString("forum_id", FrsTabController.this.iMr.getForumId());
                                bundle.putInt("tab_id", 503);
                                bundle.putBoolean("can_auto_play_video", FrsTabController.this.iMs.isFrsVideoAutoPlay);
                                bundle.putBoolean("need_log", FrsTabController.this.iMs.needLog == 1);
                                bundle.putBoolean("is_brand_forum", FrsTabController.this.iMs.isBrandForum);
                                FrsViewData frsViewData = new FrsViewData();
                                frsViewData.receiveData(FrsTabController.this.iMs);
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
                        FrsTabController.this.cCV();
                    }
                }
            };
            customMessageListener.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            customMessageListener.setSelfListener(true);
            this.jbe.registerListener(customMessageListener);
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
            this.iMq = new am(this.jbe.getActivity(), arrayList);
            if (cxb() != null) {
                this.iMq.setForumId(cxb().getForumId());
                this.iMq.setForumName(cxb().getForumName());
                if (cxb().cys() != null && cxb().cys().getForum() != null) {
                    ForumData forum = cxb().cys().getForum();
                    this.iMq.setForumGameLabel(forum.getForumGameLabel());
                    this.iMq.Ih(forum.getSpecialForumType());
                }
            }
            this.iMr.iIn = false;
            new e(this.iMr).a(this.iMq);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB, this.iMq);
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB);
            customMessage.setTag(this.jbe.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDa() {
        if (this.iMq != null && !TextUtils.isEmpty(this.iMq.getForumId())) {
            HttpMessage httpMessage = new HttpMessage(1021074);
            httpMessage.addParam("forum_id", this.iMs.getForum().getId());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    private void a(Fragment fragment, int i) {
        NavigationBar bSa;
        if ((fragment instanceof at) && this.iMs != null && this.iMs.getForum() != null && (bSa = ((at) fragment).bSa()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.iMs.getForum().getName(), 5, true, true) + this.jbe.getActivity().getString(R.string.forum));
            bSa.setCenterTextTitle(sb.toString());
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.iMr instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.iMr.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a ty(int i) {
        if (this.iMr instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.iMr.ty(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.iMr instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.iMr.a(bVar);
        }
    }

    public void onNewIntent(Intent intent) {
        if (this.iMr != null) {
            this.iMr.onNewIntent(intent);
        }
    }

    public void onResume() {
        if (!cDc()) {
            this.iMr.setPrimary(true);
        } else if (this.jbf != null) {
            Fragment currentFragment = this.jbf.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(true);
            }
        }
        if (this.jbj) {
            this.jbj = false;
            if (this.iMr != null) {
                this.iMr.refresh();
            }
        }
        if (this.iMs != null && this.iMs.getUserData() != null && this.iMs.getUserData().getNewGodData() != null) {
            if (this.iMs.getForum() != null) {
                w.bDg().setFid(this.iMs.getForum().getId());
            }
            w.bDg().b(2, this.iMs.getUserData().getNewGodData());
        }
        this.jbx = true;
        if (this.jbw) {
            e((ForumData) null);
        }
    }

    public void onPause() {
        this.jbx = false;
        if (this.jbt != null) {
            this.jbt.cEO();
        }
        if (!cDc()) {
            this.iMr.setPrimary(false);
        } else if (this.jbf != null) {
            Fragment currentFragment = this.jbf.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(false);
            }
        }
        w.bDg().removeCallbacks();
    }

    public void onChangeSkinType(int i) {
        UtilHelper.changeStatusBarIconAndTextColor(true, this.jbe);
        if (this.iMr != null) {
            this.iMr.onChangeSkinType(i);
        }
        if (this.jbf != null) {
            this.jbf.onChangeSkinType(i);
        }
        cCX();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (cDc() && this.jbf != null && this.jbf.czz()) {
                this.jbf.czQ();
                UtilHelper.setNavigationBarBackground(this.jbe, this.jbf.czL());
            } else if (this.iMr != null && this.iMr.isAdded()) {
                if (this.iMr.onKeyDown(i, keyEvent)) {
                    return true;
                }
                cDb();
            } else {
                return this.jbe.b(i, keyEvent);
            }
        } else if (i == 24) {
            if (this.iMr != null && this.iMr.isAdded()) {
                return this.iMr.onKeyDown(i, keyEvent);
            }
        } else {
            return this.jbe.b(i, keyEvent);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDb() {
        if (this.iMu != this.iMt && cDc()) {
            this.jbf.setCurrentTab(this.iMt);
            if (zz(this.iMt) != 1) {
                this.iMr.pz(false);
            }
            this.iMu = this.iMt;
            a(this.jbf.getCurrentFragment(), this.iMt);
            return;
        }
        this.iMr.closeActivity();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!cDc()) {
            this.iMr.onActivityResult(i, i2, intent);
        } else if (this.jbf != null) {
            if (1 == this.jbf.getCurrentTabType()) {
                this.iMr.onActivityResult(i, i2, intent);
            } else {
                this.jbf.getCurrentFragment().onActivityResult(i, i2, intent);
            }
        }
        if (i2 == -1) {
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1) {
                    com.baidu.tieba.p.a.dzt().F(this.jbe.getPageContext());
                    ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.linkUrl != null && this.jbi != null) {
                        this.jbi.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.15
                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void bwm() {
                            }

                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void a(final CustomDialogData customDialogData) {
                                com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.15.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (FrsTabController.this.jbe != null) {
                                            com.baidu.tieba.pb.interactionpopupwindow.c.a(FrsTabController.this.jbe.getPageContext(), customDialogData).show();
                                        }
                                    }
                                }, 1000L);
                            }
                        });
                    }
                }
            } else if (i == 13011) {
                com.baidu.tieba.p.a.dzt().F(this.jbe.getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (!cDc()) {
            return this.iMr.getVoiceManager();
        }
        if (this.jbf == null) {
            return null;
        }
        Fragment currentFragment = this.jbf.getCurrentFragment();
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
    public int zx(int i) {
        if (this.iMq == null) {
            return -1;
        }
        int count = y.getCount(this.iMq.byy());
        for (int i2 = 0; i2 < count; i2++) {
            if (this.iMq.byy().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int zz(int i) {
        if (this.iMq != null && i < y.getCount(this.iMq.byy())) {
            return this.iMq.byy().get(i).tab_id.intValue();
        }
        return -1;
    }

    public FrsFragment cxb() {
        return this.iMr;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> cxc() {
        if (!cDc()) {
            if (this.iMr instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) this.iMr).cxc();
            }
        } else if (this.jbf == null) {
            return null;
        } else {
            Fragment currentFragment = this.jbf.getCurrentFragment();
            if (currentFragment instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) currentFragment).cxc();
            }
        }
        return null;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(t.iLA);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.jbe.isLoadingViewAttached()) {
            this.jbe.hideLoadingView(this.jbe.findViewById(16908290));
        }
        if (this.jbF != null) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jbF);
        }
        com.baidu.tbadk.core.sharedPref.b.bpu().putBoolean(this.jbh, false);
        if (this.jbi != null) {
            this.jbi.cancelLoadData();
        }
        if (this.iMr != null && this.iMr.cxJ() != null) {
            this.iMr.cxJ().cDp();
        }
        if (this.jbp != null) {
            this.jbp.onDestroy();
        }
        if (FrsActivityConfig.FRS_FROM_FLUTTER_BCASTEDIT.equals(this.mFrom)) {
            new o(TbadkCoreApplication.getInst()).bpJ();
        }
        if (this.jbu != null) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jbu);
        }
        if (this.iMs != null && this.iMs.getForum() != null && this.jbt != null) {
            this.jbt.fN(com.baidu.adp.lib.f.b.toLong(this.iMs.getForum().getId(), 0L));
        }
    }

    public FragmentTabHost czO() {
        if (this.jbf == null) {
            return null;
        }
        return this.jbf.czO();
    }

    public boolean cDc() {
        if (this.jbl == null) {
            return false;
        }
        return this.jbl.getItem(0) instanceof FrsTabHostFragment;
    }

    public void zB(int i) {
        this.iMt = i;
    }

    public void An(int i) {
        this.iMu = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDd() {
        if (this.jbe != null) {
            if (this.jbp == null) {
                this.jbp = (NavigationBarCoverTip) this.jbe.findViewById(R.id.navigation_cover_tip);
            }
            if (this.jbp != null) {
                View inflate = View.inflate(this.jbe, R.layout.write_thread_share_guide, null);
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
                cVar.bsD();
                tBSpecificationBtn.setConfig(cVar);
                tBSpecificationBtn.brT();
                ap.setViewTextColor(textView, R.color.CAM_X0101);
                ap.setBackgroundColor(this.jbp, R.color.cp_link_tip_a_alpha95);
                tBSpecificationBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.16
                    /* JADX DEBUG: Multi-variable search result rejected for r4v9, resolved type: com.baidu.tieba.frs.FrsActivity */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        new ar("c13439").bqy();
                        if (FrsTabController.this.cxb() != null && !TextUtils.isEmpty(FrsTabController.this.cxb().getForumId()) && !TextUtils.isEmpty(FrsTabController.this.mForumName) && FrsTabController.this.jbe != null) {
                            if (FrsTabController.this.jbp != null) {
                                FrsTabController.this.jbp.hideTip();
                            }
                            bf.bqF().b(FrsTabController.this.jbe.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/bawutask?fid=" + FrsTabController.this.cxb().getForumId() + "&fn=" + FrsTabController.this.mForumName + "&noread=" + (com.baidu.tbadk.core.sharedPref.b.bpu().getInt("key_bawu_task_toast", 0) == -1 ? 1 : 0)});
                        }
                    }
                });
                this.jbp.a(this.jbe, inflate, 30000);
                new ar("c13438").bqy();
                int i = com.baidu.tbadk.core.sharedPref.b.bpu().getInt("key_bawu_task_toast", 0);
                if (i >= 0) {
                    com.baidu.tbadk.core.sharedPref.b.bpu().putInt("key_bawu_task_toast", i + 1);
                }
            }
        }
    }

    private void cDe() {
        boolean z;
        if (this.iMs != null && this.iMs.getEntelechyTabInfo() != null && this.iMs.getEntelechyTabInfo().tab != null) {
            Iterator<FrsTabInfo> it = this.iMs.getEntelechyTabInfo().tab.iterator();
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
                if (this.jbs == null) {
                    this.jbs = new com.baidu.tieba.d.e(this.jbe.getPageContext(), this.jbm);
                    this.jbs.fq(R.drawable.pic_sign_tip_down);
                    this.jbs.setAnchor(2);
                    this.jbs.setUseDirectOffset(true);
                    this.jbs.xO(-l.getDimens(this.jbe, R.dimen.tbds20));
                    this.jbs.setYOffset(-l.getDimens(this.jbe, R.dimen.tbds20));
                    this.jbs.setTextColor(R.color.CAM_X0101);
                    this.jbs.setHeight(R.dimen.tbds54);
                    this.jbs.xM(l.getDimens(this.jbe, R.dimen.tbds44));
                }
                this.jbs.aL(this.jbe.getString(R.string.frs_evaluate_tip), "first_into_frs_with_evaluate_tab");
            }
        }
    }

    private void d(final ForumData forumData) {
        boolean z = false;
        if (g(forumData.getName(), forumData.getId(), forumData.getImage_url(), false)) {
            if (this.jbu != null) {
                com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jbu);
            }
            z = true;
        }
        if (!this.jbv) {
            this.jbt.cEN().i(TbadkCoreApplication.getCurrentAccount(), forumData.getId(), System.currentTimeMillis());
            this.jbv = true;
        }
        if (!z) {
            this.jbu = this.jbu != null ? this.jbu : new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.17
                @Override // java.lang.Runnable
                public void run() {
                    if (FrsTabController.this.jbt != null) {
                        if (FrsTabController.this.jbx) {
                            FrsTabController.this.g(forumData.getName(), forumData.getId(), forumData.getImage_url(), true);
                        } else {
                            FrsTabController.this.jbw = true;
                        }
                    }
                }
            };
            com.baidu.adp.lib.f.e.mY().postDelayed(this.jbu, 60000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ForumData forumData) {
        if (this.iMr.cxL() != null && this.jbt != null) {
            if (forumData == null) {
                forumData = this.iMs.getForum();
            }
            if (forumData != null && forumData.isLike() != 1) {
                if (!this.jbx) {
                    this.jbw = true;
                } else if (g(forumData.getName(), forumData.getId(), forumData.getImage_url(), false) && this.jbu != null) {
                    com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jbu);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(String str, String str2, String str3, boolean z) {
        if (!this.jbt.eZ(TbadkCoreApplication.getCurrentAccount(), str2) || this.iMr == null || this.iMr.cxL() == null) {
            return false;
        }
        this.jbw = false;
        this.jbt.a(this.jbe, str, str2, str3, this.iMr.cxL().cFG());
        this.jbt.cEN().a(TbadkCoreApplication.getCurrentAccount(), str2, System.currentTimeMillis(), z);
        return true;
    }

    public boolean fL(long j) {
        ForumData forum;
        return (this.iMs == null || j == 0 || (forum = this.iMs.getForum()) == null || com.baidu.adp.lib.f.b.toLong(forum.getId(), 0L) != j) ? false : true;
    }

    /* loaded from: classes21.dex */
    public class FragmentAdapter extends FragmentStatePagerAdapter {
        private List<BaseFragment> mFragments;

        public FragmentAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.mFragments = new ArrayList(2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v4.app.FragmentStatePagerAdapter
        /* renamed from: Ao */
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

        public BaseFragment Kh(String str) {
            if (au.isEmpty(str)) {
                return null;
            }
            for (BaseFragment baseFragment : this.mFragments) {
                if (baseFragment != null && str.equals(baseFragment.getBaseTag())) {
                    return baseFragment;
                }
            }
            return null;
        }

        public BaseFragment Ap(int i) {
            return (BaseFragment) y.remove(this.mFragments, i);
        }

        public String Aq(int i) {
            if (getItem(i) != null) {
                return getItem(i).getBaseTag();
            }
            return null;
        }
    }

    public TbPageTag getTbPageTag() {
        if (!cDc()) {
            return this.iMr.getTbPageTag();
        }
        if (this.jbf != null) {
            if (1 == this.jbf.getCurrentTabType()) {
                return this.iMr.getTbPageTag();
            }
            Fragment currentFragment = this.jbf.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                return ((BaseFragment) currentFragment).getTbPageTag();
            }
        }
        return null;
    }

    public void onScreenShot(String str) {
        if (this.iMs != null && this.iMs.getForum() != null) {
            TiebaStatic.log(new ar("c13848").dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fid", this.iMs.getForum().getId()).ak("obj_type", 2));
        }
    }
}
