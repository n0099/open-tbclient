package com.baidu.tieba.enterForum.home;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
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
/* loaded from: classes7.dex */
public class c extends com.baidu.adp.base.c implements NoNetworkView.a {
    private BdBaseViewPager dgo;
    private NoNetworkView ehd;
    private AlphaAnimation ejn;
    private AlphaAnimation ejo;
    private com.baidu.tieba.enterForum.data.b fQS;
    private EnterForumTabFragment fTj;
    private LinearLayout fTk;
    private ForumHeaderView fTl;
    private NewPagerSlidingTabBaseStrip fTm;
    private EnterForumTabPagerAdapter fTn;
    private List<EnterForumTabPagerAdapter.a> fTo;
    private com.baidu.tieba.enterForum.data.b fTp;
    private ImageView fTq;
    private ImageView fTr;
    private NavigationBar fTs;
    private View fTt;
    private List<a> fTu;
    private com.baidu.tieba.enterForum.view.b fTv;
    private int fTw;
    private int fTx;
    private Drawable fTy;
    private com.baidu.adp.framework.listener.a fTz;
    private int mNavHeight;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private View mRootView;
    private int mSkinType;

    public c(EnterForumTabFragment enterForumTabFragment) {
        super(enterForumTabFragment.getPageContext());
        this.fTw = -1;
        this.mSkinType = 3;
        this.fTz = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.enterForum.home.c.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String str = "";
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage = (forumRecommendSocketResponseMessage) responsedMessage;
                    if (forumrecommendsocketresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendsocketresponsemessage.getHotSearchInfoData().bwj();
                    }
                } else if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage = (forumRecommendHttpResponseMessage) responsedMessage;
                    if (forumrecommendhttpresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendhttpresponsemessage.getHotSearchInfoData().bwj();
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
                c.this.rJ(i);
                if (c.this.fTo != null && c.this.fTo.size() > i) {
                    if (c.this.fTv != null) {
                        c.this.fTv.bxY();
                    }
                    EnterForumTabPagerAdapter.a aVar = (EnterForumTabPagerAdapter.a) c.this.fTo.get(i);
                    if (aVar != null && aVar.fragment != null) {
                        if (aVar.fragment instanceof RecommendFragment) {
                            if (c.this.fTu != null) {
                                for (a aVar2 : c.this.fTu) {
                                    aVar2.bwZ();
                                }
                            }
                        } else if ((aVar.fragment instanceof EnterForumFragment) && c.this.fTu != null) {
                            for (a aVar3 : c.this.fTu) {
                                aVar3.bwY();
                            }
                        }
                        if (i == 0) {
                            c.this.fTw = 1;
                            TiebaStatic.log(new an("c13366").Z("obj_locate", 1));
                        } else if (i == 1) {
                            c.this.fTw = 2;
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
        this.fTj = enterForumTabFragment;
        this.fTj.registerListener(this.fTz);
        this.mNavHeight = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds240);
        this.fTx = UtilHelper.getStatusBarHeight() + l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds240);
    }

    private void bwS() {
        forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
        forumrecommendrequestmessage.set_like_forum(Integer.valueOf(TbadkCoreApplication.isLogin() ? 1 : 0));
        forumrecommendrequestmessage.set_topic(0);
        forumrecommendrequestmessage.set_recommend(1);
        this.fTj.sendMessage(forumrecommendrequestmessage);
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            ae(bundle);
            af(bundle);
            ag(bundle);
            this.ehd = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.ehd.a(this);
            if (!TbadkCoreApplication.getInst().checkInterrupt()) {
                bwS();
            }
            if (TbSingleton.getInstance().isShowNewYearSkin()) {
                this.fTm.setDefaultSelectorColorResourceId(R.color.cp_other_f);
                this.fTm.setNormalSelectorColorResId(R.color.cp_cont_a);
                this.fTm.setRectPaintColor(R.color.cp_other_f);
                this.fTs.setNavHeight(this.mNavHeight + l.getDimens(this.mContext.getContext(), R.dimen.tbds21));
                ((RelativeLayout.LayoutParams) this.ehd.getLayoutParams()).topMargin = l.getDimens(this.mContext.getContext(), R.dimen.tbds_20);
            }
        }
    }

