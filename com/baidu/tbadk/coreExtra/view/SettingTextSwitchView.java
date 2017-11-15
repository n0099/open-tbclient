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
    private LinearLayout axr;
    private TextView axs;
    protected TextView axt;
    private BdSwitchView axu;
    private final Context mContext;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        Bl();
        b(attributeSet);
        ex(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        Bl();
        ex(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        Bl();
        b(attributeSet);
        ex(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.axr;
    }

    public void ex(int i) {
        this.axu.a(aj.cQ(d.f.bg_switch_open), aj.cQ(d.f.bg_switch_close), aj.cQ(d.f.btn_handle));
        aj.c(this.axs, d.C0080d.cp_cont_b, 1);
        if (this.axt != null) {
            aj.c(this.axt, d.C0080d.cp_cont_d, 1);
        }
    }

    public void km() {
        this.axu.km();
        this.axu.setContentDescription(this.mContext.getString(d.j.talk_message_tip) + this.mContext.getString(d.j.talk_close));
    }

    public void kl() {
        this.axu.kl();
        this.axu.setContentDescription(this.mContext.getString(d.j.talk_message_tip) + this.mContext.getString(d.j.talk_open));
    }

    public void R(boolean z) {
        this.axu.R(z);
        this.axu.setContentDescription(this.mContext.getString(d.j.talk_message_tip) + this.mContext.getString(d.j.talk_close));
    }

    public void Q(boolean z) {
        this.axu.Q(z);
        this.axu.setContentDescription(this.mContext.getString(d.j.talk_message_tip) + this.mContext.getString(d.j.talk_open));
    }

    public void setText(String str) {
        this.axs.setText(str);
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.axu.setOnSwitchStateChangeListener(aVar);
    }

    private void Bl() {
        LayoutInflater.from(this.mContext).inflate(d.h.setting_text_switch_view, (ViewGroup) this, true);
        this.axr = (LinearLayout) findViewById(d.g.container);
        this.axs = (TextView) findViewById(d.g.text);
        this.axu = (BdSwitchView) findViewById(d.g.button);
        this.axu.setFocusable(true);
        this.axt = (TextView) findViewById(d.g.tip);
        if (this.axt != null) {
            this.axt.setVisibility(8);
        }
        setTag(this.axu);
        this.axr.setClickable(false);
        this.axr.setFocusable(false);
    }

    private void b(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.l.TbSettingView);
        String string = obtainStyledAttributes.getString(d.l.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(d.l.TbSettingView_settingTextColor, -1);
        float dimension = obtainStyledAttributes.getDimension(d.l.TbSettingView_settingTextSize, -1.0f);
        String string2 = obtainStyledAttributes.getString(d.l.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(d.l.TbSettingView_settingTipColor, -1);
        if (this.axt != null && string2 != null) {
            this.axt.setVisibility(0);
            this.axt.setText(string2);
            if (color2 > -1) {
                this.axt.setTextColor(color2);
            }
        }
        if (string != null) {
            this.axs.setText(string);
        }
        if (color > -1) {
            this.axs.setTextColor(color);
        }
        if (dimension > -1.0f) {
            this.axs.setTextSize(0, dimension);
        }
        this.axr.setClickable(false);
        this.axr.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.axt != null) {
            displayTip();
            this.axt.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.axt != null) {
            displayTip();
            this.axt.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.axt != null) {
            this.axt.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.axt != null) {
            this.axt.setVisibility(8);
        }
    }

    public void setTextLeftMargin(int i) {
        if (this.axs.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.axs.getLayoutParams();
            layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(i);
            this.axs.setLayoutParams(layoutParams);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.axu;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.axu = bdSwitchView;
    }
}
