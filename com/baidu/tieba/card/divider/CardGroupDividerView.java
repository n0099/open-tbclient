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
    private static final int dcE = e.d.cp_bg_line_c;
    private static final int dcF = e.d.cp_bg_line_c;
    private View dcC;
    private View dcD;
    private int dcG;
    private TextView mTitle;

    public void setTitleClickListener(View.OnClickListener onClickListener) {
        if (this.mTitle != null) {
            this.mTitle.setOnClickListener(onClickListener);
        }
    }

    public CardGroupDividerView(Context context) {
        super(context);
        this.dcG = dcF;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dcG = dcF;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dcG = dcF;
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(e.h.card_divider_view, (ViewGroup) this, true);
        this.dcC = findViewById(e.g.card_divider_top_margin);
        this.mTitle = (TextView) findViewById(e.g.card_divider_tv);
        this.dcD = findViewById(e.g.bottom_line);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        al.j(this, e.d.cp_bg_line_d);
        al.j(this.dcC, e.d.cp_bg_line_c);
        al.h(this.mTitle, e.d.cp_cont_d);
        al.j(this.dcD, this.dcG);
    }

    public void setTitleText(String str) {
        this.mTitle.setText(str);
    }

    public void setTitleTextSize(int i, float f) {
        this.mTitle.setTextSize(i, f);
    }

    private void setDividerColor(int i) {
        this.dcG = i;
        al.j(this.dcD, this.dcG);
    }

    public View getBotttomLine() {
        return this.dcD;
    }
}
