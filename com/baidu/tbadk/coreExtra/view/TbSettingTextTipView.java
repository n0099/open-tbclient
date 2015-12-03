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
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class TbSettingTextTipView extends FrameLayout {
    protected TextView anI;
    protected TextView anJ;
    private boolean anL;
    protected ImageView anM;
    protected LinearLayout container;
    protected Context mContext;

    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.anL = true;
        this.mContext = context;
        Aj();
        c(attributeSet);
    }

    public TbSettingTextTipView(Context context) {
        super(context);
        this.anL = true;
        this.mContext = context;
        Aj();
    }

    public void displayTip() {
        if (this.anJ != null) {
            this.anJ.setVisibility(0);
        }
    }

    public void setTipColor(int i) {
        if (this.anJ != null) {
            this.anJ.setTextColor(i);
        }
    }

    public void setTipStyle(int i) {
    }

    public void h(int i, int i2, int i3, int i4) {
        if (this.anJ != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(i, i2, i3, i4);
            this.anJ.setLayoutParams(layoutParams);
        }
    }

    public void recycle() {
    }

    public void hideArrow() {
        this.anM.setVisibility(8);
    }

    public void setText(String str) {
        this.anI.setText(str);
    }

    public void setText(int i) {
        this.anI.setText(i);
    }

    public void setTip(String str) {
        this.anJ.setText(str);
    }

    public CharSequence getTip() {
        return this.anJ.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.anJ.setBackgroundDrawable(drawable);
    }

    protected void Aj() {
        LayoutInflater.from(this.mContext).inflate(n.g.tb_setting_text_tip_view, (ViewGroup) this, true);
        this.container = (LinearLayout) findViewById(n.f.container);
        this.anI = (TextView) findViewById(n.f.text);
        this.anJ = (TextView) findViewById(n.f.tip);
        this.anM = (ImageView) findViewById(n.f.arrow2);
    }

    protected void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, n.k.TbSettingView);
        if (obtainStyledAttributes != null) {
            String string = obtainStyledAttributes.getString(0);
            String string2 = obtainStyledAttributes.getString(3);
            if (string != null) {
                this.anI.setText(string);
            }
            if (string2 != null) {
                this.anJ.setText(string2);
            }
            this.anL = obtainStyledAttributes.getBoolean(5, true);
            obtainStyledAttributes.recycle();
        }
        this.container.setClickable(false);
        this.container.setFocusable(false);
        if (!this.anL) {
            this.anM.setVisibility(4);
        }
    }
}
