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
/* loaded from: classes21.dex */
public class c {
    private int dvm;
    private TbPageContext<HotTopicActivity> eNx;
    private CustomViewPager eRw;
    private NoNetworkView gpu;
    private NoNetworkView.a iQf;
    private ImageView jYm;
    public ImageView jbo;
    private RelativeLayout kgg;
    private NavigationBar kgh;
    private ImageView kgi;
    private e kgj;
    private HotTopicHeaderView kgk;
    private HotTopicThreadPagerAdapter kgl;
    private DisableScrollLayout kgm;
    private int kgn;
    private TextView kgo;
    private com.baidu.tieba.hottopic.controller.c kgp;
    private boolean kgr;
    private float kgs;
    private NavigationBar mNavigationBar;
    private int mNavigationBarHeight;
    private String mTopicId;
    private final com.baidu.tbadk.widget.layout.e fNu = new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.hottopic.view.c.1
        @Override // com.baidu.tbadk.widget.layout.e
        public void d(View view, int i, int i2, int i3, int i4) {
            c.this.mNavigationBarHeight = i2;
            if (c.this.kgk != null) {
                c.this.kgk.Dv(i2);
            }
        }
    };
    private final com.baidu.tbadk.widget.layout.e kgq = new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.hottopic.view.c.2
        @Override // com.baidu.tbadk.widget.layout.e
        public void d(View view, int i, int i2, int i3, int i4) {
            c.this.dvm = i2;
            c.this.kgl.Dl(i2);
            c.this.kgm.setHeaderViewHeight(i2);
        }
    };
    private boolean kgt = false;
    private a kbN = new a() { // from class: com.baidu.tieba.hottopic.view.c.5
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            HotTopicView cRn = c.this.kgl.cRn();
            if (cRn != null && absListView == cRn.getListView() && i == 0) {
                c.this.kgr = true;
                float y = c.this.kgk.getY();
                if (c.this.kgl != null) {
                    if (Math.abs(c.this.kgs) != c.this.cSo() || c.this.kgs == y) {
                        c.this.kgl.Dp((int) (c.this.kgs - y));
                        return;
                    }
                    c.this.kgl.aK(y);
                    c.this.mNavigationBar.hideBottomLine();
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            HotTopicActivity hotTopicActivity;
            HotTopicView cRn = c.this.kgl.cRn();
            if (cRn != null) {
                if (absListView == cRn.getListView()) {
                    if (c.this.kgj != null) {
                        c.this.kgj.Dz(i);
                    }
                    c.this.cSp();
                }
                if (c.this.kgl != null && c.this.kgk.getNavigationBarSwitchHeight() != c.this.mNavigationBarHeight) {
                    if (c.this.kgt) {
                        float navigationBarSwitchHeight = (-c.this.kgk.getY()) / (c.this.kgk.getNavigationBarSwitchHeight() - c.this.mNavigationBarHeight);
                        c.this.mNavigationBar.setAlpha(1.0f - navigationBarSwitchHeight);
                        c.this.kgh.setAlpha(navigationBarSwitchHeight);
                        if (c.this.kgo != null) {
                            c.this.kgo.setAlpha((-c.this.kgk.getY()) / (c.this.kgk.getNavigationBarSwitchHeight() - c.this.mNavigationBarHeight));
                        }
                    } else {
                        if (c.this.kgo != null) {
                            c.this.kgo.setAlpha((-c.this.kgk.getY()) / (c.this.kgk.getNavigationBarSwitchHeight() - c.this.mNavigationBarHeight));
                        }
                        if (Math.abs(c.this.kgs) == c.this.cSo()) {
                            c.this.kgh.hideBottomLine();
                        } else {
                            c.this.kgh.showBottomLine();
                        }
                    }
                }
                if (i == 0 && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && (hotTopicActivity = (HotTopicActivity) c.this.eNx.getOrignalPage()) != null) {
                    hotTopicActivity.onScrollToBottom();
                }
            }
        }
    };

    public c(TbPageContext<HotTopicActivity> tbPageContext, String str) {
        this.eNx = tbPageContext;
        this.mTopicId = str;
        initView();
    }

    private void initView() {
        if (this.eNx != null) {
            this.eNx.getOrignalPage().setContentView(R.layout.hot_topic_activity);
            this.kgn = l.getDimens(this.eNx.getPageActivity(), R.dimen.ds80);
            this.kgp = new com.baidu.tieba.hottopic.controller.c((OvalActionButton) this.eNx.getOrignalPage().findViewById(R.id.topic_post_forum_button), this.eNx);
            this.kgp.setTopicId(this.mTopicId);
            this.kgg = (RelativeLayout) this.eNx.getOrignalPage().findViewById(R.id.hot_topic_root_view);
            this.kgm = (DisableScrollLayout) this.kgg.findViewById(R.id.disable_scroll_layout);
            this.mNavigationBar = (NavigationBar) this.eNx.getOrignalPage().findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.hideBottomLine();
            this.kgh = (NavigationBar) this.eNx.getOrignalPage().findViewById(R.id.view_navigation_bar_after_scroll);
            this.kgo = this.kgh.setCenterTextTitle("");
            this.kgo.setAlpha(0.0f);
            this.kgh.hideBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            ap.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.selector_topbar_return_white);
            this.kgh.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.jYm = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!j.isNetWorkAvailable()) {
                        ((HotTopicActivity) c.this.eNx.getOrignalPage()).showToast(R.string.topic_share_no_network);
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                    if (ShareSwitch.isOn() || bh.checkUpIsLogin(c.this.eNx.getContext())) {
                        TiebaStatic.log(new ar("c10521").dY("obj_id", ((HotTopicActivity) c.this.eNx.getOrignalPage()).cRD()).dY("topic_id", ((HotTopicActivity) c.this.eNx.getOrignalPage()).cRD()));
                        ((HotTopicActivity) c.this.eNx.getOrignalPage()).cRu();
                    }
                }
            });
            this.kgi = (ImageView) this.kgh.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!j.isNetWorkAvailable()) {
                        ((HotTopicActivity) c.this.eNx.getOrignalPage()).showToast(R.string.topic_share_no_network);
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                    if (ShareSwitch.isOn() || bh.checkUpIsLogin(c.this.eNx.getContext())) {
                        TiebaStatic.log(new ar("c10521").dY("obj_id", ((HotTopicActivity) c.this.eNx.getOrignalPage()).cRD()).dY("topic_id", ((HotTopicActivity) c.this.eNx.getOrignalPage()).cRD()));
                        ((HotTopicActivity) c.this.eNx.getOrignalPage()).cRu();
                    }
                }
            });
            this.gpu = (NoNetworkView) this.kgg.findViewById(R.id.view_no_network);
            ((ObservedChangeLinearLayout) this.kgg.findViewById(R.id.hot_topic_observed_change_layout)).setOnSizeChangeListener(this.fNu);
            this.kgj = new e(this.eNx, this.kgg);
            this.kgk = (HotTopicHeaderView) this.kgg.findViewById(R.id.hot_topic_header);
            this.kgk.setOnSizeChangeListener(this.kgq);
            this.eRw = (CustomViewPager) this.kgg.findViewById(R.id.hot_topic_view_pager);
            this.kgl = new HotTopicThreadPagerAdapter(this.eNx.getPageActivity(), this.kbN);
            this.kgl.setMainView(this);
            this.eRw.setAdapter(this.kgl);
            this.kgk.setViewPager(this.eRw);
            this.kgk.setHeaderBottomLineShow(false);
            this.jbo = (ImageView) this.kgg.findViewById(R.id.normal_write_icon);
            this.jbo.setVisibility(8);
        }
    }

    public void a(int i, boolean z, long j, int i2) {
        this.kgj.a(i, z, j, i2);
    }

    public void b(View.OnTouchListener onTouchListener) {
        if (onTouchListener != null && this.jbo != null) {
            this.jbo.setOnTouchListener(onTouchListener);
        }
    }

    public View cSh() {
        return this.kgg;
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null && this.kgt) {
            this.mNavigationBar.onChangeSkinType(this.eNx, i);
            this.mNavigationBar.setBackgroundResource(R.drawable.black_alpha_from_30_to_0);
            ap.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.selector_topbar_return_white);
            this.mNavigationBar.setAlpha((this.kgk.getY() / (this.kgk.getNavigationBarSwitchHeight() - this.mNavigationBarHeight)) + 1.0f);
        }
        if (this.kgh != null) {
            this.kgh.onChangeSkinType(this.eNx, i);
            if (this.kgt) {
                this.kgh.setAlpha((-this.kgk.getY()) / (this.kgk.getNavigationBarSwitchHeight() - this.mNavigationBarHeight));
            } else {
                this.kgh.setAlpha(1.0f);
            }
        }
        if (this.gpu != null) {
            this.gpu.onChangeSkinType(this.eNx, i);
        }
        if (this.kgi != null) {
            SvgManager.btW().a(this.kgi, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.jYm != null) {
            SvgManager.btW().a(this.jYm, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.kgk != null) {
            this.kgk.onChangeSkinType();
        }
        if (this.kgl != null) {
            this.kgl.onChangeSkinType(i);
        }
        if (this.jbo != null) {
            ap.setBackgroundResource(this.jbo, R.drawable.icon_tabbar_chaticon_n);
            ap.setImageResource(this.jbo, R.drawable.icon_tabbar_add_n);
        }
    }

    public void c(com.baidu.tieba.hottopic.data.e eVar) {
        if (eVar != null && eVar.cRS() != null) {
            if (!this.kgk.cSm()) {
                this.kgk.setData(eVar.cRS());
            }
            if (eVar.cRS() != null) {
                this.kgt = !StringUtils.isNull(eVar.cRS().kdH);
                this.mNavigationBar.setVisibility(this.kgt ? 0 : 8);
                if (!this.kgt) {
                    this.kgh.setAlpha(1.0f);
                    this.kgh.showBottomLine();
                }
            }
            String str = eVar.cRS().eIa;
            if (StringUtils.isNull(str)) {
                this.jbo.setVisibility(8);
                ME("");
            } else {
                ME(com.baidu.tieba.hottopic.b.a.aV(str, 10));
            }
            this.kgk.setHeaderBottomLineShow(true);
        }
    }

    private void ME(String str) {
        if (this.kgo != null) {
            this.kgo.setText(str);
        } else if (this.kgh != null) {
            this.kgo = this.kgh.setCenterTextTitle(str);
        }
    }

    public int getCurrentTab() {
        if (this.eRw.getCurrentItem() < 0) {
            return 0;
        }
        return this.eRw.getCurrentItem();
    }

    public void g(NoNetworkView.a aVar) {
        this.iQf = aVar;
        if (this.gpu != null) {
            this.gpu.a(this.iQf);
        }
    }

    public void Dw(int i) {
        this.kgk.setVisibility(i);
        this.eRw.setVisibility(i);
    }

    public void Yb() {
        this.kgl.Yb();
    }

    public void showLoadingView() {
        this.kgl.showLoadingView();
    }

    public void cSj() {
        this.kgl.rR(false);
    }

    public void eh(List<com.baidu.tieba.hottopic.data.e> list) {
        this.kgl.ed(list);
    }

    public void destroy() {
        if (this.kgl != null) {
            this.kgl.destroy();
        }
        if (this.kgj != null) {
            this.kgj.clearAnimation();
        }
        if (this.gpu != null && this.iQf != null) {
            this.gpu.b(this.iQf);
        }
    }

    public void resume() {
        if (this.kgl != null) {
            this.kgl.resume();
        }
    }

    public void pause() {
        if (this.kgl != null) {
            this.kgl.pause();
        }
    }

    public void rU(boolean z) {
        if (this.gpu != null) {
            if (z) {
                this.gpu.setVisibility(0);
            } else {
                this.gpu.setVisibility(8);
            }
        }
    }

    public HotTopicView cSn() {
        return this.kgl.cRn();
    }

    public int cSo() {
        return (this.dvm - this.kgn) - this.mNavigationBarHeight;
    }

    public void Dm(int i) {
        if (this.kgl != null) {
            this.kgl.Dm(i);
        }
    }

    public void Dn(int i) {
        if (this.kgl != null) {
            this.kgl.Dn(i);
        }
    }

    public void Do(int i) {
        if (this.kgl != null) {
            this.kgl.Do(i);
        }
    }

    public void a(AbsListView absListView, int i) {
        HotTopicView cRn;
        if (this.kgk != null && this.kgm != null && (cRn = this.kgl.cRn()) != null && cRn.getListView() != null && absListView == cRn.getListView()) {
            this.kgm.setHeaderViewHeight(this.dvm - i);
            this.kgk.setY(-i);
            if (i == 0) {
                this.kgm.jC(false);
            } else {
                this.kgm.jC(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSp() {
        if (this.kgr) {
            this.kgs = this.kgk.getY();
            this.kgr = false;
        }
    }

    /* loaded from: classes21.dex */
    public abstract class a implements AbsListView.OnScrollListener {
        public a() {
        }
    }

    public HotTopicHeaderView cSq() {
        return this.kgk;
    }

    public int cSr() {
        return this.dvm;
    }
}
