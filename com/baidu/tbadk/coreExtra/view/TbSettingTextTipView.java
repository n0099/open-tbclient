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
    private View awA;
    private View awB;
    protected ImageView awC;
    protected LinearLayout awv;
    protected TextView aww;
    protected TextView awx;
    private boolean awz;
    protected Context mContext;

    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.awz = true;
        this.mContext = context;
        Bl();
        c(attributeSet);
    }

    public TbSettingTextTipView(Context context) {
        super(context);
        this.awz = true;
        this.mContext = context;
        Bl();
    }

    public void displayTip() {
        if (this.awx != null) {
            this.awx.setVisibility(0);
        }
    }

    public void setTipColor(int i) {
        if (this.awx != null) {
            this.awx.setTextColor(i);
        }
    }

    public void setTipStyle(int i) {
    }

    public void f(int i, int i2, int i3, int i4) {
        if (this.awx != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(i, i2, i3, i4);
            this.awx.setLayoutParams(layoutParams);
        }
    }

    public void recycle() {
    }

    public void hideArrow() {
        this.awC.setVisibility(8);
    }

    public void setText(String str) {
        this.aww.setText(str);
    }

    public void setText(int i) {
        this.aww.setText(i);
    }

    public void setTip(String str) {
        this.awx.setText(str);
    }

    public CharSequence getTip() {
        return this.awx.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.awx.setBackgroundDrawable(drawable);
    }

    protected void Bl() {
        LayoutInflater.from(this.mContext).inflate(w.j.tb_setting_text_tip_view, (ViewGroup) this, true);
        this.awv = (LinearLayout) findViewById(w.h.container);
        this.aww = (TextView) findViewById(w.h.text);
        this.awx = (TextView) findViewById(w.h.tip);
        this.awC = (ImageView) findViewById(w.h.arrow2);
        this.awB = findViewById(w.h.bottom_line_ll);
        this.awA = findViewById(w.h.top_line_ll);
    }

    protected void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, w.n.TbSettingView);
        if (obtainStyledAttributes != null) {
            String string = obtainStyledAttributes.getString(0);
            String string2 = obtainStyledAttributes.getString(3);
            if (string != null) {
                this.aww.setText(string);
            }
            if (string2 != null) {
                this.awx.setText(string2);
            }
            this.awz = obtainStyledAttributes.getBoolean(5, true);
            obtainStyledAttributes.recycle();
        }
        this.awv.setClickable(false);
        this.awv.setFocusable(false);
        if (!this.awz) {
            this.awC.setVisibility(4);
        }
    }

    public void setTopLineVisibility(boolean z) {
        if (z) {
            this.awA.setVisibility(0);
        } else {
            this.awA.setVisibility(8);
        }
    }

    public void setBottomLineVisibility(boolean z) {
        if (z) {
            this.awB.setVisibility(0);
        } else {
            this.awB.setVisibility(8);
        }
    }
}
