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
    private ImageView khG;
    private TextView khH;
    private View khI;
    private SlidingTabLayout khJ;
    private Animation khK;
    private Animation khL;
    private boolean khM = true;
    private Animation.AnimationListener khN = new Animation.AnimationListener() { // from class: com.baidu.tieba.hottopic.view.indicator.a.1
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (a.this.khH != null) {
                if (animation == a.this.khK) {
                    a.this.khH.setVisibility(0);
                    a.this.khH.setClickable(true);
                } else if (animation == a.this.khL) {
                    a.this.khH.setVisibility(8);
                    a.this.khH.setClickable(false);
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
        this.khH = (TextView) view.findViewById(R.id.topic_tab_widget_switch);
        this.khI = view.findViewById(R.id.topic_tab_widget_line);
        this.khG = (ImageView) view.findViewById(R.id.topic_tab_widget_more);
        this.khG.setContentDescription("展开");
        this.khJ = (SlidingTabLayout) view.findViewById(R.id.topic_tab_widget_sliding_tab);
    }

    public void E(View.OnClickListener onClickListener) {
        if (this.khG != null) {
            this.khG.setOnClickListener(onClickListener);
        }
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.khJ != null) {
            this.khJ.setViewPager(viewPager);
        }
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.rootView, R.color.common_color_10274);
        ap.setBackgroundColor(this.khH, R.color.CAM_X0205);
        ap.setViewTextColor(this.khH, R.color.CAM_X0106, 1);
        ap.setBackgroundColor(this.khI, R.color.CAM_X0204);
        if (this.khM) {
            if (1 == i || 4 == i) {
                this.khG.setImageResource(R.drawable.icon_topic_triangle_down_normal_1);
                this.khG.setBackgroundResource(R.drawable.rec_topic_btn_more_selector_1);
            } else {
                this.khG.setImageResource(R.drawable.icon_topic_triangle_down_normal);
                this.khG.setBackgroundResource(R.drawable.rec_topic_btn_more_selector);
            }
        } else if (1 == i || 4 == i) {
            this.khG.setImageResource(R.drawable.icon_topic_triangle_up_normal_1);
            this.khG.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector_1);
        } else {
            this.khG.setImageResource(R.drawable.icon_topic_triangle_up_normal);
            this.khG.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector);
        }
        if (this.khJ != null) {
            this.khJ.onChangeSkinType(i);
        }
    }

    public void blG() {
        this.khM = false;
        if (this.khH != null) {
            this.khH.clearAnimation();
            this.khH.setVisibility(0);
            this.khH.startAnimation(getInAnimation());
        }
        if (1 == TbadkCoreApplication.getInst().getSkinType() || 4 == TbadkCoreApplication.getInst().getSkinType()) {
            this.khG.setImageResource(R.drawable.icon_topic_triangle_up_normal_1);
            this.khG.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector_1);
        } else {
            this.khG.setImageResource(R.drawable.icon_topic_triangle_up_normal);
            this.khG.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector);
        }
        this.khJ.setDrawBottomLine(false);
        this.khI.setVisibility(8);
    }

    public void cSD() {
        this.khM = true;
        if (this.khH != null) {
            this.khH.clearAnimation();
            this.khH.startAnimation(getOutAnimation());
        }
        if (1 == TbadkCoreApplication.getInst().getSkinType() || 4 == TbadkCoreApplication.getInst().getSkinType()) {
            this.khG.setImageResource(R.drawable.icon_topic_triangle_down_normal_1);
            this.khG.setBackgroundResource(R.drawable.rec_topic_btn_more_selector_1);
        } else {
            this.khG.setImageResource(R.drawable.icon_topic_triangle_down_normal);
            this.khG.setBackgroundResource(R.drawable.rec_topic_btn_more_selector);
        }
        this.khJ.setDrawBottomLine(true);
        this.khI.setVisibility(0);
    }

    private Animation getInAnimation() {
        if (this.khK == null) {
            this.khK = AnimationUtils.loadAnimation(this.mContext, R.anim.fade_in);
            this.khK.setAnimationListener(this.khN);
        }
        return this.khK;
    }

    private Animation getOutAnimation() {
        if (this.khL == null) {
            this.khL = AnimationUtils.loadAnimation(this.mContext, R.anim.fade_out);
            this.khL.setAnimationListener(this.khN);
        }
        return this.khL;
    }

    public void setVisibility(int i) {
        if (this.rootView != null) {
            this.rootView.setVisibility(i);
        }
    }
}
