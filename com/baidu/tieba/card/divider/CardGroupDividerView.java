package com.baidu.tieba.card.divider;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class CardGroupDividerView extends LinearLayout {
    private static final int bOr = d.e.cp_bg_line_c;
    private static final int bOs = d.e.cp_bg_line_c;
    private View bOp;
    private View bOq;
    private int bOt;
    private TextView mTitle;

    public void setTitleClickListener(View.OnClickListener onClickListener) {
        if (this.mTitle != null) {
            this.mTitle.setOnClickListener(onClickListener);
        }
    }

    public CardGroupDividerView(Context context) {
        super(context);
        this.bOt = bOs;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bOt = bOs;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bOt = bOs;
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(d.j.card_divider_view, (ViewGroup) this, true);
        this.bOp = findViewById(d.h.card_divider_top_margin);
        this.mTitle = (TextView) findViewById(d.h.card_divider_tv);
        this.bOq = findViewById(d.h.bottom_line);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        aj.k(this, d.e.cp_bg_line_d);
        aj.k(this.bOp, d.e.cp_bg_line_c);
        aj.i(this.mTitle, d.e.cp_cont_d);
        aj.k(this.bOq, this.bOt);
    }

    public void setTitleText(String str) {
        this.mTitle.setText(str);
    }

    public void c(int i, float f) {
        this.mTitle.setTextSize(i, f);
    }

    public void Yk() {
        if (this.bOp.getVisibility() != 8) {
            this.bOp.setVisibility(8);
        }
    }

    public void Yl() {
        if (this.bOp.getVisibility() != 0) {
            this.bOp.setVisibility(0);
        }
    }

    public void Ym() {
        Yk();
        if (this.mTitle.getVisibility() != 8) {
            this.mTitle.setVisibility(8);
        }
        if (this.bOq.getVisibility() != 0) {
            this.bOq.setVisibility(0);
            setDividerColor(bOs);
        }
    }

    public void y(String str, boolean z) {
        if (z) {
            Yl();
        } else {
            Yk();
        }
        if (TextUtils.isEmpty(str)) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setText(str);
        }
        if (this.bOq.getVisibility() != 0) {
            this.bOq.setVisibility(0);
            setDividerColor(bOr);
        }
    }

    private void setDividerColor(int i) {
        this.bOt = i;
        aj.k(this.bOq, this.bOt);
    }

    public View getBotttomLine() {
        return this.bOq;
    }
}
