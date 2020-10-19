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
/* loaded from: classes21.dex */
public class a {
    private ImageView jAU;
    private TextView jAV;
    private View jAW;
    private SlidingTabLayout jAX;
    private Animation jAY;
    private Animation jAZ;
    private boolean jBa = true;
    private Animation.AnimationListener jBb = new Animation.AnimationListener() { // from class: com.baidu.tieba.hottopic.view.indicator.a.1
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (a.this.jAV != null) {
                if (animation == a.this.jAY) {
                    a.this.jAV.setVisibility(0);
                    a.this.jAV.setClickable(true);
                } else if (animation == a.this.jAZ) {
                    a.this.jAV.setVisibility(8);
                    a.this.jAV.setClickable(false);
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
        this.jAV = (TextView) view.findViewById(R.id.topic_tab_widget_switch);
        this.jAW = view.findViewById(R.id.topic_tab_widget_line);
        this.jAU = (ImageView) view.findViewById(R.id.topic_tab_widget_more);
        this.jAU.setContentDescription("展开");
        this.jAX = (SlidingTabLayout) view.findViewById(R.id.topic_tab_widget_sliding_tab);
    }

    public void D(View.OnClickListener onClickListener) {
        if (this.jAU != null) {
            this.jAU.setOnClickListener(onClickListener);
        }
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.jAX != null) {
            this.jAX.setViewPager(viewPager);
        }
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.rootView, R.color.common_color_10274);
        ap.setBackgroundColor(this.jAV, R.color.cp_bg_line_e);
        ap.setViewTextColor(this.jAV, R.color.cp_cont_f, 1);
        ap.setBackgroundColor(this.jAW, R.color.cp_bg_line_c);
        if (this.jBa) {
            if (1 == i || 4 == i) {
                this.jAU.setImageResource(R.drawable.icon_topic_triangle_down_normal_1);
                this.jAU.setBackgroundResource(R.drawable.rec_topic_btn_more_selector_1);
            } else {
                this.jAU.setImageResource(R.drawable.icon_topic_triangle_down_normal);
                this.jAU.setBackgroundResource(R.drawable.rec_topic_btn_more_selector);
            }
        } else if (1 == i || 4 == i) {
            this.jAU.setImageResource(R.drawable.icon_topic_triangle_up_normal_1);
            this.jAU.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector_1);
        } else {
            this.jAU.setImageResource(R.drawable.icon_topic_triangle_up_normal);
            this.jAU.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector);
        }
        if (this.jAX != null) {
            this.jAX.onChangeSkinType(i);
        }
    }

    public void beZ() {
        this.jBa = false;
        if (this.jAV != null) {
            this.jAV.clearAnimation();
            this.jAV.setVisibility(0);
            this.jAV.startAnimation(getInAnimation());
        }
        if (1 == TbadkCoreApplication.getInst().getSkinType() || 4 == TbadkCoreApplication.getInst().getSkinType()) {
            this.jAU.setImageResource(R.drawable.icon_topic_triangle_up_normal_1);
            this.jAU.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector_1);
        } else {
            this.jAU.setImageResource(R.drawable.icon_topic_triangle_up_normal);
            this.jAU.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector);
        }
        this.jAX.setDrawBottomLine(false);
        this.jAW.setVisibility(8);
    }

    public void cIa() {
        this.jBa = true;
        if (this.jAV != null) {
            this.jAV.clearAnimation();
            this.jAV.startAnimation(getOutAnimation());
        }
        if (1 == TbadkCoreApplication.getInst().getSkinType() || 4 == TbadkCoreApplication.getInst().getSkinType()) {
            this.jAU.setImageResource(R.drawable.icon_topic_triangle_down_normal_1);
            this.jAU.setBackgroundResource(R.drawable.rec_topic_btn_more_selector_1);
        } else {
            this.jAU.setImageResource(R.drawable.icon_topic_triangle_down_normal);
            this.jAU.setBackgroundResource(R.drawable.rec_topic_btn_more_selector);
        }
        this.jAX.setDrawBottomLine(true);
        this.jAW.setVisibility(0);
    }

    private Animation getInAnimation() {
        if (this.jAY == null) {
            this.jAY = AnimationUtils.loadAnimation(this.mContext, R.anim.fade_in);
            this.jAY.setAnimationListener(this.jBb);
        }
        return this.jAY;
    }

    private Animation getOutAnimation() {
        if (this.jAZ == null) {
            this.jAZ = AnimationUtils.loadAnimation(this.mContext, R.anim.fade_out);
            this.jAZ.setAnimationListener(this.jBb);
        }
        return this.jAZ;
    }

    public void setVisibility(int i) {
        if (this.rootView != null) {
            this.rootView.setVisibility(i);
        }
    }
}
