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
    public static final String jaq = FrsFragment.class.getSimpleName();
    public static final String jar = FrsTabHostFragment.class.getSimpleName();
    private LinearLayout iHs;
    private am iLD;
    private FrsFragment iLE;
    private m iLF;
    private int iLH;
    private FRSRefreshButton iLJ;
    private OvalActionButton jaA;
    private boolean jaB;
    private boolean jaC;
    private NavigationBarCoverTip jaD;
    private com.baidu.tieba.c.e jaG;
    private com.baidu.tieba.frs.f.d jaH;
    private Runnable jaI;
    private boolean jaJ;
    private FrsActivity jas;
    private FrsTabHostFragment jat;
    private ShareSuccessReplyToServerModel jaw;
    private FrsBaseViewPager jay;
    private FragmentAdapter jaz;
    private String mForumName;
    private String mFrom;
    private boolean jau = false;
    private final Handler mHandler = new Handler();
    private int iLG = 0;
    private boolean jax = false;
    private boolean jaE = false;
    private boolean jaF = false;
    private boolean jaK = false;
    private boolean jaL = false;
    private HttpMessageListener jaM = new HttpMessageListener(CmdConfigHttp.CMD_FRS_RECOMMEND) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof FrsRecommendResMsg) {
                if (httpResponsedMessage.getError() != 0) {
                    new BdTopToast(FrsTabController.this.jas).yk(false).Ut(httpResponsedMessage.getErrorString()).aJ((ViewGroup) FrsTabController.this.jas.findViewById(R.id.frs));
                    return;
                }
                int pushStatus = ((FrsRecommendResMsg) httpResponsedMessage).getPushStatus();
                String pushMsg = ((FrsRecommendResMsg) httpResponsedMessage).getPushMsg();
                if (pushStatus == 1) {
                    new ScreenTopToast(FrsTabController.this.jas).Ux(FrsTabController.this.jas.getString(R.string.frs_recommend_suc_tip_title)).Uy(FrsTabController.this.jas.getString(R.string.frs_recommend_suc_tip_content)).Uz(FrsTabController.this.jas.getString(R.string.dialog_confirm_see)).al(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.1.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("_forumId", FrsTabController.this.iLF.getForum().getId());
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new com.baidu.tieba.tbadkCore.data.m(FrsTabController.this.jas, "RecommendHistoryPage", hashMap)));
                        }
                    }).aJ((ViewGroup) FrsTabController.this.jas.findViewById(R.id.frs));
                } else {
                    new BdTopToast(FrsTabController.this.jas).yk(false).Ut(pushMsg).aJ((ViewGroup) FrsTabController.this.jas.findViewById(R.id.frs));
                }
            }
        }
    };
    private CustomMessageListener jaN = new CustomMessageListener(2921465) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            new ScreenTopToast(FrsTabController.this.jas).Ux(FrsTabController.this.jas.getString(R.string.frs_recommend_fail_month_tip)).Uz(FrsTabController.this.jas.getString(R.string.frs_recommend_fail_tip_btn)).al(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.12.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("_forumId", FrsTabController.this.iLF.getForum().getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new com.baidu.tieba.tbadkCore.data.m(FrsTabController.this.jas, "ForumGradePage", hashMap)));
                }
            }).aJ((ViewGroup) FrsTabController.this.jas.findViewById(R.id.frs));
        }
    };
    private com.baidu.adp.framework.listener.a jaO = new com.baidu.adp.framework.listener.a(1001703, CmdConfigSocket.CMD_FRS_PAGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.18
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            m mVar = null;
            int i = -1;
            if (!FrsTabController.this.jau && !responsedMessage.hasError() && responsedMessage.getError() == 0) {
                if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                    mVar = ((FrsPageHttpResponseMessage) responsedMessage).getResponseData();
                    i = ((FrsPageHttpResponseMessage) responsedMessage).getUpdateType();
                } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                    mVar = ((FRSPageSocketResponsedMessage) responsedMessage).getResponseData();
                    i = ((FRSPageSocketResponsedMessage) responsedMessage).getUpdateType();
                }
                if (mVar != null) {
                    FrsTabController.this.jau = true;
                    FrsTabController.this.a(mVar, true, i);
                    if (mVar != null && mVar.getForum() != null && !StringUtils.isNull(mVar.getForum().getId())) {
                        com.baidu.tbadk.core.business.a.bjT().dF("2", mVar.getForum().getId());
                    }
                }
                if (mVar != null && mVar.getUserData() != null && mVar.getUserData().getNewGodData() != null) {
                    if (mVar.getForum() != null) {
                        w.bDN().setFid(mVar.getForum().getId());
                    }
                    w.bDN().b(2, mVar.getUserData().getNewGodData());
                }
            }
        }
    };
    private CustomMessageListener jaP = new CustomMessageListener(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!FrsTabController.this.jau && FrsTabController.this.iLF == null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof m)) {
                m mVar = (m) customResponsedMessage.getData();
                if (mVar.getForum() != null && FrsTabController.this.mForumName != null && FrsTabController.this.mForumName.equals(mVar.getForum().getName())) {
                    FrsTabController.this.a(mVar, false, -1);
                }
            }
        }
    };
    private CustomMessageListener jaQ = new CustomMessageListener(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsTabController.this.cDx();
        }
    };
    private CustomMessageListener jaR = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int yZ;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (10001 == intValue) {
                    yZ = FrsTabController.this.yZ(9);
                    if (yZ == -1) {
                        yZ = FrsTabController.this.yZ(2);
                    }
                } else {
                    yZ = FrsTabController.this.yZ(intValue);
                }
                if (yZ != -1 && FrsTabController.this.cDy() && FrsTabController.this.jat != null) {
                    FrsTabController.this.jat.setCurrentTab(yZ);
                    if (FrsTabController.this.zb(yZ) != 1) {
                        FrsTabController.this.iLE.pw(false);
                    }
                }
            }
        }
    };
    private HttpMessageListener jaS = new HttpMessageListener(0) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && 1021074 == httpResponsedMessage.getCmd() && (httpResponsedMessage instanceof AlaGameTabGetNewNotifyResponsedMessage)) {
                List<a> newNotifyData = ((AlaGameTabGetNewNotifyResponsedMessage) httpResponsedMessage).getNewNotifyData();
                if (!y.isEmpty(newNotifyData) && FrsTabController.this.jat != null) {
                    for (a aVar : newNotifyData) {
                        if (aVar != null) {
                            for (int i = 0; i < FrsTabController.this.iLD.bzi().size(); i++) {
                                FragmentTabHost.b oP = FrsTabController.this.jat.oP(i);
                                if (oP != null && oP.mType != 1 && oP.mType != FrsTabController.this.jat.getCurrentTabType() && oP.mType == aVar.getTabId() && aVar.cDo() && oP.eLs.Ee(String.valueOf(oP.mType)) != null) {
                                    oP.eLs.Ee(String.valueOf(oP.mType)).view.setVisibility(0);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private Runnable jaT = new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.23
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this);
            FrsTabController.this.cDw();
            com.baidu.adp.lib.f.e.mY().postDelayed(this, 30000L);
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                FrsTabController.this.jax = true;
            }
        }
    };
    private CustomMessageListener jaU = new CustomMessageListener(2921369) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.jay != null && FrsTabController.this.jaz != null && (customResponsedMessage.getData() instanceof FrsTabViewPager.a)) {
                FrsTabViewPager.a aVar = (FrsTabViewPager.a) customResponsedMessage.getData();
                FrsTabController.this.jaB = aVar.cAs();
                FrsTabController.this.jaC = aVar.cAt();
            }
        }
    };
    private CustomMessageListener jaV = new CustomMessageListener(2921370) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.jay != null && FrsTabController.this.jaz != null && (customResponsedMessage.getData() instanceof Boolean)) {
                FrsTabController.this.jay.setForceIntercept(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };
    private CustomMessageListener jaW = new CustomMessageListener(CmdConfigCustom.CMD_NEW_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                FrsTabController.this.e((ForumData) null);
            }
        }
    };
    private CustomMessageListener jaX = new CustomMessageListener(2921498) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsTabController.this.jaH != null && customResponsedMessage != null && customResponsedMessage.getData() != null) {
                if (customResponsedMessage.getData() instanceof ForumData) {
                    FrsTabController.this.e((ForumData) customResponsedMessage.getData());
                } else if (customResponsedMessage.getData() instanceof Long) {
                    long longValue = ((Long) customResponsedMessage.getData()).longValue();
                    if (FrsTabController.this.fI(longValue) && FrsTabController.this.jaH.fJ(longValue) >= 3) {
                        FrsTabController.this.jaH.fK(longValue);
                        FrsTabController.this.jaK = true;
                    }
                }
            }
        }
    };
    private CustomMessageListener jaY = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                if (FrsTabController.this.jaH != null && aVar != null && TbadkCoreApplication.isLogin()) {
                    FrsTabController.this.jaH.eY(TbadkCoreApplication.getCurrentAccount(), String.valueOf(aVar.forumId));
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener jaZ = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.7
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i != 1) {
                FrsTabController.this.jaA.setVisibility(0);
                if (FrsTabController.this.cxy() != null) {
                    FrsTabController.this.cxy().pq(false);
                }
                FrsTabController.this.iLE.cyO();
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            switch (i) {
                case 0:
                    FrsTabController.this.jaC = false;
                    FrsTabController.this.jay.setForceIntercept(false);
                    return;
                default:
                    return;
            }
        }
    };
    private FrsBaseViewPager.a jba = new FrsBaseViewPager.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.8
        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public void cxT() {
            if (FrsTabController.this.jay != null) {
                if (FrsTabController.this.jay.getCurrentItem() == 0) {
                    FrsTabController.this.jay.setmDisallowSlip(true);
                } else {
                    FrsTabController.this.jay.setmDisallowSlip(false);
                }
            }
        }

        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public boolean cxU() {
            if (FrsTabController.this.jay.getCurrentItem() == 0) {
                if (FrsTabController.this.jaB && FrsTabController.this.jaC) {
                    FrsTabController.this.jay.setmDisallowSlip(false);
                }
                if (!FrsTabController.this.jaC) {
                    FrsTabController.this.jay.setmDisallowSlip(true);
                }
                FrsTabController.this.jay.setmDisallowSlip(true);
            } else {
                FrsTabController.this.jay.setmDisallowSlip(true);
            }
            return true;
        }
    };
    private String jav = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.SHOW_GAME_FOREM_TAB_HOT_POINT);

    public FrsTabController(FrsActivity frsActivity) {
        this.jas = frsActivity;
    }

    public void init(Bundle bundle) {
        if (this.jas != null) {
            this.jas.setContentView(R.layout.frs_base_layout);
            this.jay = (FrsBaseViewPager) this.jas.findViewById(R.id.frs_base_viewpager);
            this.jaz = new FragmentAdapter(this.jas.getSupportFragmentManager());
            this.jay.setAdapter(this.jaz);
            this.jay.setPageTransformer(true, new CubeOutViewPagerTransformer());
            this.jay.addOnPageChangeListener(this.jaZ);
            this.jay.setmDisallowSlip(true);
            this.jay.setOnTouchEventListener(this.jba);
            this.jaA = (OvalActionButton) this.jas.findViewById(R.id.frs_post_forum_button);
            this.jaA.setIsCircle(true);
            this.jaA.setHasShadow(false);
            this.iLJ = (FRSRefreshButton) this.jas.findViewById(R.id.frs_refresh_forum_button);
            this.iHs = (LinearLayout) this.jas.findViewById(R.id.frs_ll_redpack);
            this.jas.registerListener(this.jaU);
            this.jas.registerListener(this.jaV);
            this.jaO.getHttpMessageListener().setPriority(-1);
            this.jaO.getSocketMessageListener().setPriority(-1);
            this.jas.registerListener(this.jaP);
            this.jaR.setSelfListener(true);
            this.jas.registerListener(this.jaR);
            this.jaQ.setSelfListener(true);
            this.jas.registerListener(this.jaQ);
            this.jas.registerListener(this.mAccountChangedListener);
            if (bundle == null) {
                this.mForumName = this.jas.getIntent().getStringExtra("name");
                this.mFrom = this.jas.getIntent().getStringExtra("from");
                this.iLG = this.jas.getIntent().getIntExtra(FrsActivityConfig.FRS_GAME_DEFAULT_TAB_ID, 0);
            } else {
                this.mForumName = bundle.getString("name");
                this.mFrom = bundle.getString("from");
                this.iLG = bundle.getInt("default_tab_id", 0);
            }
            an(bundle);
            this.jaz.notifyDataSetChanged();
            this.jaw = new ShareSuccessReplyToServerModel();
            this.jas.registerListener(this.jaO);
            this.jas.registerListener(this.jaM);
            this.jas.registerListener(this.jaN);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.mForumName);
        bundle.putInt("default_tab_id", this.iLG);
        bundle.putString("from", this.mFrom);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void an(Bundle bundle) {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.jaz != null) {
            try {
                FrsFragment frsFragment = (FrsFragment) this.jaz.KG(jaq);
                if (frsFragment == null) {
                    frsFragment = ao(bundle);
                }
                frsFragment.b(this.jaA);
                frsFragment.a(this.iLJ);
                frsFragment.c(this.iHs);
                if (!jaq.equals(this.jaz.zS(0))) {
                    if (jar.equals(this.jaz.zS(0))) {
                        this.jaz.zR(0);
                    }
                    this.jaz.a(0, frsFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDr() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.jaz != null) {
            try {
                FrsTabHostFragment frsTabHostFragment = (FrsTabHostFragment) this.jaz.KG(jar);
                if (frsTabHostFragment == null) {
                    frsTabHostFragment = cDs();
                }
                frsTabHostFragment.b(this.jaA);
                frsTabHostFragment.b(this.iLJ);
                if (!jar.equals(this.jaz.zS(0))) {
                    if (jaq.equals(this.jaz.zS(0))) {
                        this.jaz.zR(0);
                    }
                    this.jaz.a(0, frsTabHostFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private FrsFragment ao(Bundle bundle) {
        if (this.iLE == null) {
            this.iLE = new FrsFragment();
            this.iLE.setArguments(bundle);
            this.iLE.setBaseTag(jaq);
        }
        this.iLE.iHz = false;
        return this.iLE;
    }

    private FrsTabHostFragment cDs() {
        if (this.jat == null) {
            this.jat = new FrsTabHostFragment(this);
            this.jat.setBaseTag(jar);
            this.jat.zd(this.iLG);
        }
        return this.jat;
    }

    private FragmentManager getFragmentManager() {
        if (this.jas != null) {
            return this.jas.getSupportFragmentManager();
        }
        return null;
    }

    private void cDt() {
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.iLF != null && (themeColorInfo = this.iLF.getForum().getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            this.jaA.setStartAndEndColor(themeElement.light_color, themeElement.dark_color);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(m mVar, boolean z, int i) {
        if (mVar != null && mVar.getForum() != null) {
            ForumData forum = mVar.getForum();
            if (z) {
                a(forum, mVar.getAnti());
            }
            if (forum.getIsShowBawuTask() && com.baidu.tbadk.core.sharedPref.b.bqh().getInt("key_bawu_task_toast", 0) == 0 && !this.jaE) {
                this.jaE = true;
                com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.9
                    @Override // java.lang.Runnable
                    public void run() {
                        FrsTabController.this.cDz();
                    }
                }, 30000L);
            }
            if (mVar.bazhuExam != null && !this.jaF && z) {
                com.baidu.tieba.frs.m.a(this.jas.getPageContext(), mVar.bazhuExam, forum.getId(), forum.getName());
                this.jaF = true;
            }
            this.iLF = mVar;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921476));
            if (y.getCount(mVar.getGameTabInfo()) > 0) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.10
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean dl = FrsTabController.this.dl(FrsTabController.this.iLF.getGameTabInfo());
                        if (dl) {
                            FrsTabController.this.jaz.notifyDataSetChanged();
                            if (dl && FrsTabController.this.jat != null) {
                                FrsTabController.this.jat.Z(FrsTabController.this.iLE);
                                FrsTabController.this.jat.a(FrsTabController.this.iLF, FrsTabController.this.iLD);
                            }
                        }
                        if (FrsTabController.this.jas.isLoadingViewAttached()) {
                            FrsTabController.this.jas.hideLoadingView(FrsTabController.this.jas.findViewById(16908290));
                        }
                    }
                });
            } else if (cDy()) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.11
                    @Override // java.lang.Runnable
                    public void run() {
                        Bundle bundle;
                        FrsTabController.this.iLE.iHz = true;
                        if (FrsTabController.this.iLE != null) {
                            bundle = FrsTabController.this.iLE.getArguments();
                        } else {
                            bundle = null;
                        }
                        FrsTabController.this.an(bundle);
                        FrsTabController.this.jaz.notifyDataSetChanged();
                        if (FrsTabController.this.jas.isLoadingViewAttached()) {
                            FrsTabController.this.jas.hideLoadingView(FrsTabController.this.jas.findViewById(16908290));
                        }
                    }
                });
            }
            cDt();
            cDA();
            if (z) {
                if ((!this.jaJ || i == 4) && forum.isLike() == 0 && com.baidu.tbadk.a.d.bhZ() && TbadkCoreApplication.isLogin()) {
                    this.jaH = new com.baidu.tieba.frs.f.d();
                    this.jas.registerListener(this.jaX);
                    this.jas.registerListener(this.jaW);
                    this.jas.registerListener(this.jaY);
                    d(forum);
                }
            }
        }
    }

    private void a(ForumData forumData, AntiData antiData) {
        if (forumData != null && !com.baidu.tbadk.youngster.b.a.a(this.jas.getPageContext(), antiData, R.id.frs) && !c(forumData)) {
            List<TipInfo> tipInfos = forumData.getTipInfos();
            if (!y.isEmpty(tipInfos)) {
                com.baidu.tbadk.youngster.b.a.a(this.jas.getPageContext(), tipInfos.get(0), TbadkCoreApplication.getCurrentAccount(), forumData.getId(), this.jas.getString(R.string.frs_risk_dialog_button_text));
            }
        }
    }

    private boolean c(ForumData forumData) {
        if (at.isEmpty(forumData.getRiskTipPop()) || at.isEmpty(forumData.getRiskTipPopTitle())) {
            return false;
        }
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jas);
        aVar.Bn(forumData.getRiskTipPopTitle());
        aVar.setTitleShowCenter(true);
        aVar.setMessageShowCenter(true);
        aVar.Bo(forumData.getRiskTipPop());
        aVar.a(R.string.frs_risk_dialog_button_text, new a.b() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.13
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar.dismiss();
            }
        });
        aVar.b(this.jas.getPageContext()).bpc();
        return true;
    }

    public m cDu() {
        return this.iLF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dl(List<FrsTabInfo> list) {
        if (this.jas.isLoadingViewAttached()) {
            this.jas.hideLoadingView(this.jas.findViewById(16908290));
        }
        if (cDy()) {
            return false;
        }
        this.iLE.iHz = true;
        cDv();
        if (com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean("frs_game_login_tip", true)) {
            com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean(SharedPrefConfig.FRS_LOGIN_TIP, true);
            com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean("frs_game_login_tip", false);
        }
        dm(list);
        return true;
    }

    private void cDv() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021074, TbConfig.SERVER_ADDRESS + "game/forum/getNewNotify");
        tbHttpMessageTask.setResponsedClass(AlaGameTabGetNewNotifyResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.jas.registerListener(1021074, this.jaS);
    }

    private void dm(List<FrsTabInfo> list) {
        boolean z;
        if (!y.isEmpty(list)) {
            CustomMessageListener customMessageListener = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.14
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof am)) {
                        if (!com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean(FrsTabController.this.jav, true)) {
                            com.baidu.adp.lib.f.e.mY().post(FrsTabController.this.jaT);
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
                                bundle.putString("name", FrsTabController.this.iLE.getForumName());
                                bundle.putString("from", FrsTabController.this.iLE.getFrom());
                                bundle.putString("forum_id", FrsTabController.this.iLE.getForumId());
                                bundle.putInt("tab_id", 503);
                                bundle.putBoolean("can_auto_play_video", FrsTabController.this.iLF.isFrsVideoAutoPlay);
                                bundle.putBoolean("need_log", FrsTabController.this.iLF.needLog == 1);
                                bundle.putBoolean("is_brand_forum", FrsTabController.this.iLF.isBrandForum);
                                FrsViewData frsViewData = new FrsViewData();
                                frsViewData.receiveData(FrsTabController.this.iLF);
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
                        FrsTabController.this.cDr();
                    }
                }
            };
            customMessageListener.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            customMessageListener.setSelfListener(true);
            this.jas.registerListener(customMessageListener);
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
            this.iLD = new am(this.jas.getActivity(), arrayList);
            if (cxy() != null) {
                this.iLD.setForumId(cxy().getForumId());
                this.iLD.setForumName(cxy().getForumName());
                if (cxy().cyP() != null && cxy().cyP().getForum() != null) {
                    ForumData forum = cxy().cyP().getForum();
                    this.iLD.setForumGameLabel(forum.getForumGameLabel());
                    this.iLD.IG(forum.getSpecialForumType());
                }
            }
            this.iLE.iHz = false;
            new e(this.iLE).a(this.iLD);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB, this.iLD);
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB);
            customMessage.setTag(this.jas.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDw() {
        if (this.iLD != null && !TextUtils.isEmpty(this.iLD.getForumId())) {
            HttpMessage httpMessage = new HttpMessage(1021074);
            httpMessage.addParam("forum_id", this.iLF.getForum().getId());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    private void a(Fragment fragment, int i) {
        NavigationBar bSH;
        if ((fragment instanceof com.baidu.tieba.frs.at) && this.iLF != null && this.iLF.getForum() != null && (bSH = ((com.baidu.tieba.frs.at) fragment).bSH()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.iLF.getForum().getName(), 5, true, true) + this.jas.getActivity().getString(R.string.forum));
            bSH.setCenterTextTitle(sb.toString());
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.iLE instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.iLE.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a ta(int i) {
        if (this.iLE instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.iLE.ta(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.iLE instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.iLE.a(bVar);
        }
    }

    public void onNewIntent(Intent intent) {
        if (this.iLE != null) {
            this.iLE.onNewIntent(intent);
        }
    }

    public void onResume() {
        if (!cDy()) {
            this.iLE.setPrimary(true);
        } else if (this.jat != null) {
            Fragment currentFragment = this.jat.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(true);
            }
        }
        if (this.jax) {
            this.jax = false;
            if (this.iLE != null) {
                this.iLE.refresh();
            }
        }
        if (this.iLF != null && this.iLF.getUserData() != null && this.iLF.getUserData().getNewGodData() != null) {
            if (this.iLF.getForum() != null) {
                w.bDN().setFid(this.iLF.getForum().getId());
            }
            w.bDN().b(2, this.iLF.getUserData().getNewGodData());
        }
        this.jaL = true;
        if (this.jaK) {
            e((ForumData) null);
        }
    }

    public void onPause() {
        this.jaL = false;
        if (this.jaH != null) {
            this.jaH.cFj();
        }
        if (!cDy()) {
            this.iLE.setPrimary(false);
        } else if (this.jat != null) {
            Fragment currentFragment = this.jat.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(false);
            }
        }
        w.bDN().removeCallbacks();
    }

    public void onChangeSkinType(int i) {
        UtilHelper.changeStatusBarIconAndTextColor(true, this.jas);
        if (this.iLE != null) {
            this.iLE.onChangeSkinType(i);
        }
        if (this.jat != null) {
            this.jat.onChangeSkinType(i);
        }
        cDt();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (cDy() && this.jat != null && this.jat.czW()) {
                this.jat.cAn();
                UtilHelper.setNavigationBarBackground(this.jas, this.jat.cAi());
            } else if (this.iLE != null && this.iLE.isAdded()) {
                if (this.iLE.onKeyDown(i, keyEvent)) {
                    return true;
                }
                cDx();
            } else {
                return this.jas.b(i, keyEvent);
            }
        } else if (i == 24) {
            if (this.iLE != null && this.iLE.isAdded()) {
                return this.iLE.onKeyDown(i, keyEvent);
            }
        } else {
            return this.jas.b(i, keyEvent);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDx() {
        if (this.iLH != this.iLG && cDy()) {
            this.jat.setCurrentTab(this.iLG);
            if (zb(this.iLG) != 1) {
                this.iLE.pw(false);
            }
            this.iLH = this.iLG;
            a(this.jat.getCurrentFragment(), this.iLG);
            return;
        }
        this.iLE.closeActivity();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!cDy()) {
            this.iLE.onActivityResult(i, i2, intent);
        } else if (this.jat != null) {
            if (1 == this.jat.getCurrentTabType()) {
                this.iLE.onActivityResult(i, i2, intent);
            } else {
                this.jat.getCurrentFragment().onActivityResult(i, i2, intent);
            }
        }
        if (i2 == -1) {
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1) {
                    com.baidu.tieba.o.a.dzT().F(this.jas.getPageContext());
                    ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.linkUrl != null && this.jaw != null) {
                        this.jaw.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.15
                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void bwW() {
                            }

                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void a(final CustomDialogData customDialogData) {
                                com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.15.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (FrsTabController.this.jas != null) {
                                            com.baidu.tieba.pb.interactionpopupwindow.c.a(FrsTabController.this.jas.getPageContext(), customDialogData).show();
                                        }
                                    }
                                }, 1000L);
                            }
                        });
                    }
                }
            } else if (i == 13011) {
                com.baidu.tieba.o.a.dzT().F(this.jas.getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (!cDy()) {
            return this.iLE.getVoiceManager();
        }
        if (this.jat == null) {
            return null;
        }
        Fragment currentFragment = this.jat.getCurrentFragment();
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
    public int yZ(int i) {
        if (this.iLD == null) {
            return -1;
        }
        int count = y.getCount(this.iLD.bzi());
        for (int i2 = 0; i2 < count; i2++) {
            if (this.iLD.bzi().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int zb(int i) {
        if (this.iLD != null && i < y.getCount(this.iLD.bzi())) {
            return this.iLD.bzi().get(i).tab_id.intValue();
        }
        return -1;
    }

    public FrsFragment cxy() {
        return this.iLE;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> cxz() {
        if (!cDy()) {
            if (this.iLE instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) this.iLE).cxz();
            }
        } else if (this.jat == null) {
            return null;
        } else {
            Fragment currentFragment = this.jat.getCurrentFragment();
            if (currentFragment instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) currentFragment).cxz();
            }
        }
        return null;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(t.iKN);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.jas.isLoadingViewAttached()) {
            this.jas.hideLoadingView(this.jas.findViewById(16908290));
        }
        if (this.jaT != null) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jaT);
        }
        com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean(this.jav, false);
        if (this.jaw != null) {
            this.jaw.cancelLoadData();
        }
        if (this.iLE != null && this.iLE.cyg() != null) {
            this.iLE.cyg().cDL();
        }
        if (this.jaD != null) {
            this.jaD.onDestroy();
        }
        if (FrsActivityConfig.FRS_FROM_FLUTTER_BCASTEDIT.equals(this.mFrom)) {
            new o(TbadkCoreApplication.getInst()).bqw();
        }
        if (this.jaI != null) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jaI);
        }
        if (this.iLF != null && this.iLF.getForum() != null && this.jaH != null) {
            this.jaH.fK(com.baidu.adp.lib.f.b.toLong(this.iLF.getForum().getId(), 0L));
        }
    }

    public FragmentTabHost cAl() {
        if (this.jat == null) {
            return null;
        }
        return this.jat.cAl();
    }

    public boolean cDy() {
        if (this.jaz == null) {
            return false;
        }
        return this.jaz.getItem(0) instanceof FrsTabHostFragment;
    }

    public void zd(int i) {
        this.iLG = i;
    }

    public void zP(int i) {
        this.iLH = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDz() {
        if (this.jas != null) {
            if (this.jaD == null) {
                this.jaD = (NavigationBarCoverTip) this.jas.findViewById(R.id.navigation_cover_tip);
            }
            if (this.jaD != null) {
                View inflate = View.inflate(this.jas, R.layout.write_thread_share_guide, null);
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
                cVar.btn();
                tBSpecificationBtn.setConfig(cVar);
                tBSpecificationBtn.bsD();
                ap.setViewTextColor(textView, R.color.cp_cont_a);
                ap.setBackgroundColor(this.jaD, R.color.cp_link_tip_a_alpha95);
                tBSpecificationBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.16
                    /* JADX DEBUG: Multi-variable search result rejected for r4v9, resolved type: com.baidu.tieba.frs.FrsActivity */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        new aq("c13439").brk();
                        if (FrsTabController.this.cxy() != null && !TextUtils.isEmpty(FrsTabController.this.cxy().getForumId()) && !TextUtils.isEmpty(FrsTabController.this.mForumName) && FrsTabController.this.jas != null) {
                            if (FrsTabController.this.jaD != null) {
                                FrsTabController.this.jaD.hideTip();
                            }
                            be.brr().b(FrsTabController.this.jas.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/bawutask?fid=" + FrsTabController.this.cxy().getForumId() + "&fn=" + FrsTabController.this.mForumName + "&noread=" + (com.baidu.tbadk.core.sharedPref.b.bqh().getInt("key_bawu_task_toast", 0) == -1 ? 1 : 0)});
                        }
                    }
                });
                this.jaD.a(this.jas, inflate, 30000);
                new aq("c13438").brk();
                int i = com.baidu.tbadk.core.sharedPref.b.bqh().getInt("key_bawu_task_toast", 0);
                if (i >= 0) {
                    com.baidu.tbadk.core.sharedPref.b.bqh().putInt("key_bawu_task_toast", i + 1);
                }
            }
        }
    }

    private void cDA() {
        boolean z;
        if (this.iLF != null && this.iLF.getEntelechyTabInfo() != null && this.iLF.getEntelechyTabInfo().tab != null) {
            Iterator<FrsTabInfo> it = this.iLF.getEntelechyTabInfo().tab.iterator();
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
                if (this.jaG == null) {
                    this.jaG = new com.baidu.tieba.c.e(this.jas.getPageContext(), this.jaA);
                    this.jaG.fu(R.drawable.pic_sign_tip_down);
                    this.jaG.setAnchor(2);
                    this.jaG.setUseDirectOffset(true);
                    this.jaG.xq(-l.getDimens(this.jas, R.dimen.tbds20));
                    this.jaG.setYOffset(-l.getDimens(this.jas, R.dimen.tbds20));
                    this.jaG.setTextColor(R.color.cp_cont_a);
                    this.jaG.setHeight(R.dimen.tbds54);
                    this.jaG.xo(l.getDimens(this.jas, R.dimen.tbds44));
                }
                this.jaG.aM(this.jas.getString(R.string.frs_evaluate_tip), "first_into_frs_with_evaluate_tab");
            }
        }
    }

    private void d(final ForumData forumData) {
        boolean z = false;
        if (g(forumData.getName(), forumData.getId(), forumData.getImage_url(), false)) {
            if (this.jaI != null) {
                com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jaI);
            }
            z = true;
        }
        if (!this.jaJ) {
            this.jaH.cFi().i(TbadkCoreApplication.getCurrentAccount(), forumData.getId(), System.currentTimeMillis());
            this.jaJ = true;
        }
        if (!z) {
            this.jaI = this.jaI != null ? this.jaI : new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.17
                @Override // java.lang.Runnable
                public void run() {
                    if (FrsTabController.this.jaH != null) {
                        if (FrsTabController.this.jaL) {
                            FrsTabController.this.g(forumData.getName(), forumData.getId(), forumData.getImage_url(), true);
                        } else {
                            FrsTabController.this.jaK = true;
                        }
                    }
                }
            };
            com.baidu.adp.lib.f.e.mY().postDelayed(this.jaI, 60000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ForumData forumData) {
        if (this.iLE.cyi() != null && this.jaH != null) {
            if (forumData == null) {
                forumData = this.iLF.getForum();
            }
            if (forumData != null && forumData.isLike() != 1) {
                if (!this.jaL) {
                    this.jaK = true;
                } else if (g(forumData.getName(), forumData.getId(), forumData.getImage_url(), false) && this.jaI != null) {
                    com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jaI);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(String str, String str2, String str3, boolean z) {
        if (!this.jaH.eZ(TbadkCoreApplication.getCurrentAccount(), str2) || this.iLE == null || this.iLE.cyi() == null) {
            return false;
        }
        this.jaK = false;
        this.jaH.a(this.jas, str, str2, str3, this.iLE.cyi().cGb());
        this.jaH.cFi().a(TbadkCoreApplication.getCurrentAccount(), str2, System.currentTimeMillis(), z);
        return true;
    }

    public boolean fI(long j) {
        ForumData forum;
        return (this.iLF == null || j == 0 || (forum = this.iLF.getForum()) == null || com.baidu.adp.lib.f.b.toLong(forum.getId(), 0L) != j) ? false : true;
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
        /* renamed from: zQ */
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

        public BaseFragment KG(String str) {
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

        public BaseFragment zR(int i) {
            return (BaseFragment) y.remove(this.mFragments, i);
        }

        public String zS(int i) {
            if (getItem(i) != null) {
                return getItem(i).getBaseTag();
            }
            return null;
        }
    }

    public TbPageTag getTbPageTag() {
        if (!cDy()) {
            return this.iLE.getTbPageTag();
        }
        if (this.jat != null) {
            if (1 == this.jat.getCurrentTabType()) {
                return this.iLE.getTbPageTag();
            }
            Fragment currentFragment = this.jat.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                return ((BaseFragment) currentFragment).getTbPageTag();
            }
        }
        return null;
    }
}
