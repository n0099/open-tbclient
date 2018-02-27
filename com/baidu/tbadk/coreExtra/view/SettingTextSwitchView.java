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
    private BdSwitchView boA;
    private LinearLayout box;
    private TextView boy;
    protected TextView boz;
    private final Context mContext;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        Ju();
        d(attributeSet);
        hr(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        Ju();
        hr(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        Ju();
        d(attributeSet);
        hr(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.box;
    }

    public void hr(int i) {
        this.boA.a(aj.fO(d.f.bg_switch_open), aj.fO(d.f.bg_switch_close), aj.fO(d.f.btn_handle));
        aj.e(this.boy, d.C0141d.cp_cont_b, 1);
        if (this.boz != null) {
            aj.e(this.boz, d.C0141d.cp_cont_d, 1);
        }
    }

    public void rK() {
        this.boA.rK();
        this.boA.setContentDescription(this.mContext.getString(d.j.talk_message_tip) + this.mContext.getString(d.j.talk_close));
    }

    public void rJ() {
        this.boA.rJ();
        this.boA.setContentDescription(this.mContext.getString(d.j.talk_message_tip) + this.mContext.getString(d.j.talk_open));
    }

    public void aB(boolean z) {
        this.boA.aB(z);
        this.boA.setContentDescription(this.mContext.getString(d.j.talk_message_tip) + this.mContext.getString(d.j.talk_close));
    }

    public void aA(boolean z) {
        this.boA.aA(z);
        this.boA.setContentDescription(this.mContext.getString(d.j.talk_message_tip) + this.mContext.getString(d.j.talk_open));
    }

    public void setText(String str) {
        this.boy.setText(str);
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.boA.setOnSwitchStateChangeListener(aVar);
    }

    private void Ju() {
        LayoutInflater.from(this.mContext).inflate(d.h.setting_text_switch_view, (ViewGroup) this, true);
        this.box = (LinearLayout) findViewById(d.g.container);
        this.boy = (TextView) findViewById(d.g.text);
        this.boA = (BdSwitchView) findViewById(d.g.button);
        this.boA.setFocusable(true);
        this.boz = (TextView) findViewById(d.g.tip);
        if (this.boz != null) {
            this.boz.setVisibility(8);
        }
        setTag(this.boA);
        this.box.setClickable(false);
        this.box.setFocusable(false);
    }

    private void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.l.TbSettingView);
        String string = obtainStyledAttributes.getString(d.l.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(d.l.TbSettingView_settingTextColor, -1);
        float dimension = obtainStyledAttributes.getDimension(d.l.TbSettingView_settingTextSize, -1.0f);
        String string2 = obtainStyledAttributes.getString(d.l.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(d.l.TbSettingView_settingTipColor, -1);
        if (this.boz != null && string2 != null) {
            this.boz.setVisibility(0);
            this.boz.setText(string2);
            if (color2 > -1) {
                this.boz.setTextColor(color2);
            }
        }
        if (string != null) {
            this.boy.setText(string);
        }
        if (color > -1) {
            this.boy.setTextColor(color);
        }
        if (dimension > -1.0f) {
            this.boy.setTextSize(0, dimension);
        }
        this.box.setClickable(false);
        this.box.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.boz != null) {
            displayTip();
            this.boz.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.boz != null) {
            displayTip();
            this.boz.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.boz != null) {
            this.boz.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.boz != null) {
            this.boz.setVisibility(8);
        }
    }

    public void setTextLeftMargin(int i) {
        if (this.boy.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.boy.getLayoutParams();
            layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(i);
            this.boy.setLayoutParams(layoutParams);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.boA;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.boA = bdSwitchView;
    }
}
