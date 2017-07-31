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
    protected LinearLayout ayE;
    protected TextView ayF;
    protected TextView ayG;
    private boolean ayI;
    private View ayJ;
    private View ayK;
    protected ImageView ayL;
    protected Context mContext;

    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ayI = true;
        this.mContext = context;
        BE();
        c(attributeSet);
    }

    public TbSettingTextTipView(Context context) {
        super(context);
        this.ayI = true;
        this.mContext = context;
        BE();
    }

    public void displayTip() {
        if (this.ayG != null) {
            this.ayG.setVisibility(0);
        }
    }

    public void setTipColor(int i) {
        if (this.ayG != null) {
            this.ayG.setTextColor(i);
        }
    }

    public void setTipStyle(int i) {
        if (this.ayG != null) {
        }
    }

    public void i(int i, int i2, int i3, int i4) {
        if (this.ayG != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(i, i2, i3, i4);
            this.ayG.setLayoutParams(layoutParams);
        }
    }

    public void recycle() {
    }

    public void hideArrow() {
        this.ayL.setVisibility(8);
    }

    public void setText(String str) {
        this.ayF.setText(str);
    }

    public void setText(int i) {
        this.ayF.setText(i);
    }

    public void setTip(String str) {
        this.ayG.setText(str);
    }

    public CharSequence getTip() {
        return this.ayG.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.ayG.setBackgroundDrawable(drawable);
    }

    protected void BE() {
        LayoutInflater.from(this.mContext).inflate(d.j.tb_setting_text_tip_view, (ViewGroup) this, true);
        this.ayE = (LinearLayout) findViewById(d.h.container);
        this.ayF = (TextView) findViewById(d.h.text);
        this.ayG = (TextView) findViewById(d.h.tip);
        this.ayL = (ImageView) findViewById(d.h.arrow2);
        this.ayK = findViewById(d.h.bottom_line_ll);
        this.ayJ = findViewById(d.h.top_line_ll);
    }

    protected void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.n.TbSettingView);
        if (obtainStyledAttributes != null) {
            String string = obtainStyledAttributes.getString(d.n.TbSettingView_settingText);
            String string2 = obtainStyledAttributes.getString(d.n.TbSettingView_settingTip);
            if (string != null) {
                this.ayF.setText(string);
            }
            if (string2 != null) {
                this.ayG.setText(string2);
            }
            this.ayI = obtainStyledAttributes.getBoolean(d.n.TbSettingView_settingShowArraw, true);
            obtainStyledAttributes.recycle();
        }
        this.ayE.setClickable(false);
        this.ayE.setFocusable(false);
        if (!this.ayI) {
            this.ayL.setVisibility(4);
        }
    }

    public void setTopLineVisibility(boolean z) {
        if (z) {
            this.ayJ.setVisibility(0);
        } else {
            this.ayJ.setVisibility(8);
        }
    }

    public void setBottomLineVisibility(boolean z) {
        if (z) {
            this.ayK.setVisibility(0);
        } else {
            this.ayK.setVisibility(8);
        }
    }
}
