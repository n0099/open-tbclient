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
/* loaded from: classes20.dex */
public class c {
    private int dok;
    private TbPageContext<HotTopicActivity> eGu;
    private CustomViewPager eKk;
    private NoNetworkView ghk;
    private NoNetworkView.a iFn;
    public ImageView iQx;
    private ImageView jKJ;
    private RelativeLayout jSC;
    private NavigationBar jSD;
    private ImageView jSE;
    private e jSF;
    private HotTopicHeaderView jSG;
    private HotTopicThreadPagerAdapter jSH;
    private DisableScrollLayout jSI;
    private int jSJ;
    private TextView jSK;
    private com.baidu.tieba.hottopic.controller.c jSL;
    private boolean jSN;
    private float jSO;
    private NavigationBar mNavigationBar;
    private int mNavigationBarHeight;
    private String mTopicId;
    private final com.baidu.tbadk.widget.layout.e fFI = new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.hottopic.view.c.1
        @Override // com.baidu.tbadk.widget.layout.e
        public void d(View view, int i, int i2, int i3, int i4) {
            c.this.mNavigationBarHeight = i2;
            if (c.this.jSG != null) {
                c.this.jSG.CG(i2);
            }
        }
    };
    private final com.baidu.tbadk.widget.layout.e jSM = new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.hottopic.view.c.2
        @Override // com.baidu.tbadk.widget.layout.e
        public void d(View view, int i, int i2, int i3, int i4) {
            c.this.dok = i2;
            c.this.jSH.Cw(i2);
            c.this.jSI.setHeaderViewHeight(i2);
        }
    };
    private boolean jSP = false;
    private a jOk = new a() { // from class: com.baidu.tieba.hottopic.view.c.5
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            HotTopicView cLZ = c.this.jSH.cLZ();
            if (cLZ != null && absListView == cLZ.getListView() && i == 0) {
                c.this.jSN = true;
                float y = c.this.jSG.getY();
                if (c.this.jSH != null) {
                    if (Math.abs(c.this.jSO) != c.this.cNa() || c.this.jSO == y) {
                        c.this.jSH.CA((int) (c.this.jSO - y));
                        return;
                    }
                    c.this.jSH.aJ(y);
                    c.this.mNavigationBar.hideBottomLine();
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            HotTopicActivity hotTopicActivity;
            HotTopicView cLZ = c.this.jSH.cLZ();
            if (cLZ != null) {
                if (absListView == cLZ.getListView()) {
                    if (c.this.jSF != null) {
                        c.this.jSF.CK(i);
                    }
                    c.this.cNb();
                }
                if (c.this.jSH != null && c.this.jSG.getNavigationBarSwitchHeight() != c.this.mNavigationBarHeight) {
                    if (c.this.jSP) {
                        float navigationBarSwitchHeight = (-c.this.jSG.getY()) / (c.this.jSG.getNavigationBarSwitchHeight() - c.this.mNavigationBarHeight);
                        c.this.mNavigationBar.setAlpha(1.0f - navigationBarSwitchHeight);
                        c.this.jSD.setAlpha(navigationBarSwitchHeight);
                        if (c.this.jSK != null) {
                            c.this.jSK.setAlpha((-c.this.jSG.getY()) / (c.this.jSG.getNavigationBarSwitchHeight() - c.this.mNavigationBarHeight));
                        }
                    } else {
                        if (c.this.jSK != null) {
                            c.this.jSK.setAlpha((-c.this.jSG.getY()) / (c.this.jSG.getNavigationBarSwitchHeight() - c.this.mNavigationBarHeight));
                        }
                        if (Math.abs(c.this.jSO) == c.this.cNa()) {
                            c.this.jSD.hideBottomLine();
                        } else {
                            c.this.jSD.showBottomLine();
                        }
                    }
                }
                if (i == 0 && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && (hotTopicActivity = (HotTopicActivity) c.this.eGu.getOrignalPage()) != null) {
                    hotTopicActivity.onScrollToBottom();
                }
            }
        }
    };

    public c(TbPageContext<HotTopicActivity> tbPageContext, String str) {
        this.eGu = tbPageContext;
        this.mTopicId = str;
        initView();
    }

    private void initView() {
        if (this.eGu != null) {
            this.eGu.getOrignalPage().setContentView(R.layout.hot_topic_activity);
            this.jSJ = l.getDimens(this.eGu.getPageActivity(), R.dimen.ds80);
            this.jSL = new com.baidu.tieba.hottopic.controller.c((OvalActionButton) this.eGu.getOrignalPage().findViewById(R.id.topic_post_forum_button), this.eGu);
            this.jSL.setTopicId(this.mTopicId);
            this.jSC = (RelativeLayout) this.eGu.getOrignalPage().findViewById(R.id.hot_topic_root_view);
            this.jSI = (DisableScrollLayout) this.jSC.findViewById(R.id.disable_scroll_layout);
            this.mNavigationBar = (NavigationBar) this.eGu.getOrignalPage().findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.hideBottomLine();
            this.jSD = (NavigationBar) this.eGu.getOrignalPage().findViewById(R.id.view_navigation_bar_after_scroll);
            this.jSK = this.jSD.setCenterTextTitle("");
            this.jSK.setAlpha(0.0f);
            this.jSD.hideBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            ap.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.selector_topbar_return_white);
            this.jSD.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.jKJ = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!j.isNetWorkAvailable()) {
                        ((HotTopicActivity) c.this.eGu.getOrignalPage()).showToast(R.string.topic_share_no_network);
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                    if (ShareSwitch.isOn() || bh.checkUpIsLogin(c.this.eGu.getContext())) {
                        TiebaStatic.log(new ar("c10521").dR("obj_id", ((HotTopicActivity) c.this.eGu.getOrignalPage()).cMp()).dR("topic_id", ((HotTopicActivity) c.this.eGu.getOrignalPage()).cMp()));
                        ((HotTopicActivity) c.this.eGu.getOrignalPage()).cMg();
                    }
                }
            });
            this.jSE = (ImageView) this.jSD.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!j.isNetWorkAvailable()) {
                        ((HotTopicActivity) c.this.eGu.getOrignalPage()).showToast(R.string.topic_share_no_network);
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                    if (ShareSwitch.isOn() || bh.checkUpIsLogin(c.this.eGu.getContext())) {
                        TiebaStatic.log(new ar("c10521").dR("obj_id", ((HotTopicActivity) c.this.eGu.getOrignalPage()).cMp()).dR("topic_id", ((HotTopicActivity) c.this.eGu.getOrignalPage()).cMp()));
                        ((HotTopicActivity) c.this.eGu.getOrignalPage()).cMg();
                    }
                }
            });
            this.ghk = (NoNetworkView) this.jSC.findViewById(R.id.view_no_network);
            ((ObservedChangeLinearLayout) this.jSC.findViewById(R.id.hot_topic_observed_change_layout)).setOnSizeChangeListener(this.fFI);
            this.jSF = new e(this.eGu, this.jSC);
            this.jSG = (HotTopicHeaderView) this.jSC.findViewById(R.id.hot_topic_header);
            this.jSG.setOnSizeChangeListener(this.jSM);
            this.eKk = (CustomViewPager) this.jSC.findViewById(R.id.hot_topic_view_pager);
            this.jSH = new HotTopicThreadPagerAdapter(this.eGu.getPageActivity(), this.jOk);
            this.jSH.setMainView(this);
            this.eKk.setAdapter(this.jSH);
            this.jSG.setViewPager(this.eKk);
            this.jSG.setHeaderBottomLineShow(false);
            this.iQx = (ImageView) this.jSC.findViewById(R.id.normal_write_icon);
            this.iQx.setVisibility(8);
        }
    }

    public void a(int i, boolean z, long j, int i2) {
        this.jSF.a(i, z, j, i2);
    }

    public void b(View.OnTouchListener onTouchListener) {
        if (onTouchListener != null && this.iQx != null) {
            this.iQx.setOnTouchListener(onTouchListener);
        }
    }

    public View cMT() {
        return this.jSC;
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null && this.jSP) {
            this.mNavigationBar.onChangeSkinType(this.eGu, i);
            this.mNavigationBar.setBackgroundResource(R.drawable.black_alpha_from_30_to_0);
            ap.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.selector_topbar_return_white);
            this.mNavigationBar.setAlpha((this.jSG.getY() / (this.jSG.getNavigationBarSwitchHeight() - this.mNavigationBarHeight)) + 1.0f);
        }
        if (this.jSD != null) {
            this.jSD.onChangeSkinType(this.eGu, i);
            if (this.jSP) {
                this.jSD.setAlpha((-this.jSG.getY()) / (this.jSG.getNavigationBarSwitchHeight() - this.mNavigationBarHeight));
            } else {
                this.jSD.setAlpha(1.0f);
            }
        }
        if (this.ghk != null) {
            this.ghk.onChangeSkinType(this.eGu, i);
        }
        if (this.jSE != null) {
            SvgManager.bqB().a(this.jSE, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.jKJ != null) {
            SvgManager.bqB().a(this.jKJ, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.jSG != null) {
            this.jSG.onChangeSkinType();
        }
        if (this.jSH != null) {
            this.jSH.onChangeSkinType(i);
        }
        if (this.iQx != null) {
            ap.setBackgroundResource(this.iQx, R.drawable.icon_tabbar_chaticon_n);
            ap.setImageResource(this.iQx, R.drawable.icon_tabbar_add_n);
        }
    }

    public void c(com.baidu.tieba.hottopic.data.e eVar) {
        if (eVar != null && eVar.cME() != null) {
            if (!this.jSG.cMY()) {
                this.jSG.setData(eVar.cME());
            }
            if (eVar.cME() != null) {
                this.jSP = !StringUtils.isNull(eVar.cME().jQe);
                this.mNavigationBar.setVisibility(this.jSP ? 0 : 8);
                if (!this.jSP) {
                    this.jSD.setAlpha(1.0f);
                    this.jSD.showBottomLine();
                }
            }
            String str = eVar.cME().eBa;
            if (StringUtils.isNull(str)) {
                this.iQx.setVisibility(8);
                Lx("");
            } else {
                Lx(com.baidu.tieba.hottopic.b.a.aU(str, 10));
            }
            this.jSG.setHeaderBottomLineShow(true);
        }
    }

    private void Lx(String str) {
        if (this.jSK != null) {
            this.jSK.setText(str);
        } else if (this.jSD != null) {
            this.jSK = this.jSD.setCenterTextTitle(str);
        }
    }

    public int getCurrentTab() {
        if (this.eKk.getCurrentItem() < 0) {
            return 0;
        }
        return this.eKk.getCurrentItem();
    }

    public void g(NoNetworkView.a aVar) {
        this.iFn = aVar;
        if (this.ghk != null) {
            this.ghk.a(this.iFn);
        }
    }

    public void CH(int i) {
        this.jSG.setVisibility(i);
        this.eKk.setVisibility(i);
    }

    public void VB() {
        this.jSH.VB();
    }

    public void showLoadingView() {
        this.jSH.showLoadingView();
    }

    public void cMV() {
        this.jSH.rp(false);
    }

    public void dW(List<com.baidu.tieba.hottopic.data.e> list) {
        this.jSH.dS(list);
    }

    public void destroy() {
        if (this.jSH != null) {
            this.jSH.destroy();
        }
        if (this.jSF != null) {
            this.jSF.clearAnimation();
        }
        if (this.ghk != null && this.iFn != null) {
            this.ghk.b(this.iFn);
        }
    }

    public void resume() {
        if (this.jSH != null) {
            this.jSH.resume();
        }
    }

    public void pause() {
        if (this.jSH != null) {
            this.jSH.pause();
        }
    }

    public void rs(boolean z) {
        if (this.ghk != null) {
            if (z) {
                this.ghk.setVisibility(0);
            } else {
                this.ghk.setVisibility(8);
            }
        }
    }

    public HotTopicView cMZ() {
        return this.jSH.cLZ();
    }

    public int cNa() {
        return (this.dok - this.jSJ) - this.mNavigationBarHeight;
    }

    public void Cx(int i) {
        if (this.jSH != null) {
            this.jSH.Cx(i);
        }
    }

    public void Cy(int i) {
        if (this.jSH != null) {
            this.jSH.Cy(i);
        }
    }

    public void Cz(int i) {
        if (this.jSH != null) {
            this.jSH.Cz(i);
        }
    }

    public void a(AbsListView absListView, int i) {
        HotTopicView cLZ;
        if (this.jSG != null && this.jSI != null && (cLZ = this.jSH.cLZ()) != null && cLZ.getListView() != null && absListView == cLZ.getListView()) {
            this.jSI.setHeaderViewHeight(this.dok - i);
            this.jSG.setY(-i);
            if (i == 0) {
                this.jSI.jm(false);
            } else {
                this.jSI.jm(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cNb() {
        if (this.jSN) {
            this.jSO = this.jSG.getY();
            this.jSN = false;
        }
    }

    /* loaded from: classes20.dex */
    public abstract class a implements AbsListView.OnScrollListener {
        public a() {
        }
    }

    public HotTopicHeaderView cNc() {
        return this.jSG;
    }

    public int cNd() {
        return this.dok;
    }
}
