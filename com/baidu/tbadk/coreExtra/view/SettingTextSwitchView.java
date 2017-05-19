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
    private LinearLayout avI;
    private TextView avJ;
    protected TextView avK;
    private BdSwitchView avL;
    private final Context mContext;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        AW();
        d(attributeSet);
        eh(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        AW();
        eh(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        AW();
        d(attributeSet);
        eh(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public View getView() {
        return this.avI;
    }

    public void eh(int i) {
        this.avL.a(aq.cL(w.g.bg_switch_open), aq.cL(w.g.bg_switch_close), aq.cL(w.g.btn_handle));
        aq.c(this.avJ, w.e.cp_cont_b, 1);
        if (this.avK != null) {
            aq.c(this.avK, w.e.cp_cont_d, 1);
        }
    }

    public void ks() {
        this.avL.ks();
        this.avL.setContentDescription(String.valueOf(this.mContext.getString(w.l.talk_message_tip)) + this.mContext.getString(w.l.talk_close));
    }

    public void kr() {
        this.avL.kr();
        this.avL.setContentDescription(String.valueOf(this.mContext.getString(w.l.talk_message_tip)) + this.mContext.getString(w.l.talk_open));
    }

    public void Q(boolean z) {
        this.avL.Q(z);
        this.avL.setContentDescription(String.valueOf(this.mContext.getString(w.l.talk_message_tip)) + this.mContext.getString(w.l.talk_close));
    }

    public void P(boolean z) {
        this.avL.P(z);
        this.avL.setContentDescription(String.valueOf(this.mContext.getString(w.l.talk_message_tip)) + this.mContext.getString(w.l.talk_open));
    }

    public void setText(String str) {
        this.avJ.setText(str);
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.avL.setOnSwitchStateChangeListener(aVar);
    }

    private void AW() {
        LayoutInflater.from(this.mContext).inflate(w.j.setting_text_switch_view, (ViewGroup) this, true);
        this.avI = (LinearLayout) findViewById(w.h.container);
        this.avJ = (TextView) findViewById(w.h.text);
        this.avL = (BdSwitchView) findViewById(w.h.button);
        this.avL.setFocusable(true);
        this.avK = (TextView) findViewById(w.h.tip);
        if (this.avK != null) {
            this.avK.setVisibility(8);
        }
        setTag(this.avL);
        this.avI.setClickable(false);
        this.avI.setFocusable(false);
    }

    private void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, w.n.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        float dimension = obtainStyledAttributes.getDimension(2, -1.0f);
        String string2 = obtainStyledAttributes.getString(3);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (this.avK != null && string2 != null) {
            this.avK.setVisibility(0);
            this.avK.setText(string2);
            if (color2 > -1) {
                this.avK.setTextColor(color2);
            }
        }
        if (string != null) {
            this.avJ.setText(string);
        }
        if (color > -1) {
            this.avJ.setTextColor(color);
        }
        if (dimension > -1.0f) {
            this.avJ.setTextSize(0, dimension);
        }
        this.avI.setClickable(false);
        this.avI.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.avK != null) {
            displayTip();
            this.avK.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.avK != null) {
            displayTip();
            this.avK.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.avK != null) {
            this.avK.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.avK != null) {
            this.avK.setVisibility(8);
        }
    }

    public void setTextLeftMargin(int i) {
        if (this.avJ.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.avJ.getLayoutParams();
            layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(i);
            this.avJ.setLayoutParams(layoutParams);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.avL;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.avL = bdSwitchView;
    }
}
