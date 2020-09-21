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
/* loaded from: classes20.dex */
public class c {
    private int cPq;
    private TbPageContext<HotTopicActivity> ehG;
    private CustomViewPager ekP;
    private NoNetworkView fFC;
    private NoNetworkView.a hXf;
    public ImageView iiu;
    private ImageView jcB;
    private ImageView jkA;
    private e jkB;
    private HotTopicHeaderView jkC;
    private HotTopicThreadPagerAdapter jkD;
    private DisableScrollLayout jkE;
    private int jkF;
    private TextView jkG;
    private com.baidu.tieba.hottopic.controller.c jkH;
    private boolean jkJ;
    private float jkK;
    private RelativeLayout jky;
    private NavigationBar jkz;
    private NavigationBar mNavigationBar;
    private int mNavigationBarHeight;
    private String mTopicId;
    private final com.baidu.tbadk.widget.layout.e ffE = new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.hottopic.view.c.1
        @Override // com.baidu.tbadk.widget.layout.e
        public void d(View view, int i, int i2, int i3, int i4) {
            c.this.mNavigationBarHeight = i2;
            if (c.this.jkC != null) {
                c.this.jkC.AW(i2);
            }
        }
    };
    private final com.baidu.tbadk.widget.layout.e jkI = new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.hottopic.view.c.2
        @Override // com.baidu.tbadk.widget.layout.e
        public void d(View view, int i, int i2, int i3, int i4) {
            c.this.cPq = i2;
            c.this.jkD.AM(i2);
            c.this.jkE.setHeaderViewHeight(i2);
        }
    };
    private boolean jkL = false;
    private a jge = new a() { // from class: com.baidu.tieba.hottopic.view.c.5
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            HotTopicView cDb = c.this.jkD.cDb();
            if (cDb != null && absListView == cDb.getListView() && i == 0) {
                c.this.jkJ = true;
                float y = c.this.jkC.getY();
                if (c.this.jkD != null) {
                    if (Math.abs(c.this.jkK) != c.this.cEd() || c.this.jkK == y) {
                        c.this.jkD.AQ((int) (c.this.jkK - y));
                        return;
                    }
                    c.this.jkD.as(y);
                    c.this.mNavigationBar.hideBottomLine();
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            HotTopicActivity hotTopicActivity;
            HotTopicView cDb = c.this.jkD.cDb();
            if (cDb != null) {
                if (absListView == cDb.getListView()) {
                    if (c.this.jkB != null) {
                        c.this.jkB.Ba(i);
                    }
                    c.this.cEe();
                }
                if (c.this.jkD != null && c.this.jkC.getNavigationBarSwitchHeight() != c.this.mNavigationBarHeight) {
                    if (c.this.jkL) {
                        float navigationBarSwitchHeight = (-c.this.jkC.getY()) / (c.this.jkC.getNavigationBarSwitchHeight() - c.this.mNavigationBarHeight);
                        c.this.mNavigationBar.setAlpha(1.0f - navigationBarSwitchHeight);
                        c.this.jkz.setAlpha(navigationBarSwitchHeight);
                        if (c.this.jkG != null) {
                            c.this.jkG.setAlpha((-c.this.jkC.getY()) / (c.this.jkC.getNavigationBarSwitchHeight() - c.this.mNavigationBarHeight));
                        }
                    } else {
                        if (c.this.jkG != null) {
                            c.this.jkG.setAlpha((-c.this.jkC.getY()) / (c.this.jkC.getNavigationBarSwitchHeight() - c.this.mNavigationBarHeight));
                        }
                        if (Math.abs(c.this.jkK) == c.this.cEd()) {
                            c.this.jkz.hideBottomLine();
                        } else {
                            c.this.jkz.showBottomLine();
                        }
                    }
                }
                if (i == 0 && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && (hotTopicActivity = (HotTopicActivity) c.this.ehG.getOrignalPage()) != null) {
                    hotTopicActivity.onScrollToBottom();
                }
            }
        }
    };

    public c(TbPageContext<HotTopicActivity> tbPageContext, String str) {
        this.ehG = tbPageContext;
        this.mTopicId = str;
        initView();
    }

    private void initView() {
        if (this.ehG != null) {
            this.ehG.getOrignalPage().setContentView(R.layout.hot_topic_activity);
            this.jkF = l.getDimens(this.ehG.getPageActivity(), R.dimen.ds80);
            this.jkH = new com.baidu.tieba.hottopic.controller.c((OvalActionButton) this.ehG.getOrignalPage().findViewById(R.id.topic_post_forum_button), this.ehG);
            this.jkH.setTopicId(this.mTopicId);
            this.jky = (RelativeLayout) this.ehG.getOrignalPage().findViewById(R.id.hot_topic_root_view);
            this.jkE = (DisableScrollLayout) this.jky.findViewById(R.id.disable_scroll_layout);
            this.mNavigationBar = (NavigationBar) this.ehG.getOrignalPage().findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.hideBottomLine();
            this.jkz = (NavigationBar) this.ehG.getOrignalPage().findViewById(R.id.view_navigation_bar_after_scroll);
            this.jkG = this.jkz.setCenterTextTitle("");
            this.jkG.setAlpha(0.0f);
            this.jkz.hideBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            ap.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.selector_topbar_return_white);
            this.jkz.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.jcB = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!j.isNetWorkAvailable()) {
                        ((HotTopicActivity) c.this.ehG.getOrignalPage()).showToast(R.string.topic_share_no_network);
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                    if (ShareSwitch.isOn() || bg.checkUpIsLogin(c.this.ehG.getContext())) {
                        TiebaStatic.log(new aq("c10521").dF("obj_id", ((HotTopicActivity) c.this.ehG.getOrignalPage()).cDr()).dF("topic_id", ((HotTopicActivity) c.this.ehG.getOrignalPage()).cDr()));
                        ((HotTopicActivity) c.this.ehG.getOrignalPage()).cDi();
                    }
                }
            });
            this.jkA = (ImageView) this.jkz.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!j.isNetWorkAvailable()) {
                        ((HotTopicActivity) c.this.ehG.getOrignalPage()).showToast(R.string.topic_share_no_network);
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                    if (ShareSwitch.isOn() || bg.checkUpIsLogin(c.this.ehG.getContext())) {
                        TiebaStatic.log(new aq("c10521").dF("obj_id", ((HotTopicActivity) c.this.ehG.getOrignalPage()).cDr()).dF("topic_id", ((HotTopicActivity) c.this.ehG.getOrignalPage()).cDr()));
                        ((HotTopicActivity) c.this.ehG.getOrignalPage()).cDi();
                    }
                }
            });
            this.fFC = (NoNetworkView) this.jky.findViewById(R.id.view_no_network);
            ((ObservedChangeLinearLayout) this.jky.findViewById(R.id.hot_topic_observed_change_layout)).setOnSizeChangeListener(this.ffE);
            this.jkB = new e(this.ehG, this.jky);
            this.jkC = (HotTopicHeaderView) this.jky.findViewById(R.id.hot_topic_header);
            this.jkC.setOnSizeChangeListener(this.jkI);
            this.ekP = (CustomViewPager) this.jky.findViewById(R.id.hot_topic_view_pager);
            this.jkD = new HotTopicThreadPagerAdapter(this.ehG.getPageActivity(), this.jge);
            this.jkD.setMainView(this);
            this.ekP.setAdapter(this.jkD);
            this.jkC.setViewPager(this.ekP);
            this.jkC.setHeaderBottomLineShow(false);
            this.iiu = (ImageView) this.jky.findViewById(R.id.normal_write_icon);
            this.iiu.setVisibility(8);
        }
    }

    public void a(int i, boolean z, long j, int i2) {
        this.jkB.a(i, z, j, i2);
    }

    public void b(View.OnTouchListener onTouchListener) {
        if (onTouchListener != null && this.iiu != null) {
            this.iiu.setOnTouchListener(onTouchListener);
        }
    }

    public View cDW() {
        return this.jky;
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null && this.jkL) {
            this.mNavigationBar.onChangeSkinType(this.ehG, i);
            this.mNavigationBar.setBackgroundResource(R.drawable.black_alpha_from_30_to_0);
            ap.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.selector_topbar_return_white);
            this.mNavigationBar.setAlpha((this.jkC.getY() / (this.jkC.getNavigationBarSwitchHeight() - this.mNavigationBarHeight)) + 1.0f);
        }
        if (this.jkz != null) {
            this.jkz.onChangeSkinType(this.ehG, i);
            if (this.jkL) {
                this.jkz.setAlpha((-this.jkC.getY()) / (this.jkC.getNavigationBarSwitchHeight() - this.mNavigationBarHeight));
            } else {
                this.jkz.setAlpha(1.0f);
            }
        }
        if (this.fFC != null) {
            this.fFC.onChangeSkinType(this.ehG, i);
        }
        if (this.jkA != null) {
            SvgManager.bkl().a(this.jkA, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.jcB != null) {
            SvgManager.bkl().a(this.jcB, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.jkC != null) {
            this.jkC.onChangeSkinType();
        }
        if (this.jkD != null) {
            this.jkD.onChangeSkinType(i);
        }
        if (this.iiu != null) {
            ap.setBackgroundResource(this.iiu, R.drawable.icon_tabbar_chaticon_n);
            ap.setImageResource(this.iiu, R.drawable.icon_tabbar_add_n);
        }
    }

    public void c(com.baidu.tieba.hottopic.data.e eVar) {
        if (eVar != null && eVar.cDG() != null) {
            if (!this.jkC.cEb()) {
                this.jkC.setData(eVar.cDG());
            }
            if (eVar.cDG() != null) {
                this.jkL = !StringUtils.isNull(eVar.cDG().jhY);
                this.mNavigationBar.setVisibility(this.jkL ? 0 : 8);
                if (!this.jkL) {
                    this.jkz.setAlpha(1.0f);
                    this.jkz.showBottomLine();
                }
            }
            String str = eVar.cDG().ecp;
            if (StringUtils.isNull(str)) {
                this.iiu.setVisibility(8);
                Ks("");
            } else {
                Ks(com.baidu.tieba.hottopic.b.a.aR(str, 10));
            }
            this.jkC.setHeaderBottomLineShow(true);
        }
    }

    private void Ks(String str) {
        if (this.jkG != null) {
            this.jkG.setText(str);
        } else if (this.jkz != null) {
            this.jkG = this.jkz.setCenterTextTitle(str);
        }
    }

    public int getCurrentTab() {
        if (this.ekP.getCurrentItem() < 0) {
            return 0;
        }
        return this.ekP.getCurrentItem();
    }

    public void g(NoNetworkView.a aVar) {
        this.hXf = aVar;
        if (this.fFC != null) {
            this.fFC.a(this.hXf);
        }
    }

    public void AX(int i) {
        this.jkC.setVisibility(i);
        this.ekP.setVisibility(i);
    }

    public void bHn() {
        this.jkD.bHn();
    }

    public void showLoadingView() {
        this.jkD.showLoadingView();
    }

    public void cDY() {
        this.jkD.qf(false);
    }

    public void dC(List<com.baidu.tieba.hottopic.data.e> list) {
        this.jkD.dy(list);
    }

    public void destroy() {
        if (this.jkD != null) {
            this.jkD.destroy();
        }
        if (this.jkB != null) {
            this.jkB.clearAnimation();
        }
        if (this.fFC != null && this.hXf != null) {
            this.fFC.b(this.hXf);
        }
    }

    public void resume() {
        if (this.jkD != null) {
            this.jkD.resume();
        }
    }

    public void pause() {
        if (this.jkD != null) {
            this.jkD.pause();
        }
    }

    public void qi(boolean z) {
        if (this.fFC != null) {
            if (z) {
                this.fFC.setVisibility(0);
            } else {
                this.fFC.setVisibility(8);
            }
        }
    }

    public HotTopicView cEc() {
        return this.jkD.cDb();
    }

    public int cEd() {
        return (this.cPq - this.jkF) - this.mNavigationBarHeight;
    }

    public void AN(int i) {
        if (this.jkD != null) {
            this.jkD.AN(i);
        }
    }

    public void AO(int i) {
        if (this.jkD != null) {
            this.jkD.AO(i);
        }
    }

    public void AP(int i) {
        if (this.jkD != null) {
            this.jkD.AP(i);
        }
    }

    public void a(AbsListView absListView, int i) {
        HotTopicView cDb;
        if (this.jkC != null && this.jkE != null && (cDb = this.jkD.cDb()) != null && cDb.getListView() != null && absListView == cDb.getListView()) {
            this.jkE.setHeaderViewHeight(this.cPq - i);
            this.jkC.setY(-i);
            if (i == 0) {
                this.jkE.ir(false);
            } else {
                this.jkE.ir(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEe() {
        if (this.jkJ) {
            this.jkK = this.jkC.getY();
            this.jkJ = false;
        }
    }

    /* loaded from: classes20.dex */
    public abstract class a implements AbsListView.OnScrollListener {
        public a() {
        }
    }

    public HotTopicHeaderView cEf() {
        return this.jkC;
    }

    public int cEg() {
        return this.cPq;
    }
}
