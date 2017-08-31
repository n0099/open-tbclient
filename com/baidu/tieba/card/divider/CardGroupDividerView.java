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
    private static final int bOg = d.e.cp_bg_line_c;
    private static final int bOh = d.e.cp_bg_line_c;
    private View bOe;
    private View bOf;
    private int bOi;
    private TextView mTitle;

    public void setTitleClickListener(View.OnClickListener onClickListener) {
        if (this.mTitle != null) {
            this.mTitle.setOnClickListener(onClickListener);
        }
    }

    public CardGroupDividerView(Context context) {
        super(context);
        this.bOi = bOh;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bOi = bOh;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bOi = bOh;
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(d.j.card_divider_view, (ViewGroup) this, true);
        this.bOe = findViewById(d.h.card_divider_top_margin);
        this.mTitle = (TextView) findViewById(d.h.card_divider_tv);
        this.bOf = findViewById(d.h.bottom_line);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        aj.k(this, d.e.cp_bg_line_d);
        aj.k(this.bOe, d.e.cp_bg_line_c);
        aj.i(this.mTitle, d.e.cp_cont_d);
        aj.k(this.bOf, this.bOi);
    }

    public void setTitleText(String str) {
        this.mTitle.setText(str);
    }

    public void c(int i, float f) {
        this.mTitle.setTextSize(i, f);
    }

    public void Yv() {
        if (this.bOe.getVisibility() != 8) {
            this.bOe.setVisibility(8);
        }
    }

    public void Yw() {
        if (this.bOe.getVisibility() != 0) {
            this.bOe.setVisibility(0);
        }
    }

    public void Yx() {
        Yv();
        if (this.mTitle.getVisibility() != 8) {
            this.mTitle.setVisibility(8);
        }
        if (this.bOf.getVisibility() != 0) {
            this.bOf.setVisibility(0);
            setDividerColor(bOh);
        }
    }

    public void B(String str, boolean z) {
        if (z) {
            Yw();
        } else {
            Yv();
        }
        if (TextUtils.isEmpty(str)) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setText(str);
        }
        if (this.bOf.getVisibility() != 0) {
            this.bOf.setVisibility(0);
            setDividerColor(bOg);
        }
    }

    private void setDividerColor(int i) {
        this.bOi = i;
        aj.k(this.bOf, this.bOi);
    }

    public View getBotttomLine() {
        return this.bOf;
    }
}
