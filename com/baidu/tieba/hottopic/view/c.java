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
/* loaded from: classes15.dex */
public class c {
    private int cNq;
    private TbPageContext<HotTopicActivity> efr;
    private CustomViewPager eiA;
    private NoNetworkView fCq;
    private NoNetworkView.a hQf;
    private ImageView iTV;
    public ImageView ibp;
    private RelativeLayout jbS;
    private NavigationBar jbT;
    private ImageView jbU;
    private e jbV;
    private HotTopicHeaderView jbW;
    private HotTopicThreadPagerAdapter jbX;
    private DisableScrollLayout jbY;
    private int jbZ;
    private TextView jca;
    private com.baidu.tieba.hottopic.controller.c jcb;
    private boolean jcd;
    private float jce;
    private NavigationBar mNavigationBar;
    private int mNavigationBarHeight;
    private String mTopicId;
    private final com.baidu.tbadk.widget.layout.e fcM = new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.hottopic.view.c.1
        @Override // com.baidu.tbadk.widget.layout.e
        public void d(View view, int i, int i2, int i3, int i4) {
            c.this.mNavigationBarHeight = i2;
            if (c.this.jbW != null) {
                c.this.jbW.Av(i2);
            }
        }
    };
    private final com.baidu.tbadk.widget.layout.e jcc = new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.hottopic.view.c.2
        @Override // com.baidu.tbadk.widget.layout.e
        public void d(View view, int i, int i2, int i3, int i4) {
            c.this.cNq = i2;
            c.this.jbX.Al(i2);
            c.this.jbY.setHeaderViewHeight(i2);
        }
    };
    private boolean jcf = false;
    private a iXy = new a() { // from class: com.baidu.tieba.hottopic.view.c.5
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            HotTopicView czu = c.this.jbX.czu();
            if (czu != null && absListView == czu.getListView() && i == 0) {
                c.this.jcd = true;
                float y = c.this.jbW.getY();
                if (c.this.jbX != null) {
                    if (Math.abs(c.this.jce) != c.this.cAw() || c.this.jce == y) {
                        c.this.jbX.Ap((int) (c.this.jce - y));
                        return;
                    }
                    c.this.jbX.as(y);
                    c.this.mNavigationBar.hideBottomLine();
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            HotTopicActivity hotTopicActivity;
            HotTopicView czu = c.this.jbX.czu();
            if (czu != null) {
                if (absListView == czu.getListView()) {
                    if (c.this.jbV != null) {
                        c.this.jbV.Az(i);
                    }
                    c.this.cAx();
                }
                if (c.this.jbX != null && c.this.jbW.getNavigationBarSwitchHeight() != c.this.mNavigationBarHeight) {
                    if (c.this.jcf) {
                        float navigationBarSwitchHeight = (-c.this.jbW.getY()) / (c.this.jbW.getNavigationBarSwitchHeight() - c.this.mNavigationBarHeight);
                        c.this.mNavigationBar.setAlpha(1.0f - navigationBarSwitchHeight);
                        c.this.jbT.setAlpha(navigationBarSwitchHeight);
                        if (c.this.jca != null) {
                            c.this.jca.setAlpha((-c.this.jbW.getY()) / (c.this.jbW.getNavigationBarSwitchHeight() - c.this.mNavigationBarHeight));
                        }
                    } else {
                        if (c.this.jca != null) {
                            c.this.jca.setAlpha((-c.this.jbW.getY()) / (c.this.jbW.getNavigationBarSwitchHeight() - c.this.mNavigationBarHeight));
                        }
                        if (Math.abs(c.this.jce) == c.this.cAw()) {
                            c.this.jbT.hideBottomLine();
                        } else {
                            c.this.jbT.showBottomLine();
                        }
                    }
                }
                if (i == 0 && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && (hotTopicActivity = (HotTopicActivity) c.this.efr.getOrignalPage()) != null) {
                    hotTopicActivity.onScrollToBottom();
                }
            }
        }
    };

    public c(TbPageContext<HotTopicActivity> tbPageContext, String str) {
        this.efr = tbPageContext;
        this.mTopicId = str;
        initView();
    }

    private void initView() {
        if (this.efr != null) {
            this.efr.getOrignalPage().setContentView(R.layout.hot_topic_activity);
            this.jbZ = l.getDimens(this.efr.getPageActivity(), R.dimen.ds80);
            this.jcb = new com.baidu.tieba.hottopic.controller.c((OvalActionButton) this.efr.getOrignalPage().findViewById(R.id.topic_post_forum_button), this.efr);
            this.jcb.setTopicId(this.mTopicId);
            this.jbS = (RelativeLayout) this.efr.getOrignalPage().findViewById(R.id.hot_topic_root_view);
            this.jbY = (DisableScrollLayout) this.jbS.findViewById(R.id.disable_scroll_layout);
            this.mNavigationBar = (NavigationBar) this.efr.getOrignalPage().findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.hideBottomLine();
            this.jbT = (NavigationBar) this.efr.getOrignalPage().findViewById(R.id.view_navigation_bar_after_scroll);
            this.jca = this.jbT.setCenterTextTitle("");
            this.jca.setAlpha(0.0f);
            this.jbT.hideBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            ap.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.selector_topbar_return_white);
            this.jbT.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.iTV = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!j.isNetWorkAvailable()) {
                        ((HotTopicActivity) c.this.efr.getOrignalPage()).showToast(R.string.topic_share_no_network);
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                    if (ShareSwitch.isOn() || bg.checkUpIsLogin(c.this.efr.getContext())) {
                        TiebaStatic.log(new aq("c10521").dD("obj_id", ((HotTopicActivity) c.this.efr.getOrignalPage()).czK()).dD("topic_id", ((HotTopicActivity) c.this.efr.getOrignalPage()).czK()));
                        ((HotTopicActivity) c.this.efr.getOrignalPage()).czB();
                    }
                }
            });
            this.jbU = (ImageView) this.jbT.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!j.isNetWorkAvailable()) {
                        ((HotTopicActivity) c.this.efr.getOrignalPage()).showToast(R.string.topic_share_no_network);
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                    if (ShareSwitch.isOn() || bg.checkUpIsLogin(c.this.efr.getContext())) {
                        TiebaStatic.log(new aq("c10521").dD("obj_id", ((HotTopicActivity) c.this.efr.getOrignalPage()).czK()).dD("topic_id", ((HotTopicActivity) c.this.efr.getOrignalPage()).czK()));
                        ((HotTopicActivity) c.this.efr.getOrignalPage()).czB();
                    }
                }
            });
            this.fCq = (NoNetworkView) this.jbS.findViewById(R.id.view_no_network);
            ((ObservedChangeLinearLayout) this.jbS.findViewById(R.id.hot_topic_observed_change_layout)).setOnSizeChangeListener(this.fcM);
            this.jbV = new e(this.efr, this.jbS);
            this.jbW = (HotTopicHeaderView) this.jbS.findViewById(R.id.hot_topic_header);
            this.jbW.setOnSizeChangeListener(this.jcc);
            this.eiA = (CustomViewPager) this.jbS.findViewById(R.id.hot_topic_view_pager);
            this.jbX = new HotTopicThreadPagerAdapter(this.efr.getPageActivity(), this.iXy);
            this.jbX.setMainView(this);
            this.eiA.setAdapter(this.jbX);
            this.jbW.setViewPager(this.eiA);
            this.jbW.setHeaderBottomLineShow(false);
            this.ibp = (ImageView) this.jbS.findViewById(R.id.normal_write_icon);
            this.ibp.setVisibility(8);
        }
    }

    public void a(int i, boolean z, long j, int i2) {
        this.jbV.a(i, z, j, i2);
    }

    public void b(View.OnTouchListener onTouchListener) {
        if (onTouchListener != null && this.ibp != null) {
            this.ibp.setOnTouchListener(onTouchListener);
        }
    }

    public View cAp() {
        return this.jbS;
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null && this.jcf) {
            this.mNavigationBar.onChangeSkinType(this.efr, i);
            this.mNavigationBar.setBackgroundResource(R.drawable.black_alpha_from_30_to_0);
            ap.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.selector_topbar_return_white);
            this.mNavigationBar.setAlpha((this.jbW.getY() / (this.jbW.getNavigationBarSwitchHeight() - this.mNavigationBarHeight)) + 1.0f);
        }
        if (this.jbT != null) {
            this.jbT.onChangeSkinType(this.efr, i);
            if (this.jcf) {
                this.jbT.setAlpha((-this.jbW.getY()) / (this.jbW.getNavigationBarSwitchHeight() - this.mNavigationBarHeight));
            } else {
                this.jbT.setAlpha(1.0f);
            }
        }
        if (this.fCq != null) {
            this.fCq.onChangeSkinType(this.efr, i);
        }
        if (this.jbU != null) {
            SvgManager.bjq().a(this.jbU, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.iTV != null) {
            SvgManager.bjq().a(this.iTV, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.jbW != null) {
            this.jbW.onChangeSkinType();
        }
        if (this.jbX != null) {
            this.jbX.onChangeSkinType(i);
        }
        if (this.ibp != null) {
            ap.setBackgroundResource(this.ibp, R.drawable.icon_tabbar_chaticon_n);
            ap.setImageResource(this.ibp, R.drawable.icon_tabbar_add_n);
        }
    }

    public void c(com.baidu.tieba.hottopic.data.e eVar) {
        if (eVar != null && eVar.czZ() != null) {
            if (!this.jbW.cAu()) {
                this.jbW.setData(eVar.czZ());
            }
            if (eVar.czZ() != null) {
                this.jcf = !StringUtils.isNull(eVar.czZ().iZt);
                this.mNavigationBar.setVisibility(this.jcf ? 0 : 8);
                if (!this.jcf) {
                    this.jbT.setAlpha(1.0f);
                    this.jbT.showBottomLine();
                }
            }
            String str = eVar.czZ().eaf;
            if (StringUtils.isNull(str)) {
                this.ibp.setVisibility(8);
                JQ("");
            } else {
                JQ(com.baidu.tieba.hottopic.b.a.aR(str, 10));
            }
            this.jbW.setHeaderBottomLineShow(true);
        }
    }

    private void JQ(String str) {
        if (this.jca != null) {
            this.jca.setText(str);
        } else if (this.jbT != null) {
            this.jca = this.jbT.setCenterTextTitle(str);
        }
    }

    public int getCurrentTab() {
        if (this.eiA.getCurrentItem() < 0) {
            return 0;
        }
        return this.eiA.getCurrentItem();
    }

    public void g(NoNetworkView.a aVar) {
        this.hQf = aVar;
        if (this.fCq != null) {
            this.fCq.a(this.hQf);
        }
    }

    public void Aw(int i) {
        this.jbW.setVisibility(i);
        this.eiA.setVisibility(i);
    }

    public void bFX() {
        this.jbX.bFX();
    }

    public void showLoadingView() {
        this.jbX.showLoadingView();
    }

    public void cAr() {
        this.jbX.pX(false);
    }

    public void du(List<com.baidu.tieba.hottopic.data.e> list) {
        this.jbX.dq(list);
    }

    public void destroy() {
        if (this.jbX != null) {
            this.jbX.destroy();
        }
        if (this.jbV != null) {
            this.jbV.clearAnimation();
        }
        if (this.fCq != null && this.hQf != null) {
            this.fCq.b(this.hQf);
        }
    }

    public void resume() {
        if (this.jbX != null) {
            this.jbX.resume();
        }
    }

    public void pause() {
        if (this.jbX != null) {
            this.jbX.pause();
        }
    }

    public void qa(boolean z) {
        if (this.fCq != null) {
            if (z) {
                this.fCq.setVisibility(0);
            } else {
                this.fCq.setVisibility(8);
            }
        }
    }

    public HotTopicView cAv() {
        return this.jbX.czu();
    }

    public int cAw() {
        return (this.cNq - this.jbZ) - this.mNavigationBarHeight;
    }

    public void Am(int i) {
        if (this.jbX != null) {
            this.jbX.Am(i);
        }
    }

    public void An(int i) {
        if (this.jbX != null) {
            this.jbX.An(i);
        }
    }

    public void Ao(int i) {
        if (this.jbX != null) {
            this.jbX.Ao(i);
        }
    }

    public void a(AbsListView absListView, int i) {
        HotTopicView czu;
        if (this.jbW != null && this.jbY != null && (czu = this.jbX.czu()) != null && czu.getListView() != null && absListView == czu.getListView()) {
            this.jbY.setHeaderViewHeight(this.cNq - i);
            this.jbW.setY(-i);
            if (i == 0) {
                this.jbY.iu(false);
            } else {
                this.jbY.iu(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAx() {
        if (this.jcd) {
            this.jce = this.jbW.getY();
            this.jcd = false;
        }
    }

    /* loaded from: classes15.dex */
    public abstract class a implements AbsListView.OnScrollListener {
        public a() {
        }
    }

    public HotTopicHeaderView cAy() {
        return this.jbW;
    }

    public int cAz() {
        return this.cNq;
    }
}
