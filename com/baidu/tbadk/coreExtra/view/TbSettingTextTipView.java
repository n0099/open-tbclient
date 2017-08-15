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
    protected LinearLayout ayF;
    protected TextView ayG;
    protected TextView ayH;
    private boolean ayJ;
    private View ayK;
    private View ayL;
    protected ImageView ayM;
    protected Context mContext;

    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ayJ = true;
        this.mContext = context;
        BE();
        c(attributeSet);
    }

    public TbSettingTextTipView(Context context) {
        super(context);
        this.ayJ = true;
        this.mContext = context;
        BE();
    }

    public void displayTip() {
        if (this.ayH != null) {
            this.ayH.setVisibility(0);
        }
    }

    public void setTipColor(int i) {
        if (this.ayH != null) {
            this.ayH.setTextColor(i);
        }
    }

    public void setTipStyle(int i) {
        if (this.ayH != null) {
        }
    }

    public void i(int i, int i2, int i3, int i4) {
        if (this.ayH != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(i, i2, i3, i4);
            this.ayH.setLayoutParams(layoutParams);
        }
    }

    public void recycle() {
    }

    public void hideArrow() {
        this.ayM.setVisibility(8);
    }

    public void setText(String str) {
        this.ayG.setText(str);
    }

    public void setText(int i) {
        this.ayG.setText(i);
    }

    public void setTip(String str) {
        this.ayH.setText(str);
    }

    public CharSequence getTip() {
        return this.ayH.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.ayH.setBackgroundDrawable(drawable);
    }

    protected void BE() {
        LayoutInflater.from(this.mContext).inflate(d.j.tb_setting_text_tip_view, (ViewGroup) this, true);
        this.ayF = (LinearLayout) findViewById(d.h.container);
        this.ayG = (TextView) findViewById(d.h.text);
        this.ayH = (TextView) findViewById(d.h.tip);
        this.ayM = (ImageView) findViewById(d.h.arrow2);
        this.ayL = findViewById(d.h.bottom_line_ll);
        this.ayK = findViewById(d.h.top_line_ll);
    }

    protected void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.n.TbSettingView);
        if (obtainStyledAttributes != null) {
            String string = obtainStyledAttributes.getString(d.n.TbSettingView_settingText);
            String string2 = obtainStyledAttributes.getString(d.n.TbSettingView_settingTip);
            if (string != null) {
                this.ayG.setText(string);
            }
            if (string2 != null) {
                this.ayH.setText(string2);
            }
            this.ayJ = obtainStyledAttributes.getBoolean(d.n.TbSettingView_settingShowArraw, true);
            obtainStyledAttributes.recycle();
        }
        this.ayF.setClickable(false);
        this.ayF.setFocusable(false);
        if (!this.ayJ) {
            this.ayM.setVisibility(4);
        }
    }

    public void setTopLineVisibility(boolean z) {
        if (z) {
            this.ayK.setVisibility(0);
        } else {
            this.ayK.setVisibility(8);
        }
    }

    public void setBottomLineVisibility(boolean z) {
        if (z) {
            this.ayL.setVisibility(0);
        } else {
            this.ayL.setVisibility(8);
        }
    }
}
