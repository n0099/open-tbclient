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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class o {
    private View aAK;
    private ImageView cnT;
    private TextView cnU;
    private View cnV;
    private SlidingTabLayout cnW;
    private Animation cnX;
    private Animation cnY;
    private boolean cnZ = true;
    private com.baidu.adp.lib.h.d coa = new p(this);
    private Context mContext;

    public o(Context context, View view) {
        this.mContext = context;
        this.aAK = view;
        this.cnU = (TextView) view.findViewById(r.g.tab_widget_switch);
        this.cnV = view.findViewById(r.g.tab_widget_line);
        this.cnT = (ImageView) view.findViewById(r.g.tab_widget_more);
        this.cnT.setContentDescription("展开");
        this.cnW = (SlidingTabLayout) view.findViewById(r.g.tab_widget_sliding_tab);
    }

    public void n(View.OnClickListener onClickListener) {
        if (this.cnT != null) {
            this.cnT.setOnClickListener(onClickListener);
        }
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.cnW != null) {
            this.cnW.setViewPager(viewPager);
        }
    }

    public void onChangeSkinType(int i) {
        ar.l(this.aAK, r.d.common_color_10274);
        ar.l(this.cnU, r.d.cp_bg_line_e);
        ar.c(this.cnU, r.d.cp_cont_f, 1);
        ar.l(this.cnV, r.d.cp_bg_line_b);
        if (this.cnZ) {
            ar.c(this.cnT, r.f.icon_triangle_down_normal);
            ar.k(this.cnT, r.f.rec_frs_btn_more_selector);
        } else {
            ar.c(this.cnT, r.f.icon_triangle_up_normal);
            ar.k(this.cnT, r.f.rec_frs_btn_more_up_selector);
        }
        if (this.cnW != null) {
            this.cnW.onChangeSkinType(i);
        }
    }

    public void aiD() {
        this.cnZ = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_LAYER_VISIBLE, true));
        if (this.cnU != null) {
            this.cnU.clearAnimation();
            this.cnU.setVisibility(0);
            this.cnU.startAnimation(getInAnimation());
        }
        ar.c(this.cnT, r.f.icon_triangle_up_normal);
        ar.k(this.cnT, r.f.rec_frs_btn_more_up_selector);
        this.cnW.setDrawBottomLine(false);
        this.cnV.setVisibility(8);
    }

    public void aiE() {
        this.cnZ = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_LAYER_VISIBLE, false));
        if (this.cnU != null) {
            this.cnU.clearAnimation();
            this.cnU.startAnimation(getOutAnimation());
        }
        ar.c(this.cnT, r.f.icon_triangle_down_normal);
        ar.k(this.cnT, r.f.rec_frs_btn_more_selector);
        this.cnW.setDrawBottomLine(true);
        this.cnV.setVisibility(0);
    }

    private Animation getInAnimation() {
        if (this.cnX == null) {
            this.cnX = AnimationUtils.loadAnimation(this.mContext, r.a.fade_in);
            this.cnX.setAnimationListener(this.coa);
        }
        return this.cnX;
    }

    private Animation getOutAnimation() {
        if (this.cnY == null) {
            this.cnY = AnimationUtils.loadAnimation(this.mContext, r.a.fade_out);
            this.cnY.setAnimationListener(this.coa);
        }
        return this.cnY;
    }

    public void ap(int i, int i2) {
        if (this.cnW != null) {
            this.cnW.ap(i, i2);
        }
    }
}
