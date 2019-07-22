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
import com.baidu.tieba.enterForum.view.EnterForumAdView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c extends com.baidu.adp.base.c implements NoNetworkView.a {
    private BdBaseViewPager cdT;
    private NoNetworkView dnF;
    private AlphaAnimation dpm;
    private AlphaAnimation dpn;
    private com.baidu.tieba.enterForum.data.b eVt;
    private EnterForumTabFragment eXM;
    private PagerSlidingTabBaseStrip eXN;
    private EnterForumTabPagerAdapter eXO;
    private List<EnterForumTabPagerAdapter.a> eXP;
    private com.baidu.tieba.enterForum.data.b eXQ;
    private ImageView eXR;
    private NavigationBar eXS;
    private View eXT;
    private List<a> eXU;
    private com.baidu.tieba.enterForum.view.b eXV;
    private int eXW;
    private com.baidu.adp.framework.listener.a eXX;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private View mRootView;

    public c(EnterForumTabFragment enterForumTabFragment) {
        super(enterForumTabFragment.getPageContext());
        this.eXW = -1;
        this.eXX = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011) { // from class: com.baidu.tieba.enterForum.home.c.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String str = "";
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage = (forumRecommendSocketResponseMessage) responsedMessage;
                    if (forumrecommendsocketresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendsocketresponsemessage.getHotSearchInfoData().bfn();
                    }
                } else if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage = (forumRecommendHttpResponseMessage) responsedMessage;
                    if (forumrecommendhttpresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendhttpresponsemessage.getHotSearchInfoData().bfn();
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
                c.this.qz(i);
                if (c.this.eXP != null && c.this.eXP.size() > i) {
                    if (c.this.eXV != null) {
                        c.this.eXV.bgW();
                    }
                    EnterForumTabPagerAdapter.a aVar = (EnterForumTabPagerAdapter.a) c.this.eXP.get(i);
                    if (aVar != null && aVar.fragment != null) {
                        if (aVar.fragment instanceof RecommendFragment) {
                            if (c.this.eXU != null) {
                                for (a aVar2 : c.this.eXU) {
                                    aVar2.bgd();
                                }
                            }
                        } else if ((aVar.fragment instanceof EnterForumFragment) && c.this.eXU != null) {
                            for (a aVar3 : c.this.eXU) {
                                aVar3.bgc();
                            }
                        }
                        if (i == 0) {
                            c.this.eXW = 1;
                            TiebaStatic.log(new an("c13366").P("obj_locate", 1));
                        } else if (i == 1) {
                            c.this.eXW = 2;
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
        this.eXM = enterForumTabFragment;
        this.eXM.registerListener(this.eXX);
    }

    private void bfX() {
        forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
        forumrecommendrequestmessage.set_like_forum(Integer.valueOf(TbadkCoreApplication.isLogin() ? 1 : 0));
        forumrecommendrequestmessage.set_topic(0);
        forumrecommendrequestmessage.set_recommend(1);
        this.eXM.sendMessage(forumrecommendrequestmessage);
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            L(bundle);
            M(bundle);
            N(bundle);
            this.dnF = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.dnF.a(this);
            if (!TbadkCoreApplication.getInst().checkInterrupt()) {
                bfX();
            }
        }
    }

    private void L(Bundle bundle) {
        this.cdT = (BdBaseViewPager) this.mRootView.findViewById(R.id.enter_forum_viewpager);
        EnterForumTabPagerAdapter.a aVar = new EnterForumTabPagerAdapter.a();
        aVar.fragment = new EnterForumFragment();
        aVar.title = this.eXM.getResources().getString(R.string.attention);
        ((EnterForumFragment) aVar.fragment).setTabViewController(this);
        EnterForumTabPagerAdapter.a aVar2 = new EnterForumTabPagerAdapter.a();
        aVar2.fragment = new RecommendFragment();
        aVar2.title = this.eXM.getResources().getString(R.string.default_personalized_name);
        ((RecommendFragment) aVar2.fragment).setTabViewController(this);
        this.eXP = new ArrayList();
        this.eXP.add(aVar);
        this.eXP.add(aVar2);
        this.eXO = new EnterForumTabPagerAdapter(this.eXM.getActivity().getSupportFragmentManager(), this.eXP);
        this.cdT.setAdapter(this.eXO);
        this.cdT.setOffscreenPageLimit(this.eXP.size());
    }

    public void Dn() {
    }

    private void M(Bundle bundle) {
        this.eXN = (PagerSlidingTabBaseStrip) LayoutInflater.from(this.eXM.getContext()).inflate(R.layout.enter_forum_tab_layout, (ViewGroup) null);
        this.eXN.d(l.g(this.eXM.getContext(), R.dimen.tbds44), l.g(this.eXM.getContext(), R.dimen.tbds68), l.g(this.eXM.getContext(), R.dimen.tbds30), true);
        this.eXN.setViewPager(this.cdT);
        this.eXN.setOnPageChangeListener(this.mOnPageChangeListener);
    }

    private void N(Bundle bundle) {
        this.eXS = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.eXS.setNavHeight(l.g(this.mContext.getPageActivity(), R.dimen.ds94));
        this.eXS.hideBottomLine();
        this.eXT = this.mRootView.findViewById(R.id.divider_shadow);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eXT.getLayoutParams();
        layoutParams.topMargin = UtilHelper.getStatusBarHeight() + this.eXM.getPageContext().getResources().getDimensionPixelOffset(R.dimen.tbds140);
        this.eXT.setLayoutParams(layoutParams);
        this.eXR = (ImageView) this.eXS.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_signall, new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.isLogin()) {
                    bd.cE(c.this.getPageContext().getPageActivity());
                } else {
                    c.this.eXM.sendMessage(new CustomMessage(2002001, new SignAllForumActivityConfig(c.this.getPageContext().getPageActivity())));
                }
            }
        });
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eXR.getLayoutParams();
        layoutParams2.setMargins(0, 0, l.g(getPageContext().getPageActivity(), R.dimen.tbds10), 0);
        this.eXR.setLayoutParams(layoutParams2);
        if (this.eXN != null) {
            this.eXS.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.eXN, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.eXN.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(3);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(3);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams3.gravity = 3;
                viewGroup.setLayoutParams(layoutParams3);
            }
            this.eXN.setPadding(this.eXN.getPaddingLeft(), this.eXN.getPaddingTop(), this.eXN.getPaddingRight(), this.eXN.getBottom());
            this.eXN.getLayoutParams().height = l.g(this.eXM.getContext(), R.dimen.ds94);
            ((LinearLayout.LayoutParams) this.eXN.getLayoutParams()).setMargins(l.g(this.eXM.getContext(), R.dimen.tbds23), 0, 0, 0);
        }
        this.eXS.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_CENTER).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.cdT.getCurrentItem() == 0) {
                    EnterForumAdView.a(c.this.eXM.getPageContext().getUniqueId(), c.this.eXM.getPageContext().getPageActivity());
                }
            }
        });
    }

    public void a(PagerSlidingTabBaseStrip.a aVar) {
        if (this.eXN != null && aVar != null) {
            this.eXN.setOnTabItemClickListener(aVar);
        }
    }

    public void qx(int i) {
        if (i <= 2 && i >= 1) {
            this.eXW = i;
            this.cdT.setCurrentItem(i - 1, true);
        }
    }

    public int bfY() {
        return this.eXW;
    }

    public boolean qy(int i) {
        return this.eXN != null && this.eXO.bfW() == i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        qz(this.cdT.getCurrentItem());
        if (this.dnF != null) {
            this.dnF.onChangeSkinType(getPageContext(), i);
        }
        if (this.eXP != null && this.eXP.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.eXP.size()) {
                    break;
                }
                EnterForumTabPagerAdapter.a aVar = this.eXP.get(i3);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            }
        }
        this.eXN.onChangeSkinType();
    }

    public void bfZ() {
        qz(this.cdT.getCurrentItem());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qz(int i) {
        int i2;
        if (this.eXR != null) {
            if (i == 0) {
                if (this.eVt != null && this.eVt.eVV && this.eVt.eVX > 0) {
                    if (this.eXV != null && this.eXV.getRefreshView() != null && this.eXV.getRefreshView().isViewAttached()) {
                        am.c(this.eXR, (int) R.drawable.icon_ba_sign_black);
                    } else if (this.eVt.eVY > 0 && this.eVt.eVX > this.eVt.eVY / 2) {
                        am.c(this.eXR, (int) R.drawable.icon_ba_sign_white);
                    } else {
                        am.c(this.eXR, (int) R.drawable.icon_ba_sign_black);
                    }
                } else {
                    am.c(this.eXR, (int) R.drawable.icon_ba_sign_black);
                }
            } else {
                am.c(this.eXR, (int) R.drawable.icon_ba_sign_black);
            }
        }
        if (this.eXS != null) {
            this.eXS.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            if (i == 0) {
                if (this.eVt != null && this.eVt.eVV && this.eVt.eVX > 0) {
                    if (this.eXV != null && this.eXV.getRefreshView() != null && this.eXV.getRefreshView().isViewAttached()) {
                        am.h(this.eXS.getBarBgView(), R.color.cp_bg_line_d, TbadkCoreApplication.getInst().getSkinType());
                    } else {
                        if (this.eVt.eVY > 0) {
                            int i3 = (this.eVt.eVX * 255) / this.eVt.eVY;
                            i2 = 255 - (i3 <= 255 ? i3 : 255);
                        } else {
                            i2 = 0;
                        }
                        this.eXS.setBackgroundColor(0);
                        am.a(this.eXS.getBarBgView(), (int) R.color.cp_bg_line_d, i2 / 255.0f, TbadkCoreApplication.getInst().getSkinType());
                    }
                } else {
                    am.h(this.eXS.getBarBgView(), R.color.cp_bg_line_d, TbadkCoreApplication.getInst().getSkinType());
                }
            } else {
                am.h(this.eXS.getBarBgView(), R.color.cp_bg_line_d, TbadkCoreApplication.getInst().getSkinType());
            }
        }
        if (i == 0) {
            if (this.eVt != null && this.eVt.eVV && this.eVt.eVX > 0) {
                if (this.eVt.eVY > 0 && this.eVt.eVX > this.eVt.eVY / 2) {
                    if (this.eXV != null && this.eXV.getRefreshView() != null && this.eXV.getRefreshView().isViewAttached()) {
                        this.eXN.setWhiteStyle(false);
                    } else {
                        this.eXN.setWhiteStyle(true);
                    }
                    if (this.eXM.isPrimary()) {
                    }
                } else {
                    this.eXN.setWhiteStyle(false);
                    if (this.eXM.isPrimary()) {
                    }
                }
            } else {
                this.eXN.setWhiteStyle(false);
                if (this.eXM.isPrimary()) {
                }
            }
        } else {
            this.eXN.setWhiteStyle(false);
            if (this.eXM.isPrimary()) {
            }
        }
        if (i == 0 && TbadkCoreApplication.getInst().getSkinType() != 1 && this.eXM.isPrimary() && this.eVt != null && this.eVt.eVV && i == 0) {
            if (this.eVt.eVX > this.eVt.eVY / 2) {
                if (this.eXQ != null && this.eXQ.eVX <= this.eVt.eVY / 2) {
                    ao.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
                }
            } else if (this.eXQ != null && this.eXQ.eVX >= this.eVt.eVY / 2) {
                ao.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            }
        }
    }

    public void bga() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            ao.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
        } else if (this.cdT.getCurrentItem() == 0 && this.eXM.isPrimary()) {
            if (this.eXV != null && this.eXV.getRefreshView() != null && this.eXV.getRefreshView().isViewAttached()) {
                ao.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            } else if (this.eVt != null && this.eVt.eVV) {
                if (this.eVt.eVX > this.eVt.eVY / 2 || this.eVt.eVX == 0) {
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
        if (this.eXP != null && this.eXP.size() > 0 && this.cdT != null) {
            EnterForumTabPagerAdapter.a aVar = this.eXP.get(this.cdT.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void bgb() {
        if (this.eXM != null && this.eXP != null && this.cdT != null && this.eXO != null) {
            FragmentManager supportFragmentManager = this.eXM.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.eXP.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.cdT.getId(), this.eXO.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.dnF != null) {
            this.dnF.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.eXO != null) {
            this.eXO.setPrimary(z);
        }
        if (this.eXP != null && this.eXP.size() > 0 && this.cdT != null) {
            EnterForumTabPagerAdapter.a aVar = this.eXP.get(this.cdT.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void ep(boolean z) {
        if (this.eXP != null && this.eXP.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.eXP.size()) {
                    break;
                }
                EnterForumTabPagerAdapter.a aVar = this.eXP.get(i2);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof NoNetworkView.a)) {
                    ((NoNetworkView.a) aVar.fragment).ep(z);
                }
                i = i2 + 1;
            }
        }
        qz(this.cdT.getCurrentItem());
    }

    public void aJu() {
        if (this.eXT != null) {
            this.eXT.clearAnimation();
            if (this.eXT.getVisibility() != 0) {
                this.eXT.setVisibility(0);
                if (this.dpm == null) {
                    this.dpm = new AlphaAnimation(0.0f, 1.0f);
                    this.dpm.setFillAfter(true);
                    this.dpm.setDuration(300L);
                }
                this.eXT.startAnimation(this.dpm);
            }
        }
    }

    public void aJv() {
        if (this.eXT != null && this.eXT.getVisibility() != 8) {
            if (this.dpn == null) {
                this.dpn = new AlphaAnimation(1.0f, 0.0f);
                this.dpn.setFillAfter(true);
                this.dpn.setDuration(300L);
                this.dpn.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.enterForum.home.c.5
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.eXT.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.eXT.startAnimation(this.dpn);
        }
    }

    public void a(a aVar) {
        if (this.eXU == null) {
            this.eXU = new ArrayList();
        }
        this.eXU.add(aVar);
    }

    public void b(a aVar) {
        if (this.eXU != null && this.eXU.size() > 0) {
            this.eXU.remove(aVar);
        }
    }

    public void a(com.baidu.tieba.enterForum.view.b bVar) {
        this.eXV = bVar;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.b bVar) {
        this.eXQ = this.eVt;
        this.eVt = bVar;
        qz(this.cdT.getCurrentItem());
    }

    /* loaded from: classes4.dex */
    public static abstract class a {
        public void bgc() {
        }

        public void bgd() {
        }
    }

    public String getCurrentPageKey() {
        if (this.eXO != null) {
            return this.eXO.getCurrentPageKey();
        }
        return null;
    }
}
