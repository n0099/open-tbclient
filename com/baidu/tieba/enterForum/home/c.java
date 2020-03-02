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
    private BdBaseViewPager dkv;
    private NoNetworkView eli;
    private AlphaAnimation eny;
    private AlphaAnimation enz;
    private com.baidu.tieba.enterForum.data.b fTp;
    private EnterForumTabFragment fVE;
    private LinearLayout fVF;
    private ForumHeaderView fVG;
    private NewPagerSlidingTabBaseStrip fVH;
    private EnterForumTabPagerAdapter fVI;
    private List<EnterForumTabPagerAdapter.a> fVJ;
    private com.baidu.tieba.enterForum.data.b fVK;
    private ImageView fVL;
    private ImageView fVM;
    private NavigationBar fVN;
    private View fVO;
    private List<a> fVP;
    private com.baidu.tieba.enterForum.view.b fVQ;
    private int fVR;
    private int fVS;
    private com.baidu.adp.framework.listener.a fVT;
    private int mNavHeight;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private View mRootView;
    private int mSkinType;

    public c(EnterForumTabFragment enterForumTabFragment) {
        super(enterForumTabFragment.getPageContext());
        this.fVR = -1;
        this.mSkinType = 3;
        this.fVT = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.enterForum.home.c.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String str = "";
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage = (forumRecommendSocketResponseMessage) responsedMessage;
                    if (forumrecommendsocketresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendsocketresponsemessage.getHotSearchInfoData().bxO();
                    }
                } else if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage = (forumRecommendHttpResponseMessage) responsedMessage;
                    if (forumrecommendhttpresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendhttpresponsemessage.getHotSearchInfoData().bxO();
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
                if (c.this.fVJ != null && c.this.fVJ.size() > i) {
                    if (c.this.fVQ != null) {
                        c.this.fVQ.bzC();
                    }
                    EnterForumTabPagerAdapter.a aVar = (EnterForumTabPagerAdapter.a) c.this.fVJ.get(i);
                    if (aVar != null && aVar.fragment != null) {
                        if (aVar.fragment instanceof RecommendFragment) {
                            if (c.this.fVP != null) {
                                for (a aVar2 : c.this.fVP) {
                                    aVar2.byG();
                                }
                            }
                        } else if ((aVar.fragment instanceof EnterForumFragment) && c.this.fVP != null) {
                            for (a aVar3 : c.this.fVP) {
                                aVar3.byF();
                            }
                        }
                        if (i == 0) {
                            c.this.fVR = 1;
                            TiebaStatic.log(new an("c13366").X("obj_locate", 1));
                        } else if (i == 1) {
                            c.this.fVR = 2;
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
        this.fVE = enterForumTabFragment;
        this.fVE.registerListener(this.fVT);
        this.mNavHeight = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds240);
        this.fVS = UtilHelper.getStatusBarHeight() + l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds240);
    }

    private void byz() {
        forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
        forumrecommendrequestmessage.set_like_forum(Integer.valueOf(TbadkCoreApplication.isLogin() ? 1 : 0));
        forumrecommendrequestmessage.set_topic(0);
        forumrecommendrequestmessage.set_recommend(1);
        this.fVE.sendMessage(forumrecommendrequestmessage);
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            ae(bundle);
            af(bundle);
            ag(bundle);
            this.eli = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.eli.a(this);
            if (!TbadkCoreApplication.getInst().checkInterrupt()) {
                byz();
            }
        }
    }

    private void ae(Bundle bundle) {
        this.dkv = (BdBaseViewPager) this.mRootView.findViewById(R.id.enter_forum_viewpager);
        EnterForumTabPagerAdapter.a aVar = new EnterForumTabPagerAdapter.a();
        aVar.fragment = new EnterForumFragment();
        aVar.title = this.fVE.getResources().getString(R.string.attention);
        ((EnterForumFragment) aVar.fragment).setTabViewController(this);
        EnterForumTabPagerAdapter.a aVar2 = new EnterForumTabPagerAdapter.a();
        aVar2.fragment = new RecommendFragment();
        aVar2.title = this.fVE.getResources().getString(R.string.default_personalized_name);
        ((RecommendFragment) aVar2.fragment).setTabViewController(this);
        this.fVJ = new ArrayList();
        this.fVJ.add(aVar);
        this.fVJ.add(aVar2);
        this.fVI = new EnterForumTabPagerAdapter(this.fVE.getActivity().getSupportFragmentManager(), this.fVJ);
        this.dkv.setAdapter(this.fVI);
        this.dkv.setOffscreenPageLimit(this.fVJ.size());
    }

    public void Sq() {
    }

    private void af(Bundle bundle) {
        this.fVF = (LinearLayout) LayoutInflater.from(this.fVE.getContext()).inflate(R.layout.enter_forum_tab_layout, (ViewGroup) null);
        this.fVG = (ForumHeaderView) this.fVF.findViewById(R.id.recommend_forum_header_serch_view);
        this.fVG.onChangeSkinType();
        this.fVH = (NewPagerSlidingTabBaseStrip) this.fVF.findViewById(R.id.tab_layout);
        this.fVH.setDefaultSelectorColorResourceId(R.color.cp_cont_b);
        this.fVH.setRectPaintColor(R.color.cp_link_tip_a);
        this.fVH.a(l.getDimens(this.fVE.getContext(), R.dimen.tbds46), l.getDimens(this.fVE.getContext(), R.dimen.tbds46), l.getDimens(this.fVE.getContext(), R.dimen.tbds10), l.getDimens(this.fVE.getContext(), R.dimen.tbds46), true);
        this.fVH.setIndicatorOffset(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds64));
        this.fVH.setIndicatorOvershot(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds8));
        this.fVH.setIndicatorRadius(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds8));
        this.fVH.setIndicatorMarginBottom(l.getDimens(this.fVE.getContext(), R.dimen.tbds0));
        this.fVH.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds170), -1));
        this.fVH.setViewPager(this.dkv);
        this.fVH.setOnPageChangeListener(this.mOnPageChangeListener);
    }

    private void ag(Bundle bundle) {
        this.fVN = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.fVN.setNavHeight(this.mNavHeight);
        this.fVN.hideBottomLine();
        this.fVO = this.mRootView.findViewById(R.id.divider_shadow);
        rR(0);
        this.fVL = (ImageView) this.fVF.findViewById(R.id.navigationBarGoSignall);
        this.fVL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.CheckFile("scan_flag") && ab.checkCamera(c.this.mContext.getPageActivity())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new QRCodeScanActivityConfig(c.this.mContext.getPageActivity())));
                } else if (!TbadkCoreApplication.isLogin()) {
                    bc.skipToLoginActivity(c.this.getPageContext().getPageActivity());
                } else {
                    c.this.fVE.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(c.this.getPageContext().getPageActivity())));
                }
            }
        });
        this.fVM = (ImageView) this.fVF.findViewById(R.id.navigationBarGoSearch);
        this.fVM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.fVG.onClick(view);
            }
        });
        if (this.fVH != null) {
            this.fVN.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, this.fVF, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.fVF.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(3);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(3);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 3;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.fVH.setPadding(this.fVH.getPaddingLeft(), this.fVH.getPaddingTop(), this.fVH.getPaddingRight(), this.fVH.getBottom());
            this.fVH.getLayoutParams().height = l.getDimens(this.fVE.getContext(), R.dimen.tbds126);
            ((RelativeLayout.LayoutParams) this.fVH.getLayoutParams()).setMargins(l.getDimens(this.fVE.getContext(), R.dimen.tbds15), 0, 0, 0);
        }
    }

    public void a(NewPagerSlidingTabBaseStrip.a aVar) {
        if (this.fVH != null && aVar != null) {
            this.fVH.setOnTabItemClickListener(aVar);
        }
    }

    public void rO(int i) {
        if (i <= 2 && i >= 1) {
            this.fVR = i;
            this.dkv.setCurrentItem(i - 1, true);
        }
    }

    public int byA() {
        return this.fVR;
    }

    public boolean rP(int i) {
        return this.fVH != null && this.fVI.byy() == i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        rQ(this.dkv.getCurrentItem());
        if (this.eli != null) {
            this.eli.onChangeSkinType(getPageContext(), i);
        }
        if (this.fVJ != null && this.fVJ.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.fVJ.size()) {
                    break;
                }
                EnterForumTabPagerAdapter.a aVar = this.fVJ.get(i3);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            }
        }
        am.setBackgroundResource(this.fVO, R.drawable.personalize_tab_shadow);
        this.fVH.onChangeSkinType();
        this.fVG.onChangeSkinType();
    }

    public void byB() {
        rQ(this.dkv.getCurrentItem());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, float f, int i2) {
        if (this.fVN != null) {
            if (i == 0) {
                if (i2 == 0) {
                    rQ(i);
                } else if (this.fTp != null && this.fTp.fTT && this.fTp.fTV > 0) {
                    if (this.fVQ != null && this.fVQ.getRefreshView() != null && this.fVQ.getRefreshView().isViewAttached()) {
                        am.setBackgroundColor(this.fVN.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
                        return;
                    }
                    this.fVN.setBackgroundColor(0);
                    am.a(this.fVN.getBarBgView(), (int) R.color.cp_bg_line_h, f, TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (i2 == 0) {
                rQ(i);
            } else if (this.fTp != null && this.fTp.fTT && this.fTp.fTV > 0) {
                if (this.fVQ != null && this.fVQ.getRefreshView() != null && this.fVQ.getRefreshView().isViewAttached()) {
                    am.setBackgroundColor(this.fVN.getBarBgView(), R.color.cp_bg_line_d, TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.fVN.setBackgroundColor(0);
                am.a(this.fVN.getBarBgView(), (int) R.color.cp_bg_line_d, 1.0f - f, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rQ(int i) {
        int i2;
        if (this.fVL != null) {
            if (i == 0) {
                if (this.fTp != null && this.fTp.fTT && this.fTp.fTV > 0) {
                    if (this.fVQ != null && this.fVQ.getRefreshView() != null && this.fVQ.getRefreshView().isViewAttached()) {
                        SvgManager.aGC().a(this.fVL, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                        am.setImageResource(this.fVM, R.drawable.icon_ba_search_black);
                    } else if (this.fTp.fTW > 0 && this.fTp.fTV > this.fTp.fTW / 2) {
                        SvgManager.aGC().a(this.fVL, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                        am.setImageResource(this.fVM, R.drawable.icon_ba_search_white);
                    } else {
                        SvgManager.aGC().a(this.fVL, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                        am.setImageResource(this.fVM, R.drawable.icon_ba_search_black);
                    }
                } else {
                    SvgManager.aGC().a(this.fVL, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    am.setImageResource(this.fVM, R.drawable.icon_ba_search_black);
                }
            } else {
                SvgManager.aGC().a(this.fVL, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                am.setImageResource(this.fVM, R.drawable.icon_ba_search_black);
            }
        }
        if (this.fVN != null) {
            this.fVN.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            if (i == 0) {
                if (this.fTp != null && this.fTp.fTT && this.fTp.fTV > 0) {
                    if (this.fVQ != null && this.fVQ.getRefreshView() != null && this.fVQ.getRefreshView().isViewAttached()) {
                        am.setBackgroundColor(this.fVN.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
                    } else {
                        if (this.fTp.fTW > 0) {
                            int i3 = (this.fTp.fTV * 255) / this.fTp.fTW;
                            if (i3 > 255) {
                                i3 = 255;
                            }
                            i2 = 255 - i3;
                        } else {
                            i2 = 0;
                        }
                        this.fVN.setBackgroundColor(0);
                        am.a(this.fVN.getBarBgView(), (int) R.color.cp_bg_line_d, i2 / 255.0f, TbadkCoreApplication.getInst().getSkinType());
                    }
                } else {
                    am.setBackgroundColor(this.fVN.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
                }
            } else {
                am.setBackgroundColor(this.fVN.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
            }
        }
        if (i == 0) {
            if (this.fTp != null && this.fTp.fTT && this.fTp.fTV > 0) {
                if (this.fTp.fTW > 0 && this.fTp.fTV > this.fTp.fTW / 2) {
                    if (this.fVQ != null && this.fVQ.getRefreshView() != null && this.fVQ.getRefreshView().isViewAttached()) {
                        this.fVH.setWhiteStyle(false);
                    } else {
                        this.fVH.setWhiteStyle(true);
                    }
                    if (this.fVE.isPrimary()) {
                    }
                } else {
                    this.fVH.setWhiteStyle(false);
                    if (this.fVE.isPrimary()) {
                    }
                }
            } else {
                this.fVH.setWhiteStyle(false);
                if (this.fVE.isPrimary()) {
                }
            }
        } else {
            this.fVH.setWhiteStyle(false);
            if (this.fVE.isPrimary()) {
            }
        }
        if (i == 0) {
            this.fVG.setAdState(this.fTp);
        } else {
            this.fVG.setAdState(null);
        }
        if (i == 0 && TbadkCoreApplication.getInst().getSkinType() != 1 && this.fVE.isPrimary() && this.fTp != null && this.fTp.fTT && i == 0) {
            if (this.fTp.fTV > this.fTp.fTW / 2) {
                if (this.fVK != null && this.fVK.fTV <= this.fTp.fTW / 2) {
                    ao.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
                }
            } else if (this.fVK != null && this.fVK.fTV >= this.fTp.fTW / 2) {
                ao.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            }
        }
    }

    public void byC() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
            ao.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
        } else if (this.dkv.getCurrentItem() == 0 && this.fVE.isPrimary()) {
            if (this.fVQ != null && this.fVQ.getRefreshView() != null && this.fVQ.getRefreshView().isViewAttached()) {
                ao.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            } else if (this.fTp != null && this.fTp.fTT) {
                if (this.fTp.fTV > this.fTp.fTW / 2 || this.fTp.fTV == 0) {
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
        if (this.fVJ != null && this.fVJ.size() > 0 && this.dkv != null) {
            EnterForumTabPagerAdapter.a aVar = this.fVJ.get(this.dkv.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void JJ() {
        if (this.fVE != null && this.fVJ != null && this.dkv != null && this.fVI != null) {
            FragmentManager supportFragmentManager = this.fVE.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.fVJ.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.dkv.getId(), this.fVI.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.eli != null) {
            this.eli.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.fVI != null) {
            this.fVI.setPrimary(z);
        }
        if (this.fVJ != null && this.fVJ.size() > 0 && this.dkv != null) {
            EnterForumTabPagerAdapter.a aVar = this.fVJ.get(this.dkv.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.fVJ != null && this.fVJ.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.fVJ.size()) {
                    break;
                }
                EnterForumTabPagerAdapter.a aVar = this.fVJ.get(i2);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof NoNetworkView.a)) {
                    ((NoNetworkView.a) aVar.fragment).onNetworkChange(z);
                }
                i = i2 + 1;
            }
        }
        rQ(this.dkv.getCurrentItem());
    }

    public void bcM() {
        if (this.fVF != null && this.fVF.getPaddingTop() < 0) {
            byD();
        } else if (this.fVO != null) {
            this.fVO.clearAnimation();
            if (this.fVO.getVisibility() != 0) {
                this.fVO.setVisibility(0);
                if (this.eny == null) {
                    this.eny = new AlphaAnimation(0.0f, 1.0f);
                    this.eny.setFillAfter(true);
                    this.eny.setDuration(300L);
                }
                this.fVO.startAnimation(this.eny);
            }
        }
    }

    public void bcN() {
        if (this.fVO != null && this.fVO.getVisibility() != 8) {
            if (this.enz == null) {
                this.enz = new AlphaAnimation(1.0f, 0.0f);
                this.enz.setFillAfter(true);
                this.enz.setDuration(300L);
                this.enz.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.enterForum.home.c.5
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.fVO.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.fVO.startAnimation(this.enz);
        }
    }

    private void byD() {
        if (this.fVO != null && this.fVO.getVisibility() != 8) {
            this.fVO.clearAnimation();
            this.fVO.setVisibility(8);
        }
    }

    public void a(a aVar) {
        if (this.fVP == null) {
            this.fVP = new ArrayList();
        }
        this.fVP.add(aVar);
    }

    public void b(a aVar) {
        if (this.fVP != null && this.fVP.size() > 0) {
            this.fVP.remove(aVar);
        }
    }

    public void a(com.baidu.tieba.enterForum.view.b bVar) {
        this.fVQ = bVar;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.b bVar) {
        this.fVK = this.fTp;
        this.fTp = bVar;
        this.fVG.setAdState(bVar);
        rQ(this.dkv.getCurrentItem());
    }

    public void setSearchHint(String str) {
        this.fVG.setSearchHint(str);
    }

    public View getRootView() {
        return getPageContext().getPageActivity().getWindow().getDecorView();
    }

    public View byE() {
        return this.fVF;
    }

    /* loaded from: classes9.dex */
    public static abstract class a {
        public void byF() {
        }

        public void byG() {
        }
    }

    public String getCurrentPageKey() {
        if (this.fVI != null) {
            return this.fVI.getCurrentPageKey();
        }
        return null;
    }

    public void e(View view, int i, int i2, int i3, int i4) {
    }

    private void rR(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fVO.getLayoutParams();
        layoutParams.topMargin = this.fVS + i;
        this.fVO.setLayoutParams(layoutParams);
    }
}
