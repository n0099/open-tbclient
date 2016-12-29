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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class SettingTextSwitchView extends FrameLayout {
    private LinearLayout aqM;
    private TextView aqN;
    protected TextView aqO;
    private BdSwitchView aqP;
    private final Context mContext;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        AZ();
        d(attributeSet);
        ek(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        AZ();
        ek(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        AZ();
        d(attributeSet);
        ek(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public View getView() {
        return this.aqM;
    }

    public void ek(int i) {
        this.aqP.a(ar.cQ(r.f.bg_switch_open), ar.cQ(r.f.bg_switch_close), ar.cQ(r.f.btn_handle));
        ar.c(this.aqN, r.d.cp_cont_b, 1);
        if (this.aqO != null) {
            ar.c(this.aqO, r.d.cp_cont_d, 1);
        }
    }

    public void jw() {
        this.aqP.jw();
        this.aqP.setContentDescription(String.valueOf(this.mContext.getString(r.j.talk_message_tip)) + this.mContext.getString(r.j.talk_close));
    }

    public void jv() {
        this.aqP.jv();
        this.aqP.setContentDescription(String.valueOf(this.mContext.getString(r.j.talk_message_tip)) + this.mContext.getString(r.j.talk_open));
    }

    public void P(boolean z) {
        this.aqP.P(z);
        this.aqP.setContentDescription(String.valueOf(this.mContext.getString(r.j.talk_message_tip)) + this.mContext.getString(r.j.talk_close));
    }

    public void O(boolean z) {
        this.aqP.O(z);
        this.aqP.setContentDescription(String.valueOf(this.mContext.getString(r.j.talk_message_tip)) + this.mContext.getString(r.j.talk_open));
    }

    public void setText(String str) {
        this.aqN.setText(str);
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.aqP.setOnSwitchStateChangeListener(aVar);
    }

    private void AZ() {
        LayoutInflater.from(this.mContext).inflate(r.h.setting_text_switch_view, (ViewGroup) this, true);
        this.aqM = (LinearLayout) findViewById(r.g.container);
        this.aqN = (TextView) findViewById(r.g.text);
        this.aqP = (BdSwitchView) findViewById(r.g.button);
        this.aqP.setFocusable(true);
        this.aqO = (TextView) findViewById(r.g.tip);
        if (this.aqO != null) {
            this.aqO.setVisibility(8);
        }
        setTag(this.aqP);
        this.aqM.setClickable(false);
        this.aqM.setFocusable(false);
    }

    private void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, r.l.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        float dimension = obtainStyledAttributes.getDimension(2, -1.0f);
        String string2 = obtainStyledAttributes.getString(3);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (this.aqO != null && string2 != null) {
            this.aqO.setVisibility(0);
            this.aqO.setText(string2);
            if (color2 > -1) {
                this.aqO.setTextColor(color2);
            }
        }
        if (string != null) {
            this.aqN.setText(string);
        }
        if (color > -1) {
            this.aqN.setTextColor(color);
        }
        if (dimension > -1.0f) {
            this.aqN.setTextSize(0, dimension);
        }
        this.aqM.setClickable(false);
        this.aqM.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.aqO != null) {
            displayTip();
            this.aqO.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.aqO != null) {
            displayTip();
            this.aqO.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.aqO != null) {
            this.aqO.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.aqO != null) {
            this.aqO.setVisibility(8);
        }
    }

    public void setTextLeftMargin(int i) {
        if (this.aqN.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aqN.getLayoutParams();
            layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(i);
            this.aqN.setLayoutParams(layoutParams);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.aqP;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.aqP = bdSwitchView;
    }
}
