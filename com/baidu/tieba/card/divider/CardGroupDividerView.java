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
    private int cYB;
    private View cYx;
    private View cYy;
    private TextView mTitle;
    private static final int cYz = d.C0108d.cp_bg_line_c;
    private static final int cYA = d.C0108d.cp_bg_line_c;

    public void setTitleClickListener(View.OnClickListener onClickListener) {
        if (this.mTitle != null) {
            this.mTitle.setOnClickListener(onClickListener);
        }
    }

    public CardGroupDividerView(Context context) {
        super(context);
        this.cYB = cYA;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cYB = cYA;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cYB = cYA;
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(d.h.card_divider_view, (ViewGroup) this, true);
        this.cYx = findViewById(d.g.card_divider_top_margin);
        this.mTitle = (TextView) findViewById(d.g.card_divider_tv);
        this.cYy = findViewById(d.g.bottom_line);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        aj.t(this, d.C0108d.cp_bg_line_d);
        aj.t(this.cYx, d.C0108d.cp_bg_line_c);
        aj.r(this.mTitle, d.C0108d.cp_cont_d);
        aj.t(this.cYy, this.cYB);
    }

    public void setTitleText(String str) {
        this.mTitle.setText(str);
    }

    public void i(int i, float f) {
        this.mTitle.setTextSize(i, f);
    }

    public void alm() {
        if (this.cYx.getVisibility() != 8) {
            this.cYx.setVisibility(8);
        }
    }

    public void aln() {
        if (this.cYx.getVisibility() != 0) {
            this.cYx.setVisibility(0);
        }
    }

    public void alo() {
        alm();
        if (this.mTitle.getVisibility() != 8) {
            this.mTitle.setVisibility(8);
        }
        if (this.cYy.getVisibility() != 0) {
            this.cYy.setVisibility(0);
            setDividerColor(cYA);
        }
    }

    public void z(String str, boolean z) {
        if (z) {
            aln();
        } else {
            alm();
        }
        if (TextUtils.isEmpty(str)) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setText(str);
        }
        if (this.cYy.getVisibility() != 0) {
            this.cYy.setVisibility(0);
            setDividerColor(cYz);
        }
    }

    private void setDividerColor(int i) {
        this.cYB = i;
        aj.t(this.cYy, this.cYB);
    }

    public View getBotttomLine() {
        return this.cYy;
    }
}
