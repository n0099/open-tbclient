package com.baidu.tieba.ala.alasquare.special_forum;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.d;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.guide.c;
import com.baidu.adp.lib.guide.d;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.ala.AlaSharedPrefConfig;
import com.baidu.ala.AlaSharedPrefHelper;
import com.baidu.ala.data.TabData;
import com.baidu.ala.notify.AlaLiveUserNotifyController;
import com.baidu.ala.notify.AlaLiveUserNotifyManager;
import com.baidu.ala.view.ScrollHorizontalTabView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.sapi2.result.OpenBdussResult;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.message.SignMessage;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tbadk.widget.layout.ObservedChangeFrameLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.special_forum.b.e;
import com.baidu.tieba.ala.alasquare.special_forum.data.SpecialLiveTabInfo;
import com.baidu.tieba.ala.alasquare.special_forum.data.h;
import com.baidu.tieba.ala.alasquare.special_forum.model.a;
import com.baidu.tieba.ala.alasquare.special_forum.subtab.ConcernTabFragment;
import com.baidu.tieba.ala.alasquare.special_forum.subtab.GameTabFragment;
import com.baidu.tieba.ala.alasquare.special_forum.subtab.OtherSubTabFragment;
import com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment;
import com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.u;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.view.bubbleView.BubbleLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class SpecialLiveFragment extends BaseFragment {
    private AppBarLayout WW;
    private CustomViewPager dSy;
    private LikeModel egK;
    private AlaLiveUserNotifyController fnE;
    private AlaLiveUserNotifyManager.AlaLiveNotifyListener fnF;
    private ScrollHorizontalTabView fqQ;
    private float fsR;
    private CollapsingToolbarLayout fsS;
    private View fsT;
    private ObservedChangeFrameLayout fsU;
    private RelativeLayout fsV;
    private View fsW;
    private TextView fsX;
    private TextView fsY;
    private TextView fsZ;
    private RelativeLayout fta;
    private View ftb;
    private View ftc;
    private TextView ftd;
    private ImageView fte;
    private a ftf;
    private e ftg;
    private com.baidu.tieba.ala.alasquare.special_forum.model.a fth;
    private List<TabData> fti;
    private List<SpecialLiveTabInfo> ftj;
    private CustomMessageListener ftk;
    private int ftl;
    private String ftm;
    private c ftp;
    private BdUniqueId mBdUniqueId;
    private Context mContext;
    private h mData;
    private String mForumId;
    private String mForumName;
    private View mRootView;
    private View mStatusBarView;
    private boolean ftn = true;
    private int mCurState = 1;
    private boolean fto = false;
    private Handler mHandler = new Handler();
    private Runnable ftq = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.1
        @Override // java.lang.Runnable
        public void run() {
            if (SpecialLiveFragment.this.ftg != null) {
                SpecialLiveFragment.this.ftg.buN();
            }
        }
    };
    private CustomMessageListener dGa = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            SpecialLiveFragment.this.mHandler.removeCallbacks(SpecialLiveFragment.this.ftq);
            SpecialLiveFragment.this.mHandler.postDelayed(SpecialLiveFragment.this.ftq, 500L);
        }
    };
    private CustomMessageListener ftr = new CustomMessageListener(CmdConfigCustom.CMD_FORCE_REFRESH) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2) {
                    if ("FrsLiveLive".equals(split[0])) {
                        SpecialLiveFragment.this.jJ(false);
                    }
                    SpecialForumTabBaseFragment qh = SpecialLiveFragment.this.ftf.qh(SpecialLiveFragment.this.dSy.getCurrentItem());
                    if (qh != null) {
                        qh.buI();
                    }
                }
            }
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && SpecialLiveFragment.this.fth != null && !TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                SpecialLiveFragment.this.jJ(false);
            }
        }
    };
    private final CustomMessageListener fts = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            u uVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof u) && (uVar = (u) customResponsedMessage.getData()) != null && SpecialLiveFragment.this.mForumId.equals(uVar.getFid())) {
                if (uVar.isLike() == 1) {
                    if (SpecialLiveFragment.this.buy()) {
                        SpecialLiveFragment.this.mCurState = 3;
                    } else {
                        SpecialLiveFragment.this.mCurState = 2;
                    }
                } else {
                    SpecialLiveFragment.this.mCurState = 1;
                }
                SpecialLiveFragment.this.jK(false);
            }
        }
    };
    private final CustomMessageListener mSignChangedListener = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            SignData signData;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (signData = (SignData) customResponsedMessage.getData()) != null && SpecialLiveFragment.this.mForumId.equals(signData.forumId) && signData.is_signed == 1) {
                SpecialLiveFragment.this.mCurState = 3;
                SpecialLiveFragment.this.jK(false);
                l.showToast(SpecialLiveFragment.this.getPageContext().getPageActivity(), SpecialLiveFragment.this.mContext.getString(R.string.special_sign_success_tip, Integer.valueOf(signData.sign_bonus_point)));
            }
        }
    };
    private final CustomMessageListener ftt = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_SPECIAL_CONCERN_TAB_TAB_ICON) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                Boolean bool = (Boolean) customResponsedMessage.getData();
                if (!w.isEmpty(SpecialLiveFragment.this.fti)) {
                    ((TabData) SpecialLiveFragment.this.fti.get(0)).extra = bool;
                    SpecialLiveFragment.this.fqQ.setData(SpecialLiveFragment.this.fti);
                    if (bool.booleanValue()) {
                        TiebaStatic.log("c12898");
                    }
                }
            }
        }
    };

    public static SpecialLiveFragment dD(String str, String str2) {
        SpecialLiveFragment specialLiveFragment = new SpecialLiveFragment();
        Bundle bundle = new Bundle();
        bundle.putString("forum_id", str);
        bundle.putString("forum_name", str2);
        specialLiveFragment.setArguments(bundle);
        return specialLiveFragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mContext = getPageContext().getPageActivity();
            this.mForumId = arguments.getString("forum_id");
            String string = arguments.getString("forum_name");
            String string2 = this.mContext.getResources().getString(R.string.forum);
            if (!TextUtils.isEmpty(string)) {
                this.mForumName = string;
                StringBuilder sb = new StringBuilder();
                sb.append(UtilHelper.getFixedBarText(string, 5, true, true) + string2);
                this.ftm = sb.toString();
            } else {
                this.mForumName = this.mContext.getResources().getString(R.string.ala_ufan_bar_title);
                this.ftm = this.mForumName + string2;
            }
            buw();
            buu();
            buv();
            MessageManager.getInstance().registerListener(this.ftk);
            MessageManager.getInstance().registerListener(this.fts);
            MessageManager.getInstance().registerListener(this.mSignChangedListener);
            MessageManager.getInstance().registerListener(this.ftt);
            MessageManager.getInstance().registerListener(this.ftr);
            MessageManager.getInstance().registerListener(this.mAccountChangedListener);
            MessageManager.getInstance().registerListener(this.dGa);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(R.layout.special_live_layout, (ViewGroup) null);
        this.WW = (AppBarLayout) this.mRootView.findViewById(R.id.special_app_bar_layout);
        this.fsS = (CollapsingToolbarLayout) this.mRootView.findViewById(R.id.special_collapse_layout);
        this.mStatusBarView = this.mRootView.findViewById(R.id.statusbar_view);
        this.fsU = (ObservedChangeFrameLayout) this.mRootView.findViewById(R.id.live_container);
        this.mBdUniqueId = BdUniqueId.gen();
        this.fsV = (RelativeLayout) this.mRootView.findViewById(R.id.function_container);
        this.fsW = this.mRootView.findViewById(R.id.function_bottom_space);
        this.fsX = (TextView) this.mRootView.findViewById(R.id.function_title);
        this.fsX.setText(this.ftm);
        this.fsY = (TextView) this.mRootView.findViewById(R.id.function_btn);
        this.fsY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!j.isNetWorkAvailable()) {
                    SpecialLiveFragment.this.showToast(R.string.neterror);
                    return;
                }
                if (!TbadkCoreApplication.isLogin()) {
                    be.skipToLoginActivity(SpecialLiveFragment.this.mContext);
                }
                if (SpecialLiveFragment.this.mCurState == 1) {
                    SpecialLiveFragment.this.fsY.setClickable(false);
                    SpecialLiveFragment.this.egK.fx(SpecialLiveFragment.this.mForumName, SpecialLiveFragment.this.mForumId);
                    TiebaStatic.log(new ao("c12890"));
                } else if (SpecialLiveFragment.this.mCurState == 2) {
                    SpecialLiveFragment.this.fsY.setClickable(false);
                    ForumData forumData = new ForumData();
                    forumData.setId(SpecialLiveFragment.this.mForumId);
                    forumData.setName(SpecialLiveFragment.this.mForumName);
                    CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_SIGN_MODEL_TASK, forumData);
                    customMessage.setTag(SpecialLiveFragment.this.mBdUniqueId);
                    MessageManager.getInstance().sendMessage(customMessage);
                    TiebaStatic.log(new ao("c12892"));
                }
            }
        });
        this.fsZ = (TextView) this.mRootView.findViewById(R.id.function_level_desc);
        this.fta = (RelativeLayout) this.mRootView.findViewById(R.id.navigation_layout);
        this.ftc = this.mRootView.findViewById(R.id.navigation_top_space);
        this.ftb = this.mRootView.findViewById(R.id.navigation_bg);
        this.ftd = (TextView) this.mRootView.findViewById(R.id.navigation_title);
        this.ftd.setText(this.ftm);
        this.fte = (ImageView) this.mRootView.findViewById(R.id.navigation_back_img);
        this.fte.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, SpecialLiveFragment.this.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        });
        this.fqQ = (ScrollHorizontalTabView) this.mRootView.findViewById(R.id.scroll_tab_view);
        this.dSy = (CustomViewPager) this.mRootView.findViewById(R.id.special_view_pager);
        initViewPager();
        this.fqQ.setViewPager(this.dSy);
        this.fqQ.setScrollTabPageListener(new ScrollHorizontalTabView.ScrollTabPageListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.2
            @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
            public boolean onPrePageSelect(int i, TabData tabData) {
                return true;
            }

            @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
            public void onPageSelected(int i, TabData tabData) {
                if (i != 0 || TbadkCoreApplication.isLogin()) {
                    if (SpecialLiveFragment.this.ftf != null) {
                        SpecialLiveFragment.this.ftf.a(i, tabData);
                        return;
                    }
                    return;
                }
                be.skipToLoginActivity(SpecialLiveFragment.this.getPageContext().getPageActivity());
                if (SpecialLiveFragment.this.dSy != null) {
                    SpecialLiveFragment.this.dSy.setCurrentItem(1);
                }
            }

            @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
            public void onPageScrolled(int i, float f, int i2) {
            }
        });
        this.WW.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.3
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                int abs = Math.abs(i);
                if (abs == 0) {
                    SpecialLiveFragment.this.ftb.setVisibility(8);
                    SpecialLiveFragment.this.ftd.setVisibility(8);
                } else {
                    SpecialLiveFragment.this.ftb.setVisibility(0);
                    SpecialLiveFragment.this.ftd.setVisibility(0);
                }
                SpecialLiveFragment.this.jL(((float) abs) > SpecialLiveFragment.this.fsR / 2.0f);
                float abs2 = Math.abs(abs / SpecialLiveFragment.this.fsR);
                SpecialLiveFragment.this.ftb.setAlpha(abs2);
                SpecialLiveFragment.this.ftd.setAlpha(abs2);
                SpecialLiveFragment.this.g(abs, abs2);
            }
        });
        this.fsT = this.mRootView.findViewById(R.id.square_main_top_divider_line);
        this.fsU.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.4
            @Override // com.baidu.tbadk.widget.layout.e
            public void d(View view, int i, int i2, int i3, int i4) {
                SpecialLiveFragment.this.fsR = (SpecialLiveFragment.this.fsU.getMeasuredHeight() + SpecialLiveFragment.this.fsV.getMeasuredHeight()) - SpecialLiveFragment.this.fta.getMeasuredHeight();
                SpecialLiveFragment.this.fsS.setMinimumHeight(SpecialLiveFragment.this.fta.getMeasuredHeight());
            }
        });
        Ip();
        this.fti = new ArrayList();
        this.ftj = new ArrayList();
        this.ftg = new e(getPageContext());
        this.fth = new com.baidu.tieba.ala.alasquare.special_forum.model.a(getPageContext(), new a.InterfaceC0535a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.5
            @Override // com.baidu.tieba.ala.alasquare.special_forum.model.a.InterfaceC0535a
            public void b(h hVar) {
                SpecialLiveFragment.this.hideLoadingView(SpecialLiveFragment.this.mRootView);
                SpecialLiveFragment.this.a(hVar);
            }

            @Override // com.baidu.tieba.ala.alasquare.special_forum.model.a.InterfaceC0535a
            public void az(int i, String str) {
                SpecialLiveFragment.this.aD(i, str);
            }
        });
        jK(true);
        jJ(true);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.mRootView.post(new Runnable() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.6
            @Override // java.lang.Runnable
            public void run() {
                SpecialLiveFragment.this.ag(SpecialLiveFragment.this.getFragmentActivity());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jJ(boolean z) {
        if (!this.fth.isLoading()) {
            if (z) {
                showLoadingView(this.mRootView);
            }
            this.fth.loadData();
        }
    }

    private void buu() {
        this.fnE = new AlaLiveUserNotifyController(getPageContext());
        this.fnF = new AlaLiveUserNotifyManager.AlaLiveNotifyListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.7
            @Override // com.baidu.ala.notify.AlaLiveUserNotifyManager.AlaLiveNotifyListener
            public void onCallBack() {
                if (SpecialLiveFragment.this.isPrimary()) {
                    SpecialLiveFragment.this.fnE.showNextNotifyDialog(0, AlaLiveUserNotifyManager.getInstance().getNotifyDataList());
                }
            }
        };
        AlaLiveUserNotifyManager.getInstance().addNotifyListener(this.fnF);
    }

    private void buv() {
        this.ftk = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_MODEL_TASK) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z;
                SignData signData = null;
                SpecialLiveFragment.this.fsY.setClickable(true);
                if (customResponsedMessage != null && customResponsedMessage.getOrginalMessage().getTag() == SpecialLiveFragment.this.mBdUniqueId) {
                    SignMessage signMessage = (SignMessage) customResponsedMessage;
                    if (AntiHelper.bA(signMessage.mSignErrorCode, signMessage.mSignErrorString) && signMessage.signData != null) {
                        AntiHelper.a(SpecialLiveFragment.this.mContext, signMessage.signData.blockPopInfoData, (AntiHelper.a) null);
                        return;
                    }
                    if (signMessage == null || signMessage.signData == null) {
                        z = false;
                    } else {
                        signData = signMessage.signData;
                        if (signData.forumId == null || !signData.forumId.equals(SpecialLiveFragment.this.mForumId)) {
                            return;
                        }
                        z = true;
                    }
                    if (z) {
                        TbadkCoreApplication.getInst().addSignedForum(SpecialLiveFragment.this.mForumName, signData.sign_bonus_point, -1);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
                        if (AntiHelper.bA(signMessage.mSignErrorCode, signMessage.mSignErrorString)) {
                            AntiHelper.aX(SpecialLiveFragment.this.mContext, signMessage.mSignErrorString);
                            return;
                        } else {
                            l.showToast(SpecialLiveFragment.this.mContext, SpecialLiveFragment.this.mContext.getString(R.string.special_sign_success_tip, Integer.valueOf(signData.sign_bonus_point)));
                            return;
                        }
                    }
                    if (signMessage.mSignErrorCode == 160002) {
                        SpecialLiveFragment.this.mCurState = 3;
                        SpecialLiveFragment.this.jK(false);
                    }
                    l.showToast(SpecialLiveFragment.this.mContext, signMessage.mSignErrorString);
                }
            }
        };
    }

    private void buw() {
        this.egK = new LikeModel(getPageContext());
        this.egK.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.9
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                SpecialLiveFragment.this.fsY.setClickable(true);
                if (SpecialLiveFragment.this.egK.getErrorCode() == 22) {
                    l.showToast(SpecialLiveFragment.this.mContext, (int) R.string.had_liked_forum);
                } else if (AntiHelper.bA(SpecialLiveFragment.this.egK.getErrorCode(), SpecialLiveFragment.this.egK.getErrorString())) {
                    AntiHelper.aX(SpecialLiveFragment.this.mContext, SpecialLiveFragment.this.egK.getErrorString());
                } else if (SpecialLiveFragment.this.egK.getErrorCode() != 0) {
                    l.showToast(SpecialLiveFragment.this.mContext, SpecialLiveFragment.this.egK.getErrorString());
                } else {
                    u uVar = (u) obj;
                    if (uVar != null) {
                        TbadkCoreApplication.getInst().addLikeForum(SpecialLiveFragment.this.mForumName);
                        uVar.setLike(1);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, uVar));
                        l.showToast(SpecialLiveFragment.this.mContext, (int) R.string.attention_success);
                        return;
                    }
                    l.showToast(SpecialLiveFragment.this.mContext, (int) R.string.neterror);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(h hVar) {
        this.mData = hVar;
        buz();
        bux();
        if (!this.fto) {
            buA();
            if (this.dSy != null && this.dSy.getChildCount() > 1) {
                this.dSy.setCurrentItem(1);
            }
            if (!w.isEmpty(this.mData.tabInfoList)) {
                this.fto = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aD(int i, String str) {
        if (TextUtils.isEmpty(str)) {
            showNetRefreshView(this.mRootView, this.mContext.getResources().getString(R.string.square_load_data_failed_tip), false);
        } else {
            showNetRefreshView(this.mRootView, str, false);
        }
    }

    private void bux() {
        if (this.mData.ftQ) {
            if (buy()) {
                this.mCurState = 3;
            } else {
                this.mCurState = 2;
            }
        } else {
            this.mCurState = 1;
        }
        jK(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean buy() {
        return this.mData.ftS.ftY;
    }

    private void buz() {
        boolean c = this.ftg.c(this.mData.ftO);
        if (c) {
            this.ftg.stopPlay();
            this.ftg.onDestroy();
        }
        this.ftg.a(this.mData.ftO, c);
        if (c) {
            this.ftg.V(this.fsU);
        }
        this.ftg.startPlay();
    }

    private void buA() {
        buB();
        this.fqQ.setData(this.fti);
        this.ftf.setData(this.ftj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(int i, float f) {
        if (this.ftg != null && f != 0.0f) {
            if (this.ftl <= i) {
                if (this.ftn && f >= 0.3f) {
                    this.ftg.jw(true);
                    this.ftg.pause();
                    this.ftn = false;
                }
            } else if (!this.ftn && f <= 0.3f) {
                this.ftg.jw(false);
                this.ftg.resume();
                this.ftn = true;
            }
            this.ftl = i;
        }
    }

    private void Ip() {
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds88);
        if (UtilHelper.canUseStyleImmersiveSticky() && this.mStatusBarView.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.mStatusBarView.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.mStatusBarView.setLayoutParams(layoutParams);
            this.mStatusBarView.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.ftc.getLayoutParams();
            layoutParams2.height = layoutParams.height;
            this.ftc.setLayoutParams(layoutParams2);
            dimensionPixelSize = layoutParams.height + dimensionPixelSize;
        } else {
            this.mStatusBarView.setVisibility(8);
        }
        CollapsingToolbarLayout.LayoutParams layoutParams3 = (CollapsingToolbarLayout.LayoutParams) this.fta.getLayoutParams();
        layoutParams3.height = dimensionPixelSize;
        this.fta.setLayoutParams(layoutParams3);
    }

    private void buB() {
        this.fti.clear();
        this.ftj.clear();
        this.fti.add(buE());
        this.fti.add(buF());
        this.ftj.add(buC());
        this.ftj.add(buD());
        if (!w.isEmpty(this.mData.tabInfoList)) {
            boolean z = b.aVP().getInt("chushou_game_tab", 1) == 1;
            for (int i = 0; i < this.mData.tabInfoList.size() && i < 10; i++) {
                SpecialLiveTabInfo specialLiveTabInfo = this.mData.tabInfoList.get(i);
                if (specialLiveTabInfo != null && (specialLiveTabInfo.tabId != 1108 || z)) {
                    this.ftj.add(specialLiveTabInfo);
                    TabData tabData = new TabData();
                    tabData.tabId = specialLiveTabInfo.tabId;
                    tabData.tabName = specialLiveTabInfo.tabName;
                    tabData.tabType = specialLiveTabInfo.tabType;
                    this.fti.add(tabData);
                }
            }
        }
    }

    private SpecialLiveTabInfo buC() {
        SpecialLiveTabInfo specialLiveTabInfo = new SpecialLiveTabInfo();
        specialLiveTabInfo.tabId = OpenBdussResult.ERROR_CODE_NOT_LOGIN;
        specialLiveTabInfo.tabName = this.mContext.getResources().getString(R.string.special_concern_tab_title);
        return specialLiveTabInfo;
    }

    private SpecialLiveTabInfo buD() {
        SpecialLiveTabInfo specialLiveTabInfo = new SpecialLiveTabInfo();
        specialLiveTabInfo.tabId = -903;
        specialLiveTabInfo.tabName = this.mContext.getResources().getString(R.string.special_recommend_tab_title);
        return specialLiveTabInfo;
    }

    private TabData buE() {
        TabData tabData = new TabData();
        tabData.tabId = OpenBdussResult.ERROR_CODE_NOT_LOGIN;
        tabData.tabName = this.mContext.getResources().getString(R.string.special_concern_tab_title);
        return tabData;
    }

    private TabData buF() {
        TabData tabData = new TabData();
        tabData.tabId = -903;
        tabData.tabName = this.mContext.getResources().getString(R.string.special_recommend_tab_title);
        return tabData;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            if (isPrimary()) {
                jJ(false);
                AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
            }
            if (this.ftg != null) {
                if (isPrimary()) {
                    this.ftg.jw(false);
                    this.ftg.startPlay();
                    return;
                }
                this.ftg.jw(true);
                this.ftg.pause();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        hideNetRefreshView(this.mRootView);
        jJ(true);
        AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.ftg != null) {
            this.ftg.jw(true);
            this.ftg.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.ftg != null) {
            this.ftg.onChangeSkinType(i);
        }
        if (this.fqQ != null) {
            an.setBackgroundResource(this.fqQ, R.color.cp_bg_line_d);
            this.fqQ.onChangeSkinType(i);
        }
        if (this.ftf != null) {
            this.ftf.onChangeSkinType(i);
        }
        jL(false);
        an.setBackgroundColor(this.mStatusBarView, R.color.cp_bg_line_d);
        an.setBackgroundColor(this.ftb, R.color.cp_bg_line_d);
        an.setViewTextColor(this.ftd, (int) R.color.cp_cont_b);
        an.setBackgroundColor(this.fsV, R.color.cp_bg_line_d);
        an.setBackgroundColor(this.fsW, R.color.cp_bg_line_e);
        an.setViewTextColor(this.fsX, (int) R.color.cp_cont_b);
        an.setViewTextColor(this.fsZ, (int) R.color.cp_cont_j);
        an.setViewTextColor(this.fsY, (int) R.color.cp_cont_g);
        an.setBackgroundResource(this.fsY, R.drawable.frs_attention_btn_bg_selector);
        an.setBackgroundResource(this.fsT, R.color.cp_bg_line_c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jK(boolean z) {
        Drawable drawable;
        int i = R.drawable.frs_attention_btn_bg_selector;
        an.setBackgroundResource(this.fsY, R.drawable.frs_attention_btn_bg_selector);
        int dimens = l.getDimens(this.mContext, R.dimen.ds10);
        String string = this.mContext.getResources().getString(R.string.attention);
        int i2 = R.color.cp_cont_a;
        if (this.mCurState == 1) {
            drawable = an.getDrawable(R.drawable.icon_add_follow_blue_s);
            this.fsY.setClickable(true);
            if (!z) {
                TiebaStatic.log(new ao("c12889"));
            }
        } else if (this.mCurState == 2) {
            string = this.mContext.getResources().getString(R.string.sign);
            drawable = an.getDrawable(R.drawable.icon_public_sign_blue_s);
            this.fsY.setClickable(true);
            if (!z) {
                TiebaStatic.log(new ao("c12891"));
            }
        } else if (this.mCurState == 3) {
            string = this.mContext.getResources().getString(R.string.signed);
            this.fsY.setClickable(false);
            i = R.drawable.special_sign_btn_signed_bg;
            i2 = R.color.cp_cont_d;
            drawable = null;
        } else {
            drawable = null;
        }
        an.setBackgroundResource(this.fsY, i);
        an.setViewTextColor(this.fsY, i2);
        this.fsY.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.fsY.setCompoundDrawablePadding(dimens);
        this.fsY.setText(string);
        buG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jL(boolean z) {
        if (this.fte != null) {
            if (z) {
                an.setNavbarIconSrc(this.fte, R.drawable.selector_topbar_return_black, R.drawable.selector_topbar_return_black, TbadkCoreApplication.getInst().getSkinType());
            } else {
                an.setNavbarIconSrc(this.fte, R.drawable.selector_topbar_return_white, R.drawable.selector_topbar_return_white, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    private void buG() {
        if (this.mData != null && this.mData.ftR != null && this.mCurState != 1) {
            int i = this.mData.ftR.level_id;
            String str = TextUtils.isEmpty(this.mData.ftR.level_name) ? "" : " " + this.mData.ftR.level_name;
            if (i >= 0) {
                this.fsZ.setText("LV" + i + str);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.ftg != null) {
            this.ftg.onDestroy();
        }
        if (this.fts != null) {
            MessageManager.getInstance().unRegisterListener(this.fts);
        }
        if (this.ftk != null) {
            MessageManager.getInstance().unRegisterListener(this.ftk);
        }
        if (this.mSignChangedListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mSignChangedListener);
        }
        if (this.ftt != null) {
            MessageManager.getInstance().unRegisterListener(this.ftt);
        }
        if (this.ftr != null) {
            MessageManager.getInstance().unRegisterListener(this.ftr);
        }
        if (this.mAccountChangedListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mAccountChangedListener);
        }
        if (this.fth != null) {
            this.fth.onDestroy();
        }
        if (this.fnE != null) {
            this.fnE.onDestroy();
        }
        AlaLiveUserNotifyManager.getInstance().removeNotifyListener(this.fnF);
        hideLoadingView(this.mRootView);
        MessageManager.getInstance().unRegisterListener(this.dGa);
    }

    private void initViewPager() {
        this.ftf = new a(getChildFragmentManager());
        this.dSy.setAdapter(this.ftf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends FragmentPagerAdapter {
        private SparseArray<SpecialForumTabBaseFragment> ftx;
        private List<SpecialLiveTabInfo> mData;

        public a(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.mData = new ArrayList();
            this.ftx = new SparseArray<>();
            this.ftx.put(0, ConcernTabFragment.qj(0));
        }

        public void setData(List<SpecialLiveTabInfo> list) {
            if (!w.isEmpty(list)) {
                this.mData.clear();
                this.mData.addAll(list);
                notifyDataSetChanged();
            }
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            SpecialForumTabBaseFragment qh = qh(i);
            if (qh == null) {
                if (i == 0) {
                    qh = ConcernTabFragment.qj(0);
                } else if (i == 1) {
                    qh = RecommendTabFragment.qk(1);
                } else if (i < this.mData.size() && this.mData.get(i) != null && this.mData.get(i).tabId == 1108) {
                    qh = GameTabFragment.Bx(this.mData.get(i).tabName);
                } else {
                    qh = OtherSubTabFragment.a(i, this.mData.get(i));
                }
                this.ftx.put(i, qh);
            }
            return qh;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.mData.size();
        }

        public SpecialForumTabBaseFragment qh(int i) {
            return this.ftx.get(i);
        }

        public void a(int i, TabData tabData) {
            if (this.ftx.get(i) != null) {
                this.ftx.get(i).setPrimary(true);
            }
        }

        public void onChangeSkinType(int i) {
            if (this.ftx != null && this.ftx.size() > 0) {
                int size = this.ftx.size();
                for (int i2 = 0; i2 < size; i2++) {
                    SpecialForumTabBaseFragment specialForumTabBaseFragment = this.ftx.get(i2);
                    if (specialForumTabBaseFragment != null) {
                        specialForumTabBaseFragment.onChangeSkinType(i);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ag(final Activity activity) {
        if (activity != null && !AlaSharedPrefHelper.getInstance().getBoolean(AlaSharedPrefConfig.SQUARE_GUIDE_MARK_MANAGE_TIP_SHOW, false)) {
            if (this.ftp != null) {
                this.ftp.dismiss();
            }
            final Handler handler = new Handler();
            final Runnable runnable = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.10
                @Override // java.lang.Runnable
                public void run() {
                    if (SpecialLiveFragment.this.ftp != null) {
                        SpecialLiveFragment.this.ftp.dismiss();
                    }
                }
            };
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.ae(true);
            dVar.b(new d.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.11
                @Override // com.baidu.adp.lib.guide.d.a
                public void onShown() {
                }

                @Override // com.baidu.adp.lib.guide.d.a
                public void onDismiss() {
                    AlaSharedPrefHelper.getInstance().putBoolean(AlaSharedPrefConfig.SQUARE_GUIDE_MARK_MANAGE_TIP_SHOW, true);
                    SpecialLiveFragment.this.ftp = null;
                    handler.removeCallbacks(runnable);
                }
            });
            dVar.y(activity.getWindow().getDecorView().findViewById(R.id.tabcontainer)).af(20).af(false);
            dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.13
                @Override // com.baidu.adp.lib.guide.b
                public View getView(LayoutInflater layoutInflater) {
                    BubbleLayout bubbleLayout = (BubbleLayout) View.inflate(activity, R.layout.square_guide_tip_layout, null);
                    TextView textView = (TextView) bubbleLayout.findViewById(R.id.square_guide_tv);
                    textView.setText(activity.getResources().getString(R.string.square_guide_mark_manage_tip_text));
                    textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.13.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            AlaSharedPrefHelper.getInstance().putBoolean(AlaSharedPrefConfig.SQUARE_GUIDE_MARK_MANAGE_TIP_SHOW, true);
                            SpecialLiveFragment.this.ftp.dismiss();
                        }
                    });
                    an.setViewTextColor(textView, (int) R.color.cp_cont_i);
                    bubbleLayout.Gy(an.getColor(R.color.cp_link_tip_a_alpha95));
                    bubbleLayout.aC(activity.getResources().getDimensionPixelSize(R.dimen.ds216));
                    return bubbleLayout;
                }

                @Override // com.baidu.adp.lib.guide.b
                public int getAnchor() {
                    return 4;
                }

                @Override // com.baidu.adp.lib.guide.b
                public int getFitPosition() {
                    return 48;
                }

                @Override // com.baidu.adp.lib.guide.b
                public int getXOffset() {
                    return -activity.getResources().getDimensionPixelSize(R.dimen.ds7);
                }

                @Override // com.baidu.adp.lib.guide.b
                public int getYOffset() {
                    return -TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds36);
                }
            });
            this.ftp = dVar.kE();
            this.ftp.show(activity);
            handler.postDelayed(runnable, 5000L);
        }
    }
}
