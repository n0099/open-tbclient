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
    protected TextView alP;
    protected TextView alQ;
    private boolean alS;
    protected ImageView alT;
    protected LinearLayout container;
    protected Context mContext;

    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.alS = true;
        this.mContext = context;
        zl();
        c(attributeSet);
    }

    public TbSettingTextTipView(Context context) {
        super(context);
        this.alS = true;
        this.mContext = context;
        zl();
    }

    public void displayTip() {
        if (this.alQ != null) {
            this.alQ.setVisibility(0);
        }
    }

    public void setTipColor(int i) {
        if (this.alQ != null) {
            this.alQ.setTextColor(i);
        }
    }

    public void setTipStyle(int i) {
    }

    public void h(int i, int i2, int i3, int i4) {
        if (this.alQ != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(i, i2, i3, i4);
            this.alQ.setLayoutParams(layoutParams);
        }
    }

    public void recycle() {
    }

    public void hideArrow() {
        this.alT.setVisibility(8);
    }

    public void setText(String str) {
        this.alP.setText(str);
    }

    public void setText(int i) {
        this.alP.setText(i);
    }

    public void setTip(String str) {
        this.alQ.setText(str);
    }

    public CharSequence getTip() {
        return this.alQ.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.alQ.setBackgroundDrawable(drawable);
    }

    protected void zl() {
        LayoutInflater.from(this.mContext).inflate(i.g.tb_setting_text_tip_view, (ViewGroup) this, true);
        this.container = (LinearLayout) findViewById(i.f.container);
        this.alP = (TextView) findViewById(i.f.text);
        this.alQ = (TextView) findViewById(i.f.tip);
        this.alT = (ImageView) findViewById(i.f.arrow2);
    }

    protected void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, i.j.TbSettingView);
        if (obtainStyledAttributes != null) {
            String string = obtainStyledAttributes.getString(0);
            String string2 = obtainStyledAttributes.getString(3);
            if (string != null) {
                this.alP.setText(string);
            }
            if (string2 != null) {
                this.alQ.setText(string2);
            }
            this.alS = obtainStyledAttributes.getBoolean(5, true);
            obtainStyledAttributes.recycle();
        }
        this.container.setClickable(false);
        this.container.setFocusable(false);
        if (!this.alS) {
            this.alT.setVisibility(4);
        }
    }
}
