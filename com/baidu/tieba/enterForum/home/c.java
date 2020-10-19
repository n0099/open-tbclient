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
/* loaded from: classes22.dex */
public class c extends com.baidu.adp.base.c implements NoNetworkView.a {
    private NoNetworkView fTu;
    private AlphaAnimation fVT;
    private AlphaAnimation fVU;
    private com.baidu.tieba.enterForum.data.c hPu;
    private EnterForumTabFragment hRQ;
    private LinearLayout hRR;
    private ForumHeaderView hRS;
    private NewPagerSlidingTabBaseStrip hRT;
    private PullLeftViewPager hRU;
    private EnterForumTabPagerAdapter hRV;
    private List<EnterForumTabPagerAdapter.a> hRW;
    private com.baidu.tieba.enterForum.data.c hRX;
    private ImageView hRY;
    private View hRZ;
    private View hSa;
    private NavigationBar hSb;
    private View hSc;
    private com.baidu.tieba.enterForum.view.b hSd;
    private int hSe;
    private String hSf;
    private boolean hSg;
    private com.baidu.adp.framework.listener.a hSh;
    private CustomMessageListener hSi;
    private int mNavHeight;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private View mRootView;

    public c(EnterForumTabFragment enterForumTabFragment) {
        super(enterForumTabFragment.getPageContext());
        this.hSg = false;
        this.hSh = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.enterForum.home.c.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String str = "";
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage = (forumRecommendSocketResponseMessage) responsedMessage;
                    if (forumrecommendsocketresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendsocketresponsemessage.getHotSearchInfoData().cls();
                    }
                } else if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage = (forumRecommendHttpResponseMessage) responsedMessage;
                    if (forumrecommendhttpresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendhttpresponsemessage.getHotSearchInfoData().cls();
                    }
                }
                if (TextUtils.isEmpty(str)) {
                    str = c.this.mContext.getResources().getString(R.string.enter_forum_search_tip);
                }
                TbSingleton.getInstance().setHotSearch(str);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921396));
            }
        };
        this.hSi = new CustomMessageListener(2001630) { // from class: com.baidu.tieba.enterForum.home.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        c.this.bKo();
                    } else {
                        c.this.bKp();
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
                c.this.xd(i);
                if (c.this.hRW != null && c.this.hRW.size() > i) {
                    if (c.this.hSd != null) {
                        c.this.hSd.cnR();
                    }
                    EnterForumTabPagerAdapter.a aVar = (EnterForumTabPagerAdapter.a) c.this.hRW.get(i);
                    if (aVar != null && aVar.fragment != null) {
                        if (aVar.fragment instanceof EnterForumFragment) {
                            z = ((EnterForumFragment) aVar.fragment).cmo();
                        } else if (aVar.fragment instanceof EnterForumTabFeedFragment) {
                            s.ciJ().nX(false);
                            boolean cmo = ((EnterForumTabFeedFragment) aVar.fragment).cmo();
                            TiebaStatic.log(new aq("c13366").aj("obj_locate", 3).dK("resource_id", ((EnterForumTabFeedFragment) aVar.fragment).getTabName()));
                            z = cmo;
                        } else {
                            z = true;
                        }
                        if (!z) {
                            c.this.bKo();
                        } else {
                            c.this.bKp();
                        }
                        if (i == 0) {
                            TiebaStatic.log(new aq("c13366").aj("obj_locate", 1));
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
        this.hRQ = enterForumTabFragment;
        this.hRQ.registerListener(this.hSh);
        this.hRQ.registerListener(this.hSi);
        this.mNavHeight = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds228);
        this.hSe = UtilHelper.getStatusBarHeight() + l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds229);
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            ak(bundle);
            al(bundle);
            am(bundle);
            this.fTu = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.fTu.a(this);
        }
    }

    private void ak(Bundle bundle) {
        this.hRU = (PullLeftViewPager) this.mRootView.findViewById(R.id.enter_forum_viewpager);
        EnterForumTabPagerAdapter.a aVar = new EnterForumTabPagerAdapter.a();
        aVar.fragment = new EnterForumFragment();
        aVar.title = this.hRQ.getResources().getString(R.string.my_forum);
        ((EnterForumFragment) aVar.fragment).setTabViewController(this);
        this.hRW = new ArrayList();
        this.hRW.add(aVar);
        this.hRV = new EnterForumTabPagerAdapter(this.hRQ.getActivity().getSupportFragmentManager(), this.hRW);
        this.hRU.setAdapter(this.hRV);
        this.hRU.setOffscreenPageLimit(this.hRW.size());
    }

    public void aqd() {
    }

    private void al(Bundle bundle) {
        this.hRR = (LinearLayout) LayoutInflater.from(this.hRQ.getContext()).inflate(R.layout.enter_forum_tab_layout, (ViewGroup) null);
        this.hRS = (ForumHeaderView) this.hRR.findViewById(R.id.recommend_forum_header_serch_view);
        this.hRS.setFrom(0);
        this.hRS.onChangeSkinType();
        this.hRT = (NewPagerSlidingTabBaseStrip) this.hRR.findViewById(R.id.tab_layout);
        this.hRT.setDefaultSelectorColorResourceId(R.color.cp_cont_b);
        this.hRT.setRectPaintColor(R.color.cp_link_tip_a);
        this.hRT.a(l.getDimens(this.hRQ.getContext(), R.dimen.tbds46), l.getDimens(this.hRQ.getContext(), R.dimen.tbds46), l.getDimens(this.hRQ.getContext(), R.dimen.tbds10), l.getDimens(this.hRQ.getContext(), R.dimen.tbds46), true);
        this.hRT.setmIndicatorWidth(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds42));
        this.hRT.setIndicatorOvershot(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds8));
        this.hRT.setIndicatorRadius(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds8));
        this.hRT.setIndicatorMarginBottom(l.getDimens(this.hRQ.getContext(), R.dimen.tbds0));
        this.hRT.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        this.hRT.setTabPadding(l.getDimens(this.hRQ.getContext(), R.dimen.tbds36), 0, l.getDimens(this.hRQ.getContext(), R.dimen.tbds36), 0);
        this.hRT.setViewPager(this.hRU);
        this.hRT.setOnPageChangeListener(this.mOnPageChangeListener);
        this.hSa = this.hRR.findViewById(R.id.enter_forum_tab_left_grandient);
        this.hRZ = this.hRR.findViewById(R.id.enter_forum_tab_right_grandient);
    }

    private void am(Bundle bundle) {
        this.hSb = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.hSb.setNavHeight(this.mNavHeight);
        this.hSb.hideBottomLine();
        this.hSc = this.mRootView.findViewById(R.id.divider_shadow);
        xe(0);
        this.hRY = (ImageView) this.hRR.findViewById(R.id.navigationBarGoSignall);
        this.hRY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.CheckFile("scan_flag") && ae.checkCamera(c.this.mContext.getPageActivity())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new QRCodeScanActivityConfig(c.this.mContext.getPageActivity())));
                } else if (!TbadkCoreApplication.isLogin()) {
                    bg.skipToLoginActivity(c.this.getPageContext().getPageActivity());
                } else {
                    c.this.hRQ.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(c.this.getPageContext().getPageActivity())));
                }
            }
        });
        if (this.hRT != null) {
            this.hSb.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, this.hRR, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.hRR.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(3);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(3);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 3;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.hRT.setPadding(this.hRT.getPaddingLeft(), this.hRT.getPaddingTop(), this.hRT.getPaddingRight(), this.hRT.getBottom());
        }
    }

    public void a(NewPagerSlidingTabBaseStrip.a aVar) {
        if (this.hRT != null && aVar != null) {
            this.hRT.setOnTabItemClickListener(aVar);
        }
    }

    public boolean xc(int i) {
        if (i < 0 || i > this.hRW.size()) {
            return false;
        }
        this.hRU.setCurrentItem(i, true);
        return true;
    }

    public void IF(String str) {
        this.hSf = str;
    }

    public int IG(String str) {
        if (StringUtils.isNull(str) || this.hRW == null || this.hRW.size() <= 0) {
            return -1;
        }
        int i = -1;
        for (int i2 = 0; i2 < this.hRW.size(); i2++) {
            if (str.equals(this.hRW.get(i2).tabName)) {
                i = i2;
            }
        }
        if (i == -1 && this.hRQ.getResources().getString(R.string.my_forum).equals(str)) {
            return 0;
        }
        return i;
    }

    public boolean cmx() {
        return this.hSg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        xd(this.hRU.getCurrentItem());
        if (this.fTu != null) {
            this.fTu.onChangeSkinType(getPageContext(), i);
        }
        if (this.hRW != null && this.hRW.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.hRW.size()) {
                    break;
                }
                EnterForumTabPagerAdapter.a aVar = this.hRW.get(i3);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            }
        }
        ap.setBackgroundResource(this.hSc, R.drawable.personalize_tab_shadow);
        this.hRT.onChangeSkinType();
        this.hRS.onChangeSkinType();
        ap.a(this.hSa, R.color.cp_bg_line_h, GradientDrawable.Orientation.LEFT_RIGHT);
        ap.a(this.hRZ, R.color.cp_bg_line_h, GradientDrawable.Orientation.RIGHT_LEFT);
    }

    public void cmy() {
        xd(this.hRU.getCurrentItem());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, float f, int i2) {
        if (this.hSb != null) {
            if (i == 0) {
                if (i2 == 0) {
                    xd(i);
                } else if (this.hPu != null && this.hPu.hPW && this.hPu.hPY > 0) {
                    if (this.hSd != null && this.hSd.getRefreshView() != null && this.hSd.getRefreshView().isViewAttached()) {
                        ap.setBackgroundColor(this.hSb.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
                        return;
                    }
                    this.hSb.setBackgroundColor(0);
                    ap.a(this.hSb.getBarBgView(), R.color.cp_bg_line_h, f, TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (i2 == 0) {
                xd(i);
            } else if (this.hPu != null && this.hPu.hPW && this.hPu.hPY > 0) {
                if (this.hSd != null && this.hSd.getRefreshView() != null && this.hSd.getRefreshView().isViewAttached()) {
                    ap.setBackgroundColor(this.hSb.getBarBgView(), R.color.cp_bg_line_d, TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.hSb.setBackgroundColor(0);
                ap.a(this.hSb.getBarBgView(), R.color.cp_bg_line_d, 1.0f - f, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xd(int i) {
        int i2;
        if (this.hRY != null) {
            if (i == 0) {
                if (this.hPu != null && this.hPu.hPW && this.hPu.hPY > 0) {
                    if (this.hSd != null && this.hSd.getRefreshView() != null && this.hSd.getRefreshView().isViewAttached()) {
                        SvgManager.bmU().a(this.hRY, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    } else if (this.hPu.hPZ > 0 && this.hPu.hPY > this.hPu.hPZ / 2) {
                        SvgManager.bmU().a(this.hRY, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    } else {
                        SvgManager.bmU().a(this.hRY, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    }
                } else {
                    SvgManager.bmU().a(this.hRY, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
            } else {
                SvgManager.bmU().a(this.hRY, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
        if (this.hSb != null) {
            this.hSb.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            if (i == 0) {
                if (this.hPu != null && this.hPu.hPW && this.hPu.hPY > 0) {
                    if (this.hSd != null && this.hSd.getRefreshView() != null && this.hSd.getRefreshView().isViewAttached()) {
                        ap.setBackgroundColor(this.hSb.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
                    } else {
                        if (this.hPu.hPZ > 0) {
                            int i3 = (this.hPu.hPY * 255) / this.hPu.hPZ;
                            i2 = 255 - (i3 <= 255 ? i3 : 255);
                        } else {
                            i2 = 0;
                        }
                        this.hSb.setBackgroundColor(0);
                        ap.a(this.hSb.getBarBgView(), R.color.cp_bg_line_d, i2 / 255.0f, TbadkCoreApplication.getInst().getSkinType());
                    }
                } else {
                    ap.setBackgroundColor(this.hSb.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
                }
            } else {
                ap.setBackgroundColor(this.hSb.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
            }
        }
        if (i == 0) {
            if (this.hPu != null && this.hPu.hPW && this.hPu.hPY > 0) {
                if (this.hPu.hPZ > 0 && this.hPu.hPY > this.hPu.hPZ / 2) {
                    if (this.hSd != null && this.hSd.getRefreshView() != null && this.hSd.getRefreshView().isViewAttached()) {
                        this.hRT.setWhiteStyle(false);
                    } else {
                        this.hRT.setWhiteStyle(true);
                    }
                } else {
                    this.hRT.setWhiteStyle(false);
                }
            } else {
                this.hRT.setWhiteStyle(false);
            }
        } else {
            this.hRT.setWhiteStyle(false);
        }
        if (i == 0) {
            this.hRS.setAdState(this.hPu);
        } else {
            this.hRS.setAdState(null);
        }
        if (i == 0 && TbadkCoreApplication.getInst().getSkinType() != 1 && this.hRQ.isPrimary() && this.hPu != null && this.hPu.hPW && i == 0) {
            if (this.hPu.hPY > this.hPu.hPZ / 2) {
                if (this.hRX != null && this.hRX.hPY <= this.hPu.hPZ / 2) {
                    ar.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
                }
            } else if (this.hRX != null && this.hRX.hPY >= this.hPu.hPZ / 2) {
                ar.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            }
        }
    }

    public void cmz() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
            ar.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
        } else if (this.hRU.getCurrentItem() == 0 && this.hRQ.isPrimary()) {
            if (this.hSd != null && this.hSd.getRefreshView() != null && this.hSd.getRefreshView().isViewAttached()) {
                ar.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            } else if (this.hPu != null && this.hPu.hPW) {
                if (this.hPu.hPY > this.hPu.hPZ / 2 || this.hPu.hPY == 0) {
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
        if (this.hRW != null && this.hRW.size() > 0 && this.hRU != null) {
            EnterForumTabPagerAdapter.a aVar = this.hRW.get(this.hRU.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void afk() {
        if (this.hRQ != null && this.hRW != null && this.hRU != null && this.hRV != null) {
            FragmentManager supportFragmentManager = this.hRQ.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.hRW.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.hRU.getId(), this.hRV.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.fTu != null) {
            this.fTu.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.hRV != null) {
            this.hRV.setPrimary(z);
        }
        if (this.hRW != null && this.hRW.size() > 0 && this.hRU != null) {
            EnterForumTabPagerAdapter.a aVar = this.hRW.get(this.hRU.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.hRW != null && this.hRW.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.hRW.size()) {
                    break;
                }
                EnterForumTabPagerAdapter.a aVar = this.hRW.get(i2);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof NoNetworkView.a)) {
                    ((NoNetworkView.a) aVar.fragment).onNetworkChange(z);
                }
                i = i2 + 1;
            }
        }
        xd(this.hRU.getCurrentItem());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKo() {
        if (this.hRR != null && this.hRR.getPaddingTop() < 0) {
            cmA();
        } else if (this.hSc != null) {
            this.hSc.clearAnimation();
            if (this.hSc.getVisibility() != 0) {
                this.hSc.setVisibility(0);
                if (this.fVT == null) {
                    this.fVT = new AlphaAnimation(0.0f, 1.0f);
                    this.fVT.setFillAfter(true);
                    this.fVT.setDuration(300L);
                }
                this.hSc.startAnimation(this.fVT);
            }
        }
    }

    public void bKp() {
        if (this.hSc != null && this.hSc.getVisibility() != 8) {
            if (this.fVU == null) {
                this.fVU = new AlphaAnimation(1.0f, 0.0f);
                this.fVU.setFillAfter(true);
                this.fVU.setDuration(300L);
                this.fVU.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.enterForum.home.c.5
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.hSc.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.hSc.startAnimation(this.fVU);
        }
    }

    private void cmA() {
        if (this.hSc != null && this.hSc.getVisibility() != 8) {
            this.hSc.clearAnimation();
            this.hSc.setVisibility(8);
        }
    }

    public void a(com.baidu.tieba.enterForum.view.b bVar) {
        this.hSd = bVar;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.hRX = this.hPu;
        this.hPu = cVar;
        this.hRS.setAdState(cVar);
        xd(this.hRU.getCurrentItem());
    }

    public void setSearchHint(String str) {
        this.hRS.setSearchHint(str);
    }

    public View getRootView() {
        return getPageContext().getPageActivity().getWindow().getDecorView();
    }

    public View cmB() {
        return this.hRR;
    }

    public String getCurrentPageKey() {
        if (this.hRV != null) {
            return this.hRV.getCurrentPageKey();
        }
        return null;
    }

    private void xe(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hSc.getLayoutParams();
        layoutParams.topMargin = this.hSe + i;
        this.hSc.setLayoutParams(layoutParams);
    }

    public int cmC() {
        return this.hRU.getCurrentItem();
    }

    public void xf(int i) {
        if (i == 0) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001631, getPageContext().getUniqueId()));
        } else if (y.getItem(this.hRW, i) != null && (this.hRW.get(i).fragment instanceof EnterForumTabFeedFragment)) {
            ((EnterForumTabFeedFragment) this.hRW.get(i).fragment).oy(true);
        }
    }

    public String xg(int i) {
        EnterForumTabPagerAdapter.a aVar = (EnterForumTabPagerAdapter.a) y.getItem(this.hRW, i);
        return (aVar == null || !(aVar.fragment instanceof EnterForumTabFeedFragment)) ? "" : ((EnterForumTabFeedFragment) aVar.fragment).getTabName();
    }
}
