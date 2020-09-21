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
/* loaded from: classes21.dex */
public class c extends com.baidu.adp.base.c implements NoNetworkView.a {
    private NoNetworkView fHl;
    private AlphaAnimation fJC;
    private AlphaAnimation fJD;
    private com.baidu.tieba.enterForum.data.c hAz;
    private EnterForumTabFragment hCU;
    private LinearLayout hCV;
    private ForumHeaderView hCW;
    private NewPagerSlidingTabBaseStrip hCX;
    private PullLeftViewPager hCY;
    private EnterForumTabPagerAdapter hCZ;
    private List<EnterForumTabPagerAdapter.a> hDa;
    private com.baidu.tieba.enterForum.data.c hDb;
    private ImageView hDc;
    private View hDd;
    private View hDe;
    private NavigationBar hDf;
    private View hDg;
    private com.baidu.tieba.enterForum.view.b hDh;
    private int hDi;
    private String hDj;
    private boolean hDk;
    private com.baidu.adp.framework.listener.a hDl;
    private CustomMessageListener hDm;
    private int mNavHeight;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private View mRootView;

    public c(EnterForumTabFragment enterForumTabFragment) {
        super(enterForumTabFragment.getPageContext());
        this.hDk = false;
        this.hDl = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.enterForum.home.c.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String str = "";
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage = (forumRecommendSocketResponseMessage) responsedMessage;
                    if (forumrecommendsocketresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendsocketresponsemessage.getHotSearchInfoData().chW();
                    }
                } else if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage = (forumRecommendHttpResponseMessage) responsedMessage;
                    if (forumrecommendhttpresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendhttpresponsemessage.getHotSearchInfoData().chW();
                    }
                }
                if (TextUtils.isEmpty(str)) {
                    str = c.this.mContext.getResources().getString(R.string.enter_forum_search_tip);
                }
                TbSingleton.getInstance().setHotSearch(str);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921396));
            }
        };
        this.hDm = new CustomMessageListener(2001630) { // from class: com.baidu.tieba.enterForum.home.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        c.this.bHC();
                    } else {
                        c.this.bHD();
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
                c.this.wx(i);
                if (c.this.hDa != null && c.this.hDa.size() > i) {
                    if (c.this.hDh != null) {
                        c.this.hDh.ckv();
                    }
                    EnterForumTabPagerAdapter.a aVar = (EnterForumTabPagerAdapter.a) c.this.hDa.get(i);
                    if (aVar != null && aVar.fragment != null) {
                        if (aVar.fragment instanceof EnterForumFragment) {
                            z = ((EnterForumFragment) aVar.fragment).ciS();
                        } else if (aVar.fragment instanceof EnterForumTabFeedFragment) {
                            s.cfn().ns(false);
                            boolean ciS = ((EnterForumTabFeedFragment) aVar.fragment).ciS();
                            TiebaStatic.log(new aq("c13366").ai("obj_locate", 3).dF("resource_id", ((EnterForumTabFeedFragment) aVar.fragment).getTabName()));
                            z = ciS;
                        } else {
                            z = true;
                        }
                        if (!z) {
                            c.this.bHC();
                        } else {
                            c.this.bHD();
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
        this.hCU = enterForumTabFragment;
        this.hCU.registerListener(this.hDl);
        this.hCU.registerListener(this.hDm);
        this.mNavHeight = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds228);
        this.hDi = UtilHelper.getStatusBarHeight() + l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds229);
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            ak(bundle);
            al(bundle);
            am(bundle);
            this.fHl = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.fHl.a(this);
        }
    }

    private void ak(Bundle bundle) {
        this.hCY = (PullLeftViewPager) this.mRootView.findViewById(R.id.enter_forum_viewpager);
        EnterForumTabPagerAdapter.a aVar = new EnterForumTabPagerAdapter.a();
        aVar.fragment = new EnterForumFragment();
        aVar.title = this.hCU.getResources().getString(R.string.my_forum);
        ((EnterForumFragment) aVar.fragment).setTabViewController(this);
        this.hDa = new ArrayList();
        this.hDa.add(aVar);
        this.hCZ = new EnterForumTabPagerAdapter(this.hCU.getActivity().getSupportFragmentManager(), this.hDa);
        this.hCY.setAdapter(this.hCZ);
        this.hCY.setOffscreenPageLimit(this.hDa.size());
    }

    public void anr() {
    }

    private void al(Bundle bundle) {
        this.hCV = (LinearLayout) LayoutInflater.from(this.hCU.getContext()).inflate(R.layout.enter_forum_tab_layout, (ViewGroup) null);
        this.hCW = (ForumHeaderView) this.hCV.findViewById(R.id.recommend_forum_header_serch_view);
        this.hCW.setFrom(0);
        this.hCW.onChangeSkinType();
        this.hCX = (NewPagerSlidingTabBaseStrip) this.hCV.findViewById(R.id.tab_layout);
        this.hCX.setDefaultSelectorColorResourceId(R.color.cp_cont_b);
        this.hCX.setRectPaintColor(R.color.cp_link_tip_a);
        this.hCX.a(l.getDimens(this.hCU.getContext(), R.dimen.tbds46), l.getDimens(this.hCU.getContext(), R.dimen.tbds46), l.getDimens(this.hCU.getContext(), R.dimen.tbds10), l.getDimens(this.hCU.getContext(), R.dimen.tbds46), true);
        this.hCX.setmIndicatorWidth(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds42));
        this.hCX.setIndicatorOvershot(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds8));
        this.hCX.setIndicatorRadius(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds8));
        this.hCX.setIndicatorMarginBottom(l.getDimens(this.hCU.getContext(), R.dimen.tbds0));
        this.hCX.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        this.hCX.setTabPadding(l.getDimens(this.hCU.getContext(), R.dimen.tbds36), 0, l.getDimens(this.hCU.getContext(), R.dimen.tbds36), 0);
        this.hCX.setViewPager(this.hCY);
        this.hCX.setOnPageChangeListener(this.mOnPageChangeListener);
        this.hDe = this.hCV.findViewById(R.id.enter_forum_tab_left_grandient);
        this.hDd = this.hCV.findViewById(R.id.enter_forum_tab_right_grandient);
    }

    private void am(Bundle bundle) {
        this.hDf = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.hDf.setNavHeight(this.mNavHeight);
        this.hDf.hideBottomLine();
        this.hDg = this.mRootView.findViewById(R.id.divider_shadow);
        wy(0);
        this.hDc = (ImageView) this.hCV.findViewById(R.id.navigationBarGoSignall);
        this.hDc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.CheckFile("scan_flag") && ae.checkCamera(c.this.mContext.getPageActivity())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new QRCodeScanActivityConfig(c.this.mContext.getPageActivity())));
                } else if (!TbadkCoreApplication.isLogin()) {
                    bg.skipToLoginActivity(c.this.getPageContext().getPageActivity());
                } else {
                    c.this.hCU.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(c.this.getPageContext().getPageActivity())));
                }
            }
        });
        if (this.hCX != null) {
            this.hDf.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, this.hCV, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.hCV.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(3);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(3);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 3;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.hCX.setPadding(this.hCX.getPaddingLeft(), this.hCX.getPaddingTop(), this.hCX.getPaddingRight(), this.hCX.getBottom());
        }
    }

    public void a(NewPagerSlidingTabBaseStrip.a aVar) {
        if (this.hCX != null && aVar != null) {
            this.hCX.setOnTabItemClickListener(aVar);
        }
    }

    public boolean ww(int i) {
        if (i < 0 || i > this.hDa.size()) {
            return false;
        }
        this.hCY.setCurrentItem(i, true);
        return true;
    }

    public void HS(String str) {
        this.hDj = str;
    }

    public int HT(String str) {
        if (StringUtils.isNull(str) || this.hDa == null || this.hDa.size() <= 0) {
            return -1;
        }
        int i = -1;
        for (int i2 = 0; i2 < this.hDa.size(); i2++) {
            if (str.equals(this.hDa.get(i2).tabName)) {
                i = i2;
            }
        }
        if (i == -1 && this.hCU.getResources().getString(R.string.my_forum).equals(str)) {
            return 0;
        }
        return i;
    }

    public boolean cjb() {
        return this.hDk;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        wx(this.hCY.getCurrentItem());
        if (this.fHl != null) {
            this.fHl.onChangeSkinType(getPageContext(), i);
        }
        if (this.hDa != null && this.hDa.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.hDa.size()) {
                    break;
                }
                EnterForumTabPagerAdapter.a aVar = this.hDa.get(i3);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            }
        }
        ap.setBackgroundResource(this.hDg, R.drawable.personalize_tab_shadow);
        this.hCX.onChangeSkinType();
        this.hCW.onChangeSkinType();
        ap.a(this.hDe, R.color.cp_bg_line_h, GradientDrawable.Orientation.LEFT_RIGHT);
        ap.a(this.hDd, R.color.cp_bg_line_h, GradientDrawable.Orientation.RIGHT_LEFT);
    }

    public void cjc() {
        wx(this.hCY.getCurrentItem());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, float f, int i2) {
        if (this.hDf != null) {
            if (i == 0) {
                if (i2 == 0) {
                    wx(i);
                } else if (this.hAz != null && this.hAz.hBb && this.hAz.hBd > 0) {
                    if (this.hDh != null && this.hDh.getRefreshView() != null && this.hDh.getRefreshView().isViewAttached()) {
                        ap.setBackgroundColor(this.hDf.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
                        return;
                    }
                    this.hDf.setBackgroundColor(0);
                    ap.a(this.hDf.getBarBgView(), R.color.cp_bg_line_h, f, TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (i2 == 0) {
                wx(i);
            } else if (this.hAz != null && this.hAz.hBb && this.hAz.hBd > 0) {
                if (this.hDh != null && this.hDh.getRefreshView() != null && this.hDh.getRefreshView().isViewAttached()) {
                    ap.setBackgroundColor(this.hDf.getBarBgView(), R.color.cp_bg_line_d, TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.hDf.setBackgroundColor(0);
                ap.a(this.hDf.getBarBgView(), R.color.cp_bg_line_d, 1.0f - f, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wx(int i) {
        int i2;
        if (this.hDc != null) {
            if (i == 0) {
                if (this.hAz != null && this.hAz.hBb && this.hAz.hBd > 0) {
                    if (this.hDh != null && this.hDh.getRefreshView() != null && this.hDh.getRefreshView().isViewAttached()) {
                        SvgManager.bkl().a(this.hDc, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    } else if (this.hAz.hBe > 0 && this.hAz.hBd > this.hAz.hBe / 2) {
                        SvgManager.bkl().a(this.hDc, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    } else {
                        SvgManager.bkl().a(this.hDc, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    }
                } else {
                    SvgManager.bkl().a(this.hDc, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
            } else {
                SvgManager.bkl().a(this.hDc, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
        if (this.hDf != null) {
            this.hDf.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            if (i == 0) {
                if (this.hAz != null && this.hAz.hBb && this.hAz.hBd > 0) {
                    if (this.hDh != null && this.hDh.getRefreshView() != null && this.hDh.getRefreshView().isViewAttached()) {
                        ap.setBackgroundColor(this.hDf.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
                    } else {
                        if (this.hAz.hBe > 0) {
                            int i3 = (this.hAz.hBd * 255) / this.hAz.hBe;
                            i2 = 255 - (i3 <= 255 ? i3 : 255);
                        } else {
                            i2 = 0;
                        }
                        this.hDf.setBackgroundColor(0);
                        ap.a(this.hDf.getBarBgView(), R.color.cp_bg_line_d, i2 / 255.0f, TbadkCoreApplication.getInst().getSkinType());
                    }
                } else {
                    ap.setBackgroundColor(this.hDf.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
                }
            } else {
                ap.setBackgroundColor(this.hDf.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
            }
        }
        if (i == 0) {
            if (this.hAz != null && this.hAz.hBb && this.hAz.hBd > 0) {
                if (this.hAz.hBe > 0 && this.hAz.hBd > this.hAz.hBe / 2) {
                    if (this.hDh != null && this.hDh.getRefreshView() != null && this.hDh.getRefreshView().isViewAttached()) {
                        this.hCX.setWhiteStyle(false);
                    } else {
                        this.hCX.setWhiteStyle(true);
                    }
                } else {
                    this.hCX.setWhiteStyle(false);
                }
            } else {
                this.hCX.setWhiteStyle(false);
            }
        } else {
            this.hCX.setWhiteStyle(false);
        }
        if (i == 0) {
            this.hCW.setAdState(this.hAz);
        } else {
            this.hCW.setAdState(null);
        }
        if (i == 0 && TbadkCoreApplication.getInst().getSkinType() != 1 && this.hCU.isPrimary() && this.hAz != null && this.hAz.hBb && i == 0) {
            if (this.hAz.hBd > this.hAz.hBe / 2) {
                if (this.hDb != null && this.hDb.hBd <= this.hAz.hBe / 2) {
                    ar.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
                }
            } else if (this.hDb != null && this.hDb.hBd >= this.hAz.hBe / 2) {
                ar.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            }
        }
    }

    public void cjd() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
            ar.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
        } else if (this.hCY.getCurrentItem() == 0 && this.hCU.isPrimary()) {
            if (this.hDh != null && this.hDh.getRefreshView() != null && this.hDh.getRefreshView().isViewAttached()) {
                ar.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            } else if (this.hAz != null && this.hAz.hBb) {
                if (this.hAz.hBd > this.hAz.hBe / 2 || this.hAz.hBd == 0) {
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
        if (this.hDa != null && this.hDa.size() > 0 && this.hCY != null) {
            EnterForumTabPagerAdapter.a aVar = this.hDa.get(this.hCY.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void acy() {
        if (this.hCU != null && this.hDa != null && this.hCY != null && this.hCZ != null) {
            FragmentManager supportFragmentManager = this.hCU.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.hDa.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.hCY.getId(), this.hCZ.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.fHl != null) {
            this.fHl.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.hCZ != null) {
            this.hCZ.setPrimary(z);
        }
        if (this.hDa != null && this.hDa.size() > 0 && this.hCY != null) {
            EnterForumTabPagerAdapter.a aVar = this.hDa.get(this.hCY.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.hDa != null && this.hDa.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.hDa.size()) {
                    break;
                }
                EnterForumTabPagerAdapter.a aVar = this.hDa.get(i2);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof NoNetworkView.a)) {
                    ((NoNetworkView.a) aVar.fragment).onNetworkChange(z);
                }
                i = i2 + 1;
            }
        }
        wx(this.hCY.getCurrentItem());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHC() {
        if (this.hCV != null && this.hCV.getPaddingTop() < 0) {
            cje();
        } else if (this.hDg != null) {
            this.hDg.clearAnimation();
            if (this.hDg.getVisibility() != 0) {
                this.hDg.setVisibility(0);
                if (this.fJC == null) {
                    this.fJC = new AlphaAnimation(0.0f, 1.0f);
                    this.fJC.setFillAfter(true);
                    this.fJC.setDuration(300L);
                }
                this.hDg.startAnimation(this.fJC);
            }
        }
    }

    public void bHD() {
        if (this.hDg != null && this.hDg.getVisibility() != 8) {
            if (this.fJD == null) {
                this.fJD = new AlphaAnimation(1.0f, 0.0f);
                this.fJD.setFillAfter(true);
                this.fJD.setDuration(300L);
                this.fJD.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.enterForum.home.c.5
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.hDg.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.hDg.startAnimation(this.fJD);
        }
    }

    private void cje() {
        if (this.hDg != null && this.hDg.getVisibility() != 8) {
            this.hDg.clearAnimation();
            this.hDg.setVisibility(8);
        }
    }

    public void a(com.baidu.tieba.enterForum.view.b bVar) {
        this.hDh = bVar;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.hDb = this.hAz;
        this.hAz = cVar;
        this.hCW.setAdState(cVar);
        wx(this.hCY.getCurrentItem());
    }

    public void setSearchHint(String str) {
        this.hCW.setSearchHint(str);
    }

    public View getRootView() {
        return getPageContext().getPageActivity().getWindow().getDecorView();
    }

    public View cjf() {
        return this.hCV;
    }

    public String getCurrentPageKey() {
        if (this.hCZ != null) {
            return this.hCZ.getCurrentPageKey();
        }
        return null;
    }

    private void wy(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hDg.getLayoutParams();
        layoutParams.topMargin = this.hDi + i;
        this.hDg.setLayoutParams(layoutParams);
    }

    public int cjg() {
        return this.hCY.getCurrentItem();
    }

    public void wz(int i) {
        if (i == 0) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001631, getPageContext().getUniqueId()));
        } else if (y.getItem(this.hDa, i) != null && (this.hDa.get(i).fragment instanceof EnterForumTabFeedFragment)) {
            ((EnterForumTabFeedFragment) this.hDa.get(i).fragment).nT(true);
        }
    }

    public String wA(int i) {
        EnterForumTabPagerAdapter.a aVar = (EnterForumTabPagerAdapter.a) y.getItem(this.hDa, i);
        return (aVar == null || !(aVar.fragment instanceof EnterForumTabFeedFragment)) ? "" : ((EnterForumTabFeedFragment) aVar.fragment).getTabName();
    }
}
