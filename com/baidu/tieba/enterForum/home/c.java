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
    private BdBaseViewPager dkI;
    private NoNetworkView elv;
    private AlphaAnimation enL;
    private AlphaAnimation enM;
    private com.baidu.tieba.enterForum.data.b fTC;
    private EnterForumTabFragment fVR;
    private LinearLayout fVS;
    private ForumHeaderView fVT;
    private NewPagerSlidingTabBaseStrip fVU;
    private EnterForumTabPagerAdapter fVV;
    private List<EnterForumTabPagerAdapter.a> fVW;
    private com.baidu.tieba.enterForum.data.b fVX;
    private ImageView fVY;
    private ImageView fVZ;
    private NavigationBar fWa;
    private View fWb;
    private List<a> fWc;
    private com.baidu.tieba.enterForum.view.b fWd;
    private int fWe;
    private int fWf;
    private com.baidu.adp.framework.listener.a fWg;
    private int mNavHeight;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private View mRootView;
    private int mSkinType;

    public c(EnterForumTabFragment enterForumTabFragment) {
        super(enterForumTabFragment.getPageContext());
        this.fWe = -1;
        this.mSkinType = 3;
        this.fWg = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.enterForum.home.c.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String str = "";
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage = (forumRecommendSocketResponseMessage) responsedMessage;
                    if (forumrecommendsocketresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendsocketresponsemessage.getHotSearchInfoData().bxP();
                    }
                } else if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage = (forumRecommendHttpResponseMessage) responsedMessage;
                    if (forumrecommendhttpresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendhttpresponsemessage.getHotSearchInfoData().bxP();
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
                if (c.this.fVW != null && c.this.fVW.size() > i) {
                    if (c.this.fWd != null) {
                        c.this.fWd.bzD();
                    }
                    EnterForumTabPagerAdapter.a aVar = (EnterForumTabPagerAdapter.a) c.this.fVW.get(i);
                    if (aVar != null && aVar.fragment != null) {
                        if (aVar.fragment instanceof RecommendFragment) {
                            if (c.this.fWc != null) {
                                for (a aVar2 : c.this.fWc) {
                                    aVar2.byH();
                                }
                            }
                        } else if ((aVar.fragment instanceof EnterForumFragment) && c.this.fWc != null) {
                            for (a aVar3 : c.this.fWc) {
                                aVar3.byG();
                            }
                        }
                        if (i == 0) {
                            c.this.fWe = 1;
                            TiebaStatic.log(new an("c13366").X("obj_locate", 1));
                        } else if (i == 1) {
                            c.this.fWe = 2;
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
        this.fVR = enterForumTabFragment;
        this.fVR.registerListener(this.fWg);
        this.mNavHeight = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds240);
        this.fWf = UtilHelper.getStatusBarHeight() + l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds240);
    }

    private void byA() {
        forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
        forumrecommendrequestmessage.set_like_forum(Integer.valueOf(TbadkCoreApplication.isLogin() ? 1 : 0));
        forumrecommendrequestmessage.set_topic(0);
        forumrecommendrequestmessage.set_recommend(1);
        this.fVR.sendMessage(forumrecommendrequestmessage);
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            ae(bundle);
            af(bundle);
            ag(bundle);
            this.elv = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.elv.a(this);
            if (!TbadkCoreApplication.getInst().checkInterrupt()) {
                byA();
            }
        }
    }

    private void ae(Bundle bundle) {
        this.dkI = (BdBaseViewPager) this.mRootView.findViewById(R.id.enter_forum_viewpager);
        EnterForumTabPagerAdapter.a aVar = new EnterForumTabPagerAdapter.a();
        aVar.fragment = new EnterForumFragment();
        aVar.title = this.fVR.getResources().getString(R.string.attention);
        ((EnterForumFragment) aVar.fragment).setTabViewController(this);
        EnterForumTabPagerAdapter.a aVar2 = new EnterForumTabPagerAdapter.a();
        aVar2.fragment = new RecommendFragment();
        aVar2.title = this.fVR.getResources().getString(R.string.default_personalized_name);
        ((RecommendFragment) aVar2.fragment).setTabViewController(this);
        this.fVW = new ArrayList();
        this.fVW.add(aVar);
        this.fVW.add(aVar2);
        this.fVV = new EnterForumTabPagerAdapter(this.fVR.getActivity().getSupportFragmentManager(), this.fVW);
        this.dkI.setAdapter(this.fVV);
        this.dkI.setOffscreenPageLimit(this.fVW.size());
    }

    public void Sq() {
    }

    private void af(Bundle bundle) {
        this.fVS = (LinearLayout) LayoutInflater.from(this.fVR.getContext()).inflate(R.layout.enter_forum_tab_layout, (ViewGroup) null);
        this.fVT = (ForumHeaderView) this.fVS.findViewById(R.id.recommend_forum_header_serch_view);
        this.fVT.onChangeSkinType();
        this.fVU = (NewPagerSlidingTabBaseStrip) this.fVS.findViewById(R.id.tab_layout);
        this.fVU.setDefaultSelectorColorResourceId(R.color.cp_cont_b);
        this.fVU.setRectPaintColor(R.color.cp_link_tip_a);
        this.fVU.a(l.getDimens(this.fVR.getContext(), R.dimen.tbds46), l.getDimens(this.fVR.getContext(), R.dimen.tbds46), l.getDimens(this.fVR.getContext(), R.dimen.tbds10), l.getDimens(this.fVR.getContext(), R.dimen.tbds46), true);
        this.fVU.setIndicatorOffset(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds64));
        this.fVU.setIndicatorOvershot(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds8));
        this.fVU.setIndicatorRadius(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds8));
        this.fVU.setIndicatorMarginBottom(l.getDimens(this.fVR.getContext(), R.dimen.tbds0));
        this.fVU.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds170), -1));
        this.fVU.setViewPager(this.dkI);
        this.fVU.setOnPageChangeListener(this.mOnPageChangeListener);
    }

    private void ag(Bundle bundle) {
        this.fWa = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.fWa.setNavHeight(this.mNavHeight);
        this.fWa.hideBottomLine();
        this.fWb = this.mRootView.findViewById(R.id.divider_shadow);
        rR(0);
        this.fVY = (ImageView) this.fVS.findViewById(R.id.navigationBarGoSignall);
        this.fVY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.CheckFile("scan_flag") && ab.checkCamera(c.this.mContext.getPageActivity())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new QRCodeScanActivityConfig(c.this.mContext.getPageActivity())));
                } else if (!TbadkCoreApplication.isLogin()) {
                    bc.skipToLoginActivity(c.this.getPageContext().getPageActivity());
                } else {
                    c.this.fVR.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(c.this.getPageContext().getPageActivity())));
                }
            }
        });
        this.fVZ = (ImageView) this.fVS.findViewById(R.id.navigationBarGoSearch);
        this.fVZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.fVT.onClick(view);
            }
        });
        if (this.fVU != null) {
            this.fWa.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, this.fVS, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.fVS.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(3);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(3);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 3;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.fVU.setPadding(this.fVU.getPaddingLeft(), this.fVU.getPaddingTop(), this.fVU.getPaddingRight(), this.fVU.getBottom());
            this.fVU.getLayoutParams().height = l.getDimens(this.fVR.getContext(), R.dimen.tbds126);
            ((RelativeLayout.LayoutParams) this.fVU.getLayoutParams()).setMargins(l.getDimens(this.fVR.getContext(), R.dimen.tbds15), 0, 0, 0);
        }
    }

    public void a(NewPagerSlidingTabBaseStrip.a aVar) {
        if (this.fVU != null && aVar != null) {
            this.fVU.setOnTabItemClickListener(aVar);
        }
    }

    public void rO(int i) {
        if (i <= 2 && i >= 1) {
            this.fWe = i;
            this.dkI.setCurrentItem(i - 1, true);
        }
    }

    public int byB() {
        return this.fWe;
    }

    public boolean rP(int i) {
        return this.fVU != null && this.fVV.byz() == i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        rQ(this.dkI.getCurrentItem());
        if (this.elv != null) {
            this.elv.onChangeSkinType(getPageContext(), i);
        }
        if (this.fVW != null && this.fVW.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.fVW.size()) {
                    break;
                }
                EnterForumTabPagerAdapter.a aVar = this.fVW.get(i3);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            }
        }
        am.setBackgroundResource(this.fWb, R.drawable.personalize_tab_shadow);
        this.fVU.onChangeSkinType();
        this.fVT.onChangeSkinType();
    }

    public void byC() {
        rQ(this.dkI.getCurrentItem());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, float f, int i2) {
        if (this.fWa != null) {
            if (i == 0) {
                if (i2 == 0) {
                    rQ(i);
                } else if (this.fTC != null && this.fTC.fUg && this.fTC.fUi > 0) {
                    if (this.fWd != null && this.fWd.getRefreshView() != null && this.fWd.getRefreshView().isViewAttached()) {
                        am.setBackgroundColor(this.fWa.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
                        return;
                    }
                    this.fWa.setBackgroundColor(0);
                    am.a(this.fWa.getBarBgView(), (int) R.color.cp_bg_line_h, f, TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (i2 == 0) {
                rQ(i);
            } else if (this.fTC != null && this.fTC.fUg && this.fTC.fUi > 0) {
                if (this.fWd != null && this.fWd.getRefreshView() != null && this.fWd.getRefreshView().isViewAttached()) {
                    am.setBackgroundColor(this.fWa.getBarBgView(), R.color.cp_bg_line_d, TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.fWa.setBackgroundColor(0);
                am.a(this.fWa.getBarBgView(), (int) R.color.cp_bg_line_d, 1.0f - f, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rQ(int i) {
        int i2;
        if (this.fVY != null) {
            if (i == 0) {
                if (this.fTC != null && this.fTC.fUg && this.fTC.fUi > 0) {
                    if (this.fWd != null && this.fWd.getRefreshView() != null && this.fWd.getRefreshView().isViewAttached()) {
                        SvgManager.aGC().a(this.fVY, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                        am.setImageResource(this.fVZ, R.drawable.icon_ba_search_black);
                    } else if (this.fTC.fUj > 0 && this.fTC.fUi > this.fTC.fUj / 2) {
                        SvgManager.aGC().a(this.fVY, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                        am.setImageResource(this.fVZ, R.drawable.icon_ba_search_white);
                    } else {
                        SvgManager.aGC().a(this.fVY, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                        am.setImageResource(this.fVZ, R.drawable.icon_ba_search_black);
                    }
                } else {
                    SvgManager.aGC().a(this.fVY, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    am.setImageResource(this.fVZ, R.drawable.icon_ba_search_black);
                }
            } else {
                SvgManager.aGC().a(this.fVY, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                am.setImageResource(this.fVZ, R.drawable.icon_ba_search_black);
            }
        }
        if (this.fWa != null) {
            this.fWa.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            if (i == 0) {
                if (this.fTC != null && this.fTC.fUg && this.fTC.fUi > 0) {
                    if (this.fWd != null && this.fWd.getRefreshView() != null && this.fWd.getRefreshView().isViewAttached()) {
                        am.setBackgroundColor(this.fWa.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
                    } else {
                        if (this.fTC.fUj > 0) {
                            int i3 = (this.fTC.fUi * 255) / this.fTC.fUj;
                            if (i3 > 255) {
                                i3 = 255;
                            }
                            i2 = 255 - i3;
                        } else {
                            i2 = 0;
                        }
                        this.fWa.setBackgroundColor(0);
                        am.a(this.fWa.getBarBgView(), (int) R.color.cp_bg_line_d, i2 / 255.0f, TbadkCoreApplication.getInst().getSkinType());
                    }
                } else {
                    am.setBackgroundColor(this.fWa.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
                }
            } else {
                am.setBackgroundColor(this.fWa.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
            }
        }
        if (i == 0) {
            if (this.fTC != null && this.fTC.fUg && this.fTC.fUi > 0) {
                if (this.fTC.fUj > 0 && this.fTC.fUi > this.fTC.fUj / 2) {
                    if (this.fWd != null && this.fWd.getRefreshView() != null && this.fWd.getRefreshView().isViewAttached()) {
                        this.fVU.setWhiteStyle(false);
                    } else {
                        this.fVU.setWhiteStyle(true);
                    }
                    if (this.fVR.isPrimary()) {
                    }
                } else {
                    this.fVU.setWhiteStyle(false);
                    if (this.fVR.isPrimary()) {
                    }
                }
            } else {
                this.fVU.setWhiteStyle(false);
                if (this.fVR.isPrimary()) {
                }
            }
        } else {
            this.fVU.setWhiteStyle(false);
            if (this.fVR.isPrimary()) {
            }
        }
        if (i == 0) {
            this.fVT.setAdState(this.fTC);
        } else {
            this.fVT.setAdState(null);
        }
        if (i == 0 && TbadkCoreApplication.getInst().getSkinType() != 1 && this.fVR.isPrimary() && this.fTC != null && this.fTC.fUg && i == 0) {
            if (this.fTC.fUi > this.fTC.fUj / 2) {
                if (this.fVX != null && this.fVX.fUi <= this.fTC.fUj / 2) {
                    ao.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
                }
            } else if (this.fVX != null && this.fVX.fUi >= this.fTC.fUj / 2) {
                ao.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            }
        }
    }

    public void byD() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
            ao.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
        } else if (this.dkI.getCurrentItem() == 0 && this.fVR.isPrimary()) {
            if (this.fWd != null && this.fWd.getRefreshView() != null && this.fWd.getRefreshView().isViewAttached()) {
                ao.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            } else if (this.fTC != null && this.fTC.fUg) {
                if (this.fTC.fUi > this.fTC.fUj / 2 || this.fTC.fUi == 0) {
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
        if (this.fVW != null && this.fVW.size() > 0 && this.dkI != null) {
            EnterForumTabPagerAdapter.a aVar = this.fVW.get(this.dkI.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void JJ() {
        if (this.fVR != null && this.fVW != null && this.dkI != null && this.fVV != null) {
            FragmentManager supportFragmentManager = this.fVR.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.fVW.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.dkI.getId(), this.fVV.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.elv != null) {
            this.elv.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.fVV != null) {
            this.fVV.setPrimary(z);
        }
        if (this.fVW != null && this.fVW.size() > 0 && this.dkI != null) {
            EnterForumTabPagerAdapter.a aVar = this.fVW.get(this.dkI.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.fVW != null && this.fVW.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.fVW.size()) {
                    break;
                }
                EnterForumTabPagerAdapter.a aVar = this.fVW.get(i2);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof NoNetworkView.a)) {
                    ((NoNetworkView.a) aVar.fragment).onNetworkChange(z);
                }
                i = i2 + 1;
            }
        }
        rQ(this.dkI.getCurrentItem());
    }

    public void bcN() {
        if (this.fVS != null && this.fVS.getPaddingTop() < 0) {
            byE();
        } else if (this.fWb != null) {
            this.fWb.clearAnimation();
            if (this.fWb.getVisibility() != 0) {
                this.fWb.setVisibility(0);
                if (this.enL == null) {
                    this.enL = new AlphaAnimation(0.0f, 1.0f);
                    this.enL.setFillAfter(true);
                    this.enL.setDuration(300L);
                }
                this.fWb.startAnimation(this.enL);
            }
        }
    }

    public void bcO() {
        if (this.fWb != null && this.fWb.getVisibility() != 8) {
            if (this.enM == null) {
                this.enM = new AlphaAnimation(1.0f, 0.0f);
                this.enM.setFillAfter(true);
                this.enM.setDuration(300L);
                this.enM.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.enterForum.home.c.5
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.fWb.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.fWb.startAnimation(this.enM);
        }
    }

    private void byE() {
        if (this.fWb != null && this.fWb.getVisibility() != 8) {
            this.fWb.clearAnimation();
            this.fWb.setVisibility(8);
        }
    }

    public void a(a aVar) {
        if (this.fWc == null) {
            this.fWc = new ArrayList();
        }
        this.fWc.add(aVar);
    }

    public void b(a aVar) {
        if (this.fWc != null && this.fWc.size() > 0) {
            this.fWc.remove(aVar);
        }
    }

    public void a(com.baidu.tieba.enterForum.view.b bVar) {
        this.fWd = bVar;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.b bVar) {
        this.fVX = this.fTC;
        this.fTC = bVar;
        this.fVT.setAdState(bVar);
        rQ(this.dkI.getCurrentItem());
    }

    public void setSearchHint(String str) {
        this.fVT.setSearchHint(str);
    }

    public View getRootView() {
        return getPageContext().getPageActivity().getWindow().getDecorView();
    }

    public View byF() {
        return this.fVS;
    }

    /* loaded from: classes9.dex */
    public static abstract class a {
        public void byG() {
        }

        public void byH() {
        }
    }

    public String getCurrentPageKey() {
        if (this.fVV != null) {
            return this.fVV.getCurrentPageKey();
        }
        return null;
    }

    public void e(View view, int i, int i2, int i3, int i4) {
    }

    private void rR(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fWb.getLayoutParams();
        layoutParams.topMargin = this.fWf + i;
        this.fWb.setLayoutParams(layoutParams);
    }
}
