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
import com.baidu.adp.lib.guide.b;
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
import com.baidu.tieba.ala.alasquare.special_forum.subtab.OtherSubTabFragment;
import com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment;
import com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.t;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.view.bubbleView.BubbleLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class SpecialLiveFragment extends BaseFragment {
    private AppBarLayout Aa;
    private CustomViewPager cig;
    private LikeModel csF;
    private CustomMessageListener dBA;
    private int dBB;
    private String dBC;
    private c dBF;
    private float dBg;
    private CollapsingToolbarLayout dBh;
    private View dBi;
    private ObservedChangeFrameLayout dBj;
    private RelativeLayout dBk;
    private View dBl;
    private TextView dBm;
    private TextView dBn;
    private TextView dBo;
    private RelativeLayout dBp;
    private View dBq;
    private View dBr;
    private TextView dBs;
    private ImageView dBt;
    private ScrollHorizontalTabView dBu;
    private a dBv;
    private e dBw;
    private com.baidu.tieba.ala.alasquare.special_forum.model.a dBx;
    private List<TabData> dBy;
    private List<SpecialLiveTabInfo> dBz;
    private AlaLiveUserNotifyController dwT;
    private AlaLiveUserNotifyManager.AlaLiveNotifyListener dwU;
    private BdUniqueId mBdUniqueId;
    private Context mContext;
    private h mData;
    private String mForumId;
    private String mForumName;
    private View mRootView;
    private View mStatusBarView;
    private boolean dBD = true;
    private int mCurState = 1;
    private boolean dBE = false;
    private Handler mHandler = new Handler();
    private Runnable dBG = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.1
        @Override // java.lang.Runnable
        public void run() {
            if (SpecialLiveFragment.this.dBw != null) {
                SpecialLiveFragment.this.dBw.aKm();
            }
        }
    };
    private CustomMessageListener bWw = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            SpecialLiveFragment.this.mHandler.removeCallbacks(SpecialLiveFragment.this.dBG);
            SpecialLiveFragment.this.mHandler.postDelayed(SpecialLiveFragment.this.dBG, 500L);
        }
    };
    private CustomMessageListener dBH = new CustomMessageListener(CmdConfigCustom.CMD_FORCE_REFRESH) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2) {
                    if ("FrsLiveLive".equals(split[0])) {
                        SpecialLiveFragment.this.loadData(false);
                    }
                    SpecialForumTabBaseFragment mk = SpecialLiveFragment.this.dBv.mk(SpecialLiveFragment.this.cig.getCurrentItem());
                    if (mk != null) {
                        mk.aKh();
                    }
                }
            }
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && SpecialLiveFragment.this.dBx != null && !TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                SpecialLiveFragment.this.loadData(false);
            }
        }
    };
    private final CustomMessageListener dBI = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            t tVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof t) && (tVar = (t) customResponsedMessage.getData()) != null && SpecialLiveFragment.this.mForumId.equals(tVar.getFid())) {
                if (tVar.isLike() == 1) {
                    if (SpecialLiveFragment.this.aJX()) {
                        SpecialLiveFragment.this.mCurState = 3;
                    } else {
                        SpecialLiveFragment.this.mCurState = 2;
                    }
                } else {
                    SpecialLiveFragment.this.mCurState = 1;
                }
                SpecialLiveFragment.this.gG(false);
            }
        }
    };
    private final CustomMessageListener dBJ = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            SignData signData;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (signData = (SignData) customResponsedMessage.getData()) != null && SpecialLiveFragment.this.mForumId.equals(signData.forumId) && signData.is_signed == 1) {
                SpecialLiveFragment.this.mCurState = 3;
                SpecialLiveFragment.this.gG(false);
                l.showToast(SpecialLiveFragment.this.getPageContext().getPageActivity(), SpecialLiveFragment.this.mContext.getString(R.string.special_sign_success_tip, Integer.valueOf(signData.sign_bonus_point)));
            }
        }
    };
    private final CustomMessageListener dBK = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_SPECIAL_CONCERN_TAB_TAB_ICON) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                Boolean bool = (Boolean) customResponsedMessage.getData();
                if (!v.isEmpty(SpecialLiveFragment.this.dBy)) {
                    ((TabData) SpecialLiveFragment.this.dBy.get(0)).extra = bool;
                    SpecialLiveFragment.this.dBu.setData(SpecialLiveFragment.this.dBy);
                    if (bool.booleanValue()) {
                        TiebaStatic.log("c12898");
                    }
                }
            }
        }
    };

    public static SpecialLiveFragment co(String str, String str2) {
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
                this.dBC = sb.toString();
            } else {
                this.mForumName = this.mContext.getResources().getString(R.string.ala_ufan_bar_title);
                this.dBC = this.mForumName + string2;
            }
            aJV();
            aJT();
            aJU();
            MessageManager.getInstance().registerListener(this.dBA);
            MessageManager.getInstance().registerListener(this.dBI);
            MessageManager.getInstance().registerListener(this.dBJ);
            MessageManager.getInstance().registerListener(this.dBK);
            MessageManager.getInstance().registerListener(this.dBH);
            MessageManager.getInstance().registerListener(this.mAccountChangedListener);
            MessageManager.getInstance().registerListener(this.bWw);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(R.layout.special_live_layout, (ViewGroup) null);
        this.Aa = (AppBarLayout) this.mRootView.findViewById(R.id.special_app_bar_layout);
        this.dBh = (CollapsingToolbarLayout) this.mRootView.findViewById(R.id.special_collapse_layout);
        this.mStatusBarView = this.mRootView.findViewById(R.id.statusbar_view);
        this.dBj = (ObservedChangeFrameLayout) this.mRootView.findViewById(R.id.live_container);
        this.mBdUniqueId = BdUniqueId.gen();
        this.dBk = (RelativeLayout) this.mRootView.findViewById(R.id.function_container);
        this.dBl = this.mRootView.findViewById(R.id.function_bottom_space);
        this.dBm = (TextView) this.mRootView.findViewById(R.id.function_title);
        this.dBm.setText(this.dBC);
        this.dBn = (TextView) this.mRootView.findViewById(R.id.function_btn);
        this.dBn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.19
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
                    SpecialLiveFragment.this.dBn.setClickable(false);
                    SpecialLiveFragment.this.csF.dY(SpecialLiveFragment.this.mForumName, SpecialLiveFragment.this.mForumId);
                    TiebaStatic.log(new an("c12890"));
                } else if (SpecialLiveFragment.this.mCurState == 2) {
                    SpecialLiveFragment.this.dBn.setClickable(false);
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
        this.dBo = (TextView) this.mRootView.findViewById(R.id.function_level_desc);
        this.dBp = (RelativeLayout) this.mRootView.findViewById(R.id.navigation_layout);
        this.dBr = this.mRootView.findViewById(R.id.navigation_top_space);
        this.dBq = this.mRootView.findViewById(R.id.navigation_bg);
        this.dBs = (TextView) this.mRootView.findViewById(R.id.navigation_title);
        this.dBs.setText(this.dBC);
        this.dBt = (ImageView) this.mRootView.findViewById(R.id.navigation_back_img);
        this.dBt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, SpecialLiveFragment.this.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        });
        this.dBu = (ScrollHorizontalTabView) this.mRootView.findViewById(R.id.scroll_tab_view);
        this.cig = (CustomViewPager) this.mRootView.findViewById(R.id.special_view_pager);
        initViewPager();
        this.dBu.setViewPager(this.cig);
        this.dBu.setScrollTabPageListener(new ScrollHorizontalTabView.ScrollTabPageListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.2
            @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
            public boolean onPrePageSelect(int i, TabData tabData) {
                return true;
            }

            @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
            public void onPageSelected(int i, TabData tabData) {
                if (i != 0 || TbadkCoreApplication.isLogin()) {
                    if (SpecialLiveFragment.this.dBv != null) {
                        SpecialLiveFragment.this.dBv.a(i, tabData);
                        return;
                    }
                    return;
                }
                bc.skipToLoginActivity(SpecialLiveFragment.this.getPageContext().getPageActivity());
                if (SpecialLiveFragment.this.cig != null) {
                    SpecialLiveFragment.this.cig.setCurrentItem(1);
                }
            }

            @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
            public void onPageScrolled(int i, float f, int i2) {
            }
        });
        this.Aa.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.3
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                int abs = Math.abs(i);
                if (abs == 0) {
                    SpecialLiveFragment.this.dBq.setVisibility(8);
                    SpecialLiveFragment.this.dBs.setVisibility(8);
                } else {
                    SpecialLiveFragment.this.dBq.setVisibility(0);
                    SpecialLiveFragment.this.dBs.setVisibility(0);
                }
                SpecialLiveFragment.this.gH(((float) abs) > SpecialLiveFragment.this.dBg / 2.0f);
                float abs2 = Math.abs(abs / SpecialLiveFragment.this.dBg);
                SpecialLiveFragment.this.dBq.setAlpha(abs2);
                SpecialLiveFragment.this.dBs.setAlpha(abs2);
                SpecialLiveFragment.this.f(abs, abs2);
            }
        });
        this.dBi = this.mRootView.findViewById(R.id.square_main_top_divider_line);
        this.dBj.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.4
            @Override // com.baidu.tbadk.widget.layout.e
            public void d(View view, int i, int i2, int i3, int i4) {
                SpecialLiveFragment.this.dBg = (SpecialLiveFragment.this.dBj.getMeasuredHeight() + SpecialLiveFragment.this.dBk.getMeasuredHeight()) - SpecialLiveFragment.this.dBp.getMeasuredHeight();
                SpecialLiveFragment.this.dBh.setMinimumHeight(SpecialLiveFragment.this.dBp.getMeasuredHeight());
            }
        });
        vz();
        this.dBy = new ArrayList();
        this.dBz = new ArrayList();
        this.dBw = new e(getPageContext());
        this.dBx = new com.baidu.tieba.ala.alasquare.special_forum.model.a(getPageContext(), new a.InterfaceC0337a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.5
            @Override // com.baidu.tieba.ala.alasquare.special_forum.model.a.InterfaceC0337a
            public void b(h hVar) {
                SpecialLiveFragment.this.hideLoadingView(SpecialLiveFragment.this.mRootView);
                SpecialLiveFragment.this.a(hVar);
            }

            @Override // com.baidu.tieba.ala.alasquare.special_forum.model.a.InterfaceC0337a
            public void S(int i, String str) {
                SpecialLiveFragment.this.R(i, str);
            }
        });
        gG(true);
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
                SpecialLiveFragment.this.ab(SpecialLiveFragment.this.getFragmentActivity());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData(boolean z) {
        if (!this.dBx.isLoading()) {
            if (z) {
                showLoadingView(this.mRootView);
            }
            this.dBx.loadData();
        }
    }

    private void aJT() {
        this.dwT = new AlaLiveUserNotifyController(getPageContext());
        this.dwU = new AlaLiveUserNotifyManager.AlaLiveNotifyListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.7
            @Override // com.baidu.ala.notify.AlaLiveUserNotifyManager.AlaLiveNotifyListener
            public void onCallBack() {
                if (SpecialLiveFragment.this.isPrimary()) {
                    SpecialLiveFragment.this.dwT.showNextNotifyDialog(0, AlaLiveUserNotifyManager.getInstance().getNotifyDataList());
                }
            }
        };
        AlaLiveUserNotifyManager.getInstance().addNotifyListener(this.dwU);
    }

    private void aJU() {
        this.dBA = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_MODEL_TASK) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z;
                SignData signData = null;
                SpecialLiveFragment.this.dBn.setClickable(true);
                if (customResponsedMessage != null && customResponsedMessage.getOrginalMessage().getTag() == SpecialLiveFragment.this.mBdUniqueId) {
                    SignMessage signMessage = (SignMessage) customResponsedMessage;
                    if (AntiHelper.aH(signMessage.mSignErrorCode, signMessage.mSignErrorString) && signMessage.signData != null) {
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
                        if (AntiHelper.aH(signMessage.mSignErrorCode, signMessage.mSignErrorString)) {
                            AntiHelper.aS(SpecialLiveFragment.this.mContext, signMessage.mSignErrorString);
                            return;
                        } else {
                            l.showToast(SpecialLiveFragment.this.mContext, SpecialLiveFragment.this.mContext.getString(R.string.special_sign_success_tip, Integer.valueOf(signData.sign_bonus_point)));
                            return;
                        }
                    }
                    if (signMessage.mSignErrorCode == 160002) {
                        SpecialLiveFragment.this.mCurState = 3;
                        SpecialLiveFragment.this.gG(false);
                    }
                    l.showToast(SpecialLiveFragment.this.mContext, signMessage.mSignErrorString);
                }
            }
        };
    }

    private void aJV() {
        this.csF = new LikeModel(getPageContext());
        this.csF.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.9
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                SpecialLiveFragment.this.dBn.setClickable(true);
                if (SpecialLiveFragment.this.csF.getErrorCode() == 22) {
                    l.showToast(SpecialLiveFragment.this.mContext, (int) R.string.had_liked_forum);
                } else if (AntiHelper.aH(SpecialLiveFragment.this.csF.getErrorCode(), SpecialLiveFragment.this.csF.getErrorString())) {
                    AntiHelper.aS(SpecialLiveFragment.this.mContext, SpecialLiveFragment.this.csF.getErrorString());
                } else if (SpecialLiveFragment.this.csF.getErrorCode() != 0) {
                    l.showToast(SpecialLiveFragment.this.mContext, SpecialLiveFragment.this.csF.getErrorString());
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
        aJY();
        aJW();
        if (!this.dBE) {
            aJZ();
            if (this.cig != null && this.cig.getChildCount() > 1) {
                this.cig.setCurrentItem(1);
            }
            if (!v.isEmpty(this.mData.tabInfoList)) {
                this.dBE = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(int i, String str) {
        if (TextUtils.isEmpty(str)) {
            showNetRefreshView(this.mRootView, this.mContext.getResources().getString(R.string.square_load_data_failed_tip), false);
        } else {
            showNetRefreshView(this.mRootView, str, false);
        }
    }

    private void aJW() {
        if (this.mData.dCf) {
            if (aJX()) {
                this.mCurState = 3;
            } else {
                this.mCurState = 2;
            }
        } else {
            this.mCurState = 1;
        }
        gG(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aJX() {
        return this.mData.dCh.dCn;
    }

    private void aJY() {
        boolean c = this.dBw.c(this.mData.dCd);
        if (c) {
            this.dBw.stopPlay();
            this.dBw.onDestroy();
        }
        this.dBw.a(this.mData.dCd, c);
        if (c) {
            this.dBw.J(this.dBj);
        }
        this.dBw.startPlay();
    }

    private void aJZ() {
        aKa();
        this.dBu.setData(this.dBy);
        this.dBv.setData(this.dBz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(int i, float f) {
        if (this.dBw != null && f != 0.0f) {
            if (this.dBB <= i) {
                if (this.dBD && f >= 0.3f) {
                    this.dBw.gA(true);
                    this.dBw.pause();
                    this.dBD = false;
                }
            } else if (!this.dBD && f <= 0.3f) {
                this.dBw.gA(false);
                this.dBw.resume();
                this.dBD = true;
            }
            this.dBB = i;
        }
    }

    private void vz() {
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds88);
        if (UtilHelper.canUseStyleImmersiveSticky() && this.mStatusBarView.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.mStatusBarView.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.mStatusBarView.setLayoutParams(layoutParams);
            this.mStatusBarView.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.dBr.getLayoutParams();
            layoutParams2.height = layoutParams.height;
            this.dBr.setLayoutParams(layoutParams2);
            dimensionPixelSize = layoutParams.height + dimensionPixelSize;
        } else {
            this.mStatusBarView.setVisibility(8);
        }
        CollapsingToolbarLayout.LayoutParams layoutParams3 = (CollapsingToolbarLayout.LayoutParams) this.dBp.getLayoutParams();
        layoutParams3.height = dimensionPixelSize;
        this.dBp.setLayoutParams(layoutParams3);
    }

    private void aKa() {
        this.dBy.clear();
        this.dBz.clear();
        this.dBy.add(aKd());
        this.dBy.add(aKe());
        this.dBz.add(aKb());
        this.dBz.add(aKc());
        if (!v.isEmpty(this.mData.tabInfoList)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mData.tabInfoList.size() && i2 < 10) {
                    SpecialLiveTabInfo specialLiveTabInfo = this.mData.tabInfoList.get(i2);
                    if (specialLiveTabInfo != null) {
                        this.dBz.add(specialLiveTabInfo);
                        TabData tabData = new TabData();
                        tabData.tabId = specialLiveTabInfo.tabId;
                        tabData.tabName = specialLiveTabInfo.tabName;
                        tabData.tabType = specialLiveTabInfo.tabType;
                        this.dBy.add(tabData);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private SpecialLiveTabInfo aKb() {
        SpecialLiveTabInfo specialLiveTabInfo = new SpecialLiveTabInfo();
        specialLiveTabInfo.tabId = -901;
        specialLiveTabInfo.tabName = this.mContext.getResources().getString(R.string.special_concern_tab_title);
        return specialLiveTabInfo;
    }

    private SpecialLiveTabInfo aKc() {
        SpecialLiveTabInfo specialLiveTabInfo = new SpecialLiveTabInfo();
        specialLiveTabInfo.tabId = -903;
        specialLiveTabInfo.tabName = this.mContext.getResources().getString(R.string.special_recommend_tab_title);
        return specialLiveTabInfo;
    }

    private TabData aKd() {
        TabData tabData = new TabData();
        tabData.tabId = -901;
        tabData.tabName = this.mContext.getResources().getString(R.string.special_concern_tab_title);
        return tabData;
    }

    private TabData aKe() {
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
            if (this.dBw != null) {
                if (isPrimary()) {
                    this.dBw.gA(false);
                    this.dBw.startPlay();
                    return;
                }
                this.dBw.gA(true);
                this.dBw.pause();
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
        if (this.dBw != null) {
            this.dBw.gA(true);
            this.dBw.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dBw != null) {
            this.dBw.onChangeSkinType(i);
        }
        if (this.dBu != null) {
            am.setBackgroundResource(this.dBu, R.color.cp_bg_line_d);
            this.dBu.onChangeSkinType(i);
        }
        if (this.dBv != null) {
            this.dBv.onChangeSkinType(i);
        }
        gH(false);
        am.setBackgroundColor(this.mStatusBarView, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.dBq, R.color.cp_bg_line_d);
        am.setViewTextColor(this.dBs, (int) R.color.cp_cont_b);
        am.setBackgroundColor(this.dBk, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.dBl, R.color.cp_bg_line_e);
        am.setViewTextColor(this.dBm, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.dBo, (int) R.color.cp_cont_j);
        am.setViewTextColor(this.dBn, (int) R.color.cp_cont_g);
        am.setBackgroundResource(this.dBn, R.drawable.frs_attention_btn_bg_selector);
        am.setBackgroundResource(this.dBi, R.color.cp_bg_line_c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gG(boolean z) {
        Drawable drawable;
        int i = R.drawable.frs_attention_btn_bg_selector;
        am.setBackgroundResource(this.dBn, R.drawable.frs_attention_btn_bg_selector);
        int dimens = l.getDimens(this.mContext, R.dimen.ds10);
        String string = this.mContext.getResources().getString(R.string.attention);
        int i2 = R.color.cp_cont_a;
        if (this.mCurState == 1) {
            drawable = am.getDrawable(R.drawable.icon_add_follow_blue_s);
            this.dBn.setClickable(true);
            if (!z) {
                TiebaStatic.log(new an("c12889"));
            }
        } else if (this.mCurState == 2) {
            string = this.mContext.getResources().getString(R.string.sign);
            drawable = am.getDrawable(R.drawable.icon_public_sign_blue_s);
            this.dBn.setClickable(true);
            if (!z) {
                TiebaStatic.log(new an("c12891"));
            }
        } else if (this.mCurState == 3) {
            string = this.mContext.getResources().getString(R.string.signed);
            this.dBn.setClickable(false);
            i = R.drawable.special_sign_btn_signed_bg;
            i2 = R.color.cp_cont_d;
            drawable = null;
        } else {
            drawable = null;
        }
        am.setBackgroundResource(this.dBn, i);
        am.setViewTextColor(this.dBn, i2);
        this.dBn.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.dBn.setCompoundDrawablePadding(dimens);
        this.dBn.setText(string);
        aKf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gH(boolean z) {
        if (this.dBt != null) {
            if (z) {
                am.setNavbarIconSrc(this.dBt, R.drawable.selector_topbar_return_black, R.drawable.selector_topbar_return_black, TbadkCoreApplication.getInst().getSkinType());
            } else {
                am.setNavbarIconSrc(this.dBt, R.drawable.selector_topbar_return_white, R.drawable.selector_topbar_return_white, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    private void aKf() {
        if (this.mData != null && this.mData.dCg != null && this.mCurState != 1) {
            int i = this.mData.dCg.level_id;
            String str = TextUtils.isEmpty(this.mData.dCg.level_name) ? "" : HanziToPinyin.Token.SEPARATOR + this.mData.dCg.level_name;
            if (i >= 0) {
                this.dBo.setText("LV" + i + str);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dBw != null) {
            this.dBw.onDestroy();
        }
        if (this.dBI != null) {
            MessageManager.getInstance().unRegisterListener(this.dBI);
        }
        if (this.dBA != null) {
            MessageManager.getInstance().unRegisterListener(this.dBA);
        }
        if (this.dBJ != null) {
            MessageManager.getInstance().unRegisterListener(this.dBJ);
        }
        if (this.dBK != null) {
            MessageManager.getInstance().unRegisterListener(this.dBK);
        }
        if (this.dBH != null) {
            MessageManager.getInstance().unRegisterListener(this.dBH);
        }
        if (this.mAccountChangedListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mAccountChangedListener);
        }
        if (this.dBx != null) {
            this.dBx.onDestroy();
        }
        if (this.dwT != null) {
            this.dwT.onDestroy();
        }
        AlaLiveUserNotifyManager.getInstance().removeNotifyListener(this.dwU);
        hideLoadingView(this.mRootView);
        MessageManager.getInstance().unRegisterListener(this.bWw);
    }

    private void initViewPager() {
        this.dBv = new a(getChildFragmentManager());
        this.cig.setAdapter(this.dBv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a extends FragmentPagerAdapter {
        private SparseArray<SpecialForumTabBaseFragment> dBO;
        private List<SpecialLiveTabInfo> mData;

        public a(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.mData = new ArrayList();
            this.dBO = new SparseArray<>();
            this.dBO.put(0, ConcernTabFragment.mm(0));
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
            SpecialForumTabBaseFragment mk = mk(i);
            if (mk == null) {
                if (i == 0) {
                    mk = ConcernTabFragment.mm(0);
                } else if (i == 1) {
                    mk = RecommendTabFragment.mn(1);
                } else {
                    mk = OtherSubTabFragment.a(i, this.mData.get(i));
                }
                this.dBO.put(i, mk);
            }
            return mk;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.mData.size();
        }

        public SpecialForumTabBaseFragment mk(int i) {
            if (i < this.dBO.size()) {
                return this.dBO.get(i);
            }
            return null;
        }

        public void a(int i, TabData tabData) {
            if (i < this.dBO.size()) {
                this.dBO.get(i).setPrimary(true);
            }
        }

        public void onChangeSkinType(int i) {
            if (this.dBO != null && this.dBO.size() > 0) {
                int size = this.dBO.size();
                for (int i2 = 0; i2 < size; i2++) {
                    SpecialForumTabBaseFragment specialForumTabBaseFragment = this.dBO.get(i2);
                    if (specialForumTabBaseFragment != null) {
                        specialForumTabBaseFragment.onChangeSkinType(i);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab(final Activity activity) {
        if (activity != null && !AlaSharedPrefHelper.getInstance().getBoolean(AlaSharedPrefConfig.SQUARE_GUIDE_MARK_MANAGE_TIP_SHOW, false)) {
            if (this.dBF != null) {
                this.dBF.dismiss();
            }
            final Handler handler = new Handler();
            final Runnable runnable = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.10
                @Override // java.lang.Runnable
                public void run() {
                    if (SpecialLiveFragment.this.dBF != null) {
                        SpecialLiveFragment.this.dBF.dismiss();
                    }
                }
            };
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.A(true);
            dVar.b(new d.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.11
                @Override // com.baidu.adp.lib.guide.d.a
                public void onShown() {
                }

                @Override // com.baidu.adp.lib.guide.d.a
                public void onDismiss() {
                    AlaSharedPrefHelper.getInstance().putBoolean(AlaSharedPrefConfig.SQUARE_GUIDE_MARK_MANAGE_TIP_SHOW, true);
                    SpecialLiveFragment.this.dBF = null;
                    handler.removeCallbacks(runnable);
                }
            });
            dVar.y(activity.getWindow().getDecorView().findViewById(R.id.tabcontainer)).I(20).B(false);
            dVar.a(new b() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.13
                @Override // com.baidu.adp.lib.guide.b
                public View getView(LayoutInflater layoutInflater) {
                    BubbleLayout bubbleLayout = (BubbleLayout) View.inflate(activity, R.layout.square_guide_tip_layout, null);
                    TextView textView = (TextView) bubbleLayout.findViewById(R.id.square_guide_tv);
                    textView.setText(activity.getResources().getString(R.string.square_guide_mark_manage_tip_text));
                    textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.13.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            AlaSharedPrefHelper.getInstance().putBoolean(AlaSharedPrefConfig.SQUARE_GUIDE_MARK_MANAGE_TIP_SHOW, true);
                            SpecialLiveFragment.this.dBF.dismiss();
                        }
                    });
                    am.setViewTextColor(textView, (int) R.color.cp_cont_i);
                    bubbleLayout.Bp(am.getColor(R.color.cp_link_tip_a_alpha95));
                    bubbleLayout.aA(activity.getResources().getDimensionPixelSize(R.dimen.ds216));
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
            this.dBF = dVar.fu();
            this.dBF.show(activity);
            handler.postDelayed(runnable, 5000L);
        }
    }
}
