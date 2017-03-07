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
    protected LinearLayout avm;
    protected TextView avn;
    protected TextView avo;
    private boolean avq;
    private View avr;
    private View avs;
    protected ImageView avt;
    protected Context mContext;

    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.avq = true;
        this.mContext = context;
        Bo();
        d(attributeSet);
    }

    public TbSettingTextTipView(Context context) {
        super(context);
        this.avq = true;
        this.mContext = context;
        Bo();
    }

    public void displayTip() {
        if (this.avo != null) {
            this.avo.setVisibility(0);
        }
    }

    public void setTipColor(int i) {
        if (this.avo != null) {
            this.avo.setTextColor(i);
        }
    }

    public void setTipStyle(int i) {
    }

    public void f(int i, int i2, int i3, int i4) {
        if (this.avo != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(i, i2, i3, i4);
            this.avo.setLayoutParams(layoutParams);
        }
    }

    public void recycle() {
    }

    public void hideArrow() {
        this.avt.setVisibility(8);
    }

    public void setText(String str) {
        this.avn.setText(str);
    }

    public void setText(int i) {
        this.avn.setText(i);
    }

    public void setTip(String str) {
        this.avo.setText(str);
    }

    public CharSequence getTip() {
        return this.avo.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.avo.setBackgroundDrawable(drawable);
    }

    protected void Bo() {
        LayoutInflater.from(this.mContext).inflate(w.j.tb_setting_text_tip_view, (ViewGroup) this, true);
        this.avm = (LinearLayout) findViewById(w.h.container);
        this.avn = (TextView) findViewById(w.h.text);
        this.avo = (TextView) findViewById(w.h.tip);
        this.avt = (ImageView) findViewById(w.h.arrow2);
        this.avs = findViewById(w.h.bottom_line_ll);
        this.avr = findViewById(w.h.top_line_ll);
    }

    protected void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, w.n.TbSettingView);
        if (obtainStyledAttributes != null) {
            String string = obtainStyledAttributes.getString(0);
            String string2 = obtainStyledAttributes.getString(3);
            if (string != null) {
                this.avn.setText(string);
            }
            if (string2 != null) {
                this.avo.setText(string2);
            }
            this.avq = obtainStyledAttributes.getBoolean(5, true);
            obtainStyledAttributes.recycle();
        }
        this.avm.setClickable(false);
        this.avm.setFocusable(false);
        if (!this.avq) {
            this.avt.setVisibility(4);
        }
    }

    public void setTopLineVisibility(boolean z) {
        if (z) {
            this.avr.setVisibility(0);
        } else {
            this.avr.setVisibility(8);
        }
    }

    public void setBottomLineVisibility(boolean z) {
        if (z) {
            this.avs.setVisibility(0);
        } else {
            this.avs.setVisibility(8);
        }
    }
}
