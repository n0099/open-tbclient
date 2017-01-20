package com.baidu.tieba.card.divider;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class CardGroupDividerView extends LinearLayout {
    private static final int bpo = r.e.cp_bg_line_c;
    private static final int bpp = r.e.cp_bg_line_c;
    private TextView aNb;
    private View bkF;
    private View bpn;
    private int bpq;

    public void setTitleClickListener(View.OnClickListener onClickListener) {
        if (this.aNb != null) {
            this.aNb.setOnClickListener(onClickListener);
        }
    }

    public CardGroupDividerView(Context context) {
        super(context);
        this.bpq = bpp;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bpq = bpp;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bpq = bpp;
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(r.j.card_divider_view, (ViewGroup) this, true);
        this.bkF = findViewById(r.h.card_divider_top_margin);
        this.aNb = (TextView) findViewById(r.h.card_divider_tv);
        this.bpn = findViewById(r.h.bottom_line);
        tg();
    }

    public void tg() {
        ap.k(this, r.e.cp_bg_line_d);
        ap.k(this.bkF, r.e.cp_bg_line_c);
        ap.i((View) this.aNb, r.e.cp_cont_d);
        ap.k(this.bpn, this.bpq);
    }

    public void setTitleText(String str) {
        this.aNb.setText(str);
    }

    public void d(int i, float f) {
        this.aNb.setTextSize(i, f);
    }

    public void Sa() {
        if (this.bkF.getVisibility() != 8) {
            this.bkF.setVisibility(8);
        }
    }

    public void Sb() {
        if (this.bkF.getVisibility() != 0) {
            this.bkF.setVisibility(0);
        }
    }

    public void Sc() {
        Sa();
        if (this.aNb.getVisibility() != 8) {
            this.aNb.setVisibility(8);
        }
        if (this.bpn.getVisibility() != 0) {
            this.bpn.setVisibility(0);
            setDividerColor(bpp);
        }
    }

    public void A(String str, boolean z) {
        if (z) {
            Sb();
        } else {
            Sa();
        }
        if (TextUtils.isEmpty(str)) {
            this.aNb.setVisibility(8);
        } else {
            this.aNb.setVisibility(0);
            this.aNb.setText(str);
        }
        if (this.bpn.getVisibility() != 0) {
            this.bpn.setVisibility(0);
            setDividerColor(bpo);
        }
    }

    private void setDividerColor(int i) {
        this.bpq = i;
        ap.k(this.bpn, this.bpq);
    }
}
