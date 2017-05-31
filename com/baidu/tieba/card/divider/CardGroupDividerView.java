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
    private static final int bEp = w.e.cp_bg_line_c;
    private static final int bEq = w.e.cp_bg_line_c;
    private View bEn;
    private View bEo;
    private int bEr;
    private TextView mTitle;

    public void setTitleClickListener(View.OnClickListener onClickListener) {
        if (this.mTitle != null) {
            this.mTitle.setOnClickListener(onClickListener);
        }
    }

    public CardGroupDividerView(Context context) {
        super(context);
        this.bEr = bEq;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bEr = bEq;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bEr = bEq;
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(w.j.card_divider_view, (ViewGroup) this, true);
        this.bEn = findViewById(w.h.card_divider_top_margin);
        this.mTitle = (TextView) findViewById(w.h.card_divider_tv);
        this.bEo = findViewById(w.h.bottom_line);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        aq.k(this, w.e.cp_bg_line_d);
        aq.k(this.bEn, w.e.cp_bg_line_c);
        aq.i(this.mTitle, w.e.cp_cont_d);
        aq.k(this.bEo, this.bEr);
    }

    public void setTitleText(String str) {
        this.mTitle.setText(str);
    }

    public void d(int i, float f) {
        this.mTitle.setTextSize(i, f);
    }

    public void UV() {
        if (this.bEn.getVisibility() != 8) {
            this.bEn.setVisibility(8);
        }
    }

    public void UW() {
        if (this.bEn.getVisibility() != 0) {
            this.bEn.setVisibility(0);
        }
    }

    public void UX() {
        UV();
        if (this.mTitle.getVisibility() != 8) {
            this.mTitle.setVisibility(8);
        }
        if (this.bEo.getVisibility() != 0) {
            this.bEo.setVisibility(0);
            setDividerColor(bEq);
        }
    }

    public void y(String str, boolean z) {
        if (z) {
            UW();
        } else {
            UV();
        }
        if (TextUtils.isEmpty(str)) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setText(str);
        }
        if (this.bEo.getVisibility() != 0) {
            this.bEo.setVisibility(0);
            setDividerColor(bEp);
        }
    }

    private void setDividerColor(int i) {
        this.bEr = i;
        aq.k(this.bEo, this.bEr);
    }

    public View getBotttomLine() {
        return this.bEo;
    }
}
