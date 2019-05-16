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
    private NoNetworkView dlW;
    private AlphaAnimation dnl;
    private AlphaAnimation dnm;
    private com.baidu.tieba.enterForum.data.b eQs;
    private EnterForumTabFragment eSL;
    private PagerSlidingTabBaseStrip eSM;
    private EnterForumTabPagerAdapter eSN;
    private List<EnterForumTabPagerAdapter.a> eSO;
    private com.baidu.tieba.enterForum.data.b eSP;
    private ImageView eSQ;
    private NavigationBar eSR;
    private View eSS;
    private List<a> eST;
    private com.baidu.tieba.enterForum.view.b eSU;
    private com.baidu.adp.framework.listener.a eSV;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private View mRootView;

    public c(EnterForumTabFragment enterForumTabFragment) {
        super(enterForumTabFragment.getPageContext());
        this.eSV = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011) { // from class: com.baidu.tieba.enterForum.home.c.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String str = "";
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage = (forumRecommendSocketResponseMessage) responsedMessage;
                    if (forumrecommendsocketresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendsocketresponsemessage.getHotSearchInfoData().bdi();
                    }
                } else if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage = (forumRecommendHttpResponseMessage) responsedMessage;
                    if (forumrecommendhttpresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendhttpresponsemessage.getHotSearchInfoData().bdi();
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
                if (c.this.eSO != null && c.this.eSO.size() > i) {
                    if (c.this.eSU != null) {
                        c.this.eSU.beQ();
                    }
                    EnterForumTabPagerAdapter.a aVar = (EnterForumTabPagerAdapter.a) c.this.eSO.get(i);
                    if (aVar != null && aVar.fragment != null) {
                        if (aVar.fragment instanceof RecommendFragment) {
                            if (c.this.eST != null) {
                                for (a aVar2 : c.this.eST) {
                                    aVar2.bdX();
                                }
                            }
                        } else if ((aVar.fragment instanceof EnterForumFragment) && c.this.eST != null) {
                            for (a aVar3 : c.this.eST) {
                                aVar3.bdW();
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
        this.eSL = enterForumTabFragment;
        this.eSL.registerListener(this.eSV);
    }

    private void bdS() {
        forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
        forumrecommendrequestmessage.set_like_forum(Integer.valueOf(TbadkCoreApplication.isLogin() ? 1 : 0));
        forumrecommendrequestmessage.set_topic(0);
        forumrecommendrequestmessage.set_recommend(1);
        this.eSL.sendMessage(forumrecommendrequestmessage);
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            L(bundle);
            M(bundle);
            N(bundle);
            this.dlW = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.dlW.a(this);
            bdS();
        }
    }

    private void L(Bundle bundle) {
        this.ccQ = (BdBaseViewPager) this.mRootView.findViewById(R.id.enter_forum_viewpager);
        EnterForumTabPagerAdapter.a aVar = new EnterForumTabPagerAdapter.a();
        aVar.fragment = new EnterForumFragment();
        aVar.title = this.eSL.getResources().getString(R.string.attention);
        ((EnterForumFragment) aVar.fragment).setTabViewController(this);
        EnterForumTabPagerAdapter.a aVar2 = new EnterForumTabPagerAdapter.a();
        aVar2.fragment = new RecommendFragment();
        aVar2.title = this.eSL.getResources().getString(R.string.default_personalized_name);
        ((RecommendFragment) aVar2.fragment).setTabViewController(this);
        this.eSO = new ArrayList();
        this.eSO.add(aVar);
        this.eSO.add(aVar2);
        this.eSN = new EnterForumTabPagerAdapter(this.eSL.getActivity().getSupportFragmentManager(), this.eSO);
        this.ccQ.setAdapter(this.eSN);
        this.ccQ.setOffscreenPageLimit(this.eSO.size());
    }

    public void CE() {
    }

    private void M(Bundle bundle) {
        this.eSM = (PagerSlidingTabBaseStrip) LayoutInflater.from(this.eSL.getContext()).inflate(R.layout.enter_forum_tab_layout, (ViewGroup) null);
        this.eSM.d(l.g(this.eSL.getContext(), R.dimen.tbds44), l.g(this.eSL.getContext(), R.dimen.tbds68), l.g(this.eSL.getContext(), R.dimen.tbds30), true);
        this.eSM.setViewPager(this.ccQ);
        this.eSM.setOnPageChangeListener(this.mOnPageChangeListener);
    }

    private void N(Bundle bundle) {
        this.eSR = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.eSR.setNavHeight(l.g(this.mContext.getPageActivity(), R.dimen.ds94));
        this.eSR.hideBottomLine();
        this.eSS = this.mRootView.findViewById(R.id.divider_shadow);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eSS.getLayoutParams();
        layoutParams.topMargin = UtilHelper.getStatusBarHeight() + this.eSL.getPageContext().getResources().getDimensionPixelOffset(R.dimen.tbds140);
        this.eSS.setLayoutParams(layoutParams);
        this.eSQ = (ImageView) this.eSR.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_signall, new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.isLogin()) {
                    bc.cD(c.this.getPageContext().getPageActivity());
                } else {
                    c.this.eSL.sendMessage(new CustomMessage(2002001, new SignAllForumActivityConfig(c.this.getPageContext().getPageActivity())));
                }
            }
        });
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eSQ.getLayoutParams();
        layoutParams2.setMargins(0, 0, l.g(getPageContext().getPageActivity(), R.dimen.tbds10), 0);
        this.eSQ.setLayoutParams(layoutParams2);
        if (this.eSM != null) {
            this.eSR.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.eSM, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.eSM.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(3);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(3);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams3.gravity = 3;
                viewGroup.setLayoutParams(layoutParams3);
            }
            this.eSM.setPadding(this.eSM.getPaddingLeft(), this.eSM.getPaddingTop(), this.eSM.getPaddingRight(), this.eSM.getBottom());
            this.eSM.getLayoutParams().height = l.g(this.eSL.getContext(), R.dimen.ds94);
            ((LinearLayout.LayoutParams) this.eSM.getLayoutParams()).setMargins(l.g(this.eSL.getContext(), R.dimen.tbds23), 0, 0, 0);
        }
        this.eSR.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_CENTER).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.ccQ.getCurrentItem() == 0) {
                    EnterForumAdView.a(c.this.eSL.getPageContext().getUniqueId(), c.this.eSL.getPageContext().getPageActivity());
                }
            }
        });
    }

    public void a(PagerSlidingTabBaseStrip.a aVar) {
        if (this.eSM != null && aVar != null) {
            this.eSM.setOnTabItemClickListener(aVar);
        }
    }

    public void qf(int i) {
        if (i <= 2 && i >= 1) {
            this.ccQ.setCurrentItem(i - 1, true);
        }
    }

    public boolean qg(int i) {
        return this.eSM != null && this.eSN.bdR() == i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        qh(this.ccQ.getCurrentItem());
        if (this.dlW != null) {
            this.dlW.onChangeSkinType(getPageContext(), i);
        }
        if (this.eSO != null && this.eSO.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.eSO.size()) {
                    break;
                }
                EnterForumTabPagerAdapter.a aVar = this.eSO.get(i3);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            }
        }
        this.eSM.onChangeSkinType();
    }

    public void bdT() {
        qh(this.ccQ.getCurrentItem());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qh(int i) {
        int i2;
        if (this.eSQ != null) {
            if (i == 0) {
                if (this.eQs != null && this.eQs.eQU && this.eQs.eQW > 0) {
                    if (this.eSU != null && this.eSU.getRefreshView() != null && this.eSU.getRefreshView().isViewAttached()) {
                        al.c(this.eSQ, (int) R.drawable.icon_ba_sign_black);
                    } else if (this.eQs.eQX > 0 && this.eQs.eQW > this.eQs.eQX / 2) {
                        al.c(this.eSQ, (int) R.drawable.icon_ba_sign_white);
                    } else {
                        al.c(this.eSQ, (int) R.drawable.icon_ba_sign_black);
                    }
                } else {
                    al.c(this.eSQ, (int) R.drawable.icon_ba_sign_black);
                }
            } else {
                al.c(this.eSQ, (int) R.drawable.icon_ba_sign_black);
            }
        }
        if (this.eSR != null) {
            this.eSR.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            if (i == 0) {
                if (this.eQs != null && this.eQs.eQU && this.eQs.eQW > 0) {
                    if (this.eSU != null && this.eSU.getRefreshView() != null && this.eSU.getRefreshView().isViewAttached()) {
                        al.h(this.eSR.getBarBgView(), R.color.cp_bg_line_d, TbadkCoreApplication.getInst().getSkinType());
                    } else {
                        if (this.eQs.eQX > 0) {
                            int i3 = (this.eQs.eQW * 255) / this.eQs.eQX;
                            i2 = 255 - (i3 <= 255 ? i3 : 255);
                        } else {
                            i2 = 0;
                        }
                        this.eSR.setBackgroundColor(0);
                        al.a(this.eSR.getBarBgView(), (int) R.color.cp_bg_line_d, i2 / 255.0f, TbadkCoreApplication.getInst().getSkinType());
                    }
                } else {
                    al.h(this.eSR.getBarBgView(), R.color.cp_bg_line_d, TbadkCoreApplication.getInst().getSkinType());
                }
            } else {
                al.h(this.eSR.getBarBgView(), R.color.cp_bg_line_d, TbadkCoreApplication.getInst().getSkinType());
            }
        }
        if (i == 0) {
            if (this.eQs != null && this.eQs.eQU && this.eQs.eQW > 0) {
                if (this.eQs.eQX > 0 && this.eQs.eQW > this.eQs.eQX / 2) {
                    if (this.eSU != null && this.eSU.getRefreshView() != null && this.eSU.getRefreshView().isViewAttached()) {
                        this.eSM.setWhiteStyle(false);
                    } else {
                        this.eSM.setWhiteStyle(true);
                    }
                    if (this.eSL.isPrimary()) {
                    }
                } else {
                    this.eSM.setWhiteStyle(false);
                    if (this.eSL.isPrimary()) {
                    }
                }
            } else {
                this.eSM.setWhiteStyle(false);
                if (this.eSL.isPrimary()) {
                }
            }
        } else {
            this.eSM.setWhiteStyle(false);
            if (this.eSL.isPrimary()) {
            }
        }
        if (i == 0 && TbadkCoreApplication.getInst().getSkinType() != 1 && this.eSL.isPrimary() && this.eQs != null && this.eQs.eQU && i == 0) {
            if (this.eQs.eQW > this.eQs.eQX / 2) {
                if (this.eSP != null && this.eSP.eQW <= this.eQs.eQX / 2) {
                    an.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
                }
            } else if (this.eSP != null && this.eSP.eQW >= this.eQs.eQX / 2) {
                an.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            }
        }
    }

    public void bdU() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            an.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
        } else if (this.ccQ.getCurrentItem() == 0 && this.eSL.isPrimary()) {
            if (this.eSU != null && this.eSU.getRefreshView() != null && this.eSU.getRefreshView().isViewAttached()) {
                an.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            } else if (this.eQs != null && this.eQs.eQU) {
                if (this.eQs.eQW > this.eQs.eQX / 2 || this.eQs.eQW == 0) {
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
        if (this.eSO != null && this.eSO.size() > 0 && this.ccQ != null) {
            EnterForumTabPagerAdapter.a aVar = this.eSO.get(this.ccQ.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void bdV() {
        if (this.eSL != null && this.eSO != null && this.ccQ != null && this.eSN != null) {
            FragmentManager supportFragmentManager = this.eSL.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.eSO.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.ccQ.getId(), this.eSN.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.dlW != null) {
            this.dlW.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.eSN != null) {
            this.eSN.setPrimary(z);
        }
        if (this.eSO != null && this.eSO.size() > 0 && this.ccQ != null) {
            EnterForumTabPagerAdapter.a aVar = this.eSO.get(this.ccQ.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void el(boolean z) {
        if (this.eSO != null && this.eSO.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.eSO.size()) {
                    break;
                }
                EnterForumTabPagerAdapter.a aVar = this.eSO.get(i2);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof NoNetworkView.a)) {
                    ((NoNetworkView.a) aVar.fragment).el(z);
                }
                i = i2 + 1;
            }
        }
        qh(this.ccQ.getCurrentItem());
    }

    public void aHR() {
        if (this.eSS != null) {
            this.eSS.clearAnimation();
            if (this.eSS.getVisibility() != 0) {
                this.eSS.setVisibility(0);
                if (this.dnl == null) {
                    this.dnl = new AlphaAnimation(0.0f, 1.0f);
                    this.dnl.setFillAfter(true);
                    this.dnl.setDuration(300L);
                }
                this.eSS.startAnimation(this.dnl);
            }
        }
    }

    public void aHS() {
        if (this.eSS != null && this.eSS.getVisibility() != 8) {
            if (this.dnm == null) {
                this.dnm = new AlphaAnimation(1.0f, 0.0f);
                this.dnm.setFillAfter(true);
                this.dnm.setDuration(300L);
                this.dnm.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.enterForum.home.c.5
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.eSS.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.eSS.startAnimation(this.dnm);
        }
    }

    public void a(a aVar) {
        if (this.eST == null) {
            this.eST = new ArrayList();
        }
        this.eST.add(aVar);
    }

    public void b(a aVar) {
        if (this.eST != null && this.eST.size() > 0) {
            this.eST.remove(aVar);
        }
    }

    public void a(com.baidu.tieba.enterForum.view.b bVar) {
        this.eSU = bVar;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.b bVar) {
        this.eSP = this.eQs;
        this.eQs = bVar;
        qh(this.ccQ.getCurrentItem());
    }

    /* loaded from: classes4.dex */
    public static abstract class a {
        public void bdW() {
        }

        public void bdX() {
        }
    }

    public String getCurrentPageKey() {
        if (this.eSN != null) {
            return this.eSN.getCurrentPageKey();
        }
        return null;
    }
}
