package com.baidu.tieba.card.divider;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class CardGroupDividerView extends LinearLayout {
    private static final int bJt = d.e.cp_bg_line_c;
    private static final int bJu = d.e.cp_bg_line_c;
    private View bJr;
    private View bJs;
    private int bJv;
    private TextView mTitle;

    public void setTitleClickListener(View.OnClickListener onClickListener) {
        if (this.mTitle != null) {
            this.mTitle.setOnClickListener(onClickListener);
        }
    }

    public CardGroupDividerView(Context context) {
        super(context);
        this.bJv = bJu;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bJv = bJu;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bJv = bJu;
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(d.j.card_divider_view, (ViewGroup) this, true);
        this.bJr = findViewById(d.h.card_divider_top_margin);
        this.mTitle = (TextView) findViewById(d.h.card_divider_tv);
        this.bJs = findViewById(d.h.bottom_line);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        ai.k(this, d.e.cp_bg_line_d);
        ai.k(this.bJr, d.e.cp_bg_line_c);
        ai.i(this.mTitle, d.e.cp_cont_d);
        ai.k(this.bJs, this.bJv);
    }

    public void setTitleText(String str) {
        this.mTitle.setText(str);
    }

    public void d(int i, float f) {
        this.mTitle.setTextSize(i, f);
    }

    public void WU() {
        if (this.bJr.getVisibility() != 8) {
            this.bJr.setVisibility(8);
        }
    }

    public void WV() {
        if (this.bJr.getVisibility() != 0) {
            this.bJr.setVisibility(0);
        }
    }

    public void WW() {
        WU();
        if (this.mTitle.getVisibility() != 8) {
            this.mTitle.setVisibility(8);
        }
        if (this.bJs.getVisibility() != 0) {
            this.bJs.setVisibility(0);
            setDividerColor(bJu);
        }
    }

    public void A(String str, boolean z) {
        if (z) {
            WV();
        } else {
            WU();
        }
        if (TextUtils.isEmpty(str)) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setText(str);
        }
        if (this.bJs.getVisibility() != 0) {
            this.bJs.setVisibility(0);
            setDividerColor(bJt);
        }
    }

    private void setDividerColor(int i) {
        this.bJv = i;
        ai.k(this.bJs, this.bJv);
    }

    public View getBotttomLine() {
        return this.bJs;
    }
}
