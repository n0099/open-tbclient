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
    protected LinearLayout axR;
    protected TextView axS;
    protected TextView axT;
    private boolean axV;
    private View axW;
    private View axX;
    protected ImageView axY;
    protected Context mContext;

    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.axV = true;
        this.mContext = context;
        Bz();
        b(attributeSet);
    }

    public TbSettingTextTipView(Context context) {
        super(context);
        this.axV = true;
        this.mContext = context;
        Bz();
    }

    public void displayTip() {
        if (this.axT != null) {
            this.axT.setVisibility(0);
        }
    }

    public void setTipColor(int i) {
        if (this.axT != null) {
            this.axT.setTextColor(i);
        }
    }

    public void setTipStyle(int i) {
        if (this.axT != null) {
        }
    }

    public void g(int i, int i2, int i3, int i4) {
        if (this.axT != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(i, i2, i3, i4);
            this.axT.setLayoutParams(layoutParams);
        }
    }

    public void recycle() {
    }

    public void hideArrow() {
        this.axY.setVisibility(8);
    }

    public void setText(String str) {
        this.axS.setText(str);
    }

    public void setText(int i) {
        this.axS.setText(i);
    }

    public void setTip(String str) {
        this.axT.setText(str);
    }

    public CharSequence getTip() {
        return this.axT.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.axT.setBackgroundDrawable(drawable);
    }

    protected void Bz() {
        LayoutInflater.from(this.mContext).inflate(d.j.tb_setting_text_tip_view, (ViewGroup) this, true);
        this.axR = (LinearLayout) findViewById(d.h.container);
        this.axS = (TextView) findViewById(d.h.text);
        this.axT = (TextView) findViewById(d.h.tip);
        this.axY = (ImageView) findViewById(d.h.arrow2);
        this.axX = findViewById(d.h.bottom_line_ll);
        this.axW = findViewById(d.h.top_line_ll);
    }

    protected void b(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.n.TbSettingView);
        if (obtainStyledAttributes != null) {
            String string = obtainStyledAttributes.getString(d.n.TbSettingView_settingText);
            String string2 = obtainStyledAttributes.getString(d.n.TbSettingView_settingTip);
            if (string != null) {
                this.axS.setText(string);
            }
            if (string2 != null) {
                this.axT.setText(string2);
            }
            this.axV = obtainStyledAttributes.getBoolean(d.n.TbSettingView_settingShowArraw, true);
            obtainStyledAttributes.recycle();
        }
        this.axR.setClickable(false);
        this.axR.setFocusable(false);
        if (!this.axV) {
            this.axY.setVisibility(4);
        }
    }

    public void setTopLineVisibility(boolean z) {
        if (z) {
            this.axW.setVisibility(0);
        } else {
            this.axW.setVisibility(8);
        }
    }

    public void setBottomLineVisibility(boolean z) {
        if (z) {
            this.axX.setVisibility(0);
        } else {
            this.axX.setVisibility(8);
        }
    }
}
