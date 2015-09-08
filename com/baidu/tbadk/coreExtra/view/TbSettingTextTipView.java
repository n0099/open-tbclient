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
    private boolean anB;
    protected ImageView anC;
    protected TextView any;
    protected TextView anz;
    protected LinearLayout container;
    protected Context mContext;

    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.anB = true;
        this.mContext = context;
        zz();
        c(attributeSet);
    }

    public TbSettingTextTipView(Context context) {
        super(context);
        this.anB = true;
        this.mContext = context;
        zz();
    }

    public void displayTip() {
        if (this.anz != null) {
            this.anz.setVisibility(0);
        }
    }

    public void setTipColor(int i) {
        if (this.anz != null) {
            this.anz.setTextColor(i);
        }
    }

    public void setTipStyle(int i) {
    }

    public void h(int i, int i2, int i3, int i4) {
        if (this.anz != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(i, i2, i3, i4);
            this.anz.setLayoutParams(layoutParams);
        }
    }

    public void recycle() {
    }

    public void hideArrow() {
        this.anC.setVisibility(8);
    }

    public void setText(String str) {
        this.any.setText(str);
    }

    public void setText(int i) {
        this.any.setText(i);
    }

    public void setTip(String str) {
        this.anz.setText(str);
    }

    public CharSequence getTip() {
        return this.anz.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.anz.setBackgroundDrawable(drawable);
    }

    protected void zz() {
        LayoutInflater.from(this.mContext).inflate(i.g.tb_setting_text_tip_view, (ViewGroup) this, true);
        this.container = (LinearLayout) findViewById(i.f.container);
        this.any = (TextView) findViewById(i.f.text);
        this.anz = (TextView) findViewById(i.f.tip);
        this.anC = (ImageView) findViewById(i.f.arrow2);
    }

    protected void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, i.j.TbSettingView);
        if (obtainStyledAttributes != null) {
            String string = obtainStyledAttributes.getString(0);
            String string2 = obtainStyledAttributes.getString(3);
            if (string != null) {
                this.any.setText(string);
            }
            if (string2 != null) {
                this.anz.setText(string2);
            }
            this.anB = obtainStyledAttributes.getBoolean(5, true);
            obtainStyledAttributes.recycle();
        }
        this.container.setClickable(false);
        this.container.setFocusable(false);
        if (!this.anB) {
            this.anC.setVisibility(4);
        }
    }
}
