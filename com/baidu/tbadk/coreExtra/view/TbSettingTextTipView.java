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
    protected LinearLayout boA;
    protected TextView boB;
    protected TextView boC;
    private boolean boE;
    private View boF;
    protected ImageView boG;
    private View mBottomLine;
    protected Context mContext;

    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.boE = true;
        this.mContext = context;
        Jw();
        d(attributeSet);
    }

    public TbSettingTextTipView(Context context) {
        super(context);
        this.boE = true;
        this.mContext = context;
        Jw();
    }

    public void displayTip() {
        if (this.boC != null) {
            this.boC.setVisibility(0);
        }
    }

    public void setTipColor(int i) {
        if (this.boC != null) {
            this.boC.setTextColor(i);
        }
    }

    public void setTipStyle(int i) {
        if (this.boC != null) {
        }
    }

    public void o(int i, int i2, int i3, int i4) {
        if (this.boC != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(i, i2, i3, i4);
            this.boC.setLayoutParams(layoutParams);
        }
    }

    public void recycle() {
    }

    public void hideArrow() {
        this.boG.setVisibility(8);
    }

    public void setText(String str) {
        this.boB.setText(str);
    }

    public void setText(int i) {
        this.boB.setText(i);
    }

    public void setTip(String str) {
        this.boC.setText(str);
    }

    public CharSequence getTip() {
        return this.boC.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.boC.setBackgroundDrawable(drawable);
    }

    protected void Jw() {
        LayoutInflater.from(this.mContext).inflate(d.h.tb_setting_text_tip_view, (ViewGroup) this, true);
        this.boA = (LinearLayout) findViewById(d.g.container);
        this.boB = (TextView) findViewById(d.g.text);
        this.boC = (TextView) findViewById(d.g.tip);
        this.boG = (ImageView) findViewById(d.g.arrow2);
        this.mBottomLine = findViewById(d.g.bottom_line_ll);
        this.boF = findViewById(d.g.top_line_ll);
    }

    protected void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.l.TbSettingView);
        if (obtainStyledAttributes != null) {
            String string = obtainStyledAttributes.getString(d.l.TbSettingView_settingText);
            String string2 = obtainStyledAttributes.getString(d.l.TbSettingView_settingTip);
            if (string != null) {
                this.boB.setText(string);
            }
            if (string2 != null) {
                this.boC.setText(string2);
            }
            this.boE = obtainStyledAttributes.getBoolean(d.l.TbSettingView_settingShowArraw, true);
            obtainStyledAttributes.recycle();
        }
        this.boA.setClickable(false);
        this.boA.setFocusable(false);
        if (!this.boE) {
            this.boG.setVisibility(4);
        }
    }

    public void setTopLineVisibility(boolean z) {
        if (z) {
            this.boF.setVisibility(0);
        } else {
            this.boF.setVisibility(8);
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
        this.boB.setTextSize(0, f);
    }

    private void setTipTextSize(float f) {
        this.boC.setTextSize(0, f);
    }

    public void Jx() {
        int t = l.t(this.mContext, d.e.tbds42);
        int t2 = l.t(this.mContext, d.e.tbds33);
        setMainTextSize(t);
        setTipTextSize(t2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.boB.getLayoutParams();
        layoutParams.setMargins(layoutParams.leftMargin, 0, layoutParams.rightMargin, 0);
        ((LinearLayout.LayoutParams) this.boC.getLayoutParams()).setMargins(0, 0, l.t(this.mContext, d.e.tbds18), 0);
        this.boA.getLayoutParams().height = -1;
        requestLayout();
    }
}
