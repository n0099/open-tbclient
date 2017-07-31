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
    private LinearLayout ayE;
    private TextView ayF;
    protected TextView ayG;
    private BdSwitchView ayH;
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
        return this.ayE;
    }

    public void eo(int i) {
        this.ayH.a(ai.cS(d.g.bg_switch_open), ai.cS(d.g.bg_switch_close), ai.cS(d.g.btn_handle));
        ai.c(this.ayF, d.e.cp_cont_b, 1);
        if (this.ayG != null) {
            ai.c(this.ayG, d.e.cp_cont_d, 1);
        }
    }

    public void kz() {
        this.ayH.kz();
        this.ayH.setContentDescription(this.mContext.getString(d.l.talk_message_tip) + this.mContext.getString(d.l.talk_close));
    }

    public void ky() {
        this.ayH.ky();
        this.ayH.setContentDescription(this.mContext.getString(d.l.talk_message_tip) + this.mContext.getString(d.l.talk_open));
    }

    public void Q(boolean z) {
        this.ayH.Q(z);
        this.ayH.setContentDescription(this.mContext.getString(d.l.talk_message_tip) + this.mContext.getString(d.l.talk_close));
    }

    public void P(boolean z) {
        this.ayH.P(z);
        this.ayH.setContentDescription(this.mContext.getString(d.l.talk_message_tip) + this.mContext.getString(d.l.talk_open));
    }

    public void setText(String str) {
        this.ayF.setText(str);
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.ayH.setOnSwitchStateChangeListener(aVar);
    }

    private void BD() {
        LayoutInflater.from(this.mContext).inflate(d.j.setting_text_switch_view, (ViewGroup) this, true);
        this.ayE = (LinearLayout) findViewById(d.h.container);
        this.ayF = (TextView) findViewById(d.h.text);
        this.ayH = (BdSwitchView) findViewById(d.h.button);
        this.ayH.setFocusable(true);
        this.ayG = (TextView) findViewById(d.h.tip);
        if (this.ayG != null) {
            this.ayG.setVisibility(8);
        }
        setTag(this.ayH);
        this.ayE.setClickable(false);
        this.ayE.setFocusable(false);
    }

    private void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.n.TbSettingView);
        String string = obtainStyledAttributes.getString(d.n.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(d.n.TbSettingView_settingTextColor, -1);
        float dimension = obtainStyledAttributes.getDimension(d.n.TbSettingView_settingTextSize, -1.0f);
        String string2 = obtainStyledAttributes.getString(d.n.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(d.n.TbSettingView_settingTipColor, -1);
        if (this.ayG != null && string2 != null) {
            this.ayG.setVisibility(0);
            this.ayG.setText(string2);
            if (color2 > -1) {
                this.ayG.setTextColor(color2);
            }
        }
        if (string != null) {
            this.ayF.setText(string);
        }
        if (color > -1) {
            this.ayF.setTextColor(color);
        }
        if (dimension > -1.0f) {
            this.ayF.setTextSize(0, dimension);
        }
        this.ayE.setClickable(false);
        this.ayE.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.ayG != null) {
            displayTip();
            this.ayG.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.ayG != null) {
            displayTip();
            this.ayG.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.ayG != null) {
            this.ayG.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.ayG != null) {
            this.ayG.setVisibility(8);
        }
    }

    public void setTextLeftMargin(int i) {
        if (this.ayF.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ayF.getLayoutParams();
            layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(i);
            this.ayF.setLayoutParams(layoutParams);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.ayH;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.ayH = bdSwitchView;
    }
}
