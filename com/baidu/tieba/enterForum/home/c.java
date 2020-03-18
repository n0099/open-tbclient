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
    private BdBaseViewPager dkV;
    private NoNetworkView elL;
    private AlphaAnimation eoc;
    private AlphaAnimation eod;
    private com.baidu.tieba.enterForum.data.b fUl;
    private LinearLayout fWA;
    private ForumHeaderView fWB;
    private NewPagerSlidingTabBaseStrip fWC;
    private EnterForumTabPagerAdapter fWD;
    private List<EnterForumTabPagerAdapter.a> fWE;
    private com.baidu.tieba.enterForum.data.b fWF;
    private ImageView fWG;
    private ImageView fWH;
    private NavigationBar fWI;
    private View fWJ;
    private List<a> fWK;
    private com.baidu.tieba.enterForum.view.b fWL;
    private int fWM;
    private int fWN;
    private com.baidu.adp.framework.listener.a fWO;
    private EnterForumTabFragment fWz;
    private int mNavHeight;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private View mRootView;
    private int mSkinType;

    public c(EnterForumTabFragment enterForumTabFragment) {
        super(enterForumTabFragment.getPageContext());
        this.fWM = -1;
        this.mSkinType = 3;
        this.fWO = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.enterForum.home.c.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String str = "";
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage = (forumRecommendSocketResponseMessage) responsedMessage;
                    if (forumrecommendsocketresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendsocketresponsemessage.getHotSearchInfoData().bxU();
                    }
                } else if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage = (forumRecommendHttpResponseMessage) responsedMessage;
                    if (forumrecommendhttpresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendhttpresponsemessage.getHotSearchInfoData().bxU();
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
                c.this.rS(i);
                if (c.this.fWE != null && c.this.fWE.size() > i) {
                    if (c.this.fWL != null) {
                        c.this.fWL.bzJ();
                    }
                    EnterForumTabPagerAdapter.a aVar = (EnterForumTabPagerAdapter.a) c.this.fWE.get(i);
                    if (aVar != null && aVar.fragment != null) {
                        if (aVar.fragment instanceof RecommendFragment) {
                            if (c.this.fWK != null) {
                                for (a aVar2 : c.this.fWK) {
                                    aVar2.byN();
                                }
                            }
                        } else if ((aVar.fragment instanceof EnterForumFragment) && c.this.fWK != null) {
                            for (a aVar3 : c.this.fWK) {
                                aVar3.byM();
                            }
                        }
                        if (i == 0) {
                            c.this.fWM = 1;
                            TiebaStatic.log(new an("c13366").X("obj_locate", 1));
                        } else if (i == 1) {
                            c.this.fWM = 2;
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
        this.fWz = enterForumTabFragment;
        this.fWz.registerListener(this.fWO);
        this.mNavHeight = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds240);
        this.fWN = UtilHelper.getStatusBarHeight() + l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds240);
    }

    private void byG() {
        forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
        forumrecommendrequestmessage.set_like_forum(Integer.valueOf(TbadkCoreApplication.isLogin() ? 1 : 0));
        forumrecommendrequestmessage.set_topic(0);
        forumrecommendrequestmessage.set_recommend(1);
        this.fWz.sendMessage(forumrecommendrequestmessage);
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            ae(bundle);
            af(bundle);
            ag(bundle);
            this.elL = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.elL.a(this);
            if (!TbadkCoreApplication.getInst().checkInterrupt()) {
                byG();
            }
        }
    }

    private void ae(Bundle bundle) {
        this.dkV = (BdBaseViewPager) this.mRootView.findViewById(R.id.enter_forum_viewpager);
        EnterForumTabPagerAdapter.a aVar = new EnterForumTabPagerAdapter.a();
        aVar.fragment = new EnterForumFragment();
        aVar.title = this.fWz.getResources().getString(R.string.attention);
        ((EnterForumFragment) aVar.fragment).setTabViewController(this);
        EnterForumTabPagerAdapter.a aVar2 = new EnterForumTabPagerAdapter.a();
        aVar2.fragment = new RecommendFragment();
        aVar2.title = this.fWz.getResources().getString(R.string.default_personalized_name);
        ((RecommendFragment) aVar2.fragment).setTabViewController(this);
        this.fWE = new ArrayList();
        this.fWE.add(aVar);
        this.fWE.add(aVar2);
        this.fWD = new EnterForumTabPagerAdapter(this.fWz.getActivity().getSupportFragmentManager(), this.fWE);
        this.dkV.setAdapter(this.fWD);
        this.dkV.setOffscreenPageLimit(this.fWE.size());
    }

    public void St() {
    }

    private void af(Bundle bundle) {
        this.fWA = (LinearLayout) LayoutInflater.from(this.fWz.getContext()).inflate(R.layout.enter_forum_tab_layout, (ViewGroup) null);
        this.fWB = (ForumHeaderView) this.fWA.findViewById(R.id.recommend_forum_header_serch_view);
        this.fWB.onChangeSkinType();
        this.fWC = (NewPagerSlidingTabBaseStrip) this.fWA.findViewById(R.id.tab_layout);
        this.fWC.setDefaultSelectorColorResourceId(R.color.cp_cont_b);
        this.fWC.setRectPaintColor(R.color.cp_link_tip_a);
        this.fWC.a(l.getDimens(this.fWz.getContext(), R.dimen.tbds46), l.getDimens(this.fWz.getContext(), R.dimen.tbds46), l.getDimens(this.fWz.getContext(), R.dimen.tbds10), l.getDimens(this.fWz.getContext(), R.dimen.tbds46), true);
        this.fWC.setIndicatorOffset(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds64));
        this.fWC.setIndicatorOvershot(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds8));
        this.fWC.setIndicatorRadius(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds8));
        this.fWC.setIndicatorMarginBottom(l.getDimens(this.fWz.getContext(), R.dimen.tbds0));
        this.fWC.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds170), -1));
        this.fWC.setViewPager(this.dkV);
        this.fWC.setOnPageChangeListener(this.mOnPageChangeListener);
    }

    private void ag(Bundle bundle) {
        this.fWI = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.fWI.setNavHeight(this.mNavHeight);
        this.fWI.hideBottomLine();
        this.fWJ = this.mRootView.findViewById(R.id.divider_shadow);
        rT(0);
        this.fWG = (ImageView) this.fWA.findViewById(R.id.navigationBarGoSignall);
        this.fWG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.CheckFile("scan_flag") && ab.checkCamera(c.this.mContext.getPageActivity())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new QRCodeScanActivityConfig(c.this.mContext.getPageActivity())));
                } else if (!TbadkCoreApplication.isLogin()) {
                    bc.skipToLoginActivity(c.this.getPageContext().getPageActivity());
                } else {
                    c.this.fWz.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(c.this.getPageContext().getPageActivity())));
                }
            }
        });
        this.fWH = (ImageView) this.fWA.findViewById(R.id.navigationBarGoSearch);
        this.fWH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.fWB.onClick(view);
            }
        });
        if (this.fWC != null) {
            this.fWI.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, this.fWA, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.fWA.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(3);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(3);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 3;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.fWC.setPadding(this.fWC.getPaddingLeft(), this.fWC.getPaddingTop(), this.fWC.getPaddingRight(), this.fWC.getBottom());
            this.fWC.getLayoutParams().height = l.getDimens(this.fWz.getContext(), R.dimen.tbds126);
            ((RelativeLayout.LayoutParams) this.fWC.getLayoutParams()).setMargins(l.getDimens(this.fWz.getContext(), R.dimen.tbds15), 0, 0, 0);
        }
    }

    public void a(NewPagerSlidingTabBaseStrip.a aVar) {
        if (this.fWC != null && aVar != null) {
            this.fWC.setOnTabItemClickListener(aVar);
        }
    }

    public void rQ(int i) {
        if (i <= 2 && i >= 1) {
            this.fWM = i;
            this.dkV.setCurrentItem(i - 1, true);
        }
    }

    public int byH() {
        return this.fWM;
    }

    public boolean rR(int i) {
        return this.fWC != null && this.fWD.byF() == i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        rS(this.dkV.getCurrentItem());
        if (this.elL != null) {
            this.elL.onChangeSkinType(getPageContext(), i);
        }
        if (this.fWE != null && this.fWE.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.fWE.size()) {
                    break;
                }
                EnterForumTabPagerAdapter.a aVar = this.fWE.get(i3);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            }
        }
        am.setBackgroundResource(this.fWJ, R.drawable.personalize_tab_shadow);
        this.fWC.onChangeSkinType();
        this.fWB.onChangeSkinType();
    }

    public void byI() {
        rS(this.dkV.getCurrentItem());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, float f, int i2) {
        if (this.fWI != null) {
            if (i == 0) {
                if (i2 == 0) {
                    rS(i);
                } else if (this.fUl != null && this.fUl.fUP && this.fUl.fUR > 0) {
                    if (this.fWL != null && this.fWL.getRefreshView() != null && this.fWL.getRefreshView().isViewAttached()) {
                        am.setBackgroundColor(this.fWI.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
                        return;
                    }
                    this.fWI.setBackgroundColor(0);
                    am.a(this.fWI.getBarBgView(), (int) R.color.cp_bg_line_h, f, TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (i2 == 0) {
                rS(i);
            } else if (this.fUl != null && this.fUl.fUP && this.fUl.fUR > 0) {
                if (this.fWL != null && this.fWL.getRefreshView() != null && this.fWL.getRefreshView().isViewAttached()) {
                    am.setBackgroundColor(this.fWI.getBarBgView(), R.color.cp_bg_line_d, TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.fWI.setBackgroundColor(0);
                am.a(this.fWI.getBarBgView(), (int) R.color.cp_bg_line_d, 1.0f - f, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rS(int i) {
        int i2;
        if (this.fWG != null) {
            if (i == 0) {
                if (this.fUl != null && this.fUl.fUP && this.fUl.fUR > 0) {
                    if (this.fWL != null && this.fWL.getRefreshView() != null && this.fWL.getRefreshView().isViewAttached()) {
                        SvgManager.aGG().a(this.fWG, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                        am.setImageResource(this.fWH, R.drawable.icon_ba_search_black);
                    } else if (this.fUl.fUS > 0 && this.fUl.fUR > this.fUl.fUS / 2) {
                        SvgManager.aGG().a(this.fWG, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                        am.setImageResource(this.fWH, R.drawable.icon_ba_search_white);
                    } else {
                        SvgManager.aGG().a(this.fWG, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                        am.setImageResource(this.fWH, R.drawable.icon_ba_search_black);
                    }
                } else {
                    SvgManager.aGG().a(this.fWG, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    am.setImageResource(this.fWH, R.drawable.icon_ba_search_black);
                }
            } else {
                SvgManager.aGG().a(this.fWG, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                am.setImageResource(this.fWH, R.drawable.icon_ba_search_black);
            }
        }
        if (this.fWI != null) {
            this.fWI.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            if (i == 0) {
                if (this.fUl != null && this.fUl.fUP && this.fUl.fUR > 0) {
                    if (this.fWL != null && this.fWL.getRefreshView() != null && this.fWL.getRefreshView().isViewAttached()) {
                        am.setBackgroundColor(this.fWI.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
                    } else {
                        if (this.fUl.fUS > 0) {
                            int i3 = (this.fUl.fUR * 255) / this.fUl.fUS;
                            if (i3 > 255) {
                                i3 = 255;
                            }
                            i2 = 255 - i3;
                        } else {
                            i2 = 0;
                        }
                        this.fWI.setBackgroundColor(0);
                        am.a(this.fWI.getBarBgView(), (int) R.color.cp_bg_line_d, i2 / 255.0f, TbadkCoreApplication.getInst().getSkinType());
                    }
                } else {
                    am.setBackgroundColor(this.fWI.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
                }
            } else {
                am.setBackgroundColor(this.fWI.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
            }
        }
        if (i == 0) {
            if (this.fUl != null && this.fUl.fUP && this.fUl.fUR > 0) {
                if (this.fUl.fUS > 0 && this.fUl.fUR > this.fUl.fUS / 2) {
                    if (this.fWL != null && this.fWL.getRefreshView() != null && this.fWL.getRefreshView().isViewAttached()) {
                        this.fWC.setWhiteStyle(false);
                    } else {
                        this.fWC.setWhiteStyle(true);
                    }
                    if (this.fWz.isPrimary()) {
                    }
                } else {
                    this.fWC.setWhiteStyle(false);
                    if (this.fWz.isPrimary()) {
                    }
                }
            } else {
                this.fWC.setWhiteStyle(false);
                if (this.fWz.isPrimary()) {
                }
            }
        } else {
            this.fWC.setWhiteStyle(false);
            if (this.fWz.isPrimary()) {
            }
        }
        if (i == 0) {
            this.fWB.setAdState(this.fUl);
        } else {
            this.fWB.setAdState(null);
        }
        if (i == 0 && TbadkCoreApplication.getInst().getSkinType() != 1 && this.fWz.isPrimary() && this.fUl != null && this.fUl.fUP && i == 0) {
            if (this.fUl.fUR > this.fUl.fUS / 2) {
                if (this.fWF != null && this.fWF.fUR <= this.fUl.fUS / 2) {
                    ao.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
                }
            } else if (this.fWF != null && this.fWF.fUR >= this.fUl.fUS / 2) {
                ao.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            }
        }
    }

    public void byJ() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
            ao.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
        } else if (this.dkV.getCurrentItem() == 0 && this.fWz.isPrimary()) {
            if (this.fWL != null && this.fWL.getRefreshView() != null && this.fWL.getRefreshView().isViewAttached()) {
                ao.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            } else if (this.fUl != null && this.fUl.fUP) {
                if (this.fUl.fUR > this.fUl.fUS / 2 || this.fUl.fUR == 0) {
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
        if (this.fWE != null && this.fWE.size() > 0 && this.dkV != null) {
            EnterForumTabPagerAdapter.a aVar = this.fWE.get(this.dkV.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void JM() {
        if (this.fWz != null && this.fWE != null && this.dkV != null && this.fWD != null) {
            FragmentManager supportFragmentManager = this.fWz.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.fWE.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.dkV.getId(), this.fWD.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.elL != null) {
            this.elL.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.fWD != null) {
            this.fWD.setPrimary(z);
        }
        if (this.fWE != null && this.fWE.size() > 0 && this.dkV != null) {
            EnterForumTabPagerAdapter.a aVar = this.fWE.get(this.dkV.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.fWE != null && this.fWE.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.fWE.size()) {
                    break;
                }
                EnterForumTabPagerAdapter.a aVar = this.fWE.get(i2);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof NoNetworkView.a)) {
                    ((NoNetworkView.a) aVar.fragment).onNetworkChange(z);
                }
                i = i2 + 1;
            }
        }
        rS(this.dkV.getCurrentItem());
    }

    public void bcR() {
        if (this.fWA != null && this.fWA.getPaddingTop() < 0) {
            byK();
        } else if (this.fWJ != null) {
            this.fWJ.clearAnimation();
            if (this.fWJ.getVisibility() != 0) {
                this.fWJ.setVisibility(0);
                if (this.eoc == null) {
                    this.eoc = new AlphaAnimation(0.0f, 1.0f);
                    this.eoc.setFillAfter(true);
                    this.eoc.setDuration(300L);
                }
                this.fWJ.startAnimation(this.eoc);
            }
        }
    }

    public void bcS() {
        if (this.fWJ != null && this.fWJ.getVisibility() != 8) {
            if (this.eod == null) {
                this.eod = new AlphaAnimation(1.0f, 0.0f);
                this.eod.setFillAfter(true);
                this.eod.setDuration(300L);
                this.eod.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.enterForum.home.c.5
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.fWJ.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.fWJ.startAnimation(this.eod);
        }
    }

    private void byK() {
        if (this.fWJ != null && this.fWJ.getVisibility() != 8) {
            this.fWJ.clearAnimation();
            this.fWJ.setVisibility(8);
        }
    }

    public void a(a aVar) {
        if (this.fWK == null) {
            this.fWK = new ArrayList();
        }
        this.fWK.add(aVar);
    }

    public void b(a aVar) {
        if (this.fWK != null && this.fWK.size() > 0) {
            this.fWK.remove(aVar);
        }
    }

    public void a(com.baidu.tieba.enterForum.view.b bVar) {
        this.fWL = bVar;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.b bVar) {
        this.fWF = this.fUl;
        this.fUl = bVar;
        this.fWB.setAdState(bVar);
        rS(this.dkV.getCurrentItem());
    }

    public void setSearchHint(String str) {
        this.fWB.setSearchHint(str);
    }

    public View getRootView() {
        return getPageContext().getPageActivity().getWindow().getDecorView();
    }

    public View byL() {
        return this.fWA;
    }

    /* loaded from: classes9.dex */
    public static abstract class a {
        public void byM() {
        }

        public void byN() {
        }
    }

    public String getCurrentPageKey() {
        if (this.fWD != null) {
            return this.fWD.getCurrentPageKey();
        }
        return null;
    }

    public void e(View view, int i, int i2, int i3, int i4) {
    }

    private void rT(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fWJ.getLayoutParams();
        layoutParams.topMargin = this.fWN + i;
        this.fWJ.setLayoutParams(layoutParams);
    }
}
