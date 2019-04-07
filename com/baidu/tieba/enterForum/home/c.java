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
    private BdBaseViewPager bUU;
    private NoNetworkView dbq;
    private AlphaAnimation dcI;
    private AlphaAnimation dcJ;
    private EnterForumTabFragment eCV;
    private PagerSlidingTabBaseStrip eCW;
    private EnterForumTabPagerAdapter eCX;
    private List<EnterForumTabPagerAdapter.a> eCY;
    private ImageView eCZ;
    private NavigationBar eDa;
    private View eDb;
    private List<a> eDc;
    private com.baidu.adp.framework.listener.a eDd;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private View mRootView;

    public c(EnterForumTabFragment enterForumTabFragment) {
        super(enterForumTabFragment.getPageContext());
        this.eDd = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011) { // from class: com.baidu.tieba.enterForum.home.c.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String str = "";
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage = (forumRecommendSocketResponseMessage) responsedMessage;
                    if (forumrecommendsocketresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendsocketresponsemessage.getHotSearchInfoData().aWg();
                    }
                } else if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage = (forumRecommendHttpResponseMessage) responsedMessage;
                    if (forumrecommendhttpresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendhttpresponsemessage.getHotSearchInfoData().aWg();
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
                if (c.this.eCY != null && c.this.eCY.size() > i && (aVar = (EnterForumTabPagerAdapter.a) c.this.eCY.get(i)) != null && aVar.fragment != null) {
                    if (aVar.fragment instanceof RecommendFragment) {
                        if (c.this.eDc != null) {
                            for (a aVar2 : c.this.eDc) {
                                aVar2.aWK();
                            }
                        }
                    } else if ((aVar.fragment instanceof EnterForumFragment) && c.this.eDc != null) {
                        for (a aVar3 : c.this.eDc) {
                            aVar3.aWJ();
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
        this.eCV = enterForumTabFragment;
        this.eCV.registerListener(this.eDd);
    }

    private void aWH() {
        forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
        forumrecommendrequestmessage.set_like_forum(Integer.valueOf(TbadkCoreApplication.isLogin() ? 1 : 0));
        forumrecommendrequestmessage.set_topic(0);
        forumrecommendrequestmessage.set_recommend(1);
        this.eCV.sendMessage(forumrecommendrequestmessage);
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            K(bundle);
            L(bundle);
            M(bundle);
            this.dbq = (NoNetworkView) this.mRootView.findViewById(d.g.view_no_network);
            this.dbq.a(this);
            aWH();
        }
    }

    private void K(Bundle bundle) {
        this.bUU = (BdBaseViewPager) this.mRootView.findViewById(d.g.enter_forum_viewpager);
        EnterForumTabPagerAdapter.a aVar = new EnterForumTabPagerAdapter.a();
        aVar.fragment = new EnterForumFragment();
        aVar.title = this.eCV.getResources().getString(d.j.attention);
        ((EnterForumFragment) aVar.fragment).setTabViewController(this);
        EnterForumTabPagerAdapter.a aVar2 = new EnterForumTabPagerAdapter.a();
        aVar2.fragment = new RecommendFragment();
        aVar2.title = this.eCV.getResources().getString(d.j.default_personalized_name);
        ((RecommendFragment) aVar2.fragment).setTabViewController(this);
        this.eCY = new ArrayList();
        this.eCY.add(aVar);
        this.eCY.add(aVar2);
        this.eCX = new EnterForumTabPagerAdapter(this.eCV.getActivity().getSupportFragmentManager(), this.eCY);
        this.bUU.setAdapter(this.eCX);
        this.bUU.setOffscreenPageLimit(this.eCY.size());
    }

    public void BC() {
    }

    private void L(Bundle bundle) {
        this.eCW = (PagerSlidingTabBaseStrip) LayoutInflater.from(this.eCV.getContext()).inflate(d.h.enter_forum_tab_layout, (ViewGroup) null);
        this.eCW.d(l.h(this.eCV.getContext(), d.e.tbds44), l.h(this.eCV.getContext(), d.e.tbds68), l.h(this.eCV.getContext(), d.e.tbds30), true);
        this.eCW.setViewPager(this.bUU);
        this.eCW.setOnPageChangeListener(this.mOnPageChangeListener);
    }

    private void M(Bundle bundle) {
        this.eDa = (NavigationBar) this.mRootView.findViewById(d.g.navigation_bar);
        this.eDa.hideBottomLine();
        this.eDb = this.mRootView.findViewById(d.g.divider_shadow);
        this.eCZ = (ImageView) this.eDa.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_signall, new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.isLogin()) {
                    bc.cY(c.this.getPageContext().getPageActivity());
                } else {
                    c.this.eCV.sendMessage(new CustomMessage(2002001, new SignAllForumActivityConfig(c.this.getPageContext().getPageActivity())));
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eCZ.getLayoutParams();
        layoutParams.setMargins(0, 0, l.h(getPageContext().getPageActivity(), d.e.tbds10), 0);
        this.eCZ.setLayoutParams(layoutParams);
        if (this.eCW != null) {
            this.eDa.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.eCW, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.eCW.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(3);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(3);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams2.gravity = 3;
                viewGroup.setLayoutParams(layoutParams2);
            }
            this.eCW.setPadding(this.eCW.getPaddingLeft(), this.eCW.getPaddingTop(), this.eCW.getPaddingRight(), this.eCW.getBottom());
            this.eCW.getLayoutParams().height = l.h(this.eCV.getContext(), d.e.ds94);
            ((LinearLayout.LayoutParams) this.eCW.getLayoutParams()).setMargins(l.h(this.eCV.getContext(), d.e.tbds23), 0, 0, 0);
        }
    }

    public void a(PagerSlidingTabBaseStrip.a aVar) {
        if (this.eCW != null && aVar != null) {
            this.eCW.setOnTabItemClickListener(aVar);
        }
    }

    public void pb(int i) {
        if (i <= 2 && i >= 1) {
            this.bUU.setCurrentItem(i - 1, true);
        }
    }

    public boolean pc(int i) {
        return this.eCW != null && this.eCX.aWG() == i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (this.eDa != null) {
            this.eDa.onChangeSkinType(getPageContext(), i);
            al.f(this.eDa.getBarBgView(), d.C0277d.cp_bg_line_d, i);
        }
        if (this.eCZ != null) {
            aq.adl().d(this.eCZ, d.f.ic_icon_ba_sign_n, d.C0277d.select_topbar_icon_color_tint);
        }
        if (this.dbq != null) {
            this.dbq.onChangeSkinType(getPageContext(), i);
        }
        if (this.eCY != null && this.eCY.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.eCY.size()) {
                    break;
                }
                EnterForumTabPagerAdapter.a aVar = this.eCY.get(i3);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            }
        }
        this.eCW.onChangeSkinType();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.eCY != null && this.eCY.size() > 0 && this.bUU != null) {
            EnterForumTabPagerAdapter.a aVar = this.eCY.get(this.bUU.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void aWI() {
        if (this.eCV != null && this.eCY != null && this.bUU != null && this.eCX != null) {
            FragmentManager supportFragmentManager = this.eCV.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.eCY.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.bUU.getId(), this.eCX.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.dbq != null) {
            this.dbq.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + Config.TRACE_TODAY_VISIT_SPLIT + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.eCX != null) {
            this.eCX.setPrimary(z);
        }
        if (this.eCY != null && this.eCY.size() > 0 && this.bUU != null) {
            EnterForumTabPagerAdapter.a aVar = this.eCY.get(this.bUU.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void dP(boolean z) {
        if (this.eCY != null && this.eCY.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.eCY.size()) {
                    EnterForumTabPagerAdapter.a aVar = this.eCY.get(i2);
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

    public void aBB() {
        if (this.eDb != null) {
            this.eDb.clearAnimation();
            if (this.eDb.getVisibility() != 0) {
                this.eDb.setVisibility(0);
                if (this.dcI == null) {
                    this.dcI = new AlphaAnimation(0.0f, 1.0f);
                    this.dcI.setFillAfter(true);
                    this.dcI.setDuration(300L);
                }
                this.eDb.startAnimation(this.dcI);
            }
        }
    }

    public void aBC() {
        if (this.eDb != null && this.eDb.getVisibility() != 8) {
            if (this.dcJ == null) {
                this.dcJ = new AlphaAnimation(1.0f, 0.0f);
                this.dcJ.setFillAfter(true);
                this.dcJ.setDuration(300L);
                this.dcJ.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.enterForum.home.c.4
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.eDb.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.eDb.startAnimation(this.dcJ);
        }
    }

    public void a(a aVar) {
        if (this.eDc == null) {
            this.eDc = new ArrayList();
        }
        this.eDc.add(aVar);
    }

    public void b(a aVar) {
        if (this.eDc != null && this.eDc.size() > 0) {
            this.eDc.remove(aVar);
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class a {
        public void aWJ() {
        }

        public void aWK() {
        }
    }
}
