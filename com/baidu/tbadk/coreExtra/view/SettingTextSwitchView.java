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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class SettingTextSwitchView extends FrameLayout {
    private LinearLayout aUA;
    protected TextView aUB;
    private BdSwitchView aUC;
    private TextView aiY;
    private final Context mContext;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        Ky();
        c(attributeSet);
        fv(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        Ky();
        fv(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        Ky();
        c(attributeSet);
        fv(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.aUA;
    }

    public void fv(int i) {
        this.aUC.setBackgroundRes(al.dO(e.f.bg_switch_open), al.dO(e.f.bg_switch_close), al.dO(e.f.btn_handle));
        al.c(this.aiY, e.d.cp_cont_b, 1);
        if (this.aUB != null) {
            al.c(this.aUB, e.d.cp_cont_d, 1);
        }
    }

    public void nS() {
        this.aUC.nS();
        this.aUC.setContentDescription(this.mContext.getString(e.j.talk_message_tip) + this.mContext.getString(e.j.talk_close));
    }

    public void nR() {
        this.aUC.nR();
        this.aUC.setContentDescription(this.mContext.getString(e.j.talk_message_tip) + this.mContext.getString(e.j.talk_open));
    }

    public void as(boolean z) {
        this.aUC.as(z);
        this.aUC.setContentDescription(this.mContext.getString(e.j.talk_message_tip) + this.mContext.getString(e.j.talk_close));
    }

    public void ar(boolean z) {
        this.aUC.ar(z);
        this.aUC.setContentDescription(this.mContext.getString(e.j.talk_message_tip) + this.mContext.getString(e.j.talk_open));
    }

    public void setText(String str) {
        this.aiY.setText(str);
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.aUC.setOnSwitchStateChangeListener(aVar);
    }

    private void Ky() {
        LayoutInflater.from(this.mContext).inflate(e.h.setting_text_switch_view, (ViewGroup) this, true);
        this.aUA = (LinearLayout) findViewById(e.g.container);
        this.aiY = (TextView) findViewById(e.g.text);
        this.aUC = (BdSwitchView) findViewById(e.g.button);
        this.aUC.setFocusable(true);
        this.aUB = (TextView) findViewById(e.g.tip);
        if (this.aUB != null) {
            this.aUB.setVisibility(8);
        }
        setTag(this.aUC);
        this.aUA.setClickable(false);
        this.aUA.setFocusable(false);
    }

    private void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, e.l.TbSettingView);
        String string = obtainStyledAttributes.getString(e.l.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(e.l.TbSettingView_settingTextColor, -1);
        float dimension = obtainStyledAttributes.getDimension(e.l.TbSettingView_settingTextSize, -1.0f);
        String string2 = obtainStyledAttributes.getString(e.l.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(e.l.TbSettingView_settingTipColor, -1);
        if (this.aUB != null && string2 != null) {
            this.aUB.setVisibility(0);
            this.aUB.setText(string2);
            if (color2 > -1) {
                this.aUB.setTextColor(color2);
            }
        }
        if (string != null) {
            this.aiY.setText(string);
        }
        if (color > -1) {
            this.aiY.setTextColor(color);
        }
        if (dimension > -1.0f) {
            this.aiY.setTextSize(0, dimension);
        }
        this.aUA.setClickable(false);
        this.aUA.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.aUB != null) {
            displayTip();
            this.aUB.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.aUB != null) {
            displayTip();
            this.aUB.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.aUB != null) {
            this.aUB.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.aUB != null) {
            this.aUB.setVisibility(8);
        }
    }

    public void setTextLeftMargin(int i) {
        if (this.aiY.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aiY.getLayoutParams();
            layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(i);
            this.aiY.setLayoutParams(layoutParams);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.aUC;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.aUC = bdSwitchView;
    }
}
