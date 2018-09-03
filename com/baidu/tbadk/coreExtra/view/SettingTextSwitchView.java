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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.f;
/* loaded from: classes.dex */
public class SettingTextSwitchView extends FrameLayout {
    private LinearLayout aIq;
    private TextView aIr;
    protected TextView aIs;
    private BdSwitchView aIt;
    private final Context mContext;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        FQ();
        c(attributeSet);
        ex(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        FQ();
        ex(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        FQ();
        c(attributeSet);
        ex(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.aIq;
    }

    public void ex(int i) {
        this.aIt.setBackgroundRes(am.cT(f.C0146f.bg_switch_open), am.cT(f.C0146f.bg_switch_close), am.cT(f.C0146f.btn_handle));
        am.c(this.aIr, f.d.cp_cont_b, 1);
        if (this.aIs != null) {
            am.c(this.aIs, f.d.cp_cont_d, 1);
        }
    }

    public void mF() {
        this.aIt.mF();
        this.aIt.setContentDescription(this.mContext.getString(f.j.talk_message_tip) + this.mContext.getString(f.j.talk_close));
    }

    public void mE() {
        this.aIt.mE();
        this.aIt.setContentDescription(this.mContext.getString(f.j.talk_message_tip) + this.mContext.getString(f.j.talk_open));
    }

    public void V(boolean z) {
        this.aIt.V(z);
        this.aIt.setContentDescription(this.mContext.getString(f.j.talk_message_tip) + this.mContext.getString(f.j.talk_close));
    }

    public void U(boolean z) {
        this.aIt.U(z);
        this.aIt.setContentDescription(this.mContext.getString(f.j.talk_message_tip) + this.mContext.getString(f.j.talk_open));
    }

    public void setText(String str) {
        this.aIr.setText(str);
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.aIt.setOnSwitchStateChangeListener(aVar);
    }

    private void FQ() {
        LayoutInflater.from(this.mContext).inflate(f.h.setting_text_switch_view, (ViewGroup) this, true);
        this.aIq = (LinearLayout) findViewById(f.g.container);
        this.aIr = (TextView) findViewById(f.g.text);
        this.aIt = (BdSwitchView) findViewById(f.g.button);
        this.aIt.setFocusable(true);
        this.aIs = (TextView) findViewById(f.g.tip);
        if (this.aIs != null) {
            this.aIs.setVisibility(8);
        }
        setTag(this.aIt);
        this.aIq.setClickable(false);
        this.aIq.setFocusable(false);
    }

    private void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, f.l.TbSettingView);
        String string = obtainStyledAttributes.getString(f.l.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(f.l.TbSettingView_settingTextColor, -1);
        float dimension = obtainStyledAttributes.getDimension(f.l.TbSettingView_settingTextSize, -1.0f);
        String string2 = obtainStyledAttributes.getString(f.l.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(f.l.TbSettingView_settingTipColor, -1);
        if (this.aIs != null && string2 != null) {
            this.aIs.setVisibility(0);
            this.aIs.setText(string2);
            if (color2 > -1) {
                this.aIs.setTextColor(color2);
            }
        }
        if (string != null) {
            this.aIr.setText(string);
        }
        if (color > -1) {
            this.aIr.setTextColor(color);
        }
        if (dimension > -1.0f) {
            this.aIr.setTextSize(0, dimension);
        }
        this.aIq.setClickable(false);
        this.aIq.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.aIs != null) {
            displayTip();
            this.aIs.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.aIs != null) {
            displayTip();
            this.aIs.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.aIs != null) {
            this.aIs.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.aIs != null) {
            this.aIs.setVisibility(8);
        }
    }

    public void setTextLeftMargin(int i) {
        if (this.aIr.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aIr.getLayoutParams();
            layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(i);
            this.aIr.setLayoutParams(layoutParams);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.aIt;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.aIt = bdSwitchView;
    }
}
