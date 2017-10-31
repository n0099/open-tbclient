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
    protected LinearLayout axj;
    protected TextView axk;
    protected TextView axl;
    private boolean axn;
    private View axo;
    protected ImageView axp;
    private View mBottomLine;
    protected Context mContext;

    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.axn = true;
        this.mContext = context;
        Ba();
        b(attributeSet);
    }

    public TbSettingTextTipView(Context context) {
        super(context);
        this.axn = true;
        this.mContext = context;
        Ba();
    }

    public void displayTip() {
        if (this.axl != null) {
            this.axl.setVisibility(0);
        }
    }

    public void setTipColor(int i) {
        if (this.axl != null) {
            this.axl.setTextColor(i);
        }
    }

    public void setTipStyle(int i) {
        if (this.axl != null) {
        }
    }

    public void g(int i, int i2, int i3, int i4) {
        if (this.axl != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(i, i2, i3, i4);
            this.axl.setLayoutParams(layoutParams);
        }
    }

    public void recycle() {
    }

    public void hideArrow() {
        this.axp.setVisibility(8);
    }

    public void setText(String str) {
        this.axk.setText(str);
    }

    public void setText(int i) {
        this.axk.setText(i);
    }

    public void setTip(String str) {
        this.axl.setText(str);
    }

    public CharSequence getTip() {
        return this.axl.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.axl.setBackgroundDrawable(drawable);
    }

    protected void Ba() {
        LayoutInflater.from(this.mContext).inflate(d.h.tb_setting_text_tip_view, (ViewGroup) this, true);
        this.axj = (LinearLayout) findViewById(d.g.container);
        this.axk = (TextView) findViewById(d.g.text);
        this.axl = (TextView) findViewById(d.g.tip);
        this.axp = (ImageView) findViewById(d.g.arrow2);
        this.mBottomLine = findViewById(d.g.bottom_line_ll);
        this.axo = findViewById(d.g.top_line_ll);
    }

    protected void b(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.l.TbSettingView);
        if (obtainStyledAttributes != null) {
            String string = obtainStyledAttributes.getString(d.l.TbSettingView_settingText);
            String string2 = obtainStyledAttributes.getString(d.l.TbSettingView_settingTip);
            if (string != null) {
                this.axk.setText(string);
            }
            if (string2 != null) {
                this.axl.setText(string2);
            }
            this.axn = obtainStyledAttributes.getBoolean(d.l.TbSettingView_settingShowArraw, true);
            obtainStyledAttributes.recycle();
        }
        this.axj.setClickable(false);
        this.axj.setFocusable(false);
        if (!this.axn) {
            this.axp.setVisibility(4);
        }
    }

    public void setTopLineVisibility(boolean z) {
        if (z) {
            this.axo.setVisibility(0);
        } else {
            this.axo.setVisibility(8);
        }
    }

    public void setBottomLineVisibility(boolean z) {
        if (z) {
            this.mBottomLine.setVisibility(0);
        } else {
            this.mBottomLine.setVisibility(8);
        }
    }
}
