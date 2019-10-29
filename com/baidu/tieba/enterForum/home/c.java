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
    private BdBaseViewPager ctf;
    private NoNetworkView dwI;
    private AlphaAnimation dyo;
    private AlphaAnimation dyp;
    private com.baidu.tieba.enterForum.data.b eZS;
    private int fcA;
    private int fcB;
    private com.baidu.adp.framework.listener.a fcC;
    private EnterForumTabFragment fcn;
    private LinearLayout fco;
    private ForumHeaderView fcp;
    private PagerSlidingTabBaseStrip fcq;
    private EnterForumTabPagerAdapter fcr;
    private List<EnterForumTabPagerAdapter.a> fcs;
    private com.baidu.tieba.enterForum.data.b fct;
    private ImageView fcu;
    private ImageView fcv;
    private NavigationBar fcw;
    private View fcx;
    private List<a> fcy;
    private com.baidu.tieba.enterForum.view.b fcz;
    private int mNavHeight;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private View mRootView;

    public c(EnterForumTabFragment enterForumTabFragment) {
        super(enterForumTabFragment.getPageContext());
        this.fcA = -1;
        this.fcC = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.enterForum.home.c.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String str = "";
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage = (forumRecommendSocketResponseMessage) responsedMessage;
                    if (forumrecommendsocketresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendsocketresponsemessage.getHotSearchInfoData().bdN();
                    }
                } else if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage = (forumRecommendHttpResponseMessage) responsedMessage;
                    if (forumrecommendhttpresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendhttpresponsemessage.getHotSearchInfoData().bdN();
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
                c.this.pz(i);
                if (c.this.fcs != null && c.this.fcs.size() > i) {
                    if (c.this.fcz != null) {
                        c.this.fcz.bfD();
                    }
                    EnterForumTabPagerAdapter.a aVar = (EnterForumTabPagerAdapter.a) c.this.fcs.get(i);
                    if (aVar != null && aVar.fragment != null) {
                        if (aVar.fragment instanceof RecommendFragment) {
                            if (c.this.fcy != null) {
                                for (a aVar2 : c.this.fcy) {
                                    aVar2.beF();
                                }
                            }
                        } else if ((aVar.fragment instanceof EnterForumFragment) && c.this.fcy != null) {
                            for (a aVar3 : c.this.fcy) {
                                aVar3.beE();
                            }
                        }
                        if (i == 0) {
                            c.this.fcA = 1;
                            TiebaStatic.log(new an("c13366").O("obj_locate", 1));
                        } else if (i == 1) {
                            c.this.fcA = 2;
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
        this.fcn = enterForumTabFragment;
        this.fcn.registerListener(this.fcC);
        this.mNavHeight = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds240);
        this.fcB = UtilHelper.getStatusBarHeight() + l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds240);
    }

    private void bex() {
        forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
        forumrecommendrequestmessage.set_like_forum(Integer.valueOf(TbadkCoreApplication.isLogin() ? 1 : 0));
        forumrecommendrequestmessage.set_topic(0);
        forumrecommendrequestmessage.set_recommend(1);
        this.fcn.sendMessage(forumrecommendrequestmessage);
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            L(bundle);
            M(bundle);
            N(bundle);
            this.dwI = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.dwI.a(this);
            if (!TbadkCoreApplication.getInst().checkInterrupt()) {
                bex();
            }
        }
    }

    private void L(Bundle bundle) {
        this.ctf = (BdBaseViewPager) this.mRootView.findViewById(R.id.enter_forum_viewpager);
        EnterForumTabPagerAdapter.a aVar = new EnterForumTabPagerAdapter.a();
        aVar.fragment = new EnterForumFragment();
        aVar.title = this.fcn.getResources().getString(R.string.attention);
        ((EnterForumFragment) aVar.fragment).setTabViewController(this);
        EnterForumTabPagerAdapter.a aVar2 = new EnterForumTabPagerAdapter.a();
        aVar2.fragment = new RecommendFragment();
        aVar2.title = this.fcn.getResources().getString(R.string.default_personalized_name);
        ((RecommendFragment) aVar2.fragment).setTabViewController(this);
        this.fcs = new ArrayList();
        this.fcs.add(aVar);
        this.fcs.add(aVar2);
        this.fcr = new EnterForumTabPagerAdapter(this.fcn.getActivity().getSupportFragmentManager(), this.fcs);
        this.ctf.setAdapter(this.fcr);
        this.ctf.setOffscreenPageLimit(this.fcs.size());
    }

    public void Il() {
    }

    private void M(Bundle bundle) {
        this.fco = (LinearLayout) LayoutInflater.from(this.fcn.getContext()).inflate(R.layout.enter_forum_tab_layout, (ViewGroup) null);
        this.fcp = (ForumHeaderView) this.fco.findViewById(R.id.recommend_forum_header_serch_view);
        this.fcp.onChangeSkinType();
        this.fcq = (PagerSlidingTabBaseStrip) this.fco.findViewById(R.id.tab_layout);
        this.fcq.d(l.getDimens(this.fcn.getContext(), R.dimen.tbds44), l.getDimens(this.fcn.getContext(), R.dimen.tbds68), l.getDimens(this.fcn.getContext(), R.dimen.tbds30), true);
        this.fcq.setViewPager(this.ctf);
        this.fcq.setOnPageChangeListener(this.mOnPageChangeListener);
    }

    private void N(Bundle bundle) {
        this.fcw = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.fcw.setNavHeight(this.mNavHeight);
        this.fcw.hideBottomLine();
        this.fcx = this.mRootView.findViewById(R.id.divider_shadow);
        pA(0);
        this.fcu = (ImageView) this.fco.findViewById(R.id.navigationBarGoSignall);
        this.fcu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.isLogin()) {
                    bc.skipToLoginActivity(c.this.getPageContext().getPageActivity());
                } else {
                    c.this.fcn.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(c.this.getPageContext().getPageActivity())));
                }
            }
        });
        this.fcv = (ImageView) this.fco.findViewById(R.id.navigationBarGoSearch);
        this.fcv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.fcp.onClick(view);
            }
        });
        if (this.fcq != null) {
            this.fcw.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, this.fco, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.fco.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(3);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(3);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 3;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.fcq.setPadding(this.fcq.getPaddingLeft(), this.fcq.getPaddingTop(), this.fcq.getPaddingRight(), this.fcq.getBottom());
            this.fcq.getLayoutParams().height = l.getDimens(this.fcn.getContext(), R.dimen.tbds126);
            ((RelativeLayout.LayoutParams) this.fcq.getLayoutParams()).setMargins(l.getDimens(this.fcn.getContext(), R.dimen.tbds23), 0, 0, 0);
        }
    }

    public void a(PagerSlidingTabBaseStrip.a aVar) {
        if (this.fcq != null && aVar != null) {
            this.fcq.setOnTabItemClickListener(aVar);
        }
    }

    public void px(int i) {
        if (i <= 2 && i >= 1) {
            this.fcA = i;
            this.ctf.setCurrentItem(i - 1, true);
        }
    }

    public int bey() {
        return this.fcA;
    }

    public boolean py(int i) {
        return this.fcq != null && this.fcr.bew() == i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        pz(this.ctf.getCurrentItem());
        if (this.dwI != null) {
            this.dwI.onChangeSkinType(getPageContext(), i);
        }
        if (this.fcs != null && this.fcs.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.fcs.size()) {
                    break;
                }
                EnterForumTabPagerAdapter.a aVar = this.fcs.get(i3);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            }
        }
        this.fcq.onChangeSkinType();
        this.fcp.onChangeSkinType();
    }

    public void bez() {
        pz(this.ctf.getCurrentItem());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, float f, int i2) {
        if (this.fcw != null) {
            if (i == 0) {
                if (i2 == 0) {
                    pz(i);
                } else if (this.eZS != null && this.eZS.fax && this.eZS.faz > 0) {
                    if (this.fcz != null && this.fcz.getRefreshView() != null && this.fcz.getRefreshView().isViewAttached()) {
                        am.setBackgroundColor(this.fcw.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
                        return;
                    }
                    this.fcw.setBackgroundColor(0);
                    am.a(this.fcw.getBarBgView(), R.color.cp_bg_line_h, f, TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (i2 == 0) {
                pz(i);
            } else if (this.eZS != null && this.eZS.fax && this.eZS.faz > 0) {
                if (this.fcz != null && this.fcz.getRefreshView() != null && this.fcz.getRefreshView().isViewAttached()) {
                    am.setBackgroundColor(this.fcw.getBarBgView(), R.color.cp_bg_line_d, TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.fcw.setBackgroundColor(0);
                am.a(this.fcw.getBarBgView(), R.color.cp_bg_line_d, 1.0f - f, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pz(int i) {
        int i2;
        if (this.fcu != null) {
            if (i == 0) {
                if (this.eZS != null && this.eZS.fax && this.eZS.faz > 0) {
                    if (this.fcz != null && this.fcz.getRefreshView() != null && this.fcz.getRefreshView().isViewAttached()) {
                        am.setImageResource(this.fcu, R.drawable.icon_ba_sign_black);
                        am.setImageResource(this.fcv, R.drawable.icon_ba_search_black);
                    } else if (this.eZS.faA > 0 && this.eZS.faz > this.eZS.faA / 2) {
                        SvgManager.amN().a(this.fcu, R.drawable.icon_pure_topbar_sign_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                        am.setImageResource(this.fcv, R.drawable.icon_ba_search_white);
                    } else {
                        SvgManager.amN().a(this.fcu, R.drawable.icon_pure_topbar_sign_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                        am.setImageResource(this.fcv, R.drawable.icon_ba_search_black);
                    }
                } else {
                    SvgManager.amN().a(this.fcu, R.drawable.icon_pure_topbar_sign_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    am.setImageResource(this.fcv, R.drawable.icon_ba_search_black);
                }
            } else {
                SvgManager.amN().a(this.fcu, R.drawable.icon_pure_topbar_sign_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                am.setImageResource(this.fcv, R.drawable.icon_ba_search_black);
            }
        }
        if (this.fcw != null) {
            this.fcw.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            if (i == 0) {
                if (this.eZS != null && this.eZS.fax && this.eZS.faz > 0) {
                    if (this.fcz != null && this.fcz.getRefreshView() != null && this.fcz.getRefreshView().isViewAttached()) {
                        am.setBackgroundColor(this.fcw.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
                    } else {
                        if (this.eZS.faA > 0) {
                            int i3 = (this.eZS.faz * 255) / this.eZS.faA;
                            if (i3 > 255) {
                                i3 = 255;
                            }
                            i2 = 255 - i3;
                        } else {
                            i2 = 0;
                        }
                        this.fcw.setBackgroundColor(0);
                        am.a(this.fcw.getBarBgView(), R.color.cp_bg_line_d, i2 / 255.0f, TbadkCoreApplication.getInst().getSkinType());
                    }
                } else {
                    am.setBackgroundColor(this.fcw.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
                }
            } else {
                am.setBackgroundColor(this.fcw.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
            }
        }
        if (i == 0) {
            if (this.eZS != null && this.eZS.fax && this.eZS.faz > 0) {
                if (this.eZS.faA > 0 && this.eZS.faz > this.eZS.faA / 2) {
                    if (this.fcz != null && this.fcz.getRefreshView() != null && this.fcz.getRefreshView().isViewAttached()) {
                        this.fcq.setWhiteStyle(false);
                    } else {
                        this.fcq.setWhiteStyle(true);
                    }
                    if (this.fcn.isPrimary()) {
                    }
                } else {
                    this.fcq.setWhiteStyle(false);
                    if (this.fcn.isPrimary()) {
                    }
                }
            } else {
                this.fcq.setWhiteStyle(false);
                if (this.fcn.isPrimary()) {
                }
            }
        } else {
            this.fcq.setWhiteStyle(false);
            if (this.fcn.isPrimary()) {
            }
        }
        if (i == 0) {
            this.fcp.setAdState(this.eZS);
        } else {
            this.fcp.setAdState(null);
        }
        if (i == 0 && TbadkCoreApplication.getInst().getSkinType() != 1 && this.fcn.isPrimary() && this.eZS != null && this.eZS.fax && i == 0) {
            if (this.eZS.faz > this.eZS.faA / 2) {
                if (this.fct != null && this.fct.faz <= this.eZS.faA / 2) {
                    ao.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
                }
            } else if (this.fct != null && this.fct.faz >= this.eZS.faA / 2) {
                ao.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            }
        }
    }

    public void beA() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            ao.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
        } else if (this.ctf.getCurrentItem() == 0 && this.fcn.isPrimary()) {
            if (this.fcz != null && this.fcz.getRefreshView() != null && this.fcz.getRefreshView().isViewAttached()) {
                ao.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            } else if (this.eZS != null && this.eZS.fax) {
                if (this.eZS.faz > this.eZS.faA / 2 || this.eZS.faz == 0) {
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
        if (this.fcs != null && this.fcs.size() > 0 && this.ctf != null) {
            EnterForumTabPagerAdapter.a aVar = this.fcs.get(this.ctf.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void beB() {
        if (this.fcn != null && this.fcs != null && this.ctf != null && this.fcr != null) {
            FragmentManager supportFragmentManager = this.fcn.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.fcs.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.ctf.getId(), this.fcr.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.dwI != null) {
            this.dwI.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.fcr != null) {
            this.fcr.setPrimary(z);
        }
        if (this.fcs != null && this.fcs.size() > 0 && this.ctf != null) {
            EnterForumTabPagerAdapter.a aVar = this.fcs.get(this.ctf.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.fcs != null && this.fcs.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.fcs.size()) {
                    break;
                }
                EnterForumTabPagerAdapter.a aVar = this.fcs.get(i2);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof NoNetworkView.a)) {
                    ((NoNetworkView.a) aVar.fragment).onNetworkChange(z);
                }
                i = i2 + 1;
            }
        }
        pz(this.ctf.getCurrentItem());
    }

    public void aJA() {
        if (this.fco != null && this.fco.getPaddingTop() < 0) {
            beC();
        } else if (this.fcx != null) {
            this.fcx.clearAnimation();
            if (this.fcx.getVisibility() != 0) {
                this.fcx.setVisibility(0);
                if (this.dyo == null) {
                    this.dyo = new AlphaAnimation(0.0f, 1.0f);
                    this.dyo.setFillAfter(true);
                    this.dyo.setDuration(300L);
                }
                this.fcx.startAnimation(this.dyo);
            }
        }
    }

    public void aJB() {
        if (this.fcx != null && this.fcx.getVisibility() != 8) {
            if (this.dyp == null) {
                this.dyp = new AlphaAnimation(1.0f, 0.0f);
                this.dyp.setFillAfter(true);
                this.dyp.setDuration(300L);
                this.dyp.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.enterForum.home.c.5
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.fcx.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.fcx.startAnimation(this.dyp);
        }
    }

    private void beC() {
        if (this.fcx != null && this.fcx.getVisibility() != 8) {
            this.fcx.clearAnimation();
            this.fcx.setVisibility(8);
        }
    }

    public void a(a aVar) {
        if (this.fcy == null) {
            this.fcy = new ArrayList();
        }
        this.fcy.add(aVar);
    }

    public void b(a aVar) {
        if (this.fcy != null && this.fcy.size() > 0) {
            this.fcy.remove(aVar);
        }
    }

    public void a(com.baidu.tieba.enterForum.view.b bVar) {
        this.fcz = bVar;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.b bVar) {
        this.fct = this.eZS;
        this.eZS = bVar;
        this.fcp.setAdState(bVar);
        pz(this.ctf.getCurrentItem());
    }

    public void setSearchHint(String str) {
        this.fcp.setSearchHint(str);
    }

    public View getRootView() {
        return getPageContext().getPageActivity().getWindow().getDecorView();
    }

    public View beD() {
        return this.fco;
    }

    /* loaded from: classes4.dex */
    public static abstract class a {
        public void beE() {
        }

        public void beF() {
        }
    }

    public String getCurrentPageKey() {
        if (this.fcr != null) {
            return this.fcr.getCurrentPageKey();
        }
        return null;
    }

    public void e(View view, int i, int i2, int i3, int i4) {
    }

    private void pA(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fcx.getLayoutParams();
        layoutParams.topMargin = this.fcB + i;
        this.fcx.setLayoutParams(layoutParams);
    }
}
