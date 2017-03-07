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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class SettingTextSwitchView extends FrameLayout {
    private LinearLayout avm;
    private TextView avn;
    protected TextView avo;
    private BdSwitchView avp;
    private final Context mContext;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        Bn();
        d(attributeSet);
        eg(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        Bn();
        eg(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        Bn();
        d(attributeSet);
        eg(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public View getView() {
        return this.avm;
    }

    public void eg(int i) {
        this.avp.a(aq.cL(w.g.bg_switch_open), aq.cL(w.g.bg_switch_close), aq.cL(w.g.btn_handle));
        aq.c(this.avn, w.e.cp_cont_b, 1);
        if (this.avo != null) {
            aq.c(this.avo, w.e.cp_cont_d, 1);
        }
    }

    public void ko() {
        this.avp.ko();
        this.avp.setContentDescription(String.valueOf(this.mContext.getString(w.l.talk_message_tip)) + this.mContext.getString(w.l.talk_close));
    }

    public void kn() {
        this.avp.kn();
        this.avp.setContentDescription(String.valueOf(this.mContext.getString(w.l.talk_message_tip)) + this.mContext.getString(w.l.talk_open));
    }

    public void Q(boolean z) {
        this.avp.Q(z);
        this.avp.setContentDescription(String.valueOf(this.mContext.getString(w.l.talk_message_tip)) + this.mContext.getString(w.l.talk_close));
    }

    public void P(boolean z) {
        this.avp.P(z);
        this.avp.setContentDescription(String.valueOf(this.mContext.getString(w.l.talk_message_tip)) + this.mContext.getString(w.l.talk_open));
    }

    public void setText(String str) {
        this.avn.setText(str);
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.avp.setOnSwitchStateChangeListener(aVar);
    }

    private void Bn() {
        LayoutInflater.from(this.mContext).inflate(w.j.setting_text_switch_view, (ViewGroup) this, true);
        this.avm = (LinearLayout) findViewById(w.h.container);
        this.avn = (TextView) findViewById(w.h.text);
        this.avp = (BdSwitchView) findViewById(w.h.button);
        this.avp.setFocusable(true);
        this.avo = (TextView) findViewById(w.h.tip);
        if (this.avo != null) {
            this.avo.setVisibility(8);
        }
        setTag(this.avp);
        this.avm.setClickable(false);
        this.avm.setFocusable(false);
    }

    private void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, w.n.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        float dimension = obtainStyledAttributes.getDimension(2, -1.0f);
        String string2 = obtainStyledAttributes.getString(3);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (this.avo != null && string2 != null) {
            this.avo.setVisibility(0);
            this.avo.setText(string2);
            if (color2 > -1) {
                this.avo.setTextColor(color2);
            }
        }
        if (string != null) {
            this.avn.setText(string);
        }
        if (color > -1) {
            this.avn.setTextColor(color);
        }
        if (dimension > -1.0f) {
            this.avn.setTextSize(0, dimension);
        }
        this.avm.setClickable(false);
        this.avm.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.avo != null) {
            displayTip();
            this.avo.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.avo != null) {
            displayTip();
            this.avo.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.avo != null) {
            this.avo.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.avo != null) {
            this.avo.setVisibility(8);
        }
    }

    public void setTextLeftMargin(int i) {
        if (this.avn.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.avn.getLayoutParams();
            layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(i);
            this.avn.setLayoutParams(layoutParams);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.avp;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.avp = bdSwitchView;
    }
}
