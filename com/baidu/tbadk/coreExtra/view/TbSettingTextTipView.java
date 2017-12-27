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
    protected LinearLayout bmf;
    protected TextView bmg;
    protected TextView bmh;
    private boolean bmj;
    private View bmk;
    protected ImageView bml;
    private View mBottomLine;
    protected Context mContext;

    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bmj = true;
        this.mContext = context;
        IZ();
        d(attributeSet);
    }

    public TbSettingTextTipView(Context context) {
        super(context);
        this.bmj = true;
        this.mContext = context;
        IZ();
    }

    public void displayTip() {
        if (this.bmh != null) {
            this.bmh.setVisibility(0);
        }
    }

    public void setTipColor(int i) {
        if (this.bmh != null) {
            this.bmh.setTextColor(i);
        }
    }

    public void setTipStyle(int i) {
        if (this.bmh != null) {
        }
    }

    public void o(int i, int i2, int i3, int i4) {
        if (this.bmh != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(i, i2, i3, i4);
            this.bmh.setLayoutParams(layoutParams);
        }
    }

    public void recycle() {
    }

    public void hideArrow() {
        this.bml.setVisibility(8);
    }

    public void setText(String str) {
        this.bmg.setText(str);
    }

    public void setText(int i) {
        this.bmg.setText(i);
    }

    public void setTip(String str) {
        this.bmh.setText(str);
    }

    public CharSequence getTip() {
        return this.bmh.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.bmh.setBackgroundDrawable(drawable);
    }

    protected void IZ() {
        LayoutInflater.from(this.mContext).inflate(d.h.tb_setting_text_tip_view, (ViewGroup) this, true);
        this.bmf = (LinearLayout) findViewById(d.g.container);
        this.bmg = (TextView) findViewById(d.g.text);
        this.bmh = (TextView) findViewById(d.g.tip);
        this.bml = (ImageView) findViewById(d.g.arrow2);
        this.mBottomLine = findViewById(d.g.bottom_line_ll);
        this.bmk = findViewById(d.g.top_line_ll);
    }

    protected void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.l.TbSettingView);
        if (obtainStyledAttributes != null) {
            String string = obtainStyledAttributes.getString(d.l.TbSettingView_settingText);
            String string2 = obtainStyledAttributes.getString(d.l.TbSettingView_settingTip);
            if (string != null) {
                this.bmg.setText(string);
            }
            if (string2 != null) {
                this.bmh.setText(string2);
            }
            this.bmj = obtainStyledAttributes.getBoolean(d.l.TbSettingView_settingShowArraw, true);
            obtainStyledAttributes.recycle();
        }
        this.bmf.setClickable(false);
        this.bmf.setFocusable(false);
        if (!this.bmj) {
            this.bml.setVisibility(4);
        }
    }

    public void setTopLineVisibility(boolean z) {
        if (z) {
            this.bmk.setVisibility(0);
        } else {
            this.bmk.setVisibility(8);
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
