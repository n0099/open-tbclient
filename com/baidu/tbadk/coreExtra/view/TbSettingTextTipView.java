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
    protected LinearLayout ayG;
    protected TextView ayH;
    protected TextView ayI;
    private boolean ayK;
    private View ayL;
    private View ayM;
    protected ImageView ayN;
    protected Context mContext;

    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ayK = true;
        this.mContext = context;
        BE();
        b(attributeSet);
    }

    public TbSettingTextTipView(Context context) {
        super(context);
        this.ayK = true;
        this.mContext = context;
        BE();
    }

    public void displayTip() {
        if (this.ayI != null) {
            this.ayI.setVisibility(0);
        }
    }

    public void setTipColor(int i) {
        if (this.ayI != null) {
            this.ayI.setTextColor(i);
        }
    }

    public void setTipStyle(int i) {
        if (this.ayI != null) {
        }
    }

    public void i(int i, int i2, int i3, int i4) {
        if (this.ayI != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(i, i2, i3, i4);
            this.ayI.setLayoutParams(layoutParams);
        }
    }

    public void recycle() {
    }

    public void hideArrow() {
        this.ayN.setVisibility(8);
    }

    public void setText(String str) {
        this.ayH.setText(str);
    }

    public void setText(int i) {
        this.ayH.setText(i);
    }

    public void setTip(String str) {
        this.ayI.setText(str);
    }

    public CharSequence getTip() {
        return this.ayI.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.ayI.setBackgroundDrawable(drawable);
    }

    protected void BE() {
        LayoutInflater.from(this.mContext).inflate(d.j.tb_setting_text_tip_view, (ViewGroup) this, true);
        this.ayG = (LinearLayout) findViewById(d.h.container);
        this.ayH = (TextView) findViewById(d.h.text);
        this.ayI = (TextView) findViewById(d.h.tip);
        this.ayN = (ImageView) findViewById(d.h.arrow2);
        this.ayM = findViewById(d.h.bottom_line_ll);
        this.ayL = findViewById(d.h.top_line_ll);
    }

    protected void b(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.n.TbSettingView);
        if (obtainStyledAttributes != null) {
            String string = obtainStyledAttributes.getString(d.n.TbSettingView_settingText);
            String string2 = obtainStyledAttributes.getString(d.n.TbSettingView_settingTip);
            if (string != null) {
                this.ayH.setText(string);
            }
            if (string2 != null) {
                this.ayI.setText(string2);
            }
            this.ayK = obtainStyledAttributes.getBoolean(d.n.TbSettingView_settingShowArraw, true);
            obtainStyledAttributes.recycle();
        }
        this.ayG.setClickable(false);
        this.ayG.setFocusable(false);
        if (!this.ayK) {
            this.ayN.setVisibility(4);
        }
    }

    public void setTopLineVisibility(boolean z) {
        if (z) {
            this.ayL.setVisibility(0);
        } else {
            this.ayL.setVisibility(8);
        }
    }

    public void setBottomLineVisibility(boolean z) {
        if (z) {
            this.ayM.setVisibility(0);
        } else {
            this.ayM.setVisibility(8);
        }
    }
}
