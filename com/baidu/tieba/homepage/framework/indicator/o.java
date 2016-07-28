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
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class o {
    private View axO;
    private View crA;
    private SlidingTabLayout crB;
    private Animation crC;
    private Animation crD;
    private boolean crE = true;
    private com.baidu.adp.lib.h.d crF = new p(this);
    private ImageView cry;
    private TextView crz;
    private Context mContext;

    public o(Context context, View view) {
        this.mContext = context;
        this.axO = view;
        this.crz = (TextView) view.findViewById(u.g.tab_widget_switch);
        this.crA = view.findViewById(u.g.tab_widget_line);
        this.cry = (ImageView) view.findViewById(u.g.tab_widget_more);
        this.cry.setContentDescription("展开");
        this.crB = (SlidingTabLayout) view.findViewById(u.g.tab_widget_sliding_tab);
    }

    public void q(View.OnClickListener onClickListener) {
        if (this.cry != null) {
            this.cry.setOnClickListener(onClickListener);
        }
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.crB != null) {
            this.crB.setViewPager(viewPager);
        }
    }

    public void onChangeSkinType(int i) {
        av.l(this.axO, u.d.common_color_10274);
        av.l(this.crz, u.d.cp_bg_line_e);
        av.c(this.crz, u.d.cp_cont_f, 1);
        av.l(this.crA, u.d.cp_bg_line_b);
        if (this.crE) {
            av.c(this.cry, u.f.icon_triangle_down_normal);
            av.k(this.cry, u.f.rec_frs_btn_more_selector);
        } else {
            av.c(this.cry, u.f.icon_triangle_up_normal);
            av.k(this.cry, u.f.rec_frs_btn_more_up_selector);
        }
        if (this.crB != null) {
            this.crB.onChangeSkinType(i);
        }
    }

    public void ahj() {
        this.crE = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_LAYER_VISIBLE, true));
        if (this.crz != null) {
            this.crz.clearAnimation();
            this.crz.setVisibility(0);
            this.crz.startAnimation(getInAnimation());
        }
        av.c(this.cry, u.f.icon_triangle_up_normal);
        av.k(this.cry, u.f.rec_frs_btn_more_up_selector);
        this.crB.setDrawBottomLine(false);
        this.crA.setVisibility(8);
    }

    public void ahk() {
        this.crE = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_LAYER_VISIBLE, false));
        if (this.crz != null) {
            this.crz.clearAnimation();
            this.crz.startAnimation(getOutAnimation());
        }
        av.c(this.cry, u.f.icon_triangle_down_normal);
        av.k(this.cry, u.f.rec_frs_btn_more_selector);
        this.crB.setDrawBottomLine(true);
        this.crA.setVisibility(0);
    }

    private Animation getInAnimation() {
        if (this.crC == null) {
            this.crC = AnimationUtils.loadAnimation(this.mContext, u.a.fade_in);
            this.crC.setAnimationListener(this.crF);
        }
        return this.crC;
    }

    private Animation getOutAnimation() {
        if (this.crD == null) {
            this.crD = AnimationUtils.loadAnimation(this.mContext, u.a.fade_out);
            this.crD.setAnimationListener(this.crF);
        }
        return this.crD;
    }

    public void an(int i, int i2) {
        if (this.crB != null) {
            this.crB.an(i, i2);
        }
    }
}
