package com.baidu.tieba.card.divider;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class CardGroupDividerView extends LinearLayout {
    private static final int byu = w.e.cp_bg_line_c;
    private static final int byv = w.e.cp_bg_line_c;
    private View bys;
    private View byt;
    private int byw;
    private TextView mTitle;

    public void setTitleClickListener(View.OnClickListener onClickListener) {
        if (this.mTitle != null) {
            this.mTitle.setOnClickListener(onClickListener);
        }
    }

    public CardGroupDividerView(Context context) {
        super(context);
        this.byw = byv;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.byw = byv;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.byw = byv;
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(w.j.card_divider_view, (ViewGroup) this, true);
        this.bys = findViewById(w.h.card_divider_top_margin);
        this.mTitle = (TextView) findViewById(w.h.card_divider_tv);
        this.byt = findViewById(w.h.bottom_line);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        aq.k(this, w.e.cp_bg_line_d);
        aq.k(this.bys, w.e.cp_bg_line_c);
        aq.i(this.mTitle, w.e.cp_cont_d);
        aq.k(this.byt, this.byw);
    }

    public void setTitleText(String str) {
        this.mTitle.setText(str);
    }

    public void d(int i, float f) {
        this.mTitle.setTextSize(i, f);
    }

    public void TR() {
        if (this.bys.getVisibility() != 8) {
            this.bys.setVisibility(8);
        }
    }

    public void TS() {
        if (this.bys.getVisibility() != 0) {
            this.bys.setVisibility(0);
        }
    }

    public void TT() {
        TR();
        if (this.mTitle.getVisibility() != 8) {
            this.mTitle.setVisibility(8);
        }
        if (this.byt.getVisibility() != 0) {
            this.byt.setVisibility(0);
            setDividerColor(byv);
        }
    }

    public void B(String str, boolean z) {
        if (z) {
            TS();
        } else {
            TR();
        }
        if (TextUtils.isEmpty(str)) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setText(str);
        }
        if (this.byt.getVisibility() != 0) {
            this.byt.setVisibility(0);
            setDividerColor(byu);
        }
    }

    private void setDividerColor(int i) {
        this.byw = i;
        aq.k(this.byt, this.byw);
    }

    public View getBotttomLine() {
        return this.byt;
    }
}
