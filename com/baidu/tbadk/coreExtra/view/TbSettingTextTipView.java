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
    protected TextView api;
    protected TextView apj;
    private boolean apl;
    protected ImageView apm;
    protected LinearLayout container;
    protected Context mContext;

    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.apl = true;
        this.mContext = context;
        zV();
        c(attributeSet);
    }

    public TbSettingTextTipView(Context context) {
        super(context);
        this.apl = true;
        this.mContext = context;
        zV();
    }

    public void displayTip() {
        if (this.apj != null) {
            this.apj.setVisibility(0);
        }
    }

    public void setTipColor(int i) {
        if (this.apj != null) {
            this.apj.setTextColor(i);
        }
    }

    public void setTipStyle(int i) {
    }

    public void h(int i, int i2, int i3, int i4) {
        if (this.apj != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(i, i2, i3, i4);
            this.apj.setLayoutParams(layoutParams);
        }
    }

    public void recycle() {
    }

    public void hideArrow() {
        this.apm.setVisibility(8);
    }

    public void setText(String str) {
        this.api.setText(str);
    }

    public void setText(int i) {
        this.api.setText(i);
    }

    public void setTip(String str) {
        this.apj.setText(str);
    }

    public CharSequence getTip() {
        return this.apj.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.apj.setBackgroundDrawable(drawable);
    }

    protected void zV() {
        LayoutInflater.from(this.mContext).inflate(n.h.tb_setting_text_tip_view, (ViewGroup) this, true);
        this.container = (LinearLayout) findViewById(n.g.container);
        this.api = (TextView) findViewById(n.g.text);
        this.apj = (TextView) findViewById(n.g.tip);
        this.apm = (ImageView) findViewById(n.g.arrow2);
    }

    protected void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, n.l.TbSettingView);
        if (obtainStyledAttributes != null) {
            String string = obtainStyledAttributes.getString(0);
            String string2 = obtainStyledAttributes.getString(3);
            if (string != null) {
                this.api.setText(string);
            }
            if (string2 != null) {
                this.apj.setText(string2);
            }
            this.apl = obtainStyledAttributes.getBoolean(5, true);
            obtainStyledAttributes.recycle();
        }
        this.container.setClickable(false);
        this.container.setFocusable(false);
        if (!this.apl) {
            this.apm.setVisibility(4);
        }
    }
}
