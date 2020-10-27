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
    private CustomViewPager eFw;
    private LikeModel eTL;
    private List<SpecialLiveTabInfo> fgG;
    private AlaLiveUserNotifyController gdK;
    private AlaLiveUserNotifyManager.AlaLiveNotifyListener gdL;
    private ScrollHorizontalTabView ghd;
    private String gjA;
    private c gjD;
    private float gjg;
    private CollapsingToolbarLayout gjh;
    private View gji;
    private ObservedChangeFrameLayout gjj;
    private RelativeLayout gjk;
    private View gjl;
    private TextView gjm;
    private TextView gjn;
    private TextView gjo;
    private RelativeLayout gjp;
    private View gjq;
    private View gjr;
    private TextView gjs;
    private ImageView gjt;
    private a gju;
    private e gjv;
    private com.baidu.tieba.ala.alasquare.special_forum.model.a gjw;
    private List<TabData> gjx;
    private CustomMessageListener gjy;
    private int gjz;
    private BdUniqueId mBdUniqueId;
    private Context mContext;
    private h mData;
    private String mForumId;
    private String mForumName;
    private View mRootView;
    private View mStatusBarView;
    private boolean gjB = true;
    private int mCurState = 1;
    private boolean gjC = false;
    private Handler mHandler = new Handler();
    private Runnable gjE = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.1
        @Override // java.lang.Runnable
        public void run() {
            if (SpecialLiveFragment.this.gjv != null) {
                SpecialLiveFragment.this.gjv.bNy();
            }
        }
    };
    private CustomMessageListener esj = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            SpecialLiveFragment.this.mHandler.removeCallbacks(SpecialLiveFragment.this.gjE);
            SpecialLiveFragment.this.mHandler.postDelayed(SpecialLiveFragment.this.gjE, 500L);
        }
    };
    private CustomMessageListener gjF = new CustomMessageListener(CmdConfigCustom.CMD_FORCE_REFRESH) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2) {
                    if ("FrsLiveLive".equals(split[0])) {
                        SpecialLiveFragment.this.lF(false);
                    }
                    SpecialForumTabBaseFragment tR = SpecialLiveFragment.this.gju.tR(SpecialLiveFragment.this.eFw.getCurrentItem());
                    if (tR != null) {
                        tR.bNv();
                    }
                }
            }
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && SpecialLiveFragment.this.gjw != null && !TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                SpecialLiveFragment.this.lF(false);
            }
        }
    };
    private final CustomMessageListener gjG = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            v vVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof v) && (vVar = (v) customResponsedMessage.getData()) != null && SpecialLiveFragment.this.mForumId.equals(vVar.getFid())) {
                if (vVar.isLike() == 1) {
                    if (SpecialLiveFragment.this.bNl()) {
                        SpecialLiveFragment.this.mCurState = 3;
                    } else {
                        SpecialLiveFragment.this.mCurState = 2;
                    }
                } else {
                    SpecialLiveFragment.this.mCurState = 1;
                }
                SpecialLiveFragment.this.lG(false);
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
                SpecialLiveFragment.this.lG(false);
                l.showToast(SpecialLiveFragment.this.getPageContext().getPageActivity(), SpecialLiveFragment.this.mContext.getString(R.string.special_sign_success_tip, Integer.valueOf(signData.sign_bonus_point)));
            }
        }
    };
    private final CustomMessageListener gjH = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_SPECIAL_CONCERN_TAB_TAB_ICON) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                Boolean bool = (Boolean) customResponsedMessage.getData();
                if (!y.isEmpty(SpecialLiveFragment.this.gjx)) {
                    ((TabData) SpecialLiveFragment.this.gjx.get(0)).extra = bool;
                    SpecialLiveFragment.this.ghd.setData(SpecialLiveFragment.this.gjx);
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
                this.gjA = sb.toString();
            } else {
                this.mForumName = this.mContext.getResources().getString(R.string.ala_ufan_bar_title);
                this.gjA = this.mForumName + string2;
            }
            bNj();
            bNh();
            bNi();
            MessageManager.getInstance().registerListener(this.gjy);
            MessageManager.getInstance().registerListener(this.gjG);
            MessageManager.getInstance().registerListener(this.mSignChangedListener);
            MessageManager.getInstance().registerListener(this.gjH);
            MessageManager.getInstance().registerListener(this.gjF);
            MessageManager.getInstance().registerListener(this.mAccountChangedListener);
            MessageManager.getInstance().registerListener(this.esj);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(R.layout.special_live_layout, (ViewGroup) null);
        this.Yh = (AppBarLayout) this.mRootView.findViewById(R.id.special_app_bar_layout);
        this.gjh = (CollapsingToolbarLayout) this.mRootView.findViewById(R.id.special_collapse_layout);
        this.mStatusBarView = this.mRootView.findViewById(R.id.statusbar_view);
        this.gjj = (ObservedChangeFrameLayout) this.mRootView.findViewById(R.id.live_container);
        this.mBdUniqueId = BdUniqueId.gen();
        this.gjk = (RelativeLayout) this.mRootView.findViewById(R.id.function_container);
        this.gjl = this.mRootView.findViewById(R.id.function_bottom_space);
        this.gjm = (TextView) this.mRootView.findViewById(R.id.function_title);
        this.gjm.setText(this.gjA);
        this.gjn = (TextView) this.mRootView.findViewById(R.id.function_btn);
        this.gjn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.19
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
                    SpecialLiveFragment.this.gjn.setClickable(false);
                    SpecialLiveFragment.this.eTL.gp(SpecialLiveFragment.this.mForumName, SpecialLiveFragment.this.mForumId);
                    TiebaStatic.log(new aq("c12890"));
                } else if (SpecialLiveFragment.this.mCurState == 2) {
                    SpecialLiveFragment.this.gjn.setClickable(false);
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
        this.gjo = (TextView) this.mRootView.findViewById(R.id.function_level_desc);
        this.gjp = (RelativeLayout) this.mRootView.findViewById(R.id.navigation_layout);
        this.gjr = this.mRootView.findViewById(R.id.navigation_top_space);
        this.gjq = this.mRootView.findViewById(R.id.navigation_bg);
        this.gjs = (TextView) this.mRootView.findViewById(R.id.navigation_title);
        this.gjs.setText(this.gjA);
        this.gjt = (ImageView) this.mRootView.findViewById(R.id.navigation_back_img);
        this.gjt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, SpecialLiveFragment.this.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        });
        this.ghd = (ScrollHorizontalTabView) this.mRootView.findViewById(R.id.scroll_tab_view);
        this.eFw = (CustomViewPager) this.mRootView.findViewById(R.id.special_view_pager);
        initViewPager();
        this.ghd.setViewPager(this.eFw);
        this.ghd.setScrollTabPageListener(new ScrollHorizontalTabView.ScrollTabPageListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.2
            @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
            public boolean onPrePageSelect(int i, TabData tabData) {
                return true;
            }

            @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
            public void onPageSelected(int i, TabData tabData) {
                if (i != 0 || TbadkCoreApplication.isLogin()) {
                    if (SpecialLiveFragment.this.gju != null) {
                        SpecialLiveFragment.this.gju.a(i, tabData);
                        return;
                    }
                    return;
                }
                bg.skipToLoginActivity(SpecialLiveFragment.this.getPageContext().getPageActivity());
                if (SpecialLiveFragment.this.eFw != null) {
                    SpecialLiveFragment.this.eFw.setCurrentItem(1);
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
                    SpecialLiveFragment.this.gjq.setVisibility(8);
                    SpecialLiveFragment.this.gjs.setVisibility(8);
                } else {
                    SpecialLiveFragment.this.gjq.setVisibility(0);
                    SpecialLiveFragment.this.gjs.setVisibility(0);
                }
                SpecialLiveFragment.this.lH(((float) abs) > SpecialLiveFragment.this.gjg / 2.0f);
                float abs2 = Math.abs(abs / SpecialLiveFragment.this.gjg);
                SpecialLiveFragment.this.gjq.setAlpha(abs2);
                SpecialLiveFragment.this.gjs.setAlpha(abs2);
                SpecialLiveFragment.this.g(abs, abs2);
            }
        });
        this.gji = this.mRootView.findViewById(R.id.square_main_top_divider_line);
        this.gjj.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.4
            @Override // com.baidu.tbadk.widget.layout.e
            public void d(View view, int i, int i2, int i3, int i4) {
                SpecialLiveFragment.this.gjg = (SpecialLiveFragment.this.gjj.getMeasuredHeight() + SpecialLiveFragment.this.gjk.getMeasuredHeight()) - SpecialLiveFragment.this.gjp.getMeasuredHeight();
                SpecialLiveFragment.this.gjh.setMinimumHeight(SpecialLiveFragment.this.gjp.getMeasuredHeight());
            }
        });
        QR();
        this.gjx = new ArrayList();
        this.fgG = new ArrayList();
        this.gjv = new e(getPageContext());
        this.gjw = new com.baidu.tieba.ala.alasquare.special_forum.model.a(getPageContext(), new a.InterfaceC0621a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.5
            @Override // com.baidu.tieba.ala.alasquare.special_forum.model.a.InterfaceC0621a
            public void b(h hVar) {
                SpecialLiveFragment.this.hideLoadingView(SpecialLiveFragment.this.mRootView);
                SpecialLiveFragment.this.a(hVar);
            }

            @Override // com.baidu.tieba.ala.alasquare.special_forum.model.a.InterfaceC0621a
            public void t(int i, String str) {
                SpecialLiveFragment.this.aP(i, str);
            }
        });
        lG(true);
        lF(true);
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
    public void lF(boolean z) {
        if (!this.gjw.isLoading()) {
            if (z) {
                showLoadingView(this.mRootView);
            }
            this.gjw.loadData();
        }
    }

    private void bNh() {
        this.gdK = new AlaLiveUserNotifyController(getPageContext());
        this.gdL = new AlaLiveUserNotifyManager.AlaLiveNotifyListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.7
            @Override // com.baidu.ala.notify.AlaLiveUserNotifyManager.AlaLiveNotifyListener
            public void onCallBack() {
                if (SpecialLiveFragment.this.isPrimary()) {
                    SpecialLiveFragment.this.gdK.showNextNotifyDialog(0, AlaLiveUserNotifyManager.getInstance().getNotifyDataList());
                }
            }
        };
        AlaLiveUserNotifyManager.getInstance().addNotifyListener(this.gdL);
    }

    private void bNi() {
        this.gjy = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_MODEL_TASK) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z;
                SignData signData = null;
                SpecialLiveFragment.this.gjn.setClickable(true);
                if (customResponsedMessage != null && customResponsedMessage.getOrginalMessage().getTag() == SpecialLiveFragment.this.mBdUniqueId) {
                    SignMessage signMessage = (SignMessage) customResponsedMessage;
                    if (AntiHelper.bN(signMessage.mSignErrorCode, signMessage.mSignErrorString) && signMessage.signData != null) {
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
                        if (AntiHelper.bN(signMessage.mSignErrorCode, signMessage.mSignErrorString)) {
                            AntiHelper.bm(SpecialLiveFragment.this.mContext, signMessage.mSignErrorString);
                            return;
                        } else {
                            l.showToast(SpecialLiveFragment.this.mContext, SpecialLiveFragment.this.mContext.getString(R.string.special_sign_success_tip, Integer.valueOf(signData.sign_bonus_point)));
                            return;
                        }
                    }
                    if (signMessage.mSignErrorCode == 160002) {
                        SpecialLiveFragment.this.mCurState = 3;
                        SpecialLiveFragment.this.lG(false);
                    }
                    l.showToast(SpecialLiveFragment.this.mContext, signMessage.mSignErrorString);
                }
            }
        };
    }

    private void bNj() {
        this.eTL = new LikeModel(getPageContext());
        this.eTL.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.9
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                SpecialLiveFragment.this.gjn.setClickable(true);
                if (SpecialLiveFragment.this.eTL.getErrorCode() == 22) {
                    l.showToast(SpecialLiveFragment.this.mContext, R.string.had_liked_forum);
                } else if (AntiHelper.bN(SpecialLiveFragment.this.eTL.getErrorCode(), SpecialLiveFragment.this.eTL.getErrorString())) {
                    AntiHelper.bm(SpecialLiveFragment.this.mContext, SpecialLiveFragment.this.eTL.getErrorString());
                } else if (SpecialLiveFragment.this.eTL.getErrorCode() != 0) {
                    l.showToast(SpecialLiveFragment.this.mContext, SpecialLiveFragment.this.eTL.getErrorString());
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
        bNm();
        bNk();
        if (!this.gjC) {
            bNn();
            if (this.eFw != null && this.eFw.getChildCount() > 1) {
                this.eFw.setCurrentItem(1);
            }
            if (!y.isEmpty(this.mData.tabInfoList)) {
                this.gjC = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aP(int i, String str) {
        if (TextUtils.isEmpty(str)) {
            showNetRefreshView(this.mRootView, this.mContext.getResources().getString(R.string.square_load_data_failed_tip), false);
        } else {
            showNetRefreshView(this.mRootView, str, false);
        }
    }

    private void bNk() {
        if (this.mData.gkd) {
            if (bNl()) {
                this.mCurState = 3;
            } else {
                this.mCurState = 2;
            }
        } else {
            this.mCurState = 1;
        }
        lG(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bNl() {
        return this.mData.gkf.gkl;
    }

    private void bNm() {
        boolean c = this.gjv.c(this.mData.gkb);
        if (c) {
            this.gjv.stopPlay();
            this.gjv.onDestroy();
        }
        this.gjv.a(this.mData.gkb, c);
        if (c) {
            this.gjv.ab(this.gjj);
        }
        this.gjv.startPlay();
    }

    private void bNn() {
        bNo();
        this.ghd.setData(this.gjx);
        this.gju.setData(this.fgG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(int i, float f) {
        if (this.gjv != null && f != 0.0f) {
            if (this.gjz <= i) {
                if (this.gjB && f >= 0.3f) {
                    this.gjv.ls(true);
                    this.gjv.pause();
                    this.gjB = false;
                }
            } else if (!this.gjB && f <= 0.3f) {
                this.gjv.ls(false);
                this.gjv.resume();
                this.gjB = true;
            }
            this.gjz = i;
        }
    }

    private void QR() {
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds88);
        if (UtilHelper.canUseStyleImmersiveSticky() && this.mStatusBarView.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.mStatusBarView.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.mStatusBarView.setLayoutParams(layoutParams);
            this.mStatusBarView.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gjr.getLayoutParams();
            layoutParams2.height = layoutParams.height;
            this.gjr.setLayoutParams(layoutParams2);
            dimensionPixelSize = layoutParams.height + dimensionPixelSize;
        } else {
            this.mStatusBarView.setVisibility(8);
        }
        CollapsingToolbarLayout.LayoutParams layoutParams3 = (CollapsingToolbarLayout.LayoutParams) this.gjp.getLayoutParams();
        layoutParams3.height = dimensionPixelSize;
        this.gjp.setLayoutParams(layoutParams3);
    }

    private void bNo() {
        this.gjx.clear();
        this.fgG.clear();
        this.gjx.add(bNr());
        this.gjx.add(bNs());
        this.fgG.add(bNp());
        this.fgG.add(bNq());
        if (!y.isEmpty(this.mData.tabInfoList)) {
            boolean z = b.bnH().getInt("chushou_game_tab", 1) == 1;
            for (int i = 0; i < this.mData.tabInfoList.size() && i < 10; i++) {
                SpecialLiveTabInfo specialLiveTabInfo = this.mData.tabInfoList.get(i);
                if (specialLiveTabInfo != null && (specialLiveTabInfo.tabId != 1108 || z)) {
                    this.fgG.add(specialLiveTabInfo);
                    TabData tabData = new TabData();
                    tabData.tabId = specialLiveTabInfo.tabId;
                    tabData.tabName = specialLiveTabInfo.tabName;
                    tabData.tabType = specialLiveTabInfo.tabType;
                    this.gjx.add(tabData);
                }
            }
        }
    }

    private SpecialLiveTabInfo bNp() {
        SpecialLiveTabInfo specialLiveTabInfo = new SpecialLiveTabInfo();
        specialLiveTabInfo.tabId = -901;
        specialLiveTabInfo.tabName = this.mContext.getResources().getString(R.string.special_concern_tab_title);
        return specialLiveTabInfo;
    }

    private SpecialLiveTabInfo bNq() {
        SpecialLiveTabInfo specialLiveTabInfo = new SpecialLiveTabInfo();
        specialLiveTabInfo.tabId = -903;
        specialLiveTabInfo.tabName = this.mContext.getResources().getString(R.string.special_recommend_tab_title);
        return specialLiveTabInfo;
    }

    private TabData bNr() {
        TabData tabData = new TabData();
        tabData.tabId = -901;
        tabData.tabName = this.mContext.getResources().getString(R.string.special_concern_tab_title);
        return tabData;
    }

    private TabData bNs() {
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
                lF(false);
                AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
            }
            if (this.gjv != null) {
                if (isPrimary()) {
                    this.gjv.ls(false);
                    this.gjv.startPlay();
                    return;
                }
                this.gjv.ls(true);
                this.gjv.pause();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        hideNetRefreshView(this.mRootView);
        lF(true);
        AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.gjv != null) {
            this.gjv.ls(true);
            this.gjv.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gjv != null) {
            this.gjv.onChangeSkinType(i);
        }
        if (this.ghd != null) {
            ap.setBackgroundResource(this.ghd, R.color.cp_bg_line_d);
            this.ghd.onChangeSkinType(i);
        }
        if (this.gju != null) {
            this.gju.onChangeSkinType(i);
        }
        lH(false);
        ap.setBackgroundColor(this.mStatusBarView, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.gjq, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.gjs, R.color.cp_cont_b);
        ap.setBackgroundColor(this.gjk, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.gjl, R.color.cp_bg_line_e);
        ap.setViewTextColor(this.gjm, R.color.cp_cont_b);
        ap.setViewTextColor(this.gjo, R.color.cp_cont_j);
        ap.setViewTextColor(this.gjn, R.color.cp_cont_g);
        ap.setBackgroundResource(this.gjn, R.drawable.frs_attention_btn_bg_selector);
        ap.setBackgroundResource(this.gji, R.color.cp_bg_line_c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lG(boolean z) {
        Drawable drawable;
        ap.setBackgroundResource(this.gjn, R.drawable.frs_attention_btn_bg_selector);
        int dimens = l.getDimens(this.mContext, R.dimen.ds10);
        String string = this.mContext.getResources().getString(R.string.attention);
        int i = R.drawable.frs_attention_btn_bg_selector;
        int i2 = R.color.cp_cont_a;
        if (this.mCurState == 1) {
            drawable = ap.getDrawable(R.drawable.icon_add_follow_blue_s);
            this.gjn.setClickable(true);
            if (!z) {
                TiebaStatic.log(new aq("c12889"));
            }
        } else if (this.mCurState == 2) {
            string = this.mContext.getResources().getString(R.string.sign);
            drawable = ap.getDrawable(R.drawable.icon_public_sign_blue_s);
            this.gjn.setClickable(true);
            if (!z) {
                TiebaStatic.log(new aq("c12891"));
            }
        } else if (this.mCurState == 3) {
            string = this.mContext.getResources().getString(R.string.signed);
            this.gjn.setClickable(false);
            i = R.drawable.special_sign_btn_signed_bg;
            i2 = R.color.cp_cont_d;
            drawable = null;
        } else {
            drawable = null;
        }
        ap.setBackgroundResource(this.gjn, i);
        ap.setViewTextColor(this.gjn, i2);
        this.gjn.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.gjn.setCompoundDrawablePadding(dimens);
        this.gjn.setText(string);
        bNt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lH(boolean z) {
        if (this.gjt != null) {
            if (z) {
                ap.setNavbarIconSrc(this.gjt, R.drawable.selector_topbar_return_black, R.drawable.selector_topbar_return_black, TbadkCoreApplication.getInst().getSkinType());
            } else {
                ap.setNavbarIconSrc(this.gjt, R.drawable.selector_topbar_return_white, R.drawable.selector_topbar_return_white, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    private void bNt() {
        if (this.mData != null && this.mData.gke != null && this.mCurState != 1) {
            int i = this.mData.gke.level_id;
            String str = TextUtils.isEmpty(this.mData.gke.level_name) ? "" : " " + this.mData.gke.level_name;
            if (i >= 0) {
                this.gjo.setText("LV" + i + str);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.gjv != null) {
            this.gjv.onDestroy();
        }
        if (this.gjG != null) {
            MessageManager.getInstance().unRegisterListener(this.gjG);
        }
        if (this.gjy != null) {
            MessageManager.getInstance().unRegisterListener(this.gjy);
        }
        if (this.mSignChangedListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mSignChangedListener);
        }
        if (this.gjH != null) {
            MessageManager.getInstance().unRegisterListener(this.gjH);
        }
        if (this.gjF != null) {
            MessageManager.getInstance().unRegisterListener(this.gjF);
        }
        if (this.mAccountChangedListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mAccountChangedListener);
        }
        if (this.gjw != null) {
            this.gjw.onDestroy();
        }
        if (this.gdK != null) {
            this.gdK.onDestroy();
        }
        AlaLiveUserNotifyManager.getInstance().removeNotifyListener(this.gdL);
        hideLoadingView(this.mRootView);
        MessageManager.getInstance().unRegisterListener(this.esj);
    }

    private void initViewPager() {
        this.gju = new a(getChildFragmentManager());
        this.eFw.setAdapter(this.gju);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends FragmentPagerAdapter {
        private SparseArray<SpecialForumTabBaseFragment> gjK;
        private List<SpecialLiveTabInfo> mData;

        public a(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.mData = new ArrayList();
            this.gjK = new SparseArray<>();
            this.gjK.put(0, ConcernTabFragment.tT(0));
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
            SpecialForumTabBaseFragment tR = tR(i);
            if (tR == null) {
                if (i == 0) {
                    tR = ConcernTabFragment.tT(0);
                } else if (i == 1) {
                    tR = RecommendTabFragment.tU(1);
                } else if (i < this.mData.size() && this.mData.get(i) != null && this.mData.get(i).tabId == 1108) {
                    tR = GameTabFragment.Gl(this.mData.get(i).tabName);
                } else {
                    tR = OtherSubTabFragment.a(i, this.mData.get(i));
                }
                this.gjK.put(i, tR);
            }
            return tR;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.mData.size();
        }

        public SpecialForumTabBaseFragment tR(int i) {
            return this.gjK.get(i);
        }

        public void a(int i, TabData tabData) {
            if (this.gjK.get(i) != null) {
                this.gjK.get(i).setPrimary(true);
            }
        }

        public void onChangeSkinType(int i) {
            if (this.gjK != null && this.gjK.size() > 0) {
                int size = this.gjK.size();
                for (int i2 = 0; i2 < size; i2++) {
                    SpecialForumTabBaseFragment specialForumTabBaseFragment = this.gjK.get(i2);
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
            if (this.gjD != null) {
                this.gjD.dismiss();
            }
            final Handler handler = new Handler();
            final Runnable runnable = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.10
                @Override // java.lang.Runnable
                public void run() {
                    if (SpecialLiveFragment.this.gjD != null) {
                        SpecialLiveFragment.this.gjD.dismiss();
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
                    SpecialLiveFragment.this.gjD = null;
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
                            SpecialLiveFragment.this.gjD.dismiss();
                        }
                    });
                    ap.setViewTextColor(textView, R.color.cp_cont_i);
                    bubbleLayout.KS(ap.getColor(R.color.cp_link_tip_a_alpha95));
                    bubbleLayout.aP(activity.getResources().getDimensionPixelSize(R.dimen.ds216));
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
            this.gjD = dVar.mi();
            this.gjD.show(activity);
            handler.postDelayed(runnable, 5000L);
        }
    }
}
