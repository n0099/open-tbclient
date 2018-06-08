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
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class TbSettingTextTipView extends FrameLayout {
    private View aHA;
    protected ImageView aHB;
    protected LinearLayout aHv;
    protected TextView aHw;
    protected TextView aHx;
    private boolean aHz;
    private View mBottomLine;
    protected Context mContext;

    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aHz = true;
        this.mContext = context;
        FD();
        c(attributeSet);
    }

    public TbSettingTextTipView(Context context) {
        super(context);
        this.aHz = true;
        this.mContext = context;
        FD();
    }

    public void displayTip() {
        if (this.aHx != null) {
            this.aHx.setVisibility(0);
        }
    }

    public void setTipColor(int i) {
        if (this.aHx != null) {
            this.aHx.setTextColor(i);
        }
    }

    public void setTipStyle(int i) {
        if (this.aHx != null) {
        }
    }

    public void g(int i, int i2, int i3, int i4) {
        if (this.aHx != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(i, i2, i3, i4);
            this.aHx.setLayoutParams(layoutParams);
        }
    }

    public void recycle() {
    }

    public void hideArrow() {
        this.aHB.setVisibility(8);
    }

    public void setText(String str) {
        this.aHw.setText(str);
    }

    public void setText(int i) {
        this.aHw.setText(i);
    }

    public void setTip(String str) {
        this.aHx.setText(str);
    }

    public CharSequence getTip() {
        return this.aHx.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.aHx.setBackgroundDrawable(drawable);
    }

    protected void FD() {
        LayoutInflater.from(this.mContext).inflate(d.i.tb_setting_text_tip_view, (ViewGroup) this, true);
        this.aHv = (LinearLayout) findViewById(d.g.container);
        this.aHw = (TextView) findViewById(d.g.text);
        this.aHx = (TextView) findViewById(d.g.tip);
        this.aHB = (ImageView) findViewById(d.g.arrow2);
        this.mBottomLine = findViewById(d.g.bottom_line_ll);
        this.aHA = findViewById(d.g.top_line_ll);
    }

    protected void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.m.TbSettingView);
        if (obtainStyledAttributes != null) {
            String string = obtainStyledAttributes.getString(d.m.TbSettingView_settingText);
            String string2 = obtainStyledAttributes.getString(d.m.TbSettingView_settingTip);
            if (string != null) {
                this.aHw.setText(string);
            }
            if (string2 != null) {
                this.aHx.setText(string2);
            }
            this.aHz = obtainStyledAttributes.getBoolean(d.m.TbSettingView_settingShowArraw, true);
            obtainStyledAttributes.recycle();
        }
        this.aHv.setClickable(false);
        this.aHv.setFocusable(false);
        if (!this.aHz) {
            this.aHB.setVisibility(4);
        }
    }

    public void setTopLineVisibility(boolean z) {
        if (z) {
            this.aHA.setVisibility(0);
        } else {
            this.aHA.setVisibility(8);
        }
    }

    public void setBottomLineVisibility(boolean z) {
        if (z) {
            this.mBottomLine.setVisibility(0);
        } else {
            this.mBottomLine.setVisibility(8);
        }
    }

    private void setMainTextSize(float f) {
        this.aHw.setTextSize(0, f);
    }

    private void setTipTextSize(float f) {
        this.aHx.setTextSize(0, f);
    }

    public void FE() {
        int e = l.e(this.mContext, d.e.tbds42);
        int e2 = l.e(this.mContext, d.e.tbds33);
        setMainTextSize(e);
        setTipTextSize(e2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aHw.getLayoutParams();
        layoutParams.setMargins(layoutParams.leftMargin, 0, layoutParams.rightMargin, 0);
        ((LinearLayout.LayoutParams) this.aHx.getLayoutParams()).setMargins(0, 0, l.e(this.mContext, d.e.tbds18), 0);
        this.aHv.getLayoutParams().height = -1;
        requestLayout();
    }
}
