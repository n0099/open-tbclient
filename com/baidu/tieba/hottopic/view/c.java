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
/* loaded from: classes7.dex */
public class c {
    private int acb;
    private int dwJ;
    private TbPageContext<HotTopicActivity> eSJ;
    private CustomViewPager eWN;
    private NoNetworkView gvm;
    private NoNetworkView.a iXM;
    private ImageView jMm;
    public ImageView jiX;
    private RelativeLayout koP;
    private NavigationBar koQ;
    private ImageView koR;
    private e koS;
    private HotTopicHeaderView koT;
    private HotTopicThreadPagerAdapter koU;
    private DisableScrollLayout koV;
    private int koW;
    private TextView koX;
    private com.baidu.tieba.hottopic.controller.c koY;
    private boolean kpa;
    private float kpb;
    private NavigationBar mNavigationBar;
    private String mTopicId;
    private final com.baidu.tbadk.widget.layout.e fSr = new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.hottopic.view.c.1
        @Override // com.baidu.tbadk.widget.layout.e
        public void f(View view, int i, int i2, int i3, int i4) {
            c.this.acb = i2;
            if (c.this.koT != null) {
                c.this.koT.Cc(i2);
            }
        }
    };
    private final com.baidu.tbadk.widget.layout.e koZ = new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.hottopic.view.c.2
        @Override // com.baidu.tbadk.widget.layout.e
        public void f(View view, int i, int i2, int i3, int i4) {
            c.this.dwJ = i2;
            c.this.koU.BS(i2);
            c.this.koV.setHeaderViewHeight(i2);
        }
    };
    private boolean kpc = false;
    private a kkw = new a() { // from class: com.baidu.tieba.hottopic.view.c.5
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            HotTopicView cQD = c.this.koU.cQD();
            if (cQD != null && absListView == cQD.getListView() && i == 0) {
                c.this.kpa = true;
                float y = c.this.koT.getY();
                if (c.this.koU != null) {
                    if (Math.abs(c.this.kpb) != c.this.cRE() || c.this.kpb == y) {
                        c.this.koU.BW((int) (c.this.kpb - y));
                        return;
                    }
                    c.this.koU.aM(y);
                    c.this.mNavigationBar.hideBottomLine();
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            HotTopicActivity hotTopicActivity;
            HotTopicView cQD = c.this.koU.cQD();
            if (cQD != null) {
                if (absListView == cQD.getListView()) {
                    if (c.this.koS != null) {
                        c.this.koS.Cg(i);
                    }
                    c.this.cRF();
                }
                if (c.this.koU != null && c.this.koT.getNavigationBarSwitchHeight() != c.this.acb) {
                    if (c.this.kpc) {
                        float navigationBarSwitchHeight = (-c.this.koT.getY()) / (c.this.koT.getNavigationBarSwitchHeight() - c.this.acb);
                        c.this.mNavigationBar.setAlpha(1.0f - navigationBarSwitchHeight);
                        c.this.koQ.setAlpha(navigationBarSwitchHeight);
                        if (c.this.koX != null) {
                            c.this.koX.setAlpha((-c.this.koT.getY()) / (c.this.koT.getNavigationBarSwitchHeight() - c.this.acb));
                        }
                    } else {
                        if (c.this.koX != null) {
                            c.this.koX.setAlpha((-c.this.koT.getY()) / (c.this.koT.getNavigationBarSwitchHeight() - c.this.acb));
                        }
                        if (Math.abs(c.this.kpb) == c.this.cRE()) {
                            c.this.koQ.hideBottomLine();
                        } else {
                            c.this.koQ.showBottomLine();
                        }
                    }
                }
                if (i == 0 && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && (hotTopicActivity = (HotTopicActivity) c.this.eSJ.getOrignalPage()) != null) {
                    hotTopicActivity.onScrollToBottom();
                }
            }
        }
    };

    public c(TbPageContext<HotTopicActivity> tbPageContext, String str) {
        this.eSJ = tbPageContext;
        this.mTopicId = str;
        initView();
    }

    private void initView() {
        if (this.eSJ != null) {
            this.eSJ.getOrignalPage().setContentView(R.layout.hot_topic_activity);
            this.koW = l.getDimens(this.eSJ.getPageActivity(), R.dimen.ds80);
            this.koY = new com.baidu.tieba.hottopic.controller.c((OvalActionButton) this.eSJ.getOrignalPage().findViewById(R.id.topic_post_forum_button), this.eSJ);
            this.koY.setTopicId(this.mTopicId);
            this.koP = (RelativeLayout) this.eSJ.getOrignalPage().findViewById(R.id.hot_topic_root_view);
            this.koV = (DisableScrollLayout) this.koP.findViewById(R.id.disable_scroll_layout);
            this.mNavigationBar = (NavigationBar) this.eSJ.getOrignalPage().findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.hideBottomLine();
            this.koQ = (NavigationBar) this.eSJ.getOrignalPage().findViewById(R.id.view_navigation_bar_after_scroll);
            this.koX = this.koQ.setCenterTextTitle("");
            this.koX.setAlpha(0.0f);
            this.koQ.hideBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            ao.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.selector_topbar_return_white);
            this.koQ.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.jMm = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!j.isNetWorkAvailable()) {
                        ((HotTopicActivity) c.this.eSJ.getOrignalPage()).showToast(R.string.topic_share_no_network);
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                    if (ShareSwitch.isOn() || bg.checkUpIsLogin(c.this.eSJ.getContext())) {
                        TiebaStatic.log(new aq("c10521").dW("obj_id", ((HotTopicActivity) c.this.eSJ.getOrignalPage()).cQT()).dW("topic_id", ((HotTopicActivity) c.this.eSJ.getOrignalPage()).cQT()));
                        ((HotTopicActivity) c.this.eSJ.getOrignalPage()).cQK();
                    }
                }
            });
            this.koR = (ImageView) this.koQ.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!j.isNetWorkAvailable()) {
                        ((HotTopicActivity) c.this.eSJ.getOrignalPage()).showToast(R.string.topic_share_no_network);
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                    if (ShareSwitch.isOn() || bg.checkUpIsLogin(c.this.eSJ.getContext())) {
                        TiebaStatic.log(new aq("c10521").dW("obj_id", ((HotTopicActivity) c.this.eSJ.getOrignalPage()).cQT()).dW("topic_id", ((HotTopicActivity) c.this.eSJ.getOrignalPage()).cQT()));
                        ((HotTopicActivity) c.this.eSJ.getOrignalPage()).cQK();
                    }
                }
            });
            this.gvm = (NoNetworkView) this.koP.findViewById(R.id.view_no_network);
            ((ObservedChangeLinearLayout) this.koP.findViewById(R.id.hot_topic_observed_change_layout)).setOnSizeChangeListener(this.fSr);
            this.koS = new e(this.eSJ, this.koP);
            this.koT = (HotTopicHeaderView) this.koP.findViewById(R.id.hot_topic_header);
            this.koT.setOnSizeChangeListener(this.koZ);
            this.eWN = (CustomViewPager) this.koP.findViewById(R.id.hot_topic_view_pager);
            this.koU = new HotTopicThreadPagerAdapter(this.eSJ.getPageActivity(), this.kkw);
            this.koU.setMainView(this);
            this.eWN.setAdapter(this.koU);
            this.koT.setViewPager(this.eWN);
            this.koT.setHeaderBottomLineShow(false);
            this.jiX = (ImageView) this.koP.findViewById(R.id.normal_write_icon);
            this.jiX.setVisibility(8);
        }
    }

    public void a(int i, boolean z, long j, int i2) {
        this.koS.a(i, z, j, i2);
    }

    public void b(View.OnTouchListener onTouchListener) {
        if (onTouchListener != null && this.jiX != null) {
            this.jiX.setOnTouchListener(onTouchListener);
        }
    }

    public View cRx() {
        return this.koP;
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null && this.kpc) {
            this.mNavigationBar.onChangeSkinType(this.eSJ, i);
            this.mNavigationBar.setBackgroundResource(R.drawable.black_alpha_from_30_to_0);
            ao.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.selector_topbar_return_white);
            this.mNavigationBar.setAlpha((this.koT.getY() / (this.koT.getNavigationBarSwitchHeight() - this.acb)) + 1.0f);
        }
        if (this.koQ != null) {
            this.koQ.onChangeSkinType(this.eSJ, i);
            if (this.kpc) {
                this.koQ.setAlpha((-this.koT.getY()) / (this.koT.getNavigationBarSwitchHeight() - this.acb));
            } else {
                this.koQ.setAlpha(1.0f);
            }
        }
        if (this.gvm != null) {
            this.gvm.onChangeSkinType(this.eSJ, i);
        }
        if (this.koR != null) {
            SvgManager.bsx().a(this.koR, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.jMm != null) {
            SvgManager.bsx().a(this.jMm, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.koT != null) {
            this.koT.onChangeSkinType();
        }
        if (this.koU != null) {
            this.koU.onChangeSkinType(i);
        }
        if (this.jiX != null) {
            ao.setBackgroundResource(this.jiX, R.drawable.icon_tabbar_chaticon_n);
            ao.setImageResource(this.jiX, R.drawable.icon_tabbar_add_n);
        }
    }

    public void b(com.baidu.tieba.hottopic.data.e eVar) {
        if (eVar != null && eVar.cRi() != null) {
            if (!this.koT.cRC()) {
                this.koT.setData(eVar.cRi());
            }
            if (eVar.cRi() != null) {
                this.kpc = !StringUtils.isNull(eVar.cRi().kmq);
                this.mNavigationBar.setVisibility(this.kpc ? 0 : 8);
                if (!this.kpc) {
                    this.koQ.setAlpha(1.0f);
                    this.koQ.showBottomLine();
                }
            }
            String str = eVar.cRi().eNh;
            if (StringUtils.isNull(str)) {
                this.jiX.setVisibility(8);
                Lw("");
            } else {
                Lw(com.baidu.tieba.hottopic.a.a.be(str, 10));
            }
            this.koT.setHeaderBottomLineShow(true);
        }
    }

    private void Lw(String str) {
        if (this.koX != null) {
            this.koX.setText(str);
        } else if (this.koQ != null) {
            this.koX = this.koQ.setCenterTextTitle(str);
        }
    }

    public int getCurrentTab() {
        if (this.eWN.getCurrentItem() < 0) {
            return 0;
        }
        return this.eWN.getCurrentItem();
    }

    public void g(NoNetworkView.a aVar) {
        this.iXM = aVar;
        if (this.gvm != null) {
            this.gvm.a(this.iXM);
        }
    }

    public void Cd(int i) {
        this.koT.setVisibility(i);
        this.eWN.setVisibility(i);
    }

    public void Vq() {
        this.koU.Vq();
    }

    public void showLoadingView() {
        this.koU.showLoadingView();
    }

    public void cRz() {
        this.koU.sk(false);
    }

    public void eo(List<com.baidu.tieba.hottopic.data.e> list) {
        this.koU.ek(list);
    }

    public void destroy() {
        if (this.koU != null) {
            this.koU.destroy();
        }
        if (this.koS != null) {
            this.koS.clearAnimation();
        }
        if (this.gvm != null && this.iXM != null) {
            this.gvm.b(this.iXM);
        }
    }

    public void resume() {
        if (this.koU != null) {
            this.koU.resume();
        }
    }

    public void pause() {
        if (this.koU != null) {
            this.koU.pause();
        }
    }

    public void sn(boolean z) {
        if (this.gvm != null) {
            if (z) {
                this.gvm.setVisibility(0);
            } else {
                this.gvm.setVisibility(8);
            }
        }
    }

    public HotTopicView cRD() {
        return this.koU.cQD();
    }

    public int cRE() {
        return (this.dwJ - this.koW) - this.acb;
    }

    public void BT(int i) {
        if (this.koU != null) {
            this.koU.BT(i);
        }
    }

    public void BU(int i) {
        if (this.koU != null) {
            this.koU.BU(i);
        }
    }

    public void BV(int i) {
        if (this.koU != null) {
            this.koU.BV(i);
        }
    }

    public void a(AbsListView absListView, int i) {
        HotTopicView cQD;
        if (this.koT != null && this.koV != null && (cQD = this.koU.cQD()) != null && cQD.getListView() != null && absListView == cQD.getListView()) {
            this.koV.setHeaderViewHeight(this.dwJ - i);
            this.koT.setY(-i);
            if (i == 0) {
                this.koV.jU(false);
            } else {
                this.koV.jU(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cRF() {
        if (this.kpa) {
            this.kpb = this.koT.getY();
            this.kpa = false;
        }
    }

    /* loaded from: classes7.dex */
    public abstract class a implements AbsListView.OnScrollListener {
        public a() {
        }
    }

    public HotTopicHeaderView cRG() {
        return this.koT;
    }

    public int cRH() {
        return this.dwJ;
    }
}
