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
import com.baidu.tieba.f;
/* loaded from: classes.dex */
public class TbSettingTextTipView extends FrameLayout {
    protected LinearLayout aIq;
    protected TextView aIr;
    protected TextView aIs;
    private boolean aIu;
    protected ImageView aIv;
    private View mBottomLine;
    protected Context mContext;
    private View mTopLine;

    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aIu = true;
        this.mContext = context;
        FR();
        c(attributeSet);
    }

    public TbSettingTextTipView(Context context) {
        super(context);
        this.aIu = true;
        this.mContext = context;
        FR();
    }

    public void displayTip() {
        if (this.aIs != null) {
            this.aIs.setVisibility(0);
        }
    }

    public void setTipColor(int i) {
        if (this.aIs != null) {
            this.aIs.setTextColor(i);
        }
    }

    public void setTipStyle(int i) {
        if (this.aIs != null) {
        }
    }

    public void f(int i, int i2, int i3, int i4) {
        if (this.aIs != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(i, i2, i3, i4);
            this.aIs.setLayoutParams(layoutParams);
        }
    }

    public void recycle() {
    }

    public void hideArrow() {
        this.aIv.setVisibility(8);
    }

    public void setText(String str) {
        this.aIr.setText(str);
    }

    public void setText(int i) {
        this.aIr.setText(i);
    }

    public void setTip(String str) {
        this.aIs.setText(str);
    }

    public CharSequence getTip() {
        return this.aIs.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.aIs.setBackgroundDrawable(drawable);
    }

    protected void FR() {
        LayoutInflater.from(this.mContext).inflate(f.h.tb_setting_text_tip_view, (ViewGroup) this, true);
        this.aIq = (LinearLayout) findViewById(f.g.container);
        this.aIr = (TextView) findViewById(f.g.text);
        this.aIs = (TextView) findViewById(f.g.tip);
        this.aIv = (ImageView) findViewById(f.g.arrow2);
        this.mBottomLine = findViewById(f.g.bottom_line_ll);
        this.mTopLine = findViewById(f.g.top_line_ll);
    }

    protected void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, f.l.TbSettingView);
        if (obtainStyledAttributes != null) {
            String string = obtainStyledAttributes.getString(f.l.TbSettingView_settingText);
            String string2 = obtainStyledAttributes.getString(f.l.TbSettingView_settingTip);
            if (string != null) {
                this.aIr.setText(string);
            }
            if (string2 != null) {
                this.aIs.setText(string2);
            }
            this.aIu = obtainStyledAttributes.getBoolean(f.l.TbSettingView_settingShowArraw, true);
            obtainStyledAttributes.recycle();
        }
        this.aIq.setClickable(false);
        this.aIq.setFocusable(false);
        if (!this.aIu) {
            this.aIv.setVisibility(4);
        }
    }

    public void setTopLineVisibility(boolean z) {
        if (z) {
            this.mTopLine.setVisibility(0);
        } else {
            this.mTopLine.setVisibility(8);
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
        this.aIr.setTextSize(0, f);
    }

    private void setTipTextSize(float f) {
        this.aIs.setTextSize(0, f);
    }

    public void FS() {
        int f = l.f(this.mContext, f.e.tbds42);
        int f2 = l.f(this.mContext, f.e.tbds33);
        setMainTextSize(f);
        setTipTextSize(f2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aIr.getLayoutParams();
        layoutParams.setMargins(layoutParams.leftMargin, 0, layoutParams.rightMargin, 0);
        ((LinearLayout.LayoutParams) this.aIs.getLayoutParams()).setMargins(0, 0, l.f(this.mContext, f.e.tbds18), 0);
        this.aIq.getLayoutParams().height = -1;
        requestLayout();
    }
}
