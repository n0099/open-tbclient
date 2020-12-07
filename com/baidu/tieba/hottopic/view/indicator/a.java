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
    private ImageView khE;
    private TextView khF;
    private View khG;
    private SlidingTabLayout khH;
    private Animation khI;
    private Animation khJ;
    private boolean khK = true;
    private Animation.AnimationListener khL = new Animation.AnimationListener() { // from class: com.baidu.tieba.hottopic.view.indicator.a.1
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (a.this.khF != null) {
                if (animation == a.this.khI) {
                    a.this.khF.setVisibility(0);
                    a.this.khF.setClickable(true);
                } else if (animation == a.this.khJ) {
                    a.this.khF.setVisibility(8);
                    a.this.khF.setClickable(false);
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
        this.khF = (TextView) view.findViewById(R.id.topic_tab_widget_switch);
        this.khG = view.findViewById(R.id.topic_tab_widget_line);
        this.khE = (ImageView) view.findViewById(R.id.topic_tab_widget_more);
        this.khE.setContentDescription("展开");
        this.khH = (SlidingTabLayout) view.findViewById(R.id.topic_tab_widget_sliding_tab);
    }

    public void E(View.OnClickListener onClickListener) {
        if (this.khE != null) {
            this.khE.setOnClickListener(onClickListener);
        }
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.khH != null) {
            this.khH.setViewPager(viewPager);
        }
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.rootView, R.color.common_color_10274);
        ap.setBackgroundColor(this.khF, R.color.CAM_X0205);
        ap.setViewTextColor(this.khF, R.color.CAM_X0106, 1);
        ap.setBackgroundColor(this.khG, R.color.CAM_X0204);
        if (this.khK) {
            if (1 == i || 4 == i) {
                this.khE.setImageResource(R.drawable.icon_topic_triangle_down_normal_1);
                this.khE.setBackgroundResource(R.drawable.rec_topic_btn_more_selector_1);
            } else {
                this.khE.setImageResource(R.drawable.icon_topic_triangle_down_normal);
                this.khE.setBackgroundResource(R.drawable.rec_topic_btn_more_selector);
            }
        } else if (1 == i || 4 == i) {
            this.khE.setImageResource(R.drawable.icon_topic_triangle_up_normal_1);
            this.khE.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector_1);
        } else {
            this.khE.setImageResource(R.drawable.icon_topic_triangle_up_normal);
            this.khE.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector);
        }
        if (this.khH != null) {
            this.khH.onChangeSkinType(i);
        }
    }

    public void blG() {
        this.khK = false;
        if (this.khF != null) {
            this.khF.clearAnimation();
            this.khF.setVisibility(0);
            this.khF.startAnimation(getInAnimation());
        }
        if (1 == TbadkCoreApplication.getInst().getSkinType() || 4 == TbadkCoreApplication.getInst().getSkinType()) {
            this.khE.setImageResource(R.drawable.icon_topic_triangle_up_normal_1);
            this.khE.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector_1);
        } else {
            this.khE.setImageResource(R.drawable.icon_topic_triangle_up_normal);
            this.khE.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector);
        }
        this.khH.setDrawBottomLine(false);
        this.khG.setVisibility(8);
    }

    public void cSC() {
        this.khK = true;
        if (this.khF != null) {
            this.khF.clearAnimation();
            this.khF.startAnimation(getOutAnimation());
        }
        if (1 == TbadkCoreApplication.getInst().getSkinType() || 4 == TbadkCoreApplication.getInst().getSkinType()) {
            this.khE.setImageResource(R.drawable.icon_topic_triangle_down_normal_1);
            this.khE.setBackgroundResource(R.drawable.rec_topic_btn_more_selector_1);
        } else {
            this.khE.setImageResource(R.drawable.icon_topic_triangle_down_normal);
            this.khE.setBackgroundResource(R.drawable.rec_topic_btn_more_selector);
        }
        this.khH.setDrawBottomLine(true);
        this.khG.setVisibility(0);
    }

    private Animation getInAnimation() {
        if (this.khI == null) {
            this.khI = AnimationUtils.loadAnimation(this.mContext, R.anim.fade_in);
            this.khI.setAnimationListener(this.khL);
        }
        return this.khI;
    }

    private Animation getOutAnimation() {
        if (this.khJ == null) {
            this.khJ = AnimationUtils.loadAnimation(this.mContext, R.anim.fade_out);
            this.khJ.setAnimationListener(this.khL);
        }
        return this.khJ;
    }

    public void setVisibility(int i) {
        if (this.rootView != null) {
            this.rootView.setVisibility(i);
        }
    }
}
