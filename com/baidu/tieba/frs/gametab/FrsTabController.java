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
import tbclient.FrsTabInfo;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes21.dex */
public class FrsTabController implements VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, FrsCommonImageLayout.c {
    public static final String ite = FrsFragment.class.getSimpleName();
    public static final String itf = FrsTabHostFragment.class.getSimpleName();
    private LinearLayout hZY;
    private am ien;
    private FrsFragment ieo;
    private m iep;
    private int ier;
    private FRSRefreshButton iet;
    private FrsActivity itg;
    private FrsTabHostFragment ith;
    private ShareSuccessReplyToServerModel itk;
    private FrsBaseViewPager itm;
    private FragmentAdapter itn;
    private OvalActionButton ito;
    private boolean itp;
    private boolean itq;
    private NavigationBarCoverTip itr;
    private com.baidu.tieba.c.e itu;
    private com.baidu.tieba.frs.f.d itv;
    private Runnable itw;
    private boolean itx;
    private String mForumName;
    private String mFrom;
    private boolean iti = false;
    private final Handler mHandler = new Handler();
    private int ieq = 0;
    private boolean itl = false;
    private boolean its = false;
    private boolean itt = false;
    private boolean ity = false;
    private boolean itz = false;
    private HttpMessageListener itA = new HttpMessageListener(CmdConfigHttp.CMD_FRS_RECOMMEND) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof FrsRecommendResMsg) {
                if (httpResponsedMessage.getError() != 0) {
                    new BdTopToast(FrsTabController.this.itg).xd(false).SP(httpResponsedMessage.getErrorString()).aF((ViewGroup) FrsTabController.this.itg.findViewById(R.id.frs));
                    return;
                }
                int pushStatus = ((FrsRecommendResMsg) httpResponsedMessage).getPushStatus();
                String pushMsg = ((FrsRecommendResMsg) httpResponsedMessage).getPushMsg();
                if (pushStatus == 1) {
                    new ScreenTopToast(FrsTabController.this.itg).ST(FrsTabController.this.itg.getString(R.string.frs_recommend_suc_tip_title)).SU(FrsTabController.this.itg.getString(R.string.frs_recommend_suc_tip_content)).SV(FrsTabController.this.itg.getString(R.string.dialog_confirm_see)).ak(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.1.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("_forumId", FrsTabController.this.iep.getForum().getId());
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new com.baidu.tieba.tbadkCore.data.m(FrsTabController.this.itg, "RecommendHistoryPage", hashMap)));
                        }
                    }).aF((ViewGroup) FrsTabController.this.itg.findViewById(R.id.frs));
                } else {
                    new BdTopToast(FrsTabController.this.itg).xd(false).SP(pushMsg).aF((ViewGroup) FrsTabController.this.itg.findViewById(R.id.frs));
                }
            }
        }
    };
    private CustomMessageListener itB = new CustomMessageListener(2921465) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            new ScreenTopToast(FrsTabController.this.itg).ST(FrsTabController.this.itg.getString(R.string.frs_recommend_fail_month_tip)).SV(FrsTabController.this.itg.getString(R.string.frs_recommend_fail_tip_btn)).ak(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.12.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("_forumId", FrsTabController.this.iep.getForum().getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new com.baidu.tieba.tbadkCore.data.m(FrsTabController.this.itg, "ForumGradePage", hashMap)));
                }
            }).aF((ViewGroup) FrsTabController.this.itg.findViewById(R.id.frs));
        }
    };
    private com.baidu.adp.framework.listener.a itC = new com.baidu.adp.framework.listener.a(1001703, CmdConfigSocket.CMD_FRS_PAGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.17
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            m mVar = null;
            int i = -1;
            if (!FrsTabController.this.iti && !responsedMessage.hasError() && responsedMessage.getError() == 0) {
                if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                    mVar = ((FrsPageHttpResponseMessage) responsedMessage).getResponseData();
                    i = ((FrsPageHttpResponseMessage) responsedMessage).getUpdateType();
                } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                    mVar = ((FRSPageSocketResponsedMessage) responsedMessage).getResponseData();
                    i = ((FRSPageSocketResponsedMessage) responsedMessage).getUpdateType();
                }
                if (mVar != null) {
                    FrsTabController.this.iti = true;
                    FrsTabController.this.a(mVar, true, i);
                    if (mVar != null && mVar.getForum() != null && !StringUtils.isNull(mVar.getForum().getId())) {
                        com.baidu.tbadk.core.business.a.bcS().dt("2", mVar.getForum().getId());
                    }
                }
                if (mVar != null && mVar.getUserData() != null && mVar.getUserData().getNewGodData() != null) {
                    if (mVar.getForum() != null) {
                        w.bwL().setFid(mVar.getForum().getId());
                    }
                    w.bwL().b(2, mVar.getUserData().getNewGodData());
                }
            }
        }
    };
    private CustomMessageListener itD = new CustomMessageListener(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!FrsTabController.this.iti && FrsTabController.this.iep == null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof m)) {
                m mVar = (m) customResponsedMessage.getData();
                if (mVar.getForum() != null && FrsTabController.this.mForumName != null && FrsTabController.this.mForumName.equals(mVar.getForum().getName())) {
                    FrsTabController.this.a(mVar, false, -1);
                }
            }
        }
    };
    private CustomMessageListener itE = new CustomMessageListener(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsTabController.this.cus();
        }
    };
    private CustomMessageListener itF = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int xN;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (10001 == intValue) {
                    xN = FrsTabController.this.xN(9);
                    if (xN == -1) {
                        xN = FrsTabController.this.xN(2);
                    }
                } else {
                    xN = FrsTabController.this.xN(intValue);
                }
                if (xN != -1 && FrsTabController.this.cut() && FrsTabController.this.ith != null) {
                    FrsTabController.this.ith.setCurrentTab(xN);
                    if (FrsTabController.this.xP(xN) != 1) {
                        FrsTabController.this.ieo.oq(false);
                    }
                }
            }
        }
    };
    private HttpMessageListener itG = new HttpMessageListener(0) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && 1021074 == httpResponsedMessage.getCmd() && (httpResponsedMessage instanceof AlaGameTabGetNewNotifyResponsedMessage)) {
                List<a> newNotifyData = ((AlaGameTabGetNewNotifyResponsedMessage) httpResponsedMessage).getNewNotifyData();
                if (!y.isEmpty(newNotifyData) && FrsTabController.this.ith != null) {
                    for (a aVar : newNotifyData) {
                        if (aVar != null) {
                            for (int i = 0; i < FrsTabController.this.ien.bsg().size(); i++) {
                                FragmentTabHost.b nX = FrsTabController.this.ith.nX(i);
                                if (nX != null && nX.mType != 1 && nX.mType != FrsTabController.this.ith.getCurrentTabType() && nX.mType == aVar.getTabId() && aVar.cuj() && nX.ekW.CL(String.valueOf(nX.mType)) != null) {
                                    nX.ekW.CL(String.valueOf(nX.mType)).view.setVisibility(0);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private Runnable itH = new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.22
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.adp.lib.f.e.mX().removeCallbacks(this);
            FrsTabController.this.cur();
            com.baidu.adp.lib.f.e.mX().postDelayed(this, 30000L);
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                FrsTabController.this.itl = true;
            }
        }
    };
    private CustomMessageListener itI = new CustomMessageListener(2921369) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.itm != null && FrsTabController.this.itn != null && (customResponsedMessage.getData() instanceof FrsTabViewPager.a)) {
                FrsTabViewPager.a aVar = (FrsTabViewPager.a) customResponsedMessage.getData();
                FrsTabController.this.itp = aVar.crm();
                FrsTabController.this.itq = aVar.crn();
            }
        }
    };
    private CustomMessageListener itJ = new CustomMessageListener(2921370) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.itm != null && FrsTabController.this.itn != null && (customResponsedMessage.getData() instanceof Boolean)) {
                FrsTabController.this.itm.setForceIntercept(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };
    private CustomMessageListener itK = new CustomMessageListener(CmdConfigCustom.CMD_NEW_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                FrsTabController.this.e((ForumData) null);
            }
        }
    };
    private CustomMessageListener itL = new CustomMessageListener(2921498) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsTabController.this.itv != null && customResponsedMessage != null && customResponsedMessage.getData() != null) {
                if (customResponsedMessage.getData() instanceof ForumData) {
                    FrsTabController.this.e((ForumData) customResponsedMessage.getData());
                } else if (customResponsedMessage.getData() instanceof Long) {
                    long longValue = ((Long) customResponsedMessage.getData()).longValue();
                    if (FrsTabController.this.eU(longValue) && FrsTabController.this.itv.eV(longValue) >= 3) {
                        FrsTabController.this.itv.eW(longValue);
                        FrsTabController.this.ity = true;
                    }
                }
            }
        }
    };
    private CustomMessageListener itM = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                if (FrsTabController.this.itv != null && aVar != null && TbadkCoreApplication.isLogin()) {
                    FrsTabController.this.itv.eM(TbadkCoreApplication.getCurrentAccount(), String.valueOf(aVar.forumId));
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener itN = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.7
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i != 1) {
                FrsTabController.this.ito.setVisibility(0);
                if (FrsTabController.this.cos() != null) {
                    FrsTabController.this.cos().ok(false);
                }
                FrsTabController.this.ieo.cpI();
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            switch (i) {
                case 0:
                    FrsTabController.this.itq = false;
                    FrsTabController.this.itm.setForceIntercept(false);
                    return;
                default:
                    return;
            }
        }
    };
    private FrsBaseViewPager.a itO = new FrsBaseViewPager.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.8
        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public void coN() {
            if (FrsTabController.this.itm != null) {
                if (FrsTabController.this.itm.getCurrentItem() == 0) {
                    FrsTabController.this.itm.setmDisallowSlip(true);
                } else {
                    FrsTabController.this.itm.setmDisallowSlip(false);
                }
            }
        }

        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public boolean coO() {
            if (FrsTabController.this.itm.getCurrentItem() == 0) {
                if (FrsTabController.this.itp && FrsTabController.this.itq) {
                    FrsTabController.this.itm.setmDisallowSlip(false);
                }
                if (!FrsTabController.this.itq) {
                    FrsTabController.this.itm.setmDisallowSlip(true);
                }
                FrsTabController.this.itm.setmDisallowSlip(true);
            } else {
                FrsTabController.this.itm.setmDisallowSlip(true);
            }
            return true;
        }
    };
    private String itj = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.SHOW_GAME_FOREM_TAB_HOT_POINT);

    public FrsTabController(FrsActivity frsActivity) {
        this.itg = frsActivity;
    }

    public void init(Bundle bundle) {
        if (this.itg != null) {
            this.itg.setContentView(R.layout.frs_base_layout);
            this.itm = (FrsBaseViewPager) this.itg.findViewById(R.id.frs_base_viewpager);
            this.itn = new FragmentAdapter(this.itg.getSupportFragmentManager());
            this.itm.setAdapter(this.itn);
            this.itm.setPageTransformer(true, new CubeOutViewPagerTransformer());
            this.itm.addOnPageChangeListener(this.itN);
            this.itm.setmDisallowSlip(true);
            this.itm.setOnTouchEventListener(this.itO);
            this.ito = (OvalActionButton) this.itg.findViewById(R.id.frs_post_forum_button);
            this.ito.setIsCircle(true);
            this.ito.setHasShadow(false);
            this.iet = (FRSRefreshButton) this.itg.findViewById(R.id.frs_refresh_forum_button);
            this.hZY = (LinearLayout) this.itg.findViewById(R.id.frs_ll_redpack);
            this.itg.registerListener(this.itI);
            this.itg.registerListener(this.itJ);
            this.itC.getHttpMessageListener().setPriority(-1);
            this.itC.getSocketMessageListener().setPriority(-1);
            this.itg.registerListener(this.itD);
            this.itF.setSelfListener(true);
            this.itg.registerListener(this.itF);
            this.itE.setSelfListener(true);
            this.itg.registerListener(this.itE);
            this.itg.registerListener(this.mAccountChangedListener);
            if (bundle == null) {
                this.mForumName = this.itg.getIntent().getStringExtra("name");
                this.mFrom = this.itg.getIntent().getStringExtra("from");
                this.ieq = this.itg.getIntent().getIntExtra(FrsActivityConfig.FRS_GAME_DEFAULT_TAB_ID, 0);
            } else {
                this.mForumName = bundle.getString("name");
                this.mFrom = bundle.getString("from");
                this.ieq = bundle.getInt("default_tab_id", 0);
            }
            an(bundle);
            this.itn.notifyDataSetChanged();
            this.itk = new ShareSuccessReplyToServerModel();
            this.itg.registerListener(this.itC);
            this.itg.registerListener(this.itA);
            this.itg.registerListener(this.itB);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.mForumName);
        bundle.putInt("default_tab_id", this.ieq);
        bundle.putString("from", this.mFrom);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void an(Bundle bundle) {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.itn != null) {
            try {
                FrsFragment frsFragment = (FrsFragment) this.itn.Jd(ite);
                if (frsFragment == null) {
                    frsFragment = ao(bundle);
                }
                frsFragment.b(this.ito);
                frsFragment.a(this.iet);
                frsFragment.c(this.hZY);
                if (!ite.equals(this.itn.yG(0))) {
                    if (itf.equals(this.itn.yG(0))) {
                        this.itn.yF(0);
                    }
                    this.itn.a(0, frsFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cum() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.itn != null) {
            try {
                FrsTabHostFragment frsTabHostFragment = (FrsTabHostFragment) this.itn.Jd(itf);
                if (frsTabHostFragment == null) {
                    frsTabHostFragment = cun();
                }
                frsTabHostFragment.b(this.ito);
                frsTabHostFragment.b(this.iet);
                if (!itf.equals(this.itn.yG(0))) {
                    if (ite.equals(this.itn.yG(0))) {
                        this.itn.yF(0);
                    }
                    this.itn.a(0, frsTabHostFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private FrsFragment ao(Bundle bundle) {
        if (this.ieo == null) {
            this.ieo = new FrsFragment();
            this.ieo.setArguments(bundle);
            this.ieo.setBaseTag(ite);
        }
        this.ieo.iaf = false;
        return this.ieo;
    }

    private FrsTabHostFragment cun() {
        if (this.ith == null) {
            this.ith = new FrsTabHostFragment(this);
            this.ith.setBaseTag(itf);
            this.ith.xR(this.ieq);
        }
        return this.ith;
    }

    private FragmentManager getFragmentManager() {
        if (this.itg != null) {
            return this.itg.getSupportFragmentManager();
        }
        return null;
    }

    private void cuo() {
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.iep != null && (themeColorInfo = this.iep.getForum().getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            this.ito.setStartAndEndColor(themeElement.light_color, themeElement.dark_color);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(m mVar, boolean z, int i) {
        if (mVar != null && mVar.getForum() != null) {
            ForumData forum = mVar.getForum();
            if (z) {
                com.baidu.tbadk.youngster.b.a.a(this.itg.getPageContext(), mVar.getAnti(), R.id.frs);
            }
            if (forum.getIsShowBawuTask() && com.baidu.tbadk.core.sharedPref.b.bjf().getInt("key_bawu_task_toast", 0) == 0 && !this.its) {
                this.its = true;
                com.baidu.adp.lib.f.e.mX().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.9
                    @Override // java.lang.Runnable
                    public void run() {
                        FrsTabController.this.cuu();
                    }
                }, 30000L);
            }
            if (mVar.bazhuExam != null && !this.itt && z) {
                com.baidu.tieba.frs.m.a(this.itg.getPageContext(), mVar.bazhuExam, forum.getId(), forum.getName());
                this.itt = true;
            }
            this.iep = mVar;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921476));
            if (y.getCount(mVar.getGameTabInfo()) > 0) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.10
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean cR = FrsTabController.this.cR(FrsTabController.this.iep.getGameTabInfo());
                        if (cR) {
                            FrsTabController.this.itn.notifyDataSetChanged();
                            if (cR && FrsTabController.this.ith != null) {
                                FrsTabController.this.ith.Z(FrsTabController.this.ieo);
                                FrsTabController.this.ith.a(FrsTabController.this.iep, FrsTabController.this.ien);
                            }
                        }
                        if (FrsTabController.this.itg.isLoadingViewAttached()) {
                            FrsTabController.this.itg.hideLoadingView(FrsTabController.this.itg.findViewById(16908290));
                        }
                    }
                });
            } else if (cut()) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.11
                    @Override // java.lang.Runnable
                    public void run() {
                        Bundle bundle;
                        FrsTabController.this.ieo.iaf = true;
                        if (FrsTabController.this.ieo != null) {
                            bundle = FrsTabController.this.ieo.getArguments();
                        } else {
                            bundle = null;
                        }
                        FrsTabController.this.an(bundle);
                        FrsTabController.this.itn.notifyDataSetChanged();
                        if (FrsTabController.this.itg.isLoadingViewAttached()) {
                            FrsTabController.this.itg.hideLoadingView(FrsTabController.this.itg.findViewById(16908290));
                        }
                    }
                });
            }
            cuo();
            cuv();
            if (z) {
                if ((!this.itx || i == 4) && forum.isLike() == 0 && com.baidu.tbadk.a.d.baY() && TbadkCoreApplication.isLogin()) {
                    this.itv = new com.baidu.tieba.frs.f.d();
                    this.itg.registerListener(this.itL);
                    this.itg.registerListener(this.itK);
                    this.itg.registerListener(this.itM);
                    d(forum);
                }
            }
        }
    }

    public m cup() {
        return this.iep;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cR(List<FrsTabInfo> list) {
        if (this.itg.isLoadingViewAttached()) {
            this.itg.hideLoadingView(this.itg.findViewById(16908290));
        }
        if (cut()) {
            return false;
        }
        this.ieo.iaf = true;
        cuq();
        if (com.baidu.tbadk.core.sharedPref.b.bjf().getBoolean("frs_game_login_tip", true)) {
            com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean(SharedPrefConfig.FRS_LOGIN_TIP, true);
            com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean("frs_game_login_tip", false);
        }
        cS(list);
        return true;
    }

    private void cuq() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021074, TbConfig.SERVER_ADDRESS + "game/forum/getNewNotify");
        tbHttpMessageTask.setResponsedClass(AlaGameTabGetNewNotifyResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.itg.registerListener(1021074, this.itG);
    }

    private void cS(List<FrsTabInfo> list) {
        boolean z;
        if (!y.isEmpty(list)) {
            CustomMessageListener customMessageListener = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.13
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof am)) {
                        if (!com.baidu.tbadk.core.sharedPref.b.bjf().getBoolean(FrsTabController.this.itj, true)) {
                            com.baidu.adp.lib.f.e.mX().post(FrsTabController.this.itH);
                        }
                        ((am) customResponsedMessage.getData()).b(new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.13.1
                            @Override // com.baidu.tbadk.mainTab.b
                            public boolean isAvailable() {
                                return true;
                            }

                            @Override // com.baidu.tbadk.mainTab.b
                            public com.baidu.tbadk.mainTab.c createFragmentTabStructure() {
                                FrsSportsRecommendFragment frsSportsRecommendFragment = new FrsSportsRecommendFragment();
                                Bundle bundle = new Bundle();
                                bundle.putString("name", FrsTabController.this.ieo.getForumName());
                                bundle.putString("from", FrsTabController.this.ieo.getFrom());
                                bundle.putString("forum_id", FrsTabController.this.ieo.getForumId());
                                bundle.putInt("tab_id", 503);
                                bundle.putBoolean("can_auto_play_video", FrsTabController.this.iep.isFrsVideoAutoPlay);
                                bundle.putBoolean("need_log", FrsTabController.this.iep.needLog == 1);
                                bundle.putBoolean("is_brand_forum", FrsTabController.this.iep.isBrandForum);
                                FrsViewData frsViewData = new FrsViewData();
                                frsViewData.receiveData(FrsTabController.this.iep);
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
                        FrsTabController.this.cum();
                    }
                }
            };
            customMessageListener.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            customMessageListener.setSelfListener(true);
            this.itg.registerListener(customMessageListener);
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
            this.ien = new am(this.itg.getActivity(), arrayList);
            if (cos() != null) {
                this.ien.setForumId(cos().getForumId());
                this.ien.setForumName(cos().getForumName());
                if (cos().cpJ() != null && cos().cpJ().getForum() != null) {
                    ForumData forum = cos().cpJ().getForum();
                    this.ien.setForumGameLabel(forum.getForumGameLabel());
                    this.ien.Hc(forum.getSpecialForumType());
                }
            }
            this.ieo.iaf = false;
            new e(this.ieo).a(this.ien);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB, this.ien);
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB);
            customMessage.setTag(this.itg.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cur() {
        if (this.ien != null && !TextUtils.isEmpty(this.ien.getForumId())) {
            HttpMessage httpMessage = new HttpMessage(1021074);
            httpMessage.addParam("forum_id", this.iep.getForum().getId());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    private void a(Fragment fragment, int i) {
        NavigationBar bKS;
        if ((fragment instanceof at) && this.iep != null && this.iep.getForum() != null && (bKS = ((at) fragment).bKS()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.iep.getForum().getName(), 5, true, true) + this.itg.getActivity().getString(R.string.forum));
            bKS.setCenterTextTitle(sb.toString());
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.ieo instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.ieo.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a sh(int i) {
        if (this.ieo instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.ieo.sh(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.ieo instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.ieo.a(bVar);
        }
    }

    public void onNewIntent(Intent intent) {
        if (this.ieo != null) {
            this.ieo.onNewIntent(intent);
        }
    }

    public void onResume() {
        if (!cut()) {
            this.ieo.setPrimary(true);
        } else if (this.ith != null) {
            Fragment currentFragment = this.ith.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(true);
            }
        }
        if (this.itl) {
            this.itl = false;
            if (this.ieo != null) {
                this.ieo.refresh();
            }
        }
        if (this.iep != null && this.iep.getUserData() != null && this.iep.getUserData().getNewGodData() != null) {
            if (this.iep.getForum() != null) {
                w.bwL().setFid(this.iep.getForum().getId());
            }
            w.bwL().b(2, this.iep.getUserData().getNewGodData());
        }
        this.itz = true;
        if (this.ity) {
            e((ForumData) null);
        }
    }

    public void onPause() {
        this.itz = false;
        if (this.itv != null) {
            this.itv.cwe();
        }
        if (!cut()) {
            this.ieo.setPrimary(false);
        } else if (this.ith != null) {
            Fragment currentFragment = this.ith.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(false);
            }
        }
        w.bwL().removeCallbacks();
    }

    public void onChangeSkinType(int i) {
        UtilHelper.changeStatusBarIconAndTextColor(true, this.itg);
        if (this.ieo != null) {
            this.ieo.onChangeSkinType(i);
        }
        if (this.ith != null) {
            this.ith.onChangeSkinType(i);
        }
        cuo();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (cut() && this.ith != null && this.ith.cqQ()) {
                this.ith.crh();
                UtilHelper.setNavigationBarBackground(this.itg, this.ith.crc());
            } else if (this.ieo != null && this.ieo.isAdded()) {
                if (this.ieo.onKeyDown(i, keyEvent)) {
                    return true;
                }
                cus();
            } else {
                return this.itg.b(i, keyEvent);
            }
        } else if (i == 24) {
            if (this.ieo != null && this.ieo.isAdded()) {
                return this.ieo.onKeyDown(i, keyEvent);
            }
        } else {
            return this.itg.b(i, keyEvent);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cus() {
        if (this.ier != this.ieq && cut()) {
            this.ith.setCurrentTab(this.ieq);
            if (xP(this.ieq) != 1) {
                this.ieo.oq(false);
            }
            this.ier = this.ieq;
            a(this.ith.getCurrentFragment(), this.ieq);
            return;
        }
        this.ieo.closeActivity();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!cut()) {
            this.ieo.onActivityResult(i, i2, intent);
        } else if (this.ith != null) {
            if (1 == this.ith.getCurrentTabType()) {
                this.ieo.onActivityResult(i, i2, intent);
            } else {
                this.ith.getCurrentFragment().onActivityResult(i, i2, intent);
            }
        }
        if (i2 == -1) {
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1) {
                    com.baidu.tieba.o.a.dqz().F(this.itg.getPageContext());
                    ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.linkUrl != null && this.itk != null) {
                        this.itk.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.14
                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void bpT() {
                            }

                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void a(final CustomDialogData customDialogData) {
                                com.baidu.adp.lib.f.e.mX().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.14.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (FrsTabController.this.itg != null) {
                                            com.baidu.tieba.pb.interactionpopupwindow.c.a(FrsTabController.this.itg.getPageContext(), customDialogData).show();
                                        }
                                    }
                                }, 1000L);
                            }
                        });
                    }
                }
            } else if (i == 13011) {
                com.baidu.tieba.o.a.dqz().F(this.itg.getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (!cut()) {
            return this.ieo.getVoiceManager();
        }
        if (this.ith == null) {
            return null;
        }
        Fragment currentFragment = this.ith.getCurrentFragment();
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
    public int xN(int i) {
        if (this.ien == null) {
            return -1;
        }
        int count = y.getCount(this.ien.bsg());
        for (int i2 = 0; i2 < count; i2++) {
            if (this.ien.bsg().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int xP(int i) {
        if (this.ien != null && i < y.getCount(this.ien.bsg())) {
            return this.ien.bsg().get(i).tab_id.intValue();
        }
        return -1;
    }

    public FrsFragment cos() {
        return this.ieo;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> cot() {
        if (!cut()) {
            if (this.ieo instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) this.ieo).cot();
            }
        } else if (this.ith == null) {
            return null;
        } else {
            Fragment currentFragment = this.ith.getCurrentFragment();
            if (currentFragment instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) currentFragment).cot();
            }
        }
        return null;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(t.idw);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.itg.isLoadingViewAttached()) {
            this.itg.hideLoadingView(this.itg.findViewById(16908290));
        }
        if (this.itH != null) {
            com.baidu.adp.lib.f.e.mX().removeCallbacks(this.itH);
        }
        com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean(this.itj, false);
        if (this.itk != null) {
            this.itk.cancelLoadData();
        }
        if (this.ieo != null && this.ieo.cpa() != null) {
            this.ieo.cpa().cuG();
        }
        if (this.itr != null) {
            this.itr.onDestroy();
        }
        if (FrsActivityConfig.FRS_FROM_FLUTTER_BCASTEDIT.equals(this.mFrom)) {
            new o(TbadkCoreApplication.getInst()).bju();
        }
        if (this.itw != null) {
            com.baidu.adp.lib.f.e.mX().removeCallbacks(this.itw);
        }
        if (this.iep != null && this.iep.getForum() != null && this.itv != null) {
            this.itv.eW(com.baidu.adp.lib.f.b.toLong(this.iep.getForum().getId(), 0L));
        }
    }

    public FragmentTabHost crf() {
        if (this.ith == null) {
            return null;
        }
        return this.ith.crf();
    }

    public boolean cut() {
        if (this.itn == null) {
            return false;
        }
        return this.itn.getItem(0) instanceof FrsTabHostFragment;
    }

    public void xR(int i) {
        this.ieq = i;
    }

    public void yD(int i) {
        this.ier = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuu() {
        if (this.itg != null) {
            if (this.itr == null) {
                this.itr = (NavigationBarCoverTip) this.itg.findViewById(R.id.navigation_cover_tip);
            }
            if (this.itr != null) {
                View inflate = View.inflate(this.itg, R.layout.write_thread_share_guide, null);
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
                cVar.bmk();
                tBSpecificationBtn.setConfig(cVar);
                tBSpecificationBtn.blA();
                ap.setViewTextColor(textView, R.color.cp_cont_a);
                ap.setBackgroundColor(this.itr, R.color.cp_link_tip_a_alpha95);
                tBSpecificationBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.15
                    /* JADX DEBUG: Multi-variable search result rejected for r4v9, resolved type: com.baidu.tieba.frs.FrsActivity */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        new aq("c13439").bki();
                        if (FrsTabController.this.cos() != null && !TextUtils.isEmpty(FrsTabController.this.cos().getForumId()) && !TextUtils.isEmpty(FrsTabController.this.mForumName) && FrsTabController.this.itg != null) {
                            if (FrsTabController.this.itr != null) {
                                FrsTabController.this.itr.hideTip();
                            }
                            be.bkp().b(FrsTabController.this.itg.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/bawutask?fid=" + FrsTabController.this.cos().getForumId() + "&fn=" + FrsTabController.this.mForumName + "&noread=" + (com.baidu.tbadk.core.sharedPref.b.bjf().getInt("key_bawu_task_toast", 0) == -1 ? 1 : 0)});
                        }
                    }
                });
                this.itr.a(this.itg, inflate, 30000);
                new aq("c13438").bki();
                int i = com.baidu.tbadk.core.sharedPref.b.bjf().getInt("key_bawu_task_toast", 0);
                if (i >= 0) {
                    com.baidu.tbadk.core.sharedPref.b.bjf().putInt("key_bawu_task_toast", i + 1);
                }
            }
        }
    }

    private void cuv() {
        boolean z;
        if (this.iep != null && this.iep.getEntelechyTabInfo() != null && this.iep.getEntelechyTabInfo().tab != null) {
            Iterator<FrsTabInfo> it = this.iep.getEntelechyTabInfo().tab.iterator();
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
                if (this.itu == null) {
                    this.itu = new com.baidu.tieba.c.e(this.itg.getPageContext(), this.ito);
                    this.itu.eW(R.drawable.pic_sign_tip_down);
                    this.itu.setAnchor(2);
                    this.itu.setUseDirectOffset(true);
                    this.itu.we(-l.getDimens(this.itg, R.dimen.tbds20));
                    this.itu.setYOffset(-l.getDimens(this.itg, R.dimen.tbds20));
                    this.itu.setTextColor(R.color.cp_cont_a);
                    this.itu.setHeight(R.dimen.tbds54);
                    this.itu.wc(l.getDimens(this.itg, R.dimen.tbds44));
                }
                this.itu.aG(this.itg.getString(R.string.frs_evaluate_tip), "first_into_frs_with_evaluate_tab");
            }
        }
    }

    private void d(final ForumData forumData) {
        boolean z = false;
        if (g(forumData.getName(), forumData.getId(), forumData.getImage_url(), false)) {
            if (this.itw != null) {
                com.baidu.adp.lib.f.e.mX().removeCallbacks(this.itw);
            }
            z = true;
        }
        if (!this.itx) {
            this.itv.cwd().h(TbadkCoreApplication.getCurrentAccount(), forumData.getId(), System.currentTimeMillis());
            this.itx = true;
        }
        if (!z) {
            this.itw = this.itw != null ? this.itw : new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.16
                @Override // java.lang.Runnable
                public void run() {
                    if (FrsTabController.this.itv != null) {
                        if (FrsTabController.this.itz) {
                            FrsTabController.this.g(forumData.getName(), forumData.getId(), forumData.getImage_url(), true);
                        } else {
                            FrsTabController.this.ity = true;
                        }
                    }
                }
            };
            com.baidu.adp.lib.f.e.mX().postDelayed(this.itw, 60000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ForumData forumData) {
        if (this.ieo.cpc() != null && this.itv != null) {
            if (forumData == null) {
                forumData = this.iep.getForum();
            }
            if (forumData != null && forumData.isLike() != 1) {
                if (!this.itz) {
                    this.ity = true;
                } else if (g(forumData.getName(), forumData.getId(), forumData.getImage_url(), false) && this.itw != null) {
                    com.baidu.adp.lib.f.e.mX().removeCallbacks(this.itw);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(String str, String str2, String str3, boolean z) {
        if (!this.itv.eN(TbadkCoreApplication.getCurrentAccount(), str2) || this.ieo == null || this.ieo.cpc() == null) {
            return false;
        }
        this.ity = false;
        this.itv.a(this.itg, str, str2, str3, this.ieo.cpc().cwW());
        this.itv.cwd().a(TbadkCoreApplication.getCurrentAccount(), str2, System.currentTimeMillis(), z);
        return true;
    }

    public boolean eU(long j) {
        ForumData forum;
        return (this.iep == null || j == 0 || (forum = this.iep.getForum()) == null || com.baidu.adp.lib.f.b.toLong(forum.getId(), 0L) != j) ? false : true;
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
        /* renamed from: yE */
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

        public BaseFragment Jd(String str) {
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

        public BaseFragment yF(int i) {
            return (BaseFragment) y.remove(this.mFragments, i);
        }

        public String yG(int i) {
            if (getItem(i) != null) {
                return getItem(i).getBaseTag();
            }
            return null;
        }
    }

    public TbPageTag getTbPageTag() {
        if (!cut()) {
            return this.ieo.getTbPageTag();
        }
        if (this.ith != null) {
            if (1 == this.ith.getCurrentTabType()) {
                return this.ieo.getTbPageTag();
            }
            Fragment currentFragment = this.ith.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                return ((BaseFragment) currentFragment).getTbPageTag();
            }
        }
        return null;
    }
}
