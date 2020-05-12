package com.baidu.tieba.enterForum.home;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
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
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
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
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip;
import com.baidu.tieba.R;
import com.baidu.tieba.card.r;
import com.baidu.tieba.enterForum.data.o;
import com.baidu.tieba.enterForum.data.p;
import com.baidu.tieba.enterForum.home.EnterForumTabPagerAdapter;
import com.baidu.tieba.enterForum.tabfeed.EnterForumTabFeedFragment;
import com.baidu.tieba.enterForum.view.ForumHeaderView;
import com.baidu.tieba.enterForum.view.PullLeftViewPager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes9.dex */
public class c extends com.baidu.adp.base.c implements NoNetworkView.a {
    private NoNetworkView ePq;
    private AlphaAnimation eRF;
    private AlphaAnimation eRG;
    private LinearLayout gBA;
    private ForumHeaderView gBB;
    private NewPagerSlidingTabBaseStrip gBC;
    private PullLeftViewPager gBD;
    private EnterForumTabPagerAdapter gBE;
    private List<EnterForumTabPagerAdapter.a> gBF;
    private com.baidu.tieba.enterForum.data.d gBG;
    private ImageView gBH;
    private View gBI;
    private View gBJ;
    private NavigationBar gBK;
    private View gBL;
    private com.baidu.tieba.enterForum.view.b gBM;
    private int gBN;
    private String gBO;
    private p gBP;
    private boolean gBQ;
    private com.baidu.adp.framework.listener.a gBR;
    private CustomMessageListener gBS;
    private EnterForumTabFragment gBz;
    private com.baidu.tieba.enterForum.data.d gyZ;
    private int mNavHeight;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private View mRootView;

