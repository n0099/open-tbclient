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
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SignAllForumActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
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
    private BdBaseViewPager ceT;
    private NoNetworkView dpy;
    private AlphaAnimation dre;
    private AlphaAnimation drf;
    private com.baidu.tieba.enterForum.data.b eXg;
    private EnterForumTabFragment eZC;
    private LinearLayout eZD;
    private ForumHeaderView eZE;
    private PagerSlidingTabBaseStrip eZF;
    private EnterForumTabPagerAdapter eZG;
    private List<EnterForumTabPagerAdapter.a> eZH;
    private com.baidu.tieba.enterForum.data.b eZI;
    private ImageView eZJ;
    private ImageView eZK;
    private NavigationBar eZL;
    private View eZM;
    private List<a> eZN;
    private com.baidu.tieba.enterForum.view.b eZO;
    private int eZP;
    private int eZQ;
    private com.baidu.adp.framework.listener.a eZR;
    private int mNavHeight;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private View mRootView;

    public c(EnterForumTabFragment enterForumTabFragment) {
        super(enterForumTabFragment.getPageContext());
        this.eZP = -1;
        this.eZR = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011) { // from class: com.baidu.tieba.enterForum.home.c.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String str = "";
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage = (forumRecommendSocketResponseMessage) responsedMessage;
                    if (forumrecommendsocketresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendsocketresponsemessage.getHotSearchInfoData().bfT();
                    }
                } else if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage = (forumRecommendHttpResponseMessage) responsedMessage;
                    if (forumrecommendhttpresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendhttpresponsemessage.getHotSearchInfoData().bfT();
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
                c.this.qD(i);
                if (c.this.eZH != null && c.this.eZH.size() > i) {
                    if (c.this.eZO != null) {
                        c.this.eZO.bhL();
                    }
                    EnterForumTabPagerAdapter.a aVar = (EnterForumTabPagerAdapter.a) c.this.eZH.get(i);
                    if (aVar != null && aVar.fragment != null) {
                        if (aVar.fragment instanceof RecommendFragment) {
                            if (c.this.eZN != null) {
                                for (a aVar2 : c.this.eZN) {
                                    aVar2.bgM();
                                }
                            }
                        } else if ((aVar.fragment instanceof EnterForumFragment) && c.this.eZN != null) {
                            for (a aVar3 : c.this.eZN) {
                                aVar3.bgL();
                            }
                        }
                        if (i == 0) {
                            c.this.eZP = 1;
                            TiebaStatic.log(new an("c13366").P("obj_locate", 1));
                        } else if (i == 1) {
                            c.this.eZP = 2;
                            TiebaStatic.log(new an("c13366").P("obj_locate", 2));
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
        this.eZC = enterForumTabFragment;
        this.eZC.registerListener(this.eZR);
        this.mNavHeight = l.g(this.mContext.getPageActivity(), R.dimen.tbds240);
        this.eZQ = UtilHelper.getStatusBarHeight() + l.g(this.mContext.getPageActivity(), R.dimen.tbds240);
    }

    private void bgE() {
        forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
        forumrecommendrequestmessage.set_like_forum(Integer.valueOf(TbadkCoreApplication.isLogin() ? 1 : 0));
        forumrecommendrequestmessage.set_topic(0);
        forumrecommendrequestmessage.set_recommend(1);
        this.eZC.sendMessage(forumrecommendrequestmessage);
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            L(bundle);
            M(bundle);
            N(bundle);
            this.dpy = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.dpy.a(this);
            if (!TbadkCoreApplication.getInst().checkInterrupt()) {
                bgE();
            }
        }
    }

    private void L(Bundle bundle) {
        this.ceT = (BdBaseViewPager) this.mRootView.findViewById(R.id.enter_forum_viewpager);
        EnterForumTabPagerAdapter.a aVar = new EnterForumTabPagerAdapter.a();
        aVar.fragment = new EnterForumFragment();
        aVar.title = this.eZC.getResources().getString(R.string.attention);
        ((EnterForumFragment) aVar.fragment).setTabViewController(this);
        EnterForumTabPagerAdapter.a aVar2 = new EnterForumTabPagerAdapter.a();
        aVar2.fragment = new RecommendFragment();
        aVar2.title = this.eZC.getResources().getString(R.string.default_personalized_name);
        ((RecommendFragment) aVar2.fragment).setTabViewController(this);
        this.eZH = new ArrayList();
        this.eZH.add(aVar);
        this.eZH.add(aVar2);
        this.eZG = new EnterForumTabPagerAdapter(this.eZC.getActivity().getSupportFragmentManager(), this.eZH);
        this.ceT.setAdapter(this.eZG);
        this.ceT.setOffscreenPageLimit(this.eZH.size());
    }

    public void Dr() {
    }

    private void M(Bundle bundle) {
        this.eZD = (LinearLayout) LayoutInflater.from(this.eZC.getContext()).inflate(R.layout.enter_forum_tab_layout, (ViewGroup) null);
        this.eZE = (ForumHeaderView) this.eZD.findViewById(R.id.recommend_forum_header_serch_view);
        this.eZE.onChangeSkinType();
        this.eZF = (PagerSlidingTabBaseStrip) this.eZD.findViewById(R.id.tab_layout);
        this.eZF.d(l.g(this.eZC.getContext(), R.dimen.tbds44), l.g(this.eZC.getContext(), R.dimen.tbds68), l.g(this.eZC.getContext(), R.dimen.tbds30), true);
        this.eZF.setViewPager(this.ceT);
        this.eZF.setOnPageChangeListener(this.mOnPageChangeListener);
    }

    private void N(Bundle bundle) {
        this.eZL = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.eZL.setNavHeight(this.mNavHeight);
        this.eZL.hideBottomLine();
        this.eZM = this.mRootView.findViewById(R.id.divider_shadow);
        qE(0);
        this.eZJ = (ImageView) this.eZD.findViewById(R.id.navigationBarGoSignall);
        this.eZJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.isLogin()) {
                    bc.cE(c.this.getPageContext().getPageActivity());
                } else {
                    c.this.eZC.sendMessage(new CustomMessage(2002001, new SignAllForumActivityConfig(c.this.getPageContext().getPageActivity())));
                }
            }
        });
        this.eZK = (ImageView) this.eZD.findViewById(R.id.navigationBarGoSearch);
        this.eZK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.eZE.onClick(view);
            }
        });
        if (this.eZF != null) {
            this.eZL.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, this.eZD, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.eZD.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(3);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(3);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 3;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.eZF.setPadding(this.eZF.getPaddingLeft(), this.eZF.getPaddingTop(), this.eZF.getPaddingRight(), this.eZF.getBottom());
            this.eZF.getLayoutParams().height = l.g(this.eZC.getContext(), R.dimen.tbds126);
            ((RelativeLayout.LayoutParams) this.eZF.getLayoutParams()).setMargins(l.g(this.eZC.getContext(), R.dimen.tbds23), 0, 0, 0);
        }
    }

    public void a(PagerSlidingTabBaseStrip.a aVar) {
        if (this.eZF != null && aVar != null) {
            this.eZF.setOnTabItemClickListener(aVar);
        }
    }

    public void qB(int i) {
        if (i <= 2 && i >= 1) {
            this.eZP = i;
            this.ceT.setCurrentItem(i - 1, true);
        }
    }

    public int bgF() {
        return this.eZP;
    }

    public boolean qC(int i) {
        return this.eZF != null && this.eZG.bgD() == i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        qD(this.ceT.getCurrentItem());
        if (this.dpy != null) {
            this.dpy.onChangeSkinType(getPageContext(), i);
        }
        if (this.eZH != null && this.eZH.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.eZH.size()) {
                    break;
                }
                EnterForumTabPagerAdapter.a aVar = this.eZH.get(i3);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            }
        }
        this.eZF.onChangeSkinType();
        this.eZE.onChangeSkinType();
    }

    public void bgG() {
        qD(this.ceT.getCurrentItem());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, float f, int i2) {
        if (this.eZL != null) {
            if (i == 0) {
                if (i2 == 0) {
                    qD(i);
                } else if (this.eXg != null && this.eXg.eXL && this.eXg.eXN > 0) {
                    if (this.eZO != null && this.eZO.getRefreshView() != null && this.eZO.getRefreshView().isViewAttached()) {
                        am.h(this.eZL.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
                        return;
                    }
                    this.eZL.setBackgroundColor(0);
                    am.a(this.eZL.getBarBgView(), (int) R.color.cp_bg_line_h, f, TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (i2 == 0) {
                qD(i);
            } else if (this.eXg != null && this.eXg.eXL && this.eXg.eXN > 0) {
                if (this.eZO != null && this.eZO.getRefreshView() != null && this.eZO.getRefreshView().isViewAttached()) {
                    am.h(this.eZL.getBarBgView(), R.color.cp_bg_line_d, TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.eZL.setBackgroundColor(0);
                am.a(this.eZL.getBarBgView(), (int) R.color.cp_bg_line_d, 1.0f - f, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qD(int i) {
        int i2;
        if (this.eZJ != null) {
            if (i == 0) {
                if (this.eXg != null && this.eXg.eXL && this.eXg.eXN > 0) {
                    if (this.eZO != null && this.eZO.getRefreshView() != null && this.eZO.getRefreshView().isViewAttached()) {
                        am.c(this.eZJ, (int) R.drawable.icon_ba_sign_black);
                        am.c(this.eZK, (int) R.drawable.icon_ba_search_black);
                    } else if (this.eXg.eXO > 0 && this.eXg.eXN > this.eXg.eXO / 2) {
                        SvgManager.ajv().a(this.eZJ, R.drawable.icon_pure_topbar_sign_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                        am.c(this.eZK, (int) R.drawable.icon_ba_search_white);
                    } else {
                        SvgManager.ajv().a(this.eZJ, R.drawable.icon_pure_topbar_sign_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                        am.c(this.eZK, (int) R.drawable.icon_ba_search_black);
                    }
                } else {
                    SvgManager.ajv().a(this.eZJ, R.drawable.icon_pure_topbar_sign_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    am.c(this.eZK, (int) R.drawable.icon_ba_search_black);
                }
            } else {
                SvgManager.ajv().a(this.eZJ, R.drawable.icon_pure_topbar_sign_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                am.c(this.eZK, (int) R.drawable.icon_ba_search_black);
            }
        }
        if (this.eZL != null) {
            this.eZL.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            if (i == 0) {
                if (this.eXg != null && this.eXg.eXL && this.eXg.eXN > 0) {
                    if (this.eZO != null && this.eZO.getRefreshView() != null && this.eZO.getRefreshView().isViewAttached()) {
                        am.h(this.eZL.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
                    } else {
                        if (this.eXg.eXO > 0) {
                            int i3 = (this.eXg.eXN * 255) / this.eXg.eXO;
                            if (i3 > 255) {
                                i3 = 255;
                            }
                            i2 = 255 - i3;
                        } else {
                            i2 = 0;
                        }
                        this.eZL.setBackgroundColor(0);
                        am.a(this.eZL.getBarBgView(), (int) R.color.cp_bg_line_d, i2 / 255.0f, TbadkCoreApplication.getInst().getSkinType());
                    }
                } else {
                    am.h(this.eZL.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
                }
            } else {
                am.h(this.eZL.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
            }
        }
        if (i == 0) {
            if (this.eXg != null && this.eXg.eXL && this.eXg.eXN > 0) {
                if (this.eXg.eXO > 0 && this.eXg.eXN > this.eXg.eXO / 2) {
                    if (this.eZO != null && this.eZO.getRefreshView() != null && this.eZO.getRefreshView().isViewAttached()) {
                        this.eZF.setWhiteStyle(false);
                    } else {
                        this.eZF.setWhiteStyle(true);
                    }
                    if (this.eZC.isPrimary()) {
                    }
                } else {
                    this.eZF.setWhiteStyle(false);
                    if (this.eZC.isPrimary()) {
                    }
                }
            } else {
                this.eZF.setWhiteStyle(false);
                if (this.eZC.isPrimary()) {
                }
            }
        } else {
            this.eZF.setWhiteStyle(false);
            if (this.eZC.isPrimary()) {
            }
        }
        if (i == 0) {
            this.eZE.setAdState(this.eXg);
        } else {
            this.eZE.setAdState(null);
        }
        if (i == 0 && TbadkCoreApplication.getInst().getSkinType() != 1 && this.eZC.isPrimary() && this.eXg != null && this.eXg.eXL && i == 0) {
            if (this.eXg.eXN > this.eXg.eXO / 2) {
                if (this.eZI != null && this.eZI.eXN <= this.eXg.eXO / 2) {
                    ao.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
                }
            } else if (this.eZI != null && this.eZI.eXN >= this.eXg.eXO / 2) {
                ao.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            }
        }
    }

    public void bgH() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            ao.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
        } else if (this.ceT.getCurrentItem() == 0 && this.eZC.isPrimary()) {
            if (this.eZO != null && this.eZO.getRefreshView() != null && this.eZO.getRefreshView().isViewAttached()) {
                ao.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            } else if (this.eXg != null && this.eXg.eXL) {
                if (this.eXg.eXN > this.eXg.eXO / 2 || this.eXg.eXN == 0) {
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
        if (this.eZH != null && this.eZH.size() > 0 && this.ceT != null) {
            EnterForumTabPagerAdapter.a aVar = this.eZH.get(this.ceT.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void bgI() {
        if (this.eZC != null && this.eZH != null && this.ceT != null && this.eZG != null) {
            FragmentManager supportFragmentManager = this.eZC.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.eZH.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.ceT.getId(), this.eZG.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.dpy != null) {
            this.dpy.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.eZG != null) {
            this.eZG.setPrimary(z);
        }
        if (this.eZH != null && this.eZH.size() > 0 && this.ceT != null) {
            EnterForumTabPagerAdapter.a aVar = this.eZH.get(this.ceT.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void es(boolean z) {
        if (this.eZH != null && this.eZH.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.eZH.size()) {
                    break;
                }
                EnterForumTabPagerAdapter.a aVar = this.eZH.get(i2);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof NoNetworkView.a)) {
                    ((NoNetworkView.a) aVar.fragment).es(z);
                }
                i = i2 + 1;
            }
        }
        qD(this.ceT.getCurrentItem());
    }

    public void aKa() {
        if (this.eZD != null && this.eZD.getPaddingTop() < 0) {
            bgJ();
        } else if (this.eZM != null) {
            this.eZM.clearAnimation();
            if (this.eZM.getVisibility() != 0) {
                this.eZM.setVisibility(0);
                if (this.dre == null) {
                    this.dre = new AlphaAnimation(0.0f, 1.0f);
                    this.dre.setFillAfter(true);
                    this.dre.setDuration(300L);
                }
                this.eZM.startAnimation(this.dre);
            }
        }
    }

    public void aKb() {
        if (this.eZM != null && this.eZM.getVisibility() != 8) {
            if (this.drf == null) {
                this.drf = new AlphaAnimation(1.0f, 0.0f);
                this.drf.setFillAfter(true);
                this.drf.setDuration(300L);
                this.drf.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.enterForum.home.c.5
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.eZM.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.eZM.startAnimation(this.drf);
        }
    }

    private void bgJ() {
        if (this.eZM != null && this.eZM.getVisibility() != 8) {
            this.eZM.clearAnimation();
            this.eZM.setVisibility(8);
        }
    }

    public void a(a aVar) {
        if (this.eZN == null) {
            this.eZN = new ArrayList();
        }
        this.eZN.add(aVar);
    }

    public void b(a aVar) {
        if (this.eZN != null && this.eZN.size() > 0) {
            this.eZN.remove(aVar);
        }
    }

    public void a(com.baidu.tieba.enterForum.view.b bVar) {
        this.eZO = bVar;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.b bVar) {
        this.eZI = this.eXg;
        this.eXg = bVar;
        this.eZE.setAdState(bVar);
        qD(this.ceT.getCurrentItem());
    }

    public void setSearchHint(String str) {
        this.eZE.setSearchHint(str);
    }

    public View getRootView() {
        return getPageContext().getPageActivity().getWindow().getDecorView();
    }

    public View bgK() {
        return this.eZD;
    }

    /* loaded from: classes4.dex */
    public static abstract class a {
        public void bgL() {
        }

        public void bgM() {
        }
    }

    public String getCurrentPageKey() {
        if (this.eZG != null) {
            return this.eZG.getCurrentPageKey();
        }
        return null;
    }

    public void d(View view, int i, int i2, int i3, int i4) {
    }

    private void qE(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eZM.getLayoutParams();
        layoutParams.topMargin = this.eZQ + i;
        this.eZM.setLayoutParams(layoutParams);
    }
}
