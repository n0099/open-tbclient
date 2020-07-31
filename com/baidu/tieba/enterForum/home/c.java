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
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.widget.horizontalpullview.PullLeftViewPager;
import com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip;
import com.baidu.tieba.R;
import com.baidu.tieba.card.s;
import com.baidu.tieba.enterForum.data.i;
import com.baidu.tieba.enterForum.data.j;
import com.baidu.tieba.enterForum.home.EnterForumTabPagerAdapter;
import com.baidu.tieba.enterForum.tabfeed.EnterForumTabFeedFragment;
import com.baidu.tieba.enterForum.view.ForumHeaderView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes16.dex */
public class c extends com.baidu.adp.base.c implements NoNetworkView.a {
    private NoNetworkView fsB;
    private AlphaAnimation fuT;
    private AlphaAnimation fuU;
    private com.baidu.tieba.enterForum.data.c hgv;
    private EnterForumTabFragment hiM;
    private LinearLayout hiN;
    private ForumHeaderView hiO;
    private NewPagerSlidingTabBaseStrip hiP;
    private PullLeftViewPager hiQ;
    private EnterForumTabPagerAdapter hiR;
    private List<EnterForumTabPagerAdapter.a> hiS;
    private com.baidu.tieba.enterForum.data.c hiT;
    private ImageView hiU;
    private View hiV;
    private View hiW;
    private NavigationBar hiX;
    private View hiY;
    private com.baidu.tieba.enterForum.view.b hiZ;
    private int hja;
    private String hjb;
    private j hjc;
    private boolean hjd;
    private com.baidu.adp.framework.listener.a hje;
    private CustomMessageListener hjf;
    private int mNavHeight;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private View mRootView;

