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
    private static final int bwj = w.e.cp_bg_line_c;
    private static final int bwk = w.e.cp_bg_line_c;
    private TextView aSO;
    private View brx;
    private View bwi;
    private int bwl;

    public void setTitleClickListener(View.OnClickListener onClickListener) {
        if (this.aSO != null) {
            this.aSO.setOnClickListener(onClickListener);
        }
    }

    public CardGroupDividerView(Context context) {
        super(context);
        this.bwl = bwk;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bwl = bwk;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bwl = bwk;
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(w.j.card_divider_view, (ViewGroup) this, true);
        this.brx = findViewById(w.h.card_divider_top_margin);
        this.aSO = (TextView) findViewById(w.h.card_divider_tv);
        this.bwi = findViewById(w.h.bottom_line);
        tD();
    }

    public void tD() {
        aq.k(this, w.e.cp_bg_line_d);
        aq.k(this.brx, w.e.cp_bg_line_c);
        aq.i((View) this.aSO, w.e.cp_cont_d);
        aq.k(this.bwi, this.bwl);
    }

    public void setTitleText(String str) {
        this.aSO.setText(str);
    }

    public void d(int i, float f) {
        this.aSO.setTextSize(i, f);
    }

    public void SY() {
        if (this.brx.getVisibility() != 8) {
            this.brx.setVisibility(8);
        }
    }

    public void SZ() {
        if (this.brx.getVisibility() != 0) {
            this.brx.setVisibility(0);
        }
    }

    public void Ta() {
        SY();
        if (this.aSO.getVisibility() != 8) {
            this.aSO.setVisibility(8);
        }
        if (this.bwi.getVisibility() != 0) {
            this.bwi.setVisibility(0);
            setDividerColor(bwk);
        }
    }

    public void B(String str, boolean z) {
        if (z) {
            SZ();
        } else {
            SY();
        }
        if (TextUtils.isEmpty(str)) {
            this.aSO.setVisibility(8);
        } else {
            this.aSO.setVisibility(0);
            this.aSO.setText(str);
        }
        if (this.bwi.getVisibility() != 0) {
            this.bwi.setVisibility(0);
            setDividerColor(bwj);
        }
    }

    private void setDividerColor(int i) {
        this.bwl = i;
        aq.k(this.bwi, this.bwl);
    }
}
