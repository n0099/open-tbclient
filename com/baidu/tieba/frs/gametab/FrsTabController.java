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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.p;
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
import com.baidu.tbadk.util.x;
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
    public static final String jEa = FrsFragment.class.getSimpleName();
    public static final String jEb = FrsTabHostFragment.class.getSimpleName();
    private FrsActivity jEc;
    private FrsTabHostFragment jEd;
    private ShareSuccessReplyToServerModel jEg;
    private FrsBaseViewPager jEi;
    private FragmentAdapter jEj;
    private OvalActionButton jEk;
    private boolean jEl;
    private boolean jEm;
    private NavigationBarCoverTip jEn;
    private com.baidu.tieba.c.e jEq;
    private com.baidu.tieba.frs.d.e jEr;
    private Runnable jEs;
    private boolean jEt;
    private LinearLayout jii;
    private ai jmt;
    private FrsFragment jmu;
    private m jmv;
    private int jmx;
    private FRSRefreshButton jmz;
    private String mForumName;
    private String mFrom;
    private boolean jEe = false;
    private final Handler mHandler = new Handler();
    private int jmw = 0;
    private boolean jEh = false;
    private boolean jEo = false;
    private boolean jEp = false;
    private boolean jEu = false;
    private boolean jEv = false;
    private HttpMessageListener jEw = new HttpMessageListener(CmdConfigHttp.CMD_FRS_RECOMMEND) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof FrsRecommendResMsg) {
                if (httpResponsedMessage.getError() != 0) {
                    new BdTopToast(FrsTabController.this.jEc).zm(false).Vg(httpResponsedMessage.getErrorString()).aR((ViewGroup) FrsTabController.this.jEc.findViewById(R.id.frs));
                    return;
                }
                int pushStatus = ((FrsRecommendResMsg) httpResponsedMessage).getPushStatus();
                String pushMsg = ((FrsRecommendResMsg) httpResponsedMessage).getPushMsg();
                if (pushStatus == 1) {
                    new ScreenTopToast(FrsTabController.this.jEc).Vl(FrsTabController.this.jEc.getString(R.string.frs_recommend_suc_tip_title)).Vm(FrsTabController.this.jEc.getString(R.string.frs_recommend_suc_tip_content)).Vn(FrsTabController.this.jEc.getString(R.string.dialog_confirm_see)).ao(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.1.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("_forumId", FrsTabController.this.jmv.getForum().getId());
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new com.baidu.tieba.tbadkCore.data.m(FrsTabController.this.jEc, "RecommendHistoryPage", hashMap)));
                        }
                    }).aR((ViewGroup) FrsTabController.this.jEc.findViewById(R.id.frs));
                } else {
                    new BdTopToast(FrsTabController.this.jEc).zm(false).Vg(pushMsg).aR((ViewGroup) FrsTabController.this.jEc.findViewById(R.id.frs));
                }
            }
        }
    };
    private CustomMessageListener jEx = new CustomMessageListener(2921465) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            new ScreenTopToast(FrsTabController.this.jEc).Vl(FrsTabController.this.jEc.getString(R.string.frs_recommend_fail_month_tip)).Vn(FrsTabController.this.jEc.getString(R.string.frs_recommend_fail_tip_btn)).ao(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.12.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("_forumId", FrsTabController.this.jmv.getForum().getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new com.baidu.tieba.tbadkCore.data.m(FrsTabController.this.jEc, "ForumGradePage", hashMap)));
                }
            }).aR((ViewGroup) FrsTabController.this.jEc.findViewById(R.id.frs));
        }
    };
    private com.baidu.adp.framework.listener.a jEy = new com.baidu.adp.framework.listener.a(1001703, CmdConfigSocket.CMD_FRS_PAGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.21
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            m mVar = null;
            int i = -1;
            if (!FrsTabController.this.jEe && !responsedMessage.hasError() && responsedMessage.getError() == 0) {
                if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                    mVar = ((FrsPageHttpResponseMessage) responsedMessage).getResponseData();
                    i = ((FrsPageHttpResponseMessage) responsedMessage).getUpdateType();
                } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                    mVar = ((FRSPageSocketResponsedMessage) responsedMessage).getResponseData();
                    i = ((FRSPageSocketResponsedMessage) responsedMessage).getUpdateType();
                }
                if (mVar != null) {
                    FrsTabController.this.jEe = true;
                    FrsTabController.this.a(mVar, true, i);
                    if (mVar != null && mVar.getForum() != null && !StringUtils.isNull(mVar.getForum().getId())) {
                        com.baidu.tbadk.core.business.b.blj().dC("2", mVar.getForum().getId());
                    }
                }
                if (mVar != null && mVar.getUserData() != null && mVar.getUserData().getNewGodData() != null) {
                    if (mVar.getForum() != null) {
                        x.bFG().setFid(mVar.getForum().getId());
                    }
                    x.bFG().b(2, mVar.getUserData().getNewGodData());
                }
            }
        }
    };
    private CustomMessageListener jEz = new CustomMessageListener(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!FrsTabController.this.jEe && FrsTabController.this.jmv == null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof m)) {
                m mVar = (m) customResponsedMessage.getData();
                if (mVar.getForum() != null && FrsTabController.this.mForumName != null && FrsTabController.this.mForumName.equals(mVar.getForum().getName())) {
                    FrsTabController.this.a(mVar, false, -1);
                }
            }
        }
    };
    private CustomMessageListener jEA = new CustomMessageListener(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsTabController.this.cIY();
        }
    };
    private CustomMessageListener jEB = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int yT;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (10001 == intValue) {
                    yT = FrsTabController.this.yT(9);
                    if (yT == -1) {
                        yT = FrsTabController.this.yT(2);
                    }
                } else {
                    yT = FrsTabController.this.yT(intValue);
                }
                if (yT != -1 && FrsTabController.this.cIZ() && FrsTabController.this.jEd != null) {
                    FrsTabController.this.jEd.setCurrentTab(yT);
                    if (FrsTabController.this.yV(yT) != 1) {
                        FrsTabController.this.jmu.qz(false);
                    }
                }
            }
        }
    };
    private HttpMessageListener jEC = new HttpMessageListener(0) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && 1021074 == httpResponsedMessage.getCmd() && (httpResponsedMessage instanceof AlaGameTabGetNewNotifyResponsedMessage)) {
                List<a> newNotifyData = ((AlaGameTabGetNewNotifyResponsedMessage) httpResponsedMessage).getNewNotifyData();
                if (!y.isEmpty(newNotifyData) && FrsTabController.this.jEd != null) {
                    for (a aVar : newNotifyData) {
                        if (aVar != null) {
                            for (int i = 0; i < FrsTabController.this.jmt.bAV().size(); i++) {
                                FragmentTabHost.b ou = FrsTabController.this.jEd.ou(i);
                                if (ou != null && ou.mType != 1 && ou.mType != FrsTabController.this.jEd.getCurrentTabType() && ou.mType == aVar.getTabId() && aVar.cIN() && ou.faJ.Ds(String.valueOf(ou.mType)) != null) {
                                    ou.faJ.Ds(String.valueOf(ou.mType)).view.setVisibility(0);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener jED = new CustomMessageListener(2921518) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            new BdTopToast(FrsTabController.this.jEc, 2000).zm(false).Vg(FrsTabController.this.jEc.getString(R.string.frs_top_forum_rules_click_toast)).aR((ViewGroup) FrsTabController.this.jEc.findViewById(R.id.frs));
        }
    };
    private Runnable jEE = new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.27
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this);
            FrsTabController.this.cIX();
            com.baidu.adp.lib.f.e.mA().postDelayed(this, 30000L);
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                FrsTabController.this.jEh = true;
            }
        }
    };
    private CustomMessageListener jEF = new CustomMessageListener(2921369) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.jEi != null && FrsTabController.this.jEj != null && (customResponsedMessage.getData() instanceof FrsTabViewPager.a)) {
                FrsTabViewPager.a aVar = (FrsTabViewPager.a) customResponsedMessage.getData();
                FrsTabController.this.jEl = aVar.cEP();
                FrsTabController.this.jEm = aVar.cEQ();
            }
        }
    };
    private CustomMessageListener jEG = new CustomMessageListener(2921370) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.jEi != null && FrsTabController.this.jEj != null && (customResponsedMessage.getData() instanceof Boolean)) {
                FrsTabController.this.jEi.setForceIntercept(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };
    private CustomMessageListener jEH = new CustomMessageListener(CmdConfigCustom.CMD_NEW_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                FrsTabController.this.e((ForumData) null);
            }
        }
    };
    private CustomMessageListener jEI = new CustomMessageListener(2921498) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsTabController.this.jEr != null && customResponsedMessage != null && customResponsedMessage.getData() != null) {
                if (customResponsedMessage.getData() instanceof ForumData) {
                    FrsTabController.this.e((ForumData) customResponsedMessage.getData());
                } else if (customResponsedMessage.getData() instanceof Long) {
                    long longValue = ((Long) customResponsedMessage.getData()).longValue();
                    if (FrsTabController.this.gv(longValue) && FrsTabController.this.jEr.gw(longValue) >= 3) {
                        FrsTabController.this.jEr.gx(longValue);
                        FrsTabController.this.jEu = true;
                    }
                }
            }
        }
    };
    private CustomMessageListener jEJ = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.e)) {
                com.baidu.tieba.tbadkCore.writeModel.e eVar = (com.baidu.tieba.tbadkCore.writeModel.e) customResponsedMessage.getData();
                if (FrsTabController.this.jEr != null && eVar != null && TbadkCoreApplication.isLogin()) {
                    FrsTabController.this.jEr.fe(TbadkCoreApplication.getCurrentAccount(), String.valueOf(eVar.forumId));
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener jEK = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.8
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i != 1) {
                FrsTabController.this.jEk.setVisibility(0);
                if (FrsTabController.this.cBR() != null) {
                    FrsTabController.this.cBR().qt(false);
                }
                FrsTabController.this.jmu.cDl();
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            switch (i) {
                case 0:
                    FrsTabController.this.jEm = false;
                    FrsTabController.this.jEi.setForceIntercept(false);
                    return;
                default:
                    return;
            }
        }
    };
    private FrsBaseViewPager.a jEL = new FrsBaseViewPager.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.9
        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public void cCn() {
            if (FrsTabController.this.jEi != null) {
                if (FrsTabController.this.jEi.getCurrentItem() == 0) {
                    FrsTabController.this.jEi.setmDisallowSlip(true);
                } else {
                    FrsTabController.this.jEi.setmDisallowSlip(false);
                }
            }
        }

        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public boolean cCo() {
            if (FrsTabController.this.jEi.getCurrentItem() == 0) {
                if (FrsTabController.this.jEl && FrsTabController.this.jEm) {
                    FrsTabController.this.jEi.setmDisallowSlip(false);
                }
                if (!FrsTabController.this.jEm) {
                    FrsTabController.this.jEi.setmDisallowSlip(true);
                }
                FrsTabController.this.jEi.setmDisallowSlip(true);
            } else {
                FrsTabController.this.jEi.setmDisallowSlip(true);
            }
            return true;
        }
    };
    private String jEf = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.SHOW_GAME_FOREM_TAB_HOT_POINT);

    public FrsTabController(FrsActivity frsActivity) {
        this.jEc = frsActivity;
    }

    public void init(Bundle bundle) {
        if (this.jEc != null) {
            this.jEc.setContentView(R.layout.frs_base_layout);
            this.jEi = (FrsBaseViewPager) this.jEc.findViewById(R.id.frs_base_viewpager);
            this.jEj = new FragmentAdapter(this.jEc.getSupportFragmentManager());
            this.jEi.setAdapter(this.jEj);
            this.jEi.setPageTransformer(true, new CubeOutViewPagerTransformer());
            this.jEi.addOnPageChangeListener(this.jEK);
            this.jEi.setmDisallowSlip(true);
            this.jEi.setOnTouchEventListener(this.jEL);
            this.jEk = (OvalActionButton) this.jEc.findViewById(R.id.frs_post_forum_button);
            this.jEk.setIsCircle(true);
            this.jEk.setHasShadow(false);
            this.jmz = (FRSRefreshButton) this.jEc.findViewById(R.id.frs_refresh_forum_button);
            this.jii = (LinearLayout) this.jEc.findViewById(R.id.frs_ll_redpack);
            this.jEc.registerListener(this.jEF);
            this.jEc.registerListener(this.jEG);
            this.jEy.getHttpMessageListener().setPriority(-1);
            this.jEy.getSocketMessageListener().setPriority(-1);
            this.jEc.registerListener(this.jEz);
            this.jEB.setSelfListener(true);
            this.jEc.registerListener(this.jEB);
            this.jEA.setSelfListener(true);
            this.jEc.registerListener(this.jEA);
            this.jEc.registerListener(this.mAccountChangedListener);
            if (bundle == null) {
                this.mForumName = this.jEc.getIntent().getStringExtra("name");
                this.mFrom = this.jEc.getIntent().getStringExtra("from");
                this.jmw = this.jEc.getIntent().getIntExtra(FrsActivityConfig.FRS_GAME_DEFAULT_TAB_ID, 0);
            } else {
                this.mForumName = bundle.getString("name");
                this.mFrom = bundle.getString("from");
                this.jmw = bundle.getInt("default_tab_id", 0);
            }
            ap(bundle);
            this.jEj.notifyDataSetChanged();
            this.jEg = new ShareSuccessReplyToServerModel();
            this.jEc.registerListener(this.jEy);
            this.jEc.registerListener(this.jEw);
            this.jEc.registerListener(this.jEx);
            this.jEc.registerListener(this.jED);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.mForumName);
        bundle.putInt("default_tab_id", this.jmw);
        bundle.putString("from", this.mFrom);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap(Bundle bundle) {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.jEj != null) {
            try {
                FrsFragment frsFragment = (FrsFragment) this.jEj.KY(jEa);
                if (frsFragment == null) {
                    frsFragment = aq(bundle);
                }
                frsFragment.b(this.jEk);
                frsFragment.a(this.jmz);
                frsFragment.c(this.jii);
                if (!jEa.equals(this.jEj.zV(0))) {
                    if (jEb.equals(this.jEj.zV(0))) {
                        this.jEj.zU(0);
                    }
                    this.jEj.a(0, frsFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cIS() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.jEj != null) {
            try {
                FrsTabHostFragment frsTabHostFragment = (FrsTabHostFragment) this.jEj.KY(jEb);
                if (frsTabHostFragment == null) {
                    frsTabHostFragment = cIT();
                }
                frsTabHostFragment.b(this.jEk);
                frsTabHostFragment.b(this.jmz);
                if (!jEb.equals(this.jEj.zV(0))) {
                    if (jEa.equals(this.jEj.zV(0))) {
                        this.jEj.zU(0);
                    }
                    this.jEj.a(0, frsTabHostFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private FrsFragment aq(Bundle bundle) {
        if (this.jmu == null) {
            this.jmu = new FrsFragment();
            this.jmu.setArguments(bundle);
            this.jmu.setBaseTag(jEa);
        }
        this.jmu.jip = false;
        return this.jmu;
    }

    private FrsTabHostFragment cIT() {
        if (this.jEd == null) {
            this.jEd = new FrsTabHostFragment(this);
            this.jEd.setBaseTag(jEb);
            this.jEd.yX(this.jmw);
        }
        return this.jEd;
    }

    private FragmentManager getFragmentManager() {
        if (this.jEc != null) {
            return this.jEc.getSupportFragmentManager();
        }
        return null;
    }

    private void cIU() {
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.jmv != null && (themeColorInfo = this.jmv.getForum().getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            this.jEk.setStartAndEndColor(themeElement.light_color, themeElement.dark_color);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(m mVar, boolean z, int i) {
        if (mVar != null && mVar.getForum() != null) {
            this.jmv = mVar;
            ForumData forum = mVar.getForum();
            if (!e(mVar)) {
                if (z) {
                    a(forum, mVar.getAnti());
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921476));
            }
            if (forum.getIsShowBawuTask() && com.baidu.tbadk.core.sharedPref.b.brR().getInt("key_bawu_task_toast", 0) == 0 && !this.jEo) {
                this.jEo = true;
                com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.10
                    @Override // java.lang.Runnable
                    public void run() {
                        FrsTabController.this.cJa();
                    }
                }, 30000L);
            }
            if (mVar.bazhuExam != null && !this.jEp && z) {
                com.baidu.tieba.frs.m.a(this.jEc.getPageContext(), mVar.bazhuExam, forum.getId(), forum.getName());
                this.jEp = true;
            }
            if (y.getCount(mVar.getGameTabInfo()) > 0) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.11
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean dx = FrsTabController.this.dx(FrsTabController.this.jmv.getGameTabInfo());
                        if (dx) {
                            FrsTabController.this.jEj.notifyDataSetChanged();
                            if (dx && FrsTabController.this.jEd != null) {
                                FrsTabController.this.jEd.Y(FrsTabController.this.jmu);
                                FrsTabController.this.jEd.a(FrsTabController.this.jmv, FrsTabController.this.jmt);
                            }
                        }
                        if (FrsTabController.this.jEc.isLoadingViewAttached()) {
                            FrsTabController.this.jEc.hideLoadingView(FrsTabController.this.jEc.findViewById(16908290));
                        }
                    }
                });
            } else if (cIZ()) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.13
                    @Override // java.lang.Runnable
                    public void run() {
                        Bundle bundle;
                        FrsTabController.this.jmu.jip = true;
                        if (FrsTabController.this.jmu != null) {
                            bundle = FrsTabController.this.jmu.getArguments();
                        } else {
                            bundle = null;
                        }
                        FrsTabController.this.ap(bundle);
                        FrsTabController.this.jEj.notifyDataSetChanged();
                        if (FrsTabController.this.jEc.isLoadingViewAttached()) {
                            FrsTabController.this.jEc.hideLoadingView(FrsTabController.this.jEc.findViewById(16908290));
                        }
                    }
                });
            }
            cIU();
            cJb();
            if (z) {
                if ((!this.jEt || i == 4) && forum.isLike() == 0 && com.baidu.tbadk.a.d.bje() && TbadkCoreApplication.isLogin()) {
                    this.jEr = new com.baidu.tieba.frs.d.e();
                    this.jEc.registerListener(this.jEI);
                    this.jEc.registerListener(this.jEH);
                    this.jEc.registerListener(this.jEJ);
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
        boolean z = com.baidu.tbadk.core.sharedPref.b.brR().getBoolean("key_forum_tool_find_dialog_show", false);
        if (is_manager == 1 && !z) {
            f(1, this.jEc.getString(R.string.forum_tool_first_bazhu_content), String.valueOf(R.drawable.pic_mask_update), "");
            com.baidu.tbadk.core.sharedPref.b.brR().putBoolean("key_forum_tool_find_dialog_show", true);
            return true;
        } else if (!z && is_manager == 2) {
            f(2, this.jEc.getString(R.string.forum_tool_first_bawu_content), String.valueOf(R.drawable.pic_mask_update), "");
            com.baidu.tbadk.core.sharedPref.b.brR().putBoolean("key_forum_tool_find_dialog_show", true);
            return true;
        } else if (mVar.bawuPopInfo != null) {
            f(3, mVar.bawuPopInfo.content, mVar.bawuPopInfo.img_url, mVar.bawuPopInfo.jump_url);
            return true;
        } else {
            return false;
        }
    }

    private void f(final int i, String str, String str2, final String str3) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jEc);
        aVar.nB(2);
        aVar.jG(false);
        FrsForumToolDialogView frsForumToolDialogView = new FrsForumToolDialogView(this.jEc);
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
                    bf.bsY().b(FrsTabController.this.jEc.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/bawuteam?fn=" + FrsTabController.this.cBR().getForumName() + "&fid=" + FrsTabController.this.cBR().getForumId()});
                } else if (i == 2) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("forum_id", FrsTabController.this.cBR().getForumId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new com.baidu.tieba.tbadkCore.data.m(FrsTabController.this.jEc, OpenFlutter.ACTIVITY_FORUM_DETAIL, hashMap)));
                } else if (i == 3 && !TextUtils.isEmpty(str3)) {
                    bf.bsY().b(FrsTabController.this.jEc.getPageContext(), new String[]{str3});
                }
            }
        });
        aVar.bn(frsForumToolDialogView);
        aVar.b(this.jEc.getPageContext()).bqz();
    }

    private void a(ForumData forumData, AntiData antiData) {
        if (forumData != null && !com.baidu.tbadk.youngster.b.a.a(this.jEc.getPageContext(), antiData, R.id.frs) && !c(forumData)) {
            List<TipInfo> tipInfos = forumData.getTipInfos();
            if (!y.isEmpty(tipInfos)) {
                com.baidu.tbadk.youngster.b.a.a(this.jEc.getPageContext(), tipInfos.get(0), TbadkCoreApplication.getCurrentAccount(), forumData.getId(), this.jEc.getString(R.string.frs_risk_dialog_button_text));
            }
        }
    }

    private boolean c(ForumData forumData) {
        if (au.isEmpty(forumData.getRiskTipPop()) || au.isEmpty(forumData.getRiskTipPopTitle())) {
            return false;
        }
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jEc);
        aVar.AA(forumData.getRiskTipPopTitle());
        aVar.setTitleShowCenter(true);
        aVar.setMessageShowCenter(true);
        aVar.AB(forumData.getRiskTipPop());
        aVar.a(R.string.frs_risk_dialog_button_text, new a.b() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.16
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar.dismiss();
            }
        });
        aVar.b(this.jEc.getPageContext()).bqz();
        return true;
    }

    public m cIV() {
        return this.jmv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dx(List<FrsTabInfo> list) {
        if (this.jEc.isLoadingViewAttached()) {
            this.jEc.hideLoadingView(this.jEc.findViewById(16908290));
        }
        if (cIZ()) {
            return false;
        }
        this.jmu.jip = true;
        cIW();
        if (com.baidu.tbadk.core.sharedPref.b.brR().getBoolean("frs_game_login_tip", true)) {
            com.baidu.tbadk.core.sharedPref.b.brR().putBoolean(SharedPrefConfig.FRS_LOGIN_TIP, true);
            com.baidu.tbadk.core.sharedPref.b.brR().putBoolean("frs_game_login_tip", false);
        }
        dy(list);
        return true;
    }

    private void cIW() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021074, TbConfig.SERVER_ADDRESS + "game/forum/getNewNotify");
        tbHttpMessageTask.setResponsedClass(AlaGameTabGetNewNotifyResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.jEc.registerListener(1021074, this.jEC);
    }

    private void dy(List<FrsTabInfo> list) {
        boolean z;
        if (!y.isEmpty(list)) {
            CustomMessageListener customMessageListener = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.17
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ai)) {
                        if (!com.baidu.tbadk.core.sharedPref.b.brR().getBoolean(FrsTabController.this.jEf, true)) {
                            com.baidu.adp.lib.f.e.mA().post(FrsTabController.this.jEE);
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
                                bundle.putString("name", FrsTabController.this.jmu.getForumName());
                                bundle.putString("from", FrsTabController.this.jmu.getFrom());
                                bundle.putString("forum_id", FrsTabController.this.jmu.getForumId());
                                bundle.putInt("tab_id", 503);
                                bundle.putBoolean("can_auto_play_video", FrsTabController.this.jmv.isFrsVideoAutoPlay);
                                bundle.putBoolean("need_log", FrsTabController.this.jmv.needLog == 1);
                                bundle.putBoolean("is_brand_forum", FrsTabController.this.jmv.isBrandForum);
                                FrsViewData frsViewData = new FrsViewData();
                                frsViewData.receiveData(FrsTabController.this.jmv);
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
                        FrsTabController.this.cIS();
                    }
                }
            };
            customMessageListener.setPriority(Integer.MAX_VALUE);
            customMessageListener.setSelfListener(true);
            this.jEc.registerListener(customMessageListener);
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
            this.jmt = new ai(this.jEc.getActivity(), arrayList);
            if (cBR() != null) {
                this.jmt.setForumId(cBR().getForumId());
                this.jmt.setForumName(cBR().getForumName());
                if (cBR().cDm() != null && cBR().cDm().getForum() != null) {
                    ForumData forum = cBR().cDm().getForum();
                    this.jmt.setForumGameLabel(forum.getForumGameLabel());
                    this.jmt.Iw(forum.getSpecialForumType());
                }
            }
            this.jmu.jip = false;
            new e(this.jmu).a(this.jmt);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB, this.jmt);
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB);
            customMessage.setTag(this.jEc.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cIX() {
        if (this.jmt != null && !TextUtils.isEmpty(this.jmt.getForumId())) {
            HttpMessage httpMessage = new HttpMessage(1021074);
            httpMessage.addParam("forum_id", this.jmv.getForum().getId());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    private void a(Fragment fragment, int i) {
        NavigationBar bVq;
        if ((fragment instanceof ap) && this.jmv != null && this.jmv.getForum() != null && (bVq = ((ap) fragment).bVq()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.jmv.getForum().getName(), 5, true, true) + this.jEc.getActivity().getString(R.string.forum));
            bVq.setCenterTextTitle(sb.toString());
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.jmu instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.jmu.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a sO(int i) {
        if (this.jmu instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.jmu.sO(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.jmu instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.jmu.a(bVar);
        }
    }

    public void onNewIntent(Intent intent) {
        if (this.jmu != null) {
            this.jmu.onNewIntent(intent);
        }
    }

    public void onResume() {
        if (!cIZ()) {
            this.jmu.setPrimary(true);
        } else if (this.jEd != null) {
            Fragment currentFragment = this.jEd.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(true);
            }
        }
        if (this.jEh) {
            this.jEh = false;
            if (this.jmu != null) {
                this.jmu.refresh();
            }
        }
        if (this.jmv != null && this.jmv.getUserData() != null && this.jmv.getUserData().getNewGodData() != null) {
            if (this.jmv.getForum() != null) {
                x.bFG().setFid(this.jmv.getForum().getId());
            }
            x.bFG().b(2, this.jmv.getUserData().getNewGodData());
        }
        this.jEv = true;
        if (this.jEu) {
            e((ForumData) null);
        }
    }

    public void onPause() {
        this.jEv = false;
        if (this.jEr != null) {
            this.jEr.cKO();
        }
        if (!cIZ()) {
            this.jmu.setPrimary(false);
        } else if (this.jEd != null) {
            Fragment currentFragment = this.jEd.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(false);
            }
        }
        x.bFG().removeCallbacks();
    }

    public void onChangeSkinType(int i) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 1 || skinType == 4) {
            UtilHelper.changeStatusBarIconAndTextColor(true, this.jEc);
        } else {
            UtilHelper.changeStatusBarIconAndTextColor(false, this.jEc);
        }
        if (this.jmu != null) {
            this.jmu.onChangeSkinType(i);
        }
        if (this.jEd != null) {
            this.jEd.onChangeSkinType(i);
        }
        cIU();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (cIZ() && this.jEd != null && this.jEd.cEs()) {
                this.jEd.cEK();
                UtilHelper.setNavigationBarBackground(this.jEc, this.jEd.cEF());
            } else if (this.jmu != null && this.jmu.isAdded()) {
                if (this.jmu.onKeyDown(i, keyEvent)) {
                    return true;
                }
                cIY();
            } else {
                return this.jEc.b(i, keyEvent);
            }
        } else if (i == 24) {
            if (this.jmu != null && this.jmu.isAdded()) {
                return this.jmu.onKeyDown(i, keyEvent);
            }
        } else {
            return this.jEc.b(i, keyEvent);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cIY() {
        if (this.jmx != this.jmw && cIZ()) {
            this.jEd.setCurrentTab(this.jmw);
            if (yV(this.jmw) != 1) {
                this.jmu.qz(false);
            }
            this.jmx = this.jmw;
            a(this.jEd.getCurrentFragment(), this.jmw);
            return;
        }
        this.jmu.closeActivity();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!cIZ()) {
            this.jmu.onActivityResult(i, i2, intent);
        } else if (this.jEd != null) {
            if (1 == this.jEd.getCurrentTabType()) {
                this.jmu.onActivityResult(i, i2, intent);
            } else {
                Fragment currentFragment = this.jEd.getCurrentFragment();
                if (currentFragment != null) {
                    currentFragment.onActivityResult(i, i2, intent);
                }
            }
        }
        if (i2 == -1) {
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1) {
                    com.baidu.tieba.o.a.dDg().I(this.jEc.getPageContext());
                    ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.linkUrl != null && this.jEg != null) {
                        this.jEg.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.18
                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void byI() {
                            }

                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void a(final CustomDialogData customDialogData) {
                                com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.18.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (FrsTabController.this.jEc != null) {
                                            com.baidu.tieba.pb.interactionpopupwindow.c.a(FrsTabController.this.jEc.getPageContext(), customDialogData).show();
                                        }
                                    }
                                }, 1000L);
                            }
                        });
                    }
                }
            } else if (i == 13011) {
                com.baidu.tieba.o.a.dDg().I(this.jEc.getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (!cIZ()) {
            return this.jmu.getVoiceManager();
        }
        if (this.jEd == null) {
            return null;
        }
        Fragment currentFragment = this.jEd.getCurrentFragment();
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
    public int yT(int i) {
        if (this.jmt == null) {
            return -1;
        }
        int count = y.getCount(this.jmt.bAV());
        for (int i2 = 0; i2 < count; i2++) {
            if (this.jmt.bAV().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int yV(int i) {
        if (this.jmt != null && i < y.getCount(this.jmt.bAV())) {
            return this.jmt.bAV().get(i).tab_id.intValue();
        }
        return -1;
    }

    public FrsFragment cBR() {
        return this.jmu;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> cBS() {
        if (!cIZ()) {
            if (this.jmu instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) this.jmu).cBS();
            }
        } else if (this.jEd == null) {
            return null;
        } else {
            Fragment currentFragment = this.jEd.getCurrentFragment();
            if (currentFragment instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) currentFragment).cBS();
            }
        }
        return null;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(FrsNoListItemViewHolder.jlE);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.jEc.isLoadingViewAttached()) {
            this.jEc.hideLoadingView(this.jEc.findViewById(16908290));
        }
        if (this.jEE != null) {
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.jEE);
        }
        com.baidu.tbadk.core.sharedPref.b.brR().putBoolean(this.jEf, false);
        if (this.jEg != null) {
            this.jEg.cancelLoadData();
        }
        if (this.jmu != null && this.jmu.cCC() != null) {
            this.jmu.cCC().cJm();
        }
        if (this.jEn != null) {
            this.jEn.onDestroy();
        }
        if (FrsActivityConfig.FRS_FROM_FLUTTER_BCASTEDIT.equals(this.mFrom)) {
            new p(TbadkCoreApplication.getInst()).bsk();
        }
        if (FrsActivityConfig.FRS_FROM_FORUM_RULE_EDIT.equals(this.mFrom)) {
            com.baidu.tbadk.k.d.bCE().ld(false);
        }
        if (this.jEs != null) {
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.jEs);
        }
        if (this.jmv != null && this.jmv.getForum() != null && this.jEr != null) {
            this.jEr.gx(com.baidu.adp.lib.f.b.toLong(this.jmv.getForum().getId(), 0L));
        }
    }

    public FragmentTabHost cEI() {
        if (this.jEd == null) {
            return null;
        }
        return this.jEd.cEI();
    }

    public boolean cIZ() {
        if (this.jEj == null) {
            return false;
        }
        return this.jEj.getItem(0) instanceof FrsTabHostFragment;
    }

    public void yX(int i) {
        this.jmw = i;
    }

    public void zS(int i) {
        this.jmx = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJa() {
        if (this.jEc != null) {
            if (this.jEn == null) {
                this.jEn = (NavigationBarCoverTip) this.jEc.findViewById(R.id.navigation_cover_tip);
            }
            if (this.jEn != null) {
                View inflate = View.inflate(this.jEc, R.layout.write_thread_share_guide, null);
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
                cVar.bvb();
                tBSpecificationBtn.setConfig(cVar);
                tBSpecificationBtn.bus();
                com.baidu.tbadk.core.util.ap.setViewTextColor(textView, R.color.CAM_X0101);
                com.baidu.tbadk.core.util.ap.setBackgroundColor(this.jEn, R.color.cp_link_tip_a_alpha95);
                tBSpecificationBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.19
                    /* JADX DEBUG: Multi-variable search result rejected for r4v9, resolved type: com.baidu.tieba.frs.FrsActivity */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        new ar("c13439").bsR();
                        if (FrsTabController.this.cBR() != null && !TextUtils.isEmpty(FrsTabController.this.cBR().getForumId()) && !TextUtils.isEmpty(FrsTabController.this.mForumName) && FrsTabController.this.jEc != null) {
                            if (FrsTabController.this.jEn != null) {
                                FrsTabController.this.jEn.hideTip();
                            }
                            bf.bsY().b(FrsTabController.this.jEc.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/bawutask?fid=" + FrsTabController.this.cBR().getForumId() + "&fn=" + FrsTabController.this.mForumName + "&noread=" + (com.baidu.tbadk.core.sharedPref.b.brR().getInt("key_bawu_task_toast", 0) == -1 ? 1 : 0)});
                        }
                    }
                });
                this.jEn.a(this.jEc, inflate, 30000);
                new ar("c13438").bsR();
                int i = com.baidu.tbadk.core.sharedPref.b.brR().getInt("key_bawu_task_toast", 0);
                if (i >= 0) {
                    com.baidu.tbadk.core.sharedPref.b.brR().putInt("key_bawu_task_toast", i + 1);
                }
            }
        }
    }

    private void cJb() {
        boolean z;
        if (this.jmv != null && this.jmv.getEntelechyTabInfo() != null && this.jmv.getEntelechyTabInfo().tab != null) {
            Iterator<FrsTabInfo> it = this.jmv.getEntelechyTabInfo().tab.iterator();
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
                if (this.jEq == null) {
                    this.jEq = new com.baidu.tieba.c.e(this.jEc.getPageContext(), this.jEk);
                    this.jEq.eo(R.drawable.pic_sign_tip_down);
                    this.jEq.xi(2);
                    this.jEq.setUseDirectOffset(true);
                    this.jEq.xm(-l.getDimens(this.jEc, R.dimen.tbds20));
                    this.jEq.setYOffset(-l.getDimens(this.jEc, R.dimen.tbds20));
                    this.jEq.setTextColor(R.color.CAM_X0101);
                    this.jEq.setHeight(R.dimen.tbds54);
                    this.jEq.xk(l.getDimens(this.jEc, R.dimen.tbds44));
                }
                this.jEq.aJ(this.jEc.getString(R.string.frs_evaluate_tip), "first_into_frs_with_evaluate_tab");
            }
        }
    }

    private void d(final ForumData forumData) {
        boolean z = false;
        if (i(forumData.getName(), forumData.getId(), forumData.getImage_url(), false)) {
            if (this.jEs != null) {
                com.baidu.adp.lib.f.e.mA().removeCallbacks(this.jEs);
            }
            z = true;
        }
        if (!this.jEt) {
            this.jEr.cKN().k(TbadkCoreApplication.getCurrentAccount(), forumData.getId(), System.currentTimeMillis());
            this.jEt = true;
        }
        if (!z) {
            this.jEs = this.jEs != null ? this.jEs : new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.20
                @Override // java.lang.Runnable
                public void run() {
                    if (FrsTabController.this.jEr != null) {
                        if (FrsTabController.this.jEv) {
                            FrsTabController.this.i(forumData.getName(), forumData.getId(), forumData.getImage_url(), true);
                        } else {
                            FrsTabController.this.jEu = true;
                        }
                    }
                }
            };
            com.baidu.adp.lib.f.e.mA().postDelayed(this.jEs, AppStatusRules.DEFAULT_GRANULARITY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ForumData forumData) {
        if (this.jmu.cCE() != null && this.jEr != null) {
            if (forumData == null) {
                forumData = this.jmv.getForum();
            }
            if (forumData != null && forumData.isLike() != 1) {
                if (!this.jEv) {
                    this.jEu = true;
                } else if (i(forumData.getName(), forumData.getId(), forumData.getImage_url(), false) && this.jEs != null) {
                    com.baidu.adp.lib.f.e.mA().removeCallbacks(this.jEs);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i(String str, String str2, String str3, boolean z) {
        if (!this.jEr.ff(TbadkCoreApplication.getCurrentAccount(), str2) || this.jmu == null || this.jmu.cCE() == null) {
            return false;
        }
        this.jEu = false;
        this.jEr.a(this.jEc, str, str2, str3, this.jmu.cCE().cLH());
        this.jEr.cKN().e(TbadkCoreApplication.getCurrentAccount(), str2, System.currentTimeMillis(), z);
        return true;
    }

    public boolean gv(long j) {
        ForumData forum;
        return (this.jmv == null || j == 0 || (forum = this.jmv.getForum()) == null || com.baidu.adp.lib.f.b.toLong(forum.getId(), 0L) != j) ? false : true;
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
        /* renamed from: zT */
        public BaseFragment getItem(int i) {
            return (BaseFragment) y.getItem(this.mFragments, i);
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
            return y.add(this.mFragments, i, baseFragment);
        }

        public BaseFragment KY(String str) {
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

        public BaseFragment zU(int i) {
            return (BaseFragment) y.remove(this.mFragments, i);
        }

        public String zV(int i) {
            if (getItem(i) != null) {
                return getItem(i).getBaseTag();
            }
            return null;
        }
    }

    public TbPageTag getTbPageTag() {
        if (!cIZ()) {
            return this.jmu.getTbPageTag();
        }
        if (this.jEd != null) {
            if (1 == this.jEd.getCurrentTabType()) {
                return this.jmu.getTbPageTag();
            }
            Fragment currentFragment = this.jEd.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                return ((BaseFragment) currentFragment).getTbPageTag();
            }
        }
        return null;
    }

    public void onScreenShot(String str) {
        if (this.jmv != null && this.jmv.getForum() != null) {
            TiebaStatic.log(new ar("c13848").dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fid", this.jmv.getForum().getId()).aq("obj_type", 2));
        }
    }
}
