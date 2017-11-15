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
    private static final int bWj = d.C0080d.cp_bg_line_c;
    private static final int bWk = d.C0080d.cp_bg_line_c;
    private View bWh;
    private View bWi;
    private int bWl;
    private TextView mTitle;

    public void setTitleClickListener(View.OnClickListener onClickListener) {
        if (this.mTitle != null) {
            this.mTitle.setOnClickListener(onClickListener);
        }
    }

    public CardGroupDividerView(Context context) {
        super(context);
        this.bWl = bWk;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bWl = bWk;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bWl = bWk;
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(d.h.card_divider_view, (ViewGroup) this, true);
        this.bWh = findViewById(d.g.card_divider_top_margin);
        this.mTitle = (TextView) findViewById(d.g.card_divider_tv);
        this.bWi = findViewById(d.g.bottom_line);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        aj.k(this, d.C0080d.cp_bg_line_d);
        aj.k(this.bWh, d.C0080d.cp_bg_line_c);
        aj.i(this.mTitle, d.C0080d.cp_cont_d);
        aj.k(this.bWi, this.bWl);
    }

    public void setTitleText(String str) {
        this.mTitle.setText(str);
    }

    public void d(int i, float f) {
        this.mTitle.setTextSize(i, f);
    }

    public void aaG() {
        if (this.bWh.getVisibility() != 8) {
            this.bWh.setVisibility(8);
        }
    }

    public void aaH() {
        if (this.bWh.getVisibility() != 0) {
            this.bWh.setVisibility(0);
        }
    }

    public void aaI() {
        aaG();
        if (this.mTitle.getVisibility() != 8) {
            this.mTitle.setVisibility(8);
        }
        if (this.bWi.getVisibility() != 0) {
            this.bWi.setVisibility(0);
            setDividerColor(bWk);
        }
    }

    public void w(String str, boolean z) {
        if (z) {
            aaH();
        } else {
            aaG();
        }
        if (TextUtils.isEmpty(str)) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setText(str);
        }
        if (this.bWi.getVisibility() != 0) {
            this.bWi.setVisibility(0);
            setDividerColor(bWj);
        }
    }

    private void setDividerColor(int i) {
        this.bWl = i;
        aj.k(this.bWi, this.bWl);
    }

    public View getBotttomLine() {
        return this.bWi;
    }
}
