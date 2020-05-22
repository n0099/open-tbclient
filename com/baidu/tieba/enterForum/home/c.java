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
import com.baidu.tieba.card.s;
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
    private NoNetworkView fbX;
    private AlphaAnimation fen;
    private AlphaAnimation feo;
    private com.baidu.tieba.enterForum.data.d gNJ;
    private com.baidu.adp.framework.listener.a gQA;
    private CustomMessageListener gQB;
    private EnterForumTabFragment gQi;
    private LinearLayout gQj;
    private ForumHeaderView gQk;
    private NewPagerSlidingTabBaseStrip gQl;
    private PullLeftViewPager gQm;
    private EnterForumTabPagerAdapter gQn;
    private List<EnterForumTabPagerAdapter.a> gQo;
    private com.baidu.tieba.enterForum.data.d gQp;
    private ImageView gQq;
    private View gQr;
    private View gQs;
    private NavigationBar gQt;
    private View gQu;
    private com.baidu.tieba.enterForum.view.b gQv;
    private int gQw;
    private String gQx;
    private p gQy;
    private boolean gQz;
    private int mNavHeight;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private View mRootView;

    public c(EnterForumTabFragment enterForumTabFragment) {
        super(enterForumTabFragment.getPageContext());
        this.gQz = false;
        this.gQA = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.enterForum.home.c.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String str = "";
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage = (forumRecommendSocketResponseMessage) responsedMessage;
                    if (forumrecommendsocketresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendsocketresponsemessage.getHotSearchInfoData().bOa();
                    }
                } else if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage = (forumRecommendHttpResponseMessage) responsedMessage;
                    if (forumrecommendhttpresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendhttpresponsemessage.getHotSearchInfoData().bOa();
                    }
                }
                if (TextUtils.isEmpty(str)) {
                    str = c.this.mContext.getResources().getString(R.string.enter_forum_search_tip);
                }
                TbSingleton.getInstance().setHotSearch(str);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921396));
            }
        };
        this.gQB = new CustomMessageListener(2001630) { // from class: com.baidu.tieba.enterForum.home.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        c.this.bre();
                    } else {
                        c.this.brf();
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
                c.this.sN(i);
                if (c.this.gQo != null && c.this.gQo.size() > i) {
                    if (c.this.gQv != null) {
                        c.this.gQv.bQt();
                    }
                    EnterForumTabPagerAdapter.a aVar = (EnterForumTabPagerAdapter.a) c.this.gQo.get(i);
                    if (aVar != null && aVar.fragment != null) {
                        if (aVar.fragment instanceof EnterForumFragment) {
                            z = ((EnterForumFragment) aVar.fragment).bOM();
                        } else if (aVar.fragment instanceof EnterForumTabFeedFragment) {
                            s.bLq().lT(false);
                            boolean bOM = ((EnterForumTabFeedFragment) aVar.fragment).bOM();
                            TiebaStatic.log(new an("c13366").ag("obj_locate", 3).dh("resource_id", ((EnterForumTabFeedFragment) aVar.fragment).getTabName()));
                            z = bOM;
                        } else {
                            z = true;
                        }
                        if (!z) {
                            c.this.bre();
                        } else {
                            c.this.brf();
                        }
                        if (i == 0) {
                            TiebaStatic.log(new an("c13366").ag("obj_locate", 1));
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
        this.gQi = enterForumTabFragment;
        this.gQi.registerListener(this.gQA);
        this.gQi.registerListener(this.gQB);
        this.mNavHeight = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds228);
        this.gQw = UtilHelper.getStatusBarHeight() + l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds229);
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            ak(bundle);
            al(bundle);
            am(bundle);
            this.fbX = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.fbX.a(this);
        }
    }

    private void ak(Bundle bundle) {
        this.gQm = (PullLeftViewPager) this.mRootView.findViewById(R.id.enter_forum_viewpager);
        EnterForumTabPagerAdapter.a aVar = new EnterForumTabPagerAdapter.a();
        aVar.fragment = new EnterForumFragment();
        aVar.title = this.gQi.getResources().getString(R.string.my_forum);
        ((EnterForumFragment) aVar.fragment).setTabViewController(this);
        this.gQo = new ArrayList();
        this.gQo.add(aVar);
        this.gQn = new EnterForumTabPagerAdapter(this.gQi.getActivity().getSupportFragmentManager(), this.gQo);
        this.gQm.setAdapter(this.gQn);
        this.gQm.setOffscreenPageLimit(this.gQo.size());
    }

    public void adh() {
    }

    private void al(Bundle bundle) {
        this.gQj = (LinearLayout) LayoutInflater.from(this.gQi.getContext()).inflate(R.layout.enter_forum_tab_layout, (ViewGroup) null);
        this.gQk = (ForumHeaderView) this.gQj.findViewById(R.id.recommend_forum_header_serch_view);
        this.gQk.setFrom(0);
        this.gQk.onChangeSkinType();
        this.gQl = (NewPagerSlidingTabBaseStrip) this.gQj.findViewById(R.id.tab_layout);
        this.gQl.setDefaultSelectorColorResourceId(R.color.cp_cont_b);
        this.gQl.setRectPaintColor(R.color.cp_link_tip_a);
        this.gQl.a(l.getDimens(this.gQi.getContext(), R.dimen.tbds46), l.getDimens(this.gQi.getContext(), R.dimen.tbds46), l.getDimens(this.gQi.getContext(), R.dimen.tbds10), l.getDimens(this.gQi.getContext(), R.dimen.tbds46), true);
        this.gQl.setmIndicatorWidth(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds42));
        this.gQl.setIndicatorOvershot(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds8));
        this.gQl.setIndicatorRadius(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds8));
        this.gQl.setIndicatorMarginBottom(l.getDimens(this.gQi.getContext(), R.dimen.tbds0));
        this.gQl.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        this.gQl.setTabPadding(l.getDimens(this.gQi.getContext(), R.dimen.tbds36), 0, l.getDimens(this.gQi.getContext(), R.dimen.tbds36), 0);
        this.gQl.setViewPager(this.gQm);
        this.gQl.setOnPageChangeListener(this.mOnPageChangeListener);
        this.gQs = this.gQj.findViewById(R.id.enter_forum_tab_left_grandient);
        this.gQr = this.gQj.findViewById(R.id.enter_forum_tab_right_grandient);
    }

    private void am(Bundle bundle) {
        this.gQt = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.gQt.setNavHeight(this.mNavHeight);
        this.gQt.hideBottomLine();
        this.gQu = this.mRootView.findViewById(R.id.divider_shadow);
        sO(0);
        this.gQq = (ImageView) this.gQj.findViewById(R.id.navigationBarGoSignall);
        this.gQq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.CheckFile("scan_flag") && ab.checkCamera(c.this.mContext.getPageActivity())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new QRCodeScanActivityConfig(c.this.mContext.getPageActivity())));
                } else if (!TbadkCoreApplication.isLogin()) {
                    bc.skipToLoginActivity(c.this.getPageContext().getPageActivity());
                } else {
                    c.this.gQi.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(c.this.getPageContext().getPageActivity())));
                }
            }
        });
        if (this.gQl != null) {
            this.gQt.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, this.gQj, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.gQj.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(3);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(3);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 3;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.gQl.setPadding(this.gQl.getPaddingLeft(), this.gQl.getPaddingTop(), this.gQl.getPaddingRight(), this.gQl.getBottom());
        }
    }

    public void a(NewPagerSlidingTabBaseStrip.a aVar) {
        if (this.gQl != null && aVar != null) {
            this.gQl.setOnTabItemClickListener(aVar);
        }
    }

    public boolean sM(int i) {
        if (i < 0 || i > this.gQo.size()) {
            return false;
        }
        this.gQm.setCurrentItem(i, true);
        return true;
    }

    public void DJ(String str) {
        this.gQx = str;
    }

    public int DK(String str) {
        if (StringUtils.isNull(str) || this.gQo == null || this.gQo.size() <= 0) {
            return -1;
        }
        int i = -1;
        for (int i2 = 0; i2 < this.gQo.size(); i2++) {
            if (str.equals(this.gQo.get(i2).tabName)) {
                i = i2;
            }
        }
        if (i == -1 && this.gQi.getResources().getString(R.string.my_forum).equals(str)) {
            return 0;
        }
        return i;
    }

    public boolean bOV() {
        return this.gQz;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        sN(this.gQm.getCurrentItem());
        if (this.fbX != null) {
            this.fbX.onChangeSkinType(getPageContext(), i);
        }
        if (this.gQo != null && this.gQo.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.gQo.size()) {
                    break;
                }
                EnterForumTabPagerAdapter.a aVar = this.gQo.get(i3);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            }
        }
        am.setBackgroundResource(this.gQu, R.drawable.personalize_tab_shadow);
        this.gQl.onChangeSkinType();
        this.gQk.onChangeSkinType();
        am.a(this.gQs, R.color.cp_bg_line_h, GradientDrawable.Orientation.LEFT_RIGHT);
        am.a(this.gQr, R.color.cp_bg_line_h, GradientDrawable.Orientation.RIGHT_LEFT);
    }

    public void bOW() {
        sN(this.gQm.getCurrentItem());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, float f, int i2) {
        if (this.gQt != null) {
            if (i == 0) {
                if (i2 == 0) {
                    sN(i);
                } else if (this.gNJ != null && this.gNJ.gOu && this.gNJ.gOw > 0) {
                    if (this.gQv != null && this.gQv.getRefreshView() != null && this.gQv.getRefreshView().isViewAttached()) {
                        am.setBackgroundColor(this.gQt.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
                        return;
                    }
                    this.gQt.setBackgroundColor(0);
                    am.a(this.gQt.getBarBgView(), (int) R.color.cp_bg_line_h, f, TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (i2 == 0) {
                sN(i);
            } else if (this.gNJ != null && this.gNJ.gOu && this.gNJ.gOw > 0) {
                if (this.gQv != null && this.gQv.getRefreshView() != null && this.gQv.getRefreshView().isViewAttached()) {
                    am.setBackgroundColor(this.gQt.getBarBgView(), R.color.cp_bg_line_d, TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.gQt.setBackgroundColor(0);
                am.a(this.gQt.getBarBgView(), (int) R.color.cp_bg_line_d, 1.0f - f, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sN(int i) {
        int i2;
        if (this.gQq != null) {
            if (i == 0) {
                if (this.gNJ != null && this.gNJ.gOu && this.gNJ.gOw > 0) {
                    if (this.gQv != null && this.gQv.getRefreshView() != null && this.gQv.getRefreshView().isViewAttached()) {
                        SvgManager.aUV().a(this.gQq, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    } else if (this.gNJ.gOx > 0 && this.gNJ.gOw > this.gNJ.gOx / 2) {
                        SvgManager.aUV().a(this.gQq, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    } else {
                        SvgManager.aUV().a(this.gQq, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    }
                } else {
                    SvgManager.aUV().a(this.gQq, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
            } else {
                SvgManager.aUV().a(this.gQq, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
        if (this.gQt != null) {
            this.gQt.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            if (i == 0) {
                if (this.gNJ != null && this.gNJ.gOu && this.gNJ.gOw > 0) {
                    if (this.gQv != null && this.gQv.getRefreshView() != null && this.gQv.getRefreshView().isViewAttached()) {
                        am.setBackgroundColor(this.gQt.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
                    } else {
                        if (this.gNJ.gOx > 0) {
                            int i3 = (this.gNJ.gOw * 255) / this.gNJ.gOx;
                            if (i3 > 255) {
                                i3 = 255;
                            }
                            i2 = 255 - i3;
                        } else {
                            i2 = 0;
                        }
                        this.gQt.setBackgroundColor(0);
                        am.a(this.gQt.getBarBgView(), (int) R.color.cp_bg_line_d, i2 / 255.0f, TbadkCoreApplication.getInst().getSkinType());
                    }
                } else {
                    am.setBackgroundColor(this.gQt.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
                }
            } else {
                am.setBackgroundColor(this.gQt.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
            }
        }
        if (i == 0) {
            if (this.gNJ != null && this.gNJ.gOu && this.gNJ.gOw > 0) {
                if (this.gNJ.gOx > 0 && this.gNJ.gOw > this.gNJ.gOx / 2) {
                    if (this.gQv != null && this.gQv.getRefreshView() != null && this.gQv.getRefreshView().isViewAttached()) {
                        this.gQl.setWhiteStyle(false);
                    } else {
                        this.gQl.setWhiteStyle(true);
                    }
                } else {
                    this.gQl.setWhiteStyle(false);
                }
            } else {
                this.gQl.setWhiteStyle(false);
            }
        } else {
            this.gQl.setWhiteStyle(false);
        }
        if (i == 0) {
            this.gQk.setAdState(this.gNJ);
        } else {
            this.gQk.setAdState(null);
        }
        if (i == 0 && TbadkCoreApplication.getInst().getSkinType() != 1 && this.gQi.isPrimary() && this.gNJ != null && this.gNJ.gOu && i == 0) {
            if (this.gNJ.gOw > this.gNJ.gOx / 2) {
                if (this.gQp != null && this.gQp.gOw <= this.gNJ.gOx / 2) {
                    ao.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
                }
            } else if (this.gQp != null && this.gQp.gOw >= this.gNJ.gOx / 2) {
                ao.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            }
        }
    }

    public void bOX() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
            ao.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
        } else if (this.gQm.getCurrentItem() == 0 && this.gQi.isPrimary()) {
            if (this.gQv != null && this.gQv.getRefreshView() != null && this.gQv.getRefreshView().isViewAttached()) {
                ao.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            } else if (this.gNJ != null && this.gNJ.gOu) {
                if (this.gNJ.gOw > this.gNJ.gOx / 2 || this.gNJ.gOw == 0) {
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
        if (this.gQo != null && this.gQo.size() > 0 && this.gQm != null) {
            EnterForumTabPagerAdapter.a aVar = this.gQo.get(this.gQm.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void TY() {
        if (this.gQi != null && this.gQo != null && this.gQm != null && this.gQn != null) {
            FragmentManager supportFragmentManager = this.gQi.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.gQo.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.gQm.getId(), this.gQn.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.fbX != null) {
            this.fbX.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.gQn != null) {
            this.gQn.setPrimary(z);
        }
        if (this.gQo != null && this.gQo.size() > 0 && this.gQm != null) {
            EnterForumTabPagerAdapter.a aVar = this.gQo.get(this.gQm.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.gQo != null && this.gQo.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.gQo.size()) {
                    break;
                }
                EnterForumTabPagerAdapter.a aVar = this.gQo.get(i2);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof NoNetworkView.a)) {
                    ((NoNetworkView.a) aVar.fragment).onNetworkChange(z);
                }
                i = i2 + 1;
            }
        }
        sN(this.gQm.getCurrentItem());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bre() {
        if (this.gQj != null && this.gQj.getPaddingTop() < 0) {
            bOY();
        } else if (this.gQu != null) {
            this.gQu.clearAnimation();
            if (this.gQu.getVisibility() != 0) {
                this.gQu.setVisibility(0);
                if (this.fen == null) {
                    this.fen = new AlphaAnimation(0.0f, 1.0f);
                    this.fen.setFillAfter(true);
                    this.fen.setDuration(300L);
                }
                this.gQu.startAnimation(this.fen);
            }
        }
    }

    public void brf() {
        if (this.gQu != null && this.gQu.getVisibility() != 8) {
            if (this.feo == null) {
                this.feo = new AlphaAnimation(1.0f, 0.0f);
                this.feo.setFillAfter(true);
                this.feo.setDuration(300L);
                this.feo.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.enterForum.home.c.5
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.gQu.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.gQu.startAnimation(this.feo);
        }
    }

    private void bOY() {
        if (this.gQu != null && this.gQu.getVisibility() != 8) {
            this.gQu.clearAnimation();
            this.gQu.setVisibility(8);
        }
    }

    public void a(com.baidu.tieba.enterForum.view.b bVar) {
        this.gQv = bVar;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.d dVar) {
        this.gQp = this.gNJ;
        this.gNJ = dVar;
        this.gQk.setAdState(dVar);
        sN(this.gQm.getCurrentItem());
    }

    public void setSearchHint(String str) {
        this.gQk.setSearchHint(str);
    }

    public View getRootView() {
        return getPageContext().getPageActivity().getWindow().getDecorView();
    }

    public View bOZ() {
        return this.gQj;
    }

    public String getCurrentPageKey() {
        if (this.gQn != null) {
            return this.gQn.getCurrentPageKey();
        }
        return null;
    }

    private void sO(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gQu.getLayoutParams();
        layoutParams.topMargin = this.gQw + i;
        this.gQu.setLayoutParams(layoutParams);
    }

    public void a(p pVar, boolean z) {
        int i = 0;
        if (!this.gQi.getActivity().getSupportFragmentManager().isDestroyed()) {
            this.gQz = true;
            if (this.gQy == null || !this.gQy.b(pVar)) {
                bPb();
                this.gQo.clear();
                this.gQo.add(this.gQo.get(0));
                Iterator<o> it = pVar.bOt().iterator();
                while (it.hasNext()) {
                    o next = it.next();
                    EnterForumTabPagerAdapter.a aVar = new EnterForumTabPagerAdapter.a();
                    aVar.fragment = new EnterForumTabFeedFragment();
                    aVar.title = next.getTabName();
                    if (z) {
                        if (this.gQy == null) {
                            aVar.gQh = true;
                        } else {
                            aVar.gQh = this.gQy.b(next);
                        }
                    }
                    aVar.tabName = next.getTabName();
                    Bundle bundle = new Bundle();
                    bundle.putString("tab_code", next.bOs());
                    bundle.putString("tab_name", next.getTabName());
                    aVar.fragment.setArguments(bundle);
                    this.gQo.add(aVar);
                }
                this.gQy = pVar;
                this.gQl.notifyDataSetChanged();
                this.gQn.notifyDataSetChanged();
                this.gQm.setOffscreenPageLimit(this.gQo.size());
                bPa();
            } else if (pVar != null && this.gQy != null && v.getCount(this.gQo) - 1 == v.getCount(pVar.bOt())) {
                if (z) {
                    while (true) {
                        int i2 = i;
                        if (i2 >= pVar.bOt().size()) {
                            break;
                        }
                        if (this.gQo.get(i2 + 1) != null && pVar.bOt().get(i2) != null) {
                            this.gQo.get(i2 + 1).gQh = this.gQy.b(pVar.bOt().get(i2));
                        }
                        i = i2 + 1;
                    }
                }
                this.gQy = pVar;
                this.gQl.notifyDataSetChanged();
                bPa();
            }
        }
    }

    private void bPa() {
        if (TextUtils.isEmpty(this.gQx)) {
            if (this.gQi.getActivity() != null && this.gQi.getActivity().getIntent() != null) {
                Intent intent = this.gQi.getActivity().getIntent();
                if (intent.hasExtra("sub_locate_type")) {
                    String stringExtra = intent.getStringExtra("sub_locate_type");
                    intent.removeExtra("sub_locate_type");
                    int DK = DK(stringExtra);
                    if (DK != -1) {
                        sM(DK);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        int DK2 = DK(this.gQx);
        if (DK2 == -1) {
            DK2 = 0;
        }
        if (sM(DK2)) {
            Intent intent2 = getPageContext().getPageActivity().getIntent();
            if (intent2 != null) {
                intent2.removeExtra("sub_locate_type");
                intent2.removeExtra("is_from_scheme");
            }
            this.gQx = null;
        }
    }

    private void bPb() {
        if (this.gQn != null && this.gQo != null) {
            try {
                FragmentManager supportFragmentManager = this.gQi.getActivity().getSupportFragmentManager();
                if (!supportFragmentManager.isDestroyed()) {
                    FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                    for (int i = 1; i < this.gQo.size(); i++) {
                        Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.gQm.getId(), this.gQn.getItemId(i)));
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

    public int bPc() {
        return this.gQm.getCurrentItem();
    }

    public void sP(int i) {
        if (i == 0) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001631, getPageContext().getUniqueId()));
        } else if (v.getItem(this.gQo, i) != null && (this.gQo.get(i).fragment instanceof EnterForumTabFeedFragment)) {
            ((EnterForumTabFeedFragment) this.gQo.get(i).fragment).mr(true);
        }
    }

    public String sQ(int i) {
        EnterForumTabPagerAdapter.a aVar = (EnterForumTabPagerAdapter.a) v.getItem(this.gQo, i);
        return (aVar == null || !(aVar.fragment instanceof EnterForumTabFeedFragment)) ? "" : ((EnterForumTabFeedFragment) aVar.fragment).getTabName();
    }
}
