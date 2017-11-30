package com.baidu.tieba.card.divider;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class CardGroupDividerView extends LinearLayout {
    private static final int ceG = d.C0082d.cp_bg_line_c;
    private static final int ceH = d.C0082d.cp_bg_line_c;
    private View ceE;
    private View ceF;
    private int ceI;
    private TextView mTitle;

    public void setTitleClickListener(View.OnClickListener onClickListener) {
        if (this.mTitle != null) {
            this.mTitle.setOnClickListener(onClickListener);
        }
    }

    public CardGroupDividerView(Context context) {
        super(context);
        this.ceI = ceH;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ceI = ceH;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ceI = ceH;
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(d.h.card_divider_view, (ViewGroup) this, true);
        this.ceE = findViewById(d.g.card_divider_top_margin);
        this.mTitle = (TextView) findViewById(d.g.card_divider_tv);
        this.ceF = findViewById(d.g.bottom_line);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        aj.k(this, d.C0082d.cp_bg_line_d);
        aj.k(this.ceE, d.C0082d.cp_bg_line_c);
        aj.i(this.mTitle, d.C0082d.cp_cont_d);
        aj.k(this.ceF, this.ceI);
    }

    public void setTitleText(String str) {
        this.mTitle.setText(str);
    }

    public void d(int i, float f) {
        this.mTitle.setTextSize(i, f);
    }

    public void acp() {
        if (this.ceE.getVisibility() != 8) {
            this.ceE.setVisibility(8);
        }
    }

    public void acq() {
        if (this.ceE.getVisibility() != 0) {
            this.ceE.setVisibility(0);
        }
    }

    public void acr() {
        acp();
        if (this.mTitle.getVisibility() != 8) {
            this.mTitle.setVisibility(8);
        }
        if (this.ceF.getVisibility() != 0) {
            this.ceF.setVisibility(0);
            setDividerColor(ceH);
        }
    }

    public void x(String str, boolean z) {
        if (z) {
            acq();
        } else {
            acp();
        }
        if (TextUtils.isEmpty(str)) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setText(str);
        }
        if (this.ceF.getVisibility() != 0) {
            this.ceF.setVisibility(0);
            setDividerColor(ceG);
        }
    }

    private void setDividerColor(int i) {
        this.ceI = i;
        aj.k(this.ceF, this.ceI);
    }

    public View getBotttomLine() {
        return this.ceF;
    }
}
