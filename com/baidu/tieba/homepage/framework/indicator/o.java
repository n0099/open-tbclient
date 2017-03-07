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
    private boolean cwA = true;
    private com.baidu.adp.lib.g.d cwB = new p(this);
    private ImageView cwu;
    private TextView cwv;
    private View cww;
    private SlidingTabLayout cwx;
    private Animation cwy;
    private Animation cwz;
    private Context mContext;
    private View rootView;

    public o(Context context, View view) {
        this.mContext = context;
        this.rootView = view;
        this.cwv = (TextView) view.findViewById(w.h.tab_widget_switch);
        this.cww = view.findViewById(w.h.tab_widget_line);
        this.cwu = (ImageView) view.findViewById(w.h.tab_widget_more);
        this.cwu.setContentDescription("展开");
        this.cwx = (SlidingTabLayout) view.findViewById(w.h.tab_widget_sliding_tab);
    }

    public void o(View.OnClickListener onClickListener) {
        if (this.cwu != null) {
            this.cwu.setOnClickListener(onClickListener);
        }
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.cwx != null) {
            this.cwx.setViewPager(viewPager);
        }
    }

    public void onChangeSkinType(int i) {
        aq.k(this.rootView, w.e.common_color_10274);
        aq.k(this.cwv, w.e.cp_bg_line_e);
        aq.c(this.cwv, w.e.cp_cont_f, 1);
        aq.k(this.cww, w.e.cp_bg_line_b);
        if (this.cwA) {
            aq.c(this.cwu, w.g.icon_triangle_down_normal);
            aq.j(this.cwu, w.g.rec_frs_btn_more_selector);
        } else {
            aq.c(this.cwu, w.g.icon_triangle_up_normal);
            aq.j(this.cwu, w.g.rec_frs_btn_more_up_selector);
        }
        if (this.cwx != null) {
            this.cwx.onChangeSkinType(i);
        }
    }

    public void aiX() {
        this.cwA = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_LAYER_VISIBLE, true));
        if (this.cwv != null) {
            this.cwv.clearAnimation();
            this.cwv.setVisibility(0);
            this.cwv.startAnimation(getInAnimation());
        }
        aq.c(this.cwu, w.g.icon_triangle_up_normal);
        aq.j(this.cwu, w.g.rec_frs_btn_more_up_selector);
        this.cwx.setDrawBottomLine(false);
        this.cww.setVisibility(8);
    }

    public void aiY() {
        this.cwA = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_LAYER_VISIBLE, false));
        if (this.cwv != null) {
            this.cwv.clearAnimation();
            this.cwv.startAnimation(getOutAnimation());
        }
        aq.c(this.cwu, w.g.icon_triangle_down_normal);
        aq.j(this.cwu, w.g.rec_frs_btn_more_selector);
        this.cwx.setDrawBottomLine(true);
        this.cww.setVisibility(0);
    }

    private Animation getInAnimation() {
        if (this.cwy == null) {
            this.cwy = AnimationUtils.loadAnimation(this.mContext, w.a.fade_in);
            this.cwy.setAnimationListener(this.cwB);
        }
        return this.cwy;
    }

    private Animation getOutAnimation() {
        if (this.cwz == null) {
            this.cwz = AnimationUtils.loadAnimation(this.mContext, w.a.fade_out);
            this.cwz.setAnimationListener(this.cwB);
        }
        return this.cwz;
    }

    public void as(int i, int i2) {
        if (this.cwx != null) {
            this.cwx.as(i, i2);
        }
    }
}
