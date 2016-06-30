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
    private LinearLayout amL;
    private TextView amM;
    protected TextView amN;
    private BdSwitchView amO;
    private final Context mContext;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        zN();
        d(attributeSet);
        dT(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        zN();
        dT(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        zN();
        d(attributeSet);
        dT(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public View getView() {
        return this.amL;
    }

    public void dT(int i) {
        this.amO.a(av.cA(u.f.bg_switch_open), av.cA(u.f.bg_switch_close), av.cA(u.f.btn_handle));
        av.c(this.amM, u.d.cp_cont_b, 1);
        if (this.amN != null) {
            av.c(this.amN, u.d.cp_cont_d, 1);
        }
    }

    public void iC() {
        this.amO.iC();
        this.amO.setContentDescription(String.valueOf(this.mContext.getString(u.j.talk_message_tip)) + this.mContext.getString(u.j.talk_close));
    }

    public void iB() {
        this.amO.iB();
        this.amO.setContentDescription(String.valueOf(this.mContext.getString(u.j.talk_message_tip)) + this.mContext.getString(u.j.talk_open));
    }

    public void L(boolean z) {
        this.amO.L(z);
        this.amO.setContentDescription(String.valueOf(this.mContext.getString(u.j.talk_message_tip)) + this.mContext.getString(u.j.talk_close));
    }

    public void K(boolean z) {
        this.amO.K(z);
        this.amO.setContentDescription(String.valueOf(this.mContext.getString(u.j.talk_message_tip)) + this.mContext.getString(u.j.talk_open));
    }

    public void setText(String str) {
        this.amM.setText(str);
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.amO.setOnSwitchStateChangeListener(aVar);
    }

    private void zN() {
        LayoutInflater.from(this.mContext).inflate(u.h.setting_text_switch_view, (ViewGroup) this, true);
        this.amL = (LinearLayout) findViewById(u.g.container);
        this.amM = (TextView) findViewById(u.g.text);
        this.amO = (BdSwitchView) findViewById(u.g.button);
        this.amO.setFocusable(true);
        this.amN = (TextView) findViewById(u.g.tip);
        if (this.amN != null) {
            this.amN.setVisibility(8);
        }
        setTag(this.amO);
        this.amL.setClickable(false);
        this.amL.setFocusable(false);
    }

    private void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, u.l.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        float dimension = obtainStyledAttributes.getDimension(2, -1.0f);
        String string2 = obtainStyledAttributes.getString(3);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (this.amN != null && string2 != null) {
            this.amN.setVisibility(0);
            this.amN.setText(string2);
            if (color2 > -1) {
                this.amN.setTextColor(color2);
            }
        }
        if (string != null) {
            this.amM.setText(string);
        }
        if (color > -1) {
            this.amM.setTextColor(color);
        }
        if (dimension > -1.0f) {
            this.amM.setTextSize(0, dimension);
        }
        this.amL.setClickable(false);
        this.amL.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.amN != null) {
            displayTip();
            this.amN.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.amN != null) {
            displayTip();
            this.amN.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.amN != null) {
            this.amN.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.amN != null) {
            this.amN.setVisibility(8);
        }
    }

    public void setTextLeftMargin(int i) {
        if (this.amM.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.amM.getLayoutParams();
            layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(i);
            this.amM.setLayoutParams(layoutParams);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.amO;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.amO = bdSwitchView;
    }
}
