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
    private LinearLayout axS;
    private TextView axT;
    protected TextView axU;
    private BdSwitchView axV;
    private final Context mContext;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        Bv();
        b(attributeSet);
        ey(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        Bv();
        ey(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        Bv();
        b(attributeSet);
        ey(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.axS;
    }

    public void ey(int i) {
        this.axV.a(aj.cR(d.f.bg_switch_open), aj.cR(d.f.bg_switch_close), aj.cR(d.f.btn_handle));
        aj.c(this.axT, d.C0082d.cp_cont_b, 1);
        if (this.axU != null) {
            aj.c(this.axU, d.C0082d.cp_cont_d, 1);
        }
    }

    public void km() {
        this.axV.km();
        this.axV.setContentDescription(this.mContext.getString(d.j.talk_message_tip) + this.mContext.getString(d.j.talk_close));
    }

    public void kl() {
        this.axV.kl();
        this.axV.setContentDescription(this.mContext.getString(d.j.talk_message_tip) + this.mContext.getString(d.j.talk_open));
    }

    public void R(boolean z) {
        this.axV.R(z);
        this.axV.setContentDescription(this.mContext.getString(d.j.talk_message_tip) + this.mContext.getString(d.j.talk_close));
    }

    public void Q(boolean z) {
        this.axV.Q(z);
        this.axV.setContentDescription(this.mContext.getString(d.j.talk_message_tip) + this.mContext.getString(d.j.talk_open));
    }

    public void setText(String str) {
        this.axT.setText(str);
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.axV.setOnSwitchStateChangeListener(aVar);
    }

    private void Bv() {
        LayoutInflater.from(this.mContext).inflate(d.h.setting_text_switch_view, (ViewGroup) this, true);
        this.axS = (LinearLayout) findViewById(d.g.container);
        this.axT = (TextView) findViewById(d.g.text);
        this.axV = (BdSwitchView) findViewById(d.g.button);
        this.axV.setFocusable(true);
        this.axU = (TextView) findViewById(d.g.tip);
        if (this.axU != null) {
            this.axU.setVisibility(8);
        }
        setTag(this.axV);
        this.axS.setClickable(false);
        this.axS.setFocusable(false);
    }

    private void b(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.l.TbSettingView);
        String string = obtainStyledAttributes.getString(d.l.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(d.l.TbSettingView_settingTextColor, -1);
        float dimension = obtainStyledAttributes.getDimension(d.l.TbSettingView_settingTextSize, -1.0f);
        String string2 = obtainStyledAttributes.getString(d.l.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(d.l.TbSettingView_settingTipColor, -1);
        if (this.axU != null && string2 != null) {
            this.axU.setVisibility(0);
            this.axU.setText(string2);
            if (color2 > -1) {
                this.axU.setTextColor(color2);
            }
        }
        if (string != null) {
            this.axT.setText(string);
        }
        if (color > -1) {
            this.axT.setTextColor(color);
        }
        if (dimension > -1.0f) {
            this.axT.setTextSize(0, dimension);
        }
        this.axS.setClickable(false);
        this.axS.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.axU != null) {
            displayTip();
            this.axU.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.axU != null) {
            displayTip();
            this.axU.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.axU != null) {
            this.axU.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.axU != null) {
            this.axU.setVisibility(8);
        }
    }

    public void setTextLeftMargin(int i) {
        if (this.axT.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.axT.getLayoutParams();
            layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(i);
            this.axT.setLayoutParams(layoutParams);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.axV;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.axV = bdSwitchView;
    }
}
