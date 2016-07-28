package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class SettingTextSwitchView extends FrameLayout {
    private LinearLayout anA;
    private TextView anB;
    protected TextView anC;
    private BdSwitchView anD;
    private final Context mContext;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        zN();
        d(attributeSet);
        dT(TbadkCoreApplication.m10getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        zN();
        dT(TbadkCoreApplication.m10getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        zN();
        d(attributeSet);
        dT(TbadkCoreApplication.m10getInst().getSkinType());
    }

    public View getView() {
        return this.anA;
    }

    public void dT(int i) {
        this.anD.a(av.cA(u.f.bg_switch_open), av.cA(u.f.bg_switch_close), av.cA(u.f.btn_handle));
        av.c(this.anB, u.d.cp_cont_b, 1);
        if (this.anC != null) {
            av.c(this.anC, u.d.cp_cont_d, 1);
        }
    }

    public void iB() {
        this.anD.iB();
        this.anD.setContentDescription(String.valueOf(this.mContext.getString(u.j.talk_message_tip)) + this.mContext.getString(u.j.talk_close));
    }

    public void iA() {
        this.anD.iA();
        this.anD.setContentDescription(String.valueOf(this.mContext.getString(u.j.talk_message_tip)) + this.mContext.getString(u.j.talk_open));
    }

    public void N(boolean z) {
        this.anD.N(z);
        this.anD.setContentDescription(String.valueOf(this.mContext.getString(u.j.talk_message_tip)) + this.mContext.getString(u.j.talk_close));
    }

    public void M(boolean z) {
        this.anD.M(z);
        this.anD.setContentDescription(String.valueOf(this.mContext.getString(u.j.talk_message_tip)) + this.mContext.getString(u.j.talk_open));
    }

    public void setText(String str) {
        this.anB.setText(str);
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.anD.setOnSwitchStateChangeListener(aVar);
    }

    private void zN() {
        LayoutInflater.from(this.mContext).inflate(u.h.setting_text_switch_view, (ViewGroup) this, true);
        this.anA = (LinearLayout) findViewById(u.g.container);
        this.anB = (TextView) findViewById(u.g.text);
        this.anD = (BdSwitchView) findViewById(u.g.button);
        this.anD.setFocusable(true);
        this.anC = (TextView) findViewById(u.g.tip);
        if (this.anC != null) {
            this.anC.setVisibility(8);
        }
        setTag(this.anD);
        this.anA.setClickable(false);
        this.anA.setFocusable(false);
    }

    private void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, u.l.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        float dimension = obtainStyledAttributes.getDimension(2, -1.0f);
        String string2 = obtainStyledAttributes.getString(3);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (this.anC != null && string2 != null) {
            this.anC.setVisibility(0);
            this.anC.setText(string2);
            if (color2 > -1) {
                this.anC.setTextColor(color2);
            }
        }
        if (string != null) {
            this.anB.setText(string);
        }
        if (color > -1) {
            this.anB.setTextColor(color);
        }
        if (dimension > -1.0f) {
            this.anB.setTextSize(0, dimension);
        }
        this.anA.setClickable(false);
        this.anA.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.anC != null) {
            displayTip();
            this.anC.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.anC != null) {
            displayTip();
            this.anC.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.anC != null) {
            this.anC.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.anC != null) {
            this.anC.setVisibility(8);
        }
    }

    public void setTextLeftMargin(int i) {
        if (this.anB.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.anB.getLayoutParams();
            layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(i);
            this.anB.setLayoutParams(layoutParams);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.anD;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.anD = bdSwitchView;
    }
}
