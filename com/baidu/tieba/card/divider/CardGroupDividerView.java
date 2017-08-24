package com.baidu.tieba.card.divider;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class CardGroupDividerView extends LinearLayout {
    private static final int bLn = d.e.cp_bg_line_c;
    private static final int bLo = d.e.cp_bg_line_c;
    private View bLl;
    private View bLm;
    private int bLp;
    private TextView mTitle;

    public void setTitleClickListener(View.OnClickListener onClickListener) {
        if (this.mTitle != null) {
            this.mTitle.setOnClickListener(onClickListener);
        }
    }

    public CardGroupDividerView(Context context) {
        super(context);
        this.bLp = bLo;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bLp = bLo;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bLp = bLo;
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(d.j.card_divider_view, (ViewGroup) this, true);
        this.bLl = findViewById(d.h.card_divider_top_margin);
        this.mTitle = (TextView) findViewById(d.h.card_divider_tv);
        this.bLm = findViewById(d.h.bottom_line);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        ai.k(this, d.e.cp_bg_line_d);
        ai.k(this.bLl, d.e.cp_bg_line_c);
        ai.i(this.mTitle, d.e.cp_cont_d);
        ai.k(this.bLm, this.bLp);
    }

    public void setTitleText(String str) {
        this.mTitle.setText(str);
    }

    public void c(int i, float f) {
        this.mTitle.setTextSize(i, f);
    }

    public void Xs() {
        if (this.bLl.getVisibility() != 8) {
            this.bLl.setVisibility(8);
        }
    }

    public void Xt() {
        if (this.bLl.getVisibility() != 0) {
            this.bLl.setVisibility(0);
        }
    }

    public void Xu() {
        Xs();
        if (this.mTitle.getVisibility() != 8) {
            this.mTitle.setVisibility(8);
        }
        if (this.bLm.getVisibility() != 0) {
            this.bLm.setVisibility(0);
            setDividerColor(bLo);
        }
    }

    public void A(String str, boolean z) {
        if (z) {
            Xt();
        } else {
            Xs();
        }
        if (TextUtils.isEmpty(str)) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setText(str);
        }
        if (this.bLm.getVisibility() != 0) {
            this.bLm.setVisibility(0);
            setDividerColor(bLn);
        }
    }

    private void setDividerColor(int i) {
        this.bLp = i;
        ai.k(this.bLm, this.bLp);
    }

    public View getBotttomLine() {
        return this.bLm;
    }
}
