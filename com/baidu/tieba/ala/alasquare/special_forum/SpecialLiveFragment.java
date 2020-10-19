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
    private AppBarLayout Yg;
    private LikeModel eLp;
    private List<SpecialLiveTabInfo> eYk;
    private CustomViewPager ewX;
    private AlaLiveUserNotifyController fTH;
    private AlaLiveUserNotifyManager.AlaLiveNotifyListener fTI;
    private ScrollHorizontalTabView fWZ;
    private float fZb;
    private CollapsingToolbarLayout fZc;
    private View fZd;
    private ObservedChangeFrameLayout fZe;
    private RelativeLayout fZf;
    private View fZg;
    private TextView fZh;
    private TextView fZi;
    private TextView fZj;
    private RelativeLayout fZk;
    private View fZl;
    private View fZm;
    private TextView fZn;
    private ImageView fZo;
    private a fZp;
    private e fZq;
    private com.baidu.tieba.ala.alasquare.special_forum.model.a fZr;
    private List<TabData> fZs;
    private CustomMessageListener fZt;
    private int fZu;
    private String fZv;
    private c fZy;
    private BdUniqueId mBdUniqueId;
    private Context mContext;
    private h mData;
    private String mForumId;
    private String mForumName;
    private View mRootView;
    private View mStatusBarView;
    private boolean fZw = true;
    private int mCurState = 1;
    private boolean fZx = false;
    private Handler mHandler = new Handler();
    private Runnable fZz = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.1
        @Override // java.lang.Runnable
        public void run() {
            if (SpecialLiveFragment.this.fZq != null) {
                SpecialLiveFragment.this.fZq.bKW();
            }
        }
    };
    private CustomMessageListener ejK = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            SpecialLiveFragment.this.mHandler.removeCallbacks(SpecialLiveFragment.this.fZz);
            SpecialLiveFragment.this.mHandler.postDelayed(SpecialLiveFragment.this.fZz, 500L);
        }
    };
    private CustomMessageListener fZA = new CustomMessageListener(CmdConfigCustom.CMD_FORCE_REFRESH) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2) {
                    if ("FrsLiveLive".equals(split[0])) {
                        SpecialLiveFragment.this.ln(false);
                    }
                    SpecialForumTabBaseFragment ty = SpecialLiveFragment.this.fZp.ty(SpecialLiveFragment.this.ewX.getCurrentItem());
                    if (ty != null) {
                        ty.bKT();
                    }
                }
            }
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && SpecialLiveFragment.this.fZr != null && !TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                SpecialLiveFragment.this.ln(false);
            }
        }
    };
    private final CustomMessageListener fZB = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            v vVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof v) && (vVar = (v) customResponsedMessage.getData()) != null && SpecialLiveFragment.this.mForumId.equals(vVar.getFid())) {
                if (vVar.isLike() == 1) {
                    if (SpecialLiveFragment.this.bKJ()) {
                        SpecialLiveFragment.this.mCurState = 3;
                    } else {
                        SpecialLiveFragment.this.mCurState = 2;
                    }
                } else {
                    SpecialLiveFragment.this.mCurState = 1;
                }
                SpecialLiveFragment.this.lo(false);
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
                SpecialLiveFragment.this.lo(false);
                l.showToast(SpecialLiveFragment.this.getPageContext().getPageActivity(), SpecialLiveFragment.this.mContext.getString(R.string.special_sign_success_tip, Integer.valueOf(signData.sign_bonus_point)));
            }
        }
    };
    private final CustomMessageListener fZC = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_SPECIAL_CONCERN_TAB_TAB_ICON) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                Boolean bool = (Boolean) customResponsedMessage.getData();
                if (!y.isEmpty(SpecialLiveFragment.this.fZs)) {
                    ((TabData) SpecialLiveFragment.this.fZs.get(0)).extra = bool;
                    SpecialLiveFragment.this.fWZ.setData(SpecialLiveFragment.this.fZs);
                    if (bool.booleanValue()) {
                        TiebaStatic.log("c12898");
                    }
                }
            }
        }
    };

    public static SpecialLiveFragment ec(String str, String str2) {
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
                this.fZv = sb.toString();
            } else {
                this.mForumName = this.mContext.getResources().getString(R.string.ala_ufan_bar_title);
                this.fZv = this.mForumName + string2;
            }
            bKH();
            bKF();
            bKG();
            MessageManager.getInstance().registerListener(this.fZt);
            MessageManager.getInstance().registerListener(this.fZB);
            MessageManager.getInstance().registerListener(this.mSignChangedListener);
            MessageManager.getInstance().registerListener(this.fZC);
            MessageManager.getInstance().registerListener(this.fZA);
            MessageManager.getInstance().registerListener(this.mAccountChangedListener);
            MessageManager.getInstance().registerListener(this.ejK);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(R.layout.special_live_layout, (ViewGroup) null);
        this.Yg = (AppBarLayout) this.mRootView.findViewById(R.id.special_app_bar_layout);
        this.fZc = (CollapsingToolbarLayout) this.mRootView.findViewById(R.id.special_collapse_layout);
        this.mStatusBarView = this.mRootView.findViewById(R.id.statusbar_view);
        this.fZe = (ObservedChangeFrameLayout) this.mRootView.findViewById(R.id.live_container);
        this.mBdUniqueId = BdUniqueId.gen();
        this.fZf = (RelativeLayout) this.mRootView.findViewById(R.id.function_container);
        this.fZg = this.mRootView.findViewById(R.id.function_bottom_space);
        this.fZh = (TextView) this.mRootView.findViewById(R.id.function_title);
        this.fZh.setText(this.fZv);
        this.fZi = (TextView) this.mRootView.findViewById(R.id.function_btn);
        this.fZi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.19
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
                    SpecialLiveFragment.this.fZi.setClickable(false);
                    SpecialLiveFragment.this.eLp.gk(SpecialLiveFragment.this.mForumName, SpecialLiveFragment.this.mForumId);
                    TiebaStatic.log(new aq("c12890"));
                } else if (SpecialLiveFragment.this.mCurState == 2) {
                    SpecialLiveFragment.this.fZi.setClickable(false);
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
        this.fZj = (TextView) this.mRootView.findViewById(R.id.function_level_desc);
        this.fZk = (RelativeLayout) this.mRootView.findViewById(R.id.navigation_layout);
        this.fZm = this.mRootView.findViewById(R.id.navigation_top_space);
        this.fZl = this.mRootView.findViewById(R.id.navigation_bg);
        this.fZn = (TextView) this.mRootView.findViewById(R.id.navigation_title);
        this.fZn.setText(this.fZv);
        this.fZo = (ImageView) this.mRootView.findViewById(R.id.navigation_back_img);
        this.fZo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, SpecialLiveFragment.this.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        });
        this.fWZ = (ScrollHorizontalTabView) this.mRootView.findViewById(R.id.scroll_tab_view);
        this.ewX = (CustomViewPager) this.mRootView.findViewById(R.id.special_view_pager);
        initViewPager();
        this.fWZ.setViewPager(this.ewX);
        this.fWZ.setScrollTabPageListener(new ScrollHorizontalTabView.ScrollTabPageListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.2
            @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
            public boolean onPrePageSelect(int i, TabData tabData) {
                return true;
            }

            @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
            public void onPageSelected(int i, TabData tabData) {
                if (i != 0 || TbadkCoreApplication.isLogin()) {
                    if (SpecialLiveFragment.this.fZp != null) {
                        SpecialLiveFragment.this.fZp.a(i, tabData);
                        return;
                    }
                    return;
                }
                bg.skipToLoginActivity(SpecialLiveFragment.this.getPageContext().getPageActivity());
                if (SpecialLiveFragment.this.ewX != null) {
                    SpecialLiveFragment.this.ewX.setCurrentItem(1);
                }
            }

            @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
            public void onPageScrolled(int i, float f, int i2) {
            }
        });
        this.Yg.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.3
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                int abs = Math.abs(i);
                if (abs == 0) {
                    SpecialLiveFragment.this.fZl.setVisibility(8);
                    SpecialLiveFragment.this.fZn.setVisibility(8);
                } else {
                    SpecialLiveFragment.this.fZl.setVisibility(0);
                    SpecialLiveFragment.this.fZn.setVisibility(0);
                }
                SpecialLiveFragment.this.lp(((float) abs) > SpecialLiveFragment.this.fZb / 2.0f);
                float abs2 = Math.abs(abs / SpecialLiveFragment.this.fZb);
                SpecialLiveFragment.this.fZl.setAlpha(abs2);
                SpecialLiveFragment.this.fZn.setAlpha(abs2);
                SpecialLiveFragment.this.g(abs, abs2);
            }
        });
        this.fZd = this.mRootView.findViewById(R.id.square_main_top_divider_line);
        this.fZe.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.4
            @Override // com.baidu.tbadk.widget.layout.e
            public void d(View view, int i, int i2, int i3, int i4) {
                SpecialLiveFragment.this.fZb = (SpecialLiveFragment.this.fZe.getMeasuredHeight() + SpecialLiveFragment.this.fZf.getMeasuredHeight()) - SpecialLiveFragment.this.fZk.getMeasuredHeight();
                SpecialLiveFragment.this.fZc.setMinimumHeight(SpecialLiveFragment.this.fZk.getMeasuredHeight());
            }
        });
        PW();
        this.fZs = new ArrayList();
        this.eYk = new ArrayList();
        this.fZq = new e(getPageContext());
        this.fZr = new com.baidu.tieba.ala.alasquare.special_forum.model.a(getPageContext(), new a.InterfaceC0605a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.5
            @Override // com.baidu.tieba.ala.alasquare.special_forum.model.a.InterfaceC0605a
            public void b(h hVar) {
                SpecialLiveFragment.this.hideLoadingView(SpecialLiveFragment.this.mRootView);
                SpecialLiveFragment.this.a(hVar);
            }

            @Override // com.baidu.tieba.ala.alasquare.special_forum.model.a.InterfaceC0605a
            public void aK(int i, String str) {
                SpecialLiveFragment.this.aO(i, str);
            }
        });
        lo(true);
        ln(true);
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
    public void ln(boolean z) {
        if (!this.fZr.isLoading()) {
            if (z) {
                showLoadingView(this.mRootView);
            }
            this.fZr.loadData();
        }
    }

    private void bKF() {
        this.fTH = new AlaLiveUserNotifyController(getPageContext());
        this.fTI = new AlaLiveUserNotifyManager.AlaLiveNotifyListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.7
            @Override // com.baidu.ala.notify.AlaLiveUserNotifyManager.AlaLiveNotifyListener
            public void onCallBack() {
                if (SpecialLiveFragment.this.isPrimary()) {
                    SpecialLiveFragment.this.fTH.showNextNotifyDialog(0, AlaLiveUserNotifyManager.getInstance().getNotifyDataList());
                }
            }
        };
        AlaLiveUserNotifyManager.getInstance().addNotifyListener(this.fTI);
    }

    private void bKG() {
        this.fZt = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_MODEL_TASK) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z;
                SignData signData = null;
                SpecialLiveFragment.this.fZi.setClickable(true);
                if (customResponsedMessage != null && customResponsedMessage.getOrginalMessage().getTag() == SpecialLiveFragment.this.mBdUniqueId) {
                    SignMessage signMessage = (SignMessage) customResponsedMessage;
                    if (AntiHelper.bM(signMessage.mSignErrorCode, signMessage.mSignErrorString) && signMessage.signData != null) {
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
                        if (AntiHelper.bM(signMessage.mSignErrorCode, signMessage.mSignErrorString)) {
                            AntiHelper.bk(SpecialLiveFragment.this.mContext, signMessage.mSignErrorString);
                            return;
                        } else {
                            l.showToast(SpecialLiveFragment.this.mContext, SpecialLiveFragment.this.mContext.getString(R.string.special_sign_success_tip, Integer.valueOf(signData.sign_bonus_point)));
                            return;
                        }
                    }
                    if (signMessage.mSignErrorCode == 160002) {
                        SpecialLiveFragment.this.mCurState = 3;
                        SpecialLiveFragment.this.lo(false);
                    }
                    l.showToast(SpecialLiveFragment.this.mContext, signMessage.mSignErrorString);
                }
            }
        };
    }

    private void bKH() {
        this.eLp = new LikeModel(getPageContext());
        this.eLp.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.9
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                SpecialLiveFragment.this.fZi.setClickable(true);
                if (SpecialLiveFragment.this.eLp.getErrorCode() == 22) {
                    l.showToast(SpecialLiveFragment.this.mContext, R.string.had_liked_forum);
                } else if (AntiHelper.bM(SpecialLiveFragment.this.eLp.getErrorCode(), SpecialLiveFragment.this.eLp.getErrorString())) {
                    AntiHelper.bk(SpecialLiveFragment.this.mContext, SpecialLiveFragment.this.eLp.getErrorString());
                } else if (SpecialLiveFragment.this.eLp.getErrorCode() != 0) {
                    l.showToast(SpecialLiveFragment.this.mContext, SpecialLiveFragment.this.eLp.getErrorString());
                } else {
                    v vVar = (v) obj;
                    if (vVar != null) {
                        TbadkCoreApplication.getInst().addLikeForum(SpecialLiveFragment.this.mForumName);
                        vVar.setLike(1);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, vVar));
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
        bKK();
        bKI();
        if (!this.fZx) {
            bKL();
            if (this.ewX != null && this.ewX.getChildCount() > 1) {
                this.ewX.setCurrentItem(1);
            }
            if (!y.isEmpty(this.mData.tabInfoList)) {
                this.fZx = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aO(int i, String str) {
        if (TextUtils.isEmpty(str)) {
            showNetRefreshView(this.mRootView, this.mContext.getResources().getString(R.string.square_load_data_failed_tip), false);
        } else {
            showNetRefreshView(this.mRootView, str, false);
        }
    }

    private void bKI() {
        if (this.mData.fZY) {
            if (bKJ()) {
                this.mCurState = 3;
            } else {
                this.mCurState = 2;
            }
        } else {
            this.mCurState = 1;
        }
        lo(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bKJ() {
        return this.mData.gaa.gag;
    }

    private void bKK() {
        boolean c = this.fZq.c(this.mData.fZW);
        if (c) {
            this.fZq.stopPlay();
            this.fZq.onDestroy();
        }
        this.fZq.a(this.mData.fZW, c);
        if (c) {
            this.fZq.aa(this.fZe);
        }
        this.fZq.startPlay();
    }

    private void bKL() {
        bKM();
        this.fWZ.setData(this.fZs);
        this.fZp.setData(this.eYk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(int i, float f) {
        if (this.fZq != null && f != 0.0f) {
            if (this.fZu <= i) {
                if (this.fZw && f >= 0.3f) {
                    this.fZq.la(true);
                    this.fZq.pause();
                    this.fZw = false;
                }
            } else if (!this.fZw && f <= 0.3f) {
                this.fZq.la(false);
                this.fZq.resume();
                this.fZw = true;
            }
            this.fZu = i;
        }
    }

    private void PW() {
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds88);
        if (UtilHelper.canUseStyleImmersiveSticky() && this.mStatusBarView.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.mStatusBarView.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.mStatusBarView.setLayoutParams(layoutParams);
            this.mStatusBarView.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fZm.getLayoutParams();
            layoutParams2.height = layoutParams.height;
            this.fZm.setLayoutParams(layoutParams2);
            dimensionPixelSize = layoutParams.height + dimensionPixelSize;
        } else {
            this.mStatusBarView.setVisibility(8);
        }
        CollapsingToolbarLayout.LayoutParams layoutParams3 = (CollapsingToolbarLayout.LayoutParams) this.fZk.getLayoutParams();
        layoutParams3.height = dimensionPixelSize;
        this.fZk.setLayoutParams(layoutParams3);
    }

    private void bKM() {
        this.fZs.clear();
        this.eYk.clear();
        this.fZs.add(bKP());
        this.fZs.add(bKQ());
        this.eYk.add(bKN());
        this.eYk.add(bKO());
        if (!y.isEmpty(this.mData.tabInfoList)) {
            boolean z = b.blO().getInt("chushou_game_tab", 1) == 1;
            for (int i = 0; i < this.mData.tabInfoList.size() && i < 10; i++) {
                SpecialLiveTabInfo specialLiveTabInfo = this.mData.tabInfoList.get(i);
                if (specialLiveTabInfo != null && (specialLiveTabInfo.tabId != 1108 || z)) {
                    this.eYk.add(specialLiveTabInfo);
                    TabData tabData = new TabData();
                    tabData.tabId = specialLiveTabInfo.tabId;
                    tabData.tabName = specialLiveTabInfo.tabName;
                    tabData.tabType = specialLiveTabInfo.tabType;
                    this.fZs.add(tabData);
                }
            }
        }
    }

    private SpecialLiveTabInfo bKN() {
        SpecialLiveTabInfo specialLiveTabInfo = new SpecialLiveTabInfo();
        specialLiveTabInfo.tabId = -901;
        specialLiveTabInfo.tabName = this.mContext.getResources().getString(R.string.special_concern_tab_title);
        return specialLiveTabInfo;
    }

    private SpecialLiveTabInfo bKO() {
        SpecialLiveTabInfo specialLiveTabInfo = new SpecialLiveTabInfo();
        specialLiveTabInfo.tabId = -903;
        specialLiveTabInfo.tabName = this.mContext.getResources().getString(R.string.special_recommend_tab_title);
        return specialLiveTabInfo;
    }

    private TabData bKP() {
        TabData tabData = new TabData();
        tabData.tabId = -901;
        tabData.tabName = this.mContext.getResources().getString(R.string.special_concern_tab_title);
        return tabData;
    }

    private TabData bKQ() {
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
                ln(false);
                AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
            }
            if (this.fZq != null) {
                if (isPrimary()) {
                    this.fZq.la(false);
                    this.fZq.startPlay();
                    return;
                }
                this.fZq.la(true);
                this.fZq.pause();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        hideNetRefreshView(this.mRootView);
        ln(true);
        AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.fZq != null) {
            this.fZq.la(true);
            this.fZq.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fZq != null) {
            this.fZq.onChangeSkinType(i);
        }
        if (this.fWZ != null) {
            ap.setBackgroundResource(this.fWZ, R.color.cp_bg_line_d);
            this.fWZ.onChangeSkinType(i);
        }
        if (this.fZp != null) {
            this.fZp.onChangeSkinType(i);
        }
        lp(false);
        ap.setBackgroundColor(this.mStatusBarView, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.fZl, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.fZn, R.color.cp_cont_b);
        ap.setBackgroundColor(this.fZf, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.fZg, R.color.cp_bg_line_e);
        ap.setViewTextColor(this.fZh, R.color.cp_cont_b);
        ap.setViewTextColor(this.fZj, R.color.cp_cont_j);
        ap.setViewTextColor(this.fZi, R.color.cp_cont_g);
        ap.setBackgroundResource(this.fZi, R.drawable.frs_attention_btn_bg_selector);
        ap.setBackgroundResource(this.fZd, R.color.cp_bg_line_c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lo(boolean z) {
        Drawable drawable;
        ap.setBackgroundResource(this.fZi, R.drawable.frs_attention_btn_bg_selector);
        int dimens = l.getDimens(this.mContext, R.dimen.ds10);
        String string = this.mContext.getResources().getString(R.string.attention);
        int i = R.drawable.frs_attention_btn_bg_selector;
        int i2 = R.color.cp_cont_a;
        if (this.mCurState == 1) {
            drawable = ap.getDrawable(R.drawable.icon_add_follow_blue_s);
            this.fZi.setClickable(true);
            if (!z) {
                TiebaStatic.log(new aq("c12889"));
            }
        } else if (this.mCurState == 2) {
            string = this.mContext.getResources().getString(R.string.sign);
            drawable = ap.getDrawable(R.drawable.icon_public_sign_blue_s);
            this.fZi.setClickable(true);
            if (!z) {
                TiebaStatic.log(new aq("c12891"));
            }
        } else if (this.mCurState == 3) {
            string = this.mContext.getResources().getString(R.string.signed);
            this.fZi.setClickable(false);
            i = R.drawable.special_sign_btn_signed_bg;
            i2 = R.color.cp_cont_d;
            drawable = null;
        } else {
            drawable = null;
        }
        ap.setBackgroundResource(this.fZi, i);
        ap.setViewTextColor(this.fZi, i2);
        this.fZi.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.fZi.setCompoundDrawablePadding(dimens);
        this.fZi.setText(string);
        bKR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lp(boolean z) {
        if (this.fZo != null) {
            if (z) {
                ap.setNavbarIconSrc(this.fZo, R.drawable.selector_topbar_return_black, R.drawable.selector_topbar_return_black, TbadkCoreApplication.getInst().getSkinType());
            } else {
                ap.setNavbarIconSrc(this.fZo, R.drawable.selector_topbar_return_white, R.drawable.selector_topbar_return_white, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    private void bKR() {
        if (this.mData != null && this.mData.fZZ != null && this.mCurState != 1) {
            int i = this.mData.fZZ.level_id;
            String str = TextUtils.isEmpty(this.mData.fZZ.level_name) ? "" : " " + this.mData.fZZ.level_name;
            if (i >= 0) {
                this.fZj.setText("LV" + i + str);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.fZq != null) {
            this.fZq.onDestroy();
        }
        if (this.fZB != null) {
            MessageManager.getInstance().unRegisterListener(this.fZB);
        }
        if (this.fZt != null) {
            MessageManager.getInstance().unRegisterListener(this.fZt);
        }
        if (this.mSignChangedListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mSignChangedListener);
        }
        if (this.fZC != null) {
            MessageManager.getInstance().unRegisterListener(this.fZC);
        }
        if (this.fZA != null) {
            MessageManager.getInstance().unRegisterListener(this.fZA);
        }
        if (this.mAccountChangedListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mAccountChangedListener);
        }
        if (this.fZr != null) {
            this.fZr.onDestroy();
        }
        if (this.fTH != null) {
            this.fTH.onDestroy();
        }
        AlaLiveUserNotifyManager.getInstance().removeNotifyListener(this.fTI);
        hideLoadingView(this.mRootView);
        MessageManager.getInstance().unRegisterListener(this.ejK);
    }

    private void initViewPager() {
        this.fZp = new a(getChildFragmentManager());
        this.ewX.setAdapter(this.fZp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends FragmentPagerAdapter {
        private SparseArray<SpecialForumTabBaseFragment> fZF;
        private List<SpecialLiveTabInfo> mData;

        public a(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.mData = new ArrayList();
            this.fZF = new SparseArray<>();
            this.fZF.put(0, ConcernTabFragment.tA(0));
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
            SpecialForumTabBaseFragment ty = ty(i);
            if (ty == null) {
                if (i == 0) {
                    ty = ConcernTabFragment.tA(0);
                } else if (i == 1) {
                    ty = RecommendTabFragment.tB(1);
                } else if (i < this.mData.size() && this.mData.get(i) != null && this.mData.get(i).tabId == 1108) {
                    ty = GameTabFragment.FM(this.mData.get(i).tabName);
                } else {
                    ty = OtherSubTabFragment.a(i, this.mData.get(i));
                }
                this.fZF.put(i, ty);
            }
            return ty;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.mData.size();
        }

        public SpecialForumTabBaseFragment ty(int i) {
            return this.fZF.get(i);
        }

        public void a(int i, TabData tabData) {
            if (this.fZF.get(i) != null) {
                this.fZF.get(i).setPrimary(true);
            }
        }

        public void onChangeSkinType(int i) {
            if (this.fZF != null && this.fZF.size() > 0) {
                int size = this.fZF.size();
                for (int i2 = 0; i2 < size; i2++) {
                    SpecialForumTabBaseFragment specialForumTabBaseFragment = this.fZF.get(i2);
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
            if (this.fZy != null) {
                this.fZy.dismiss();
            }
            final Handler handler = new Handler();
            final Runnable runnable = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.10
                @Override // java.lang.Runnable
                public void run() {
                    if (SpecialLiveFragment.this.fZy != null) {
                        SpecialLiveFragment.this.fZy.dismiss();
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
                    SpecialLiveFragment.this.fZy = null;
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
                            SpecialLiveFragment.this.fZy.dismiss();
                        }
                    });
                    ap.setViewTextColor(textView, R.color.cp_cont_i);
                    bubbleLayout.KA(ap.getColor(R.color.cp_link_tip_a_alpha95));
                    bubbleLayout.aN(activity.getResources().getDimensionPixelSize(R.dimen.ds216));
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
            this.fZy = dVar.mi();
            this.fZy.show(activity);
            handler.postDelayed(runnable, 5000L);
        }
    }
}
