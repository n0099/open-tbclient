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
import com.baidu.android.imsdk.utils.HanziToPinyin;
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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
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
    private AppBarLayout CD;
    private CustomViewPager cYo;
    private LikeModel dku;
    private AlaLiveUserNotifyController elW;
    private AlaLiveUserNotifyManager.AlaLiveNotifyListener elX;
    private ScrollHorizontalTabView epj;
    private List<TabData> erA;
    private List<SpecialLiveTabInfo> erB;
    private CustomMessageListener erC;
    private int erD;
    private String erE;
    private c erH;
    private float eri;
    private CollapsingToolbarLayout erj;
    private View erk;
    private ObservedChangeFrameLayout erl;
    private RelativeLayout erm;
    private View ern;
    private TextView ero;
    private TextView erp;
    private TextView erq;
    private RelativeLayout ers;
    private View ert;
    private View eru;
    private TextView erv;
    private ImageView erw;
    private a erx;
    private e ery;
    private com.baidu.tieba.ala.alasquare.special_forum.model.a erz;
    private BdUniqueId mBdUniqueId;
    private Context mContext;
    private h mData;
    private String mForumId;
    private String mForumName;
    private View mRootView;
    private View mStatusBarView;
    private boolean erF = true;
    private int mCurState = 1;
    private boolean erG = false;
    private Handler mHandler = new Handler();
    private Runnable erI = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.1
        @Override // java.lang.Runnable
        public void run() {
            if (SpecialLiveFragment.this.ery != null) {
                SpecialLiveFragment.this.ery.bdB();
            }
        }
    };
    private CustomMessageListener cMx = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            SpecialLiveFragment.this.mHandler.removeCallbacks(SpecialLiveFragment.this.erI);
            SpecialLiveFragment.this.mHandler.postDelayed(SpecialLiveFragment.this.erI, 500L);
        }
    };
    private CustomMessageListener erJ = new CustomMessageListener(CmdConfigCustom.CMD_FORCE_REFRESH) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2) {
                    if ("FrsLiveLive".equals(split[0])) {
                        SpecialLiveFragment.this.loadData(false);
                    }
                    SpecialForumTabBaseFragment oM = SpecialLiveFragment.this.erx.oM(SpecialLiveFragment.this.cYo.getCurrentItem());
                    if (oM != null) {
                        oM.bdw();
                    }
                }
            }
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && SpecialLiveFragment.this.erz != null && !TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                SpecialLiveFragment.this.loadData(false);
            }
        }
    };
    private final CustomMessageListener erK = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            u uVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof u) && (uVar = (u) customResponsedMessage.getData()) != null && SpecialLiveFragment.this.mForumId.equals(uVar.getFid())) {
                if (uVar.isLike() == 1) {
                    if (SpecialLiveFragment.this.bdm()) {
                        SpecialLiveFragment.this.mCurState = 3;
                    } else {
                        SpecialLiveFragment.this.mCurState = 2;
                    }
                } else {
                    SpecialLiveFragment.this.mCurState = 1;
                }
                SpecialLiveFragment.this.ie(false);
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
                SpecialLiveFragment.this.ie(false);
                l.showToast(SpecialLiveFragment.this.getPageContext().getPageActivity(), SpecialLiveFragment.this.mContext.getString(R.string.special_sign_success_tip, Integer.valueOf(signData.sign_bonus_point)));
            }
        }
    };
    private final CustomMessageListener erL = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_SPECIAL_CONCERN_TAB_TAB_ICON) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                Boolean bool = (Boolean) customResponsedMessage.getData();
                if (!v.isEmpty(SpecialLiveFragment.this.erA)) {
                    ((TabData) SpecialLiveFragment.this.erA.get(0)).extra = bool;
                    SpecialLiveFragment.this.epj.setData(SpecialLiveFragment.this.erA);
                    if (bool.booleanValue()) {
                        TiebaStatic.log("c12898");
                    }
                }
            }
        }
    };

    public static SpecialLiveFragment cP(String str, String str2) {
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
                this.erE = sb.toString();
            } else {
                this.mForumName = this.mContext.getResources().getString(R.string.ala_ufan_bar_title);
                this.erE = this.mForumName + string2;
            }
            bdk();
            bdi();
            bdj();
            MessageManager.getInstance().registerListener(this.erC);
            MessageManager.getInstance().registerListener(this.erK);
            MessageManager.getInstance().registerListener(this.mSignChangedListener);
            MessageManager.getInstance().registerListener(this.erL);
            MessageManager.getInstance().registerListener(this.erJ);
            MessageManager.getInstance().registerListener(this.mAccountChangedListener);
            MessageManager.getInstance().registerListener(this.cMx);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(R.layout.special_live_layout, (ViewGroup) null);
        this.CD = (AppBarLayout) this.mRootView.findViewById(R.id.special_app_bar_layout);
        this.erj = (CollapsingToolbarLayout) this.mRootView.findViewById(R.id.special_collapse_layout);
        this.mStatusBarView = this.mRootView.findViewById(R.id.statusbar_view);
        this.erl = (ObservedChangeFrameLayout) this.mRootView.findViewById(R.id.live_container);
        this.mBdUniqueId = BdUniqueId.gen();
        this.erm = (RelativeLayout) this.mRootView.findViewById(R.id.function_container);
        this.ern = this.mRootView.findViewById(R.id.function_bottom_space);
        this.ero = (TextView) this.mRootView.findViewById(R.id.function_title);
        this.ero.setText(this.erE);
        this.erp = (TextView) this.mRootView.findViewById(R.id.function_btn);
        this.erp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!j.isNetWorkAvailable()) {
                    SpecialLiveFragment.this.showToast(R.string.neterror);
                    return;
                }
                if (!TbadkCoreApplication.isLogin()) {
                    bc.skipToLoginActivity(SpecialLiveFragment.this.mContext);
                }
                if (SpecialLiveFragment.this.mCurState == 1) {
                    SpecialLiveFragment.this.erp.setClickable(false);
                    SpecialLiveFragment.this.dku.eA(SpecialLiveFragment.this.mForumName, SpecialLiveFragment.this.mForumId);
                    TiebaStatic.log(new an("c12890"));
                } else if (SpecialLiveFragment.this.mCurState == 2) {
                    SpecialLiveFragment.this.erp.setClickable(false);
                    ForumData forumData = new ForumData();
                    forumData.setId(SpecialLiveFragment.this.mForumId);
                    forumData.setName(SpecialLiveFragment.this.mForumName);
                    CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_SIGN_MODEL_TASK, forumData);
                    customMessage.setTag(SpecialLiveFragment.this.mBdUniqueId);
                    MessageManager.getInstance().sendMessage(customMessage);
                    TiebaStatic.log(new an("c12892"));
                }
            }
        });
        this.erq = (TextView) this.mRootView.findViewById(R.id.function_level_desc);
        this.ers = (RelativeLayout) this.mRootView.findViewById(R.id.navigation_layout);
        this.eru = this.mRootView.findViewById(R.id.navigation_top_space);
        this.ert = this.mRootView.findViewById(R.id.navigation_bg);
        this.erv = (TextView) this.mRootView.findViewById(R.id.navigation_title);
        this.erv.setText(this.erE);
        this.erw = (ImageView) this.mRootView.findViewById(R.id.navigation_back_img);
        this.erw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, SpecialLiveFragment.this.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        });
        this.epj = (ScrollHorizontalTabView) this.mRootView.findViewById(R.id.scroll_tab_view);
        this.cYo = (CustomViewPager) this.mRootView.findViewById(R.id.special_view_pager);
        initViewPager();
        this.epj.setViewPager(this.cYo);
        this.epj.setScrollTabPageListener(new ScrollHorizontalTabView.ScrollTabPageListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.2
            @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
            public boolean onPrePageSelect(int i, TabData tabData) {
                return true;
            }

            @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
            public void onPageSelected(int i, TabData tabData) {
                if (i != 0 || TbadkCoreApplication.isLogin()) {
                    if (SpecialLiveFragment.this.erx != null) {
                        SpecialLiveFragment.this.erx.a(i, tabData);
                        return;
                    }
                    return;
                }
                bc.skipToLoginActivity(SpecialLiveFragment.this.getPageContext().getPageActivity());
                if (SpecialLiveFragment.this.cYo != null) {
                    SpecialLiveFragment.this.cYo.setCurrentItem(1);
                }
            }

            @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
            public void onPageScrolled(int i, float f, int i2) {
            }
        });
        this.CD.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.3
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                int abs = Math.abs(i);
                if (abs == 0) {
                    SpecialLiveFragment.this.ert.setVisibility(8);
                    SpecialLiveFragment.this.erv.setVisibility(8);
                } else {
                    SpecialLiveFragment.this.ert.setVisibility(0);
                    SpecialLiveFragment.this.erv.setVisibility(0);
                }
                SpecialLiveFragment.this.m30if(((float) abs) > SpecialLiveFragment.this.eri / 2.0f);
                float abs2 = Math.abs(abs / SpecialLiveFragment.this.eri);
                SpecialLiveFragment.this.ert.setAlpha(abs2);
                SpecialLiveFragment.this.erv.setAlpha(abs2);
                SpecialLiveFragment.this.i(abs, abs2);
            }
        });
        this.erk = this.mRootView.findViewById(R.id.square_main_top_divider_line);
        this.erl.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.4
            @Override // com.baidu.tbadk.widget.layout.e
            public void d(View view, int i, int i2, int i3, int i4) {
                SpecialLiveFragment.this.eri = (SpecialLiveFragment.this.erl.getMeasuredHeight() + SpecialLiveFragment.this.erm.getMeasuredHeight()) - SpecialLiveFragment.this.ers.getMeasuredHeight();
                SpecialLiveFragment.this.erj.setMinimumHeight(SpecialLiveFragment.this.ers.getMeasuredHeight());
            }
        });
        Ao();
        this.erA = new ArrayList();
        this.erB = new ArrayList();
        this.ery = new e(getPageContext());
        this.erz = new com.baidu.tieba.ala.alasquare.special_forum.model.a(getPageContext(), new a.InterfaceC0426a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.5
            @Override // com.baidu.tieba.ala.alasquare.special_forum.model.a.InterfaceC0426a
            public void b(h hVar) {
                SpecialLiveFragment.this.hideLoadingView(SpecialLiveFragment.this.mRootView);
                SpecialLiveFragment.this.a(hVar);
            }

            @Override // com.baidu.tieba.ala.alasquare.special_forum.model.a.InterfaceC0426a
            public void ad(int i, String str) {
                SpecialLiveFragment.this.ai(i, str);
            }
        });
        ie(true);
        loadData(true);
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
    public void loadData(boolean z) {
        if (!this.erz.isLoading()) {
            if (z) {
                showLoadingView(this.mRootView);
            }
            this.erz.loadData();
        }
    }

    private void bdi() {
        this.elW = new AlaLiveUserNotifyController(getPageContext());
        this.elX = new AlaLiveUserNotifyManager.AlaLiveNotifyListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.7
            @Override // com.baidu.ala.notify.AlaLiveUserNotifyManager.AlaLiveNotifyListener
            public void onCallBack() {
                if (SpecialLiveFragment.this.isPrimary()) {
                    SpecialLiveFragment.this.elW.showNextNotifyDialog(0, AlaLiveUserNotifyManager.getInstance().getNotifyDataList());
                }
            }
        };
        AlaLiveUserNotifyManager.getInstance().addNotifyListener(this.elX);
    }

    private void bdj() {
        this.erC = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_MODEL_TASK) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z;
                SignData signData = null;
                SpecialLiveFragment.this.erp.setClickable(true);
                if (customResponsedMessage != null && customResponsedMessage.getOrginalMessage().getTag() == SpecialLiveFragment.this.mBdUniqueId) {
                    SignMessage signMessage = (SignMessage) customResponsedMessage;
                    if (AntiHelper.bb(signMessage.mSignErrorCode, signMessage.mSignErrorString) && signMessage.signData != null) {
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
                        if (AntiHelper.bb(signMessage.mSignErrorCode, signMessage.mSignErrorString)) {
                            AntiHelper.bn(SpecialLiveFragment.this.mContext, signMessage.mSignErrorString);
                            return;
                        } else {
                            l.showToast(SpecialLiveFragment.this.mContext, SpecialLiveFragment.this.mContext.getString(R.string.special_sign_success_tip, Integer.valueOf(signData.sign_bonus_point)));
                            return;
                        }
                    }
                    if (signMessage.mSignErrorCode == 160002) {
                        SpecialLiveFragment.this.mCurState = 3;
                        SpecialLiveFragment.this.ie(false);
                    }
                    l.showToast(SpecialLiveFragment.this.mContext, signMessage.mSignErrorString);
                }
            }
        };
    }

    private void bdk() {
        this.dku = new LikeModel(getPageContext());
        this.dku.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.9
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                SpecialLiveFragment.this.erp.setClickable(true);
                if (SpecialLiveFragment.this.dku.getErrorCode() == 22) {
                    l.showToast(SpecialLiveFragment.this.mContext, (int) R.string.had_liked_forum);
                } else if (AntiHelper.bb(SpecialLiveFragment.this.dku.getErrorCode(), SpecialLiveFragment.this.dku.getErrorString())) {
                    AntiHelper.bn(SpecialLiveFragment.this.mContext, SpecialLiveFragment.this.dku.getErrorString());
                } else if (SpecialLiveFragment.this.dku.getErrorCode() != 0) {
                    l.showToast(SpecialLiveFragment.this.mContext, SpecialLiveFragment.this.dku.getErrorString());
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
        bdn();
        bdl();
        if (!this.erG) {
            bdo();
            if (this.cYo != null && this.cYo.getChildCount() > 1) {
                this.cYo.setCurrentItem(1);
            }
            if (!v.isEmpty(this.mData.tabInfoList)) {
                this.erG = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ai(int i, String str) {
        if (TextUtils.isEmpty(str)) {
            showNetRefreshView(this.mRootView, this.mContext.getResources().getString(R.string.square_load_data_failed_tip), false);
        } else {
            showNetRefreshView(this.mRootView, str, false);
        }
    }

    private void bdl() {
        if (this.mData.esh) {
            if (bdm()) {
                this.mCurState = 3;
            } else {
                this.mCurState = 2;
            }
        } else {
            this.mCurState = 1;
        }
        ie(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bdm() {
        return this.mData.esj.esp;
    }

    private void bdn() {
        boolean c = this.ery.c(this.mData.esf);
        if (c) {
            this.ery.stopPlay();
            this.ery.onDestroy();
        }
        this.ery.a(this.mData.esf, c);
        if (c) {
            this.ery.N(this.erl);
        }
        this.ery.startPlay();
    }

    private void bdo() {
        bdp();
        this.epj.setData(this.erA);
        this.erx.setData(this.erB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(int i, float f) {
        if (this.ery != null && f != 0.0f) {
            if (this.erD <= i) {
                if (this.erF && f >= 0.3f) {
                    this.ery.hS(true);
                    this.ery.pause();
                    this.erF = false;
                }
            } else if (!this.erF && f <= 0.3f) {
                this.ery.hS(false);
                this.ery.resume();
                this.erF = true;
            }
            this.erD = i;
        }
    }

    private void Ao() {
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds88);
        if (UtilHelper.canUseStyleImmersiveSticky() && this.mStatusBarView.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.mStatusBarView.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.mStatusBarView.setLayoutParams(layoutParams);
            this.mStatusBarView.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.eru.getLayoutParams();
            layoutParams2.height = layoutParams.height;
            this.eru.setLayoutParams(layoutParams2);
            dimensionPixelSize = layoutParams.height + dimensionPixelSize;
        } else {
            this.mStatusBarView.setVisibility(8);
        }
        CollapsingToolbarLayout.LayoutParams layoutParams3 = (CollapsingToolbarLayout.LayoutParams) this.ers.getLayoutParams();
        layoutParams3.height = dimensionPixelSize;
        this.ers.setLayoutParams(layoutParams3);
    }

    private void bdp() {
        this.erA.clear();
        this.erB.clear();
        this.erA.add(bds());
        this.erA.add(bdt());
        this.erB.add(bdq());
        this.erB.add(bdr());
        if (!v.isEmpty(this.mData.tabInfoList)) {
            boolean z = b.aFH().getInt("chushou_game_tab", 1) == 1;
            for (int i = 0; i < this.mData.tabInfoList.size() && i < 10; i++) {
                SpecialLiveTabInfo specialLiveTabInfo = this.mData.tabInfoList.get(i);
                if (specialLiveTabInfo != null && (specialLiveTabInfo.tabId != 1108 || z)) {
                    this.erB.add(specialLiveTabInfo);
                    TabData tabData = new TabData();
                    tabData.tabId = specialLiveTabInfo.tabId;
                    tabData.tabName = specialLiveTabInfo.tabName;
                    tabData.tabType = specialLiveTabInfo.tabType;
                    this.erA.add(tabData);
                }
            }
        }
    }

    private SpecialLiveTabInfo bdq() {
        SpecialLiveTabInfo specialLiveTabInfo = new SpecialLiveTabInfo();
        specialLiveTabInfo.tabId = -901;
        specialLiveTabInfo.tabName = this.mContext.getResources().getString(R.string.special_concern_tab_title);
        return specialLiveTabInfo;
    }

    private SpecialLiveTabInfo bdr() {
        SpecialLiveTabInfo specialLiveTabInfo = new SpecialLiveTabInfo();
        specialLiveTabInfo.tabId = -903;
        specialLiveTabInfo.tabName = this.mContext.getResources().getString(R.string.special_recommend_tab_title);
        return specialLiveTabInfo;
    }

    private TabData bds() {
        TabData tabData = new TabData();
        tabData.tabId = -901;
        tabData.tabName = this.mContext.getResources().getString(R.string.special_concern_tab_title);
        return tabData;
    }

    private TabData bdt() {
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
                loadData(false);
                AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
            }
            if (this.ery != null) {
                if (isPrimary()) {
                    this.ery.hS(false);
                    this.ery.startPlay();
                    return;
                }
                this.ery.hS(true);
                this.ery.pause();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        hideNetRefreshView(this.mRootView);
        loadData(true);
        AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.ery != null) {
            this.ery.hS(true);
            this.ery.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.ery != null) {
            this.ery.onChangeSkinType(i);
        }
        if (this.epj != null) {
            am.setBackgroundResource(this.epj, R.color.cp_bg_line_d);
            this.epj.onChangeSkinType(i);
        }
        if (this.erx != null) {
            this.erx.onChangeSkinType(i);
        }
        m30if(false);
        am.setBackgroundColor(this.mStatusBarView, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.ert, R.color.cp_bg_line_d);
        am.setViewTextColor(this.erv, (int) R.color.cp_cont_b);
        am.setBackgroundColor(this.erm, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.ern, R.color.cp_bg_line_e);
        am.setViewTextColor(this.ero, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.erq, (int) R.color.cp_cont_j);
        am.setViewTextColor(this.erp, (int) R.color.cp_cont_g);
        am.setBackgroundResource(this.erp, R.drawable.frs_attention_btn_bg_selector);
        am.setBackgroundResource(this.erk, R.color.cp_bg_line_c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ie(boolean z) {
        Drawable drawable;
        int i = R.drawable.frs_attention_btn_bg_selector;
        am.setBackgroundResource(this.erp, R.drawable.frs_attention_btn_bg_selector);
        int dimens = l.getDimens(this.mContext, R.dimen.ds10);
        String string = this.mContext.getResources().getString(R.string.attention);
        int i2 = R.color.cp_cont_a;
        if (this.mCurState == 1) {
            drawable = am.getDrawable(R.drawable.icon_add_follow_blue_s);
            this.erp.setClickable(true);
            if (!z) {
                TiebaStatic.log(new an("c12889"));
            }
        } else if (this.mCurState == 2) {
            string = this.mContext.getResources().getString(R.string.sign);
            drawable = am.getDrawable(R.drawable.icon_public_sign_blue_s);
            this.erp.setClickable(true);
            if (!z) {
                TiebaStatic.log(new an("c12891"));
            }
        } else if (this.mCurState == 3) {
            string = this.mContext.getResources().getString(R.string.signed);
            this.erp.setClickable(false);
            i = R.drawable.special_sign_btn_signed_bg;
            i2 = R.color.cp_cont_d;
            drawable = null;
        } else {
            drawable = null;
        }
        am.setBackgroundResource(this.erp, i);
        am.setViewTextColor(this.erp, i2);
        this.erp.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.erp.setCompoundDrawablePadding(dimens);
        this.erp.setText(string);
        bdu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: if  reason: not valid java name */
    public void m30if(boolean z) {
        if (this.erw != null) {
            if (z) {
                am.setNavbarIconSrc(this.erw, R.drawable.selector_topbar_return_black, R.drawable.selector_topbar_return_black, TbadkCoreApplication.getInst().getSkinType());
            } else {
                am.setNavbarIconSrc(this.erw, R.drawable.selector_topbar_return_white, R.drawable.selector_topbar_return_white, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    private void bdu() {
        if (this.mData != null && this.mData.esi != null && this.mCurState != 1) {
            int i = this.mData.esi.level_id;
            String str = TextUtils.isEmpty(this.mData.esi.level_name) ? "" : HanziToPinyin.Token.SEPARATOR + this.mData.esi.level_name;
            if (i >= 0) {
                this.erq.setText("LV" + i + str);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.ery != null) {
            this.ery.onDestroy();
        }
        if (this.erK != null) {
            MessageManager.getInstance().unRegisterListener(this.erK);
        }
        if (this.erC != null) {
            MessageManager.getInstance().unRegisterListener(this.erC);
        }
        if (this.mSignChangedListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mSignChangedListener);
        }
        if (this.erL != null) {
            MessageManager.getInstance().unRegisterListener(this.erL);
        }
        if (this.erJ != null) {
            MessageManager.getInstance().unRegisterListener(this.erJ);
        }
        if (this.mAccountChangedListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mAccountChangedListener);
        }
        if (this.erz != null) {
            this.erz.onDestroy();
        }
        if (this.elW != null) {
            this.elW.onDestroy();
        }
        AlaLiveUserNotifyManager.getInstance().removeNotifyListener(this.elX);
        hideLoadingView(this.mRootView);
        MessageManager.getInstance().unRegisterListener(this.cMx);
    }

    private void initViewPager() {
        this.erx = new a(getChildFragmentManager());
        this.cYo.setAdapter(this.erx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends FragmentPagerAdapter {
        private SparseArray<SpecialForumTabBaseFragment> erO;
        private List<SpecialLiveTabInfo> mData;

        public a(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.mData = new ArrayList();
            this.erO = new SparseArray<>();
            this.erO.put(0, ConcernTabFragment.oO(0));
        }

        public void setData(List<SpecialLiveTabInfo> list) {
            if (!v.isEmpty(list)) {
                this.mData.clear();
                this.mData.addAll(list);
                notifyDataSetChanged();
            }
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            SpecialForumTabBaseFragment oM = oM(i);
            if (oM == null) {
                if (i == 0) {
                    oM = ConcernTabFragment.oO(0);
                } else if (i == 1) {
                    oM = RecommendTabFragment.oP(1);
                } else if (i < this.mData.size() && this.mData.get(i) != null && this.mData.get(i).tabId == 1108) {
                    oM = GameTabFragment.xK(this.mData.get(i).tabName);
                } else {
                    oM = OtherSubTabFragment.a(i, this.mData.get(i));
                }
                this.erO.put(i, oM);
            }
            return oM;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.mData.size();
        }

        public SpecialForumTabBaseFragment oM(int i) {
            return this.erO.get(i);
        }

        public void a(int i, TabData tabData) {
            if (this.erO.get(i) != null) {
                this.erO.get(i).setPrimary(true);
            }
        }

        public void onChangeSkinType(int i) {
            if (this.erO != null && this.erO.size() > 0) {
                int size = this.erO.size();
                for (int i2 = 0; i2 < size; i2++) {
                    SpecialForumTabBaseFragment specialForumTabBaseFragment = this.erO.get(i2);
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
            if (this.erH != null) {
                this.erH.dismiss();
            }
            final Handler handler = new Handler();
            final Runnable runnable = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.10
                @Override // java.lang.Runnable
                public void run() {
                    if (SpecialLiveFragment.this.erH != null) {
                        SpecialLiveFragment.this.erH.dismiss();
                    }
                }
            };
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.E(true);
            dVar.b(new d.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.11
                @Override // com.baidu.adp.lib.guide.d.a
                public void onShown() {
                }

                @Override // com.baidu.adp.lib.guide.d.a
                public void onDismiss() {
                    AlaSharedPrefHelper.getInstance().putBoolean(AlaSharedPrefConfig.SQUARE_GUIDE_MARK_MANAGE_TIP_SHOW, true);
                    SpecialLiveFragment.this.erH = null;
                    handler.removeCallbacks(runnable);
                }
            });
            dVar.y(activity.getWindow().getDecorView().findViewById(R.id.tabcontainer)).M(20).F(false);
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
                            SpecialLiveFragment.this.erH.dismiss();
                        }
                    });
                    am.setViewTextColor(textView, (int) R.color.cp_cont_i);
                    bubbleLayout.Ef(am.getColor(R.color.cp_link_tip_a_alpha95));
                    bubbleLayout.aO(activity.getResources().getDimensionPixelSize(R.dimen.ds216));
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
            this.erH = dVar.fI();
            this.erH.show(activity);
            handler.postDelayed(runnable, 5000L);
        }
    }
}
