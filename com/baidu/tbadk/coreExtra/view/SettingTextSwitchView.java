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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class SettingTextSwitchView extends FrameLayout {
    private LinearLayout aza;
    private TextView azb;
    protected TextView azc;
    private BdSwitchView azd;
    private final Context mContext;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        BZ();
        c(attributeSet);
        eq(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        BZ();
        eq(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        BZ();
        c(attributeSet);
        eq(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.aza;
    }

    public void eq(int i) {
        this.azd.setBackgroundRes(ak.cO(d.f.bg_switch_open), ak.cO(d.f.bg_switch_close), ak.cO(d.f.btn_handle));
        ak.c(this.azb, d.C0126d.cp_cont_b, 1);
        if (this.azc != null) {
            ak.c(this.azc, d.C0126d.cp_cont_d, 1);
        }
    }

    public void jP() {
        this.azd.jP();
        this.azd.setContentDescription(this.mContext.getString(d.k.talk_message_tip) + this.mContext.getString(d.k.talk_close));
    }

    public void jO() {
        this.azd.jO();
        this.azd.setContentDescription(this.mContext.getString(d.k.talk_message_tip) + this.mContext.getString(d.k.talk_open));
    }

    public void U(boolean z) {
        this.azd.U(z);
        this.azd.setContentDescription(this.mContext.getString(d.k.talk_message_tip) + this.mContext.getString(d.k.talk_close));
    }

    public void T(boolean z) {
        this.azd.T(z);
        this.azd.setContentDescription(this.mContext.getString(d.k.talk_message_tip) + this.mContext.getString(d.k.talk_open));
    }

    public void setText(String str) {
        this.azb.setText(str);
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.azd.setOnSwitchStateChangeListener(aVar);
    }

    private void BZ() {
        LayoutInflater.from(this.mContext).inflate(d.i.setting_text_switch_view, (ViewGroup) this, true);
        this.aza = (LinearLayout) findViewById(d.g.container);
        this.azb = (TextView) findViewById(d.g.text);
        this.azd = (BdSwitchView) findViewById(d.g.button);
        this.azd.setFocusable(true);
        this.azc = (TextView) findViewById(d.g.tip);
        if (this.azc != null) {
            this.azc.setVisibility(8);
        }
        setTag(this.azd);
        this.aza.setClickable(false);
        this.aza.setFocusable(false);
    }

    private void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.m.TbSettingView);
        String string = obtainStyledAttributes.getString(d.m.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(d.m.TbSettingView_settingTextColor, -1);
        float dimension = obtainStyledAttributes.getDimension(d.m.TbSettingView_settingTextSize, -1.0f);
        String string2 = obtainStyledAttributes.getString(d.m.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(d.m.TbSettingView_settingTipColor, -1);
        if (this.azc != null && string2 != null) {
            this.azc.setVisibility(0);
            this.azc.setText(string2);
            if (color2 > -1) {
                this.azc.setTextColor(color2);
            }
        }
        if (string != null) {
            this.azb.setText(string);
        }
        if (color > -1) {
            this.azb.setTextColor(color);
        }
        if (dimension > -1.0f) {
            this.azb.setTextSize(0, dimension);
        }
        this.aza.setClickable(false);
        this.aza.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.azc != null) {
            displayTip();
            this.azc.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.azc != null) {
            displayTip();
            this.azc.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.azc != null) {
            this.azc.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.azc != null) {
            this.azc.setVisibility(8);
        }
    }

    public void setTextLeftMargin(int i) {
        if (this.azb.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.azb.getLayoutParams();
            layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(i);
            this.azb.setLayoutParams(layoutParams);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.azd;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.azd = bdSwitchView;
    }
}
