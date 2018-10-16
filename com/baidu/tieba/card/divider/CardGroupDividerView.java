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
    private static final int cRm = e.d.cp_bg_line_c;
    private static final int cRn = e.d.cp_bg_line_c;
    private View cRk;
    private View cRl;
    private int cRo;
    private TextView mTitle;

    public void setTitleClickListener(View.OnClickListener onClickListener) {
        if (this.mTitle != null) {
            this.mTitle.setOnClickListener(onClickListener);
        }
    }

    public CardGroupDividerView(Context context) {
        super(context);
        this.cRo = cRn;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cRo = cRn;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cRo = cRn;
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(e.h.card_divider_view, (ViewGroup) this, true);
        this.cRk = findViewById(e.g.card_divider_top_margin);
        this.mTitle = (TextView) findViewById(e.g.card_divider_tv);
        this.cRl = findViewById(e.g.bottom_line);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        al.j(this, e.d.cp_bg_line_d);
        al.j(this.cRk, e.d.cp_bg_line_c);
        al.h(this.mTitle, e.d.cp_cont_d);
        al.j(this.cRl, this.cRo);
    }

    public void setTitleText(String str) {
        this.mTitle.setText(str);
    }

    public void setTitleTextSize(int i, float f) {
        this.mTitle.setTextSize(i, f);
    }

    private void setDividerColor(int i) {
        this.cRo = i;
        al.j(this.cRl, this.cRo);
    }

    public View getBotttomLine() {
        return this.cRl;
    }
}
