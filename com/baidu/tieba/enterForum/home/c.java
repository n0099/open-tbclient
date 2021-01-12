package com.baidu.tieba.enterForum.home;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
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
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
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
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.x;
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
/* loaded from: classes2.dex */
public class c extends com.baidu.adp.base.d implements NoNetworkView.a {
    private NoNetworkView gxx;
    private AlphaAnimation gzW;
    private AlphaAnimation gzX;
    private com.baidu.tieba.enterForum.data.c iBh;
    private EnterForumTabFragment iDE;
    private LinearLayout iDF;
    private ForumHeaderView iDG;
    private NewPagerSlidingTabBaseStrip iDH;
    private PullLeftViewPager iDI;
    private EnterForumTabPagerAdapter iDJ;
    private List<EnterForumTabPagerAdapter.a> iDK;
    private com.baidu.tieba.enterForum.data.c iDL;
    private ImageView iDM;
    private View iDN;
    private View iDO;
    private NavigationBar iDP;
    private View iDQ;
    private com.baidu.tieba.enterForum.view.b iDR;
    private int iDS;
    private String iDT;
    private boolean iDU;
    private com.baidu.adp.framework.listener.a iDV;
    private CustomMessageListener iDW;
    private int mNavHeight;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private View mRootView;

    public c(EnterForumTabFragment enterForumTabFragment) {
        super(enterForumTabFragment.getPageContext());
        this.iDU = false;
        this.iDV = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.enterForum.home.c.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String str = "";
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage = (forumRecommendSocketResponseMessage) responsedMessage;
                    if (forumrecommendsocketresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendsocketresponsemessage.getHotSearchInfoData().ctU();
                    }
                } else if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage = (forumRecommendHttpResponseMessage) responsedMessage;
                    if (forumrecommendhttpresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendhttpresponsemessage.getHotSearchInfoData().ctU();
                    }
                }
                if (TextUtils.isEmpty(str)) {
                    str = c.this.mContext.getResources().getString(R.string.enter_forum_search_tip);
                }
                TbSingleton.getInstance().setHotSearch(str);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921396));
            }
        };
        this.iDW = new CustomMessageListener(2001630) { // from class: com.baidu.tieba.enterForum.home.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        c.this.bRg();
                    } else {
                        c.this.bRh();
                    }
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.enterForum.home.c.3
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                c.this.c(i, f, i2);
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                boolean z;
                c.this.xt(i);
                if (c.this.iDK != null && c.this.iDK.size() > i) {
                    if (c.this.iDR != null) {
                        c.this.iDR.cwu();
                    }
                    EnterForumTabPagerAdapter.a aVar = (EnterForumTabPagerAdapter.a) c.this.iDK.get(i);
                    if (aVar != null && aVar.fragment != null) {
                        if (aVar.fragment instanceof EnterForumFragment) {
                            z = ((EnterForumFragment) aVar.fragment).cuR();
                        } else if (aVar.fragment instanceof EnterForumTabFeedFragment) {
                            s.crj().pr(false);
                            boolean cuR = ((EnterForumTabFeedFragment) aVar.fragment).cuR();
                            TiebaStatic.log(new aq("c13366").an("obj_locate", 3).dW("resource_id", ((EnterForumTabFeedFragment) aVar.fragment).getTabName()));
                            z = cuR;
                        } else {
                            z = true;
                        }
                        if (!z) {
                            c.this.bRg();
                        } else {
                            c.this.bRh();
                        }
                        if (i == 0) {
                            TiebaStatic.log(new aq("c13366").an("obj_locate", 1));
                        }
                        if (i == 0) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921386));
                        }
                    }
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        };
        this.iDE = enterForumTabFragment;
        this.iDE.registerListener(this.iDV);
        this.iDE.registerListener(this.iDW);
        this.mNavHeight = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds228);
        this.iDS = UtilHelper.getStatusBarHeight() + l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds229);
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            ak(bundle);
            al(bundle);
            am(bundle);
            this.gxx = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.gxx.a(this);
        }
    }

    private void ak(Bundle bundle) {
        this.iDI = (PullLeftViewPager) this.mRootView.findViewById(R.id.enter_forum_viewpager);
        EnterForumTabPagerAdapter.a aVar = new EnterForumTabPagerAdapter.a();
        aVar.fragment = new EnterForumFragment();
        aVar.title = this.iDE.getResources().getString(R.string.my_forum);
        ((EnterForumFragment) aVar.fragment).setTabViewController(this);
        this.iDK = new ArrayList();
        this.iDK.add(aVar);
        this.iDJ = new EnterForumTabPagerAdapter(this.iDE.getActivity().getSupportFragmentManager(), this.iDK);
        this.iDI.setAdapter(this.iDJ);
        this.iDI.setOffscreenPageLimit(this.iDK.size());
    }

    public void auw() {
    }

    private void al(Bundle bundle) {
        this.iDF = (LinearLayout) LayoutInflater.from(this.iDE.getContext()).inflate(R.layout.enter_forum_tab_layout, (ViewGroup) null);
        this.iDG = (ForumHeaderView) this.iDF.findViewById(R.id.recommend_forum_header_serch_view);
        this.iDG.setFrom(0);
        this.iDG.onChangeSkinType();
        this.iDH = (NewPagerSlidingTabBaseStrip) this.iDF.findViewById(R.id.tab_layout);
        this.iDH.setDefaultSelectorColorResourceId(R.color.CAM_X0105);
        this.iDH.setRectPaintColor(R.color.CAM_X0302);
        this.iDH.a(l.getDimens(this.iDE.getContext(), R.dimen.tbds46), l.getDimens(this.iDE.getContext(), R.dimen.tbds46), l.getDimens(this.iDE.getContext(), R.dimen.tbds10), l.getDimens(this.iDE.getContext(), R.dimen.tbds46), true);
        this.iDH.setmIndicatorWidth(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds42));
        this.iDH.setIndicatorOvershot(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds8));
        this.iDH.setIndicatorRadius(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds8));
        this.iDH.setIndicatorMarginBottom(l.getDimens(this.iDE.getContext(), R.dimen.tbds0));
        this.iDH.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        this.iDH.setTabPadding(l.getDimens(this.iDE.getContext(), R.dimen.tbds36), 0, l.getDimens(this.iDE.getContext(), R.dimen.tbds36), 0);
        this.iDH.setViewPager(this.iDI);
        this.iDH.setOnPageChangeListener(this.mOnPageChangeListener);
        this.iDO = this.iDF.findViewById(R.id.enter_forum_tab_left_grandient);
        this.iDN = this.iDF.findViewById(R.id.enter_forum_tab_right_grandient);
    }

    private void am(Bundle bundle) {
        this.iDP = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.iDP.setNavHeight(this.mNavHeight);
        this.iDP.hideBottomLine();
        this.iDQ = this.mRootView.findViewById(R.id.divider_shadow);
        xu(0);
        this.iDM = (ImageView) this.iDF.findViewById(R.id.navigationBarGoSignall);
        this.iDM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.CheckFile("scan_flag") && ad.checkCamera(c.this.mContext.getPageActivity())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new QRCodeScanActivityConfig(c.this.mContext.getPageActivity())));
                } else if (!TbadkCoreApplication.isLogin()) {
                    bg.skipToLoginActivity(c.this.getPageContext().getPageActivity());
                } else {
                    c.this.iDE.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(c.this.getPageContext().getPageActivity())));
                }
            }
        });
        if (this.iDH != null) {
            this.iDP.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, this.iDF, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.iDF.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(3);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(3);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 3;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.iDH.setPadding(this.iDH.getPaddingLeft(), this.iDH.getPaddingTop(), this.iDH.getPaddingRight(), this.iDH.getPaddingBottom());
        }
    }

    public void a(NewPagerSlidingTabBaseStrip.a aVar) {
        if (this.iDH != null && aVar != null) {
            this.iDH.setOnTabItemClickListener(aVar);
        }
    }

    public boolean xs(int i) {
        if (i < 0 || i > this.iDK.size()) {
            return false;
        }
        this.iDI.setCurrentItem(i, true);
        return true;
    }

    public void Iy(String str) {
        this.iDT = str;
    }

    public int Iz(String str) {
        if (StringUtils.isNull(str) || this.iDK == null || this.iDK.size() <= 0) {
            return -1;
        }
        int i = -1;
        for (int i2 = 0; i2 < this.iDK.size(); i2++) {
            if (str.equals(this.iDK.get(i2).tabName)) {
                i = i2;
            }
        }
        if (i == -1 && this.iDE.getResources().getString(R.string.my_forum).equals(str)) {
            return 0;
        }
        return i;
    }

    public boolean cva() {
        return this.iDU;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        xt(this.iDI.getCurrentItem());
        if (this.gxx != null) {
            this.gxx.onChangeSkinType(getPageContext(), i);
        }
        if (this.iDK != null && this.iDK.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.iDK.size()) {
                    break;
                }
                EnterForumTabPagerAdapter.a aVar = this.iDK.get(i3);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            }
        }
        ao.setBackgroundResource(this.iDQ, R.drawable.personalize_tab_shadow);
        this.iDH.onChangeSkinType();
        this.iDG.onChangeSkinType();
        ao.a(this.iDO, R.color.CAM_X0207, GradientDrawable.Orientation.LEFT_RIGHT);
        ao.a(this.iDN, R.color.CAM_X0207, GradientDrawable.Orientation.RIGHT_LEFT);
    }

    public void cvb() {
        xt(this.iDI.getCurrentItem());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, float f, int i2) {
        if (this.iDP != null) {
            if (i == 0) {
                if (i2 == 0) {
                    xt(i);
                } else if (this.iBh != null && this.iBh.iBJ && this.iBh.iBL > 0) {
                    if (this.iDR != null && this.iDR.getRefreshView() != null && this.iDR.getRefreshView().isViewAttached()) {
                        ao.setBackgroundColor(this.iDP.getBarBgView(), R.color.CAM_X0207, TbadkCoreApplication.getInst().getSkinType());
                        return;
                    }
                    this.iDP.setBackgroundColor(0);
                    ao.a(this.iDP.getBarBgView(), R.color.CAM_X0207, f, TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (i2 == 0) {
                xt(i);
            } else if (this.iBh != null && this.iBh.iBJ && this.iBh.iBL > 0) {
                if (this.iDR != null && this.iDR.getRefreshView() != null && this.iDR.getRefreshView().isViewAttached()) {
                    ao.setBackgroundColor(this.iDP.getBarBgView(), R.color.CAM_X0201, TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.iDP.setBackgroundColor(0);
                ao.a(this.iDP.getBarBgView(), R.color.CAM_X0201, 1.0f - f, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt(int i) {
        int i2;
        if (this.iDM != null) {
            if (i == 0) {
                if (this.iBh != null && this.iBh.iBJ && this.iBh.iBL > 0) {
                    if (this.iDR != null && this.iDR.getRefreshView() != null && this.iDR.getRefreshView().isViewAttached()) {
                        SvgManager.bsx().a(this.iDM, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    } else if (this.iBh.iBM > 0 && this.iBh.iBL > this.iBh.iBM / 2) {
                        SvgManager.bsx().a(this.iDM, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    } else {
                        SvgManager.bsx().a(this.iDM, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    }
                } else {
                    SvgManager.bsx().a(this.iDM, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
            } else {
                SvgManager.bsx().a(this.iDM, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
        if (this.iDP != null) {
            this.iDP.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            if (i == 0) {
                if (this.iBh != null && this.iBh.iBJ && this.iBh.iBL > 0) {
                    if (this.iDR != null && this.iDR.getRefreshView() != null && this.iDR.getRefreshView().isViewAttached()) {
                        ao.setBackgroundColor(this.iDP.getBarBgView(), R.color.CAM_X0207, TbadkCoreApplication.getInst().getSkinType());
                    } else {
                        if (this.iBh.iBM > 0) {
                            int i3 = (this.iBh.iBL * 255) / this.iBh.iBM;
                            i2 = 255 - (i3 <= 255 ? i3 : 255);
                        } else {
                            i2 = 0;
                        }
                        this.iDP.setBackgroundColor(0);
                        ao.a(this.iDP.getBarBgView(), R.color.CAM_X0201, i2 / 255.0f, TbadkCoreApplication.getInst().getSkinType());
                    }
                } else {
                    ao.setBackgroundColor(this.iDP.getBarBgView(), R.color.CAM_X0207, TbadkCoreApplication.getInst().getSkinType());
                }
            } else {
                ao.setBackgroundColor(this.iDP.getBarBgView(), R.color.CAM_X0207, TbadkCoreApplication.getInst().getSkinType());
            }
        }
        if (i == 0) {
            if (this.iBh != null && this.iBh.iBJ && this.iBh.iBL > 0) {
                if (this.iBh.iBM > 0 && this.iBh.iBL > this.iBh.iBM / 2) {
                    if (this.iDR != null && this.iDR.getRefreshView() != null && this.iDR.getRefreshView().isViewAttached()) {
                        this.iDH.setWhiteStyle(false);
                    } else {
                        this.iDH.setWhiteStyle(true);
                    }
                } else {
                    this.iDH.setWhiteStyle(false);
                }
            } else {
                this.iDH.setWhiteStyle(false);
            }
        } else {
            this.iDH.setWhiteStyle(false);
        }
        if (i == 0) {
            this.iDG.setAdState(this.iBh);
        } else {
            this.iDG.setAdState(null);
        }
        if (i == 0 && TbadkCoreApplication.getInst().getSkinType() != 1 && this.iDE.isPrimary() && this.iBh != null && this.iBh.iBJ && i == 0) {
            if (this.iBh.iBL > this.iBh.iBM / 2) {
                if (this.iDL != null && this.iDL.iBL <= this.iBh.iBM / 2) {
                    ar.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
                }
            } else if (this.iDL != null && this.iDL.iBL >= this.iBh.iBM / 2) {
                ar.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            }
        }
    }

    public void cvc() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
            ar.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
        } else if (this.iDI.getCurrentItem() == 0 && this.iDE.isPrimary()) {
            if (this.iDR != null && this.iDR.getRefreshView() != null && this.iDR.getRefreshView().isViewAttached()) {
                ar.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            } else if (this.iBh != null && this.iBh.iBJ) {
                if (this.iBh.iBL > this.iBh.iBM / 2 || this.iBh.iBL == 0) {
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
        if (this.iDK != null && this.iDK.size() > 0 && this.iDI != null) {
            EnterForumTabPagerAdapter.a aVar = this.iDK.get(this.iDI.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void ajv() {
        if (this.iDE != null && this.iDK != null && this.iDI != null && this.iDJ != null) {
            FragmentManager supportFragmentManager = this.iDE.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.iDK.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.iDI.getId(), this.iDJ.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.gxx != null) {
            this.gxx.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.iDJ != null) {
            this.iDJ.setPrimary(z);
        }
        if (this.iDK != null && this.iDK.size() > 0 && this.iDI != null) {
            EnterForumTabPagerAdapter.a aVar = this.iDK.get(this.iDI.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.iDK != null && this.iDK.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.iDK.size()) {
                    break;
                }
                EnterForumTabPagerAdapter.a aVar = this.iDK.get(i2);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof NoNetworkView.a)) {
                    ((NoNetworkView.a) aVar.fragment).onNetworkChange(z);
                }
                i = i2 + 1;
            }
        }
        xt(this.iDI.getCurrentItem());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRg() {
        if (this.iDF != null && this.iDF.getPaddingTop() < 0) {
            cvd();
        } else if (this.iDQ != null) {
            this.iDQ.clearAnimation();
            if (this.iDQ.getVisibility() != 0) {
                this.iDQ.setVisibility(0);
                if (this.gzW == null) {
                    this.gzW = new AlphaAnimation(0.0f, 1.0f);
                    this.gzW.setFillAfter(true);
                    this.gzW.setDuration(300L);
                }
                this.iDQ.startAnimation(this.gzW);
            }
        }
    }

    public void bRh() {
        if (this.iDQ != null && this.iDQ.getVisibility() != 8) {
            if (this.gzX == null) {
                this.gzX = new AlphaAnimation(1.0f, 0.0f);
                this.gzX.setFillAfter(true);
                this.gzX.setDuration(300L);
                this.gzX.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.enterForum.home.c.5
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.iDQ.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.iDQ.startAnimation(this.gzX);
        }
    }

    private void cvd() {
        if (this.iDQ != null && this.iDQ.getVisibility() != 8) {
            this.iDQ.clearAnimation();
            this.iDQ.setVisibility(8);
        }
    }

    public void a(com.baidu.tieba.enterForum.view.b bVar) {
        this.iDR = bVar;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.iDL = this.iBh;
        this.iBh = cVar;
        this.iDG.setAdState(cVar);
        xt(this.iDI.getCurrentItem());
    }

    public void setSearchHint(String str) {
        this.iDG.setSearchHint(str);
    }

    public View getRootView() {
        return getPageContext().getPageActivity().getWindow().getDecorView();
    }

    public View cve() {
        return this.iDF;
    }

    public String getCurrentPageKey() {
        if (this.iDJ != null) {
            return this.iDJ.getCurrentPageKey();
        }
        return null;
    }

    private void xu(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.iDQ.getLayoutParams();
        layoutParams.topMargin = this.iDS + i;
        this.iDQ.setLayoutParams(layoutParams);
    }

    public int cvf() {
        return this.iDI.getCurrentItem();
    }

    public void xv(int i) {
        if (i == 0) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001631, getPageContext().getUniqueId()));
        } else if (x.getItem(this.iDK, i) != null && (this.iDK.get(i).fragment instanceof EnterForumTabFeedFragment)) {
            ((EnterForumTabFeedFragment) this.iDK.get(i).fragment).pR(true);
        }
    }

    public String xw(int i) {
        EnterForumTabPagerAdapter.a aVar = (EnterForumTabPagerAdapter.a) x.getItem(this.iDK, i);
        return (aVar == null || !(aVar.fragment instanceof EnterForumTabFeedFragment)) ? "" : ((EnterForumTabFeedFragment) aVar.fragment).getTabName();
    }
}
