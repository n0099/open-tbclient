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
    private AlaLiveUserNotifyController grq;
    private AlaLiveUserNotifyManager.AlaLiveNotifyListener grr;
    private ScrollHorizontalTabView guH;
    private float gwJ;
    private CollapsingToolbarLayout gwK;
    private View gwL;
    private ObservedChangeFrameLayout gwM;
    private RelativeLayout gwN;
    private View gwO;
    private TextView gwP;
    private TextView gwQ;
    private TextView gwR;
    private RelativeLayout gwS;
    private View gwT;
    private View gwU;
    private TextView gwV;
    private ImageView gwW;
    private a gwX;
    private e gwY;
    private com.baidu.tieba.ala.alasquare.special_forum.model.a gwZ;
    private List<TabData> gxa;
    private CustomMessageListener gxb;
    private int gxc;
    private String gxd;
    private c gxg;
    private BdUniqueId mBdUniqueId;
    private Context mContext;
    private h mData;
    private String mForumId;
    private String mForumName;
    private View mRootView;
    private View mStatusBarView;
    private boolean gxe = true;
    private int mCurState = 1;
    private boolean gxf = false;
    private Handler mHandler = new Handler();
    private Runnable gxh = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.1
        @Override // java.lang.Runnable
        public void run() {
            if (SpecialLiveFragment.this.gwY != null) {
                SpecialLiveFragment.this.gwY.bTc();
            }
        }
    };
    private CustomMessageListener eDt = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            SpecialLiveFragment.this.mHandler.removeCallbacks(SpecialLiveFragment.this.gxh);
            SpecialLiveFragment.this.mHandler.postDelayed(SpecialLiveFragment.this.gxh, 500L);
        }
    };
    private CustomMessageListener gxi = new CustomMessageListener(CmdConfigCustom.CMD_FORCE_REFRESH) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2) {
                    if ("FrsLiveLive".equals(split[0])) {
                        SpecialLiveFragment.this.mk(false);
                    }
                    SpecialForumTabBaseFragment vd = SpecialLiveFragment.this.gwX.vd(SpecialLiveFragment.this.eRw.getCurrentItem());
                    if (vd != null) {
                        vd.bSZ();
                    }
                }
            }
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && SpecialLiveFragment.this.gwZ != null && !TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                SpecialLiveFragment.this.mk(false);
            }
        }
    };
    private final CustomMessageListener gxj = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            w wVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof w) && (wVar = (w) customResponsedMessage.getData()) != null && SpecialLiveFragment.this.mForumId.equals(wVar.getFid())) {
                if (wVar.isLike() == 1) {
                    if (SpecialLiveFragment.this.bSP()) {
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
    private final CustomMessageListener gxk = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_SPECIAL_CONCERN_TAB_TAB_ICON) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                Boolean bool = (Boolean) customResponsedMessage.getData();
                if (!y.isEmpty(SpecialLiveFragment.this.gxa)) {
                    ((TabData) SpecialLiveFragment.this.gxa.get(0)).extra = bool;
                    SpecialLiveFragment.this.guH.setData(SpecialLiveFragment.this.gxa);
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
                this.gxd = sb.toString();
            } else {
                this.mForumName = this.mContext.getResources().getString(R.string.ala_ufan_bar_title);
                this.gxd = this.mForumName + string2;
            }
            bSN();
            bSL();
            bSM();
            MessageManager.getInstance().registerListener(this.gxb);
            MessageManager.getInstance().registerListener(this.gxj);
            MessageManager.getInstance().registerListener(this.mSignChangedListener);
            MessageManager.getInstance().registerListener(this.gxk);
            MessageManager.getInstance().registerListener(this.gxi);
            MessageManager.getInstance().registerListener(this.mAccountChangedListener);
            MessageManager.getInstance().registerListener(this.eDt);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(R.layout.special_live_layout, (ViewGroup) null);
        this.Zj = (AppBarLayout) this.mRootView.findViewById(R.id.special_app_bar_layout);
        this.gwK = (CollapsingToolbarLayout) this.mRootView.findViewById(R.id.special_collapse_layout);
        this.mStatusBarView = this.mRootView.findViewById(R.id.statusbar_view);
        this.gwM = (ObservedChangeFrameLayout) this.mRootView.findViewById(R.id.live_container);
        this.mBdUniqueId = BdUniqueId.gen();
        this.gwN = (RelativeLayout) this.mRootView.findViewById(R.id.function_container);
        this.gwO = this.mRootView.findViewById(R.id.function_bottom_space);
        this.gwP = (TextView) this.mRootView.findViewById(R.id.function_title);
        this.gwP.setText(this.gxd);
        this.gwQ = (TextView) this.mRootView.findViewById(R.id.function_btn);
        this.gwQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.19
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
                    SpecialLiveFragment.this.gwQ.setClickable(false);
                    SpecialLiveFragment.this.fgf.gu(SpecialLiveFragment.this.mForumName, SpecialLiveFragment.this.mForumId);
                    TiebaStatic.log(new ar("c12890"));
                } else if (SpecialLiveFragment.this.mCurState == 2) {
                    SpecialLiveFragment.this.gwQ.setClickable(false);
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
        this.gwR = (TextView) this.mRootView.findViewById(R.id.function_level_desc);
        this.gwS = (RelativeLayout) this.mRootView.findViewById(R.id.navigation_layout);
        this.gwU = this.mRootView.findViewById(R.id.navigation_top_space);
        this.gwT = this.mRootView.findViewById(R.id.navigation_bg);
        this.gwV = (TextView) this.mRootView.findViewById(R.id.navigation_title);
        this.gwV.setText(this.gxd);
        this.gwW = (ImageView) this.mRootView.findViewById(R.id.navigation_back_img);
        this.gwW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, SpecialLiveFragment.this.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        });
        this.guH = (ScrollHorizontalTabView) this.mRootView.findViewById(R.id.scroll_tab_view);
        this.eRw = (CustomViewPager) this.mRootView.findViewById(R.id.special_view_pager);
        initViewPager();
        this.guH.setViewPager(this.eRw);
        this.guH.setScrollTabPageListener(new ScrollHorizontalTabView.ScrollTabPageListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.2
            @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
            public boolean onPrePageSelect(int i, TabData tabData) {
                return true;
            }

            @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
            public void onPageSelected(int i, TabData tabData) {
                if (i != 0 || TbadkCoreApplication.isLogin()) {
                    if (SpecialLiveFragment.this.gwX != null) {
                        SpecialLiveFragment.this.gwX.a(i, tabData);
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
                    SpecialLiveFragment.this.gwT.setVisibility(8);
                    SpecialLiveFragment.this.gwV.setVisibility(8);
                } else {
                    SpecialLiveFragment.this.gwT.setVisibility(0);
                    SpecialLiveFragment.this.gwV.setVisibility(0);
                }
                SpecialLiveFragment.this.mm(((float) abs) > SpecialLiveFragment.this.gwJ / 2.0f);
                float abs2 = Math.abs(abs / SpecialLiveFragment.this.gwJ);
                SpecialLiveFragment.this.gwT.setAlpha(abs2);
                SpecialLiveFragment.this.gwV.setAlpha(abs2);
                SpecialLiveFragment.this.g(abs, abs2);
            }
        });
        this.gwL = this.mRootView.findViewById(R.id.square_main_top_divider_line);
        this.gwM.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.4
            @Override // com.baidu.tbadk.widget.layout.e
            public void d(View view, int i, int i2, int i3, int i4) {
                SpecialLiveFragment.this.gwJ = (SpecialLiveFragment.this.gwM.getMeasuredHeight() + SpecialLiveFragment.this.gwN.getMeasuredHeight()) - SpecialLiveFragment.this.gwS.getMeasuredHeight();
                SpecialLiveFragment.this.gwK.setMinimumHeight(SpecialLiveFragment.this.gwS.getMeasuredHeight());
            }
        });
        Vq();
        this.gxa = new ArrayList();
        this.ftl = new ArrayList();
        this.gwY = new e(getPageContext());
        this.gwZ = new com.baidu.tieba.ala.alasquare.special_forum.model.a(getPageContext(), new a.InterfaceC0645a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.5
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
        if (!this.gwZ.isLoading()) {
            if (z) {
                showLoadingView(this.mRootView);
            }
            this.gwZ.loadData();
        }
    }

    private void bSL() {
        this.grq = new AlaLiveUserNotifyController(getPageContext());
        this.grr = new AlaLiveUserNotifyManager.AlaLiveNotifyListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.7
            @Override // com.baidu.ala.notify.AlaLiveUserNotifyManager.AlaLiveNotifyListener
            public void onCallBack() {
                if (SpecialLiveFragment.this.isPrimary()) {
                    SpecialLiveFragment.this.grq.showNextNotifyDialog(0, AlaLiveUserNotifyManager.getInstance().getNotifyDataList());
                }
            }
        };
        AlaLiveUserNotifyManager.getInstance().addNotifyListener(this.grr);
    }

    private void bSM() {
        this.gxb = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_MODEL_TASK) { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z;
                SignData signData = null;
                SpecialLiveFragment.this.gwQ.setClickable(true);
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

    private void bSN() {
        this.fgf = new LikeModel(getPageContext());
        this.fgf.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.9
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                SpecialLiveFragment.this.gwQ.setClickable(true);
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
        bSQ();
        bSO();
        if (!this.gxf) {
            bSR();
            if (this.eRw != null && this.eRw.getChildCount() > 1) {
                this.eRw.setCurrentItem(1);
            }
            if (!y.isEmpty(this.mData.tabInfoList)) {
                this.gxf = true;
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

    private void bSO() {
        if (this.mData.gxG) {
            if (bSP()) {
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
    public boolean bSP() {
        return this.mData.gxI.gxO;
    }

    private void bSQ() {
        boolean c = this.gwY.c(this.mData.gxE);
        if (c) {
            this.gwY.stopPlay();
            this.gwY.onDestroy();
        }
        this.gwY.a(this.mData.gxE, c);
        if (c) {
            this.gwY.Z(this.gwM);
        }
        this.gwY.startPlay();
    }

    private void bSR() {
        bSS();
        this.guH.setData(this.gxa);
        this.gwX.setData(this.ftl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(int i, float f) {
        if (this.gwY != null && f != 0.0f) {
            if (this.gxc <= i) {
                if (this.gxe && f >= 0.3f) {
                    this.gwY.lX(true);
                    this.gwY.pause();
                    this.gxe = false;
                }
            } else if (!this.gxe && f <= 0.3f) {
                this.gwY.lX(false);
                this.gwY.resume();
                this.gxe = true;
            }
            this.gxc = i;
        }
    }

    private void Vq() {
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds88);
        if (UtilHelper.canUseStyleImmersiveSticky() && this.mStatusBarView.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.mStatusBarView.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.mStatusBarView.setLayoutParams(layoutParams);
            this.mStatusBarView.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gwU.getLayoutParams();
            layoutParams2.height = layoutParams.height;
            this.gwU.setLayoutParams(layoutParams2);
            dimensionPixelSize = layoutParams.height + dimensionPixelSize;
        } else {
            this.mStatusBarView.setVisibility(8);
        }
        CollapsingToolbarLayout.LayoutParams layoutParams3 = (CollapsingToolbarLayout.LayoutParams) this.gwS.getLayoutParams();
        layoutParams3.height = dimensionPixelSize;
        this.gwS.setLayoutParams(layoutParams3);
    }

    private void bSS() {
        this.gxa.clear();
        this.ftl.clear();
        this.gxa.add(bSV());
        this.gxa.add(bSW());
        this.ftl.add(bST());
        this.ftl.add(bSU());
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
                    this.gxa.add(tabData);
                }
            }
        }
    }

    private SpecialLiveTabInfo bST() {
        SpecialLiveTabInfo specialLiveTabInfo = new SpecialLiveTabInfo();
        specialLiveTabInfo.tabId = -901;
        specialLiveTabInfo.tabName = this.mContext.getResources().getString(R.string.special_concern_tab_title);
        return specialLiveTabInfo;
    }

    private SpecialLiveTabInfo bSU() {
        SpecialLiveTabInfo specialLiveTabInfo = new SpecialLiveTabInfo();
        specialLiveTabInfo.tabId = -903;
        specialLiveTabInfo.tabName = this.mContext.getResources().getString(R.string.special_recommend_tab_title);
        return specialLiveTabInfo;
    }

    private TabData bSV() {
        TabData tabData = new TabData();
        tabData.tabId = -901;
        tabData.tabName = this.mContext.getResources().getString(R.string.special_concern_tab_title);
        return tabData;
    }

    private TabData bSW() {
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
            if (this.gwY != null) {
                if (isPrimary()) {
                    this.gwY.lX(false);
                    this.gwY.startPlay();
                    return;
                }
                this.gwY.lX(true);
                this.gwY.pause();
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
        if (this.gwY != null) {
            this.gwY.lX(true);
            this.gwY.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gwY != null) {
            this.gwY.onChangeSkinType(i);
        }
        if (this.guH != null) {
            ap.setBackgroundResource(this.guH, R.color.CAM_X0201);
            this.guH.onChangeSkinType(i);
        }
        if (this.gwX != null) {
            this.gwX.onChangeSkinType(i);
        }
        mm(false);
        ap.setBackgroundColor(this.mStatusBarView, R.color.CAM_X0201);
        ap.setBackgroundColor(this.gwT, R.color.CAM_X0201);
        ap.setViewTextColor(this.gwV, (int) R.color.CAM_X0105);
        ap.setBackgroundColor(this.gwN, R.color.CAM_X0201);
        ap.setBackgroundColor(this.gwO, R.color.CAM_X0205);
        ap.setViewTextColor(this.gwP, (int) R.color.CAM_X0105);
        ap.setViewTextColor(this.gwR, (int) R.color.CAM_X0107);
        ap.setViewTextColor(this.gwQ, (int) R.color.CAM_X0111);
        ap.setBackgroundResource(this.gwQ, R.drawable.frs_attention_btn_bg_selector);
        ap.setBackgroundResource(this.gwL, R.color.CAM_X0204);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ml(boolean z) {
        Drawable drawable;
        int i = R.drawable.frs_attention_btn_bg_selector;
        ap.setBackgroundResource(this.gwQ, R.drawable.frs_attention_btn_bg_selector);
        int dimens = l.getDimens(this.mContext, R.dimen.ds10);
        String string = this.mContext.getResources().getString(R.string.attention);
        int i2 = R.color.CAM_X0101;
        if (this.mCurState == 1) {
            drawable = ap.getDrawable(R.drawable.icon_add_follow_blue_s);
            this.gwQ.setClickable(true);
            if (!z) {
                TiebaStatic.log(new ar("c12889"));
            }
        } else if (this.mCurState == 2) {
            string = this.mContext.getResources().getString(R.string.sign);
            drawable = ap.getDrawable(R.drawable.icon_public_sign_blue_s);
            this.gwQ.setClickable(true);
            if (!z) {
                TiebaStatic.log(new ar("c12891"));
            }
        } else if (this.mCurState == 3) {
            string = this.mContext.getResources().getString(R.string.signed);
            this.gwQ.setClickable(false);
            i = R.drawable.special_sign_btn_signed_bg;
            i2 = R.color.CAM_X0109;
            drawable = null;
        } else {
            drawable = null;
        }
        ap.setBackgroundResource(this.gwQ, i);
        ap.setViewTextColor(this.gwQ, i2);
        this.gwQ.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.gwQ.setCompoundDrawablePadding(dimens);
        this.gwQ.setText(string);
        bSX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mm(boolean z) {
        if (this.gwW != null) {
            if (z) {
                ap.setNavbarIconSrc(this.gwW, R.drawable.selector_topbar_return_black, R.drawable.selector_topbar_return_black, TbadkCoreApplication.getInst().getSkinType());
            } else {
                ap.setNavbarIconSrc(this.gwW, R.drawable.selector_topbar_return_white, R.drawable.selector_topbar_return_white, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    private void bSX() {
        if (this.mData != null && this.mData.gxH != null && this.mCurState != 1) {
            int i = this.mData.gxH.level_id;
            String str = TextUtils.isEmpty(this.mData.gxH.level_name) ? "" : " " + this.mData.gxH.level_name;
            if (i >= 0) {
                this.gwR.setText("LV" + i + str);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.gwY != null) {
            this.gwY.onDestroy();
        }
        if (this.gxj != null) {
            MessageManager.getInstance().unRegisterListener(this.gxj);
        }
        if (this.gxb != null) {
            MessageManager.getInstance().unRegisterListener(this.gxb);
        }
        if (this.mSignChangedListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mSignChangedListener);
        }
        if (this.gxk != null) {
            MessageManager.getInstance().unRegisterListener(this.gxk);
        }
        if (this.gxi != null) {
            MessageManager.getInstance().unRegisterListener(this.gxi);
        }
        if (this.mAccountChangedListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mAccountChangedListener);
        }
        if (this.gwZ != null) {
            this.gwZ.onDestroy();
        }
        if (this.grq != null) {
            this.grq.onDestroy();
        }
        AlaLiveUserNotifyManager.getInstance().removeNotifyListener(this.grr);
        hideLoadingView(this.mRootView);
        MessageManager.getInstance().unRegisterListener(this.eDt);
    }

    private void initViewPager() {
        this.gwX = new a(getChildFragmentManager());
        this.eRw.setAdapter(this.gwX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a extends FragmentPagerAdapter {
        private SparseArray<SpecialForumTabBaseFragment> gxn;
        private List<SpecialLiveTabInfo> mData;

        public a(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.mData = new ArrayList();
            this.gxn = new SparseArray<>();
            this.gxn.put(0, ConcernTabFragment.vf(0));
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
                this.gxn.put(i, vd);
            }
            return vd;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.mData.size();
        }

        public SpecialForumTabBaseFragment vd(int i) {
            return this.gxn.get(i);
        }

        public void a(int i, TabData tabData) {
            if (this.gxn.get(i) != null) {
                this.gxn.get(i).setPrimary(true);
            }
        }

        public void onChangeSkinType(int i) {
            if (this.gxn != null && this.gxn.size() > 0) {
                int size = this.gxn.size();
                for (int i2 = 0; i2 < size; i2++) {
                    SpecialForumTabBaseFragment specialForumTabBaseFragment = this.gxn.get(i2);
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
            if (this.gxg != null) {
                this.gxg.dismiss();
            }
            final Handler handler = new Handler();
            final Runnable runnable = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment.10
                @Override // java.lang.Runnable
                public void run() {
                    if (SpecialLiveFragment.this.gxg != null) {
                        SpecialLiveFragment.this.gxg.dismiss();
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
                    SpecialLiveFragment.this.gxg = null;
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
                            SpecialLiveFragment.this.gxg.dismiss();
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
            this.gxg = dVar.mi();
            this.gxg.show(activity);
            handler.postDelayed(runnable, 5000L);
        }
    }
}
