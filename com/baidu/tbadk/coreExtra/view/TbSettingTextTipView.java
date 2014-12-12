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
    protected LinearLayout US;
    protected TextView UT;
    protected TextView UU;
    private boolean UW;
    protected ImageView UX;
    protected Context mContext;

    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.UW = true;
        this.mContext = context;
        tH();
        c(attributeSet);
    }

    public TbSettingTextTipView(Context context) {
        super(context);
        this.UW = true;
        this.mContext = context;
        tH();
    }

    public void tE() {
        if (this.UU != null) {
            this.UU.setVisibility(0);
        }
    }

    public void tF() {
        if (this.UU != null) {
            this.UU.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.UU != null) {
            this.UU.setTextColor(i);
        }
    }

    public void setTipStyle(int i) {
    }

    public void recycle() {
    }

    public void tG() {
        this.UX.setVisibility(8);
    }

    public void setText(String str) {
        this.UT.setText(str);
    }

    public void setText(int i) {
        this.UT.setText(i);
    }

    public void setTip(String str) {
        this.UU.setText(str);
    }

    public CharSequence getTip() {
        return this.UU.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.UU.setBackgroundDrawable(drawable);
    }

    protected void tH() {
        com.baidu.adp.lib.g.b.ek().a(this.mContext, com.baidu.tieba.x.tb_setting_text_tip_view, this, true);
        this.US = (LinearLayout) findViewById(com.baidu.tieba.w.container);
        this.UT = (TextView) findViewById(com.baidu.tieba.w.text);
        this.UU = (TextView) findViewById(com.baidu.tieba.w.tip);
        this.UX = (ImageView) findViewById(com.baidu.tieba.w.arrow2);
    }

    protected void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, com.baidu.tieba.ab.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        String string2 = obtainStyledAttributes.getString(3);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (string != null) {
            this.UT.setText(string);
        }
        if (color > -1) {
            this.UT.setTextColor(color);
        }
        if (string2 != null) {
            this.UU.setText(string2);
        }
        if (color2 > -1) {
            this.UU.setTextColor(color2);
        }
        this.UW = obtainStyledAttributes.getBoolean(5, true);
        obtainStyledAttributes.recycle();
        this.US.setClickable(false);
        this.US.setFocusable(false);
        if (!this.UW) {
            this.UX.setVisibility(4);
        }
    }
}
