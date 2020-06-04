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
    private AppBarLayout Wr;
    private CustomViewPager dLI;
    private LikeModel dYI;
    private AlaLiveUserNotifyController fcu;
    private AlaLiveUserNotifyManager.AlaLiveNotifyListener fcv;
    private ScrollHorizontalTabView ffE;
    private float fhD;
    private CollapsingToolbarLayout fhE;
    private View fhF;
    private ObservedChangeFrameLayout fhG;
    private RelativeLayout fhH;
    private View fhI;
    private TextView fhJ;
    private TextView fhK;
    private TextView fhL;
    private RelativeLayout fhM;
    private View fhN;
    private View fhO;
    private TextView fhP;
    private ImageView fhQ;
    private a fhR;
    private e fhS;
    private com.baidu.tieba.ala.alasquare.special_forum.model.a fhT;
    private List<TabData> fhU;
    private List<SpecialLiveTabInfo> fhV;
    private CustomMessageListener fhW;
    private int fhX;
    private String fhY;
    private c fib;
    private BdUniqueId mBdUniqueId;
    private Context mContext;
    private h mData;
    private String mForumId;
    private String mForumName;
    private View mRootView;
    private View mStatusBarView;
    private boolean fhZ = true;
    private int mCurState = 1;
    private boolean fia = false;
    private Handler mHandler = new Handler();
    private Runnable fic = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.1
        @Override // java.lang.Runnable
        public void run() {
            if (SpecialLiveFragment.this.fhS != null) {
                SpecialLiveFragment.this.fhS.brQ();
            }
        }
    };
    private CustomMessageListener dzH = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            SpecialLiveFragment.this.mHandler.removeCallbacks(SpecialLiveFragment.this.fic);
            SpecialLiveFragment.this.mHandler.postDelayed(SpecialLiveFragment.this.fic, 500L);
        }
    };
    private CustomMessageListener fie = new CustomMessageListener(CmdConfigCustom.CMD_FORCE_REFRESH) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2) {
                    if ("FrsLiveLive".equals(split[0])) {
                        SpecialLiveFragment.this.jw(false);
                    }
                    SpecialForumTabBaseFragment pI = SpecialLiveFragment.this.fhR.pI(SpecialLiveFragment.this.dLI.getCurrentItem());
                    if (pI != null) {
                        pI.brL();
                    }
                }
            }
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && SpecialLiveFragment.this.fhT != null && !TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                SpecialLiveFragment.this.jw(false);
            }
        }
    };
    private final CustomMessageListener fif = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            u uVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof u) && (uVar = (u) customResponsedMessage.getData()) != null && SpecialLiveFragment.this.mForumId.equals(uVar.getFid())) {
                if (uVar.isLike() == 1) {
                    if (SpecialLiveFragment.this.brB()) {
                        SpecialLiveFragment.this.mCurState = 3;
                    } else {
                        SpecialLiveFragment.this.mCurState = 2;
                    }
                } else {
                    SpecialLiveFragment.this.mCurState = 1;
                }
                SpecialLiveFragment.this.jx(false);
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
                SpecialLiveFragment.this.jx(false);
                l.showToast(SpecialLiveFragment.this.getPageContext().getPageActivity(), SpecialLiveFragment.this.mContext.getString(R.string.special_sign_success_tip, Integer.valueOf(signData.sign_bonus_point)));
            }
        }
    };
    private final CustomMessageListener fig = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_SPECIAL_CONCERN_TAB_TAB_ICON) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                Boolean bool = (Boolean) customResponsedMessage.getData();
                if (!v.isEmpty(SpecialLiveFragment.this.fhU)) {
                    ((TabData) SpecialLiveFragment.this.fhU.get(0)).extra = bool;
                    SpecialLiveFragment.this.ffE.setData(SpecialLiveFragment.this.fhU);
                    if (bool.booleanValue()) {
                        TiebaStatic.log("c12898");
                    }
                }
            }
        }
    };

    public static SpecialLiveFragment dz(String str, String str2) {
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
                this.fhY = sb.toString();
            } else {
                this.mForumName = this.mContext.getResources().getString(R.string.ala_ufan_bar_title);
                this.fhY = this.mForumName + string2;
            }
            brz();
            brx();
            bry();
            MessageManager.getInstance().registerListener(this.fhW);
            MessageManager.getInstance().registerListener(this.fif);
            MessageManager.getInstance().registerListener(this.mSignChangedListener);
            MessageManager.getInstance().registerListener(this.fig);
            MessageManager.getInstance().registerListener(this.fie);
            MessageManager.getInstance().registerListener(this.mAccountChangedListener);
            MessageManager.getInstance().registerListener(this.dzH);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(R.layout.special_live_layout, (ViewGroup) null);
        this.Wr = (AppBarLayout) this.mRootView.findViewById(R.id.special_app_bar_layout);
        this.fhE = (CollapsingToolbarLayout) this.mRootView.findViewById(R.id.special_collapse_layout);
        this.mStatusBarView = this.mRootView.findViewById(R.id.statusbar_view);
        this.fhG = (ObservedChangeFrameLayout) this.mRootView.findViewById(R.id.live_container);
        this.mBdUniqueId = BdUniqueId.gen();
        this.fhH = (RelativeLayout) this.mRootView.findViewById(R.id.function_container);
        this.fhI = this.mRootView.findViewById(R.id.function_bottom_space);
        this.fhJ = (TextView) this.mRootView.findViewById(R.id.function_title);
        this.fhJ.setText(this.fhY);
        this.fhK = (TextView) this.mRootView.findViewById(R.id.function_btn);
        this.fhK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.19
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
                    SpecialLiveFragment.this.fhK.setClickable(false);
                    SpecialLiveFragment.this.dYI.fq(SpecialLiveFragment.this.mForumName, SpecialLiveFragment.this.mForumId);
                    TiebaStatic.log(new an("c12890"));
                } else if (SpecialLiveFragment.this.mCurState == 2) {
                    SpecialLiveFragment.this.fhK.setClickable(false);
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
        this.fhL = (TextView) this.mRootView.findViewById(R.id.function_level_desc);
        this.fhM = (RelativeLayout) this.mRootView.findViewById(R.id.navigation_layout);
        this.fhO = this.mRootView.findViewById(R.id.navigation_top_space);
        this.fhN = this.mRootView.findViewById(R.id.navigation_bg);
        this.fhP = (TextView) this.mRootView.findViewById(R.id.navigation_title);
        this.fhP.setText(this.fhY);
        this.fhQ = (ImageView) this.mRootView.findViewById(R.id.navigation_back_img);
        this.fhQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, SpecialLiveFragment.this.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        });
        this.ffE = (ScrollHorizontalTabView) this.mRootView.findViewById(R.id.scroll_tab_view);
        this.dLI = (CustomViewPager) this.mRootView.findViewById(R.id.special_view_pager);
        initViewPager();
        this.ffE.setViewPager(this.dLI);
        this.ffE.setScrollTabPageListener(new ScrollHorizontalTabView.ScrollTabPageListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.2
            @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
            public boolean onPrePageSelect(int i, TabData tabData) {
                return true;
            }

            @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
            public void onPageSelected(int i, TabData tabData) {
                if (i != 0 || TbadkCoreApplication.isLogin()) {
                    if (SpecialLiveFragment.this.fhR != null) {
                        SpecialLiveFragment.this.fhR.a(i, tabData);
                        return;
                    }
                    return;
                }
                bc.skipToLoginActivity(SpecialLiveFragment.this.getPageContext().getPageActivity());
                if (SpecialLiveFragment.this.dLI != null) {
                    SpecialLiveFragment.this.dLI.setCurrentItem(1);
                }
            }

            @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
            public void onPageScrolled(int i, float f, int i2) {
            }
        });
        this.Wr.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.3
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                int abs = Math.abs(i);
                if (abs == 0) {
                    SpecialLiveFragment.this.fhN.setVisibility(8);
                    SpecialLiveFragment.this.fhP.setVisibility(8);
                } else {
                    SpecialLiveFragment.this.fhN.setVisibility(0);
                    SpecialLiveFragment.this.fhP.setVisibility(0);
                }
                SpecialLiveFragment.this.jy(((float) abs) > SpecialLiveFragment.this.fhD / 2.0f);
                float abs2 = Math.abs(abs / SpecialLiveFragment.this.fhD);
                SpecialLiveFragment.this.fhN.setAlpha(abs2);
                SpecialLiveFragment.this.fhP.setAlpha(abs2);
                SpecialLiveFragment.this.g(abs, abs2);
            }
        });
        this.fhF = this.mRootView.findViewById(R.id.square_main_top_divider_line);
        this.fhG.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.4
            @Override // com.baidu.tbadk.widget.layout.e
            public void d(View view, int i, int i2, int i3, int i4) {
                SpecialLiveFragment.this.fhD = (SpecialLiveFragment.this.fhG.getMeasuredHeight() + SpecialLiveFragment.this.fhH.getMeasuredHeight()) - SpecialLiveFragment.this.fhM.getMeasuredHeight();
                SpecialLiveFragment.this.fhE.setMinimumHeight(SpecialLiveFragment.this.fhM.getMeasuredHeight());
            }
        });
        Hc();
        this.fhU = new ArrayList();
        this.fhV = new ArrayList();
        this.fhS = new e(getPageContext());
        this.fhT = new com.baidu.tieba.ala.alasquare.special_forum.model.a(getPageContext(), new a.InterfaceC0527a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.5
            @Override // com.baidu.tieba.ala.alasquare.special_forum.model.a.InterfaceC0527a
            public void b(h hVar) {
                SpecialLiveFragment.this.hideLoadingView(SpecialLiveFragment.this.mRootView);
                SpecialLiveFragment.this.a(hVar);
            }

            @Override // com.baidu.tieba.ala.alasquare.special_forum.model.a.InterfaceC0527a
            public void ax(int i, String str) {
                SpecialLiveFragment.this.aB(i, str);
            }
        });
        jx(true);
        jw(true);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.mRootView.post(new Runnable() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.6
            @Override // java.lang.Runnable
            public void run() {
                SpecialLiveFragment.this.af(SpecialLiveFragment.this.getFragmentActivity());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jw(boolean z) {
        if (!this.fhT.isLoading()) {
            if (z) {
                showLoadingView(this.mRootView);
            }
            this.fhT.loadData();
        }
    }

    private void brx() {
        this.fcu = new AlaLiveUserNotifyController(getPageContext());
        this.fcv = new AlaLiveUserNotifyManager.AlaLiveNotifyListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.7
            @Override // com.baidu.ala.notify.AlaLiveUserNotifyManager.AlaLiveNotifyListener
            public void onCallBack() {
                if (SpecialLiveFragment.this.isPrimary()) {
                    SpecialLiveFragment.this.fcu.showNextNotifyDialog(0, AlaLiveUserNotifyManager.getInstance().getNotifyDataList());
                }
            }
        };
        AlaLiveUserNotifyManager.getInstance().addNotifyListener(this.fcv);
    }

    private void bry() {
        this.fhW = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_MODEL_TASK) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z;
                SignData signData = null;
                SpecialLiveFragment.this.fhK.setClickable(true);
                if (customResponsedMessage != null && customResponsedMessage.getOrginalMessage().getTag() == SpecialLiveFragment.this.mBdUniqueId) {
                    SignMessage signMessage = (SignMessage) customResponsedMessage;
                    if (AntiHelper.bv(signMessage.mSignErrorCode, signMessage.mSignErrorString) && signMessage.signData != null) {
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
                        if (AntiHelper.bv(signMessage.mSignErrorCode, signMessage.mSignErrorString)) {
                            AntiHelper.aX(SpecialLiveFragment.this.mContext, signMessage.mSignErrorString);
                            return;
                        } else {
                            l.showToast(SpecialLiveFragment.this.mContext, SpecialLiveFragment.this.mContext.getString(R.string.special_sign_success_tip, Integer.valueOf(signData.sign_bonus_point)));
                            return;
                        }
                    }
                    if (signMessage.mSignErrorCode == 160002) {
                        SpecialLiveFragment.this.mCurState = 3;
                        SpecialLiveFragment.this.jx(false);
                    }
                    l.showToast(SpecialLiveFragment.this.mContext, signMessage.mSignErrorString);
                }
            }
        };
    }

    private void brz() {
        this.dYI = new LikeModel(getPageContext());
        this.dYI.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.9
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                SpecialLiveFragment.this.fhK.setClickable(true);
                if (SpecialLiveFragment.this.dYI.getErrorCode() == 22) {
                    l.showToast(SpecialLiveFragment.this.mContext, (int) R.string.had_liked_forum);
                } else if (AntiHelper.bv(SpecialLiveFragment.this.dYI.getErrorCode(), SpecialLiveFragment.this.dYI.getErrorString())) {
                    AntiHelper.aX(SpecialLiveFragment.this.mContext, SpecialLiveFragment.this.dYI.getErrorString());
                } else if (SpecialLiveFragment.this.dYI.getErrorCode() != 0) {
                    l.showToast(SpecialLiveFragment.this.mContext, SpecialLiveFragment.this.dYI.getErrorString());
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
        brC();
        brA();
        if (!this.fia) {
            brD();
            if (this.dLI != null && this.dLI.getChildCount() > 1) {
                this.dLI.setCurrentItem(1);
            }
            if (!v.isEmpty(this.mData.tabInfoList)) {
                this.fia = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aB(int i, String str) {
        if (TextUtils.isEmpty(str)) {
            showNetRefreshView(this.mRootView, this.mContext.getResources().getString(R.string.square_load_data_failed_tip), false);
        } else {
            showNetRefreshView(this.mRootView, str, false);
        }
    }

    private void brA() {
        if (this.mData.fiD) {
            if (brB()) {
                this.mCurState = 3;
            } else {
                this.mCurState = 2;
            }
        } else {
            this.mCurState = 1;
        }
        jx(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean brB() {
        return this.mData.fiF.fiL;
    }

    private void brC() {
        boolean c = this.fhS.c(this.mData.fiB);
        if (c) {
            this.fhS.stopPlay();
            this.fhS.onDestroy();
        }
        this.fhS.a(this.mData.fiB, c);
        if (c) {
            this.fhS.T(this.fhG);
        }
        this.fhS.startPlay();
    }

    private void brD() {
        brE();
        this.ffE.setData(this.fhU);
        this.fhR.setData(this.fhV);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(int i, float f) {
        if (this.fhS != null && f != 0.0f) {
            if (this.fhX <= i) {
                if (this.fhZ && f >= 0.3f) {
                    this.fhS.jj(true);
                    this.fhS.pause();
                    this.fhZ = false;
                }
            } else if (!this.fhZ && f <= 0.3f) {
                this.fhS.jj(false);
                this.fhS.resume();
                this.fhZ = true;
            }
            this.fhX = i;
        }
    }

    private void Hc() {
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds88);
        if (UtilHelper.canUseStyleImmersiveSticky() && this.mStatusBarView.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.mStatusBarView.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.mStatusBarView.setLayoutParams(layoutParams);
            this.mStatusBarView.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fhO.getLayoutParams();
            layoutParams2.height = layoutParams.height;
            this.fhO.setLayoutParams(layoutParams2);
            dimensionPixelSize = layoutParams.height + dimensionPixelSize;
        } else {
            this.mStatusBarView.setVisibility(8);
        }
        CollapsingToolbarLayout.LayoutParams layoutParams3 = (CollapsingToolbarLayout.LayoutParams) this.fhM.getLayoutParams();
        layoutParams3.height = dimensionPixelSize;
        this.fhM.setLayoutParams(layoutParams3);
    }

    private void brE() {
        this.fhU.clear();
        this.fhV.clear();
        this.fhU.add(brH());
        this.fhU.add(brI());
        this.fhV.add(brF());
        this.fhV.add(brG());
        if (!v.isEmpty(this.mData.tabInfoList)) {
            boolean z = b.aTX().getInt("chushou_game_tab", 1) == 1;
            for (int i = 0; i < this.mData.tabInfoList.size() && i < 10; i++) {
                SpecialLiveTabInfo specialLiveTabInfo = this.mData.tabInfoList.get(i);
                if (specialLiveTabInfo != null && (specialLiveTabInfo.tabId != 1108 || z)) {
                    this.fhV.add(specialLiveTabInfo);
                    TabData tabData = new TabData();
                    tabData.tabId = specialLiveTabInfo.tabId;
                    tabData.tabName = specialLiveTabInfo.tabName;
                    tabData.tabType = specialLiveTabInfo.tabType;
                    this.fhU.add(tabData);
                }
            }
        }
    }

    private SpecialLiveTabInfo brF() {
        SpecialLiveTabInfo specialLiveTabInfo = new SpecialLiveTabInfo();
        specialLiveTabInfo.tabId = OpenBdussResult.ERROR_CODE_NOT_LOGIN;
        specialLiveTabInfo.tabName = this.mContext.getResources().getString(R.string.special_concern_tab_title);
        return specialLiveTabInfo;
    }

    private SpecialLiveTabInfo brG() {
        SpecialLiveTabInfo specialLiveTabInfo = new SpecialLiveTabInfo();
        specialLiveTabInfo.tabId = -903;
        specialLiveTabInfo.tabName = this.mContext.getResources().getString(R.string.special_recommend_tab_title);
        return specialLiveTabInfo;
    }

    private TabData brH() {
        TabData tabData = new TabData();
        tabData.tabId = OpenBdussResult.ERROR_CODE_NOT_LOGIN;
        tabData.tabName = this.mContext.getResources().getString(R.string.special_concern_tab_title);
        return tabData;
    }

    private TabData brI() {
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
                jw(false);
                AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
            }
            if (this.fhS != null) {
                if (isPrimary()) {
                    this.fhS.jj(false);
                    this.fhS.startPlay();
                    return;
                }
                this.fhS.jj(true);
                this.fhS.pause();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        hideNetRefreshView(this.mRootView);
        jw(true);
        AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.fhS != null) {
            this.fhS.jj(true);
            this.fhS.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fhS != null) {
            this.fhS.onChangeSkinType(i);
        }
        if (this.ffE != null) {
            am.setBackgroundResource(this.ffE, R.color.cp_bg_line_d);
            this.ffE.onChangeSkinType(i);
        }
        if (this.fhR != null) {
            this.fhR.onChangeSkinType(i);
        }
        jy(false);
        am.setBackgroundColor(this.mStatusBarView, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.fhN, R.color.cp_bg_line_d);
        am.setViewTextColor(this.fhP, (int) R.color.cp_cont_b);
        am.setBackgroundColor(this.fhH, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.fhI, R.color.cp_bg_line_e);
        am.setViewTextColor(this.fhJ, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.fhL, (int) R.color.cp_cont_j);
        am.setViewTextColor(this.fhK, (int) R.color.cp_cont_g);
        am.setBackgroundResource(this.fhK, R.drawable.frs_attention_btn_bg_selector);
        am.setBackgroundResource(this.fhF, R.color.cp_bg_line_c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jx(boolean z) {
        Drawable drawable;
        int i = R.drawable.frs_attention_btn_bg_selector;
        am.setBackgroundResource(this.fhK, R.drawable.frs_attention_btn_bg_selector);
        int dimens = l.getDimens(this.mContext, R.dimen.ds10);
        String string = this.mContext.getResources().getString(R.string.attention);
        int i2 = R.color.cp_cont_a;
        if (this.mCurState == 1) {
            drawable = am.getDrawable(R.drawable.icon_add_follow_blue_s);
            this.fhK.setClickable(true);
            if (!z) {
                TiebaStatic.log(new an("c12889"));
            }
        } else if (this.mCurState == 2) {
            string = this.mContext.getResources().getString(R.string.sign);
            drawable = am.getDrawable(R.drawable.icon_public_sign_blue_s);
            this.fhK.setClickable(true);
            if (!z) {
                TiebaStatic.log(new an("c12891"));
            }
        } else if (this.mCurState == 3) {
            string = this.mContext.getResources().getString(R.string.signed);
            this.fhK.setClickable(false);
            i = R.drawable.special_sign_btn_signed_bg;
            i2 = R.color.cp_cont_d;
            drawable = null;
        } else {
            drawable = null;
        }
        am.setBackgroundResource(this.fhK, i);
        am.setViewTextColor(this.fhK, i2);
        this.fhK.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.fhK.setCompoundDrawablePadding(dimens);
        this.fhK.setText(string);
        brJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jy(boolean z) {
        if (this.fhQ != null) {
            if (z) {
                am.setNavbarIconSrc(this.fhQ, R.drawable.selector_topbar_return_black, R.drawable.selector_topbar_return_black, TbadkCoreApplication.getInst().getSkinType());
            } else {
                am.setNavbarIconSrc(this.fhQ, R.drawable.selector_topbar_return_white, R.drawable.selector_topbar_return_white, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    private void brJ() {
        if (this.mData != null && this.mData.fiE != null && this.mCurState != 1) {
            int i = this.mData.fiE.level_id;
            String str = TextUtils.isEmpty(this.mData.fiE.level_name) ? "" : " " + this.mData.fiE.level_name;
            if (i >= 0) {
                this.fhL.setText("LV" + i + str);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.fhS != null) {
            this.fhS.onDestroy();
        }
        if (this.fif != null) {
            MessageManager.getInstance().unRegisterListener(this.fif);
        }
        if (this.fhW != null) {
            MessageManager.getInstance().unRegisterListener(this.fhW);
        }
        if (this.mSignChangedListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mSignChangedListener);
        }
        if (this.fig != null) {
            MessageManager.getInstance().unRegisterListener(this.fig);
        }
        if (this.fie != null) {
            MessageManager.getInstance().unRegisterListener(this.fie);
        }
        if (this.mAccountChangedListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mAccountChangedListener);
        }
        if (this.fhT != null) {
            this.fhT.onDestroy();
        }
        if (this.fcu != null) {
            this.fcu.onDestroy();
        }
        AlaLiveUserNotifyManager.getInstance().removeNotifyListener(this.fcv);
        hideLoadingView(this.mRootView);
        MessageManager.getInstance().unRegisterListener(this.dzH);
    }

    private void initViewPager() {
        this.fhR = new a(getChildFragmentManager());
        this.dLI.setAdapter(this.fhR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends FragmentPagerAdapter {
        private SparseArray<SpecialForumTabBaseFragment> fij;
        private List<SpecialLiveTabInfo> mData;

        public a(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.mData = new ArrayList();
            this.fij = new SparseArray<>();
            this.fij.put(0, ConcernTabFragment.pK(0));
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
            SpecialForumTabBaseFragment pI = pI(i);
            if (pI == null) {
                if (i == 0) {
                    pI = ConcernTabFragment.pK(0);
                } else if (i == 1) {
                    pI = RecommendTabFragment.pL(1);
                } else if (i < this.mData.size() && this.mData.get(i) != null && this.mData.get(i).tabId == 1108) {
                    pI = GameTabFragment.AY(this.mData.get(i).tabName);
                } else {
                    pI = OtherSubTabFragment.a(i, this.mData.get(i));
                }
                this.fij.put(i, pI);
            }
            return pI;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.mData.size();
        }

        public SpecialForumTabBaseFragment pI(int i) {
            return this.fij.get(i);
        }

        public void a(int i, TabData tabData) {
            if (this.fij.get(i) != null) {
                this.fij.get(i).setPrimary(true);
            }
        }

        public void onChangeSkinType(int i) {
            if (this.fij != null && this.fij.size() > 0) {
                int size = this.fij.size();
                for (int i2 = 0; i2 < size; i2++) {
                    SpecialForumTabBaseFragment specialForumTabBaseFragment = this.fij.get(i2);
                    if (specialForumTabBaseFragment != null) {
                        specialForumTabBaseFragment.onChangeSkinType(i);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void af(final Activity activity) {
        if (activity != null && !AlaSharedPrefHelper.getInstance().getBoolean(AlaSharedPrefConfig.SQUARE_GUIDE_MARK_MANAGE_TIP_SHOW, false)) {
            if (this.fib != null) {
                this.fib.dismiss();
            }
            final Handler handler = new Handler();
            final Runnable runnable = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.10
                @Override // java.lang.Runnable
                public void run() {
                    if (SpecialLiveFragment.this.fib != null) {
                        SpecialLiveFragment.this.fib.dismiss();
                    }
                }
            };
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.ad(true);
            dVar.b(new d.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.11
                @Override // com.baidu.adp.lib.guide.d.a
                public void onShown() {
                }

                @Override // com.baidu.adp.lib.guide.d.a
                public void onDismiss() {
                    AlaSharedPrefHelper.getInstance().putBoolean(AlaSharedPrefConfig.SQUARE_GUIDE_MARK_MANAGE_TIP_SHOW, true);
                    SpecialLiveFragment.this.fib = null;
                    handler.removeCallbacks(runnable);
                }
            });
            dVar.y(activity.getWindow().getDecorView().findViewById(R.id.tabcontainer)).Z(20).ae(false);
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
                            SpecialLiveFragment.this.fib.dismiss();
                        }
                    });
                    am.setViewTextColor(textView, (int) R.color.cp_cont_i);
                    bubbleLayout.Fu(am.getColor(R.color.cp_link_tip_a_alpha95));
                    bubbleLayout.ax(activity.getResources().getDimensionPixelSize(R.dimen.ds216));
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
            this.fib = dVar.ko();
            this.fib.show(activity);
            handler.postDelayed(runnable, 5000L);
        }
    }
}
