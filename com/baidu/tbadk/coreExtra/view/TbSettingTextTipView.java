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
    protected LinearLayout aza;
    protected TextView azb;
    protected TextView azc;
    private boolean aze;
    private View azf;
    protected ImageView azg;
    private View mBottomLine;
    protected Context mContext;

    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aze = true;
        this.mContext = context;
        Ca();
        c(attributeSet);
    }

    public TbSettingTextTipView(Context context) {
        super(context);
        this.aze = true;
        this.mContext = context;
        Ca();
    }

    public void displayTip() {
        if (this.azc != null) {
            this.azc.setVisibility(0);
        }
    }

    public void setTipColor(int i) {
        if (this.azc != null) {
            this.azc.setTextColor(i);
        }
    }

    public void setTipStyle(int i) {
        if (this.azc != null) {
        }
    }

    public void g(int i, int i2, int i3, int i4) {
        if (this.azc != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(i, i2, i3, i4);
            this.azc.setLayoutParams(layoutParams);
        }
    }

    public void recycle() {
    }

    public void hideArrow() {
        this.azg.setVisibility(8);
    }

    public void setText(String str) {
        this.azb.setText(str);
    }

    public void setText(int i) {
        this.azb.setText(i);
    }

    public void setTip(String str) {
        this.azc.setText(str);
    }

    public CharSequence getTip() {
        return this.azc.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.azc.setBackgroundDrawable(drawable);
    }

    protected void Ca() {
        LayoutInflater.from(this.mContext).inflate(d.i.tb_setting_text_tip_view, (ViewGroup) this, true);
        this.aza = (LinearLayout) findViewById(d.g.container);
        this.azb = (TextView) findViewById(d.g.text);
        this.azc = (TextView) findViewById(d.g.tip);
        this.azg = (ImageView) findViewById(d.g.arrow2);
        this.mBottomLine = findViewById(d.g.bottom_line_ll);
        this.azf = findViewById(d.g.top_line_ll);
    }

    protected void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.m.TbSettingView);
        if (obtainStyledAttributes != null) {
            String string = obtainStyledAttributes.getString(d.m.TbSettingView_settingText);
            String string2 = obtainStyledAttributes.getString(d.m.TbSettingView_settingTip);
            if (string != null) {
                this.azb.setText(string);
            }
            if (string2 != null) {
                this.azc.setText(string2);
            }
            this.aze = obtainStyledAttributes.getBoolean(d.m.TbSettingView_settingShowArraw, true);
            obtainStyledAttributes.recycle();
        }
        this.aza.setClickable(false);
        this.aza.setFocusable(false);
        if (!this.aze) {
            this.azg.setVisibility(4);
        }
    }

    public void setTopLineVisibility(boolean z) {
        if (z) {
            this.azf.setVisibility(0);
        } else {
            this.azf.setVisibility(8);
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
        this.azb.setTextSize(0, f);
    }

    private void setTipTextSize(float f) {
        this.azc.setTextSize(0, f);
    }

    public void Cb() {
        int e = l.e(this.mContext, d.e.tbds42);
        int e2 = l.e(this.mContext, d.e.tbds33);
        setMainTextSize(e);
        setTipTextSize(e2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.azb.getLayoutParams();
        layoutParams.setMargins(layoutParams.leftMargin, 0, layoutParams.rightMargin, 0);
        ((LinearLayout.LayoutParams) this.azc.getLayoutParams()).setMargins(0, 0, l.e(this.mContext, d.e.tbds18), 0);
        this.aza.getLayoutParams().height = -1;
        requestLayout();
    }
}
