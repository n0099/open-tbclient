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
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class o {
    private View aBq;
    private View cIA;
    private SlidingTabLayout cIB;
    private Animation cIC;
    private Animation cID;
    private boolean cIE = true;
    private com.baidu.adp.lib.h.d cIF = new p(this);
    private ImageView cIy;
    private TextView cIz;
    private Context mContext;

    public o(Context context, View view) {
        this.mContext = context;
        this.aBq = view;
        this.cIz = (TextView) view.findViewById(r.g.tab_widget_switch);
        this.cIA = view.findViewById(r.g.tab_widget_line);
        this.cIy = (ImageView) view.findViewById(r.g.tab_widget_more);
        this.cIy.setContentDescription("展开");
        this.cIB = (SlidingTabLayout) view.findViewById(r.g.tab_widget_sliding_tab);
    }

    public void p(View.OnClickListener onClickListener) {
        if (this.cIy != null) {
            this.cIy.setOnClickListener(onClickListener);
        }
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.cIB != null) {
            this.cIB.setViewPager(viewPager);
        }
    }

    public void onChangeSkinType(int i) {
        at.l(this.aBq, r.d.common_color_10274);
        at.l(this.cIz, r.d.cp_bg_line_e);
        at.c(this.cIz, r.d.cp_cont_f, 1);
        at.l(this.cIA, r.d.cp_bg_line_b);
        if (this.cIE) {
            at.c(this.cIy, r.f.icon_triangle_down_normal);
            at.k(this.cIy, r.f.rec_frs_btn_more_selector);
        } else {
            at.c(this.cIy, r.f.icon_triangle_up_normal);
            at.k(this.cIy, r.f.rec_frs_btn_more_up_selector);
        }
        if (this.cIB != null) {
            this.cIB.onChangeSkinType(i);
        }
    }

    public void aod() {
        this.cIE = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_LAYER_VISIBLE, true));
        if (this.cIz != null) {
            this.cIz.clearAnimation();
            this.cIz.setVisibility(0);
            this.cIz.startAnimation(getInAnimation());
        }
        at.c(this.cIy, r.f.icon_triangle_up_normal);
        at.k(this.cIy, r.f.rec_frs_btn_more_up_selector);
        this.cIB.setDrawBottomLine(false);
        this.cIA.setVisibility(8);
    }

    public void aoe() {
        this.cIE = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_LAYER_VISIBLE, false));
        if (this.cIz != null) {
            this.cIz.clearAnimation();
            this.cIz.startAnimation(getOutAnimation());
        }
        at.c(this.cIy, r.f.icon_triangle_down_normal);
        at.k(this.cIy, r.f.rec_frs_btn_more_selector);
        this.cIB.setDrawBottomLine(true);
        this.cIA.setVisibility(0);
    }

    private Animation getInAnimation() {
        if (this.cIC == null) {
            this.cIC = AnimationUtils.loadAnimation(this.mContext, r.a.fade_in);
            this.cIC.setAnimationListener(this.cIF);
        }
        return this.cIC;
    }

    private Animation getOutAnimation() {
        if (this.cID == null) {
            this.cID = AnimationUtils.loadAnimation(this.mContext, r.a.fade_out);
            this.cID.setAnimationListener(this.cIF);
        }
        return this.cID;
    }

    public void au(int i, int i2) {
        if (this.cIB != null) {
            this.cIB.au(i, i2);
        }
    }
}
