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
/* loaded from: classes9.dex */
public class c extends com.baidu.adp.base.c implements NoNetworkView.a {
    private BdBaseViewPager dku;
    private NoNetworkView elh;
    private AlphaAnimation enx;
    private AlphaAnimation eny;
    private com.baidu.tieba.enterForum.data.b fTn;
    private EnterForumTabFragment fVC;
    private LinearLayout fVD;
    private ForumHeaderView fVE;
    private NewPagerSlidingTabBaseStrip fVF;
    private EnterForumTabPagerAdapter fVG;
    private List<EnterForumTabPagerAdapter.a> fVH;
    private com.baidu.tieba.enterForum.data.b fVI;
    private ImageView fVJ;
    private ImageView fVK;
    private NavigationBar fVL;
    private View fVM;
    private List<a> fVN;
    private com.baidu.tieba.enterForum.view.b fVO;
    private int fVP;
    private int fVQ;
    private com.baidu.adp.framework.listener.a fVR;
    private int mNavHeight;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private View mRootView;
    private int mSkinType;

    public c(EnterForumTabFragment enterForumTabFragment) {
        super(enterForumTabFragment.getPageContext());
        this.fVP = -1;
        this.mSkinType = 3;
        this.fVR = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.enterForum.home.c.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String str = "";
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage = (forumRecommendSocketResponseMessage) responsedMessage;
                    if (forumrecommendsocketresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendsocketresponsemessage.getHotSearchInfoData().bxM();
                    }
                } else if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage = (forumRecommendHttpResponseMessage) responsedMessage;
                    if (forumrecommendhttpresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendhttpresponsemessage.getHotSearchInfoData().bxM();
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
                c.this.rQ(i);
                if (c.this.fVH != null && c.this.fVH.size() > i) {
                    if (c.this.fVO != null) {
                        c.this.fVO.bzA();
                    }
                    EnterForumTabPagerAdapter.a aVar = (EnterForumTabPagerAdapter.a) c.this.fVH.get(i);
                    if (aVar != null && aVar.fragment != null) {
                        if (aVar.fragment instanceof RecommendFragment) {
                            if (c.this.fVN != null) {
                                for (a aVar2 : c.this.fVN) {
                                    aVar2.byE();
                                }
                            }
                        } else if ((aVar.fragment instanceof EnterForumFragment) && c.this.fVN != null) {
                            for (a aVar3 : c.this.fVN) {
                                aVar3.byD();
                            }
                        }
                        if (i == 0) {
                            c.this.fVP = 1;
                            TiebaStatic.log(new an("c13366").X("obj_locate", 1));
                        } else if (i == 1) {
                            c.this.fVP = 2;
                            TiebaStatic.log(new an("c13366").X("obj_locate", 2));
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
        this.fVC = enterForumTabFragment;
        this.fVC.registerListener(this.fVR);
        this.mNavHeight = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds240);
        this.fVQ = UtilHelper.getStatusBarHeight() + l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds240);
    }

    private void byx() {
        forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
        forumrecommendrequestmessage.set_like_forum(Integer.valueOf(TbadkCoreApplication.isLogin() ? 1 : 0));
        forumrecommendrequestmessage.set_topic(0);
        forumrecommendrequestmessage.set_recommend(1);
        this.fVC.sendMessage(forumrecommendrequestmessage);
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            ae(bundle);
            af(bundle);
            ag(bundle);
            this.elh = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.elh.a(this);
            if (!TbadkCoreApplication.getInst().checkInterrupt()) {
                byx();
            }
        }
    }

    private void ae(Bundle bundle) {
        this.dku = (BdBaseViewPager) this.mRootView.findViewById(R.id.enter_forum_viewpager);
        EnterForumTabPagerAdapter.a aVar = new EnterForumTabPagerAdapter.a();
        aVar.fragment = new EnterForumFragment();
        aVar.title = this.fVC.getResources().getString(R.string.attention);
        ((EnterForumFragment) aVar.fragment).setTabViewController(this);
        EnterForumTabPagerAdapter.a aVar2 = new EnterForumTabPagerAdapter.a();
        aVar2.fragment = new RecommendFragment();
        aVar2.title = this.fVC.getResources().getString(R.string.default_personalized_name);
        ((RecommendFragment) aVar2.fragment).setTabViewController(this);
        this.fVH = new ArrayList();
        this.fVH.add(aVar);
        this.fVH.add(aVar2);
        this.fVG = new EnterForumTabPagerAdapter(this.fVC.getActivity().getSupportFragmentManager(), this.fVH);
        this.dku.setAdapter(this.fVG);
        this.dku.setOffscreenPageLimit(this.fVH.size());
    }

