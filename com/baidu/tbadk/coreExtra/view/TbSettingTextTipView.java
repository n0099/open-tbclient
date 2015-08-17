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
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class TbSettingTextTipView extends FrameLayout {
    protected TextView alM;
    protected TextView alN;
    private boolean alP;
    protected ImageView alQ;
    protected LinearLayout container;
    protected Context mContext;

    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.alP = true;
        this.mContext = context;
        zm();
        c(attributeSet);
    }

    public TbSettingTextTipView(Context context) {
        super(context);
        this.alP = true;
        this.mContext = context;
        zm();
    }

    public void displayTip() {
        if (this.alN != null) {
            this.alN.setVisibility(0);
        }
    }

    public void setTipColor(int i) {
        if (this.alN != null) {
            this.alN.setTextColor(i);
        }
    }

    public void setTipStyle(int i) {
    }

    public void h(int i, int i2, int i3, int i4) {
        if (this.alN != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(i, i2, i3, i4);
            this.alN.setLayoutParams(layoutParams);
        }
    }

    public void recycle() {
    }

    public void hideArrow() {
        this.alQ.setVisibility(8);
    }

    public void setText(String str) {
        this.alM.setText(str);
    }

    public void setText(int i) {
        this.alM.setText(i);
    }

    public void setTip(String str) {
        this.alN.setText(str);
    }

    public CharSequence getTip() {
        return this.alN.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.alN.setBackgroundDrawable(drawable);
    }

    protected void zm() {
        LayoutInflater.from(this.mContext).inflate(i.g.tb_setting_text_tip_view, (ViewGroup) this, true);
        this.container = (LinearLayout) findViewById(i.f.container);
        this.alM = (TextView) findViewById(i.f.text);
        this.alN = (TextView) findViewById(i.f.tip);
        this.alQ = (ImageView) findViewById(i.f.arrow2);
    }

    protected void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, i.k.TbSettingView);
        if (obtainStyledAttributes != null) {
            String string = obtainStyledAttributes.getString(0);
            String string2 = obtainStyledAttributes.getString(3);
            if (string != null) {
                this.alM.setText(string);
            }
            if (string2 != null) {
                this.alN.setText(string2);
            }
            this.alP = obtainStyledAttributes.getBoolean(5, true);
            obtainStyledAttributes.recycle();
        }
        this.container.setClickable(false);
        this.container.setFocusable(false);
        if (!this.alP) {
            this.alQ.setVisibility(4);
        }
    }
}
