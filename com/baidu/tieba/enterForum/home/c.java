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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.home.EnterForumTabPagerAdapter;
import com.baidu.tieba.enterForum.recommend.RecommendFragment;
import com.baidu.tieba.enterForum.view.EnterForumAdView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c extends com.baidu.adp.base.c implements NoNetworkView.a {
    private BdBaseViewPager ccQ;
    private NoNetworkView dlX;
    private AlphaAnimation dnm;
    private AlphaAnimation dnn;
    private com.baidu.tieba.enterForum.data.b eQt;
    private EnterForumTabFragment eSM;
    private PagerSlidingTabBaseStrip eSN;
    private EnterForumTabPagerAdapter eSO;
    private List<EnterForumTabPagerAdapter.a> eSP;
    private com.baidu.tieba.enterForum.data.b eSQ;
    private ImageView eSR;
    private NavigationBar eSS;
    private View eST;
    private List<a> eSU;
    private com.baidu.tieba.enterForum.view.b eSV;
    private com.baidu.adp.framework.listener.a eSW;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private View mRootView;

    public c(EnterForumTabFragment enterForumTabFragment) {
        super(enterForumTabFragment.getPageContext());
        this.eSW = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011) { // from class: com.baidu.tieba.enterForum.home.c.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String str = "";
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage = (forumRecommendSocketResponseMessage) responsedMessage;
                    if (forumrecommendsocketresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendsocketresponsemessage.getHotSearchInfoData().bdl();
                    }
                } else if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage = (forumRecommendHttpResponseMessage) responsedMessage;
                    if (forumrecommendhttpresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendhttpresponsemessage.getHotSearchInfoData().bdl();
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
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                c.this.qh(i);
                if (c.this.eSP != null && c.this.eSP.size() > i) {
                    if (c.this.eSV != null) {
                        c.this.eSV.beT();
                    }
                    EnterForumTabPagerAdapter.a aVar = (EnterForumTabPagerAdapter.a) c.this.eSP.get(i);
                    if (aVar != null && aVar.fragment != null) {
                        if (aVar.fragment instanceof RecommendFragment) {
                            if (c.this.eSU != null) {
                                for (a aVar2 : c.this.eSU) {
                                    aVar2.bea();
                                }
                            }
                        } else if ((aVar.fragment instanceof EnterForumFragment) && c.this.eSU != null) {
                            for (a aVar3 : c.this.eSU) {
                                aVar3.bdZ();
                            }
                        }
                        if (i == 0) {
                            TiebaStatic.log(new am("c13366").P("obj_locate", 1));
                        } else if (i == 1) {
                            TiebaStatic.log(new am("c13366").P("obj_locate", 2));
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
        this.eSM = enterForumTabFragment;
        this.eSM.registerListener(this.eSW);
    }

    private void bdV() {
        forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
        forumrecommendrequestmessage.set_like_forum(Integer.valueOf(TbadkCoreApplication.isLogin() ? 1 : 0));
        forumrecommendrequestmessage.set_topic(0);
        forumrecommendrequestmessage.set_recommend(1);
        this.eSM.sendMessage(forumrecommendrequestmessage);
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            L(bundle);
            M(bundle);
            N(bundle);
            this.dlX = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.dlX.a(this);
            if (!TbadkCoreApplication.getInst().checkInterrupt()) {
                bdV();
            }
        }
    }

    private void L(Bundle bundle) {
        this.ccQ = (BdBaseViewPager) this.mRootView.findViewById(R.id.enter_forum_viewpager);
        EnterForumTabPagerAdapter.a aVar = new EnterForumTabPagerAdapter.a();
        aVar.fragment = new EnterForumFragment();
        aVar.title = this.eSM.getResources().getString(R.string.attention);
        ((EnterForumFragment) aVar.fragment).setTabViewController(this);
        EnterForumTabPagerAdapter.a aVar2 = new EnterForumTabPagerAdapter.a();
        aVar2.fragment = new RecommendFragment();
        aVar2.title = this.eSM.getResources().getString(R.string.default_personalized_name);
        ((RecommendFragment) aVar2.fragment).setTabViewController(this);
        this.eSP = new ArrayList();
        this.eSP.add(aVar);
        this.eSP.add(aVar2);
        this.eSO = new EnterForumTabPagerAdapter(this.eSM.getActivity().getSupportFragmentManager(), this.eSP);
        this.ccQ.setAdapter(this.eSO);
        this.ccQ.setOffscreenPageLimit(this.eSP.size());
    }

    public void CE() {
    }

    private void M(Bundle bundle) {
        this.eSN = (PagerSlidingTabBaseStrip) LayoutInflater.from(this.eSM.getContext()).inflate(R.layout.enter_forum_tab_layout, (ViewGroup) null);
        this.eSN.d(l.g(this.eSM.getContext(), R.dimen.tbds44), l.g(this.eSM.getContext(), R.dimen.tbds68), l.g(this.eSM.getContext(), R.dimen.tbds30), true);
        this.eSN.setViewPager(this.ccQ);
        this.eSN.setOnPageChangeListener(this.mOnPageChangeListener);
    }

    private void N(Bundle bundle) {
        this.eSS = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.eSS.setNavHeight(l.g(this.mContext.getPageActivity(), R.dimen.ds94));
        this.eSS.hideBottomLine();
        this.eST = this.mRootView.findViewById(R.id.divider_shadow);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eST.getLayoutParams();
        layoutParams.topMargin = UtilHelper.getStatusBarHeight() + this.eSM.getPageContext().getResources().getDimensionPixelOffset(R.dimen.tbds140);
        this.eST.setLayoutParams(layoutParams);
        this.eSR = (ImageView) this.eSS.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_signall, new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.isLogin()) {
                    bc.cD(c.this.getPageContext().getPageActivity());
                } else {
                    c.this.eSM.sendMessage(new CustomMessage(2002001, new SignAllForumActivityConfig(c.this.getPageContext().getPageActivity())));
                }
            }
        });
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eSR.getLayoutParams();
        layoutParams2.setMargins(0, 0, l.g(getPageContext().getPageActivity(), R.dimen.tbds10), 0);
        this.eSR.setLayoutParams(layoutParams2);
        if (this.eSN != null) {
            this.eSS.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.eSN, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.eSN.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(3);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(3);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams3.gravity = 3;
                viewGroup.setLayoutParams(layoutParams3);
            }
            this.eSN.setPadding(this.eSN.getPaddingLeft(), this.eSN.getPaddingTop(), this.eSN.getPaddingRight(), this.eSN.getBottom());
            this.eSN.getLayoutParams().height = l.g(this.eSM.getContext(), R.dimen.ds94);
            ((LinearLayout.LayoutParams) this.eSN.getLayoutParams()).setMargins(l.g(this.eSM.getContext(), R.dimen.tbds23), 0, 0, 0);
        }
        this.eSS.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_CENTER).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.ccQ.getCurrentItem() == 0) {
                    EnterForumAdView.a(c.this.eSM.getPageContext().getUniqueId(), c.this.eSM.getPageContext().getPageActivity());
                }
            }
        });
    }

    public void a(PagerSlidingTabBaseStrip.a aVar) {
        if (this.eSN != null && aVar != null) {
            this.eSN.setOnTabItemClickListener(aVar);
        }
    }

    public void qf(int i) {
        if (i <= 2 && i >= 1) {
            this.ccQ.setCurrentItem(i - 1, true);
        }
    }

    public boolean qg(int i) {
        return this.eSN != null && this.eSO.bdU() == i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        qh(this.ccQ.getCurrentItem());
        if (this.dlX != null) {
            this.dlX.onChangeSkinType(getPageContext(), i);
        }
        if (this.eSP != null && this.eSP.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.eSP.size()) {
                    break;
                }
                EnterForumTabPagerAdapter.a aVar = this.eSP.get(i3);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            }
        }
        this.eSN.onChangeSkinType();
    }

    public void bdW() {
        qh(this.ccQ.getCurrentItem());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qh(int i) {
        int i2;
        if (this.eSR != null) {
            if (i == 0) {
                if (this.eQt != null && this.eQt.eQV && this.eQt.eQX > 0) {
                    if (this.eSV != null && this.eSV.getRefreshView() != null && this.eSV.getRefreshView().isViewAttached()) {
                        al.c(this.eSR, (int) R.drawable.icon_ba_sign_black);
                    } else if (this.eQt.eQY > 0 && this.eQt.eQX > this.eQt.eQY / 2) {
                        al.c(this.eSR, (int) R.drawable.icon_ba_sign_white);
                    } else {
                        al.c(this.eSR, (int) R.drawable.icon_ba_sign_black);
                    }
                } else {
                    al.c(this.eSR, (int) R.drawable.icon_ba_sign_black);
                }
            } else {
                al.c(this.eSR, (int) R.drawable.icon_ba_sign_black);
            }
        }
        if (this.eSS != null) {
            this.eSS.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            if (i == 0) {
                if (this.eQt != null && this.eQt.eQV && this.eQt.eQX > 0) {
                    if (this.eSV != null && this.eSV.getRefreshView() != null && this.eSV.getRefreshView().isViewAttached()) {
                        al.h(this.eSS.getBarBgView(), R.color.cp_bg_line_d, TbadkCoreApplication.getInst().getSkinType());
                    } else {
                        if (this.eQt.eQY > 0) {
                            int i3 = (this.eQt.eQX * 255) / this.eQt.eQY;
                            i2 = 255 - (i3 <= 255 ? i3 : 255);
                        } else {
                            i2 = 0;
                        }
                        this.eSS.setBackgroundColor(0);
                        al.a(this.eSS.getBarBgView(), (int) R.color.cp_bg_line_d, i2 / 255.0f, TbadkCoreApplication.getInst().getSkinType());
                    }
                } else {
                    al.h(this.eSS.getBarBgView(), R.color.cp_bg_line_d, TbadkCoreApplication.getInst().getSkinType());
                }
            } else {
                al.h(this.eSS.getBarBgView(), R.color.cp_bg_line_d, TbadkCoreApplication.getInst().getSkinType());
            }
        }
        if (i == 0) {
            if (this.eQt != null && this.eQt.eQV && this.eQt.eQX > 0) {
                if (this.eQt.eQY > 0 && this.eQt.eQX > this.eQt.eQY / 2) {
                    if (this.eSV != null && this.eSV.getRefreshView() != null && this.eSV.getRefreshView().isViewAttached()) {
                        this.eSN.setWhiteStyle(false);
                    } else {
                        this.eSN.setWhiteStyle(true);
                    }
                    if (this.eSM.isPrimary()) {
                    }
                } else {
                    this.eSN.setWhiteStyle(false);
                    if (this.eSM.isPrimary()) {
                    }
                }
            } else {
                this.eSN.setWhiteStyle(false);
                if (this.eSM.isPrimary()) {
                }
            }
        } else {
            this.eSN.setWhiteStyle(false);
            if (this.eSM.isPrimary()) {
            }
        }
        if (i == 0 && TbadkCoreApplication.getInst().getSkinType() != 1 && this.eSM.isPrimary() && this.eQt != null && this.eQt.eQV && i == 0) {
            if (this.eQt.eQX > this.eQt.eQY / 2) {
                if (this.eSQ != null && this.eSQ.eQX <= this.eQt.eQY / 2) {
                    an.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
                }
            } else if (this.eSQ != null && this.eSQ.eQX >= this.eQt.eQY / 2) {
                an.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            }
        }
    }

    public void bdX() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            an.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
        } else if (this.ccQ.getCurrentItem() == 0 && this.eSM.isPrimary()) {
            if (this.eSV != null && this.eSV.getRefreshView() != null && this.eSV.getRefreshView().isViewAttached()) {
                an.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            } else if (this.eQt != null && this.eQt.eQV) {
                if (this.eQt.eQX > this.eQt.eQY / 2 || this.eQt.eQX == 0) {
                    an.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
                } else {
                    an.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
                }
            } else {
                an.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            }
        } else {
            an.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.eSP != null && this.eSP.size() > 0 && this.ccQ != null) {
            EnterForumTabPagerAdapter.a aVar = this.eSP.get(this.ccQ.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void bdY() {
        if (this.eSM != null && this.eSP != null && this.ccQ != null && this.eSO != null) {
            FragmentManager supportFragmentManager = this.eSM.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.eSP.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.ccQ.getId(), this.eSO.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.dlX != null) {
            this.dlX.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.eSO != null) {
            this.eSO.setPrimary(z);
        }
        if (this.eSP != null && this.eSP.size() > 0 && this.ccQ != null) {
            EnterForumTabPagerAdapter.a aVar = this.eSP.get(this.ccQ.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void el(boolean z) {
        if (this.eSP != null && this.eSP.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.eSP.size()) {
                    break;
                }
                EnterForumTabPagerAdapter.a aVar = this.eSP.get(i2);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof NoNetworkView.a)) {
                    ((NoNetworkView.a) aVar.fragment).el(z);
                }
                i = i2 + 1;
            }
        }
        qh(this.ccQ.getCurrentItem());
    }

    public void aHU() {
        if (this.eST != null) {
            this.eST.clearAnimation();
            if (this.eST.getVisibility() != 0) {
                this.eST.setVisibility(0);
                if (this.dnm == null) {
                    this.dnm = new AlphaAnimation(0.0f, 1.0f);
                    this.dnm.setFillAfter(true);
                    this.dnm.setDuration(300L);
                }
                this.eST.startAnimation(this.dnm);
            }
        }
    }

    public void aHV() {
        if (this.eST != null && this.eST.getVisibility() != 8) {
            if (this.dnn == null) {
                this.dnn = new AlphaAnimation(1.0f, 0.0f);
                this.dnn.setFillAfter(true);
                this.dnn.setDuration(300L);
                this.dnn.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.enterForum.home.c.5
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.eST.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.eST.startAnimation(this.dnn);
        }
    }

    public void a(a aVar) {
        if (this.eSU == null) {
            this.eSU = new ArrayList();
        }
        this.eSU.add(aVar);
    }

    public void b(a aVar) {
        if (this.eSU != null && this.eSU.size() > 0) {
            this.eSU.remove(aVar);
        }
    }

    public void a(com.baidu.tieba.enterForum.view.b bVar) {
        this.eSV = bVar;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.b bVar) {
        this.eSQ = this.eQt;
        this.eQt = bVar;
        qh(this.ccQ.getCurrentItem());
    }

    /* loaded from: classes4.dex */
    public static abstract class a {
        public void bdZ() {
        }

        public void bea() {
        }
    }

    public String getCurrentPageKey() {
        if (this.eSO != null) {
            return this.eSO.getCurrentPageKey();
        }
        return null;
    }
}
