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
public class j {
    private View axa;
    private ImageView cpd;
    private TextView cpe;
    private View cpf;
    private SlidingTabLayout cpg;
    private Animation cph;
    private Animation cpi;
    private boolean cpj = true;
    private com.baidu.adp.lib.h.d cpk = new k(this);
    private Context mContext;

    public j(Context context, View view) {
        this.mContext = context;
        this.axa = view;
        this.cpe = (TextView) view.findViewById(u.g.tab_widget_switch);
        this.cpf = view.findViewById(u.g.tab_widget_line);
        this.cpd = (ImageView) view.findViewById(u.g.tab_widget_more);
        this.cpd.setContentDescription("展开");
        this.cpg = (SlidingTabLayout) view.findViewById(u.g.tab_widget_sliding_tab);
    }

    public void q(View.OnClickListener onClickListener) {
        if (this.cpd != null) {
            this.cpd.setOnClickListener(onClickListener);
        }
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.cpg != null) {
            this.cpg.setViewPager(viewPager);
        }
    }

    public void onChangeSkinType(int i) {
        av.l(this.axa, u.d.common_color_10274);
        av.l(this.cpe, u.d.cp_bg_line_e);
        av.c(this.cpe, u.d.cp_cont_f, 1);
        av.l(this.cpf, u.d.cp_bg_line_b);
        if (this.cpj) {
            av.c(this.cpd, u.f.icon_triangle_down_normal);
            av.k(this.cpd, u.f.rec_frs_btn_more_selector);
        } else {
            av.c(this.cpd, u.f.icon_triangle_up_normal);
            av.k(this.cpd, u.f.rec_frs_btn_more_up_selector);
        }
        if (this.cpg != null) {
            this.cpg.onChangeSkinType(i);
        }
    }

    public void agD() {
        this.cpj = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_LAYER_VISIBLE, true));
        if (this.cpe != null) {
            this.cpe.clearAnimation();
            this.cpe.setVisibility(0);
            this.cpe.startAnimation(getInAnimation());
        }
        av.c(this.cpd, u.f.icon_triangle_up_normal);
        av.k(this.cpd, u.f.rec_frs_btn_more_up_selector);
        this.cpg.setDrawBottomLine(false);
        this.cpf.setVisibility(8);
    }

    public void agE() {
        this.cpj = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_LAYER_VISIBLE, false));
        if (this.cpe != null) {
            this.cpe.clearAnimation();
            this.cpe.startAnimation(getOutAnimation());
        }
        av.c(this.cpd, u.f.icon_triangle_down_normal);
        av.k(this.cpd, u.f.rec_frs_btn_more_selector);
        this.cpg.setDrawBottomLine(true);
        this.cpf.setVisibility(0);
    }

    private Animation getInAnimation() {
        if (this.cph == null) {
            this.cph = AnimationUtils.loadAnimation(this.mContext, u.a.fade_in);
            this.cph.setAnimationListener(this.cpk);
        }
        return this.cph;
    }

    private Animation getOutAnimation() {
        if (this.cpi == null) {
            this.cpi = AnimationUtils.loadAnimation(this.mContext, u.a.fade_out);
            this.cpi.setAnimationListener(this.cpk);
        }
        return this.cpi;
    }

    public void al(int i, int i2) {
        if (this.cpg != null) {
            this.cpg.al(i, i2);
        }
    }
}
