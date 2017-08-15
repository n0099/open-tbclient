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
    private static final int bLm = d.e.cp_bg_line_c;
    private static final int bLn = d.e.cp_bg_line_c;
    private View bLk;
    private View bLl;
    private int bLo;
    private TextView mTitle;

    public void setTitleClickListener(View.OnClickListener onClickListener) {
        if (this.mTitle != null) {
            this.mTitle.setOnClickListener(onClickListener);
        }
    }

    public CardGroupDividerView(Context context) {
        super(context);
        this.bLo = bLn;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bLo = bLn;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bLo = bLn;
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(d.j.card_divider_view, (ViewGroup) this, true);
        this.bLk = findViewById(d.h.card_divider_top_margin);
        this.mTitle = (TextView) findViewById(d.h.card_divider_tv);
        this.bLl = findViewById(d.h.bottom_line);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        ai.k(this, d.e.cp_bg_line_d);
        ai.k(this.bLk, d.e.cp_bg_line_c);
        ai.i(this.mTitle, d.e.cp_cont_d);
        ai.k(this.bLl, this.bLo);
    }

    public void setTitleText(String str) {
        this.mTitle.setText(str);
    }

    public void d(int i, float f) {
        this.mTitle.setTextSize(i, f);
    }

    public void Xv() {
        if (this.bLk.getVisibility() != 8) {
            this.bLk.setVisibility(8);
        }
    }

    public void Xw() {
        if (this.bLk.getVisibility() != 0) {
            this.bLk.setVisibility(0);
        }
    }

    public void Xx() {
        Xv();
        if (this.mTitle.getVisibility() != 8) {
            this.mTitle.setVisibility(8);
        }
        if (this.bLl.getVisibility() != 0) {
            this.bLl.setVisibility(0);
            setDividerColor(bLn);
        }
    }

    public void A(String str, boolean z) {
        if (z) {
            Xw();
        } else {
            Xv();
        }
        if (TextUtils.isEmpty(str)) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setText(str);
        }
        if (this.bLl.getVisibility() != 0) {
            this.bLl.setVisibility(0);
            setDividerColor(bLm);
        }
    }

    private void setDividerColor(int i) {
        this.bLo = i;
        ai.k(this.bLl, this.bLo);
    }

    public View getBotttomLine() {
        return this.bLl;
    }
}