    public c(EnterForumTabFragment enterForumTabFragment) {
        super(enterForumTabFragment.getPageContext());
        this.gBQ = false;
        this.gBR = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.enterForum.home.c.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String str = "";
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage = (forumRecommendSocketResponseMessage) responsedMessage;
                    if (forumrecommendsocketresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendsocketresponsemessage.getHotSearchInfoData().bHH();
                    }
                } else if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage = (forumRecommendHttpResponseMessage) responsedMessage;
                    if (forumrecommendhttpresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendhttpresponsemessage.getHotSearchInfoData().bHH();
                    }
                }
                if (TextUtils.isEmpty(str)) {
                    str = c.this.mContext.getResources().getString(R.string.enter_forum_search_tip);
                }
                TbSingleton.getInstance().setHotSearch(str);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921396));
            }
        };
        this.gBS = new CustomMessageListener(2001630) { // from class: com.baidu.tieba.enterForum.home.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        c.this.blG();
                    } else {
                        c.this.blH();
                    }
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.enterForum.home.c.3
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                c.this.a(i, f, i2);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                boolean z;
                c.this.si(i);
                if (c.this.gBF != null && c.this.gBF.size() > i) {
                    if (c.this.gBM != null) {
                        c.this.gBM.bJY();
                    }
                    EnterForumTabPagerAdapter.a aVar = (EnterForumTabPagerAdapter.a) c.this.gBF.get(i);
                    if (aVar != null && aVar.fragment != null) {
                        if (aVar.fragment instanceof EnterForumFragment) {
                            z = ((EnterForumFragment) aVar.fragment).bIt();
                        } else if (aVar.fragment instanceof EnterForumTabFeedFragment) {
                            r.bEX().lx(false);
                            boolean bIt = ((EnterForumTabFeedFragment) aVar.fragment).bIt();
                            TiebaStatic.log(new an("c13366").af("obj_locate", 3).cI("resource_id", ((EnterForumTabFeedFragment) aVar.fragment).getTabName()));
                            z = bIt;
                        } else {
                            z = true;
                        }
                        if (!z) {
                            c.this.blG();
                        } else {
                            c.this.blH();
                        }
                        if (i == 0) {
                            TiebaStatic.log(new an("c13366").af("obj_locate", 1));
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
        this.gBz = enterForumTabFragment;
        this.gBz.registerListener(this.gBR);
        this.gBz.registerListener(this.gBS);
        this.mNavHeight = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds228);
        this.gBN = UtilHelper.getStatusBarHeight() + l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds229);
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            ae(bundle);
            af(bundle);
            ag(bundle);
            this.ePq = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.ePq.a(this);
        }
    }

    private void ae(Bundle bundle) {
        this.gBD = (PullLeftViewPager) this.mRootView.findViewById(R.id.enter_forum_viewpager);
        EnterForumTabPagerAdapter.a aVar = new EnterForumTabPagerAdapter.a();
        aVar.fragment = new EnterForumFragment();
        aVar.title = this.gBz.getResources().getString(R.string.my_forum);
        ((EnterForumFragment) aVar.fragment).setTabViewController(this);
        this.gBF = new ArrayList();
        this.gBF.add(aVar);
        this.gBE = new EnterForumTabPagerAdapter(this.gBz.getActivity().getSupportFragmentManager(), this.gBF);
        this.gBD.setAdapter(this.gBE);
        this.gBD.setOffscreenPageLimit(this.gBF.size());
    }

    public void aah() {
    }

    private void af(Bundle bundle) {
        this.gBA = (LinearLayout) LayoutInflater.from(this.gBz.getContext()).inflate(R.layout.enter_forum_tab_layout, (ViewGroup) null);
        this.gBB = (ForumHeaderView) this.gBA.findViewById(R.id.recommend_forum_header_serch_view);
        this.gBB.setFrom(0);
        this.gBB.onChangeSkinType();
        this.gBC = (NewPagerSlidingTabBaseStrip) this.gBA.findViewById(R.id.tab_layout);
        this.gBC.setDefaultSelectorColorResourceId(R.color.cp_cont_b);
        this.gBC.setRectPaintColor(R.color.cp_link_tip_a);
        this.gBC.a(l.getDimens(this.gBz.getContext(), R.dimen.tbds46), l.getDimens(this.gBz.getContext(), R.dimen.tbds46), l.getDimens(this.gBz.getContext(), R.dimen.tbds10), l.getDimens(this.gBz.getContext(), R.dimen.tbds46), true);
        this.gBC.setmIndicatorWidth(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds42));
        this.gBC.setIndicatorOvershot(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds8));
        this.gBC.setIndicatorRadius(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds8));
        this.gBC.setIndicatorMarginBottom(l.getDimens(this.gBz.getContext(), R.dimen.tbds0));
        this.gBC.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        this.gBC.setTabPadding(l.getDimens(this.gBz.getContext(), R.dimen.tbds36), 0, l.getDimens(this.gBz.getContext(), R.dimen.tbds36), 0);
        this.gBC.setViewPager(this.gBD);
        this.gBC.setOnPageChangeListener(this.mOnPageChangeListener);
        this.gBJ = this.gBA.findViewById(R.id.enter_forum_tab_left_grandient);
        this.gBI = this.gBA.findViewById(R.id.enter_forum_tab_right_grandient);
    }

    private void ag(Bundle bundle) {
        this.gBK = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.gBK.setNavHeight(this.mNavHeight);
        this.gBK.hideBottomLine();
        this.gBL = this.mRootView.findViewById(R.id.divider_shadow);
        sj(0);
        this.gBH = (ImageView) this.gBA.findViewById(R.id.navigationBarGoSignall);
        this.gBH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.CheckFile("scan_flag") && ab.checkCamera(c.this.mContext.getPageActivity())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new QRCodeScanActivityConfig(c.this.mContext.getPageActivity())));
                } else if (!TbadkCoreApplication.isLogin()) {
                    bc.skipToLoginActivity(c.this.getPageContext().getPageActivity());
                } else {
                    c.this.gBz.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(c.this.getPageContext().getPageActivity())));
                }
            }
        });
        if (this.gBC != null) {
            this.gBK.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, this.gBA, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.gBA.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(3);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(3);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 3;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.gBC.setPadding(this.gBC.getPaddingLeft(), this.gBC.getPaddingTop(), this.gBC.getPaddingRight(), this.gBC.getBottom());
        }
    }

    public void a(NewPagerSlidingTabBaseStrip.a aVar) {
        if (this.gBC != null && aVar != null) {
            this.gBC.setOnTabItemClickListener(aVar);
        }
    }

    public boolean sh(int i) {
        if (i < 0 || i > this.gBF.size()) {
            return false;
        }
        this.gBD.setCurrentItem(i, true);
        return true;
    }

    public void Ca(String str) {
        this.gBO = str;
    }

    public int Cb(String str) {
        if (StringUtils.isNull(str) || this.gBF == null || this.gBF.size() <= 0) {
            return -1;
        }
        int i = -1;
        for (int i2 = 0; i2 < this.gBF.size(); i2++) {
            if (str.equals(this.gBF.get(i2).tabName)) {
                i = i2;
            }
        }
        if (i == -1 && this.gBz.getResources().getString(R.string.my_forum).equals(str)) {
            return 0;
        }
        return i;
    }

    public boolean bIC() {
        return this.gBQ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        si(this.gBD.getCurrentItem());
        if (this.ePq != null) {
            this.ePq.onChangeSkinType(getPageContext(), i);
        }
        if (this.gBF != null && this.gBF.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.gBF.size()) {
                    break;
                }
                EnterForumTabPagerAdapter.a aVar = this.gBF.get(i3);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            }
        }
        am.setBackgroundResource(this.gBL, R.drawable.personalize_tab_shadow);
        this.gBC.onChangeSkinType();
        this.gBB.onChangeSkinType();
        am.a(this.gBJ, R.color.cp_bg_line_h, GradientDrawable.Orientation.LEFT_RIGHT);
        am.a(this.gBI, R.color.cp_bg_line_h, GradientDrawable.Orientation.RIGHT_LEFT);
    }

    public void bID() {
        si(this.gBD.getCurrentItem());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, float f, int i2) {
        if (this.gBK != null) {
            if (i == 0) {
                if (i2 == 0) {
                    si(i);
                } else if (this.gyZ != null && this.gyZ.gzK && this.gyZ.gzM > 0) {
                    if (this.gBM != null && this.gBM.getRefreshView() != null && this.gBM.getRefreshView().isViewAttached()) {
                        am.setBackgroundColor(this.gBK.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
                        return;
                    }
                    this.gBK.setBackgroundColor(0);
                    am.a(this.gBK.getBarBgView(), (int) R.color.cp_bg_line_h, f, TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (i2 == 0) {
                si(i);
            } else if (this.gyZ != null && this.gyZ.gzK && this.gyZ.gzM > 0) {
                if (this.gBM != null && this.gBM.getRefreshView() != null && this.gBM.getRefreshView().isViewAttached()) {
                    am.setBackgroundColor(this.gBK.getBarBgView(), R.color.cp_bg_line_d, TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.gBK.setBackgroundColor(0);
                am.a(this.gBK.getBarBgView(), (int) R.color.cp_bg_line_d, 1.0f - f, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void si(int i) {
        int i2;
        if (this.gBH != null) {
            if (i == 0) {
                if (this.gyZ != null && this.gyZ.gzK && this.gyZ.gzM > 0) {
                    if (this.gBM != null && this.gBM.getRefreshView() != null && this.gBM.getRefreshView().isViewAttached()) {
                        SvgManager.aOR().a(this.gBH, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    } else if (this.gyZ.gzN > 0 && this.gyZ.gzM > this.gyZ.gzN / 2) {
                        SvgManager.aOR().a(this.gBH, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    } else {
                        SvgManager.aOR().a(this.gBH, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    }
                } else {
                    SvgManager.aOR().a(this.gBH, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
            } else {
                SvgManager.aOR().a(this.gBH, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
        if (this.gBK != null) {
            this.gBK.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            if (i == 0) {
                if (this.gyZ != null && this.gyZ.gzK && this.gyZ.gzM > 0) {
                    if (this.gBM != null && this.gBM.getRefreshView() != null && this.gBM.getRefreshView().isViewAttached()) {
                        am.setBackgroundColor(this.gBK.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
                    } else {
                        if (this.gyZ.gzN > 0) {
                            int i3 = (this.gyZ.gzM * 255) / this.gyZ.gzN;
                            if (i3 > 255) {
                                i3 = 255;
                            }
                            i2 = 255 - i3;
                        } else {
                            i2 = 0;
                        }
                        this.gBK.setBackgroundColor(0);
                        am.a(this.gBK.getBarBgView(), (int) R.color.cp_bg_line_d, i2 / 255.0f, TbadkCoreApplication.getInst().getSkinType());
                    }
                } else {
                    am.setBackgroundColor(this.gBK.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
                }
            } else {
                am.setBackgroundColor(this.gBK.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
            }
        }
        if (i == 0) {
            if (this.gyZ != null && this.gyZ.gzK && this.gyZ.gzM > 0) {
                if (this.gyZ.gzN > 0 && this.gyZ.gzM > this.gyZ.gzN / 2) {
                    if (this.gBM != null && this.gBM.getRefreshView() != null && this.gBM.getRefreshView().isViewAttached()) {
                        this.gBC.setWhiteStyle(false);
                    } else {
                        this.gBC.setWhiteStyle(true);
                    }
                } else {
                    this.gBC.setWhiteStyle(false);
                }
            } else {
                this.gBC.setWhiteStyle(false);
            }
        } else {
            this.gBC.setWhiteStyle(false);
        }
        if (i == 0) {
            this.gBB.setAdState(this.gyZ);
        } else {
            this.gBB.setAdState(null);
        }
        if (i == 0 && TbadkCoreApplication.getInst().getSkinType() != 1 && this.gBz.isPrimary() && this.gyZ != null && this.gyZ.gzK && i == 0) {
            if (this.gyZ.gzM > this.gyZ.gzN / 2) {
                if (this.gBG != null && this.gBG.gzM <= this.gyZ.gzN / 2) {
                    ao.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
                }
            } else if (this.gBG != null && this.gBG.gzM >= this.gyZ.gzN / 2) {
                ao.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            }
        }
    }

    public void bIE() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
            ao.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
        } else if (this.gBD.getCurrentItem() == 0 && this.gBz.isPrimary()) {
            if (this.gBM != null && this.gBM.getRefreshView() != null && this.gBM.getRefreshView().isViewAttached()) {
                ao.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            } else if (this.gyZ != null && this.gyZ.gzK) {
                if (this.gyZ.gzM > this.gyZ.gzN / 2 || this.gyZ.gzM == 0) {
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
        if (this.gBF != null && this.gBF.size() > 0 && this.gBD != null) {
            EnterForumTabPagerAdapter.a aVar = this.gBF.get(this.gBD.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void Rx() {
        if (this.gBz != null && this.gBF != null && this.gBD != null && this.gBE != null) {
            FragmentManager supportFragmentManager = this.gBz.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.gBF.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.gBD.getId(), this.gBE.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.ePq != null) {
            this.ePq.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.gBE != null) {
            this.gBE.setPrimary(z);
        }
        if (this.gBF != null && this.gBF.size() > 0 && this.gBD != null) {
            EnterForumTabPagerAdapter.a aVar = this.gBF.get(this.gBD.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.gBF != null && this.gBF.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.gBF.size()) {
                    break;
                }
                EnterForumTabPagerAdapter.a aVar = this.gBF.get(i2);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof NoNetworkView.a)) {
                    ((NoNetworkView.a) aVar.fragment).onNetworkChange(z);
                }
                i = i2 + 1;
            }
        }
        si(this.gBD.getCurrentItem());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blG() {
        if (this.gBA != null && this.gBA.getPaddingTop() < 0) {
            bIF();
        } else if (this.gBL != null) {
            this.gBL.clearAnimation();
            if (this.gBL.getVisibility() != 0) {
                this.gBL.setVisibility(0);
                if (this.eRF == null) {
                    this.eRF = new AlphaAnimation(0.0f, 1.0f);
                    this.eRF.setFillAfter(true);
                    this.eRF.setDuration(300L);
                }
                this.gBL.startAnimation(this.eRF);
            }
        }
    }

    public void blH() {
        if (this.gBL != null && this.gBL.getVisibility() != 8) {
            if (this.eRG == null) {
                this.eRG = new AlphaAnimation(1.0f, 0.0f);
                this.eRG.setFillAfter(true);
                this.eRG.setDuration(300L);
                this.eRG.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.enterForum.home.c.5
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.gBL.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.gBL.startAnimation(this.eRG);
        }
    }

    private void bIF() {
        if (this.gBL != null && this.gBL.getVisibility() != 8) {
            this.gBL.clearAnimation();
            this.gBL.setVisibility(8);
        }
    }

    public void a(com.baidu.tieba.enterForum.view.b bVar) {
        this.gBM = bVar;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.d dVar) {
        this.gBG = this.gyZ;
        this.gyZ = dVar;
        this.gBB.setAdState(dVar);
        si(this.gBD.getCurrentItem());
    }

    public void setSearchHint(String str) {
        this.gBB.setSearchHint(str);
    }

    public View getRootView() {
        return getPageContext().getPageActivity().getWindow().getDecorView();
    }

    public View bIG() {
        return this.gBA;
    }

    public String getCurrentPageKey() {
        if (this.gBE != null) {
            return this.gBE.getCurrentPageKey();
        }
        return null;
    }

    private void sj(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gBL.getLayoutParams();
        layoutParams.topMargin = this.gBN + i;
        this.gBL.setLayoutParams(layoutParams);
    }

    public void a(p pVar, boolean z) {
        int i = 0;
        if (!this.gBz.getActivity().getSupportFragmentManager().isDestroyed()) {
            this.gBQ = true;
            if (this.gBP == null || !this.gBP.b(pVar)) {
                bII();
                this.gBF.clear();
                this.gBF.add(this.gBF.get(0));
                Iterator<o> it = pVar.bIa().iterator();
                while (it.hasNext()) {
                    o next = it.next();
                    EnterForumTabPagerAdapter.a aVar = new EnterForumTabPagerAdapter.a();
                    aVar.fragment = new EnterForumTabFeedFragment();
                    aVar.title = next.getTabName();
                    if (z) {
                        if (this.gBP == null) {
                            aVar.gBy = true;
                        } else {
                            aVar.gBy = this.gBP.b(next);
                        }
                    }
                    aVar.tabName = next.getTabName();
                    Bundle bundle = new Bundle();
                    bundle.putString("tab_code", next.bHZ());
                    bundle.putString("tab_name", next.getTabName());
                    aVar.fragment.setArguments(bundle);
                    this.gBF.add(aVar);
                }
                this.gBP = pVar;
                this.gBC.notifyDataSetChanged();
                this.gBE.notifyDataSetChanged();
                this.gBD.setOffscreenPageLimit(this.gBF.size());
                bIH();
            } else if (pVar != null && this.gBP != null && v.getCount(this.gBF) - 1 == v.getCount(pVar.bIa())) {
                if (z) {
                    while (true) {
                        int i2 = i;
                        if (i2 >= pVar.bIa().size()) {
                            break;
                        }
                        if (this.gBF.get(i2 + 1) != null && pVar.bIa().get(i2) != null) {
                            this.gBF.get(i2 + 1).gBy = this.gBP.b(pVar.bIa().get(i2));
                        }
                        i = i2 + 1;
                    }
                }
                this.gBP = pVar;
                this.gBC.notifyDataSetChanged();
                bIH();
            }
        }
    }

    private void bIH() {
        if (!TextUtils.isEmpty(this.gBO)) {
            int Cb = Cb(this.gBO);
            if (Cb == -1) {
                Cb = 0;
            }
            if (sh(Cb)) {
                Intent intent = getPageContext().getPageActivity().getIntent();
                if (intent != null) {
                    intent.removeExtra("sub_locate_type");
                    intent.removeExtra("is_from_scheme");
                }
                this.gBO = null;
            }
        }
    }

    private void bII() {
        if (this.gBE != null && this.gBF != null) {
            try {
                FragmentManager supportFragmentManager = this.gBz.getActivity().getSupportFragmentManager();
                if (!supportFragmentManager.isDestroyed()) {
                    FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                    for (int i = 1; i < this.gBF.size(); i++) {
                        Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.gBD.getId(), this.gBE.getItemId(i)));
                        if (findFragmentByTag != null) {
                            beginTransaction.remove(findFragmentByTag);
                        }
                    }
                    beginTransaction.commit();
                    supportFragmentManager.executePendingTransactions();
                }
            } catch (Throwable th) {
            }
        }
    }

    public int bIJ() {
        return this.gBD.getCurrentItem();
    }

    public void sk(int i) {
        if (i == 0) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001631, getPageContext().getUniqueId()));
        } else if (v.getItem(this.gBF, i) != null && (this.gBF.get(i).fragment instanceof EnterForumTabFeedFragment)) {
            ((EnterForumTabFeedFragment) this.gBF.get(i).fragment).lW(true);
        }
    }

    public String sl(int i) {
        EnterForumTabPagerAdapter.a aVar = (EnterForumTabPagerAdapter.a) v.getItem(this.gBF, i);
        return (aVar == null || !(aVar.fragment instanceof EnterForumTabFeedFragment)) ? "" : ((EnterForumTabFeedFragment) aVar.fragment).getTabName();
    }
}
