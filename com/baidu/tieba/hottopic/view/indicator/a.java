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
    private ImageView iOl;
    private TextView iOm;
    private View iOn;
    private SlidingTabLayout iOo;
    private Animation iOp;
    private Animation iOq;
    private boolean iOr = true;
    private Animation.AnimationListener iOs = new Animation.AnimationListener() { // from class: com.baidu.tieba.hottopic.view.indicator.a.1
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (a.this.iOm != null) {
                if (animation == a.this.iOp) {
                    a.this.iOm.setVisibility(0);
                    a.this.iOm.setClickable(true);
                } else if (animation == a.this.iOq) {
                    a.this.iOm.setVisibility(8);
                    a.this.iOm.setClickable(false);
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
        this.iOm = (TextView) view.findViewById(R.id.topic_tab_widget_switch);
        this.iOn = view.findViewById(R.id.topic_tab_widget_line);
        this.iOl = (ImageView) view.findViewById(R.id.topic_tab_widget_more);
        this.iOl.setContentDescription("展开");
        this.iOo = (SlidingTabLayout) view.findViewById(R.id.topic_tab_widget_sliding_tab);
    }

    public void C(View.OnClickListener onClickListener) {
        if (this.iOl != null) {
            this.iOl.setOnClickListener(onClickListener);
        }
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.iOo != null) {
            this.iOo.setViewPager(viewPager);
        }
    }

    public void onChangeSkinType(int i) {
        ao.setBackgroundColor(this.rootView, R.color.common_color_10274);
        ao.setBackgroundColor(this.iOm, R.color.cp_bg_line_e);
        ao.setViewTextColor(this.iOm, R.color.cp_cont_f, 1);
        ao.setBackgroundColor(this.iOn, R.color.cp_bg_line_c);
        if (this.iOr) {
            if (1 == i || 4 == i) {
                this.iOl.setImageResource(R.drawable.icon_topic_triangle_down_normal_1);
                this.iOl.setBackgroundResource(R.drawable.rec_topic_btn_more_selector_1);
            } else {
                this.iOl.setImageResource(R.drawable.icon_topic_triangle_down_normal);
                this.iOl.setBackgroundResource(R.drawable.rec_topic_btn_more_selector);
            }
        } else if (1 == i || 4 == i) {
            this.iOl.setImageResource(R.drawable.icon_topic_triangle_up_normal_1);
            this.iOl.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector_1);
        } else {
            this.iOl.setImageResource(R.drawable.icon_topic_triangle_up_normal);
            this.iOl.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector);
        }
        if (this.iOo != null) {
            this.iOo.onChangeSkinType(i);
        }
    }

    public void aTg() {
        this.iOr = false;
        if (this.iOm != null) {
            this.iOm.clearAnimation();
            this.iOm.setVisibility(0);
            this.iOm.startAnimation(getInAnimation());
        }
        if (1 == TbadkCoreApplication.getInst().getSkinType() || 4 == TbadkCoreApplication.getInst().getSkinType()) {
            this.iOl.setImageResource(R.drawable.icon_topic_triangle_up_normal_1);
            this.iOl.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector_1);
        } else {
            this.iOl.setImageResource(R.drawable.icon_topic_triangle_up_normal);
            this.iOl.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector);
        }
        this.iOo.setDrawBottomLine(false);
        this.iOn.setVisibility(8);
    }

    public void cpR() {
        this.iOr = true;
        if (this.iOm != null) {
            this.iOm.clearAnimation();
            this.iOm.startAnimation(getOutAnimation());
        }
        if (1 == TbadkCoreApplication.getInst().getSkinType() || 4 == TbadkCoreApplication.getInst().getSkinType()) {
            this.iOl.setImageResource(R.drawable.icon_topic_triangle_down_normal_1);
            this.iOl.setBackgroundResource(R.drawable.rec_topic_btn_more_selector_1);
        } else {
            this.iOl.setImageResource(R.drawable.icon_topic_triangle_down_normal);
            this.iOl.setBackgroundResource(R.drawable.rec_topic_btn_more_selector);
        }
        this.iOo.setDrawBottomLine(true);
        this.iOn.setVisibility(0);
    }

    private Animation getInAnimation() {
        if (this.iOp == null) {
            this.iOp = AnimationUtils.loadAnimation(this.mContext, R.anim.fade_in);
            this.iOp.setAnimationListener(this.iOs);
        }
        return this.iOp;
    }

    private Animation getOutAnimation() {
        if (this.iOq == null) {
            this.iOq = AnimationUtils.loadAnimation(this.mContext, R.anim.fade_out);
            this.iOq.setAnimationListener(this.iOs);
        }
        return this.iOq;
    }

    public void setVisibility(int i) {
        if (this.rootView != null) {
            this.rootView.setVisibility(i);
        }
    }
}
