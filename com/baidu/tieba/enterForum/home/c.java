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
import com.baidu.tbadk.core.atomData.QRCodeScanActivityConfig;
import com.baidu.tbadk.core.atomData.SignAllForumActivityConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.home.EnterForumTabPagerAdapter;
import com.baidu.tieba.enterForum.recommend.RecommendFragment;
import com.baidu.tieba.enterForum.view.ForumHeaderView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class c extends com.baidu.adp.base.c implements NoNetworkView.a {
    private BdBaseViewPager dgc;
    private NoNetworkView egT;
    private AlphaAnimation eiA;
    private AlphaAnimation eiz;
    private com.baidu.tieba.enterForum.data.b fNJ;
    private EnterForumTabFragment fQa;
    private LinearLayout fQb;
    private ForumHeaderView fQc;
    private NewPagerSlidingTabBaseStrip fQd;
    private EnterForumTabPagerAdapter fQe;
    private List<EnterForumTabPagerAdapter.a> fQf;
    private com.baidu.tieba.enterForum.data.b fQg;
    private ImageView fQh;
    private ImageView fQi;
    private NavigationBar fQj;
    private View fQk;
    private List<a> fQl;
    private com.baidu.tieba.enterForum.view.b fQm;
    private int fQn;
    private int fQo;
    private com.baidu.adp.framework.listener.a fQp;
    private int mNavHeight;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private View mRootView;

    public c(EnterForumTabFragment enterForumTabFragment) {
        super(enterForumTabFragment.getPageContext());
        this.fQn = -1;
        this.fQp = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.enterForum.home.c.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String str = "";
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage = (forumRecommendSocketResponseMessage) responsedMessage;
                    if (forumrecommendsocketresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendsocketresponsemessage.getHotSearchInfoData().bvh();
                    }
                } else if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage = (forumRecommendHttpResponseMessage) responsedMessage;
                    if (forumrecommendhttpresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendhttpresponsemessage.getHotSearchInfoData().bvh();
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
                c.this.rE(i);
                if (c.this.fQf != null && c.this.fQf.size() > i) {
                    if (c.this.fQm != null) {
                        c.this.fQm.bwW();
                    }
                    EnterForumTabPagerAdapter.a aVar = (EnterForumTabPagerAdapter.a) c.this.fQf.get(i);
                    if (aVar != null && aVar.fragment != null) {
                        if (aVar.fragment instanceof RecommendFragment) {
                            if (c.this.fQl != null) {
                                for (a aVar2 : c.this.fQl) {
                                    aVar2.bvX();
                                }
                            }
                        } else if ((aVar.fragment instanceof EnterForumFragment) && c.this.fQl != null) {
                            for (a aVar3 : c.this.fQl) {
                                aVar3.bvW();
                            }
                        }
                        if (i == 0) {
                            c.this.fQn = 1;
                            TiebaStatic.log(new an("c13366").Z("obj_locate", 1));
                        } else if (i == 1) {
                            c.this.fQn = 2;
                            TiebaStatic.log(new an("c13366").Z("obj_locate", 2));
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
        this.fQa = enterForumTabFragment;
        this.fQa.registerListener(this.fQp);
        this.mNavHeight = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds240);
        this.fQo = UtilHelper.getStatusBarHeight() + l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds240);
    }

    private void bvQ() {
        forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
        forumrecommendrequestmessage.set_like_forum(Integer.valueOf(TbadkCoreApplication.isLogin() ? 1 : 0));
        forumrecommendrequestmessage.set_topic(0);
        forumrecommendrequestmessage.set_recommend(1);
        this.fQa.sendMessage(forumrecommendrequestmessage);
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            ae(bundle);
            af(bundle);
            ag(bundle);
            this.egT = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.egT.a(this);
            if (!TbadkCoreApplication.getInst().checkInterrupt()) {
                bvQ();
            }
        }
    }

    private void ae(Bundle bundle) {
        this.dgc = (BdBaseViewPager) this.mRootView.findViewById(R.id.enter_forum_viewpager);
        EnterForumTabPagerAdapter.a aVar = new EnterForumTabPagerAdapter.a();
        aVar.fragment = new EnterForumFragment();
        aVar.title = this.fQa.getResources().getString(R.string.attention);
        ((EnterForumFragment) aVar.fragment).setTabViewController(this);
        EnterForumTabPagerAdapter.a aVar2 = new EnterForumTabPagerAdapter.a();
        aVar2.fragment = new RecommendFragment();
        aVar2.title = this.fQa.getResources().getString(R.string.default_personalized_name);
        ((RecommendFragment) aVar2.fragment).setTabViewController(this);
        this.fQf = new ArrayList();
        this.fQf.add(aVar);
        this.fQf.add(aVar2);
        this.fQe = new EnterForumTabPagerAdapter(this.fQa.getActivity().getSupportFragmentManager(), this.fQf);
        this.dgc.setAdapter(this.fQe);
        this.dgc.setOffscreenPageLimit(this.fQf.size());
    }

    public void PE() {
    }

    private void af(Bundle bundle) {
        this.fQb = (LinearLayout) LayoutInflater.from(this.fQa.getContext()).inflate(R.layout.enter_forum_tab_layout, (ViewGroup) null);
        this.fQc = (ForumHeaderView) this.fQb.findViewById(R.id.recommend_forum_header_serch_view);
        this.fQc.onChangeSkinType();
        this.fQd = (NewPagerSlidingTabBaseStrip) this.fQb.findViewById(R.id.tab_layout);
        this.fQd.setDefaultSelectorColorResourceId(R.color.cp_cont_b);
        this.fQd.setRectPaintColor(R.color.cp_link_tip_a);
        this.fQd.a(l.getDimens(this.fQa.getContext(), R.dimen.tbds46), l.getDimens(this.fQa.getContext(), R.dimen.tbds46), l.getDimens(this.fQa.getContext(), R.dimen.tbds10), l.getDimens(this.fQa.getContext(), R.dimen.tbds46), true);
        this.fQd.setIndicatorOffset(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds64));
        this.fQd.setIndicatorOvershot(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds8));
        this.fQd.setIndicatorRadius(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds8));
        this.fQd.setIndicatorMarginBottom(l.getDimens(this.fQa.getContext(), R.dimen.tbds0));
        this.fQd.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds170), -1));
        this.fQd.setViewPager(this.dgc);
        this.fQd.setOnPageChangeListener(this.mOnPageChangeListener);
    }

    private void ag(Bundle bundle) {
        this.fQj = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.fQj.setNavHeight(this.mNavHeight);
        this.fQj.hideBottomLine();
        this.fQk = this.mRootView.findViewById(R.id.divider_shadow);
        rF(0);
        this.fQh = (ImageView) this.fQb.findViewById(R.id.navigationBarGoSignall);
        this.fQh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.CheckFile("scan_flag") && ab.checkCamera(c.this.mContext.getPageActivity())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new QRCodeScanActivityConfig(c.this.mContext.getPageActivity())));
                } else if (!TbadkCoreApplication.isLogin()) {
                    bc.skipToLoginActivity(c.this.getPageContext().getPageActivity());
                } else {
                    c.this.fQa.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(c.this.getPageContext().getPageActivity())));
                }
            }
        });
        this.fQi = (ImageView) this.fQb.findViewById(R.id.navigationBarGoSearch);
        this.fQi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.fQc.onClick(view);
            }
        });
        if (this.fQd != null) {
            this.fQj.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, this.fQb, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.fQb.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(3);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(3);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 3;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.fQd.setPadding(this.fQd.getPaddingLeft(), this.fQd.getPaddingTop(), this.fQd.getPaddingRight(), this.fQd.getBottom());
            this.fQd.getLayoutParams().height = l.getDimens(this.fQa.getContext(), R.dimen.tbds126);
            ((RelativeLayout.LayoutParams) this.fQd.getLayoutParams()).setMargins(l.getDimens(this.fQa.getContext(), R.dimen.tbds15), 0, 0, 0);
        }
    }

    public void a(NewPagerSlidingTabBaseStrip.a aVar) {
        if (this.fQd != null && aVar != null) {
            this.fQd.setOnTabItemClickListener(aVar);
        }
    }

    public void rC(int i) {
        if (i <= 2 && i >= 1) {
            this.fQn = i;
            this.dgc.setCurrentItem(i - 1, true);
        }
    }

    public int bvR() {
        return this.fQn;
    }

    public boolean rD(int i) {
        return this.fQd != null && this.fQe.bvP() == i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        rE(this.dgc.getCurrentItem());
        if (this.egT != null) {
            this.egT.onChangeSkinType(getPageContext(), i);
        }
        if (this.fQf != null && this.fQf.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.fQf.size()) {
                    break;
                }
                EnterForumTabPagerAdapter.a aVar = this.fQf.get(i3);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            }
        }
        am.setBackgroundResource(this.fQk, R.drawable.personalize_tab_shadow);
        this.fQd.onChangeSkinType();
        this.fQc.onChangeSkinType();
    }

    public void bvS() {
        rE(this.dgc.getCurrentItem());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, float f, int i2) {
        if (this.fQj != null) {
            if (i == 0) {
                if (i2 == 0) {
                    rE(i);
                } else if (this.fNJ != null && this.fNJ.fOn && this.fNJ.fOp > 0) {
                    if (this.fQm != null && this.fQm.getRefreshView() != null && this.fQm.getRefreshView().isViewAttached()) {
                        am.setBackgroundColor(this.fQj.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
                        return;
                    }
                    this.fQj.setBackgroundColor(0);
                    am.a(this.fQj.getBarBgView(), (int) R.color.cp_bg_line_h, f, TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (i2 == 0) {
                rE(i);
            } else if (this.fNJ != null && this.fNJ.fOn && this.fNJ.fOp > 0) {
                if (this.fQm != null && this.fQm.getRefreshView() != null && this.fQm.getRefreshView().isViewAttached()) {
                    am.setBackgroundColor(this.fQj.getBarBgView(), R.color.cp_bg_line_d, TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.fQj.setBackgroundColor(0);
                am.a(this.fQj.getBarBgView(), (int) R.color.cp_bg_line_d, 1.0f - f, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rE(int i) {
        int i2;
        if (this.fQh != null) {
            if (i == 0) {
                if (this.fNJ != null && this.fNJ.fOn && this.fNJ.fOp > 0) {
                    if (this.fQm != null && this.fQm.getRefreshView() != null && this.fQm.getRefreshView().isViewAttached()) {
                        SvgManager.aDW().a(this.fQh, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                        am.setImageResource(this.fQi, R.drawable.icon_ba_search_black);
                    } else if (this.fNJ.fOq > 0 && this.fNJ.fOp > this.fNJ.fOq / 2) {
                        SvgManager.aDW().a(this.fQh, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                        am.setImageResource(this.fQi, R.drawable.icon_ba_search_white);
                    } else {
                        SvgManager.aDW().a(this.fQh, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                        am.setImageResource(this.fQi, R.drawable.icon_ba_search_black);
                    }
                } else {
                    SvgManager.aDW().a(this.fQh, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    am.setImageResource(this.fQi, R.drawable.icon_ba_search_black);
                }
            } else {
                SvgManager.aDW().a(this.fQh, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                am.setImageResource(this.fQi, R.drawable.icon_ba_search_black);
            }
        }
        if (this.fQj != null) {
            this.fQj.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            if (i == 0) {
                if (this.fNJ != null && this.fNJ.fOn && this.fNJ.fOp > 0) {
                    if (this.fQm != null && this.fQm.getRefreshView() != null && this.fQm.getRefreshView().isViewAttached()) {
                        am.setBackgroundColor(this.fQj.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
                    } else {
                        if (this.fNJ.fOq > 0) {
                            int i3 = (this.fNJ.fOp * 255) / this.fNJ.fOq;
                            if (i3 > 255) {
                                i3 = 255;
                            }
                            i2 = 255 - i3;
                        } else {
                            i2 = 0;
                        }
                        this.fQj.setBackgroundColor(0);
                        am.a(this.fQj.getBarBgView(), (int) R.color.cp_bg_line_d, i2 / 255.0f, TbadkCoreApplication.getInst().getSkinType());
                    }
                } else {
                    am.setBackgroundColor(this.fQj.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
                }
            } else {
                am.setBackgroundColor(this.fQj.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
            }
        }
        if (i == 0) {
            if (this.fNJ != null && this.fNJ.fOn && this.fNJ.fOp > 0) {
                if (this.fNJ.fOq > 0 && this.fNJ.fOp > this.fNJ.fOq / 2) {
                    if (this.fQm != null && this.fQm.getRefreshView() != null && this.fQm.getRefreshView().isViewAttached()) {
                        this.fQd.setWhiteStyle(false);
                    } else {
                        this.fQd.setWhiteStyle(true);
                    }
                    if (this.fQa.isPrimary()) {
                    }
                } else {
                    this.fQd.setWhiteStyle(false);
                    if (this.fQa.isPrimary()) {
                    }
                }
            } else {
                this.fQd.setWhiteStyle(false);
                if (this.fQa.isPrimary()) {
                }
            }
        } else {
            this.fQd.setWhiteStyle(false);
            if (this.fQa.isPrimary()) {
            }
        }
        if (i == 0) {
            this.fQc.setAdState(this.fNJ);
        } else {
            this.fQc.setAdState(null);
        }
        if (i == 0 && TbadkCoreApplication.getInst().getSkinType() != 1 && this.fQa.isPrimary() && this.fNJ != null && this.fNJ.fOn && i == 0) {
            if (this.fNJ.fOp > this.fNJ.fOq / 2) {
                if (this.fQg != null && this.fQg.fOp <= this.fNJ.fOq / 2) {
                    ao.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
                }
            } else if (this.fQg != null && this.fQg.fOp >= this.fNJ.fOq / 2) {
                ao.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            }
        }
    }

    public void bvT() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
            ao.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
        } else if (this.dgc.getCurrentItem() == 0 && this.fQa.isPrimary()) {
            if (this.fQm != null && this.fQm.getRefreshView() != null && this.fQm.getRefreshView().isViewAttached()) {
                ao.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            } else if (this.fNJ != null && this.fNJ.fOn) {
                if (this.fNJ.fOp > this.fNJ.fOq / 2 || this.fNJ.fOp == 0) {
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
        if (this.fQf != null && this.fQf.size() > 0 && this.dgc != null) {
            EnterForumTabPagerAdapter.a aVar = this.fQf.get(this.dgc.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void GW() {
        if (this.fQa != null && this.fQf != null && this.dgc != null && this.fQe != null) {
            FragmentManager supportFragmentManager = this.fQa.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.fQf.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.dgc.getId(), this.fQe.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.egT != null) {
            this.egT.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.fQe != null) {
            this.fQe.setPrimary(z);
        }
        if (this.fQf != null && this.fQf.size() > 0 && this.dgc != null) {
            EnterForumTabPagerAdapter.a aVar = this.fQf.get(this.dgc.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.fQf != null && this.fQf.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.fQf.size()) {
                    break;
                }
                EnterForumTabPagerAdapter.a aVar = this.fQf.get(i2);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof NoNetworkView.a)) {
                    ((NoNetworkView.a) aVar.fragment).onNetworkChange(z);
                }
                i = i2 + 1;
            }
        }
        rE(this.dgc.getCurrentItem());
    }

    public void aZW() {
        if (this.fQb != null && this.fQb.getPaddingTop() < 0) {
            bvU();
        } else if (this.fQk != null) {
            this.fQk.clearAnimation();
            if (this.fQk.getVisibility() != 0) {
                this.fQk.setVisibility(0);
                if (this.eiz == null) {
                    this.eiz = new AlphaAnimation(0.0f, 1.0f);
                    this.eiz.setFillAfter(true);
                    this.eiz.setDuration(300L);
                }
                this.fQk.startAnimation(this.eiz);
            }
        }
    }

    public void aZX() {
        if (this.fQk != null && this.fQk.getVisibility() != 8) {
            if (this.eiA == null) {
                this.eiA = new AlphaAnimation(1.0f, 0.0f);
                this.eiA.setFillAfter(true);
                this.eiA.setDuration(300L);
                this.eiA.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.enterForum.home.c.5
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.fQk.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.fQk.startAnimation(this.eiA);
        }
    }

    private void bvU() {
        if (this.fQk != null && this.fQk.getVisibility() != 8) {
            this.fQk.clearAnimation();
            this.fQk.setVisibility(8);
        }
    }

    public void a(a aVar) {
        if (this.fQl == null) {
            this.fQl = new ArrayList();
        }
        this.fQl.add(aVar);
    }

    public void b(a aVar) {
        if (this.fQl != null && this.fQl.size() > 0) {
            this.fQl.remove(aVar);
        }
    }

    public void a(com.baidu.tieba.enterForum.view.b bVar) {
        this.fQm = bVar;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.b bVar) {
        this.fQg = this.fNJ;
        this.fNJ = bVar;
        this.fQc.setAdState(bVar);
        rE(this.dgc.getCurrentItem());
    }

    public void setSearchHint(String str) {
        this.fQc.setSearchHint(str);
    }

    public View getRootView() {
        return getPageContext().getPageActivity().getWindow().getDecorView();
    }

    public View bvV() {
        return this.fQb;
    }

    /* loaded from: classes6.dex */
    public static abstract class a {
        public void bvW() {
        }

        public void bvX() {
        }
    }

    public String getCurrentPageKey() {
        if (this.fQe != null) {
            return this.fQe.getCurrentPageKey();
        }
        return null;
    }

    public void e(View view, int i, int i2, int i3, int i4) {
    }

    private void rF(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fQk.getLayoutParams();
        layoutParams.topMargin = this.fQo + i;
        this.fQk.setLayoutParams(layoutParams);
    }
}
