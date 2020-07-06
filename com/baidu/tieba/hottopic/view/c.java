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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.be;
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
    private int cBB;
    private TbPageContext<HotTopicActivity> dPv;
    private CustomViewPager dSy;
    private NoNetworkView flI;
    public ImageView hHg;
    private NoNetworkView.a hwW;
    private RelativeLayout iGH;
    private NavigationBar iGI;
    private ImageView iGJ;
    private e iGK;
    private HotTopicHeaderView iGL;
    private HotTopicThreadPagerAdapter iGM;
    private DisableScrollLayout iGN;
    private int iGO;
    private TextView iGP;
    private com.baidu.tieba.hottopic.controller.c iGQ;
    private boolean iGS;
    private float iGT;
    private ImageView iyL;
    private NavigationBar mNavigationBar;
    private int mNavigationBarHeight;
    private String mTopicId;
    private final com.baidu.tbadk.widget.layout.e eLG = new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.hottopic.view.c.1
        @Override // com.baidu.tbadk.widget.layout.e
        public void d(View view, int i, int i2, int i3, int i4) {
            c.this.mNavigationBarHeight = i2;
            if (c.this.iGL != null) {
                c.this.iGL.xJ(i2);
            }
        }
    };
    private final com.baidu.tbadk.widget.layout.e iGR = new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.hottopic.view.c.2
        @Override // com.baidu.tbadk.widget.layout.e
        public void d(View view, int i, int i2, int i3, int i4) {
            c.this.cBB = i2;
            c.this.iGM.xz(i2);
            c.this.iGN.setHeaderViewHeight(i2);
        }
    };
    private boolean iGU = false;
    private a iCo = new a() { // from class: com.baidu.tieba.hottopic.view.c.5
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            HotTopicView cla = c.this.iGM.cla();
            if (cla != null && absListView == cla.getListView() && i == 0) {
                c.this.iGS = true;
                float y = c.this.iGL.getY();
                if (c.this.iGM != null) {
                    if (Math.abs(c.this.iGT) != c.this.cmd() || c.this.iGT == y) {
                        c.this.iGM.xD((int) (c.this.iGT - y));
                        return;
                    }
                    c.this.iGM.am(y);
                    c.this.mNavigationBar.hideBottomLine();
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            HotTopicActivity hotTopicActivity;
            HotTopicView cla = c.this.iGM.cla();
            if (cla != null) {
                if (absListView == cla.getListView()) {
                    if (c.this.iGK != null) {
                        c.this.iGK.xN(i);
                    }
                    c.this.cme();
                }
                if (c.this.iGM != null && c.this.iGL.getNavigationBarSwitchHeight() != c.this.mNavigationBarHeight) {
                    if (c.this.iGU) {
                        float navigationBarSwitchHeight = (-c.this.iGL.getY()) / (c.this.iGL.getNavigationBarSwitchHeight() - c.this.mNavigationBarHeight);
                        c.this.mNavigationBar.setAlpha(1.0f - navigationBarSwitchHeight);
                        c.this.iGI.setAlpha(navigationBarSwitchHeight);
                        if (c.this.iGP != null) {
                            c.this.iGP.setAlpha((-c.this.iGL.getY()) / (c.this.iGL.getNavigationBarSwitchHeight() - c.this.mNavigationBarHeight));
                        }
                    } else {
                        if (c.this.iGP != null) {
                            c.this.iGP.setAlpha((-c.this.iGL.getY()) / (c.this.iGL.getNavigationBarSwitchHeight() - c.this.mNavigationBarHeight));
                        }
                        if (Math.abs(c.this.iGT) == c.this.cmd()) {
                            c.this.iGI.hideBottomLine();
                        } else {
                            c.this.iGI.showBottomLine();
                        }
                    }
                }
                if (i == 0 && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && (hotTopicActivity = (HotTopicActivity) c.this.dPv.getOrignalPage()) != null) {
                    hotTopicActivity.onScrollToBottom();
                }
            }
        }
    };

    public c(TbPageContext<HotTopicActivity> tbPageContext, String str) {
        this.dPv = tbPageContext;
        this.mTopicId = str;
        initView();
    }

    private void initView() {
        if (this.dPv != null) {
            this.dPv.getOrignalPage().setContentView(R.layout.hot_topic_activity);
            this.iGO = l.getDimens(this.dPv.getPageActivity(), R.dimen.ds80);
            this.iGQ = new com.baidu.tieba.hottopic.controller.c((OvalActionButton) this.dPv.getOrignalPage().findViewById(R.id.topic_post_forum_button), this.dPv);
            this.iGQ.setTopicId(this.mTopicId);
            this.iGH = (RelativeLayout) this.dPv.getOrignalPage().findViewById(R.id.hot_topic_root_view);
            this.iGN = (DisableScrollLayout) this.iGH.findViewById(R.id.disable_scroll_layout);
            this.mNavigationBar = (NavigationBar) this.dPv.getOrignalPage().findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.hideBottomLine();
            this.iGI = (NavigationBar) this.dPv.getOrignalPage().findViewById(R.id.view_navigation_bar_after_scroll);
            this.iGP = this.iGI.setCenterTextTitle("");
            this.iGP.setAlpha(0.0f);
            this.iGI.hideBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            an.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.selector_topbar_return_white);
            this.iGI.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.iyL = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!j.isNetWorkAvailable()) {
                        ((HotTopicActivity) c.this.dPv.getOrignalPage()).showToast(R.string.topic_share_no_network);
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                    if (ShareSwitch.isOn() || be.checkUpIsLogin(c.this.dPv.getContext())) {
                        TiebaStatic.log(new ao("c10521").dk("obj_id", ((HotTopicActivity) c.this.dPv.getOrignalPage()).clq()).dk("topic_id", ((HotTopicActivity) c.this.dPv.getOrignalPage()).clq()));
                        ((HotTopicActivity) c.this.dPv.getOrignalPage()).clh();
                    }
                }
            });
            this.iGJ = (ImageView) this.iGI.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!j.isNetWorkAvailable()) {
                        ((HotTopicActivity) c.this.dPv.getOrignalPage()).showToast(R.string.topic_share_no_network);
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                    if (ShareSwitch.isOn() || be.checkUpIsLogin(c.this.dPv.getContext())) {
                        TiebaStatic.log(new ao("c10521").dk("obj_id", ((HotTopicActivity) c.this.dPv.getOrignalPage()).clq()).dk("topic_id", ((HotTopicActivity) c.this.dPv.getOrignalPage()).clq()));
                        ((HotTopicActivity) c.this.dPv.getOrignalPage()).clh();
                    }
                }
            });
            this.flI = (NoNetworkView) this.iGH.findViewById(R.id.view_no_network);
            ((ObservedChangeLinearLayout) this.iGH.findViewById(R.id.hot_topic_observed_change_layout)).setOnSizeChangeListener(this.eLG);
            this.iGK = new e(this.dPv, this.iGH);
            this.iGL = (HotTopicHeaderView) this.iGH.findViewById(R.id.hot_topic_header);
            this.iGL.setOnSizeChangeListener(this.iGR);
            this.dSy = (CustomViewPager) this.iGH.findViewById(R.id.hot_topic_view_pager);
            this.iGM = new HotTopicThreadPagerAdapter(this.dPv.getPageActivity(), this.iCo);
            this.iGM.setMainView(this);
            this.dSy.setAdapter(this.iGM);
            this.iGL.setViewPager(this.dSy);
            this.iGL.setHeaderBottomLineShow(false);
            this.hHg = (ImageView) this.iGH.findViewById(R.id.normal_write_icon);
            this.hHg.setVisibility(8);
        }
    }

    public void a(int i, boolean z, long j, int i2) {
        this.iGK.a(i, z, j, i2);
    }

    public void b(View.OnTouchListener onTouchListener) {
        if (onTouchListener != null && this.hHg != null) {
            this.hHg.setOnTouchListener(onTouchListener);
        }
    }

    public View clV() {
        return this.iGH;
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null && this.iGU) {
            this.mNavigationBar.onChangeSkinType(this.dPv, i);
            this.mNavigationBar.setBackgroundResource(R.drawable.black_alpha_from_30_to_0);
            an.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.selector_topbar_return_white);
            this.mNavigationBar.setAlpha((this.iGL.getY() / (this.iGL.getNavigationBarSwitchHeight() - this.mNavigationBarHeight)) + 1.0f);
        }
        if (this.iGI != null) {
            this.iGI.onChangeSkinType(this.dPv, i);
            if (this.iGU) {
                this.iGI.setAlpha((-this.iGL.getY()) / (this.iGL.getNavigationBarSwitchHeight() - this.mNavigationBarHeight));
            } else {
                this.iGI.setAlpha(1.0f);
            }
        }
        if (this.flI != null) {
            this.flI.onChangeSkinType(this.dPv, i);
        }
        if (this.iGJ != null) {
            SvgManager.aWQ().a(this.iGJ, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.iyL != null) {
            SvgManager.aWQ().a(this.iyL, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.iGL != null) {
            this.iGL.onChangeSkinType();
        }
        if (this.iGM != null) {
            this.iGM.onChangeSkinType(i);
        }
        if (this.hHg != null) {
            an.setBackgroundResource(this.hHg, R.drawable.icon_tabbar_chaticon_n);
            an.setImageResource(this.hHg, R.drawable.icon_tabbar_add_n);
        }
    }

    public void c(com.baidu.tieba.hottopic.data.e eVar) {
        if (eVar != null && eVar.clF() != null) {
            if (!this.iGL.cmb()) {
                this.iGL.setData(eVar.clF());
            }
            if (eVar.clF() != null) {
                this.iGU = !StringUtils.isNull(eVar.clF().iEj);
                this.mNavigationBar.setVisibility(this.iGU ? 0 : 8);
                if (!this.iGU) {
                    this.iGI.setAlpha(1.0f);
                    this.iGI.showBottomLine();
                }
            }
            String str = eVar.clF().dKw;
            if (StringUtils.isNull(str)) {
                this.hHg.setVisibility(8);
                Gl("");
            } else {
                Gl(com.baidu.tieba.hottopic.b.a.aP(str, 10));
            }
            this.iGL.setHeaderBottomLineShow(true);
        }
    }

    private void Gl(String str) {
        if (this.iGP != null) {
            this.iGP.setText(str);
        } else if (this.iGI != null) {
            this.iGP = this.iGI.setCenterTextTitle(str);
        }
    }

    public int getCurrentTab() {
        if (this.dSy.getCurrentItem() < 0) {
            return 0;
        }
        return this.dSy.getCurrentItem();
    }

    public void g(NoNetworkView.a aVar) {
        this.hwW = aVar;
        if (this.flI != null) {
            this.flI.a(this.hwW);
        }
    }

    public void xK(int i) {
        this.iGL.setVisibility(i);
        this.dSy.setVisibility(i);
    }

    public void btO() {
        this.iGM.btO();
    }

    public void showLoadingView() {
        this.iGM.showLoadingView();
    }

    public void clX() {
        this.iGM.oK(false);
    }

    public void di(List<com.baidu.tieba.hottopic.data.e> list) {
        this.iGM.de(list);
    }

    public void destroy() {
        if (this.iGM != null) {
            this.iGM.destroy();
        }
        if (this.iGK != null) {
            this.iGK.clearAnimation();
        }
        if (this.flI != null && this.hwW != null) {
            this.flI.b(this.hwW);
        }
    }

    public void resume() {
        if (this.iGM != null) {
            this.iGM.resume();
        }
    }

    public void pause() {
        if (this.iGM != null) {
            this.iGM.pause();
        }
    }

    public void oN(boolean z) {
        if (this.flI != null) {
            if (z) {
                this.flI.setVisibility(0);
            } else {
                this.flI.setVisibility(8);
            }
        }
    }

    public HotTopicView cmc() {
        return this.iGM.cla();
    }

    public int cmd() {
        return (this.cBB - this.iGO) - this.mNavigationBarHeight;
    }

    public void xA(int i) {
        if (this.iGM != null) {
            this.iGM.xA(i);
        }
    }

    public void xB(int i) {
        if (this.iGM != null) {
            this.iGM.xB(i);
        }
    }

    public void xC(int i) {
        if (this.iGM != null) {
            this.iGM.xC(i);
        }
    }

    public void a(AbsListView absListView, int i) {
        HotTopicView cla;
        if (this.iGL != null && this.iGN != null && (cla = this.iGM.cla()) != null && cla.getListView() != null && absListView == cla.getListView()) {
            this.iGN.setHeaderViewHeight(this.cBB - i);
            this.iGL.setY(-i);
            if (i == 0) {
                this.iGN.hr(false);
            } else {
                this.iGN.hr(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cme() {
        if (this.iGS) {
            this.iGT = this.iGL.getY();
            this.iGS = false;
        }
    }

    /* loaded from: classes8.dex */
    public abstract class a implements AbsListView.OnScrollListener {
        public a() {
        }
    }

    public HotTopicHeaderView cmf() {
        return this.iGL;
    }

    public int cmg() {
        return this.cBB;
    }
}
