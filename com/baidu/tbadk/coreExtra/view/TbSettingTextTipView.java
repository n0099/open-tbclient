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
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class TbSettingTextTipView extends FrameLayout {
    protected LinearLayout avE;
    protected TextView avF;
    protected TextView avG;
    private boolean avI;
    private View avJ;
    private View avK;
    protected ImageView avL;
    protected Context mContext;

    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.avI = true;
        this.mContext = context;
        BM();
        d(attributeSet);
    }

    public TbSettingTextTipView(Context context) {
        super(context);
        this.avI = true;
        this.mContext = context;
        BM();
    }

    public void displayTip() {
        if (this.avG != null) {
            this.avG.setVisibility(0);
        }
    }

    public void setTipColor(int i) {
        if (this.avG != null) {
            this.avG.setTextColor(i);
        }
    }

    public void setTipStyle(int i) {
    }

    public void f(int i, int i2, int i3, int i4) {
        if (this.avG != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(i, i2, i3, i4);
            this.avG.setLayoutParams(layoutParams);
        }
    }

    public void recycle() {
    }

    public void hideArrow() {
        this.avL.setVisibility(8);
    }

    public void setText(String str) {
        this.avF.setText(str);
    }

    public void setText(int i) {
        this.avF.setText(i);
    }

    public void setTip(String str) {
        this.avG.setText(str);
    }

    public CharSequence getTip() {
        return this.avG.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.avG.setBackgroundDrawable(drawable);
    }

    protected void BM() {
        LayoutInflater.from(this.mContext).inflate(w.j.tb_setting_text_tip_view, (ViewGroup) this, true);
        this.avE = (LinearLayout) findViewById(w.h.container);
        this.avF = (TextView) findViewById(w.h.text);
        this.avG = (TextView) findViewById(w.h.tip);
        this.avL = (ImageView) findViewById(w.h.arrow2);
        this.avK = findViewById(w.h.bottom_line_ll);
        this.avJ = findViewById(w.h.top_line_ll);
    }

    protected void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, w.n.TbSettingView);
        if (obtainStyledAttributes != null) {
            String string = obtainStyledAttributes.getString(0);
            String string2 = obtainStyledAttributes.getString(3);
            if (string != null) {
                this.avF.setText(string);
            }
            if (string2 != null) {
                this.avG.setText(string2);
            }
            this.avI = obtainStyledAttributes.getBoolean(5, true);
            obtainStyledAttributes.recycle();
        }
        this.avE.setClickable(false);
        this.avE.setFocusable(false);
        if (!this.avI) {
            this.avL.setVisibility(4);
        }
    }

    public void setTopLineVisibility(boolean z) {
        if (z) {
            this.avJ.setVisibility(0);
        } else {
            this.avJ.setVisibility(8);
        }
    }

    public void setBottomLineVisibility(boolean z) {
        if (z) {
            this.avK.setVisibility(0);
        } else {
            this.avK.setVisibility(8);
        }
    }
}
