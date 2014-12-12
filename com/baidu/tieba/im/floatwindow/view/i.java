package com.baidu.tieba.im.floatwindow.view;

import android.graphics.Point;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
public class i {
    private HeadImageView aFT;
    private TextView aXu;
    private RelativeLayout aYs;
    private ImageView aYt;
    private TranslateAnimation aYu;
    private TranslateAnimation aYv;
    private int aYw;
    private ao aYz;
    private final int index;
    private boolean aYx = false;
    private m aYy = new j(this);
    private Point aXv = new Point();

    public i(RelativeLayout relativeLayout, int i) {
        this.index = i;
        this.aYs = relativeLayout;
        this.aFT = (HeadImageView) relativeLayout.findViewById(com.baidu.tieba.w.im_floating_head_view);
        this.aXu = (TextView) relativeLayout.findViewById(com.baidu.tieba.w.im_floating_unread_view);
        this.aYt = (ImageView) relativeLayout.findViewById(com.baidu.tieba.w.im_floating_arrow);
        this.aFT.setAutoChangeStyle(false);
        this.aFT.setIsRound(true);
        this.aFT.setTag(Integer.valueOf(i));
        this.aFT.setOnLongClickListener(new k(this));
        this.aFT.setOnTouchListener(new l(this));
    }

    public void a(ao aoVar) {
        this.aYz = aoVar;
    }

    public boolean d(Animation animation) {
        return this.aYv == animation;
    }

    public void a(com.baidu.adp.lib.g.e eVar) {
        if (this.aYs.getVisibility() == 0) {
            this.aYu = new TranslateAnimation(NH(), 0.0f, 0.0f, 0.0f);
            this.aYu.setDuration(300L);
            if (eVar != null) {
                this.aYu.setAnimationListener(eVar);
            }
            this.aYs.startAnimation(this.aYu);
        }
    }

    private int NH() {
        int[] iArr = new int[2];
        this.aYs.getLocationInWindow(iArr);
        int M = com.baidu.adp.lib.util.l.M(TbadkCoreApplication.m255getInst());
        return ((M - iArr[0]) - this.aYs.getMeasuredWidth()) - com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.m255getInst(), 10.0f);
    }

    public void b(com.baidu.adp.lib.g.e eVar) {
        if (this.aYs.getVisibility() == 0) {
            this.aYv = new TranslateAnimation(0.0f, NH(), 0.0f, 0.0f);
            this.aYv.setDuration(300L);
            if (eVar != null) {
                this.aYv.setAnimationListener(eVar);
            }
            this.aYs.startAnimation(this.aYv);
        }
    }

    public void NI() {
        TranslateAnimation translateAnimation = new TranslateAnimation(this.aYs.getMeasuredWidth(), 0.0f, 0.0f, 0.0f);
        translateAnimation.setDuration(300L);
        this.aYs.startAnimation(translateAnimation);
    }

    public void NJ() {
        TranslateAnimation translateAnimation = new TranslateAnimation(-this.aYs.getMeasuredWidth(), 0.0f, 0.0f, 0.0f);
        translateAnimation.setDuration(300L);
        this.aYs.startAnimation(translateAnimation);
    }

    public void a(boolean z, UserData userData, int i) {
        if (z && userData != null) {
            this.aYw = userData.getConcern_num();
            fI(userData.getConcern_num());
            this.aFT.d(userData.getPortrait(), 12, false);
            this.aFT.setUrl(userData.getPortrait());
            if (i == this.index) {
                this.aYt.setVisibility(0);
            } else {
                this.aYt.setVisibility(8);
            }
            this.aYs.setVisibility(0);
            return;
        }
        this.aYs.setVisibility(8);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.aFT.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fI(int i) {
        int i2;
        if (!this.aYx) {
            if (i <= 0) {
                this.aXu.setVisibility(8);
                return;
            }
            this.aXu.setVisibility(0);
            if (i < 10) {
                this.aXu.setText(String.valueOf(i));
                i2 = com.baidu.tieba.v.icon_news_head_prompt_one;
            } else if (i < 100) {
                this.aXu.setText(String.valueOf(i));
                i2 = com.baidu.tieba.v.icon_news_head_prompt_two;
            } else {
                this.aXu.setText("   ");
                i2 = com.baidu.tieba.v.icon_news_head_prompt_more;
            }
            this.aXu.setBackgroundResource(i2);
        }
    }
}
