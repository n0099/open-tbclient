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
    private boolean boB;
    private View boC;
    protected ImageView boD;
    protected LinearLayout box;
    protected TextView boy;
    protected TextView boz;
    private View mBottomLine;
    protected Context mContext;

    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.boB = true;
        this.mContext = context;
        Jv();
        d(attributeSet);
    }

    public TbSettingTextTipView(Context context) {
        super(context);
        this.boB = true;
        this.mContext = context;
        Jv();
    }

    public void displayTip() {
        if (this.boz != null) {
            this.boz.setVisibility(0);
        }
    }

    public void setTipColor(int i) {
        if (this.boz != null) {
            this.boz.setTextColor(i);
        }
    }

    public void setTipStyle(int i) {
        if (this.boz != null) {
        }
    }

    public void o(int i, int i2, int i3, int i4) {
        if (this.boz != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(i, i2, i3, i4);
            this.boz.setLayoutParams(layoutParams);
        }
    }

    public void recycle() {
    }

    public void hideArrow() {
        this.boD.setVisibility(8);
    }

    public void setText(String str) {
        this.boy.setText(str);
    }

    public void setText(int i) {
        this.boy.setText(i);
    }

    public void setTip(String str) {
        this.boz.setText(str);
    }

    public CharSequence getTip() {
        return this.boz.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.boz.setBackgroundDrawable(drawable);
    }

    protected void Jv() {
        LayoutInflater.from(this.mContext).inflate(d.h.tb_setting_text_tip_view, (ViewGroup) this, true);
        this.box = (LinearLayout) findViewById(d.g.container);
        this.boy = (TextView) findViewById(d.g.text);
        this.boz = (TextView) findViewById(d.g.tip);
        this.boD = (ImageView) findViewById(d.g.arrow2);
        this.mBottomLine = findViewById(d.g.bottom_line_ll);
        this.boC = findViewById(d.g.top_line_ll);
    }

    protected void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.l.TbSettingView);
        if (obtainStyledAttributes != null) {
            String string = obtainStyledAttributes.getString(d.l.TbSettingView_settingText);
            String string2 = obtainStyledAttributes.getString(d.l.TbSettingView_settingTip);
            if (string != null) {
                this.boy.setText(string);
            }
            if (string2 != null) {
                this.boz.setText(string2);
            }
            this.boB = obtainStyledAttributes.getBoolean(d.l.TbSettingView_settingShowArraw, true);
            obtainStyledAttributes.recycle();
        }
        this.box.setClickable(false);
        this.box.setFocusable(false);
        if (!this.boB) {
            this.boD.setVisibility(4);
        }
    }

    public void setTopLineVisibility(boolean z) {
        if (z) {
            this.boC.setVisibility(0);
        } else {
            this.boC.setVisibility(8);
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
        this.boy.setTextSize(0, f);
    }

    private void setTipTextSize(float f) {
        this.boz.setTextSize(0, f);
    }

    public void Jw() {
        int t = l.t(this.mContext, d.e.tbds42);
        int t2 = l.t(this.mContext, d.e.tbds33);
        setMainTextSize(t);
        setTipTextSize(t2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.boy.getLayoutParams();
        layoutParams.setMargins(layoutParams.leftMargin, 0, layoutParams.rightMargin, 0);
        ((LinearLayout.LayoutParams) this.boz.getLayoutParams()).setMargins(0, 0, l.t(this.mContext, d.e.tbds18), 0);
        this.box.getLayoutParams().height = -1;
        requestLayout();
    }
}
