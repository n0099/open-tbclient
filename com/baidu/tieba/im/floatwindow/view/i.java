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
    private HeadImageView aHa;
    private TextView aYP;
    private RelativeLayout aZN;
    private ImageView aZO;
    private TranslateAnimation aZP;
    private TranslateAnimation aZQ;
    private int aZR;
    private ao aZU;
    private final int index;
    private boolean aZS = false;
    private m aZT = new j(this);
    private Point aYQ = new Point();

    public i(RelativeLayout relativeLayout, int i) {
        this.index = i;
        this.aZN = relativeLayout;
        this.aHa = (HeadImageView) relativeLayout.findViewById(com.baidu.tieba.w.im_floating_head_view);
        this.aYP = (TextView) relativeLayout.findViewById(com.baidu.tieba.w.im_floating_unread_view);
        this.aZO = (ImageView) relativeLayout.findViewById(com.baidu.tieba.w.im_floating_arrow);
        this.aHa.setAutoChangeStyle(false);
        this.aHa.setIsRound(true);
        this.aHa.setTag(Integer.valueOf(i));
        this.aHa.setOnLongClickListener(new k(this));
        this.aHa.setOnTouchListener(new l(this));
    }

    public void a(ao aoVar) {
        this.aZU = aoVar;
    }

    public boolean d(Animation animation) {
        return this.aZQ == animation;
    }

    public void a(com.baidu.adp.lib.g.e eVar) {
        if (this.aZN.getVisibility() == 0) {
            this.aZP = new TranslateAnimation(NY(), 0.0f, 0.0f, 0.0f);
            this.aZP.setDuration(300L);
            if (eVar != null) {
                this.aZP.setAnimationListener(eVar);
            }
            this.aZN.startAnimation(this.aZP);
        }
    }

    private int NY() {
        int[] iArr = new int[2];
        this.aZN.getLocationInWindow(iArr);
        int M = com.baidu.adp.lib.util.l.M(TbadkCoreApplication.m255getInst());
        return ((M - iArr[0]) - this.aZN.getMeasuredWidth()) - com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.m255getInst(), 10.0f);
    }

    public void b(com.baidu.adp.lib.g.e eVar) {
        if (this.aZN.getVisibility() == 0) {
            this.aZQ = new TranslateAnimation(0.0f, NY(), 0.0f, 0.0f);
            this.aZQ.setDuration(300L);
            if (eVar != null) {
                this.aZQ.setAnimationListener(eVar);
            }
            this.aZN.startAnimation(this.aZQ);
        }
    }

    public void NZ() {
        TranslateAnimation translateAnimation = new TranslateAnimation(this.aZN.getMeasuredWidth(), 0.0f, 0.0f, 0.0f);
        translateAnimation.setDuration(300L);
        this.aZN.startAnimation(translateAnimation);
    }

    public void Oa() {
        TranslateAnimation translateAnimation = new TranslateAnimation(-this.aZN.getMeasuredWidth(), 0.0f, 0.0f, 0.0f);
        translateAnimation.setDuration(300L);
        this.aZN.startAnimation(translateAnimation);
    }

    public void a(boolean z, UserData userData, int i) {
        if (z && userData != null) {
            this.aZR = userData.getConcern_num();
            fN(userData.getConcern_num());
            this.aHa.d(userData.getPortrait(), 12, false);
            this.aHa.setUrl(userData.getPortrait());
            if (i == this.index) {
                this.aZO.setVisibility(0);
            } else {
                this.aZO.setVisibility(8);
            }
            this.aZN.setVisibility(0);
            return;
        }
        this.aZN.setVisibility(8);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.aHa.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fN(int i) {
        int i2;
        if (!this.aZS) {
            if (i <= 0) {
                this.aYP.setVisibility(8);
                return;
            }
            this.aYP.setVisibility(0);
            if (i < 10) {
                this.aYP.setText(String.valueOf(i));
                i2 = com.baidu.tieba.v.icon_news_head_prompt_one;
            } else if (i < 100) {
                this.aYP.setText(String.valueOf(i));
                i2 = com.baidu.tieba.v.icon_news_head_prompt_two;
            } else {
                this.aYP.setText("   ");
                i2 = com.baidu.tieba.v.icon_news_head_prompt_more;
            }
            this.aYP.setBackgroundResource(i2);
        }
    }
}
