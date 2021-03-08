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
/* loaded from: classes9.dex */
public class SpecialLiveFragment extends BaseFragment {
    private AppBarLayout abf;
    private List<SpecialLiveTabInfo> fBX;
    private CustomViewPager faC;
    private LikeModel foW;
    private AlaLiveUserNotifyController gCr;
    private AlaLiveUserNotifyManager.AlaLiveNotifyListener gCs;
    private ScrollHorizontalTabView gFJ;
    private float gHQ;
    private CollapsingToolbarLayout gHR;
    private View gHS;
    private ObservedChangeFrameLayout gHT;
    private RelativeLayout gHU;
    private View gHV;
    private TextView gHW;
    private TextView gHX;
    private TextView gHY;
    private RelativeLayout gHZ;
    private View gIa;
    private View gIb;
    private TextView gIc;
    private ImageView gId;
    private a gIe;
    private e gIf;
    private com.baidu.tieba.ala.alasquare.special_forum.model.a gIg;
    private List<TabData> gIh;
    private CustomMessageListener gIi;
    private int gIj;
    private String gIk;
    private c gIn;
    private BdUniqueId mBdUniqueId;
    private Context mContext;
    private h mData;
    private String mForumId;
    private String mForumName;
    private View mRootView;
    private View mStatusBarView;
    private boolean gIl = true;
    private int mCurState = 1;
    private boolean gIm = false;
    private Handler mHandler = new Handler();
    private Runnable mRefreshRunnable = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.1
        @Override // java.lang.Runnable
        public void run() {
            if (SpecialLiveFragment.this.gIf != null) {
                SpecialLiveFragment.this.gIf.bSG();
            }
        }
    };
    private CustomMessageListener eMc = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            SpecialLiveFragment.this.mHandler.removeCallbacks(SpecialLiveFragment.this.mRefreshRunnable);
            SpecialLiveFragment.this.mHandler.postDelayed(SpecialLiveFragment.this.mRefreshRunnable, 500L);
        }
    };
    private CustomMessageListener gIo = new CustomMessageListener(CmdConfigCustom.CMD_FORCE_REFRESH) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2) {
                    if ("FrsLiveLive".equals(split[0])) {
                        SpecialLiveFragment.this.mH(false);
                    }
                    SpecialForumTabBaseFragment tQ = SpecialLiveFragment.this.gIe.tQ(SpecialLiveFragment.this.faC.getCurrentItem());
                    if (tQ != null) {
                        tQ.bSD();
                    }
                }
            }
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && SpecialLiveFragment.this.gIg != null && !TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                SpecialLiveFragment.this.mH(false);
            }
        }
    };
    private final CustomMessageListener gIp = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            w wVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof w) && (wVar = (w) customResponsedMessage.getData()) != null && SpecialLiveFragment.this.mForumId.equals(wVar.getFid())) {
                if (wVar.isLike() == 1) {
                    if (SpecialLiveFragment.this.bSt()) {
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
    private final CustomMessageListener gIq = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_SPECIAL_CONCERN_TAB_TAB_ICON) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                Boolean bool = (Boolean) customResponsedMessage.getData();
                if (!y.isEmpty(SpecialLiveFragment.this.gIh)) {
                    ((TabData) SpecialLiveFragment.this.gIh.get(0)).extra = bool;
                    SpecialLiveFragment.this.gFJ.setData(SpecialLiveFragment.this.gIh);
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
                this.gIk = sb.toString();
            } else {
                this.mForumName = this.mContext.getResources().getString(R.string.ala_ufan_bar_title);
                this.gIk = this.mForumName + string2;
            }
            bSr();
            bSp();
            bSq();
            MessageManager.getInstance().registerListener(this.gIi);
            MessageManager.getInstance().registerListener(this.gIp);
            MessageManager.getInstance().registerListener(this.mSignChangedListener);
            MessageManager.getInstance().registerListener(this.gIq);
            MessageManager.getInstance().registerListener(this.gIo);
            MessageManager.getInstance().registerListener(this.mAccountChangedListener);
            MessageManager.getInstance().registerListener(this.eMc);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(R.layout.special_live_layout, (ViewGroup) null);
        this.abf = (AppBarLayout) this.mRootView.findViewById(R.id.special_app_bar_layout);
        this.gHR = (CollapsingToolbarLayout) this.mRootView.findViewById(R.id.special_collapse_layout);
        this.mStatusBarView = this.mRootView.findViewById(R.id.statusbar_view);
        this.gHT = (ObservedChangeFrameLayout) this.mRootView.findViewById(R.id.live_container);
        this.mBdUniqueId = BdUniqueId.gen();
        this.gHU = (RelativeLayout) this.mRootView.findViewById(R.id.function_container);
        this.gHV = this.mRootView.findViewById(R.id.function_bottom_space);
        this.gHW = (TextView) this.mRootView.findViewById(R.id.function_title);
        this.gHW.setText(this.gIk);
        this.gHX = (TextView) this.mRootView.findViewById(R.id.function_btn);
        this.gHX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.19
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
                    SpecialLiveFragment.this.gHX.setClickable(false);
                    SpecialLiveFragment.this.foW.gy(SpecialLiveFragment.this.mForumName, SpecialLiveFragment.this.mForumId);
                    TiebaStatic.log(new ar("c12890"));
                } else if (SpecialLiveFragment.this.mCurState == 2) {
                    SpecialLiveFragment.this.gHX.setClickable(false);
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
        this.gHY = (TextView) this.mRootView.findViewById(R.id.function_level_desc);
        this.gHZ = (RelativeLayout) this.mRootView.findViewById(R.id.navigation_layout);
        this.gIb = this.mRootView.findViewById(R.id.navigation_top_space);
        this.gIa = this.mRootView.findViewById(R.id.navigation_bg);
        this.gIc = (TextView) this.mRootView.findViewById(R.id.navigation_title);
        this.gIc.setText(this.gIk);
        this.gId = (ImageView) this.mRootView.findViewById(R.id.navigation_back_img);
        this.gId.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, SpecialLiveFragment.this.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        });
        this.gFJ = (ScrollHorizontalTabView) this.mRootView.findViewById(R.id.scroll_tab_view);
        this.faC = (CustomViewPager) this.mRootView.findViewById(R.id.special_view_pager);
        initViewPager();
        this.gFJ.setViewPager(this.faC);
        this.gFJ.setScrollTabPageListener(new ScrollHorizontalTabView.ScrollTabPageListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.2
            @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
            public boolean onPrePageSelect(int i, TabData tabData) {
                return true;
            }

            @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
            public void onPageSelected(int i, TabData tabData) {
                if (i != 0 || TbadkCoreApplication.isLogin()) {
                    if (SpecialLiveFragment.this.gIe != null) {
                        SpecialLiveFragment.this.gIe.a(i, tabData);
                        return;
                    }
                    return;
                }
                bh.skipToLoginActivity(SpecialLiveFragment.this.getPageContext().getPageActivity());
                if (SpecialLiveFragment.this.faC != null) {
                    SpecialLiveFragment.this.faC.setCurrentItem(1);
                }
            }

            @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
            public void onPageScrolled(int i, float f, int i2) {
            }
        });
        this.abf.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.3
            @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                int abs = Math.abs(i);
                if (abs == 0) {
                    SpecialLiveFragment.this.gIa.setVisibility(8);
                    SpecialLiveFragment.this.gIc.setVisibility(8);
                } else {
                    SpecialLiveFragment.this.gIa.setVisibility(0);
                    SpecialLiveFragment.this.gIc.setVisibility(0);
                }
                SpecialLiveFragment.this.mJ(((float) abs) > SpecialLiveFragment.this.gHQ / 2.0f);
                float abs2 = Math.abs(abs / SpecialLiveFragment.this.gHQ);
                SpecialLiveFragment.this.gIa.setAlpha(abs2);
                SpecialLiveFragment.this.gIc.setAlpha(abs2);
                SpecialLiveFragment.this.g(abs, abs2);
            }
        });
        this.gHS = this.mRootView.findViewById(R.id.square_main_top_divider_line);
        this.gHT.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.4
            @Override // com.baidu.tbadk.widget.layout.e
            public void f(View view, int i, int i2, int i3, int i4) {
                SpecialLiveFragment.this.gHQ = (SpecialLiveFragment.this.gHT.getMeasuredHeight() + SpecialLiveFragment.this.gHU.getMeasuredHeight()) - SpecialLiveFragment.this.gHZ.getMeasuredHeight();
                SpecialLiveFragment.this.gHR.setMinimumHeight(SpecialLiveFragment.this.gHZ.getMeasuredHeight());
            }
        });
        Uk();
        this.gIh = new ArrayList();
        this.fBX = new ArrayList();
        this.gIf = new e(getPageContext());
        this.gIg = new com.baidu.tieba.ala.alasquare.special_forum.model.a(getPageContext(), new a.InterfaceC0625a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.5
            @Override // com.baidu.tieba.ala.alasquare.special_forum.model.a.InterfaceC0625a
            public void b(h hVar) {
                SpecialLiveFragment.this.hideLoadingView(SpecialLiveFragment.this.mRootView);
                SpecialLiveFragment.this.a(hVar);
            }

            @Override // com.baidu.tieba.ala.alasquare.special_forum.model.a.InterfaceC0625a
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
        if (!this.gIg.isLoading()) {
            if (z) {
                showLoadingView(this.mRootView);
            }
            this.gIg.loadData();
        }
    }

    private void bSp() {
        this.gCr = new AlaLiveUserNotifyController(getPageContext());
        this.gCs = new AlaLiveUserNotifyManager.AlaLiveNotifyListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.7
            @Override // com.baidu.ala.notify.AlaLiveUserNotifyManager.AlaLiveNotifyListener
            public void onCallBack() {
                if (SpecialLiveFragment.this.isPrimary()) {
                    SpecialLiveFragment.this.gCr.showNextNotifyDialog(0, AlaLiveUserNotifyManager.getInstance().getNotifyDataList());
                }
            }
        };
        AlaLiveUserNotifyManager.getInstance().addNotifyListener(this.gCs);
    }

    private void bSq() {
        this.gIi = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_MODEL_TASK) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z;
                SignData signData = null;
                SpecialLiveFragment.this.gHX.setClickable(true);
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

    private void bSr() {
        this.foW = new LikeModel(getPageContext());
        this.foW.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.9
            @Override // com.baidu.adp.base.e
            public void callback(Object obj) {
                SpecialLiveFragment.this.gHX.setClickable(true);
                if (SpecialLiveFragment.this.foW.getErrorCode() == 22) {
                    l.showToast(SpecialLiveFragment.this.mContext, R.string.had_liked_forum);
                } else if (AntiHelper.bX(SpecialLiveFragment.this.foW.getErrorCode(), SpecialLiveFragment.this.foW.getErrorString())) {
                    AntiHelper.bq(SpecialLiveFragment.this.mContext, SpecialLiveFragment.this.foW.getErrorString());
                } else if (SpecialLiveFragment.this.foW.getErrorCode() != 0) {
                    l.showToast(SpecialLiveFragment.this.mContext, SpecialLiveFragment.this.foW.getErrorString());
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
        this.abf.setVisibility(0);
        this.mData = hVar;
        bSu();
        bSs();
        if (!this.gIm) {
            bSv();
            if (this.faC != null && this.faC.getChildCount() > 1) {
                this.faC.setCurrentItem(1);
            }
            if (!y.isEmpty(this.mData.tabInfoList)) {
                this.gIm = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZ(int i, String str) {
        hideLoadingView(this.mRootView);
        this.abf.setVisibility(8);
        if (TextUtils.isEmpty(str)) {
            showNetRefreshView(this.mRootView, this.mContext.getResources().getString(R.string.square_load_data_failed_tip), true);
        } else {
            showNetRefreshView(this.mRootView, str, true);
        }
    }

    private void bSs() {
        if (this.mData.gIM) {
            if (bSt()) {
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
    public boolean bSt() {
        return this.mData.gIO.gIU;
    }

    private void bSu() {
        boolean c = this.gIf.c(this.mData.gIK);
        if (c) {
            this.gIf.stopPlay();
            this.gIf.onDestroy();
        }
        this.gIf.a(this.mData.gIK, c);
        if (c) {
            this.gIf.aj(this.gHT);
        }
        this.gIf.startPlay();
    }

    private void bSv() {
        bSw();
        this.gFJ.setData(this.gIh);
        this.gIe.setData(this.fBX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(int i, float f) {
        if (this.gIf != null && f != 0.0f) {
            if (this.gIj <= i) {
                if (this.gIl && f >= 0.3f) {
                    this.gIf.mu(true);
                    this.gIf.pause();
                    this.gIl = false;
                }
            } else if (!this.gIl && f <= 0.3f) {
                this.gIf.mu(false);
                this.gIf.resume();
                this.gIl = true;
            }
            this.gIj = i;
        }
    }

    private void Uk() {
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds88);
        if (UtilHelper.canUseStyleImmersiveSticky() && this.mStatusBarView.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.mStatusBarView.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.mStatusBarView.setLayoutParams(layoutParams);
            this.mStatusBarView.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gIb.getLayoutParams();
            layoutParams2.height = layoutParams.height;
            this.gIb.setLayoutParams(layoutParams2);
            dimensionPixelSize = layoutParams.height + dimensionPixelSize;
        } else {
            this.mStatusBarView.setVisibility(8);
        }
        CollapsingToolbarLayout.LayoutParams layoutParams3 = (CollapsingToolbarLayout.LayoutParams) this.gHZ.getLayoutParams();
        layoutParams3.height = dimensionPixelSize;
        this.gHZ.setLayoutParams(layoutParams3);
    }

    private void bSw() {
        this.gIh.clear();
        this.fBX.clear();
        this.gIh.add(bSz());
        this.gIh.add(bSA());
        this.fBX.add(bSx());
        this.fBX.add(bSy());
        if (!y.isEmpty(this.mData.tabInfoList)) {
            boolean z = b.brR().getInt("chushou_game_tab", 1) == 1;
            for (int i = 0; i < this.mData.tabInfoList.size() && i < 10; i++) {
                SpecialLiveTabInfo specialLiveTabInfo = this.mData.tabInfoList.get(i);
                if (specialLiveTabInfo != null && (specialLiveTabInfo.tabId != 1108 || z)) {
                    this.fBX.add(specialLiveTabInfo);
                    TabData tabData = new TabData();
                    tabData.tabId = specialLiveTabInfo.tabId;
                    tabData.tabName = specialLiveTabInfo.tabName;
                    tabData.tabType = specialLiveTabInfo.tabType;
                    this.gIh.add(tabData);
                }
            }
        }
    }

    private SpecialLiveTabInfo bSx() {
        SpecialLiveTabInfo specialLiveTabInfo = new SpecialLiveTabInfo();
        specialLiveTabInfo.tabId = -901;
        specialLiveTabInfo.tabName = this.mContext.getResources().getString(R.string.special_concern_tab_title);
        return specialLiveTabInfo;
    }

    private SpecialLiveTabInfo bSy() {
        SpecialLiveTabInfo specialLiveTabInfo = new SpecialLiveTabInfo();
        specialLiveTabInfo.tabId = -903;
        specialLiveTabInfo.tabName = this.mContext.getResources().getString(R.string.special_recommend_tab_title);
        return specialLiveTabInfo;
    }

    private TabData bSz() {
        TabData tabData = new TabData();
        tabData.tabId = -901;
        tabData.tabName = this.mContext.getResources().getString(R.string.special_concern_tab_title);
        return tabData;
    }

    private TabData bSA() {
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
            if (this.gIf != null) {
                if (isPrimary()) {
                    this.gIf.mu(false);
                    this.gIf.startPlay();
                    return;
                }
                this.gIf.mu(true);
                this.gIf.pause();
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
        if (this.gIf != null) {
            this.gIf.mu(true);
            this.gIf.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gIf != null) {
            this.gIf.onChangeSkinType(i);
        }
        if (this.gFJ != null) {
            ap.setBackgroundResource(this.gFJ, R.color.CAM_X0201);
            this.gFJ.onChangeSkinType(i);
        }
        if (this.gIe != null) {
            this.gIe.onChangeSkinType(i);
        }
        mJ(false);
        ap.setBackgroundColor(this.mStatusBarView, R.color.CAM_X0201);
        ap.setBackgroundColor(this.gIa, R.color.CAM_X0201);
        ap.setViewTextColor(this.gIc, R.color.CAM_X0105);
        ap.setBackgroundColor(this.gHU, R.color.CAM_X0201);
        ap.setBackgroundColor(this.gHV, R.color.CAM_X0205);
        ap.setViewTextColor(this.gHW, R.color.CAM_X0105);
        ap.setViewTextColor(this.gHY, R.color.CAM_X0107);
        ap.setViewTextColor(this.gHX, R.color.CAM_X0111);
        ap.setBackgroundResource(this.gHX, R.drawable.frs_attention_btn_bg_selector);
        ap.setBackgroundResource(this.gHS, R.color.CAM_X0204);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mI(boolean z) {
        Drawable drawable;
        ap.setBackgroundResource(this.gHX, R.drawable.frs_attention_btn_bg_selector);
        int dimens = l.getDimens(this.mContext, R.dimen.ds10);
        String string = this.mContext.getResources().getString(R.string.attention);
        int i = R.drawable.frs_attention_btn_bg_selector;
        int i2 = R.color.CAM_X0101;
        if (this.mCurState == 1) {
            drawable = ap.getDrawable(R.drawable.icon_add_follow_blue_s);
            this.gHX.setClickable(true);
            if (!z) {
                TiebaStatic.log(new ar("c12889"));
            }
        } else if (this.mCurState == 2) {
            string = this.mContext.getResources().getString(R.string.sign);
            drawable = ap.getDrawable(R.drawable.icon_public_sign_blue_s);
            this.gHX.setClickable(true);
            if (!z) {
                TiebaStatic.log(new ar("c12891"));
            }
        } else if (this.mCurState == 3) {
            string = this.mContext.getResources().getString(R.string.signed);
            this.gHX.setClickable(false);
            i = R.drawable.special_sign_btn_signed_bg;
            i2 = R.color.CAM_X0109;
            drawable = null;
        } else {
            drawable = null;
        }
        ap.setBackgroundResource(this.gHX, i);
        ap.setViewTextColor(this.gHX, i2);
        this.gHX.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.gHX.setCompoundDrawablePadding(dimens);
        this.gHX.setText(string);
        bSB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mJ(boolean z) {
        if (this.gId != null) {
            if (z) {
                ap.setNavbarIconSrc(this.gId, R.drawable.selector_topbar_return_black, R.drawable.selector_topbar_return_black, TbadkCoreApplication.getInst().getSkinType());
            } else {
                ap.setNavbarIconSrc(this.gId, R.drawable.selector_topbar_return_white, R.drawable.selector_topbar_return_white, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    private void bSB() {
        if (this.mData != null && this.mData.gIN != null && this.mCurState != 1) {
            int i = this.mData.gIN.level_id;
            String str = TextUtils.isEmpty(this.mData.gIN.level_name) ? "" : " " + this.mData.gIN.level_name;
            if (i >= 0) {
                this.gHY.setText("LV" + i + str);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.gIf != null) {
            this.gIf.onDestroy();
        }
        if (this.gIp != null) {
            MessageManager.getInstance().unRegisterListener(this.gIp);
        }
        if (this.gIi != null) {
            MessageManager.getInstance().unRegisterListener(this.gIi);
        }
        if (this.mSignChangedListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mSignChangedListener);
        }
        if (this.gIq != null) {
            MessageManager.getInstance().unRegisterListener(this.gIq);
        }
        if (this.gIo != null) {
            MessageManager.getInstance().unRegisterListener(this.gIo);
        }
        if (this.mAccountChangedListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mAccountChangedListener);
        }
        if (this.gIg != null) {
            this.gIg.onDestroy();
        }
        if (this.gCr != null) {
            this.gCr.onDestroy();
        }
        AlaLiveUserNotifyManager.getInstance().removeNotifyListener(this.gCs);
        hideLoadingView(this.mRootView);
        MessageManager.getInstance().unRegisterListener(this.eMc);
    }

    private void initViewPager() {
        this.gIe = new a(getChildFragmentManager());
        this.faC.setAdapter(this.gIe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a extends FragmentPagerAdapter {
        private SparseArray<SpecialForumTabBaseFragment> gIt;
        private List<SpecialLiveTabInfo> mData;

        public a(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.mData = new ArrayList();
            this.gIt = new SparseArray<>();
            this.gIt.put(0, ConcernTabFragment.tS(0));
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
            SpecialForumTabBaseFragment tQ = tQ(i);
            if (tQ == null) {
                if (i == 0) {
                    tQ = ConcernTabFragment.tS(0);
                } else if (i == 1) {
                    tQ = RecommendTabFragment.tT(1);
                } else if (i < this.mData.size() && this.mData.get(i) != null && this.mData.get(i).tabId == 1108) {
                    tQ = GameTabFragment.Gi(this.mData.get(i).tabName);
                } else {
                    tQ = OtherSubTabFragment.a(i, this.mData.get(i));
                }
                this.gIt.put(i, tQ);
            }
            return tQ;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.mData.size();
        }

        public SpecialForumTabBaseFragment tQ(int i) {
            return this.gIt.get(i);
        }

        public void a(int i, TabData tabData) {
            if (this.gIt.get(i) != null) {
                this.gIt.get(i).setPrimary(true);
            }
        }

        public void onChangeSkinType(int i) {
            if (this.gIt != null && this.gIt.size() > 0) {
                int size = this.gIt.size();
                for (int i2 = 0; i2 < size; i2++) {
                    SpecialForumTabBaseFragment specialForumTabBaseFragment = this.gIt.get(i2);
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
            if (this.gIn != null) {
                this.gIn.dismiss();
            }
            final Handler handler = new Handler();
            final Runnable runnable = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.10
                @Override // java.lang.Runnable
                public void run() {
                    if (SpecialLiveFragment.this.gIn != null) {
                        SpecialLiveFragment.this.gIn.dismiss();
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
                    SpecialLiveFragment.this.gIn = null;
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
                            SpecialLiveFragment.this.gIn.dismiss();
                        }
                    });
                    ap.setViewTextColor(textView, R.color.CAM_X0112);
                    bubbleLayout.Lg(ap.getColor(R.color.cp_link_tip_a_alpha95));
                    bubbleLayout.bi(activity.getResources().getDimensionPixelSize(R.dimen.ds216));
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
            this.gIn = dVar.lF();
            this.gIn.show(activity);
            handler.postDelayed(runnable, 5000L);
        }
    }
}
