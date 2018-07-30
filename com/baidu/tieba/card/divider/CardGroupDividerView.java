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
    private static final int cDf = d.C0140d.cp_bg_line_c;
    private static final int cDg = d.C0140d.cp_bg_line_c;
    private View cDd;
    private View cDe;
    private int cDh;
    private TextView mTitle;

    public void setTitleClickListener(View.OnClickListener onClickListener) {
        if (this.mTitle != null) {
            this.mTitle.setOnClickListener(onClickListener);
        }
    }

    public CardGroupDividerView(Context context) {
        super(context);
        this.cDh = cDg;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cDh = cDg;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cDh = cDg;
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(d.h.card_divider_view, (ViewGroup) this, true);
        this.cDd = findViewById(d.g.card_divider_top_margin);
        this.mTitle = (TextView) findViewById(d.g.card_divider_tv);
        this.cDe = findViewById(d.g.bottom_line);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        am.j(this, d.C0140d.cp_bg_line_d);
        am.j(this.cDd, d.C0140d.cp_bg_line_c);
        am.h(this.mTitle, d.C0140d.cp_cont_d);
        am.j(this.cDe, this.cDh);
    }

    public void setTitleText(String str) {
        this.mTitle.setText(str);
    }

    public void setTitleTextSize(int i, float f) {
        this.mTitle.setTextSize(i, f);
    }

    private void setDividerColor(int i) {
        this.cDh = i;
        am.j(this.cDe, this.cDh);
    }

    public View getBotttomLine() {
        return this.cDe;
    }
}
