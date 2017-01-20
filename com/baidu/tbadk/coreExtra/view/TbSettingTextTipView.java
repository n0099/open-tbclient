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
    private View FN;
    protected LinearLayout apS;
    protected TextView apT;
    protected TextView apU;
    private boolean apW;
    private View apX;
    protected ImageView apY;
    protected Context mContext;

    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.apW = true;
        this.mContext = context;
        AV();
        d(attributeSet);
    }

    public TbSettingTextTipView(Context context) {
        super(context);
        this.apW = true;
        this.mContext = context;
        AV();
    }

    public void displayTip() {
        if (this.apU != null) {
            this.apU.setVisibility(0);
        }
    }

    public void setTipColor(int i) {
        if (this.apU != null) {
            this.apU.setTextColor(i);
        }
    }

    public void setTipStyle(int i) {
    }

    public void f(int i, int i2, int i3, int i4) {
        if (this.apU != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(i, i2, i3, i4);
            this.apU.setLayoutParams(layoutParams);
        }
    }

    public void recycle() {
    }

    public void hideArrow() {
        this.apY.setVisibility(8);
    }

    public void setText(String str) {
        this.apT.setText(str);
    }

    public void setText(int i) {
        this.apT.setText(i);
    }

    public void setTip(String str) {
        this.apU.setText(str);
    }

    public CharSequence getTip() {
        return this.apU.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.apU.setBackgroundDrawable(drawable);
    }

    protected void AV() {
        LayoutInflater.from(this.mContext).inflate(r.j.tb_setting_text_tip_view, (ViewGroup) this, true);
        this.apS = (LinearLayout) findViewById(r.h.container);
        this.apT = (TextView) findViewById(r.h.text);
        this.apU = (TextView) findViewById(r.h.tip);
        this.apY = (ImageView) findViewById(r.h.arrow2);
        this.FN = findViewById(r.h.bottom_line_ll);
        this.apX = findViewById(r.h.top_line_ll);
    }

    protected void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, r.n.TbSettingView);
        if (obtainStyledAttributes != null) {
            String string = obtainStyledAttributes.getString(0);
            String string2 = obtainStyledAttributes.getString(3);
            if (string != null) {
                this.apT.setText(string);
            }
            if (string2 != null) {
                this.apU.setText(string2);
            }
            this.apW = obtainStyledAttributes.getBoolean(5, true);
            obtainStyledAttributes.recycle();
        }
        this.apS.setClickable(false);
        this.apS.setFocusable(false);
        if (!this.apW) {
            this.apY.setVisibility(4);
        }
    }

    public void setTopLineVisibility(boolean z) {
        if (z) {
            this.apX.setVisibility(0);
        } else {
            this.apX.setVisibility(8);
        }
    }

    public void setBottomLineVisibility(boolean z) {
        if (z) {
            this.FN.setVisibility(0);
        } else {
            this.FN.setVisibility(8);
        }
    }
}
