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
    protected LinearLayout aya;
    protected TextView ayb;
    protected TextView ayc;
    private boolean aye;
    private View ayf;
    protected ImageView ayg;
    private View mBottomLine;
    protected Context mContext;

    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aye = true;
        this.mContext = context;
        Bx();
        b(attributeSet);
    }

    public TbSettingTextTipView(Context context) {
        super(context);
        this.aye = true;
        this.mContext = context;
        Bx();
    }

    public void displayTip() {
        if (this.ayc != null) {
            this.ayc.setVisibility(0);
        }
    }

    public void setTipColor(int i) {
        if (this.ayc != null) {
            this.ayc.setTextColor(i);
        }
    }

    public void setTipStyle(int i) {
        if (this.ayc != null) {
        }
    }

    public void g(int i, int i2, int i3, int i4) {
        if (this.ayc != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(i, i2, i3, i4);
            this.ayc.setLayoutParams(layoutParams);
        }
    }

    public void recycle() {
    }

    public void hideArrow() {
        this.ayg.setVisibility(8);
    }

    public void setText(String str) {
        this.ayb.setText(str);
    }

    public void setText(int i) {
        this.ayb.setText(i);
    }

    public void setTip(String str) {
        this.ayc.setText(str);
    }

    public CharSequence getTip() {
        return this.ayc.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.ayc.setBackgroundDrawable(drawable);
    }

    protected void Bx() {
        LayoutInflater.from(this.mContext).inflate(d.h.tb_setting_text_tip_view, (ViewGroup) this, true);
        this.aya = (LinearLayout) findViewById(d.g.container);
        this.ayb = (TextView) findViewById(d.g.text);
        this.ayc = (TextView) findViewById(d.g.tip);
        this.ayg = (ImageView) findViewById(d.g.arrow2);
        this.mBottomLine = findViewById(d.g.bottom_line_ll);
        this.ayf = findViewById(d.g.top_line_ll);
    }

    protected void b(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.l.TbSettingView);
        if (obtainStyledAttributes != null) {
            String string = obtainStyledAttributes.getString(d.l.TbSettingView_settingText);
            String string2 = obtainStyledAttributes.getString(d.l.TbSettingView_settingTip);
            if (string != null) {
                this.ayb.setText(string);
            }
            if (string2 != null) {
                this.ayc.setText(string2);
            }
            this.aye = obtainStyledAttributes.getBoolean(d.l.TbSettingView_settingShowArraw, true);
            obtainStyledAttributes.recycle();
        }
        this.aya.setClickable(false);
        this.aya.setFocusable(false);
        if (!this.aye) {
            this.ayg.setVisibility(4);
        }
    }

    public void setTopLineVisibility(boolean z) {
        if (z) {
            this.ayf.setVisibility(0);
        } else {
            this.ayf.setVisibility(8);
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
