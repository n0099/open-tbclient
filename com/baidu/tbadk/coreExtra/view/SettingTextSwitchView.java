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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class SettingTextSwitchView extends FrameLayout {
    private LinearLayout aqp;
    private TextView aqq;
    protected TextView aqr;
    private BdSwitchView aqs;
    private final Context mContext;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        Bf();
        d(attributeSet);
        eh(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        Bf();
        eh(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        Bf();
        d(attributeSet);
        eh(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public View getView() {
        return this.aqp;
    }

    public void eh(int i) {
        this.aqs.a(av.cN(r.f.bg_switch_open), av.cN(r.f.bg_switch_close), av.cN(r.f.btn_handle));
        av.c(this.aqq, r.d.cp_cont_b, 1);
        if (this.aqr != null) {
            av.c(this.aqr, r.d.cp_cont_d, 1);
        }
    }

    public void jw() {
        this.aqs.jw();
        this.aqs.setContentDescription(String.valueOf(this.mContext.getString(r.j.talk_message_tip)) + this.mContext.getString(r.j.talk_close));
    }

    public void jv() {
        this.aqs.jv();
        this.aqs.setContentDescription(String.valueOf(this.mContext.getString(r.j.talk_message_tip)) + this.mContext.getString(r.j.talk_open));
    }

    public void P(boolean z) {
        this.aqs.P(z);
        this.aqs.setContentDescription(String.valueOf(this.mContext.getString(r.j.talk_message_tip)) + this.mContext.getString(r.j.talk_close));
    }

    public void O(boolean z) {
        this.aqs.O(z);
        this.aqs.setContentDescription(String.valueOf(this.mContext.getString(r.j.talk_message_tip)) + this.mContext.getString(r.j.talk_open));
    }

    public void setText(String str) {
        this.aqq.setText(str);
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.aqs.setOnSwitchStateChangeListener(aVar);
    }

    private void Bf() {
        LayoutInflater.from(this.mContext).inflate(r.h.setting_text_switch_view, (ViewGroup) this, true);
        this.aqp = (LinearLayout) findViewById(r.g.container);
        this.aqq = (TextView) findViewById(r.g.text);
        this.aqs = (BdSwitchView) findViewById(r.g.button);
        this.aqs.setFocusable(true);
        this.aqr = (TextView) findViewById(r.g.tip);
        if (this.aqr != null) {
            this.aqr.setVisibility(8);
        }
        setTag(this.aqs);
        this.aqp.setClickable(false);
        this.aqp.setFocusable(false);
    }

    private void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, r.l.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        float dimension = obtainStyledAttributes.getDimension(2, -1.0f);
        String string2 = obtainStyledAttributes.getString(3);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (this.aqr != null && string2 != null) {
            this.aqr.setVisibility(0);
            this.aqr.setText(string2);
            if (color2 > -1) {
                this.aqr.setTextColor(color2);
            }
        }
        if (string != null) {
            this.aqq.setText(string);
        }
        if (color > -1) {
            this.aqq.setTextColor(color);
        }
        if (dimension > -1.0f) {
            this.aqq.setTextSize(0, dimension);
        }
        this.aqp.setClickable(false);
        this.aqp.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.aqr != null) {
            displayTip();
            this.aqr.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.aqr != null) {
            displayTip();
            this.aqr.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.aqr != null) {
            this.aqr.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.aqr != null) {
            this.aqr.setVisibility(8);
        }
    }

    public void setTextLeftMargin(int i) {
        if (this.aqq.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aqq.getLayoutParams();
            layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(i);
            this.aqq.setLayoutParams(layoutParams);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.aqs;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.aqs = bdSwitchView;
    }
}
