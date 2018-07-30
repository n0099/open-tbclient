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
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class SettingTextSwitchView extends FrameLayout {
    private LinearLayout aIs;
    private TextView aIt;
    protected TextView aIu;
    private BdSwitchView aIv;
    private final Context mContext;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        FQ();
        c(attributeSet);
        ey(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        FQ();
        ey(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        FQ();
        c(attributeSet);
        ey(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.aIs;
    }

    public void ey(int i) {
        this.aIv.setBackgroundRes(am.cT(d.f.bg_switch_open), am.cT(d.f.bg_switch_close), am.cT(d.f.btn_handle));
        am.c(this.aIt, d.C0140d.cp_cont_b, 1);
        if (this.aIu != null) {
            am.c(this.aIu, d.C0140d.cp_cont_d, 1);
        }
    }

    public void mF() {
        this.aIv.mF();
        this.aIv.setContentDescription(this.mContext.getString(d.j.talk_message_tip) + this.mContext.getString(d.j.talk_close));
    }

    public void mE() {
        this.aIv.mE();
        this.aIv.setContentDescription(this.mContext.getString(d.j.talk_message_tip) + this.mContext.getString(d.j.talk_open));
    }

    public void V(boolean z) {
        this.aIv.V(z);
        this.aIv.setContentDescription(this.mContext.getString(d.j.talk_message_tip) + this.mContext.getString(d.j.talk_close));
    }

    public void U(boolean z) {
        this.aIv.U(z);
        this.aIv.setContentDescription(this.mContext.getString(d.j.talk_message_tip) + this.mContext.getString(d.j.talk_open));
    }

    public void setText(String str) {
        this.aIt.setText(str);
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.aIv.setOnSwitchStateChangeListener(aVar);
    }

    private void FQ() {
        LayoutInflater.from(this.mContext).inflate(d.h.setting_text_switch_view, (ViewGroup) this, true);
        this.aIs = (LinearLayout) findViewById(d.g.container);
        this.aIt = (TextView) findViewById(d.g.text);
        this.aIv = (BdSwitchView) findViewById(d.g.button);
        this.aIv.setFocusable(true);
        this.aIu = (TextView) findViewById(d.g.tip);
        if (this.aIu != null) {
            this.aIu.setVisibility(8);
        }
        setTag(this.aIv);
        this.aIs.setClickable(false);
        this.aIs.setFocusable(false);
    }

    private void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.l.TbSettingView);
        String string = obtainStyledAttributes.getString(d.l.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(d.l.TbSettingView_settingTextColor, -1);
        float dimension = obtainStyledAttributes.getDimension(d.l.TbSettingView_settingTextSize, -1.0f);
        String string2 = obtainStyledAttributes.getString(d.l.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(d.l.TbSettingView_settingTipColor, -1);
        if (this.aIu != null && string2 != null) {
            this.aIu.setVisibility(0);
            this.aIu.setText(string2);
            if (color2 > -1) {
                this.aIu.setTextColor(color2);
            }
        }
        if (string != null) {
            this.aIt.setText(string);
        }
        if (color > -1) {
            this.aIt.setTextColor(color);
        }
        if (dimension > -1.0f) {
            this.aIt.setTextSize(0, dimension);
        }
        this.aIs.setClickable(false);
        this.aIs.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.aIu != null) {
            displayTip();
            this.aIu.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.aIu != null) {
            displayTip();
            this.aIu.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.aIu != null) {
            this.aIu.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.aIu != null) {
            this.aIu.setVisibility(8);
        }
    }

    public void setTextLeftMargin(int i) {
        if (this.aIt.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aIt.getLayoutParams();
            layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(i);
            this.aIt.setLayoutParams(layoutParams);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.aIv;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.aIv = bdSwitchView;
    }
}
