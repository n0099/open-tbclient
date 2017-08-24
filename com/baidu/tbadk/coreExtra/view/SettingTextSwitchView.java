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
    private LinearLayout ayG;
    private TextView ayH;
    protected TextView ayI;
    private BdSwitchView ayJ;
    private final Context mContext;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        BD();
        b(attributeSet);
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
        b(attributeSet);
        eo(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.ayG;
    }

    public void eo(int i) {
        this.ayJ.a(ai.cS(d.g.bg_switch_open), ai.cS(d.g.bg_switch_close), ai.cS(d.g.btn_handle));
        ai.c(this.ayH, d.e.cp_cont_b, 1);
        if (this.ayI != null) {
            ai.c(this.ayI, d.e.cp_cont_d, 1);
        }
    }

    public void ky() {
        this.ayJ.ky();
        this.ayJ.setContentDescription(this.mContext.getString(d.l.talk_message_tip) + this.mContext.getString(d.l.talk_close));
    }

    public void kx() {
        this.ayJ.kx();
        this.ayJ.setContentDescription(this.mContext.getString(d.l.talk_message_tip) + this.mContext.getString(d.l.talk_open));
    }

    public void Q(boolean z) {
        this.ayJ.Q(z);
        this.ayJ.setContentDescription(this.mContext.getString(d.l.talk_message_tip) + this.mContext.getString(d.l.talk_close));
    }

    public void P(boolean z) {
        this.ayJ.P(z);
        this.ayJ.setContentDescription(this.mContext.getString(d.l.talk_message_tip) + this.mContext.getString(d.l.talk_open));
    }

    public void setText(String str) {
        this.ayH.setText(str);
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.ayJ.setOnSwitchStateChangeListener(aVar);
    }

    private void BD() {
        LayoutInflater.from(this.mContext).inflate(d.j.setting_text_switch_view, (ViewGroup) this, true);
        this.ayG = (LinearLayout) findViewById(d.h.container);
        this.ayH = (TextView) findViewById(d.h.text);
        this.ayJ = (BdSwitchView) findViewById(d.h.button);
        this.ayJ.setFocusable(true);
        this.ayI = (TextView) findViewById(d.h.tip);
        if (this.ayI != null) {
            this.ayI.setVisibility(8);
        }
        setTag(this.ayJ);
        this.ayG.setClickable(false);
        this.ayG.setFocusable(false);
    }

    private void b(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.n.TbSettingView);
        String string = obtainStyledAttributes.getString(d.n.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(d.n.TbSettingView_settingTextColor, -1);
        float dimension = obtainStyledAttributes.getDimension(d.n.TbSettingView_settingTextSize, -1.0f);
        String string2 = obtainStyledAttributes.getString(d.n.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(d.n.TbSettingView_settingTipColor, -1);
        if (this.ayI != null && string2 != null) {
            this.ayI.setVisibility(0);
            this.ayI.setText(string2);
            if (color2 > -1) {
                this.ayI.setTextColor(color2);
            }
        }
        if (string != null) {
            this.ayH.setText(string);
        }
        if (color > -1) {
            this.ayH.setTextColor(color);
        }
        if (dimension > -1.0f) {
            this.ayH.setTextSize(0, dimension);
        }
        this.ayG.setClickable(false);
        this.ayG.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.ayI != null) {
            displayTip();
            this.ayI.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.ayI != null) {
            displayTip();
            this.ayI.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.ayI != null) {
            this.ayI.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.ayI != null) {
            this.ayI.setVisibility(8);
        }
    }

    public void setTextLeftMargin(int i) {
        if (this.ayH.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ayH.getLayoutParams();
            layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(i);
            this.ayH.setLayoutParams(layoutParams);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.ayJ;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.ayJ = bdSwitchView;
    }
}
