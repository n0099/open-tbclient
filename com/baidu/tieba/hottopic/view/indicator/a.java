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
    private ImageView jdk;
    private TextView jdl;
    private View jdm;
    private SlidingTabLayout jdn;
    private Animation jdo;
    private Animation jdp;
    private boolean jdq = true;
    private Animation.AnimationListener jdr = new Animation.AnimationListener() { // from class: com.baidu.tieba.hottopic.view.indicator.a.1
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (a.this.jdl != null) {
                if (animation == a.this.jdo) {
                    a.this.jdl.setVisibility(0);
                    a.this.jdl.setClickable(true);
                } else if (animation == a.this.jdp) {
                    a.this.jdl.setVisibility(8);
                    a.this.jdl.setClickable(false);
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
        this.jdl = (TextView) view.findViewById(R.id.topic_tab_widget_switch);
        this.jdm = view.findViewById(R.id.topic_tab_widget_line);
        this.jdk = (ImageView) view.findViewById(R.id.topic_tab_widget_more);
        this.jdk.setContentDescription("展开");
        this.jdn = (SlidingTabLayout) view.findViewById(R.id.topic_tab_widget_sliding_tab);
    }

    public void D(View.OnClickListener onClickListener) {
        if (this.jdk != null) {
            this.jdk.setOnClickListener(onClickListener);
        }
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.jdn != null) {
            this.jdn.setViewPager(viewPager);
        }
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.rootView, R.color.common_color_10274);
        ap.setBackgroundColor(this.jdl, R.color.cp_bg_line_e);
        ap.setViewTextColor(this.jdl, R.color.cp_cont_f, 1);
        ap.setBackgroundColor(this.jdm, R.color.cp_bg_line_c);
        if (this.jdq) {
            if (1 == i || 4 == i) {
                this.jdk.setImageResource(R.drawable.icon_topic_triangle_down_normal_1);
                this.jdk.setBackgroundResource(R.drawable.rec_topic_btn_more_selector_1);
            } else {
                this.jdk.setImageResource(R.drawable.icon_topic_triangle_down_normal);
                this.jdk.setBackgroundResource(R.drawable.rec_topic_btn_more_selector);
            }
        } else if (1 == i || 4 == i) {
            this.jdk.setImageResource(R.drawable.icon_topic_triangle_up_normal_1);
            this.jdk.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector_1);
        } else {
            this.jdk.setImageResource(R.drawable.icon_topic_triangle_up_normal);
            this.jdk.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector);
        }
        if (this.jdn != null) {
            this.jdn.onChangeSkinType(i);
        }
    }

    public void bbx() {
        this.jdq = false;
        if (this.jdl != null) {
            this.jdl.clearAnimation();
            this.jdl.setVisibility(0);
            this.jdl.startAnimation(getInAnimation());
        }
        if (1 == TbadkCoreApplication.getInst().getSkinType() || 4 == TbadkCoreApplication.getInst().getSkinType()) {
            this.jdk.setImageResource(R.drawable.icon_topic_triangle_up_normal_1);
            this.jdk.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector_1);
        } else {
            this.jdk.setImageResource(R.drawable.icon_topic_triangle_up_normal);
            this.jdk.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector);
        }
        this.jdn.setDrawBottomLine(false);
        this.jdm.setVisibility(8);
    }

    public void cAJ() {
        this.jdq = true;
        if (this.jdl != null) {
            this.jdl.clearAnimation();
            this.jdl.startAnimation(getOutAnimation());
        }
        if (1 == TbadkCoreApplication.getInst().getSkinType() || 4 == TbadkCoreApplication.getInst().getSkinType()) {
            this.jdk.setImageResource(R.drawable.icon_topic_triangle_down_normal_1);
            this.jdk.setBackgroundResource(R.drawable.rec_topic_btn_more_selector_1);
        } else {
            this.jdk.setImageResource(R.drawable.icon_topic_triangle_down_normal);
            this.jdk.setBackgroundResource(R.drawable.rec_topic_btn_more_selector);
        }
        this.jdn.setDrawBottomLine(true);
        this.jdm.setVisibility(0);
    }

    private Animation getInAnimation() {
        if (this.jdo == null) {
            this.jdo = AnimationUtils.loadAnimation(this.mContext, R.anim.fade_in);
            this.jdo.setAnimationListener(this.jdr);
        }
        return this.jdo;
    }

    private Animation getOutAnimation() {
        if (this.jdp == null) {
            this.jdp = AnimationUtils.loadAnimation(this.mContext, R.anim.fade_out);
            this.jdp.setAnimationListener(this.jdr);
        }
        return this.jdp;
    }

    public void setVisibility(int i) {
        if (this.rootView != null) {
            this.rootView.setVisibility(i);
        }
    }
}
