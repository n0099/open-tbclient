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
    private static final int dbm = d.C0140d.cp_bg_line_c;
    private static final int dbn = d.C0140d.cp_bg_line_c;
    private View dbk;
    private View dbl;
    private int dbo;
    private TextView mTitle;

    public void setTitleClickListener(View.OnClickListener onClickListener) {
        if (this.mTitle != null) {
            this.mTitle.setOnClickListener(onClickListener);
        }
    }

    public CardGroupDividerView(Context context) {
        super(context);
        this.dbo = dbn;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dbo = dbn;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dbo = dbn;
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(d.h.card_divider_view, (ViewGroup) this, true);
        this.dbk = findViewById(d.g.card_divider_top_margin);
        this.mTitle = (TextView) findViewById(d.g.card_divider_tv);
        this.dbl = findViewById(d.g.bottom_line);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        aj.t(this, d.C0140d.cp_bg_line_d);
        aj.t(this.dbk, d.C0140d.cp_bg_line_c);
        aj.r(this.mTitle, d.C0140d.cp_cont_d);
        aj.t(this.dbl, this.dbo);
    }

    public void setTitleText(String str) {
        this.mTitle.setText(str);
    }

    public void alV() {
        if (this.dbk.getVisibility() != 8) {
            this.dbk.setVisibility(8);
        }
    }

    public void alW() {
        if (this.dbk.getVisibility() != 0) {
            this.dbk.setVisibility(0);
        }
    }

    public void alX() {
        alV();
        if (this.mTitle.getVisibility() != 8) {
            this.mTitle.setVisibility(8);
        }
        if (this.dbl.getVisibility() != 0) {
            this.dbl.setVisibility(0);
            setDividerColor(dbn);
        }
    }

    public void x(String str, boolean z) {
        if (z) {
            alW();
        } else {
            alV();
        }
        if (TextUtils.isEmpty(str)) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setText(str);
        }
        if (this.dbl.getVisibility() != 0) {
            this.dbl.setVisibility(0);
            setDividerColor(dbm);
        }
    }

    private void setDividerColor(int i) {
        this.dbo = i;
        aj.t(this.dbl, this.dbo);
    }

    public View getBotttomLine() {
        return this.dbl;
    }
}
