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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class SettingTextSwitchView extends FrameLayout {
    private LinearLayout apS;
    private TextView apT;
    protected TextView apU;
    private BdSwitchView apV;
    private final Context mContext;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        AU();
        d(attributeSet);
        el(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        AU();
        el(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        AU();
        d(attributeSet);
        el(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public View getView() {
        return this.apS;
    }

    public void el(int i) {
        this.apV.a(ap.cP(r.g.bg_switch_open), ap.cP(r.g.bg_switch_close), ap.cP(r.g.btn_handle));
        ap.c(this.apT, r.e.cp_cont_b, 1);
        if (this.apU != null) {
            ap.c(this.apU, r.e.cp_cont_d, 1);
        }
    }

    public void ju() {
        this.apV.ju();
        this.apV.setContentDescription(String.valueOf(this.mContext.getString(r.l.talk_message_tip)) + this.mContext.getString(r.l.talk_close));
    }

    public void jt() {
        this.apV.jt();
        this.apV.setContentDescription(String.valueOf(this.mContext.getString(r.l.talk_message_tip)) + this.mContext.getString(r.l.talk_open));
    }

    public void P(boolean z) {
        this.apV.P(z);
        this.apV.setContentDescription(String.valueOf(this.mContext.getString(r.l.talk_message_tip)) + this.mContext.getString(r.l.talk_close));
    }

    public void O(boolean z) {
        this.apV.O(z);
        this.apV.setContentDescription(String.valueOf(this.mContext.getString(r.l.talk_message_tip)) + this.mContext.getString(r.l.talk_open));
    }

    public void setText(String str) {
        this.apT.setText(str);
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.apV.setOnSwitchStateChangeListener(aVar);
    }

    private void AU() {
        LayoutInflater.from(this.mContext).inflate(r.j.setting_text_switch_view, (ViewGroup) this, true);
        this.apS = (LinearLayout) findViewById(r.h.container);
        this.apT = (TextView) findViewById(r.h.text);
        this.apV = (BdSwitchView) findViewById(r.h.button);
        this.apV.setFocusable(true);
        this.apU = (TextView) findViewById(r.h.tip);
        if (this.apU != null) {
            this.apU.setVisibility(8);
        }
        setTag(this.apV);
        this.apS.setClickable(false);
        this.apS.setFocusable(false);
    }

    private void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, r.n.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        float dimension = obtainStyledAttributes.getDimension(2, -1.0f);
        String string2 = obtainStyledAttributes.getString(3);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (this.apU != null && string2 != null) {
            this.apU.setVisibility(0);
            this.apU.setText(string2);
            if (color2 > -1) {
                this.apU.setTextColor(color2);
            }
        }
        if (string != null) {
            this.apT.setText(string);
        }
        if (color > -1) {
            this.apT.setTextColor(color);
        }
        if (dimension > -1.0f) {
            this.apT.setTextSize(0, dimension);
        }
        this.apS.setClickable(false);
        this.apS.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.apU != null) {
            displayTip();
            this.apU.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.apU != null) {
            displayTip();
            this.apU.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.apU != null) {
            this.apU.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.apU != null) {
            this.apU.setVisibility(8);
        }
    }

    public void setTextLeftMargin(int i) {
        if (this.apT.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.apT.getLayoutParams();
            layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(i);
            this.apT.setLayoutParams(layoutParams);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.apV;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.apV = bdSwitchView;
    }
}
