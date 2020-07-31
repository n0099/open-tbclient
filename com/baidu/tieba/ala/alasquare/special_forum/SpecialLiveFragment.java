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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.x;
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
/* loaded from: classes4.dex */
public class SpecialLiveFragment extends BaseFragment {
    private AppBarLayout WP;
    private CustomViewPager dYQ;
    private LikeModel emT;
    private AlaLiveUserNotifyController fsN;
    private AlaLiveUserNotifyManager.AlaLiveNotifyListener fsO;
    private ScrollHorizontalTabView fwa;
    private float fxZ;
    private CollapsingToolbarLayout fya;
    private View fyb;
    private ObservedChangeFrameLayout fyc;
    private RelativeLayout fyd;
    private View fye;
    private TextView fyf;
    private TextView fyg;
    private TextView fyh;
    private RelativeLayout fyi;
    private View fyj;
    private View fyk;
    private TextView fyl;
    private ImageView fym;
    private a fyn;
    private e fyo;
    private com.baidu.tieba.ala.alasquare.special_forum.model.a fyp;
    private List<TabData> fyq;
    private List<SpecialLiveTabInfo> fyr;
    private CustomMessageListener fys;
    private int fyt;
    private String fyu;
    private c fyx;
    private BdUniqueId mBdUniqueId;
    private Context mContext;
    private h mData;
    private String mForumId;
    private String mForumName;
    private View mRootView;
    private View mStatusBarView;
    private boolean fyv = true;
    private int mCurState = 1;
    private boolean fyw = false;
    private Handler mHandler = new Handler();
    private Runnable fyy = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.1
        @Override // java.lang.Runnable
        public void run() {
            if (SpecialLiveFragment.this.fyo != null) {
                SpecialLiveFragment.this.fyo.bxW();
            }
        }
    };
    private CustomMessageListener dMl = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            SpecialLiveFragment.this.mHandler.removeCallbacks(SpecialLiveFragment.this.fyy);
            SpecialLiveFragment.this.mHandler.postDelayed(SpecialLiveFragment.this.fyy, 500L);
        }
    };
    private CustomMessageListener fyz = new CustomMessageListener(CmdConfigCustom.CMD_FORCE_REFRESH) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2) {
                    if ("FrsLiveLive".equals(split[0])) {
                        SpecialLiveFragment.this.kn(false);
                    }
                    SpecialForumTabBaseFragment qw = SpecialLiveFragment.this.fyn.qw(SpecialLiveFragment.this.dYQ.getCurrentItem());
                    if (qw != null) {
                        qw.bxR();
                    }
                }
            }
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && SpecialLiveFragment.this.fyp != null && !TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                SpecialLiveFragment.this.kn(false);
            }
        }
    };
    private final CustomMessageListener fyA = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            u uVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof u) && (uVar = (u) customResponsedMessage.getData()) != null && SpecialLiveFragment.this.mForumId.equals(uVar.getFid())) {
                if (uVar.isLike() == 1) {
                    if (SpecialLiveFragment.this.bxH()) {
                        SpecialLiveFragment.this.mCurState = 3;
                    } else {
                        SpecialLiveFragment.this.mCurState = 2;
                    }
                } else {
                    SpecialLiveFragment.this.mCurState = 1;
                }
                SpecialLiveFragment.this.ko(false);
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
                SpecialLiveFragment.this.ko(false);
                l.showToast(SpecialLiveFragment.this.getPageContext().getPageActivity(), SpecialLiveFragment.this.mContext.getString(R.string.special_sign_success_tip, Integer.valueOf(signData.sign_bonus_point)));
            }
        }
    };
    private final CustomMessageListener fyB = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_SPECIAL_CONCERN_TAB_TAB_ICON) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                Boolean bool = (Boolean) customResponsedMessage.getData();
                if (!x.isEmpty(SpecialLiveFragment.this.fyq)) {
                    ((TabData) SpecialLiveFragment.this.fyq.get(0)).extra = bool;
                    SpecialLiveFragment.this.fwa.setData(SpecialLiveFragment.this.fyq);
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
                this.fyu = sb.toString();
            } else {
                this.mForumName = this.mContext.getResources().getString(R.string.ala_ufan_bar_title);
                this.fyu = this.mForumName + string2;
            }
            bxF();
            bxD();
            bxE();
            MessageManager.getInstance().registerListener(this.fys);
            MessageManager.getInstance().registerListener(this.fyA);
            MessageManager.getInstance().registerListener(this.mSignChangedListener);
            MessageManager.getInstance().registerListener(this.fyB);
            MessageManager.getInstance().registerListener(this.fyz);
            MessageManager.getInstance().registerListener(this.mAccountChangedListener);
            MessageManager.getInstance().registerListener(this.dMl);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(R.layout.special_live_layout, (ViewGroup) null);
        this.WP = (AppBarLayout) this.mRootView.findViewById(R.id.special_app_bar_layout);
        this.fya = (CollapsingToolbarLayout) this.mRootView.findViewById(R.id.special_collapse_layout);
        this.mStatusBarView = this.mRootView.findViewById(R.id.statusbar_view);
        this.fyc = (ObservedChangeFrameLayout) this.mRootView.findViewById(R.id.live_container);
        this.mBdUniqueId = BdUniqueId.gen();
        this.fyd = (RelativeLayout) this.mRootView.findViewById(R.id.function_container);
        this.fye = this.mRootView.findViewById(R.id.function_bottom_space);
        this.fyf = (TextView) this.mRootView.findViewById(R.id.function_title);
        this.fyf.setText(this.fyu);
        this.fyg = (TextView) this.mRootView.findViewById(R.id.function_btn);
        this.fyg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!j.isNetWorkAvailable()) {
                    SpecialLiveFragment.this.showToast(R.string.neterror);
                    return;
                }
                if (!TbadkCoreApplication.isLogin()) {
                    bf.skipToLoginActivity(SpecialLiveFragment.this.mContext);
                }
                if (SpecialLiveFragment.this.mCurState == 1) {
                    SpecialLiveFragment.this.fyg.setClickable(false);
                    SpecialLiveFragment.this.emT.fz(SpecialLiveFragment.this.mForumName, SpecialLiveFragment.this.mForumId);
                    TiebaStatic.log(new ap("c12890"));
                } else if (SpecialLiveFragment.this.mCurState == 2) {
                    SpecialLiveFragment.this.fyg.setClickable(false);
                    ForumData forumData = new ForumData();
                    forumData.setId(SpecialLiveFragment.this.mForumId);
                    forumData.setName(SpecialLiveFragment.this.mForumName);
                    CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_SIGN_MODEL_TASK, forumData);
                    customMessage.setTag(SpecialLiveFragment.this.mBdUniqueId);
                    MessageManager.getInstance().sendMessage(customMessage);
                    TiebaStatic.log(new ap("c12892"));
                }
            }
        });
        this.fyh = (TextView) this.mRootView.findViewById(R.id.function_level_desc);
        this.fyi = (RelativeLayout) this.mRootView.findViewById(R.id.navigation_layout);
        this.fyk = this.mRootView.findViewById(R.id.navigation_top_space);
        this.fyj = this.mRootView.findViewById(R.id.navigation_bg);
        this.fyl = (TextView) this.mRootView.findViewById(R.id.navigation_title);
        this.fyl.setText(this.fyu);
        this.fym = (ImageView) this.mRootView.findViewById(R.id.navigation_back_img);
        this.fym.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, SpecialLiveFragment.this.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        });
        this.fwa = (ScrollHorizontalTabView) this.mRootView.findViewById(R.id.scroll_tab_view);
        this.dYQ = (CustomViewPager) this.mRootView.findViewById(R.id.special_view_pager);
        initViewPager();
        this.fwa.setViewPager(this.dYQ);
        this.fwa.setScrollTabPageListener(new ScrollHorizontalTabView.ScrollTabPageListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.2
            @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
            public boolean onPrePageSelect(int i, TabData tabData) {
                return true;
            }

            @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
            public void onPageSelected(int i, TabData tabData) {
                if (i != 0 || TbadkCoreApplication.isLogin()) {
                    if (SpecialLiveFragment.this.fyn != null) {
                        SpecialLiveFragment.this.fyn.a(i, tabData);
                        return;
                    }
                    return;
                }
                bf.skipToLoginActivity(SpecialLiveFragment.this.getPageContext().getPageActivity());
                if (SpecialLiveFragment.this.dYQ != null) {
                    SpecialLiveFragment.this.dYQ.setCurrentItem(1);
                }
            }

            @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
            public void onPageScrolled(int i, float f, int i2) {
            }
        });
        this.WP.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.3
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                int abs = Math.abs(i);
                if (abs == 0) {
                    SpecialLiveFragment.this.fyj.setVisibility(8);
                    SpecialLiveFragment.this.fyl.setVisibility(8);
                } else {
                    SpecialLiveFragment.this.fyj.setVisibility(0);
                    SpecialLiveFragment.this.fyl.setVisibility(0);
                }
                SpecialLiveFragment.this.kp(((float) abs) > SpecialLiveFragment.this.fxZ / 2.0f);
                float abs2 = Math.abs(abs / SpecialLiveFragment.this.fxZ);
                SpecialLiveFragment.this.fyj.setAlpha(abs2);
                SpecialLiveFragment.this.fyl.setAlpha(abs2);
                SpecialLiveFragment.this.g(abs, abs2);
            }
        });
        this.fyb = this.mRootView.findViewById(R.id.square_main_top_divider_line);
        this.fyc.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.4
            @Override // com.baidu.tbadk.widget.layout.e
            public void d(View view, int i, int i2, int i3, int i4) {
                SpecialLiveFragment.this.fxZ = (SpecialLiveFragment.this.fyc.getMeasuredHeight() + SpecialLiveFragment.this.fyd.getMeasuredHeight()) - SpecialLiveFragment.this.fyi.getMeasuredHeight();
                SpecialLiveFragment.this.fya.setMinimumHeight(SpecialLiveFragment.this.fyi.getMeasuredHeight());
            }
        });
        Iv();
        this.fyq = new ArrayList();
        this.fyr = new ArrayList();
        this.fyo = new e(getPageContext());
        this.fyp = new com.baidu.tieba.ala.alasquare.special_forum.model.a(getPageContext(), new a.InterfaceC0546a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.5
            @Override // com.baidu.tieba.ala.alasquare.special_forum.model.a.InterfaceC0546a
            public void b(h hVar) {
                SpecialLiveFragment.this.hideLoadingView(SpecialLiveFragment.this.mRootView);
                SpecialLiveFragment.this.a(hVar);
            }

            @Override // com.baidu.tieba.ala.alasquare.special_forum.model.a.InterfaceC0546a
            public void aB(int i, String str) {
                SpecialLiveFragment.this.aF(i, str);
            }
        });
        ko(true);
        kn(true);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.mRootView.post(new Runnable() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.6
            @Override // java.lang.Runnable
            public void run() {
                SpecialLiveFragment.this.ah(SpecialLiveFragment.this.getFragmentActivity());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kn(boolean z) {
        if (!this.fyp.isLoading()) {
            if (z) {
                showLoadingView(this.mRootView);
            }
            this.fyp.loadData();
        }
    }

    private void bxD() {
        this.fsN = new AlaLiveUserNotifyController(getPageContext());
        this.fsO = new AlaLiveUserNotifyManager.AlaLiveNotifyListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.7
            @Override // com.baidu.ala.notify.AlaLiveUserNotifyManager.AlaLiveNotifyListener
            public void onCallBack() {
                if (SpecialLiveFragment.this.isPrimary()) {
                    SpecialLiveFragment.this.fsN.showNextNotifyDialog(0, AlaLiveUserNotifyManager.getInstance().getNotifyDataList());
                }
            }
        };
        AlaLiveUserNotifyManager.getInstance().addNotifyListener(this.fsO);
    }

    private void bxE() {
        this.fys = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_MODEL_TASK) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z;
                SignData signData = null;
                SpecialLiveFragment.this.fyg.setClickable(true);
                if (customResponsedMessage != null && customResponsedMessage.getOrginalMessage().getTag() == SpecialLiveFragment.this.mBdUniqueId) {
                    SignMessage signMessage = (SignMessage) customResponsedMessage;
                    if (AntiHelper.bB(signMessage.mSignErrorCode, signMessage.mSignErrorString) && signMessage.signData != null) {
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
                        if (AntiHelper.bB(signMessage.mSignErrorCode, signMessage.mSignErrorString)) {
                            AntiHelper.aW(SpecialLiveFragment.this.mContext, signMessage.mSignErrorString);
                            return;
                        } else {
                            l.showToast(SpecialLiveFragment.this.mContext, SpecialLiveFragment.this.mContext.getString(R.string.special_sign_success_tip, Integer.valueOf(signData.sign_bonus_point)));
                            return;
                        }
                    }
                    if (signMessage.mSignErrorCode == 160002) {
                        SpecialLiveFragment.this.mCurState = 3;
                        SpecialLiveFragment.this.ko(false);
                    }
                    l.showToast(SpecialLiveFragment.this.mContext, signMessage.mSignErrorString);
                }
            }
        };
    }

    private void bxF() {
        this.emT = new LikeModel(getPageContext());
        this.emT.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.9
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                SpecialLiveFragment.this.fyg.setClickable(true);
                if (SpecialLiveFragment.this.emT.getErrorCode() == 22) {
                    l.showToast(SpecialLiveFragment.this.mContext, R.string.had_liked_forum);
                } else if (AntiHelper.bB(SpecialLiveFragment.this.emT.getErrorCode(), SpecialLiveFragment.this.emT.getErrorString())) {
                    AntiHelper.aW(SpecialLiveFragment.this.mContext, SpecialLiveFragment.this.emT.getErrorString());
                } else if (SpecialLiveFragment.this.emT.getErrorCode() != 0) {
                    l.showToast(SpecialLiveFragment.this.mContext, SpecialLiveFragment.this.emT.getErrorString());
                } else {
                    u uVar = (u) obj;
                    if (uVar != null) {
                        TbadkCoreApplication.getInst().addLikeForum(SpecialLiveFragment.this.mForumName);
                        uVar.setLike(1);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, uVar));
                        l.showToast(SpecialLiveFragment.this.mContext, R.string.attention_success);
                        return;
                    }
                    l.showToast(SpecialLiveFragment.this.mContext, R.string.neterror);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(h hVar) {
        this.mData = hVar;
        bxI();
        bxG();
        if (!this.fyw) {
            bxJ();
            if (this.dYQ != null && this.dYQ.getChildCount() > 1) {
                this.dYQ.setCurrentItem(1);
            }
            if (!x.isEmpty(this.mData.tabInfoList)) {
                this.fyw = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aF(int i, String str) {
        if (TextUtils.isEmpty(str)) {
            showNetRefreshView(this.mRootView, this.mContext.getResources().getString(R.string.square_load_data_failed_tip), false);
        } else {
            showNetRefreshView(this.mRootView, str, false);
        }
    }

    private void bxG() {
        if (this.mData.fyX) {
            if (bxH()) {
                this.mCurState = 3;
            } else {
                this.mCurState = 2;
            }
        } else {
            this.mCurState = 1;
        }
        ko(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bxH() {
        return this.mData.fyZ.fzf;
    }

    private void bxI() {
        boolean c = this.fyo.c(this.mData.fyV);
        if (c) {
            this.fyo.stopPlay();
            this.fyo.onDestroy();
        }
        this.fyo.a(this.mData.fyV, c);
        if (c) {
            this.fyo.W(this.fyc);
        }
        this.fyo.startPlay();
    }

    private void bxJ() {
        bxK();
        this.fwa.setData(this.fyq);
        this.fyn.setData(this.fyr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(int i, float f) {
        if (this.fyo != null && f != 0.0f) {
            if (this.fyt <= i) {
                if (this.fyv && f >= 0.3f) {
                    this.fyo.ka(true);
                    this.fyo.pause();
                    this.fyv = false;
                }
            } else if (!this.fyv && f <= 0.3f) {
                this.fyo.ka(false);
                this.fyo.resume();
                this.fyv = true;
            }
            this.fyt = i;
        }
    }

    private void Iv() {
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds88);
        if (UtilHelper.canUseStyleImmersiveSticky() && this.mStatusBarView.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.mStatusBarView.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.mStatusBarView.setLayoutParams(layoutParams);
            this.mStatusBarView.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fyk.getLayoutParams();
            layoutParams2.height = layoutParams.height;
            this.fyk.setLayoutParams(layoutParams2);
            dimensionPixelSize = layoutParams.height + dimensionPixelSize;
        } else {
            this.mStatusBarView.setVisibility(8);
        }
        CollapsingToolbarLayout.LayoutParams layoutParams3 = (CollapsingToolbarLayout.LayoutParams) this.fyi.getLayoutParams();
        layoutParams3.height = dimensionPixelSize;
        this.fyi.setLayoutParams(layoutParams3);
    }

    private void bxK() {
        this.fyq.clear();
        this.fyr.clear();
        this.fyq.add(bxN());
        this.fyq.add(bxO());
        this.fyr.add(bxL());
        this.fyr.add(bxM());
        if (!x.isEmpty(this.mData.tabInfoList)) {
            boolean z = b.aZP().getInt("chushou_game_tab", 1) == 1;
            for (int i = 0; i < this.mData.tabInfoList.size() && i < 10; i++) {
                SpecialLiveTabInfo specialLiveTabInfo = this.mData.tabInfoList.get(i);
                if (specialLiveTabInfo != null && (specialLiveTabInfo.tabId != 1108 || z)) {
                    this.fyr.add(specialLiveTabInfo);
                    TabData tabData = new TabData();
                    tabData.tabId = specialLiveTabInfo.tabId;
                    tabData.tabName = specialLiveTabInfo.tabName;
                    tabData.tabType = specialLiveTabInfo.tabType;
                    this.fyq.add(tabData);
                }
            }
        }
    }

    private SpecialLiveTabInfo bxL() {
        SpecialLiveTabInfo specialLiveTabInfo = new SpecialLiveTabInfo();
        specialLiveTabInfo.tabId = OpenBdussResult.ERROR_CODE_NOT_LOGIN;
        specialLiveTabInfo.tabName = this.mContext.getResources().getString(R.string.special_concern_tab_title);
        return specialLiveTabInfo;
    }

    private SpecialLiveTabInfo bxM() {
        SpecialLiveTabInfo specialLiveTabInfo = new SpecialLiveTabInfo();
        specialLiveTabInfo.tabId = -903;
        specialLiveTabInfo.tabName = this.mContext.getResources().getString(R.string.special_recommend_tab_title);
        return specialLiveTabInfo;
    }

    private TabData bxN() {
        TabData tabData = new TabData();
        tabData.tabId = OpenBdussResult.ERROR_CODE_NOT_LOGIN;
        tabData.tabName = this.mContext.getResources().getString(R.string.special_concern_tab_title);
        return tabData;
    }

    private TabData bxO() {
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
                kn(false);
                AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
            }
            if (this.fyo != null) {
                if (isPrimary()) {
                    this.fyo.ka(false);
                    this.fyo.startPlay();
                    return;
                }
                this.fyo.ka(true);
                this.fyo.pause();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        hideNetRefreshView(this.mRootView);
        kn(true);
        AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.fyo != null) {
            this.fyo.ka(true);
            this.fyo.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fyo != null) {
            this.fyo.onChangeSkinType(i);
        }
        if (this.fwa != null) {
            ao.setBackgroundResource(this.fwa, R.color.cp_bg_line_d);
            this.fwa.onChangeSkinType(i);
        }
        if (this.fyn != null) {
            this.fyn.onChangeSkinType(i);
        }
        kp(false);
        ao.setBackgroundColor(this.mStatusBarView, R.color.cp_bg_line_d);
        ao.setBackgroundColor(this.fyj, R.color.cp_bg_line_d);
        ao.setViewTextColor(this.fyl, R.color.cp_cont_b);
        ao.setBackgroundColor(this.fyd, R.color.cp_bg_line_d);
        ao.setBackgroundColor(this.fye, R.color.cp_bg_line_e);
        ao.setViewTextColor(this.fyf, R.color.cp_cont_b);
        ao.setViewTextColor(this.fyh, R.color.cp_cont_j);
        ao.setViewTextColor(this.fyg, R.color.cp_cont_g);
        ao.setBackgroundResource(this.fyg, R.drawable.frs_attention_btn_bg_selector);
        ao.setBackgroundResource(this.fyb, R.color.cp_bg_line_c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ko(boolean z) {
        Drawable drawable;
        ao.setBackgroundResource(this.fyg, R.drawable.frs_attention_btn_bg_selector);
        int dimens = l.getDimens(this.mContext, R.dimen.ds10);
        String string = this.mContext.getResources().getString(R.string.attention);
        int i = R.drawable.frs_attention_btn_bg_selector;
        int i2 = R.color.cp_cont_a;
        if (this.mCurState == 1) {
            drawable = ao.getDrawable(R.drawable.icon_add_follow_blue_s);
            this.fyg.setClickable(true);
            if (!z) {
                TiebaStatic.log(new ap("c12889"));
            }
        } else if (this.mCurState == 2) {
            string = this.mContext.getResources().getString(R.string.sign);
            drawable = ao.getDrawable(R.drawable.icon_public_sign_blue_s);
            this.fyg.setClickable(true);
            if (!z) {
                TiebaStatic.log(new ap("c12891"));
            }
        } else if (this.mCurState == 3) {
            string = this.mContext.getResources().getString(R.string.signed);
            this.fyg.setClickable(false);
            i = R.drawable.special_sign_btn_signed_bg;
            i2 = R.color.cp_cont_d;
            drawable = null;
        } else {
            drawable = null;
        }
        ao.setBackgroundResource(this.fyg, i);
        ao.setViewTextColor(this.fyg, i2);
        this.fyg.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.fyg.setCompoundDrawablePadding(dimens);
        this.fyg.setText(string);
        bxP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kp(boolean z) {
        if (this.fym != null) {
            if (z) {
                ao.setNavbarIconSrc(this.fym, R.drawable.selector_topbar_return_black, R.drawable.selector_topbar_return_black, TbadkCoreApplication.getInst().getSkinType());
            } else {
                ao.setNavbarIconSrc(this.fym, R.drawable.selector_topbar_return_white, R.drawable.selector_topbar_return_white, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    private void bxP() {
        if (this.mData != null && this.mData.fyY != null && this.mCurState != 1) {
            int i = this.mData.fyY.level_id;
            String str = TextUtils.isEmpty(this.mData.fyY.level_name) ? "" : " " + this.mData.fyY.level_name;
            if (i >= 0) {
                this.fyh.setText("LV" + i + str);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.fyo != null) {
            this.fyo.onDestroy();
        }
        if (this.fyA != null) {
            MessageManager.getInstance().unRegisterListener(this.fyA);
        }
        if (this.fys != null) {
            MessageManager.getInstance().unRegisterListener(this.fys);
        }
        if (this.mSignChangedListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mSignChangedListener);
        }
        if (this.fyB != null) {
            MessageManager.getInstance().unRegisterListener(this.fyB);
        }
        if (this.fyz != null) {
            MessageManager.getInstance().unRegisterListener(this.fyz);
        }
        if (this.mAccountChangedListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mAccountChangedListener);
        }
        if (this.fyp != null) {
            this.fyp.onDestroy();
        }
        if (this.fsN != null) {
            this.fsN.onDestroy();
        }
        AlaLiveUserNotifyManager.getInstance().removeNotifyListener(this.fsO);
        hideLoadingView(this.mRootView);
        MessageManager.getInstance().unRegisterListener(this.dMl);
    }

    private void initViewPager() {
        this.fyn = new a(getChildFragmentManager());
        this.dYQ.setAdapter(this.fyn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends FragmentPagerAdapter {
        private SparseArray<SpecialForumTabBaseFragment> fyE;
        private List<SpecialLiveTabInfo> mData;

        public a(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.mData = new ArrayList();
            this.fyE = new SparseArray<>();
            this.fyE.put(0, ConcernTabFragment.qy(0));
        }

        public void setData(List<SpecialLiveTabInfo> list) {
            if (!x.isEmpty(list)) {
                this.mData.clear();
                this.mData.addAll(list);
                notifyDataSetChanged();
            }
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            SpecialForumTabBaseFragment qw = qw(i);
            if (qw == null) {
                if (i == 0) {
                    qw = ConcernTabFragment.qy(0);
                } else if (i == 1) {
                    qw = RecommendTabFragment.qz(1);
                } else if (i < this.mData.size() && this.mData.get(i) != null && this.mData.get(i).tabId == 1108) {
                    qw = GameTabFragment.Ci(this.mData.get(i).tabName);
                } else {
                    qw = OtherSubTabFragment.a(i, this.mData.get(i));
                }
                this.fyE.put(i, qw);
            }
            return qw;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.mData.size();
        }

        public SpecialForumTabBaseFragment qw(int i) {
            return this.fyE.get(i);
        }

        public void a(int i, TabData tabData) {
            if (this.fyE.get(i) != null) {
                this.fyE.get(i).setPrimary(true);
            }
        }

        public void onChangeSkinType(int i) {
            if (this.fyE != null && this.fyE.size() > 0) {
                int size = this.fyE.size();
                for (int i2 = 0; i2 < size; i2++) {
                    SpecialForumTabBaseFragment specialForumTabBaseFragment = this.fyE.get(i2);
                    if (specialForumTabBaseFragment != null) {
                        specialForumTabBaseFragment.onChangeSkinType(i);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ah(final Activity activity) {
        if (activity != null && !AlaSharedPrefHelper.getInstance().getBoolean(AlaSharedPrefConfig.SQUARE_GUIDE_MARK_MANAGE_TIP_SHOW, false)) {
            if (this.fyx != null) {
                this.fyx.dismiss();
            }
            final Handler handler = new Handler();
            final Runnable runnable = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.10
                @Override // java.lang.Runnable
                public void run() {
                    if (SpecialLiveFragment.this.fyx != null) {
                        SpecialLiveFragment.this.fyx.dismiss();
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
                    SpecialLiveFragment.this.fyx = null;
                    handler.removeCallbacks(runnable);
                }
            });
            dVar.y(activity.getWindow().getDecorView().findViewById(R.id.tabcontainer)).ah(20).af(false);
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
                            SpecialLiveFragment.this.fyx.dismiss();
                        }
                    });
                    ao.setViewTextColor(textView, R.color.cp_cont_i);
                    bubbleLayout.GU(ao.getColor(R.color.cp_link_tip_a_alpha95));
                    bubbleLayout.aB(activity.getResources().getDimensionPixelSize(R.dimen.ds216));
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
            this.fyx = dVar.kE();
            this.fyx.show(activity);
            handler.postDelayed(runnable, 5000L);
        }
    }
}
