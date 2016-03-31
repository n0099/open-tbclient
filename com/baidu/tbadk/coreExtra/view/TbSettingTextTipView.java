package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class TbSettingTextTipView extends FrameLayout {
    protected LinearLayout aqr;
    protected TextView aqs;
    protected TextView aqt;
    private boolean aqv;
    protected ImageView aqw;
    protected Context mContext;

    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aqv = true;
        this.mContext = context;
        BO();
        d(attributeSet);
    }

    public TbSettingTextTipView(Context context) {
        super(context);
        this.aqv = true;
        this.mContext = context;
        BO();
    }

    public void displayTip() {
        if (this.aqt != null) {
            this.aqt.setVisibility(0);
        }
    }

    public void setTipColor(int i) {
        if (this.aqt != null) {
            this.aqt.setTextColor(i);
        }
    }

    public void setTipStyle(int i) {
    }

    public void e(int i, int i2, int i3, int i4) {
        if (this.aqt != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(i, i2, i3, i4);
            this.aqt.setLayoutParams(layoutParams);
        }
    }

    public void recycle() {
    }

    public void hideArrow() {
        this.aqw.setVisibility(8);
    }

    public void setText(String str) {
        this.aqs.setText(str);
    }

    public void setText(int i) {
        this.aqs.setText(i);
    }

    public void setTip(String str) {
        this.aqt.setText(str);
    }

    public CharSequence getTip() {
        return this.aqt.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.aqt.setBackgroundDrawable(drawable);
    }

    protected void BO() {
        LayoutInflater.from(this.mContext).inflate(t.h.tb_setting_text_tip_view, (ViewGroup) this, true);
        this.aqr = (LinearLayout) findViewById(t.g.container);
        this.aqs = (TextView) findViewById(t.g.text);
        this.aqt = (TextView) findViewById(t.g.tip);
        this.aqw = (ImageView) findViewById(t.g.arrow2);
    }

    protected void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, t.l.TbSettingView);
        if (obtainStyledAttributes != null) {
            String string = obtainStyledAttributes.getString(0);
            String string2 = obtainStyledAttributes.getString(3);
            if (string != null) {
                this.aqs.setText(string);
            }
            if (string2 != null) {
                this.aqt.setText(string2);
            }
            this.aqv = obtainStyledAttributes.getBoolean(5, true);
            obtainStyledAttributes.recycle();
        }
        this.aqr.setClickable(false);
        this.aqr.setFocusable(false);
        if (!this.aqv) {
            this.aqw.setVisibility(4);
        }
    }
}
