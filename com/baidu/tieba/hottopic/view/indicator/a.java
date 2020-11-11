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
    private ImageView jTq;
    private TextView jTr;
    private View jTs;
    private SlidingTabLayout jTt;
    private Animation jTu;
    private Animation jTv;
    private boolean jTw = true;
    private Animation.AnimationListener jTx = new Animation.AnimationListener() { // from class: com.baidu.tieba.hottopic.view.indicator.a.1
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (a.this.jTr != null) {
                if (animation == a.this.jTu) {
                    a.this.jTr.setVisibility(0);
                    a.this.jTr.setClickable(true);
                } else if (animation == a.this.jTv) {
                    a.this.jTr.setVisibility(8);
                    a.this.jTr.setClickable(false);
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
        this.jTr = (TextView) view.findViewById(R.id.topic_tab_widget_switch);
        this.jTs = view.findViewById(R.id.topic_tab_widget_line);
        this.jTq = (ImageView) view.findViewById(R.id.topic_tab_widget_more);
        this.jTq.setContentDescription("展开");
        this.jTt = (SlidingTabLayout) view.findViewById(R.id.topic_tab_widget_sliding_tab);
    }

    public void E(View.OnClickListener onClickListener) {
        if (this.jTq != null) {
            this.jTq.setOnClickListener(onClickListener);
        }
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.jTt != null) {
            this.jTt.setViewPager(viewPager);
        }
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.rootView, R.color.common_color_10274);
        ap.setBackgroundColor(this.jTr, R.color.cp_bg_line_e);
        ap.setViewTextColor(this.jTr, R.color.cp_cont_f, 1);
        ap.setBackgroundColor(this.jTs, R.color.cp_bg_line_c);
        if (this.jTw) {
            if (1 == i || 4 == i) {
                this.jTq.setImageResource(R.drawable.icon_topic_triangle_down_normal_1);
                this.jTq.setBackgroundResource(R.drawable.rec_topic_btn_more_selector_1);
            } else {
                this.jTq.setImageResource(R.drawable.icon_topic_triangle_down_normal);
                this.jTq.setBackgroundResource(R.drawable.rec_topic_btn_more_selector);
            }
        } else if (1 == i || 4 == i) {
            this.jTq.setImageResource(R.drawable.icon_topic_triangle_up_normal_1);
            this.jTq.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector_1);
        } else {
            this.jTq.setImageResource(R.drawable.icon_topic_triangle_up_normal);
            this.jTq.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector);
        }
        if (this.jTt != null) {
            this.jTt.onChangeSkinType(i);
        }
    }

    public void bjs() {
        this.jTw = false;
        if (this.jTr != null) {
            this.jTr.clearAnimation();
            this.jTr.setVisibility(0);
            this.jTr.startAnimation(getInAnimation());
        }
        if (1 == TbadkCoreApplication.getInst().getSkinType() || 4 == TbadkCoreApplication.getInst().getSkinType()) {
            this.jTq.setImageResource(R.drawable.icon_topic_triangle_up_normal_1);
            this.jTq.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector_1);
        } else {
            this.jTq.setImageResource(R.drawable.icon_topic_triangle_up_normal);
            this.jTq.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector);
        }
        this.jTt.setDrawBottomLine(false);
        this.jTs.setVisibility(8);
    }

    public void cNI() {
        this.jTw = true;
        if (this.jTr != null) {
            this.jTr.clearAnimation();
            this.jTr.startAnimation(getOutAnimation());
        }
        if (1 == TbadkCoreApplication.getInst().getSkinType() || 4 == TbadkCoreApplication.getInst().getSkinType()) {
            this.jTq.setImageResource(R.drawable.icon_topic_triangle_down_normal_1);
            this.jTq.setBackgroundResource(R.drawable.rec_topic_btn_more_selector_1);
        } else {
            this.jTq.setImageResource(R.drawable.icon_topic_triangle_down_normal);
            this.jTq.setBackgroundResource(R.drawable.rec_topic_btn_more_selector);
        }
        this.jTt.setDrawBottomLine(true);
        this.jTs.setVisibility(0);
    }

    private Animation getInAnimation() {
        if (this.jTu == null) {
            this.jTu = AnimationUtils.loadAnimation(this.mContext, R.anim.fade_in);
            this.jTu.setAnimationListener(this.jTx);
        }
        return this.jTu;
    }

    private Animation getOutAnimation() {
        if (this.jTv == null) {
            this.jTv = AnimationUtils.loadAnimation(this.mContext, R.anim.fade_out);
            this.jTv.setAnimationListener(this.jTx);
        }
        return this.jTv;
    }

    public void setVisibility(int i) {
        if (this.rootView != null) {
            this.rootView.setVisibility(i);
        }
    }
}
