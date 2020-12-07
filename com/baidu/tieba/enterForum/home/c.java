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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.util.n;
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
/* loaded from: classes22.dex */
public class c extends com.baidu.adp.base.c implements NoNetworkView.a {
    private NoNetworkView grd;
    private AlphaAnimation gtC;
    private AlphaAnimation gtD;
    private com.baidu.tieba.enterForum.data.c itz;
    private EnterForumTabFragment ivW;
    private LinearLayout ivX;
    private ForumHeaderView ivY;
    private NewPagerSlidingTabBaseStrip ivZ;
    private PullLeftViewPager iwa;
    private EnterForumTabPagerAdapter iwb;
    private List<EnterForumTabPagerAdapter.a> iwc;
    private com.baidu.tieba.enterForum.data.c iwd;
    private ImageView iwe;
    private View iwf;
    private View iwg;
    private NavigationBar iwh;
    private View iwi;
    private com.baidu.tieba.enterForum.view.b iwj;
    private int iwk;
    private String iwl;
    private boolean iwm;
    private com.baidu.adp.framework.listener.a iwn;
    private CustomMessageListener iwo;
    private int mNavHeight;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private View mRootView;

    public c(EnterForumTabFragment enterForumTabFragment) {
        super(enterForumTabFragment.getPageContext());
        this.iwm = false;
        this.iwn = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.enterForum.home.c.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String str = "";
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage = (forumRecommendSocketResponseMessage) responsedMessage;
                    if (forumrecommendsocketresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendsocketresponsemessage.getHotSearchInfoData().cuR();
                    }
                } else if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage = (forumRecommendHttpResponseMessage) responsedMessage;
                    if (forumrecommendhttpresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendhttpresponsemessage.getHotSearchInfoData().cuR();
                    }
                }
                if (TextUtils.isEmpty(str)) {
                    str = c.this.mContext.getResources().getString(R.string.enter_forum_search_tip);
                }
                TbSingleton.getInstance().setHotSearch(str);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921396));
            }
        };
        this.iwo = new CustomMessageListener(2001630) { // from class: com.baidu.tieba.enterForum.home.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        c.this.bSu();
                    } else {
                        c.this.bSv();
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
                c.this.yM(i);
                if (c.this.iwc != null && c.this.iwc.size() > i) {
                    if (c.this.iwj != null) {
                        c.this.iwj.cxr();
                    }
                    EnterForumTabPagerAdapter.a aVar = (EnterForumTabPagerAdapter.a) c.this.iwc.get(i);
                    if (aVar != null && aVar.fragment != null) {
                        if (aVar.fragment instanceof EnterForumFragment) {
                            z = ((EnterForumFragment) aVar.fragment).cvO();
                        } else if (aVar.fragment instanceof EnterForumTabFeedFragment) {
                            t.csg().oX(false);
                            boolean cvO = ((EnterForumTabFeedFragment) aVar.fragment).cvO();
                            TiebaStatic.log(new ar("c13366").al("obj_locate", 3).dY("resource_id", ((EnterForumTabFeedFragment) aVar.fragment).getTabName()));
                            z = cvO;
                        } else {
                            z = true;
                        }
                        if (!z) {
                            c.this.bSu();
                        } else {
                            c.this.bSv();
                        }
                        if (i == 0) {
                            TiebaStatic.log(new ar("c13366").al("obj_locate", 1));
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
        this.ivW = enterForumTabFragment;
        this.ivW.registerListener(this.iwn);
        this.ivW.registerListener(this.iwo);
        this.mNavHeight = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds228);
        this.iwk = UtilHelper.getStatusBarHeight() + l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds229);
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            ak(bundle);
            al(bundle);
            am(bundle);
            this.grd = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.grd.a(this);
        }
    }

    private void ak(Bundle bundle) {
        this.iwa = (PullLeftViewPager) this.mRootView.findViewById(R.id.enter_forum_viewpager);
        EnterForumTabPagerAdapter.a aVar = new EnterForumTabPagerAdapter.a();
        aVar.fragment = new EnterForumFragment();
        aVar.title = this.ivW.getResources().getString(R.string.my_forum);
        ((EnterForumFragment) aVar.fragment).setTabViewController(this);
        this.iwc = new ArrayList();
        this.iwc.add(aVar);
        this.iwb = new EnterForumTabPagerAdapter(this.ivW.getActivity().getSupportFragmentManager(), this.iwc);
        this.iwa.setAdapter(this.iwb);
        this.iwa.setOffscreenPageLimit(this.iwc.size());
    }

    public void awY() {
    }

    private void al(Bundle bundle) {
        this.ivX = (LinearLayout) LayoutInflater.from(this.ivW.getContext()).inflate(R.layout.enter_forum_tab_layout, (ViewGroup) null);
        this.ivY = (ForumHeaderView) this.ivX.findViewById(R.id.recommend_forum_header_serch_view);
        this.ivY.setFrom(0);
        this.ivY.onChangeSkinType();
        this.ivZ = (NewPagerSlidingTabBaseStrip) this.ivX.findViewById(R.id.tab_layout);
        this.ivZ.setDefaultSelectorColorResourceId(R.color.CAM_X0105);
        this.ivZ.setRectPaintColor(R.color.CAM_X0302);
        this.ivZ.a(l.getDimens(this.ivW.getContext(), R.dimen.tbds46), l.getDimens(this.ivW.getContext(), R.dimen.tbds46), l.getDimens(this.ivW.getContext(), R.dimen.tbds10), l.getDimens(this.ivW.getContext(), R.dimen.tbds46), true);
        this.ivZ.setmIndicatorWidth(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds42));
        this.ivZ.setIndicatorOvershot(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds8));
        this.ivZ.setIndicatorRadius(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds8));
        this.ivZ.setIndicatorMarginBottom(l.getDimens(this.ivW.getContext(), R.dimen.tbds0));
        this.ivZ.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        this.ivZ.setTabPadding(l.getDimens(this.ivW.getContext(), R.dimen.tbds36), 0, l.getDimens(this.ivW.getContext(), R.dimen.tbds36), 0);
        this.ivZ.setViewPager(this.iwa);
        this.ivZ.setOnPageChangeListener(this.mOnPageChangeListener);
        this.iwg = this.ivX.findViewById(R.id.enter_forum_tab_left_grandient);
        this.iwf = this.ivX.findViewById(R.id.enter_forum_tab_right_grandient);
    }

    private void am(Bundle bundle) {
        this.iwh = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.iwh.setNavHeight(this.mNavHeight);
        this.iwh.hideBottomLine();
        this.iwi = this.mRootView.findViewById(R.id.divider_shadow);
        yN(0);
        this.iwe = (ImageView) this.ivX.findViewById(R.id.navigationBarGoSignall);
        this.iwe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.CheckFile("scan_flag") && ae.checkCamera(c.this.mContext.getPageActivity())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new QRCodeScanActivityConfig(c.this.mContext.getPageActivity())));
                } else if (!TbadkCoreApplication.isLogin()) {
                    bh.skipToLoginActivity(c.this.getPageContext().getPageActivity());
                } else {
                    c.this.ivW.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(c.this.getPageContext().getPageActivity())));
                }
            }
        });
        if (this.ivZ != null) {
            this.iwh.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, this.ivX, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.ivX.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(3);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(3);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 3;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.ivZ.setPadding(this.ivZ.getPaddingLeft(), this.ivZ.getPaddingTop(), this.ivZ.getPaddingRight(), this.ivZ.getPaddingBottom());
        }
    }

    public void a(NewPagerSlidingTabBaseStrip.a aVar) {
        if (this.ivZ != null && aVar != null) {
            this.ivZ.setOnTabItemClickListener(aVar);
        }
    }

    public boolean yL(int i) {
        if (i < 0 || i > this.iwc.size()) {
            return false;
        }
        this.iwa.setCurrentItem(i, true);
        return true;
    }

    public void JM(String str) {
        this.iwl = str;
    }

    public int JN(String str) {
        if (StringUtils.isNull(str) || this.iwc == null || this.iwc.size() <= 0) {
            return -1;
        }
        int i = -1;
        for (int i2 = 0; i2 < this.iwc.size(); i2++) {
            if (str.equals(this.iwc.get(i2).tabName)) {
                i = i2;
            }
        }
        if (i == -1 && this.ivW.getResources().getString(R.string.my_forum).equals(str)) {
            return 0;
        }
        return i;
    }

    public boolean cvX() {
        return this.iwm;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        yM(this.iwa.getCurrentItem());
        if (this.grd != null) {
            this.grd.onChangeSkinType(getPageContext(), i);
        }
        if (this.iwc != null && this.iwc.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.iwc.size()) {
                    break;
                }
                EnterForumTabPagerAdapter.a aVar = this.iwc.get(i3);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            }
        }
        ap.setBackgroundResource(this.iwi, R.drawable.personalize_tab_shadow);
        this.ivZ.onChangeSkinType();
        this.ivY.onChangeSkinType();
        ap.a(this.iwg, R.color.CAM_X0207, GradientDrawable.Orientation.LEFT_RIGHT);
        ap.a(this.iwf, R.color.CAM_X0207, GradientDrawable.Orientation.RIGHT_LEFT);
    }

    public void cvY() {
        yM(this.iwa.getCurrentItem());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, float f, int i2) {
        if (this.iwh != null) {
            if (i == 0) {
                if (i2 == 0) {
                    yM(i);
                } else if (this.itz != null && this.itz.iub && this.itz.iud > 0) {
                    if (this.iwj != null && this.iwj.getRefreshView() != null && this.iwj.getRefreshView().isViewAttached()) {
                        ap.setBackgroundColor(this.iwh.getBarBgView(), R.color.CAM_X0207, TbadkCoreApplication.getInst().getSkinType());
                        return;
                    }
                    this.iwh.setBackgroundColor(0);
                    ap.a(this.iwh.getBarBgView(), R.color.CAM_X0207, f, TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (i2 == 0) {
                yM(i);
            } else if (this.itz != null && this.itz.iub && this.itz.iud > 0) {
                if (this.iwj != null && this.iwj.getRefreshView() != null && this.iwj.getRefreshView().isViewAttached()) {
                    ap.setBackgroundColor(this.iwh.getBarBgView(), R.color.CAM_X0201, TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.iwh.setBackgroundColor(0);
                ap.a(this.iwh.getBarBgView(), R.color.CAM_X0201, 1.0f - f, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yM(int i) {
        int i2;
        if (this.iwe != null) {
            if (i == 0) {
                if (this.itz != null && this.itz.iub && this.itz.iud > 0) {
                    if (this.iwj != null && this.iwj.getRefreshView() != null && this.iwj.getRefreshView().isViewAttached()) {
                        SvgManager.btW().a(this.iwe, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    } else if (this.itz.iue > 0 && this.itz.iud > this.itz.iue / 2) {
                        SvgManager.btW().a(this.iwe, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    } else {
                        SvgManager.btW().a(this.iwe, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    }
                } else {
                    SvgManager.btW().a(this.iwe, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
            } else {
                SvgManager.btW().a(this.iwe, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
        if (this.iwh != null) {
            this.iwh.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            if (i == 0) {
                if (this.itz != null && this.itz.iub && this.itz.iud > 0) {
                    if (this.iwj != null && this.iwj.getRefreshView() != null && this.iwj.getRefreshView().isViewAttached()) {
                        ap.setBackgroundColor(this.iwh.getBarBgView(), R.color.CAM_X0207, TbadkCoreApplication.getInst().getSkinType());
                    } else {
                        if (this.itz.iue > 0) {
                            int i3 = (this.itz.iud * 255) / this.itz.iue;
                            i2 = 255 - (i3 <= 255 ? i3 : 255);
                        } else {
                            i2 = 0;
                        }
                        this.iwh.setBackgroundColor(0);
                        ap.a(this.iwh.getBarBgView(), R.color.CAM_X0201, i2 / 255.0f, TbadkCoreApplication.getInst().getSkinType());
                    }
                } else {
                    ap.setBackgroundColor(this.iwh.getBarBgView(), R.color.CAM_X0207, TbadkCoreApplication.getInst().getSkinType());
                }
            } else {
                ap.setBackgroundColor(this.iwh.getBarBgView(), R.color.CAM_X0207, TbadkCoreApplication.getInst().getSkinType());
            }
        }
        if (i == 0) {
            if (this.itz != null && this.itz.iub && this.itz.iud > 0) {
                if (this.itz.iue > 0 && this.itz.iud > this.itz.iue / 2) {
                    if (this.iwj != null && this.iwj.getRefreshView() != null && this.iwj.getRefreshView().isViewAttached()) {
                        this.ivZ.setWhiteStyle(false);
                    } else {
                        this.ivZ.setWhiteStyle(true);
                    }
                } else {
                    this.ivZ.setWhiteStyle(false);
                }
            } else {
                this.ivZ.setWhiteStyle(false);
            }
        } else {
            this.ivZ.setWhiteStyle(false);
        }
        if (i == 0) {
            this.ivY.setAdState(this.itz);
        } else {
            this.ivY.setAdState(null);
        }
        if (i == 0 && TbadkCoreApplication.getInst().getSkinType() != 1 && this.ivW.isPrimary() && this.itz != null && this.itz.iub && i == 0) {
            if (this.itz.iud > this.itz.iue / 2) {
                if (this.iwd != null && this.iwd.iud <= this.itz.iue / 2) {
                    as.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
                }
            } else if (this.iwd != null && this.iwd.iud >= this.itz.iue / 2) {
                as.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            }
        }
    }

    public void cvZ() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
            as.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
        } else if (this.iwa.getCurrentItem() == 0 && this.ivW.isPrimary()) {
            if (this.iwj != null && this.iwj.getRefreshView() != null && this.iwj.getRefreshView().isViewAttached()) {
                as.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            } else if (this.itz != null && this.itz.iub) {
                if (this.itz.iud > this.itz.iue / 2 || this.itz.iud == 0) {
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
        if (this.iwc != null && this.iwc.size() > 0 && this.iwa != null) {
            EnterForumTabPagerAdapter.a aVar = this.iwc.get(this.iwa.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void ame() {
        if (this.ivW != null && this.iwc != null && this.iwa != null && this.iwb != null) {
            FragmentManager supportFragmentManager = this.ivW.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.iwc.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.iwa.getId(), this.iwb.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.grd != null) {
            this.grd.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.iwb != null) {
            this.iwb.setPrimary(z);
        }
        if (this.iwc != null && this.iwc.size() > 0 && this.iwa != null) {
            EnterForumTabPagerAdapter.a aVar = this.iwc.get(this.iwa.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.iwc != null && this.iwc.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.iwc.size()) {
                    break;
                }
                EnterForumTabPagerAdapter.a aVar = this.iwc.get(i2);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof NoNetworkView.a)) {
                    ((NoNetworkView.a) aVar.fragment).onNetworkChange(z);
                }
                i = i2 + 1;
            }
        }
        yM(this.iwa.getCurrentItem());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSu() {
        if (this.ivX != null && this.ivX.getPaddingTop() < 0) {
            cwa();
        } else if (this.iwi != null) {
            this.iwi.clearAnimation();
            if (this.iwi.getVisibility() != 0) {
                this.iwi.setVisibility(0);
                if (this.gtC == null) {
                    this.gtC = new AlphaAnimation(0.0f, 1.0f);
                    this.gtC.setFillAfter(true);
                    this.gtC.setDuration(300L);
                }
                this.iwi.startAnimation(this.gtC);
            }
        }
    }

    public void bSv() {
        if (this.iwi != null && this.iwi.getVisibility() != 8) {
            if (this.gtD == null) {
                this.gtD = new AlphaAnimation(1.0f, 0.0f);
                this.gtD.setFillAfter(true);
                this.gtD.setDuration(300L);
                this.gtD.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.enterForum.home.c.5
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.iwi.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.iwi.startAnimation(this.gtD);
        }
    }

    private void cwa() {
        if (this.iwi != null && this.iwi.getVisibility() != 8) {
            this.iwi.clearAnimation();
            this.iwi.setVisibility(8);
        }
    }

    public void a(com.baidu.tieba.enterForum.view.b bVar) {
        this.iwj = bVar;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.iwd = this.itz;
        this.itz = cVar;
        this.ivY.setAdState(cVar);
        yM(this.iwa.getCurrentItem());
    }

    public void setSearchHint(String str) {
        this.ivY.setSearchHint(str);
    }

    public View getRootView() {
        return getPageContext().getPageActivity().getWindow().getDecorView();
    }

    public View cwb() {
        return this.ivX;
    }

    public String getCurrentPageKey() {
        if (this.iwb != null) {
            return this.iwb.getCurrentPageKey();
        }
        return null;
    }

    private void yN(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.iwi.getLayoutParams();
        layoutParams.topMargin = this.iwk + i;
        this.iwi.setLayoutParams(layoutParams);
    }

    public int cwc() {
        return this.iwa.getCurrentItem();
    }

    public void yO(int i) {
        if (i == 0) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001631, getPageContext().getUniqueId()));
        } else if (y.getItem(this.iwc, i) != null && (this.iwc.get(i).fragment instanceof EnterForumTabFeedFragment)) {
            ((EnterForumTabFeedFragment) this.iwc.get(i).fragment).py(true);
        }
    }

    public String yP(int i) {
        EnterForumTabPagerAdapter.a aVar = (EnterForumTabPagerAdapter.a) y.getItem(this.iwc, i);
        return (aVar == null || !(aVar.fragment instanceof EnterForumTabFeedFragment)) ? "" : ((EnterForumTabFeedFragment) aVar.fragment).getTabName();
    }
}
