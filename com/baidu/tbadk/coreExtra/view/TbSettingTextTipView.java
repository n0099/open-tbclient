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
    protected LinearLayout Pg;
    protected TextView Ph;
    protected TextView Pi;
    private boolean Pk;
    protected ImageView Pl;
    protected Context mContext;

    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Pk = true;
        this.mContext = context;
        qo();
        c(attributeSet);
    }

    public TbSettingTextTipView(Context context) {
        super(context);
        this.Pk = true;
        this.mContext = context;
        qo();
    }

    public void ql() {
        if (this.Pi != null) {
            this.Pi.setVisibility(0);
        }
    }

    public void qm() {
        if (this.Pi != null) {
            this.Pi.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.Pi != null) {
            this.Pi.setTextColor(i);
        }
    }

    public void setTipStyle(int i) {
    }

    public void recycle() {
    }

    public void qn() {
        this.Pl.setVisibility(8);
    }

    public void setText(String str) {
        this.Ph.setText(str);
    }

    public void setText(int i) {
        this.Ph.setText(i);
    }

    public void setTip(String str) {
        this.Pi.setText(str);
    }

    public CharSequence getTip() {
        return this.Pi.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.Pi.setBackgroundDrawable(drawable);
    }

    protected void qo() {
        com.baidu.adp.lib.g.b.ek().a(this.mContext, com.baidu.tieba.w.tb_setting_text_tip_view, this, true);
        this.Pg = (LinearLayout) findViewById(com.baidu.tieba.v.container);
        this.Ph = (TextView) findViewById(com.baidu.tieba.v.text);
        this.Pi = (TextView) findViewById(com.baidu.tieba.v.tip);
        this.Pl = (ImageView) findViewById(com.baidu.tieba.v.arrow2);
    }

    protected void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, com.baidu.tieba.aa.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        String string2 = obtainStyledAttributes.getString(3);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (string != null) {
            this.Ph.setText(string);
        }
        if (color > -1) {
            this.Ph.setTextColor(color);
        }
        if (string2 != null) {
            this.Pi.setText(string2);
        }
        if (color2 > -1) {
            this.Pi.setTextColor(color2);
        }
        this.Pk = obtainStyledAttributes.getBoolean(5, true);
        obtainStyledAttributes.recycle();
        this.Pg.setClickable(false);
        this.Pg.setFocusable(false);
        if (!this.Pk) {
            this.Pl.setVisibility(4);
        }
    }
}
