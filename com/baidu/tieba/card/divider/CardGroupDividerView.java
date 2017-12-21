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
    private static final int ceY = d.C0095d.cp_bg_line_c;
    private static final int ceZ = d.C0095d.cp_bg_line_c;
    private View ceW;
    private View ceX;
    private int cfa;
    private TextView mTitle;

    public void setTitleClickListener(View.OnClickListener onClickListener) {
        if (this.mTitle != null) {
            this.mTitle.setOnClickListener(onClickListener);
        }
    }

    public CardGroupDividerView(Context context) {
        super(context);
        this.cfa = ceZ;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cfa = ceZ;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cfa = ceZ;
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(d.h.card_divider_view, (ViewGroup) this, true);
        this.ceW = findViewById(d.g.card_divider_top_margin);
        this.mTitle = (TextView) findViewById(d.g.card_divider_tv);
        this.ceX = findViewById(d.g.bottom_line);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        aj.k(this, d.C0095d.cp_bg_line_d);
        aj.k(this.ceW, d.C0095d.cp_bg_line_c);
        aj.i(this.mTitle, d.C0095d.cp_cont_d);
        aj.k(this.ceX, this.cfa);
    }

    public void setTitleText(String str) {
        this.mTitle.setText(str);
    }

    public void d(int i, float f) {
        this.mTitle.setTextSize(i, f);
    }

    public void acy() {
        if (this.ceW.getVisibility() != 8) {
            this.ceW.setVisibility(8);
        }
    }

    public void acz() {
        if (this.ceW.getVisibility() != 0) {
            this.ceW.setVisibility(0);
        }
    }

    public void acA() {
        acy();
        if (this.mTitle.getVisibility() != 8) {
            this.mTitle.setVisibility(8);
        }
        if (this.ceX.getVisibility() != 0) {
            this.ceX.setVisibility(0);
            setDividerColor(ceZ);
        }
    }

    public void z(String str, boolean z) {
        if (z) {
            acz();
        } else {
            acy();
        }
        if (TextUtils.isEmpty(str)) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setText(str);
        }
        if (this.ceX.getVisibility() != 0) {
            this.ceX.setVisibility(0);
            setDividerColor(ceY);
        }
    }

    private void setDividerColor(int i) {
        this.cfa = i;
        aj.k(this.ceX, this.cfa);
    }

    public View getBotttomLine() {
        return this.ceX;
    }
}
