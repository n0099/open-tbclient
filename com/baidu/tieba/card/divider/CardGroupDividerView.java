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
    private static final int bwc = w.e.cp_bg_line_c;
    private static final int bwd = w.e.cp_bg_line_c;
    private View brp;
    private View bwb;
    private int bwe;
    private TextView mTitle;

    public void setTitleClickListener(View.OnClickListener onClickListener) {
        if (this.mTitle != null) {
            this.mTitle.setOnClickListener(onClickListener);
        }
    }

    public CardGroupDividerView(Context context) {
        super(context);
        this.bwe = bwd;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bwe = bwd;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bwe = bwd;
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(w.j.card_divider_view, (ViewGroup) this, true);
        this.brp = findViewById(w.h.card_divider_top_margin);
        this.mTitle = (TextView) findViewById(w.h.card_divider_tv);
        this.bwb = findViewById(w.h.bottom_line);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        aq.k(this, w.e.cp_bg_line_d);
        aq.k(this.brp, w.e.cp_bg_line_c);
        aq.i(this.mTitle, w.e.cp_cont_d);
        aq.k(this.bwb, this.bwe);
    }

    public void setTitleText(String str) {
        this.mTitle.setText(str);
    }

    public void d(int i, float f) {
        this.mTitle.setTextSize(i, f);
    }

    public void Tw() {
        if (this.brp.getVisibility() != 8) {
            this.brp.setVisibility(8);
        }
    }

    public void Tx() {
        if (this.brp.getVisibility() != 0) {
            this.brp.setVisibility(0);
        }
    }

    public void Ty() {
        Tw();
        if (this.mTitle.getVisibility() != 8) {
            this.mTitle.setVisibility(8);
        }
        if (this.bwb.getVisibility() != 0) {
            this.bwb.setVisibility(0);
            setDividerColor(bwd);
        }
    }

    public void B(String str, boolean z) {
        if (z) {
            Tx();
        } else {
            Tw();
        }
        if (TextUtils.isEmpty(str)) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setText(str);
        }
        if (this.bwb.getVisibility() != 0) {
            this.bwb.setVisibility(0);
            setDividerColor(bwc);
        }
    }

    private void setDividerColor(int i) {
        this.bwe = i;
        aq.k(this.bwb, this.bwe);
    }
}
