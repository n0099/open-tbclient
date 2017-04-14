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
    private ImageView cuU;
    private TextView cuV;
    private View cuW;
    private SlidingTabLayout cuX;
    private Animation cuY;
    private Animation cuZ;
    private boolean cva = true;
    private com.baidu.adp.lib.g.d cvb = new p(this);
    private Context mContext;
    private View rootView;

    public o(Context context, View view) {
        this.mContext = context;
        this.rootView = view;
        this.cuV = (TextView) view.findViewById(w.h.tab_widget_switch);
        this.cuW = view.findViewById(w.h.tab_widget_line);
        this.cuU = (ImageView) view.findViewById(w.h.tab_widget_more);
        this.cuU.setContentDescription("展开");
        this.cuX = (SlidingTabLayout) view.findViewById(w.h.tab_widget_sliding_tab);
    }

    public void o(View.OnClickListener onClickListener) {
        if (this.cuU != null) {
            this.cuU.setOnClickListener(onClickListener);
        }
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.cuX != null) {
            this.cuX.setViewPager(viewPager);
        }
    }

    public void onChangeSkinType(int i) {
        aq.k(this.rootView, w.e.common_color_10274);
        aq.k(this.cuV, w.e.cp_bg_line_e);
        aq.c(this.cuV, w.e.cp_cont_f, 1);
        aq.k(this.cuW, w.e.cp_bg_line_b);
        if (this.cva) {
            aq.c(this.cuU, w.g.icon_triangle_down_normal);
            aq.j(this.cuU, w.g.rec_frs_btn_more_selector);
        } else {
            aq.c(this.cuU, w.g.icon_triangle_up_normal);
            aq.j(this.cuU, w.g.rec_frs_btn_more_up_selector);
        }
        if (this.cuX != null) {
            this.cuX.onChangeSkinType(i);
        }
    }

    public void aiR() {
        this.cva = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_LAYER_VISIBLE, true));
        if (this.cuV != null) {
            this.cuV.clearAnimation();
            this.cuV.setVisibility(0);
            this.cuV.startAnimation(getInAnimation());
        }
        aq.c(this.cuU, w.g.icon_triangle_up_normal);
        aq.j(this.cuU, w.g.rec_frs_btn_more_up_selector);
        this.cuX.setDrawBottomLine(false);
        this.cuW.setVisibility(8);
    }

    public void aiS() {
        this.cva = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_LAYER_VISIBLE, false));
        if (this.cuV != null) {
            this.cuV.clearAnimation();
            this.cuV.startAnimation(getOutAnimation());
        }
        aq.c(this.cuU, w.g.icon_triangle_down_normal);
        aq.j(this.cuU, w.g.rec_frs_btn_more_selector);
        this.cuX.setDrawBottomLine(true);
        this.cuW.setVisibility(0);
    }

    private Animation getInAnimation() {
        if (this.cuY == null) {
            this.cuY = AnimationUtils.loadAnimation(this.mContext, w.a.fade_in);
            this.cuY.setAnimationListener(this.cvb);
        }
        return this.cuY;
    }

    private Animation getOutAnimation() {
        if (this.cuZ == null) {
            this.cuZ = AnimationUtils.loadAnimation(this.mContext, w.a.fade_out);
            this.cuZ.setAnimationListener(this.cvb);
        }
        return this.cuZ;
    }

    public void aq(int i, int i2) {
        if (this.cuX != null) {
            this.cuX.aq(i, i2);
        }
    }
}
