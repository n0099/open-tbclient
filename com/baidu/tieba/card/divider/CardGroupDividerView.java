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
    private static final int cYe = d.C0107d.cp_bg_line_c;
    private static final int cYf = d.C0107d.cp_bg_line_c;
    private View cYc;
    private View cYd;
    private int cYg;
    private TextView mTitle;

    public void setTitleClickListener(View.OnClickListener onClickListener) {
        if (this.mTitle != null) {
            this.mTitle.setOnClickListener(onClickListener);
        }
    }

    public CardGroupDividerView(Context context) {
        super(context);
        this.cYg = cYf;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cYg = cYf;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cYg = cYf;
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(d.h.card_divider_view, (ViewGroup) this, true);
        this.cYc = findViewById(d.g.card_divider_top_margin);
        this.mTitle = (TextView) findViewById(d.g.card_divider_tv);
        this.cYd = findViewById(d.g.bottom_line);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        aj.t(this, d.C0107d.cp_bg_line_d);
        aj.t(this.cYc, d.C0107d.cp_bg_line_c);
        aj.r(this.mTitle, d.C0107d.cp_cont_d);
        aj.t(this.cYd, this.cYg);
    }

    public void setTitleText(String str) {
        this.mTitle.setText(str);
    }

    public void i(int i, float f) {
        this.mTitle.setTextSize(i, f);
    }

    public void alh() {
        if (this.cYc.getVisibility() != 8) {
            this.cYc.setVisibility(8);
        }
    }

    public void ali() {
        if (this.cYc.getVisibility() != 0) {
            this.cYc.setVisibility(0);
        }
    }

    public void alj() {
        alh();
        if (this.mTitle.getVisibility() != 8) {
            this.mTitle.setVisibility(8);
        }
        if (this.cYd.getVisibility() != 0) {
            this.cYd.setVisibility(0);
            setDividerColor(cYf);
        }
    }

    public void z(String str, boolean z) {
        if (z) {
            ali();
        } else {
            alh();
        }
        if (TextUtils.isEmpty(str)) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setText(str);
        }
        if (this.cYd.getVisibility() != 0) {
            this.cYd.setVisibility(0);
            setDividerColor(cYe);
        }
    }

    private void setDividerColor(int i) {
        this.cYg = i;
        aj.t(this.cYd, this.cYg);
    }

    public View getBotttomLine() {
        return this.cYd;
    }
}
