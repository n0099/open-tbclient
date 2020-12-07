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
import com.baidu.tieba.frs.al;
import com.baidu.tieba.frs.as;
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
    public static final String joE = FrsFragment.class.getSimpleName();
    public static final String joF = FrsTabHostFragment.class.getSimpleName();
    private LinearLayout iSY;
    private al iXh;
    private FrsFragment iXi;
    private m iXj;
    private int iXl;
    private FRSRefreshButton iXn;
    private FrsActivity joG;
    private FrsTabHostFragment joH;
    private ShareSuccessReplyToServerModel joK;
    private FrsBaseViewPager joM;
    private FragmentAdapter joN;
    private OvalActionButton joO;
    private boolean joP;
    private boolean joQ;
    private NavigationBarCoverTip joR;
    private com.baidu.tieba.d.e joU;
    private com.baidu.tieba.frs.f.e joV;
    private Runnable joW;
    private boolean joX;
    private String mForumName;
    private String mFrom;
    private boolean joI = false;
    private final Handler mHandler = new Handler();
    private int iXk = 0;
    private boolean joL = false;
    private boolean joS = false;
    private boolean joT = false;
    private boolean joY = false;
    private boolean joZ = false;
    private HttpMessageListener jpa = new HttpMessageListener(CmdConfigHttp.CMD_FRS_RECOMMEND) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof FrsRecommendResMsg) {
                if (httpResponsedMessage.getError() != 0) {
                    new BdTopToast(FrsTabController.this.joG).yW(false).Vt(httpResponsedMessage.getErrorString()).aF((ViewGroup) FrsTabController.this.joG.findViewById(R.id.frs));
                    return;
                }
                int pushStatus = ((FrsRecommendResMsg) httpResponsedMessage).getPushStatus();
                String pushMsg = ((FrsRecommendResMsg) httpResponsedMessage).getPushMsg();
                if (pushStatus == 1) {
                    new ScreenTopToast(FrsTabController.this.joG).Vx(FrsTabController.this.joG.getString(R.string.frs_recommend_suc_tip_title)).Vy(FrsTabController.this.joG.getString(R.string.frs_recommend_suc_tip_content)).Vz(FrsTabController.this.joG.getString(R.string.dialog_confirm_see)).al(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.1.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("_forumId", FrsTabController.this.iXj.getForum().getId());
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new com.baidu.tieba.tbadkCore.data.m(FrsTabController.this.joG, "RecommendHistoryPage", hashMap)));
                        }
                    }).aF((ViewGroup) FrsTabController.this.joG.findViewById(R.id.frs));
                } else {
                    new BdTopToast(FrsTabController.this.joG).yW(false).Vt(pushMsg).aF((ViewGroup) FrsTabController.this.joG.findViewById(R.id.frs));
                }
            }
        }
    };
    private CustomMessageListener jpb = new CustomMessageListener(2921465) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            new ScreenTopToast(FrsTabController.this.joG).Vx(FrsTabController.this.joG.getString(R.string.frs_recommend_fail_month_tip)).Vz(FrsTabController.this.joG.getString(R.string.frs_recommend_fail_tip_btn)).al(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.12.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("_forumId", FrsTabController.this.iXj.getForum().getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new com.baidu.tieba.tbadkCore.data.m(FrsTabController.this.joG, "ForumGradePage", hashMap)));
                }
            }).aF((ViewGroup) FrsTabController.this.joG.findViewById(R.id.frs));
        }
    };
    private com.baidu.adp.framework.listener.a jpc = new com.baidu.adp.framework.listener.a(1001703, CmdConfigSocket.CMD_FRS_PAGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.19
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            m mVar = null;
            int i = -1;
            if (!FrsTabController.this.joI && !responsedMessage.hasError() && responsedMessage.getError() == 0) {
                if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                    mVar = ((FrsPageHttpResponseMessage) responsedMessage).getResponseData();
                    i = ((FrsPageHttpResponseMessage) responsedMessage).getUpdateType();
                } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                    mVar = ((FRSPageSocketResponsedMessage) responsedMessage).getResponseData();
                    i = ((FRSPageSocketResponsedMessage) responsedMessage).getUpdateType();
                }
                if (mVar != null) {
                    FrsTabController.this.joI = true;
                    FrsTabController.this.a(mVar, true, i);
                    if (mVar != null && mVar.getForum() != null && !StringUtils.isNull(mVar.getForum().getId())) {
                        com.baidu.tbadk.core.business.a.bmh().dK("2", mVar.getForum().getId());
                    }
                }
                if (mVar != null && mVar.getUserData() != null && mVar.getUserData().getNewGodData() != null) {
                    if (mVar.getForum() != null) {
                        w.bGH().setFid(mVar.getForum().getId());
                    }
                    w.bGH().b(2, mVar.getUserData().getNewGodData());
                }
            }
        }
    };
    private CustomMessageListener jpd = new CustomMessageListener(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!FrsTabController.this.joI && FrsTabController.this.iXj == null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof m)) {
                m mVar = (m) customResponsedMessage.getData();
                if (mVar.getForum() != null && FrsTabController.this.mForumName != null && FrsTabController.this.mForumName.equals(mVar.getForum().getName())) {
                    FrsTabController.this.a(mVar, false, -1);
                }
            }
        }
    };
    private CustomMessageListener jpe = new CustomMessageListener(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsTabController.this.cIo();
        }
    };
    private CustomMessageListener jpf = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int Ac;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (10001 == intValue) {
                    Ac = FrsTabController.this.Ac(9);
                    if (Ac == -1) {
                        Ac = FrsTabController.this.Ac(2);
                    }
                } else {
                    Ac = FrsTabController.this.Ac(intValue);
                }
                if (Ac != -1 && FrsTabController.this.cIp() && FrsTabController.this.joH != null) {
                    FrsTabController.this.joH.setCurrentTab(Ac);
                    if (FrsTabController.this.Ae(Ac) != 1) {
                        FrsTabController.this.iXi.pW(false);
                    }
                }
            }
        }
    };
    private HttpMessageListener jpg = new HttpMessageListener(0) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && 1021074 == httpResponsedMessage.getCmd() && (httpResponsedMessage instanceof AlaGameTabGetNewNotifyResponsedMessage)) {
                List<a> newNotifyData = ((AlaGameTabGetNewNotifyResponsedMessage) httpResponsedMessage).getNewNotifyData();
                if (!y.isEmpty(newNotifyData) && FrsTabController.this.joH != null) {
                    for (a aVar : newNotifyData) {
                        if (aVar != null) {
                            for (int i = 0; i < FrsTabController.this.iXh.bBY().size(); i++) {
                                FragmentTabHost.b pL = FrsTabController.this.joH.pL(i);
                                if (pL != null && pL.mType != 1 && pL.mType != FrsTabController.this.joH.getCurrentTabType() && pL.mType == aVar.getTabId() && aVar.cId() && pL.eRD.El(String.valueOf(pL.mType)) != null) {
                                    pL.eRD.El(String.valueOf(pL.mType)).view.setVisibility(0);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener jph = new CustomMessageListener(2921518) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            new BdTopToast(FrsTabController.this.joG, 2000).yW(false).Vt(FrsTabController.this.joG.getString(R.string.frs_top_forum_rules_click_toast)).aF((ViewGroup) FrsTabController.this.joG.findViewById(R.id.frs));
        }
    };
    private Runnable jpi = new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.25
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this);
            FrsTabController.this.cIn();
            com.baidu.adp.lib.f.e.mY().postDelayed(this, 30000L);
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                FrsTabController.this.joL = true;
            }
        }
    };
    private CustomMessageListener jpj = new CustomMessageListener(2921369) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.joM != null && FrsTabController.this.joN != null && (customResponsedMessage.getData() instanceof FrsTabViewPager.a)) {
                FrsTabViewPager.a aVar = (FrsTabViewPager.a) customResponsedMessage.getData();
                FrsTabController.this.joP = aVar.cEl();
                FrsTabController.this.joQ = aVar.cEm();
            }
        }
    };
    private CustomMessageListener jpk = new CustomMessageListener(2921370) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.joM != null && FrsTabController.this.joN != null && (customResponsedMessage.getData() instanceof Boolean)) {
                FrsTabController.this.joM.setForceIntercept(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };
    private CustomMessageListener jpl = new CustomMessageListener(CmdConfigCustom.CMD_NEW_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                FrsTabController.this.e((ForumData) null);
            }
        }
    };
    private CustomMessageListener jpm = new CustomMessageListener(2921498) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsTabController.this.joV != null && customResponsedMessage != null && customResponsedMessage.getData() != null) {
                if (customResponsedMessage.getData() instanceof ForumData) {
                    FrsTabController.this.e((ForumData) customResponsedMessage.getData());
                } else if (customResponsedMessage.getData() instanceof Long) {
                    long longValue = ((Long) customResponsedMessage.getData()).longValue();
                    if (FrsTabController.this.gq(longValue) && FrsTabController.this.joV.gr(longValue) >= 3) {
                        FrsTabController.this.joV.gs(longValue);
                        FrsTabController.this.joY = true;
                    }
                }
            }
        }
    };
    private CustomMessageListener jpn = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                if (FrsTabController.this.joV != null && aVar != null && TbadkCoreApplication.isLogin()) {
                    FrsTabController.this.joV.fe(TbadkCoreApplication.getCurrentAccount(), String.valueOf(aVar.forumId));
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener jpo = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.8
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i != 1) {
                FrsTabController.this.joO.setVisibility(0);
                if (FrsTabController.this.cBq() != null) {
                    FrsTabController.this.cBq().pQ(false);
                }
                FrsTabController.this.iXi.cCI();
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            switch (i) {
                case 0:
                    FrsTabController.this.joQ = false;
                    FrsTabController.this.joM.setForceIntercept(false);
                    return;
                default:
                    return;
            }
        }
    };
    private FrsBaseViewPager.a jpp = new FrsBaseViewPager.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.9
        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public void cBM() {
            if (FrsTabController.this.joM != null) {
                if (FrsTabController.this.joM.getCurrentItem() == 0) {
                    FrsTabController.this.joM.setmDisallowSlip(true);
                } else {
                    FrsTabController.this.joM.setmDisallowSlip(false);
                }
            }
        }

        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public boolean cBN() {
            if (FrsTabController.this.joM.getCurrentItem() == 0) {
                if (FrsTabController.this.joP && FrsTabController.this.joQ) {
                    FrsTabController.this.joM.setmDisallowSlip(false);
                }
                if (!FrsTabController.this.joQ) {
                    FrsTabController.this.joM.setmDisallowSlip(true);
                }
                FrsTabController.this.joM.setmDisallowSlip(true);
            } else {
                FrsTabController.this.joM.setmDisallowSlip(true);
            }
            return true;
        }
    };
    private String joJ = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.SHOW_GAME_FOREM_TAB_HOT_POINT);

    public FrsTabController(FrsActivity frsActivity) {
        this.joG = frsActivity;
    }

    public void init(Bundle bundle) {
        if (this.joG != null) {
            this.joG.setContentView(R.layout.frs_base_layout);
            this.joM = (FrsBaseViewPager) this.joG.findViewById(R.id.frs_base_viewpager);
            this.joN = new FragmentAdapter(this.joG.getSupportFragmentManager());
            this.joM.setAdapter(this.joN);
            this.joM.setPageTransformer(true, new CubeOutViewPagerTransformer());
            this.joM.addOnPageChangeListener(this.jpo);
            this.joM.setmDisallowSlip(true);
            this.joM.setOnTouchEventListener(this.jpp);
            this.joO = (OvalActionButton) this.joG.findViewById(R.id.frs_post_forum_button);
            this.joO.setIsCircle(true);
            this.joO.setHasShadow(false);
            this.iXn = (FRSRefreshButton) this.joG.findViewById(R.id.frs_refresh_forum_button);
            this.iSY = (LinearLayout) this.joG.findViewById(R.id.frs_ll_redpack);
            this.joG.registerListener(this.jpj);
            this.joG.registerListener(this.jpk);
            this.jpc.getHttpMessageListener().setPriority(-1);
            this.jpc.getSocketMessageListener().setPriority(-1);
            this.joG.registerListener(this.jpd);
            this.jpf.setSelfListener(true);
            this.joG.registerListener(this.jpf);
            this.jpe.setSelfListener(true);
            this.joG.registerListener(this.jpe);
            this.joG.registerListener(this.mAccountChangedListener);
            if (bundle == null) {
                this.mForumName = this.joG.getIntent().getStringExtra("name");
                this.mFrom = this.joG.getIntent().getStringExtra("from");
                this.iXk = this.joG.getIntent().getIntExtra(FrsActivityConfig.FRS_GAME_DEFAULT_TAB_ID, 0);
            } else {
                this.mForumName = bundle.getString("name");
                this.mFrom = bundle.getString("from");
                this.iXk = bundle.getInt("default_tab_id", 0);
            }
            ap(bundle);
            this.joN.notifyDataSetChanged();
            this.joK = new ShareSuccessReplyToServerModel();
            this.joG.registerListener(this.jpc);
            this.joG.registerListener(this.jpa);
            this.joG.registerListener(this.jpb);
            this.joG.registerListener(this.jph);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.mForumName);
        bundle.putInt("default_tab_id", this.iXk);
        bundle.putString("from", this.mFrom);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap(Bundle bundle) {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.joN != null) {
            try {
                FrsFragment frsFragment = (FrsFragment) this.joN.Lo(joE);
                if (frsFragment == null) {
                    frsFragment = aq(bundle);
                }
                frsFragment.b(this.joO);
                frsFragment.a(this.iXn);
                frsFragment.c(this.iSY);
                if (!joE.equals(this.joN.Be(0))) {
                    if (joF.equals(this.joN.Be(0))) {
                        this.joN.Bd(0);
                    }
                    this.joN.a(0, frsFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cIi() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.joN != null) {
            try {
                FrsTabHostFragment frsTabHostFragment = (FrsTabHostFragment) this.joN.Lo(joF);
                if (frsTabHostFragment == null) {
                    frsTabHostFragment = cIj();
                }
                frsTabHostFragment.b(this.joO);
                frsTabHostFragment.b(this.iXn);
                if (!joF.equals(this.joN.Be(0))) {
                    if (joE.equals(this.joN.Be(0))) {
                        this.joN.Bd(0);
                    }
                    this.joN.a(0, frsTabHostFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private FrsFragment aq(Bundle bundle) {
        if (this.iXi == null) {
            this.iXi = new FrsFragment();
            this.iXi.setArguments(bundle);
            this.iXi.setBaseTag(joE);
        }
        this.iXi.iTf = false;
        return this.iXi;
    }

    private FrsTabHostFragment cIj() {
        if (this.joH == null) {
            this.joH = new FrsTabHostFragment(this);
            this.joH.setBaseTag(joF);
            this.joH.Ag(this.iXk);
        }
        return this.joH;
    }

    private FragmentManager getFragmentManager() {
        if (this.joG != null) {
            return this.joG.getSupportFragmentManager();
        }
        return null;
    }

    private void cIk() {
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.iXj != null && (themeColorInfo = this.iXj.getForum().getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            this.joO.setStartAndEndColor(themeElement.light_color, themeElement.dark_color);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(m mVar, boolean z, int i) {
        if (mVar != null && mVar.getForum() != null) {
            ForumData forum = mVar.getForum();
            if (z) {
                a(forum, mVar.getAnti());
            }
            if (forum.getIsShowBawuTask() && com.baidu.tbadk.core.sharedPref.b.bsO().getInt("key_bawu_task_toast", 0) == 0 && !this.joS) {
                this.joS = true;
                com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.10
                    @Override // java.lang.Runnable
                    public void run() {
                        FrsTabController.this.cIq();
                    }
                }, 30000L);
            }
            if (mVar.bazhuExam != null && !this.joT && z) {
                com.baidu.tieba.frs.m.a(this.joG.getPageContext(), mVar.bazhuExam, forum.getId(), forum.getName());
                this.joT = true;
            }
            this.iXj = mVar;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921476));
            if (y.getCount(mVar.getGameTabInfo()) > 0) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.11
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean du = FrsTabController.this.du(FrsTabController.this.iXj.getGameTabInfo());
                        if (du) {
                            FrsTabController.this.joN.notifyDataSetChanged();
                            if (du && FrsTabController.this.joH != null) {
                                FrsTabController.this.joH.Y(FrsTabController.this.iXi);
                                FrsTabController.this.joH.a(FrsTabController.this.iXj, FrsTabController.this.iXh);
                            }
                        }
                        if (FrsTabController.this.joG.isLoadingViewAttached()) {
                            FrsTabController.this.joG.hideLoadingView(FrsTabController.this.joG.findViewById(16908290));
                        }
                    }
                });
            } else if (cIp()) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.13
                    @Override // java.lang.Runnable
                    public void run() {
                        Bundle bundle;
                        FrsTabController.this.iXi.iTf = true;
                        if (FrsTabController.this.iXi != null) {
                            bundle = FrsTabController.this.iXi.getArguments();
                        } else {
                            bundle = null;
                        }
                        FrsTabController.this.ap(bundle);
                        FrsTabController.this.joN.notifyDataSetChanged();
                        if (FrsTabController.this.joG.isLoadingViewAttached()) {
                            FrsTabController.this.joG.hideLoadingView(FrsTabController.this.joG.findViewById(16908290));
                        }
                    }
                });
            }
            cIk();
            cIr();
            if (z) {
                if ((!this.joX || i == 4) && forum.isLike() == 0 && com.baidu.tbadk.a.d.bkv() && TbadkCoreApplication.isLogin()) {
                    this.joV = new com.baidu.tieba.frs.f.e();
                    this.joG.registerListener(this.jpm);
                    this.joG.registerListener(this.jpl);
                    this.joG.registerListener(this.jpn);
                    d(forum);
                }
            }
        }
    }

    private void a(ForumData forumData, AntiData antiData) {
        if (forumData != null && !com.baidu.tbadk.youngster.b.a.a(this.joG.getPageContext(), antiData, R.id.frs) && !c(forumData)) {
            List<TipInfo> tipInfos = forumData.getTipInfos();
            if (!y.isEmpty(tipInfos)) {
                com.baidu.tbadk.youngster.b.a.a(this.joG.getPageContext(), tipInfos.get(0), TbadkCoreApplication.getCurrentAccount(), forumData.getId(), this.joG.getString(R.string.frs_risk_dialog_button_text));
            }
        }
    }

    private boolean c(ForumData forumData) {
        if (au.isEmpty(forumData.getRiskTipPop()) || au.isEmpty(forumData.getRiskTipPopTitle())) {
            return false;
        }
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.joG);
        aVar.Bp(forumData.getRiskTipPopTitle());
        aVar.setTitleShowCenter(true);
        aVar.setMessageShowCenter(true);
        aVar.Bq(forumData.getRiskTipPop());
        aVar.a(R.string.frs_risk_dialog_button_text, new a.b() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.14
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar.dismiss();
            }
        });
        aVar.b(this.joG.getPageContext()).brv();
        return true;
    }

    public m cIl() {
        return this.iXj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean du(List<FrsTabInfo> list) {
        if (this.joG.isLoadingViewAttached()) {
            this.joG.hideLoadingView(this.joG.findViewById(16908290));
        }
        if (cIp()) {
            return false;
        }
        this.iXi.iTf = true;
        cIm();
        if (com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean("frs_game_login_tip", true)) {
            com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean(SharedPrefConfig.FRS_LOGIN_TIP, true);
            com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean("frs_game_login_tip", false);
        }
        dv(list);
        return true;
    }

    private void cIm() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021074, TbConfig.SERVER_ADDRESS + "game/forum/getNewNotify");
        tbHttpMessageTask.setResponsedClass(AlaGameTabGetNewNotifyResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.joG.registerListener(1021074, this.jpg);
    }

    private void dv(List<FrsTabInfo> list) {
        boolean z;
        if (!y.isEmpty(list)) {
            CustomMessageListener customMessageListener = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.15
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof al)) {
                        if (!com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean(FrsTabController.this.joJ, true)) {
                            com.baidu.adp.lib.f.e.mY().post(FrsTabController.this.jpi);
                        }
                        ((al) customResponsedMessage.getData()).b(new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.15.1
                            @Override // com.baidu.tbadk.mainTab.b
                            public boolean isAvailable() {
                                return true;
                            }

                            @Override // com.baidu.tbadk.mainTab.b
                            public com.baidu.tbadk.mainTab.c createFragmentTabStructure() {
                                FrsSportsRecommendFragment frsSportsRecommendFragment = new FrsSportsRecommendFragment();
                                Bundle bundle = new Bundle();
                                bundle.putString("name", FrsTabController.this.iXi.getForumName());
                                bundle.putString("from", FrsTabController.this.iXi.getFrom());
                                bundle.putString("forum_id", FrsTabController.this.iXi.getForumId());
                                bundle.putInt("tab_id", 503);
                                bundle.putBoolean("can_auto_play_video", FrsTabController.this.iXj.isFrsVideoAutoPlay);
                                bundle.putBoolean("need_log", FrsTabController.this.iXj.needLog == 1);
                                bundle.putBoolean("is_brand_forum", FrsTabController.this.iXj.isBrandForum);
                                FrsViewData frsViewData = new FrsViewData();
                                frsViewData.receiveData(FrsTabController.this.iXj);
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
                        FrsTabController.this.cIi();
                    }
                }
            };
            customMessageListener.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            customMessageListener.setSelfListener(true);
            this.joG.registerListener(customMessageListener);
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
            this.iXh = new al(this.joG.getActivity(), arrayList);
            if (cBq() != null) {
                this.iXh.setForumId(cBq().getForumId());
                this.iXh.setForumName(cBq().getForumName());
                if (cBq().cCJ() != null && cBq().cCJ().getForum() != null) {
                    ForumData forum = cBq().cCJ().getForum();
                    this.iXh.setForumGameLabel(forum.getForumGameLabel());
                    this.iXh.IW(forum.getSpecialForumType());
                }
            }
            this.iXi.iTf = false;
            new e(this.iXi).a(this.iXh);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB, this.iXh);
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB);
            customMessage.setTag(this.joG.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cIn() {
        if (this.iXh != null && !TextUtils.isEmpty(this.iXh.getForumId())) {
            HttpMessage httpMessage = new HttpMessage(1021074);
            httpMessage.addParam("forum_id", this.iXj.getForum().getId());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    private void a(Fragment fragment, int i) {
        NavigationBar bVK;
        if ((fragment instanceof as) && this.iXj != null && this.iXj.getForum() != null && (bVK = ((as) fragment).bVK()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.iXj.getForum().getName(), 5, true, true) + this.joG.getActivity().getString(R.string.forum));
            bVK.setCenterTextTitle(sb.toString());
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.iXi instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.iXi.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a ub(int i) {
        if (this.iXi instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.iXi.ub(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.iXi instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.iXi.a(bVar);
        }
    }

    public void onNewIntent(Intent intent) {
        if (this.iXi != null) {
            this.iXi.onNewIntent(intent);
        }
    }

    public void onResume() {
        if (!cIp()) {
            this.iXi.setPrimary(true);
        } else if (this.joH != null) {
            Fragment currentFragment = this.joH.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(true);
            }
        }
        if (this.joL) {
            this.joL = false;
            if (this.iXi != null) {
                this.iXi.refresh();
            }
        }
        if (this.iXj != null && this.iXj.getUserData() != null && this.iXj.getUserData().getNewGodData() != null) {
            if (this.iXj.getForum() != null) {
                w.bGH().setFid(this.iXj.getForum().getId());
            }
            w.bGH().b(2, this.iXj.getUserData().getNewGodData());
        }
        this.joZ = true;
        if (this.joY) {
            e((ForumData) null);
        }
    }

    public void onPause() {
        this.joZ = false;
        if (this.joV != null) {
            this.joV.cKd();
        }
        if (!cIp()) {
            this.iXi.setPrimary(false);
        } else if (this.joH != null) {
            Fragment currentFragment = this.joH.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(false);
            }
        }
        w.bGH().removeCallbacks();
    }

    public void onChangeSkinType(int i) {
        UtilHelper.changeStatusBarIconAndTextColor(true, this.joG);
        if (this.iXi != null) {
            this.iXi.onChangeSkinType(i);
        }
        if (this.joH != null) {
            this.joH.onChangeSkinType(i);
        }
        cIk();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (cIp() && this.joH != null && this.joH.cDP()) {
                this.joH.cEg();
                UtilHelper.setNavigationBarBackground(this.joG, this.joH.cEb());
            } else if (this.iXi != null && this.iXi.isAdded()) {
                if (this.iXi.onKeyDown(i, keyEvent)) {
                    return true;
                }
                cIo();
            } else {
                return this.joG.b(i, keyEvent);
            }
        } else if (i == 24) {
            if (this.iXi != null && this.iXi.isAdded()) {
                return this.iXi.onKeyDown(i, keyEvent);
            }
        } else {
            return this.joG.b(i, keyEvent);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cIo() {
        if (this.iXl != this.iXk && cIp()) {
            this.joH.setCurrentTab(this.iXk);
            if (Ae(this.iXk) != 1) {
                this.iXi.pW(false);
            }
            this.iXl = this.iXk;
            a(this.joH.getCurrentFragment(), this.iXk);
            return;
        }
        this.iXi.closeActivity();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!cIp()) {
            this.iXi.onActivityResult(i, i2, intent);
        } else if (this.joH != null) {
            if (1 == this.joH.getCurrentTabType()) {
                this.iXi.onActivityResult(i, i2, intent);
            } else {
                this.joH.getCurrentFragment().onActivityResult(i, i2, intent);
            }
        }
        if (i2 == -1) {
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1) {
                    com.baidu.tieba.p.a.dEK().F(this.joG.getPageContext());
                    ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.linkUrl != null && this.joK != null) {
                        this.joK.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.16
                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void bzM() {
                            }

                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void a(final CustomDialogData customDialogData) {
                                com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.16.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (FrsTabController.this.joG != null) {
                                            com.baidu.tieba.pb.interactionpopupwindow.c.a(FrsTabController.this.joG.getPageContext(), customDialogData).show();
                                        }
                                    }
                                }, 1000L);
                            }
                        });
                    }
                }
            } else if (i == 13011) {
                com.baidu.tieba.p.a.dEK().F(this.joG.getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (!cIp()) {
            return this.iXi.getVoiceManager();
        }
        if (this.joH == null) {
            return null;
        }
        Fragment currentFragment = this.joH.getCurrentFragment();
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
    public int Ac(int i) {
        if (this.iXh == null) {
            return -1;
        }
        int count = y.getCount(this.iXh.bBY());
        for (int i2 = 0; i2 < count; i2++) {
            if (this.iXh.bBY().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Ae(int i) {
        if (this.iXh != null && i < y.getCount(this.iXh.bBY())) {
            return this.iXh.bBY().get(i).tab_id.intValue();
        }
        return -1;
    }

    public FrsFragment cBq() {
        return this.iXi;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> cBr() {
        if (!cIp()) {
            if (this.iXi instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) this.iXi).cBr();
            }
        } else if (this.joH == null) {
            return null;
        } else {
            Fragment currentFragment = this.joH.getCurrentFragment();
            if (currentFragment instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) currentFragment).cBr();
            }
        }
        return null;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(t.iWt);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.joG.isLoadingViewAttached()) {
            this.joG.hideLoadingView(this.joG.findViewById(16908290));
        }
        if (this.jpi != null) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jpi);
        }
        com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean(this.joJ, false);
        if (this.joK != null) {
            this.joK.cancelLoadData();
        }
        if (this.iXi != null && this.iXi.cBZ() != null) {
            this.iXi.cBZ().cIC();
        }
        if (this.joR != null) {
            this.joR.onDestroy();
        }
        if (FrsActivityConfig.FRS_FROM_FLUTTER_BCASTEDIT.equals(this.mFrom)) {
            new o(TbadkCoreApplication.getInst()).bte();
        }
        if (FrsActivityConfig.FRS_FROM_FORUM_RULE_EDIT.equals(this.mFrom)) {
            com.baidu.tbadk.k.d.bDH().kI(false);
        }
        if (this.joW != null) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.joW);
        }
        if (this.iXj != null && this.iXj.getForum() != null && this.joV != null) {
            this.joV.gs(com.baidu.adp.lib.f.b.toLong(this.iXj.getForum().getId(), 0L));
        }
    }

    public FragmentTabHost cEe() {
        if (this.joH == null) {
            return null;
        }
        return this.joH.cEe();
    }

    public boolean cIp() {
        if (this.joN == null) {
            return false;
        }
        return this.joN.getItem(0) instanceof FrsTabHostFragment;
    }

    public void Ag(int i) {
        this.iXk = i;
    }

    public void Bb(int i) {
        this.iXl = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cIq() {
        if (this.joG != null) {
            if (this.joR == null) {
                this.joR = (NavigationBarCoverTip) this.joG.findViewById(R.id.navigation_cover_tip);
            }
            if (this.joR != null) {
                View inflate = View.inflate(this.joG, R.layout.write_thread_share_guide, null);
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
                cVar.bwd();
                tBSpecificationBtn.setConfig(cVar);
                tBSpecificationBtn.bvt();
                ap.setViewTextColor(textView, R.color.CAM_X0101);
                ap.setBackgroundColor(this.joR, R.color.cp_link_tip_a_alpha95);
                tBSpecificationBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.17
                    /* JADX DEBUG: Multi-variable search result rejected for r4v9, resolved type: com.baidu.tieba.frs.FrsActivity */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        new ar("c13439").btT();
                        if (FrsTabController.this.cBq() != null && !TextUtils.isEmpty(FrsTabController.this.cBq().getForumId()) && !TextUtils.isEmpty(FrsTabController.this.mForumName) && FrsTabController.this.joG != null) {
                            if (FrsTabController.this.joR != null) {
                                FrsTabController.this.joR.hideTip();
                            }
                            bf.bua().b(FrsTabController.this.joG.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/bawutask?fid=" + FrsTabController.this.cBq().getForumId() + "&fn=" + FrsTabController.this.mForumName + "&noread=" + (com.baidu.tbadk.core.sharedPref.b.bsO().getInt("key_bawu_task_toast", 0) == -1 ? 1 : 0)});
                        }
                    }
                });
                this.joR.a(this.joG, inflate, 30000);
                new ar("c13438").btT();
                int i = com.baidu.tbadk.core.sharedPref.b.bsO().getInt("key_bawu_task_toast", 0);
                if (i >= 0) {
                    com.baidu.tbadk.core.sharedPref.b.bsO().putInt("key_bawu_task_toast", i + 1);
                }
            }
        }
    }

    private void cIr() {
        boolean z;
        if (this.iXj != null && this.iXj.getEntelechyTabInfo() != null && this.iXj.getEntelechyTabInfo().tab != null) {
            Iterator<FrsTabInfo> it = this.iXj.getEntelechyTabInfo().tab.iterator();
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
                if (this.joU == null) {
                    this.joU = new com.baidu.tieba.d.e(this.joG.getPageContext(), this.joO);
                    this.joU.fO(R.drawable.pic_sign_tip_down);
                    this.joU.setAnchor(2);
                    this.joU.setUseDirectOffset(true);
                    this.joU.yt(-l.getDimens(this.joG, R.dimen.tbds20));
                    this.joU.setYOffset(-l.getDimens(this.joG, R.dimen.tbds20));
                    this.joU.setTextColor(R.color.CAM_X0101);
                    this.joU.setHeight(R.dimen.tbds54);
                    this.joU.yr(l.getDimens(this.joG, R.dimen.tbds44));
                }
                this.joU.aP(this.joG.getString(R.string.frs_evaluate_tip), "first_into_frs_with_evaluate_tab");
            }
        }
    }

    private void d(final ForumData forumData) {
        boolean z = false;
        if (g(forumData.getName(), forumData.getId(), forumData.getImage_url(), false)) {
            if (this.joW != null) {
                com.baidu.adp.lib.f.e.mY().removeCallbacks(this.joW);
            }
            z = true;
        }
        if (!this.joX) {
            this.joV.cKc().i(TbadkCoreApplication.getCurrentAccount(), forumData.getId(), System.currentTimeMillis());
            this.joX = true;
        }
        if (!z) {
            this.joW = this.joW != null ? this.joW : new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.18
                @Override // java.lang.Runnable
                public void run() {
                    if (FrsTabController.this.joV != null) {
                        if (FrsTabController.this.joZ) {
                            FrsTabController.this.g(forumData.getName(), forumData.getId(), forumData.getImage_url(), true);
                        } else {
                            FrsTabController.this.joY = true;
                        }
                    }
                }
            };
            com.baidu.adp.lib.f.e.mY().postDelayed(this.joW, 60000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ForumData forumData) {
        if (this.iXi.cCb() != null && this.joV != null) {
            if (forumData == null) {
                forumData = this.iXj.getForum();
            }
            if (forumData != null && forumData.isLike() != 1) {
                if (!this.joZ) {
                    this.joY = true;
                } else if (g(forumData.getName(), forumData.getId(), forumData.getImage_url(), false) && this.joW != null) {
                    com.baidu.adp.lib.f.e.mY().removeCallbacks(this.joW);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(String str, String str2, String str3, boolean z) {
        if (!this.joV.ff(TbadkCoreApplication.getCurrentAccount(), str2) || this.iXi == null || this.iXi.cCb() == null) {
            return false;
        }
        this.joY = false;
        this.joV.a(this.joG, str, str2, str3, this.iXi.cCb().cKV());
        this.joV.cKc().a(TbadkCoreApplication.getCurrentAccount(), str2, System.currentTimeMillis(), z);
        return true;
    }

    public boolean gq(long j) {
        ForumData forum;
        return (this.iXj == null || j == 0 || (forum = this.iXj.getForum()) == null || com.baidu.adp.lib.f.b.toLong(forum.getId(), 0L) != j) ? false : true;
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
        /* renamed from: Bc */
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

        public BaseFragment Lo(String str) {
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

        public BaseFragment Bd(int i) {
            return (BaseFragment) y.remove(this.mFragments, i);
        }

        public String Be(int i) {
            if (getItem(i) != null) {
                return getItem(i).getBaseTag();
            }
            return null;
        }
    }

    public TbPageTag getTbPageTag() {
        if (!cIp()) {
            return this.iXi.getTbPageTag();
        }
        if (this.joH != null) {
            if (1 == this.joH.getCurrentTabType()) {
                return this.iXi.getTbPageTag();
            }
            Fragment currentFragment = this.joH.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                return ((BaseFragment) currentFragment).getTbPageTag();
            }
        }
        return null;
    }

    public void onScreenShot(String str) {
        if (this.iXj != null && this.iXj.getForum() != null) {
            TiebaStatic.log(new ar("c13848").dY("uid", TbadkCoreApplication.getCurrentAccount()).dY("fid", this.iXj.getForum().getId()).al("obj_type", 2));
        }
    }
}
