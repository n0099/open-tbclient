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
    private boolean VB;
    protected ImageView VC;
    protected LinearLayout Vx;
    protected TextView Vy;
    protected TextView Vz;
    protected Context mContext;

    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.VB = true;
        this.mContext = context;
        tY();
        c(attributeSet);
    }

    public TbSettingTextTipView(Context context) {
        super(context);
        this.VB = true;
        this.mContext = context;
        tY();
    }

    public void tV() {
        if (this.Vz != null) {
            this.Vz.setVisibility(0);
        }
    }

    public void tW() {
        if (this.Vz != null) {
            this.Vz.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.Vz != null) {
            this.Vz.setTextColor(i);
        }
    }

    public void setTipStyle(int i) {
    }

    public void recycle() {
    }

    public void tX() {
        this.VC.setVisibility(8);
    }

    public void setText(String str) {
        this.Vy.setText(str);
    }

    public void setText(int i) {
        this.Vy.setText(i);
    }

    public void setTip(String str) {
        this.Vz.setText(str);
    }

    public CharSequence getTip() {
        return this.Vz.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.Vz.setBackgroundDrawable(drawable);
    }

    protected void tY() {
        com.baidu.adp.lib.g.b.ei().a(this.mContext, com.baidu.tieba.x.tb_setting_text_tip_view, this, true);
        this.Vx = (LinearLayout) findViewById(com.baidu.tieba.w.container);
        this.Vy = (TextView) findViewById(com.baidu.tieba.w.text);
        this.Vz = (TextView) findViewById(com.baidu.tieba.w.tip);
        this.VC = (ImageView) findViewById(com.baidu.tieba.w.arrow2);
    }

    protected void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, com.baidu.tieba.ab.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        String string2 = obtainStyledAttributes.getString(3);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (string != null) {
            this.Vy.setText(string);
        }
        if (color > -1) {
            this.Vy.setTextColor(color);
        }
        if (string2 != null) {
            this.Vz.setText(string2);
        }
        if (color2 > -1) {
            this.Vz.setTextColor(color2);
        }
        this.VB = obtainStyledAttributes.getBoolean(5, true);
        obtainStyledAttributes.recycle();
        this.Vx.setClickable(false);
        this.Vx.setFocusable(false);
        if (!this.VB) {
            this.VC.setVisibility(4);
        }
    }
}
