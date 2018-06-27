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
    protected LinearLayout aIs;
    protected TextView aIt;
    protected TextView aIu;
    private boolean aIw;
    private View aIx;
    protected ImageView aIy;
    private View mBottomLine;
    protected Context mContext;

    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aIw = true;
        this.mContext = context;
        FV();
        c(attributeSet);
    }

    public TbSettingTextTipView(Context context) {
        super(context);
        this.aIw = true;
        this.mContext = context;
        FV();
    }

    public void displayTip() {
        if (this.aIu != null) {
            this.aIu.setVisibility(0);
        }
    }

    public void setTipColor(int i) {
        if (this.aIu != null) {
            this.aIu.setTextColor(i);
        }
    }

    public void setTipStyle(int i) {
        if (this.aIu != null) {
        }
    }

    public void g(int i, int i2, int i3, int i4) {
        if (this.aIu != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(i, i2, i3, i4);
            this.aIu.setLayoutParams(layoutParams);
        }
    }

    public void recycle() {
    }

    public void hideArrow() {
        this.aIy.setVisibility(8);
    }

    public void setText(String str) {
        this.aIt.setText(str);
    }

    public void setText(int i) {
        this.aIt.setText(i);
    }

    public void setTip(String str) {
        this.aIu.setText(str);
    }

    public CharSequence getTip() {
        return this.aIu.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.aIu.setBackgroundDrawable(drawable);
    }

    protected void FV() {
        LayoutInflater.from(this.mContext).inflate(d.i.tb_setting_text_tip_view, (ViewGroup) this, true);
        this.aIs = (LinearLayout) findViewById(d.g.container);
        this.aIt = (TextView) findViewById(d.g.text);
        this.aIu = (TextView) findViewById(d.g.tip);
        this.aIy = (ImageView) findViewById(d.g.arrow2);
        this.mBottomLine = findViewById(d.g.bottom_line_ll);
        this.aIx = findViewById(d.g.top_line_ll);
    }

    protected void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.m.TbSettingView);
        if (obtainStyledAttributes != null) {
            String string = obtainStyledAttributes.getString(d.m.TbSettingView_settingText);
            String string2 = obtainStyledAttributes.getString(d.m.TbSettingView_settingTip);
            if (string != null) {
                this.aIt.setText(string);
            }
            if (string2 != null) {
                this.aIu.setText(string2);
            }
            this.aIw = obtainStyledAttributes.getBoolean(d.m.TbSettingView_settingShowArraw, true);
            obtainStyledAttributes.recycle();
        }
        this.aIs.setClickable(false);
        this.aIs.setFocusable(false);
        if (!this.aIw) {
            this.aIy.setVisibility(4);
        }
    }

    public void setTopLineVisibility(boolean z) {
        if (z) {
            this.aIx.setVisibility(0);
        } else {
            this.aIx.setVisibility(8);
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
        this.aIt.setTextSize(0, f);
    }

    private void setTipTextSize(float f) {
        this.aIu.setTextSize(0, f);
    }

    public void FW() {
        int e = l.e(this.mContext, d.e.tbds42);
        int e2 = l.e(this.mContext, d.e.tbds33);
        setMainTextSize(e);
        setTipTextSize(e2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aIt.getLayoutParams();
        layoutParams.setMargins(layoutParams.leftMargin, 0, layoutParams.rightMargin, 0);
        ((LinearLayout.LayoutParams) this.aIu.getLayoutParams()).setMargins(0, 0, l.e(this.mContext, d.e.tbds18), 0);
        this.aIs.getLayoutParams().height = -1;
        requestLayout();
    }
}
