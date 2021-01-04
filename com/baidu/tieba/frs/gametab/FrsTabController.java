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
    public static final String jBd = FrsFragment.class.getSimpleName();
    public static final String jBe = FrsTabHostFragment.class.getSimpleName();
    private FrsActivity jBf;
    private FrsTabHostFragment jBg;
    private ShareSuccessReplyToServerModel jBj;
    private FrsBaseViewPager jBl;
    private FragmentAdapter jBm;
    private OvalActionButton jBn;
    private boolean jBo;
    private boolean jBp;
    private NavigationBarCoverTip jBq;
    private com.baidu.tieba.c.e jBt;
    private com.baidu.tieba.frs.d.e jBu;
    private Runnable jBv;
    private boolean jBw;
    private LinearLayout jfl;
    private int jjA;
    private FRSRefreshButton jjC;
    private ai jjw;
    private FrsFragment jjx;
    private m jjy;
    private String mForumName;
    private String mFrom;
    private boolean jBh = false;
    private final Handler mHandler = new Handler();
    private int jjz = 0;
    private boolean jBk = false;
    private boolean jBr = false;
    private boolean jBs = false;
    private boolean jBx = false;
    private boolean jBy = false;
    private HttpMessageListener jBz = new HttpMessageListener(CmdConfigHttp.CMD_FRS_RECOMMEND) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof FrsRecommendResMsg) {
                if (httpResponsedMessage.getError() != 0) {
                    new BdTopToast(FrsTabController.this.jBf).yW(false).UY(httpResponsedMessage.getErrorString()).aR((ViewGroup) FrsTabController.this.jBf.findViewById(R.id.frs));
                    return;
                }
                int pushStatus = ((FrsRecommendResMsg) httpResponsedMessage).getPushStatus();
                String pushMsg = ((FrsRecommendResMsg) httpResponsedMessage).getPushMsg();
                if (pushStatus == 1) {
                    new ScreenTopToast(FrsTabController.this.jBf).Vc(FrsTabController.this.jBf.getString(R.string.frs_recommend_suc_tip_title)).Vd(FrsTabController.this.jBf.getString(R.string.frs_recommend_suc_tip_content)).Ve(FrsTabController.this.jBf.getString(R.string.dialog_confirm_see)).an(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.1.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("_forumId", FrsTabController.this.jjy.getForum().getId());
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new com.baidu.tieba.tbadkCore.data.m(FrsTabController.this.jBf, "RecommendHistoryPage", hashMap)));
                        }
                    }).aR((ViewGroup) FrsTabController.this.jBf.findViewById(R.id.frs));
                } else {
                    new BdTopToast(FrsTabController.this.jBf).yW(false).UY(pushMsg).aR((ViewGroup) FrsTabController.this.jBf.findViewById(R.id.frs));
                }
            }
        }
    };
    private CustomMessageListener jBA = new CustomMessageListener(2921465) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            new ScreenTopToast(FrsTabController.this.jBf).Vc(FrsTabController.this.jBf.getString(R.string.frs_recommend_fail_month_tip)).Ve(FrsTabController.this.jBf.getString(R.string.frs_recommend_fail_tip_btn)).an(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.12.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("_forumId", FrsTabController.this.jjy.getForum().getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new com.baidu.tieba.tbadkCore.data.m(FrsTabController.this.jBf, "ForumGradePage", hashMap)));
                }
            }).aR((ViewGroup) FrsTabController.this.jBf.findViewById(R.id.frs));
        }
    };
    private com.baidu.adp.framework.listener.a jBB = new com.baidu.adp.framework.listener.a(1001703, CmdConfigSocket.CMD_FRS_PAGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.21
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            m mVar = null;
            int i = -1;
            if (!FrsTabController.this.jBh && !responsedMessage.hasError() && responsedMessage.getError() == 0) {
                if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                    mVar = ((FrsPageHttpResponseMessage) responsedMessage).getResponseData();
                    i = ((FrsPageHttpResponseMessage) responsedMessage).getUpdateType();
                } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                    mVar = ((FRSPageSocketResponsedMessage) responsedMessage).getResponseData();
                    i = ((FRSPageSocketResponsedMessage) responsedMessage).getUpdateType();
                }
                if (mVar != null) {
                    FrsTabController.this.jBh = true;
                    FrsTabController.this.a(mVar, true, i);
                    if (mVar != null && mVar.getForum() != null && !StringUtils.isNull(mVar.getForum().getId())) {
                        com.baidu.tbadk.core.business.b.boI().dJ("2", mVar.getForum().getId());
                    }
                }
                if (mVar != null && mVar.getUserData() != null && mVar.getUserData().getNewGodData() != null) {
                    if (mVar.getForum() != null) {
                        v.bJa().setFid(mVar.getForum().getId());
                    }
                    v.bJa().b(2, mVar.getUserData().getNewGodData());
                }
            }
        }
    };
    private CustomMessageListener jBC = new CustomMessageListener(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!FrsTabController.this.jBh && FrsTabController.this.jjy == null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof m)) {
                m mVar = (m) customResponsedMessage.getData();
                if (mVar.getForum() != null && FrsTabController.this.mForumName != null && FrsTabController.this.mForumName.equals(mVar.getForum().getName())) {
                    FrsTabController.this.a(mVar, false, -1);
                }
            }
        }
    };
    private CustomMessageListener jBD = new CustomMessageListener(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsTabController.this.cLp();
        }
    };
    private CustomMessageListener jBE = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int Ao;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (10001 == intValue) {
                    Ao = FrsTabController.this.Ao(9);
                    if (Ao == -1) {
                        Ao = FrsTabController.this.Ao(2);
                    }
                } else {
                    Ao = FrsTabController.this.Ao(intValue);
                }
                if (Ao != -1 && FrsTabController.this.cLq() && FrsTabController.this.jBg != null) {
                    FrsTabController.this.jBg.setCurrentTab(Ao);
                    if (FrsTabController.this.Aq(Ao) != 1) {
                        FrsTabController.this.jjx.qt(false);
                    }
                }
            }
        }
    };
    private HttpMessageListener jBF = new HttpMessageListener(0) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && 1021074 == httpResponsedMessage.getCmd() && (httpResponsedMessage instanceof AlaGameTabGetNewNotifyResponsedMessage)) {
                List<a> newNotifyData = ((AlaGameTabGetNewNotifyResponsedMessage) httpResponsedMessage).getNewNotifyData();
                if (!x.isEmpty(newNotifyData) && FrsTabController.this.jBg != null) {
                    for (a aVar : newNotifyData) {
                        if (aVar != null) {
                            for (int i = 0; i < FrsTabController.this.jjw.bEt().size(); i++) {
                                FragmentTabHost.b pV = FrsTabController.this.jBg.pV(i);
                                if (pV != null && pV.mType != 1 && pV.mType != FrsTabController.this.jBg.getCurrentTabType() && pV.mType == aVar.getTabId() && aVar.cLe() && pV.fbC.Ei(String.valueOf(pV.mType)) != null) {
                                    pV.fbC.Ei(String.valueOf(pV.mType)).view.setVisibility(0);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener jBG = new CustomMessageListener(2921518) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            new BdTopToast(FrsTabController.this.jBf, 2000).yW(false).UY(FrsTabController.this.jBf.getString(R.string.frs_top_forum_rules_click_toast)).aR((ViewGroup) FrsTabController.this.jBf.findViewById(R.id.frs));
        }
    };
    private Runnable jBH = new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.27
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.adp.lib.f.e.mB().removeCallbacks(this);
            FrsTabController.this.cLo();
            com.baidu.adp.lib.f.e.mB().postDelayed(this, 30000L);
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                FrsTabController.this.jBk = true;
            }
        }
    };
    private CustomMessageListener jBI = new CustomMessageListener(2921369) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.jBl != null && FrsTabController.this.jBm != null && (customResponsedMessage.getData() instanceof FrsTabViewPager.a)) {
                FrsTabViewPager.a aVar = (FrsTabViewPager.a) customResponsedMessage.getData();
                FrsTabController.this.jBo = aVar.cHh();
                FrsTabController.this.jBp = aVar.cHi();
            }
        }
    };
    private CustomMessageListener jBJ = new CustomMessageListener(2921370) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.jBl != null && FrsTabController.this.jBm != null && (customResponsedMessage.getData() instanceof Boolean)) {
                FrsTabController.this.jBl.setForceIntercept(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };
    private CustomMessageListener jBK = new CustomMessageListener(CmdConfigCustom.CMD_NEW_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                FrsTabController.this.e((ForumData) null);
            }
        }
    };
    private CustomMessageListener jBL = new CustomMessageListener(2921498) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsTabController.this.jBu != null && customResponsedMessage != null && customResponsedMessage.getData() != null) {
                if (customResponsedMessage.getData() instanceof ForumData) {
                    FrsTabController.this.e((ForumData) customResponsedMessage.getData());
                } else if (customResponsedMessage.getData() instanceof Long) {
                    long longValue = ((Long) customResponsedMessage.getData()).longValue();
                    if (FrsTabController.this.gq(longValue) && FrsTabController.this.jBu.gr(longValue) >= 3) {
                        FrsTabController.this.jBu.gs(longValue);
                        FrsTabController.this.jBx = true;
                    }
                }
            }
        }
    };
    private CustomMessageListener jBM = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.e)) {
                com.baidu.tieba.tbadkCore.writeModel.e eVar = (com.baidu.tieba.tbadkCore.writeModel.e) customResponsedMessage.getData();
                if (FrsTabController.this.jBu != null && eVar != null && TbadkCoreApplication.isLogin()) {
                    FrsTabController.this.jBu.ff(TbadkCoreApplication.getCurrentAccount(), String.valueOf(eVar.forumId));
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener jBN = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.8
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i != 1) {
                FrsTabController.this.jBn.setVisibility(0);
                if (FrsTabController.this.cEk() != null) {
                    FrsTabController.this.cEk().qn(false);
                }
                FrsTabController.this.jjx.cFD();
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            switch (i) {
                case 0:
                    FrsTabController.this.jBp = false;
                    FrsTabController.this.jBl.setForceIntercept(false);
                    return;
                default:
                    return;
            }
        }
    };
    private FrsBaseViewPager.a jBO = new FrsBaseViewPager.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.9
        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public void cEG() {
            if (FrsTabController.this.jBl != null) {
                if (FrsTabController.this.jBl.getCurrentItem() == 0) {
                    FrsTabController.this.jBl.setmDisallowSlip(true);
                } else {
                    FrsTabController.this.jBl.setmDisallowSlip(false);
                }
            }
        }

        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public boolean cEH() {
            if (FrsTabController.this.jBl.getCurrentItem() == 0) {
                if (FrsTabController.this.jBo && FrsTabController.this.jBp) {
                    FrsTabController.this.jBl.setmDisallowSlip(false);
                }
                if (!FrsTabController.this.jBp) {
                    FrsTabController.this.jBl.setmDisallowSlip(true);
                }
                FrsTabController.this.jBl.setmDisallowSlip(true);
            } else {
                FrsTabController.this.jBl.setmDisallowSlip(true);
            }
            return true;
        }
    };
    private String jBi = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.SHOW_GAME_FOREM_TAB_HOT_POINT);

    public FrsTabController(FrsActivity frsActivity) {
        this.jBf = frsActivity;
    }

    public void init(Bundle bundle) {
        if (this.jBf != null) {
            this.jBf.setContentView(R.layout.frs_base_layout);
            this.jBl = (FrsBaseViewPager) this.jBf.findViewById(R.id.frs_base_viewpager);
            this.jBm = new FragmentAdapter(this.jBf.getSupportFragmentManager());
            this.jBl.setAdapter(this.jBm);
            this.jBl.setPageTransformer(true, new CubeOutViewPagerTransformer());
            this.jBl.addOnPageChangeListener(this.jBN);
            this.jBl.setmDisallowSlip(true);
            this.jBl.setOnTouchEventListener(this.jBO);
            this.jBn = (OvalActionButton) this.jBf.findViewById(R.id.frs_post_forum_button);
            this.jBn.setIsCircle(true);
            this.jBn.setHasShadow(false);
            this.jjC = (FRSRefreshButton) this.jBf.findViewById(R.id.frs_refresh_forum_button);
            this.jfl = (LinearLayout) this.jBf.findViewById(R.id.frs_ll_redpack);
            this.jBf.registerListener(this.jBI);
            this.jBf.registerListener(this.jBJ);
            this.jBB.getHttpMessageListener().setPriority(-1);
            this.jBB.getSocketMessageListener().setPriority(-1);
            this.jBf.registerListener(this.jBC);
            this.jBE.setSelfListener(true);
            this.jBf.registerListener(this.jBE);
            this.jBD.setSelfListener(true);
            this.jBf.registerListener(this.jBD);
            this.jBf.registerListener(this.mAccountChangedListener);
            if (bundle == null) {
                this.mForumName = this.jBf.getIntent().getStringExtra("name");
                this.mFrom = this.jBf.getIntent().getStringExtra("from");
                this.jjz = this.jBf.getIntent().getIntExtra(FrsActivityConfig.FRS_GAME_DEFAULT_TAB_ID, 0);
            } else {
                this.mForumName = bundle.getString("name");
                this.mFrom = bundle.getString("from");
                this.jjz = bundle.getInt("default_tab_id", 0);
            }
            ap(bundle);
            this.jBm.notifyDataSetChanged();
            this.jBj = new ShareSuccessReplyToServerModel();
            this.jBf.registerListener(this.jBB);
            this.jBf.registerListener(this.jBz);
            this.jBf.registerListener(this.jBA);
            this.jBf.registerListener(this.jBG);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.mForumName);
        bundle.putInt("default_tab_id", this.jjz);
        bundle.putString("from", this.mFrom);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap(Bundle bundle) {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.jBm != null) {
            try {
                FrsFragment frsFragment = (FrsFragment) this.jBm.Lo(jBd);
                if (frsFragment == null) {
                    frsFragment = aq(bundle);
                }
                frsFragment.b(this.jBn);
                frsFragment.a(this.jjC);
                frsFragment.c(this.jfl);
                if (!jBd.equals(this.jBm.Bq(0))) {
                    if (jBe.equals(this.jBm.Bq(0))) {
                        this.jBm.Bp(0);
                    }
                    this.jBm.a(0, frsFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLj() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.jBm != null) {
            try {
                FrsTabHostFragment frsTabHostFragment = (FrsTabHostFragment) this.jBm.Lo(jBe);
                if (frsTabHostFragment == null) {
                    frsTabHostFragment = cLk();
                }
                frsTabHostFragment.b(this.jBn);
                frsTabHostFragment.b(this.jjC);
                if (!jBe.equals(this.jBm.Bq(0))) {
                    if (jBd.equals(this.jBm.Bq(0))) {
                        this.jBm.Bp(0);
                    }
                    this.jBm.a(0, frsTabHostFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private FrsFragment aq(Bundle bundle) {
        if (this.jjx == null) {
            this.jjx = new FrsFragment();
            this.jjx.setArguments(bundle);
            this.jjx.setBaseTag(jBd);
        }
        this.jjx.jfs = false;
        return this.jjx;
    }

    private FrsTabHostFragment cLk() {
        if (this.jBg == null) {
            this.jBg = new FrsTabHostFragment(this);
            this.jBg.setBaseTag(jBe);
            this.jBg.As(this.jjz);
        }
        return this.jBg;
    }

    private FragmentManager getFragmentManager() {
        if (this.jBf != null) {
            return this.jBf.getSupportFragmentManager();
        }
        return null;
    }

    private void cLl() {
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.jjy != null && (themeColorInfo = this.jjy.getForum().getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            this.jBn.setStartAndEndColor(themeElement.light_color, themeElement.dark_color);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(m mVar, boolean z, int i) {
        if (mVar != null && mVar.getForum() != null) {
            this.jjy = mVar;
            ForumData forum = mVar.getForum();
            if (!e(mVar)) {
                if (z) {
                    a(forum, mVar.getAnti());
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921476));
            }
            if (forum.getIsShowBawuTask() && com.baidu.tbadk.core.sharedPref.b.bvq().getInt("key_bawu_task_toast", 0) == 0 && !this.jBr) {
                this.jBr = true;
                com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.10
                    @Override // java.lang.Runnable
                    public void run() {
                        FrsTabController.this.cLr();
                    }
                }, 30000L);
            }
            if (mVar.bazhuExam != null && !this.jBs && z) {
                com.baidu.tieba.frs.m.a(this.jBf.getPageContext(), mVar.bazhuExam, forum.getId(), forum.getName());
                this.jBs = true;
            }
            if (x.getCount(mVar.getGameTabInfo()) > 0) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.11
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean dC = FrsTabController.this.dC(FrsTabController.this.jjy.getGameTabInfo());
                        if (dC) {
                            FrsTabController.this.jBm.notifyDataSetChanged();
                            if (dC && FrsTabController.this.jBg != null) {
                                FrsTabController.this.jBg.Y(FrsTabController.this.jjx);
                                FrsTabController.this.jBg.a(FrsTabController.this.jjy, FrsTabController.this.jjw);
                            }
                        }
                        if (FrsTabController.this.jBf.isLoadingViewAttached()) {
                            FrsTabController.this.jBf.hideLoadingView(FrsTabController.this.jBf.findViewById(16908290));
                        }
                    }
                });
            } else if (cLq()) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.13
                    @Override // java.lang.Runnable
                    public void run() {
                        Bundle bundle;
                        FrsTabController.this.jjx.jfs = true;
                        if (FrsTabController.this.jjx != null) {
                            bundle = FrsTabController.this.jjx.getArguments();
                        } else {
                            bundle = null;
                        }
                        FrsTabController.this.ap(bundle);
                        FrsTabController.this.jBm.notifyDataSetChanged();
                        if (FrsTabController.this.jBf.isLoadingViewAttached()) {
                            FrsTabController.this.jBf.hideLoadingView(FrsTabController.this.jBf.findViewById(16908290));
                        }
                    }
                });
            }
            cLl();
            cLs();
            if (z) {
                if ((!this.jBw || i == 4) && forum.isLike() == 0 && com.baidu.tbadk.a.d.bmJ() && TbadkCoreApplication.isLogin()) {
                    this.jBu = new com.baidu.tieba.frs.d.e();
                    this.jBf.registerListener(this.jBL);
                    this.jBf.registerListener(this.jBK);
                    this.jBf.registerListener(this.jBM);
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
        boolean z = com.baidu.tbadk.core.sharedPref.b.bvq().getBoolean("key_forum_tool_find_dialog_show", false);
        if (is_manager == 1 && !z) {
            f(1, this.jBf.getString(R.string.forum_tool_first_bazhu_content), String.valueOf(R.drawable.pic_mask_update), "");
            com.baidu.tbadk.core.sharedPref.b.bvq().putBoolean("key_forum_tool_find_dialog_show", true);
            return true;
        } else if (!z && is_manager == 2) {
            f(2, this.jBf.getString(R.string.forum_tool_first_bawu_content), String.valueOf(R.drawable.pic_mask_update), "");
            com.baidu.tbadk.core.sharedPref.b.bvq().putBoolean("key_forum_tool_find_dialog_show", true);
            return true;
        } else if (mVar.bawuPopInfo != null) {
            f(3, mVar.bawuPopInfo.content, mVar.bawuPopInfo.img_url, mVar.bawuPopInfo.jump_url);
            return true;
        } else {
            return false;
        }
    }

    private void f(final int i, String str, String str2, final String str3) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jBf);
        aVar.pd(2);
        aVar.jI(false);
        FrsForumToolDialogView frsForumToolDialogView = new FrsForumToolDialogView(this.jBf);
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
                    be.bwu().b(FrsTabController.this.jBf.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/bawuteam?fn=" + FrsTabController.this.cEk().getForumName() + "&fid=" + FrsTabController.this.cEk().getForumId()});
                } else if (i == 2) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("forum_id", FrsTabController.this.cEk().getForumId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new com.baidu.tieba.tbadkCore.data.m(FrsTabController.this.jBf, OpenFlutter.ACTIVITY_FORUM_DETAIL, hashMap)));
                } else if (i == 3 && !TextUtils.isEmpty(str3)) {
                    be.bwu().b(FrsTabController.this.jBf.getPageContext(), new String[]{str3});
                }
            }
        });
        aVar.br(frsForumToolDialogView);
        aVar.b(this.jBf.getPageContext()).btX();
    }

    private void a(ForumData forumData, AntiData antiData) {
        if (forumData != null && !com.baidu.tbadk.youngster.b.a.a(this.jBf.getPageContext(), antiData, R.id.frs) && !c(forumData)) {
            List<TipInfo> tipInfos = forumData.getTipInfos();
            if (!x.isEmpty(tipInfos)) {
                com.baidu.tbadk.youngster.b.a.a(this.jBf.getPageContext(), tipInfos.get(0), TbadkCoreApplication.getCurrentAccount(), forumData.getId(), this.jBf.getString(R.string.frs_risk_dialog_button_text));
            }
        }
    }

    private boolean c(ForumData forumData) {
        if (at.isEmpty(forumData.getRiskTipPop()) || at.isEmpty(forumData.getRiskTipPopTitle())) {
            return false;
        }
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jBf);
        aVar.Bo(forumData.getRiskTipPopTitle());
        aVar.setTitleShowCenter(true);
        aVar.setMessageShowCenter(true);
        aVar.Bp(forumData.getRiskTipPop());
        aVar.a(R.string.frs_risk_dialog_button_text, new a.b() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.16
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar.dismiss();
            }
        });
        aVar.b(this.jBf.getPageContext()).btX();
        return true;
    }

    public m cLm() {
        return this.jjy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dC(List<FrsTabInfo> list) {
        if (this.jBf.isLoadingViewAttached()) {
            this.jBf.hideLoadingView(this.jBf.findViewById(16908290));
        }
        if (cLq()) {
            return false;
        }
        this.jjx.jfs = true;
        cLn();
        if (com.baidu.tbadk.core.sharedPref.b.bvq().getBoolean("frs_game_login_tip", true)) {
            com.baidu.tbadk.core.sharedPref.b.bvq().putBoolean(SharedPrefConfig.FRS_LOGIN_TIP, true);
            com.baidu.tbadk.core.sharedPref.b.bvq().putBoolean("frs_game_login_tip", false);
        }
        dD(list);
        return true;
    }

    private void cLn() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021074, TbConfig.SERVER_ADDRESS + "game/forum/getNewNotify");
        tbHttpMessageTask.setResponsedClass(AlaGameTabGetNewNotifyResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.jBf.registerListener(1021074, this.jBF);
    }

    private void dD(List<FrsTabInfo> list) {
        boolean z;
        if (!x.isEmpty(list)) {
            CustomMessageListener customMessageListener = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.17
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ai)) {
                        if (!com.baidu.tbadk.core.sharedPref.b.bvq().getBoolean(FrsTabController.this.jBi, true)) {
                            com.baidu.adp.lib.f.e.mB().post(FrsTabController.this.jBH);
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
                                bundle.putString("name", FrsTabController.this.jjx.getForumName());
                                bundle.putString("from", FrsTabController.this.jjx.getFrom());
                                bundle.putString("forum_id", FrsTabController.this.jjx.getForumId());
                                bundle.putInt("tab_id", 503);
                                bundle.putBoolean("can_auto_play_video", FrsTabController.this.jjy.isFrsVideoAutoPlay);
                                bundle.putBoolean("need_log", FrsTabController.this.jjy.needLog == 1);
                                bundle.putBoolean("is_brand_forum", FrsTabController.this.jjy.isBrandForum);
                                FrsViewData frsViewData = new FrsViewData();
                                frsViewData.receiveData(FrsTabController.this.jjy);
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
                        FrsTabController.this.cLj();
                    }
                }
            };
            customMessageListener.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            customMessageListener.setSelfListener(true);
            this.jBf.registerListener(customMessageListener);
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
            this.jjw = new ai(this.jBf.getActivity(), arrayList);
            if (cEk() != null) {
                this.jjw.setForumId(cEk().getForumId());
                this.jjw.setForumName(cEk().getForumName());
                if (cEk().cFE() != null && cEk().cFE().getForum() != null) {
                    ForumData forum = cEk().cFE().getForum();
                    this.jjw.setForumGameLabel(forum.getForumGameLabel());
                    this.jjw.IU(forum.getSpecialForumType());
                }
            }
            this.jjx.jfs = false;
            new e(this.jjx).a(this.jjw);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB, this.jjw);
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB);
            customMessage.setTag(this.jBf.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLo() {
        if (this.jjw != null && !TextUtils.isEmpty(this.jjw.getForumId())) {
            HttpMessage httpMessage = new HttpMessage(1021074);
            httpMessage.addParam("forum_id", this.jjy.getForum().getId());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    private void a(Fragment fragment, int i) {
        NavigationBar bYq;
        if ((fragment instanceof ap) && this.jjy != null && this.jjy.getForum() != null && (bYq = ((ap) fragment).bYq()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.jjy.getForum().getName(), 5, true, true) + this.jBf.getActivity().getString(R.string.forum));
            bYq.setCenterTextTitle(sb.toString());
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.jjx instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.jjx.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a un(int i) {
        if (this.jjx instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.jjx.un(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.jjx instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.jjx.a(bVar);
        }
    }

    public void onNewIntent(Intent intent) {
        if (this.jjx != null) {
            this.jjx.onNewIntent(intent);
        }
    }

    public void onResume() {
        if (!cLq()) {
            this.jjx.setPrimary(true);
        } else if (this.jBg != null) {
            Fragment currentFragment = this.jBg.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(true);
            }
        }
        if (this.jBk) {
            this.jBk = false;
            if (this.jjx != null) {
                this.jjx.refresh();
            }
        }
        if (this.jjy != null && this.jjy.getUserData() != null && this.jjy.getUserData().getNewGodData() != null) {
            if (this.jjy.getForum() != null) {
                v.bJa().setFid(this.jjy.getForum().getId());
            }
            v.bJa().b(2, this.jjy.getUserData().getNewGodData());
        }
        this.jBy = true;
        if (this.jBx) {
            e((ForumData) null);
        }
    }

    public void onPause() {
        this.jBy = false;
        if (this.jBu != null) {
            this.jBu.cNf();
        }
        if (!cLq()) {
            this.jjx.setPrimary(false);
        } else if (this.jBg != null) {
            Fragment currentFragment = this.jBg.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(false);
            }
        }
        v.bJa().removeCallbacks();
    }

    public void onChangeSkinType(int i) {
        UtilHelper.changeStatusBarIconAndTextColor(true, this.jBf);
        if (this.jjx != null) {
            this.jjx.onChangeSkinType(i);
        }
        if (this.jBg != null) {
            this.jBg.onChangeSkinType(i);
        }
        cLl();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (cLq() && this.jBg != null && this.jBg.cGK()) {
                this.jBg.cHc();
                UtilHelper.setNavigationBarBackground(this.jBf, this.jBg.cGX());
            } else if (this.jjx != null && this.jjx.isAdded()) {
                if (this.jjx.onKeyDown(i, keyEvent)) {
                    return true;
                }
                cLp();
            } else {
                return this.jBf.b(i, keyEvent);
            }
        } else if (i == 24) {
            if (this.jjx != null && this.jjx.isAdded()) {
                return this.jjx.onKeyDown(i, keyEvent);
            }
        } else {
            return this.jBf.b(i, keyEvent);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLp() {
        if (this.jjA != this.jjz && cLq()) {
            this.jBg.setCurrentTab(this.jjz);
            if (Aq(this.jjz) != 1) {
                this.jjx.qt(false);
            }
            this.jjA = this.jjz;
            a(this.jBg.getCurrentFragment(), this.jjz);
            return;
        }
        this.jjx.closeActivity();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!cLq()) {
            this.jjx.onActivityResult(i, i2, intent);
        } else if (this.jBg != null) {
            if (1 == this.jBg.getCurrentTabType()) {
                this.jjx.onActivityResult(i, i2, intent);
            } else {
                this.jBg.getCurrentFragment().onActivityResult(i, i2, intent);
            }
        }
        if (i2 == -1) {
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1) {
                    com.baidu.tieba.o.a.dEA().E(this.jBf.getPageContext());
                    ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.linkUrl != null && this.jBj != null) {
                        this.jBj.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.18
                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void bCg() {
                            }

                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void a(final CustomDialogData customDialogData) {
                                com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.18.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (FrsTabController.this.jBf != null) {
                                            com.baidu.tieba.pb.interactionpopupwindow.c.a(FrsTabController.this.jBf.getPageContext(), customDialogData).show();
                                        }
                                    }
                                }, 1000L);
                            }
                        });
                    }
                }
            } else if (i == 13011) {
                com.baidu.tieba.o.a.dEA().E(this.jBf.getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (!cLq()) {
            return this.jjx.getVoiceManager();
        }
        if (this.jBg == null) {
            return null;
        }
        Fragment currentFragment = this.jBg.getCurrentFragment();
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
    public int Ao(int i) {
        if (this.jjw == null) {
            return -1;
        }
        int count = x.getCount(this.jjw.bEt());
        for (int i2 = 0; i2 < count; i2++) {
            if (this.jjw.bEt().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Aq(int i) {
        if (this.jjw != null && i < x.getCount(this.jjw.bEt())) {
            return this.jjw.bEt().get(i).tab_id.intValue();
        }
        return -1;
    }

    public FrsFragment cEk() {
        return this.jjx;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> cEl() {
        if (!cLq()) {
            if (this.jjx instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) this.jjx).cEl();
            }
        } else if (this.jBg == null) {
            return null;
        } else {
            Fragment currentFragment = this.jBg.getCurrentFragment();
            if (currentFragment instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) currentFragment).cEl();
            }
        }
        return null;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(FrsNoListItemViewHolder.jiI);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.jBf.isLoadingViewAttached()) {
            this.jBf.hideLoadingView(this.jBf.findViewById(16908290));
        }
        if (this.jBH != null) {
            com.baidu.adp.lib.f.e.mB().removeCallbacks(this.jBH);
        }
        com.baidu.tbadk.core.sharedPref.b.bvq().putBoolean(this.jBi, false);
        if (this.jBj != null) {
            this.jBj.cancelLoadData();
        }
        if (this.jjx != null && this.jjx.cEU() != null) {
            this.jjx.cEU().cLD();
        }
        if (this.jBq != null) {
            this.jBq.onDestroy();
        }
        if (FrsActivityConfig.FRS_FROM_FLUTTER_BCASTEDIT.equals(this.mFrom)) {
            new o(TbadkCoreApplication.getInst()).bvG();
        }
        if (FrsActivityConfig.FRS_FROM_FORUM_RULE_EDIT.equals(this.mFrom)) {
            com.baidu.tbadk.k.d.bGb().le(false);
        }
        if (this.jBv != null) {
            com.baidu.adp.lib.f.e.mB().removeCallbacks(this.jBv);
        }
        if (this.jjy != null && this.jjy.getForum() != null && this.jBu != null) {
            this.jBu.gs(com.baidu.adp.lib.f.b.toLong(this.jjy.getForum().getId(), 0L));
        }
    }

    public FragmentTabHost cHa() {
        if (this.jBg == null) {
            return null;
        }
        return this.jBg.cHa();
    }

    public boolean cLq() {
        if (this.jBm == null) {
            return false;
        }
        return this.jBm.getItem(0) instanceof FrsTabHostFragment;
    }

    public void As(int i) {
        this.jjz = i;
    }

    public void Bn(int i) {
        this.jjA = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLr() {
        if (this.jBf != null) {
            if (this.jBq == null) {
                this.jBq = (NavigationBarCoverTip) this.jBf.findViewById(R.id.navigation_cover_tip);
            }
            if (this.jBq != null) {
                View inflate = View.inflate(this.jBf, R.layout.write_thread_share_guide, null);
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
                cVar.byx();
                tBSpecificationBtn.setConfig(cVar);
                tBSpecificationBtn.bxO();
                ao.setViewTextColor(textView, R.color.CAM_X0101);
                ao.setBackgroundColor(this.jBq, R.color.cp_link_tip_a_alpha95);
                tBSpecificationBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.19
                    /* JADX DEBUG: Multi-variable search result rejected for r4v9, resolved type: com.baidu.tieba.frs.FrsActivity */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        new aq("c13439").bwn();
                        if (FrsTabController.this.cEk() != null && !TextUtils.isEmpty(FrsTabController.this.cEk().getForumId()) && !TextUtils.isEmpty(FrsTabController.this.mForumName) && FrsTabController.this.jBf != null) {
                            if (FrsTabController.this.jBq != null) {
                                FrsTabController.this.jBq.hideTip();
                            }
                            be.bwu().b(FrsTabController.this.jBf.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/bawutask?fid=" + FrsTabController.this.cEk().getForumId() + "&fn=" + FrsTabController.this.mForumName + "&noread=" + (com.baidu.tbadk.core.sharedPref.b.bvq().getInt("key_bawu_task_toast", 0) == -1 ? 1 : 0)});
                        }
                    }
                });
                this.jBq.a(this.jBf, inflate, 30000);
                new aq("c13438").bwn();
                int i = com.baidu.tbadk.core.sharedPref.b.bvq().getInt("key_bawu_task_toast", 0);
                if (i >= 0) {
                    com.baidu.tbadk.core.sharedPref.b.bvq().putInt("key_bawu_task_toast", i + 1);
                }
            }
        }
    }

    private void cLs() {
        boolean z;
        if (this.jjy != null && this.jjy.getEntelechyTabInfo() != null && this.jjy.getEntelechyTabInfo().tab != null) {
            Iterator<FrsTabInfo> it = this.jjy.getEntelechyTabInfo().tab.iterator();
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
                if (this.jBt == null) {
                    this.jBt = new com.baidu.tieba.c.e(this.jBf.getPageContext(), this.jBn);
                    this.jBt.fP(R.drawable.pic_sign_tip_down);
                    this.jBt.setAnchor(2);
                    this.jBt.setUseDirectOffset(true);
                    this.jBt.yH(-l.getDimens(this.jBf, R.dimen.tbds20));
                    this.jBt.setYOffset(-l.getDimens(this.jBf, R.dimen.tbds20));
                    this.jBt.setTextColor(R.color.CAM_X0101);
                    this.jBt.setHeight(R.dimen.tbds54);
                    this.jBt.yF(l.getDimens(this.jBf, R.dimen.tbds44));
                }
                this.jBt.aK(this.jBf.getString(R.string.frs_evaluate_tip), "first_into_frs_with_evaluate_tab");
            }
        }
    }

    private void d(final ForumData forumData) {
        boolean z = false;
        if (i(forumData.getName(), forumData.getId(), forumData.getImage_url(), false)) {
            if (this.jBv != null) {
                com.baidu.adp.lib.f.e.mB().removeCallbacks(this.jBv);
            }
            z = true;
        }
        if (!this.jBw) {
            this.jBu.cNe().j(TbadkCoreApplication.getCurrentAccount(), forumData.getId(), System.currentTimeMillis());
            this.jBw = true;
        }
        if (!z) {
            this.jBv = this.jBv != null ? this.jBv : new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.20
                @Override // java.lang.Runnable
                public void run() {
                    if (FrsTabController.this.jBu != null) {
                        if (FrsTabController.this.jBy) {
                            FrsTabController.this.i(forumData.getName(), forumData.getId(), forumData.getImage_url(), true);
                        } else {
                            FrsTabController.this.jBx = true;
                        }
                    }
                }
            };
            com.baidu.adp.lib.f.e.mB().postDelayed(this.jBv, AppStatusRules.DEFAULT_GRANULARITY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ForumData forumData) {
        if (this.jjx.cEW() != null && this.jBu != null) {
            if (forumData == null) {
                forumData = this.jjy.getForum();
            }
            if (forumData != null && forumData.isLike() != 1) {
                if (!this.jBy) {
                    this.jBx = true;
                } else if (i(forumData.getName(), forumData.getId(), forumData.getImage_url(), false) && this.jBv != null) {
                    com.baidu.adp.lib.f.e.mB().removeCallbacks(this.jBv);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i(String str, String str2, String str3, boolean z) {
        if (!this.jBu.fg(TbadkCoreApplication.getCurrentAccount(), str2) || this.jjx == null || this.jjx.cEW() == null) {
            return false;
        }
        this.jBx = false;
        this.jBu.a(this.jBf, str, str2, str3, this.jjx.cEW().cNX());
        this.jBu.cNe().e(TbadkCoreApplication.getCurrentAccount(), str2, System.currentTimeMillis(), z);
        return true;
    }

    public boolean gq(long j) {
        ForumData forum;
        return (this.jjy == null || j == 0 || (forum = this.jjy.getForum()) == null || com.baidu.adp.lib.f.b.toLong(forum.getId(), 0L) != j) ? false : true;
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
        /* renamed from: Bo */
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

        public BaseFragment Lo(String str) {
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

        public BaseFragment Bp(int i) {
            return (BaseFragment) x.remove(this.mFragments, i);
        }

        public String Bq(int i) {
            if (getItem(i) != null) {
                return getItem(i).getBaseTag();
            }
            return null;
        }
    }

    public TbPageTag getTbPageTag() {
        if (!cLq()) {
            return this.jjx.getTbPageTag();
        }
        if (this.jBg != null) {
            if (1 == this.jBg.getCurrentTabType()) {
                return this.jjx.getTbPageTag();
            }
            Fragment currentFragment = this.jBg.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                return ((BaseFragment) currentFragment).getTbPageTag();
            }
        }
        return null;
    }

    public void onScreenShot(String str) {
        if (this.jjy != null && this.jjy.getForum() != null) {
            TiebaStatic.log(new aq("c13848").dX("uid", TbadkCoreApplication.getCurrentAccount()).dX("fid", this.jjy.getForum().getId()).an("obj_type", 2));
        }
    }
}
