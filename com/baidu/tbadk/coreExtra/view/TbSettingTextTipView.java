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
    protected LinearLayout axr;
    protected TextView axs;
    protected TextView axt;
    private boolean axv;
    private View axw;
    protected ImageView axx;
    private View mBottomLine;
    protected Context mContext;

    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.axv = true;
        this.mContext = context;
        Bm();
        b(attributeSet);
    }

    public TbSettingTextTipView(Context context) {
        super(context);
        this.axv = true;
        this.mContext = context;
        Bm();
    }

    public void displayTip() {
        if (this.axt != null) {
            this.axt.setVisibility(0);
        }
    }

    public void setTipColor(int i) {
        if (this.axt != null) {
            this.axt.setTextColor(i);
        }
    }

    public void setTipStyle(int i) {
        if (this.axt != null) {
        }
    }

    public void g(int i, int i2, int i3, int i4) {
        if (this.axt != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(i, i2, i3, i4);
            this.axt.setLayoutParams(layoutParams);
        }
    }

    public void recycle() {
    }

    public void hideArrow() {
        this.axx.setVisibility(8);
    }

    public void setText(String str) {
        this.axs.setText(str);
    }

    public void setText(int i) {
        this.axs.setText(i);
    }

    public void setTip(String str) {
        this.axt.setText(str);
    }

    public CharSequence getTip() {
        return this.axt.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.axt.setBackgroundDrawable(drawable);
    }

    protected void Bm() {
        LayoutInflater.from(this.mContext).inflate(d.h.tb_setting_text_tip_view, (ViewGroup) this, true);
        this.axr = (LinearLayout) findViewById(d.g.container);
        this.axs = (TextView) findViewById(d.g.text);
        this.axt = (TextView) findViewById(d.g.tip);
        this.axx = (ImageView) findViewById(d.g.arrow2);
        this.mBottomLine = findViewById(d.g.bottom_line_ll);
        this.axw = findViewById(d.g.top_line_ll);
    }

    protected void b(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.l.TbSettingView);
        if (obtainStyledAttributes != null) {
            String string = obtainStyledAttributes.getString(d.l.TbSettingView_settingText);
            String string2 = obtainStyledAttributes.getString(d.l.TbSettingView_settingTip);
            if (string != null) {
                this.axs.setText(string);
            }
            if (string2 != null) {
                this.axt.setText(string2);
            }
            this.axv = obtainStyledAttributes.getBoolean(d.l.TbSettingView_settingShowArraw, true);
            obtainStyledAttributes.recycle();
        }
        this.axr.setClickable(false);
        this.axr.setFocusable(false);
        if (!this.axv) {
            this.axx.setVisibility(4);
        }
    }

    public void setTopLineVisibility(boolean z) {
        if (z) {
            this.axw.setVisibility(0);
        } else {
            this.axw.setVisibility(8);
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
