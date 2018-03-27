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
    private static final int dbd = d.C0141d.cp_bg_line_c;
    private static final int dbe = d.C0141d.cp_bg_line_c;
    private View dbb;
    private View dbc;
    private int dbf;
    private TextView mTitle;

    public void setTitleClickListener(View.OnClickListener onClickListener) {
        if (this.mTitle != null) {
            this.mTitle.setOnClickListener(onClickListener);
        }
    }

    public CardGroupDividerView(Context context) {
        super(context);
        this.dbf = dbe;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dbf = dbe;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dbf = dbe;
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(d.h.card_divider_view, (ViewGroup) this, true);
        this.dbb = findViewById(d.g.card_divider_top_margin);
        this.mTitle = (TextView) findViewById(d.g.card_divider_tv);
        this.dbc = findViewById(d.g.bottom_line);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        aj.t(this, d.C0141d.cp_bg_line_d);
        aj.t(this.dbb, d.C0141d.cp_bg_line_c);
        aj.r(this.mTitle, d.C0141d.cp_cont_d);
        aj.t(this.dbc, this.dbf);
    }

    public void setTitleText(String str) {
        this.mTitle.setText(str);
    }

    public void alV() {
        if (this.dbb.getVisibility() != 8) {
            this.dbb.setVisibility(8);
        }
    }

    public void alW() {
        if (this.dbb.getVisibility() != 0) {
            this.dbb.setVisibility(0);
        }
    }

    public void alX() {
        alV();
        if (this.mTitle.getVisibility() != 8) {
            this.mTitle.setVisibility(8);
        }
        if (this.dbc.getVisibility() != 0) {
            this.dbc.setVisibility(0);
            setDividerColor(dbe);
        }
    }

    public void w(String str, boolean z) {
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
        if (this.dbc.getVisibility() != 0) {
            this.dbc.setVisibility(0);
            setDividerColor(dbd);
        }
    }

    private void setDividerColor(int i) {
        this.dbf = i;
        aj.t(this.dbc, this.dbf);
    }

    public View getBotttomLine() {
        return this.dbc;
    }
}
