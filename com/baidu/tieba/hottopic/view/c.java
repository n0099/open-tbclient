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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bh;
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
/* loaded from: classes8.dex */
public class c {
    private int abW;
    private int dyO;
    private TbPageContext<HotTopicActivity> eUY;
    private CustomViewPager eZd;
    private NoNetworkView gxW;
    private ImageView jTp;
    private NoNetworkView.a jdt;
    public ImageView joE;
    private RelativeLayout kwW;
    private NavigationBar kwX;
    private ImageView kwY;
    private e kwZ;
    private HotTopicHeaderView kxa;
    private HotTopicThreadPagerAdapter kxb;
    private DisableScrollLayout kxc;
    private int kxd;
    private TextView kxe;
    private com.baidu.tieba.hottopic.controller.c kxf;
    private boolean kxh;
    private float kxi;
    private NavigationBar mNavigationBar;
    private String mTopicId;
    private final com.baidu.tbadk.widget.layout.e fUG = new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.hottopic.view.c.1
        @Override // com.baidu.tbadk.widget.layout.e
        public void f(View view, int i, int i2, int i3, int i4) {
            c.this.abW = i2;
            if (c.this.kxa != null) {
                c.this.kxa.Cu(i2);
            }
        }
    };
    private final com.baidu.tbadk.widget.layout.e kxg = new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.hottopic.view.c.2
        @Override // com.baidu.tbadk.widget.layout.e
        public void f(View view, int i, int i2, int i3, int i4) {
            c.this.dyO = i2;
            c.this.kxb.Ck(i2);
            c.this.kxc.setHeaderViewHeight(i2);
        }
    };
    private boolean kxj = false;
    private a ksD = new a() { // from class: com.baidu.tieba.hottopic.view.c.5
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            HotTopicView cSC = c.this.kxb.cSC();
            if (cSC != null && absListView == cSC.getListView() && i == 0) {
                c.this.kxh = true;
                float y = c.this.kxa.getY();
                if (c.this.kxb != null) {
                    if (Math.abs(c.this.kxi) != c.this.cTD() || c.this.kxi == y) {
                        c.this.kxb.Co((int) (c.this.kxi - y));
                        return;
                    }
                    c.this.kxb.aP(y);
                    c.this.mNavigationBar.hideBottomLine();
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            HotTopicActivity hotTopicActivity;
            HotTopicView cSC = c.this.kxb.cSC();
            if (cSC != null) {
                if (absListView == cSC.getListView()) {
                    if (c.this.kwZ != null) {
                        c.this.kwZ.Cy(i);
                    }
                    c.this.cTE();
                }
                if (c.this.kxb != null && c.this.kxa.getNavigationBarSwitchHeight() != c.this.abW) {
                    if (c.this.kxj) {
                        float navigationBarSwitchHeight = (-c.this.kxa.getY()) / (c.this.kxa.getNavigationBarSwitchHeight() - c.this.abW);
                        c.this.mNavigationBar.setAlpha(1.0f - navigationBarSwitchHeight);
                        c.this.kwX.setAlpha(navigationBarSwitchHeight);
                        if (c.this.kxe != null) {
                            c.this.kxe.setAlpha((-c.this.kxa.getY()) / (c.this.kxa.getNavigationBarSwitchHeight() - c.this.abW));
                        }
                    } else {
                        if (c.this.kxe != null) {
                            c.this.kxe.setAlpha((-c.this.kxa.getY()) / (c.this.kxa.getNavigationBarSwitchHeight() - c.this.abW));
                        }
                        if (Math.abs(c.this.kxi) == c.this.cTD()) {
                            c.this.kwX.hideBottomLine();
                        } else {
                            c.this.kwX.showBottomLine();
                        }
                    }
                }
                if (i == 0 && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && (hotTopicActivity = (HotTopicActivity) c.this.eUY.getOrignalPage()) != null) {
                    hotTopicActivity.onScrollToBottom();
                }
            }
        }
    };

    public c(TbPageContext<HotTopicActivity> tbPageContext, String str) {
        this.eUY = tbPageContext;
        this.mTopicId = str;
        initView();
    }

    private void initView() {
        if (this.eUY != null) {
            this.eUY.getOrignalPage().setContentView(R.layout.hot_topic_activity);
            this.kxd = l.getDimens(this.eUY.getPageActivity(), R.dimen.ds80);
            this.kxf = new com.baidu.tieba.hottopic.controller.c((OvalActionButton) this.eUY.getOrignalPage().findViewById(R.id.topic_post_forum_button), this.eUY);
            this.kxf.setTopicId(this.mTopicId);
            this.kwW = (RelativeLayout) this.eUY.getOrignalPage().findViewById(R.id.hot_topic_root_view);
            this.kxc = (DisableScrollLayout) this.kwW.findViewById(R.id.disable_scroll_layout);
            this.mNavigationBar = (NavigationBar) this.eUY.getOrignalPage().findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.hideBottomLine();
            this.kwX = (NavigationBar) this.eUY.getOrignalPage().findViewById(R.id.view_navigation_bar_after_scroll);
            this.kxe = this.kwX.setCenterTextTitle("");
            this.kxe.setAlpha(0.0f);
            this.kwX.hideBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            ap.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.selector_topbar_return_white);
            this.kwX.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.jTp = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!j.isNetWorkAvailable()) {
                        ((HotTopicActivity) c.this.eUY.getOrignalPage()).showToast(R.string.topic_share_no_network);
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                    if (ShareSwitch.isOn() || bh.checkUpIsLogin(c.this.eUY.getContext())) {
                        TiebaStatic.log(new ar("c10521").dR("obj_id", ((HotTopicActivity) c.this.eUY.getOrignalPage()).cSS()).dR("topic_id", ((HotTopicActivity) c.this.eUY.getOrignalPage()).cSS()));
                        ((HotTopicActivity) c.this.eUY.getOrignalPage()).cSJ();
                    }
                }
            });
            this.kwY = (ImageView) this.kwX.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!j.isNetWorkAvailable()) {
                        ((HotTopicActivity) c.this.eUY.getOrignalPage()).showToast(R.string.topic_share_no_network);
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                    if (ShareSwitch.isOn() || bh.checkUpIsLogin(c.this.eUY.getContext())) {
                        TiebaStatic.log(new ar("c10521").dR("obj_id", ((HotTopicActivity) c.this.eUY.getOrignalPage()).cSS()).dR("topic_id", ((HotTopicActivity) c.this.eUY.getOrignalPage()).cSS()));
                        ((HotTopicActivity) c.this.eUY.getOrignalPage()).cSJ();
                    }
                }
            });
            this.gxW = (NoNetworkView) this.kwW.findViewById(R.id.view_no_network);
            ((ObservedChangeLinearLayout) this.kwW.findViewById(R.id.hot_topic_observed_change_layout)).setOnSizeChangeListener(this.fUG);
            this.kwZ = new e(this.eUY, this.kwW);
            this.kxa = (HotTopicHeaderView) this.kwW.findViewById(R.id.hot_topic_header);
            this.kxa.setOnSizeChangeListener(this.kxg);
            this.eZd = (CustomViewPager) this.kwW.findViewById(R.id.hot_topic_view_pager);
            this.kxb = new HotTopicThreadPagerAdapter(this.eUY.getPageActivity(), this.ksD);
            this.kxb.setMainView(this);
            this.eZd.setAdapter(this.kxb);
            this.kxa.setViewPager(this.eZd);
            this.kxa.setHeaderBottomLineShow(false);
            this.joE = (ImageView) this.kwW.findViewById(R.id.normal_write_icon);
            this.joE.setVisibility(8);
        }
    }

    public void a(int i, boolean z, long j, int i2) {
        this.kwZ.a(i, z, j, i2);
    }

    public void b(View.OnTouchListener onTouchListener) {
        if (onTouchListener != null && this.joE != null) {
            this.joE.setOnTouchListener(onTouchListener);
        }
    }

    public View cTw() {
        return this.kwW;
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null && this.kxj) {
            this.mNavigationBar.onChangeSkinType(this.eUY, i);
            this.mNavigationBar.setBackgroundResource(R.drawable.black_alpha_from_30_to_0);
            ap.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.selector_topbar_return_white);
            this.mNavigationBar.setAlpha((this.kxa.getY() / (this.kxa.getNavigationBarSwitchHeight() - this.abW)) + 1.0f);
        }
        if (this.kwX != null) {
            this.kwX.onChangeSkinType(this.eUY, i);
            if (this.kxj) {
                this.kwX.setAlpha((-this.kxa.getY()) / (this.kxa.getNavigationBarSwitchHeight() - this.abW));
            } else {
                this.kwX.setAlpha(1.0f);
            }
        }
        if (this.gxW != null) {
            this.gxW.onChangeSkinType(this.eUY, i);
        }
        if (this.kwY != null) {
            SvgManager.bsR().a(this.kwY, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.jTp != null) {
            SvgManager.bsR().a(this.jTp, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.kxa != null) {
            this.kxa.onChangeSkinType();
        }
        if (this.kxb != null) {
            this.kxb.onChangeSkinType(i);
        }
        if (this.joE != null) {
            ap.setBackgroundResource(this.joE, R.drawable.icon_tabbar_chaticon_n);
            ap.setImageResource(this.joE, R.drawable.icon_tabbar_add_n);
        }
    }

    public void b(com.baidu.tieba.hottopic.data.e eVar) {
        if (eVar != null && eVar.cTh() != null) {
            if (!this.kxa.cTB()) {
                this.kxa.setData(eVar.cTh());
            }
            if (eVar.cTh() != null) {
                this.kxj = !StringUtils.isNull(eVar.cTh().kux);
                this.mNavigationBar.setVisibility(this.kxj ? 0 : 8);
                if (!this.kxj) {
                    this.kwX.setAlpha(1.0f);
                    this.kwX.showBottomLine();
                }
            }
            String str = eVar.cTh().ePt;
            if (StringUtils.isNull(str)) {
                this.joE.setVisibility(8);
                Mk("");
            } else {
                Mk(com.baidu.tieba.hottopic.a.a.be(str, 10));
            }
            this.kxa.setHeaderBottomLineShow(true);
        }
    }

    private void Mk(String str) {
        if (this.kxe != null) {
            this.kxe.setText(str);
        } else if (this.kwX != null) {
            this.kxe = this.kwX.setCenterTextTitle(str);
        }
    }

    public int getCurrentTab() {
        if (this.eZd.getCurrentItem() < 0) {
            return 0;
        }
        return this.eZd.getCurrentItem();
    }

    public void g(NoNetworkView.a aVar) {
        this.jdt = aVar;
        if (this.gxW != null) {
            this.gxW.a(this.jdt);
        }
    }

    public void Cv(int i) {
        this.kxa.setVisibility(i);
        this.eZd.setVisibility(i);
    }

    public void WZ() {
        this.kxb.WZ();
    }

    public void showLoadingView() {
        this.kxb.showLoadingView();
    }

    public void cTy() {
        this.kxb.sx(false);
    }

    public void em(List<com.baidu.tieba.hottopic.data.e> list) {
        this.kxb.ei(list);
    }

    public void destroy() {
        if (this.kxb != null) {
            this.kxb.destroy();
        }
        if (this.kwZ != null) {
            this.kwZ.clearAnimation();
        }
        if (this.gxW != null && this.jdt != null) {
            this.gxW.b(this.jdt);
        }
    }

    public void resume() {
        if (this.kxb != null) {
            this.kxb.resume();
        }
    }

    public void pause() {
        if (this.kxb != null) {
            this.kxb.pause();
        }
    }

    public void sA(boolean z) {
        if (this.gxW != null) {
            if (z) {
                this.gxW.setVisibility(0);
            } else {
                this.gxW.setVisibility(8);
            }
        }
    }

    public HotTopicView cTC() {
        return this.kxb.cSC();
    }

    public int cTD() {
        return (this.dyO - this.kxd) - this.abW;
    }

    public void Cl(int i) {
        if (this.kxb != null) {
            this.kxb.Cl(i);
        }
    }

    public void Cm(int i) {
        if (this.kxb != null) {
            this.kxb.Cm(i);
        }
    }

    public void Cn(int i) {
        if (this.kxb != null) {
            this.kxb.Cn(i);
        }
    }

    public void a(AbsListView absListView, int i) {
        HotTopicView cSC;
        if (this.kxa != null && this.kxc != null && (cSC = this.kxb.cSC()) != null && cSC.getListView() != null && absListView == cSC.getListView()) {
            this.kxc.setHeaderViewHeight(this.dyO - i);
            this.kxa.setY(-i);
            if (i == 0) {
                this.kxc.jX(false);
            } else {
                this.kxc.jX(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTE() {
        if (this.kxh) {
            this.kxi = this.kxa.getY();
            this.kxh = false;
        }
    }

    /* loaded from: classes8.dex */
    public abstract class a implements AbsListView.OnScrollListener {
        public a() {
        }
    }

    public HotTopicHeaderView cTF() {
        return this.kxa;
    }

    public int cTG() {
        return this.dyO;
    }
}
