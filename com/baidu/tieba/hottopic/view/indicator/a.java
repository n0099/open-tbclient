package com.baidu.tieba.hottopic.view.indicator;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class a {
    private ImageView iIg;
    private TextView iIh;
    private View iIi;
    private SlidingTabLayout iIj;
    private Animation iIk;
    private Animation iIl;
    private boolean iIm = true;
    private Animation.AnimationListener iIn = new Animation.AnimationListener() { // from class: com.baidu.tieba.hottopic.view.indicator.a.1
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (a.this.iIh != null) {
                if (animation == a.this.iIk) {
                    a.this.iIh.setVisibility(0);
                    a.this.iIh.setClickable(true);
                } else if (animation == a.this.iIl) {
                    a.this.iIh.setVisibility(8);
                    a.this.iIh.setClickable(false);
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
        this.iIh = (TextView) view.findViewById(R.id.topic_tab_widget_switch);
        this.iIi = view.findViewById(R.id.topic_tab_widget_line);
        this.iIg = (ImageView) view.findViewById(R.id.topic_tab_widget_more);
        this.iIg.setContentDescription("展开");
        this.iIj = (SlidingTabLayout) view.findViewById(R.id.topic_tab_widget_sliding_tab);
    }

    public void C(View.OnClickListener onClickListener) {
        if (this.iIg != null) {
            this.iIg.setOnClickListener(onClickListener);
        }
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.iIj != null) {
            this.iIj.setViewPager(viewPager);
        }
    }

    public void onChangeSkinType(int i) {
        an.setBackgroundColor(this.rootView, R.color.common_color_10274);
        an.setBackgroundColor(this.iIh, R.color.cp_bg_line_e);
        an.setViewTextColor(this.iIh, R.color.cp_cont_f, 1);
        an.setBackgroundColor(this.iIi, R.color.cp_bg_line_c);
        if (this.iIm) {
            if (1 == i || 4 == i) {
                this.iIg.setImageResource(R.drawable.icon_topic_triangle_down_normal_1);
                this.iIg.setBackgroundResource(R.drawable.rec_topic_btn_more_selector_1);
            } else {
                this.iIg.setImageResource(R.drawable.icon_topic_triangle_down_normal);
                this.iIg.setBackgroundResource(R.drawable.rec_topic_btn_more_selector);
            }
        } else if (1 == i || 4 == i) {
            this.iIg.setImageResource(R.drawable.icon_topic_triangle_up_normal_1);
            this.iIg.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector_1);
        } else {
            this.iIg.setImageResource(R.drawable.icon_topic_triangle_up_normal);
            this.iIg.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector);
        }
        if (this.iIj != null) {
            this.iIj.onChangeSkinType(i);
        }
    }

    public void aPl() {
        this.iIm = false;
        if (this.iIh != null) {
            this.iIh.clearAnimation();
            this.iIh.setVisibility(0);
            this.iIh.startAnimation(getInAnimation());
        }
        if (1 == TbadkCoreApplication.getInst().getSkinType() || 4 == TbadkCoreApplication.getInst().getSkinType()) {
            this.iIg.setImageResource(R.drawable.icon_topic_triangle_up_normal_1);
            this.iIg.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector_1);
        } else {
            this.iIg.setImageResource(R.drawable.icon_topic_triangle_up_normal);
            this.iIg.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector);
        }
        this.iIj.setDrawBottomLine(false);
        this.iIi.setVisibility(8);
    }

    public void cmr() {
        this.iIm = true;
        if (this.iIh != null) {
            this.iIh.clearAnimation();
            this.iIh.startAnimation(getOutAnimation());
        }
        if (1 == TbadkCoreApplication.getInst().getSkinType() || 4 == TbadkCoreApplication.getInst().getSkinType()) {
            this.iIg.setImageResource(R.drawable.icon_topic_triangle_down_normal_1);
            this.iIg.setBackgroundResource(R.drawable.rec_topic_btn_more_selector_1);
        } else {
            this.iIg.setImageResource(R.drawable.icon_topic_triangle_down_normal);
            this.iIg.setBackgroundResource(R.drawable.rec_topic_btn_more_selector);
        }
        this.iIj.setDrawBottomLine(true);
        this.iIi.setVisibility(0);
    }

    private Animation getInAnimation() {
        if (this.iIk == null) {
            this.iIk = AnimationUtils.loadAnimation(this.mContext, R.anim.fade_in);
            this.iIk.setAnimationListener(this.iIn);
        }
        return this.iIk;
    }

    private Animation getOutAnimation() {
        if (this.iIl == null) {
            this.iIl = AnimationUtils.loadAnimation(this.mContext, R.anim.fade_out);
            this.iIl.setAnimationListener(this.iIn);
        }
        return this.iIl;
    }

    public void setVisibility(int i) {
        if (this.rootView != null) {
            this.rootView.setVisibility(i);
        }
    }
}
