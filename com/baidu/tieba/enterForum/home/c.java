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
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.widget.horizontalpullview.PullLeftViewPager;
import com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip;
import com.baidu.tieba.R;
import com.baidu.tieba.card.s;
import com.baidu.tieba.enterForum.home.EnterForumTabPagerAdapter;
import com.baidu.tieba.enterForum.tabfeed.EnterForumTabFeedFragment;
import com.baidu.tieba.enterForum.view.ForumHeaderView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class c extends com.baidu.adp.base.c implements NoNetworkView.a {
    private NoNetworkView fDZ;
    private AlphaAnimation fGq;
    private AlphaAnimation fGr;
    private com.baidu.tieba.enterForum.data.c htu;
    private EnterForumTabFragment hvQ;
    private LinearLayout hvR;
    private ForumHeaderView hvS;
    private NewPagerSlidingTabBaseStrip hvT;
    private PullLeftViewPager hvU;
    private EnterForumTabPagerAdapter hvV;
    private List<EnterForumTabPagerAdapter.a> hvW;
    private com.baidu.tieba.enterForum.data.c hvX;
    private ImageView hvY;
    private View hvZ;
    private View hwa;
    private NavigationBar hwb;
    private View hwc;
    private com.baidu.tieba.enterForum.view.b hwd;
    private int hwe;
    private String hwf;
    private boolean hwg;
    private com.baidu.adp.framework.listener.a hwh;
    private CustomMessageListener hwi;
    private int mNavHeight;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private View mRootView;

    public c(EnterForumTabFragment enterForumTabFragment) {
        super(enterForumTabFragment.getPageContext());
        this.hwg = false;
        this.hwh = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.enterForum.home.c.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String str = "";
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage = (forumRecommendSocketResponseMessage) responsedMessage;
                    if (forumrecommendsocketresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendsocketresponsemessage.getHotSearchInfoData().ceH();
                    }
                } else if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage = (forumRecommendHttpResponseMessage) responsedMessage;
                    if (forumrecommendhttpresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendhttpresponsemessage.getHotSearchInfoData().ceH();
                    }
                }
                if (TextUtils.isEmpty(str)) {
                    str = c.this.mContext.getResources().getString(R.string.enter_forum_search_tip);
                }
                TbSingleton.getInstance().setHotSearch(str);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921396));
            }
        };
        this.hwi = new CustomMessageListener(2001630) { // from class: com.baidu.tieba.enterForum.home.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        c.this.bGm();
                    } else {
                        c.this.bGn();
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
                c.this.vY(i);
                if (c.this.hvW != null && c.this.hvW.size() > i) {
                    if (c.this.hwd != null) {
                        c.this.hwd.chg();
                    }
                    EnterForumTabPagerAdapter.a aVar = (EnterForumTabPagerAdapter.a) c.this.hvW.get(i);
                    if (aVar != null && aVar.fragment != null) {
                        if (aVar.fragment instanceof EnterForumFragment) {
                            z = ((EnterForumFragment) aVar.fragment).cfB();
                        } else if (aVar.fragment instanceof EnterForumTabFeedFragment) {
                            s.cbY().nm(false);
                            boolean cfB = ((EnterForumTabFeedFragment) aVar.fragment).cfB();
                            TiebaStatic.log(new aq("c13366").ai("obj_locate", 3).dD("resource_id", ((EnterForumTabFeedFragment) aVar.fragment).getTabName()));
                            z = cfB;
                        } else {
                            z = true;
                        }
                        if (!z) {
                            c.this.bGm();
                        } else {
                            c.this.bGn();
                        }
                        if (i == 0) {
                            TiebaStatic.log(new aq("c13366").ai("obj_locate", 1));
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
        this.hvQ = enterForumTabFragment;
        this.hvQ.registerListener(this.hwh);
        this.hvQ.registerListener(this.hwi);
        this.mNavHeight = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds228);
        this.hwe = UtilHelper.getStatusBarHeight() + l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds229);
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            ak(bundle);
            al(bundle);
            am(bundle);
            this.fDZ = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.fDZ.a(this);
        }
    }

    private void ak(Bundle bundle) {
        this.hvU = (PullLeftViewPager) this.mRootView.findViewById(R.id.enter_forum_viewpager);
        EnterForumTabPagerAdapter.a aVar = new EnterForumTabPagerAdapter.a();
        aVar.fragment = new EnterForumFragment();
        aVar.title = this.hvQ.getResources().getString(R.string.my_forum);
        ((EnterForumFragment) aVar.fragment).setTabViewController(this);
        this.hvW = new ArrayList();
        this.hvW.add(aVar);
        this.hvV = new EnterForumTabPagerAdapter(this.hvQ.getActivity().getSupportFragmentManager(), this.hvW);
        this.hvU.setAdapter(this.hvV);
        this.hvU.setOffscreenPageLimit(this.hvW.size());
    }

    public void amH() {
    }

    private void al(Bundle bundle) {
        this.hvR = (LinearLayout) LayoutInflater.from(this.hvQ.getContext()).inflate(R.layout.enter_forum_tab_layout, (ViewGroup) null);
        this.hvS = (ForumHeaderView) this.hvR.findViewById(R.id.recommend_forum_header_serch_view);
        this.hvS.setFrom(0);
        this.hvS.onChangeSkinType();
        this.hvT = (NewPagerSlidingTabBaseStrip) this.hvR.findViewById(R.id.tab_layout);
        this.hvT.setDefaultSelectorColorResourceId(R.color.cp_cont_b);
        this.hvT.setRectPaintColor(R.color.cp_link_tip_a);
        this.hvT.a(l.getDimens(this.hvQ.getContext(), R.dimen.tbds46), l.getDimens(this.hvQ.getContext(), R.dimen.tbds46), l.getDimens(this.hvQ.getContext(), R.dimen.tbds10), l.getDimens(this.hvQ.getContext(), R.dimen.tbds46), true);
        this.hvT.setmIndicatorWidth(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds42));
        this.hvT.setIndicatorOvershot(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds8));
        this.hvT.setIndicatorRadius(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds8));
        this.hvT.setIndicatorMarginBottom(l.getDimens(this.hvQ.getContext(), R.dimen.tbds0));
        this.hvT.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        this.hvT.setTabPadding(l.getDimens(this.hvQ.getContext(), R.dimen.tbds36), 0, l.getDimens(this.hvQ.getContext(), R.dimen.tbds36), 0);
        this.hvT.setViewPager(this.hvU);
        this.hvT.setOnPageChangeListener(this.mOnPageChangeListener);
        this.hwa = this.hvR.findViewById(R.id.enter_forum_tab_left_grandient);
        this.hvZ = this.hvR.findViewById(R.id.enter_forum_tab_right_grandient);
    }

    private void am(Bundle bundle) {
        this.hwb = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.hwb.setNavHeight(this.mNavHeight);
        this.hwb.hideBottomLine();
        this.hwc = this.mRootView.findViewById(R.id.divider_shadow);
        vZ(0);
        this.hvY = (ImageView) this.hvR.findViewById(R.id.navigationBarGoSignall);
        this.hvY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.CheckFile("scan_flag") && ae.checkCamera(c.this.mContext.getPageActivity())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new QRCodeScanActivityConfig(c.this.mContext.getPageActivity())));
                } else if (!TbadkCoreApplication.isLogin()) {
                    bg.skipToLoginActivity(c.this.getPageContext().getPageActivity());
                } else {
                    c.this.hvQ.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(c.this.getPageContext().getPageActivity())));
                }
            }
        });
        if (this.hvT != null) {
            this.hwb.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, this.hvR, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.hvR.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(3);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(3);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 3;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.hvT.setPadding(this.hvT.getPaddingLeft(), this.hvT.getPaddingTop(), this.hvT.getPaddingRight(), this.hvT.getBottom());
        }
    }

    public void a(NewPagerSlidingTabBaseStrip.a aVar) {
        if (this.hvT != null && aVar != null) {
            this.hvT.setOnTabItemClickListener(aVar);
        }
    }

    public boolean vX(int i) {
        if (i < 0 || i > this.hvW.size()) {
            return false;
        }
        this.hvU.setCurrentItem(i, true);
        return true;
    }

    public void Hv(String str) {
        this.hwf = str;
    }

    public int Hw(String str) {
        if (StringUtils.isNull(str) || this.hvW == null || this.hvW.size() <= 0) {
            return -1;
        }
        int i = -1;
        for (int i2 = 0; i2 < this.hvW.size(); i2++) {
            if (str.equals(this.hvW.get(i2).tabName)) {
                i = i2;
            }
        }
        if (i == -1 && this.hvQ.getResources().getString(R.string.my_forum).equals(str)) {
            return 0;
        }
        return i;
    }

    public boolean cfK() {
        return this.hwg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        vY(this.hvU.getCurrentItem());
        if (this.fDZ != null) {
            this.fDZ.onChangeSkinType(getPageContext(), i);
        }
        if (this.hvW != null && this.hvW.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.hvW.size()) {
                    break;
                }
                EnterForumTabPagerAdapter.a aVar = this.hvW.get(i3);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            }
        }
        ap.setBackgroundResource(this.hwc, R.drawable.personalize_tab_shadow);
        this.hvT.onChangeSkinType();
        this.hvS.onChangeSkinType();
        ap.a(this.hwa, R.color.cp_bg_line_h, GradientDrawable.Orientation.LEFT_RIGHT);
        ap.a(this.hvZ, R.color.cp_bg_line_h, GradientDrawable.Orientation.RIGHT_LEFT);
    }

    public void cfL() {
        vY(this.hvU.getCurrentItem());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, float f, int i2) {
        if (this.hwb != null) {
            if (i == 0) {
                if (i2 == 0) {
                    vY(i);
                } else if (this.htu != null && this.htu.htW && this.htu.htY > 0) {
                    if (this.hwd != null && this.hwd.getRefreshView() != null && this.hwd.getRefreshView().isViewAttached()) {
                        ap.setBackgroundColor(this.hwb.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
                        return;
                    }
                    this.hwb.setBackgroundColor(0);
                    ap.a(this.hwb.getBarBgView(), R.color.cp_bg_line_h, f, TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (i2 == 0) {
                vY(i);
            } else if (this.htu != null && this.htu.htW && this.htu.htY > 0) {
                if (this.hwd != null && this.hwd.getRefreshView() != null && this.hwd.getRefreshView().isViewAttached()) {
                    ap.setBackgroundColor(this.hwb.getBarBgView(), R.color.cp_bg_line_d, TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.hwb.setBackgroundColor(0);
                ap.a(this.hwb.getBarBgView(), R.color.cp_bg_line_d, 1.0f - f, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vY(int i) {
        int i2;
        if (this.hvY != null) {
            if (i == 0) {
                if (this.htu != null && this.htu.htW && this.htu.htY > 0) {
                    if (this.hwd != null && this.hwd.getRefreshView() != null && this.hwd.getRefreshView().isViewAttached()) {
                        SvgManager.bjq().a(this.hvY, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    } else if (this.htu.htZ > 0 && this.htu.htY > this.htu.htZ / 2) {
                        SvgManager.bjq().a(this.hvY, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    } else {
                        SvgManager.bjq().a(this.hvY, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    }
                } else {
                    SvgManager.bjq().a(this.hvY, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
            } else {
                SvgManager.bjq().a(this.hvY, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
        if (this.hwb != null) {
            this.hwb.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            if (i == 0) {
                if (this.htu != null && this.htu.htW && this.htu.htY > 0) {
                    if (this.hwd != null && this.hwd.getRefreshView() != null && this.hwd.getRefreshView().isViewAttached()) {
                        ap.setBackgroundColor(this.hwb.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
                    } else {
                        if (this.htu.htZ > 0) {
                            int i3 = (this.htu.htY * 255) / this.htu.htZ;
                            i2 = 255 - (i3 <= 255 ? i3 : 255);
                        } else {
                            i2 = 0;
                        }
                        this.hwb.setBackgroundColor(0);
                        ap.a(this.hwb.getBarBgView(), R.color.cp_bg_line_d, i2 / 255.0f, TbadkCoreApplication.getInst().getSkinType());
                    }
                } else {
                    ap.setBackgroundColor(this.hwb.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
                }
            } else {
                ap.setBackgroundColor(this.hwb.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
            }
        }
        if (i == 0) {
            if (this.htu != null && this.htu.htW && this.htu.htY > 0) {
                if (this.htu.htZ > 0 && this.htu.htY > this.htu.htZ / 2) {
                    if (this.hwd != null && this.hwd.getRefreshView() != null && this.hwd.getRefreshView().isViewAttached()) {
                        this.hvT.setWhiteStyle(false);
                    } else {
                        this.hvT.setWhiteStyle(true);
                    }
                } else {
                    this.hvT.setWhiteStyle(false);
                }
            } else {
                this.hvT.setWhiteStyle(false);
            }
        } else {
            this.hvT.setWhiteStyle(false);
        }
        if (i == 0) {
            this.hvS.setAdState(this.htu);
        } else {
            this.hvS.setAdState(null);
        }
        if (i == 0 && TbadkCoreApplication.getInst().getSkinType() != 1 && this.hvQ.isPrimary() && this.htu != null && this.htu.htW && i == 0) {
            if (this.htu.htY > this.htu.htZ / 2) {
                if (this.hvX != null && this.hvX.htY <= this.htu.htZ / 2) {
                    ar.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
                }
            } else if (this.hvX != null && this.hvX.htY >= this.htu.htZ / 2) {
                ar.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            }
        }
    }

    public void cfM() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
            ar.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
        } else if (this.hvU.getCurrentItem() == 0 && this.hvQ.isPrimary()) {
            if (this.hwd != null && this.hwd.getRefreshView() != null && this.hwd.getRefreshView().isViewAttached()) {
                ar.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            } else if (this.htu != null && this.htu.htW) {
                if (this.htu.htY > this.htu.htZ / 2 || this.htu.htY == 0) {
                    ar.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
                } else {
                    ar.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
                }
            } else {
                ar.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            }
        } else {
            ar.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.hvW != null && this.hvW.size() > 0 && this.hvU != null) {
            EnterForumTabPagerAdapter.a aVar = this.hvW.get(this.hvU.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void abP() {
        if (this.hvQ != null && this.hvW != null && this.hvU != null && this.hvV != null) {
            FragmentManager supportFragmentManager = this.hvQ.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.hvW.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.hvU.getId(), this.hvV.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.fDZ != null) {
            this.fDZ.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.hvV != null) {
            this.hvV.setPrimary(z);
        }
        if (this.hvW != null && this.hvW.size() > 0 && this.hvU != null) {
            EnterForumTabPagerAdapter.a aVar = this.hvW.get(this.hvU.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.hvW != null && this.hvW.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.hvW.size()) {
                    break;
                }
                EnterForumTabPagerAdapter.a aVar = this.hvW.get(i2);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof NoNetworkView.a)) {
                    ((NoNetworkView.a) aVar.fragment).onNetworkChange(z);
                }
                i = i2 + 1;
            }
        }
        vY(this.hvU.getCurrentItem());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGm() {
        if (this.hvR != null && this.hvR.getPaddingTop() < 0) {
            cfN();
        } else if (this.hwc != null) {
            this.hwc.clearAnimation();
            if (this.hwc.getVisibility() != 0) {
                this.hwc.setVisibility(0);
                if (this.fGq == null) {
                    this.fGq = new AlphaAnimation(0.0f, 1.0f);
                    this.fGq.setFillAfter(true);
                    this.fGq.setDuration(300L);
                }
                this.hwc.startAnimation(this.fGq);
            }
        }
    }

    public void bGn() {
        if (this.hwc != null && this.hwc.getVisibility() != 8) {
            if (this.fGr == null) {
                this.fGr = new AlphaAnimation(1.0f, 0.0f);
                this.fGr.setFillAfter(true);
                this.fGr.setDuration(300L);
                this.fGr.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.enterForum.home.c.5
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.hwc.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.hwc.startAnimation(this.fGr);
        }
    }

    private void cfN() {
        if (this.hwc != null && this.hwc.getVisibility() != 8) {
            this.hwc.clearAnimation();
            this.hwc.setVisibility(8);
        }
    }

    public void a(com.baidu.tieba.enterForum.view.b bVar) {
        this.hwd = bVar;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.hvX = this.htu;
        this.htu = cVar;
        this.hvS.setAdState(cVar);
        vY(this.hvU.getCurrentItem());
    }

    public void setSearchHint(String str) {
        this.hvS.setSearchHint(str);
    }

    public View getRootView() {
        return getPageContext().getPageActivity().getWindow().getDecorView();
    }

    public View cfO() {
        return this.hvR;
    }

    public String getCurrentPageKey() {
        if (this.hvV != null) {
            return this.hvV.getCurrentPageKey();
        }
        return null;
    }

    private void vZ(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hwc.getLayoutParams();
        layoutParams.topMargin = this.hwe + i;
        this.hwc.setLayoutParams(layoutParams);
    }

    public int cfP() {
        return this.hvU.getCurrentItem();
    }

    public void wa(int i) {
        if (i == 0) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001631, getPageContext().getUniqueId()));
        } else if (y.getItem(this.hvW, i) != null && (this.hvW.get(i).fragment instanceof EnterForumTabFeedFragment)) {
            ((EnterForumTabFeedFragment) this.hvW.get(i).fragment).nN(true);
        }
    }

    public String wb(int i) {
        EnterForumTabPagerAdapter.a aVar = (EnterForumTabPagerAdapter.a) y.getItem(this.hvW, i);
        return (aVar == null || !(aVar.fragment instanceof EnterForumTabFeedFragment)) ? "" : ((EnterForumTabFeedFragment) aVar.fragment).getTabName();
    }
}
