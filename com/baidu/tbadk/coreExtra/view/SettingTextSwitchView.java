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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class SettingTextSwitchView extends FrameLayout {
    private LinearLayout aQi;
    private TextView aQj;
    protected TextView aQk;
    private BdSwitchView aQl;
    private final Context mContext;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        Jh();
        c(attributeSet);
        eS(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        Jh();
        eS(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        Jh();
        c(attributeSet);
        eS(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.aQi;
    }

    public void eS(int i) {
        this.aQl.setBackgroundRes(al.dm(e.f.bg_switch_open), al.dm(e.f.bg_switch_close), al.dm(e.f.btn_handle));
        al.c(this.aQj, e.d.cp_cont_b, 1);
        if (this.aQk != null) {
            al.c(this.aQk, e.d.cp_cont_d, 1);
        }
    }

    public void nV() {
        this.aQl.nV();
        this.aQl.setContentDescription(this.mContext.getString(e.j.talk_message_tip) + this.mContext.getString(e.j.talk_close));
    }

    public void nU() {
        this.aQl.nU();
        this.aQl.setContentDescription(this.mContext.getString(e.j.talk_message_tip) + this.mContext.getString(e.j.talk_open));
    }

    public void ae(boolean z) {
        this.aQl.ae(z);
        this.aQl.setContentDescription(this.mContext.getString(e.j.talk_message_tip) + this.mContext.getString(e.j.talk_close));
    }

    public void ad(boolean z) {
        this.aQl.ad(z);
        this.aQl.setContentDescription(this.mContext.getString(e.j.talk_message_tip) + this.mContext.getString(e.j.talk_open));
    }

    public void setText(String str) {
        this.aQj.setText(str);
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.aQl.setOnSwitchStateChangeListener(aVar);
    }

    private void Jh() {
        LayoutInflater.from(this.mContext).inflate(e.h.setting_text_switch_view, (ViewGroup) this, true);
        this.aQi = (LinearLayout) findViewById(e.g.container);
        this.aQj = (TextView) findViewById(e.g.text);
        this.aQl = (BdSwitchView) findViewById(e.g.button);
        this.aQl.setFocusable(true);
        this.aQk = (TextView) findViewById(e.g.tip);
        if (this.aQk != null) {
            this.aQk.setVisibility(8);
        }
        setTag(this.aQl);
        this.aQi.setClickable(false);
        this.aQi.setFocusable(false);
    }

    private void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, e.l.TbSettingView);
        String string = obtainStyledAttributes.getString(e.l.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(e.l.TbSettingView_settingTextColor, -1);
        float dimension = obtainStyledAttributes.getDimension(e.l.TbSettingView_settingTextSize, -1.0f);
        String string2 = obtainStyledAttributes.getString(e.l.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(e.l.TbSettingView_settingTipColor, -1);
        if (this.aQk != null && string2 != null) {
            this.aQk.setVisibility(0);
            this.aQk.setText(string2);
            if (color2 > -1) {
                this.aQk.setTextColor(color2);
            }
        }
        if (string != null) {
            this.aQj.setText(string);
        }
        if (color > -1) {
            this.aQj.setTextColor(color);
        }
        if (dimension > -1.0f) {
            this.aQj.setTextSize(0, dimension);
        }
        this.aQi.setClickable(false);
        this.aQi.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.aQk != null) {
            displayTip();
            this.aQk.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.aQk != null) {
            displayTip();
            this.aQk.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.aQk != null) {
            this.aQk.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.aQk != null) {
            this.aQk.setVisibility(8);
        }
    }

    public void setTextLeftMargin(int i) {
        if (this.aQj.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aQj.getLayoutParams();
            layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(i);
            this.aQj.setLayoutParams(layoutParams);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.aQl;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.aQl = bdSwitchView;
    }
}
