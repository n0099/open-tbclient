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
import com.baidu.tieba.tbadkCore.t;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.view.bubbleView.BubbleLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class SpecialLiveFragment extends BaseFragment {
    private AppBarLayout Ck;
    private CustomViewPager cTX;
    private LikeModel dfN;
    private AlaLiveUserNotifyController ehm;
    private AlaLiveUserNotifyManager.AlaLiveNotifyListener ehn;
    private ScrollHorizontalTabView ekt;
    private com.baidu.tieba.ala.alasquare.special_forum.model.a emA;
    private List<TabData> emB;
    private List<SpecialLiveTabInfo> emC;
    private CustomMessageListener emD;
    private int emE;
    private String emF;
    private c emI;
    private float emk;
    private CollapsingToolbarLayout eml;
    private View emm;
    private ObservedChangeFrameLayout emn;
    private RelativeLayout emo;
    private View emp;
    private TextView emq;
    private TextView emr;
    private TextView ems;
    private RelativeLayout emt;
    private View emu;
    private View emv;
    private TextView emw;
    private ImageView emx;
    private a emy;
    private e emz;
    private BdUniqueId mBdUniqueId;
    private Context mContext;
    private h mData;
    private String mForumId;
    private String mForumName;
    private View mRootView;
    private View mStatusBarView;
    private boolean emG = true;
    private int mCurState = 1;
    private boolean emH = false;
    private Handler mHandler = new Handler();
    private Runnable emJ = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.1
        @Override // java.lang.Runnable
        public void run() {
            if (SpecialLiveFragment.this.emz != null) {
                SpecialLiveFragment.this.emz.bbe();
            }
        }
    };
    private CustomMessageListener cIh = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            SpecialLiveFragment.this.mHandler.removeCallbacks(SpecialLiveFragment.this.emJ);
            SpecialLiveFragment.this.mHandler.postDelayed(SpecialLiveFragment.this.emJ, 500L);
        }
    };
    private CustomMessageListener emK = new CustomMessageListener(CmdConfigCustom.CMD_FORCE_REFRESH) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2) {
                    if ("FrsLiveLive".equals(split[0])) {
                        SpecialLiveFragment.this.loadData(false);
                    }
                    SpecialForumTabBaseFragment ot = SpecialLiveFragment.this.emy.ot(SpecialLiveFragment.this.cTX.getCurrentItem());
                    if (ot != null) {
                        ot.baZ();
                    }
                }
            }
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && SpecialLiveFragment.this.emA != null && !TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                SpecialLiveFragment.this.loadData(false);
            }
        }
    };
    private final CustomMessageListener emL = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            t tVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof t) && (tVar = (t) customResponsedMessage.getData()) != null && SpecialLiveFragment.this.mForumId.equals(tVar.getFid())) {
                if (tVar.isLike() == 1) {
                    if (SpecialLiveFragment.this.baP()) {
                        SpecialLiveFragment.this.mCurState = 3;
                    } else {
                        SpecialLiveFragment.this.mCurState = 2;
                    }
                } else {
                    SpecialLiveFragment.this.mCurState = 1;
                }
                SpecialLiveFragment.this.hV(false);
            }
        }
    };
    private final CustomMessageListener emM = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            SignData signData;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (signData = (SignData) customResponsedMessage.getData()) != null && SpecialLiveFragment.this.mForumId.equals(signData.forumId) && signData.is_signed == 1) {
                SpecialLiveFragment.this.mCurState = 3;
                SpecialLiveFragment.this.hV(false);
                l.showToast(SpecialLiveFragment.this.getPageContext().getPageActivity(), SpecialLiveFragment.this.mContext.getString(R.string.special_sign_success_tip, Integer.valueOf(signData.sign_bonus_point)));
            }
        }
    };
    private final CustomMessageListener emN = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_SPECIAL_CONCERN_TAB_TAB_ICON) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                Boolean bool = (Boolean) customResponsedMessage.getData();
                if (!v.isEmpty(SpecialLiveFragment.this.emB)) {
                    ((TabData) SpecialLiveFragment.this.emB.get(0)).extra = bool;
                    SpecialLiveFragment.this.ekt.setData(SpecialLiveFragment.this.emB);
                    if (bool.booleanValue()) {
                        TiebaStatic.log("c12898");
                    }
                }
            }
        }
    };

    public static SpecialLiveFragment cG(String str, String str2) {
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
                this.emF = sb.toString();
            } else {
                this.mForumName = this.mContext.getResources().getString(R.string.ala_ufan_bar_title);
                this.emF = this.mForumName + string2;
            }
            baN();
            baL();
            baM();
            MessageManager.getInstance().registerListener(this.emD);
            MessageManager.getInstance().registerListener(this.emL);
            MessageManager.getInstance().registerListener(this.emM);
            MessageManager.getInstance().registerListener(this.emN);
            MessageManager.getInstance().registerListener(this.emK);
            MessageManager.getInstance().registerListener(this.mAccountChangedListener);
            MessageManager.getInstance().registerListener(this.cIh);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(R.layout.special_live_layout, (ViewGroup) null);
        this.Ck = (AppBarLayout) this.mRootView.findViewById(R.id.special_app_bar_layout);
        this.eml = (CollapsingToolbarLayout) this.mRootView.findViewById(R.id.special_collapse_layout);
        this.mStatusBarView = this.mRootView.findViewById(R.id.statusbar_view);
        this.emn = (ObservedChangeFrameLayout) this.mRootView.findViewById(R.id.live_container);
        this.mBdUniqueId = BdUniqueId.gen();
        this.emo = (RelativeLayout) this.mRootView.findViewById(R.id.function_container);
        this.emp = this.mRootView.findViewById(R.id.function_bottom_space);
        this.emq = (TextView) this.mRootView.findViewById(R.id.function_title);
        this.emq.setText(this.emF);
        this.emr = (TextView) this.mRootView.findViewById(R.id.function_btn);
        this.emr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.19
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
                    SpecialLiveFragment.this.emr.setClickable(false);
                    SpecialLiveFragment.this.dfN.et(SpecialLiveFragment.this.mForumName, SpecialLiveFragment.this.mForumId);
                    TiebaStatic.log(new an("c12890"));
                } else if (SpecialLiveFragment.this.mCurState == 2) {
                    SpecialLiveFragment.this.emr.setClickable(false);
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
        this.ems = (TextView) this.mRootView.findViewById(R.id.function_level_desc);
        this.emt = (RelativeLayout) this.mRootView.findViewById(R.id.navigation_layout);
        this.emv = this.mRootView.findViewById(R.id.navigation_top_space);
        this.emu = this.mRootView.findViewById(R.id.navigation_bg);
        this.emw = (TextView) this.mRootView.findViewById(R.id.navigation_title);
        this.emw.setText(this.emF);
        this.emx = (ImageView) this.mRootView.findViewById(R.id.navigation_back_img);
        this.emx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, SpecialLiveFragment.this.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        });
        this.ekt = (ScrollHorizontalTabView) this.mRootView.findViewById(R.id.scroll_tab_view);
        this.cTX = (CustomViewPager) this.mRootView.findViewById(R.id.special_view_pager);
        initViewPager();
        this.ekt.setViewPager(this.cTX);
        this.ekt.setScrollTabPageListener(new ScrollHorizontalTabView.ScrollTabPageListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.2
            @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
            public boolean onPrePageSelect(int i, TabData tabData) {
                return true;
            }

            @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
            public void onPageSelected(int i, TabData tabData) {
                if (i != 0 || TbadkCoreApplication.isLogin()) {
                    if (SpecialLiveFragment.this.emy != null) {
                        SpecialLiveFragment.this.emy.a(i, tabData);
                        return;
                    }
                    return;
                }
                bc.skipToLoginActivity(SpecialLiveFragment.this.getPageContext().getPageActivity());
                if (SpecialLiveFragment.this.cTX != null) {
                    SpecialLiveFragment.this.cTX.setCurrentItem(1);
                }
            }

            @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
            public void onPageScrolled(int i, float f, int i2) {
            }
        });
        this.Ck.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.3
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                int abs = Math.abs(i);
                if (abs == 0) {
                    SpecialLiveFragment.this.emu.setVisibility(8);
                    SpecialLiveFragment.this.emw.setVisibility(8);
                } else {
                    SpecialLiveFragment.this.emu.setVisibility(0);
                    SpecialLiveFragment.this.emw.setVisibility(0);
                }
                SpecialLiveFragment.this.hW(((float) abs) > SpecialLiveFragment.this.emk / 2.0f);
                float abs2 = Math.abs(abs / SpecialLiveFragment.this.emk);
                SpecialLiveFragment.this.emu.setAlpha(abs2);
                SpecialLiveFragment.this.emw.setAlpha(abs2);
                SpecialLiveFragment.this.i(abs, abs2);
            }
        });
        this.emm = this.mRootView.findViewById(R.id.square_main_top_divider_line);
        this.emn.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.4
            @Override // com.baidu.tbadk.widget.layout.e
            public void d(View view, int i, int i2, int i3, int i4) {
                SpecialLiveFragment.this.emk = (SpecialLiveFragment.this.emn.getMeasuredHeight() + SpecialLiveFragment.this.emo.getMeasuredHeight()) - SpecialLiveFragment.this.emt.getMeasuredHeight();
                SpecialLiveFragment.this.eml.setMinimumHeight(SpecialLiveFragment.this.emt.getMeasuredHeight());
            }
        });
        xO();
        this.emB = new ArrayList();
        this.emC = new ArrayList();
        this.emz = new e(getPageContext());
        this.emA = new com.baidu.tieba.ala.alasquare.special_forum.model.a(getPageContext(), new a.InterfaceC0415a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.5
            @Override // com.baidu.tieba.ala.alasquare.special_forum.model.a.InterfaceC0415a
            public void b(h hVar) {
                SpecialLiveFragment.this.hideLoadingView(SpecialLiveFragment.this.mRootView);
                SpecialLiveFragment.this.a(hVar);
            }

            @Override // com.baidu.tieba.ala.alasquare.special_forum.model.a.InterfaceC0415a
            public void ac(int i, String str) {
                SpecialLiveFragment.this.ah(i, str);
            }
        });
        hV(true);
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
                SpecialLiveFragment.this.ah(SpecialLiveFragment.this.getFragmentActivity());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData(boolean z) {
        if (!this.emA.isLoading()) {
            if (z) {
                showLoadingView(this.mRootView);
            }
            this.emA.loadData();
        }
    }

    private void baL() {
        this.ehm = new AlaLiveUserNotifyController(getPageContext());
        this.ehn = new AlaLiveUserNotifyManager.AlaLiveNotifyListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.7
            @Override // com.baidu.ala.notify.AlaLiveUserNotifyManager.AlaLiveNotifyListener
            public void onCallBack() {
                if (SpecialLiveFragment.this.isPrimary()) {
                    SpecialLiveFragment.this.ehm.showNextNotifyDialog(0, AlaLiveUserNotifyManager.getInstance().getNotifyDataList());
                }
            }
        };
        AlaLiveUserNotifyManager.getInstance().addNotifyListener(this.ehn);
    }

    private void baM() {
        this.emD = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_MODEL_TASK) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z;
                SignData signData = null;
                SpecialLiveFragment.this.emr.setClickable(true);
                if (customResponsedMessage != null && customResponsedMessage.getOrginalMessage().getTag() == SpecialLiveFragment.this.mBdUniqueId) {
                    SignMessage signMessage = (SignMessage) customResponsedMessage;
                    if (AntiHelper.bc(signMessage.mSignErrorCode, signMessage.mSignErrorString) && signMessage.signData != null) {
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
                        if (AntiHelper.bc(signMessage.mSignErrorCode, signMessage.mSignErrorString)) {
                            AntiHelper.bn(SpecialLiveFragment.this.mContext, signMessage.mSignErrorString);
                            return;
                        } else {
                            l.showToast(SpecialLiveFragment.this.mContext, SpecialLiveFragment.this.mContext.getString(R.string.special_sign_success_tip, Integer.valueOf(signData.sign_bonus_point)));
                            return;
                        }
                    }
                    if (signMessage.mSignErrorCode == 160002) {
                        SpecialLiveFragment.this.mCurState = 3;
                        SpecialLiveFragment.this.hV(false);
                    }
                    l.showToast(SpecialLiveFragment.this.mContext, signMessage.mSignErrorString);
                }
            }
        };
    }

    private void baN() {
        this.dfN = new LikeModel(getPageContext());
        this.dfN.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.9
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                SpecialLiveFragment.this.emr.setClickable(true);
                if (SpecialLiveFragment.this.dfN.getErrorCode() == 22) {
                    l.showToast(SpecialLiveFragment.this.mContext, (int) R.string.had_liked_forum);
                } else if (AntiHelper.bc(SpecialLiveFragment.this.dfN.getErrorCode(), SpecialLiveFragment.this.dfN.getErrorString())) {
                    AntiHelper.bn(SpecialLiveFragment.this.mContext, SpecialLiveFragment.this.dfN.getErrorString());
                } else if (SpecialLiveFragment.this.dfN.getErrorCode() != 0) {
                    l.showToast(SpecialLiveFragment.this.mContext, SpecialLiveFragment.this.dfN.getErrorString());
                } else {
                    t tVar = (t) obj;
                    if (tVar != null) {
                        TbadkCoreApplication.getInst().addLikeForum(SpecialLiveFragment.this.mForumName);
                        tVar.setLike(1);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, tVar));
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
        baQ();
        baO();
        if (!this.emH) {
            baR();
            if (this.cTX != null && this.cTX.getChildCount() > 1) {
                this.cTX.setCurrentItem(1);
            }
            if (!v.isEmpty(this.mData.tabInfoList)) {
                this.emH = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ah(int i, String str) {
        if (TextUtils.isEmpty(str)) {
            showNetRefreshView(this.mRootView, this.mContext.getResources().getString(R.string.square_load_data_failed_tip), false);
        } else {
            showNetRefreshView(this.mRootView, str, false);
        }
    }

    private void baO() {
        if (this.mData.enk) {
            if (baP()) {
                this.mCurState = 3;
            } else {
                this.mCurState = 2;
            }
        } else {
            this.mCurState = 1;
        }
        hV(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean baP() {
        return this.mData.enm.ens;
    }

    private void baQ() {
        boolean c = this.emz.c(this.mData.eni);
        if (c) {
            this.emz.stopPlay();
            this.emz.onDestroy();
        }
        this.emz.a(this.mData.eni, c);
        if (c) {
            this.emz.M(this.emn);
        }
        this.emz.startPlay();
    }

    private void baR() {
        baS();
        this.ekt.setData(this.emB);
        this.emy.setData(this.emC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(int i, float f) {
        if (this.emz != null && f != 0.0f) {
            if (this.emE <= i) {
                if (this.emG && f >= 0.3f) {
                    this.emz.hK(true);
                    this.emz.pause();
                    this.emG = false;
                }
            } else if (!this.emG && f <= 0.3f) {
                this.emz.hK(false);
                this.emz.resume();
                this.emG = true;
            }
            this.emE = i;
        }
    }

    private void xO() {
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds88);
        if (UtilHelper.canUseStyleImmersiveSticky() && this.mStatusBarView.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.mStatusBarView.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.mStatusBarView.setLayoutParams(layoutParams);
            this.mStatusBarView.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.emv.getLayoutParams();
            layoutParams2.height = layoutParams.height;
            this.emv.setLayoutParams(layoutParams2);
            dimensionPixelSize = layoutParams.height + dimensionPixelSize;
        } else {
            this.mStatusBarView.setVisibility(8);
        }
        CollapsingToolbarLayout.LayoutParams layoutParams3 = (CollapsingToolbarLayout.LayoutParams) this.emt.getLayoutParams();
        layoutParams3.height = dimensionPixelSize;
        this.emt.setLayoutParams(layoutParams3);
    }

    private void baS() {
        this.emB.clear();
        this.emC.clear();
        this.emB.add(baV());
        this.emB.add(baW());
        this.emC.add(baT());
        this.emC.add(baU());
        if (!v.isEmpty(this.mData.tabInfoList)) {
            boolean z = b.aDr().getInt("chushou_game_tab", 1) == 1;
            for (int i = 0; i < this.mData.tabInfoList.size() && i < 10; i++) {
                SpecialLiveTabInfo specialLiveTabInfo = this.mData.tabInfoList.get(i);
                if (specialLiveTabInfo != null && (specialLiveTabInfo.tabId != 1108 || z)) {
                    this.emC.add(specialLiveTabInfo);
                    TabData tabData = new TabData();
                    tabData.tabId = specialLiveTabInfo.tabId;
                    tabData.tabName = specialLiveTabInfo.tabName;
                    tabData.tabType = specialLiveTabInfo.tabType;
                    this.emB.add(tabData);
                }
            }
        }
    }

    private SpecialLiveTabInfo baT() {
        SpecialLiveTabInfo specialLiveTabInfo = new SpecialLiveTabInfo();
        specialLiveTabInfo.tabId = -901;
        specialLiveTabInfo.tabName = this.mContext.getResources().getString(R.string.special_concern_tab_title);
        return specialLiveTabInfo;
    }

    private SpecialLiveTabInfo baU() {
        SpecialLiveTabInfo specialLiveTabInfo = new SpecialLiveTabInfo();
        specialLiveTabInfo.tabId = -903;
        specialLiveTabInfo.tabName = this.mContext.getResources().getString(R.string.special_recommend_tab_title);
        return specialLiveTabInfo;
    }

    private TabData baV() {
        TabData tabData = new TabData();
        tabData.tabId = -901;
        tabData.tabName = this.mContext.getResources().getString(R.string.special_concern_tab_title);
        return tabData;
    }

    private TabData baW() {
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
            if (this.emz != null) {
                if (isPrimary()) {
                    this.emz.hK(false);
                    this.emz.startPlay();
                    return;
                }
                this.emz.hK(true);
                this.emz.pause();
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
        if (this.emz != null) {
            this.emz.hK(true);
            this.emz.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.emz != null) {
            this.emz.onChangeSkinType(i);
        }
        if (this.ekt != null) {
            am.setBackgroundResource(this.ekt, R.color.cp_bg_line_d);
            this.ekt.onChangeSkinType(i);
        }
        if (this.emy != null) {
            this.emy.onChangeSkinType(i);
        }
        hW(false);
        am.setBackgroundColor(this.mStatusBarView, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.emu, R.color.cp_bg_line_d);
        am.setViewTextColor(this.emw, (int) R.color.cp_cont_b);
        am.setBackgroundColor(this.emo, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.emp, R.color.cp_bg_line_e);
        am.setViewTextColor(this.emq, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.ems, (int) R.color.cp_cont_j);
        am.setViewTextColor(this.emr, (int) R.color.cp_cont_g);
        am.setBackgroundResource(this.emr, R.drawable.frs_attention_btn_bg_selector);
        am.setBackgroundResource(this.emm, R.color.cp_bg_line_c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hV(boolean z) {
        Drawable drawable;
        int i = R.drawable.frs_attention_btn_bg_selector;
        am.setBackgroundResource(this.emr, R.drawable.frs_attention_btn_bg_selector);
        int dimens = l.getDimens(this.mContext, R.dimen.ds10);
        String string = this.mContext.getResources().getString(R.string.attention);
        int i2 = R.color.cp_cont_a;
        if (this.mCurState == 1) {
            drawable = am.getDrawable(R.drawable.icon_add_follow_blue_s);
            this.emr.setClickable(true);
            if (!z) {
                TiebaStatic.log(new an("c12889"));
            }
        } else if (this.mCurState == 2) {
            string = this.mContext.getResources().getString(R.string.sign);
            drawable = am.getDrawable(R.drawable.icon_public_sign_blue_s);
            this.emr.setClickable(true);
            if (!z) {
                TiebaStatic.log(new an("c12891"));
            }
        } else if (this.mCurState == 3) {
            string = this.mContext.getResources().getString(R.string.signed);
            this.emr.setClickable(false);
            i = R.drawable.special_sign_btn_signed_bg;
            i2 = R.color.cp_cont_d;
            drawable = null;
        } else {
            drawable = null;
        }
        am.setBackgroundResource(this.emr, i);
        am.setViewTextColor(this.emr, i2);
        this.emr.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.emr.setCompoundDrawablePadding(dimens);
        this.emr.setText(string);
        baX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hW(boolean z) {
        if (this.emx != null) {
            if (z) {
                am.setNavbarIconSrc(this.emx, R.drawable.selector_topbar_return_black, R.drawable.selector_topbar_return_black, TbadkCoreApplication.getInst().getSkinType());
            } else {
                am.setNavbarIconSrc(this.emx, R.drawable.selector_topbar_return_white, R.drawable.selector_topbar_return_white, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    private void baX() {
        if (this.mData != null && this.mData.enl != null && this.mCurState != 1) {
            int i = this.mData.enl.level_id;
            String str = TextUtils.isEmpty(this.mData.enl.level_name) ? "" : HanziToPinyin.Token.SEPARATOR + this.mData.enl.level_name;
            if (i >= 0) {
                this.ems.setText("LV" + i + str);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.emz != null) {
            this.emz.onDestroy();
        }
        if (this.emL != null) {
            MessageManager.getInstance().unRegisterListener(this.emL);
        }
        if (this.emD != null) {
            MessageManager.getInstance().unRegisterListener(this.emD);
        }
        if (this.emM != null) {
            MessageManager.getInstance().unRegisterListener(this.emM);
        }
        if (this.emN != null) {
            MessageManager.getInstance().unRegisterListener(this.emN);
        }
        if (this.emK != null) {
            MessageManager.getInstance().unRegisterListener(this.emK);
        }
        if (this.mAccountChangedListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mAccountChangedListener);
        }
        if (this.emA != null) {
            this.emA.onDestroy();
        }
        if (this.ehm != null) {
            this.ehm.onDestroy();
        }
        AlaLiveUserNotifyManager.getInstance().removeNotifyListener(this.ehn);
        hideLoadingView(this.mRootView);
        MessageManager.getInstance().unRegisterListener(this.cIh);
    }

    private void initViewPager() {
        this.emy = new a(getChildFragmentManager());
        this.cTX.setAdapter(this.emy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends FragmentPagerAdapter {
        private SparseArray<SpecialForumTabBaseFragment> emQ;
        private List<SpecialLiveTabInfo> mData;

        public a(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.mData = new ArrayList();
            this.emQ = new SparseArray<>();
            this.emQ.put(0, ConcernTabFragment.ov(0));
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
            SpecialForumTabBaseFragment ot = ot(i);
            if (ot == null) {
                if (i == 0) {
                    ot = ConcernTabFragment.ov(0);
                } else if (i == 1) {
                    ot = RecommendTabFragment.ow(1);
                } else if (i < this.mData.size() && this.mData.get(i) != null && this.mData.get(i).tabId == 1108) {
                    ot = GameTabFragment.xp(this.mData.get(i).tabName);
                } else {
                    ot = OtherSubTabFragment.a(i, this.mData.get(i));
                }
                this.emQ.put(i, ot);
            }
            return ot;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.mData.size();
        }

        public SpecialForumTabBaseFragment ot(int i) {
            return this.emQ.get(i);
        }

        public void a(int i, TabData tabData) {
            if (this.emQ.get(i) != null) {
                this.emQ.get(i).setPrimary(true);
            }
        }

        public void onChangeSkinType(int i) {
            if (this.emQ != null && this.emQ.size() > 0) {
                int size = this.emQ.size();
                for (int i2 = 0; i2 < size; i2++) {
                    SpecialForumTabBaseFragment specialForumTabBaseFragment = this.emQ.get(i2);
                    if (specialForumTabBaseFragment != null) {
                        specialForumTabBaseFragment.onChangeSkinType(i);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ah(final Activity activity) {
        if (activity != null && !AlaSharedPrefHelper.getInstance().getBoolean(AlaSharedPrefConfig.SQUARE_GUIDE_MARK_MANAGE_TIP_SHOW, false)) {
            if (this.emI != null) {
                this.emI.dismiss();
            }
            final Handler handler = new Handler();
            final Runnable runnable = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.10
                @Override // java.lang.Runnable
                public void run() {
                    if (SpecialLiveFragment.this.emI != null) {
                        SpecialLiveFragment.this.emI.dismiss();
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
                    SpecialLiveFragment.this.emI = null;
                    handler.removeCallbacks(runnable);
                }
            });
            dVar.y(activity.getWindow().getDecorView().findViewById(R.id.tabcontainer)).J(20).F(false);
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
                            SpecialLiveFragment.this.emI.dismiss();
                        }
                    });
                    am.setViewTextColor(textView, (int) R.color.cp_cont_i);
                    bubbleLayout.DR(am.getColor(R.color.cp_link_tip_a_alpha95));
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
            this.emI = dVar.fI();
            this.emI.show(activity);
            handler.postDelayed(runnable, 5000L);
        }
    }
}
