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
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class TbSettingTextTipView extends FrameLayout {
    protected LinearLayout avs;
    protected TextView avt;
    protected TextView avu;
    private boolean avw;
    private View avx;
    private View avy;
    protected ImageView avz;
    protected Context mContext;

    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.avw = true;
        this.mContext = context;
        AQ();
        c(attributeSet);
    }

    public TbSettingTextTipView(Context context) {
        super(context);
        this.avw = true;
        this.mContext = context;
        AQ();
    }

    public void displayTip() {
        if (this.avu != null) {
            this.avu.setVisibility(0);
        }
    }

    public void setTipColor(int i) {
        if (this.avu != null) {
            this.avu.setTextColor(i);
        }
    }

    public void setTipStyle(int i) {
    }

    public void f(int i, int i2, int i3, int i4) {
        if (this.avu != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(i, i2, i3, i4);
            this.avu.setLayoutParams(layoutParams);
        }
    }

    public void recycle() {
    }

    public void hideArrow() {
        this.avz.setVisibility(8);
    }

    public void setText(String str) {
        this.avt.setText(str);
    }

    public void setText(int i) {
        this.avt.setText(i);
    }

    public void setTip(String str) {
        this.avu.setText(str);
    }

    public CharSequence getTip() {
        return this.avu.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.avu.setBackgroundDrawable(drawable);
    }

    protected void AQ() {
        LayoutInflater.from(this.mContext).inflate(w.j.tb_setting_text_tip_view, (ViewGroup) this, true);
        this.avs = (LinearLayout) findViewById(w.h.container);
        this.avt = (TextView) findViewById(w.h.text);
        this.avu = (TextView) findViewById(w.h.tip);
        this.avz = (ImageView) findViewById(w.h.arrow2);
        this.avy = findViewById(w.h.bottom_line_ll);
        this.avx = findViewById(w.h.top_line_ll);
    }

    protected void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, w.n.TbSettingView);
        if (obtainStyledAttributes != null) {
            String string = obtainStyledAttributes.getString(0);
            String string2 = obtainStyledAttributes.getString(3);
            if (string != null) {
                this.avt.setText(string);
            }
            if (string2 != null) {
                this.avu.setText(string2);
            }
            this.avw = obtainStyledAttributes.getBoolean(5, true);
            obtainStyledAttributes.recycle();
        }
        this.avs.setClickable(false);
        this.avs.setFocusable(false);
        if (!this.avw) {
            this.avz.setVisibility(4);
        }
    }

    public void setTopLineVisibility(boolean z) {
        if (z) {
            this.avx.setVisibility(0);
        } else {
            this.avx.setVisibility(8);
        }
    }

    public void setBottomLineVisibility(boolean z) {
        if (z) {
            this.avy.setVisibility(0);
        } else {
            this.avy.setVisibility(8);
        }
    }
}
