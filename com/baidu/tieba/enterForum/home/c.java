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
    private NoNetworkView ePl;
    private AlphaAnimation eRA;
    private AlphaAnimation eRB;
    private com.baidu.tieba.enterForum.data.d gBA;
    private ImageView gBB;
    private View gBC;
    private View gBD;
    private NavigationBar gBE;
    private View gBF;
    private com.baidu.tieba.enterForum.view.b gBG;
    private int gBH;
    private String gBI;
    private p gBJ;
    private boolean gBK;
    private com.baidu.adp.framework.listener.a gBL;
    private CustomMessageListener gBM;
    private EnterForumTabFragment gBt;
    private LinearLayout gBu;
    private ForumHeaderView gBv;
    private NewPagerSlidingTabBaseStrip gBw;
    private PullLeftViewPager gBx;
    private EnterForumTabPagerAdapter gBy;
    private List<EnterForumTabPagerAdapter.a> gBz;
    private com.baidu.tieba.enterForum.data.d gyT;
    private int mNavHeight;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private View mRootView;

    public c(EnterForumTabFragment enterForumTabFragment) {
        super(enterForumTabFragment.getPageContext());
        this.gBK = false;
        this.gBL = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.enterForum.home.c.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String str = "";
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage = (forumRecommendSocketResponseMessage) responsedMessage;
                    if (forumrecommendsocketresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendsocketresponsemessage.getHotSearchInfoData().bHI();
                    }
                } else if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage = (forumRecommendHttpResponseMessage) responsedMessage;
                    if (forumrecommendhttpresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendhttpresponsemessage.getHotSearchInfoData().bHI();
                    }
                }
                if (TextUtils.isEmpty(str)) {
                    str = c.this.mContext.getResources().getString(R.string.enter_forum_search_tip);
                }
                TbSingleton.getInstance().setHotSearch(str);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921396));
            }
        };
        this.gBM = new CustomMessageListener(2001630) { // from class: com.baidu.tieba.enterForum.home.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        c.this.blI();
                    } else {
                        c.this.blJ();
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
                if (c.this.gBz != null && c.this.gBz.size() > i) {
                    if (c.this.gBG != null) {
                        c.this.gBG.bJZ();
                    }
                    EnterForumTabPagerAdapter.a aVar = (EnterForumTabPagerAdapter.a) c.this.gBz.get(i);
                    if (aVar != null && aVar.fragment != null) {
                        if (aVar.fragment instanceof EnterForumFragment) {
                            z = ((EnterForumFragment) aVar.fragment).bIu();
                        } else if (aVar.fragment instanceof EnterForumTabFeedFragment) {
                            r.bEY().lx(false);
                            boolean bIu = ((EnterForumTabFeedFragment) aVar.fragment).bIu();
                            TiebaStatic.log(new an("c13366").af("obj_locate", 3).cI("resource_id", ((EnterForumTabFeedFragment) aVar.fragment).getTabName()));
                            z = bIu;
                        } else {
                            z = true;
                        }
                        if (!z) {
                            c.this.blI();
                        } else {
                            c.this.blJ();
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
        this.gBt = enterForumTabFragment;
        this.gBt.registerListener(this.gBL);
        this.gBt.registerListener(this.gBM);
        this.mNavHeight = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds228);
        this.gBH = UtilHelper.getStatusBarHeight() + l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds229);
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            ae(bundle);
            af(bundle);
            ag(bundle);
            this.ePl = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.ePl.a(this);
        }
    }

    private void ae(Bundle bundle) {
        this.gBx = (PullLeftViewPager) this.mRootView.findViewById(R.id.enter_forum_viewpager);
        EnterForumTabPagerAdapter.a aVar = new EnterForumTabPagerAdapter.a();
        aVar.fragment = new EnterForumFragment();
        aVar.title = this.gBt.getResources().getString(R.string.my_forum);
        ((EnterForumFragment) aVar.fragment).setTabViewController(this);
        this.gBz = new ArrayList();
        this.gBz.add(aVar);
        this.gBy = new EnterForumTabPagerAdapter(this.gBt.getActivity().getSupportFragmentManager(), this.gBz);
        this.gBx.setAdapter(this.gBy);
        this.gBx.setOffscreenPageLimit(this.gBz.size());
    }

    public void aai() {
    }

    private void af(Bundle bundle) {
        this.gBu = (LinearLayout) LayoutInflater.from(this.gBt.getContext()).inflate(R.layout.enter_forum_tab_layout, (ViewGroup) null);
        this.gBv = (ForumHeaderView) this.gBu.findViewById(R.id.recommend_forum_header_serch_view);
        this.gBv.setFrom(0);
        this.gBv.onChangeSkinType();
        this.gBw = (NewPagerSlidingTabBaseStrip) this.gBu.findViewById(R.id.tab_layout);
        this.gBw.setDefaultSelectorColorResourceId(R.color.cp_cont_b);
        this.gBw.setRectPaintColor(R.color.cp_link_tip_a);
        this.gBw.a(l.getDimens(this.gBt.getContext(), R.dimen.tbds46), l.getDimens(this.gBt.getContext(), R.dimen.tbds46), l.getDimens(this.gBt.getContext(), R.dimen.tbds10), l.getDimens(this.gBt.getContext(), R.dimen.tbds46), true);
        this.gBw.setmIndicatorWidth(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds42));
        this.gBw.setIndicatorOvershot(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds8));
        this.gBw.setIndicatorRadius(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds8));
        this.gBw.setIndicatorMarginBottom(l.getDimens(this.gBt.getContext(), R.dimen.tbds0));
        this.gBw.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        this.gBw.setTabPadding(l.getDimens(this.gBt.getContext(), R.dimen.tbds36), 0, l.getDimens(this.gBt.getContext(), R.dimen.tbds36), 0);
        this.gBw.setViewPager(this.gBx);
        this.gBw.setOnPageChangeListener(this.mOnPageChangeListener);
        this.gBD = this.gBu.findViewById(R.id.enter_forum_tab_left_grandient);
        this.gBC = this.gBu.findViewById(R.id.enter_forum_tab_right_grandient);
    }

    private void ag(Bundle bundle) {
        this.gBE = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.gBE.setNavHeight(this.mNavHeight);
        this.gBE.hideBottomLine();
        this.gBF = this.mRootView.findViewById(R.id.divider_shadow);
        sj(0);
        this.gBB = (ImageView) this.gBu.findViewById(R.id.navigationBarGoSignall);
        this.gBB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.CheckFile("scan_flag") && ab.checkCamera(c.this.mContext.getPageActivity())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new QRCodeScanActivityConfig(c.this.mContext.getPageActivity())));
                } else if (!TbadkCoreApplication.isLogin()) {
                    bc.skipToLoginActivity(c.this.getPageContext().getPageActivity());
                } else {
                    c.this.gBt.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(c.this.getPageContext().getPageActivity())));
                }
            }
        });
        if (this.gBw != null) {
            this.gBE.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, this.gBu, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.gBu.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(3);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(3);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 3;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.gBw.setPadding(this.gBw.getPaddingLeft(), this.gBw.getPaddingTop(), this.gBw.getPaddingRight(), this.gBw.getBottom());
        }
    }

    public void a(NewPagerSlidingTabBaseStrip.a aVar) {
        if (this.gBw != null && aVar != null) {
            this.gBw.setOnTabItemClickListener(aVar);
        }
    }

    public boolean sh(int i) {
        if (i < 0 || i > this.gBz.size()) {
            return false;
        }
        this.gBx.setCurrentItem(i, true);
        return true;
    }

    public void BX(String str) {
        this.gBI = str;
    }

    public int BY(String str) {
        if (StringUtils.isNull(str) || this.gBz == null || this.gBz.size() <= 0) {
            return -1;
        }
        int i = -1;
        for (int i2 = 0; i2 < this.gBz.size(); i2++) {
            if (str.equals(this.gBz.get(i2).tabName)) {
                i = i2;
            }
        }
        if (i == -1 && this.gBt.getResources().getString(R.string.my_forum).equals(str)) {
            return 0;
        }
        return i;
    }

    public boolean bID() {
        return this.gBK;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        si(this.gBx.getCurrentItem());
        if (this.ePl != null) {
            this.ePl.onChangeSkinType(getPageContext(), i);
        }
        if (this.gBz != null && this.gBz.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.gBz.size()) {
                    break;
                }
                EnterForumTabPagerAdapter.a aVar = this.gBz.get(i3);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            }
        }
        am.setBackgroundResource(this.gBF, R.drawable.personalize_tab_shadow);
        this.gBw.onChangeSkinType();
        this.gBv.onChangeSkinType();
        am.a(this.gBD, R.color.cp_bg_line_h, GradientDrawable.Orientation.LEFT_RIGHT);
        am.a(this.gBC, R.color.cp_bg_line_h, GradientDrawable.Orientation.RIGHT_LEFT);
    }

    public void bIE() {
        si(this.gBx.getCurrentItem());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, float f, int i2) {
        if (this.gBE != null) {
            if (i == 0) {
                if (i2 == 0) {
                    si(i);
                } else if (this.gyT != null && this.gyT.gzE && this.gyT.gzG > 0) {
                    if (this.gBG != null && this.gBG.getRefreshView() != null && this.gBG.getRefreshView().isViewAttached()) {
                        am.setBackgroundColor(this.gBE.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
                        return;
                    }
                    this.gBE.setBackgroundColor(0);
                    am.a(this.gBE.getBarBgView(), (int) R.color.cp_bg_line_h, f, TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (i2 == 0) {
                si(i);
            } else if (this.gyT != null && this.gyT.gzE && this.gyT.gzG > 0) {
                if (this.gBG != null && this.gBG.getRefreshView() != null && this.gBG.getRefreshView().isViewAttached()) {
                    am.setBackgroundColor(this.gBE.getBarBgView(), R.color.cp_bg_line_d, TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.gBE.setBackgroundColor(0);
                am.a(this.gBE.getBarBgView(), (int) R.color.cp_bg_line_d, 1.0f - f, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void si(int i) {
        int i2;
        if (this.gBB != null) {
            if (i == 0) {
                if (this.gyT != null && this.gyT.gzE && this.gyT.gzG > 0) {
                    if (this.gBG != null && this.gBG.getRefreshView() != null && this.gBG.getRefreshView().isViewAttached()) {
                        SvgManager.aOU().a(this.gBB, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    } else if (this.gyT.gzH > 0 && this.gyT.gzG > this.gyT.gzH / 2) {
                        SvgManager.aOU().a(this.gBB, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    } else {
                        SvgManager.aOU().a(this.gBB, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    }
                } else {
                    SvgManager.aOU().a(this.gBB, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
            } else {
                SvgManager.aOU().a(this.gBB, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
        if (this.gBE != null) {
            this.gBE.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            if (i == 0) {
                if (this.gyT != null && this.gyT.gzE && this.gyT.gzG > 0) {
                    if (this.gBG != null && this.gBG.getRefreshView() != null && this.gBG.getRefreshView().isViewAttached()) {
                        am.setBackgroundColor(this.gBE.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
                    } else {
                        if (this.gyT.gzH > 0) {
                            int i3 = (this.gyT.gzG * 255) / this.gyT.gzH;
                            if (i3 > 255) {
                                i3 = 255;
                            }
                            i2 = 255 - i3;
                        } else {
                            i2 = 0;
                        }
                        this.gBE.setBackgroundColor(0);
                        am.a(this.gBE.getBarBgView(), (int) R.color.cp_bg_line_d, i2 / 255.0f, TbadkCoreApplication.getInst().getSkinType());
                    }
                } else {
                    am.setBackgroundColor(this.gBE.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
                }
            } else {
                am.setBackgroundColor(this.gBE.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
            }
        }
        if (i == 0) {
            if (this.gyT != null && this.gyT.gzE && this.gyT.gzG > 0) {
                if (this.gyT.gzH > 0 && this.gyT.gzG > this.gyT.gzH / 2) {
                    if (this.gBG != null && this.gBG.getRefreshView() != null && this.gBG.getRefreshView().isViewAttached()) {
                        this.gBw.setWhiteStyle(false);
                    } else {
                        this.gBw.setWhiteStyle(true);
                    }
                } else {
                    this.gBw.setWhiteStyle(false);
                }
            } else {
                this.gBw.setWhiteStyle(false);
            }
        } else {
            this.gBw.setWhiteStyle(false);
        }
        if (i == 0) {
            this.gBv.setAdState(this.gyT);
        } else {
            this.gBv.setAdState(null);
        }
        if (i == 0 && TbadkCoreApplication.getInst().getSkinType() != 1 && this.gBt.isPrimary() && this.gyT != null && this.gyT.gzE && i == 0) {
            if (this.gyT.gzG > this.gyT.gzH / 2) {
                if (this.gBA != null && this.gBA.gzG <= this.gyT.gzH / 2) {
                    ao.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
                }
            } else if (this.gBA != null && this.gBA.gzG >= this.gyT.gzH / 2) {
                ao.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            }
        }
    }

    public void bIF() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
            ao.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
        } else if (this.gBx.getCurrentItem() == 0 && this.gBt.isPrimary()) {
            if (this.gBG != null && this.gBG.getRefreshView() != null && this.gBG.getRefreshView().isViewAttached()) {
                ao.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            } else if (this.gyT != null && this.gyT.gzE) {
                if (this.gyT.gzG > this.gyT.gzH / 2 || this.gyT.gzG == 0) {
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
        if (this.gBz != null && this.gBz.size() > 0 && this.gBx != null) {
            EnterForumTabPagerAdapter.a aVar = this.gBz.get(this.gBx.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void Ry() {
        if (this.gBt != null && this.gBz != null && this.gBx != null && this.gBy != null) {
            FragmentManager supportFragmentManager = this.gBt.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.gBz.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.gBx.getId(), this.gBy.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.ePl != null) {
            this.ePl.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.gBy != null) {
            this.gBy.setPrimary(z);
        }
        if (this.gBz != null && this.gBz.size() > 0 && this.gBx != null) {
            EnterForumTabPagerAdapter.a aVar = this.gBz.get(this.gBx.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.gBz != null && this.gBz.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.gBz.size()) {
                    break;
                }
                EnterForumTabPagerAdapter.a aVar = this.gBz.get(i2);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof NoNetworkView.a)) {
                    ((NoNetworkView.a) aVar.fragment).onNetworkChange(z);
                }
                i = i2 + 1;
            }
        }
        si(this.gBx.getCurrentItem());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blI() {
        if (this.gBu != null && this.gBu.getPaddingTop() < 0) {
            bIG();
        } else if (this.gBF != null) {
            this.gBF.clearAnimation();
            if (this.gBF.getVisibility() != 0) {
                this.gBF.setVisibility(0);
                if (this.eRA == null) {
                    this.eRA = new AlphaAnimation(0.0f, 1.0f);
                    this.eRA.setFillAfter(true);
                    this.eRA.setDuration(300L);
                }
                this.gBF.startAnimation(this.eRA);
            }
        }
    }

    public void blJ() {
        if (this.gBF != null && this.gBF.getVisibility() != 8) {
            if (this.eRB == null) {
                this.eRB = new AlphaAnimation(1.0f, 0.0f);
                this.eRB.setFillAfter(true);
                this.eRB.setDuration(300L);
                this.eRB.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.enterForum.home.c.5
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.gBF.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.gBF.startAnimation(this.eRB);
        }
    }

    private void bIG() {
        if (this.gBF != null && this.gBF.getVisibility() != 8) {
            this.gBF.clearAnimation();
            this.gBF.setVisibility(8);
        }
    }

    public void a(com.baidu.tieba.enterForum.view.b bVar) {
        this.gBG = bVar;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.d dVar) {
        this.gBA = this.gyT;
        this.gyT = dVar;
        this.gBv.setAdState(dVar);
        si(this.gBx.getCurrentItem());
    }

    public void setSearchHint(String str) {
        this.gBv.setSearchHint(str);
    }

    public View getRootView() {
        return getPageContext().getPageActivity().getWindow().getDecorView();
    }

    public View bIH() {
        return this.gBu;
    }

    public String getCurrentPageKey() {
        if (this.gBy != null) {
            return this.gBy.getCurrentPageKey();
        }
        return null;
    }

    private void sj(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gBF.getLayoutParams();
        layoutParams.topMargin = this.gBH + i;
        this.gBF.setLayoutParams(layoutParams);
    }

    public void a(p pVar, boolean z) {
        int i = 0;
        if (!this.gBt.getActivity().getSupportFragmentManager().isDestroyed()) {
            this.gBK = true;
            if (this.gBJ == null || !this.gBJ.b(pVar)) {
                bIJ();
                this.gBz.clear();
                this.gBz.add(this.gBz.get(0));
                Iterator<o> it = pVar.bIb().iterator();
                while (it.hasNext()) {
                    o next = it.next();
                    EnterForumTabPagerAdapter.a aVar = new EnterForumTabPagerAdapter.a();
                    aVar.fragment = new EnterForumTabFeedFragment();
                    aVar.title = next.getTabName();
                    if (z) {
                        if (this.gBJ == null) {
                            aVar.gBs = true;
                        } else {
                            aVar.gBs = this.gBJ.b(next);
                        }
                    }
                    aVar.tabName = next.getTabName();
                    Bundle bundle = new Bundle();
                    bundle.putString("tab_code", next.bIa());
                    bundle.putString("tab_name", next.getTabName());
                    aVar.fragment.setArguments(bundle);
                    this.gBz.add(aVar);
                }
                this.gBJ = pVar;
                this.gBw.notifyDataSetChanged();
                this.gBy.notifyDataSetChanged();
                this.gBx.setOffscreenPageLimit(this.gBz.size());
                bII();
            } else if (pVar != null && this.gBJ != null && v.getCount(this.gBz) - 1 == v.getCount(pVar.bIb())) {
                if (z) {
                    while (true) {
                        int i2 = i;
                        if (i2 >= pVar.bIb().size()) {
                            break;
                        }
                        if (this.gBz.get(i2 + 1) != null && pVar.bIb().get(i2) != null) {
                            this.gBz.get(i2 + 1).gBs = this.gBJ.b(pVar.bIb().get(i2));
                        }
                        i = i2 + 1;
                    }
                }
                this.gBJ = pVar;
                this.gBw.notifyDataSetChanged();
                bII();
            }
        }
    }

    private void bII() {
        if (!TextUtils.isEmpty(this.gBI)) {
            int BY = BY(this.gBI);
            if (BY == -1) {
                BY = 0;
            }
            if (sh(BY)) {
                Intent intent = getPageContext().getPageActivity().getIntent();
                if (intent != null) {
                    intent.removeExtra("sub_locate_type");
                    intent.removeExtra("is_from_scheme");
                }
                this.gBI = null;
            }
        }
    }

    private void bIJ() {
        if (this.gBy != null && this.gBz != null) {
            try {
                FragmentManager supportFragmentManager = this.gBt.getActivity().getSupportFragmentManager();
                if (!supportFragmentManager.isDestroyed()) {
                    FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                    for (int i = 1; i < this.gBz.size(); i++) {
                        Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.gBx.getId(), this.gBy.getItemId(i)));
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

    public int bIK() {
        return this.gBx.getCurrentItem();
    }

    public void sk(int i) {
        if (i == 0) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001631, getPageContext().getUniqueId()));
        } else if (v.getItem(this.gBz, i) != null && (this.gBz.get(i).fragment instanceof EnterForumTabFeedFragment)) {
            ((EnterForumTabFeedFragment) this.gBz.get(i).fragment).lW(true);
        }
    }

    public String sl(int i) {
        EnterForumTabPagerAdapter.a aVar = (EnterForumTabPagerAdapter.a) v.getItem(this.gBz, i);
        return (aVar == null || !(aVar.fragment instanceof EnterForumTabFeedFragment)) ? "" : ((EnterForumTabFeedFragment) aVar.fragment).getTabName();
    }
}
