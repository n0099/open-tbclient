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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class o {
    private View aAy;
    private ImageView cDl;
    private TextView cDm;
    private View cDn;
    private SlidingTabLayout cDo;
    private Animation cDp;
    private Animation cDq;
    private boolean cDr = true;
    private com.baidu.adp.lib.h.d cDs = new p(this);
    private Context mContext;

    public o(Context context, View view) {
        this.mContext = context;
        this.aAy = view;
        this.cDm = (TextView) view.findViewById(r.g.tab_widget_switch);
        this.cDn = view.findViewById(r.g.tab_widget_line);
        this.cDl = (ImageView) view.findViewById(r.g.tab_widget_more);
        this.cDl.setContentDescription("展开");
        this.cDo = (SlidingTabLayout) view.findViewById(r.g.tab_widget_sliding_tab);
    }

    public void n(View.OnClickListener onClickListener) {
        if (this.cDl != null) {
            this.cDl.setOnClickListener(onClickListener);
        }
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.cDo != null) {
            this.cDo.setViewPager(viewPager);
        }
    }

    public void onChangeSkinType(int i) {
        av.l(this.aAy, r.d.common_color_10274);
        av.l(this.cDm, r.d.cp_bg_line_e);
        av.c(this.cDm, r.d.cp_cont_f, 1);
        av.l(this.cDn, r.d.cp_bg_line_b);
        if (this.cDr) {
            av.c(this.cDl, r.f.icon_triangle_down_normal);
            av.k(this.cDl, r.f.rec_frs_btn_more_selector);
        } else {
            av.c(this.cDl, r.f.icon_triangle_up_normal);
            av.k(this.cDl, r.f.rec_frs_btn_more_up_selector);
        }
        if (this.cDo != null) {
            this.cDo.onChangeSkinType(i);
        }
    }

    public void ami() {
        this.cDr = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_LAYER_VISIBLE, true));
        if (this.cDm != null) {
            this.cDm.clearAnimation();
            this.cDm.setVisibility(0);
            this.cDm.startAnimation(getInAnimation());
        }
        av.c(this.cDl, r.f.icon_triangle_up_normal);
        av.k(this.cDl, r.f.rec_frs_btn_more_up_selector);
        this.cDo.setDrawBottomLine(false);
        this.cDn.setVisibility(8);
    }

    public void amj() {
        this.cDr = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_LAYER_VISIBLE, false));
        if (this.cDm != null) {
            this.cDm.clearAnimation();
            this.cDm.startAnimation(getOutAnimation());
        }
        av.c(this.cDl, r.f.icon_triangle_down_normal);
        av.k(this.cDl, r.f.rec_frs_btn_more_selector);
        this.cDo.setDrawBottomLine(true);
        this.cDn.setVisibility(0);
    }

    private Animation getInAnimation() {
        if (this.cDp == null) {
            this.cDp = AnimationUtils.loadAnimation(this.mContext, r.a.fade_in);
            this.cDp.setAnimationListener(this.cDs);
        }
        return this.cDp;
    }

    private Animation getOutAnimation() {
        if (this.cDq == null) {
            this.cDq = AnimationUtils.loadAnimation(this.mContext, r.a.fade_out);
            this.cDq.setAnimationListener(this.cDs);
        }
        return this.cDq;
    }

    public void at(int i, int i2) {
        if (this.cDo != null) {
            this.cDo.at(i, i2);
        }
    }
}