    public c(EnterForumTabFragment enterForumTabFragment) {
        super(enterForumTabFragment.getPageContext());
        this.hjd = false;
        this.hje = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.enterForum.home.c.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String str = "";
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage = (forumRecommendSocketResponseMessage) responsedMessage;
                    if (forumrecommendsocketresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendsocketresponsemessage.getHotSearchInfoData().bUv();
                    }
                } else if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage = (forumRecommendHttpResponseMessage) responsedMessage;
                    if (forumrecommendhttpresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendhttpresponsemessage.getHotSearchInfoData().bUv();
                    }
                }
                if (TextUtils.isEmpty(str)) {
                    str = c.this.mContext.getResources().getString(R.string.enter_forum_search_tip);
                }
                TbSingleton.getInstance().setHotSearch(str);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921396));
            }
        };
        this.hjf = new CustomMessageListener(2001630) { // from class: com.baidu.tieba.enterForum.home.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        c.this.bxm();
                    } else {
                        c.this.bxn();
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
                c.this.tI(i);
                if (c.this.hiS != null && c.this.hiS.size() > i) {
                    if (c.this.hiZ != null) {
                        c.this.hiZ.bWS();
                    }
                    EnterForumTabPagerAdapter.a aVar = (EnterForumTabPagerAdapter.a) c.this.hiS.get(i);
                    if (aVar != null && aVar.fragment != null) {
                        if (aVar.fragment instanceof EnterForumFragment) {
                            z = ((EnterForumFragment) aVar.fragment).bVj();
                        } else if (aVar.fragment instanceof EnterForumTabFeedFragment) {
                            s.bRL().mH(false);
                            boolean bVj = ((EnterForumTabFeedFragment) aVar.fragment).bVj();
                            TiebaStatic.log(new ap("c13366").ah("obj_locate", 3).dn("resource_id", ((EnterForumTabFeedFragment) aVar.fragment).getTabName()));
                            z = bVj;
                        } else {
                            z = true;
                        }
                        if (!z) {
                            c.this.bxm();
                        } else {
                            c.this.bxn();
                        }
                        if (i == 0) {
                            TiebaStatic.log(new ap("c13366").ah("obj_locate", 1));
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
        this.hiM = enterForumTabFragment;
        this.hiM.registerListener(this.hje);
        this.hiM.registerListener(this.hjf);
        this.mNavHeight = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds228);
        this.hja = UtilHelper.getStatusBarHeight() + l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds229);
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            al(bundle);
            am(bundle);
            an(bundle);
            this.fsB = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.fsB.a(this);
        }
    }

    private void al(Bundle bundle) {
        this.hiQ = (PullLeftViewPager) this.mRootView.findViewById(R.id.enter_forum_viewpager);
        EnterForumTabPagerAdapter.a aVar = new EnterForumTabPagerAdapter.a();
        aVar.fragment = new EnterForumFragment();
        aVar.title = this.hiM.getResources().getString(R.string.my_forum);
        ((EnterForumFragment) aVar.fragment).setTabViewController(this);
        this.hiS = new ArrayList();
        this.hiS.add(aVar);
        this.hiR = new EnterForumTabPagerAdapter(this.hiM.getActivity().getSupportFragmentManager(), this.hiS);
        this.hiQ.setAdapter(this.hiR);
        this.hiQ.setOffscreenPageLimit(this.hiS.size());
    }

    public void afA() {
    }

    private void am(Bundle bundle) {
        this.hiN = (LinearLayout) LayoutInflater.from(this.hiM.getContext()).inflate(R.layout.enter_forum_tab_layout, (ViewGroup) null);
        this.hiO = (ForumHeaderView) this.hiN.findViewById(R.id.recommend_forum_header_serch_view);
        this.hiO.setFrom(0);
        this.hiO.onChangeSkinType();
        this.hiP = (NewPagerSlidingTabBaseStrip) this.hiN.findViewById(R.id.tab_layout);
        this.hiP.setDefaultSelectorColorResourceId(R.color.cp_cont_b);
        this.hiP.setRectPaintColor(R.color.cp_link_tip_a);
        this.hiP.a(l.getDimens(this.hiM.getContext(), R.dimen.tbds46), l.getDimens(this.hiM.getContext(), R.dimen.tbds46), l.getDimens(this.hiM.getContext(), R.dimen.tbds10), l.getDimens(this.hiM.getContext(), R.dimen.tbds46), true);
        this.hiP.setmIndicatorWidth(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds42));
        this.hiP.setIndicatorOvershot(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds8));
        this.hiP.setIndicatorRadius(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds8));
        this.hiP.setIndicatorMarginBottom(l.getDimens(this.hiM.getContext(), R.dimen.tbds0));
        this.hiP.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        this.hiP.setTabPadding(l.getDimens(this.hiM.getContext(), R.dimen.tbds36), 0, l.getDimens(this.hiM.getContext(), R.dimen.tbds36), 0);
        this.hiP.setViewPager(this.hiQ);
        this.hiP.setOnPageChangeListener(this.mOnPageChangeListener);
        this.hiW = this.hiN.findViewById(R.id.enter_forum_tab_left_grandient);
        this.hiV = this.hiN.findViewById(R.id.enter_forum_tab_right_grandient);
    }

    private void an(Bundle bundle) {
        this.hiX = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.hiX.setNavHeight(this.mNavHeight);
        this.hiX.hideBottomLine();
        this.hiY = this.mRootView.findViewById(R.id.divider_shadow);
        tJ(0);
        this.hiU = (ImageView) this.hiN.findViewById(R.id.navigationBarGoSignall);
        this.hiU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.CheckFile("scan_flag") && ad.checkCamera(c.this.mContext.getPageActivity())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new QRCodeScanActivityConfig(c.this.mContext.getPageActivity())));
                } else if (!TbadkCoreApplication.isLogin()) {
                    bf.skipToLoginActivity(c.this.getPageContext().getPageActivity());
                } else {
                    c.this.hiM.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(c.this.getPageContext().getPageActivity())));
                }
            }
        });
        if (this.hiP != null) {
            this.hiX.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, this.hiN, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.hiN.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(3);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(3);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 3;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.hiP.setPadding(this.hiP.getPaddingLeft(), this.hiP.getPaddingTop(), this.hiP.getPaddingRight(), this.hiP.getBottom());
        }
    }

    public void a(NewPagerSlidingTabBaseStrip.a aVar) {
        if (this.hiP != null && aVar != null) {
            this.hiP.setOnTabItemClickListener(aVar);
        }
    }

    public boolean tH(int i) {
        if (i < 0 || i > this.hiS.size()) {
            return false;
        }
        this.hiQ.setCurrentItem(i, true);
        return true;
    }

    public void EV(String str) {
        this.hjb = str;
    }

    public int EW(String str) {
        if (StringUtils.isNull(str) || this.hiS == null || this.hiS.size() <= 0) {
            return -1;
        }
        int i = -1;
        for (int i2 = 0; i2 < this.hiS.size(); i2++) {
            if (str.equals(this.hiS.get(i2).tabName)) {
                i = i2;
            }
        }
        if (i == -1 && this.hiM.getResources().getString(R.string.my_forum).equals(str)) {
            return 0;
        }
        return i;
    }

    public boolean bVs() {
        return this.hjd;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        tI(this.hiQ.getCurrentItem());
        if (this.fsB != null) {
            this.fsB.onChangeSkinType(getPageContext(), i);
        }
        if (this.hiS != null && this.hiS.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.hiS.size()) {
                    break;
                }
                EnterForumTabPagerAdapter.a aVar = this.hiS.get(i3);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            }
        }
        ao.setBackgroundResource(this.hiY, R.drawable.personalize_tab_shadow);
        this.hiP.onChangeSkinType();
        this.hiO.onChangeSkinType();
        ao.a(this.hiW, R.color.cp_bg_line_h, GradientDrawable.Orientation.LEFT_RIGHT);
        ao.a(this.hiV, R.color.cp_bg_line_h, GradientDrawable.Orientation.RIGHT_LEFT);
    }

    public void bVt() {
        tI(this.hiQ.getCurrentItem());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, float f, int i2) {
        if (this.hiX != null) {
            if (i == 0) {
                if (i2 == 0) {
                    tI(i);
                } else if (this.hgv != null && this.hgv.hgX && this.hgv.hgZ > 0) {
                    if (this.hiZ != null && this.hiZ.getRefreshView() != null && this.hiZ.getRefreshView().isViewAttached()) {
                        ao.setBackgroundColor(this.hiX.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
                        return;
                    }
                    this.hiX.setBackgroundColor(0);
                    ao.a(this.hiX.getBarBgView(), R.color.cp_bg_line_h, f, TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (i2 == 0) {
                tI(i);
            } else if (this.hgv != null && this.hgv.hgX && this.hgv.hgZ > 0) {
                if (this.hiZ != null && this.hiZ.getRefreshView() != null && this.hiZ.getRefreshView().isViewAttached()) {
                    ao.setBackgroundColor(this.hiX.getBarBgView(), R.color.cp_bg_line_d, TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.hiX.setBackgroundColor(0);
                ao.a(this.hiX.getBarBgView(), R.color.cp_bg_line_d, 1.0f - f, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tI(int i) {
        int i2;
        if (this.hiU != null) {
            if (i == 0) {
                if (this.hgv != null && this.hgv.hgX && this.hgv.hgZ > 0) {
                    if (this.hiZ != null && this.hiZ.getRefreshView() != null && this.hiZ.getRefreshView().isViewAttached()) {
                        SvgManager.baR().a(this.hiU, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    } else if (this.hgv.hha > 0 && this.hgv.hgZ > this.hgv.hha / 2) {
                        SvgManager.baR().a(this.hiU, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    } else {
                        SvgManager.baR().a(this.hiU, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    }
                } else {
                    SvgManager.baR().a(this.hiU, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
            } else {
                SvgManager.baR().a(this.hiU, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
        if (this.hiX != null) {
            this.hiX.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            if (i == 0) {
                if (this.hgv != null && this.hgv.hgX && this.hgv.hgZ > 0) {
                    if (this.hiZ != null && this.hiZ.getRefreshView() != null && this.hiZ.getRefreshView().isViewAttached()) {
                        ao.setBackgroundColor(this.hiX.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
                    } else {
                        if (this.hgv.hha > 0) {
                            int i3 = (this.hgv.hgZ * 255) / this.hgv.hha;
                            i2 = 255 - (i3 <= 255 ? i3 : 255);
                        } else {
                            i2 = 0;
                        }
                        this.hiX.setBackgroundColor(0);
                        ao.a(this.hiX.getBarBgView(), R.color.cp_bg_line_d, i2 / 255.0f, TbadkCoreApplication.getInst().getSkinType());
                    }
                } else {
                    ao.setBackgroundColor(this.hiX.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
                }
            } else {
                ao.setBackgroundColor(this.hiX.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
            }
        }
        if (i == 0) {
            if (this.hgv != null && this.hgv.hgX && this.hgv.hgZ > 0) {
                if (this.hgv.hha > 0 && this.hgv.hgZ > this.hgv.hha / 2) {
                    if (this.hiZ != null && this.hiZ.getRefreshView() != null && this.hiZ.getRefreshView().isViewAttached()) {
                        this.hiP.setWhiteStyle(false);
                    } else {
                        this.hiP.setWhiteStyle(true);
                    }
                } else {
                    this.hiP.setWhiteStyle(false);
                }
            } else {
                this.hiP.setWhiteStyle(false);
            }
        } else {
            this.hiP.setWhiteStyle(false);
        }
        if (i == 0) {
            this.hiO.setAdState(this.hgv);
        } else {
            this.hiO.setAdState(null);
        }
        if (i == 0 && TbadkCoreApplication.getInst().getSkinType() != 1 && this.hiM.isPrimary() && this.hgv != null && this.hgv.hgX && i == 0) {
            if (this.hgv.hgZ > this.hgv.hha / 2) {
                if (this.hiT != null && this.hiT.hgZ <= this.hgv.hha / 2) {
                    aq.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
                }
            } else if (this.hiT != null && this.hiT.hgZ >= this.hgv.hha / 2) {
                aq.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            }
        }
    }

    public void bVu() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
            aq.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
        } else if (this.hiQ.getCurrentItem() == 0 && this.hiM.isPrimary()) {
            if (this.hiZ != null && this.hiZ.getRefreshView() != null && this.hiZ.getRefreshView().isViewAttached()) {
                aq.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            } else if (this.hgv != null && this.hgv.hgX) {
                if (this.hgv.hgZ > this.hgv.hha / 2 || this.hgv.hgZ == 0) {
                    aq.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
                } else {
                    aq.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
                }
            } else {
                aq.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            }
        } else {
            aq.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.hiS != null && this.hiS.size() > 0 && this.hiQ != null) {
            EnterForumTabPagerAdapter.a aVar = this.hiS.get(this.hiQ.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void VJ() {
        if (this.hiM != null && this.hiS != null && this.hiQ != null && this.hiR != null) {
            FragmentManager supportFragmentManager = this.hiM.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.hiS.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.hiQ.getId(), this.hiR.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.fsB != null) {
            this.fsB.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.hiR != null) {
            this.hiR.setPrimary(z);
        }
        if (this.hiS != null && this.hiS.size() > 0 && this.hiQ != null) {
            EnterForumTabPagerAdapter.a aVar = this.hiS.get(this.hiQ.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.hiS != null && this.hiS.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.hiS.size()) {
                    break;
                }
                EnterForumTabPagerAdapter.a aVar = this.hiS.get(i2);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof NoNetworkView.a)) {
                    ((NoNetworkView.a) aVar.fragment).onNetworkChange(z);
                }
                i = i2 + 1;
            }
        }
        tI(this.hiQ.getCurrentItem());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxm() {
        if (this.hiN != null && this.hiN.getPaddingTop() < 0) {
            bVv();
        } else if (this.hiY != null) {
            this.hiY.clearAnimation();
            if (this.hiY.getVisibility() != 0) {
                this.hiY.setVisibility(0);
                if (this.fuT == null) {
                    this.fuT = new AlphaAnimation(0.0f, 1.0f);
                    this.fuT.setFillAfter(true);
                    this.fuT.setDuration(300L);
                }
                this.hiY.startAnimation(this.fuT);
            }
        }
    }

    public void bxn() {
        if (this.hiY != null && this.hiY.getVisibility() != 8) {
            if (this.fuU == null) {
                this.fuU = new AlphaAnimation(1.0f, 0.0f);
                this.fuU.setFillAfter(true);
                this.fuU.setDuration(300L);
                this.fuU.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.enterForum.home.c.5
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.hiY.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.hiY.startAnimation(this.fuU);
        }
    }

    private void bVv() {
        if (this.hiY != null && this.hiY.getVisibility() != 8) {
            this.hiY.clearAnimation();
            this.hiY.setVisibility(8);
        }
    }

    public void a(com.baidu.tieba.enterForum.view.b bVar) {
        this.hiZ = bVar;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.hiT = this.hgv;
        this.hgv = cVar;
        this.hiO.setAdState(cVar);
        tI(this.hiQ.getCurrentItem());
    }

    public void setSearchHint(String str) {
        this.hiO.setSearchHint(str);
    }

    public View getRootView() {
        return getPageContext().getPageActivity().getWindow().getDecorView();
    }

    public View bVw() {
        return this.hiN;
    }

    public String getCurrentPageKey() {
        if (this.hiR != null) {
            return this.hiR.getCurrentPageKey();
        }
        return null;
    }

    private void tJ(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hiY.getLayoutParams();
        layoutParams.topMargin = this.hja + i;
        this.hiY.setLayoutParams(layoutParams);
    }

    public void a(j jVar, boolean z) {
        int i = 0;
        if (!this.hiM.getActivity().getSupportFragmentManager().isDestroyed()) {
            this.hjd = true;
            if (this.hjc == null || !this.hjc.b(jVar)) {
                bVy();
                this.hiS.clear();
                this.hiS.add(this.hiS.get(0));
                Iterator<i> it = jVar.bUL().iterator();
                while (it.hasNext()) {
                    i next = it.next();
                    EnterForumTabPagerAdapter.a aVar = new EnterForumTabPagerAdapter.a();
                    aVar.fragment = new EnterForumTabFeedFragment();
                    aVar.title = next.getTabName();
                    if (z) {
                        if (this.hjc == null) {
                            aVar.hiL = true;
                        } else {
                            aVar.hiL = this.hjc.b(next);
                        }
                    }
                    aVar.tabName = next.getTabName();
                    Bundle bundle = new Bundle();
                    bundle.putString("tab_code", next.bUK());
                    bundle.putString("tab_name", next.getTabName());
                    aVar.fragment.setArguments(bundle);
                    this.hiS.add(aVar);
                }
                this.hjc = jVar;
                this.hiP.notifyDataSetChanged();
                this.hiR.notifyDataSetChanged();
                this.hiQ.setOffscreenPageLimit(this.hiS.size());
                bVx();
            } else if (jVar != null && this.hjc != null && x.getCount(this.hiS) - 1 == x.getCount(jVar.bUL())) {
                if (z) {
                    while (true) {
                        int i2 = i;
                        if (i2 >= jVar.bUL().size()) {
                            break;
                        }
                        if (this.hiS.get(i2 + 1) != null && jVar.bUL().get(i2) != null) {
                            this.hiS.get(i2 + 1).hiL = this.hjc.b(jVar.bUL().get(i2));
                        }
                        i = i2 + 1;
                    }
                }
                this.hjc = jVar;
                this.hiP.notifyDataSetChanged();
                bVx();
            }
        }
    }

    private void bVx() {
        if (TextUtils.isEmpty(this.hjb)) {
            if (this.hiM.getActivity() != null && this.hiM.getActivity().getIntent() != null) {
                Intent intent = this.hiM.getActivity().getIntent();
                if (intent.hasExtra("sub_locate_type")) {
                    String stringExtra = intent.getStringExtra("sub_locate_type");
                    intent.removeExtra("sub_locate_type");
                    int EW = EW(stringExtra);
                    if (EW != -1) {
                        tH(EW);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        int EW2 = EW(this.hjb);
        if (EW2 == -1) {
            EW2 = 0;
        }
        if (tH(EW2)) {
            Intent intent2 = getPageContext().getPageActivity().getIntent();
            if (intent2 != null) {
                intent2.removeExtra("sub_locate_type");
                intent2.removeExtra("is_from_scheme");
            }
            this.hjb = null;
        }
    }

    private void bVy() {
        if (this.hiR != null && this.hiS != null) {
            try {
                FragmentManager supportFragmentManager = this.hiM.getActivity().getSupportFragmentManager();
                if (!supportFragmentManager.isDestroyed()) {
                    FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                    for (int i = 1; i < this.hiS.size(); i++) {
                        Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.hiQ.getId(), this.hiR.getItemId(i)));
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

    public int bVz() {
        return this.hiQ.getCurrentItem();
    }

    public void tK(int i) {
        if (i == 0) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001631, getPageContext().getUniqueId()));
        } else if (x.getItem(this.hiS, i) != null && (this.hiS.get(i).fragment instanceof EnterForumTabFeedFragment)) {
            ((EnterForumTabFeedFragment) this.hiS.get(i).fragment).nh(true);
        }
    }

    public String tL(int i) {
        EnterForumTabPagerAdapter.a aVar = (EnterForumTabPagerAdapter.a) x.getItem(this.hiS, i);
        return (aVar == null || !(aVar.fragment instanceof EnterForumTabFeedFragment)) ? "" : ((EnterForumTabFeedFragment) aVar.fragment).getTabName();
    }
}
