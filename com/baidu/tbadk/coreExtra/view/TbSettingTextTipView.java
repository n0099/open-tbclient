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
    private boolean afA;
    protected ImageView afB;
    protected LinearLayout afw;
    protected TextView afx;
    protected TextView afy;
    protected Context mContext;

    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.afA = true;
        this.mContext = context;
        xj();
        c(attributeSet);
    }

    public TbSettingTextTipView(Context context) {
        super(context);
        this.afA = true;
        this.mContext = context;
        xj();
    }

    public void displayTip() {
        if (this.afy != null) {
            this.afy.setVisibility(0);
        }
    }

    public void setTipColor(int i) {
        if (this.afy != null) {
            this.afy.setTextColor(i);
        }
    }

    public void setTipStyle(int i) {
    }

    public void recycle() {
    }

    public void hideArrow() {
        this.afB.setVisibility(8);
    }

    public void setText(String str) {
        this.afx.setText(str);
    }

    public void setText(int i) {
        this.afx.setText(i);
    }

    public void setTip(String str) {
        this.afy.setText(str);
    }

    public CharSequence getTip() {
        return this.afy.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.afy.setBackgroundDrawable(drawable);
    }

    protected void xj() {
        com.baidu.adp.lib.g.b.hH().a(this.mContext, com.baidu.tieba.w.tb_setting_text_tip_view, this, true);
        this.afw = (LinearLayout) findViewById(com.baidu.tieba.v.container);
        this.afx = (TextView) findViewById(com.baidu.tieba.v.text);
        this.afy = (TextView) findViewById(com.baidu.tieba.v.tip);
        this.afB = (ImageView) findViewById(com.baidu.tieba.v.arrow2);
    }

    protected void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, com.baidu.tieba.aa.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        String string2 = obtainStyledAttributes.getString(3);
        if (string != null) {
            this.afx.setText(string);
        }
        if (string2 != null) {
            this.afy.setText(string2);
        }
        this.afA = obtainStyledAttributes.getBoolean(5, true);
        obtainStyledAttributes.recycle();
        this.afw.setClickable(false);
        this.afw.setFocusable(false);
        if (!this.afA) {
            this.afB.setVisibility(4);
        }
    }
}
