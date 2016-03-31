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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class SettingTextSwitchView extends FrameLayout {
    private LinearLayout aqr;
    private TextView aqs;
    protected TextView aqt;
    private BdSwitchView aqu;
    private final Context mContext;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        BN();
        d(attributeSet);
        em(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        BN();
        em(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        BN();
        d(attributeSet);
        em(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public View getView() {
        return this.aqr;
    }

    public void em(int i) {
        this.aqu.a(at.cR(t.f.bg_switch_open), at.cR(t.f.bg_switch_close), at.cR(t.f.btn_handle));
        at.b(this.aqs, t.d.cp_cont_b, 1);
        if (this.aqt != null) {
            at.b(this.aqt, t.d.cp_cont_d, 1);
        }
    }

    public void ml() {
        this.aqu.ml();
        this.aqu.setContentDescription(String.valueOf(this.mContext.getString(t.j.talk_message_tip)) + this.mContext.getString(t.j.talk_close));
    }

    public void mk() {
        this.aqu.mk();
        this.aqu.setContentDescription(String.valueOf(this.mContext.getString(t.j.talk_message_tip)) + this.mContext.getString(t.j.talk_open));
    }

    public void L(boolean z) {
        this.aqu.L(z);
        this.aqu.setContentDescription(String.valueOf(this.mContext.getString(t.j.talk_message_tip)) + this.mContext.getString(t.j.talk_close));
    }

    public void K(boolean z) {
        this.aqu.K(z);
        this.aqu.setContentDescription(String.valueOf(this.mContext.getString(t.j.talk_message_tip)) + this.mContext.getString(t.j.talk_open));
    }

    public void setText(String str) {
        this.aqs.setText(str);
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.aqu.setOnSwitchStateChangeListener(aVar);
    }

    private void BN() {
        LayoutInflater.from(this.mContext).inflate(t.h.setting_text_switch_view, (ViewGroup) this, true);
        this.aqr = (LinearLayout) findViewById(t.g.container);
        this.aqs = (TextView) findViewById(t.g.text);
        this.aqu = (BdSwitchView) findViewById(t.g.button);
        this.aqu.setFocusable(true);
        this.aqt = (TextView) findViewById(t.g.tip);
        if (this.aqt != null) {
            this.aqt.setVisibility(8);
        }
        setTag(this.aqu);
        this.aqr.setClickable(false);
        this.aqr.setFocusable(false);
    }

    private void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, t.l.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        float dimension = obtainStyledAttributes.getDimension(2, -1.0f);
        String string2 = obtainStyledAttributes.getString(3);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (this.aqt != null && string2 != null) {
            this.aqt.setVisibility(0);
            this.aqt.setText(string2);
            if (color2 > -1) {
                this.aqt.setTextColor(color2);
            }
        }
        if (string != null) {
            this.aqs.setText(string);
        }
        if (color > -1) {
            this.aqs.setTextColor(color);
        }
        if (dimension > -1.0f) {
            this.aqs.setTextSize(0, dimension);
        }
        this.aqr.setClickable(false);
        this.aqr.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.aqt != null) {
            displayTip();
            this.aqt.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.aqt != null) {
            displayTip();
            this.aqt.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.aqt != null) {
            this.aqt.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.aqt != null) {
            this.aqt.setVisibility(8);
        }
    }

    public void setTextLeftMargin(int i) {
        if (this.aqs.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aqs.getLayoutParams();
            layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(i);
            this.aqs.setLayoutParams(layoutParams);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.aqu;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.aqu = bdSwitchView;
    }
}
