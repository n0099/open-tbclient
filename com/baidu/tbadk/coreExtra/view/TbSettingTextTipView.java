package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
public class TbSettingTextTipView extends FrameLayout {
    protected LinearLayout afE;
    protected TextView afF;
    protected TextView afG;
    private boolean afI;
    protected ImageView afJ;
    protected Context mContext;

    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.afI = true;
        this.mContext = context;
        xp();
        c(attributeSet);
    }

    public TbSettingTextTipView(Context context) {
        super(context);
        this.afI = true;
        this.mContext = context;
        xp();
    }

    public void displayTip() {
        if (this.afG != null) {
            this.afG.setVisibility(0);
        }
    }

    public void setTipColor(int i) {
        if (this.afG != null) {
            this.afG.setTextColor(i);
        }
    }

    public void setTipStyle(int i) {
    }

    public void recycle() {
    }

    public void hideArrow() {
        this.afJ.setVisibility(8);
    }

    public void setText(String str) {
        this.afF.setText(str);
    }

    public void setText(int i) {
        this.afF.setText(i);
    }

    public void setTip(String str) {
        this.afG.setText(str);
    }

    public CharSequence getTip() {
        return this.afG.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.afG.setBackgroundDrawable(drawable);
    }

    protected void xp() {
        com.baidu.adp.lib.g.b.hH().a(this.mContext, com.baidu.tieba.w.tb_setting_text_tip_view, this, true);
        this.afE = (LinearLayout) findViewById(com.baidu.tieba.v.container);
        this.afF = (TextView) findViewById(com.baidu.tieba.v.text);
        this.afG = (TextView) findViewById(com.baidu.tieba.v.tip);
        this.afJ = (ImageView) findViewById(com.baidu.tieba.v.arrow2);
    }

    protected void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, com.baidu.tieba.aa.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        String string2 = obtainStyledAttributes.getString(3);
        if (string != null) {
            this.afF.setText(string);
        }
        if (string2 != null) {
            this.afG.setText(string2);
        }
        this.afI = obtainStyledAttributes.getBoolean(5, true);
        obtainStyledAttributes.recycle();
        this.afE.setClickable(false);
        this.afE.setFocusable(false);
        if (!this.afI) {
            this.afJ.setVisibility(4);
        }
    }
}
