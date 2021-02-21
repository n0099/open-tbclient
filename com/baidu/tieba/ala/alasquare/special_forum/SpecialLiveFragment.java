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
import com.baidu.tieba.tbadkCore.w;
import com.baidu.tieba.view.bubbleView.BubbleLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class SpecialLiveFragment extends BaseFragment {
    private AppBarLayout ZM;
    private CustomViewPager eZd;
    private List<SpecialLiveTabInfo> fAy;
    private LikeModel fnw;
    private AlaLiveUserNotifyController gAI;
    private AlaLiveUserNotifyManager.AlaLiveNotifyListener gAJ;
    private ScrollHorizontalTabView gEa;
    private int gGA;
    private String gGB;
    private c gGE;
    private float gGh;
    private CollapsingToolbarLayout gGi;
    private View gGj;
    private ObservedChangeFrameLayout gGk;
    private RelativeLayout gGl;
    private View gGm;
    private TextView gGn;
    private TextView gGo;
    private TextView gGp;
    private RelativeLayout gGq;
    private View gGr;
    private View gGs;
    private TextView gGt;
    private ImageView gGu;
    private a gGv;
    private e gGw;
    private com.baidu.tieba.ala.alasquare.special_forum.model.a gGx;
    private List<TabData> gGy;
    private CustomMessageListener gGz;
    private BdUniqueId mBdUniqueId;
    private Context mContext;
    private h mData;
    private String mForumId;
    private String mForumName;
    private View mRootView;
    private View mStatusBarView;
    private boolean gGC = true;
    private int mCurState = 1;
    private boolean gGD = false;
    private Handler mHandler = new Handler();
    private Runnable mRefreshRunnable = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.1
        @Override // java.lang.Runnable
        public void run() {
            if (SpecialLiveFragment.this.gGw != null) {
                SpecialLiveFragment.this.gGw.bSA();
            }
        }
    };
    private CustomMessageListener eKB = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            SpecialLiveFragment.this.mHandler.removeCallbacks(SpecialLiveFragment.this.mRefreshRunnable);
            SpecialLiveFragment.this.mHandler.postDelayed(SpecialLiveFragment.this.mRefreshRunnable, 500L);
        }
    };
    private CustomMessageListener gGF = new CustomMessageListener(CmdConfigCustom.CMD_FORCE_REFRESH) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2) {
                    if ("FrsLiveLive".equals(split[0])) {
                        SpecialLiveFragment.this.mH(false);
                    }
                    SpecialForumTabBaseFragment tO = SpecialLiveFragment.this.gGv.tO(SpecialLiveFragment.this.eZd.getCurrentItem());
                    if (tO != null) {
                        tO.bSx();
                    }
                }
            }
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && SpecialLiveFragment.this.gGx != null && !TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                SpecialLiveFragment.this.mH(false);
            }
        }
    };
    private final CustomMessageListener gGG = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            w wVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof w) && (wVar = (w) customResponsedMessage.getData()) != null && SpecialLiveFragment.this.mForumId.equals(wVar.getFid())) {
                if (wVar.isLike() == 1) {
                    if (SpecialLiveFragment.this.bSn()) {
                        SpecialLiveFragment.this.mCurState = 3;
                    } else {
                        SpecialLiveFragment.this.mCurState = 2;
                    }
                } else {
                    SpecialLiveFragment.this.mCurState = 1;
                }
                SpecialLiveFragment.this.mI(false);
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
                SpecialLiveFragment.this.mI(false);
                l.showToast(SpecialLiveFragment.this.getPageContext().getPageActivity(), SpecialLiveFragment.this.mContext.getString(R.string.special_sign_success_tip, Integer.valueOf(signData.sign_bonus_point)));
            }
        }
    };
    private final CustomMessageListener gGH = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_SPECIAL_CONCERN_TAB_TAB_ICON) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                Boolean bool = (Boolean) customResponsedMessage.getData();
                if (!y.isEmpty(SpecialLiveFragment.this.gGy)) {
                    ((TabData) SpecialLiveFragment.this.gGy.get(0)).extra = bool;
                    SpecialLiveFragment.this.gEa.setData(SpecialLiveFragment.this.gGy);
                    if (bool.booleanValue()) {
                        TiebaStatic.log("c12898");
                    }
                }
            }
        }
    };

    public static SpecialLiveFragment en(String str, String str2) {
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
                this.gGB = sb.toString();
            } else {
                this.mForumName = this.mContext.getResources().getString(R.string.ala_ufan_bar_title);
                this.gGB = this.mForumName + string2;
            }
            bSl();
            bSj();
            bSk();
            MessageManager.getInstance().registerListener(this.gGz);
            MessageManager.getInstance().registerListener(this.gGG);
            MessageManager.getInstance().registerListener(this.mSignChangedListener);
            MessageManager.getInstance().registerListener(this.gGH);
            MessageManager.getInstance().registerListener(this.gGF);
            MessageManager.getInstance().registerListener(this.mAccountChangedListener);
            MessageManager.getInstance().registerListener(this.eKB);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(R.layout.special_live_layout, (ViewGroup) null);
        this.ZM = (AppBarLayout) this.mRootView.findViewById(R.id.special_app_bar_layout);
        this.gGi = (CollapsingToolbarLayout) this.mRootView.findViewById(R.id.special_collapse_layout);
        this.mStatusBarView = this.mRootView.findViewById(R.id.statusbar_view);
        this.gGk = (ObservedChangeFrameLayout) this.mRootView.findViewById(R.id.live_container);
        this.mBdUniqueId = BdUniqueId.gen();
        this.gGl = (RelativeLayout) this.mRootView.findViewById(R.id.function_container);
        this.gGm = this.mRootView.findViewById(R.id.function_bottom_space);
        this.gGn = (TextView) this.mRootView.findViewById(R.id.function_title);
        this.gGn.setText(this.gGB);
        this.gGo = (TextView) this.mRootView.findViewById(R.id.function_btn);
        this.gGo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.19
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
                    SpecialLiveFragment.this.gGo.setClickable(false);
                    SpecialLiveFragment.this.fnw.gy(SpecialLiveFragment.this.mForumName, SpecialLiveFragment.this.mForumId);
                    TiebaStatic.log(new ar("c12890"));
                } else if (SpecialLiveFragment.this.mCurState == 2) {
                    SpecialLiveFragment.this.gGo.setClickable(false);
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
        this.gGp = (TextView) this.mRootView.findViewById(R.id.function_level_desc);
        this.gGq = (RelativeLayout) this.mRootView.findViewById(R.id.navigation_layout);
        this.gGs = this.mRootView.findViewById(R.id.navigation_top_space);
        this.gGr = this.mRootView.findViewById(R.id.navigation_bg);
        this.gGt = (TextView) this.mRootView.findViewById(R.id.navigation_title);
        this.gGt.setText(this.gGB);
        this.gGu = (ImageView) this.mRootView.findViewById(R.id.navigation_back_img);
        this.gGu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, SpecialLiveFragment.this.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        });
        this.gEa = (ScrollHorizontalTabView) this.mRootView.findViewById(R.id.scroll_tab_view);
        this.eZd = (CustomViewPager) this.mRootView.findViewById(R.id.special_view_pager);
        initViewPager();
        this.gEa.setViewPager(this.eZd);
        this.gEa.setScrollTabPageListener(new ScrollHorizontalTabView.ScrollTabPageListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.2
            @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
            public boolean onPrePageSelect(int i, TabData tabData) {
                return true;
            }

            @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
            public void onPageSelected(int i, TabData tabData) {
                if (i != 0 || TbadkCoreApplication.isLogin()) {
                    if (SpecialLiveFragment.this.gGv != null) {
                        SpecialLiveFragment.this.gGv.a(i, tabData);
                        return;
                    }
                    return;
                }
                bh.skipToLoginActivity(SpecialLiveFragment.this.getPageContext().getPageActivity());
                if (SpecialLiveFragment.this.eZd != null) {
                    SpecialLiveFragment.this.eZd.setCurrentItem(1);
                }
            }

            @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
            public void onPageScrolled(int i, float f, int i2) {
            }
        });
        this.ZM.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.3
            @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                int abs = Math.abs(i);
                if (abs == 0) {
                    SpecialLiveFragment.this.gGr.setVisibility(8);
                    SpecialLiveFragment.this.gGt.setVisibility(8);
                } else {
                    SpecialLiveFragment.this.gGr.setVisibility(0);
                    SpecialLiveFragment.this.gGt.setVisibility(0);
                }
                SpecialLiveFragment.this.mJ(((float) abs) > SpecialLiveFragment.this.gGh / 2.0f);
                float abs2 = Math.abs(abs / SpecialLiveFragment.this.gGh);
                SpecialLiveFragment.this.gGr.setAlpha(abs2);
                SpecialLiveFragment.this.gGt.setAlpha(abs2);
                SpecialLiveFragment.this.g(abs, abs2);
            }
        });
        this.gGj = this.mRootView.findViewById(R.id.square_main_top_divider_line);
        this.gGk.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.4
            @Override // com.baidu.tbadk.widget.layout.e
            public void f(View view, int i, int i2, int i3, int i4) {
                SpecialLiveFragment.this.gGh = (SpecialLiveFragment.this.gGk.getMeasuredHeight() + SpecialLiveFragment.this.gGl.getMeasuredHeight()) - SpecialLiveFragment.this.gGq.getMeasuredHeight();
                SpecialLiveFragment.this.gGi.setMinimumHeight(SpecialLiveFragment.this.gGq.getMeasuredHeight());
            }
        });
        Uh();
        this.gGy = new ArrayList();
        this.fAy = new ArrayList();
        this.gGw = new e(getPageContext());
        this.gGx = new com.baidu.tieba.ala.alasquare.special_forum.model.a(getPageContext(), new a.InterfaceC0619a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.5
            @Override // com.baidu.tieba.ala.alasquare.special_forum.model.a.InterfaceC0619a
            public void b(h hVar) {
                SpecialLiveFragment.this.hideLoadingView(SpecialLiveFragment.this.mRootView);
                SpecialLiveFragment.this.a(hVar);
            }

            @Override // com.baidu.tieba.ala.alasquare.special_forum.model.a.InterfaceC0619a
            public void A(int i, String str) {
                SpecialLiveFragment.this.aZ(i, str);
            }
        });
        mI(true);
        mH(true);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
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
    public void mH(boolean z) {
        if (!this.gGx.isLoading()) {
            if (z) {
                showLoadingView(this.mRootView);
            }
            this.gGx.loadData();
        }
    }

    private void bSj() {
        this.gAI = new AlaLiveUserNotifyController(getPageContext());
        this.gAJ = new AlaLiveUserNotifyManager.AlaLiveNotifyListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.7
            @Override // com.baidu.ala.notify.AlaLiveUserNotifyManager.AlaLiveNotifyListener
            public void onCallBack() {
                if (SpecialLiveFragment.this.isPrimary()) {
                    SpecialLiveFragment.this.gAI.showNextNotifyDialog(0, AlaLiveUserNotifyManager.getInstance().getNotifyDataList());
                }
            }
        };
        AlaLiveUserNotifyManager.getInstance().addNotifyListener(this.gAJ);
    }

    private void bSk() {
        this.gGz = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_MODEL_TASK) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z;
                SignData signData = null;
                SpecialLiveFragment.this.gGo.setClickable(true);
                if (customResponsedMessage != null && customResponsedMessage.getOrginalMessage().getTag() == SpecialLiveFragment.this.mBdUniqueId) {
                    SignMessage signMessage = (SignMessage) customResponsedMessage;
                    if (AntiHelper.bX(signMessage.mSignErrorCode, signMessage.mSignErrorString) && signMessage.signData != null) {
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
                        if (AntiHelper.bX(signMessage.mSignErrorCode, signMessage.mSignErrorString)) {
                            AntiHelper.bq(SpecialLiveFragment.this.mContext, signMessage.mSignErrorString);
                            return;
                        } else {
                            l.showToast(SpecialLiveFragment.this.mContext, SpecialLiveFragment.this.mContext.getString(R.string.special_sign_success_tip, Integer.valueOf(signData.sign_bonus_point)));
                            return;
                        }
                    }
                    if (signMessage.mSignErrorCode == 160002) {
                        SpecialLiveFragment.this.mCurState = 3;
                        SpecialLiveFragment.this.mI(false);
                    }
                    l.showToast(SpecialLiveFragment.this.mContext, signMessage.mSignErrorString);
                }
            }
        };
    }

    private void bSl() {
        this.fnw = new LikeModel(getPageContext());
        this.fnw.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.9
            @Override // com.baidu.adp.base.e
            public void callback(Object obj) {
                SpecialLiveFragment.this.gGo.setClickable(true);
                if (SpecialLiveFragment.this.fnw.getErrorCode() == 22) {
                    l.showToast(SpecialLiveFragment.this.mContext, R.string.had_liked_forum);
                } else if (AntiHelper.bX(SpecialLiveFragment.this.fnw.getErrorCode(), SpecialLiveFragment.this.fnw.getErrorString())) {
                    AntiHelper.bq(SpecialLiveFragment.this.mContext, SpecialLiveFragment.this.fnw.getErrorString());
                } else if (SpecialLiveFragment.this.fnw.getErrorCode() != 0) {
                    l.showToast(SpecialLiveFragment.this.mContext, SpecialLiveFragment.this.fnw.getErrorString());
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
        this.ZM.setVisibility(0);
        this.mData = hVar;
        bSo();
        bSm();
        if (!this.gGD) {
            bSp();
            if (this.eZd != null && this.eZd.getChildCount() > 1) {
                this.eZd.setCurrentItem(1);
            }
            if (!y.isEmpty(this.mData.tabInfoList)) {
                this.gGD = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZ(int i, String str) {
        hideLoadingView(this.mRootView);
        this.ZM.setVisibility(8);
        if (TextUtils.isEmpty(str)) {
            showNetRefreshView(this.mRootView, this.mContext.getResources().getString(R.string.square_load_data_failed_tip), true);
        } else {
            showNetRefreshView(this.mRootView, str, true);
        }
    }

    private void bSm() {
        if (this.mData.gHd) {
            if (bSn()) {
                this.mCurState = 3;
            } else {
                this.mCurState = 2;
            }
        } else {
            this.mCurState = 1;
        }
        mI(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bSn() {
        return this.mData.gHf.gHl;
    }

    private void bSo() {
        boolean c = this.gGw.c(this.mData.gHb);
        if (c) {
            this.gGw.stopPlay();
            this.gGw.onDestroy();
        }
        this.gGw.a(this.mData.gHb, c);
        if (c) {
            this.gGw.aj(this.gGk);
        }
        this.gGw.startPlay();
    }

    private void bSp() {
        bSq();
        this.gEa.setData(this.gGy);
        this.gGv.setData(this.fAy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(int i, float f) {
        if (this.gGw != null && f != 0.0f) {
            if (this.gGA <= i) {
                if (this.gGC && f >= 0.3f) {
                    this.gGw.mu(true);
                    this.gGw.pause();
                    this.gGC = false;
                }
            } else if (!this.gGC && f <= 0.3f) {
                this.gGw.mu(false);
                this.gGw.resume();
                this.gGC = true;
            }
            this.gGA = i;
        }
    }

    private void Uh() {
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds88);
        if (UtilHelper.canUseStyleImmersiveSticky() && this.mStatusBarView.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.mStatusBarView.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.mStatusBarView.setLayoutParams(layoutParams);
            this.mStatusBarView.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gGs.getLayoutParams();
            layoutParams2.height = layoutParams.height;
            this.gGs.setLayoutParams(layoutParams2);
            dimensionPixelSize = layoutParams.height + dimensionPixelSize;
        } else {
            this.mStatusBarView.setVisibility(8);
        }
        CollapsingToolbarLayout.LayoutParams layoutParams3 = (CollapsingToolbarLayout.LayoutParams) this.gGq.getLayoutParams();
        layoutParams3.height = dimensionPixelSize;
        this.gGq.setLayoutParams(layoutParams3);
    }

    private void bSq() {
        this.gGy.clear();
        this.fAy.clear();
        this.gGy.add(bSt());
        this.gGy.add(bSu());
        this.fAy.add(bSr());
        this.fAy.add(bSs());
        if (!y.isEmpty(this.mData.tabInfoList)) {
            boolean z = b.brQ().getInt("chushou_game_tab", 1) == 1;
            for (int i = 0; i < this.mData.tabInfoList.size() && i < 10; i++) {
                SpecialLiveTabInfo specialLiveTabInfo = this.mData.tabInfoList.get(i);
                if (specialLiveTabInfo != null && (specialLiveTabInfo.tabId != 1108 || z)) {
                    this.fAy.add(specialLiveTabInfo);
                    TabData tabData = new TabData();
                    tabData.tabId = specialLiveTabInfo.tabId;
                    tabData.tabName = specialLiveTabInfo.tabName;
                    tabData.tabType = specialLiveTabInfo.tabType;
                    this.gGy.add(tabData);
                }
            }
        }
    }

    private SpecialLiveTabInfo bSr() {
        SpecialLiveTabInfo specialLiveTabInfo = new SpecialLiveTabInfo();
        specialLiveTabInfo.tabId = -901;
        specialLiveTabInfo.tabName = this.mContext.getResources().getString(R.string.special_concern_tab_title);
        return specialLiveTabInfo;
    }

    private SpecialLiveTabInfo bSs() {
        SpecialLiveTabInfo specialLiveTabInfo = new SpecialLiveTabInfo();
        specialLiveTabInfo.tabId = -903;
        specialLiveTabInfo.tabName = this.mContext.getResources().getString(R.string.special_recommend_tab_title);
        return specialLiveTabInfo;
    }

    private TabData bSt() {
        TabData tabData = new TabData();
        tabData.tabId = -901;
        tabData.tabName = this.mContext.getResources().getString(R.string.special_concern_tab_title);
        return tabData;
    }

    private TabData bSu() {
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
                mH(false);
                AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
            }
            if (this.gGw != null) {
                if (isPrimary()) {
                    this.gGw.mu(false);
                    this.gGw.startPlay();
                    return;
                }
                this.gGw.mu(true);
                this.gGw.pause();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        hideNetRefreshView(this.mRootView);
        mH(true);
        AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.gGw != null) {
            this.gGw.mu(true);
            this.gGw.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gGw != null) {
            this.gGw.onChangeSkinType(i);
        }
        if (this.gEa != null) {
            ap.setBackgroundResource(this.gEa, R.color.CAM_X0201);
            this.gEa.onChangeSkinType(i);
        }
        if (this.gGv != null) {
            this.gGv.onChangeSkinType(i);
        }
        mJ(false);
        ap.setBackgroundColor(this.mStatusBarView, R.color.CAM_X0201);
        ap.setBackgroundColor(this.gGr, R.color.CAM_X0201);
        ap.setViewTextColor(this.gGt, R.color.CAM_X0105);
        ap.setBackgroundColor(this.gGl, R.color.CAM_X0201);
        ap.setBackgroundColor(this.gGm, R.color.CAM_X0205);
        ap.setViewTextColor(this.gGn, R.color.CAM_X0105);
        ap.setViewTextColor(this.gGp, R.color.CAM_X0107);
        ap.setViewTextColor(this.gGo, R.color.CAM_X0111);
        ap.setBackgroundResource(this.gGo, R.drawable.frs_attention_btn_bg_selector);
        ap.setBackgroundResource(this.gGj, R.color.CAM_X0204);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mI(boolean z) {
        Drawable drawable;
        ap.setBackgroundResource(this.gGo, R.drawable.frs_attention_btn_bg_selector);
        int dimens = l.getDimens(this.mContext, R.dimen.ds10);
        String string = this.mContext.getResources().getString(R.string.attention);
        int i = R.drawable.frs_attention_btn_bg_selector;
        int i2 = R.color.CAM_X0101;
        if (this.mCurState == 1) {
            drawable = ap.getDrawable(R.drawable.icon_add_follow_blue_s);
            this.gGo.setClickable(true);
            if (!z) {
                TiebaStatic.log(new ar("c12889"));
            }
        } else if (this.mCurState == 2) {
            string = this.mContext.getResources().getString(R.string.sign);
            drawable = ap.getDrawable(R.drawable.icon_public_sign_blue_s);
            this.gGo.setClickable(true);
            if (!z) {
                TiebaStatic.log(new ar("c12891"));
            }
        } else if (this.mCurState == 3) {
            string = this.mContext.getResources().getString(R.string.signed);
            this.gGo.setClickable(false);
            i = R.drawable.special_sign_btn_signed_bg;
            i2 = R.color.CAM_X0109;
            drawable = null;
        } else {
            drawable = null;
        }
        ap.setBackgroundResource(this.gGo, i);
        ap.setViewTextColor(this.gGo, i2);
        this.gGo.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.gGo.setCompoundDrawablePadding(dimens);
        this.gGo.setText(string);
        bSv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mJ(boolean z) {
        if (this.gGu != null) {
            if (z) {
                ap.setNavbarIconSrc(this.gGu, R.drawable.selector_topbar_return_black, R.drawable.selector_topbar_return_black, TbadkCoreApplication.getInst().getSkinType());
            } else {
                ap.setNavbarIconSrc(this.gGu, R.drawable.selector_topbar_return_white, R.drawable.selector_topbar_return_white, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    private void bSv() {
        if (this.mData != null && this.mData.gHe != null && this.mCurState != 1) {
            int i = this.mData.gHe.level_id;
            String str = TextUtils.isEmpty(this.mData.gHe.level_name) ? "" : " " + this.mData.gHe.level_name;
            if (i >= 0) {
                this.gGp.setText("LV" + i + str);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.gGw != null) {
            this.gGw.onDestroy();
        }
        if (this.gGG != null) {
            MessageManager.getInstance().unRegisterListener(this.gGG);
        }
        if (this.gGz != null) {
            MessageManager.getInstance().unRegisterListener(this.gGz);
        }
        if (this.mSignChangedListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mSignChangedListener);
        }
        if (this.gGH != null) {
            MessageManager.getInstance().unRegisterListener(this.gGH);
        }
        if (this.gGF != null) {
            MessageManager.getInstance().unRegisterListener(this.gGF);
        }
        if (this.mAccountChangedListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mAccountChangedListener);
        }
        if (this.gGx != null) {
            this.gGx.onDestroy();
        }
        if (this.gAI != null) {
            this.gAI.onDestroy();
        }
        AlaLiveUserNotifyManager.getInstance().removeNotifyListener(this.gAJ);
        hideLoadingView(this.mRootView);
        MessageManager.getInstance().unRegisterListener(this.eKB);
    }

    private void initViewPager() {
        this.gGv = new a(getChildFragmentManager());
        this.eZd.setAdapter(this.gGv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a extends FragmentPagerAdapter {
        private SparseArray<SpecialForumTabBaseFragment> gGK;
        private List<SpecialLiveTabInfo> mData;

        public a(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.mData = new ArrayList();
            this.gGK = new SparseArray<>();
            this.gGK.put(0, ConcernTabFragment.tQ(0));
        }

        public void setData(List<SpecialLiveTabInfo> list) {
            if (!y.isEmpty(list)) {
                this.mData.clear();
                this.mData.addAll(list);
                notifyDataSetChanged();
            }
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            SpecialForumTabBaseFragment tO = tO(i);
            if (tO == null) {
                if (i == 0) {
                    tO = ConcernTabFragment.tQ(0);
                } else if (i == 1) {
                    tO = RecommendTabFragment.tR(1);
                } else if (i < this.mData.size() && this.mData.get(i) != null && this.mData.get(i).tabId == 1108) {
                    tO = GameTabFragment.FZ(this.mData.get(i).tabName);
                } else {
                    tO = OtherSubTabFragment.a(i, this.mData.get(i));
                }
                this.gGK.put(i, tO);
            }
            return tO;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.mData.size();
        }

        public SpecialForumTabBaseFragment tO(int i) {
            return this.gGK.get(i);
        }

        public void a(int i, TabData tabData) {
            if (this.gGK.get(i) != null) {
                this.gGK.get(i).setPrimary(true);
            }
        }

        public void onChangeSkinType(int i) {
            if (this.gGK != null && this.gGK.size() > 0) {
                int size = this.gGK.size();
                for (int i2 = 0; i2 < size; i2++) {
                    SpecialForumTabBaseFragment specialForumTabBaseFragment = this.gGK.get(i2);
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
            if (this.gGE != null) {
                this.gGE.dismiss();
            }
            final Handler handler = new Handler();
            final Runnable runnable = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.10
                @Override // java.lang.Runnable
                public void run() {
                    if (SpecialLiveFragment.this.gGE != null) {
                        SpecialLiveFragment.this.gGE.dismiss();
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
                    SpecialLiveFragment.this.gGE = null;
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
                            SpecialLiveFragment.this.gGE.dismiss();
                        }
                    });
                    ap.setViewTextColor(textView, R.color.CAM_X0112);
                    bubbleLayout.Lc(ap.getColor(R.color.cp_link_tip_a_alpha95));
                    bubbleLayout.be(activity.getResources().getDimensionPixelSize(R.dimen.ds216));
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
            this.gGE = dVar.lF();
            this.gGE.show(activity);
            handler.postDelayed(runnable, 5000L);
        }
    }
}
