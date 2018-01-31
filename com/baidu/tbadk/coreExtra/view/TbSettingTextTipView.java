package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class TbSettingTextTipView extends FrameLayout {
    private boolean bmA;
    private View bmB;
    protected ImageView bmC;
    protected LinearLayout bmw;
    protected TextView bmx;
    protected TextView bmy;
    private View mBottomLine;
    protected Context mContext;

    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bmA = true;
        this.mContext = context;
        IQ();
        d(attributeSet);
    }

    public TbSettingTextTipView(Context context) {
        super(context);
        this.bmA = true;
        this.mContext = context;
        IQ();
    }

    public void displayTip() {
        if (this.bmy != null) {
            this.bmy.setVisibility(0);
        }
    }

    public void setTipColor(int i) {
        if (this.bmy != null) {
            this.bmy.setTextColor(i);
        }
    }

    public void setTipStyle(int i) {
        if (this.bmy != null) {
        }
    }

    public void o(int i, int i2, int i3, int i4) {
        if (this.bmy != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(i, i2, i3, i4);
            this.bmy.setLayoutParams(layoutParams);
        }
    }

    public void recycle() {
    }

    public void hideArrow() {
        this.bmC.setVisibility(8);
    }

    public void setText(String str) {
        this.bmx.setText(str);
    }

    public void setText(int i) {
        this.bmx.setText(i);
    }

    public void setTip(String str) {
        this.bmy.setText(str);
    }

    public CharSequence getTip() {
        return this.bmy.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.bmy.setBackgroundDrawable(drawable);
    }

    protected void IQ() {
        LayoutInflater.from(this.mContext).inflate(d.h.tb_setting_text_tip_view, (ViewGroup) this, true);
        this.bmw = (LinearLayout) findViewById(d.g.container);
        this.bmx = (TextView) findViewById(d.g.text);
        this.bmy = (TextView) findViewById(d.g.tip);
        this.bmC = (ImageView) findViewById(d.g.arrow2);
        this.mBottomLine = findViewById(d.g.bottom_line_ll);
        this.bmB = findViewById(d.g.top_line_ll);
    }

    protected void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.l.TbSettingView);
        if (obtainStyledAttributes != null) {
            String string = obtainStyledAttributes.getString(d.l.TbSettingView_settingText);
            String string2 = obtainStyledAttributes.getString(d.l.TbSettingView_settingTip);
            if (string != null) {
                this.bmx.setText(string);
            }
            if (string2 != null) {
                this.bmy.setText(string2);
            }
            this.bmA = obtainStyledAttributes.getBoolean(d.l.TbSettingView_settingShowArraw, true);
            obtainStyledAttributes.recycle();
        }
        this.bmw.setClickable(false);
        this.bmw.setFocusable(false);
        if (!this.bmA) {
            this.bmC.setVisibility(4);
        }
    }

    public void setTopLineVisibility(boolean z) {
        if (z) {
            this.bmB.setVisibility(0);
        } else {
            this.bmB.setVisibility(8);
        }
    }

    public void setBottomLineVisibility(boolean z) {
        if (z) {
            this.mBottomLine.setVisibility(0);
        } else {
            this.mBottomLine.setVisibility(8);
        }
    }
}
