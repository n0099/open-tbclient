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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class SettingTextSwitchView extends FrameLayout {
    private LinearLayout ayF;
    private TextView ayG;
    protected TextView ayH;
    private BdSwitchView ayI;
    private final Context mContext;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        BD();
        c(attributeSet);
        eo(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        BD();
        eo(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        BD();
        c(attributeSet);
        eo(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.ayF;
    }

    public void eo(int i) {
        this.ayI.a(ai.cS(d.g.bg_switch_open), ai.cS(d.g.bg_switch_close), ai.cS(d.g.btn_handle));
        ai.c(this.ayG, d.e.cp_cont_b, 1);
        if (this.ayH != null) {
            ai.c(this.ayH, d.e.cp_cont_d, 1);
        }
    }

    public void kz() {
        this.ayI.kz();
        this.ayI.setContentDescription(this.mContext.getString(d.l.talk_message_tip) + this.mContext.getString(d.l.talk_close));
    }

    public void ky() {
        this.ayI.ky();
        this.ayI.setContentDescription(this.mContext.getString(d.l.talk_message_tip) + this.mContext.getString(d.l.talk_open));
    }

    public void Q(boolean z) {
        this.ayI.Q(z);
        this.ayI.setContentDescription(this.mContext.getString(d.l.talk_message_tip) + this.mContext.getString(d.l.talk_close));
    }

    public void P(boolean z) {
        this.ayI.P(z);
        this.ayI.setContentDescription(this.mContext.getString(d.l.talk_message_tip) + this.mContext.getString(d.l.talk_open));
    }

    public void setText(String str) {
        this.ayG.setText(str);
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.ayI.setOnSwitchStateChangeListener(aVar);
    }

    private void BD() {
        LayoutInflater.from(this.mContext).inflate(d.j.setting_text_switch_view, (ViewGroup) this, true);
        this.ayF = (LinearLayout) findViewById(d.h.container);
        this.ayG = (TextView) findViewById(d.h.text);
        this.ayI = (BdSwitchView) findViewById(d.h.button);
        this.ayI.setFocusable(true);
        this.ayH = (TextView) findViewById(d.h.tip);
        if (this.ayH != null) {
            this.ayH.setVisibility(8);
        }
        setTag(this.ayI);
        this.ayF.setClickable(false);
        this.ayF.setFocusable(false);
    }

    private void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.n.TbSettingView);
        String string = obtainStyledAttributes.getString(d.n.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(d.n.TbSettingView_settingTextColor, -1);
        float dimension = obtainStyledAttributes.getDimension(d.n.TbSettingView_settingTextSize, -1.0f);
        String string2 = obtainStyledAttributes.getString(d.n.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(d.n.TbSettingView_settingTipColor, -1);
        if (this.ayH != null && string2 != null) {
            this.ayH.setVisibility(0);
            this.ayH.setText(string2);
            if (color2 > -1) {
                this.ayH.setTextColor(color2);
            }
        }
        if (string != null) {
            this.ayG.setText(string);
        }
        if (color > -1) {
            this.ayG.setTextColor(color);
        }
        if (dimension > -1.0f) {
            this.ayG.setTextSize(0, dimension);
        }
        this.ayF.setClickable(false);
        this.ayF.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.ayH != null) {
            displayTip();
            this.ayH.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.ayH != null) {
            displayTip();
            this.ayH.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.ayH != null) {
            this.ayH.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.ayH != null) {
            this.ayH.setVisibility(8);
        }
    }

    public void setTextLeftMargin(int i) {
        if (this.ayG.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ayG.getLayoutParams();
            layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(i);
            this.ayG.setLayoutParams(layoutParams);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.ayI;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.ayI = bdSwitchView;
    }
}
