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
    private int djX;
    private TbPageContext<HotTopicActivity> eCn;
    private CustomViewPager eFw;
    private NoNetworkView gbO;
    public ImageView iJN;
    private NoNetworkView.a iyC;
    private ImageView jEa;
    private RelativeLayout jLV;
    private NavigationBar jLW;
    private ImageView jLX;
    private e jLY;
    private HotTopicHeaderView jLZ;
    private HotTopicThreadPagerAdapter jMa;
    private DisableScrollLayout jMb;
    private int jMc;
    private TextView jMd;
    private com.baidu.tieba.hottopic.controller.c jMe;
    private boolean jMg;
    private float jMh;
    private NavigationBar mNavigationBar;
    private int mNavigationBarHeight;
    private String mTopicId;
    private final com.baidu.tbadk.widget.layout.e fAq = new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.hottopic.view.c.1
        @Override // com.baidu.tbadk.widget.layout.e
        public void d(View view, int i, int i2, int i3, int i4) {
            c.this.mNavigationBarHeight = i2;
            if (c.this.jLZ != null) {
                c.this.jLZ.BV(i2);
            }
        }
    };
    private final com.baidu.tbadk.widget.layout.e jMf = new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.hottopic.view.c.2
        @Override // com.baidu.tbadk.widget.layout.e
        public void d(View view, int i, int i2, int i3, int i4) {
            c.this.djX = i2;
            c.this.jMa.BL(i2);
            c.this.jMb.setHeaderViewHeight(i2);
        }
    };
    private boolean jMi = false;
    private a jHC = new a() { // from class: com.baidu.tieba.hottopic.view.c.5
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            HotTopicView cJR = c.this.jMa.cJR();
            if (cJR != null && absListView == cJR.getListView() && i == 0) {
                c.this.jMg = true;
                float y = c.this.jLZ.getY();
                if (c.this.jMa != null) {
                    if (Math.abs(c.this.jMh) != c.this.cKT() || c.this.jMh == y) {
                        c.this.jMa.BP((int) (c.this.jMh - y));
                        return;
                    }
                    c.this.jMa.aA(y);
                    c.this.mNavigationBar.hideBottomLine();
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            HotTopicActivity hotTopicActivity;
            HotTopicView cJR = c.this.jMa.cJR();
            if (cJR != null) {
                if (absListView == cJR.getListView()) {
                    if (c.this.jLY != null) {
                        c.this.jLY.BZ(i);
                    }
                    c.this.cKU();
                }
                if (c.this.jMa != null && c.this.jLZ.getNavigationBarSwitchHeight() != c.this.mNavigationBarHeight) {
                    if (c.this.jMi) {
                        float navigationBarSwitchHeight = (-c.this.jLZ.getY()) / (c.this.jLZ.getNavigationBarSwitchHeight() - c.this.mNavigationBarHeight);
                        c.this.mNavigationBar.setAlpha(1.0f - navigationBarSwitchHeight);
                        c.this.jLW.setAlpha(navigationBarSwitchHeight);
                        if (c.this.jMd != null) {
                            c.this.jMd.setAlpha((-c.this.jLZ.getY()) / (c.this.jLZ.getNavigationBarSwitchHeight() - c.this.mNavigationBarHeight));
                        }
                    } else {
                        if (c.this.jMd != null) {
                            c.this.jMd.setAlpha((-c.this.jLZ.getY()) / (c.this.jLZ.getNavigationBarSwitchHeight() - c.this.mNavigationBarHeight));
                        }
                        if (Math.abs(c.this.jMh) == c.this.cKT()) {
                            c.this.jLW.hideBottomLine();
                        } else {
                            c.this.jLW.showBottomLine();
                        }
                    }
                }
                if (i == 0 && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && (hotTopicActivity = (HotTopicActivity) c.this.eCn.getOrignalPage()) != null) {
                    hotTopicActivity.onScrollToBottom();
                }
            }
        }
    };

    public c(TbPageContext<HotTopicActivity> tbPageContext, String str) {
        this.eCn = tbPageContext;
        this.mTopicId = str;
        initView();
    }

    private void initView() {
        if (this.eCn != null) {
            this.eCn.getOrignalPage().setContentView(R.layout.hot_topic_activity);
            this.jMc = l.getDimens(this.eCn.getPageActivity(), R.dimen.ds80);
            this.jMe = new com.baidu.tieba.hottopic.controller.c((OvalActionButton) this.eCn.getOrignalPage().findViewById(R.id.topic_post_forum_button), this.eCn);
            this.jMe.setTopicId(this.mTopicId);
            this.jLV = (RelativeLayout) this.eCn.getOrignalPage().findViewById(R.id.hot_topic_root_view);
            this.jMb = (DisableScrollLayout) this.jLV.findViewById(R.id.disable_scroll_layout);
            this.mNavigationBar = (NavigationBar) this.eCn.getOrignalPage().findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.hideBottomLine();
            this.jLW = (NavigationBar) this.eCn.getOrignalPage().findViewById(R.id.view_navigation_bar_after_scroll);
            this.jMd = this.jLW.setCenterTextTitle("");
            this.jMd.setAlpha(0.0f);
            this.jLW.hideBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            ap.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.selector_topbar_return_white);
            this.jLW.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.jEa = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!j.isNetWorkAvailable()) {
                        ((HotTopicActivity) c.this.eCn.getOrignalPage()).showToast(R.string.topic_share_no_network);
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                    if (ShareSwitch.isOn() || bg.checkUpIsLogin(c.this.eCn.getContext())) {
                        TiebaStatic.log(new aq("c10521").dR("obj_id", ((HotTopicActivity) c.this.eCn.getOrignalPage()).cKh()).dR("topic_id", ((HotTopicActivity) c.this.eCn.getOrignalPage()).cKh()));
                        ((HotTopicActivity) c.this.eCn.getOrignalPage()).cJY();
                    }
                }
            });
            this.jLX = (ImageView) this.jLW.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!j.isNetWorkAvailable()) {
                        ((HotTopicActivity) c.this.eCn.getOrignalPage()).showToast(R.string.topic_share_no_network);
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                    if (ShareSwitch.isOn() || bg.checkUpIsLogin(c.this.eCn.getContext())) {
                        TiebaStatic.log(new aq("c10521").dR("obj_id", ((HotTopicActivity) c.this.eCn.getOrignalPage()).cKh()).dR("topic_id", ((HotTopicActivity) c.this.eCn.getOrignalPage()).cKh()));
                        ((HotTopicActivity) c.this.eCn.getOrignalPage()).cJY();
                    }
                }
            });
            this.gbO = (NoNetworkView) this.jLV.findViewById(R.id.view_no_network);
            ((ObservedChangeLinearLayout) this.jLV.findViewById(R.id.hot_topic_observed_change_layout)).setOnSizeChangeListener(this.fAq);
            this.jLY = new e(this.eCn, this.jLV);
            this.jLZ = (HotTopicHeaderView) this.jLV.findViewById(R.id.hot_topic_header);
            this.jLZ.setOnSizeChangeListener(this.jMf);
            this.eFw = (CustomViewPager) this.jLV.findViewById(R.id.hot_topic_view_pager);
            this.jMa = new HotTopicThreadPagerAdapter(this.eCn.getPageActivity(), this.jHC);
            this.jMa.setMainView(this);
            this.eFw.setAdapter(this.jMa);
            this.jLZ.setViewPager(this.eFw);
            this.jLZ.setHeaderBottomLineShow(false);
            this.iJN = (ImageView) this.jLV.findViewById(R.id.normal_write_icon);
            this.iJN.setVisibility(8);
        }
    }

    public void a(int i, boolean z, long j, int i2) {
        this.jLY.a(i, z, j, i2);
    }

    public void b(View.OnTouchListener onTouchListener) {
        if (onTouchListener != null && this.iJN != null) {
            this.iJN.setOnTouchListener(onTouchListener);
        }
    }

    public View cKM() {
        return this.jLV;
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null && this.jMi) {
            this.mNavigationBar.onChangeSkinType(this.eCn, i);
            this.mNavigationBar.setBackgroundResource(R.drawable.black_alpha_from_30_to_0);
            ap.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.selector_topbar_return_white);
            this.mNavigationBar.setAlpha((this.jLZ.getY() / (this.jLZ.getNavigationBarSwitchHeight() - this.mNavigationBarHeight)) + 1.0f);
        }
        if (this.jLW != null) {
            this.jLW.onChangeSkinType(this.eCn, i);
            if (this.jMi) {
                this.jLW.setAlpha((-this.jLZ.getY()) / (this.jLZ.getNavigationBarSwitchHeight() - this.mNavigationBarHeight));
            } else {
                this.jLW.setAlpha(1.0f);
            }
        }
        if (this.gbO != null) {
            this.gbO.onChangeSkinType(this.eCn, i);
        }
        if (this.jLX != null) {
            SvgManager.boN().a(this.jLX, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.jEa != null) {
            SvgManager.boN().a(this.jEa, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.jLZ != null) {
            this.jLZ.onChangeSkinType();
        }
        if (this.jMa != null) {
            this.jMa.onChangeSkinType(i);
        }
        if (this.iJN != null) {
            ap.setBackgroundResource(this.iJN, R.drawable.icon_tabbar_chaticon_n);
            ap.setImageResource(this.iJN, R.drawable.icon_tabbar_add_n);
        }
    }

    public void c(com.baidu.tieba.hottopic.data.e eVar) {
        if (eVar != null && eVar.cKw() != null) {
            if (!this.jLZ.cKR()) {
                this.jLZ.setData(eVar.cKw());
            }
            if (eVar.cKw() != null) {
                this.jMi = !StringUtils.isNull(eVar.cKw().jJw);
                this.mNavigationBar.setVisibility(this.jMi ? 0 : 8);
                if (!this.jMi) {
                    this.jLW.setAlpha(1.0f);
                    this.jLW.showBottomLine();
                }
            }
            String str = eVar.cKw().ewR;
            if (StringUtils.isNull(str)) {
                this.iJN.setVisibility(8);
                LF("");
            } else {
                LF(com.baidu.tieba.hottopic.b.a.aT(str, 10));
            }
            this.jLZ.setHeaderBottomLineShow(true);
        }
    }

    private void LF(String str) {
        if (this.jMd != null) {
            this.jMd.setText(str);
        } else if (this.jLW != null) {
            this.jMd = this.jLW.setCenterTextTitle(str);
        }
    }

    public int getCurrentTab() {
        if (this.eFw.getCurrentItem() < 0) {
            return 0;
        }
        return this.eFw.getCurrentItem();
    }

    public void g(NoNetworkView.a aVar) {
        this.iyC = aVar;
        if (this.gbO != null) {
            this.gbO.a(this.iyC);
        }
    }

    public void BW(int i) {
        this.jLZ.setVisibility(i);
        this.eFw.setVisibility(i);
    }

    public void TK() {
        this.jMa.TK();
    }

    public void showLoadingView() {
        this.jMa.showLoadingView();
    }

    public void cKO() {
        this.jMa.rd(false);
    }

    public void dO(List<com.baidu.tieba.hottopic.data.e> list) {
        this.jMa.dK(list);
    }

    public void destroy() {
        if (this.jMa != null) {
            this.jMa.destroy();
        }
        if (this.jLY != null) {
            this.jLY.clearAnimation();
        }
        if (this.gbO != null && this.iyC != null) {
            this.gbO.b(this.iyC);
        }
    }

    public void resume() {
        if (this.jMa != null) {
            this.jMa.resume();
        }
    }

    public void pause() {
        if (this.jMa != null) {
            this.jMa.pause();
        }
    }

    public void rg(boolean z) {
        if (this.gbO != null) {
            if (z) {
                this.gbO.setVisibility(0);
            } else {
                this.gbO.setVisibility(8);
            }
        }
    }

    public HotTopicView cKS() {
        return this.jMa.cJR();
    }

    public int cKT() {
        return (this.djX - this.jMc) - this.mNavigationBarHeight;
    }

    public void BM(int i) {
        if (this.jMa != null) {
            this.jMa.BM(i);
        }
    }

    public void BN(int i) {
        if (this.jMa != null) {
            this.jMa.BN(i);
        }
    }

    public void BO(int i) {
        if (this.jMa != null) {
            this.jMa.BO(i);
        }
    }

    public void a(AbsListView absListView, int i) {
        HotTopicView cJR;
        if (this.jLZ != null && this.jMb != null && (cJR = this.jMa.cJR()) != null && cJR.getListView() != null && absListView == cJR.getListView()) {
            this.jMb.setHeaderViewHeight(this.djX - i);
            this.jLZ.setY(-i);
            if (i == 0) {
                this.jMb.jc(false);
            } else {
                this.jMb.jc(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKU() {
        if (this.jMg) {
            this.jMh = this.jLZ.getY();
            this.jMg = false;
        }
    }

    /* loaded from: classes21.dex */
    public abstract class a implements AbsListView.OnScrollListener {
        public a() {
        }
    }

    public HotTopicHeaderView cKV() {
        return this.jLZ;
    }

    public int cKW() {
        return this.djX;
    }
}
