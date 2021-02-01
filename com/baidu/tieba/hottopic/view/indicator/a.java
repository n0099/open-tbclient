package com.baidu.tieba.hottopic.view.indicator;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class a {
    private boolean kyA = true;
    private Animation.AnimationListener kyB = new Animation.AnimationListener() { // from class: com.baidu.tieba.hottopic.view.indicator.a.1
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (a.this.kyv != null) {
                if (animation == a.this.kyy) {
                    a.this.kyv.setVisibility(0);
                    a.this.kyv.setClickable(true);
                } else if (animation == a.this.kyz) {
                    a.this.kyv.setVisibility(8);
                    a.this.kyv.setClickable(false);
                }
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private ImageView kyu;
    private TextView kyv;
    private View kyw;
    private SlidingTabLayout kyx;
    private Animation kyy;
    private Animation kyz;
    private Context mContext;
    private View rootView;

    public a(Context context, View view) {
        this.mContext = context;
        this.rootView = view;
        this.kyv = (TextView) view.findViewById(R.id.topic_tab_widget_switch);
        this.kyw = view.findViewById(R.id.topic_tab_widget_line);
        this.kyu = (ImageView) view.findViewById(R.id.topic_tab_widget_more);
        this.kyu.setContentDescription("展开");
        this.kyx = (SlidingTabLayout) view.findViewById(R.id.topic_tab_widget_sliding_tab);
    }

    public void G(View.OnClickListener onClickListener) {
        if (this.kyu != null) {
            this.kyu.setOnClickListener(onClickListener);
        }
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.kyx != null) {
            this.kyx.setViewPager(viewPager);
        }
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.rootView, R.color.common_color_10274);
        ap.setBackgroundColor(this.kyv, R.color.CAM_X0205);
        ap.setViewTextColor(this.kyv, R.color.CAM_X0106, 1);
        ap.setBackgroundColor(this.kyw, R.color.CAM_X0204);
        if (this.kyA) {
            if (1 == i || 4 == i) {
                this.kyu.setImageResource(R.drawable.icon_topic_triangle_down_normal_1);
                this.kyu.setBackgroundResource(R.drawable.rec_topic_btn_more_selector_1);
            } else {
                this.kyu.setImageResource(R.drawable.icon_topic_triangle_down_normal);
                this.kyu.setBackgroundResource(R.drawable.rec_topic_btn_more_selector);
            }
        } else if (1 == i || 4 == i) {
            this.kyu.setImageResource(R.drawable.icon_topic_triangle_up_normal_1);
            this.kyu.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector_1);
        } else {
            this.kyu.setImageResource(R.drawable.icon_topic_triangle_up_normal);
            this.kyu.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector);
        }
        if (this.kyx != null) {
            this.kyx.onChangeSkinType(i);
        }
    }

    public void bkE() {
        this.kyA = false;
        if (this.kyv != null) {
            this.kyv.clearAnimation();
            this.kyv.setVisibility(0);
            this.kyv.startAnimation(getInAnimation());
        }
        if (1 == TbadkCoreApplication.getInst().getSkinType() || 4 == TbadkCoreApplication.getInst().getSkinType()) {
            this.kyu.setImageResource(R.drawable.icon_topic_triangle_up_normal_1);
            this.kyu.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector_1);
        } else {
            this.kyu.setImageResource(R.drawable.icon_topic_triangle_up_normal);
            this.kyu.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector);
        }
        this.kyx.setDrawBottomLine(false);
        this.kyw.setVisibility(8);
    }

    public void cTR() {
        this.kyA = true;
        if (this.kyv != null) {
            this.kyv.clearAnimation();
            this.kyv.startAnimation(getOutAnimation());
        }
        if (1 == TbadkCoreApplication.getInst().getSkinType() || 4 == TbadkCoreApplication.getInst().getSkinType()) {
            this.kyu.setImageResource(R.drawable.icon_topic_triangle_down_normal_1);
            this.kyu.setBackgroundResource(R.drawable.rec_topic_btn_more_selector_1);
        } else {
            this.kyu.setImageResource(R.drawable.icon_topic_triangle_down_normal);
            this.kyu.setBackgroundResource(R.drawable.rec_topic_btn_more_selector);
        }
        this.kyx.setDrawBottomLine(true);
        this.kyw.setVisibility(0);
    }

    private Animation getInAnimation() {
        if (this.kyy == null) {
            this.kyy = AnimationUtils.loadAnimation(this.mContext, R.anim.fade_in);
            this.kyy.setAnimationListener(this.kyB);
        }
        return this.kyy;
    }

    private Animation getOutAnimation() {
        if (this.kyz == null) {
            this.kyz = AnimationUtils.loadAnimation(this.mContext, R.anim.fade_out);
            this.kyz.setAnimationListener(this.kyB);
        }
        return this.kyz;
    }

    public void setVisibility(int i) {
        if (this.rootView != null) {
            this.rootView.setVisibility(i);
        }
    }
}
