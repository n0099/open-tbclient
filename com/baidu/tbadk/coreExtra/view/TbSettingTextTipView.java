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
    protected TextView alQ;
    protected TextView alR;
    private boolean alT;
    protected ImageView alU;
    protected LinearLayout container;
    protected Context mContext;

    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.alT = true;
        this.mContext = context;
        zl();
        c(attributeSet);
    }

    public TbSettingTextTipView(Context context) {
        super(context);
        this.alT = true;
        this.mContext = context;
        zl();
    }

    public void displayTip() {
        if (this.alR != null) {
            this.alR.setVisibility(0);
        }
    }

    public void setTipColor(int i) {
        if (this.alR != null) {
            this.alR.setTextColor(i);
        }
    }

    public void setTipStyle(int i) {
    }

    public void h(int i, int i2, int i3, int i4) {
        if (this.alR != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(i, i2, i3, i4);
            this.alR.setLayoutParams(layoutParams);
        }
    }

    public void recycle() {
    }

    public void hideArrow() {
        this.alU.setVisibility(8);
    }

    public void setText(String str) {
        this.alQ.setText(str);
    }

    public void setText(int i) {
        this.alQ.setText(i);
    }

    public void setTip(String str) {
        this.alR.setText(str);
    }

    public CharSequence getTip() {
        return this.alR.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.alR.setBackgroundDrawable(drawable);
    }

    protected void zl() {
        LayoutInflater.from(this.mContext).inflate(i.g.tb_setting_text_tip_view, (ViewGroup) this, true);
        this.container = (LinearLayout) findViewById(i.f.container);
        this.alQ = (TextView) findViewById(i.f.text);
        this.alR = (TextView) findViewById(i.f.tip);
        this.alU = (ImageView) findViewById(i.f.arrow2);
    }

    protected void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, i.j.TbSettingView);
        if (obtainStyledAttributes != null) {
            String string = obtainStyledAttributes.getString(0);
            String string2 = obtainStyledAttributes.getString(3);
            if (string != null) {
                this.alQ.setText(string);
            }
            if (string2 != null) {
                this.alR.setText(string2);
            }
            this.alT = obtainStyledAttributes.getBoolean(5, true);
            obtainStyledAttributes.recycle();
        }
        this.container.setClickable(false);
        this.container.setFocusable(false);
        if (!this.alT) {
            this.alU.setVisibility(4);
        }
    }
}
