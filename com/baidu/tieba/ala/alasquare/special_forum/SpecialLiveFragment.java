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
import com.baidu.tieba.tbadkCore.w;
import com.baidu.tieba.view.bubbleView.BubbleLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class SpecialLiveFragment extends BaseFragment {
    private AppBarLayout Zj;
    private CustomViewPager eRw;
    private LikeModel fgf;
    private List<SpecialLiveTabInfo> ftl;
    private AlaLiveUserNotifyController grs;
    private AlaLiveUserNotifyManager.AlaLiveNotifyListener grt;
    private ScrollHorizontalTabView guJ;
    private float gwL;
    private CollapsingToolbarLayout gwM;
    private View gwN;
    private ObservedChangeFrameLayout gwO;
    private RelativeLayout gwP;
    private View gwQ;
    private TextView gwR;
    private TextView gwS;
    private TextView gwT;
    private RelativeLayout gwU;
    private View gwV;
    private View gwW;
    private TextView gwX;
    private ImageView gwY;
    private a gwZ;
    private e gxa;
    private com.baidu.tieba.ala.alasquare.special_forum.model.a gxb;
    private List<TabData> gxc;
    private CustomMessageListener gxd;
    private int gxe;
    private String gxf;
    private c gxi;
    private BdUniqueId mBdUniqueId;
    private Context mContext;
    private h mData;
    private String mForumId;
    private String mForumName;
    private View mRootView;
    private View mStatusBarView;
    private boolean gxg = true;
    private int mCurState = 1;
    private boolean gxh = false;
    private Handler mHandler = new Handler();
    private Runnable gxj = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.1
        @Override // java.lang.Runnable
        public void run() {
            if (SpecialLiveFragment.this.gxa != null) {
                SpecialLiveFragment.this.gxa.bTd();
            }
        }
    };
    private CustomMessageListener eDt = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            SpecialLiveFragment.this.mHandler.removeCallbacks(SpecialLiveFragment.this.gxj);
            SpecialLiveFragment.this.mHandler.postDelayed(SpecialLiveFragment.this.gxj, 500L);
        }
    };
    private CustomMessageListener gxk = new CustomMessageListener(CmdConfigCustom.CMD_FORCE_REFRESH) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2) {
                    if ("FrsLiveLive".equals(split[0])) {
                        SpecialLiveFragment.this.mk(false);
                    }
                    SpecialForumTabBaseFragment vd = SpecialLiveFragment.this.gwZ.vd(SpecialLiveFragment.this.eRw.getCurrentItem());
                    if (vd != null) {
                        vd.bTa();
                    }
                }
            }
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && SpecialLiveFragment.this.gxb != null && !TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                SpecialLiveFragment.this.mk(false);
            }
        }
    };
    private final CustomMessageListener gxl = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            w wVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof w) && (wVar = (w) customResponsedMessage.getData()) != null && SpecialLiveFragment.this.mForumId.equals(wVar.getFid())) {
                if (wVar.isLike() == 1) {
                    if (SpecialLiveFragment.this.bSQ()) {
                        SpecialLiveFragment.this.mCurState = 3;
                    } else {
                        SpecialLiveFragment.this.mCurState = 2;
                    }
                } else {
                    SpecialLiveFragment.this.mCurState = 1;
                }
                SpecialLiveFragment.this.ml(false);
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
                SpecialLiveFragment.this.ml(false);
                l.showToast(SpecialLiveFragment.this.getPageContext().getPageActivity(), SpecialLiveFragment.this.mContext.getString(R.string.special_sign_success_tip, Integer.valueOf(signData.sign_bonus_point)));
            }
        }
    };
    private final CustomMessageListener gxm = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_SPECIAL_CONCERN_TAB_TAB_ICON) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                Boolean bool = (Boolean) customResponsedMessage.getData();
                if (!y.isEmpty(SpecialLiveFragment.this.gxc)) {
                    ((TabData) SpecialLiveFragment.this.gxc.get(0)).extra = bool;
                    SpecialLiveFragment.this.guJ.setData(SpecialLiveFragment.this.gxc);
                    if (bool.booleanValue()) {
                        TiebaStatic.log("c12898");
                    }
                }
            }
        }
    };

    public static SpecialLiveFragment eq(String str, String str2) {
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
                this.gxf = sb.toString();
            } else {
                this.mForumName = this.mContext.getResources().getString(R.string.ala_ufan_bar_title);
                this.gxf = this.mForumName + string2;
            }
            bSO();
            bSM();
            bSN();
            MessageManager.getInstance().registerListener(this.gxd);
            MessageManager.getInstance().registerListener(this.gxl);
            MessageManager.getInstance().registerListener(this.mSignChangedListener);
            MessageManager.getInstance().registerListener(this.gxm);
            MessageManager.getInstance().registerListener(this.gxk);
            MessageManager.getInstance().registerListener(this.mAccountChangedListener);
            MessageManager.getInstance().registerListener(this.eDt);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(R.layout.special_live_layout, (ViewGroup) null);
        this.Zj = (AppBarLayout) this.mRootView.findViewById(R.id.special_app_bar_layout);
        this.gwM = (CollapsingToolbarLayout) this.mRootView.findViewById(R.id.special_collapse_layout);
        this.mStatusBarView = this.mRootView.findViewById(R.id.statusbar_view);
        this.gwO = (ObservedChangeFrameLayout) this.mRootView.findViewById(R.id.live_container);
        this.mBdUniqueId = BdUniqueId.gen();
        this.gwP = (RelativeLayout) this.mRootView.findViewById(R.id.function_container);
        this.gwQ = this.mRootView.findViewById(R.id.function_bottom_space);
        this.gwR = (TextView) this.mRootView.findViewById(R.id.function_title);
        this.gwR.setText(this.gxf);
        this.gwS = (TextView) this.mRootView.findViewById(R.id.function_btn);
        this.gwS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.19
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
                    SpecialLiveFragment.this.gwS.setClickable(false);
                    SpecialLiveFragment.this.fgf.gu(SpecialLiveFragment.this.mForumName, SpecialLiveFragment.this.mForumId);
                    TiebaStatic.log(new ar("c12890"));
                } else if (SpecialLiveFragment.this.mCurState == 2) {
                    SpecialLiveFragment.this.gwS.setClickable(false);
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
        this.gwT = (TextView) this.mRootView.findViewById(R.id.function_level_desc);
        this.gwU = (RelativeLayout) this.mRootView.findViewById(R.id.navigation_layout);
        this.gwW = this.mRootView.findViewById(R.id.navigation_top_space);
        this.gwV = this.mRootView.findViewById(R.id.navigation_bg);
        this.gwX = (TextView) this.mRootView.findViewById(R.id.navigation_title);
        this.gwX.setText(this.gxf);
        this.gwY = (ImageView) this.mRootView.findViewById(R.id.navigation_back_img);
        this.gwY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, SpecialLiveFragment.this.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        });
        this.guJ = (ScrollHorizontalTabView) this.mRootView.findViewById(R.id.scroll_tab_view);
        this.eRw = (CustomViewPager) this.mRootView.findViewById(R.id.special_view_pager);
        initViewPager();
        this.guJ.setViewPager(this.eRw);
        this.guJ.setScrollTabPageListener(new ScrollHorizontalTabView.ScrollTabPageListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.2
            @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
            public boolean onPrePageSelect(int i, TabData tabData) {
                return true;
            }

            @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
            public void onPageSelected(int i, TabData tabData) {
                if (i != 0 || TbadkCoreApplication.isLogin()) {
                    if (SpecialLiveFragment.this.gwZ != null) {
                        SpecialLiveFragment.this.gwZ.a(i, tabData);
                        return;
                    }
                    return;
                }
                bh.skipToLoginActivity(SpecialLiveFragment.this.getPageContext().getPageActivity());
                if (SpecialLiveFragment.this.eRw != null) {
                    SpecialLiveFragment.this.eRw.setCurrentItem(1);
                }
            }

            @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
            public void onPageScrolled(int i, float f, int i2) {
            }
        });
        this.Zj.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.3
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                int abs = Math.abs(i);
                if (abs == 0) {
                    SpecialLiveFragment.this.gwV.setVisibility(8);
                    SpecialLiveFragment.this.gwX.setVisibility(8);
                } else {
                    SpecialLiveFragment.this.gwV.setVisibility(0);
                    SpecialLiveFragment.this.gwX.setVisibility(0);
                }
                SpecialLiveFragment.this.mm(((float) abs) > SpecialLiveFragment.this.gwL / 2.0f);
                float abs2 = Math.abs(abs / SpecialLiveFragment.this.gwL);
                SpecialLiveFragment.this.gwV.setAlpha(abs2);
                SpecialLiveFragment.this.gwX.setAlpha(abs2);
                SpecialLiveFragment.this.g(abs, abs2);
            }
        });
        this.gwN = this.mRootView.findViewById(R.id.square_main_top_divider_line);
        this.gwO.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.4
            @Override // com.baidu.tbadk.widget.layout.e
            public void d(View view, int i, int i2, int i3, int i4) {
                SpecialLiveFragment.this.gwL = (SpecialLiveFragment.this.gwO.getMeasuredHeight() + SpecialLiveFragment.this.gwP.getMeasuredHeight()) - SpecialLiveFragment.this.gwU.getMeasuredHeight();
                SpecialLiveFragment.this.gwM.setMinimumHeight(SpecialLiveFragment.this.gwU.getMeasuredHeight());
            }
        });
        Vq();
        this.gxc = new ArrayList();
        this.ftl = new ArrayList();
        this.gxa = new e(getPageContext());
        this.gxb = new com.baidu.tieba.ala.alasquare.special_forum.model.a(getPageContext(), new a.InterfaceC0645a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.5
            @Override // com.baidu.tieba.ala.alasquare.special_forum.model.a.InterfaceC0645a
            public void b(h hVar) {
                SpecialLiveFragment.this.hideLoadingView(SpecialLiveFragment.this.mRootView);
                SpecialLiveFragment.this.a(hVar);
            }

            @Override // com.baidu.tieba.ala.alasquare.special_forum.model.a.InterfaceC0645a
            public void t(int i, String str) {
                SpecialLiveFragment.this.aR(i, str);
            }
        });
        ml(true);
        mk(true);
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
    public void mk(boolean z) {
        if (!this.gxb.isLoading()) {
            if (z) {
                showLoadingView(this.mRootView);
            }
            this.gxb.loadData();
        }
    }

    private void bSM() {
        this.grs = new AlaLiveUserNotifyController(getPageContext());
        this.grt = new AlaLiveUserNotifyManager.AlaLiveNotifyListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.7
            @Override // com.baidu.ala.notify.AlaLiveUserNotifyManager.AlaLiveNotifyListener
            public void onCallBack() {
                if (SpecialLiveFragment.this.isPrimary()) {
                    SpecialLiveFragment.this.grs.showNextNotifyDialog(0, AlaLiveUserNotifyManager.getInstance().getNotifyDataList());
                }
            }
        };
        AlaLiveUserNotifyManager.getInstance().addNotifyListener(this.grt);
    }

    private void bSN() {
        this.gxd = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_MODEL_TASK) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z;
                SignData signData = null;
                SpecialLiveFragment.this.gwS.setClickable(true);
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
                            AntiHelper.bn(SpecialLiveFragment.this.mContext, signMessage.mSignErrorString);
                            return;
                        } else {
                            l.showToast(SpecialLiveFragment.this.mContext, SpecialLiveFragment.this.mContext.getString(R.string.special_sign_success_tip, Integer.valueOf(signData.sign_bonus_point)));
                            return;
                        }
                    }
                    if (signMessage.mSignErrorCode == 160002) {
                        SpecialLiveFragment.this.mCurState = 3;
                        SpecialLiveFragment.this.ml(false);
                    }
                    l.showToast(SpecialLiveFragment.this.mContext, signMessage.mSignErrorString);
                }
            }
        };
    }

    private void bSO() {
        this.fgf = new LikeModel(getPageContext());
        this.fgf.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.9
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                SpecialLiveFragment.this.gwS.setClickable(true);
                if (SpecialLiveFragment.this.fgf.getErrorCode() == 22) {
                    l.showToast(SpecialLiveFragment.this.mContext, (int) R.string.had_liked_forum);
                } else if (AntiHelper.bP(SpecialLiveFragment.this.fgf.getErrorCode(), SpecialLiveFragment.this.fgf.getErrorString())) {
                    AntiHelper.bn(SpecialLiveFragment.this.mContext, SpecialLiveFragment.this.fgf.getErrorString());
                } else if (SpecialLiveFragment.this.fgf.getErrorCode() != 0) {
                    l.showToast(SpecialLiveFragment.this.mContext, SpecialLiveFragment.this.fgf.getErrorString());
                } else {
                    w wVar = (w) obj;
                    if (wVar != null) {
                        TbadkCoreApplication.getInst().addLikeForum(SpecialLiveFragment.this.mForumName);
                        wVar.setLike(1);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, wVar));
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
        this.Zj.setVisibility(0);
        this.mData = hVar;
        bSR();
        bSP();
        if (!this.gxh) {
            bSS();
            if (this.eRw != null && this.eRw.getChildCount() > 1) {
                this.eRw.setCurrentItem(1);
            }
            if (!y.isEmpty(this.mData.tabInfoList)) {
                this.gxh = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aR(int i, String str) {
        hideLoadingView(this.mRootView);
        this.Zj.setVisibility(8);
        if (TextUtils.isEmpty(str)) {
            showNetRefreshView(this.mRootView, this.mContext.getResources().getString(R.string.square_load_data_failed_tip), true);
        } else {
            showNetRefreshView(this.mRootView, str, true);
        }
    }

    private void bSP() {
        if (this.mData.gxI) {
            if (bSQ()) {
                this.mCurState = 3;
            } else {
                this.mCurState = 2;
            }
        } else {
            this.mCurState = 1;
        }
        ml(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bSQ() {
        return this.mData.gxK.gxQ;
    }

    private void bSR() {
        boolean c = this.gxa.c(this.mData.gxG);
        if (c) {
            this.gxa.stopPlay();
            this.gxa.onDestroy();
        }
        this.gxa.a(this.mData.gxG, c);
        if (c) {
            this.gxa.Z(this.gwO);
        }
        this.gxa.startPlay();
    }

    private void bSS() {
        bST();
        this.guJ.setData(this.gxc);
        this.gwZ.setData(this.ftl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(int i, float f) {
        if (this.gxa != null && f != 0.0f) {
            if (this.gxe <= i) {
                if (this.gxg && f >= 0.3f) {
                    this.gxa.lX(true);
                    this.gxa.pause();
                    this.gxg = false;
                }
            } else if (!this.gxg && f <= 0.3f) {
                this.gxa.lX(false);
                this.gxa.resume();
                this.gxg = true;
            }
            this.gxe = i;
        }
    }

    private void Vq() {
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds88);
        if (UtilHelper.canUseStyleImmersiveSticky() && this.mStatusBarView.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.mStatusBarView.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.mStatusBarView.setLayoutParams(layoutParams);
            this.mStatusBarView.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gwW.getLayoutParams();
            layoutParams2.height = layoutParams.height;
            this.gwW.setLayoutParams(layoutParams2);
            dimensionPixelSize = layoutParams.height + dimensionPixelSize;
        } else {
            this.mStatusBarView.setVisibility(8);
        }
        CollapsingToolbarLayout.LayoutParams layoutParams3 = (CollapsingToolbarLayout.LayoutParams) this.gwU.getLayoutParams();
        layoutParams3.height = dimensionPixelSize;
        this.gwU.setLayoutParams(layoutParams3);
    }

    private void bST() {
        this.gxc.clear();
        this.ftl.clear();
        this.gxc.add(bSW());
        this.gxc.add(bSX());
        this.ftl.add(bSU());
        this.ftl.add(bSV());
        if (!y.isEmpty(this.mData.tabInfoList)) {
            boolean z = b.bsO().getInt("chushou_game_tab", 1) == 1;
            for (int i = 0; i < this.mData.tabInfoList.size() && i < 10; i++) {
                SpecialLiveTabInfo specialLiveTabInfo = this.mData.tabInfoList.get(i);
                if (specialLiveTabInfo != null && (specialLiveTabInfo.tabId != 1108 || z)) {
                    this.ftl.add(specialLiveTabInfo);
                    TabData tabData = new TabData();
                    tabData.tabId = specialLiveTabInfo.tabId;
                    tabData.tabName = specialLiveTabInfo.tabName;
                    tabData.tabType = specialLiveTabInfo.tabType;
                    this.gxc.add(tabData);
                }
            }
        }
    }

    private SpecialLiveTabInfo bSU() {
        SpecialLiveTabInfo specialLiveTabInfo = new SpecialLiveTabInfo();
        specialLiveTabInfo.tabId = -901;
        specialLiveTabInfo.tabName = this.mContext.getResources().getString(R.string.special_concern_tab_title);
        return specialLiveTabInfo;
    }

    private SpecialLiveTabInfo bSV() {
        SpecialLiveTabInfo specialLiveTabInfo = new SpecialLiveTabInfo();
        specialLiveTabInfo.tabId = -903;
        specialLiveTabInfo.tabName = this.mContext.getResources().getString(R.string.special_recommend_tab_title);
        return specialLiveTabInfo;
    }

    private TabData bSW() {
        TabData tabData = new TabData();
        tabData.tabId = -901;
        tabData.tabName = this.mContext.getResources().getString(R.string.special_concern_tab_title);
        return tabData;
    }

    private TabData bSX() {
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
                mk(false);
                AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
            }
            if (this.gxa != null) {
                if (isPrimary()) {
                    this.gxa.lX(false);
                    this.gxa.startPlay();
                    return;
                }
                this.gxa.lX(true);
                this.gxa.pause();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        hideNetRefreshView(this.mRootView);
        mk(true);
        AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.gxa != null) {
            this.gxa.lX(true);
            this.gxa.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gxa != null) {
            this.gxa.onChangeSkinType(i);
        }
        if (this.guJ != null) {
            ap.setBackgroundResource(this.guJ, R.color.CAM_X0201);
            this.guJ.onChangeSkinType(i);
        }
        if (this.gwZ != null) {
            this.gwZ.onChangeSkinType(i);
        }
        mm(false);
        ap.setBackgroundColor(this.mStatusBarView, R.color.CAM_X0201);
        ap.setBackgroundColor(this.gwV, R.color.CAM_X0201);
        ap.setViewTextColor(this.gwX, (int) R.color.CAM_X0105);
        ap.setBackgroundColor(this.gwP, R.color.CAM_X0201);
        ap.setBackgroundColor(this.gwQ, R.color.CAM_X0205);
        ap.setViewTextColor(this.gwR, (int) R.color.CAM_X0105);
        ap.setViewTextColor(this.gwT, (int) R.color.CAM_X0107);
        ap.setViewTextColor(this.gwS, (int) R.color.CAM_X0111);
        ap.setBackgroundResource(this.gwS, R.drawable.frs_attention_btn_bg_selector);
        ap.setBackgroundResource(this.gwN, R.color.CAM_X0204);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ml(boolean z) {
        Drawable drawable;
        int i = R.drawable.frs_attention_btn_bg_selector;
        ap.setBackgroundResource(this.gwS, R.drawable.frs_attention_btn_bg_selector);
        int dimens = l.getDimens(this.mContext, R.dimen.ds10);
        String string = this.mContext.getResources().getString(R.string.attention);
        int i2 = R.color.CAM_X0101;
        if (this.mCurState == 1) {
            drawable = ap.getDrawable(R.drawable.icon_add_follow_blue_s);
            this.gwS.setClickable(true);
            if (!z) {
                TiebaStatic.log(new ar("c12889"));
            }
        } else if (this.mCurState == 2) {
            string = this.mContext.getResources().getString(R.string.sign);
            drawable = ap.getDrawable(R.drawable.icon_public_sign_blue_s);
            this.gwS.setClickable(true);
            if (!z) {
                TiebaStatic.log(new ar("c12891"));
            }
        } else if (this.mCurState == 3) {
            string = this.mContext.getResources().getString(R.string.signed);
            this.gwS.setClickable(false);
            i = R.drawable.special_sign_btn_signed_bg;
            i2 = R.color.CAM_X0109;
            drawable = null;
        } else {
            drawable = null;
        }
        ap.setBackgroundResource(this.gwS, i);
        ap.setViewTextColor(this.gwS, i2);
        this.gwS.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.gwS.setCompoundDrawablePadding(dimens);
        this.gwS.setText(string);
        bSY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mm(boolean z) {
        if (this.gwY != null) {
            if (z) {
                ap.setNavbarIconSrc(this.gwY, R.drawable.selector_topbar_return_black, R.drawable.selector_topbar_return_black, TbadkCoreApplication.getInst().getSkinType());
            } else {
                ap.setNavbarIconSrc(this.gwY, R.drawable.selector_topbar_return_white, R.drawable.selector_topbar_return_white, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    private void bSY() {
        if (this.mData != null && this.mData.gxJ != null && this.mCurState != 1) {
            int i = this.mData.gxJ.level_id;
            String str = TextUtils.isEmpty(this.mData.gxJ.level_name) ? "" : " " + this.mData.gxJ.level_name;
            if (i >= 0) {
                this.gwT.setText("LV" + i + str);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.gxa != null) {
            this.gxa.onDestroy();
        }
        if (this.gxl != null) {
            MessageManager.getInstance().unRegisterListener(this.gxl);
        }
        if (this.gxd != null) {
            MessageManager.getInstance().unRegisterListener(this.gxd);
        }
        if (this.mSignChangedListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mSignChangedListener);
        }
        if (this.gxm != null) {
            MessageManager.getInstance().unRegisterListener(this.gxm);
        }
        if (this.gxk != null) {
            MessageManager.getInstance().unRegisterListener(this.gxk);
        }
        if (this.mAccountChangedListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mAccountChangedListener);
        }
        if (this.gxb != null) {
            this.gxb.onDestroy();
        }
        if (this.grs != null) {
            this.grs.onDestroy();
        }
        AlaLiveUserNotifyManager.getInstance().removeNotifyListener(this.grt);
        hideLoadingView(this.mRootView);
        MessageManager.getInstance().unRegisterListener(this.eDt);
    }

    private void initViewPager() {
        this.gwZ = new a(getChildFragmentManager());
        this.eRw.setAdapter(this.gwZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a extends FragmentPagerAdapter {
        private SparseArray<SpecialForumTabBaseFragment> gxp;
        private List<SpecialLiveTabInfo> mData;

        public a(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.mData = new ArrayList();
            this.gxp = new SparseArray<>();
            this.gxp.put(0, ConcernTabFragment.vf(0));
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
            SpecialForumTabBaseFragment vd = vd(i);
            if (vd == null) {
                if (i == 0) {
                    vd = ConcernTabFragment.vf(0);
                } else if (i == 1) {
                    vd = RecommendTabFragment.vg(1);
                } else if (i < this.mData.size() && this.mData.get(i) != null && this.mData.get(i).tabId == 1108) {
                    vd = GameTabFragment.GO(this.mData.get(i).tabName);
                } else {
                    vd = OtherSubTabFragment.a(i, this.mData.get(i));
                }
                this.gxp.put(i, vd);
            }
            return vd;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.mData.size();
        }

        public SpecialForumTabBaseFragment vd(int i) {
            return this.gxp.get(i);
        }

        public void a(int i, TabData tabData) {
            if (this.gxp.get(i) != null) {
                this.gxp.get(i).setPrimary(true);
            }
        }

        public void onChangeSkinType(int i) {
            if (this.gxp != null && this.gxp.size() > 0) {
                int size = this.gxp.size();
                for (int i2 = 0; i2 < size; i2++) {
                    SpecialForumTabBaseFragment specialForumTabBaseFragment = this.gxp.get(i2);
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
            if (this.gxi != null) {
                this.gxi.dismiss();
            }
            final Handler handler = new Handler();
            final Runnable runnable = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.10
                @Override // java.lang.Runnable
                public void run() {
                    if (SpecialLiveFragment.this.gxi != null) {
                        SpecialLiveFragment.this.gxi.dismiss();
                    }
                }
            };
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.ac(true);
            dVar.b(new d.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.11
                @Override // com.baidu.adp.lib.guide.d.a
                public void onShown() {
                }

                @Override // com.baidu.adp.lib.guide.d.a
                public void onDismiss() {
                    AlaSharedPrefHelper.getInstance().putBoolean(AlaSharedPrefConfig.SQUARE_GUIDE_MARK_MANAGE_TIP_SHOW, true);
                    SpecialLiveFragment.this.gxi = null;
                    handler.removeCallbacks(runnable);
                }
            });
            dVar.y(activity.getWindow().getDecorView().findViewById(R.id.tabcontainer)).an(20).ad(false);
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
                            SpecialLiveFragment.this.gxi.dismiss();
                        }
                    });
                    ap.setViewTextColor(textView, (int) R.color.CAM_X0112);
                    bubbleLayout.MA(ap.getColor(R.color.cp_link_tip_a_alpha95));
                    bubbleLayout.aZ(activity.getResources().getDimensionPixelSize(R.dimen.ds216));
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
            this.gxi = dVar.mi();
            this.gxi.show(activity);
            handler.postDelayed(runnable, 5000L);
        }
    }
}
