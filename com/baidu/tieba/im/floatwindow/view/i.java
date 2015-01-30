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
    private HeadImageView aHd;
    private TextView aYQ;
    private RelativeLayout aZO;
    private ImageView aZP;
    private TranslateAnimation aZQ;
    private TranslateAnimation aZR;
    private int aZS;
    private ao aZV;
    private final int index;
    private boolean aZT = false;
    private m aZU = new j(this);
    private Point aYR = new Point();

    public i(RelativeLayout relativeLayout, int i) {
        this.index = i;
        this.aZO = relativeLayout;
        this.aHd = (HeadImageView) relativeLayout.findViewById(com.baidu.tieba.w.im_floating_head_view);
        this.aYQ = (TextView) relativeLayout.findViewById(com.baidu.tieba.w.im_floating_unread_view);
        this.aZP = (ImageView) relativeLayout.findViewById(com.baidu.tieba.w.im_floating_arrow);
        this.aHd.setAutoChangeStyle(false);
        this.aHd.setIsRound(true);
        this.aHd.setTag(Integer.valueOf(i));
        this.aHd.setOnLongClickListener(new k(this));
        this.aHd.setOnTouchListener(new l(this));
    }

    public void a(ao aoVar) {
        this.aZV = aoVar;
    }

    public boolean d(Animation animation) {
        return this.aZR == animation;
    }

    public void a(com.baidu.adp.lib.g.e eVar) {
        if (this.aZO.getVisibility() == 0) {
            this.aZQ = new TranslateAnimation(Od(), 0.0f, 0.0f, 0.0f);
            this.aZQ.setDuration(300L);
            if (eVar != null) {
                this.aZQ.setAnimationListener(eVar);
            }
            this.aZO.startAnimation(this.aZQ);
        }
    }

    private int Od() {
        int[] iArr = new int[2];
        this.aZO.getLocationInWindow(iArr);
        int M = com.baidu.adp.lib.util.l.M(TbadkCoreApplication.m255getInst());
        return ((M - iArr[0]) - this.aZO.getMeasuredWidth()) - com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.m255getInst(), 10.0f);
    }

    public void b(com.baidu.adp.lib.g.e eVar) {
        if (this.aZO.getVisibility() == 0) {
            this.aZR = new TranslateAnimation(0.0f, Od(), 0.0f, 0.0f);
            this.aZR.setDuration(300L);
            if (eVar != null) {
                this.aZR.setAnimationListener(eVar);
            }
            this.aZO.startAnimation(this.aZR);
        }
    }

    public void Oe() {
        TranslateAnimation translateAnimation = new TranslateAnimation(this.aZO.getMeasuredWidth(), 0.0f, 0.0f, 0.0f);
        translateAnimation.setDuration(300L);
        this.aZO.startAnimation(translateAnimation);
    }

    public void Of() {
        TranslateAnimation translateAnimation = new TranslateAnimation(-this.aZO.getMeasuredWidth(), 0.0f, 0.0f, 0.0f);
        translateAnimation.setDuration(300L);
        this.aZO.startAnimation(translateAnimation);
    }

    public void a(boolean z, UserData userData, int i) {
        if (z && userData != null) {
            this.aZS = userData.getConcern_num();
            fN(userData.getConcern_num());
            this.aHd.d(userData.getPortrait(), 12, false);
            this.aHd.setUrl(userData.getPortrait());
            if (i == this.index) {
                this.aZP.setVisibility(0);
            } else {
                this.aZP.setVisibility(8);
            }
            this.aZO.setVisibility(0);
            return;
        }
        this.aZO.setVisibility(8);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.aHd.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fN(int i) {
        int i2;
        if (!this.aZT) {
            if (i <= 0) {
                this.aYQ.setVisibility(8);
                return;
            }
            this.aYQ.setVisibility(0);
            if (i < 10) {
                this.aYQ.setText(String.valueOf(i));
                i2 = com.baidu.tieba.v.icon_news_head_prompt_one;
            } else if (i < 100) {
                this.aYQ.setText(String.valueOf(i));
                i2 = com.baidu.tieba.v.icon_news_head_prompt_two;
            } else {
                this.aYQ.setText("   ");
                i2 = com.baidu.tieba.v.icon_news_head_prompt_more;
            }
            this.aYQ.setBackgroundResource(i2);
        }
    }
}
