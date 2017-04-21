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
    private LinearLayout avE;
    private TextView avF;
    protected TextView avG;
    private BdSwitchView avH;
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
        return this.avE;
    }

    public void ej(int i) {
        this.avH.a(aq.cO(w.g.bg_switch_open), aq.cO(w.g.bg_switch_close), aq.cO(w.g.btn_handle));
        aq.c(this.avF, w.e.cp_cont_b, 1);
        if (this.avG != null) {
            aq.c(this.avG, w.e.cp_cont_d, 1);
        }
    }

    public void kt() {
        this.avH.kt();
        this.avH.setContentDescription(String.valueOf(this.mContext.getString(w.l.talk_message_tip)) + this.mContext.getString(w.l.talk_close));
    }

    public void ks() {
        this.avH.ks();
        this.avH.setContentDescription(String.valueOf(this.mContext.getString(w.l.talk_message_tip)) + this.mContext.getString(w.l.talk_open));
    }

    public void Q(boolean z) {
        this.avH.Q(z);
        this.avH.setContentDescription(String.valueOf(this.mContext.getString(w.l.talk_message_tip)) + this.mContext.getString(w.l.talk_close));
    }

    public void P(boolean z) {
        this.avH.P(z);
        this.avH.setContentDescription(String.valueOf(this.mContext.getString(w.l.talk_message_tip)) + this.mContext.getString(w.l.talk_open));
    }

    public void setText(String str) {
        this.avF.setText(str);
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.avH.setOnSwitchStateChangeListener(aVar);
    }

    private void BL() {
        LayoutInflater.from(this.mContext).inflate(w.j.setting_text_switch_view, (ViewGroup) this, true);
        this.avE = (LinearLayout) findViewById(w.h.container);
        this.avF = (TextView) findViewById(w.h.text);
        this.avH = (BdSwitchView) findViewById(w.h.button);
        this.avH.setFocusable(true);
        this.avG = (TextView) findViewById(w.h.tip);
        if (this.avG != null) {
            this.avG.setVisibility(8);
        }
        setTag(this.avH);
        this.avE.setClickable(false);
        this.avE.setFocusable(false);
    }

    private void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, w.n.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        float dimension = obtainStyledAttributes.getDimension(2, -1.0f);
        String string2 = obtainStyledAttributes.getString(3);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (this.avG != null && string2 != null) {
            this.avG.setVisibility(0);
            this.avG.setText(string2);
            if (color2 > -1) {
                this.avG.setTextColor(color2);
            }
        }
        if (string != null) {
            this.avF.setText(string);
        }
        if (color > -1) {
            this.avF.setTextColor(color);
        }
        if (dimension > -1.0f) {
            this.avF.setTextSize(0, dimension);
        }
        this.avE.setClickable(false);
        this.avE.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.avG != null) {
            displayTip();
            this.avG.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.avG != null) {
            displayTip();
            this.avG.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.avG != null) {
            this.avG.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.avG != null) {
            this.avG.setVisibility(8);
        }
    }

    public void setTextLeftMargin(int i) {
        if (this.avF.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.avF.getLayoutParams();
            layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(i);
            this.avF.setLayoutParams(layoutParams);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.avH;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.avH = bdSwitchView;
    }
}
