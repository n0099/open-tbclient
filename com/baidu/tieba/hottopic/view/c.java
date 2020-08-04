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
    public ImageView hNe;
    private ImageView iER;
    private RelativeLayout iMO;
    private NavigationBar iMP;
    private ImageView iMQ;
    private e iMR;
    private HotTopicHeaderView iMS;
    private HotTopicThreadPagerAdapter iMT;
    private DisableScrollLayout iMU;
    private int iMV;
    private TextView iMW;
    private com.baidu.tieba.hottopic.controller.c iMX;
    private boolean iMZ;
    private float iNa;
    private NavigationBar mNavigationBar;
    private int mNavigationBarHeight;
    private String mTopicId;
    private final com.baidu.tbadk.widget.layout.e eSb = new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.hottopic.view.c.1
        @Override // com.baidu.tbadk.widget.layout.e
        public void d(View view, int i, int i2, int i3, int i4) {
            c.this.mNavigationBarHeight = i2;
            if (c.this.iMS != null) {
                c.this.iMS.yb(i2);
            }
        }
    };
    private final com.baidu.tbadk.widget.layout.e iMY = new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.hottopic.view.c.2
        @Override // com.baidu.tbadk.widget.layout.e
        public void d(View view, int i, int i2, int i3, int i4) {
            c.this.cEo = i2;
            c.this.iMT.xR(i2);
            c.this.iMU.setHeaderViewHeight(i2);
        }
    };
    private boolean iNb = false;
    private a iIu = new a() { // from class: com.baidu.tieba.hottopic.view.c.5
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            HotTopicView coA = c.this.iMT.coA();
            if (coA != null && absListView == coA.getListView() && i == 0) {
                c.this.iMZ = true;
                float y = c.this.iMS.getY();
                if (c.this.iMT != null) {
                    if (Math.abs(c.this.iNa) != c.this.cpD() || c.this.iNa == y) {
                        c.this.iMT.xV((int) (c.this.iNa - y));
                        return;
                    }
                    c.this.iMT.am(y);
                    c.this.mNavigationBar.hideBottomLine();
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            HotTopicActivity hotTopicActivity;
            HotTopicView coA = c.this.iMT.coA();
            if (coA != null) {
                if (absListView == coA.getListView()) {
                    if (c.this.iMR != null) {
                        c.this.iMR.yf(i);
                    }
                    c.this.cpE();
                }
                if (c.this.iMT != null && c.this.iMS.getNavigationBarSwitchHeight() != c.this.mNavigationBarHeight) {
                    if (c.this.iNb) {
                        float navigationBarSwitchHeight = (-c.this.iMS.getY()) / (c.this.iMS.getNavigationBarSwitchHeight() - c.this.mNavigationBarHeight);
                        c.this.mNavigationBar.setAlpha(1.0f - navigationBarSwitchHeight);
                        c.this.iMP.setAlpha(navigationBarSwitchHeight);
                        if (c.this.iMW != null) {
                            c.this.iMW.setAlpha((-c.this.iMS.getY()) / (c.this.iMS.getNavigationBarSwitchHeight() - c.this.mNavigationBarHeight));
                        }
                    } else {
                        if (c.this.iMW != null) {
                            c.this.iMW.setAlpha((-c.this.iMS.getY()) / (c.this.iMS.getNavigationBarSwitchHeight() - c.this.mNavigationBarHeight));
                        }
                        if (Math.abs(c.this.iNa) == c.this.cpD()) {
                            c.this.iMP.hideBottomLine();
                        } else {
                            c.this.iMP.showBottomLine();
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
            this.iMV = l.getDimens(this.dVN.getPageActivity(), R.dimen.ds80);
            this.iMX = new com.baidu.tieba.hottopic.controller.c((OvalActionButton) this.dVN.getOrignalPage().findViewById(R.id.topic_post_forum_button), this.dVN);
            this.iMX.setTopicId(this.mTopicId);
            this.iMO = (RelativeLayout) this.dVN.getOrignalPage().findViewById(R.id.hot_topic_root_view);
            this.iMU = (DisableScrollLayout) this.iMO.findViewById(R.id.disable_scroll_layout);
            this.mNavigationBar = (NavigationBar) this.dVN.getOrignalPage().findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.hideBottomLine();
            this.iMP = (NavigationBar) this.dVN.getOrignalPage().findViewById(R.id.view_navigation_bar_after_scroll);
            this.iMW = this.iMP.setCenterTextTitle("");
            this.iMW.setAlpha(0.0f);
            this.iMP.hideBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            ao.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.selector_topbar_return_white);
            this.iMP.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.iER = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.c.3
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
            this.iMQ = (ImageView) this.iMP.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.c.4
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
            this.fqQ = (NoNetworkView) this.iMO.findViewById(R.id.view_no_network);
            ((ObservedChangeLinearLayout) this.iMO.findViewById(R.id.hot_topic_observed_change_layout)).setOnSizeChangeListener(this.eSb);
            this.iMR = new e(this.dVN, this.iMO);
            this.iMS = (HotTopicHeaderView) this.iMO.findViewById(R.id.hot_topic_header);
            this.iMS.setOnSizeChangeListener(this.iMY);
            this.dYQ = (CustomViewPager) this.iMO.findViewById(R.id.hot_topic_view_pager);
            this.iMT = new HotTopicThreadPagerAdapter(this.dVN.getPageActivity(), this.iIu);
            this.iMT.setMainView(this);
            this.dYQ.setAdapter(this.iMT);
            this.iMS.setViewPager(this.dYQ);
            this.iMS.setHeaderBottomLineShow(false);
            this.hNe = (ImageView) this.iMO.findViewById(R.id.normal_write_icon);
            this.hNe.setVisibility(8);
        }
    }

    public void a(int i, boolean z, long j, int i2) {
        this.iMR.a(i, z, j, i2);
    }

    public void b(View.OnTouchListener onTouchListener) {
        if (onTouchListener != null && this.hNe != null) {
            this.hNe.setOnTouchListener(onTouchListener);
        }
    }

    public View cpv() {
        return this.iMO;
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null && this.iNb) {
            this.mNavigationBar.onChangeSkinType(this.dVN, i);
            this.mNavigationBar.setBackgroundResource(R.drawable.black_alpha_from_30_to_0);
            ao.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.selector_topbar_return_white);
            this.mNavigationBar.setAlpha((this.iMS.getY() / (this.iMS.getNavigationBarSwitchHeight() - this.mNavigationBarHeight)) + 1.0f);
        }
        if (this.iMP != null) {
            this.iMP.onChangeSkinType(this.dVN, i);
            if (this.iNb) {
                this.iMP.setAlpha((-this.iMS.getY()) / (this.iMS.getNavigationBarSwitchHeight() - this.mNavigationBarHeight));
            } else {
                this.iMP.setAlpha(1.0f);
            }
        }
        if (this.fqQ != null) {
            this.fqQ.onChangeSkinType(this.dVN, i);
        }
        if (this.iMQ != null) {
            SvgManager.baR().a(this.iMQ, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.iER != null) {
            SvgManager.baR().a(this.iER, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.iMS != null) {
            this.iMS.onChangeSkinType();
        }
        if (this.iMT != null) {
            this.iMT.onChangeSkinType(i);
        }
        if (this.hNe != null) {
            ao.setBackgroundResource(this.hNe, R.drawable.icon_tabbar_chaticon_n);
            ao.setImageResource(this.hNe, R.drawable.icon_tabbar_add_n);
        }
    }

    public void c(com.baidu.tieba.hottopic.data.e eVar) {
        if (eVar != null && eVar.cpf() != null) {
            if (!this.iMS.cpB()) {
                this.iMS.setData(eVar.cpf());
            }
            if (eVar.cpf() != null) {
                this.iNb = !StringUtils.isNull(eVar.cpf().iKp);
                this.mNavigationBar.setVisibility(this.iNb ? 0 : 8);
                if (!this.iNb) {
                    this.iMP.setAlpha(1.0f);
                    this.iMP.showBottomLine();
                }
            }
            String str = eVar.cpf().dQI;
            if (StringUtils.isNull(str)) {
                this.hNe.setVisibility(8);
                GX("");
            } else {
                GX(com.baidu.tieba.hottopic.b.a.aO(str, 10));
            }
            this.iMS.setHeaderBottomLineShow(true);
        }
    }

    private void GX(String str) {
        if (this.iMW != null) {
            this.iMW.setText(str);
        } else if (this.iMP != null) {
            this.iMW = this.iMP.setCenterTextTitle(str);
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
        this.iMS.setVisibility(i);
        this.dYQ.setVisibility(i);
    }

    public void bwX() {
        this.iMT.bwX();
    }

    public void showLoadingView() {
        this.iMT.showLoadingView();
    }

    public void cpx() {
        this.iMT.pp(false);
    }

    public void dn(List<com.baidu.tieba.hottopic.data.e> list) {
        this.iMT.dj(list);
    }

    public void destroy() {
        if (this.iMT != null) {
            this.iMT.destroy();
        }
        if (this.iMR != null) {
            this.iMR.clearAnimation();
        }
        if (this.fqQ != null && this.hCK != null) {
            this.fqQ.b(this.hCK);
        }
    }

    public void resume() {
        if (this.iMT != null) {
            this.iMT.resume();
        }
    }

    public void pause() {
        if (this.iMT != null) {
            this.iMT.pause();
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
        return this.iMT.coA();
    }

    public int cpD() {
        return (this.cEo - this.iMV) - this.mNavigationBarHeight;
    }

    public void xS(int i) {
        if (this.iMT != null) {
            this.iMT.xS(i);
        }
    }

    public void xT(int i) {
        if (this.iMT != null) {
            this.iMT.xT(i);
        }
    }

    public void xU(int i) {
        if (this.iMT != null) {
            this.iMT.xU(i);
        }
    }

    public void a(AbsListView absListView, int i) {
        HotTopicView coA;
        if (this.iMS != null && this.iMU != null && (coA = this.iMT.coA()) != null && coA.getListView() != null && absListView == coA.getListView()) {
            this.iMU.setHeaderViewHeight(this.cEo - i);
            this.iMS.setY(-i);
            if (i == 0) {
                this.iMU.hW(false);
            } else {
                this.iMU.hW(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpE() {
        if (this.iMZ) {
            this.iNa = this.iMS.getY();
            this.iMZ = false;
        }
    }

    /* loaded from: classes15.dex */
    public abstract class a implements AbsListView.OnScrollListener {
        public a() {
        }
    }

    public HotTopicHeaderView cpF() {
        return this.iMS;
    }

    public int cpG() {
        return this.cEo;
    }
}
