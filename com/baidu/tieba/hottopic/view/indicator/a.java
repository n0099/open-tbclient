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
/* loaded from: classes8.dex */
public class a {
    private ImageView kuS;
    private TextView kuT;
    private View kuU;
    private SlidingTabLayout kuV;
    private Animation kuW;
    private Animation kuX;
    private boolean kuY = true;
    private Animation.AnimationListener kuZ = new Animation.AnimationListener() { // from class: com.baidu.tieba.hottopic.view.indicator.a.1
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (a.this.kuT != null) {
                if (animation == a.this.kuW) {
                    a.this.kuT.setVisibility(0);
                    a.this.kuT.setClickable(true);
                } else if (animation == a.this.kuX) {
                    a.this.kuT.setVisibility(8);
                    a.this.kuT.setClickable(false);
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
        this.kuT = (TextView) view.findViewById(R.id.topic_tab_widget_switch);
        this.kuU = view.findViewById(R.id.topic_tab_widget_line);
        this.kuS = (ImageView) view.findViewById(R.id.topic_tab_widget_more);
        this.kuS.setContentDescription("展开");
        this.kuV = (SlidingTabLayout) view.findViewById(R.id.topic_tab_widget_sliding_tab);
    }

    public void G(View.OnClickListener onClickListener) {
        if (this.kuS != null) {
            this.kuS.setOnClickListener(onClickListener);
        }
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.kuV != null) {
            this.kuV.setViewPager(viewPager);
        }
    }

    public void onChangeSkinType(int i) {
        ao.setBackgroundColor(this.rootView, R.color.common_color_10274);
        ao.setBackgroundColor(this.kuT, R.color.CAM_X0205);
        ao.setViewTextColor(this.kuT, R.color.CAM_X0106, 1);
        ao.setBackgroundColor(this.kuU, R.color.CAM_X0204);
        if (this.kuY) {
            if (1 == i || 4 == i) {
                this.kuS.setImageResource(R.drawable.icon_topic_triangle_down_normal_1);
                this.kuS.setBackgroundResource(R.drawable.rec_topic_btn_more_selector_1);
            } else {
                this.kuS.setImageResource(R.drawable.icon_topic_triangle_down_normal);
                this.kuS.setBackgroundResource(R.drawable.rec_topic_btn_more_selector);
            }
        } else if (1 == i || 4 == i) {
            this.kuS.setImageResource(R.drawable.icon_topic_triangle_up_normal_1);
            this.kuS.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector_1);
        } else {
            this.kuS.setImageResource(R.drawable.icon_topic_triangle_up_normal);
            this.kuS.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector);
        }
        if (this.kuV != null) {
            this.kuV.onChangeSkinType(i);
        }
    }

    public void bog() {
        this.kuY = false;
        if (this.kuT != null) {
            this.kuT.clearAnimation();
            this.kuT.setVisibility(0);
            this.kuT.startAnimation(getInAnimation());
        }
        if (1 == TbadkCoreApplication.getInst().getSkinType() || 4 == TbadkCoreApplication.getInst().getSkinType()) {
            this.kuS.setImageResource(R.drawable.icon_topic_triangle_up_normal_1);
            this.kuS.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector_1);
        } else {
            this.kuS.setImageResource(R.drawable.icon_topic_triangle_up_normal);
            this.kuS.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector);
        }
        this.kuV.setDrawBottomLine(false);
        this.kuU.setVisibility(8);
    }

    public void cVK() {
        this.kuY = true;
        if (this.kuT != null) {
            this.kuT.clearAnimation();
            this.kuT.startAnimation(getOutAnimation());
        }
        if (1 == TbadkCoreApplication.getInst().getSkinType() || 4 == TbadkCoreApplication.getInst().getSkinType()) {
            this.kuS.setImageResource(R.drawable.icon_topic_triangle_down_normal_1);
            this.kuS.setBackgroundResource(R.drawable.rec_topic_btn_more_selector_1);
        } else {
            this.kuS.setImageResource(R.drawable.icon_topic_triangle_down_normal);
            this.kuS.setBackgroundResource(R.drawable.rec_topic_btn_more_selector);
        }
        this.kuV.setDrawBottomLine(true);
        this.kuU.setVisibility(0);
    }

    private Animation getInAnimation() {
        if (this.kuW == null) {
            this.kuW = AnimationUtils.loadAnimation(this.mContext, R.anim.fade_in);
            this.kuW.setAnimationListener(this.kuZ);
        }
        return this.kuW;
    }

    private Animation getOutAnimation() {
        if (this.kuX == null) {
            this.kuX = AnimationUtils.loadAnimation(this.mContext, R.anim.fade_out);
            this.kuX.setAnimationListener(this.kuZ);
        }
        return this.kuX;
    }

    public void setVisibility(int i) {
        if (this.rootView != null) {
            this.rootView.setVisibility(i);
        }
    }
}
