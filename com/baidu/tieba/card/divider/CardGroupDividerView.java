package com.baidu.tieba.card.divider;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class CardGroupDividerView extends LinearLayout {
    private static final int cDc = f.d.cp_bg_line_c;
    private static final int cDd = f.d.cp_bg_line_c;
    private View cDa;
    private View cDb;
    private int cDe;
    private TextView mTitle;

    public void setTitleClickListener(View.OnClickListener onClickListener) {
        if (this.mTitle != null) {
            this.mTitle.setOnClickListener(onClickListener);
        }
    }

    public CardGroupDividerView(Context context) {
        super(context);
        this.cDe = cDd;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cDe = cDd;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cDe = cDd;
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(f.h.card_divider_view, (ViewGroup) this, true);
        this.cDa = findViewById(f.g.card_divider_top_margin);
        this.mTitle = (TextView) findViewById(f.g.card_divider_tv);
        this.cDb = findViewById(f.g.bottom_line);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        am.j(this, f.d.cp_bg_line_d);
        am.j(this.cDa, f.d.cp_bg_line_c);
        am.h(this.mTitle, f.d.cp_cont_d);
        am.j(this.cDb, this.cDe);
    }

    public void setTitleText(String str) {
        this.mTitle.setText(str);
    }

    public void setTitleTextSize(int i, float f) {
        this.mTitle.setTextSize(i, f);
    }

    private void setDividerColor(int i) {
        this.cDe = i;
        am.j(this.cDb, this.cDe);
    }

    public View getBotttomLine() {
        return this.cDb;
    }
}
