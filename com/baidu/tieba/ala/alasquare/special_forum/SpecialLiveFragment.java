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
    private AppBarLayout Xv;
    private CustomViewPager eiw;
    private LikeModel ewX;
    private AlaLiveUserNotifyController fEh;
    private AlaLiveUserNotifyManager.AlaLiveNotifyListener fEi;
    private ScrollHorizontalTabView fHs;
    private RelativeLayout fJA;
    private View fJB;
    private View fJC;
    private TextView fJD;
    private ImageView fJE;
    private a fJF;
    private e fJG;
    private com.baidu.tieba.ala.alasquare.special_forum.model.a fJH;
    private List<TabData> fJI;
    private List<SpecialLiveTabInfo> fJJ;
    private CustomMessageListener fJK;
    private int fJL;
    private String fJM;
    private c fJP;
    private float fJr;
    private CollapsingToolbarLayout fJs;
    private View fJt;
    private ObservedChangeFrameLayout fJu;
    private RelativeLayout fJv;
    private View fJw;
    private TextView fJx;
    private TextView fJy;
    private TextView fJz;
    private BdUniqueId mBdUniqueId;
    private Context mContext;
    private h mData;
    private String mForumId;
    private String mForumName;
    private View mRootView;
    private View mStatusBarView;
    private boolean fJN = true;
    private int mCurState = 1;
    private boolean fJO = false;
    private Handler mHandler = new Handler();
    private Runnable fJQ = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.1
        @Override // java.lang.Runnable
        public void run() {
            if (SpecialLiveFragment.this.fJG != null) {
                SpecialLiveFragment.this.fJG.bGV();
            }
        }
    };
    private CustomMessageListener dVu = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            SpecialLiveFragment.this.mHandler.removeCallbacks(SpecialLiveFragment.this.fJQ);
            SpecialLiveFragment.this.mHandler.postDelayed(SpecialLiveFragment.this.fJQ, 500L);
        }
    };
    private CustomMessageListener fJR = new CustomMessageListener(CmdConfigCustom.CMD_FORCE_REFRESH) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2) {
                    if ("FrsLiveLive".equals(split[0])) {
                        SpecialLiveFragment.this.kL(false);
                    }
                    SpecialForumTabBaseFragment sI = SpecialLiveFragment.this.fJF.sI(SpecialLiveFragment.this.eiw.getCurrentItem());
                    if (sI != null) {
                        sI.bGQ();
                    }
                }
            }
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && SpecialLiveFragment.this.fJH != null && !TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                SpecialLiveFragment.this.kL(false);
            }
        }
    };
    private final CustomMessageListener fJS = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            v vVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof v) && (vVar = (v) customResponsedMessage.getData()) != null && SpecialLiveFragment.this.mForumId.equals(vVar.getFid())) {
                if (vVar.isLike() == 1) {
                    if (SpecialLiveFragment.this.bGG()) {
                        SpecialLiveFragment.this.mCurState = 3;
                    } else {
                        SpecialLiveFragment.this.mCurState = 2;
                    }
                } else {
                    SpecialLiveFragment.this.mCurState = 1;
                }
                SpecialLiveFragment.this.kM(false);
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
                SpecialLiveFragment.this.kM(false);
                l.showToast(SpecialLiveFragment.this.getPageContext().getPageActivity(), SpecialLiveFragment.this.mContext.getString(R.string.special_sign_success_tip, Integer.valueOf(signData.sign_bonus_point)));
            }
        }
    };
    private final CustomMessageListener fJT = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_SPECIAL_CONCERN_TAB_TAB_ICON) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                Boolean bool = (Boolean) customResponsedMessage.getData();
                if (!y.isEmpty(SpecialLiveFragment.this.fJI)) {
                    ((TabData) SpecialLiveFragment.this.fJI.get(0)).extra = bool;
                    SpecialLiveFragment.this.fHs.setData(SpecialLiveFragment.this.fJI);
                    if (bool.booleanValue()) {
                        TiebaStatic.log("c12898");
                    }
                }
            }
        }
    };

    public static SpecialLiveFragment dT(String str, String str2) {
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
                this.fJM = sb.toString();
            } else {
                this.mForumName = this.mContext.getResources().getString(R.string.ala_ufan_bar_title);
                this.fJM = this.mForumName + string2;
            }
            bGE();
            bGC();
            bGD();
            MessageManager.getInstance().registerListener(this.fJK);
            MessageManager.getInstance().registerListener(this.fJS);
            MessageManager.getInstance().registerListener(this.mSignChangedListener);
            MessageManager.getInstance().registerListener(this.fJT);
            MessageManager.getInstance().registerListener(this.fJR);
            MessageManager.getInstance().registerListener(this.mAccountChangedListener);
            MessageManager.getInstance().registerListener(this.dVu);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(R.layout.special_live_layout, (ViewGroup) null);
        this.Xv = (AppBarLayout) this.mRootView.findViewById(R.id.special_app_bar_layout);
        this.fJs = (CollapsingToolbarLayout) this.mRootView.findViewById(R.id.special_collapse_layout);
        this.mStatusBarView = this.mRootView.findViewById(R.id.statusbar_view);
        this.fJu = (ObservedChangeFrameLayout) this.mRootView.findViewById(R.id.live_container);
        this.mBdUniqueId = BdUniqueId.gen();
        this.fJv = (RelativeLayout) this.mRootView.findViewById(R.id.function_container);
        this.fJw = this.mRootView.findViewById(R.id.function_bottom_space);
        this.fJx = (TextView) this.mRootView.findViewById(R.id.function_title);
        this.fJx.setText(this.fJM);
        this.fJy = (TextView) this.mRootView.findViewById(R.id.function_btn);
        this.fJy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.19
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
                    SpecialLiveFragment.this.fJy.setClickable(false);
                    SpecialLiveFragment.this.ewX.fQ(SpecialLiveFragment.this.mForumName, SpecialLiveFragment.this.mForumId);
                    TiebaStatic.log(new aq("c12890"));
                } else if (SpecialLiveFragment.this.mCurState == 2) {
                    SpecialLiveFragment.this.fJy.setClickable(false);
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
        this.fJz = (TextView) this.mRootView.findViewById(R.id.function_level_desc);
        this.fJA = (RelativeLayout) this.mRootView.findViewById(R.id.navigation_layout);
        this.fJC = this.mRootView.findViewById(R.id.navigation_top_space);
        this.fJB = this.mRootView.findViewById(R.id.navigation_bg);
        this.fJD = (TextView) this.mRootView.findViewById(R.id.navigation_title);
        this.fJD.setText(this.fJM);
        this.fJE = (ImageView) this.mRootView.findViewById(R.id.navigation_back_img);
        this.fJE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, SpecialLiveFragment.this.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        });
        this.fHs = (ScrollHorizontalTabView) this.mRootView.findViewById(R.id.scroll_tab_view);
        this.eiw = (CustomViewPager) this.mRootView.findViewById(R.id.special_view_pager);
        initViewPager();
        this.fHs.setViewPager(this.eiw);
        this.fHs.setScrollTabPageListener(new ScrollHorizontalTabView.ScrollTabPageListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.2
            @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
            public boolean onPrePageSelect(int i, TabData tabData) {
                return true;
            }

            @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
            public void onPageSelected(int i, TabData tabData) {
                if (i != 0 || TbadkCoreApplication.isLogin()) {
                    if (SpecialLiveFragment.this.fJF != null) {
                        SpecialLiveFragment.this.fJF.a(i, tabData);
                        return;
                    }
                    return;
                }
                bg.skipToLoginActivity(SpecialLiveFragment.this.getPageContext().getPageActivity());
                if (SpecialLiveFragment.this.eiw != null) {
                    SpecialLiveFragment.this.eiw.setCurrentItem(1);
                }
            }

            @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
            public void onPageScrolled(int i, float f, int i2) {
            }
        });
        this.Xv.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.3
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                int abs = Math.abs(i);
                if (abs == 0) {
                    SpecialLiveFragment.this.fJB.setVisibility(8);
                    SpecialLiveFragment.this.fJD.setVisibility(8);
                } else {
                    SpecialLiveFragment.this.fJB.setVisibility(0);
                    SpecialLiveFragment.this.fJD.setVisibility(0);
                }
                SpecialLiveFragment.this.kN(((float) abs) > SpecialLiveFragment.this.fJr / 2.0f);
                float abs2 = Math.abs(abs / SpecialLiveFragment.this.fJr);
                SpecialLiveFragment.this.fJB.setAlpha(abs2);
                SpecialLiveFragment.this.fJD.setAlpha(abs2);
                SpecialLiveFragment.this.g(abs, abs2);
            }
        });
        this.fJt = this.mRootView.findViewById(R.id.square_main_top_divider_line);
        this.fJu.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.4
            @Override // com.baidu.tbadk.widget.layout.e
            public void d(View view, int i, int i2, int i3, int i4) {
                SpecialLiveFragment.this.fJr = (SpecialLiveFragment.this.fJu.getMeasuredHeight() + SpecialLiveFragment.this.fJv.getMeasuredHeight()) - SpecialLiveFragment.this.fJA.getMeasuredHeight();
                SpecialLiveFragment.this.fJs.setMinimumHeight(SpecialLiveFragment.this.fJA.getMeasuredHeight());
            }
        });
        Oo();
        this.fJI = new ArrayList();
        this.fJJ = new ArrayList();
        this.fJG = new e(getPageContext());
        this.fJH = new com.baidu.tieba.ala.alasquare.special_forum.model.a(getPageContext(), new a.InterfaceC0592a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.5
            @Override // com.baidu.tieba.ala.alasquare.special_forum.model.a.InterfaceC0592a
            public void b(h hVar) {
                SpecialLiveFragment.this.hideLoadingView(SpecialLiveFragment.this.mRootView);
                SpecialLiveFragment.this.a(hVar);
            }

            @Override // com.baidu.tieba.ala.alasquare.special_forum.model.a.InterfaceC0592a
            public void az(int i, String str) {
                SpecialLiveFragment.this.aD(i, str);
            }
        });
        kM(true);
        kL(true);
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
    public void kL(boolean z) {
        if (!this.fJH.isLoading()) {
            if (z) {
                showLoadingView(this.mRootView);
            }
            this.fJH.loadData();
        }
    }

    private void bGC() {
        this.fEh = new AlaLiveUserNotifyController(getPageContext());
        this.fEi = new AlaLiveUserNotifyManager.AlaLiveNotifyListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.7
            @Override // com.baidu.ala.notify.AlaLiveUserNotifyManager.AlaLiveNotifyListener
            public void onCallBack() {
                if (SpecialLiveFragment.this.isPrimary()) {
                    SpecialLiveFragment.this.fEh.showNextNotifyDialog(0, AlaLiveUserNotifyManager.getInstance().getNotifyDataList());
                }
            }
        };
        AlaLiveUserNotifyManager.getInstance().addNotifyListener(this.fEi);
    }

    private void bGD() {
        this.fJK = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_MODEL_TASK) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z;
                SignData signData = null;
                SpecialLiveFragment.this.fJy.setClickable(true);
                if (customResponsedMessage != null && customResponsedMessage.getOrginalMessage().getTag() == SpecialLiveFragment.this.mBdUniqueId) {
                    SignMessage signMessage = (SignMessage) customResponsedMessage;
                    if (AntiHelper.bz(signMessage.mSignErrorCode, signMessage.mSignErrorString) && signMessage.signData != null) {
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
                        if (AntiHelper.bz(signMessage.mSignErrorCode, signMessage.mSignErrorString)) {
                            AntiHelper.bb(SpecialLiveFragment.this.mContext, signMessage.mSignErrorString);
                            return;
                        } else {
                            l.showToast(SpecialLiveFragment.this.mContext, SpecialLiveFragment.this.mContext.getString(R.string.special_sign_success_tip, Integer.valueOf(signData.sign_bonus_point)));
                            return;
                        }
                    }
                    if (signMessage.mSignErrorCode == 160002) {
                        SpecialLiveFragment.this.mCurState = 3;
                        SpecialLiveFragment.this.kM(false);
                    }
                    l.showToast(SpecialLiveFragment.this.mContext, signMessage.mSignErrorString);
                }
            }
        };
    }

    private void bGE() {
        this.ewX = new LikeModel(getPageContext());
        this.ewX.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.9
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                SpecialLiveFragment.this.fJy.setClickable(true);
                if (SpecialLiveFragment.this.ewX.getErrorCode() == 22) {
                    l.showToast(SpecialLiveFragment.this.mContext, (int) R.string.had_liked_forum);
                } else if (AntiHelper.bz(SpecialLiveFragment.this.ewX.getErrorCode(), SpecialLiveFragment.this.ewX.getErrorString())) {
                    AntiHelper.bb(SpecialLiveFragment.this.mContext, SpecialLiveFragment.this.ewX.getErrorString());
                } else if (SpecialLiveFragment.this.ewX.getErrorCode() != 0) {
                    l.showToast(SpecialLiveFragment.this.mContext, SpecialLiveFragment.this.ewX.getErrorString());
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
        bGH();
        bGF();
        if (!this.fJO) {
            bGI();
            if (this.eiw != null && this.eiw.getChildCount() > 1) {
                this.eiw.setCurrentItem(1);
            }
            if (!y.isEmpty(this.mData.tabInfoList)) {
                this.fJO = true;
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

    private void bGF() {
        if (this.mData.fKp) {
            if (bGG()) {
                this.mCurState = 3;
            } else {
                this.mCurState = 2;
            }
        } else {
            this.mCurState = 1;
        }
        kM(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bGG() {
        return this.mData.fKr.fKx;
    }

    private void bGH() {
        boolean c = this.fJG.c(this.mData.fKn);
        if (c) {
            this.fJG.stopPlay();
            this.fJG.onDestroy();
        }
        this.fJG.a(this.mData.fKn, c);
        if (c) {
            this.fJG.X(this.fJu);
        }
        this.fJG.startPlay();
    }

    private void bGI() {
        bGJ();
        this.fHs.setData(this.fJI);
        this.fJF.setData(this.fJJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(int i, float f) {
        if (this.fJG != null && f != 0.0f) {
            if (this.fJL <= i) {
                if (this.fJN && f >= 0.3f) {
                    this.fJG.ky(true);
                    this.fJG.pause();
                    this.fJN = false;
                }
            } else if (!this.fJN && f <= 0.3f) {
                this.fJG.ky(false);
                this.fJG.resume();
                this.fJN = true;
            }
            this.fJL = i;
        }
    }

    private void Oo() {
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds88);
        if (UtilHelper.canUseStyleImmersiveSticky() && this.mStatusBarView.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.mStatusBarView.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.mStatusBarView.setLayoutParams(layoutParams);
            this.mStatusBarView.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fJC.getLayoutParams();
            layoutParams2.height = layoutParams.height;
            this.fJC.setLayoutParams(layoutParams2);
            dimensionPixelSize = layoutParams.height + dimensionPixelSize;
        } else {
            this.mStatusBarView.setVisibility(8);
        }
        CollapsingToolbarLayout.LayoutParams layoutParams3 = (CollapsingToolbarLayout.LayoutParams) this.fJA.getLayoutParams();
        layoutParams3.height = dimensionPixelSize;
        this.fJA.setLayoutParams(layoutParams3);
    }

    private void bGJ() {
        this.fJI.clear();
        this.fJJ.clear();
        this.fJI.add(bGM());
        this.fJI.add(bGN());
        this.fJJ.add(bGK());
        this.fJJ.add(bGL());
        if (!y.isEmpty(this.mData.tabInfoList)) {
            boolean z = b.bik().getInt("chushou_game_tab", 1) == 1;
            for (int i = 0; i < this.mData.tabInfoList.size() && i < 10; i++) {
                SpecialLiveTabInfo specialLiveTabInfo = this.mData.tabInfoList.get(i);
                if (specialLiveTabInfo != null && (specialLiveTabInfo.tabId != 1108 || z)) {
                    this.fJJ.add(specialLiveTabInfo);
                    TabData tabData = new TabData();
                    tabData.tabId = specialLiveTabInfo.tabId;
                    tabData.tabName = specialLiveTabInfo.tabName;
                    tabData.tabType = specialLiveTabInfo.tabType;
                    this.fJI.add(tabData);
                }
            }
        }
    }

    private SpecialLiveTabInfo bGK() {
        SpecialLiveTabInfo specialLiveTabInfo = new SpecialLiveTabInfo();
        specialLiveTabInfo.tabId = -901;
        specialLiveTabInfo.tabName = this.mContext.getResources().getString(R.string.special_concern_tab_title);
        return specialLiveTabInfo;
    }

    private SpecialLiveTabInfo bGL() {
        SpecialLiveTabInfo specialLiveTabInfo = new SpecialLiveTabInfo();
        specialLiveTabInfo.tabId = -903;
        specialLiveTabInfo.tabName = this.mContext.getResources().getString(R.string.special_recommend_tab_title);
        return specialLiveTabInfo;
    }

    private TabData bGM() {
        TabData tabData = new TabData();
        tabData.tabId = -901;
        tabData.tabName = this.mContext.getResources().getString(R.string.special_concern_tab_title);
        return tabData;
    }

    private TabData bGN() {
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
                kL(false);
                AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
            }
            if (this.fJG != null) {
                if (isPrimary()) {
                    this.fJG.ky(false);
                    this.fJG.startPlay();
                    return;
                }
                this.fJG.ky(true);
                this.fJG.pause();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        hideNetRefreshView(this.mRootView);
        kL(true);
        AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.fJG != null) {
            this.fJG.ky(true);
            this.fJG.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fJG != null) {
            this.fJG.onChangeSkinType(i);
        }
        if (this.fHs != null) {
            ap.setBackgroundResource(this.fHs, R.color.cp_bg_line_d);
            this.fHs.onChangeSkinType(i);
        }
        if (this.fJF != null) {
            this.fJF.onChangeSkinType(i);
        }
        kN(false);
        ap.setBackgroundColor(this.mStatusBarView, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.fJB, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.fJD, (int) R.color.cp_cont_b);
        ap.setBackgroundColor(this.fJv, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.fJw, R.color.cp_bg_line_e);
        ap.setViewTextColor(this.fJx, (int) R.color.cp_cont_b);
        ap.setViewTextColor(this.fJz, (int) R.color.cp_cont_j);
        ap.setViewTextColor(this.fJy, (int) R.color.cp_cont_g);
        ap.setBackgroundResource(this.fJy, R.drawable.frs_attention_btn_bg_selector);
        ap.setBackgroundResource(this.fJt, R.color.cp_bg_line_c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kM(boolean z) {
        Drawable drawable;
        int i = R.drawable.frs_attention_btn_bg_selector;
        ap.setBackgroundResource(this.fJy, R.drawable.frs_attention_btn_bg_selector);
        int dimens = l.getDimens(this.mContext, R.dimen.ds10);
        String string = this.mContext.getResources().getString(R.string.attention);
        int i2 = R.color.cp_cont_a;
        if (this.mCurState == 1) {
            drawable = ap.getDrawable(R.drawable.icon_add_follow_blue_s);
            this.fJy.setClickable(true);
            if (!z) {
                TiebaStatic.log(new aq("c12889"));
            }
        } else if (this.mCurState == 2) {
            string = this.mContext.getResources().getString(R.string.sign);
            drawable = ap.getDrawable(R.drawable.icon_public_sign_blue_s);
            this.fJy.setClickable(true);
            if (!z) {
                TiebaStatic.log(new aq("c12891"));
            }
        } else if (this.mCurState == 3) {
            string = this.mContext.getResources().getString(R.string.signed);
            this.fJy.setClickable(false);
            i = R.drawable.special_sign_btn_signed_bg;
            i2 = R.color.cp_cont_d;
            drawable = null;
        } else {
            drawable = null;
        }
        ap.setBackgroundResource(this.fJy, i);
        ap.setViewTextColor(this.fJy, i2);
        this.fJy.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.fJy.setCompoundDrawablePadding(dimens);
        this.fJy.setText(string);
        bGO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kN(boolean z) {
        if (this.fJE != null) {
            if (z) {
                ap.setNavbarIconSrc(this.fJE, R.drawable.selector_topbar_return_black, R.drawable.selector_topbar_return_black, TbadkCoreApplication.getInst().getSkinType());
            } else {
                ap.setNavbarIconSrc(this.fJE, R.drawable.selector_topbar_return_white, R.drawable.selector_topbar_return_white, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    private void bGO() {
        if (this.mData != null && this.mData.fKq != null && this.mCurState != 1) {
            int i = this.mData.fKq.level_id;
            String str = TextUtils.isEmpty(this.mData.fKq.level_name) ? "" : " " + this.mData.fKq.level_name;
            if (i >= 0) {
                this.fJz.setText("LV" + i + str);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.fJG != null) {
            this.fJG.onDestroy();
        }
        if (this.fJS != null) {
            MessageManager.getInstance().unRegisterListener(this.fJS);
        }
        if (this.fJK != null) {
            MessageManager.getInstance().unRegisterListener(this.fJK);
        }
        if (this.mSignChangedListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mSignChangedListener);
        }
        if (this.fJT != null) {
            MessageManager.getInstance().unRegisterListener(this.fJT);
        }
        if (this.fJR != null) {
            MessageManager.getInstance().unRegisterListener(this.fJR);
        }
        if (this.mAccountChangedListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mAccountChangedListener);
        }
        if (this.fJH != null) {
            this.fJH.onDestroy();
        }
        if (this.fEh != null) {
            this.fEh.onDestroy();
        }
        AlaLiveUserNotifyManager.getInstance().removeNotifyListener(this.fEi);
        hideLoadingView(this.mRootView);
        MessageManager.getInstance().unRegisterListener(this.dVu);
    }

    private void initViewPager() {
        this.fJF = new a(getChildFragmentManager());
        this.eiw.setAdapter(this.fJF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends FragmentPagerAdapter {
        private SparseArray<SpecialForumTabBaseFragment> fJW;
        private List<SpecialLiveTabInfo> mData;

        public a(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.mData = new ArrayList();
            this.fJW = new SparseArray<>();
            this.fJW.put(0, ConcernTabFragment.sK(0));
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
            SpecialForumTabBaseFragment sI = sI(i);
            if (sI == null) {
                if (i == 0) {
                    sI = ConcernTabFragment.sK(0);
                } else if (i == 1) {
                    sI = RecommendTabFragment.sL(1);
                } else if (i < this.mData.size() && this.mData.get(i) != null && this.mData.get(i).tabId == 1108) {
                    sI = GameTabFragment.EC(this.mData.get(i).tabName);
                } else {
                    sI = OtherSubTabFragment.a(i, this.mData.get(i));
                }
                this.fJW.put(i, sI);
            }
            return sI;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.mData.size();
        }

        public SpecialForumTabBaseFragment sI(int i) {
            return this.fJW.get(i);
        }

        public void a(int i, TabData tabData) {
            if (this.fJW.get(i) != null) {
                this.fJW.get(i).setPrimary(true);
            }
        }

        public void onChangeSkinType(int i) {
            if (this.fJW != null && this.fJW.size() > 0) {
                int size = this.fJW.size();
                for (int i2 = 0; i2 < size; i2++) {
                    SpecialForumTabBaseFragment specialForumTabBaseFragment = this.fJW.get(i2);
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
            if (this.fJP != null) {
                this.fJP.dismiss();
            }
            final Handler handler = new Handler();
            final Runnable runnable = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.10
                @Override // java.lang.Runnable
                public void run() {
                    if (SpecialLiveFragment.this.fJP != null) {
                        SpecialLiveFragment.this.fJP.dismiss();
                    }
                }
            };
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.af(true);
            dVar.b(new d.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.11
                @Override // com.baidu.adp.lib.guide.d.a
                public void onShown() {
                }

                @Override // com.baidu.adp.lib.guide.d.a
                public void onDismiss() {
                    AlaSharedPrefHelper.getInstance().putBoolean(AlaSharedPrefConfig.SQUARE_GUIDE_MARK_MANAGE_TIP_SHOW, true);
                    SpecialLiveFragment.this.fJP = null;
                    handler.removeCallbacks(runnable);
                }
            });
            dVar.y(activity.getWindow().getDecorView().findViewById(R.id.tabcontainer)).aj(20).ag(false);
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
                            SpecialLiveFragment.this.fJP.dismiss();
                        }
                    });
                    ap.setViewTextColor(textView, (int) R.color.cp_cont_i);
                    bubbleLayout.Jq(ap.getColor(R.color.cp_link_tip_a_alpha95));
                    bubbleLayout.aH(activity.getResources().getDimensionPixelSize(R.dimen.ds216));
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
            this.fJP = dVar.md();
            this.fJP.show(activity);
            handler.postDelayed(runnable, 5000L);
        }
    }
}
