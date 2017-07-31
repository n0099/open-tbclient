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
    private static final int bKD = d.e.cp_bg_line_c;
    private static final int bKE = d.e.cp_bg_line_c;
    private View bKB;
    private View bKC;
    private int bKF;
    private TextView mTitle;

    public void setTitleClickListener(View.OnClickListener onClickListener) {
        if (this.mTitle != null) {
            this.mTitle.setOnClickListener(onClickListener);
        }
    }

    public CardGroupDividerView(Context context) {
        super(context);
        this.bKF = bKE;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bKF = bKE;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bKF = bKE;
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(d.j.card_divider_view, (ViewGroup) this, true);
        this.bKB = findViewById(d.h.card_divider_top_margin);
        this.mTitle = (TextView) findViewById(d.h.card_divider_tv);
        this.bKC = findViewById(d.h.bottom_line);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        ai.k(this, d.e.cp_bg_line_d);
        ai.k(this.bKB, d.e.cp_bg_line_c);
        ai.i(this.mTitle, d.e.cp_cont_d);
        ai.k(this.bKC, this.bKF);
    }

    public void setTitleText(String str) {
        this.mTitle.setText(str);
    }

    public void d(int i, float f) {
        this.mTitle.setTextSize(i, f);
    }

    public void WZ() {
        if (this.bKB.getVisibility() != 8) {
            this.bKB.setVisibility(8);
        }
    }

    public void Xa() {
        if (this.bKB.getVisibility() != 0) {
            this.bKB.setVisibility(0);
        }
    }

    public void Xb() {
        WZ();
        if (this.mTitle.getVisibility() != 8) {
            this.mTitle.setVisibility(8);
        }
        if (this.bKC.getVisibility() != 0) {
            this.bKC.setVisibility(0);
            setDividerColor(bKE);
        }
    }

    public void A(String str, boolean z) {
        if (z) {
            Xa();
        } else {
            WZ();
        }
        if (TextUtils.isEmpty(str)) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setText(str);
        }
        if (this.bKC.getVisibility() != 0) {
            this.bKC.setVisibility(0);
            setDividerColor(bKD);
        }
    }

    private void setDividerColor(int i) {
        this.bKF = i;
        ai.k(this.bKC, this.bKF);
    }

    public View getBotttomLine() {
        return this.bKC;
    }
}
