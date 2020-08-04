package com.baidu.tieba.hottopic.view.indicator;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class a {
    private ImageView iOn;
    private TextView iOo;
    private View iOp;
    private SlidingTabLayout iOq;
    private Animation iOr;
    private Animation iOs;
    private boolean iOt = true;
    private Animation.AnimationListener iOu = new Animation.AnimationListener() { // from class: com.baidu.tieba.hottopic.view.indicator.a.1
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (a.this.iOo != null) {
                if (animation == a.this.iOr) {
                    a.this.iOo.setVisibility(0);
                    a.this.iOo.setClickable(true);
                } else if (animation == a.this.iOs) {
                    a.this.iOo.setVisibility(8);
                    a.this.iOo.setClickable(false);
                }
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private Context mContext;
    private View rootView;

    public a(Context context, View view) {
        this.mContext = context;
        this.rootView = view;
        this.iOo = (TextView) view.findViewById(R.id.topic_tab_widget_switch);
        this.iOp = view.findViewById(R.id.topic_tab_widget_line);
        this.iOn = (ImageView) view.findViewById(R.id.topic_tab_widget_more);
        this.iOn.setContentDescription("展开");
        this.iOq = (SlidingTabLayout) view.findViewById(R.id.topic_tab_widget_sliding_tab);
    }

    public void C(View.OnClickListener onClickListener) {
        if (this.iOn != null) {
            this.iOn.setOnClickListener(onClickListener);
        }
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.iOq != null) {
            this.iOq.setViewPager(viewPager);
        }
    }

    public void onChangeSkinType(int i) {
        ao.setBackgroundColor(this.rootView, R.color.common_color_10274);
        ao.setBackgroundColor(this.iOo, R.color.cp_bg_line_e);
        ao.setViewTextColor(this.iOo, R.color.cp_cont_f, 1);
        ao.setBackgroundColor(this.iOp, R.color.cp_bg_line_c);
        if (this.iOt) {
            if (1 == i || 4 == i) {
                this.iOn.setImageResource(R.drawable.icon_topic_triangle_down_normal_1);
                this.iOn.setBackgroundResource(R.drawable.rec_topic_btn_more_selector_1);
            } else {
                this.iOn.setImageResource(R.drawable.icon_topic_triangle_down_normal);
                this.iOn.setBackgroundResource(R.drawable.rec_topic_btn_more_selector);
            }
        } else if (1 == i || 4 == i) {
            this.iOn.setImageResource(R.drawable.icon_topic_triangle_up_normal_1);
            this.iOn.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector_1);
        } else {
            this.iOn.setImageResource(R.drawable.icon_topic_triangle_up_normal);
            this.iOn.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector);
        }
        if (this.iOq != null) {
            this.iOq.onChangeSkinType(i);
        }
    }

    public void aTg() {
        this.iOt = false;
        if (this.iOo != null) {
            this.iOo.clearAnimation();
            this.iOo.setVisibility(0);
            this.iOo.startAnimation(getInAnimation());
        }
        if (1 == TbadkCoreApplication.getInst().getSkinType() || 4 == TbadkCoreApplication.getInst().getSkinType()) {
            this.iOn.setImageResource(R.drawable.icon_topic_triangle_up_normal_1);
            this.iOn.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector_1);
        } else {
            this.iOn.setImageResource(R.drawable.icon_topic_triangle_up_normal);
            this.iOn.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector);
        }
        this.iOq.setDrawBottomLine(false);
        this.iOp.setVisibility(8);
    }

    public void cpR() {
        this.iOt = true;
        if (this.iOo != null) {
            this.iOo.clearAnimation();
            this.iOo.startAnimation(getOutAnimation());
        }
        if (1 == TbadkCoreApplication.getInst().getSkinType() || 4 == TbadkCoreApplication.getInst().getSkinType()) {
            this.iOn.setImageResource(R.drawable.icon_topic_triangle_down_normal_1);
            this.iOn.setBackgroundResource(R.drawable.rec_topic_btn_more_selector_1);
        } else {
            this.iOn.setImageResource(R.drawable.icon_topic_triangle_down_normal);
            this.iOn.setBackgroundResource(R.drawable.rec_topic_btn_more_selector);
        }
        this.iOq.setDrawBottomLine(true);
        this.iOp.setVisibility(0);
    }

    private Animation getInAnimation() {
        if (this.iOr == null) {
            this.iOr = AnimationUtils.loadAnimation(this.mContext, R.anim.fade_in);
            this.iOr.setAnimationListener(this.iOu);
        }
        return this.iOr;
    }

    private Animation getOutAnimation() {
        if (this.iOs == null) {
            this.iOs = AnimationUtils.loadAnimation(this.mContext, R.anim.fade_out);
            this.iOs.setAnimationListener(this.iOu);
        }
        return this.iOs;
    }

    public void setVisibility(int i) {
        if (this.rootView != null) {
            this.rootView.setVisibility(i);
        }
    }
}
