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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.bd;
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
    private BdBaseViewPager cea;
    private NoNetworkView dnM;
    private AlphaAnimation dpt;
    private AlphaAnimation dpu;
    private com.baidu.tieba.enterForum.data.b eVA;
    private EnterForumTabFragment eXW;
    private LinearLayout eXX;
    private ForumHeaderView eXY;
    private PagerSlidingTabBaseStrip eXZ;
    private EnterForumTabPagerAdapter eYa;
    private List<EnterForumTabPagerAdapter.a> eYb;
    private com.baidu.tieba.enterForum.data.b eYc;
    private ImageView eYd;
    private ImageView eYe;
    private NavigationBar eYf;
    private View eYg;
    private List<a> eYh;
    private com.baidu.tieba.enterForum.view.b eYi;
    private int eYj;
    private int eYk;
    private com.baidu.adp.framework.listener.a eYl;
    private int mNavHeight;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private View mRootView;

    public c(EnterForumTabFragment enterForumTabFragment) {
        super(enterForumTabFragment.getPageContext());
        this.eYj = -1;
        this.eYl = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011) { // from class: com.baidu.tieba.enterForum.home.c.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String str = "";
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage = (forumRecommendSocketResponseMessage) responsedMessage;
                    if (forumrecommendsocketresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendsocketresponsemessage.getHotSearchInfoData().bfp();
                    }
                } else if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage = (forumRecommendHttpResponseMessage) responsedMessage;
                    if (forumrecommendhttpresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendhttpresponsemessage.getHotSearchInfoData().bfp();
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
                c.this.qA(i);
                if (c.this.eYb != null && c.this.eYb.size() > i) {
                    if (c.this.eYi != null) {
                        c.this.eYi.bhd();
                    }
                    EnterForumTabPagerAdapter.a aVar = (EnterForumTabPagerAdapter.a) c.this.eYb.get(i);
                    if (aVar != null && aVar.fragment != null) {
                        if (aVar.fragment instanceof RecommendFragment) {
                            if (c.this.eYh != null) {
                                for (a aVar2 : c.this.eYh) {
                                    aVar2.bgg();
                                }
                            }
                        } else if ((aVar.fragment instanceof EnterForumFragment) && c.this.eYh != null) {
                            for (a aVar3 : c.this.eYh) {
                                aVar3.bgf();
                            }
                        }
                        if (i == 0) {
                            c.this.eYj = 1;
                            TiebaStatic.log(new an("c13366").P("obj_locate", 1));
                        } else if (i == 1) {
                            c.this.eYj = 2;
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
        this.eXW = enterForumTabFragment;
        this.eXW.registerListener(this.eYl);
        this.mNavHeight = l.g(this.mContext.getPageActivity(), R.dimen.tbds240);
        this.eYk = UtilHelper.getStatusBarHeight() + l.g(this.mContext.getPageActivity(), R.dimen.tbds240);
    }

    private void bfZ() {
        forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
        forumrecommendrequestmessage.set_like_forum(Integer.valueOf(TbadkCoreApplication.isLogin() ? 1 : 0));
        forumrecommendrequestmessage.set_topic(0);
        forumrecommendrequestmessage.set_recommend(1);
        this.eXW.sendMessage(forumrecommendrequestmessage);
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            L(bundle);
            M(bundle);
            N(bundle);
            this.dnM = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.dnM.a(this);
            if (!TbadkCoreApplication.getInst().checkInterrupt()) {
                bfZ();
            }
        }
    }

    private void L(Bundle bundle) {
        this.cea = (BdBaseViewPager) this.mRootView.findViewById(R.id.enter_forum_viewpager);
        EnterForumTabPagerAdapter.a aVar = new EnterForumTabPagerAdapter.a();
        aVar.fragment = new EnterForumFragment();
        aVar.title = this.eXW.getResources().getString(R.string.attention);
        ((EnterForumFragment) aVar.fragment).setTabViewController(this);
        EnterForumTabPagerAdapter.a aVar2 = new EnterForumTabPagerAdapter.a();
        aVar2.fragment = new RecommendFragment();
        aVar2.title = this.eXW.getResources().getString(R.string.default_personalized_name);
        ((RecommendFragment) aVar2.fragment).setTabViewController(this);
        this.eYb = new ArrayList();
        this.eYb.add(aVar);
        this.eYb.add(aVar2);
        this.eYa = new EnterForumTabPagerAdapter(this.eXW.getActivity().getSupportFragmentManager(), this.eYb);
        this.cea.setAdapter(this.eYa);
        this.cea.setOffscreenPageLimit(this.eYb.size());
    }

    public void Dn() {
    }

    private void M(Bundle bundle) {
        this.eXX = (LinearLayout) LayoutInflater.from(this.eXW.getContext()).inflate(R.layout.enter_forum_tab_layout, (ViewGroup) null);
        this.eXY = (ForumHeaderView) this.eXX.findViewById(R.id.recommend_forum_header_serch_view);
        this.eXY.onChangeSkinType();
        this.eXZ = (PagerSlidingTabBaseStrip) this.eXX.findViewById(R.id.tab_layout);
        this.eXZ.d(l.g(this.eXW.getContext(), R.dimen.tbds44), l.g(this.eXW.getContext(), R.dimen.tbds68), l.g(this.eXW.getContext(), R.dimen.tbds30), true);
        this.eXZ.setViewPager(this.cea);
        this.eXZ.setOnPageChangeListener(this.mOnPageChangeListener);
    }

    private void N(Bundle bundle) {
        this.eYf = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.eYf.setNavHeight(this.mNavHeight);
        this.eYf.hideBottomLine();
        this.eYg = this.mRootView.findViewById(R.id.divider_shadow);
        qB(0);
        this.eYd = (ImageView) this.eXX.findViewById(R.id.navigationBarGoSignall);
        this.eYd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.isLogin()) {
                    bd.cE(c.this.getPageContext().getPageActivity());
                } else {
                    c.this.eXW.sendMessage(new CustomMessage(2002001, new SignAllForumActivityConfig(c.this.getPageContext().getPageActivity())));
                }
            }
        });
        this.eYe = (ImageView) this.eXX.findViewById(R.id.navigationBarGoSearch);
        this.eYe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.eXY.onClick(view);
            }
        });
        if (this.eXZ != null) {
            this.eYf.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, this.eXX, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.eXX.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(3);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(3);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 3;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.eXZ.setPadding(this.eXZ.getPaddingLeft(), this.eXZ.getPaddingTop(), this.eXZ.getPaddingRight(), this.eXZ.getBottom());
            this.eXZ.getLayoutParams().height = l.g(this.eXW.getContext(), R.dimen.tbds126);
            ((RelativeLayout.LayoutParams) this.eXZ.getLayoutParams()).setMargins(l.g(this.eXW.getContext(), R.dimen.tbds23), 0, 0, 0);
        }
    }

    public void a(PagerSlidingTabBaseStrip.a aVar) {
        if (this.eXZ != null && aVar != null) {
            this.eXZ.setOnTabItemClickListener(aVar);
        }
    }

    public void qy(int i) {
        if (i <= 2 && i >= 1) {
            this.eYj = i;
            this.cea.setCurrentItem(i - 1, true);
        }
    }

    public int bga() {
        return this.eYj;
    }

    public boolean qz(int i) {
        return this.eXZ != null && this.eYa.bfY() == i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        qA(this.cea.getCurrentItem());
        if (this.dnM != null) {
            this.dnM.onChangeSkinType(getPageContext(), i);
        }
        if (this.eYb != null && this.eYb.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.eYb.size()) {
                    break;
                }
                EnterForumTabPagerAdapter.a aVar = this.eYb.get(i3);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            }
        }
        this.eXZ.onChangeSkinType();
        this.eXY.onChangeSkinType();
    }

    public void bgb() {
        qA(this.cea.getCurrentItem());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, float f, int i2) {
        if (this.eYf != null) {
            if (i == 0) {
                if (i2 == 0) {
                    qA(i);
                } else if (this.eVA != null && this.eVA.eWf && this.eVA.eWh > 0) {
                    if (this.eYi != null && this.eYi.getRefreshView() != null && this.eYi.getRefreshView().isViewAttached()) {
                        am.h(this.eYf.getBarBgView(), R.color.cp_bg_line_d, TbadkCoreApplication.getInst().getSkinType());
                        return;
                    }
                    this.eYf.setBackgroundColor(0);
                    am.a(this.eYf.getBarBgView(), (int) R.color.cp_bg_line_d, f, TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (i2 == 0) {
                qA(i);
            } else if (this.eVA != null && this.eVA.eWf && this.eVA.eWh > 0) {
                if (this.eYi != null && this.eYi.getRefreshView() != null && this.eYi.getRefreshView().isViewAttached()) {
                    am.h(this.eYf.getBarBgView(), R.color.cp_bg_line_d, TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.eYf.setBackgroundColor(0);
                am.a(this.eYf.getBarBgView(), (int) R.color.cp_bg_line_d, 1.0f - f, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qA(int i) {
        int i2;
        if (this.eYd != null) {
            if (i == 0) {
                if (this.eVA != null && this.eVA.eWf && this.eVA.eWh > 0) {
                    if (this.eYi != null && this.eYi.getRefreshView() != null && this.eYi.getRefreshView().isViewAttached()) {
                        am.c(this.eYd, (int) R.drawable.icon_ba_sign_black);
                        am.c(this.eYe, (int) R.drawable.icon_ba_search_black);
                    } else if (this.eVA.eWi > 0 && this.eVA.eWh > this.eVA.eWi / 2) {
                        am.c(this.eYd, (int) R.drawable.icon_ba_sign_white);
                        am.c(this.eYe, (int) R.drawable.icon_ba_search_white);
                    } else {
                        am.c(this.eYd, (int) R.drawable.icon_ba_sign_black);
                        am.c(this.eYe, (int) R.drawable.icon_ba_search_black);
                    }
                } else {
                    am.c(this.eYd, (int) R.drawable.icon_ba_sign_black);
                    am.c(this.eYe, (int) R.drawable.icon_ba_search_black);
                }
            } else {
                am.c(this.eYd, (int) R.drawable.icon_ba_sign_black);
                am.c(this.eYe, (int) R.drawable.icon_ba_search_black);
            }
        }
        if (this.eYf != null) {
            this.eYf.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            if (i == 0) {
                if (this.eVA != null && this.eVA.eWf && this.eVA.eWh > 0) {
                    if (this.eYi != null && this.eYi.getRefreshView() != null && this.eYi.getRefreshView().isViewAttached()) {
                        am.h(this.eYf.getBarBgView(), R.color.cp_bg_line_d, TbadkCoreApplication.getInst().getSkinType());
                    } else {
                        if (this.eVA.eWi > 0) {
                            int i3 = (this.eVA.eWh * 255) / this.eVA.eWi;
                            if (i3 > 255) {
                                i3 = 255;
                            }
                            i2 = 255 - i3;
                        } else {
                            i2 = 0;
                        }
                        this.eYf.setBackgroundColor(0);
                        am.a(this.eYf.getBarBgView(), (int) R.color.cp_bg_line_d, i2 / 255.0f, TbadkCoreApplication.getInst().getSkinType());
                    }
                } else {
                    am.h(this.eYf.getBarBgView(), R.color.cp_bg_line_d, TbadkCoreApplication.getInst().getSkinType());
                }
            } else {
                am.h(this.eYf.getBarBgView(), R.color.cp_bg_line_d, TbadkCoreApplication.getInst().getSkinType());
            }
        }
        if (i == 0) {
            if (this.eVA != null && this.eVA.eWf && this.eVA.eWh > 0) {
                if (this.eVA.eWi > 0 && this.eVA.eWh > this.eVA.eWi / 2) {
                    if (this.eYi != null && this.eYi.getRefreshView() != null && this.eYi.getRefreshView().isViewAttached()) {
                        this.eXZ.setWhiteStyle(false);
                    } else {
                        this.eXZ.setWhiteStyle(true);
                    }
                    if (this.eXW.isPrimary()) {
                    }
                } else {
                    this.eXZ.setWhiteStyle(false);
                    if (this.eXW.isPrimary()) {
                    }
                }
            } else {
                this.eXZ.setWhiteStyle(false);
                if (this.eXW.isPrimary()) {
                }
            }
        } else {
            this.eXZ.setWhiteStyle(false);
            if (this.eXW.isPrimary()) {
            }
        }
        if (i == 0) {
            this.eXY.setAdState(this.eVA);
        } else {
            this.eXY.setAdState(null);
        }
        if (i == 0 && TbadkCoreApplication.getInst().getSkinType() != 1 && this.eXW.isPrimary() && this.eVA != null && this.eVA.eWf && i == 0) {
            if (this.eVA.eWh > this.eVA.eWi / 2) {
                if (this.eYc != null && this.eYc.eWh <= this.eVA.eWi / 2) {
                    ao.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
                }
            } else if (this.eYc != null && this.eYc.eWh >= this.eVA.eWi / 2) {
                ao.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            }
        }
    }

    public void bgc() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            ao.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
        } else if (this.cea.getCurrentItem() == 0 && this.eXW.isPrimary()) {
            if (this.eYi != null && this.eYi.getRefreshView() != null && this.eYi.getRefreshView().isViewAttached()) {
                ao.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            } else if (this.eVA != null && this.eVA.eWf) {
                if (this.eVA.eWh > this.eVA.eWi / 2 || this.eVA.eWh == 0) {
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
        if (this.eYb != null && this.eYb.size() > 0 && this.cea != null) {
            EnterForumTabPagerAdapter.a aVar = this.eYb.get(this.cea.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void bgd() {
        if (this.eXW != null && this.eYb != null && this.cea != null && this.eYa != null) {
            FragmentManager supportFragmentManager = this.eXW.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.eYb.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.cea.getId(), this.eYa.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.dnM != null) {
            this.dnM.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.eYa != null) {
            this.eYa.setPrimary(z);
        }
        if (this.eYb != null && this.eYb.size() > 0 && this.cea != null) {
            EnterForumTabPagerAdapter.a aVar = this.eYb.get(this.cea.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void ep(boolean z) {
        if (this.eYb != null && this.eYb.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.eYb.size()) {
                    break;
                }
                EnterForumTabPagerAdapter.a aVar = this.eYb.get(i2);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof NoNetworkView.a)) {
                    ((NoNetworkView.a) aVar.fragment).ep(z);
                }
                i = i2 + 1;
            }
        }
        qA(this.cea.getCurrentItem());
    }

    public void aJw() {
        if (this.eXX != null && this.eXX.getPaddingTop() < 0) {
            bge();
        } else if (this.eYg != null) {
            this.eYg.clearAnimation();
            if (this.eYg.getVisibility() != 0) {
                this.eYg.setVisibility(0);
                if (this.dpt == null) {
                    this.dpt = new AlphaAnimation(0.0f, 1.0f);
                    this.dpt.setFillAfter(true);
                    this.dpt.setDuration(300L);
                }
                this.eYg.startAnimation(this.dpt);
            }
        }
    }

    public void aJx() {
        if (this.eYg != null && this.eYg.getVisibility() != 8) {
            if (this.dpu == null) {
                this.dpu = new AlphaAnimation(1.0f, 0.0f);
                this.dpu.setFillAfter(true);
                this.dpu.setDuration(300L);
                this.dpu.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.enterForum.home.c.5
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.eYg.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.eYg.startAnimation(this.dpu);
        }
    }

    private void bge() {
        if (this.eYg != null && this.eYg.getVisibility() != 8) {
            this.eYg.clearAnimation();
            this.eYg.setVisibility(8);
        }
    }

    public void a(a aVar) {
        if (this.eYh == null) {
            this.eYh = new ArrayList();
        }
        this.eYh.add(aVar);
    }

    public void b(a aVar) {
        if (this.eYh != null && this.eYh.size() > 0) {
            this.eYh.remove(aVar);
        }
    }

    public void a(com.baidu.tieba.enterForum.view.b bVar) {
        this.eYi = bVar;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.b bVar) {
        this.eYc = this.eVA;
        this.eVA = bVar;
        this.eXY.setAdState(bVar);
        qA(this.cea.getCurrentItem());
    }

    public void setSearchHint(String str) {
        this.eXY.setSearchHint(str);
    }

    public View getRootView() {
        return getPageContext().getPageActivity().getWindow().getDecorView();
    }

    /* loaded from: classes4.dex */
    public static abstract class a {
        public void bgf() {
        }

        public void bgg() {
        }
    }

    public String getCurrentPageKey() {
        if (this.eYa != null) {
            return this.eYa.getCurrentPageKey();
        }
        return null;
    }

    public void d(View view, int i, int i2, int i3, int i4) {
    }

    private void qB(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eYg.getLayoutParams();
        layoutParams.topMargin = this.eYk + i;
        this.eYg.setLayoutParams(layoutParams);
    }
}
