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
    protected LinearLayout awM;
    protected TextView awN;
    protected TextView awO;
    private boolean awQ;
    private View awR;
    protected ImageView awS;
    private View mBottomLine;
    protected Context mContext;

    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.awQ = true;
        this.mContext = context;
        AR();
        b(attributeSet);
    }

    public TbSettingTextTipView(Context context) {
        super(context);
        this.awQ = true;
        this.mContext = context;
        AR();
    }

    public void displayTip() {
        if (this.awO != null) {
            this.awO.setVisibility(0);
        }
    }

    public void setTipColor(int i) {
        if (this.awO != null) {
            this.awO.setTextColor(i);
        }
    }

    public void setTipStyle(int i) {
        if (this.awO != null) {
        }
    }

    public void g(int i, int i2, int i3, int i4) {
        if (this.awO != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(i, i2, i3, i4);
            this.awO.setLayoutParams(layoutParams);
        }
    }

    public void recycle() {
    }

    public void hideArrow() {
        this.awS.setVisibility(8);
    }

    public void setText(String str) {
        this.awN.setText(str);
    }

    public void setText(int i) {
        this.awN.setText(i);
    }

    public void setTip(String str) {
        this.awO.setText(str);
    }

    public CharSequence getTip() {
        return this.awO.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.awO.setBackgroundDrawable(drawable);
    }

    protected void AR() {
        LayoutInflater.from(this.mContext).inflate(d.j.tb_setting_text_tip_view, (ViewGroup) this, true);
        this.awM = (LinearLayout) findViewById(d.h.container);
        this.awN = (TextView) findViewById(d.h.text);
        this.awO = (TextView) findViewById(d.h.tip);
        this.awS = (ImageView) findViewById(d.h.arrow2);
        this.mBottomLine = findViewById(d.h.bottom_line_ll);
        this.awR = findViewById(d.h.top_line_ll);
    }

    protected void b(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.n.TbSettingView);
        if (obtainStyledAttributes != null) {
            String string = obtainStyledAttributes.getString(d.n.TbSettingView_settingText);
            String string2 = obtainStyledAttributes.getString(d.n.TbSettingView_settingTip);
            if (string != null) {
                this.awN.setText(string);
            }
            if (string2 != null) {
                this.awO.setText(string2);
            }
            this.awQ = obtainStyledAttributes.getBoolean(d.n.TbSettingView_settingShowArraw, true);
            obtainStyledAttributes.recycle();
        }
        this.awM.setClickable(false);
        this.awM.setFocusable(false);
        if (!this.awQ) {
            this.awS.setVisibility(4);
        }
    }

    public void setTopLineVisibility(boolean z) {
        if (z) {
            this.awR.setVisibility(0);
        } else {
            this.awR.setVisibility(8);
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
