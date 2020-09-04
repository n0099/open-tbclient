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
/* loaded from: classes15.dex */
public class a {
    private ImageView jdq;
    private TextView jdr;
    private View jds;
    private SlidingTabLayout jdt;
    private Animation jdu;
    private Animation jdv;
    private boolean jdw = true;
    private Animation.AnimationListener jdx = new Animation.AnimationListener() { // from class: com.baidu.tieba.hottopic.view.indicator.a.1
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (a.this.jdr != null) {
                if (animation == a.this.jdu) {
                    a.this.jdr.setVisibility(0);
                    a.this.jdr.setClickable(true);
                } else if (animation == a.this.jdv) {
                    a.this.jdr.setVisibility(8);
                    a.this.jdr.setClickable(false);
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
        this.jdr = (TextView) view.findViewById(R.id.topic_tab_widget_switch);
        this.jds = view.findViewById(R.id.topic_tab_widget_line);
        this.jdq = (ImageView) view.findViewById(R.id.topic_tab_widget_more);
        this.jdq.setContentDescription("展开");
        this.jdt = (SlidingTabLayout) view.findViewById(R.id.topic_tab_widget_sliding_tab);
    }

    public void D(View.OnClickListener onClickListener) {
        if (this.jdq != null) {
            this.jdq.setOnClickListener(onClickListener);
        }
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.jdt != null) {
            this.jdt.setViewPager(viewPager);
        }
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.rootView, R.color.common_color_10274);
        ap.setBackgroundColor(this.jdr, R.color.cp_bg_line_e);
        ap.setViewTextColor(this.jdr, R.color.cp_cont_f, 1);
        ap.setBackgroundColor(this.jds, R.color.cp_bg_line_c);
        if (this.jdw) {
            if (1 == i || 4 == i) {
                this.jdq.setImageResource(R.drawable.icon_topic_triangle_down_normal_1);
                this.jdq.setBackgroundResource(R.drawable.rec_topic_btn_more_selector_1);
            } else {
                this.jdq.setImageResource(R.drawable.icon_topic_triangle_down_normal);
                this.jdq.setBackgroundResource(R.drawable.rec_topic_btn_more_selector);
            }
        } else if (1 == i || 4 == i) {
            this.jdq.setImageResource(R.drawable.icon_topic_triangle_up_normal_1);
            this.jdq.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector_1);
        } else {
            this.jdq.setImageResource(R.drawable.icon_topic_triangle_up_normal);
            this.jdq.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector);
        }
        if (this.jdt != null) {
            this.jdt.onChangeSkinType(i);
        }
    }

    public void bbx() {
        this.jdw = false;
        if (this.jdr != null) {
            this.jdr.clearAnimation();
            this.jdr.setVisibility(0);
            this.jdr.startAnimation(getInAnimation());
        }
        if (1 == TbadkCoreApplication.getInst().getSkinType() || 4 == TbadkCoreApplication.getInst().getSkinType()) {
            this.jdq.setImageResource(R.drawable.icon_topic_triangle_up_normal_1);
            this.jdq.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector_1);
        } else {
            this.jdq.setImageResource(R.drawable.icon_topic_triangle_up_normal);
            this.jdq.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector);
        }
        this.jdt.setDrawBottomLine(false);
        this.jds.setVisibility(8);
    }

    public void cAK() {
        this.jdw = true;
        if (this.jdr != null) {
            this.jdr.clearAnimation();
            this.jdr.startAnimation(getOutAnimation());
        }
        if (1 == TbadkCoreApplication.getInst().getSkinType() || 4 == TbadkCoreApplication.getInst().getSkinType()) {
            this.jdq.setImageResource(R.drawable.icon_topic_triangle_down_normal_1);
            this.jdq.setBackgroundResource(R.drawable.rec_topic_btn_more_selector_1);
        } else {
            this.jdq.setImageResource(R.drawable.icon_topic_triangle_down_normal);
            this.jdq.setBackgroundResource(R.drawable.rec_topic_btn_more_selector);
        }
        this.jdt.setDrawBottomLine(true);
        this.jds.setVisibility(0);
    }

    private Animation getInAnimation() {
        if (this.jdu == null) {
            this.jdu = AnimationUtils.loadAnimation(this.mContext, R.anim.fade_in);
            this.jdu.setAnimationListener(this.jdx);
        }
        return this.jdu;
    }

    private Animation getOutAnimation() {
        if (this.jdv == null) {
            this.jdv = AnimationUtils.loadAnimation(this.mContext, R.anim.fade_out);
            this.jdv.setAnimationListener(this.jdx);
        }
        return this.jdv;
    }

    public void setVisibility(int i) {
        if (this.rootView != null) {
            this.rootView.setVisibility(i);
        }
    }
}
