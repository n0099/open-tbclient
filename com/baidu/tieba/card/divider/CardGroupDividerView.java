package com.baidu.tieba.card.divider;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class CardGroupDividerView extends LinearLayout {
    private static final int bFh = w.e.cp_bg_line_c;
    private static final int bFi = w.e.cp_bg_line_c;
    private View bFf;
    private View bFg;
    private int bFj;
    private TextView mTitle;

    public void setTitleClickListener(View.OnClickListener onClickListener) {
        if (this.mTitle != null) {
            this.mTitle.setOnClickListener(onClickListener);
        }
    }

    public CardGroupDividerView(Context context) {
        super(context);
        this.bFj = bFi;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bFj = bFi;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bFj = bFi;
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(w.j.card_divider_view, (ViewGroup) this, true);
        this.bFf = findViewById(w.h.card_divider_top_margin);
        this.mTitle = (TextView) findViewById(w.h.card_divider_tv);
        this.bFg = findViewById(w.h.bottom_line);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        as.k(this, w.e.cp_bg_line_d);
        as.k(this.bFf, w.e.cp_bg_line_c);
        as.i(this.mTitle, w.e.cp_cont_d);
        as.k(this.bFg, this.bFj);
    }

    public void setTitleText(String str) {
        this.mTitle.setText(str);
    }

    public void d(int i, float f) {
        this.mTitle.setTextSize(i, f);
    }

    public void Wm() {
        if (this.bFf.getVisibility() != 8) {
            this.bFf.setVisibility(8);
        }
    }

    public void Wn() {
        if (this.bFf.getVisibility() != 0) {
            this.bFf.setVisibility(0);
        }
    }

    public void Wo() {
        Wm();
        if (this.mTitle.getVisibility() != 8) {
            this.mTitle.setVisibility(8);
        }
        if (this.bFg.getVisibility() != 0) {
            this.bFg.setVisibility(0);
            setDividerColor(bFi);
        }
    }

    public void A(String str, boolean z) {
        if (z) {
            Wn();
        } else {
            Wm();
        }
        if (TextUtils.isEmpty(str)) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setText(str);
        }
        if (this.bFg.getVisibility() != 0) {
            this.bFg.setVisibility(0);
            setDividerColor(bFh);
        }
    }

    private void setDividerColor(int i) {
        this.bFj = i;
        as.k(this.bFg, this.bFj);
    }

    public View getBotttomLine() {
        return this.bFg;
    }
}
