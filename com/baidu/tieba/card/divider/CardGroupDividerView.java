package com.baidu.tieba.card.divider;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class CardGroupDividerView extends LinearLayout {
    private static final int cAA = d.C0142d.cp_bg_line_c;
    private static final int cAB = d.C0142d.cp_bg_line_c;
    private int cAC;
    private View cAy;
    private View cAz;
    private TextView mTitle;

    public void setTitleClickListener(View.OnClickListener onClickListener) {
        if (this.mTitle != null) {
            this.mTitle.setOnClickListener(onClickListener);
        }
    }

    public CardGroupDividerView(Context context) {
        super(context);
        this.cAC = cAB;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cAC = cAB;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cAC = cAB;
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(d.i.card_divider_view, (ViewGroup) this, true);
        this.cAy = findViewById(d.g.card_divider_top_margin);
        this.mTitle = (TextView) findViewById(d.g.card_divider_tv);
        this.cAz = findViewById(d.g.bottom_line);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        am.j(this, d.C0142d.cp_bg_line_d);
        am.j(this.cAy, d.C0142d.cp_bg_line_c);
        am.h(this.mTitle, d.C0142d.cp_cont_d);
        am.j(this.cAz, this.cAC);
    }

    public void setTitleText(String str) {
        this.mTitle.setText(str);
    }

    public void setTitleTextSize(int i, float f) {
        this.mTitle.setTextSize(i, f);
    }

    private void setDividerColor(int i) {
        this.cAC = i;
        am.j(this.cAz, this.cAC);
    }

    public View getBotttomLine() {
        return this.cAz;
    }
}
