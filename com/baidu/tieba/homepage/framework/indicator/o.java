package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class o {
    private ImageView cxl;
    private TextView cxm;
    private View cxn;
    private SlidingTabLayout cxo;
    private Animation cxp;
    private Animation cxq;
    private boolean cxr = true;
    private com.baidu.adp.lib.g.d cxs = new p(this);
    private Context mContext;
    private View rootView;

    public o(Context context, View view) {
        this.mContext = context;
        this.rootView = view;
        this.cxm = (TextView) view.findViewById(w.h.tab_widget_switch);
        this.cxn = view.findViewById(w.h.tab_widget_line);
        this.cxl = (ImageView) view.findViewById(w.h.tab_widget_more);
        this.cxl.setContentDescription("展开");
        this.cxo = (SlidingTabLayout) view.findViewById(w.h.tab_widget_sliding_tab);
    }

    public void o(View.OnClickListener onClickListener) {
        if (this.cxl != null) {
            this.cxl.setOnClickListener(onClickListener);
        }
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.cxo != null) {
            this.cxo.setViewPager(viewPager);
        }
    }

    public void onChangeSkinType(int i) {
        aq.k(this.rootView, w.e.common_color_10274);
        aq.k(this.cxm, w.e.cp_bg_line_e);
        aq.c(this.cxm, w.e.cp_cont_f, 1);
        aq.k(this.cxn, w.e.cp_bg_line_b);
        if (this.cxr) {
            aq.c(this.cxl, w.g.icon_triangle_down_normal);
            aq.j(this.cxl, w.g.rec_frs_btn_more_selector);
        } else {
            aq.c(this.cxl, w.g.icon_triangle_up_normal);
            aq.j(this.cxl, w.g.rec_frs_btn_more_up_selector);
        }
        if (this.cxo != null) {
            this.cxo.onChangeSkinType(i);
        }
    }

    public void ajS() {
        this.cxr = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_LAYER_VISIBLE, true));
        if (this.cxm != null) {
            this.cxm.clearAnimation();
            this.cxm.setVisibility(0);
            this.cxm.startAnimation(getInAnimation());
        }
        aq.c(this.cxl, w.g.icon_triangle_up_normal);
        aq.j(this.cxl, w.g.rec_frs_btn_more_up_selector);
        this.cxo.setDrawBottomLine(false);
        this.cxn.setVisibility(8);
    }

    public void ajT() {
        this.cxr = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_LAYER_VISIBLE, false));
        if (this.cxm != null) {
            this.cxm.clearAnimation();
            this.cxm.startAnimation(getOutAnimation());
        }
        aq.c(this.cxl, w.g.icon_triangle_down_normal);
        aq.j(this.cxl, w.g.rec_frs_btn_more_selector);
        this.cxo.setDrawBottomLine(true);
        this.cxn.setVisibility(0);
    }

    private Animation getInAnimation() {
        if (this.cxp == null) {
            this.cxp = AnimationUtils.loadAnimation(this.mContext, w.a.fade_in);
            this.cxp.setAnimationListener(this.cxs);
        }
        return this.cxp;
    }

    private Animation getOutAnimation() {
        if (this.cxq == null) {
            this.cxq = AnimationUtils.loadAnimation(this.mContext, w.a.fade_out);
            this.cxq.setAnimationListener(this.cxs);
        }
        return this.cxq;
    }

    public void aq(int i, int i2) {
        if (this.cxo != null) {
            this.cxo.aq(i, i2);
        }
    }
}
