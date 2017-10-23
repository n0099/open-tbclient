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
    private LinearLayout awM;
    private TextView awN;
    protected TextView awO;
    private BdSwitchView awP;
    private final Context mContext;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        AQ();
        b(attributeSet);
        ex(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        AQ();
        ex(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        AQ();
        b(attributeSet);
        ex(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.awM;
    }

    public void ex(int i) {
        this.awP.a(aj.cQ(d.g.bg_switch_open), aj.cQ(d.g.bg_switch_close), aj.cQ(d.g.btn_handle));
        aj.c(this.awN, d.e.cp_cont_b, 1);
        if (this.awO != null) {
            aj.c(this.awO, d.e.cp_cont_d, 1);
        }
    }

    public void kp() {
        this.awP.kp();
        this.awP.setContentDescription(this.mContext.getString(d.l.talk_message_tip) + this.mContext.getString(d.l.talk_close));
    }

    public void ko() {
        this.awP.ko();
        this.awP.setContentDescription(this.mContext.getString(d.l.talk_message_tip) + this.mContext.getString(d.l.talk_open));
    }

    public void R(boolean z) {
        this.awP.R(z);
        this.awP.setContentDescription(this.mContext.getString(d.l.talk_message_tip) + this.mContext.getString(d.l.talk_close));
    }

    public void Q(boolean z) {
        this.awP.Q(z);
        this.awP.setContentDescription(this.mContext.getString(d.l.talk_message_tip) + this.mContext.getString(d.l.talk_open));
    }

    public void setText(String str) {
        this.awN.setText(str);
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.awP.setOnSwitchStateChangeListener(aVar);
    }

    private void AQ() {
        LayoutInflater.from(this.mContext).inflate(d.j.setting_text_switch_view, (ViewGroup) this, true);
        this.awM = (LinearLayout) findViewById(d.h.container);
        this.awN = (TextView) findViewById(d.h.text);
        this.awP = (BdSwitchView) findViewById(d.h.button);
        this.awP.setFocusable(true);
        this.awO = (TextView) findViewById(d.h.tip);
        if (this.awO != null) {
            this.awO.setVisibility(8);
        }
        setTag(this.awP);
        this.awM.setClickable(false);
        this.awM.setFocusable(false);
    }

    private void b(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.n.TbSettingView);
        String string = obtainStyledAttributes.getString(d.n.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(d.n.TbSettingView_settingTextColor, -1);
        float dimension = obtainStyledAttributes.getDimension(d.n.TbSettingView_settingTextSize, -1.0f);
        String string2 = obtainStyledAttributes.getString(d.n.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(d.n.TbSettingView_settingTipColor, -1);
        if (this.awO != null && string2 != null) {
            this.awO.setVisibility(0);
            this.awO.setText(string2);
            if (color2 > -1) {
                this.awO.setTextColor(color2);
            }
        }
        if (string != null) {
            this.awN.setText(string);
        }
        if (color > -1) {
            this.awN.setTextColor(color);
        }
        if (dimension > -1.0f) {
            this.awN.setTextSize(0, dimension);
        }
        this.awM.setClickable(false);
        this.awM.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.awO != null) {
            displayTip();
            this.awO.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.awO != null) {
            displayTip();
            this.awO.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.awO != null) {
            this.awO.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.awO != null) {
            this.awO.setVisibility(8);
        }
    }

    public void setTextLeftMargin(int i) {
        if (this.awN.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.awN.getLayoutParams();
            layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(i);
            this.awN.setLayoutParams(layoutParams);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.awP;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.awP = bdSwitchView;
    }
}
