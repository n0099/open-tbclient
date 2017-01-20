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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class o {
    private ImageView cuV;
    private TextView cuW;
    private View cuX;
    private SlidingTabLayout cuY;
    private Animation cuZ;
    private Animation cva;
    private boolean cvb = true;
    private com.baidu.adp.lib.g.d cvc = new p(this);
    private Context mContext;
    private View rootView;

    public o(Context context, View view) {
        this.mContext = context;
        this.rootView = view;
        this.cuW = (TextView) view.findViewById(r.h.tab_widget_switch);
        this.cuX = view.findViewById(r.h.tab_widget_line);
        this.cuV = (ImageView) view.findViewById(r.h.tab_widget_more);
        this.cuV.setContentDescription("展开");
        this.cuY = (SlidingTabLayout) view.findViewById(r.h.tab_widget_sliding_tab);
    }

    public void q(View.OnClickListener onClickListener) {
        if (this.cuV != null) {
            this.cuV.setOnClickListener(onClickListener);
        }
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.cuY != null) {
            this.cuY.setViewPager(viewPager);
        }
    }

    public void onChangeSkinType(int i) {
        ap.k(this.rootView, r.e.common_color_10274);
        ap.k(this.cuW, r.e.cp_bg_line_e);
        ap.c(this.cuW, r.e.cp_cont_f, 1);
        ap.k(this.cuX, r.e.cp_bg_line_b);
        if (this.cvb) {
            ap.c(this.cuV, r.g.icon_triangle_down_normal);
            ap.j(this.cuV, r.g.rec_frs_btn_more_selector);
        } else {
            ap.c(this.cuV, r.g.icon_triangle_up_normal);
            ap.j(this.cuV, r.g.rec_frs_btn_more_up_selector);
        }
        if (this.cuY != null) {
            this.cuY.onChangeSkinType(i);
        }
    }

    public void ajL() {
        this.cvb = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_LAYER_VISIBLE, true));
        if (this.cuW != null) {
            this.cuW.clearAnimation();
            this.cuW.setVisibility(0);
            this.cuW.startAnimation(getInAnimation());
        }
        ap.c(this.cuV, r.g.icon_triangle_up_normal);
        ap.j(this.cuV, r.g.rec_frs_btn_more_up_selector);
        this.cuY.setDrawBottomLine(false);
        this.cuX.setVisibility(8);
    }

    public void ajM() {
        this.cvb = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_LAYER_VISIBLE, false));
        if (this.cuW != null) {
            this.cuW.clearAnimation();
            this.cuW.startAnimation(getOutAnimation());
        }
        ap.c(this.cuV, r.g.icon_triangle_down_normal);
        ap.j(this.cuV, r.g.rec_frs_btn_more_selector);
        this.cuY.setDrawBottomLine(true);
        this.cuX.setVisibility(0);
    }

    private Animation getInAnimation() {
        if (this.cuZ == null) {
            this.cuZ = AnimationUtils.loadAnimation(this.mContext, r.a.fade_in);
            this.cuZ.setAnimationListener(this.cvc);
        }
        return this.cuZ;
    }

    private Animation getOutAnimation() {
        if (this.cva == null) {
            this.cva = AnimationUtils.loadAnimation(this.mContext, r.a.fade_out);
            this.cva.setAnimationListener(this.cvc);
        }
        return this.cva;
    }

    public void ap(int i, int i2) {
        if (this.cuY != null) {
            this.cuY.ap(i, i2);
        }
    }
}
