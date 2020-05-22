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
    private AlaLiveUserNotifyController fcj;
    private AlaLiveUserNotifyManager.AlaLiveNotifyListener fck;
    private ScrollHorizontalTabView fft;
    private TextView fhA;
    private RelativeLayout fhB;
    private View fhC;
    private View fhD;
    private TextView fhE;
    private ImageView fhF;
    private a fhG;
    private e fhH;
    private com.baidu.tieba.ala.alasquare.special_forum.model.a fhI;
    private List<TabData> fhJ;
    private List<SpecialLiveTabInfo> fhK;
    private CustomMessageListener fhL;
    private int fhM;
    private String fhN;
    private c fhQ;
    private float fhs;
    private CollapsingToolbarLayout fht;
    private View fhu;
    private ObservedChangeFrameLayout fhv;
    private RelativeLayout fhw;
    private View fhx;
    private TextView fhy;
    private TextView fhz;
    private BdUniqueId mBdUniqueId;
    private Context mContext;
    private h mData;
    private String mForumId;
    private String mForumName;
    private View mRootView;
    private View mStatusBarView;
    private boolean fhO = true;
    private int mCurState = 1;
    private boolean fhP = false;
    private Handler mHandler = new Handler();
    private Runnable fhR = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.1
        @Override // java.lang.Runnable
        public void run() {
            if (SpecialLiveFragment.this.fhH != null) {
                SpecialLiveFragment.this.fhH.brO();
            }
        }
    };
    private CustomMessageListener dzH = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            SpecialLiveFragment.this.mHandler.removeCallbacks(SpecialLiveFragment.this.fhR);
            SpecialLiveFragment.this.mHandler.postDelayed(SpecialLiveFragment.this.fhR, 500L);
        }
    };
    private CustomMessageListener fhS = new CustomMessageListener(CmdConfigCustom.CMD_FORCE_REFRESH) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2) {
                    if ("FrsLiveLive".equals(split[0])) {
                        SpecialLiveFragment.this.jw(false);
                    }
                    SpecialForumTabBaseFragment pG = SpecialLiveFragment.this.fhG.pG(SpecialLiveFragment.this.dLI.getCurrentItem());
                    if (pG != null) {
                        pG.brJ();
                    }
                }
            }
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && SpecialLiveFragment.this.fhI != null && !TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                SpecialLiveFragment.this.jw(false);
            }
        }
    };
    private final CustomMessageListener fhT = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            u uVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof u) && (uVar = (u) customResponsedMessage.getData()) != null && SpecialLiveFragment.this.mForumId.equals(uVar.getFid())) {
                if (uVar.isLike() == 1) {
                    if (SpecialLiveFragment.this.brz()) {
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
    private final CustomMessageListener fhU = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_SPECIAL_CONCERN_TAB_TAB_ICON) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                Boolean bool = (Boolean) customResponsedMessage.getData();
                if (!v.isEmpty(SpecialLiveFragment.this.fhJ)) {
                    ((TabData) SpecialLiveFragment.this.fhJ.get(0)).extra = bool;
                    SpecialLiveFragment.this.fft.setData(SpecialLiveFragment.this.fhJ);
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
                this.fhN = sb.toString();
            } else {
                this.mForumName = this.mContext.getResources().getString(R.string.ala_ufan_bar_title);
                this.fhN = this.mForumName + string2;
            }
            brx();
            brv();
            brw();
            MessageManager.getInstance().registerListener(this.fhL);
            MessageManager.getInstance().registerListener(this.fhT);
            MessageManager.getInstance().registerListener(this.mSignChangedListener);
            MessageManager.getInstance().registerListener(this.fhU);
            MessageManager.getInstance().registerListener(this.fhS);
            MessageManager.getInstance().registerListener(this.mAccountChangedListener);
            MessageManager.getInstance().registerListener(this.dzH);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(R.layout.special_live_layout, (ViewGroup) null);
        this.Wr = (AppBarLayout) this.mRootView.findViewById(R.id.special_app_bar_layout);
        this.fht = (CollapsingToolbarLayout) this.mRootView.findViewById(R.id.special_collapse_layout);
        this.mStatusBarView = this.mRootView.findViewById(R.id.statusbar_view);
        this.fhv = (ObservedChangeFrameLayout) this.mRootView.findViewById(R.id.live_container);
        this.mBdUniqueId = BdUniqueId.gen();
        this.fhw = (RelativeLayout) this.mRootView.findViewById(R.id.function_container);
        this.fhx = this.mRootView.findViewById(R.id.function_bottom_space);
        this.fhy = (TextView) this.mRootView.findViewById(R.id.function_title);
        this.fhy.setText(this.fhN);
        this.fhz = (TextView) this.mRootView.findViewById(R.id.function_btn);
        this.fhz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.19
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
                    SpecialLiveFragment.this.fhz.setClickable(false);
                    SpecialLiveFragment.this.dYI.fq(SpecialLiveFragment.this.mForumName, SpecialLiveFragment.this.mForumId);
                    TiebaStatic.log(new an("c12890"));
                } else if (SpecialLiveFragment.this.mCurState == 2) {
                    SpecialLiveFragment.this.fhz.setClickable(false);
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
        this.fhA = (TextView) this.mRootView.findViewById(R.id.function_level_desc);
        this.fhB = (RelativeLayout) this.mRootView.findViewById(R.id.navigation_layout);
        this.fhD = this.mRootView.findViewById(R.id.navigation_top_space);
        this.fhC = this.mRootView.findViewById(R.id.navigation_bg);
        this.fhE = (TextView) this.mRootView.findViewById(R.id.navigation_title);
        this.fhE.setText(this.fhN);
        this.fhF = (ImageView) this.mRootView.findViewById(R.id.navigation_back_img);
        this.fhF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, SpecialLiveFragment.this.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        });
        this.fft = (ScrollHorizontalTabView) this.mRootView.findViewById(R.id.scroll_tab_view);
        this.dLI = (CustomViewPager) this.mRootView.findViewById(R.id.special_view_pager);
        initViewPager();
        this.fft.setViewPager(this.dLI);
        this.fft.setScrollTabPageListener(new ScrollHorizontalTabView.ScrollTabPageListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.2
            @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
            public boolean onPrePageSelect(int i, TabData tabData) {
                return true;
            }

            @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
            public void onPageSelected(int i, TabData tabData) {
                if (i != 0 || TbadkCoreApplication.isLogin()) {
                    if (SpecialLiveFragment.this.fhG != null) {
                        SpecialLiveFragment.this.fhG.a(i, tabData);
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
                    SpecialLiveFragment.this.fhC.setVisibility(8);
                    SpecialLiveFragment.this.fhE.setVisibility(8);
                } else {
                    SpecialLiveFragment.this.fhC.setVisibility(0);
                    SpecialLiveFragment.this.fhE.setVisibility(0);
                }
                SpecialLiveFragment.this.jy(((float) abs) > SpecialLiveFragment.this.fhs / 2.0f);
                float abs2 = Math.abs(abs / SpecialLiveFragment.this.fhs);
                SpecialLiveFragment.this.fhC.setAlpha(abs2);
                SpecialLiveFragment.this.fhE.setAlpha(abs2);
                SpecialLiveFragment.this.g(abs, abs2);
            }
        });
        this.fhu = this.mRootView.findViewById(R.id.square_main_top_divider_line);
        this.fhv.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.4
            @Override // com.baidu.tbadk.widget.layout.e
            public void d(View view, int i, int i2, int i3, int i4) {
                SpecialLiveFragment.this.fhs = (SpecialLiveFragment.this.fhv.getMeasuredHeight() + SpecialLiveFragment.this.fhw.getMeasuredHeight()) - SpecialLiveFragment.this.fhB.getMeasuredHeight();
                SpecialLiveFragment.this.fht.setMinimumHeight(SpecialLiveFragment.this.fhB.getMeasuredHeight());
            }
        });
        Hc();
        this.fhJ = new ArrayList();
        this.fhK = new ArrayList();
        this.fhH = new e(getPageContext());
        this.fhI = new com.baidu.tieba.ala.alasquare.special_forum.model.a(getPageContext(), new a.InterfaceC0527a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.5
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
        if (!this.fhI.isLoading()) {
            if (z) {
                showLoadingView(this.mRootView);
            }
            this.fhI.loadData();
        }
    }

    private void brv() {
        this.fcj = new AlaLiveUserNotifyController(getPageContext());
        this.fck = new AlaLiveUserNotifyManager.AlaLiveNotifyListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.7
            @Override // com.baidu.ala.notify.AlaLiveUserNotifyManager.AlaLiveNotifyListener
            public void onCallBack() {
                if (SpecialLiveFragment.this.isPrimary()) {
                    SpecialLiveFragment.this.fcj.showNextNotifyDialog(0, AlaLiveUserNotifyManager.getInstance().getNotifyDataList());
                }
            }
        };
        AlaLiveUserNotifyManager.getInstance().addNotifyListener(this.fck);
    }

    private void brw() {
        this.fhL = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_MODEL_TASK) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z;
                SignData signData = null;
                SpecialLiveFragment.this.fhz.setClickable(true);
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

    private void brx() {
        this.dYI = new LikeModel(getPageContext());
        this.dYI.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.9
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                SpecialLiveFragment.this.fhz.setClickable(true);
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
        brA();
        bry();
        if (!this.fhP) {
            brB();
            if (this.dLI != null && this.dLI.getChildCount() > 1) {
                this.dLI.setCurrentItem(1);
            }
            if (!v.isEmpty(this.mData.tabInfoList)) {
                this.fhP = true;
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

    private void bry() {
        if (this.mData.fir) {
            if (brz()) {
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
    public boolean brz() {
        return this.mData.fit.fiA;
    }

    private void brA() {
        boolean c = this.fhH.c(this.mData.fip);
        if (c) {
            this.fhH.stopPlay();
            this.fhH.onDestroy();
        }
        this.fhH.a(this.mData.fip, c);
        if (c) {
            this.fhH.T(this.fhv);
        }
        this.fhH.startPlay();
    }

    private void brB() {
        brC();
        this.fft.setData(this.fhJ);
        this.fhG.setData(this.fhK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(int i, float f) {
        if (this.fhH != null && f != 0.0f) {
            if (this.fhM <= i) {
                if (this.fhO && f >= 0.3f) {
                    this.fhH.jj(true);
                    this.fhH.pause();
                    this.fhO = false;
                }
            } else if (!this.fhO && f <= 0.3f) {
                this.fhH.jj(false);
                this.fhH.resume();
                this.fhO = true;
            }
            this.fhM = i;
        }
    }

    private void Hc() {
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds88);
        if (UtilHelper.canUseStyleImmersiveSticky() && this.mStatusBarView.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.mStatusBarView.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.mStatusBarView.setLayoutParams(layoutParams);
            this.mStatusBarView.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fhD.getLayoutParams();
            layoutParams2.height = layoutParams.height;
            this.fhD.setLayoutParams(layoutParams2);
            dimensionPixelSize = layoutParams.height + dimensionPixelSize;
        } else {
            this.mStatusBarView.setVisibility(8);
        }
        CollapsingToolbarLayout.LayoutParams layoutParams3 = (CollapsingToolbarLayout.LayoutParams) this.fhB.getLayoutParams();
        layoutParams3.height = dimensionPixelSize;
        this.fhB.setLayoutParams(layoutParams3);
    }

    private void brC() {
        this.fhJ.clear();
        this.fhK.clear();
        this.fhJ.add(brF());
        this.fhJ.add(brG());
        this.fhK.add(brD());
        this.fhK.add(brE());
        if (!v.isEmpty(this.mData.tabInfoList)) {
            boolean z = b.aTX().getInt("chushou_game_tab", 1) == 1;
            for (int i = 0; i < this.mData.tabInfoList.size() && i < 10; i++) {
                SpecialLiveTabInfo specialLiveTabInfo = this.mData.tabInfoList.get(i);
                if (specialLiveTabInfo != null && (specialLiveTabInfo.tabId != 1108 || z)) {
                    this.fhK.add(specialLiveTabInfo);
                    TabData tabData = new TabData();
                    tabData.tabId = specialLiveTabInfo.tabId;
                    tabData.tabName = specialLiveTabInfo.tabName;
                    tabData.tabType = specialLiveTabInfo.tabType;
                    this.fhJ.add(tabData);
                }
            }
        }
    }

    private SpecialLiveTabInfo brD() {
        SpecialLiveTabInfo specialLiveTabInfo = new SpecialLiveTabInfo();
        specialLiveTabInfo.tabId = OpenBdussResult.ERROR_CODE_NOT_LOGIN;
        specialLiveTabInfo.tabName = this.mContext.getResources().getString(R.string.special_concern_tab_title);
        return specialLiveTabInfo;
    }

    private SpecialLiveTabInfo brE() {
        SpecialLiveTabInfo specialLiveTabInfo = new SpecialLiveTabInfo();
        specialLiveTabInfo.tabId = -903;
        specialLiveTabInfo.tabName = this.mContext.getResources().getString(R.string.special_recommend_tab_title);
        return specialLiveTabInfo;
    }

    private TabData brF() {
        TabData tabData = new TabData();
        tabData.tabId = OpenBdussResult.ERROR_CODE_NOT_LOGIN;
        tabData.tabName = this.mContext.getResources().getString(R.string.special_concern_tab_title);
        return tabData;
    }

    private TabData brG() {
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
            if (this.fhH != null) {
                if (isPrimary()) {
                    this.fhH.jj(false);
                    this.fhH.startPlay();
                    return;
                }
                this.fhH.jj(true);
                this.fhH.pause();
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
        if (this.fhH != null) {
            this.fhH.jj(true);
            this.fhH.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fhH != null) {
            this.fhH.onChangeSkinType(i);
        }
        if (this.fft != null) {
            am.setBackgroundResource(this.fft, R.color.cp_bg_line_d);
            this.fft.onChangeSkinType(i);
        }
        if (this.fhG != null) {
            this.fhG.onChangeSkinType(i);
        }
        jy(false);
        am.setBackgroundColor(this.mStatusBarView, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.fhC, R.color.cp_bg_line_d);
        am.setViewTextColor(this.fhE, (int) R.color.cp_cont_b);
        am.setBackgroundColor(this.fhw, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.fhx, R.color.cp_bg_line_e);
        am.setViewTextColor(this.fhy, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.fhA, (int) R.color.cp_cont_j);
        am.setViewTextColor(this.fhz, (int) R.color.cp_cont_g);
        am.setBackgroundResource(this.fhz, R.drawable.frs_attention_btn_bg_selector);
        am.setBackgroundResource(this.fhu, R.color.cp_bg_line_c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jx(boolean z) {
        Drawable drawable;
        int i = R.drawable.frs_attention_btn_bg_selector;
        am.setBackgroundResource(this.fhz, R.drawable.frs_attention_btn_bg_selector);
        int dimens = l.getDimens(this.mContext, R.dimen.ds10);
        String string = this.mContext.getResources().getString(R.string.attention);
        int i2 = R.color.cp_cont_a;
        if (this.mCurState == 1) {
            drawable = am.getDrawable(R.drawable.icon_add_follow_blue_s);
            this.fhz.setClickable(true);
            if (!z) {
                TiebaStatic.log(new an("c12889"));
            }
        } else if (this.mCurState == 2) {
            string = this.mContext.getResources().getString(R.string.sign);
            drawable = am.getDrawable(R.drawable.icon_public_sign_blue_s);
            this.fhz.setClickable(true);
            if (!z) {
                TiebaStatic.log(new an("c12891"));
            }
        } else if (this.mCurState == 3) {
            string = this.mContext.getResources().getString(R.string.signed);
            this.fhz.setClickable(false);
            i = R.drawable.special_sign_btn_signed_bg;
            i2 = R.color.cp_cont_d;
            drawable = null;
        } else {
            drawable = null;
        }
        am.setBackgroundResource(this.fhz, i);
        am.setViewTextColor(this.fhz, i2);
        this.fhz.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.fhz.setCompoundDrawablePadding(dimens);
        this.fhz.setText(string);
        brH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jy(boolean z) {
        if (this.fhF != null) {
            if (z) {
                am.setNavbarIconSrc(this.fhF, R.drawable.selector_topbar_return_black, R.drawable.selector_topbar_return_black, TbadkCoreApplication.getInst().getSkinType());
            } else {
                am.setNavbarIconSrc(this.fhF, R.drawable.selector_topbar_return_white, R.drawable.selector_topbar_return_white, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    private void brH() {
        if (this.mData != null && this.mData.fis != null && this.mCurState != 1) {
            int i = this.mData.fis.level_id;
            String str = TextUtils.isEmpty(this.mData.fis.level_name) ? "" : " " + this.mData.fis.level_name;
            if (i >= 0) {
                this.fhA.setText("LV" + i + str);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.fhH != null) {
            this.fhH.onDestroy();
        }
        if (this.fhT != null) {
            MessageManager.getInstance().unRegisterListener(this.fhT);
        }
        if (this.fhL != null) {
            MessageManager.getInstance().unRegisterListener(this.fhL);
        }
        if (this.mSignChangedListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mSignChangedListener);
        }
        if (this.fhU != null) {
            MessageManager.getInstance().unRegisterListener(this.fhU);
        }
        if (this.fhS != null) {
            MessageManager.getInstance().unRegisterListener(this.fhS);
        }
        if (this.mAccountChangedListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mAccountChangedListener);
        }
        if (this.fhI != null) {
            this.fhI.onDestroy();
        }
        if (this.fcj != null) {
            this.fcj.onDestroy();
        }
        AlaLiveUserNotifyManager.getInstance().removeNotifyListener(this.fck);
        hideLoadingView(this.mRootView);
        MessageManager.getInstance().unRegisterListener(this.dzH);
    }

    private void initViewPager() {
        this.fhG = new a(getChildFragmentManager());
        this.dLI.setAdapter(this.fhG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends FragmentPagerAdapter {
        private SparseArray<SpecialForumTabBaseFragment> fhX;
        private List<SpecialLiveTabInfo> mData;

        public a(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.mData = new ArrayList();
            this.fhX = new SparseArray<>();
            this.fhX.put(0, ConcernTabFragment.pI(0));
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
            SpecialForumTabBaseFragment pG = pG(i);
            if (pG == null) {
                if (i == 0) {
                    pG = ConcernTabFragment.pI(0);
                } else if (i == 1) {
                    pG = RecommendTabFragment.pJ(1);
                } else if (i < this.mData.size() && this.mData.get(i) != null && this.mData.get(i).tabId == 1108) {
                    pG = GameTabFragment.AY(this.mData.get(i).tabName);
                } else {
                    pG = OtherSubTabFragment.a(i, this.mData.get(i));
                }
                this.fhX.put(i, pG);
            }
            return pG;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.mData.size();
        }

        public SpecialForumTabBaseFragment pG(int i) {
            return this.fhX.get(i);
        }

        public void a(int i, TabData tabData) {
            if (this.fhX.get(i) != null) {
                this.fhX.get(i).setPrimary(true);
            }
        }

        public void onChangeSkinType(int i) {
            if (this.fhX != null && this.fhX.size() > 0) {
                int size = this.fhX.size();
                for (int i2 = 0; i2 < size; i2++) {
                    SpecialForumTabBaseFragment specialForumTabBaseFragment = this.fhX.get(i2);
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
            if (this.fhQ != null) {
                this.fhQ.dismiss();
            }
            final Handler handler = new Handler();
            final Runnable runnable = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.10
                @Override // java.lang.Runnable
                public void run() {
                    if (SpecialLiveFragment.this.fhQ != null) {
                        SpecialLiveFragment.this.fhQ.dismiss();
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
                    SpecialLiveFragment.this.fhQ = null;
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
                            SpecialLiveFragment.this.fhQ.dismiss();
                        }
                    });
                    am.setViewTextColor(textView, (int) R.color.cp_cont_i);
                    bubbleLayout.Fs(am.getColor(R.color.cp_link_tip_a_alpha95));
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
            this.fhQ = dVar.ko();
            this.fhQ.show(activity);
            handler.postDelayed(runnable, 5000L);
        }
    }
}
