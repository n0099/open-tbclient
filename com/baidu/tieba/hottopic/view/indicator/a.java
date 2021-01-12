package com.baidu.tieba.hottopic.view.indicator;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class a {
    private ImageView kqn;
    private TextView kqo;
    private View kqp;
    private SlidingTabLayout kqq;
    private Animation kqr;
    private Animation kqs;
    private boolean kqt = true;
    private Animation.AnimationListener kqu = new Animation.AnimationListener() { // from class: com.baidu.tieba.hottopic.view.indicator.a.1
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (a.this.kqo != null) {
                if (animation == a.this.kqr) {
                    a.this.kqo.setVisibility(0);
                    a.this.kqo.setClickable(true);
                } else if (animation == a.this.kqs) {
                    a.this.kqo.setVisibility(8);
                    a.this.kqo.setClickable(false);
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
        this.kqo = (TextView) view.findViewById(R.id.topic_tab_widget_switch);
        this.kqp = view.findViewById(R.id.topic_tab_widget_line);
        this.kqn = (ImageView) view.findViewById(R.id.topic_tab_widget_more);
        this.kqn.setContentDescription("展开");
        this.kqq = (SlidingTabLayout) view.findViewById(R.id.topic_tab_widget_sliding_tab);
    }

    public void G(View.OnClickListener onClickListener) {
        if (this.kqn != null) {
            this.kqn.setOnClickListener(onClickListener);
        }
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.kqq != null) {
            this.kqq.setViewPager(viewPager);
        }
    }

    public void onChangeSkinType(int i) {
        ao.setBackgroundColor(this.rootView, R.color.common_color_10274);
        ao.setBackgroundColor(this.kqo, R.color.CAM_X0205);
        ao.setViewTextColor(this.kqo, R.color.CAM_X0106, 1);
        ao.setBackgroundColor(this.kqp, R.color.CAM_X0204);
        if (this.kqt) {
            if (1 == i || 4 == i) {
                this.kqn.setImageResource(R.drawable.icon_topic_triangle_down_normal_1);
                this.kqn.setBackgroundResource(R.drawable.rec_topic_btn_more_selector_1);
            } else {
                this.kqn.setImageResource(R.drawable.icon_topic_triangle_down_normal);
                this.kqn.setBackgroundResource(R.drawable.rec_topic_btn_more_selector);
            }
        } else if (1 == i || 4 == i) {
            this.kqn.setImageResource(R.drawable.icon_topic_triangle_up_normal_1);
            this.kqn.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector_1);
        } else {
            this.kqn.setImageResource(R.drawable.icon_topic_triangle_up_normal);
            this.kqn.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector);
        }
        if (this.kqq != null) {
            this.kqq.onChangeSkinType(i);
        }
    }

    public void bkm() {
        this.kqt = false;
        if (this.kqo != null) {
            this.kqo.clearAnimation();
            this.kqo.setVisibility(0);
            this.kqo.startAnimation(getInAnimation());
        }
        if (1 == TbadkCoreApplication.getInst().getSkinType() || 4 == TbadkCoreApplication.getInst().getSkinType()) {
            this.kqn.setImageResource(R.drawable.icon_topic_triangle_up_normal_1);
            this.kqn.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector_1);
        } else {
            this.kqn.setImageResource(R.drawable.icon_topic_triangle_up_normal);
            this.kqn.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector);
        }
        this.kqq.setDrawBottomLine(false);
        this.kqp.setVisibility(8);
    }

    public void cRS() {
        this.kqt = true;
        if (this.kqo != null) {
            this.kqo.clearAnimation();
            this.kqo.startAnimation(getOutAnimation());
        }
        if (1 == TbadkCoreApplication.getInst().getSkinType() || 4 == TbadkCoreApplication.getInst().getSkinType()) {
            this.kqn.setImageResource(R.drawable.icon_topic_triangle_down_normal_1);
            this.kqn.setBackgroundResource(R.drawable.rec_topic_btn_more_selector_1);
        } else {
            this.kqn.setImageResource(R.drawable.icon_topic_triangle_down_normal);
            this.kqn.setBackgroundResource(R.drawable.rec_topic_btn_more_selector);
        }
        this.kqq.setDrawBottomLine(true);
        this.kqp.setVisibility(0);
    }

    private Animation getInAnimation() {
        if (this.kqr == null) {
            this.kqr = AnimationUtils.loadAnimation(this.mContext, R.anim.fade_in);
            this.kqr.setAnimationListener(this.kqu);
        }
        return this.kqr;
    }

    private Animation getOutAnimation() {
        if (this.kqs == null) {
            this.kqs = AnimationUtils.loadAnimation(this.mContext, R.anim.fade_out);
            this.kqs.setAnimationListener(this.kqu);
        }
        return this.kqs;
    }

    public void setVisibility(int i) {
        if (this.rootView != null) {
            this.rootView.setVisibility(i);
        }
    }
}
