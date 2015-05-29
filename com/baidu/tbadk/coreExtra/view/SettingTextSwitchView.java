package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class SettingTextSwitchView extends FrameLayout {
    private LinearLayout agF;
    private TextView agG;
    protected TextView agH;
    private BdSwitchView agI;
    private final Context mContext;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        yb();
        c(attributeSet);
        dl(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        yb();
        dl(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        yb();
        c(attributeSet);
        dl(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public View getView() {
        return this.agF;
    }

    public void dl(int i) {
        this.agI.a(com.baidu.tbadk.core.util.ay.ck(com.baidu.tieba.p.bg_game_switch_open), com.baidu.tbadk.core.util.ay.ck(com.baidu.tieba.p.bg_game_switch_close), com.baidu.tbadk.core.util.ay.ck(com.baidu.tieba.p.btn_game_handle));
        com.baidu.tbadk.core.util.ay.b(this.agG, com.baidu.tieba.n.cp_cont_b, 1);
        if (this.agH != null) {
            com.baidu.tbadk.core.util.ay.b(this.agH, com.baidu.tieba.n.cp_cont_d, 1);
        }
    }

    public void mu() {
        this.agI.mu();
    }

    public void mt() {
        this.agI.mt();
    }

    public void O(boolean z) {
        this.agI.O(z);
    }

    public void N(boolean z) {
        this.agI.N(z);
    }

    public void setText(String str) {
        this.agG.setText(str);
    }

    public void setSwitchStateChangeListener(com.baidu.adp.widget.BdSwitchView.b bVar) {
        this.agI.setOnSwitchStateChangeListener(bVar);
    }

    private void yb() {
        com.baidu.adp.lib.g.b.hr().a(this.mContext, com.baidu.tieba.r.setting_text_switch_view, this, true);
        this.agF = (LinearLayout) findViewById(com.baidu.tieba.q.container);
        this.agG = (TextView) findViewById(com.baidu.tieba.q.text);
        this.agI = (BdSwitchView) findViewById(com.baidu.tieba.q.button);
        this.agH = (TextView) findViewById(com.baidu.tieba.q.tip);
        if (this.agH != null) {
            this.agH.setVisibility(8);
        }
        setTag(this.agI);
        this.agF.setClickable(false);
        this.agF.setFocusable(false);
    }

    private void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, com.baidu.tieba.v.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        float dimension = obtainStyledAttributes.getDimension(2, -1.0f);
        String string2 = obtainStyledAttributes.getString(3);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (this.agH != null && string2 != null) {
            this.agH.setVisibility(0);
            this.agH.setText(string2);
            if (color2 > -1) {
                this.agH.setTextColor(color2);
            }
        }
        if (string != null) {
            this.agG.setText(string);
        }
        if (color > -1) {
            this.agG.setTextColor(color);
        }
        if (dimension > -1.0f) {
            this.agG.setTextSize(0, dimension);
        }
        this.agF.setClickable(false);
        this.agF.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.agH != null) {
            displayTip();
            this.agH.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.agH != null) {
            displayTip();
            this.agH.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.agH != null) {
            this.agH.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.agH != null) {
            this.agH.setVisibility(8);
        }
    }

    public void setTextLeftMargin(int i) {
        if (this.agG.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.agG.getLayoutParams();
            layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(i);
            this.agG.setLayoutParams(layoutParams);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.agI;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.agI = bdSwitchView;
    }
}
