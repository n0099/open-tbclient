package com.baidu.tieba.card.divider;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class CardGroupDividerView extends LinearLayout {
    private static final int cSs = e.d.cp_bg_line_c;
    private static final int cSt = e.d.cp_bg_line_c;
    private View cSq;
    private View cSr;
    private int cSu;
    private TextView mTitle;

    public void setTitleClickListener(View.OnClickListener onClickListener) {
        if (this.mTitle != null) {
            this.mTitle.setOnClickListener(onClickListener);
        }
    }

    public CardGroupDividerView(Context context) {
        super(context);
        this.cSu = cSt;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cSu = cSt;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cSu = cSt;
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(e.h.card_divider_view, (ViewGroup) this, true);
        this.cSq = findViewById(e.g.card_divider_top_margin);
        this.mTitle = (TextView) findViewById(e.g.card_divider_tv);
        this.cSr = findViewById(e.g.bottom_line);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        al.j(this, e.d.cp_bg_line_d);
        al.j(this.cSq, e.d.cp_bg_line_c);
        al.h(this.mTitle, e.d.cp_cont_d);
        al.j(this.cSr, this.cSu);
    }

    public void setTitleText(String str) {
        this.mTitle.setText(str);
    }

    public void setTitleTextSize(int i, float f) {
        this.mTitle.setTextSize(i, f);
    }

    private void setDividerColor(int i) {
        this.cSu = i;
        al.j(this.cSr, this.cSu);
    }

    public View getBotttomLine() {
        return this.cSr;
    }
}
