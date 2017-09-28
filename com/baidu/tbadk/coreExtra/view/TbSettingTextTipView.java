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
    protected LinearLayout awY;
    protected TextView awZ;
    protected TextView axa;
    private boolean axc;
    private View axd;
    protected ImageView axe;
    private View mBottomLine;
    protected Context mContext;

    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.axc = true;
        this.mContext = context;
        AX();
        b(attributeSet);
    }

    public TbSettingTextTipView(Context context) {
        super(context);
        this.axc = true;
        this.mContext = context;
        AX();
    }

    public void displayTip() {
        if (this.axa != null) {
            this.axa.setVisibility(0);
        }
    }

    public void setTipColor(int i) {
        if (this.axa != null) {
            this.axa.setTextColor(i);
        }
    }

    public void setTipStyle(int i) {
        if (this.axa != null) {
        }
    }

    public void g(int i, int i2, int i3, int i4) {
        if (this.axa != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(i, i2, i3, i4);
            this.axa.setLayoutParams(layoutParams);
        }
    }

    public void recycle() {
    }

    public void hideArrow() {
        this.axe.setVisibility(8);
    }

    public void setText(String str) {
        this.awZ.setText(str);
    }

    public void setText(int i) {
        this.awZ.setText(i);
    }

    public void setTip(String str) {
        this.axa.setText(str);
    }

    public CharSequence getTip() {
        return this.axa.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.axa.setBackgroundDrawable(drawable);
    }

    protected void AX() {
        LayoutInflater.from(this.mContext).inflate(d.j.tb_setting_text_tip_view, (ViewGroup) this, true);
        this.awY = (LinearLayout) findViewById(d.h.container);
        this.awZ = (TextView) findViewById(d.h.text);
        this.axa = (TextView) findViewById(d.h.tip);
        this.axe = (ImageView) findViewById(d.h.arrow2);
        this.mBottomLine = findViewById(d.h.bottom_line_ll);
        this.axd = findViewById(d.h.top_line_ll);
    }

    protected void b(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.n.TbSettingView);
        if (obtainStyledAttributes != null) {
            String string = obtainStyledAttributes.getString(d.n.TbSettingView_settingText);
            String string2 = obtainStyledAttributes.getString(d.n.TbSettingView_settingTip);
            if (string != null) {
                this.awZ.setText(string);
            }
            if (string2 != null) {
                this.axa.setText(string2);
            }
            this.axc = obtainStyledAttributes.getBoolean(d.n.TbSettingView_settingShowArraw, true);
            obtainStyledAttributes.recycle();
        }
        this.awY.setClickable(false);
        this.awY.setFocusable(false);
        if (!this.axc) {
            this.axe.setVisibility(4);
        }
    }

    public void setTopLineVisibility(boolean z) {
        if (z) {
            this.axd.setVisibility(0);
        } else {
            this.axd.setVisibility(8);
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
