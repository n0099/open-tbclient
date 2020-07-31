package com.baidu.tieba.hottopic.view;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.view.DisableScrollLayout;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.adapter.HotTopicThreadPagerAdapter;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import java.util.List;
/* loaded from: classes15.dex */
public class c {
    private int cEo;
    private TbPageContext<HotTopicActivity> dVN;
    private CustomViewPager dYQ;
    private NoNetworkView fqQ;
    private NoNetworkView.a hCK;
    public ImageView hNc;
    private ImageView iEP;
    private RelativeLayout iMM;
    private NavigationBar iMN;
    private ImageView iMO;
    private e iMP;
    private HotTopicHeaderView iMQ;
    private HotTopicThreadPagerAdapter iMR;
    private DisableScrollLayout iMS;
    private int iMT;
    private TextView iMU;
    private com.baidu.tieba.hottopic.controller.c iMV;
    private boolean iMX;
    private float iMY;
    private NavigationBar mNavigationBar;
    private int mNavigationBarHeight;
    private String mTopicId;
    private final com.baidu.tbadk.widget.layout.e eSb = new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.hottopic.view.c.1
        @Override // com.baidu.tbadk.widget.layout.e
        public void d(View view, int i, int i2, int i3, int i4) {
            c.this.mNavigationBarHeight = i2;
            if (c.this.iMQ != null) {
                c.this.iMQ.yb(i2);
            }
        }
    };
    private final com.baidu.tbadk.widget.layout.e iMW = new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.hottopic.view.c.2
        @Override // com.baidu.tbadk.widget.layout.e
        public void d(View view, int i, int i2, int i3, int i4) {
            c.this.cEo = i2;
            c.this.iMR.xR(i2);
            c.this.iMS.setHeaderViewHeight(i2);
        }
    };
    private boolean iMZ = false;
    private a iIs = new a() { // from class: com.baidu.tieba.hottopic.view.c.5
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            HotTopicView coA = c.this.iMR.coA();
            if (coA != null && absListView == coA.getListView() && i == 0) {
                c.this.iMX = true;
                float y = c.this.iMQ.getY();
                if (c.this.iMR != null) {
                    if (Math.abs(c.this.iMY) != c.this.cpD() || c.this.iMY == y) {
                        c.this.iMR.xV((int) (c.this.iMY - y));
                        return;
                    }
                    c.this.iMR.am(y);
                    c.this.mNavigationBar.hideBottomLine();
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            HotTopicActivity hotTopicActivity;
            HotTopicView coA = c.this.iMR.coA();
            if (coA != null) {
                if (absListView == coA.getListView()) {
                    if (c.this.iMP != null) {
                        c.this.iMP.yf(i);
                    }
                    c.this.cpE();
                }
                if (c.this.iMR != null && c.this.iMQ.getNavigationBarSwitchHeight() != c.this.mNavigationBarHeight) {
                    if (c.this.iMZ) {
                        float navigationBarSwitchHeight = (-c.this.iMQ.getY()) / (c.this.iMQ.getNavigationBarSwitchHeight() - c.this.mNavigationBarHeight);
                        c.this.mNavigationBar.setAlpha(1.0f - navigationBarSwitchHeight);
                        c.this.iMN.setAlpha(navigationBarSwitchHeight);
                        if (c.this.iMU != null) {
                            c.this.iMU.setAlpha((-c.this.iMQ.getY()) / (c.this.iMQ.getNavigationBarSwitchHeight() - c.this.mNavigationBarHeight));
                        }
                    } else {
                        if (c.this.iMU != null) {
                            c.this.iMU.setAlpha((-c.this.iMQ.getY()) / (c.this.iMQ.getNavigationBarSwitchHeight() - c.this.mNavigationBarHeight));
                        }
                        if (Math.abs(c.this.iMY) == c.this.cpD()) {
                            c.this.iMN.hideBottomLine();
                        } else {
                            c.this.iMN.showBottomLine();
                        }
                    }
                }
                if (i == 0 && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && (hotTopicActivity = (HotTopicActivity) c.this.dVN.getOrignalPage()) != null) {
                    hotTopicActivity.onScrollToBottom();
                }
            }
        }
    };

    public c(TbPageContext<HotTopicActivity> tbPageContext, String str) {
        this.dVN = tbPageContext;
        this.mTopicId = str;
        initView();
    }

    private void initView() {
        if (this.dVN != null) {
            this.dVN.getOrignalPage().setContentView(R.layout.hot_topic_activity);
            this.iMT = l.getDimens(this.dVN.getPageActivity(), R.dimen.ds80);
            this.iMV = new com.baidu.tieba.hottopic.controller.c((OvalActionButton) this.dVN.getOrignalPage().findViewById(R.id.topic_post_forum_button), this.dVN);
            this.iMV.setTopicId(this.mTopicId);
            this.iMM = (RelativeLayout) this.dVN.getOrignalPage().findViewById(R.id.hot_topic_root_view);
            this.iMS = (DisableScrollLayout) this.iMM.findViewById(R.id.disable_scroll_layout);
            this.mNavigationBar = (NavigationBar) this.dVN.getOrignalPage().findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.hideBottomLine();
            this.iMN = (NavigationBar) this.dVN.getOrignalPage().findViewById(R.id.view_navigation_bar_after_scroll);
            this.iMU = this.iMN.setCenterTextTitle("");
            this.iMU.setAlpha(0.0f);
            this.iMN.hideBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            ao.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.selector_topbar_return_white);
            this.iMN.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.iEP = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!j.isNetWorkAvailable()) {
                        ((HotTopicActivity) c.this.dVN.getOrignalPage()).showToast(R.string.topic_share_no_network);
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                    if (ShareSwitch.isOn() || bf.checkUpIsLogin(c.this.dVN.getContext())) {
                        TiebaStatic.log(new ap("c10521").dn("obj_id", ((HotTopicActivity) c.this.dVN.getOrignalPage()).coQ()).dn("topic_id", ((HotTopicActivity) c.this.dVN.getOrignalPage()).coQ()));
                        ((HotTopicActivity) c.this.dVN.getOrignalPage()).coH();
                    }
                }
            });
            this.iMO = (ImageView) this.iMN.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!j.isNetWorkAvailable()) {
                        ((HotTopicActivity) c.this.dVN.getOrignalPage()).showToast(R.string.topic_share_no_network);
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                    if (ShareSwitch.isOn() || bf.checkUpIsLogin(c.this.dVN.getContext())) {
                        TiebaStatic.log(new ap("c10521").dn("obj_id", ((HotTopicActivity) c.this.dVN.getOrignalPage()).coQ()).dn("topic_id", ((HotTopicActivity) c.this.dVN.getOrignalPage()).coQ()));
                        ((HotTopicActivity) c.this.dVN.getOrignalPage()).coH();
                    }
                }
            });
            this.fqQ = (NoNetworkView) this.iMM.findViewById(R.id.view_no_network);
            ((ObservedChangeLinearLayout) this.iMM.findViewById(R.id.hot_topic_observed_change_layout)).setOnSizeChangeListener(this.eSb);
            this.iMP = new e(this.dVN, this.iMM);
            this.iMQ = (HotTopicHeaderView) this.iMM.findViewById(R.id.hot_topic_header);
            this.iMQ.setOnSizeChangeListener(this.iMW);
            this.dYQ = (CustomViewPager) this.iMM.findViewById(R.id.hot_topic_view_pager);
            this.iMR = new HotTopicThreadPagerAdapter(this.dVN.getPageActivity(), this.iIs);
            this.iMR.setMainView(this);
            this.dYQ.setAdapter(this.iMR);
            this.iMQ.setViewPager(this.dYQ);
            this.iMQ.setHeaderBottomLineShow(false);
            this.hNc = (ImageView) this.iMM.findViewById(R.id.normal_write_icon);
            this.hNc.setVisibility(8);
        }
    }

    public void a(int i, boolean z, long j, int i2) {
        this.iMP.a(i, z, j, i2);
    }

    public void b(View.OnTouchListener onTouchListener) {
        if (onTouchListener != null && this.hNc != null) {
            this.hNc.setOnTouchListener(onTouchListener);
        }
    }

    public View cpv() {
        return this.iMM;
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null && this.iMZ) {
            this.mNavigationBar.onChangeSkinType(this.dVN, i);
            this.mNavigationBar.setBackgroundResource(R.drawable.black_alpha_from_30_to_0);
            ao.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.selector_topbar_return_white);
            this.mNavigationBar.setAlpha((this.iMQ.getY() / (this.iMQ.getNavigationBarSwitchHeight() - this.mNavigationBarHeight)) + 1.0f);
        }
        if (this.iMN != null) {
            this.iMN.onChangeSkinType(this.dVN, i);
            if (this.iMZ) {
                this.iMN.setAlpha((-this.iMQ.getY()) / (this.iMQ.getNavigationBarSwitchHeight() - this.mNavigationBarHeight));
            } else {
                this.iMN.setAlpha(1.0f);
            }
        }
        if (this.fqQ != null) {
            this.fqQ.onChangeSkinType(this.dVN, i);
        }
        if (this.iMO != null) {
            SvgManager.baR().a(this.iMO, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.iEP != null) {
            SvgManager.baR().a(this.iEP, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.iMQ != null) {
            this.iMQ.onChangeSkinType();
        }
        if (this.iMR != null) {
            this.iMR.onChangeSkinType(i);
        }
        if (this.hNc != null) {
            ao.setBackgroundResource(this.hNc, R.drawable.icon_tabbar_chaticon_n);
            ao.setImageResource(this.hNc, R.drawable.icon_tabbar_add_n);
        }
    }

    public void c(com.baidu.tieba.hottopic.data.e eVar) {
        if (eVar != null && eVar.cpf() != null) {
            if (!this.iMQ.cpB()) {
                this.iMQ.setData(eVar.cpf());
            }
            if (eVar.cpf() != null) {
                this.iMZ = !StringUtils.isNull(eVar.cpf().iKn);
                this.mNavigationBar.setVisibility(this.iMZ ? 0 : 8);
                if (!this.iMZ) {
                    this.iMN.setAlpha(1.0f);
                    this.iMN.showBottomLine();
                }
            }
            String str = eVar.cpf().dQI;
            if (StringUtils.isNull(str)) {
                this.hNc.setVisibility(8);
                GX("");
            } else {
                GX(com.baidu.tieba.hottopic.b.a.aO(str, 10));
            }
            this.iMQ.setHeaderBottomLineShow(true);
        }
    }

    private void GX(String str) {
        if (this.iMU != null) {
            this.iMU.setText(str);
        } else if (this.iMN != null) {
            this.iMU = this.iMN.setCenterTextTitle(str);
        }
    }

    public int getCurrentTab() {
        if (this.dYQ.getCurrentItem() < 0) {
            return 0;
        }
        return this.dYQ.getCurrentItem();
    }

    public void g(NoNetworkView.a aVar) {
        this.hCK = aVar;
        if (this.fqQ != null) {
            this.fqQ.a(this.hCK);
        }
    }

    public void yc(int i) {
        this.iMQ.setVisibility(i);
        this.dYQ.setVisibility(i);
    }

    public void bwX() {
        this.iMR.bwX();
    }

    public void showLoadingView() {
        this.iMR.showLoadingView();
    }

    public void cpx() {
        this.iMR.pp(false);
    }

    public void dn(List<com.baidu.tieba.hottopic.data.e> list) {
        this.iMR.dj(list);
    }

    public void destroy() {
        if (this.iMR != null) {
            this.iMR.destroy();
        }
        if (this.iMP != null) {
            this.iMP.clearAnimation();
        }
        if (this.fqQ != null && this.hCK != null) {
            this.fqQ.b(this.hCK);
        }
    }

    public void resume() {
        if (this.iMR != null) {
            this.iMR.resume();
        }
    }

    public void pause() {
        if (this.iMR != null) {
            this.iMR.pause();
        }
    }

    public void ps(boolean z) {
        if (this.fqQ != null) {
            if (z) {
                this.fqQ.setVisibility(0);
            } else {
                this.fqQ.setVisibility(8);
            }
        }
    }

    public HotTopicView cpC() {
        return this.iMR.coA();
    }

    public int cpD() {
        return (this.cEo - this.iMT) - this.mNavigationBarHeight;
    }

    public void xS(int i) {
        if (this.iMR != null) {
            this.iMR.xS(i);
        }
    }

    public void xT(int i) {
        if (this.iMR != null) {
            this.iMR.xT(i);
        }
    }

    public void xU(int i) {
        if (this.iMR != null) {
            this.iMR.xU(i);
        }
    }

    public void a(AbsListView absListView, int i) {
        HotTopicView coA;
        if (this.iMQ != null && this.iMS != null && (coA = this.iMR.coA()) != null && coA.getListView() != null && absListView == coA.getListView()) {
            this.iMS.setHeaderViewHeight(this.cEo - i);
            this.iMQ.setY(-i);
            if (i == 0) {
                this.iMS.hW(false);
            } else {
                this.iMS.hW(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpE() {
        if (this.iMX) {
            this.iMY = this.iMQ.getY();
            this.iMX = false;
        }
    }

    /* loaded from: classes15.dex */
    public abstract class a implements AbsListView.OnScrollListener {
        public a() {
        }
    }

    public HotTopicHeaderView cpF() {
        return this.iMQ;
    }

    public int cpG() {
        return this.cEo;
    }
}
