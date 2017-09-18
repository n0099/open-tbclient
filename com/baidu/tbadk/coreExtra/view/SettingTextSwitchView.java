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
    private LinearLayout axO;
    private TextView axP;
    protected TextView axQ;
    private BdSwitchView axR;
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
        return this.axO;
    }

    public void en(int i) {
        this.axR.a(aj.cT(d.g.bg_switch_open), aj.cT(d.g.bg_switch_close), aj.cT(d.g.btn_handle));
        aj.c(this.axP, d.e.cp_cont_b, 1);
        if (this.axQ != null) {
            aj.c(this.axQ, d.e.cp_cont_d, 1);
        }
    }

    public void kq() {
        this.axR.kq();
        this.axR.setContentDescription(this.mContext.getString(d.l.talk_message_tip) + this.mContext.getString(d.l.talk_close));
    }

    public void kp() {
        this.axR.kp();
        this.axR.setContentDescription(this.mContext.getString(d.l.talk_message_tip) + this.mContext.getString(d.l.talk_open));
    }

    public void R(boolean z) {
        this.axR.R(z);
        this.axR.setContentDescription(this.mContext.getString(d.l.talk_message_tip) + this.mContext.getString(d.l.talk_close));
    }

    public void Q(boolean z) {
        this.axR.Q(z);
        this.axR.setContentDescription(this.mContext.getString(d.l.talk_message_tip) + this.mContext.getString(d.l.talk_open));
    }

    public void setText(String str) {
        this.axP.setText(str);
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.axR.setOnSwitchStateChangeListener(aVar);
    }

    private void By() {
        LayoutInflater.from(this.mContext).inflate(d.j.setting_text_switch_view, (ViewGroup) this, true);
        this.axO = (LinearLayout) findViewById(d.h.container);
        this.axP = (TextView) findViewById(d.h.text);
        this.axR = (BdSwitchView) findViewById(d.h.button);
        this.axR.setFocusable(true);
        this.axQ = (TextView) findViewById(d.h.tip);
        if (this.axQ != null) {
            this.axQ.setVisibility(8);
        }
        setTag(this.axR);
        this.axO.setClickable(false);
        this.axO.setFocusable(false);
    }

    private void b(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.n.TbSettingView);
        String string = obtainStyledAttributes.getString(d.n.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(d.n.TbSettingView_settingTextColor, -1);
        float dimension = obtainStyledAttributes.getDimension(d.n.TbSettingView_settingTextSize, -1.0f);
        String string2 = obtainStyledAttributes.getString(d.n.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(d.n.TbSettingView_settingTipColor, -1);
        if (this.axQ != null && string2 != null) {
            this.axQ.setVisibility(0);
            this.axQ.setText(string2);
            if (color2 > -1) {
                this.axQ.setTextColor(color2);
            }
        }
        if (string != null) {
            this.axP.setText(string);
        }
        if (color > -1) {
            this.axP.setTextColor(color);
        }
        if (dimension > -1.0f) {
            this.axP.setTextSize(0, dimension);
        }
        this.axO.setClickable(false);
        this.axO.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.axQ != null) {
            displayTip();
            this.axQ.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.axQ != null) {
            displayTip();
            this.axQ.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.axQ != null) {
            this.axQ.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.axQ != null) {
            this.axQ.setVisibility(8);
        }
    }

    public void setTextLeftMargin(int i) {
        if (this.axP.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.axP.getLayoutParams();
            layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(i);
            this.axP.setLayoutParams(layoutParams);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.axR;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.axR = bdSwitchView;
    }
}
