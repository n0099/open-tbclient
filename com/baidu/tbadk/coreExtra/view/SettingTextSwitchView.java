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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class SettingTextSwitchView extends FrameLayout {
    private LinearLayout boA;
    private TextView boB;
    protected TextView boC;
    private BdSwitchView boD;
    private final Context mContext;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        Jv();
        d(attributeSet);
        hr(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        Jv();
        hr(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        Jv();
        d(attributeSet);
        hr(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.boA;
    }

    public void hr(int i) {
        this.boD.a(aj.fO(d.f.bg_switch_open), aj.fO(d.f.bg_switch_close), aj.fO(d.f.btn_handle));
        aj.e(this.boB, d.C0141d.cp_cont_b, 1);
        if (this.boC != null) {
            aj.e(this.boC, d.C0141d.cp_cont_d, 1);
        }
    }

    public void rK() {
        this.boD.rK();
        this.boD.setContentDescription(this.mContext.getString(d.j.talk_message_tip) + this.mContext.getString(d.j.talk_close));
    }

    public void rJ() {
        this.boD.rJ();
        this.boD.setContentDescription(this.mContext.getString(d.j.talk_message_tip) + this.mContext.getString(d.j.talk_open));
    }

    public void aB(boolean z) {
        this.boD.aB(z);
        this.boD.setContentDescription(this.mContext.getString(d.j.talk_message_tip) + this.mContext.getString(d.j.talk_close));
    }

    public void aA(boolean z) {
        this.boD.aA(z);
        this.boD.setContentDescription(this.mContext.getString(d.j.talk_message_tip) + this.mContext.getString(d.j.talk_open));
    }

    public void setText(String str) {
        this.boB.setText(str);
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.boD.setOnSwitchStateChangeListener(aVar);
    }

    private void Jv() {
        LayoutInflater.from(this.mContext).inflate(d.h.setting_text_switch_view, (ViewGroup) this, true);
        this.boA = (LinearLayout) findViewById(d.g.container);
        this.boB = (TextView) findViewById(d.g.text);
        this.boD = (BdSwitchView) findViewById(d.g.button);
        this.boD.setFocusable(true);
        this.boC = (TextView) findViewById(d.g.tip);
        if (this.boC != null) {
            this.boC.setVisibility(8);
        }
        setTag(this.boD);
        this.boA.setClickable(false);
        this.boA.setFocusable(false);
    }

    private void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.l.TbSettingView);
        String string = obtainStyledAttributes.getString(d.l.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(d.l.TbSettingView_settingTextColor, -1);
        float dimension = obtainStyledAttributes.getDimension(d.l.TbSettingView_settingTextSize, -1.0f);
        String string2 = obtainStyledAttributes.getString(d.l.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(d.l.TbSettingView_settingTipColor, -1);
        if (this.boC != null && string2 != null) {
            this.boC.setVisibility(0);
            this.boC.setText(string2);
            if (color2 > -1) {
                this.boC.setTextColor(color2);
            }
        }
        if (string != null) {
            this.boB.setText(string);
        }
        if (color > -1) {
            this.boB.setTextColor(color);
        }
        if (dimension > -1.0f) {
            this.boB.setTextSize(0, dimension);
        }
        this.boA.setClickable(false);
        this.boA.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.boC != null) {
            displayTip();
            this.boC.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.boC != null) {
            displayTip();
            this.boC.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.boC != null) {
            this.boC.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.boC != null) {
            this.boC.setVisibility(8);
        }
    }

    public void setTextLeftMargin(int i) {
        if (this.boB.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.boB.getLayoutParams();
            layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(i);
            this.boB.setLayoutParams(layoutParams);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.boD;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.boD = bdSwitchView;
    }
}
