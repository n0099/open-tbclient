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
    private ImageView kyI;
    private TextView kyJ;
    private View kyK;
    private SlidingTabLayout kyL;
    private Animation kyM;
    private Animation kyN;
    private boolean kyO = true;
    private Animation.AnimationListener kyP = new Animation.AnimationListener() { // from class: com.baidu.tieba.hottopic.view.indicator.a.1
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (a.this.kyJ != null) {
                if (animation == a.this.kyM) {
                    a.this.kyJ.setVisibility(0);
                    a.this.kyJ.setClickable(true);
                } else if (animation == a.this.kyN) {
                    a.this.kyJ.setVisibility(8);
                    a.this.kyJ.setClickable(false);
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
        this.kyJ = (TextView) view.findViewById(R.id.topic_tab_widget_switch);
        this.kyK = view.findViewById(R.id.topic_tab_widget_line);
        this.kyI = (ImageView) view.findViewById(R.id.topic_tab_widget_more);
        this.kyI.setContentDescription("展开");
        this.kyL = (SlidingTabLayout) view.findViewById(R.id.topic_tab_widget_sliding_tab);
    }

    public void G(View.OnClickListener onClickListener) {
        if (this.kyI != null) {
            this.kyI.setOnClickListener(onClickListener);
        }
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.kyL != null) {
            this.kyL.setViewPager(viewPager);
        }
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.rootView, R.color.common_color_10274);
        ap.setBackgroundColor(this.kyJ, R.color.CAM_X0205);
        ap.setViewTextColor(this.kyJ, R.color.CAM_X0106, 1);
        ap.setBackgroundColor(this.kyK, R.color.CAM_X0204);
        if (this.kyO) {
            if (1 == i || 4 == i) {
                this.kyI.setImageResource(R.drawable.icon_topic_triangle_down_normal_1);
                this.kyI.setBackgroundResource(R.drawable.rec_topic_btn_more_selector_1);
            } else {
                this.kyI.setImageResource(R.drawable.icon_topic_triangle_down_normal);
                this.kyI.setBackgroundResource(R.drawable.rec_topic_btn_more_selector);
            }
        } else if (1 == i || 4 == i) {
            this.kyI.setImageResource(R.drawable.icon_topic_triangle_up_normal_1);
            this.kyI.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector_1);
        } else {
            this.kyI.setImageResource(R.drawable.icon_topic_triangle_up_normal);
            this.kyI.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector);
        }
        if (this.kyL != null) {
            this.kyL.onChangeSkinType(i);
        }
    }

    public void bkE() {
        this.kyO = false;
        if (this.kyJ != null) {
            this.kyJ.clearAnimation();
            this.kyJ.setVisibility(0);
            this.kyJ.startAnimation(getInAnimation());
        }
        if (1 == TbadkCoreApplication.getInst().getSkinType() || 4 == TbadkCoreApplication.getInst().getSkinType()) {
            this.kyI.setImageResource(R.drawable.icon_topic_triangle_up_normal_1);
            this.kyI.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector_1);
        } else {
            this.kyI.setImageResource(R.drawable.icon_topic_triangle_up_normal);
            this.kyI.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector);
        }
        this.kyL.setDrawBottomLine(false);
        this.kyK.setVisibility(8);
    }

    public void cTY() {
        this.kyO = true;
        if (this.kyJ != null) {
            this.kyJ.clearAnimation();
            this.kyJ.startAnimation(getOutAnimation());
        }
        if (1 == TbadkCoreApplication.getInst().getSkinType() || 4 == TbadkCoreApplication.getInst().getSkinType()) {
            this.kyI.setImageResource(R.drawable.icon_topic_triangle_down_normal_1);
            this.kyI.setBackgroundResource(R.drawable.rec_topic_btn_more_selector_1);
        } else {
            this.kyI.setImageResource(R.drawable.icon_topic_triangle_down_normal);
            this.kyI.setBackgroundResource(R.drawable.rec_topic_btn_more_selector);
        }
        this.kyL.setDrawBottomLine(true);
        this.kyK.setVisibility(0);
    }

    private Animation getInAnimation() {
        if (this.kyM == null) {
            this.kyM = AnimationUtils.loadAnimation(this.mContext, R.anim.fade_in);
            this.kyM.setAnimationListener(this.kyP);
        }
        return this.kyM;
    }

    private Animation getOutAnimation() {
        if (this.kyN == null) {
            this.kyN = AnimationUtils.loadAnimation(this.mContext, R.anim.fade_out);
            this.kyN.setAnimationListener(this.kyP);
        }
        return this.kyN;
    }

    public void setVisibility(int i) {
        if (this.rootView != null) {
            this.rootView.setVisibility(i);
        }
    }
}
