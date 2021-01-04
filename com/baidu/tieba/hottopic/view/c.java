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
/* loaded from: classes8.dex */
public class c {
    private int acd;
    private int dBv;
    private TbPageContext<HotTopicActivity> eXu;
    private CustomViewPager fbv;
    private NoNetworkView gzT;
    private ImageView jQR;
    private NoNetworkView.a jct;
    public ImageView jnE;
    private DisableScrollLayout ktA;
    private int ktB;
    private TextView ktC;
    private com.baidu.tieba.hottopic.controller.c ktD;
    private boolean ktF;
    private float ktG;
    private RelativeLayout ktu;
    private NavigationBar ktv;
    private ImageView ktw;
    private e ktx;
    private HotTopicHeaderView kty;
    private HotTopicThreadPagerAdapter ktz;
    private NavigationBar mNavigationBar;
    private String mTopicId;
    private final com.baidu.tbadk.widget.layout.e fWY = new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.hottopic.view.c.1
        @Override // com.baidu.tbadk.widget.layout.e
        public void f(View view, int i, int i2, int i3, int i4) {
            c.this.acd = i2;
            if (c.this.kty != null) {
                c.this.kty.DJ(i2);
            }
        }
    };
    private final com.baidu.tbadk.widget.layout.e ktE = new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.hottopic.view.c.2
        @Override // com.baidu.tbadk.widget.layout.e
        public void f(View view, int i, int i2, int i3, int i4) {
            c.this.dBv = i2;
            c.this.ktz.Dz(i2);
            c.this.ktA.setHeaderViewHeight(i2);
        }
    };
    private boolean ktH = false;
    private a kpb = new a() { // from class: com.baidu.tieba.hottopic.view.c.5
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            HotTopicView cUu = c.this.ktz.cUu();
            if (cUu != null && absListView == cUu.getListView() && i == 0) {
                c.this.ktF = true;
                float y = c.this.kty.getY();
                if (c.this.ktz != null) {
                    if (Math.abs(c.this.ktG) != c.this.cVv() || c.this.ktG == y) {
                        c.this.ktz.DD((int) (c.this.ktG - y));
                        return;
                    }
                    c.this.ktz.aM(y);
                    c.this.mNavigationBar.hideBottomLine();
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            HotTopicActivity hotTopicActivity;
            HotTopicView cUu = c.this.ktz.cUu();
            if (cUu != null) {
                if (absListView == cUu.getListView()) {
                    if (c.this.ktx != null) {
                        c.this.ktx.DN(i);
                    }
                    c.this.cVw();
                }
                if (c.this.ktz != null && c.this.kty.getNavigationBarSwitchHeight() != c.this.acd) {
                    if (c.this.ktH) {
                        float navigationBarSwitchHeight = (-c.this.kty.getY()) / (c.this.kty.getNavigationBarSwitchHeight() - c.this.acd);
                        c.this.mNavigationBar.setAlpha(1.0f - navigationBarSwitchHeight);
                        c.this.ktv.setAlpha(navigationBarSwitchHeight);
                        if (c.this.ktC != null) {
                            c.this.ktC.setAlpha((-c.this.kty.getY()) / (c.this.kty.getNavigationBarSwitchHeight() - c.this.acd));
                        }
                    } else {
                        if (c.this.ktC != null) {
                            c.this.ktC.setAlpha((-c.this.kty.getY()) / (c.this.kty.getNavigationBarSwitchHeight() - c.this.acd));
                        }
                        if (Math.abs(c.this.ktG) == c.this.cVv()) {
                            c.this.ktv.hideBottomLine();
                        } else {
                            c.this.ktv.showBottomLine();
                        }
                    }
                }
                if (i == 0 && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && (hotTopicActivity = (HotTopicActivity) c.this.eXu.getOrignalPage()) != null) {
                    hotTopicActivity.onScrollToBottom();
                }
            }
        }
    };

    public c(TbPageContext<HotTopicActivity> tbPageContext, String str) {
        this.eXu = tbPageContext;
        this.mTopicId = str;
        initView();
    }

    private void initView() {
        if (this.eXu != null) {
            this.eXu.getOrignalPage().setContentView(R.layout.hot_topic_activity);
            this.ktB = l.getDimens(this.eXu.getPageActivity(), R.dimen.ds80);
            this.ktD = new com.baidu.tieba.hottopic.controller.c((OvalActionButton) this.eXu.getOrignalPage().findViewById(R.id.topic_post_forum_button), this.eXu);
            this.ktD.setTopicId(this.mTopicId);
            this.ktu = (RelativeLayout) this.eXu.getOrignalPage().findViewById(R.id.hot_topic_root_view);
            this.ktA = (DisableScrollLayout) this.ktu.findViewById(R.id.disable_scroll_layout);
            this.mNavigationBar = (NavigationBar) this.eXu.getOrignalPage().findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.hideBottomLine();
            this.ktv = (NavigationBar) this.eXu.getOrignalPage().findViewById(R.id.view_navigation_bar_after_scroll);
            this.ktC = this.ktv.setCenterTextTitle("");
            this.ktC.setAlpha(0.0f);
            this.ktv.hideBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            ao.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.selector_topbar_return_white);
            this.ktv.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.jQR = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!j.isNetWorkAvailable()) {
                        ((HotTopicActivity) c.this.eXu.getOrignalPage()).showToast(R.string.topic_share_no_network);
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                    if (ShareSwitch.isOn() || bg.checkUpIsLogin(c.this.eXu.getContext())) {
                        TiebaStatic.log(new aq("c10521").dX("obj_id", ((HotTopicActivity) c.this.eXu.getOrignalPage()).cUK()).dX("topic_id", ((HotTopicActivity) c.this.eXu.getOrignalPage()).cUK()));
                        ((HotTopicActivity) c.this.eXu.getOrignalPage()).cUB();
                    }
                }
            });
            this.ktw = (ImageView) this.ktv.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!j.isNetWorkAvailable()) {
                        ((HotTopicActivity) c.this.eXu.getOrignalPage()).showToast(R.string.topic_share_no_network);
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                    if (ShareSwitch.isOn() || bg.checkUpIsLogin(c.this.eXu.getContext())) {
                        TiebaStatic.log(new aq("c10521").dX("obj_id", ((HotTopicActivity) c.this.eXu.getOrignalPage()).cUK()).dX("topic_id", ((HotTopicActivity) c.this.eXu.getOrignalPage()).cUK()));
                        ((HotTopicActivity) c.this.eXu.getOrignalPage()).cUB();
                    }
                }
            });
            this.gzT = (NoNetworkView) this.ktu.findViewById(R.id.view_no_network);
            ((ObservedChangeLinearLayout) this.ktu.findViewById(R.id.hot_topic_observed_change_layout)).setOnSizeChangeListener(this.fWY);
            this.ktx = new e(this.eXu, this.ktu);
            this.kty = (HotTopicHeaderView) this.ktu.findViewById(R.id.hot_topic_header);
            this.kty.setOnSizeChangeListener(this.ktE);
            this.fbv = (CustomViewPager) this.ktu.findViewById(R.id.hot_topic_view_pager);
            this.ktz = new HotTopicThreadPagerAdapter(this.eXu.getPageActivity(), this.kpb);
            this.ktz.setMainView(this);
            this.fbv.setAdapter(this.ktz);
            this.kty.setViewPager(this.fbv);
            this.kty.setHeaderBottomLineShow(false);
            this.jnE = (ImageView) this.ktu.findViewById(R.id.normal_write_icon);
            this.jnE.setVisibility(8);
        }
    }

    public void a(int i, boolean z, long j, int i2) {
        this.ktx.a(i, z, j, i2);
    }

    public void b(View.OnTouchListener onTouchListener) {
        if (onTouchListener != null && this.jnE != null) {
            this.jnE.setOnTouchListener(onTouchListener);
        }
    }

    public View cVo() {
        return this.ktu;
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null && this.ktH) {
            this.mNavigationBar.onChangeSkinType(this.eXu, i);
            this.mNavigationBar.setBackgroundResource(R.drawable.black_alpha_from_30_to_0);
            ao.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.selector_topbar_return_white);
            this.mNavigationBar.setAlpha((this.kty.getY() / (this.kty.getNavigationBarSwitchHeight() - this.acd)) + 1.0f);
        }
        if (this.ktv != null) {
            this.ktv.onChangeSkinType(this.eXu, i);
            if (this.ktH) {
                this.ktv.setAlpha((-this.kty.getY()) / (this.kty.getNavigationBarSwitchHeight() - this.acd));
            } else {
                this.ktv.setAlpha(1.0f);
            }
        }
        if (this.gzT != null) {
            this.gzT.onChangeSkinType(this.eXu, i);
        }
        if (this.ktw != null) {
            SvgManager.bwq().a(this.ktw, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.jQR != null) {
            SvgManager.bwq().a(this.jQR, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.kty != null) {
            this.kty.onChangeSkinType();
        }
        if (this.ktz != null) {
            this.ktz.onChangeSkinType(i);
        }
        if (this.jnE != null) {
            ao.setBackgroundResource(this.jnE, R.drawable.icon_tabbar_chaticon_n);
            ao.setImageResource(this.jnE, R.drawable.icon_tabbar_add_n);
        }
    }

    public void b(com.baidu.tieba.hottopic.data.e eVar) {
        if (eVar != null && eVar.cUZ() != null) {
            if (!this.kty.cVt()) {
                this.kty.setData(eVar.cUZ());
            }
            if (eVar.cUZ() != null) {
                this.ktH = !StringUtils.isNull(eVar.cUZ().kqV);
                this.mNavigationBar.setVisibility(this.ktH ? 0 : 8);
                if (!this.ktH) {
                    this.ktv.setAlpha(1.0f);
                    this.ktv.showBottomLine();
                }
            }
            String str = eVar.cUZ().eRS;
            if (StringUtils.isNull(str)) {
                this.jnE.setVisibility(8);
                ME("");
            } else {
                ME(com.baidu.tieba.hottopic.a.a.bd(str, 10));
            }
            this.kty.setHeaderBottomLineShow(true);
        }
    }

    private void ME(String str) {
        if (this.ktC != null) {
            this.ktC.setText(str);
        } else if (this.ktv != null) {
            this.ktC = this.ktv.setCenterTextTitle(str);
        }
    }

    public int getCurrentTab() {
        if (this.fbv.getCurrentItem() < 0) {
            return 0;
        }
        return this.fbv.getCurrentItem();
    }

    public void g(NoNetworkView.a aVar) {
        this.jct = aVar;
        if (this.gzT != null) {
            this.gzT.a(this.jct);
        }
    }

    public void DK(int i) {
        this.kty.setVisibility(i);
        this.fbv.setVisibility(i);
    }

    public void Zi() {
        this.ktz.Zi();
    }

    public void showLoadingView() {
        this.ktz.showLoadingView();
    }

    public void cVq() {
        this.ktz.so(false);
    }

    public void eo(List<com.baidu.tieba.hottopic.data.e> list) {
        this.ktz.ek(list);
    }

    public void destroy() {
        if (this.ktz != null) {
            this.ktz.destroy();
        }
        if (this.ktx != null) {
            this.ktx.clearAnimation();
        }
        if (this.gzT != null && this.jct != null) {
            this.gzT.b(this.jct);
        }
    }

    public void resume() {
        if (this.ktz != null) {
            this.ktz.resume();
        }
    }

    public void pause() {
        if (this.ktz != null) {
            this.ktz.pause();
        }
    }

    public void sr(boolean z) {
        if (this.gzT != null) {
            if (z) {
                this.gzT.setVisibility(0);
            } else {
                this.gzT.setVisibility(8);
            }
        }
    }

    public HotTopicView cVu() {
        return this.ktz.cUu();
    }

    public int cVv() {
        return (this.dBv - this.ktB) - this.acd;
    }

    public void DA(int i) {
        if (this.ktz != null) {
            this.ktz.DA(i);
        }
    }

    public void DB(int i) {
        if (this.ktz != null) {
            this.ktz.DB(i);
        }
    }

    public void DC(int i) {
        if (this.ktz != null) {
            this.ktz.DC(i);
        }
    }

    public void a(AbsListView absListView, int i) {
        HotTopicView cUu;
        if (this.kty != null && this.ktA != null && (cUu = this.ktz.cUu()) != null && cUu.getListView() != null && absListView == cUu.getListView()) {
            this.ktA.setHeaderViewHeight(this.dBv - i);
            this.kty.setY(-i);
            if (i == 0) {
                this.ktA.jY(false);
            } else {
                this.ktA.jY(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVw() {
        if (this.ktF) {
            this.ktG = this.kty.getY();
            this.ktF = false;
        }
    }

    /* loaded from: classes8.dex */
    public abstract class a implements AbsListView.OnScrollListener {
        public a() {
        }
    }

    public HotTopicHeaderView cVx() {
        return this.kty;
    }

    public int cVy() {
        return this.dBv;
    }
}
