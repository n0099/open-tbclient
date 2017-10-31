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
    private LinearLayout axj;
    private TextView axk;
    protected TextView axl;
    private BdSwitchView axm;
    private final Context mContext;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        AZ();
        b(attributeSet);
        ey(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        AZ();
        ey(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        AZ();
        b(attributeSet);
        ey(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.axj;
    }

    public void ey(int i) {
        this.axm.a(aj.cR(d.f.bg_switch_open), aj.cR(d.f.bg_switch_close), aj.cR(d.f.btn_handle));
        aj.c(this.axk, d.C0080d.cp_cont_b, 1);
        if (this.axl != null) {
            aj.c(this.axl, d.C0080d.cp_cont_d, 1);
        }
    }

    public void km() {
        this.axm.km();
        this.axm.setContentDescription(this.mContext.getString(d.j.talk_message_tip) + this.mContext.getString(d.j.talk_close));
    }

    public void kl() {
        this.axm.kl();
        this.axm.setContentDescription(this.mContext.getString(d.j.talk_message_tip) + this.mContext.getString(d.j.talk_open));
    }

    public void R(boolean z) {
        this.axm.R(z);
        this.axm.setContentDescription(this.mContext.getString(d.j.talk_message_tip) + this.mContext.getString(d.j.talk_close));
    }

    public void Q(boolean z) {
        this.axm.Q(z);
        this.axm.setContentDescription(this.mContext.getString(d.j.talk_message_tip) + this.mContext.getString(d.j.talk_open));
    }

    public void setText(String str) {
        this.axk.setText(str);
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.axm.setOnSwitchStateChangeListener(aVar);
    }

    private void AZ() {
        LayoutInflater.from(this.mContext).inflate(d.h.setting_text_switch_view, (ViewGroup) this, true);
        this.axj = (LinearLayout) findViewById(d.g.container);
        this.axk = (TextView) findViewById(d.g.text);
        this.axm = (BdSwitchView) findViewById(d.g.button);
        this.axm.setFocusable(true);
        this.axl = (TextView) findViewById(d.g.tip);
        if (this.axl != null) {
            this.axl.setVisibility(8);
        }
        setTag(this.axm);
        this.axj.setClickable(false);
        this.axj.setFocusable(false);
    }

    private void b(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.l.TbSettingView);
        String string = obtainStyledAttributes.getString(d.l.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(d.l.TbSettingView_settingTextColor, -1);
        float dimension = obtainStyledAttributes.getDimension(d.l.TbSettingView_settingTextSize, -1.0f);
        String string2 = obtainStyledAttributes.getString(d.l.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(d.l.TbSettingView_settingTipColor, -1);
        if (this.axl != null && string2 != null) {
            this.axl.setVisibility(0);
            this.axl.setText(string2);
            if (color2 > -1) {
                this.axl.setTextColor(color2);
            }
        }
        if (string != null) {
            this.axk.setText(string);
        }
        if (color > -1) {
            this.axk.setTextColor(color);
        }
        if (dimension > -1.0f) {
            this.axk.setTextSize(0, dimension);
        }
        this.axj.setClickable(false);
        this.axj.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.axl != null) {
            displayTip();
            this.axl.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.axl != null) {
            displayTip();
            this.axl.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.axl != null) {
            this.axl.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.axl != null) {
            this.axl.setVisibility(8);
        }
    }

    public void setTextLeftMargin(int i) {
        if (this.axk.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.axk.getLayoutParams();
            layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(i);
            this.axk.setLayoutParams(layoutParams);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.axm;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.axm = bdSwitchView;
    }
}
