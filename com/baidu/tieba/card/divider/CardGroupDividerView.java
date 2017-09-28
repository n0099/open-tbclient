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
    private static final int bOD = d.e.cp_bg_line_c;
    private static final int bOE = d.e.cp_bg_line_c;
    private View bOB;
    private View bOC;
    private int bOF;
    private TextView mTitle;

    public void setTitleClickListener(View.OnClickListener onClickListener) {
        if (this.mTitle != null) {
            this.mTitle.setOnClickListener(onClickListener);
        }
    }

    public CardGroupDividerView(Context context) {
        super(context);
        this.bOF = bOE;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bOF = bOE;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bOF = bOE;
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(d.j.card_divider_view, (ViewGroup) this, true);
        this.bOB = findViewById(d.h.card_divider_top_margin);
        this.mTitle = (TextView) findViewById(d.h.card_divider_tv);
        this.bOC = findViewById(d.h.bottom_line);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        aj.k(this, d.e.cp_bg_line_d);
        aj.k(this.bOB, d.e.cp_bg_line_c);
        aj.i(this.mTitle, d.e.cp_cont_d);
        aj.k(this.bOC, this.bOF);
    }

    public void setTitleText(String str) {
        this.mTitle.setText(str);
    }

    public void c(int i, float f) {
        this.mTitle.setTextSize(i, f);
    }

    public void Yo() {
        if (this.bOB.getVisibility() != 8) {
            this.bOB.setVisibility(8);
        }
    }

    public void Yp() {
        if (this.bOB.getVisibility() != 0) {
            this.bOB.setVisibility(0);
        }
    }

    public void Yq() {
        Yo();
        if (this.mTitle.getVisibility() != 8) {
            this.mTitle.setVisibility(8);
        }
        if (this.bOC.getVisibility() != 0) {
            this.bOC.setVisibility(0);
            setDividerColor(bOE);
        }
    }

    public void y(String str, boolean z) {
        if (z) {
            Yp();
        } else {
            Yo();
        }
        if (TextUtils.isEmpty(str)) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setText(str);
        }
        if (this.bOC.getVisibility() != 0) {
            this.bOC.setVisibility(0);
            setDividerColor(bOD);
        }
    }

    private void setDividerColor(int i) {
        this.bOF = i;
        aj.k(this.bOC, this.bOF);
    }

    public View getBotttomLine() {
        return this.bOC;
    }
}
