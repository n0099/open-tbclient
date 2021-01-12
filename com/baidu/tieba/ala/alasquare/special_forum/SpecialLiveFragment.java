package com.baidu.tieba.ala.alasquare.special_forum;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.baidu.adp.BdUniqueId;
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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bg;
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
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.w;
import com.baidu.tieba.view.bubbleView.BubbleLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class SpecialLiveFragment extends BaseFragment {
    private AppBarLayout ZQ;
    private CustomViewPager eWN;
    private LikeModel fle;
    private List<SpecialLiveTabInfo> fyj;
    private ScrollHorizontalTabView gBc;
    private List<TabData> gDA;
    private CustomMessageListener gDB;
    private int gDC;
    private String gDD;
    private c gDG;
    private float gDj;
    private CollapsingToolbarLayout gDk;
    private View gDl;
    private ObservedChangeFrameLayout gDm;
    private RelativeLayout gDn;
    private View gDo;
    private TextView gDp;
    private TextView gDq;
    private TextView gDr;
    private RelativeLayout gDs;
    private View gDt;
    private View gDu;
    private TextView gDv;
    private ImageView gDw;
    private a gDx;
    private e gDy;
    private com.baidu.tieba.ala.alasquare.special_forum.model.a gDz;
    private AlaLiveUserNotifyController gxK;
    private AlaLiveUserNotifyManager.AlaLiveNotifyListener gxL;
    private BdUniqueId mBdUniqueId;
    private Context mContext;
    private h mData;
    private String mForumId;
    private String mForumName;
    private View mRootView;
    private View mStatusBarView;
    private boolean gDE = true;
    private int mCurState = 1;
    private boolean gDF = false;
    private Handler mHandler = new Handler();
    private Runnable mRefreshRunnable = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.1
        @Override // java.lang.Runnable
        public void run() {
            if (SpecialLiveFragment.this.gDy != null) {
                SpecialLiveFragment.this.gDy.bRQ();
            }
        }
    };
    private CustomMessageListener eIv = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            SpecialLiveFragment.this.mHandler.removeCallbacks(SpecialLiveFragment.this.mRefreshRunnable);
            SpecialLiveFragment.this.mHandler.postDelayed(SpecialLiveFragment.this.mRefreshRunnable, 500L);
        }
    };
    private CustomMessageListener gDH = new CustomMessageListener(CmdConfigCustom.CMD_FORCE_REFRESH) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2) {
                    if ("FrsLiveLive".equals(split[0])) {
                        SpecialLiveFragment.this.mD(false);
                    }
                    SpecialForumTabBaseFragment tI = SpecialLiveFragment.this.gDx.tI(SpecialLiveFragment.this.eWN.getCurrentItem());
                    if (tI != null) {
                        tI.bRN();
                    }
                }
            }
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && SpecialLiveFragment.this.gDz != null && !TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                SpecialLiveFragment.this.mD(false);
            }
        }
    };
    private final CustomMessageListener gDI = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            w wVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof w) && (wVar = (w) customResponsedMessage.getData()) != null && SpecialLiveFragment.this.mForumId.equals(wVar.getFid())) {
                if (wVar.isLike() == 1) {
                    if (SpecialLiveFragment.this.bRD()) {
                        SpecialLiveFragment.this.mCurState = 3;
                    } else {
                        SpecialLiveFragment.this.mCurState = 2;
                    }
                } else {
                    SpecialLiveFragment.this.mCurState = 1;
                }
                SpecialLiveFragment.this.mE(false);
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
                SpecialLiveFragment.this.mE(false);
                l.showToast(SpecialLiveFragment.this.getPageContext().getPageActivity(), SpecialLiveFragment.this.mContext.getString(R.string.special_sign_success_tip, Integer.valueOf(signData.sign_bonus_point)));
            }
        }
    };
    private final CustomMessageListener gDJ = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_SPECIAL_CONCERN_TAB_TAB_ICON) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                Boolean bool = (Boolean) customResponsedMessage.getData();
                if (!x.isEmpty(SpecialLiveFragment.this.gDA)) {
                    ((TabData) SpecialLiveFragment.this.gDA.get(0)).extra = bool;
                    SpecialLiveFragment.this.gBc.setData(SpecialLiveFragment.this.gDA);
                    if (bool.booleanValue()) {
                        TiebaStatic.log("c12898");
                    }
                }
            }
        }
    };

    public static SpecialLiveFragment eo(String str, String str2) {
        SpecialLiveFragment specialLiveFragment = new SpecialLiveFragment();
        Bundle bundle = new Bundle();
        bundle.putString("forum_id", str);
        bundle.putString("forum_name", str2);
        specialLiveFragment.setArguments(bundle);
        return specialLiveFragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
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
                this.gDD = sb.toString();
            } else {
                this.mForumName = this.mContext.getResources().getString(R.string.ala_ufan_bar_title);
                this.gDD = this.mForumName + string2;
            }
            bRB();
            bRz();
            bRA();
            MessageManager.getInstance().registerListener(this.gDB);
            MessageManager.getInstance().registerListener(this.gDI);
            MessageManager.getInstance().registerListener(this.mSignChangedListener);
            MessageManager.getInstance().registerListener(this.gDJ);
            MessageManager.getInstance().registerListener(this.gDH);
            MessageManager.getInstance().registerListener(this.mAccountChangedListener);
            MessageManager.getInstance().registerListener(this.eIv);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(R.layout.special_live_layout, (ViewGroup) null);
        this.ZQ = (AppBarLayout) this.mRootView.findViewById(R.id.special_app_bar_layout);
        this.gDk = (CollapsingToolbarLayout) this.mRootView.findViewById(R.id.special_collapse_layout);
        this.mStatusBarView = this.mRootView.findViewById(R.id.statusbar_view);
        this.gDm = (ObservedChangeFrameLayout) this.mRootView.findViewById(R.id.live_container);
        this.mBdUniqueId = BdUniqueId.gen();
        this.gDn = (RelativeLayout) this.mRootView.findViewById(R.id.function_container);
        this.gDo = this.mRootView.findViewById(R.id.function_bottom_space);
        this.gDp = (TextView) this.mRootView.findViewById(R.id.function_title);
        this.gDp.setText(this.gDD);
        this.gDq = (TextView) this.mRootView.findViewById(R.id.function_btn);
        this.gDq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.19
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
                    SpecialLiveFragment.this.gDq.setClickable(false);
                    SpecialLiveFragment.this.fle.gq(SpecialLiveFragment.this.mForumName, SpecialLiveFragment.this.mForumId);
                    TiebaStatic.log(new aq("c12890"));
                } else if (SpecialLiveFragment.this.mCurState == 2) {
                    SpecialLiveFragment.this.gDq.setClickable(false);
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
        this.gDr = (TextView) this.mRootView.findViewById(R.id.function_level_desc);
        this.gDs = (RelativeLayout) this.mRootView.findViewById(R.id.navigation_layout);
        this.gDu = this.mRootView.findViewById(R.id.navigation_top_space);
        this.gDt = this.mRootView.findViewById(R.id.navigation_bg);
        this.gDv = (TextView) this.mRootView.findViewById(R.id.navigation_title);
        this.gDv.setText(this.gDD);
        this.gDw = (ImageView) this.mRootView.findViewById(R.id.navigation_back_img);
        this.gDw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, SpecialLiveFragment.this.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        });
        this.gBc = (ScrollHorizontalTabView) this.mRootView.findViewById(R.id.scroll_tab_view);
        this.eWN = (CustomViewPager) this.mRootView.findViewById(R.id.special_view_pager);
        initViewPager();
        this.gBc.setViewPager(this.eWN);
        this.gBc.setScrollTabPageListener(new ScrollHorizontalTabView.ScrollTabPageListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.2
            @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
            public boolean onPrePageSelect(int i, TabData tabData) {
                return true;
            }

            @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
            public void onPageSelected(int i, TabData tabData) {
                if (i != 0 || TbadkCoreApplication.isLogin()) {
                    if (SpecialLiveFragment.this.gDx != null) {
                        SpecialLiveFragment.this.gDx.a(i, tabData);
                        return;
                    }
                    return;
                }
                bg.skipToLoginActivity(SpecialLiveFragment.this.getPageContext().getPageActivity());
                if (SpecialLiveFragment.this.eWN != null) {
                    SpecialLiveFragment.this.eWN.setCurrentItem(1);
                }
            }

            @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
            public void onPageScrolled(int i, float f, int i2) {
            }
        });
        this.ZQ.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.3
            @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                int abs = Math.abs(i);
                if (abs == 0) {
                    SpecialLiveFragment.this.gDt.setVisibility(8);
                    SpecialLiveFragment.this.gDv.setVisibility(8);
                } else {
                    SpecialLiveFragment.this.gDt.setVisibility(0);
                    SpecialLiveFragment.this.gDv.setVisibility(0);
                }
                SpecialLiveFragment.this.mF(((float) abs) > SpecialLiveFragment.this.gDj / 2.0f);
                float abs2 = Math.abs(abs / SpecialLiveFragment.this.gDj);
                SpecialLiveFragment.this.gDt.setAlpha(abs2);
                SpecialLiveFragment.this.gDv.setAlpha(abs2);
                SpecialLiveFragment.this.g(abs, abs2);
            }
        });
        this.gDl = this.mRootView.findViewById(R.id.square_main_top_divider_line);
        this.gDm.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.4
            @Override // com.baidu.tbadk.widget.layout.e
            public void f(View view, int i, int i2, int i3, int i4) {
                SpecialLiveFragment.this.gDj = (SpecialLiveFragment.this.gDm.getMeasuredHeight() + SpecialLiveFragment.this.gDn.getMeasuredHeight()) - SpecialLiveFragment.this.gDs.getMeasuredHeight();
                SpecialLiveFragment.this.gDk.setMinimumHeight(SpecialLiveFragment.this.gDs.getMeasuredHeight());
            }
        });
        SA();
        this.gDA = new ArrayList();
        this.fyj = new ArrayList();
        this.gDy = new e(getPageContext());
        this.gDz = new com.baidu.tieba.ala.alasquare.special_forum.model.a(getPageContext(), new a.InterfaceC0619a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.5
            @Override // com.baidu.tieba.ala.alasquare.special_forum.model.a.InterfaceC0619a
            public void b(h hVar) {
                SpecialLiveFragment.this.hideLoadingView(SpecialLiveFragment.this.mRootView);
                SpecialLiveFragment.this.a(hVar);
            }

            @Override // com.baidu.tieba.ala.alasquare.special_forum.model.a.InterfaceC0619a
            public void w(int i, String str) {
                SpecialLiveFragment.this.aU(i, str);
            }
        });
        mE(true);
        mD(true);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.mRootView.post(new Runnable() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.6
            @Override // java.lang.Runnable
            public void run() {
                SpecialLiveFragment.this.am(SpecialLiveFragment.this.getFragmentActivity());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mD(boolean z) {
        if (!this.gDz.isLoading()) {
            if (z) {
                showLoadingView(this.mRootView);
            }
            this.gDz.loadData();
        }
    }

    private void bRz() {
        this.gxK = new AlaLiveUserNotifyController(getPageContext());
        this.gxL = new AlaLiveUserNotifyManager.AlaLiveNotifyListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.7
            @Override // com.baidu.ala.notify.AlaLiveUserNotifyManager.AlaLiveNotifyListener
            public void onCallBack() {
                if (SpecialLiveFragment.this.isPrimary()) {
                    SpecialLiveFragment.this.gxK.showNextNotifyDialog(0, AlaLiveUserNotifyManager.getInstance().getNotifyDataList());
                }
            }
        };
        AlaLiveUserNotifyManager.getInstance().addNotifyListener(this.gxL);
    }

    private void bRA() {
        this.gDB = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_MODEL_TASK) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z;
                SignData signData = null;
                SpecialLiveFragment.this.gDq.setClickable(true);
                if (customResponsedMessage != null && customResponsedMessage.getOrginalMessage().getTag() == SpecialLiveFragment.this.mBdUniqueId) {
                    SignMessage signMessage = (SignMessage) customResponsedMessage;
                    if (AntiHelper.bQ(signMessage.mSignErrorCode, signMessage.mSignErrorString) && signMessage.signData != null) {
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
                        if (AntiHelper.bQ(signMessage.mSignErrorCode, signMessage.mSignErrorString)) {
                            AntiHelper.bs(SpecialLiveFragment.this.mContext, signMessage.mSignErrorString);
                            return;
                        } else {
                            l.showToast(SpecialLiveFragment.this.mContext, SpecialLiveFragment.this.mContext.getString(R.string.special_sign_success_tip, Integer.valueOf(signData.sign_bonus_point)));
                            return;
                        }
                    }
                    if (signMessage.mSignErrorCode == 160002) {
                        SpecialLiveFragment.this.mCurState = 3;
                        SpecialLiveFragment.this.mE(false);
                    }
                    l.showToast(SpecialLiveFragment.this.mContext, signMessage.mSignErrorString);
                }
            }
        };
    }

    private void bRB() {
        this.fle = new LikeModel(getPageContext());
        this.fle.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.9
            @Override // com.baidu.adp.base.e
            public void callback(Object obj) {
                SpecialLiveFragment.this.gDq.setClickable(true);
                if (SpecialLiveFragment.this.fle.getErrorCode() == 22) {
                    l.showToast(SpecialLiveFragment.this.mContext, R.string.had_liked_forum);
                } else if (AntiHelper.bQ(SpecialLiveFragment.this.fle.getErrorCode(), SpecialLiveFragment.this.fle.getErrorString())) {
                    AntiHelper.bs(SpecialLiveFragment.this.mContext, SpecialLiveFragment.this.fle.getErrorString());
                } else if (SpecialLiveFragment.this.fle.getErrorCode() != 0) {
                    l.showToast(SpecialLiveFragment.this.mContext, SpecialLiveFragment.this.fle.getErrorString());
                } else {
                    w wVar = (w) obj;
                    if (wVar != null) {
                        TbadkCoreApplication.getInst().addLikeForum(SpecialLiveFragment.this.mForumName);
                        wVar.setLike(1);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, wVar));
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
        this.ZQ.setVisibility(0);
        this.mData = hVar;
        bRE();
        bRC();
        if (!this.gDF) {
            bRF();
            if (this.eWN != null && this.eWN.getChildCount() > 1) {
                this.eWN.setCurrentItem(1);
            }
            if (!x.isEmpty(this.mData.tabInfoList)) {
                this.gDF = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aU(int i, String str) {
        hideLoadingView(this.mRootView);
        this.ZQ.setVisibility(8);
        if (TextUtils.isEmpty(str)) {
            showNetRefreshView(this.mRootView, this.mContext.getResources().getString(R.string.square_load_data_failed_tip), true);
        } else {
            showNetRefreshView(this.mRootView, str, true);
        }
    }

    private void bRC() {
        if (this.mData.gEf) {
            if (bRD()) {
                this.mCurState = 3;
            } else {
                this.mCurState = 2;
            }
        } else {
            this.mCurState = 1;
        }
        mE(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bRD() {
        return this.mData.gEh.gEn;
    }

    private void bRE() {
        boolean c = this.gDy.c(this.mData.gEd);
        if (c) {
            this.gDy.stopPlay();
            this.gDy.onDestroy();
        }
        this.gDy.a(this.mData.gEd, c);
        if (c) {
            this.gDy.al(this.gDm);
        }
        this.gDy.startPlay();
    }

    private void bRF() {
        bRG();
        this.gBc.setData(this.gDA);
        this.gDx.setData(this.fyj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(int i, float f) {
        if (this.gDy != null && f != 0.0f) {
            if (this.gDC <= i) {
                if (this.gDE && f >= 0.3f) {
                    this.gDy.mq(true);
                    this.gDy.pause();
                    this.gDE = false;
                }
            } else if (!this.gDE && f <= 0.3f) {
                this.gDy.mq(false);
                this.gDy.resume();
                this.gDE = true;
            }
            this.gDC = i;
        }
    }

    private void SA() {
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds88);
        if (UtilHelper.canUseStyleImmersiveSticky() && this.mStatusBarView.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.mStatusBarView.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.mStatusBarView.setLayoutParams(layoutParams);
            this.mStatusBarView.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gDu.getLayoutParams();
            layoutParams2.height = layoutParams.height;
            this.gDu.setLayoutParams(layoutParams2);
            dimensionPixelSize = layoutParams.height + dimensionPixelSize;
        } else {
            this.mStatusBarView.setVisibility(8);
        }
        CollapsingToolbarLayout.LayoutParams layoutParams3 = (CollapsingToolbarLayout.LayoutParams) this.gDs.getLayoutParams();
        layoutParams3.height = dimensionPixelSize;
        this.gDs.setLayoutParams(layoutParams3);
    }

    private void bRG() {
        this.gDA.clear();
        this.fyj.clear();
        this.gDA.add(bRJ());
        this.gDA.add(bRK());
        this.fyj.add(bRH());
        this.fyj.add(bRI());
        if (!x.isEmpty(this.mData.tabInfoList)) {
            boolean z = b.brx().getInt("chushou_game_tab", 1) == 1;
            for (int i = 0; i < this.mData.tabInfoList.size() && i < 10; i++) {
                SpecialLiveTabInfo specialLiveTabInfo = this.mData.tabInfoList.get(i);
                if (specialLiveTabInfo != null && (specialLiveTabInfo.tabId != 1108 || z)) {
                    this.fyj.add(specialLiveTabInfo);
                    TabData tabData = new TabData();
                    tabData.tabId = specialLiveTabInfo.tabId;
                    tabData.tabName = specialLiveTabInfo.tabName;
                    tabData.tabType = specialLiveTabInfo.tabType;
                    this.gDA.add(tabData);
                }
            }
        }
    }

    private SpecialLiveTabInfo bRH() {
        SpecialLiveTabInfo specialLiveTabInfo = new SpecialLiveTabInfo();
        specialLiveTabInfo.tabId = -901;
        specialLiveTabInfo.tabName = this.mContext.getResources().getString(R.string.special_concern_tab_title);
        return specialLiveTabInfo;
    }

    private SpecialLiveTabInfo bRI() {
        SpecialLiveTabInfo specialLiveTabInfo = new SpecialLiveTabInfo();
        specialLiveTabInfo.tabId = -903;
        specialLiveTabInfo.tabName = this.mContext.getResources().getString(R.string.special_recommend_tab_title);
        return specialLiveTabInfo;
    }

    private TabData bRJ() {
        TabData tabData = new TabData();
        tabData.tabId = -901;
        tabData.tabName = this.mContext.getResources().getString(R.string.special_concern_tab_title);
        return tabData;
    }

    private TabData bRK() {
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
                mD(false);
                AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
            }
            if (this.gDy != null) {
                if (isPrimary()) {
                    this.gDy.mq(false);
                    this.gDy.startPlay();
                    return;
                }
                this.gDy.mq(true);
                this.gDy.pause();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        hideNetRefreshView(this.mRootView);
        mD(true);
        AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.gDy != null) {
            this.gDy.mq(true);
            this.gDy.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gDy != null) {
            this.gDy.onChangeSkinType(i);
        }
        if (this.gBc != null) {
            ao.setBackgroundResource(this.gBc, R.color.CAM_X0201);
            this.gBc.onChangeSkinType(i);
        }
        if (this.gDx != null) {
            this.gDx.onChangeSkinType(i);
        }
        mF(false);
        ao.setBackgroundColor(this.mStatusBarView, R.color.CAM_X0201);
        ao.setBackgroundColor(this.gDt, R.color.CAM_X0201);
        ao.setViewTextColor(this.gDv, R.color.CAM_X0105);
        ao.setBackgroundColor(this.gDn, R.color.CAM_X0201);
        ao.setBackgroundColor(this.gDo, R.color.CAM_X0205);
        ao.setViewTextColor(this.gDp, R.color.CAM_X0105);
        ao.setViewTextColor(this.gDr, R.color.CAM_X0107);
        ao.setViewTextColor(this.gDq, R.color.CAM_X0111);
        ao.setBackgroundResource(this.gDq, R.drawable.frs_attention_btn_bg_selector);
        ao.setBackgroundResource(this.gDl, R.color.CAM_X0204);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mE(boolean z) {
        Drawable drawable;
        ao.setBackgroundResource(this.gDq, R.drawable.frs_attention_btn_bg_selector);
        int dimens = l.getDimens(this.mContext, R.dimen.ds10);
        String string = this.mContext.getResources().getString(R.string.attention);
        int i = R.drawable.frs_attention_btn_bg_selector;
        int i2 = R.color.CAM_X0101;
        if (this.mCurState == 1) {
            drawable = ao.getDrawable(R.drawable.icon_add_follow_blue_s);
            this.gDq.setClickable(true);
            if (!z) {
                TiebaStatic.log(new aq("c12889"));
            }
        } else if (this.mCurState == 2) {
            string = this.mContext.getResources().getString(R.string.sign);
            drawable = ao.getDrawable(R.drawable.icon_public_sign_blue_s);
            this.gDq.setClickable(true);
            if (!z) {
                TiebaStatic.log(new aq("c12891"));
            }
        } else if (this.mCurState == 3) {
            string = this.mContext.getResources().getString(R.string.signed);
            this.gDq.setClickable(false);
            i = R.drawable.special_sign_btn_signed_bg;
            i2 = R.color.CAM_X0109;
            drawable = null;
        } else {
            drawable = null;
        }
        ao.setBackgroundResource(this.gDq, i);
        ao.setViewTextColor(this.gDq, i2);
        this.gDq.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.gDq.setCompoundDrawablePadding(dimens);
        this.gDq.setText(string);
        bRL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mF(boolean z) {
        if (this.gDw != null) {
            if (z) {
                ao.setNavbarIconSrc(this.gDw, R.drawable.selector_topbar_return_black, R.drawable.selector_topbar_return_black, TbadkCoreApplication.getInst().getSkinType());
            } else {
                ao.setNavbarIconSrc(this.gDw, R.drawable.selector_topbar_return_white, R.drawable.selector_topbar_return_white, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    private void bRL() {
        if (this.mData != null && this.mData.gEg != null && this.mCurState != 1) {
            int i = this.mData.gEg.level_id;
            String str = TextUtils.isEmpty(this.mData.gEg.level_name) ? "" : " " + this.mData.gEg.level_name;
            if (i >= 0) {
                this.gDr.setText("LV" + i + str);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.gDy != null) {
            this.gDy.onDestroy();
        }
        if (this.gDI != null) {
            MessageManager.getInstance().unRegisterListener(this.gDI);
        }
        if (this.gDB != null) {
            MessageManager.getInstance().unRegisterListener(this.gDB);
        }
        if (this.mSignChangedListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mSignChangedListener);
        }
        if (this.gDJ != null) {
            MessageManager.getInstance().unRegisterListener(this.gDJ);
        }
        if (this.gDH != null) {
            MessageManager.getInstance().unRegisterListener(this.gDH);
        }
        if (this.mAccountChangedListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mAccountChangedListener);
        }
        if (this.gDz != null) {
            this.gDz.onDestroy();
        }
        if (this.gxK != null) {
            this.gxK.onDestroy();
        }
        AlaLiveUserNotifyManager.getInstance().removeNotifyListener(this.gxL);
        hideLoadingView(this.mRootView);
        MessageManager.getInstance().unRegisterListener(this.eIv);
    }

    private void initViewPager() {
        this.gDx = new a(getChildFragmentManager());
        this.eWN.setAdapter(this.gDx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a extends FragmentPagerAdapter {
        private SparseArray<SpecialForumTabBaseFragment> gDM;
        private List<SpecialLiveTabInfo> mData;

        public a(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.mData = new ArrayList();
            this.gDM = new SparseArray<>();
            this.gDM.put(0, ConcernTabFragment.tK(0));
        }

        public void setData(List<SpecialLiveTabInfo> list) {
            if (!x.isEmpty(list)) {
                this.mData.clear();
                this.mData.addAll(list);
                notifyDataSetChanged();
            }
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            SpecialForumTabBaseFragment tI = tI(i);
            if (tI == null) {
                if (i == 0) {
                    tI = ConcernTabFragment.tK(0);
                } else if (i == 1) {
                    tI = RecommendTabFragment.tL(1);
                } else if (i < this.mData.size() && this.mData.get(i) != null && this.mData.get(i).tabId == 1108) {
                    tI = GameTabFragment.FA(this.mData.get(i).tabName);
                } else {
                    tI = OtherSubTabFragment.a(i, this.mData.get(i));
                }
                this.gDM.put(i, tI);
            }
            return tI;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.mData.size();
        }

        public SpecialForumTabBaseFragment tI(int i) {
            return this.gDM.get(i);
        }

        public void a(int i, TabData tabData) {
            if (this.gDM.get(i) != null) {
                this.gDM.get(i).setPrimary(true);
            }
        }

        public void onChangeSkinType(int i) {
            if (this.gDM != null && this.gDM.size() > 0) {
                int size = this.gDM.size();
                for (int i2 = 0; i2 < size; i2++) {
                    SpecialForumTabBaseFragment specialForumTabBaseFragment = this.gDM.get(i2);
                    if (specialForumTabBaseFragment != null) {
                        specialForumTabBaseFragment.onChangeSkinType(i);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void am(final Activity activity) {
        if (activity != null && !AlaSharedPrefHelper.getInstance().getBoolean(AlaSharedPrefConfig.SQUARE_GUIDE_MARK_MANAGE_TIP_SHOW, false)) {
            if (this.gDG != null) {
                this.gDG.dismiss();
            }
            final Handler handler = new Handler();
            final Runnable runnable = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.10
                @Override // java.lang.Runnable
                public void run() {
                    if (SpecialLiveFragment.this.gDG != null) {
                        SpecialLiveFragment.this.gDG.dismiss();
                    }
                }
            };
            d dVar = new d();
            dVar.ab(true);
            dVar.b(new d.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.11
                @Override // com.baidu.adp.lib.guide.d.a
                public void onShown() {
                }

                @Override // com.baidu.adp.lib.guide.d.a
                public void onDismiss() {
                    AlaSharedPrefHelper.getInstance().putBoolean(AlaSharedPrefConfig.SQUARE_GUIDE_MARK_MANAGE_TIP_SHOW, true);
                    SpecialLiveFragment.this.gDG = null;
                    handler.removeCallbacks(runnable);
                }
            });
            dVar.y(activity.getWindow().getDecorView().findViewById(R.id.tabcontainer)).an(20).ac(false);
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
                            SpecialLiveFragment.this.gDG.dismiss();
                        }
                    });
                    ao.setViewTextColor(textView, R.color.CAM_X0112);
                    bubbleLayout.KG(ao.getColor(R.color.cp_link_tip_a_alpha95));
                    bubbleLayout.bb(activity.getResources().getDimensionPixelSize(R.dimen.ds216));
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
            this.gDG = dVar.lG();
            this.gDG.show(activity);
            handler.postDelayed(runnable, 5000L);
        }
    }
}
