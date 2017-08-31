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
    private LinearLayout axR;
    private TextView axS;
    protected TextView axT;
    private BdSwitchView axU;
    private final Context mContext;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        By();
        b(attributeSet);
        en(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        By();
        en(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        By();
        b(attributeSet);
        en(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.axR;
    }

    public void en(int i) {
        this.axU.a(aj.cT(d.g.bg_switch_open), aj.cT(d.g.bg_switch_close), aj.cT(d.g.btn_handle));
        aj.c(this.axS, d.e.cp_cont_b, 1);
        if (this.axT != null) {
            aj.c(this.axT, d.e.cp_cont_d, 1);
        }
    }

    public void kq() {
        this.axU.kq();
        this.axU.setContentDescription(this.mContext.getString(d.l.talk_message_tip) + this.mContext.getString(d.l.talk_close));
    }

    public void kp() {
        this.axU.kp();
        this.axU.setContentDescription(this.mContext.getString(d.l.talk_message_tip) + this.mContext.getString(d.l.talk_open));
    }

    public void R(boolean z) {
        this.axU.R(z);
        this.axU.setContentDescription(this.mContext.getString(d.l.talk_message_tip) + this.mContext.getString(d.l.talk_close));
    }

    public void Q(boolean z) {
        this.axU.Q(z);
        this.axU.setContentDescription(this.mContext.getString(d.l.talk_message_tip) + this.mContext.getString(d.l.talk_open));
    }

    public void setText(String str) {
        this.axS.setText(str);
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.axU.setOnSwitchStateChangeListener(aVar);
    }

    private void By() {
        LayoutInflater.from(this.mContext).inflate(d.j.setting_text_switch_view, (ViewGroup) this, true);
        this.axR = (LinearLayout) findViewById(d.h.container);
        this.axS = (TextView) findViewById(d.h.text);
        this.axU = (BdSwitchView) findViewById(d.h.button);
        this.axU.setFocusable(true);
        this.axT = (TextView) findViewById(d.h.tip);
        if (this.axT != null) {
            this.axT.setVisibility(8);
        }
        setTag(this.axU);
        this.axR.setClickable(false);
        this.axR.setFocusable(false);
    }

    private void b(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.n.TbSettingView);
        String string = obtainStyledAttributes.getString(d.n.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(d.n.TbSettingView_settingTextColor, -1);
        float dimension = obtainStyledAttributes.getDimension(d.n.TbSettingView_settingTextSize, -1.0f);
        String string2 = obtainStyledAttributes.getString(d.n.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(d.n.TbSettingView_settingTipColor, -1);
        if (this.axT != null && string2 != null) {
            this.axT.setVisibility(0);
            this.axT.setText(string2);
            if (color2 > -1) {
                this.axT.setTextColor(color2);
            }
        }
        if (string != null) {
            this.axS.setText(string);
        }
        if (color > -1) {
            this.axS.setTextColor(color);
        }
        if (dimension > -1.0f) {
            this.axS.setTextSize(0, dimension);
        }
        this.axR.setClickable(false);
        this.axR.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.axT != null) {
            displayTip();
            this.axT.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.axT != null) {
            displayTip();
            this.axT.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.axT != null) {
            this.axT.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.axT != null) {
            this.axT.setVisibility(8);
        }
    }

    public void setTextLeftMargin(int i) {
        if (this.axS.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.axS.getLayoutParams();
            layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(i);
            this.axS.setLayoutParams(layoutParams);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.axU;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.axU = bdSwitchView;
    }
}
