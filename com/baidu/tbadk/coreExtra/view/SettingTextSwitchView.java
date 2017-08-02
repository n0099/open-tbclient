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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class SettingTextSwitchView extends FrameLayout {
    private LinearLayout axn;
    private TextView axo;
    protected TextView axp;
    private BdSwitchView axq;
    private final Context mContext;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        Bv();
        c(attributeSet);
        em(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        Bv();
        em(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        Bv();
        c(attributeSet);
        em(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.axn;
    }

    public void em(int i) {
        this.axq.a(ai.cQ(d.g.bg_switch_open), ai.cQ(d.g.bg_switch_close), ai.cQ(d.g.btn_handle));
        ai.c(this.axo, d.e.cp_cont_b, 1);
        if (this.axp != null) {
            ai.c(this.axp, d.e.cp_cont_d, 1);
        }
    }

    public void kp() {
        this.axq.kp();
        this.axq.setContentDescription(this.mContext.getString(d.l.talk_message_tip) + this.mContext.getString(d.l.talk_close));
    }

    public void ko() {
        this.axq.ko();
        this.axq.setContentDescription(this.mContext.getString(d.l.talk_message_tip) + this.mContext.getString(d.l.talk_open));
    }

    public void Q(boolean z) {
        this.axq.Q(z);
        this.axq.setContentDescription(this.mContext.getString(d.l.talk_message_tip) + this.mContext.getString(d.l.talk_close));
    }

    public void P(boolean z) {
        this.axq.P(z);
        this.axq.setContentDescription(this.mContext.getString(d.l.talk_message_tip) + this.mContext.getString(d.l.talk_open));
    }

    public void setText(String str) {
        this.axo.setText(str);
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.axq.setOnSwitchStateChangeListener(aVar);
    }

    private void Bv() {
        LayoutInflater.from(this.mContext).inflate(d.j.setting_text_switch_view, (ViewGroup) this, true);
        this.axn = (LinearLayout) findViewById(d.h.container);
        this.axo = (TextView) findViewById(d.h.text);
        this.axq = (BdSwitchView) findViewById(d.h.button);
        this.axq.setFocusable(true);
        this.axp = (TextView) findViewById(d.h.tip);
        if (this.axp != null) {
            this.axp.setVisibility(8);
        }
        setTag(this.axq);
        this.axn.setClickable(false);
        this.axn.setFocusable(false);
    }

    private void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.n.TbSettingView);
        String string = obtainStyledAttributes.getString(d.n.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(d.n.TbSettingView_settingTextColor, -1);
        float dimension = obtainStyledAttributes.getDimension(d.n.TbSettingView_settingTextSize, -1.0f);
        String string2 = obtainStyledAttributes.getString(d.n.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(d.n.TbSettingView_settingTipColor, -1);
        if (this.axp != null && string2 != null) {
            this.axp.setVisibility(0);
            this.axp.setText(string2);
            if (color2 > -1) {
                this.axp.setTextColor(color2);
            }
        }
        if (string != null) {
            this.axo.setText(string);
        }
        if (color > -1) {
            this.axo.setTextColor(color);
        }
        if (dimension > -1.0f) {
            this.axo.setTextSize(0, dimension);
        }
        this.axn.setClickable(false);
        this.axn.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.axp != null) {
            displayTip();
            this.axp.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.axp != null) {
            displayTip();
            this.axp.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.axp != null) {
            this.axp.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.axp != null) {
            this.axp.setVisibility(8);
        }
    }

    public void setTextLeftMargin(int i) {
        if (this.axo.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.axo.getLayoutParams();
            layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(i);
            this.axo.setLayoutParams(layoutParams);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.axq;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.axq = bdSwitchView;
    }
}
