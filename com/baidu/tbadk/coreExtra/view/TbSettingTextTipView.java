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
    protected LinearLayout axn;
    protected TextView axo;
    protected TextView axp;
    private boolean axr;
    private View axs;
    private View axt;
    protected ImageView axu;
    protected Context mContext;

    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.axr = true;
        this.mContext = context;
        Bw();
        c(attributeSet);
    }

    public TbSettingTextTipView(Context context) {
        super(context);
        this.axr = true;
        this.mContext = context;
        Bw();
    }

    public void displayTip() {
        if (this.axp != null) {
            this.axp.setVisibility(0);
        }
    }

    public void setTipColor(int i) {
        if (this.axp != null) {
            this.axp.setTextColor(i);
        }
    }

    public void setTipStyle(int i) {
        if (this.axp != null) {
        }
    }

    public void h(int i, int i2, int i3, int i4) {
        if (this.axp != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(i, i2, i3, i4);
            this.axp.setLayoutParams(layoutParams);
        }
    }

    public void recycle() {
    }

    public void hideArrow() {
        this.axu.setVisibility(8);
    }

    public void setText(String str) {
        this.axo.setText(str);
    }

    public void setText(int i) {
        this.axo.setText(i);
    }

    public void setTip(String str) {
        this.axp.setText(str);
    }

    public CharSequence getTip() {
        return this.axp.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.axp.setBackgroundDrawable(drawable);
    }

    protected void Bw() {
        LayoutInflater.from(this.mContext).inflate(d.j.tb_setting_text_tip_view, (ViewGroup) this, true);
        this.axn = (LinearLayout) findViewById(d.h.container);
        this.axo = (TextView) findViewById(d.h.text);
        this.axp = (TextView) findViewById(d.h.tip);
        this.axu = (ImageView) findViewById(d.h.arrow2);
        this.axt = findViewById(d.h.bottom_line_ll);
        this.axs = findViewById(d.h.top_line_ll);
    }

    protected void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.n.TbSettingView);
        if (obtainStyledAttributes != null) {
            String string = obtainStyledAttributes.getString(d.n.TbSettingView_settingText);
            String string2 = obtainStyledAttributes.getString(d.n.TbSettingView_settingTip);
            if (string != null) {
                this.axo.setText(string);
            }
            if (string2 != null) {
                this.axp.setText(string2);
            }
            this.axr = obtainStyledAttributes.getBoolean(d.n.TbSettingView_settingShowArraw, true);
            obtainStyledAttributes.recycle();
        }
        this.axn.setClickable(false);
        this.axn.setFocusable(false);
        if (!this.axr) {
            this.axu.setVisibility(4);
        }
    }

    public void setTopLineVisibility(boolean z) {
        if (z) {
            this.axs.setVisibility(0);
        } else {
            this.axs.setVisibility(8);
        }
    }

    public void setBottomLineVisibility(boolean z) {
        if (z) {
            this.axt.setVisibility(0);
        } else {
            this.axt.setVisibility(8);
        }
    }
}
