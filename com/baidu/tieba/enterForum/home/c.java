package com.baidu.tieba.enterForum.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SignAllForumActivityConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.home.EnterForumTabPagerAdapter;
import com.baidu.tieba.enterForum.recommend.RecommendFragment;
import com.baidu.tieba.enterForum.view.ForumHeaderView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c extends com.baidu.adp.base.c implements NoNetworkView.a {
    private BdBaseViewPager cso;
    private NoNetworkView dvR;
    private AlphaAnimation dxx;
    private AlphaAnimation dxy;
    private com.baidu.tieba.enterForum.data.b eZb;
    private EnterForumTabPagerAdapter fbA;
    private List<EnterForumTabPagerAdapter.a> fbB;
    private com.baidu.tieba.enterForum.data.b fbC;
    private ImageView fbD;
    private ImageView fbE;
    private NavigationBar fbF;
    private View fbG;
    private List<a> fbH;
    private com.baidu.tieba.enterForum.view.b fbI;
    private int fbJ;
    private int fbK;
    private com.baidu.adp.framework.listener.a fbL;
    private EnterForumTabFragment fbw;
    private LinearLayout fbx;
    private ForumHeaderView fby;
    private PagerSlidingTabBaseStrip fbz;
    private int mNavHeight;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private View mRootView;

    public c(EnterForumTabFragment enterForumTabFragment) {
        super(enterForumTabFragment.getPageContext());
        this.fbJ = -1;
        this.fbL = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.enterForum.home.c.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String str = "";
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage = (forumRecommendSocketResponseMessage) responsedMessage;
                    if (forumrecommendsocketresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendsocketresponsemessage.getHotSearchInfoData().bdL();
                    }
                } else if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage = (forumRecommendHttpResponseMessage) responsedMessage;
                    if (forumrecommendhttpresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendhttpresponsemessage.getHotSearchInfoData().bdL();
                    }
                }
                if (TextUtils.isEmpty(str)) {
                    str = c.this.mContext.getResources().getString(R.string.enter_forum_search_tip);
                }
                TbSingleton.getInstance().setHotSearch(str);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921396));
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.enterForum.home.c.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                c.this.a(i, f, i2);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                c.this.py(i);
                if (c.this.fbB != null && c.this.fbB.size() > i) {
                    if (c.this.fbI != null) {
                        c.this.fbI.bfB();
                    }
                    EnterForumTabPagerAdapter.a aVar = (EnterForumTabPagerAdapter.a) c.this.fbB.get(i);
                    if (aVar != null && aVar.fragment != null) {
                        if (aVar.fragment instanceof RecommendFragment) {
                            if (c.this.fbH != null) {
                                for (a aVar2 : c.this.fbH) {
                                    aVar2.beD();
                                }
                            }
                        } else if ((aVar.fragment instanceof EnterForumFragment) && c.this.fbH != null) {
                            for (a aVar3 : c.this.fbH) {
                                aVar3.beC();
                            }
                        }
                        if (i == 0) {
                            c.this.fbJ = 1;
                            TiebaStatic.log(new an("c13366").O("obj_locate", 1));
                        } else if (i == 1) {
                            c.this.fbJ = 2;
                            TiebaStatic.log(new an("c13366").O("obj_locate", 2));
                        }
                        if (i == 0) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921386));
                        }
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        };
        this.fbw = enterForumTabFragment;
        this.fbw.registerListener(this.fbL);
        this.mNavHeight = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds240);
        this.fbK = UtilHelper.getStatusBarHeight() + l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds240);
    }

    private void bev() {
        forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
        forumrecommendrequestmessage.set_like_forum(Integer.valueOf(TbadkCoreApplication.isLogin() ? 1 : 0));
        forumrecommendrequestmessage.set_topic(0);
        forumrecommendrequestmessage.set_recommend(1);
        this.fbw.sendMessage(forumrecommendrequestmessage);
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            L(bundle);
            M(bundle);
            N(bundle);
            this.dvR = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.dvR.a(this);
            if (!TbadkCoreApplication.getInst().checkInterrupt()) {
                bev();
            }
        }
    }

    private void L(Bundle bundle) {
        this.cso = (BdBaseViewPager) this.mRootView.findViewById(R.id.enter_forum_viewpager);
        EnterForumTabPagerAdapter.a aVar = new EnterForumTabPagerAdapter.a();
        aVar.fragment = new EnterForumFragment();
        aVar.title = this.fbw.getResources().getString(R.string.attention);
        ((EnterForumFragment) aVar.fragment).setTabViewController(this);
        EnterForumTabPagerAdapter.a aVar2 = new EnterForumTabPagerAdapter.a();
        aVar2.fragment = new RecommendFragment();
        aVar2.title = this.fbw.getResources().getString(R.string.default_personalized_name);
        ((RecommendFragment) aVar2.fragment).setTabViewController(this);
        this.fbB = new ArrayList();
        this.fbB.add(aVar);
        this.fbB.add(aVar2);
        this.fbA = new EnterForumTabPagerAdapter(this.fbw.getActivity().getSupportFragmentManager(), this.fbB);
        this.cso.setAdapter(this.fbA);
        this.cso.setOffscreenPageLimit(this.fbB.size());
    }

    public void Im() {
    }

    private void M(Bundle bundle) {
        this.fbx = (LinearLayout) LayoutInflater.from(this.fbw.getContext()).inflate(R.layout.enter_forum_tab_layout, (ViewGroup) null);
        this.fby = (ForumHeaderView) this.fbx.findViewById(R.id.recommend_forum_header_serch_view);
        this.fby.onChangeSkinType();
        this.fbz = (PagerSlidingTabBaseStrip) this.fbx.findViewById(R.id.tab_layout);
        this.fbz.d(l.getDimens(this.fbw.getContext(), R.dimen.tbds44), l.getDimens(this.fbw.getContext(), R.dimen.tbds68), l.getDimens(this.fbw.getContext(), R.dimen.tbds30), true);
        this.fbz.setViewPager(this.cso);
        this.fbz.setOnPageChangeListener(this.mOnPageChangeListener);
    }

    private void N(Bundle bundle) {
        this.fbF = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.fbF.setNavHeight(this.mNavHeight);
        this.fbF.hideBottomLine();
        this.fbG = this.mRootView.findViewById(R.id.divider_shadow);
        pz(0);
        this.fbD = (ImageView) this.fbx.findViewById(R.id.navigationBarGoSignall);
        this.fbD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.isLogin()) {
                    bc.skipToLoginActivity(c.this.getPageContext().getPageActivity());
                } else {
                    c.this.fbw.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(c.this.getPageContext().getPageActivity())));
                }
            }
        });
        this.fbE = (ImageView) this.fbx.findViewById(R.id.navigationBarGoSearch);
        this.fbE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.fby.onClick(view);
            }
        });
        if (this.fbz != null) {
            this.fbF.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, this.fbx, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.fbx.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(3);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(3);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 3;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.fbz.setPadding(this.fbz.getPaddingLeft(), this.fbz.getPaddingTop(), this.fbz.getPaddingRight(), this.fbz.getBottom());
            this.fbz.getLayoutParams().height = l.getDimens(this.fbw.getContext(), R.dimen.tbds126);
            ((RelativeLayout.LayoutParams) this.fbz.getLayoutParams()).setMargins(l.getDimens(this.fbw.getContext(), R.dimen.tbds23), 0, 0, 0);
        }
    }

    public void a(PagerSlidingTabBaseStrip.a aVar) {
        if (this.fbz != null && aVar != null) {
            this.fbz.setOnTabItemClickListener(aVar);
        }
    }

    public void pw(int i) {
        if (i <= 2 && i >= 1) {
            this.fbJ = i;
            this.cso.setCurrentItem(i - 1, true);
        }
    }

    public int bew() {
        return this.fbJ;
    }

    public boolean px(int i) {
        return this.fbz != null && this.fbA.beu() == i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        py(this.cso.getCurrentItem());
        if (this.dvR != null) {
            this.dvR.onChangeSkinType(getPageContext(), i);
        }
        if (this.fbB != null && this.fbB.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.fbB.size()) {
                    break;
                }
                EnterForumTabPagerAdapter.a aVar = this.fbB.get(i3);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            }
        }
        this.fbz.onChangeSkinType();
        this.fby.onChangeSkinType();
    }

    public void bex() {
        py(this.cso.getCurrentItem());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, float f, int i2) {
        if (this.fbF != null) {
            if (i == 0) {
                if (i2 == 0) {
                    py(i);
                } else if (this.eZb != null && this.eZb.eZG && this.eZb.eZI > 0) {
                    if (this.fbI != null && this.fbI.getRefreshView() != null && this.fbI.getRefreshView().isViewAttached()) {
                        am.setBackgroundColor(this.fbF.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
                        return;
                    }
                    this.fbF.setBackgroundColor(0);
                    am.a(this.fbF.getBarBgView(), R.color.cp_bg_line_h, f, TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (i2 == 0) {
                py(i);
            } else if (this.eZb != null && this.eZb.eZG && this.eZb.eZI > 0) {
                if (this.fbI != null && this.fbI.getRefreshView() != null && this.fbI.getRefreshView().isViewAttached()) {
                    am.setBackgroundColor(this.fbF.getBarBgView(), R.color.cp_bg_line_d, TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.fbF.setBackgroundColor(0);
                am.a(this.fbF.getBarBgView(), R.color.cp_bg_line_d, 1.0f - f, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void py(int i) {
        int i2;
        if (this.fbD != null) {
            if (i == 0) {
                if (this.eZb != null && this.eZb.eZG && this.eZb.eZI > 0) {
                    if (this.fbI != null && this.fbI.getRefreshView() != null && this.fbI.getRefreshView().isViewAttached()) {
                        am.setImageResource(this.fbD, R.drawable.icon_ba_sign_black);
                        am.setImageResource(this.fbE, R.drawable.icon_ba_search_black);
                    } else if (this.eZb.eZJ > 0 && this.eZb.eZI > this.eZb.eZJ / 2) {
                        SvgManager.amL().a(this.fbD, R.drawable.icon_pure_topbar_sign_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                        am.setImageResource(this.fbE, R.drawable.icon_ba_search_white);
                    } else {
                        SvgManager.amL().a(this.fbD, R.drawable.icon_pure_topbar_sign_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                        am.setImageResource(this.fbE, R.drawable.icon_ba_search_black);
                    }
                } else {
                    SvgManager.amL().a(this.fbD, R.drawable.icon_pure_topbar_sign_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    am.setImageResource(this.fbE, R.drawable.icon_ba_search_black);
                }
            } else {
                SvgManager.amL().a(this.fbD, R.drawable.icon_pure_topbar_sign_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                am.setImageResource(this.fbE, R.drawable.icon_ba_search_black);
            }
        }
        if (this.fbF != null) {
            this.fbF.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            if (i == 0) {
                if (this.eZb != null && this.eZb.eZG && this.eZb.eZI > 0) {
                    if (this.fbI != null && this.fbI.getRefreshView() != null && this.fbI.getRefreshView().isViewAttached()) {
                        am.setBackgroundColor(this.fbF.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
                    } else {
                        if (this.eZb.eZJ > 0) {
                            int i3 = (this.eZb.eZI * 255) / this.eZb.eZJ;
                            if (i3 > 255) {
                                i3 = 255;
                            }
                            i2 = 255 - i3;
                        } else {
                            i2 = 0;
                        }
                        this.fbF.setBackgroundColor(0);
                        am.a(this.fbF.getBarBgView(), R.color.cp_bg_line_d, i2 / 255.0f, TbadkCoreApplication.getInst().getSkinType());
                    }
                } else {
                    am.setBackgroundColor(this.fbF.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
                }
            } else {
                am.setBackgroundColor(this.fbF.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
            }
        }
        if (i == 0) {
            if (this.eZb != null && this.eZb.eZG && this.eZb.eZI > 0) {
                if (this.eZb.eZJ > 0 && this.eZb.eZI > this.eZb.eZJ / 2) {
                    if (this.fbI != null && this.fbI.getRefreshView() != null && this.fbI.getRefreshView().isViewAttached()) {
                        this.fbz.setWhiteStyle(false);
                    } else {
                        this.fbz.setWhiteStyle(true);
                    }
                    if (this.fbw.isPrimary()) {
                    }
                } else {
                    this.fbz.setWhiteStyle(false);
                    if (this.fbw.isPrimary()) {
                    }
                }
            } else {
                this.fbz.setWhiteStyle(false);
                if (this.fbw.isPrimary()) {
                }
            }
        } else {
            this.fbz.setWhiteStyle(false);
            if (this.fbw.isPrimary()) {
            }
        }
        if (i == 0) {
            this.fby.setAdState(this.eZb);
        } else {
            this.fby.setAdState(null);
        }
        if (i == 0 && TbadkCoreApplication.getInst().getSkinType() != 1 && this.fbw.isPrimary() && this.eZb != null && this.eZb.eZG && i == 0) {
            if (this.eZb.eZI > this.eZb.eZJ / 2) {
                if (this.fbC != null && this.fbC.eZI <= this.eZb.eZJ / 2) {
                    ao.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
                }
            } else if (this.fbC != null && this.fbC.eZI >= this.eZb.eZJ / 2) {
                ao.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            }
        }
    }

    public void bey() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            ao.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
        } else if (this.cso.getCurrentItem() == 0 && this.fbw.isPrimary()) {
            if (this.fbI != null && this.fbI.getRefreshView() != null && this.fbI.getRefreshView().isViewAttached()) {
                ao.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            } else if (this.eZb != null && this.eZb.eZG) {
                if (this.eZb.eZI > this.eZb.eZJ / 2 || this.eZb.eZI == 0) {
                    ao.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
                } else {
                    ao.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
                }
            } else {
                ao.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            }
        } else {
            ao.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.fbB != null && this.fbB.size() > 0 && this.cso != null) {
            EnterForumTabPagerAdapter.a aVar = this.fbB.get(this.cso.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void bez() {
        if (this.fbw != null && this.fbB != null && this.cso != null && this.fbA != null) {
            FragmentManager supportFragmentManager = this.fbw.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.fbB.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.cso.getId(), this.fbA.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.dvR != null) {
            this.dvR.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.fbA != null) {
            this.fbA.setPrimary(z);
        }
        if (this.fbB != null && this.fbB.size() > 0 && this.cso != null) {
            EnterForumTabPagerAdapter.a aVar = this.fbB.get(this.cso.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.fbB != null && this.fbB.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.fbB.size()) {
                    break;
                }
                EnterForumTabPagerAdapter.a aVar = this.fbB.get(i2);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof NoNetworkView.a)) {
                    ((NoNetworkView.a) aVar.fragment).onNetworkChange(z);
                }
                i = i2 + 1;
            }
        }
        py(this.cso.getCurrentItem());
    }

    public void aJy() {
        if (this.fbx != null && this.fbx.getPaddingTop() < 0) {
            beA();
        } else if (this.fbG != null) {
            this.fbG.clearAnimation();
            if (this.fbG.getVisibility() != 0) {
                this.fbG.setVisibility(0);
                if (this.dxx == null) {
                    this.dxx = new AlphaAnimation(0.0f, 1.0f);
                    this.dxx.setFillAfter(true);
                    this.dxx.setDuration(300L);
                }
                this.fbG.startAnimation(this.dxx);
            }
        }
    }

    public void aJz() {
        if (this.fbG != null && this.fbG.getVisibility() != 8) {
            if (this.dxy == null) {
                this.dxy = new AlphaAnimation(1.0f, 0.0f);
                this.dxy.setFillAfter(true);
                this.dxy.setDuration(300L);
                this.dxy.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.enterForum.home.c.5
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.fbG.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.fbG.startAnimation(this.dxy);
        }
    }

    private void beA() {
        if (this.fbG != null && this.fbG.getVisibility() != 8) {
            this.fbG.clearAnimation();
            this.fbG.setVisibility(8);
        }
    }

    public void a(a aVar) {
        if (this.fbH == null) {
            this.fbH = new ArrayList();
        }
        this.fbH.add(aVar);
    }

    public void b(a aVar) {
        if (this.fbH != null && this.fbH.size() > 0) {
            this.fbH.remove(aVar);
        }
    }

    public void a(com.baidu.tieba.enterForum.view.b bVar) {
        this.fbI = bVar;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.b bVar) {
        this.fbC = this.eZb;
        this.eZb = bVar;
        this.fby.setAdState(bVar);
        py(this.cso.getCurrentItem());
    }

    public void setSearchHint(String str) {
        this.fby.setSearchHint(str);
    }

    public View getRootView() {
        return getPageContext().getPageActivity().getWindow().getDecorView();
    }

    public View beB() {
        return this.fbx;
    }

    /* loaded from: classes4.dex */
    public static abstract class a {
        public void beC() {
        }

        public void beD() {
        }
    }

    public String getCurrentPageKey() {
        if (this.fbA != null) {
            return this.fbA.getCurrentPageKey();
        }
        return null;
    }

    public void e(View view, int i, int i2, int i3, int i4) {
    }

    private void pz(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fbG.getLayoutParams();
        layoutParams.topMargin = this.fbK + i;
        this.fbG.setLayoutParams(layoutParams);
    }
}
