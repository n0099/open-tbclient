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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class TbSettingTextTipView extends FrameLayout {
    private View GD;
    protected LinearLayout arj;
    protected TextView ark;
    protected TextView arl;
    private boolean arn;
    private View aro;
    protected ImageView arp;
    protected Context mContext;

    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.arn = true;
        this.mContext = context;
        Bn();
        d(attributeSet);
    }

    public TbSettingTextTipView(Context context) {
        super(context);
        this.arn = true;
        this.mContext = context;
        Bn();
    }

    public void displayTip() {
        if (this.arl != null) {
            this.arl.setVisibility(0);
        }
    }

    public void setTipColor(int i) {
        if (this.arl != null) {
            this.arl.setTextColor(i);
        }
    }

    public void setTipStyle(int i) {
    }

    public void f(int i, int i2, int i3, int i4) {
        if (this.arl != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(i, i2, i3, i4);
            this.arl.setLayoutParams(layoutParams);
        }
    }

    public void recycle() {
    }

    public void hideArrow() {
        this.arp.setVisibility(8);
    }

    public void setText(String str) {
        this.ark.setText(str);
    }

    public void setText(int i) {
        this.ark.setText(i);
    }

    public void setTip(String str) {
        this.arl.setText(str);
    }

    public CharSequence getTip() {
        return this.arl.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.arl.setBackgroundDrawable(drawable);
    }

    protected void Bn() {
        LayoutInflater.from(this.mContext).inflate(r.h.tb_setting_text_tip_view, (ViewGroup) this, true);
        this.arj = (LinearLayout) findViewById(r.g.container);
        this.ark = (TextView) findViewById(r.g.text);
        this.arl = (TextView) findViewById(r.g.tip);
        this.arp = (ImageView) findViewById(r.g.arrow2);
        this.GD = findViewById(r.g.bottom_line_ll);
        this.aro = findViewById(r.g.top_line_ll);
    }

    protected void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, r.l.TbSettingView);
        if (obtainStyledAttributes != null) {
            String string = obtainStyledAttributes.getString(0);
            String string2 = obtainStyledAttributes.getString(3);
            if (string != null) {
                this.ark.setText(string);
            }
            if (string2 != null) {
                this.arl.setText(string2);
            }
            this.arn = obtainStyledAttributes.getBoolean(5, true);
            obtainStyledAttributes.recycle();
        }
        this.arj.setClickable(false);
        this.arj.setFocusable(false);
        if (!this.arn) {
            this.arp.setVisibility(4);
        }
    }

    public void setTopLineVisibility(boolean z) {
        if (z) {
            this.aro.setVisibility(0);
        } else {
            this.aro.setVisibility(8);
        }
    }

    public void setBottomLineVisibility(boolean z) {
        if (z) {
            this.GD.setVisibility(0);
        } else {
            this.GD.setVisibility(8);
        }
    }
}
