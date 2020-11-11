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
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.message.SignMessage;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.y;
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
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.v;
import com.baidu.tieba.view.bubbleView.BubbleLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class SpecialLiveFragment extends BaseFragment {
    private AppBarLayout Yh;
    private CustomViewPager eLl;
    private LikeModel eZA;
    private List<SpecialLiveTabInfo> fmA;
    private AlaLiveUserNotifyController gjA;
    private AlaLiveUserNotifyManager.AlaLiveNotifyListener gjB;
    private ScrollHorizontalTabView gmR;
    private float goT;
    private CollapsingToolbarLayout goU;
    private View goV;
    private ObservedChangeFrameLayout goW;
    private RelativeLayout goX;
    private View goY;
    private TextView goZ;
    private TextView gpa;
    private TextView gpb;
    private RelativeLayout gpc;
    private View gpd;
    private View gpe;
    private TextView gpf;
    private ImageView gpg;
    private a gph;
    private e gpi;
    private com.baidu.tieba.ala.alasquare.special_forum.model.a gpj;
    private List<TabData> gpk;
    private CustomMessageListener gpl;
    private int gpm;
    private String gpn;
    private c gpq;
    private BdUniqueId mBdUniqueId;
    private Context mContext;
    private h mData;
    private String mForumId;
    private String mForumName;
    private View mRootView;
    private View mStatusBarView;
    private boolean gpo = true;
    private int mCurState = 1;
    private boolean gpp = false;
    private Handler mHandler = new Handler();
    private Runnable gpr = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.1
        @Override // java.lang.Runnable
        public void run() {
            if (SpecialLiveFragment.this.gpi != null) {
                SpecialLiveFragment.this.gpi.bPY();
            }
        }
    };
    private CustomMessageListener eyc = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            SpecialLiveFragment.this.mHandler.removeCallbacks(SpecialLiveFragment.this.gpr);
            SpecialLiveFragment.this.mHandler.postDelayed(SpecialLiveFragment.this.gpr, 500L);
        }
    };
    private CustomMessageListener gps = new CustomMessageListener(CmdConfigCustom.CMD_FORCE_REFRESH) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2) {
                    if ("FrsLiveLive".equals(split[0])) {
                        SpecialLiveFragment.this.lO(false);
                    }
                    SpecialForumTabBaseFragment ub = SpecialLiveFragment.this.gph.ub(SpecialLiveFragment.this.eLl.getCurrentItem());
                    if (ub != null) {
                        ub.bPV();
                    }
                }
            }
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && SpecialLiveFragment.this.gpj != null && !TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                SpecialLiveFragment.this.lO(false);
            }
        }
    };
    private final CustomMessageListener gpt = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            v vVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof v) && (vVar = (v) customResponsedMessage.getData()) != null && SpecialLiveFragment.this.mForumId.equals(vVar.getFid())) {
                if (vVar.isLike() == 1) {
                    if (SpecialLiveFragment.this.bPL()) {
                        SpecialLiveFragment.this.mCurState = 3;
                    } else {
                        SpecialLiveFragment.this.mCurState = 2;
                    }
                } else {
                    SpecialLiveFragment.this.mCurState = 1;
                }
                SpecialLiveFragment.this.lP(false);
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
                SpecialLiveFragment.this.lP(false);
                l.showToast(SpecialLiveFragment.this.getPageContext().getPageActivity(), SpecialLiveFragment.this.mContext.getString(R.string.special_sign_success_tip, Integer.valueOf(signData.sign_bonus_point)));
            }
        }
    };
    private final CustomMessageListener gpu = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_SPECIAL_CONCERN_TAB_TAB_ICON) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                Boolean bool = (Boolean) customResponsedMessage.getData();
                if (!y.isEmpty(SpecialLiveFragment.this.gpk)) {
                    ((TabData) SpecialLiveFragment.this.gpk.get(0)).extra = bool;
                    SpecialLiveFragment.this.gmR.setData(SpecialLiveFragment.this.gpk);
                    if (bool.booleanValue()) {
                        TiebaStatic.log("c12898");
                    }
                }
            }
        }
    };

    public static SpecialLiveFragment ej(String str, String str2) {
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
                this.gpn = sb.toString();
            } else {
                this.mForumName = this.mContext.getResources().getString(R.string.ala_ufan_bar_title);
                this.gpn = this.mForumName + string2;
            }
            bPJ();
            bPH();
            bPI();
            MessageManager.getInstance().registerListener(this.gpl);
            MessageManager.getInstance().registerListener(this.gpt);
            MessageManager.getInstance().registerListener(this.mSignChangedListener);
            MessageManager.getInstance().registerListener(this.gpu);
            MessageManager.getInstance().registerListener(this.gps);
            MessageManager.getInstance().registerListener(this.mAccountChangedListener);
            MessageManager.getInstance().registerListener(this.eyc);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(R.layout.special_live_layout, (ViewGroup) null);
        this.Yh = (AppBarLayout) this.mRootView.findViewById(R.id.special_app_bar_layout);
        this.goU = (CollapsingToolbarLayout) this.mRootView.findViewById(R.id.special_collapse_layout);
        this.mStatusBarView = this.mRootView.findViewById(R.id.statusbar_view);
        this.goW = (ObservedChangeFrameLayout) this.mRootView.findViewById(R.id.live_container);
        this.mBdUniqueId = BdUniqueId.gen();
        this.goX = (RelativeLayout) this.mRootView.findViewById(R.id.function_container);
        this.goY = this.mRootView.findViewById(R.id.function_bottom_space);
        this.goZ = (TextView) this.mRootView.findViewById(R.id.function_title);
        this.goZ.setText(this.gpn);
        this.gpa = (TextView) this.mRootView.findViewById(R.id.function_btn);
        this.gpa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!j.isNetWorkAvailable()) {
                    SpecialLiveFragment.this.showToast(R.string.neterror);
                    return;
                }
                if (!TbadkCoreApplication.isLogin()) {
                    bg.skipToLoginActivity(SpecialLiveFragment.this.mContext);
                }
                if (SpecialLiveFragment.this.mCurState == 1) {
                    SpecialLiveFragment.this.gpa.setClickable(false);
                    SpecialLiveFragment.this.eZA.gp(SpecialLiveFragment.this.mForumName, SpecialLiveFragment.this.mForumId);
                    TiebaStatic.log(new aq("c12890"));
                } else if (SpecialLiveFragment.this.mCurState == 2) {
                    SpecialLiveFragment.this.gpa.setClickable(false);
                    ForumData forumData = new ForumData();
                    forumData.setId(SpecialLiveFragment.this.mForumId);
                    forumData.setName(SpecialLiveFragment.this.mForumName);
                    CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_SIGN_MODEL_TASK, forumData);
                    customMessage.setTag(SpecialLiveFragment.this.mBdUniqueId);
                    MessageManager.getInstance().sendMessage(customMessage);
                    TiebaStatic.log(new aq("c12892"));
                }
            }
        });
        this.gpb = (TextView) this.mRootView.findViewById(R.id.function_level_desc);
        this.gpc = (RelativeLayout) this.mRootView.findViewById(R.id.navigation_layout);
        this.gpe = this.mRootView.findViewById(R.id.navigation_top_space);
        this.gpd = this.mRootView.findViewById(R.id.navigation_bg);
        this.gpf = (TextView) this.mRootView.findViewById(R.id.navigation_title);
        this.gpf.setText(this.gpn);
        this.gpg = (ImageView) this.mRootView.findViewById(R.id.navigation_back_img);
        this.gpg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, SpecialLiveFragment.this.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        });
        this.gmR = (ScrollHorizontalTabView) this.mRootView.findViewById(R.id.scroll_tab_view);
        this.eLl = (CustomViewPager) this.mRootView.findViewById(R.id.special_view_pager);
        initViewPager();
        this.gmR.setViewPager(this.eLl);
        this.gmR.setScrollTabPageListener(new ScrollHorizontalTabView.ScrollTabPageListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.2
            @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
            public boolean onPrePageSelect(int i, TabData tabData) {
                return true;
            }

            @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
            public void onPageSelected(int i, TabData tabData) {
                if (i != 0 || TbadkCoreApplication.isLogin()) {
                    if (SpecialLiveFragment.this.gph != null) {
                        SpecialLiveFragment.this.gph.a(i, tabData);
                        return;
                    }
                    return;
                }
                bg.skipToLoginActivity(SpecialLiveFragment.this.getPageContext().getPageActivity());
                if (SpecialLiveFragment.this.eLl != null) {
                    SpecialLiveFragment.this.eLl.setCurrentItem(1);
                }
            }

            @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
            public void onPageScrolled(int i, float f, int i2) {
            }
        });
        this.Yh.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.3
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                int abs = Math.abs(i);
                if (abs == 0) {
                    SpecialLiveFragment.this.gpd.setVisibility(8);
                    SpecialLiveFragment.this.gpf.setVisibility(8);
                } else {
                    SpecialLiveFragment.this.gpd.setVisibility(0);
                    SpecialLiveFragment.this.gpf.setVisibility(0);
                }
                SpecialLiveFragment.this.lQ(((float) abs) > SpecialLiveFragment.this.goT / 2.0f);
                float abs2 = Math.abs(abs / SpecialLiveFragment.this.goT);
                SpecialLiveFragment.this.gpd.setAlpha(abs2);
                SpecialLiveFragment.this.gpf.setAlpha(abs2);
                SpecialLiveFragment.this.g(abs, abs2);
            }
        });
        this.goV = this.mRootView.findViewById(R.id.square_main_top_divider_line);
        this.goW.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.4
            @Override // com.baidu.tbadk.widget.layout.e
            public void d(View view, int i, int i2, int i3, int i4) {
                SpecialLiveFragment.this.goT = (SpecialLiveFragment.this.goW.getMeasuredHeight() + SpecialLiveFragment.this.goX.getMeasuredHeight()) - SpecialLiveFragment.this.gpc.getMeasuredHeight();
                SpecialLiveFragment.this.goU.setMinimumHeight(SpecialLiveFragment.this.gpc.getMeasuredHeight());
            }
        });
        Tz();
        this.gpk = new ArrayList();
        this.fmA = new ArrayList();
        this.gpi = new e(getPageContext());
        this.gpj = new com.baidu.tieba.ala.alasquare.special_forum.model.a(getPageContext(), new a.InterfaceC0633a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.5
            @Override // com.baidu.tieba.ala.alasquare.special_forum.model.a.InterfaceC0633a
            public void b(h hVar) {
                SpecialLiveFragment.this.hideLoadingView(SpecialLiveFragment.this.mRootView);
                SpecialLiveFragment.this.a(hVar);
            }

            @Override // com.baidu.tieba.ala.alasquare.special_forum.model.a.InterfaceC0633a
            public void t(int i, String str) {
                SpecialLiveFragment.this.aT(i, str);
            }
        });
        lP(true);
        lO(true);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.mRootView.post(new Runnable() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.6
            @Override // java.lang.Runnable
            public void run() {
                SpecialLiveFragment.this.ak(SpecialLiveFragment.this.getFragmentActivity());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lO(boolean z) {
        if (!this.gpj.isLoading()) {
            if (z) {
                showLoadingView(this.mRootView);
            }
            this.gpj.loadData();
        }
    }

    private void bPH() {
        this.gjA = new AlaLiveUserNotifyController(getPageContext());
        this.gjB = new AlaLiveUserNotifyManager.AlaLiveNotifyListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.7
            @Override // com.baidu.ala.notify.AlaLiveUserNotifyManager.AlaLiveNotifyListener
            public void onCallBack() {
                if (SpecialLiveFragment.this.isPrimary()) {
                    SpecialLiveFragment.this.gjA.showNextNotifyDialog(0, AlaLiveUserNotifyManager.getInstance().getNotifyDataList());
                }
            }
        };
        AlaLiveUserNotifyManager.getInstance().addNotifyListener(this.gjB);
    }

    private void bPI() {
        this.gpl = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_MODEL_TASK) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z;
                SignData signData = null;
                SpecialLiveFragment.this.gpa.setClickable(true);
                if (customResponsedMessage != null && customResponsedMessage.getOrginalMessage().getTag() == SpecialLiveFragment.this.mBdUniqueId) {
                    SignMessage signMessage = (SignMessage) customResponsedMessage;
                    if (AntiHelper.bR(signMessage.mSignErrorCode, signMessage.mSignErrorString) && signMessage.signData != null) {
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
                        if (AntiHelper.bR(signMessage.mSignErrorCode, signMessage.mSignErrorString)) {
                            AntiHelper.bm(SpecialLiveFragment.this.mContext, signMessage.mSignErrorString);
                            return;
                        } else {
                            l.showToast(SpecialLiveFragment.this.mContext, SpecialLiveFragment.this.mContext.getString(R.string.special_sign_success_tip, Integer.valueOf(signData.sign_bonus_point)));
                            return;
                        }
                    }
                    if (signMessage.mSignErrorCode == 160002) {
                        SpecialLiveFragment.this.mCurState = 3;
                        SpecialLiveFragment.this.lP(false);
                    }
                    l.showToast(SpecialLiveFragment.this.mContext, signMessage.mSignErrorString);
                }
            }
        };
    }

    private void bPJ() {
        this.eZA = new LikeModel(getPageContext());
        this.eZA.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.9
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                SpecialLiveFragment.this.gpa.setClickable(true);
                if (SpecialLiveFragment.this.eZA.getErrorCode() == 22) {
                    l.showToast(SpecialLiveFragment.this.mContext, (int) R.string.had_liked_forum);
                } else if (AntiHelper.bR(SpecialLiveFragment.this.eZA.getErrorCode(), SpecialLiveFragment.this.eZA.getErrorString())) {
                    AntiHelper.bm(SpecialLiveFragment.this.mContext, SpecialLiveFragment.this.eZA.getErrorString());
                } else if (SpecialLiveFragment.this.eZA.getErrorCode() != 0) {
                    l.showToast(SpecialLiveFragment.this.mContext, SpecialLiveFragment.this.eZA.getErrorString());
                } else {
                    v vVar = (v) obj;
                    if (vVar != null) {
                        TbadkCoreApplication.getInst().addLikeForum(SpecialLiveFragment.this.mForumName);
                        vVar.setLike(1);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, vVar));
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
        bPM();
        bPK();
        if (!this.gpp) {
            bPN();
            if (this.eLl != null && this.eLl.getChildCount() > 1) {
                this.eLl.setCurrentItem(1);
            }
            if (!y.isEmpty(this.mData.tabInfoList)) {
                this.gpp = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aT(int i, String str) {
        if (TextUtils.isEmpty(str)) {
            showNetRefreshView(this.mRootView, this.mContext.getResources().getString(R.string.square_load_data_failed_tip), false);
        } else {
            showNetRefreshView(this.mRootView, str, false);
        }
    }

    private void bPK() {
        if (this.mData.gpQ) {
            if (bPL()) {
                this.mCurState = 3;
            } else {
                this.mCurState = 2;
            }
        } else {
            this.mCurState = 1;
        }
        lP(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bPL() {
        return this.mData.gpS.gpY;
    }

    private void bPM() {
        boolean c = this.gpi.c(this.mData.gpO);
        if (c) {
            this.gpi.stopPlay();
            this.gpi.onDestroy();
        }
        this.gpi.a(this.mData.gpO, c);
        if (c) {
            this.gpi.ad(this.goW);
        }
        this.gpi.startPlay();
    }

    private void bPN() {
        bPO();
        this.gmR.setData(this.gpk);
        this.gph.setData(this.fmA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(int i, float f) {
        if (this.gpi != null && f != 0.0f) {
            if (this.gpm <= i) {
                if (this.gpo && f >= 0.3f) {
                    this.gpi.lB(true);
                    this.gpi.pause();
                    this.gpo = false;
                }
            } else if (!this.gpo && f <= 0.3f) {
                this.gpi.lB(false);
                this.gpi.resume();
                this.gpo = true;
            }
            this.gpm = i;
        }
    }

    private void Tz() {
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds88);
        if (UtilHelper.canUseStyleImmersiveSticky() && this.mStatusBarView.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.mStatusBarView.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.mStatusBarView.setLayoutParams(layoutParams);
            this.mStatusBarView.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gpe.getLayoutParams();
            layoutParams2.height = layoutParams.height;
            this.gpe.setLayoutParams(layoutParams2);
            dimensionPixelSize = layoutParams.height + dimensionPixelSize;
        } else {
            this.mStatusBarView.setVisibility(8);
        }
        CollapsingToolbarLayout.LayoutParams layoutParams3 = (CollapsingToolbarLayout.LayoutParams) this.gpc.getLayoutParams();
        layoutParams3.height = dimensionPixelSize;
        this.gpc.setLayoutParams(layoutParams3);
    }

    private void bPO() {
        this.gpk.clear();
        this.fmA.clear();
        this.gpk.add(bPR());
        this.gpk.add(bPS());
        this.fmA.add(bPP());
        this.fmA.add(bPQ());
        if (!y.isEmpty(this.mData.tabInfoList)) {
            boolean z = b.bqh().getInt("chushou_game_tab", 1) == 1;
            for (int i = 0; i < this.mData.tabInfoList.size() && i < 10; i++) {
                SpecialLiveTabInfo specialLiveTabInfo = this.mData.tabInfoList.get(i);
                if (specialLiveTabInfo != null && (specialLiveTabInfo.tabId != 1108 || z)) {
                    this.fmA.add(specialLiveTabInfo);
                    TabData tabData = new TabData();
                    tabData.tabId = specialLiveTabInfo.tabId;
                    tabData.tabName = specialLiveTabInfo.tabName;
                    tabData.tabType = specialLiveTabInfo.tabType;
                    this.gpk.add(tabData);
                }
            }
        }
    }

    private SpecialLiveTabInfo bPP() {
        SpecialLiveTabInfo specialLiveTabInfo = new SpecialLiveTabInfo();
        specialLiveTabInfo.tabId = -901;
        specialLiveTabInfo.tabName = this.mContext.getResources().getString(R.string.special_concern_tab_title);
        return specialLiveTabInfo;
    }

    private SpecialLiveTabInfo bPQ() {
        SpecialLiveTabInfo specialLiveTabInfo = new SpecialLiveTabInfo();
        specialLiveTabInfo.tabId = -903;
        specialLiveTabInfo.tabName = this.mContext.getResources().getString(R.string.special_recommend_tab_title);
        return specialLiveTabInfo;
    }

    private TabData bPR() {
        TabData tabData = new TabData();
        tabData.tabId = -901;
        tabData.tabName = this.mContext.getResources().getString(R.string.special_concern_tab_title);
        return tabData;
    }

    private TabData bPS() {
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
                lO(false);
                AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
            }
            if (this.gpi != null) {
                if (isPrimary()) {
                    this.gpi.lB(false);
                    this.gpi.startPlay();
                    return;
                }
                this.gpi.lB(true);
                this.gpi.pause();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        hideNetRefreshView(this.mRootView);
        lO(true);
        AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.gpi != null) {
            this.gpi.lB(true);
            this.gpi.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gpi != null) {
            this.gpi.onChangeSkinType(i);
        }
        if (this.gmR != null) {
            ap.setBackgroundResource(this.gmR, R.color.cp_bg_line_d);
            this.gmR.onChangeSkinType(i);
        }
        if (this.gph != null) {
            this.gph.onChangeSkinType(i);
        }
        lQ(false);
        ap.setBackgroundColor(this.mStatusBarView, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.gpd, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.gpf, (int) R.color.cp_cont_b);
        ap.setBackgroundColor(this.goX, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.goY, R.color.cp_bg_line_e);
        ap.setViewTextColor(this.goZ, (int) R.color.cp_cont_b);
        ap.setViewTextColor(this.gpb, (int) R.color.cp_cont_j);
        ap.setViewTextColor(this.gpa, (int) R.color.cp_cont_g);
        ap.setBackgroundResource(this.gpa, R.drawable.frs_attention_btn_bg_selector);
        ap.setBackgroundResource(this.goV, R.color.cp_bg_line_c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lP(boolean z) {
        Drawable drawable;
        int i = R.drawable.frs_attention_btn_bg_selector;
        ap.setBackgroundResource(this.gpa, R.drawable.frs_attention_btn_bg_selector);
        int dimens = l.getDimens(this.mContext, R.dimen.ds10);
        String string = this.mContext.getResources().getString(R.string.attention);
        int i2 = R.color.cp_cont_a;
        if (this.mCurState == 1) {
            drawable = ap.getDrawable(R.drawable.icon_add_follow_blue_s);
            this.gpa.setClickable(true);
            if (!z) {
                TiebaStatic.log(new aq("c12889"));
            }
        } else if (this.mCurState == 2) {
            string = this.mContext.getResources().getString(R.string.sign);
            drawable = ap.getDrawable(R.drawable.icon_public_sign_blue_s);
            this.gpa.setClickable(true);
            if (!z) {
                TiebaStatic.log(new aq("c12891"));
            }
        } else if (this.mCurState == 3) {
            string = this.mContext.getResources().getString(R.string.signed);
            this.gpa.setClickable(false);
            i = R.drawable.special_sign_btn_signed_bg;
            i2 = R.color.cp_cont_d;
            drawable = null;
        } else {
            drawable = null;
        }
        ap.setBackgroundResource(this.gpa, i);
        ap.setViewTextColor(this.gpa, i2);
        this.gpa.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.gpa.setCompoundDrawablePadding(dimens);
        this.gpa.setText(string);
        bPT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lQ(boolean z) {
        if (this.gpg != null) {
            if (z) {
                ap.setNavbarIconSrc(this.gpg, R.drawable.selector_topbar_return_black, R.drawable.selector_topbar_return_black, TbadkCoreApplication.getInst().getSkinType());
            } else {
                ap.setNavbarIconSrc(this.gpg, R.drawable.selector_topbar_return_white, R.drawable.selector_topbar_return_white, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    private void bPT() {
        if (this.mData != null && this.mData.gpR != null && this.mCurState != 1) {
            int i = this.mData.gpR.level_id;
            String str = TextUtils.isEmpty(this.mData.gpR.level_name) ? "" : " " + this.mData.gpR.level_name;
            if (i >= 0) {
                this.gpb.setText("LV" + i + str);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.gpi != null) {
            this.gpi.onDestroy();
        }
        if (this.gpt != null) {
            MessageManager.getInstance().unRegisterListener(this.gpt);
        }
        if (this.gpl != null) {
            MessageManager.getInstance().unRegisterListener(this.gpl);
        }
        if (this.mSignChangedListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mSignChangedListener);
        }
        if (this.gpu != null) {
            MessageManager.getInstance().unRegisterListener(this.gpu);
        }
        if (this.gps != null) {
            MessageManager.getInstance().unRegisterListener(this.gps);
        }
        if (this.mAccountChangedListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mAccountChangedListener);
        }
        if (this.gpj != null) {
            this.gpj.onDestroy();
        }
        if (this.gjA != null) {
            this.gjA.onDestroy();
        }
        AlaLiveUserNotifyManager.getInstance().removeNotifyListener(this.gjB);
        hideLoadingView(this.mRootView);
        MessageManager.getInstance().unRegisterListener(this.eyc);
    }

    private void initViewPager() {
        this.gph = new a(getChildFragmentManager());
        this.eLl.setAdapter(this.gph);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends FragmentPagerAdapter {
        private SparseArray<SpecialForumTabBaseFragment> gpx;
        private List<SpecialLiveTabInfo> mData;

        public a(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.mData = new ArrayList();
            this.gpx = new SparseArray<>();
            this.gpx.put(0, ConcernTabFragment.ud(0));
        }

        public void setData(List<SpecialLiveTabInfo> list) {
            if (!y.isEmpty(list)) {
                this.mData.clear();
                this.mData.addAll(list);
                notifyDataSetChanged();
            }
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            SpecialForumTabBaseFragment ub = ub(i);
            if (ub == null) {
                if (i == 0) {
                    ub = ConcernTabFragment.ud(0);
                } else if (i == 1) {
                    ub = RecommendTabFragment.ue(1);
                } else if (i < this.mData.size() && this.mData.get(i) != null && this.mData.get(i).tabId == 1108) {
                    ub = GameTabFragment.Gz(this.mData.get(i).tabName);
                } else {
                    ub = OtherSubTabFragment.a(i, this.mData.get(i));
                }
                this.gpx.put(i, ub);
            }
            return ub;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.mData.size();
        }

        public SpecialForumTabBaseFragment ub(int i) {
            return this.gpx.get(i);
        }

        public void a(int i, TabData tabData) {
            if (this.gpx.get(i) != null) {
                this.gpx.get(i).setPrimary(true);
            }
        }

        public void onChangeSkinType(int i) {
            if (this.gpx != null && this.gpx.size() > 0) {
                int size = this.gpx.size();
                for (int i2 = 0; i2 < size; i2++) {
                    SpecialForumTabBaseFragment specialForumTabBaseFragment = this.gpx.get(i2);
                    if (specialForumTabBaseFragment != null) {
                        specialForumTabBaseFragment.onChangeSkinType(i);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ak(final Activity activity) {
        if (activity != null && !AlaSharedPrefHelper.getInstance().getBoolean(AlaSharedPrefConfig.SQUARE_GUIDE_MARK_MANAGE_TIP_SHOW, false)) {
            if (this.gpq != null) {
                this.gpq.dismiss();
            }
            final Handler handler = new Handler();
            final Runnable runnable = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.10
                @Override // java.lang.Runnable
                public void run() {
                    if (SpecialLiveFragment.this.gpq != null) {
                        SpecialLiveFragment.this.gpq.dismiss();
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
                    SpecialLiveFragment.this.gpq = null;
                    handler.removeCallbacks(runnable);
                }
            });
            dVar.y(activity.getWindow().getDecorView().findViewById(R.id.tabcontainer)).ak(20).af(false);
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
                            SpecialLiveFragment.this.gpq.dismiss();
                        }
                    });
                    ap.setViewTextColor(textView, (int) R.color.cp_cont_i);
                    bubbleLayout.Lf(ap.getColor(R.color.cp_link_tip_a_alpha95));
                    bubbleLayout.aR(activity.getResources().getDimensionPixelSize(R.dimen.ds216));
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
            this.gpq = dVar.mi();
            this.gpq.show(activity);
            handler.postDelayed(runnable, 5000L);
        }
    }
}
