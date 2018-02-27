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
    private static final int dba = d.C0141d.cp_bg_line_c;
    private static final int dbb = d.C0141d.cp_bg_line_c;
    private View daY;
    private View daZ;
    private int dbc;
    private TextView mTitle;

    public void setTitleClickListener(View.OnClickListener onClickListener) {
        if (this.mTitle != null) {
            this.mTitle.setOnClickListener(onClickListener);
        }
    }

    public CardGroupDividerView(Context context) {
        super(context);
        this.dbc = dbb;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dbc = dbb;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dbc = dbb;
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(d.h.card_divider_view, (ViewGroup) this, true);
        this.daY = findViewById(d.g.card_divider_top_margin);
        this.mTitle = (TextView) findViewById(d.g.card_divider_tv);
        this.daZ = findViewById(d.g.bottom_line);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        aj.t(this, d.C0141d.cp_bg_line_d);
        aj.t(this.daY, d.C0141d.cp_bg_line_c);
        aj.r(this.mTitle, d.C0141d.cp_cont_d);
        aj.t(this.daZ, this.dbc);
    }

    public void setTitleText(String str) {
        this.mTitle.setText(str);
    }

    public void alU() {
        if (this.daY.getVisibility() != 8) {
            this.daY.setVisibility(8);
        }
    }

    public void alV() {
        if (this.daY.getVisibility() != 0) {
            this.daY.setVisibility(0);
        }
    }

    public void alW() {
        alU();
        if (this.mTitle.getVisibility() != 8) {
            this.mTitle.setVisibility(8);
        }
        if (this.daZ.getVisibility() != 0) {
            this.daZ.setVisibility(0);
            setDividerColor(dbb);
        }
    }

    public void w(String str, boolean z) {
        if (z) {
            alV();
        } else {
            alU();
        }
        if (TextUtils.isEmpty(str)) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setText(str);
        }
        if (this.daZ.getVisibility() != 0) {
            this.daZ.setVisibility(0);
            setDividerColor(dba);
        }
    }

    private void setDividerColor(int i) {
        this.dbc = i;
        aj.t(this.daZ, this.dbc);
    }

    public View getBotttomLine() {
        return this.daZ;
    }
}
