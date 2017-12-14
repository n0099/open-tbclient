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
    private LinearLayout axX;
    private TextView axY;
    protected TextView axZ;
    private BdSwitchView aya;
    private final Context mContext;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        Bw();
        b(attributeSet);
        ey(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        Bw();
        ey(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        Bw();
        b(attributeSet);
        ey(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.axX;
    }

    public void ey(int i) {
        this.aya.a(aj.cR(d.f.bg_switch_open), aj.cR(d.f.bg_switch_close), aj.cR(d.f.btn_handle));
        aj.c(this.axY, d.C0096d.cp_cont_b, 1);
        if (this.axZ != null) {
            aj.c(this.axZ, d.C0096d.cp_cont_d, 1);
        }
    }

    public void km() {
        this.aya.km();
        this.aya.setContentDescription(this.mContext.getString(d.j.talk_message_tip) + this.mContext.getString(d.j.talk_close));
    }

    public void kl() {
        this.aya.kl();
        this.aya.setContentDescription(this.mContext.getString(d.j.talk_message_tip) + this.mContext.getString(d.j.talk_open));
    }

    public void R(boolean z) {
        this.aya.R(z);
        this.aya.setContentDescription(this.mContext.getString(d.j.talk_message_tip) + this.mContext.getString(d.j.talk_close));
    }

    public void Q(boolean z) {
        this.aya.Q(z);
        this.aya.setContentDescription(this.mContext.getString(d.j.talk_message_tip) + this.mContext.getString(d.j.talk_open));
    }

    public void setText(String str) {
        this.axY.setText(str);
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.aya.setOnSwitchStateChangeListener(aVar);
    }

    private void Bw() {
        LayoutInflater.from(this.mContext).inflate(d.h.setting_text_switch_view, (ViewGroup) this, true);
        this.axX = (LinearLayout) findViewById(d.g.container);
        this.axY = (TextView) findViewById(d.g.text);
        this.aya = (BdSwitchView) findViewById(d.g.button);
        this.aya.setFocusable(true);
        this.axZ = (TextView) findViewById(d.g.tip);
        if (this.axZ != null) {
            this.axZ.setVisibility(8);
        }
        setTag(this.aya);
        this.axX.setClickable(false);
        this.axX.setFocusable(false);
    }

    private void b(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.l.TbSettingView);
        String string = obtainStyledAttributes.getString(d.l.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(d.l.TbSettingView_settingTextColor, -1);
        float dimension = obtainStyledAttributes.getDimension(d.l.TbSettingView_settingTextSize, -1.0f);
        String string2 = obtainStyledAttributes.getString(d.l.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(d.l.TbSettingView_settingTipColor, -1);
        if (this.axZ != null && string2 != null) {
            this.axZ.setVisibility(0);
            this.axZ.setText(string2);
            if (color2 > -1) {
                this.axZ.setTextColor(color2);
            }
        }
        if (string != null) {
            this.axY.setText(string);
        }
        if (color > -1) {
            this.axY.setTextColor(color);
        }
        if (dimension > -1.0f) {
            this.axY.setTextSize(0, dimension);
        }
        this.axX.setClickable(false);
        this.axX.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.axZ != null) {
            displayTip();
            this.axZ.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.axZ != null) {
            displayTip();
            this.axZ.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.axZ != null) {
            this.axZ.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.axZ != null) {
            this.axZ.setVisibility(8);
        }
    }

    public void setTextLeftMargin(int i) {
        if (this.axY.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.axY.getLayoutParams();
            layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(i);
            this.axY.setLayoutParams(layoutParams);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.aya;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.aya = bdSwitchView;
    }
}
