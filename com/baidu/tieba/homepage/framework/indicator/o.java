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
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class o {
    private View aAV;
    private ImageView cCG;
    private TextView cCH;
    private View cCI;
    private SlidingTabLayout cCJ;
    private Animation cCK;
    private Animation cCL;
    private boolean cCM = true;
    private com.baidu.adp.lib.h.d cCN = new p(this);
    private Context mContext;

    public o(Context context, View view) {
        this.mContext = context;
        this.aAV = view;
        this.cCH = (TextView) view.findViewById(t.g.tab_widget_switch);
        this.cCI = view.findViewById(t.g.tab_widget_line);
        this.cCG = (ImageView) view.findViewById(t.g.tab_widget_more);
        this.cCG.setContentDescription("展开");
        this.cCJ = (SlidingTabLayout) view.findViewById(t.g.tab_widget_sliding_tab);
    }

    public void o(View.OnClickListener onClickListener) {
        if (this.cCG != null) {
            this.cCG.setOnClickListener(onClickListener);
        }
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.cCJ != null) {
            this.cCJ.setViewPager(viewPager);
        }
    }

    public void onChangeSkinType(int i) {
        av.l(this.aAV, t.d.common_color_10274);
        av.l(this.cCH, t.d.cp_bg_line_e);
        av.c(this.cCH, t.d.cp_cont_f, 1);
        av.l(this.cCI, t.d.cp_bg_line_b);
        if (this.cCM) {
            av.c(this.cCG, t.f.icon_triangle_down_normal);
            av.k(this.cCG, t.f.rec_frs_btn_more_selector);
        } else {
            av.c(this.cCG, t.f.icon_triangle_up_normal);
            av.k(this.cCG, t.f.rec_frs_btn_more_up_selector);
        }
        if (this.cCJ != null) {
            this.cCJ.onChangeSkinType(i);
        }
    }

    public void alU() {
        this.cCM = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_LAYER_VISIBLE, true));
        if (this.cCH != null) {
            this.cCH.clearAnimation();
            this.cCH.setVisibility(0);
            this.cCH.startAnimation(getInAnimation());
        }
        av.c(this.cCG, t.f.icon_triangle_up_normal);
        av.k(this.cCG, t.f.rec_frs_btn_more_up_selector);
        this.cCJ.setDrawBottomLine(false);
        this.cCI.setVisibility(8);
    }

    public void alV() {
        this.cCM = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_LAYER_VISIBLE, false));
        if (this.cCH != null) {
            this.cCH.clearAnimation();
            this.cCH.startAnimation(getOutAnimation());
        }
        av.c(this.cCG, t.f.icon_triangle_down_normal);
        av.k(this.cCG, t.f.rec_frs_btn_more_selector);
        this.cCJ.setDrawBottomLine(true);
        this.cCI.setVisibility(0);
    }

    private Animation getInAnimation() {
        if (this.cCK == null) {
            this.cCK = AnimationUtils.loadAnimation(this.mContext, t.a.fade_in);
            this.cCK.setAnimationListener(this.cCN);
        }
        return this.cCK;
    }

    private Animation getOutAnimation() {
        if (this.cCL == null) {
            this.cCL = AnimationUtils.loadAnimation(this.mContext, t.a.fade_out);
            this.cCL.setAnimationListener(this.cCN);
        }
        return this.cCL;
    }

    public void as(int i, int i2) {
        if (this.cCJ != null) {
            this.cCJ.as(i, i2);
        }
    }
}
