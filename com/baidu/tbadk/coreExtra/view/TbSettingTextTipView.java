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
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class TbSettingTextTipView extends FrameLayout {
    protected LinearLayout anA;
    protected TextView anB;
    protected TextView anC;
    private boolean anE;
    protected ImageView anF;
    protected Context mContext;

    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.anE = true;
        this.mContext = context;
        zO();
        d(attributeSet);
    }

    public TbSettingTextTipView(Context context) {
        super(context);
        this.anE = true;
        this.mContext = context;
        zO();
    }

    public void displayTip() {
        if (this.anC != null) {
            this.anC.setVisibility(0);
        }
    }

    public void setTipColor(int i) {
        if (this.anC != null) {
            this.anC.setTextColor(i);
        }
    }

    public void setTipStyle(int i) {
    }

    public void f(int i, int i2, int i3, int i4) {
        if (this.anC != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(i, i2, i3, i4);
            this.anC.setLayoutParams(layoutParams);
        }
    }

    public void recycle() {
    }

    public void hideArrow() {
        this.anF.setVisibility(8);
    }

    public void setText(String str) {
        this.anB.setText(str);
    }

    public void setText(int i) {
        this.anB.setText(i);
    }

    public void setTip(String str) {
        this.anC.setText(str);
    }

    public CharSequence getTip() {
        return this.anC.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.anC.setBackgroundDrawable(drawable);
    }

    protected void zO() {
        LayoutInflater.from(this.mContext).inflate(u.h.tb_setting_text_tip_view, (ViewGroup) this, true);
        this.anA = (LinearLayout) findViewById(u.g.container);
        this.anB = (TextView) findViewById(u.g.text);
        this.anC = (TextView) findViewById(u.g.tip);
        this.anF = (ImageView) findViewById(u.g.arrow2);
    }

    protected void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, u.l.TbSettingView);
        if (obtainStyledAttributes != null) {
            String string = obtainStyledAttributes.getString(0);
            String string2 = obtainStyledAttributes.getString(3);
            if (string != null) {
                this.anB.setText(string);
            }
            if (string2 != null) {
                this.anC.setText(string2);
            }
            this.anE = obtainStyledAttributes.getBoolean(5, true);
            obtainStyledAttributes.recycle();
        }
        this.anA.setClickable(false);
        this.anA.setFocusable(false);
        if (!this.anE) {
            this.anF.setVisibility(4);
        }
    }
}
