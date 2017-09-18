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
    protected LinearLayout axO;
    protected TextView axP;
    protected TextView axQ;
    private boolean axS;
    private View axT;
    private View axU;
    protected ImageView axV;
    protected Context mContext;

    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.axS = true;
        this.mContext = context;
        Bz();
        b(attributeSet);
    }

    public TbSettingTextTipView(Context context) {
        super(context);
        this.axS = true;
        this.mContext = context;
        Bz();
    }

    public void displayTip() {
        if (this.axQ != null) {
            this.axQ.setVisibility(0);
        }
    }

    public void setTipColor(int i) {
        if (this.axQ != null) {
            this.axQ.setTextColor(i);
        }
    }

    public void setTipStyle(int i) {
        if (this.axQ != null) {
        }
    }

    public void g(int i, int i2, int i3, int i4) {
        if (this.axQ != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(i, i2, i3, i4);
            this.axQ.setLayoutParams(layoutParams);
        }
    }

    public void recycle() {
    }

    public void hideArrow() {
        this.axV.setVisibility(8);
    }

    public void setText(String str) {
        this.axP.setText(str);
    }

    public void setText(int i) {
        this.axP.setText(i);
    }

    public void setTip(String str) {
        this.axQ.setText(str);
    }

    public CharSequence getTip() {
        return this.axQ.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.axQ.setBackgroundDrawable(drawable);
    }

    protected void Bz() {
        LayoutInflater.from(this.mContext).inflate(d.j.tb_setting_text_tip_view, (ViewGroup) this, true);
        this.axO = (LinearLayout) findViewById(d.h.container);
        this.axP = (TextView) findViewById(d.h.text);
        this.axQ = (TextView) findViewById(d.h.tip);
        this.axV = (ImageView) findViewById(d.h.arrow2);
        this.axU = findViewById(d.h.bottom_line_ll);
        this.axT = findViewById(d.h.top_line_ll);
    }

    protected void b(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.n.TbSettingView);
        if (obtainStyledAttributes != null) {
            String string = obtainStyledAttributes.getString(d.n.TbSettingView_settingText);
            String string2 = obtainStyledAttributes.getString(d.n.TbSettingView_settingTip);
            if (string != null) {
                this.axP.setText(string);
            }
            if (string2 != null) {
                this.axQ.setText(string2);
            }
            this.axS = obtainStyledAttributes.getBoolean(d.n.TbSettingView_settingShowArraw, true);
            obtainStyledAttributes.recycle();
        }
        this.axO.setClickable(false);
        this.axO.setFocusable(false);
        if (!this.axS) {
            this.axV.setVisibility(4);
        }
    }

    public void setTopLineVisibility(boolean z) {
        if (z) {
            this.axT.setVisibility(0);
        } else {
            this.axT.setVisibility(8);
        }
    }

    public void setBottomLineVisibility(boolean z) {
        if (z) {
            this.axU.setVisibility(0);
        } else {
            this.axU.setVisibility(8);
        }
    }
}
