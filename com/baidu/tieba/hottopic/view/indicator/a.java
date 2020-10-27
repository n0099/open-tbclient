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
    private ImageView jNt;
    private TextView jNu;
    private View jNv;
    private SlidingTabLayout jNw;
    private Animation jNx;
    private Animation jNy;
    private Context mContext;
    private View rootView;
    private boolean jNz = true;
    private Animation.AnimationListener jNA = new Animation.AnimationListener() { // from class: com.baidu.tieba.hottopic.view.indicator.a.1
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (a.this.jNu != null) {
                if (animation == a.this.jNx) {
                    a.this.jNu.setVisibility(0);
                    a.this.jNu.setClickable(true);
                } else if (animation == a.this.jNy) {
                    a.this.jNu.setVisibility(8);
                    a.this.jNu.setClickable(false);
                }
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };

    public a(Context context, View view) {
        this.mContext = context;
        this.rootView = view;
        this.jNu = (TextView) view.findViewById(R.id.topic_tab_widget_switch);
        this.jNv = view.findViewById(R.id.topic_tab_widget_line);
        this.jNt = (ImageView) view.findViewById(R.id.topic_tab_widget_more);
        this.jNt.setContentDescription("展开");
        this.jNw = (SlidingTabLayout) view.findViewById(R.id.topic_tab_widget_sliding_tab);
    }

    public void D(View.OnClickListener onClickListener) {
        if (this.jNt != null) {
            this.jNt.setOnClickListener(onClickListener);
        }
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.jNw != null) {
            this.jNw.setViewPager(viewPager);
        }
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.rootView, R.color.common_color_10274);
        ap.setBackgroundColor(this.jNu, R.color.cp_bg_line_e);
        ap.setViewTextColor(this.jNu, R.color.cp_cont_f, 1);
        ap.setBackgroundColor(this.jNv, R.color.cp_bg_line_c);
        if (this.jNz) {
            if (1 == i || 4 == i) {
                this.jNt.setImageResource(R.drawable.icon_topic_triangle_down_normal_1);
                this.jNt.setBackgroundResource(R.drawable.rec_topic_btn_more_selector_1);
            } else {
                this.jNt.setImageResource(R.drawable.icon_topic_triangle_down_normal);
                this.jNt.setBackgroundResource(R.drawable.rec_topic_btn_more_selector);
            }
        } else if (1 == i || 4 == i) {
            this.jNt.setImageResource(R.drawable.icon_topic_triangle_up_normal_1);
            this.jNt.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector_1);
        } else {
            this.jNt.setImageResource(R.drawable.icon_topic_triangle_up_normal);
            this.jNt.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector);
        }
        if (this.jNw != null) {
            this.jNw.onChangeSkinType(i);
        }
    }

    public void bgS() {
        this.jNz = false;
        if (this.jNu != null) {
            this.jNu.clearAnimation();
            this.jNu.setVisibility(0);
            this.jNu.startAnimation(getInAnimation());
        }
        if (1 == TbadkCoreApplication.getInst().getSkinType() || 4 == TbadkCoreApplication.getInst().getSkinType()) {
            this.jNt.setImageResource(R.drawable.icon_topic_triangle_up_normal_1);
            this.jNt.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector_1);
        } else {
            this.jNt.setImageResource(R.drawable.icon_topic_triangle_up_normal);
            this.jNt.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector);
        }
        this.jNw.setDrawBottomLine(false);
        this.jNv.setVisibility(8);
    }

    public void cLh() {
        this.jNz = true;
        if (this.jNu != null) {
            this.jNu.clearAnimation();
            this.jNu.startAnimation(getOutAnimation());
        }
        if (1 == TbadkCoreApplication.getInst().getSkinType() || 4 == TbadkCoreApplication.getInst().getSkinType()) {
            this.jNt.setImageResource(R.drawable.icon_topic_triangle_down_normal_1);
            this.jNt.setBackgroundResource(R.drawable.rec_topic_btn_more_selector_1);
        } else {
            this.jNt.setImageResource(R.drawable.icon_topic_triangle_down_normal);
            this.jNt.setBackgroundResource(R.drawable.rec_topic_btn_more_selector);
        }
        this.jNw.setDrawBottomLine(true);
        this.jNv.setVisibility(0);
    }

    private Animation getInAnimation() {
        if (this.jNx == null) {
            this.jNx = AnimationUtils.loadAnimation(this.mContext, R.anim.fade_in);
            this.jNx.setAnimationListener(this.jNA);
        }
        return this.jNx;
    }

    private Animation getOutAnimation() {
        if (this.jNy == null) {
            this.jNy = AnimationUtils.loadAnimation(this.mContext, R.anim.fade_out);
            this.jNy.setAnimationListener(this.jNA);
        }
        return this.jNy;
    }

    public void setVisibility(int i) {
        if (this.rootView != null) {
            this.rootView.setVisibility(i);
        }
    }
}