    private void ae(Bundle bundle) {
        this.dgo = (BdBaseViewPager) this.mRootView.findViewById(R.id.enter_forum_viewpager);
        EnterForumTabPagerAdapter.a aVar = new EnterForumTabPagerAdapter.a();
        aVar.fragment = new EnterForumFragment();
        aVar.title = this.fTj.getResources().getString(R.string.attention);
        ((EnterForumFragment) aVar.fragment).setTabViewController(this);
        EnterForumTabPagerAdapter.a aVar2 = new EnterForumTabPagerAdapter.a();
        aVar2.fragment = new RecommendFragment();
        aVar2.title = this.fTj.getResources().getString(R.string.default_personalized_name);
        ((RecommendFragment) aVar2.fragment).setTabViewController(this);
        this.fTo = new ArrayList();
        this.fTo.add(aVar);
        this.fTo.add(aVar2);
        this.fTn = new EnterForumTabPagerAdapter(this.fTj.getActivity().getSupportFragmentManager(), this.fTo);
        this.dgo.setAdapter(this.fTn);
        this.dgo.setOffscreenPageLimit(this.fTo.size());
    }

    public void Qa() {
    }

    private void af(Bundle bundle) {
        this.fTk = (LinearLayout) LayoutInflater.from(this.fTj.getContext()).inflate(R.layout.enter_forum_tab_layout, (ViewGroup) null);
        this.fTl = (ForumHeaderView) this.fTk.findViewById(R.id.recommend_forum_header_serch_view);
        this.fTl.onChangeSkinType();
        this.fTm = (NewPagerSlidingTabBaseStrip) this.fTk.findViewById(R.id.tab_layout);
        this.fTm.setDefaultSelectorColorResourceId(R.color.cp_cont_b);
        this.fTm.setRectPaintColor(R.color.cp_link_tip_a);
        this.fTm.a(l.getDimens(this.fTj.getContext(), R.dimen.tbds46), l.getDimens(this.fTj.getContext(), R.dimen.tbds46), l.getDimens(this.fTj.getContext(), R.dimen.tbds10), l.getDimens(this.fTj.getContext(), R.dimen.tbds46), true);
        this.fTm.setIndicatorOffset(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds64));
        this.fTm.setIndicatorOvershot(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds8));
        this.fTm.setIndicatorRadius(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds8));
        this.fTm.setIndicatorMarginBottom(l.getDimens(this.fTj.getContext(), R.dimen.tbds0));
        this.fTm.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds170), -1));
        this.fTm.setViewPager(this.dgo);
        this.fTm.setOnPageChangeListener(this.mOnPageChangeListener);
    }

    private void ag(Bundle bundle) {
        this.fTs = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.fTs.setNavHeight(this.mNavHeight);
        this.fTs.hideBottomLine();
        this.fTt = this.mRootView.findViewById(R.id.divider_shadow);
        rK(0);
        this.fTq = (ImageView) this.fTk.findViewById(R.id.navigationBarGoSignall);
        this.fTq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.CheckFile("scan_flag") && ab.checkCamera(c.this.mContext.getPageActivity())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new QRCodeScanActivityConfig(c.this.mContext.getPageActivity())));
                } else if (!TbadkCoreApplication.isLogin()) {
                    bc.skipToLoginActivity(c.this.getPageContext().getPageActivity());
                } else {
                    c.this.fTj.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(c.this.getPageContext().getPageActivity())));
                }
            }
        });
        this.fTr = (ImageView) this.fTk.findViewById(R.id.navigationBarGoSearch);
        this.fTr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.fTl.onClick(view);
            }
        });
        if (this.fTm != null) {
            this.fTs.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, this.fTk, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.fTk.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(3);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(3);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 3;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.fTm.setPadding(this.fTm.getPaddingLeft(), this.fTm.getPaddingTop(), this.fTm.getPaddingRight(), this.fTm.getBottom());
            this.fTm.getLayoutParams().height = l.getDimens(this.fTj.getContext(), R.dimen.tbds126);
            ((RelativeLayout.LayoutParams) this.fTm.getLayoutParams()).setMargins(l.getDimens(this.fTj.getContext(), R.dimen.tbds15), 0, 0, 0);
        }
    }

    public void a(NewPagerSlidingTabBaseStrip.a aVar) {
        if (this.fTm != null && aVar != null) {
            this.fTm.setOnTabItemClickListener(aVar);
        }
    }

    public void rH(int i) {
        if (i <= 2 && i >= 1) {
            this.fTw = i;
            this.dgo.setCurrentItem(i - 1, true);
        }
    }

    public int bwT() {
        return this.fTw;
    }

    public boolean rI(int i) {
        return this.fTm != null && this.fTn.bwR() == i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (this.fTy == null || this.mSkinType != i) {
            this.mSkinType = i;
            this.fTy = am.getDrawable(R.drawable.backguard_mask_topbar_newyear);
            if (i == 1) {
                int color = am.getColor(R.color.cp_mask_a);
                this.fTy.mutate();
                this.fTy.setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
            } else if (i == 4) {
                int color2 = am.getColor(R.color.cp_mask_a);
                this.fTy.mutate();
                this.fTy.setColorFilter(color2, PorterDuff.Mode.SRC_ATOP);
            }
        }
        rJ(this.dgo.getCurrentItem());
        if (this.ehd != null) {
            this.ehd.onChangeSkinType(getPageContext(), i);
        }
        if (this.fTo != null && this.fTo.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.fTo.size()) {
                    break;
                }
                EnterForumTabPagerAdapter.a aVar = this.fTo.get(i3);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            }
        }
        am.setBackgroundResource(this.fTt, R.drawable.personalize_tab_shadow);
        this.fTm.onChangeSkinType();
        this.fTl.onChangeSkinType();
    }

    public void bwU() {
        rJ(this.dgo.getCurrentItem());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, float f, int i2) {
        if (this.fTs != null) {
            if (i == 0) {
                if (i2 == 0) {
                    rJ(i);
                } else if (this.fQS != null && this.fQS.fRw && this.fQS.fRy > 0) {
                    if (this.fTv != null && this.fTv.getRefreshView() != null && this.fTv.getRefreshView().isViewAttached()) {
                        am.setBackgroundColor(this.fTs.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
                        return;
                    }
                    this.fTs.setBackgroundColor(0);
                    am.a(this.fTs.getBarBgView(), (int) R.color.cp_bg_line_h, f, TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (i2 == 0) {
                rJ(i);
            } else if (this.fQS != null && this.fQS.fRw && this.fQS.fRy > 0) {
                if (this.fTv != null && this.fTv.getRefreshView() != null && this.fTv.getRefreshView().isViewAttached()) {
                    am.setBackgroundColor(this.fTs.getBarBgView(), R.color.cp_bg_line_d, TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.fTs.setBackgroundColor(0);
                am.a(this.fTs.getBarBgView(), (int) R.color.cp_bg_line_d, 1.0f - f, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rJ(int i) {
        int i2;
        if (this.fTq != null) {
            if (TbSingleton.getInstance().isShowNewYearSkin()) {
                SvgManager.aEp().a(this.fTq, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                am.setImageResource(this.fTr, R.drawable.icon_ba_search_black);
            } else if (i == 0) {
                if (this.fQS != null && this.fQS.fRw && this.fQS.fRy > 0) {
                    if (this.fTv != null && this.fTv.getRefreshView() != null && this.fTv.getRefreshView().isViewAttached()) {
                        SvgManager.aEp().a(this.fTq, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                        am.setImageResource(this.fTr, R.drawable.icon_ba_search_black);
                    } else if (this.fQS.fRz > 0 && this.fQS.fRy > this.fQS.fRz / 2) {
                        SvgManager.aEp().a(this.fTq, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                        am.setImageResource(this.fTr, R.drawable.icon_ba_search_white);
                    } else {
                        SvgManager.aEp().a(this.fTq, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                        am.setImageResource(this.fTr, R.drawable.icon_ba_search_black);
                    }
                } else {
                    SvgManager.aEp().a(this.fTq, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    am.setImageResource(this.fTr, R.drawable.icon_ba_search_black);
                }
            } else {
                SvgManager.aEp().a(this.fTq, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                am.setImageResource(this.fTr, R.drawable.icon_ba_search_black);
            }
        }
        if (this.fTs != null) {
            this.fTs.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            if (TbSingleton.getInstance().isShowNewYearSkin() && this.fTy != null) {
                this.fTs.setSpecialBackground(this.fTy, R.color.cp_cont_h);
                this.fTs.getBarBgView().setBackgroundDrawable(null);
                this.fTs.setBackgroundColor(0);
            } else if (i == 0) {
                if (this.fQS != null && this.fQS.fRw && this.fQS.fRy > 0) {
                    if (this.fTv != null && this.fTv.getRefreshView() != null && this.fTv.getRefreshView().isViewAttached()) {
                        am.setBackgroundColor(this.fTs.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
                    } else {
                        if (this.fQS.fRz > 0) {
                            int i3 = (this.fQS.fRy * 255) / this.fQS.fRz;
                            if (i3 > 255) {
                                i3 = 255;
                            }
                            i2 = 255 - i3;
                        } else {
                            i2 = 0;
                        }
                        this.fTs.setBackgroundColor(0);
                        am.a(this.fTs.getBarBgView(), (int) R.color.cp_bg_line_d, i2 / 255.0f, TbadkCoreApplication.getInst().getSkinType());
                    }
                } else {
                    am.setBackgroundColor(this.fTs.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
                }
            } else {
                am.setBackgroundColor(this.fTs.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
            }
        }
        if (!TbSingleton.getInstance().isShowNewYearSkin()) {
            if (i == 0) {
                if (this.fQS != null && this.fQS.fRw && this.fQS.fRy > 0) {
                    if (this.fQS.fRz > 0 && this.fQS.fRy > this.fQS.fRz / 2) {
                        if (this.fTv != null && this.fTv.getRefreshView() != null && this.fTv.getRefreshView().isViewAttached()) {
                            this.fTm.setWhiteStyle(false);
                        } else {
                            this.fTm.setWhiteStyle(true);
                        }
                        if (this.fTj.isPrimary()) {
                        }
                    } else {
                        this.fTm.setWhiteStyle(false);
                        if (this.fTj.isPrimary()) {
                        }
                    }
                } else {
                    this.fTm.setWhiteStyle(false);
                    if (this.fTj.isPrimary()) {
                    }
                }
            } else {
                this.fTm.setWhiteStyle(false);
                if (this.fTj.isPrimary()) {
                }
            }
            if (i == 0) {
                this.fTl.setAdState(this.fQS);
            } else {
                this.fTl.setAdState(null);
            }
        }
        if (i == 0 && TbadkCoreApplication.getInst().getSkinType() != 1 && this.fTj.isPrimary() && this.fQS != null && this.fQS.fRw && i == 0) {
            if (this.fQS.fRy > this.fQS.fRz / 2) {
                if (this.fTp != null && this.fTp.fRy <= this.fQS.fRz / 2) {
                    ao.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
                }
            } else if (this.fTp != null && this.fTp.fRy >= this.fQS.fRz / 2) {
                ao.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            }
        }
    }

    public void bwV() {
        if (TbSingleton.getInstance().isShowNewYearSkin()) {
            if (this.fTj != null && UtilHelper.canUseStyleImmersiveSticky() && this.fTj.isPrimary()) {
                UtilHelper.changeStatusBarIconAndTextColor(true, this.fTj.getFragmentActivity());
            }
        } else if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
            ao.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
        } else if (this.dgo.getCurrentItem() == 0 && this.fTj.isPrimary()) {
            if (this.fTv != null && this.fTv.getRefreshView() != null && this.fTv.getRefreshView().isViewAttached()) {
                ao.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            } else if (this.fQS != null && this.fQS.fRw) {
                if (this.fQS.fRy > this.fQS.fRz / 2 || this.fQS.fRy == 0) {
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
        if (this.fTo != null && this.fTo.size() > 0 && this.dgo != null) {
            EnterForumTabPagerAdapter.a aVar = this.fTo.get(this.dgo.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void Hs() {
        if (this.fTj != null && this.fTo != null && this.dgo != null && this.fTn != null) {
            FragmentManager supportFragmentManager = this.fTj.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.fTo.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.dgo.getId(), this.fTn.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.ehd != null) {
            this.ehd.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.fTn != null) {
            this.fTn.setPrimary(z);
        }
        if (this.fTo != null && this.fTo.size() > 0 && this.dgo != null) {
            EnterForumTabPagerAdapter.a aVar = this.fTo.get(this.dgo.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.fTo != null && this.fTo.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.fTo.size()) {
                    break;
                }
                EnterForumTabPagerAdapter.a aVar = this.fTo.get(i2);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof NoNetworkView.a)) {
                    ((NoNetworkView.a) aVar.fragment).onNetworkChange(z);
                }
                i = i2 + 1;
            }
        }
        rJ(this.dgo.getCurrentItem());
    }

    public void bav() {
        if (this.fTk != null && this.fTk.getPaddingTop() < 0) {
            bwW();
        } else if (this.fTt != null) {
            this.fTt.clearAnimation();
            if (this.fTt.getVisibility() != 0) {
                this.fTt.setVisibility(0);
                if (this.ejn == null) {
                    this.ejn = new AlphaAnimation(0.0f, 1.0f);
                    this.ejn.setFillAfter(true);
                    this.ejn.setDuration(300L);
                }
                this.fTt.startAnimation(this.ejn);
            }
        }
    }

    public void baw() {
        if (this.fTt != null && this.fTt.getVisibility() != 8) {
            if (this.ejo == null) {
                this.ejo = new AlphaAnimation(1.0f, 0.0f);
                this.ejo.setFillAfter(true);
                this.ejo.setDuration(300L);
                this.ejo.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.enterForum.home.c.5
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.fTt.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.fTt.startAnimation(this.ejo);
        }
    }

    private void bwW() {
        if (this.fTt != null && this.fTt.getVisibility() != 8) {
            this.fTt.clearAnimation();
            this.fTt.setVisibility(8);
        }
    }

    public void a(a aVar) {
        if (this.fTu == null) {
            this.fTu = new ArrayList();
        }
        this.fTu.add(aVar);
    }

    public void b(a aVar) {
        if (this.fTu != null && this.fTu.size() > 0) {
            this.fTu.remove(aVar);
        }
    }

    public void a(com.baidu.tieba.enterForum.view.b bVar) {
        this.fTv = bVar;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.b bVar) {
        this.fTp = this.fQS;
        this.fQS = bVar;
        this.fTl.setAdState(bVar);
        rJ(this.dgo.getCurrentItem());
    }

    public void setSearchHint(String str) {
        this.fTl.setSearchHint(str);
    }

    public View getRootView() {
        return getPageContext().getPageActivity().getWindow().getDecorView();
    }

    public View bwX() {
        return this.fTk;
    }

    /* loaded from: classes7.dex */
    public static abstract class a {
        public void bwY() {
        }

        public void bwZ() {
        }
    }

    public String getCurrentPageKey() {
        if (this.fTn != null) {
            return this.fTn.getCurrentPageKey();
        }
        return null;
    }

    public void e(View view, int i, int i2, int i3, int i4) {
    }

    private void rK(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fTt.getLayoutParams();
        layoutParams.topMargin = this.fTx + i;
        this.fTt.setLayoutParams(layoutParams);
    }
}
