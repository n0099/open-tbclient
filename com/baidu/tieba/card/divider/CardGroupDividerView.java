package com.baidu.tieba.card.divider;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class CardGroupDividerView extends LinearLayout {
    private static final int emB = d.C0277d.cp_bg_line_c;
    private static final int emC = d.C0277d.cp_bg_line_c;
    private View emA;
    private int emD;
    private View emz;
    private TextView mTitle;

    public void setTitleClickListener(View.OnClickListener onClickListener) {
        if (this.mTitle != null) {
            this.mTitle.setOnClickListener(onClickListener);
        }
    }

    public CardGroupDividerView(Context context) {
        super(context);
        this.emD = emC;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.emD = emC;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.emD = emC;
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(d.h.card_divider_view, (ViewGroup) this, true);
        this.emz = findViewById(d.g.card_divider_top_margin);
        this.mTitle = (TextView) findViewById(d.g.card_divider_tv);
        this.emA = findViewById(d.g.bottom_line);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        al.l(this, d.C0277d.cp_bg_line_d);
        al.l(this.emz, d.C0277d.cp_bg_line_c);
        al.j(this.mTitle, d.C0277d.cp_cont_d);
        al.l(this.emA, this.emD);
    }

    public void setTitleText(String str) {
        this.mTitle.setText(str);
    }

    public void setTitleTextSize(int i, float f) {
        this.mTitle.setTextSize(i, f);
    }

    private void setDividerColor(int i) {
        this.emD = i;
        al.l(this.emA, this.emD);
    }

    public View getBotttomLine() {
        return this.emA;
    }
}
