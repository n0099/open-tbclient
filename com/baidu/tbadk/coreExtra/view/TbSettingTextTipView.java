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
    protected LinearLayout Pc;
    protected TextView Pd;
    protected TextView Pe;
    private boolean Pg;
    protected ImageView Ph;
    protected Context mContext;

    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Pg = true;
        this.mContext = context;
        qm();
        c(attributeSet);
    }

    public TbSettingTextTipView(Context context) {
        super(context);
        this.Pg = true;
        this.mContext = context;
        qm();
    }

    public void qj() {
        if (this.Pe != null) {
            this.Pe.setVisibility(0);
        }
    }

    public void qk() {
        if (this.Pe != null) {
            this.Pe.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.Pe != null) {
            this.Pe.setTextColor(i);
        }
    }

    public void setTipStyle(int i) {
    }

    public void recycle() {
    }

    public void ql() {
        this.Ph.setVisibility(8);
    }

    public void setText(String str) {
        this.Pd.setText(str);
    }

    public void setText(int i) {
        this.Pd.setText(i);
    }

    public void setTip(String str) {
        this.Pe.setText(str);
    }

    public CharSequence getTip() {
        return this.Pe.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.Pe.setBackgroundDrawable(drawable);
    }

    protected void qm() {
        com.baidu.adp.lib.g.b.ek().a(this.mContext, com.baidu.tieba.w.tb_setting_text_tip_view, this, true);
        this.Pc = (LinearLayout) findViewById(com.baidu.tieba.v.container);
        this.Pd = (TextView) findViewById(com.baidu.tieba.v.text);
        this.Pe = (TextView) findViewById(com.baidu.tieba.v.tip);
        this.Ph = (ImageView) findViewById(com.baidu.tieba.v.arrow2);
    }

    protected void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, com.baidu.tieba.aa.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        String string2 = obtainStyledAttributes.getString(3);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (string != null) {
            this.Pd.setText(string);
        }
        if (color > -1) {
            this.Pd.setTextColor(color);
        }
        if (string2 != null) {
            this.Pe.setText(string2);
        }
        if (color2 > -1) {
            this.Pe.setTextColor(color2);
        }
        this.Pg = obtainStyledAttributes.getBoolean(5, true);
        obtainStyledAttributes.recycle();
        this.Pc.setClickable(false);
        this.Pc.setFocusable(false);
        if (!this.Pg) {
            this.Ph.setVisibility(4);
        }
    }
}
