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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bh;
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
    private AppBarLayout Ym;
    private CustomViewPager eKk;
    private LikeModel eYI;
    private List<SpecialLiveTabInfo> flH;
    private AlaLiveUserNotifyController gjh;
    private AlaLiveUserNotifyManager.AlaLiveNotifyListener gji;
    private ScrollHorizontalTabView gmy;
    private float goA;
    private CollapsingToolbarLayout goB;
    private View goC;
    private ObservedChangeFrameLayout goD;
    private RelativeLayout goE;
    private View goF;
    private TextView goG;
    private TextView goH;
    private TextView goI;
    private RelativeLayout goJ;
    private View goK;
    private View goL;
    private TextView goM;
    private ImageView goN;
    private a goO;
    private e goP;
    private com.baidu.tieba.ala.alasquare.special_forum.model.a goQ;
    private List<TabData> goR;
    private CustomMessageListener goS;
    private int goT;
    private String goU;
    private c goX;
    private BdUniqueId mBdUniqueId;
    private Context mContext;
    private h mData;
    private String mForumId;
    private String mForumName;
    private View mRootView;
    private View mStatusBarView;
    private boolean goV = true;
    private int mCurState = 1;
    private boolean goW = false;
    private Handler mHandler = new Handler();
    private Runnable goY = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.1
        @Override // java.lang.Runnable
        public void run() {
            if (SpecialLiveFragment.this.goP != null) {
                SpecialLiveFragment.this.goP.bPr();
            }
        }
    };
    private CustomMessageListener ews = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            SpecialLiveFragment.this.mHandler.removeCallbacks(SpecialLiveFragment.this.goY);
            SpecialLiveFragment.this.mHandler.postDelayed(SpecialLiveFragment.this.goY, 500L);
        }
    };
    private CustomMessageListener goZ = new CustomMessageListener(CmdConfigCustom.CMD_FORCE_REFRESH) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2) {
                    if ("FrsLiveLive".equals(split[0])) {
                        SpecialLiveFragment.this.lP(false);
                    }
                    SpecialForumTabBaseFragment uz = SpecialLiveFragment.this.goO.uz(SpecialLiveFragment.this.eKk.getCurrentItem());
                    if (uz != null) {
                        uz.bPo();
                    }
                }
            }
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && SpecialLiveFragment.this.goQ != null && !TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                SpecialLiveFragment.this.lP(false);
            }
        }
    };
    private final CustomMessageListener gpa = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            v vVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof v) && (vVar = (v) customResponsedMessage.getData()) != null && SpecialLiveFragment.this.mForumId.equals(vVar.getFid())) {
                if (vVar.isLike() == 1) {
                    if (SpecialLiveFragment.this.bPe()) {
                        SpecialLiveFragment.this.mCurState = 3;
                    } else {
                        SpecialLiveFragment.this.mCurState = 2;
                    }
                } else {
                    SpecialLiveFragment.this.mCurState = 1;
                }
                SpecialLiveFragment.this.lQ(false);
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
                SpecialLiveFragment.this.lQ(false);
                l.showToast(SpecialLiveFragment.this.getPageContext().getPageActivity(), SpecialLiveFragment.this.mContext.getString(R.string.special_sign_success_tip, Integer.valueOf(signData.sign_bonus_point)));
            }
        }
    };
    private final CustomMessageListener gpb = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_SPECIAL_CONCERN_TAB_TAB_ICON) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                Boolean bool = (Boolean) customResponsedMessage.getData();
                if (!y.isEmpty(SpecialLiveFragment.this.goR)) {
                    ((TabData) SpecialLiveFragment.this.goR.get(0)).extra = bool;
                    SpecialLiveFragment.this.gmy.setData(SpecialLiveFragment.this.goR);
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
                this.goU = sb.toString();
            } else {
                this.mForumName = this.mContext.getResources().getString(R.string.ala_ufan_bar_title);
                this.goU = this.mForumName + string2;
            }
            bPc();
            bPa();
            bPb();
            MessageManager.getInstance().registerListener(this.goS);
            MessageManager.getInstance().registerListener(this.gpa);
            MessageManager.getInstance().registerListener(this.mSignChangedListener);
            MessageManager.getInstance().registerListener(this.gpb);
            MessageManager.getInstance().registerListener(this.goZ);
            MessageManager.getInstance().registerListener(this.mAccountChangedListener);
            MessageManager.getInstance().registerListener(this.ews);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(R.layout.special_live_layout, (ViewGroup) null);
        this.Ym = (AppBarLayout) this.mRootView.findViewById(R.id.special_app_bar_layout);
        this.goB = (CollapsingToolbarLayout) this.mRootView.findViewById(R.id.special_collapse_layout);
        this.mStatusBarView = this.mRootView.findViewById(R.id.statusbar_view);
        this.goD = (ObservedChangeFrameLayout) this.mRootView.findViewById(R.id.live_container);
        this.mBdUniqueId = BdUniqueId.gen();
        this.goE = (RelativeLayout) this.mRootView.findViewById(R.id.function_container);
        this.goF = this.mRootView.findViewById(R.id.function_bottom_space);
        this.goG = (TextView) this.mRootView.findViewById(R.id.function_title);
        this.goG.setText(this.goU);
        this.goH = (TextView) this.mRootView.findViewById(R.id.function_btn);
        this.goH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!j.isNetWorkAvailable()) {
                    SpecialLiveFragment.this.showToast(R.string.neterror);
                    return;
                }
                if (!TbadkCoreApplication.isLogin()) {
                    bh.skipToLoginActivity(SpecialLiveFragment.this.mContext);
                }
                if (SpecialLiveFragment.this.mCurState == 1) {
                    SpecialLiveFragment.this.goH.setClickable(false);
                    SpecialLiveFragment.this.eYI.gp(SpecialLiveFragment.this.mForumName, SpecialLiveFragment.this.mForumId);
                    TiebaStatic.log(new ar("c12890"));
                } else if (SpecialLiveFragment.this.mCurState == 2) {
                    SpecialLiveFragment.this.goH.setClickable(false);
                    ForumData forumData = new ForumData();
                    forumData.setId(SpecialLiveFragment.this.mForumId);
                    forumData.setName(SpecialLiveFragment.this.mForumName);
                    CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_SIGN_MODEL_TASK, forumData);
                    customMessage.setTag(SpecialLiveFragment.this.mBdUniqueId);
                    MessageManager.getInstance().sendMessage(customMessage);
                    TiebaStatic.log(new ar("c12892"));
                }
            }
        });
        this.goI = (TextView) this.mRootView.findViewById(R.id.function_level_desc);
        this.goJ = (RelativeLayout) this.mRootView.findViewById(R.id.navigation_layout);
        this.goL = this.mRootView.findViewById(R.id.navigation_top_space);
        this.goK = this.mRootView.findViewById(R.id.navigation_bg);
        this.goM = (TextView) this.mRootView.findViewById(R.id.navigation_title);
        this.goM.setText(this.goU);
        this.goN = (ImageView) this.mRootView.findViewById(R.id.navigation_back_img);
        this.goN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, SpecialLiveFragment.this.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        });
        this.gmy = (ScrollHorizontalTabView) this.mRootView.findViewById(R.id.scroll_tab_view);
        this.eKk = (CustomViewPager) this.mRootView.findViewById(R.id.special_view_pager);
        initViewPager();
        this.gmy.setViewPager(this.eKk);
        this.gmy.setScrollTabPageListener(new ScrollHorizontalTabView.ScrollTabPageListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.2
            @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
            public boolean onPrePageSelect(int i, TabData tabData) {
                return true;
            }

            @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
            public void onPageSelected(int i, TabData tabData) {
                if (i != 0 || TbadkCoreApplication.isLogin()) {
                    if (SpecialLiveFragment.this.goO != null) {
                        SpecialLiveFragment.this.goO.a(i, tabData);
                        return;
                    }
                    return;
                }
                bh.skipToLoginActivity(SpecialLiveFragment.this.getPageContext().getPageActivity());
                if (SpecialLiveFragment.this.eKk != null) {
                    SpecialLiveFragment.this.eKk.setCurrentItem(1);
                }
            }

            @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
            public void onPageScrolled(int i, float f, int i2) {
            }
        });
        this.Ym.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.3
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                int abs = Math.abs(i);
                if (abs == 0) {
                    SpecialLiveFragment.this.goK.setVisibility(8);
                    SpecialLiveFragment.this.goM.setVisibility(8);
                } else {
                    SpecialLiveFragment.this.goK.setVisibility(0);
                    SpecialLiveFragment.this.goM.setVisibility(0);
                }
                SpecialLiveFragment.this.lR(((float) abs) > SpecialLiveFragment.this.goA / 2.0f);
                float abs2 = Math.abs(abs / SpecialLiveFragment.this.goA);
                SpecialLiveFragment.this.goK.setAlpha(abs2);
                SpecialLiveFragment.this.goM.setAlpha(abs2);
                SpecialLiveFragment.this.g(abs, abs2);
            }
        });
        this.goC = this.mRootView.findViewById(R.id.square_main_top_divider_line);
        this.goD.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.4
            @Override // com.baidu.tbadk.widget.layout.e
            public void d(View view, int i, int i2, int i3, int i4) {
                SpecialLiveFragment.this.goA = (SpecialLiveFragment.this.goD.getMeasuredHeight() + SpecialLiveFragment.this.goE.getMeasuredHeight()) - SpecialLiveFragment.this.goJ.getMeasuredHeight();
                SpecialLiveFragment.this.goB.setMinimumHeight(SpecialLiveFragment.this.goJ.getMeasuredHeight());
            }
        });
        SQ();
        this.goR = new ArrayList();
        this.flH = new ArrayList();
        this.goP = new e(getPageContext());
        this.goQ = new com.baidu.tieba.ala.alasquare.special_forum.model.a(getPageContext(), new a.InterfaceC0633a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.5
            @Override // com.baidu.tieba.ala.alasquare.special_forum.model.a.InterfaceC0633a
            public void b(h hVar) {
                SpecialLiveFragment.this.hideLoadingView(SpecialLiveFragment.this.mRootView);
                SpecialLiveFragment.this.a(hVar);
            }

            @Override // com.baidu.tieba.ala.alasquare.special_forum.model.a.InterfaceC0633a
            public void t(int i, String str) {
                SpecialLiveFragment.this.aR(i, str);
            }
        });
        lQ(true);
        lP(true);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.mRootView.post(new Runnable() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.6
            @Override // java.lang.Runnable
            public void run() {
                SpecialLiveFragment.this.aj(SpecialLiveFragment.this.getFragmentActivity());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lP(boolean z) {
        if (!this.goQ.isLoading()) {
            if (z) {
                showLoadingView(this.mRootView);
            }
            this.goQ.loadData();
        }
    }

    private void bPa() {
        this.gjh = new AlaLiveUserNotifyController(getPageContext());
        this.gji = new AlaLiveUserNotifyManager.AlaLiveNotifyListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.7
            @Override // com.baidu.ala.notify.AlaLiveUserNotifyManager.AlaLiveNotifyListener
            public void onCallBack() {
                if (SpecialLiveFragment.this.isPrimary()) {
                    SpecialLiveFragment.this.gjh.showNextNotifyDialog(0, AlaLiveUserNotifyManager.getInstance().getNotifyDataList());
                }
            }
        };
        AlaLiveUserNotifyManager.getInstance().addNotifyListener(this.gji);
    }

    private void bPb() {
        this.goS = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_MODEL_TASK) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z;
                SignData signData = null;
                SpecialLiveFragment.this.goH.setClickable(true);
                if (customResponsedMessage != null && customResponsedMessage.getOrginalMessage().getTag() == SpecialLiveFragment.this.mBdUniqueId) {
                    SignMessage signMessage = (SignMessage) customResponsedMessage;
                    if (AntiHelper.bP(signMessage.mSignErrorCode, signMessage.mSignErrorString) && signMessage.signData != null) {
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
                        if (AntiHelper.bP(signMessage.mSignErrorCode, signMessage.mSignErrorString)) {
                            AntiHelper.bj(SpecialLiveFragment.this.mContext, signMessage.mSignErrorString);
                            return;
                        } else {
                            l.showToast(SpecialLiveFragment.this.mContext, SpecialLiveFragment.this.mContext.getString(R.string.special_sign_success_tip, Integer.valueOf(signData.sign_bonus_point)));
                            return;
                        }
                    }
                    if (signMessage.mSignErrorCode == 160002) {
                        SpecialLiveFragment.this.mCurState = 3;
                        SpecialLiveFragment.this.lQ(false);
                    }
                    l.showToast(SpecialLiveFragment.this.mContext, signMessage.mSignErrorString);
                }
            }
        };
    }

    private void bPc() {
        this.eYI = new LikeModel(getPageContext());
        this.eYI.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.9
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                SpecialLiveFragment.this.goH.setClickable(true);
                if (SpecialLiveFragment.this.eYI.getErrorCode() == 22) {
                    l.showToast(SpecialLiveFragment.this.mContext, R.string.had_liked_forum);
                } else if (AntiHelper.bP(SpecialLiveFragment.this.eYI.getErrorCode(), SpecialLiveFragment.this.eYI.getErrorString())) {
                    AntiHelper.bj(SpecialLiveFragment.this.mContext, SpecialLiveFragment.this.eYI.getErrorString());
                } else if (SpecialLiveFragment.this.eYI.getErrorCode() != 0) {
                    l.showToast(SpecialLiveFragment.this.mContext, SpecialLiveFragment.this.eYI.getErrorString());
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
        this.Ym.setVisibility(0);
        this.mData = hVar;
        bPf();
        bPd();
        if (!this.goW) {
            bPg();
            if (this.eKk != null && this.eKk.getChildCount() > 1) {
                this.eKk.setCurrentItem(1);
            }
            if (!y.isEmpty(this.mData.tabInfoList)) {
                this.goW = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aR(int i, String str) {
        hideLoadingView(this.mRootView);
        this.Ym.setVisibility(8);
        if (TextUtils.isEmpty(str)) {
            showNetRefreshView(this.mRootView, this.mContext.getResources().getString(R.string.square_load_data_failed_tip), true);
        } else {
            showNetRefreshView(this.mRootView, str, true);
        }
    }

    private void bPd() {
        if (this.mData.gpx) {
            if (bPe()) {
                this.mCurState = 3;
            } else {
                this.mCurState = 2;
            }
        } else {
            this.mCurState = 1;
        }
        lQ(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bPe() {
        return this.mData.gpz.gpF;
    }

    private void bPf() {
        boolean c = this.goP.c(this.mData.gpv);
        if (c) {
            this.goP.stopPlay();
            this.goP.onDestroy();
        }
        this.goP.a(this.mData.gpv, c);
        if (c) {
            this.goP.Z(this.goD);
        }
        this.goP.startPlay();
    }

    private void bPg() {
        bPh();
        this.gmy.setData(this.goR);
        this.goO.setData(this.flH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(int i, float f) {
        if (this.goP != null && f != 0.0f) {
            if (this.goT <= i) {
                if (this.goV && f >= 0.3f) {
                    this.goP.lC(true);
                    this.goP.pause();
                    this.goV = false;
                }
            } else if (!this.goV && f <= 0.3f) {
                this.goP.lC(false);
                this.goP.resume();
                this.goV = true;
            }
            this.goT = i;
        }
    }

    private void SQ() {
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds88);
        if (UtilHelper.canUseStyleImmersiveSticky() && this.mStatusBarView.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.mStatusBarView.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.mStatusBarView.setLayoutParams(layoutParams);
            this.mStatusBarView.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.goL.getLayoutParams();
            layoutParams2.height = layoutParams.height;
            this.goL.setLayoutParams(layoutParams2);
            dimensionPixelSize = layoutParams.height + dimensionPixelSize;
        } else {
            this.mStatusBarView.setVisibility(8);
        }
        CollapsingToolbarLayout.LayoutParams layoutParams3 = (CollapsingToolbarLayout.LayoutParams) this.goJ.getLayoutParams();
        layoutParams3.height = dimensionPixelSize;
        this.goJ.setLayoutParams(layoutParams3);
    }

    private void bPh() {
        this.goR.clear();
        this.flH.clear();
        this.goR.add(bPk());
        this.goR.add(bPl());
        this.flH.add(bPi());
        this.flH.add(bPj());
        if (!y.isEmpty(this.mData.tabInfoList)) {
            boolean z = b.bpu().getInt("chushou_game_tab", 1) == 1;
            for (int i = 0; i < this.mData.tabInfoList.size() && i < 10; i++) {
                SpecialLiveTabInfo specialLiveTabInfo = this.mData.tabInfoList.get(i);
                if (specialLiveTabInfo != null && (specialLiveTabInfo.tabId != 1108 || z)) {
                    this.flH.add(specialLiveTabInfo);
                    TabData tabData = new TabData();
                    tabData.tabId = specialLiveTabInfo.tabId;
                    tabData.tabName = specialLiveTabInfo.tabName;
                    tabData.tabType = specialLiveTabInfo.tabType;
                    this.goR.add(tabData);
                }
            }
        }
    }

    private SpecialLiveTabInfo bPi() {
        SpecialLiveTabInfo specialLiveTabInfo = new SpecialLiveTabInfo();
        specialLiveTabInfo.tabId = -901;
        specialLiveTabInfo.tabName = this.mContext.getResources().getString(R.string.special_concern_tab_title);
        return specialLiveTabInfo;
    }

    private SpecialLiveTabInfo bPj() {
        SpecialLiveTabInfo specialLiveTabInfo = new SpecialLiveTabInfo();
        specialLiveTabInfo.tabId = -903;
        specialLiveTabInfo.tabName = this.mContext.getResources().getString(R.string.special_recommend_tab_title);
        return specialLiveTabInfo;
    }

    private TabData bPk() {
        TabData tabData = new TabData();
        tabData.tabId = -901;
        tabData.tabName = this.mContext.getResources().getString(R.string.special_concern_tab_title);
        return tabData;
    }

    private TabData bPl() {
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
                lP(false);
                AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
            }
            if (this.goP != null) {
                if (isPrimary()) {
                    this.goP.lC(false);
                    this.goP.startPlay();
                    return;
                }
                this.goP.lC(true);
                this.goP.pause();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        hideNetRefreshView(this.mRootView);
        lP(true);
        AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.goP != null) {
            this.goP.lC(true);
            this.goP.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.goP != null) {
            this.goP.onChangeSkinType(i);
        }
        if (this.gmy != null) {
            ap.setBackgroundResource(this.gmy, R.color.CAM_X0201);
            this.gmy.onChangeSkinType(i);
        }
        if (this.goO != null) {
            this.goO.onChangeSkinType(i);
        }
        lR(false);
        ap.setBackgroundColor(this.mStatusBarView, R.color.CAM_X0201);
        ap.setBackgroundColor(this.goK, R.color.CAM_X0201);
        ap.setViewTextColor(this.goM, R.color.CAM_X0105);
        ap.setBackgroundColor(this.goE, R.color.CAM_X0201);
        ap.setBackgroundColor(this.goF, R.color.CAM_X0205);
        ap.setViewTextColor(this.goG, R.color.CAM_X0105);
        ap.setViewTextColor(this.goI, R.color.CAM_X0107);
        ap.setViewTextColor(this.goH, R.color.CAM_X0111);
        ap.setBackgroundResource(this.goH, R.drawable.frs_attention_btn_bg_selector);
        ap.setBackgroundResource(this.goC, R.color.CAM_X0204);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lQ(boolean z) {
        Drawable drawable;
        ap.setBackgroundResource(this.goH, R.drawable.frs_attention_btn_bg_selector);
        int dimens = l.getDimens(this.mContext, R.dimen.ds10);
        String string = this.mContext.getResources().getString(R.string.attention);
        int i = R.drawable.frs_attention_btn_bg_selector;
        int i2 = R.color.CAM_X0101;
        if (this.mCurState == 1) {
            drawable = ap.getDrawable(R.drawable.icon_add_follow_blue_s);
            this.goH.setClickable(true);
            if (!z) {
                TiebaStatic.log(new ar("c12889"));
            }
        } else if (this.mCurState == 2) {
            string = this.mContext.getResources().getString(R.string.sign);
            drawable = ap.getDrawable(R.drawable.icon_public_sign_blue_s);
            this.goH.setClickable(true);
            if (!z) {
                TiebaStatic.log(new ar("c12891"));
            }
        } else if (this.mCurState == 3) {
            string = this.mContext.getResources().getString(R.string.signed);
            this.goH.setClickable(false);
            i = R.drawable.special_sign_btn_signed_bg;
            i2 = R.color.CAM_X0109;
            drawable = null;
        } else {
            drawable = null;
        }
        ap.setBackgroundResource(this.goH, i);
        ap.setViewTextColor(this.goH, i2);
        this.goH.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.goH.setCompoundDrawablePadding(dimens);
        this.goH.setText(string);
        bPm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lR(boolean z) {
        if (this.goN != null) {
            if (z) {
                ap.setNavbarIconSrc(this.goN, R.drawable.selector_topbar_return_black, R.drawable.selector_topbar_return_black, TbadkCoreApplication.getInst().getSkinType());
            } else {
                ap.setNavbarIconSrc(this.goN, R.drawable.selector_topbar_return_white, R.drawable.selector_topbar_return_white, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    private void bPm() {
        if (this.mData != null && this.mData.gpy != null && this.mCurState != 1) {
            int i = this.mData.gpy.level_id;
            String str = TextUtils.isEmpty(this.mData.gpy.level_name) ? "" : " " + this.mData.gpy.level_name;
            if (i >= 0) {
                this.goI.setText("LV" + i + str);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.goP != null) {
            this.goP.onDestroy();
        }
        if (this.gpa != null) {
            MessageManager.getInstance().unRegisterListener(this.gpa);
        }
        if (this.goS != null) {
            MessageManager.getInstance().unRegisterListener(this.goS);
        }
        if (this.mSignChangedListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mSignChangedListener);
        }
        if (this.gpb != null) {
            MessageManager.getInstance().unRegisterListener(this.gpb);
        }
        if (this.goZ != null) {
            MessageManager.getInstance().unRegisterListener(this.goZ);
        }
        if (this.mAccountChangedListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mAccountChangedListener);
        }
        if (this.goQ != null) {
            this.goQ.onDestroy();
        }
        if (this.gjh != null) {
            this.gjh.onDestroy();
        }
        AlaLiveUserNotifyManager.getInstance().removeNotifyListener(this.gji);
        hideLoadingView(this.mRootView);
        MessageManager.getInstance().unRegisterListener(this.ews);
    }

    private void initViewPager() {
        this.goO = new a(getChildFragmentManager());
        this.eKk.setAdapter(this.goO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends FragmentPagerAdapter {
        private SparseArray<SpecialForumTabBaseFragment> gpe;
        private List<SpecialLiveTabInfo> mData;

        public a(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.mData = new ArrayList();
            this.gpe = new SparseArray<>();
            this.gpe.put(0, ConcernTabFragment.uB(0));
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
            SpecialForumTabBaseFragment uz = uz(i);
            if (uz == null) {
                if (i == 0) {
                    uz = ConcernTabFragment.uB(0);
                } else if (i == 1) {
                    uz = RecommendTabFragment.uC(1);
                } else if (i < this.mData.size() && this.mData.get(i) != null && this.mData.get(i).tabId == 1108) {
                    uz = GameTabFragment.Ga(this.mData.get(i).tabName);
                } else {
                    uz = OtherSubTabFragment.a(i, this.mData.get(i));
                }
                this.gpe.put(i, uz);
            }
            return uz;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.mData.size();
        }

        public SpecialForumTabBaseFragment uz(int i) {
            return this.gpe.get(i);
        }

        public void a(int i, TabData tabData) {
            if (this.gpe.get(i) != null) {
                this.gpe.get(i).setPrimary(true);
            }
        }

        public void onChangeSkinType(int i) {
            if (this.gpe != null && this.gpe.size() > 0) {
                int size = this.gpe.size();
                for (int i2 = 0; i2 < size; i2++) {
                    SpecialForumTabBaseFragment specialForumTabBaseFragment = this.gpe.get(i2);
                    if (specialForumTabBaseFragment != null) {
                        specialForumTabBaseFragment.onChangeSkinType(i);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aj(final Activity activity) {
        if (activity != null && !AlaSharedPrefHelper.getInstance().getBoolean(AlaSharedPrefConfig.SQUARE_GUIDE_MARK_MANAGE_TIP_SHOW, false)) {
            if (this.goX != null) {
                this.goX.dismiss();
            }
            final Handler handler = new Handler();
            final Runnable runnable = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.10
                @Override // java.lang.Runnable
                public void run() {
                    if (SpecialLiveFragment.this.goX != null) {
                        SpecialLiveFragment.this.goX.dismiss();
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
                    SpecialLiveFragment.this.goX = null;
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
                            SpecialLiveFragment.this.goX.dismiss();
                        }
                    });
                    ap.setViewTextColor(textView, R.color.CAM_X0112);
                    bubbleLayout.LI(ap.getColor(R.color.cp_link_tip_a_alpha95));
                    bubbleLayout.aY(activity.getResources().getDimensionPixelSize(R.dimen.ds216));
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
            this.goX = dVar.mi();
            this.goX.show(activity);
            handler.postDelayed(runnable, 5000L);
        }
    }
}
