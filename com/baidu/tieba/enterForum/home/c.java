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
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.widget.horizontalpullview.PullLeftViewPager;
import com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip;
import com.baidu.tieba.R;
import com.baidu.tieba.card.t;
import com.baidu.tieba.enterForum.home.EnterForumTabPagerAdapter;
import com.baidu.tieba.enterForum.tabfeed.EnterForumTabFeedFragment;
import com.baidu.tieba.enterForum.view.ForumHeaderView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c extends com.baidu.adp.base.d implements NoNetworkView.a {
    private NoNetworkView gAv;
    private AlphaAnimation gCU;
    private AlphaAnimation gCV;
    private com.baidu.tieba.enterForum.data.c iHf;
    private EnterForumTabFragment iJC;
    private LinearLayout iJD;
    private ForumHeaderView iJE;
    private NewPagerSlidingTabBaseStrip iJF;
    private PullLeftViewPager iJG;
    private EnterForumTabPagerAdapter iJH;
    private List<EnterForumTabPagerAdapter.a> iJI;
    private com.baidu.tieba.enterForum.data.c iJJ;
    private ImageView iJK;
    private View iJL;
    private View iJM;
    private NavigationBar iJN;
    private View iJO;
    private com.baidu.tieba.enterForum.view.b iJP;
    private int iJQ;
    private String iJR;
    private boolean iJS;
    private com.baidu.adp.framework.listener.a iJT;
    private CustomMessageListener iJU;
    private int mNavHeight;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private View mRootView;

    public c(EnterForumTabFragment enterForumTabFragment) {
        super(enterForumTabFragment.getPageContext());
        this.iJS = false;
        this.iJT = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.enterForum.home.c.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String str = "";
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage = (forumRecommendSocketResponseMessage) responsedMessage;
                    if (forumrecommendsocketresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendsocketresponsemessage.getHotSearchInfoData().cvn();
                    }
                } else if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage = (forumRecommendHttpResponseMessage) responsedMessage;
                    if (forumrecommendhttpresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendhttpresponsemessage.getHotSearchInfoData().cvn();
                    }
                }
                if (TextUtils.isEmpty(str)) {
                    str = c.this.mContext.getResources().getString(R.string.enter_forum_search_tip);
                }
                TbSingleton.getInstance().setHotSearch(str);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921396));
            }
        };
        this.iJU = new CustomMessageListener(2001630) { // from class: com.baidu.tieba.enterForum.home.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        c.this.bRQ();
                    } else {
                        c.this.bRR();
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
                c.this.xD(i);
                if (c.this.iJI != null && c.this.iJI.size() > i) {
                    if (c.this.iJP != null) {
                        c.this.iJP.cxN();
                    }
                    EnterForumTabPagerAdapter.a aVar = (EnterForumTabPagerAdapter.a) c.this.iJI.get(i);
                    if (aVar != null && aVar.fragment != null) {
                        if (aVar.fragment instanceof EnterForumFragment) {
                            z = ((EnterForumFragment) aVar.fragment).cwk();
                        } else if (aVar.fragment instanceof EnterForumTabFeedFragment) {
                            t.csB().pB(false);
                            boolean cwk = ((EnterForumTabFeedFragment) aVar.fragment).cwk();
                            TiebaStatic.log(new ar("c13366").ap("obj_locate", 3).dR("resource_id", ((EnterForumTabFeedFragment) aVar.fragment).getTabName()));
                            z = cwk;
                        } else {
                            z = true;
                        }
                        if (!z) {
                            c.this.bRQ();
                        } else {
                            c.this.bRR();
                        }
                        if (i == 0) {
                            TiebaStatic.log(new ar("c13366").ap("obj_locate", 1));
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
        this.iJC = enterForumTabFragment;
        this.iJC.registerListener(this.iJT);
        this.iJC.registerListener(this.iJU);
        this.mNavHeight = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds228);
        this.iJQ = UtilHelper.getStatusBarHeight() + l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds229);
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            ak(bundle);
            al(bundle);
            am(bundle);
            this.gAv = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.gAv.a(this);
        }
    }

    private void ak(Bundle bundle) {
        this.iJG = (PullLeftViewPager) this.mRootView.findViewById(R.id.enter_forum_viewpager);
        EnterForumTabPagerAdapter.a aVar = new EnterForumTabPagerAdapter.a();
        aVar.fragment = new EnterForumFragment();
        aVar.title = this.iJC.getResources().getString(R.string.my_forum);
        ((EnterForumFragment) aVar.fragment).setTabViewController(this);
        this.iJI = new ArrayList();
        this.iJI.add(aVar);
        this.iJH = new EnterForumTabPagerAdapter(this.iJC.getActivity().getSupportFragmentManager(), this.iJI);
        this.iJG.setAdapter(this.iJH);
        this.iJG.setOffscreenPageLimit(this.iJI.size());
    }

    public void auU() {
    }

    private void al(Bundle bundle) {
        this.iJD = (LinearLayout) LayoutInflater.from(this.iJC.getContext()).inflate(R.layout.enter_forum_tab_layout, (ViewGroup) null);
        this.iJE = (ForumHeaderView) this.iJD.findViewById(R.id.recommend_forum_header_serch_view);
        this.iJE.setFrom(0);
        this.iJE.onChangeSkinType();
        this.iJF = (NewPagerSlidingTabBaseStrip) this.iJD.findViewById(R.id.tab_layout);
        this.iJF.setDefaultSelectorColorResourceId(R.color.CAM_X0105);
        this.iJF.setRectPaintColor(R.color.CAM_X0302);
        this.iJF.a(l.getDimens(this.iJC.getContext(), R.dimen.tbds46), l.getDimens(this.iJC.getContext(), R.dimen.tbds46), l.getDimens(this.iJC.getContext(), R.dimen.tbds10), l.getDimens(this.iJC.getContext(), R.dimen.tbds46), true);
        this.iJF.setmIndicatorWidth(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds42));
        this.iJF.setIndicatorOvershot(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds8));
        this.iJF.setIndicatorRadius(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds8));
        this.iJF.setIndicatorMarginBottom(l.getDimens(this.iJC.getContext(), R.dimen.tbds0));
        this.iJF.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        this.iJF.setTabPadding(l.getDimens(this.iJC.getContext(), R.dimen.tbds36), 0, l.getDimens(this.iJC.getContext(), R.dimen.tbds36), 0);
        this.iJF.setViewPager(this.iJG);
        this.iJF.setOnPageChangeListener(this.mOnPageChangeListener);
        this.iJM = this.iJD.findViewById(R.id.enter_forum_tab_left_grandient);
        this.iJL = this.iJD.findViewById(R.id.enter_forum_tab_right_grandient);
    }

    private void am(Bundle bundle) {
        this.iJN = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.iJN.setNavHeight(this.mNavHeight);
        this.iJN.hideBottomLine();
        this.iJO = this.mRootView.findViewById(R.id.divider_shadow);
        xE(0);
        this.iJK = (ImageView) this.iJD.findViewById(R.id.navigationBarGoSignall);
        this.iJK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (o.CheckFile("scan_flag") && ae.checkCamera(c.this.mContext.getPageActivity())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new QRCodeScanActivityConfig(c.this.mContext.getPageActivity())));
                } else if (!TbadkCoreApplication.isLogin()) {
                    bh.skipToLoginActivity(c.this.getPageContext().getPageActivity());
                } else {
                    c.this.iJC.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(c.this.getPageContext().getPageActivity())));
                }
            }
        });
        if (this.iJF != null) {
            this.iJN.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, this.iJD, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.iJD.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(3);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(3);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 3;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.iJF.setPadding(this.iJF.getPaddingLeft(), this.iJF.getPaddingTop(), this.iJF.getPaddingRight(), this.iJF.getPaddingBottom());
        }
    }

    public void a(NewPagerSlidingTabBaseStrip.a aVar) {
        if (this.iJF != null && aVar != null) {
            this.iJF.setOnTabItemClickListener(aVar);
        }
    }

    public boolean xC(int i) {
        if (i < 0 || i > this.iJI.size()) {
            return false;
        }
        this.iJG.setCurrentItem(i, true);
        return true;
    }

    public void Jk(String str) {
        this.iJR = str;
    }

    public int Jl(String str) {
        if (StringUtils.isNull(str) || this.iJI == null || this.iJI.size() <= 0) {
            return -1;
        }
        int i = -1;
        for (int i2 = 0; i2 < this.iJI.size(); i2++) {
            if (str.equals(this.iJI.get(i2).tabName)) {
                i = i2;
            }
        }
        if (i == -1 && this.iJC.getResources().getString(R.string.my_forum).equals(str)) {
            return 0;
        }
        return i;
    }

    public boolean cwt() {
        return this.iJS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        xD(this.iJG.getCurrentItem());
        if (this.gAv != null) {
            this.gAv.onChangeSkinType(getPageContext(), i);
        }
        if (this.iJI != null && this.iJI.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.iJI.size()) {
                    break;
                }
                EnterForumTabPagerAdapter.a aVar = this.iJI.get(i3);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            }
        }
        ap.setBackgroundResource(this.iJO, R.drawable.personalize_tab_shadow);
        this.iJF.onChangeSkinType();
        this.iJE.onChangeSkinType();
        ap.a(this.iJM, R.color.CAM_X0207, GradientDrawable.Orientation.LEFT_RIGHT);
        ap.a(this.iJL, R.color.CAM_X0207, GradientDrawable.Orientation.RIGHT_LEFT);
    }

    public void cwu() {
        xD(this.iJG.getCurrentItem());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, float f, int i2) {
        if (this.iJN != null) {
            if (i == 0) {
                if (i2 == 0) {
                    xD(i);
                } else if (this.iHf != null && this.iHf.iHH && this.iHf.iHJ > 0) {
                    if (this.iJP != null && this.iJP.getRefreshView() != null && this.iJP.getRefreshView().isViewAttached()) {
                        ap.setBackgroundColor(this.iJN.getBarBgView(), R.color.CAM_X0207, TbadkCoreApplication.getInst().getSkinType());
                        return;
                    }
                    this.iJN.setBackgroundColor(0);
                    ap.a(this.iJN.getBarBgView(), R.color.CAM_X0207, f, TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (i2 == 0) {
                xD(i);
            } else if (this.iHf != null && this.iHf.iHH && this.iHf.iHJ > 0) {
                if (this.iJP != null && this.iJP.getRefreshView() != null && this.iJP.getRefreshView().isViewAttached()) {
                    ap.setBackgroundColor(this.iJN.getBarBgView(), R.color.CAM_X0201, TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.iJN.setBackgroundColor(0);
                ap.a(this.iJN.getBarBgView(), R.color.CAM_X0201, 1.0f - f, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xD(int i) {
        int i2;
        if (this.iJK != null) {
            if (i == 0) {
                if (this.iHf != null && this.iHf.iHH && this.iHf.iHJ > 0) {
                    if (this.iJP != null && this.iJP.getRefreshView() != null && this.iJP.getRefreshView().isViewAttached()) {
                        SvgManager.bsR().a(this.iJK, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    } else if (this.iHf.iHK > 0 && this.iHf.iHJ > this.iHf.iHK / 2) {
                        SvgManager.bsR().a(this.iJK, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    } else {
                        SvgManager.bsR().a(this.iJK, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    }
                } else {
                    SvgManager.bsR().a(this.iJK, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
            } else {
                SvgManager.bsR().a(this.iJK, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
        if (this.iJN != null) {
            this.iJN.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            if (i == 0) {
                if (this.iHf != null && this.iHf.iHH && this.iHf.iHJ > 0) {
                    if (this.iJP != null && this.iJP.getRefreshView() != null && this.iJP.getRefreshView().isViewAttached()) {
                        ap.setBackgroundColor(this.iJN.getBarBgView(), R.color.CAM_X0207, TbadkCoreApplication.getInst().getSkinType());
                    } else {
                        if (this.iHf.iHK > 0) {
                            int i3 = (this.iHf.iHJ * 255) / this.iHf.iHK;
                            i2 = 255 - (i3 <= 255 ? i3 : 255);
                        } else {
                            i2 = 0;
                        }
                        this.iJN.setBackgroundColor(0);
                        ap.a(this.iJN.getBarBgView(), R.color.CAM_X0201, i2 / 255.0f, TbadkCoreApplication.getInst().getSkinType());
                    }
                } else {
                    ap.setBackgroundColor(this.iJN.getBarBgView(), R.color.CAM_X0207, TbadkCoreApplication.getInst().getSkinType());
                }
            } else {
                ap.setBackgroundColor(this.iJN.getBarBgView(), R.color.CAM_X0207, TbadkCoreApplication.getInst().getSkinType());
            }
        }
        if (i == 0) {
            if (this.iHf != null && this.iHf.iHH && this.iHf.iHJ > 0) {
                if (this.iHf.iHK > 0 && this.iHf.iHJ > this.iHf.iHK / 2) {
                    if (this.iJP != null && this.iJP.getRefreshView() != null && this.iJP.getRefreshView().isViewAttached()) {
                        this.iJF.setWhiteStyle(false);
                    } else {
                        this.iJF.setWhiteStyle(true);
                    }
                } else {
                    this.iJF.setWhiteStyle(false);
                }
            } else {
                this.iJF.setWhiteStyle(false);
            }
        } else {
            this.iJF.setWhiteStyle(false);
        }
        if (i == 0) {
            this.iJE.setAdState(this.iHf);
        } else {
            this.iJE.setAdState(null);
        }
        if (i == 0 && TbadkCoreApplication.getInst().getSkinType() != 1 && this.iJC.isPrimary() && this.iHf != null && this.iHf.iHH && i == 0) {
            if (this.iHf.iHJ > this.iHf.iHK / 2) {
                if (this.iJJ != null && this.iJJ.iHJ <= this.iHf.iHK / 2) {
                    as.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
                }
            } else if (this.iJJ != null && this.iJJ.iHJ >= this.iHf.iHK / 2) {
                as.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            }
        }
    }

    public void cwv() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
            as.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
        } else if (this.iJG.getCurrentItem() == 0 && this.iJC.isPrimary()) {
            if (this.iJP != null && this.iJP.getRefreshView() != null && this.iJP.getRefreshView().isViewAttached()) {
                as.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            } else if (this.iHf != null && this.iHf.iHH) {
                if (this.iHf.iHJ > this.iHf.iHK / 2 || this.iHf.iHJ == 0) {
                    as.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
                } else {
                    as.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
                }
            } else {
                as.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            }
        } else {
            as.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.iJI != null && this.iJI.size() > 0 && this.iJG != null) {
            EnterForumTabPagerAdapter.a aVar = this.iJI.get(this.iJG.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void ajT() {
        if (this.iJC != null && this.iJI != null && this.iJG != null && this.iJH != null) {
            FragmentManager supportFragmentManager = this.iJC.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.iJI.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.iJG.getId(), this.iJH.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.gAv != null) {
            this.gAv.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.iJH != null) {
            this.iJH.setPrimary(z);
        }
        if (this.iJI != null && this.iJI.size() > 0 && this.iJG != null) {
            EnterForumTabPagerAdapter.a aVar = this.iJI.get(this.iJG.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.iJI != null && this.iJI.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.iJI.size()) {
                    break;
                }
                EnterForumTabPagerAdapter.a aVar = this.iJI.get(i2);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof NoNetworkView.a)) {
                    ((NoNetworkView.a) aVar.fragment).onNetworkChange(z);
                }
                i = i2 + 1;
            }
        }
        xD(this.iJG.getCurrentItem());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRQ() {
        if (this.iJD != null && this.iJD.getPaddingTop() < 0) {
            cww();
        } else if (this.iJO != null) {
            this.iJO.clearAnimation();
            if (this.iJO.getVisibility() != 0) {
                this.iJO.setVisibility(0);
                if (this.gCU == null) {
                    this.gCU = new AlphaAnimation(0.0f, 1.0f);
                    this.gCU.setFillAfter(true);
                    this.gCU.setDuration(300L);
                }
                this.iJO.startAnimation(this.gCU);
            }
        }
    }

    public void bRR() {
        if (this.iJO != null && this.iJO.getVisibility() != 8) {
            if (this.gCV == null) {
                this.gCV = new AlphaAnimation(1.0f, 0.0f);
                this.gCV.setFillAfter(true);
                this.gCV.setDuration(300L);
                this.gCV.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.enterForum.home.c.5
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.iJO.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.iJO.startAnimation(this.gCV);
        }
    }

    private void cww() {
        if (this.iJO != null && this.iJO.getVisibility() != 8) {
            this.iJO.clearAnimation();
            this.iJO.setVisibility(8);
        }
    }

    public void a(com.baidu.tieba.enterForum.view.b bVar) {
        this.iJP = bVar;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.iJJ = this.iHf;
        this.iHf = cVar;
        this.iJE.setAdState(cVar);
        xD(this.iJG.getCurrentItem());
    }

    public void setSearchHint(String str) {
        this.iJE.setSearchHint(str);
    }

    public View getRootView() {
        return getPageContext().getPageActivity().getWindow().getDecorView();
    }

    public View cwx() {
        return this.iJD;
    }

    public String getCurrentPageKey() {
        if (this.iJH != null) {
            return this.iJH.getCurrentPageKey();
        }
        return null;
    }

    private void xE(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.iJO.getLayoutParams();
        layoutParams.topMargin = this.iJQ + i;
        this.iJO.setLayoutParams(layoutParams);
    }

    public int cwy() {
        return this.iJG.getCurrentItem();
    }

    public void xF(int i) {
        if (i == 0) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001631, getPageContext().getUniqueId()));
        } else if (y.getItem(this.iJI, i) != null && (this.iJI.get(i).fragment instanceof EnterForumTabFeedFragment)) {
            ((EnterForumTabFeedFragment) this.iJI.get(i).fragment).qb(true);
        }
    }

    public String xG(int i) {
        EnterForumTabPagerAdapter.a aVar = (EnterForumTabPagerAdapter.a) y.getItem(this.iJI, i);
        return (aVar == null || !(aVar.fragment instanceof EnterForumTabFeedFragment)) ? "" : ((EnterForumTabFeedFragment) aVar.fragment).getTabName();
    }
}
