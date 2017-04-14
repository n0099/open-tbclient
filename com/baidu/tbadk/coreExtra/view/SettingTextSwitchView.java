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
    private LinearLayout avC;
    private TextView avD;
    protected TextView avE;
    private BdSwitchView avF;
    private final Context mContext;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        BL();
        d(attributeSet);
        ej(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        BL();
        ej(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        BL();
        d(attributeSet);
        ej(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public View getView() {
        return this.avC;
    }

    public void ej(int i) {
        this.avF.a(aq.cO(w.g.bg_switch_open), aq.cO(w.g.bg_switch_close), aq.cO(w.g.btn_handle));
        aq.c(this.avD, w.e.cp_cont_b, 1);
        if (this.avE != null) {
            aq.c(this.avE, w.e.cp_cont_d, 1);
        }
    }

    public void ks() {
        this.avF.ks();
        this.avF.setContentDescription(String.valueOf(this.mContext.getString(w.l.talk_message_tip)) + this.mContext.getString(w.l.talk_close));
    }

    public void kr() {
        this.avF.kr();
        this.avF.setContentDescription(String.valueOf(this.mContext.getString(w.l.talk_message_tip)) + this.mContext.getString(w.l.talk_open));
    }

    public void Q(boolean z) {
        this.avF.Q(z);
        this.avF.setContentDescription(String.valueOf(this.mContext.getString(w.l.talk_message_tip)) + this.mContext.getString(w.l.talk_close));
    }

    public void P(boolean z) {
        this.avF.P(z);
        this.avF.setContentDescription(String.valueOf(this.mContext.getString(w.l.talk_message_tip)) + this.mContext.getString(w.l.talk_open));
    }

    public void setText(String str) {
        this.avD.setText(str);
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.avF.setOnSwitchStateChangeListener(aVar);
    }

    private void BL() {
        LayoutInflater.from(this.mContext).inflate(w.j.setting_text_switch_view, (ViewGroup) this, true);
        this.avC = (LinearLayout) findViewById(w.h.container);
        this.avD = (TextView) findViewById(w.h.text);
        this.avF = (BdSwitchView) findViewById(w.h.button);
        this.avF.setFocusable(true);
        this.avE = (TextView) findViewById(w.h.tip);
        if (this.avE != null) {
            this.avE.setVisibility(8);
        }
        setTag(this.avF);
        this.avC.setClickable(false);
        this.avC.setFocusable(false);
    }

    private void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, w.n.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        float dimension = obtainStyledAttributes.getDimension(2, -1.0f);
        String string2 = obtainStyledAttributes.getString(3);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (this.avE != null && string2 != null) {
            this.avE.setVisibility(0);
            this.avE.setText(string2);
            if (color2 > -1) {
                this.avE.setTextColor(color2);
            }
        }
        if (string != null) {
            this.avD.setText(string);
        }
        if (color > -1) {
            this.avD.setTextColor(color);
        }
        if (dimension > -1.0f) {
            this.avD.setTextSize(0, dimension);
        }
        this.avC.setClickable(false);
        this.avC.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.avE != null) {
            displayTip();
            this.avE.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.avE != null) {
            displayTip();
            this.avE.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.avE != null) {
            this.avE.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.avE != null) {
            this.avE.setVisibility(8);
        }
    }

    public void setTextLeftMargin(int i) {
        if (this.avD.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.avD.getLayoutParams();
            layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(i);
            this.avD.setLayoutParams(layoutParams);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.avF;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.avF = bdSwitchView;
    }
}