    public void So() {
    }

    private void af(Bundle bundle) {
        this.fVD = (LinearLayout) LayoutInflater.from(this.fVC.getContext()).inflate(R.layout.enter_forum_tab_layout, (ViewGroup) null);
        this.fVE = (ForumHeaderView) this.fVD.findViewById(R.id.recommend_forum_header_serch_view);
        this.fVE.onChangeSkinType();
        this.fVF = (NewPagerSlidingTabBaseStrip) this.fVD.findViewById(R.id.tab_layout);
        this.fVF.setDefaultSelectorColorResourceId(R.color.cp_cont_b);
        this.fVF.setRectPaintColor(R.color.cp_link_tip_a);
        this.fVF.a(l.getDimens(this.fVC.getContext(), R.dimen.tbds46), l.getDimens(this.fVC.getContext(), R.dimen.tbds46), l.getDimens(this.fVC.getContext(), R.dimen.tbds10), l.getDimens(this.fVC.getContext(), R.dimen.tbds46), true);
        this.fVF.setIndicatorOffset(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds64));
        this.fVF.setIndicatorOvershot(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds8));
        this.fVF.setIndicatorRadius(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds8));
        this.fVF.setIndicatorMarginBottom(l.getDimens(this.fVC.getContext(), R.dimen.tbds0));
        this.fVF.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds170), -1));
        this.fVF.setViewPager(this.dku);
        this.fVF.setOnPageChangeListener(this.mOnPageChangeListener);
    }

    private void ag(Bundle bundle) {
        this.fVL = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.fVL.setNavHeight(this.mNavHeight);
        this.fVL.hideBottomLine();
        this.fVM = this.mRootView.findViewById(R.id.divider_shadow);
        rR(0);
        this.fVJ = (ImageView) this.fVD.findViewById(R.id.navigationBarGoSignall);
        this.fVJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.CheckFile("scan_flag") && ab.checkCamera(c.this.mContext.getPageActivity())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new QRCodeScanActivityConfig(c.this.mContext.getPageActivity())));
                } else if (!TbadkCoreApplication.isLogin()) {
                    bc.skipToLoginActivity(c.this.getPageContext().getPageActivity());
                } else {
                    c.this.fVC.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(c.this.getPageContext().getPageActivity())));
                }
            }
        });
        this.fVK = (ImageView) this.fVD.findViewById(R.id.navigationBarGoSearch);
        this.fVK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.fVE.onClick(view);
            }
        });
        if (this.fVF != null) {
            this.fVL.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, this.fVD, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.fVD.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(3);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(3);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 3;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.fVF.setPadding(this.fVF.getPaddingLeft(), this.fVF.getPaddingTop(), this.fVF.getPaddingRight(), this.fVF.getBottom());
            this.fVF.getLayoutParams().height = l.getDimens(this.fVC.getContext(), R.dimen.tbds126);
            ((RelativeLayout.LayoutParams) this.fVF.getLayoutParams()).setMargins(l.getDimens(this.fVC.getContext(), R.dimen.tbds15), 0, 0, 0);
        }
    }

    public void a(NewPagerSlidingTabBaseStrip.a aVar) {
        if (this.fVF != null && aVar != null) {
            this.fVF.setOnTabItemClickListener(aVar);
        }
    }

    public void rO(int i) {
        if (i <= 2 && i >= 1) {
            this.fVP = i;
            this.dku.setCurrentItem(i - 1, true);
        }
    }

    public int byy() {
        return this.fVP;
    }

    public boolean rP(int i) {
        return this.fVF != null && this.fVG.byw() == i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        rQ(this.dku.getCurrentItem());
        if (this.elh != null) {
            this.elh.onChangeSkinType(getPageContext(), i);
        }
        if (this.fVH != null && this.fVH.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.fVH.size()) {
                    break;
                }
                EnterForumTabPagerAdapter.a aVar = this.fVH.get(i3);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            }
        }
        am.setBackgroundResource(this.fVM, R.drawable.personalize_tab_shadow);
        this.fVF.onChangeSkinType();
        this.fVE.onChangeSkinType();
    }

    public void byz() {
        rQ(this.dku.getCurrentItem());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, float f, int i2) {
        if (this.fVL != null) {
            if (i == 0) {
                if (i2 == 0) {
                    rQ(i);
                } else if (this.fTn != null && this.fTn.fTR && this.fTn.fTT > 0) {
                    if (this.fVO != null && this.fVO.getRefreshView() != null && this.fVO.getRefreshView().isViewAttached()) {
                        am.setBackgroundColor(this.fVL.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
                        return;
                    }
                    this.fVL.setBackgroundColor(0);
                    am.a(this.fVL.getBarBgView(), (int) R.color.cp_bg_line_h, f, TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (i2 == 0) {
                rQ(i);
            } else if (this.fTn != null && this.fTn.fTR && this.fTn.fTT > 0) {
                if (this.fVO != null && this.fVO.getRefreshView() != null && this.fVO.getRefreshView().isViewAttached()) {
                    am.setBackgroundColor(this.fVL.getBarBgView(), R.color.cp_bg_line_d, TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.fVL.setBackgroundColor(0);
                am.a(this.fVL.getBarBgView(), (int) R.color.cp_bg_line_d, 1.0f - f, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rQ(int i) {
        int i2;
        if (this.fVJ != null) {
            if (i == 0) {
                if (this.fTn != null && this.fTn.fTR && this.fTn.fTT > 0) {
                    if (this.fVO != null && this.fVO.getRefreshView() != null && this.fVO.getRefreshView().isViewAttached()) {
                        SvgManager.aGA().a(this.fVJ, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                        am.setImageResource(this.fVK, R.drawable.icon_ba_search_black);
                    } else if (this.fTn.fTU > 0 && this.fTn.fTT > this.fTn.fTU / 2) {
                        SvgManager.aGA().a(this.fVJ, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                        am.setImageResource(this.fVK, R.drawable.icon_ba_search_white);
                    } else {
                        SvgManager.aGA().a(this.fVJ, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                        am.setImageResource(this.fVK, R.drawable.icon_ba_search_black);
                    }
                } else {
                    SvgManager.aGA().a(this.fVJ, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    am.setImageResource(this.fVK, R.drawable.icon_ba_search_black);
                }
            } else {
                SvgManager.aGA().a(this.fVJ, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                am.setImageResource(this.fVK, R.drawable.icon_ba_search_black);
            }
        }
        if (this.fVL != null) {
            this.fVL.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            if (i == 0) {
                if (this.fTn != null && this.fTn.fTR && this.fTn.fTT > 0) {
                    if (this.fVO != null && this.fVO.getRefreshView() != null && this.fVO.getRefreshView().isViewAttached()) {
                        am.setBackgroundColor(this.fVL.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
                    } else {
                        if (this.fTn.fTU > 0) {
                            int i3 = (this.fTn.fTT * 255) / this.fTn.fTU;
                            if (i3 > 255) {
                                i3 = 255;
                            }
                            i2 = 255 - i3;
                        } else {
                            i2 = 0;
                        }
                        this.fVL.setBackgroundColor(0);
                        am.a(this.fVL.getBarBgView(), (int) R.color.cp_bg_line_d, i2 / 255.0f, TbadkCoreApplication.getInst().getSkinType());
                    }
                } else {
                    am.setBackgroundColor(this.fVL.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
                }
            } else {
                am.setBackgroundColor(this.fVL.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
            }
        }
        if (i == 0) {
            if (this.fTn != null && this.fTn.fTR && this.fTn.fTT > 0) {
                if (this.fTn.fTU > 0 && this.fTn.fTT > this.fTn.fTU / 2) {
                    if (this.fVO != null && this.fVO.getRefreshView() != null && this.fVO.getRefreshView().isViewAttached()) {
                        this.fVF.setWhiteStyle(false);
                    } else {
                        this.fVF.setWhiteStyle(true);
                    }
                    if (this.fVC.isPrimary()) {
                    }
                } else {
                    this.fVF.setWhiteStyle(false);
                    if (this.fVC.isPrimary()) {
                    }
                }
            } else {
                this.fVF.setWhiteStyle(false);
                if (this.fVC.isPrimary()) {
                }
            }
        } else {
            this.fVF.setWhiteStyle(false);
            if (this.fVC.isPrimary()) {
            }
        }
        if (i == 0) {
            this.fVE.setAdState(this.fTn);
        } else {
            this.fVE.setAdState(null);
        }
        if (i == 0 && TbadkCoreApplication.getInst().getSkinType() != 1 && this.fVC.isPrimary() && this.fTn != null && this.fTn.fTR && i == 0) {
            if (this.fTn.fTT > this.fTn.fTU / 2) {
                if (this.fVI != null && this.fVI.fTT <= this.fTn.fTU / 2) {
                    ao.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
                }
            } else if (this.fVI != null && this.fVI.fTT >= this.fTn.fTU / 2) {
                ao.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            }
        }
    }

    public void byA() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
            ao.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
        } else if (this.dku.getCurrentItem() == 0 && this.fVC.isPrimary()) {
            if (this.fVO != null && this.fVO.getRefreshView() != null && this.fVO.getRefreshView().isViewAttached()) {
                ao.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            } else if (this.fTn != null && this.fTn.fTR) {
                if (this.fTn.fTT > this.fTn.fTU / 2 || this.fTn.fTT == 0) {
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
        if (this.fVH != null && this.fVH.size() > 0 && this.dku != null) {
            EnterForumTabPagerAdapter.a aVar = this.fVH.get(this.dku.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void JH() {
        if (this.fVC != null && this.fVH != null && this.dku != null && this.fVG != null) {
            FragmentManager supportFragmentManager = this.fVC.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.fVH.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.dku.getId(), this.fVG.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.elh != null) {
            this.elh.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.fVG != null) {
            this.fVG.setPrimary(z);
        }
        if (this.fVH != null && this.fVH.size() > 0 && this.dku != null) {
            EnterForumTabPagerAdapter.a aVar = this.fVH.get(this.dku.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.fVH != null && this.fVH.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.fVH.size()) {
                    break;
                }
                EnterForumTabPagerAdapter.a aVar = this.fVH.get(i2);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof NoNetworkView.a)) {
                    ((NoNetworkView.a) aVar.fragment).onNetworkChange(z);
                }
                i = i2 + 1;
            }
        }
        rQ(this.dku.getCurrentItem());
    }

    public void bcK() {
        if (this.fVD != null && this.fVD.getPaddingTop() < 0) {
            byB();
        } else if (this.fVM != null) {
            this.fVM.clearAnimation();
            if (this.fVM.getVisibility() != 0) {
                this.fVM.setVisibility(0);
                if (this.enx == null) {
                    this.enx = new AlphaAnimation(0.0f, 1.0f);
                    this.enx.setFillAfter(true);
                    this.enx.setDuration(300L);
                }
                this.fVM.startAnimation(this.enx);
            }
        }
    }

    public void bcL() {
        if (this.fVM != null && this.fVM.getVisibility() != 8) {
            if (this.eny == null) {
                this.eny = new AlphaAnimation(1.0f, 0.0f);
                this.eny.setFillAfter(true);
                this.eny.setDuration(300L);
                this.eny.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.enterForum.home.c.5
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.fVM.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.fVM.startAnimation(this.eny);
        }
    }

    private void byB() {
        if (this.fVM != null && this.fVM.getVisibility() != 8) {
            this.fVM.clearAnimation();
            this.fVM.setVisibility(8);
        }
    }

    public void a(a aVar) {
        if (this.fVN == null) {
            this.fVN = new ArrayList();
        }
        this.fVN.add(aVar);
    }

    public void b(a aVar) {
        if (this.fVN != null && this.fVN.size() > 0) {
            this.fVN.remove(aVar);
        }
    }

    public void a(com.baidu.tieba.enterForum.view.b bVar) {
        this.fVO = bVar;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.b bVar) {
        this.fVI = this.fTn;
        this.fTn = bVar;
        this.fVE.setAdState(bVar);
        rQ(this.dku.getCurrentItem());
    }

    public void setSearchHint(String str) {
        this.fVE.setSearchHint(str);
    }

    public View getRootView() {
        return getPageContext().getPageActivity().getWindow().getDecorView();
    }

    public View byC() {
        return this.fVD;
    }

    /* loaded from: classes9.dex */
    public static abstract class a {
        public void byD() {
        }

        public void byE() {
        }
    }

    public String getCurrentPageKey() {
        if (this.fVG != null) {
            return this.fVG.getCurrentPageKey();
        }
        return null;
    }

    public void e(View view, int i, int i2, int i3, int i4) {
    }

    private void rR(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fVM.getLayoutParams();
        layoutParams.topMargin = this.fVQ + i;
        this.fVM.setLayoutParams(layoutParams);
    }
}
