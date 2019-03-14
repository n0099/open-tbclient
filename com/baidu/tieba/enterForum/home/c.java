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
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SignAllForumActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip;
import com.baidu.tieba.d;
import com.baidu.tieba.enterForum.home.EnterForumTabPagerAdapter;
import com.baidu.tieba.enterForum.recommend.RecommendFragment;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c extends com.baidu.adp.base.c implements NoNetworkView.a {
    private BdBaseViewPager bUS;
    private NoNetworkView dbm;
    private AlphaAnimation dcE;
    private AlphaAnimation dcF;
    private EnterForumTabFragment eDk;
    private PagerSlidingTabBaseStrip eDl;
    private EnterForumTabPagerAdapter eDm;
    private List<EnterForumTabPagerAdapter.a> eDn;
    private ImageView eDo;
    private NavigationBar eDp;
    private View eDq;
    private List<a> eDr;
    private com.baidu.adp.framework.listener.a eDs;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private View mRootView;

    public c(EnterForumTabFragment enterForumTabFragment) {
        super(enterForumTabFragment.getPageContext());
        this.eDs = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011) { // from class: com.baidu.tieba.enterForum.home.c.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String str = "";
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage = (forumRecommendSocketResponseMessage) responsedMessage;
                    if (forumrecommendsocketresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendsocketresponsemessage.getHotSearchInfoData().aWi();
                    }
                } else if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage = (forumRecommendHttpResponseMessage) responsedMessage;
                    if (forumrecommendhttpresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendhttpresponsemessage.getHotSearchInfoData().aWi();
                    }
                }
                if (TextUtils.isEmpty(str)) {
                    str = c.this.mContext.getResources().getString(d.j.enter_forum_search_tip);
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
                EnterForumTabPagerAdapter.a aVar;
                if (c.this.eDn != null && c.this.eDn.size() > i && (aVar = (EnterForumTabPagerAdapter.a) c.this.eDn.get(i)) != null && aVar.fragment != null) {
                    if (aVar.fragment instanceof RecommendFragment) {
                        if (c.this.eDr != null) {
                            for (a aVar2 : c.this.eDr) {
                                aVar2.aWM();
                            }
                        }
                    } else if ((aVar.fragment instanceof EnterForumFragment) && c.this.eDr != null) {
                        for (a aVar3 : c.this.eDr) {
                            aVar3.aWL();
                        }
                    }
                    if (i == 0) {
                        TiebaStatic.log(new am("c13366").T("obj_locate", 1));
                    } else if (i == 1) {
                        TiebaStatic.log(new am("c13366").T("obj_locate", 2));
                    }
                    if (i == 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921386));
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        };
        this.eDk = enterForumTabFragment;
        this.eDk.registerListener(this.eDs);
    }

    private void aWJ() {
        forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
        forumrecommendrequestmessage.set_like_forum(Integer.valueOf(TbadkCoreApplication.isLogin() ? 1 : 0));
        forumrecommendrequestmessage.set_topic(0);
        forumrecommendrequestmessage.set_recommend(1);
        this.eDk.sendMessage(forumrecommendrequestmessage);
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            K(bundle);
            L(bundle);
            M(bundle);
            this.dbm = (NoNetworkView) this.mRootView.findViewById(d.g.view_no_network);
            this.dbm.a(this);
            aWJ();
        }
    }

    private void K(Bundle bundle) {
        this.bUS = (BdBaseViewPager) this.mRootView.findViewById(d.g.enter_forum_viewpager);
        EnterForumTabPagerAdapter.a aVar = new EnterForumTabPagerAdapter.a();
        aVar.fragment = new EnterForumFragment();
        aVar.title = this.eDk.getResources().getString(d.j.attention);
        ((EnterForumFragment) aVar.fragment).setTabViewController(this);
        EnterForumTabPagerAdapter.a aVar2 = new EnterForumTabPagerAdapter.a();
        aVar2.fragment = new RecommendFragment();
        aVar2.title = this.eDk.getResources().getString(d.j.default_personalized_name);
        ((RecommendFragment) aVar2.fragment).setTabViewController(this);
        this.eDn = new ArrayList();
        this.eDn.add(aVar);
        this.eDn.add(aVar2);
        this.eDm = new EnterForumTabPagerAdapter(this.eDk.getActivity().getSupportFragmentManager(), this.eDn);
        this.bUS.setAdapter(this.eDm);
        this.bUS.setOffscreenPageLimit(this.eDn.size());
    }

    public void BE() {
    }

    private void L(Bundle bundle) {
        this.eDl = (PagerSlidingTabBaseStrip) LayoutInflater.from(this.eDk.getContext()).inflate(d.h.enter_forum_tab_layout, (ViewGroup) null);
        this.eDl.d(l.h(this.eDk.getContext(), d.e.tbds44), l.h(this.eDk.getContext(), d.e.tbds68), l.h(this.eDk.getContext(), d.e.tbds30), true);
        this.eDl.setViewPager(this.bUS);
        this.eDl.setOnPageChangeListener(this.mOnPageChangeListener);
    }

    private void M(Bundle bundle) {
        this.eDp = (NavigationBar) this.mRootView.findViewById(d.g.navigation_bar);
        this.eDp.hideBottomLine();
        this.eDq = this.mRootView.findViewById(d.g.divider_shadow);
        this.eDo = (ImageView) this.eDp.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_signall, new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.isLogin()) {
                    bc.cY(c.this.getPageContext().getPageActivity());
                } else {
                    c.this.eDk.sendMessage(new CustomMessage(2002001, new SignAllForumActivityConfig(c.this.getPageContext().getPageActivity())));
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eDo.getLayoutParams();
        layoutParams.setMargins(0, 0, l.h(getPageContext().getPageActivity(), d.e.tbds10), 0);
        this.eDo.setLayoutParams(layoutParams);
        if (this.eDl != null) {
            this.eDp.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.eDl, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.eDl.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(3);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(3);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams2.gravity = 3;
                viewGroup.setLayoutParams(layoutParams2);
            }
            this.eDl.setPadding(this.eDl.getPaddingLeft(), this.eDl.getPaddingTop(), this.eDl.getPaddingRight(), this.eDl.getBottom());
            this.eDl.getLayoutParams().height = l.h(this.eDk.getContext(), d.e.ds94);
            ((LinearLayout.LayoutParams) this.eDl.getLayoutParams()).setMargins(l.h(this.eDk.getContext(), d.e.tbds23), 0, 0, 0);
        }
    }

    public void a(PagerSlidingTabBaseStrip.a aVar) {
        if (this.eDl != null && aVar != null) {
            this.eDl.setOnTabItemClickListener(aVar);
        }
    }

    public void pf(int i) {
        if (i <= 2 && i >= 1) {
            this.bUS.setCurrentItem(i - 1, true);
        }
    }

    public boolean pg(int i) {
        return this.eDl != null && this.eDm.aWI() == i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (this.eDp != null) {
            this.eDp.onChangeSkinType(getPageContext(), i);
            al.f(this.eDp.getBarBgView(), d.C0277d.cp_bg_line_d, i);
        }
        if (this.eDo != null) {
            aq.ado().d(this.eDo, d.f.ic_icon_ba_sign_n, d.C0277d.select_topbar_icon_color_tint);
        }
        if (this.dbm != null) {
            this.dbm.onChangeSkinType(getPageContext(), i);
        }
        if (this.eDn != null && this.eDn.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.eDn.size()) {
                    break;
                }
                EnterForumTabPagerAdapter.a aVar = this.eDn.get(i3);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            }
        }
        this.eDl.onChangeSkinType();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.eDn != null && this.eDn.size() > 0 && this.bUS != null) {
            EnterForumTabPagerAdapter.a aVar = this.eDn.get(this.bUS.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void aWK() {
        if (this.eDk != null && this.eDn != null && this.bUS != null && this.eDm != null) {
            FragmentManager supportFragmentManager = this.eDk.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.eDn.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.bUS.getId(), this.eDm.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.dbm != null) {
            this.dbm.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + Config.TRACE_TODAY_VISIT_SPLIT + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.eDm != null) {
            this.eDm.setPrimary(z);
        }
        if (this.eDn != null && this.eDn.size() > 0 && this.bUS != null) {
            EnterForumTabPagerAdapter.a aVar = this.eDn.get(this.bUS.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void dP(boolean z) {
        if (this.eDn != null && this.eDn.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.eDn.size()) {
                    EnterForumTabPagerAdapter.a aVar = this.eDn.get(i2);
                    if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof NoNetworkView.a)) {
                        ((NoNetworkView.a) aVar.fragment).dP(z);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void aBE() {
        if (this.eDq != null) {
            this.eDq.clearAnimation();
            if (this.eDq.getVisibility() != 0) {
                this.eDq.setVisibility(0);
                if (this.dcE == null) {
                    this.dcE = new AlphaAnimation(0.0f, 1.0f);
                    this.dcE.setFillAfter(true);
                    this.dcE.setDuration(300L);
                }
                this.eDq.startAnimation(this.dcE);
            }
        }
    }

    public void aBF() {
        if (this.eDq != null && this.eDq.getVisibility() != 8) {
            if (this.dcF == null) {
                this.dcF = new AlphaAnimation(1.0f, 0.0f);
                this.dcF.setFillAfter(true);
                this.dcF.setDuration(300L);
                this.dcF.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.enterForum.home.c.4
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.eDq.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.eDq.startAnimation(this.dcF);
        }
    }

    public void a(a aVar) {
        if (this.eDr == null) {
            this.eDr = new ArrayList();
        }
        this.eDr.add(aVar);
    }

    public void b(a aVar) {
        if (this.eDr != null && this.eDr.size() > 0) {
            this.eDr.remove(aVar);
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class a {
        public void aWL() {
        }

        public void aWM() {
        }
    }
}
