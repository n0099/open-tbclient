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
    private int cNm;
    private TbPageContext<HotTopicActivity> efn;
    private CustomViewPager eiw;
    private NoNetworkView fCm;
    private NoNetworkView.a hPZ;
    private ImageView iTP;
    public ImageView ibj;
    private RelativeLayout jbM;
    private NavigationBar jbN;
    private ImageView jbO;
    private e jbP;
    private HotTopicHeaderView jbQ;
    private HotTopicThreadPagerAdapter jbR;
    private DisableScrollLayout jbS;
    private int jbT;
    private TextView jbU;
    private com.baidu.tieba.hottopic.controller.c jbV;
    private boolean jbX;
    private float jbY;
    private NavigationBar mNavigationBar;
    private int mNavigationBarHeight;
    private String mTopicId;
    private final com.baidu.tbadk.widget.layout.e fcI = new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.hottopic.view.c.1
        @Override // com.baidu.tbadk.widget.layout.e
        public void d(View view, int i, int i2, int i3, int i4) {
            c.this.mNavigationBarHeight = i2;
            if (c.this.jbQ != null) {
                c.this.jbQ.Av(i2);
            }
        }
    };
    private final com.baidu.tbadk.widget.layout.e jbW = new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.hottopic.view.c.2
        @Override // com.baidu.tbadk.widget.layout.e
        public void d(View view, int i, int i2, int i3, int i4) {
            c.this.cNm = i2;
            c.this.jbR.Al(i2);
            c.this.jbS.setHeaderViewHeight(i2);
        }
    };
    private boolean jbZ = false;
    private a iXs = new a() { // from class: com.baidu.tieba.hottopic.view.c.5
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            HotTopicView czt = c.this.jbR.czt();
            if (czt != null && absListView == czt.getListView() && i == 0) {
                c.this.jbX = true;
                float y = c.this.jbQ.getY();
                if (c.this.jbR != null) {
                    if (Math.abs(c.this.jbY) != c.this.cAv() || c.this.jbY == y) {
                        c.this.jbR.Ap((int) (c.this.jbY - y));
                        return;
                    }
                    c.this.jbR.as(y);
                    c.this.mNavigationBar.hideBottomLine();
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            HotTopicActivity hotTopicActivity;
            HotTopicView czt = c.this.jbR.czt();
            if (czt != null) {
                if (absListView == czt.getListView()) {
                    if (c.this.jbP != null) {
                        c.this.jbP.Az(i);
                    }
                    c.this.cAw();
                }
                if (c.this.jbR != null && c.this.jbQ.getNavigationBarSwitchHeight() != c.this.mNavigationBarHeight) {
                    if (c.this.jbZ) {
                        float navigationBarSwitchHeight = (-c.this.jbQ.getY()) / (c.this.jbQ.getNavigationBarSwitchHeight() - c.this.mNavigationBarHeight);
                        c.this.mNavigationBar.setAlpha(1.0f - navigationBarSwitchHeight);
                        c.this.jbN.setAlpha(navigationBarSwitchHeight);
                        if (c.this.jbU != null) {
                            c.this.jbU.setAlpha((-c.this.jbQ.getY()) / (c.this.jbQ.getNavigationBarSwitchHeight() - c.this.mNavigationBarHeight));
                        }
                    } else {
                        if (c.this.jbU != null) {
                            c.this.jbU.setAlpha((-c.this.jbQ.getY()) / (c.this.jbQ.getNavigationBarSwitchHeight() - c.this.mNavigationBarHeight));
                        }
                        if (Math.abs(c.this.jbY) == c.this.cAv()) {
                            c.this.jbN.hideBottomLine();
                        } else {
                            c.this.jbN.showBottomLine();
                        }
                    }
                }
                if (i == 0 && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && (hotTopicActivity = (HotTopicActivity) c.this.efn.getOrignalPage()) != null) {
                    hotTopicActivity.onScrollToBottom();
                }
            }
        }
    };

    public c(TbPageContext<HotTopicActivity> tbPageContext, String str) {
        this.efn = tbPageContext;
        this.mTopicId = str;
        initView();
    }

    private void initView() {
        if (this.efn != null) {
            this.efn.getOrignalPage().setContentView(R.layout.hot_topic_activity);
            this.jbT = l.getDimens(this.efn.getPageActivity(), R.dimen.ds80);
            this.jbV = new com.baidu.tieba.hottopic.controller.c((OvalActionButton) this.efn.getOrignalPage().findViewById(R.id.topic_post_forum_button), this.efn);
            this.jbV.setTopicId(this.mTopicId);
            this.jbM = (RelativeLayout) this.efn.getOrignalPage().findViewById(R.id.hot_topic_root_view);
            this.jbS = (DisableScrollLayout) this.jbM.findViewById(R.id.disable_scroll_layout);
            this.mNavigationBar = (NavigationBar) this.efn.getOrignalPage().findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.hideBottomLine();
            this.jbN = (NavigationBar) this.efn.getOrignalPage().findViewById(R.id.view_navigation_bar_after_scroll);
            this.jbU = this.jbN.setCenterTextTitle("");
            this.jbU.setAlpha(0.0f);
            this.jbN.hideBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            ap.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.selector_topbar_return_white);
            this.jbN.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.iTP = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!j.isNetWorkAvailable()) {
                        ((HotTopicActivity) c.this.efn.getOrignalPage()).showToast(R.string.topic_share_no_network);
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                    if (ShareSwitch.isOn() || bg.checkUpIsLogin(c.this.efn.getContext())) {
                        TiebaStatic.log(new aq("c10521").dD("obj_id", ((HotTopicActivity) c.this.efn.getOrignalPage()).czJ()).dD("topic_id", ((HotTopicActivity) c.this.efn.getOrignalPage()).czJ()));
                        ((HotTopicActivity) c.this.efn.getOrignalPage()).czA();
                    }
                }
            });
            this.jbO = (ImageView) this.jbN.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!j.isNetWorkAvailable()) {
                        ((HotTopicActivity) c.this.efn.getOrignalPage()).showToast(R.string.topic_share_no_network);
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                    if (ShareSwitch.isOn() || bg.checkUpIsLogin(c.this.efn.getContext())) {
                        TiebaStatic.log(new aq("c10521").dD("obj_id", ((HotTopicActivity) c.this.efn.getOrignalPage()).czJ()).dD("topic_id", ((HotTopicActivity) c.this.efn.getOrignalPage()).czJ()));
                        ((HotTopicActivity) c.this.efn.getOrignalPage()).czA();
                    }
                }
            });
            this.fCm = (NoNetworkView) this.jbM.findViewById(R.id.view_no_network);
            ((ObservedChangeLinearLayout) this.jbM.findViewById(R.id.hot_topic_observed_change_layout)).setOnSizeChangeListener(this.fcI);
            this.jbP = new e(this.efn, this.jbM);
            this.jbQ = (HotTopicHeaderView) this.jbM.findViewById(R.id.hot_topic_header);
            this.jbQ.setOnSizeChangeListener(this.jbW);
            this.eiw = (CustomViewPager) this.jbM.findViewById(R.id.hot_topic_view_pager);
            this.jbR = new HotTopicThreadPagerAdapter(this.efn.getPageActivity(), this.iXs);
            this.jbR.setMainView(this);
            this.eiw.setAdapter(this.jbR);
            this.jbQ.setViewPager(this.eiw);
            this.jbQ.setHeaderBottomLineShow(false);
            this.ibj = (ImageView) this.jbM.findViewById(R.id.normal_write_icon);
            this.ibj.setVisibility(8);
        }
    }

    public void a(int i, boolean z, long j, int i2) {
        this.jbP.a(i, z, j, i2);
    }

    public void b(View.OnTouchListener onTouchListener) {
        if (onTouchListener != null && this.ibj != null) {
            this.ibj.setOnTouchListener(onTouchListener);
        }
    }

    public View cAo() {
        return this.jbM;
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null && this.jbZ) {
            this.mNavigationBar.onChangeSkinType(this.efn, i);
            this.mNavigationBar.setBackgroundResource(R.drawable.black_alpha_from_30_to_0);
            ap.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.selector_topbar_return_white);
            this.mNavigationBar.setAlpha((this.jbQ.getY() / (this.jbQ.getNavigationBarSwitchHeight() - this.mNavigationBarHeight)) + 1.0f);
        }
        if (this.jbN != null) {
            this.jbN.onChangeSkinType(this.efn, i);
            if (this.jbZ) {
                this.jbN.setAlpha((-this.jbQ.getY()) / (this.jbQ.getNavigationBarSwitchHeight() - this.mNavigationBarHeight));
            } else {
                this.jbN.setAlpha(1.0f);
            }
        }
        if (this.fCm != null) {
            this.fCm.onChangeSkinType(this.efn, i);
        }
        if (this.jbO != null) {
            SvgManager.bjq().a(this.jbO, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.iTP != null) {
            SvgManager.bjq().a(this.iTP, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.jbQ != null) {
            this.jbQ.onChangeSkinType();
        }
        if (this.jbR != null) {
            this.jbR.onChangeSkinType(i);
        }
        if (this.ibj != null) {
            ap.setBackgroundResource(this.ibj, R.drawable.icon_tabbar_chaticon_n);
            ap.setImageResource(this.ibj, R.drawable.icon_tabbar_add_n);
        }
    }

    public void c(com.baidu.tieba.hottopic.data.e eVar) {
        if (eVar != null && eVar.czY() != null) {
            if (!this.jbQ.cAt()) {
                this.jbQ.setData(eVar.czY());
            }
            if (eVar.czY() != null) {
                this.jbZ = !StringUtils.isNull(eVar.czY().iZn);
                this.mNavigationBar.setVisibility(this.jbZ ? 0 : 8);
                if (!this.jbZ) {
                    this.jbN.setAlpha(1.0f);
                    this.jbN.showBottomLine();
                }
            }
            String str = eVar.czY().eab;
            if (StringUtils.isNull(str)) {
                this.ibj.setVisibility(8);
                JP("");
            } else {
                JP(com.baidu.tieba.hottopic.b.a.aR(str, 10));
            }
            this.jbQ.setHeaderBottomLineShow(true);
        }
    }

    private void JP(String str) {
        if (this.jbU != null) {
            this.jbU.setText(str);
        } else if (this.jbN != null) {
            this.jbU = this.jbN.setCenterTextTitle(str);
        }
    }

    public int getCurrentTab() {
        if (this.eiw.getCurrentItem() < 0) {
            return 0;
        }
        return this.eiw.getCurrentItem();
    }

    public void g(NoNetworkView.a aVar) {
        this.hPZ = aVar;
        if (this.fCm != null) {
            this.fCm.a(this.hPZ);
        }
    }

    public void Aw(int i) {
        this.jbQ.setVisibility(i);
        this.eiw.setVisibility(i);
    }

    public void bFW() {
        this.jbR.bFW();
    }

    public void showLoadingView() {
        this.jbR.showLoadingView();
    }

    public void cAq() {
        this.jbR.pV(false);
    }

    public void du(List<com.baidu.tieba.hottopic.data.e> list) {
        this.jbR.dq(list);
    }

    public void destroy() {
        if (this.jbR != null) {
            this.jbR.destroy();
        }
        if (this.jbP != null) {
            this.jbP.clearAnimation();
        }
        if (this.fCm != null && this.hPZ != null) {
            this.fCm.b(this.hPZ);
        }
    }

    public void resume() {
        if (this.jbR != null) {
            this.jbR.resume();
        }
    }

    public void pause() {
        if (this.jbR != null) {
            this.jbR.pause();
        }
    }

    public void pY(boolean z) {
        if (this.fCm != null) {
            if (z) {
                this.fCm.setVisibility(0);
            } else {
                this.fCm.setVisibility(8);
            }
        }
    }

    public HotTopicView cAu() {
        return this.jbR.czt();
    }

    public int cAv() {
        return (this.cNm - this.jbT) - this.mNavigationBarHeight;
    }

    public void Am(int i) {
        if (this.jbR != null) {
            this.jbR.Am(i);
        }
    }

    public void An(int i) {
        if (this.jbR != null) {
            this.jbR.An(i);
        }
    }

    public void Ao(int i) {
        if (this.jbR != null) {
            this.jbR.Ao(i);
        }
    }

    public void a(AbsListView absListView, int i) {
        HotTopicView czt;
        if (this.jbQ != null && this.jbS != null && (czt = this.jbR.czt()) != null && czt.getListView() != null && absListView == czt.getListView()) {
            this.jbS.setHeaderViewHeight(this.cNm - i);
            this.jbQ.setY(-i);
            if (i == 0) {
                this.jbS.it(false);
            } else {
                this.jbS.it(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAw() {
        if (this.jbX) {
            this.jbY = this.jbQ.getY();
            this.jbX = false;
        }
    }

    /* loaded from: classes15.dex */
    public abstract class a implements AbsListView.OnScrollListener {
        public a() {
        }
    }

    public HotTopicHeaderView cAx() {
        return this.jbQ;
    }

    public int cAy() {
        return this.cNm;
    }
}
