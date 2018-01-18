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
    protected LinearLayout bmo;
    protected TextView bmp;
    protected TextView bmq;
    private boolean bms;
    private View bmt;
    protected ImageView bmu;
    private View mBottomLine;
    protected Context mContext;

    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bms = true;
        this.mContext = context;
        IO();
        d(attributeSet);
    }

    public TbSettingTextTipView(Context context) {
        super(context);
        this.bms = true;
        this.mContext = context;
        IO();
    }

    public void displayTip() {
        if (this.bmq != null) {
            this.bmq.setVisibility(0);
        }
    }

    public void setTipColor(int i) {
        if (this.bmq != null) {
            this.bmq.setTextColor(i);
        }
    }

    public void setTipStyle(int i) {
        if (this.bmq != null) {
        }
    }

    public void o(int i, int i2, int i3, int i4) {
        if (this.bmq != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(i, i2, i3, i4);
            this.bmq.setLayoutParams(layoutParams);
        }
    }

    public void recycle() {
    }

    public void hideArrow() {
        this.bmu.setVisibility(8);
    }

    public void setText(String str) {
        this.bmp.setText(str);
    }

    public void setText(int i) {
        this.bmp.setText(i);
    }

    public void setTip(String str) {
        this.bmq.setText(str);
    }

    public CharSequence getTip() {
        return this.bmq.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.bmq.setBackgroundDrawable(drawable);
    }

    protected void IO() {
        LayoutInflater.from(this.mContext).inflate(d.h.tb_setting_text_tip_view, (ViewGroup) this, true);
        this.bmo = (LinearLayout) findViewById(d.g.container);
        this.bmp = (TextView) findViewById(d.g.text);
        this.bmq = (TextView) findViewById(d.g.tip);
        this.bmu = (ImageView) findViewById(d.g.arrow2);
        this.mBottomLine = findViewById(d.g.bottom_line_ll);
        this.bmt = findViewById(d.g.top_line_ll);
    }

    protected void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.l.TbSettingView);
        if (obtainStyledAttributes != null) {
            String string = obtainStyledAttributes.getString(d.l.TbSettingView_settingText);
            String string2 = obtainStyledAttributes.getString(d.l.TbSettingView_settingTip);
            if (string != null) {
                this.bmp.setText(string);
            }
            if (string2 != null) {
                this.bmq.setText(string2);
            }
            this.bms = obtainStyledAttributes.getBoolean(d.l.TbSettingView_settingShowArraw, true);
            obtainStyledAttributes.recycle();
        }
        this.bmo.setClickable(false);
        this.bmo.setFocusable(false);
        if (!this.bms) {
            this.bmu.setVisibility(4);
        }
    }

    public void setTopLineVisibility(boolean z) {
        if (z) {
            this.bmt.setVisibility(0);
        } else {
            this.bmt.setVisibility(8);
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
