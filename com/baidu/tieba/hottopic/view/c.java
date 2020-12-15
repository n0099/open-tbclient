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
    private NoNetworkView gpw;
    private NoNetworkView.a iQh;
    private ImageView jYo;
    public ImageView jbq;
    private RelativeLayout kgi;
    private NavigationBar kgj;
    private ImageView kgk;
    private e kgl;
    private HotTopicHeaderView kgm;
    private HotTopicThreadPagerAdapter kgn;
    private DisableScrollLayout kgo;
    private int kgp;
    private TextView kgq;
    private com.baidu.tieba.hottopic.controller.c kgr;
    private boolean kgt;
    private float kgu;
    private NavigationBar mNavigationBar;
    private int mNavigationBarHeight;
    private String mTopicId;
    private final com.baidu.tbadk.widget.layout.e fNu = new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.hottopic.view.c.1
        @Override // com.baidu.tbadk.widget.layout.e
        public void d(View view, int i, int i2, int i3, int i4) {
            c.this.mNavigationBarHeight = i2;
            if (c.this.kgm != null) {
                c.this.kgm.Dv(i2);
            }
        }
    };
    private final com.baidu.tbadk.widget.layout.e kgs = new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.hottopic.view.c.2
        @Override // com.baidu.tbadk.widget.layout.e
        public void d(View view, int i, int i2, int i3, int i4) {
            c.this.dvm = i2;
            c.this.kgn.Dl(i2);
            c.this.kgo.setHeaderViewHeight(i2);
        }
    };
    private boolean kgv = false;
    private a kbP = new a() { // from class: com.baidu.tieba.hottopic.view.c.5
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            HotTopicView cRo = c.this.kgn.cRo();
            if (cRo != null && absListView == cRo.getListView() && i == 0) {
                c.this.kgt = true;
                float y = c.this.kgm.getY();
                if (c.this.kgn != null) {
                    if (Math.abs(c.this.kgu) != c.this.cSp() || c.this.kgu == y) {
                        c.this.kgn.Dp((int) (c.this.kgu - y));
                        return;
                    }
                    c.this.kgn.aK(y);
                    c.this.mNavigationBar.hideBottomLine();
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            HotTopicActivity hotTopicActivity;
            HotTopicView cRo = c.this.kgn.cRo();
            if (cRo != null) {
                if (absListView == cRo.getListView()) {
                    if (c.this.kgl != null) {
                        c.this.kgl.Dz(i);
                    }
                    c.this.cSq();
                }
                if (c.this.kgn != null && c.this.kgm.getNavigationBarSwitchHeight() != c.this.mNavigationBarHeight) {
                    if (c.this.kgv) {
                        float navigationBarSwitchHeight = (-c.this.kgm.getY()) / (c.this.kgm.getNavigationBarSwitchHeight() - c.this.mNavigationBarHeight);
                        c.this.mNavigationBar.setAlpha(1.0f - navigationBarSwitchHeight);
                        c.this.kgj.setAlpha(navigationBarSwitchHeight);
                        if (c.this.kgq != null) {
                            c.this.kgq.setAlpha((-c.this.kgm.getY()) / (c.this.kgm.getNavigationBarSwitchHeight() - c.this.mNavigationBarHeight));
                        }
                    } else {
                        if (c.this.kgq != null) {
                            c.this.kgq.setAlpha((-c.this.kgm.getY()) / (c.this.kgm.getNavigationBarSwitchHeight() - c.this.mNavigationBarHeight));
                        }
                        if (Math.abs(c.this.kgu) == c.this.cSp()) {
                            c.this.kgj.hideBottomLine();
                        } else {
                            c.this.kgj.showBottomLine();
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
            this.kgp = l.getDimens(this.eNx.getPageActivity(), R.dimen.ds80);
            this.kgr = new com.baidu.tieba.hottopic.controller.c((OvalActionButton) this.eNx.getOrignalPage().findViewById(R.id.topic_post_forum_button), this.eNx);
            this.kgr.setTopicId(this.mTopicId);
            this.kgi = (RelativeLayout) this.eNx.getOrignalPage().findViewById(R.id.hot_topic_root_view);
            this.kgo = (DisableScrollLayout) this.kgi.findViewById(R.id.disable_scroll_layout);
            this.mNavigationBar = (NavigationBar) this.eNx.getOrignalPage().findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.hideBottomLine();
            this.kgj = (NavigationBar) this.eNx.getOrignalPage().findViewById(R.id.view_navigation_bar_after_scroll);
            this.kgq = this.kgj.setCenterTextTitle("");
            this.kgq.setAlpha(0.0f);
            this.kgj.hideBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            ap.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.selector_topbar_return_white);
            this.kgj.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.jYo = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!j.isNetWorkAvailable()) {
                        ((HotTopicActivity) c.this.eNx.getOrignalPage()).showToast(R.string.topic_share_no_network);
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                    if (ShareSwitch.isOn() || bh.checkUpIsLogin(c.this.eNx.getContext())) {
                        TiebaStatic.log(new ar("c10521").dY("obj_id", ((HotTopicActivity) c.this.eNx.getOrignalPage()).cRE()).dY("topic_id", ((HotTopicActivity) c.this.eNx.getOrignalPage()).cRE()));
                        ((HotTopicActivity) c.this.eNx.getOrignalPage()).cRv();
                    }
                }
            });
            this.kgk = (ImageView) this.kgj.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!j.isNetWorkAvailable()) {
                        ((HotTopicActivity) c.this.eNx.getOrignalPage()).showToast(R.string.topic_share_no_network);
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                    if (ShareSwitch.isOn() || bh.checkUpIsLogin(c.this.eNx.getContext())) {
                        TiebaStatic.log(new ar("c10521").dY("obj_id", ((HotTopicActivity) c.this.eNx.getOrignalPage()).cRE()).dY("topic_id", ((HotTopicActivity) c.this.eNx.getOrignalPage()).cRE()));
                        ((HotTopicActivity) c.this.eNx.getOrignalPage()).cRv();
                    }
                }
            });
            this.gpw = (NoNetworkView) this.kgi.findViewById(R.id.view_no_network);
            ((ObservedChangeLinearLayout) this.kgi.findViewById(R.id.hot_topic_observed_change_layout)).setOnSizeChangeListener(this.fNu);
            this.kgl = new e(this.eNx, this.kgi);
            this.kgm = (HotTopicHeaderView) this.kgi.findViewById(R.id.hot_topic_header);
            this.kgm.setOnSizeChangeListener(this.kgs);
            this.eRw = (CustomViewPager) this.kgi.findViewById(R.id.hot_topic_view_pager);
            this.kgn = new HotTopicThreadPagerAdapter(this.eNx.getPageActivity(), this.kbP);
            this.kgn.setMainView(this);
            this.eRw.setAdapter(this.kgn);
            this.kgm.setViewPager(this.eRw);
            this.kgm.setHeaderBottomLineShow(false);
            this.jbq = (ImageView) this.kgi.findViewById(R.id.normal_write_icon);
            this.jbq.setVisibility(8);
        }
    }

    public void a(int i, boolean z, long j, int i2) {
        this.kgl.a(i, z, j, i2);
    }

    public void b(View.OnTouchListener onTouchListener) {
        if (onTouchListener != null && this.jbq != null) {
            this.jbq.setOnTouchListener(onTouchListener);
        }
    }

    public View cSi() {
        return this.kgi;
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null && this.kgv) {
            this.mNavigationBar.onChangeSkinType(this.eNx, i);
            this.mNavigationBar.setBackgroundResource(R.drawable.black_alpha_from_30_to_0);
            ap.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.selector_topbar_return_white);
            this.mNavigationBar.setAlpha((this.kgm.getY() / (this.kgm.getNavigationBarSwitchHeight() - this.mNavigationBarHeight)) + 1.0f);
        }
        if (this.kgj != null) {
            this.kgj.onChangeSkinType(this.eNx, i);
            if (this.kgv) {
                this.kgj.setAlpha((-this.kgm.getY()) / (this.kgm.getNavigationBarSwitchHeight() - this.mNavigationBarHeight));
            } else {
                this.kgj.setAlpha(1.0f);
            }
        }
        if (this.gpw != null) {
            this.gpw.onChangeSkinType(this.eNx, i);
        }
        if (this.kgk != null) {
            SvgManager.btW().a(this.kgk, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.jYo != null) {
            SvgManager.btW().a(this.jYo, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.kgm != null) {
            this.kgm.onChangeSkinType();
        }
        if (this.kgn != null) {
            this.kgn.onChangeSkinType(i);
        }
        if (this.jbq != null) {
            ap.setBackgroundResource(this.jbq, R.drawable.icon_tabbar_chaticon_n);
            ap.setImageResource(this.jbq, R.drawable.icon_tabbar_add_n);
        }
    }

    public void c(com.baidu.tieba.hottopic.data.e eVar) {
        if (eVar != null && eVar.cRT() != null) {
            if (!this.kgm.cSn()) {
                this.kgm.setData(eVar.cRT());
            }
            if (eVar.cRT() != null) {
                this.kgv = !StringUtils.isNull(eVar.cRT().kdJ);
                this.mNavigationBar.setVisibility(this.kgv ? 0 : 8);
                if (!this.kgv) {
                    this.kgj.setAlpha(1.0f);
                    this.kgj.showBottomLine();
                }
            }
            String str = eVar.cRT().eIa;
            if (StringUtils.isNull(str)) {
                this.jbq.setVisibility(8);
                ME("");
            } else {
                ME(com.baidu.tieba.hottopic.b.a.aV(str, 10));
            }
            this.kgm.setHeaderBottomLineShow(true);
        }
    }

    private void ME(String str) {
        if (this.kgq != null) {
            this.kgq.setText(str);
        } else if (this.kgj != null) {
            this.kgq = this.kgj.setCenterTextTitle(str);
        }
    }

    public int getCurrentTab() {
        if (this.eRw.getCurrentItem() < 0) {
            return 0;
        }
        return this.eRw.getCurrentItem();
    }

    public void g(NoNetworkView.a aVar) {
        this.iQh = aVar;
        if (this.gpw != null) {
            this.gpw.a(this.iQh);
        }
    }

    public void Dw(int i) {
        this.kgm.setVisibility(i);
        this.eRw.setVisibility(i);
    }

    public void Yb() {
        this.kgn.Yb();
    }

    public void showLoadingView() {
        this.kgn.showLoadingView();
    }

    public void cSk() {
        this.kgn.rR(false);
    }

    public void eh(List<com.baidu.tieba.hottopic.data.e> list) {
        this.kgn.ed(list);
    }

    public void destroy() {
        if (this.kgn != null) {
            this.kgn.destroy();
        }
        if (this.kgl != null) {
            this.kgl.clearAnimation();
        }
        if (this.gpw != null && this.iQh != null) {
            this.gpw.b(this.iQh);
        }
    }

    public void resume() {
        if (this.kgn != null) {
            this.kgn.resume();
        }
    }

    public void pause() {
        if (this.kgn != null) {
            this.kgn.pause();
        }
    }

    public void rU(boolean z) {
        if (this.gpw != null) {
            if (z) {
                this.gpw.setVisibility(0);
            } else {
                this.gpw.setVisibility(8);
            }
        }
    }

    public HotTopicView cSo() {
        return this.kgn.cRo();
    }

    public int cSp() {
        return (this.dvm - this.kgp) - this.mNavigationBarHeight;
    }

    public void Dm(int i) {
        if (this.kgn != null) {
            this.kgn.Dm(i);
        }
    }

    public void Dn(int i) {
        if (this.kgn != null) {
            this.kgn.Dn(i);
        }
    }

    public void Do(int i) {
        if (this.kgn != null) {
            this.kgn.Do(i);
        }
    }

    public void a(AbsListView absListView, int i) {
        HotTopicView cRo;
        if (this.kgm != null && this.kgo != null && (cRo = this.kgn.cRo()) != null && cRo.getListView() != null && absListView == cRo.getListView()) {
            this.kgo.setHeaderViewHeight(this.dvm - i);
            this.kgm.setY(-i);
            if (i == 0) {
                this.kgo.jC(false);
            } else {
                this.kgo.jC(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSq() {
        if (this.kgt) {
            this.kgu = this.kgm.getY();
            this.kgt = false;
        }
    }

    /* loaded from: classes21.dex */
    public abstract class a implements AbsListView.OnScrollListener {
        public a() {
        }
    }

    public HotTopicHeaderView cSr() {
        return this.kgm;
    }

    public int cSs() {
        return this.dvm;
    }
}
