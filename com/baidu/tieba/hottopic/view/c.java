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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bg;
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
/* loaded from: classes21.dex */
public class c {
    private int dpS;
    private TbPageContext<HotTopicActivity> eIc;
    private CustomViewPager eLl;
    private NoNetworkView ghD;
    private NoNetworkView.a iEz;
    public ImageView iPK;
    private ImageView jJY;
    private RelativeLayout jRS;
    private NavigationBar jRT;
    private ImageView jRU;
    private e jRV;
    private HotTopicHeaderView jRW;
    private HotTopicThreadPagerAdapter jRX;
    private DisableScrollLayout jRY;
    private int jRZ;
    private TextView jSa;
    private com.baidu.tieba.hottopic.controller.c jSb;
    private boolean jSd;
    private float jSe;
    private NavigationBar mNavigationBar;
    private int mNavigationBarHeight;
    private String mTopicId;
    private final com.baidu.tbadk.widget.layout.e fGg = new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.hottopic.view.c.1
        @Override // com.baidu.tbadk.widget.layout.e
        public void d(View view, int i, int i2, int i3, int i4) {
            c.this.mNavigationBarHeight = i2;
            if (c.this.jRW != null) {
                c.this.jRW.Ci(i2);
            }
        }
    };
    private final com.baidu.tbadk.widget.layout.e jSc = new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.hottopic.view.c.2
        @Override // com.baidu.tbadk.widget.layout.e
        public void d(View view, int i, int i2, int i3, int i4) {
            c.this.dpS = i2;
            c.this.jRX.BY(i2);
            c.this.jRY.setHeaderViewHeight(i2);
        }
    };
    private boolean jSf = false;
    private a jNA = new a() { // from class: com.baidu.tieba.hottopic.view.c.5
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            HotTopicView cMs = c.this.jRX.cMs();
            if (cMs != null && absListView == cMs.getListView() && i == 0) {
                c.this.jSd = true;
                float y = c.this.jRW.getY();
                if (c.this.jRX != null) {
                    if (Math.abs(c.this.jSe) != c.this.cNu() || c.this.jSe == y) {
                        c.this.jRX.Cc((int) (c.this.jSe - y));
                        return;
                    }
                    c.this.jRX.aC(y);
                    c.this.mNavigationBar.hideBottomLine();
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            HotTopicActivity hotTopicActivity;
            HotTopicView cMs = c.this.jRX.cMs();
            if (cMs != null) {
                if (absListView == cMs.getListView()) {
                    if (c.this.jRV != null) {
                        c.this.jRV.Cm(i);
                    }
                    c.this.cNv();
                }
                if (c.this.jRX != null && c.this.jRW.getNavigationBarSwitchHeight() != c.this.mNavigationBarHeight) {
                    if (c.this.jSf) {
                        float navigationBarSwitchHeight = (-c.this.jRW.getY()) / (c.this.jRW.getNavigationBarSwitchHeight() - c.this.mNavigationBarHeight);
                        c.this.mNavigationBar.setAlpha(1.0f - navigationBarSwitchHeight);
                        c.this.jRT.setAlpha(navigationBarSwitchHeight);
                        if (c.this.jSa != null) {
                            c.this.jSa.setAlpha((-c.this.jRW.getY()) / (c.this.jRW.getNavigationBarSwitchHeight() - c.this.mNavigationBarHeight));
                        }
                    } else {
                        if (c.this.jSa != null) {
                            c.this.jSa.setAlpha((-c.this.jRW.getY()) / (c.this.jRW.getNavigationBarSwitchHeight() - c.this.mNavigationBarHeight));
                        }
                        if (Math.abs(c.this.jSe) == c.this.cNu()) {
                            c.this.jRT.hideBottomLine();
                        } else {
                            c.this.jRT.showBottomLine();
                        }
                    }
                }
                if (i == 0 && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && (hotTopicActivity = (HotTopicActivity) c.this.eIc.getOrignalPage()) != null) {
                    hotTopicActivity.onScrollToBottom();
                }
            }
        }
    };

    public c(TbPageContext<HotTopicActivity> tbPageContext, String str) {
        this.eIc = tbPageContext;
        this.mTopicId = str;
        initView();
    }

    private void initView() {
        if (this.eIc != null) {
            this.eIc.getOrignalPage().setContentView(R.layout.hot_topic_activity);
            this.jRZ = l.getDimens(this.eIc.getPageActivity(), R.dimen.ds80);
            this.jSb = new com.baidu.tieba.hottopic.controller.c((OvalActionButton) this.eIc.getOrignalPage().findViewById(R.id.topic_post_forum_button), this.eIc);
            this.jSb.setTopicId(this.mTopicId);
            this.jRS = (RelativeLayout) this.eIc.getOrignalPage().findViewById(R.id.hot_topic_root_view);
            this.jRY = (DisableScrollLayout) this.jRS.findViewById(R.id.disable_scroll_layout);
            this.mNavigationBar = (NavigationBar) this.eIc.getOrignalPage().findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.hideBottomLine();
            this.jRT = (NavigationBar) this.eIc.getOrignalPage().findViewById(R.id.view_navigation_bar_after_scroll);
            this.jSa = this.jRT.setCenterTextTitle("");
            this.jSa.setAlpha(0.0f);
            this.jRT.hideBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            ap.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.selector_topbar_return_white);
            this.jRT.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.jJY = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!j.isNetWorkAvailable()) {
                        ((HotTopicActivity) c.this.eIc.getOrignalPage()).showToast(R.string.topic_share_no_network);
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                    if (ShareSwitch.isOn() || bg.checkUpIsLogin(c.this.eIc.getContext())) {
                        TiebaStatic.log(new aq("c10521").dR("obj_id", ((HotTopicActivity) c.this.eIc.getOrignalPage()).cMI()).dR("topic_id", ((HotTopicActivity) c.this.eIc.getOrignalPage()).cMI()));
                        ((HotTopicActivity) c.this.eIc.getOrignalPage()).cMz();
                    }
                }
            });
            this.jRU = (ImageView) this.jRT.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!j.isNetWorkAvailable()) {
                        ((HotTopicActivity) c.this.eIc.getOrignalPage()).showToast(R.string.topic_share_no_network);
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                    if (ShareSwitch.isOn() || bg.checkUpIsLogin(c.this.eIc.getContext())) {
                        TiebaStatic.log(new aq("c10521").dR("obj_id", ((HotTopicActivity) c.this.eIc.getOrignalPage()).cMI()).dR("topic_id", ((HotTopicActivity) c.this.eIc.getOrignalPage()).cMI()));
                        ((HotTopicActivity) c.this.eIc.getOrignalPage()).cMz();
                    }
                }
            });
            this.ghD = (NoNetworkView) this.jRS.findViewById(R.id.view_no_network);
            ((ObservedChangeLinearLayout) this.jRS.findViewById(R.id.hot_topic_observed_change_layout)).setOnSizeChangeListener(this.fGg);
            this.jRV = new e(this.eIc, this.jRS);
            this.jRW = (HotTopicHeaderView) this.jRS.findViewById(R.id.hot_topic_header);
            this.jRW.setOnSizeChangeListener(this.jSc);
            this.eLl = (CustomViewPager) this.jRS.findViewById(R.id.hot_topic_view_pager);
            this.jRX = new HotTopicThreadPagerAdapter(this.eIc.getPageActivity(), this.jNA);
            this.jRX.setMainView(this);
            this.eLl.setAdapter(this.jRX);
            this.jRW.setViewPager(this.eLl);
            this.jRW.setHeaderBottomLineShow(false);
            this.iPK = (ImageView) this.jRS.findViewById(R.id.normal_write_icon);
            this.iPK.setVisibility(8);
        }
    }

    public void a(int i, boolean z, long j, int i2) {
        this.jRV.a(i, z, j, i2);
    }

    public void b(View.OnTouchListener onTouchListener) {
        if (onTouchListener != null && this.iPK != null) {
            this.iPK.setOnTouchListener(onTouchListener);
        }
    }

    public View cNn() {
        return this.jRS;
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null && this.jSf) {
            this.mNavigationBar.onChangeSkinType(this.eIc, i);
            this.mNavigationBar.setBackgroundResource(R.drawable.black_alpha_from_30_to_0);
            ap.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.selector_topbar_return_white);
            this.mNavigationBar.setAlpha((this.jRW.getY() / (this.jRW.getNavigationBarSwitchHeight() - this.mNavigationBarHeight)) + 1.0f);
        }
        if (this.jRT != null) {
            this.jRT.onChangeSkinType(this.eIc, i);
            if (this.jSf) {
                this.jRT.setAlpha((-this.jRW.getY()) / (this.jRW.getNavigationBarSwitchHeight() - this.mNavigationBarHeight));
            } else {
                this.jRT.setAlpha(1.0f);
            }
        }
        if (this.ghD != null) {
            this.ghD.onChangeSkinType(this.eIc, i);
        }
        if (this.jRU != null) {
            SvgManager.brn().a(this.jRU, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.jJY != null) {
            SvgManager.brn().a(this.jJY, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.jRW != null) {
            this.jRW.onChangeSkinType();
        }
        if (this.jRX != null) {
            this.jRX.onChangeSkinType(i);
        }
        if (this.iPK != null) {
            ap.setBackgroundResource(this.iPK, R.drawable.icon_tabbar_chaticon_n);
            ap.setImageResource(this.iPK, R.drawable.icon_tabbar_add_n);
        }
    }

    public void c(com.baidu.tieba.hottopic.data.e eVar) {
        if (eVar != null && eVar.cMX() != null) {
            if (!this.jRW.cNs()) {
                this.jRW.setData(eVar.cMX());
            }
            if (eVar.cMX() != null) {
                this.jSf = !StringUtils.isNull(eVar.cMX().jPu);
                this.mNavigationBar.setVisibility(this.jSf ? 0 : 8);
                if (!this.jSf) {
                    this.jRT.setAlpha(1.0f);
                    this.jRT.showBottomLine();
                }
            }
            String str = eVar.cMX().eCJ;
            if (StringUtils.isNull(str)) {
                this.iPK.setVisibility(8);
                LW("");
            } else {
                LW(com.baidu.tieba.hottopic.b.a.aV(str, 10));
            }
            this.jRW.setHeaderBottomLineShow(true);
        }
    }

    private void LW(String str) {
        if (this.jSa != null) {
            this.jSa.setText(str);
        } else if (this.jRT != null) {
            this.jSa = this.jRT.setCenterTextTitle(str);
        }
    }

    public int getCurrentTab() {
        if (this.eLl.getCurrentItem() < 0) {
            return 0;
        }
        return this.eLl.getCurrentItem();
    }

    public void g(NoNetworkView.a aVar) {
        this.iEz = aVar;
        if (this.ghD != null) {
            this.ghD.a(this.iEz);
        }
    }

    public void Cj(int i) {
        this.jRW.setVisibility(i);
        this.eLl.setVisibility(i);
    }

    public void Wk() {
        this.jRX.Wk();
    }

    public void showLoadingView() {
        this.jRX.showLoadingView();
    }

    public void cNp() {
        this.jRX.rm(false);
    }

    public void dW(List<com.baidu.tieba.hottopic.data.e> list) {
        this.jRX.dS(list);
    }

    public void destroy() {
        if (this.jRX != null) {
            this.jRX.destroy();
        }
        if (this.jRV != null) {
            this.jRV.clearAnimation();
        }
        if (this.ghD != null && this.iEz != null) {
            this.ghD.b(this.iEz);
        }
    }

    public void resume() {
        if (this.jRX != null) {
            this.jRX.resume();
        }
    }

    public void pause() {
        if (this.jRX != null) {
            this.jRX.pause();
        }
    }

    public void rp(boolean z) {
        if (this.ghD != null) {
            if (z) {
                this.ghD.setVisibility(0);
            } else {
                this.ghD.setVisibility(8);
            }
        }
    }

    public HotTopicView cNt() {
        return this.jRX.cMs();
    }

    public int cNu() {
        return (this.dpS - this.jRZ) - this.mNavigationBarHeight;
    }

    public void BZ(int i) {
        if (this.jRX != null) {
            this.jRX.BZ(i);
        }
    }

    public void Ca(int i) {
        if (this.jRX != null) {
            this.jRX.Ca(i);
        }
    }

    public void Cb(int i) {
        if (this.jRX != null) {
            this.jRX.Cb(i);
        }
    }

    public void a(AbsListView absListView, int i) {
        HotTopicView cMs;
        if (this.jRW != null && this.jRY != null && (cMs = this.jRX.cMs()) != null && cMs.getListView() != null && absListView == cMs.getListView()) {
            this.jRY.setHeaderViewHeight(this.dpS - i);
            this.jRW.setY(-i);
            if (i == 0) {
                this.jRY.jl(false);
            } else {
                this.jRY.jl(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cNv() {
        if (this.jSd) {
            this.jSe = this.jRW.getY();
            this.jSd = false;
        }
    }

    /* loaded from: classes21.dex */
    public abstract class a implements AbsListView.OnScrollListener {
        public a() {
        }
    }

    public HotTopicHeaderView cNw() {
        return this.jRW;
    }

    public int cNx() {
        return this.dpS;
    }
}
