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
/* loaded from: classes7.dex */
public class c {
    private int adt;
    private int dAp;
    private TbPageContext<HotTopicActivity> eWx;
    private CustomViewPager faC;
    private NoNetworkView gzT;
    private ImageView jVU;
    private NoNetworkView.a jfq;
    public ImageView jqB;
    private RelativeLayout kzm;
    private NavigationBar kzn;
    private ImageView kzo;
    private e kzp;
    private HotTopicHeaderView kzq;
    private HotTopicThreadPagerAdapter kzr;
    private DisableScrollLayout kzs;
    private int kzt;
    private TextView kzu;
    private com.baidu.tieba.hottopic.controller.c kzv;
    private boolean kzx;
    private float kzy;
    private NavigationBar mNavigationBar;
    private String mTopicId;
    private final com.baidu.tbadk.widget.layout.e fWg = new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.hottopic.view.c.1
        @Override // com.baidu.tbadk.widget.layout.e
        public void f(View view, int i, int i2, int i3, int i4) {
            c.this.adt = i2;
            if (c.this.kzq != null) {
                c.this.kzq.Cx(i2);
            }
        }
    };
    private final com.baidu.tbadk.widget.layout.e kzw = new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.hottopic.view.c.2
        @Override // com.baidu.tbadk.widget.layout.e
        public void f(View view, int i, int i2, int i3, int i4) {
            c.this.dAp = i2;
            c.this.kzr.Cn(i2);
            c.this.kzs.setHeaderViewHeight(i2);
        }
    };
    private boolean kzz = false;
    private a kuT = new a() { // from class: com.baidu.tieba.hottopic.view.c.5
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            HotTopicView cSQ = c.this.kzr.cSQ();
            if (cSQ != null && absListView == cSQ.getListView() && i == 0) {
                c.this.kzx = true;
                float y = c.this.kzq.getY();
                if (c.this.kzr != null) {
                    if (Math.abs(c.this.kzy) != c.this.cTR() || c.this.kzy == y) {
                        c.this.kzr.Cr((int) (c.this.kzy - y));
                        return;
                    }
                    c.this.kzr.aT(y);
                    c.this.mNavigationBar.hideBottomLine();
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            HotTopicActivity hotTopicActivity;
            HotTopicView cSQ = c.this.kzr.cSQ();
            if (cSQ != null) {
                if (absListView == cSQ.getListView()) {
                    if (c.this.kzp != null) {
                        c.this.kzp.CB(i);
                    }
                    c.this.cTS();
                }
                if (c.this.kzr != null && c.this.kzq.getNavigationBarSwitchHeight() != c.this.adt) {
                    if (c.this.kzz) {
                        float navigationBarSwitchHeight = (-c.this.kzq.getY()) / (c.this.kzq.getNavigationBarSwitchHeight() - c.this.adt);
                        c.this.mNavigationBar.setAlpha(1.0f - navigationBarSwitchHeight);
                        c.this.kzn.setAlpha(navigationBarSwitchHeight);
                        if (c.this.kzu != null) {
                            c.this.kzu.setAlpha((-c.this.kzq.getY()) / (c.this.kzq.getNavigationBarSwitchHeight() - c.this.adt));
                        }
                    } else {
                        if (c.this.kzu != null) {
                            c.this.kzu.setAlpha((-c.this.kzq.getY()) / (c.this.kzq.getNavigationBarSwitchHeight() - c.this.adt));
                        }
                        if (Math.abs(c.this.kzy) == c.this.cTR()) {
                            c.this.kzn.hideBottomLine();
                        } else {
                            c.this.kzn.showBottomLine();
                        }
                    }
                }
                if (i == 0 && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && (hotTopicActivity = (HotTopicActivity) c.this.eWx.getOrignalPage()) != null) {
                    hotTopicActivity.onScrollToBottom();
                }
            }
        }
    };

    public c(TbPageContext<HotTopicActivity> tbPageContext, String str) {
        this.eWx = tbPageContext;
        this.mTopicId = str;
        initView();
    }

    private void initView() {
        if (this.eWx != null) {
            this.eWx.getOrignalPage().setContentView(R.layout.hot_topic_activity);
            this.kzt = l.getDimens(this.eWx.getPageActivity(), R.dimen.ds80);
            this.kzv = new com.baidu.tieba.hottopic.controller.c((OvalActionButton) this.eWx.getOrignalPage().findViewById(R.id.topic_post_forum_button), this.eWx);
            this.kzv.setTopicId(this.mTopicId);
            this.kzm = (RelativeLayout) this.eWx.getOrignalPage().findViewById(R.id.hot_topic_root_view);
            this.kzs = (DisableScrollLayout) this.kzm.findViewById(R.id.disable_scroll_layout);
            this.mNavigationBar = (NavigationBar) this.eWx.getOrignalPage().findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.hideBottomLine();
            this.kzn = (NavigationBar) this.eWx.getOrignalPage().findViewById(R.id.view_navigation_bar_after_scroll);
            this.kzu = this.kzn.setCenterTextTitle("");
            this.kzu.setAlpha(0.0f);
            this.kzn.hideBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            ap.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.selector_topbar_return_white);
            this.kzn.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.jVU = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!j.isNetWorkAvailable()) {
                        ((HotTopicActivity) c.this.eWx.getOrignalPage()).showToast(R.string.topic_share_no_network);
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                    if (ShareSwitch.isOn() || bh.checkUpIsLogin(c.this.eWx.getContext())) {
                        TiebaStatic.log(new ar("c10521").dR("obj_id", ((HotTopicActivity) c.this.eWx.getOrignalPage()).cTg()).dR("topic_id", ((HotTopicActivity) c.this.eWx.getOrignalPage()).cTg()));
                        ((HotTopicActivity) c.this.eWx.getOrignalPage()).cSX();
                    }
                }
            });
            this.kzo = (ImageView) this.kzn.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!j.isNetWorkAvailable()) {
                        ((HotTopicActivity) c.this.eWx.getOrignalPage()).showToast(R.string.topic_share_no_network);
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                    if (ShareSwitch.isOn() || bh.checkUpIsLogin(c.this.eWx.getContext())) {
                        TiebaStatic.log(new ar("c10521").dR("obj_id", ((HotTopicActivity) c.this.eWx.getOrignalPage()).cTg()).dR("topic_id", ((HotTopicActivity) c.this.eWx.getOrignalPage()).cTg()));
                        ((HotTopicActivity) c.this.eWx.getOrignalPage()).cSX();
                    }
                }
            });
            this.gzT = (NoNetworkView) this.kzm.findViewById(R.id.view_no_network);
            ((ObservedChangeLinearLayout) this.kzm.findViewById(R.id.hot_topic_observed_change_layout)).setOnSizeChangeListener(this.fWg);
            this.kzp = new e(this.eWx, this.kzm);
            this.kzq = (HotTopicHeaderView) this.kzm.findViewById(R.id.hot_topic_header);
            this.kzq.setOnSizeChangeListener(this.kzw);
            this.faC = (CustomViewPager) this.kzm.findViewById(R.id.hot_topic_view_pager);
            this.kzr = new HotTopicThreadPagerAdapter(this.eWx.getPageActivity(), this.kuT);
            this.kzr.setMainView(this);
            this.faC.setAdapter(this.kzr);
            this.kzq.setViewPager(this.faC);
            this.kzq.setHeaderBottomLineShow(false);
            this.jqB = (ImageView) this.kzm.findViewById(R.id.normal_write_icon);
            this.jqB.setVisibility(8);
        }
    }

    public void a(int i, boolean z, long j, int i2) {
        this.kzp.a(i, z, j, i2);
    }

    public void b(View.OnTouchListener onTouchListener) {
        if (onTouchListener != null && this.jqB != null) {
            this.jqB.setOnTouchListener(onTouchListener);
        }
    }

    public View cTK() {
        return this.kzm;
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null && this.kzz) {
            this.mNavigationBar.onChangeSkinType(this.eWx, i);
            this.mNavigationBar.setBackgroundResource(R.drawable.black_alpha_from_30_to_0);
            ap.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.selector_topbar_return_white);
            this.mNavigationBar.setAlpha((this.kzq.getY() / (this.kzq.getNavigationBarSwitchHeight() - this.adt)) + 1.0f);
        }
        if (this.kzn != null) {
            this.kzn.onChangeSkinType(this.eWx, i);
            if (this.kzz) {
                this.kzn.setAlpha((-this.kzq.getY()) / (this.kzq.getNavigationBarSwitchHeight() - this.adt));
            } else {
                this.kzn.setAlpha(1.0f);
            }
        }
        if (this.gzT != null) {
            this.gzT.onChangeSkinType(this.eWx, i);
        }
        if (this.kzo != null) {
            SvgManager.bsU().a(this.kzo, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.jVU != null) {
            SvgManager.bsU().a(this.jVU, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.kzq != null) {
            this.kzq.onChangeSkinType();
        }
        if (this.kzr != null) {
            this.kzr.onChangeSkinType(i);
        }
        if (this.jqB != null) {
            ap.setBackgroundResource(this.jqB, R.drawable.icon_tabbar_chaticon_n);
            ap.setImageResource(this.jqB, R.drawable.icon_tabbar_add_n);
        }
    }

    public void b(com.baidu.tieba.hottopic.data.e eVar) {
        if (eVar != null && eVar.cTv() != null) {
            if (!this.kzq.cTP()) {
                this.kzq.setData(eVar.cTv());
            }
            if (eVar.cTv() != null) {
                this.kzz = !StringUtils.isNull(eVar.cTv().kwN);
                this.mNavigationBar.setVisibility(this.kzz ? 0 : 8);
                if (!this.kzz) {
                    this.kzn.setAlpha(1.0f);
                    this.kzn.showBottomLine();
                }
            }
            String str = eVar.cTv().eQU;
            if (StringUtils.isNull(str)) {
                this.jqB.setVisibility(8);
                Mr("");
            } else {
                Mr(com.baidu.tieba.hottopic.a.a.be(str, 10));
            }
            this.kzq.setHeaderBottomLineShow(true);
        }
    }

    private void Mr(String str) {
        if (this.kzu != null) {
            this.kzu.setText(str);
        } else if (this.kzn != null) {
            this.kzu = this.kzn.setCenterTextTitle(str);
        }
    }

    public int getCurrentTab() {
        if (this.faC.getCurrentItem() < 0) {
            return 0;
        }
        return this.faC.getCurrentItem();
    }

    public void g(NoNetworkView.a aVar) {
        this.jfq = aVar;
        if (this.gzT != null) {
            this.gzT.a(this.jfq);
        }
    }

    public void Cy(int i) {
        this.kzq.setVisibility(i);
        this.faC.setVisibility(i);
    }

    public void Xc() {
        this.kzr.Xc();
    }

    public void showLoadingView() {
        this.kzr.showLoadingView();
    }

    public void cTM() {
        this.kzr.sx(false);
    }

    public void em(List<com.baidu.tieba.hottopic.data.e> list) {
        this.kzr.ei(list);
    }

    public void destroy() {
        if (this.kzr != null) {
            this.kzr.destroy();
        }
        if (this.kzp != null) {
            this.kzp.clearAnimation();
        }
        if (this.gzT != null && this.jfq != null) {
            this.gzT.b(this.jfq);
        }
    }

    public void resume() {
        if (this.kzr != null) {
            this.kzr.resume();
        }
    }

    public void pause() {
        if (this.kzr != null) {
            this.kzr.pause();
        }
    }

    public void sA(boolean z) {
        if (this.gzT != null) {
            if (z) {
                this.gzT.setVisibility(0);
            } else {
                this.gzT.setVisibility(8);
            }
        }
    }

    public HotTopicView cTQ() {
        return this.kzr.cSQ();
    }

    public int cTR() {
        return (this.dAp - this.kzt) - this.adt;
    }

    public void Co(int i) {
        if (this.kzr != null) {
            this.kzr.Co(i);
        }
    }

    public void Cp(int i) {
        if (this.kzr != null) {
            this.kzr.Cp(i);
        }
    }

    public void Cq(int i) {
        if (this.kzr != null) {
            this.kzr.Cq(i);
        }
    }

    public void a(AbsListView absListView, int i) {
        HotTopicView cSQ;
        if (this.kzq != null && this.kzs != null && (cSQ = this.kzr.cSQ()) != null && cSQ.getListView() != null && absListView == cSQ.getListView()) {
            this.kzs.setHeaderViewHeight(this.dAp - i);
            this.kzq.setY(-i);
            if (i == 0) {
                this.kzs.jX(false);
            } else {
                this.kzs.jX(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTS() {
        if (this.kzx) {
            this.kzy = this.kzq.getY();
            this.kzx = false;
        }
    }

    /* loaded from: classes7.dex */
    public abstract class a implements AbsListView.OnScrollListener {
        public a() {
        }
    }

    public HotTopicHeaderView cTT() {
        return this.kzq;
    }

    public int cTU() {
        return this.dAp;
    }
}
