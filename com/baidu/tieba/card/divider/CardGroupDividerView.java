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
    private static final int ceU = d.C0096d.cp_bg_line_c;
    private static final int ceV = d.C0096d.cp_bg_line_c;
    private View ceS;
    private View ceT;
    private int ceW;
    private TextView mTitle;

    public void setTitleClickListener(View.OnClickListener onClickListener) {
        if (this.mTitle != null) {
            this.mTitle.setOnClickListener(onClickListener);
        }
    }

    public CardGroupDividerView(Context context) {
        super(context);
        this.ceW = ceV;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ceW = ceV;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ceW = ceV;
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(d.h.card_divider_view, (ViewGroup) this, true);
        this.ceS = findViewById(d.g.card_divider_top_margin);
        this.mTitle = (TextView) findViewById(d.g.card_divider_tv);
        this.ceT = findViewById(d.g.bottom_line);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        aj.k(this, d.C0096d.cp_bg_line_d);
        aj.k(this.ceS, d.C0096d.cp_bg_line_c);
        aj.i(this.mTitle, d.C0096d.cp_cont_d);
        aj.k(this.ceT, this.ceW);
    }

    public void setTitleText(String str) {
        this.mTitle.setText(str);
    }

    public void d(int i, float f) {
        this.mTitle.setTextSize(i, f);
    }

    public void acz() {
        if (this.ceS.getVisibility() != 8) {
            this.ceS.setVisibility(8);
        }
    }

    public void acA() {
        if (this.ceS.getVisibility() != 0) {
            this.ceS.setVisibility(0);
        }
    }

    public void acB() {
        acz();
        if (this.mTitle.getVisibility() != 8) {
            this.mTitle.setVisibility(8);
        }
        if (this.ceT.getVisibility() != 0) {
            this.ceT.setVisibility(0);
            setDividerColor(ceV);
        }
    }

    public void z(String str, boolean z) {
        if (z) {
            acA();
        } else {
            acz();
        }
        if (TextUtils.isEmpty(str)) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setText(str);
        }
        if (this.ceT.getVisibility() != 0) {
            this.ceT.setVisibility(0);
            setDividerColor(ceU);
        }
    }

    private void setDividerColor(int i) {
        this.ceW = i;
        aj.k(this.ceT, this.ceW);
    }

    public View getBotttomLine() {
        return this.ceT;
    }
}
