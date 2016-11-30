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
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class SettingTextSwitchView extends FrameLayout {
    private LinearLayout arj;
    private TextView ark;
    protected TextView arl;
    private BdSwitchView arm;
    private final Context mContext;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        Bm();
        d(attributeSet);
        ej(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        Bm();
        ej(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        Bm();
        d(attributeSet);
        ej(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public View getView() {
        return this.arj;
    }

    public void ej(int i) {
        this.arm.a(at.cO(r.f.bg_switch_open), at.cO(r.f.bg_switch_close), at.cO(r.f.btn_handle));
        at.c(this.ark, r.d.cp_cont_b, 1);
        if (this.arl != null) {
            at.c(this.arl, r.d.cp_cont_d, 1);
        }
    }

    public void jw() {
        this.arm.jw();
        this.arm.setContentDescription(String.valueOf(this.mContext.getString(r.j.talk_message_tip)) + this.mContext.getString(r.j.talk_close));
    }

    public void jv() {
        this.arm.jv();
        this.arm.setContentDescription(String.valueOf(this.mContext.getString(r.j.talk_message_tip)) + this.mContext.getString(r.j.talk_open));
    }

    public void P(boolean z) {
        this.arm.P(z);
        this.arm.setContentDescription(String.valueOf(this.mContext.getString(r.j.talk_message_tip)) + this.mContext.getString(r.j.talk_close));
    }

    public void O(boolean z) {
        this.arm.O(z);
        this.arm.setContentDescription(String.valueOf(this.mContext.getString(r.j.talk_message_tip)) + this.mContext.getString(r.j.talk_open));
    }

    public void setText(String str) {
        this.ark.setText(str);
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.arm.setOnSwitchStateChangeListener(aVar);
    }

    private void Bm() {
        LayoutInflater.from(this.mContext).inflate(r.h.setting_text_switch_view, (ViewGroup) this, true);
        this.arj = (LinearLayout) findViewById(r.g.container);
        this.ark = (TextView) findViewById(r.g.text);
        this.arm = (BdSwitchView) findViewById(r.g.button);
        this.arm.setFocusable(true);
        this.arl = (TextView) findViewById(r.g.tip);
        if (this.arl != null) {
            this.arl.setVisibility(8);
        }
        setTag(this.arm);
        this.arj.setClickable(false);
        this.arj.setFocusable(false);
    }

    private void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, r.l.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        float dimension = obtainStyledAttributes.getDimension(2, -1.0f);
        String string2 = obtainStyledAttributes.getString(3);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (this.arl != null && string2 != null) {
            this.arl.setVisibility(0);
            this.arl.setText(string2);
            if (color2 > -1) {
                this.arl.setTextColor(color2);
            }
        }
        if (string != null) {
            this.ark.setText(string);
        }
        if (color > -1) {
            this.ark.setTextColor(color);
        }
        if (dimension > -1.0f) {
            this.ark.setTextSize(0, dimension);
        }
        this.arj.setClickable(false);
        this.arj.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.arl != null) {
            displayTip();
            this.arl.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.arl != null) {
            displayTip();
            this.arl.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.arl != null) {
            this.arl.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.arl != null) {
            this.arl.setVisibility(8);
        }
    }

    public void setTextLeftMargin(int i) {
        if (this.ark.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ark.getLayoutParams();
            layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(i);
            this.ark.setLayoutParams(layoutParams);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.arm;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.arm = bdSwitchView;
    }
}
