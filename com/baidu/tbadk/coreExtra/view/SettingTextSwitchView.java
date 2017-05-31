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
    private LinearLayout avs;
    private TextView avt;
    protected TextView avu;
    private BdSwitchView avv;
    private final Context mContext;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        AP();
        c(attributeSet);
        ei(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        AP();
        ei(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        AP();
        c(attributeSet);
        ei(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public View getView() {
        return this.avs;
    }

    public void ei(int i) {
        this.avv.a(aq.cM(w.g.bg_switch_open), aq.cM(w.g.bg_switch_close), aq.cM(w.g.btn_handle));
        aq.c(this.avt, w.e.cp_cont_b, 1);
        if (this.avu != null) {
            aq.c(this.avu, w.e.cp_cont_d, 1);
        }
    }

    public void ks() {
        this.avv.ks();
        this.avv.setContentDescription(String.valueOf(this.mContext.getString(w.l.talk_message_tip)) + this.mContext.getString(w.l.talk_close));
    }

    public void kr() {
        this.avv.kr();
        this.avv.setContentDescription(String.valueOf(this.mContext.getString(w.l.talk_message_tip)) + this.mContext.getString(w.l.talk_open));
    }

    public void Q(boolean z) {
        this.avv.Q(z);
        this.avv.setContentDescription(String.valueOf(this.mContext.getString(w.l.talk_message_tip)) + this.mContext.getString(w.l.talk_close));
    }

    public void P(boolean z) {
        this.avv.P(z);
        this.avv.setContentDescription(String.valueOf(this.mContext.getString(w.l.talk_message_tip)) + this.mContext.getString(w.l.talk_open));
    }

    public void setText(String str) {
        this.avt.setText(str);
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.avv.setOnSwitchStateChangeListener(aVar);
    }

    private void AP() {
        LayoutInflater.from(this.mContext).inflate(w.j.setting_text_switch_view, (ViewGroup) this, true);
        this.avs = (LinearLayout) findViewById(w.h.container);
        this.avt = (TextView) findViewById(w.h.text);
        this.avv = (BdSwitchView) findViewById(w.h.button);
        this.avv.setFocusable(true);
        this.avu = (TextView) findViewById(w.h.tip);
        if (this.avu != null) {
            this.avu.setVisibility(8);
        }
        setTag(this.avv);
        this.avs.setClickable(false);
        this.avs.setFocusable(false);
    }

    private void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, w.n.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        float dimension = obtainStyledAttributes.getDimension(2, -1.0f);
        String string2 = obtainStyledAttributes.getString(3);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (this.avu != null && string2 != null) {
            this.avu.setVisibility(0);
            this.avu.setText(string2);
            if (color2 > -1) {
                this.avu.setTextColor(color2);
            }
        }
        if (string != null) {
            this.avt.setText(string);
        }
        if (color > -1) {
            this.avt.setTextColor(color);
        }
        if (dimension > -1.0f) {
            this.avt.setTextSize(0, dimension);
        }
        this.avs.setClickable(false);
        this.avs.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.avu != null) {
            displayTip();
            this.avu.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.avu != null) {
            displayTip();
            this.avu.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.avu != null) {
            this.avu.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.avu != null) {
            this.avu.setVisibility(8);
        }
    }

    public void setTextLeftMargin(int i) {
        if (this.avt.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.avt.getLayoutParams();
            layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(i);
            this.avt.setLayoutParams(layoutParams);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.avv;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.avv = bdSwitchView;
    }
}
