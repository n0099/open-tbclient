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
    protected LinearLayout avC;
    protected TextView avD;
    protected TextView avE;
    private boolean avG;
    private View avH;
    private View avI;
    protected ImageView avJ;
    protected Context mContext;

    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.avG = true;
        this.mContext = context;
        BM();
        d(attributeSet);
    }

    public TbSettingTextTipView(Context context) {
        super(context);
        this.avG = true;
        this.mContext = context;
        BM();
    }

    public void displayTip() {
        if (this.avE != null) {
            this.avE.setVisibility(0);
        }
    }

    public void setTipColor(int i) {
        if (this.avE != null) {
            this.avE.setTextColor(i);
        }
    }

    public void setTipStyle(int i) {
    }

    public void f(int i, int i2, int i3, int i4) {
        if (this.avE != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(i, i2, i3, i4);
            this.avE.setLayoutParams(layoutParams);
        }
    }

    public void recycle() {
    }

    public void hideArrow() {
        this.avJ.setVisibility(8);
    }

    public void setText(String str) {
        this.avD.setText(str);
    }

    public void setText(int i) {
        this.avD.setText(i);
    }

    public void setTip(String str) {
        this.avE.setText(str);
    }

    public CharSequence getTip() {
        return this.avE.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.avE.setBackgroundDrawable(drawable);
    }

    protected void BM() {
        LayoutInflater.from(this.mContext).inflate(w.j.tb_setting_text_tip_view, (ViewGroup) this, true);
        this.avC = (LinearLayout) findViewById(w.h.container);
        this.avD = (TextView) findViewById(w.h.text);
        this.avE = (TextView) findViewById(w.h.tip);
        this.avJ = (ImageView) findViewById(w.h.arrow2);
        this.avI = findViewById(w.h.bottom_line_ll);
        this.avH = findViewById(w.h.top_line_ll);
    }

    protected void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, w.n.TbSettingView);
        if (obtainStyledAttributes != null) {
            String string = obtainStyledAttributes.getString(0);
            String string2 = obtainStyledAttributes.getString(3);
            if (string != null) {
                this.avD.setText(string);
            }
            if (string2 != null) {
                this.avE.setText(string2);
            }
            this.avG = obtainStyledAttributes.getBoolean(5, true);
            obtainStyledAttributes.recycle();
        }
        this.avC.setClickable(false);
        this.avC.setFocusable(false);
        if (!this.avG) {
            this.avJ.setVisibility(4);
        }
    }

    public void setTopLineVisibility(boolean z) {
        if (z) {
            this.avH.setVisibility(0);
        } else {
            this.avH.setVisibility(8);
        }
    }

    public void setBottomLineVisibility(boolean z) {
        if (z) {
            this.avI.setVisibility(0);
        } else {
            this.avI.setVisibility(8);
        }
    }
}
