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
    private int dbv;
    private TbPageContext<HotTopicActivity> etO;
    private CustomViewPager ewX;
    private NoNetworkView fRL;
    private NoNetworkView.a ime;
    public ImageView ixr;
    private ImageView jrA;
    private HotTopicHeaderView jzA;
    private HotTopicThreadPagerAdapter jzB;
    private DisableScrollLayout jzC;
    private int jzD;
    private TextView jzE;
    private com.baidu.tieba.hottopic.controller.c jzF;
    private boolean jzH;
    private float jzI;
    private RelativeLayout jzw;
    private NavigationBar jzx;
    private ImageView jzy;
    private e jzz;
    private NavigationBar mNavigationBar;
    private int mNavigationBarHeight;
    private String mTopicId;
    private final com.baidu.tbadk.widget.layout.e frT = new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.hottopic.view.c.1
        @Override // com.baidu.tbadk.widget.layout.e
        public void d(View view, int i, int i2, int i3, int i4) {
            c.this.mNavigationBarHeight = i2;
            if (c.this.jzA != null) {
                c.this.jzA.BC(i2);
            }
        }
    };
    private final com.baidu.tbadk.widget.layout.e jzG = new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.hottopic.view.c.2
        @Override // com.baidu.tbadk.widget.layout.e
        public void d(View view, int i, int i2, int i3, int i4) {
            c.this.dbv = i2;
            c.this.jzB.Bs(i2);
            c.this.jzC.setHeaderViewHeight(i2);
        }
    };
    private boolean jzJ = false;
    private a jvd = new a() { // from class: com.baidu.tieba.hottopic.view.c.5
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            HotTopicView cGK = c.this.jzB.cGK();
            if (cGK != null && absListView == cGK.getListView() && i == 0) {
                c.this.jzH = true;
                float y = c.this.jzA.getY();
                if (c.this.jzB != null) {
                    if (Math.abs(c.this.jzI) != c.this.cHM() || c.this.jzI == y) {
                        c.this.jzB.Bw((int) (c.this.jzI - y));
                        return;
                    }
                    c.this.jzB.ay(y);
                    c.this.mNavigationBar.hideBottomLine();
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            HotTopicActivity hotTopicActivity;
            HotTopicView cGK = c.this.jzB.cGK();
            if (cGK != null) {
                if (absListView == cGK.getListView()) {
                    if (c.this.jzz != null) {
                        c.this.jzz.BG(i);
                    }
                    c.this.cHN();
                }
                if (c.this.jzB != null && c.this.jzA.getNavigationBarSwitchHeight() != c.this.mNavigationBarHeight) {
                    if (c.this.jzJ) {
                        float navigationBarSwitchHeight = (-c.this.jzA.getY()) / (c.this.jzA.getNavigationBarSwitchHeight() - c.this.mNavigationBarHeight);
                        c.this.mNavigationBar.setAlpha(1.0f - navigationBarSwitchHeight);
                        c.this.jzx.setAlpha(navigationBarSwitchHeight);
                        if (c.this.jzE != null) {
                            c.this.jzE.setAlpha((-c.this.jzA.getY()) / (c.this.jzA.getNavigationBarSwitchHeight() - c.this.mNavigationBarHeight));
                        }
                    } else {
                        if (c.this.jzE != null) {
                            c.this.jzE.setAlpha((-c.this.jzA.getY()) / (c.this.jzA.getNavigationBarSwitchHeight() - c.this.mNavigationBarHeight));
                        }
                        if (Math.abs(c.this.jzI) == c.this.cHM()) {
                            c.this.jzx.hideBottomLine();
                        } else {
                            c.this.jzx.showBottomLine();
                        }
                    }
                }
                if (i == 0 && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && (hotTopicActivity = (HotTopicActivity) c.this.etO.getOrignalPage()) != null) {
                    hotTopicActivity.onScrollToBottom();
                }
            }
        }
    };

    public c(TbPageContext<HotTopicActivity> tbPageContext, String str) {
        this.etO = tbPageContext;
        this.mTopicId = str;
        initView();
    }

    private void initView() {
        if (this.etO != null) {
            this.etO.getOrignalPage().setContentView(R.layout.hot_topic_activity);
            this.jzD = l.getDimens(this.etO.getPageActivity(), R.dimen.ds80);
            this.jzF = new com.baidu.tieba.hottopic.controller.c((OvalActionButton) this.etO.getOrignalPage().findViewById(R.id.topic_post_forum_button), this.etO);
            this.jzF.setTopicId(this.mTopicId);
            this.jzw = (RelativeLayout) this.etO.getOrignalPage().findViewById(R.id.hot_topic_root_view);
            this.jzC = (DisableScrollLayout) this.jzw.findViewById(R.id.disable_scroll_layout);
            this.mNavigationBar = (NavigationBar) this.etO.getOrignalPage().findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.hideBottomLine();
            this.jzx = (NavigationBar) this.etO.getOrignalPage().findViewById(R.id.view_navigation_bar_after_scroll);
            this.jzE = this.jzx.setCenterTextTitle("");
            this.jzE.setAlpha(0.0f);
            this.jzx.hideBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            ap.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.selector_topbar_return_white);
            this.jzx.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.jrA = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!j.isNetWorkAvailable()) {
                        ((HotTopicActivity) c.this.etO.getOrignalPage()).showToast(R.string.topic_share_no_network);
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                    if (ShareSwitch.isOn() || bg.checkUpIsLogin(c.this.etO.getContext())) {
                        TiebaStatic.log(new aq("c10521").dK("obj_id", ((HotTopicActivity) c.this.etO.getOrignalPage()).cHa()).dK("topic_id", ((HotTopicActivity) c.this.etO.getOrignalPage()).cHa()));
                        ((HotTopicActivity) c.this.etO.getOrignalPage()).cGR();
                    }
                }
            });
            this.jzy = (ImageView) this.jzx.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!j.isNetWorkAvailable()) {
                        ((HotTopicActivity) c.this.etO.getOrignalPage()).showToast(R.string.topic_share_no_network);
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                    if (ShareSwitch.isOn() || bg.checkUpIsLogin(c.this.etO.getContext())) {
                        TiebaStatic.log(new aq("c10521").dK("obj_id", ((HotTopicActivity) c.this.etO.getOrignalPage()).cHa()).dK("topic_id", ((HotTopicActivity) c.this.etO.getOrignalPage()).cHa()));
                        ((HotTopicActivity) c.this.etO.getOrignalPage()).cGR();
                    }
                }
            });
            this.fRL = (NoNetworkView) this.jzw.findViewById(R.id.view_no_network);
            ((ObservedChangeLinearLayout) this.jzw.findViewById(R.id.hot_topic_observed_change_layout)).setOnSizeChangeListener(this.frT);
            this.jzz = new e(this.etO, this.jzw);
            this.jzA = (HotTopicHeaderView) this.jzw.findViewById(R.id.hot_topic_header);
            this.jzA.setOnSizeChangeListener(this.jzG);
            this.ewX = (CustomViewPager) this.jzw.findViewById(R.id.hot_topic_view_pager);
            this.jzB = new HotTopicThreadPagerAdapter(this.etO.getPageActivity(), this.jvd);
            this.jzB.setMainView(this);
            this.ewX.setAdapter(this.jzB);
            this.jzA.setViewPager(this.ewX);
            this.jzA.setHeaderBottomLineShow(false);
            this.ixr = (ImageView) this.jzw.findViewById(R.id.normal_write_icon);
            this.ixr.setVisibility(8);
        }
    }

    public void a(int i, boolean z, long j, int i2) {
        this.jzz.a(i, z, j, i2);
    }

    public void b(View.OnTouchListener onTouchListener) {
        if (onTouchListener != null && this.ixr != null) {
            this.ixr.setOnTouchListener(onTouchListener);
        }
    }

    public View cHF() {
        return this.jzw;
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null && this.jzJ) {
            this.mNavigationBar.onChangeSkinType(this.etO, i);
            this.mNavigationBar.setBackgroundResource(R.drawable.black_alpha_from_30_to_0);
            ap.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.selector_topbar_return_white);
            this.mNavigationBar.setAlpha((this.jzA.getY() / (this.jzA.getNavigationBarSwitchHeight() - this.mNavigationBarHeight)) + 1.0f);
        }
        if (this.jzx != null) {
            this.jzx.onChangeSkinType(this.etO, i);
            if (this.jzJ) {
                this.jzx.setAlpha((-this.jzA.getY()) / (this.jzA.getNavigationBarSwitchHeight() - this.mNavigationBarHeight));
            } else {
                this.jzx.setAlpha(1.0f);
            }
        }
        if (this.fRL != null) {
            this.fRL.onChangeSkinType(this.etO, i);
        }
        if (this.jzy != null) {
            SvgManager.bmU().a(this.jzy, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.jrA != null) {
            SvgManager.bmU().a(this.jrA, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.jzA != null) {
            this.jzA.onChangeSkinType();
        }
        if (this.jzB != null) {
            this.jzB.onChangeSkinType(i);
        }
        if (this.ixr != null) {
            ap.setBackgroundResource(this.ixr, R.drawable.icon_tabbar_chaticon_n);
            ap.setImageResource(this.ixr, R.drawable.icon_tabbar_add_n);
        }
    }

    public void c(com.baidu.tieba.hottopic.data.e eVar) {
        if (eVar != null && eVar.cHp() != null) {
            if (!this.jzA.cHK()) {
                this.jzA.setData(eVar.cHp());
            }
            if (eVar.cHp() != null) {
                this.jzJ = !StringUtils.isNull(eVar.cHp().jwX);
                this.mNavigationBar.setVisibility(this.jzJ ? 0 : 8);
                if (!this.jzJ) {
                    this.jzx.setAlpha(1.0f);
                    this.jzx.showBottomLine();
                }
            }
            String str = eVar.cHp().eou;
            if (StringUtils.isNull(str)) {
                this.ixr.setVisibility(8);
                Lh("");
            } else {
                Lh(com.baidu.tieba.hottopic.b.a.aS(str, 10));
            }
            this.jzA.setHeaderBottomLineShow(true);
        }
    }

    private void Lh(String str) {
        if (this.jzE != null) {
            this.jzE.setText(str);
        } else if (this.jzx != null) {
            this.jzE = this.jzx.setCenterTextTitle(str);
        }
    }

    public int getCurrentTab() {
        if (this.ewX.getCurrentItem() < 0) {
            return 0;
        }
        return this.ewX.getCurrentItem();
    }

    public void g(NoNetworkView.a aVar) {
        this.ime = aVar;
        if (this.fRL != null) {
            this.fRL.a(this.ime);
        }
    }

    public void BD(int i) {
        this.jzA.setVisibility(i);
        this.ewX.setVisibility(i);
    }

    public void SK() {
        this.jzB.SK();
    }

    public void showLoadingView() {
        this.jzB.showLoadingView();
    }

    public void cHH() {
        this.jzB.qL(false);
    }

    public void dF(List<com.baidu.tieba.hottopic.data.e> list) {
        this.jzB.dB(list);
    }

    public void destroy() {
        if (this.jzB != null) {
            this.jzB.destroy();
        }
        if (this.jzz != null) {
            this.jzz.clearAnimation();
        }
        if (this.fRL != null && this.ime != null) {
            this.fRL.b(this.ime);
        }
    }

    public void resume() {
        if (this.jzB != null) {
            this.jzB.resume();
        }
    }

    public void pause() {
        if (this.jzB != null) {
            this.jzB.pause();
        }
    }

    public void qO(boolean z) {
        if (this.fRL != null) {
            if (z) {
                this.fRL.setVisibility(0);
            } else {
                this.fRL.setVisibility(8);
            }
        }
    }

    public HotTopicView cHL() {
        return this.jzB.cGK();
    }

    public int cHM() {
        return (this.dbv - this.jzD) - this.mNavigationBarHeight;
    }

    public void Bt(int i) {
        if (this.jzB != null) {
            this.jzB.Bt(i);
        }
    }

    public void Bu(int i) {
        if (this.jzB != null) {
            this.jzB.Bu(i);
        }
    }

    public void Bv(int i) {
        if (this.jzB != null) {
            this.jzB.Bv(i);
        }
    }

    public void a(AbsListView absListView, int i) {
        HotTopicView cGK;
        if (this.jzA != null && this.jzC != null && (cGK = this.jzB.cGK()) != null && cGK.getListView() != null && absListView == cGK.getListView()) {
            this.jzC.setHeaderViewHeight(this.dbv - i);
            this.jzA.setY(-i);
            if (i == 0) {
                this.jzC.iP(false);
            } else {
                this.jzC.iP(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHN() {
        if (this.jzH) {
            this.jzI = this.jzA.getY();
            this.jzH = false;
        }
    }

    /* loaded from: classes21.dex */
    public abstract class a implements AbsListView.OnScrollListener {
        public a() {
        }
    }

    public HotTopicHeaderView cHO() {
        return this.jzA;
    }

    public int cHP() {
        return this.dbv;
    }
}
