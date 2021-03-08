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
/* loaded from: classes7.dex */
public class a {
    private ImageView kAK;
    private TextView kAL;
    private View kAM;
    private SlidingTabLayout kAN;
    private Animation kAO;
    private Animation kAP;
    private boolean kAQ = true;
    private Animation.AnimationListener kAR = new Animation.AnimationListener() { // from class: com.baidu.tieba.hottopic.view.indicator.a.1
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (a.this.kAL != null) {
                if (animation == a.this.kAO) {
                    a.this.kAL.setVisibility(0);
                    a.this.kAL.setClickable(true);
                } else if (animation == a.this.kAP) {
                    a.this.kAL.setVisibility(8);
                    a.this.kAL.setClickable(false);
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
        this.kAL = (TextView) view.findViewById(R.id.topic_tab_widget_switch);
        this.kAM = view.findViewById(R.id.topic_tab_widget_line);
        this.kAK = (ImageView) view.findViewById(R.id.topic_tab_widget_more);
        this.kAK.setContentDescription("展开");
        this.kAN = (SlidingTabLayout) view.findViewById(R.id.topic_tab_widget_sliding_tab);
    }

    public void H(View.OnClickListener onClickListener) {
        if (this.kAK != null) {
            this.kAK.setOnClickListener(onClickListener);
        }
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.kAN != null) {
            this.kAN.setViewPager(viewPager);
        }
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.rootView, R.color.common_color_10274);
        ap.setBackgroundColor(this.kAL, R.color.CAM_X0205);
        ap.setViewTextColor(this.kAL, R.color.CAM_X0106, 1);
        ap.setBackgroundColor(this.kAM, R.color.CAM_X0204);
        if (this.kAQ) {
            if (1 == i || 4 == i) {
                this.kAK.setImageResource(R.drawable.icon_topic_triangle_down_normal_1);
                this.kAK.setBackgroundResource(R.drawable.rec_topic_btn_more_selector_1);
            } else {
                this.kAK.setImageResource(R.drawable.icon_topic_triangle_down_normal);
                this.kAK.setBackgroundResource(R.drawable.rec_topic_btn_more_selector);
            }
        } else if (1 == i || 4 == i) {
            this.kAK.setImageResource(R.drawable.icon_topic_triangle_up_normal_1);
            this.kAK.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector_1);
        } else {
            this.kAK.setImageResource(R.drawable.icon_topic_triangle_up_normal);
            this.kAK.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector);
        }
        if (this.kAN != null) {
            this.kAN.onChangeSkinType(i);
        }
    }

    public void bkG() {
        this.kAQ = false;
        if (this.kAL != null) {
            this.kAL.clearAnimation();
            this.kAL.setVisibility(0);
            this.kAL.startAnimation(getInAnimation());
        }
        if (1 == TbadkCoreApplication.getInst().getSkinType() || 4 == TbadkCoreApplication.getInst().getSkinType()) {
            this.kAK.setImageResource(R.drawable.icon_topic_triangle_up_normal_1);
            this.kAK.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector_1);
        } else {
            this.kAK.setImageResource(R.drawable.icon_topic_triangle_up_normal);
            this.kAK.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector);
        }
        this.kAN.setDrawBottomLine(false);
        this.kAM.setVisibility(8);
    }

    public void cUf() {
        this.kAQ = true;
        if (this.kAL != null) {
            this.kAL.clearAnimation();
            this.kAL.startAnimation(getOutAnimation());
        }
        if (1 == TbadkCoreApplication.getInst().getSkinType() || 4 == TbadkCoreApplication.getInst().getSkinType()) {
            this.kAK.setImageResource(R.drawable.icon_topic_triangle_down_normal_1);
            this.kAK.setBackgroundResource(R.drawable.rec_topic_btn_more_selector_1);
        } else {
            this.kAK.setImageResource(R.drawable.icon_topic_triangle_down_normal);
            this.kAK.setBackgroundResource(R.drawable.rec_topic_btn_more_selector);
        }
        this.kAN.setDrawBottomLine(true);
        this.kAM.setVisibility(0);
    }

    private Animation getInAnimation() {
        if (this.kAO == null) {
            this.kAO = AnimationUtils.loadAnimation(this.mContext, R.anim.fade_in);
            this.kAO.setAnimationListener(this.kAR);
        }
        return this.kAO;
    }

    private Animation getOutAnimation() {
        if (this.kAP == null) {
            this.kAP = AnimationUtils.loadAnimation(this.mContext, R.anim.fade_out);
            this.kAP.setAnimationListener(this.kAR);
        }
        return this.kAP;
    }

    public void setVisibility(int i) {
        if (this.rootView != null) {
            this.rootView.setVisibility(i);
        }
    }
}
