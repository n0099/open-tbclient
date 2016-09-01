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
    protected LinearLayout aqH;
    protected TextView aqI;
    protected TextView aqJ;
    private boolean aqL;
    protected ImageView aqM;
    protected Context mContext;

    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aqL = true;
        this.mContext = context;
        Bd();
        d(attributeSet);
    }

    public TbSettingTextTipView(Context context) {
        super(context);
        this.aqL = true;
        this.mContext = context;
        Bd();
    }

    public void displayTip() {
        if (this.aqJ != null) {
            this.aqJ.setVisibility(0);
        }
    }

    public void setTipColor(int i) {
        if (this.aqJ != null) {
            this.aqJ.setTextColor(i);
        }
    }

    public void setTipStyle(int i) {
    }

    public void f(int i, int i2, int i3, int i4) {
        if (this.aqJ != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(i, i2, i3, i4);
            this.aqJ.setLayoutParams(layoutParams);
        }
    }

    public void recycle() {
    }

    public void hideArrow() {
        this.aqM.setVisibility(8);
    }

    public void setText(String str) {
        this.aqI.setText(str);
    }

    public void setText(int i) {
        this.aqI.setText(i);
    }

    public void setTip(String str) {
        this.aqJ.setText(str);
    }

    public CharSequence getTip() {
        return this.aqJ.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.aqJ.setBackgroundDrawable(drawable);
    }

    protected void Bd() {
        LayoutInflater.from(this.mContext).inflate(t.h.tb_setting_text_tip_view, (ViewGroup) this, true);
        this.aqH = (LinearLayout) findViewById(t.g.container);
        this.aqI = (TextView) findViewById(t.g.text);
        this.aqJ = (TextView) findViewById(t.g.tip);
        this.aqM = (ImageView) findViewById(t.g.arrow2);
    }

    protected void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, t.l.TbSettingView);
        if (obtainStyledAttributes != null) {
            String string = obtainStyledAttributes.getString(0);
            String string2 = obtainStyledAttributes.getString(3);
            if (string != null) {
                this.aqI.setText(string);
            }
            if (string2 != null) {
                this.aqJ.setText(string2);
            }
            this.aqL = obtainStyledAttributes.getBoolean(5, true);
            obtainStyledAttributes.recycle();
        }
        this.aqH.setClickable(false);
        this.aqH.setFocusable(false);
        if (!this.aqL) {
            this.aqM.setVisibility(4);
        }
    }
}
