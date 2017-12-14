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
    protected LinearLayout axX;
    protected TextView axY;
    protected TextView axZ;
    private boolean ayb;
    private View ayc;
    protected ImageView ayd;
    private View mBottomLine;
    protected Context mContext;

    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ayb = true;
        this.mContext = context;
        Bx();
        b(attributeSet);
    }

    public TbSettingTextTipView(Context context) {
        super(context);
        this.ayb = true;
        this.mContext = context;
        Bx();
    }

    public void displayTip() {
        if (this.axZ != null) {
            this.axZ.setVisibility(0);
        }
    }

    public void setTipColor(int i) {
        if (this.axZ != null) {
            this.axZ.setTextColor(i);
        }
    }

    public void setTipStyle(int i) {
        if (this.axZ != null) {
        }
    }

    public void g(int i, int i2, int i3, int i4) {
        if (this.axZ != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(i, i2, i3, i4);
            this.axZ.setLayoutParams(layoutParams);
        }
    }

    public void recycle() {
    }

    public void hideArrow() {
        this.ayd.setVisibility(8);
    }

    public void setText(String str) {
        this.axY.setText(str);
    }

    public void setText(int i) {
        this.axY.setText(i);
    }

    public void setTip(String str) {
        this.axZ.setText(str);
    }

    public CharSequence getTip() {
        return this.axZ.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.axZ.setBackgroundDrawable(drawable);
    }

    protected void Bx() {
        LayoutInflater.from(this.mContext).inflate(d.h.tb_setting_text_tip_view, (ViewGroup) this, true);
        this.axX = (LinearLayout) findViewById(d.g.container);
        this.axY = (TextView) findViewById(d.g.text);
        this.axZ = (TextView) findViewById(d.g.tip);
        this.ayd = (ImageView) findViewById(d.g.arrow2);
        this.mBottomLine = findViewById(d.g.bottom_line_ll);
        this.ayc = findViewById(d.g.top_line_ll);
    }

    protected void b(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.l.TbSettingView);
        if (obtainStyledAttributes != null) {
            String string = obtainStyledAttributes.getString(d.l.TbSettingView_settingText);
            String string2 = obtainStyledAttributes.getString(d.l.TbSettingView_settingTip);
            if (string != null) {
                this.axY.setText(string);
            }
            if (string2 != null) {
                this.axZ.setText(string2);
            }
            this.ayb = obtainStyledAttributes.getBoolean(d.l.TbSettingView_settingShowArraw, true);
            obtainStyledAttributes.recycle();
        }
        this.axX.setClickable(false);
        this.axX.setFocusable(false);
        if (!this.ayb) {
            this.ayd.setVisibility(4);
        }
    }

    public void setTopLineVisibility(boolean z) {
        if (z) {
            this.ayc.setVisibility(0);
        } else {
            this.ayc.setVisibility(8);
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
