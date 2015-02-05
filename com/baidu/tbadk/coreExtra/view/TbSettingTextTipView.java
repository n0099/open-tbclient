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
    protected LinearLayout Vu;
    protected TextView Vv;
    protected TextView Vw;
    private boolean Vy;
    protected ImageView Vz;
    protected Context mContext;

    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Vy = true;
        this.mContext = context;
        tS();
        c(attributeSet);
    }

    public TbSettingTextTipView(Context context) {
        super(context);
        this.Vy = true;
        this.mContext = context;
        tS();
    }

    public void tP() {
        if (this.Vw != null) {
            this.Vw.setVisibility(0);
        }
    }

    public void tQ() {
        if (this.Vw != null) {
            this.Vw.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.Vw != null) {
            this.Vw.setTextColor(i);
        }
    }

    public void setTipStyle(int i) {
    }

    public void recycle() {
    }

    public void tR() {
        this.Vz.setVisibility(8);
    }

    public void setText(String str) {
        this.Vv.setText(str);
    }

    public void setText(int i) {
        this.Vv.setText(i);
    }

    public void setTip(String str) {
        this.Vw.setText(str);
    }

    public CharSequence getTip() {
        return this.Vw.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.Vw.setBackgroundDrawable(drawable);
    }

    protected void tS() {
        com.baidu.adp.lib.g.b.ei().a(this.mContext, com.baidu.tieba.x.tb_setting_text_tip_view, this, true);
        this.Vu = (LinearLayout) findViewById(com.baidu.tieba.w.container);
        this.Vv = (TextView) findViewById(com.baidu.tieba.w.text);
        this.Vw = (TextView) findViewById(com.baidu.tieba.w.tip);
        this.Vz = (ImageView) findViewById(com.baidu.tieba.w.arrow2);
    }

    protected void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, com.baidu.tieba.ab.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        String string2 = obtainStyledAttributes.getString(3);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (string != null) {
            this.Vv.setText(string);
        }
        if (color > -1) {
            this.Vv.setTextColor(color);
        }
        if (string2 != null) {
            this.Vw.setText(string2);
        }
        if (color2 > -1) {
            this.Vw.setTextColor(color2);
        }
        this.Vy = obtainStyledAttributes.getBoolean(5, true);
        obtainStyledAttributes.recycle();
        this.Vu.setClickable(false);
        this.Vu.setFocusable(false);
        if (!this.Vy) {
            this.Vz.setVisibility(4);
        }
    }
}
