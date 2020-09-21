package com.baidu.tieba.hottopic.view.indicator;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public class a {
    private ImageView jlW;
    private TextView jlX;
    private View jlY;
    private SlidingTabLayout jlZ;
    private Animation jma;
    private Animation jmb;
    private boolean jmc = true;
    private Animation.AnimationListener jmd = new Animation.AnimationListener() { // from class: com.baidu.tieba.hottopic.view.indicator.a.1
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (a.this.jlX != null) {
                if (animation == a.this.jma) {
                    a.this.jlX.setVisibility(0);
                    a.this.jlX.setClickable(true);
                } else if (animation == a.this.jmb) {
                    a.this.jlX.setVisibility(8);
                    a.this.jlX.setClickable(false);
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
        this.jlX = (TextView) view.findViewById(R.id.topic_tab_widget_switch);
        this.jlY = view.findViewById(R.id.topic_tab_widget_line);
        this.jlW = (ImageView) view.findViewById(R.id.topic_tab_widget_more);
        this.jlW.setContentDescription("展开");
        this.jlZ = (SlidingTabLayout) view.findViewById(R.id.topic_tab_widget_sliding_tab);
    }

    public void D(View.OnClickListener onClickListener) {
        if (this.jlW != null) {
            this.jlW.setOnClickListener(onClickListener);
        }
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.jlZ != null) {
            this.jlZ.setViewPager(viewPager);
        }
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.rootView, R.color.common_color_10274);
        ap.setBackgroundColor(this.jlX, R.color.cp_bg_line_e);
        ap.setViewTextColor(this.jlX, R.color.cp_cont_f, 1);
        ap.setBackgroundColor(this.jlY, R.color.cp_bg_line_c);
        if (this.jmc) {
            if (1 == i || 4 == i) {
                this.jlW.setImageResource(R.drawable.icon_topic_triangle_down_normal_1);
                this.jlW.setBackgroundResource(R.drawable.rec_topic_btn_more_selector_1);
            } else {
                this.jlW.setImageResource(R.drawable.icon_topic_triangle_down_normal);
                this.jlW.setBackgroundResource(R.drawable.rec_topic_btn_more_selector);
            }
        } else if (1 == i || 4 == i) {
            this.jlW.setImageResource(R.drawable.icon_topic_triangle_up_normal_1);
            this.jlW.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector_1);
        } else {
            this.jlW.setImageResource(R.drawable.icon_topic_triangle_up_normal);
            this.jlW.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector);
        }
        if (this.jlZ != null) {
            this.jlZ.onChangeSkinType(i);
        }
    }

    public void bcr() {
        this.jmc = false;
        if (this.jlX != null) {
            this.jlX.clearAnimation();
            this.jlX.setVisibility(0);
            this.jlX.startAnimation(getInAnimation());
        }
        if (1 == TbadkCoreApplication.getInst().getSkinType() || 4 == TbadkCoreApplication.getInst().getSkinType()) {
            this.jlW.setImageResource(R.drawable.icon_topic_triangle_up_normal_1);
            this.jlW.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector_1);
        } else {
            this.jlW.setImageResource(R.drawable.icon_topic_triangle_up_normal);
            this.jlW.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector);
        }
        this.jlZ.setDrawBottomLine(false);
        this.jlY.setVisibility(8);
    }

    public void cEr() {
        this.jmc = true;
        if (this.jlX != null) {
            this.jlX.clearAnimation();
            this.jlX.startAnimation(getOutAnimation());
        }
        if (1 == TbadkCoreApplication.getInst().getSkinType() || 4 == TbadkCoreApplication.getInst().getSkinType()) {
            this.jlW.setImageResource(R.drawable.icon_topic_triangle_down_normal_1);
            this.jlW.setBackgroundResource(R.drawable.rec_topic_btn_more_selector_1);
        } else {
            this.jlW.setImageResource(R.drawable.icon_topic_triangle_down_normal);
            this.jlW.setBackgroundResource(R.drawable.rec_topic_btn_more_selector);
        }
        this.jlZ.setDrawBottomLine(true);
        this.jlY.setVisibility(0);
    }

    private Animation getInAnimation() {
        if (this.jma == null) {
            this.jma = AnimationUtils.loadAnimation(this.mContext, R.anim.fade_in);
            this.jma.setAnimationListener(this.jmd);
        }
        return this.jma;
    }

    private Animation getOutAnimation() {
        if (this.jmb == null) {
            this.jmb = AnimationUtils.loadAnimation(this.mContext, R.anim.fade_out);
            this.jmb.setAnimationListener(this.jmd);
        }
        return this.jmb;
    }

    public void setVisibility(int i) {
        if (this.rootView != null) {
            this.rootView.setVisibility(i);
        }
    }
}
