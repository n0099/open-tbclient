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
    private LinearLayout awY;
    private TextView awZ;
    protected TextView axa;
    private BdSwitchView axb;
    private final Context mContext;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        AW();
        b(attributeSet);
        ey(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        AW();
        ey(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        AW();
        b(attributeSet);
        ey(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.awY;
    }

    public void ey(int i) {
        this.axb.a(aj.cR(d.g.bg_switch_open), aj.cR(d.g.bg_switch_close), aj.cR(d.g.btn_handle));
        aj.c(this.awZ, d.e.cp_cont_b, 1);
        if (this.axa != null) {
            aj.c(this.axa, d.e.cp_cont_d, 1);
        }
    }

    public void kp() {
        this.axb.kp();
        this.axb.setContentDescription(this.mContext.getString(d.l.talk_message_tip) + this.mContext.getString(d.l.talk_close));
    }

    public void ko() {
        this.axb.ko();
        this.axb.setContentDescription(this.mContext.getString(d.l.talk_message_tip) + this.mContext.getString(d.l.talk_open));
    }

    public void R(boolean z) {
        this.axb.R(z);
        this.axb.setContentDescription(this.mContext.getString(d.l.talk_message_tip) + this.mContext.getString(d.l.talk_close));
    }

    public void Q(boolean z) {
        this.axb.Q(z);
        this.axb.setContentDescription(this.mContext.getString(d.l.talk_message_tip) + this.mContext.getString(d.l.talk_open));
    }

    public void setText(String str) {
        this.awZ.setText(str);
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.axb.setOnSwitchStateChangeListener(aVar);
    }

    private void AW() {
        LayoutInflater.from(this.mContext).inflate(d.j.setting_text_switch_view, (ViewGroup) this, true);
        this.awY = (LinearLayout) findViewById(d.h.container);
        this.awZ = (TextView) findViewById(d.h.text);
        this.axb = (BdSwitchView) findViewById(d.h.button);
        this.axb.setFocusable(true);
        this.axa = (TextView) findViewById(d.h.tip);
        if (this.axa != null) {
            this.axa.setVisibility(8);
        }
        setTag(this.axb);
        this.awY.setClickable(false);
        this.awY.setFocusable(false);
    }

    private void b(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.n.TbSettingView);
        String string = obtainStyledAttributes.getString(d.n.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(d.n.TbSettingView_settingTextColor, -1);
        float dimension = obtainStyledAttributes.getDimension(d.n.TbSettingView_settingTextSize, -1.0f);
        String string2 = obtainStyledAttributes.getString(d.n.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(d.n.TbSettingView_settingTipColor, -1);
        if (this.axa != null && string2 != null) {
            this.axa.setVisibility(0);
            this.axa.setText(string2);
            if (color2 > -1) {
                this.axa.setTextColor(color2);
            }
        }
        if (string != null) {
            this.awZ.setText(string);
        }
        if (color > -1) {
            this.awZ.setTextColor(color);
        }
        if (dimension > -1.0f) {
            this.awZ.setTextSize(0, dimension);
        }
        this.awY.setClickable(false);
        this.awY.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.axa != null) {
            displayTip();
            this.axa.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.axa != null) {
            displayTip();
            this.axa.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.axa != null) {
            this.axa.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.axa != null) {
            this.axa.setVisibility(8);
        }
    }

    public void setTextLeftMargin(int i) {
        if (this.awZ.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.awZ.getLayoutParams();
            layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(i);
            this.awZ.setLayoutParams(layoutParams);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.axb;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.axb = bdSwitchView;
    }
}
