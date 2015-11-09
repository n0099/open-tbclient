package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class TbSettingTextTipView extends FrameLayout {
    protected TextView alV;
    protected TextView alW;
    private boolean alY;
    protected ImageView alZ;
    protected LinearLayout container;
    protected Context mContext;

    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.alY = true;
        this.mContext = context;
        zn();
        c(attributeSet);
    }

    public TbSettingTextTipView(Context context) {
        super(context);
        this.alY = true;
        this.mContext = context;
        zn();
    }

    public void displayTip() {
        if (this.alW != null) {
            this.alW.setVisibility(0);
        }
    }

    public void setTipColor(int i) {
        if (this.alW != null) {
            this.alW.setTextColor(i);
        }
    }

    public void setTipStyle(int i) {
    }

    public void h(int i, int i2, int i3, int i4) {
        if (this.alW != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(i, i2, i3, i4);
            this.alW.setLayoutParams(layoutParams);
        }
    }

    public void recycle() {
    }

    public void hideArrow() {
        this.alZ.setVisibility(8);
    }

    public void setText(String str) {
        this.alV.setText(str);
    }

    public void setText(int i) {
        this.alV.setText(i);
    }

    public void setTip(String str) {
        this.alW.setText(str);
    }

    public CharSequence getTip() {
        return this.alW.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.alW.setBackgroundDrawable(drawable);
    }

    protected void zn() {
        LayoutInflater.from(this.mContext).inflate(i.g.tb_setting_text_tip_view, (ViewGroup) this, true);
        this.container = (LinearLayout) findViewById(i.f.container);
        this.alV = (TextView) findViewById(i.f.text);
        this.alW = (TextView) findViewById(i.f.tip);
        this.alZ = (ImageView) findViewById(i.f.arrow2);
    }

    protected void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, i.j.TbSettingView);
        if (obtainStyledAttributes != null) {
            String string = obtainStyledAttributes.getString(0);
            String string2 = obtainStyledAttributes.getString(3);
            if (string != null) {
                this.alV.setText(string);
            }
            if (string2 != null) {
                this.alW.setText(string2);
            }
            this.alY = obtainStyledAttributes.getBoolean(5, true);
            obtainStyledAttributes.recycle();
        }
        this.container.setClickable(false);
        this.container.setFocusable(false);
        if (!this.alY) {
            this.alZ.setVisibility(4);
        }
    }
}
