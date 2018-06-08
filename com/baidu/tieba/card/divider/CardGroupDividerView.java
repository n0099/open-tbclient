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
/* loaded from: classes2.dex */
public class CardGroupDividerView extends LinearLayout {
    private static final int cCG = d.C0141d.cp_bg_line_c;
    private static final int cCH = d.C0141d.cp_bg_line_c;
    private View cCE;
    private View cCF;
    private int cCI;
    private TextView mTitle;

    public void setTitleClickListener(View.OnClickListener onClickListener) {
        if (this.mTitle != null) {
            this.mTitle.setOnClickListener(onClickListener);
        }
    }

    public CardGroupDividerView(Context context) {
        super(context);
        this.cCI = cCH;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cCI = cCH;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cCI = cCH;
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(d.i.card_divider_view, (ViewGroup) this, true);
        this.cCE = findViewById(d.g.card_divider_top_margin);
        this.mTitle = (TextView) findViewById(d.g.card_divider_tv);
        this.cCF = findViewById(d.g.bottom_line);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        al.j(this, d.C0141d.cp_bg_line_d);
        al.j(this.cCE, d.C0141d.cp_bg_line_c);
        al.h(this.mTitle, d.C0141d.cp_cont_d);
        al.j(this.cCF, this.cCI);
    }

    public void setTitleText(String str) {
        this.mTitle.setText(str);
    }

    public void setTitleTextSize(int i, float f) {
        this.mTitle.setTextSize(i, f);
    }

    private void setDividerColor(int i) {
        this.cCI = i;
        al.j(this.cCF, this.cCI);
    }

    public View getBotttomLine() {
        return this.cCF;
    }
}
