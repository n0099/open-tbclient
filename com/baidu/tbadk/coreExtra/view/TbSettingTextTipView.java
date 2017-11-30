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
    protected LinearLayout axS;
    protected TextView axT;
    protected TextView axU;
    private boolean axW;
    private View axX;
    protected ImageView axY;
    private View mBottomLine;
    protected Context mContext;

    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.axW = true;
        this.mContext = context;
        Bw();
        b(attributeSet);
    }

    public TbSettingTextTipView(Context context) {
        super(context);
        this.axW = true;
        this.mContext = context;
        Bw();
    }

    public void displayTip() {
        if (this.axU != null) {
            this.axU.setVisibility(0);
        }
    }

    public void setTipColor(int i) {
        if (this.axU != null) {
            this.axU.setTextColor(i);
        }
    }

    public void setTipStyle(int i) {
        if (this.axU != null) {
        }
    }

    public void g(int i, int i2, int i3, int i4) {
        if (this.axU != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(i, i2, i3, i4);
            this.axU.setLayoutParams(layoutParams);
        }
    }

    public void recycle() {
    }

    public void hideArrow() {
        this.axY.setVisibility(8);
    }

    public void setText(String str) {
        this.axT.setText(str);
    }

    public void setText(int i) {
        this.axT.setText(i);
    }

    public void setTip(String str) {
        this.axU.setText(str);
    }

    public CharSequence getTip() {
        return this.axU.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.axU.setBackgroundDrawable(drawable);
    }

    protected void Bw() {
        LayoutInflater.from(this.mContext).inflate(d.h.tb_setting_text_tip_view, (ViewGroup) this, true);
        this.axS = (LinearLayout) findViewById(d.g.container);
        this.axT = (TextView) findViewById(d.g.text);
        this.axU = (TextView) findViewById(d.g.tip);
        this.axY = (ImageView) findViewById(d.g.arrow2);
        this.mBottomLine = findViewById(d.g.bottom_line_ll);
        this.axX = findViewById(d.g.top_line_ll);
    }

    protected void b(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.l.TbSettingView);
        if (obtainStyledAttributes != null) {
            String string = obtainStyledAttributes.getString(d.l.TbSettingView_settingText);
            String string2 = obtainStyledAttributes.getString(d.l.TbSettingView_settingTip);
            if (string != null) {
                this.axT.setText(string);
            }
            if (string2 != null) {
                this.axU.setText(string2);
            }
            this.axW = obtainStyledAttributes.getBoolean(d.l.TbSettingView_settingShowArraw, true);
            obtainStyledAttributes.recycle();
        }
        this.axS.setClickable(false);
        this.axS.setFocusable(false);
        if (!this.axW) {
            this.axY.setVisibility(4);
        }
    }

    public void setTopLineVisibility(boolean z) {
        if (z) {
            this.axX.setVisibility(0);
        } else {
            this.axX.setVisibility(8);
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
