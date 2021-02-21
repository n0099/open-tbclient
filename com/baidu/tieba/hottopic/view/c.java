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
/* loaded from: classes8.dex */
public class c {
    private int abW;
    private int dyO;
    private TbPageContext<HotTopicActivity> eUY;
    private CustomViewPager eZd;
    private NoNetworkView gyk;
    private ImageView jTD;
    private NoNetworkView.a jdH;
    public ImageView joS;
    private RelativeLayout kxk;
    private NavigationBar kxl;
    private ImageView kxm;
    private e kxn;
    private HotTopicHeaderView kxo;
    private HotTopicThreadPagerAdapter kxp;
    private DisableScrollLayout kxq;
    private int kxr;
    private TextView kxs;
    private com.baidu.tieba.hottopic.controller.c kxt;
    private boolean kxv;
    private float kxw;
    private NavigationBar mNavigationBar;
    private String mTopicId;
    private final com.baidu.tbadk.widget.layout.e fUG = new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.hottopic.view.c.1
        @Override // com.baidu.tbadk.widget.layout.e
        public void f(View view, int i, int i2, int i3, int i4) {
            c.this.abW = i2;
            if (c.this.kxo != null) {
                c.this.kxo.Cu(i2);
            }
        }
    };
    private final com.baidu.tbadk.widget.layout.e kxu = new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.hottopic.view.c.2
        @Override // com.baidu.tbadk.widget.layout.e
        public void f(View view, int i, int i2, int i3, int i4) {
            c.this.dyO = i2;
            c.this.kxp.Ck(i2);
            c.this.kxq.setHeaderViewHeight(i2);
        }
    };
    private boolean kxx = false;
    private a ksR = new a() { // from class: com.baidu.tieba.hottopic.view.c.5
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            HotTopicView cSJ = c.this.kxp.cSJ();
            if (cSJ != null && absListView == cSJ.getListView() && i == 0) {
                c.this.kxv = true;
                float y = c.this.kxo.getY();
                if (c.this.kxp != null) {
                    if (Math.abs(c.this.kxw) != c.this.cTK() || c.this.kxw == y) {
                        c.this.kxp.Co((int) (c.this.kxw - y));
                        return;
                    }
                    c.this.kxp.aP(y);
                    c.this.mNavigationBar.hideBottomLine();
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            HotTopicActivity hotTopicActivity;
            HotTopicView cSJ = c.this.kxp.cSJ();
            if (cSJ != null) {
                if (absListView == cSJ.getListView()) {
                    if (c.this.kxn != null) {
                        c.this.kxn.Cy(i);
                    }
                    c.this.cTL();
                }
                if (c.this.kxp != null && c.this.kxo.getNavigationBarSwitchHeight() != c.this.abW) {
                    if (c.this.kxx) {
                        float navigationBarSwitchHeight = (-c.this.kxo.getY()) / (c.this.kxo.getNavigationBarSwitchHeight() - c.this.abW);
                        c.this.mNavigationBar.setAlpha(1.0f - navigationBarSwitchHeight);
                        c.this.kxl.setAlpha(navigationBarSwitchHeight);
                        if (c.this.kxs != null) {
                            c.this.kxs.setAlpha((-c.this.kxo.getY()) / (c.this.kxo.getNavigationBarSwitchHeight() - c.this.abW));
                        }
                    } else {
                        if (c.this.kxs != null) {
                            c.this.kxs.setAlpha((-c.this.kxo.getY()) / (c.this.kxo.getNavigationBarSwitchHeight() - c.this.abW));
                        }
                        if (Math.abs(c.this.kxw) == c.this.cTK()) {
                            c.this.kxl.hideBottomLine();
                        } else {
                            c.this.kxl.showBottomLine();
                        }
                    }
                }
                if (i == 0 && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && (hotTopicActivity = (HotTopicActivity) c.this.eUY.getOrignalPage()) != null) {
                    hotTopicActivity.onScrollToBottom();
                }
            }
        }
    };

    public c(TbPageContext<HotTopicActivity> tbPageContext, String str) {
        this.eUY = tbPageContext;
        this.mTopicId = str;
        initView();
    }

    private void initView() {
        if (this.eUY != null) {
            this.eUY.getOrignalPage().setContentView(R.layout.hot_topic_activity);
            this.kxr = l.getDimens(this.eUY.getPageActivity(), R.dimen.ds80);
            this.kxt = new com.baidu.tieba.hottopic.controller.c((OvalActionButton) this.eUY.getOrignalPage().findViewById(R.id.topic_post_forum_button), this.eUY);
            this.kxt.setTopicId(this.mTopicId);
            this.kxk = (RelativeLayout) this.eUY.getOrignalPage().findViewById(R.id.hot_topic_root_view);
            this.kxq = (DisableScrollLayout) this.kxk.findViewById(R.id.disable_scroll_layout);
            this.mNavigationBar = (NavigationBar) this.eUY.getOrignalPage().findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.hideBottomLine();
            this.kxl = (NavigationBar) this.eUY.getOrignalPage().findViewById(R.id.view_navigation_bar_after_scroll);
            this.kxs = this.kxl.setCenterTextTitle("");
            this.kxs.setAlpha(0.0f);
            this.kxl.hideBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            ap.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.selector_topbar_return_white);
            this.kxl.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.jTD = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!j.isNetWorkAvailable()) {
                        ((HotTopicActivity) c.this.eUY.getOrignalPage()).showToast(R.string.topic_share_no_network);
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                    if (ShareSwitch.isOn() || bh.checkUpIsLogin(c.this.eUY.getContext())) {
                        TiebaStatic.log(new ar("c10521").dR("obj_id", ((HotTopicActivity) c.this.eUY.getOrignalPage()).cSZ()).dR("topic_id", ((HotTopicActivity) c.this.eUY.getOrignalPage()).cSZ()));
                        ((HotTopicActivity) c.this.eUY.getOrignalPage()).cSQ();
                    }
                }
            });
            this.kxm = (ImageView) this.kxl.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!j.isNetWorkAvailable()) {
                        ((HotTopicActivity) c.this.eUY.getOrignalPage()).showToast(R.string.topic_share_no_network);
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                    if (ShareSwitch.isOn() || bh.checkUpIsLogin(c.this.eUY.getContext())) {
                        TiebaStatic.log(new ar("c10521").dR("obj_id", ((HotTopicActivity) c.this.eUY.getOrignalPage()).cSZ()).dR("topic_id", ((HotTopicActivity) c.this.eUY.getOrignalPage()).cSZ()));
                        ((HotTopicActivity) c.this.eUY.getOrignalPage()).cSQ();
                    }
                }
            });
            this.gyk = (NoNetworkView) this.kxk.findViewById(R.id.view_no_network);
            ((ObservedChangeLinearLayout) this.kxk.findViewById(R.id.hot_topic_observed_change_layout)).setOnSizeChangeListener(this.fUG);
            this.kxn = new e(this.eUY, this.kxk);
            this.kxo = (HotTopicHeaderView) this.kxk.findViewById(R.id.hot_topic_header);
            this.kxo.setOnSizeChangeListener(this.kxu);
            this.eZd = (CustomViewPager) this.kxk.findViewById(R.id.hot_topic_view_pager);
            this.kxp = new HotTopicThreadPagerAdapter(this.eUY.getPageActivity(), this.ksR);
            this.kxp.setMainView(this);
            this.eZd.setAdapter(this.kxp);
            this.kxo.setViewPager(this.eZd);
            this.kxo.setHeaderBottomLineShow(false);
            this.joS = (ImageView) this.kxk.findViewById(R.id.normal_write_icon);
            this.joS.setVisibility(8);
        }
    }

    public void a(int i, boolean z, long j, int i2) {
        this.kxn.a(i, z, j, i2);
    }

    public void b(View.OnTouchListener onTouchListener) {
        if (onTouchListener != null && this.joS != null) {
            this.joS.setOnTouchListener(onTouchListener);
        }
    }

    public View cTD() {
        return this.kxk;
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null && this.kxx) {
            this.mNavigationBar.onChangeSkinType(this.eUY, i);
            this.mNavigationBar.setBackgroundResource(R.drawable.black_alpha_from_30_to_0);
            ap.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.selector_topbar_return_white);
            this.mNavigationBar.setAlpha((this.kxo.getY() / (this.kxo.getNavigationBarSwitchHeight() - this.abW)) + 1.0f);
        }
        if (this.kxl != null) {
            this.kxl.onChangeSkinType(this.eUY, i);
            if (this.kxx) {
                this.kxl.setAlpha((-this.kxo.getY()) / (this.kxo.getNavigationBarSwitchHeight() - this.abW));
            } else {
                this.kxl.setAlpha(1.0f);
            }
        }
        if (this.gyk != null) {
            this.gyk.onChangeSkinType(this.eUY, i);
        }
        if (this.kxm != null) {
            SvgManager.bsR().a(this.kxm, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.jTD != null) {
            SvgManager.bsR().a(this.jTD, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.kxo != null) {
            this.kxo.onChangeSkinType();
        }
        if (this.kxp != null) {
            this.kxp.onChangeSkinType(i);
        }
        if (this.joS != null) {
            ap.setBackgroundResource(this.joS, R.drawable.icon_tabbar_chaticon_n);
            ap.setImageResource(this.joS, R.drawable.icon_tabbar_add_n);
        }
    }

    public void b(com.baidu.tieba.hottopic.data.e eVar) {
        if (eVar != null && eVar.cTo() != null) {
            if (!this.kxo.cTI()) {
                this.kxo.setData(eVar.cTo());
            }
            if (eVar.cTo() != null) {
                this.kxx = !StringUtils.isNull(eVar.cTo().kuL);
                this.mNavigationBar.setVisibility(this.kxx ? 0 : 8);
                if (!this.kxx) {
                    this.kxl.setAlpha(1.0f);
                    this.kxl.showBottomLine();
                }
            }
            String str = eVar.cTo().ePt;
            if (StringUtils.isNull(str)) {
                this.joS.setVisibility(8);
                Ml("");
            } else {
                Ml(com.baidu.tieba.hottopic.a.a.be(str, 10));
            }
            this.kxo.setHeaderBottomLineShow(true);
        }
    }

    private void Ml(String str) {
        if (this.kxs != null) {
            this.kxs.setText(str);
        } else if (this.kxl != null) {
            this.kxs = this.kxl.setCenterTextTitle(str);
        }
    }

    public int getCurrentTab() {
        if (this.eZd.getCurrentItem() < 0) {
            return 0;
        }
        return this.eZd.getCurrentItem();
    }

    public void g(NoNetworkView.a aVar) {
        this.jdH = aVar;
        if (this.gyk != null) {
            this.gyk.a(this.jdH);
        }
    }

    public void Cv(int i) {
        this.kxo.setVisibility(i);
        this.eZd.setVisibility(i);
    }

    public void WZ() {
        this.kxp.WZ();
    }

    public void showLoadingView() {
        this.kxp.showLoadingView();
    }

    public void cTF() {
        this.kxp.sx(false);
    }

    public void em(List<com.baidu.tieba.hottopic.data.e> list) {
        this.kxp.ei(list);
    }

    public void destroy() {
        if (this.kxp != null) {
            this.kxp.destroy();
        }
        if (this.kxn != null) {
            this.kxn.clearAnimation();
        }
        if (this.gyk != null && this.jdH != null) {
            this.gyk.b(this.jdH);
        }
    }

    public void resume() {
        if (this.kxp != null) {
            this.kxp.resume();
        }
    }

    public void pause() {
        if (this.kxp != null) {
            this.kxp.pause();
        }
    }

    public void sA(boolean z) {
        if (this.gyk != null) {
            if (z) {
                this.gyk.setVisibility(0);
            } else {
                this.gyk.setVisibility(8);
            }
        }
    }

    public HotTopicView cTJ() {
        return this.kxp.cSJ();
    }

    public int cTK() {
        return (this.dyO - this.kxr) - this.abW;
    }

    public void Cl(int i) {
        if (this.kxp != null) {
            this.kxp.Cl(i);
        }
    }

    public void Cm(int i) {
        if (this.kxp != null) {
            this.kxp.Cm(i);
        }
    }

    public void Cn(int i) {
        if (this.kxp != null) {
            this.kxp.Cn(i);
        }
    }

    public void a(AbsListView absListView, int i) {
        HotTopicView cSJ;
        if (this.kxo != null && this.kxq != null && (cSJ = this.kxp.cSJ()) != null && cSJ.getListView() != null && absListView == cSJ.getListView()) {
            this.kxq.setHeaderViewHeight(this.dyO - i);
            this.kxo.setY(-i);
            if (i == 0) {
                this.kxq.jX(false);
            } else {
                this.kxq.jX(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTL() {
        if (this.kxv) {
            this.kxw = this.kxo.getY();
            this.kxv = false;
        }
    }

    /* loaded from: classes8.dex */
    public abstract class a implements AbsListView.OnScrollListener {
        public a() {
        }
    }

    public HotTopicHeaderView cTM() {
        return this.kxo;
    }

    public int cTN() {
        return this.dyO;
    }
}
