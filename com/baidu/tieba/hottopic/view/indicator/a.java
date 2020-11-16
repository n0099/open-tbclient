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
    private ImageView jUa;
    private TextView jUb;
    private View jUc;
    private SlidingTabLayout jUd;
    private Animation jUe;
    private Animation jUf;
    private boolean jUg = true;
    private Animation.AnimationListener jUh = new Animation.AnimationListener() { // from class: com.baidu.tieba.hottopic.view.indicator.a.1
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (a.this.jUb != null) {
                if (animation == a.this.jUe) {
                    a.this.jUb.setVisibility(0);
                    a.this.jUb.setClickable(true);
                } else if (animation == a.this.jUf) {
                    a.this.jUb.setVisibility(8);
                    a.this.jUb.setClickable(false);
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
        this.jUb = (TextView) view.findViewById(R.id.topic_tab_widget_switch);
        this.jUc = view.findViewById(R.id.topic_tab_widget_line);
        this.jUa = (ImageView) view.findViewById(R.id.topic_tab_widget_more);
        this.jUa.setContentDescription("展开");
        this.jUd = (SlidingTabLayout) view.findViewById(R.id.topic_tab_widget_sliding_tab);
    }

    public void E(View.OnClickListener onClickListener) {
        if (this.jUa != null) {
            this.jUa.setOnClickListener(onClickListener);
        }
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.jUd != null) {
            this.jUd.setViewPager(viewPager);
        }
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.rootView, R.color.common_color_10274);
        ap.setBackgroundColor(this.jUb, R.color.CAM_X0205);
        ap.setViewTextColor(this.jUb, R.color.CAM_X0106, 1);
        ap.setBackgroundColor(this.jUc, R.color.CAM_X0204);
        if (this.jUg) {
            if (1 == i || 4 == i) {
                this.jUa.setImageResource(R.drawable.icon_topic_triangle_down_normal_1);
                this.jUa.setBackgroundResource(R.drawable.rec_topic_btn_more_selector_1);
            } else {
                this.jUa.setImageResource(R.drawable.icon_topic_triangle_down_normal);
                this.jUa.setBackgroundResource(R.drawable.rec_topic_btn_more_selector);
            }
        } else if (1 == i || 4 == i) {
            this.jUa.setImageResource(R.drawable.icon_topic_triangle_up_normal_1);
            this.jUa.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector_1);
        } else {
            this.jUa.setImageResource(R.drawable.icon_topic_triangle_up_normal);
            this.jUa.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector);
        }
        if (this.jUd != null) {
            this.jUd.onChangeSkinType(i);
        }
    }

    public void biw() {
        this.jUg = false;
        if (this.jUb != null) {
            this.jUb.clearAnimation();
            this.jUb.setVisibility(0);
            this.jUb.startAnimation(getInAnimation());
        }
        if (1 == TbadkCoreApplication.getInst().getSkinType() || 4 == TbadkCoreApplication.getInst().getSkinType()) {
            this.jUa.setImageResource(R.drawable.icon_topic_triangle_up_normal_1);
            this.jUa.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector_1);
        } else {
            this.jUa.setImageResource(R.drawable.icon_topic_triangle_up_normal);
            this.jUa.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector);
        }
        this.jUd.setDrawBottomLine(false);
        this.jUc.setVisibility(8);
    }

    public void cNo() {
        this.jUg = true;
        if (this.jUb != null) {
            this.jUb.clearAnimation();
            this.jUb.startAnimation(getOutAnimation());
        }
        if (1 == TbadkCoreApplication.getInst().getSkinType() || 4 == TbadkCoreApplication.getInst().getSkinType()) {
            this.jUa.setImageResource(R.drawable.icon_topic_triangle_down_normal_1);
            this.jUa.setBackgroundResource(R.drawable.rec_topic_btn_more_selector_1);
        } else {
            this.jUa.setImageResource(R.drawable.icon_topic_triangle_down_normal);
            this.jUa.setBackgroundResource(R.drawable.rec_topic_btn_more_selector);
        }
        this.jUd.setDrawBottomLine(true);
        this.jUc.setVisibility(0);
    }

    private Animation getInAnimation() {
        if (this.jUe == null) {
            this.jUe = AnimationUtils.loadAnimation(this.mContext, R.anim.fade_in);
            this.jUe.setAnimationListener(this.jUh);
        }
        return this.jUe;
    }

    private Animation getOutAnimation() {
        if (this.jUf == null) {
            this.jUf = AnimationUtils.loadAnimation(this.mContext, R.anim.fade_out);
            this.jUf.setAnimationListener(this.jUh);
        }
        return this.jUf;
    }

    public void setVisibility(int i) {
        if (this.rootView != null) {
            this.rootView.setVisibility(i);
        }
    }
}
