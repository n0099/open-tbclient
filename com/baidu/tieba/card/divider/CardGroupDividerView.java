package com.baidu.tieba.card.divider;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class CardGroupDividerView extends LinearLayout {
    private static final int csS = d.C0126d.cp_bg_line_c;
    private static final int csT = d.C0126d.cp_bg_line_c;
    private View csQ;
    private View csR;
    private int csU;
    private TextView mTitle;

    public void setTitleClickListener(View.OnClickListener onClickListener) {
        if (this.mTitle != null) {
            this.mTitle.setOnClickListener(onClickListener);
        }
    }

    public CardGroupDividerView(Context context) {
        super(context);
        this.csU = csT;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.csU = csT;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.csU = csT;
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(d.i.card_divider_view, (ViewGroup) this, true);
        this.csQ = findViewById(d.g.card_divider_top_margin);
        this.mTitle = (TextView) findViewById(d.g.card_divider_tv);
        this.csR = findViewById(d.g.bottom_line);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        ak.j(this, d.C0126d.cp_bg_line_d);
        ak.j(this.csQ, d.C0126d.cp_bg_line_c);
        ak.h(this.mTitle, d.C0126d.cp_cont_d);
        ak.j(this.csR, this.csU);
    }

    public void setTitleText(String str) {
        this.mTitle.setText(str);
    }

    public void setTitleTextSize(int i, float f) {
        this.mTitle.setTextSize(i, f);
    }

    private void setDividerColor(int i) {
        this.csU = i;
        ak.j(this.csR, this.csU);
    }

    public View getBotttomLine() {
        return this.csR;
    }
}
