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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class TbSettingTextTipView extends FrameLayout {
    private View GB;
    protected LinearLayout aqp;
    protected TextView aqq;
    protected TextView aqr;
    private boolean aqt;
    private View aqu;
    protected ImageView aqv;
    protected Context mContext;

    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aqt = true;
        this.mContext = context;
        Bg();
        d(attributeSet);
    }

    public TbSettingTextTipView(Context context) {
        super(context);
        this.aqt = true;
        this.mContext = context;
        Bg();
    }

    public void displayTip() {
        if (this.aqr != null) {
            this.aqr.setVisibility(0);
        }
    }

    public void setTipColor(int i) {
        if (this.aqr != null) {
            this.aqr.setTextColor(i);
        }
    }

    public void setTipStyle(int i) {
    }

    public void f(int i, int i2, int i3, int i4) {
        if (this.aqr != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(i, i2, i3, i4);
            this.aqr.setLayoutParams(layoutParams);
        }
    }

    public void recycle() {
    }

    public void hideArrow() {
        this.aqv.setVisibility(8);
    }

    public void setText(String str) {
        this.aqq.setText(str);
    }

    public void setText(int i) {
        this.aqq.setText(i);
    }

    public void setTip(String str) {
        this.aqr.setText(str);
    }

    public CharSequence getTip() {
        return this.aqr.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.aqr.setBackgroundDrawable(drawable);
    }

    protected void Bg() {
        LayoutInflater.from(this.mContext).inflate(r.h.tb_setting_text_tip_view, (ViewGroup) this, true);
        this.aqp = (LinearLayout) findViewById(r.g.container);
        this.aqq = (TextView) findViewById(r.g.text);
        this.aqr = (TextView) findViewById(r.g.tip);
        this.aqv = (ImageView) findViewById(r.g.arrow2);
        this.GB = findViewById(r.g.bottom_line_ll);
        this.aqu = findViewById(r.g.top_line_ll);
    }

    protected void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, r.l.TbSettingView);
        if (obtainStyledAttributes != null) {
            String string = obtainStyledAttributes.getString(0);
            String string2 = obtainStyledAttributes.getString(3);
            if (string != null) {
                this.aqq.setText(string);
            }
            if (string2 != null) {
                this.aqr.setText(string2);
            }
            this.aqt = obtainStyledAttributes.getBoolean(5, true);
            obtainStyledAttributes.recycle();
        }
        this.aqp.setClickable(false);
        this.aqp.setFocusable(false);
        if (!this.aqt) {
            this.aqv.setVisibility(4);
        }
    }

    public void setTopLineVisibility(boolean z) {
        if (z) {
            this.aqu.setVisibility(0);
        } else {
            this.aqu.setVisibility(8);
        }
    }

    public void setBottomLineVisibility(boolean z) {
        if (z) {
            this.GB.setVisibility(0);
        } else {
            this.GB.setVisibility(8);
        }
    }
}
