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
    private static final int cTC = d.C0108d.cp_bg_line_c;
    private static final int cTD = d.C0108d.cp_bg_line_c;
    private View cTA;
    private View cTB;
    private int cTE;
    private TextView mTitle;

    public void setTitleClickListener(View.OnClickListener onClickListener) {
        if (this.mTitle != null) {
            this.mTitle.setOnClickListener(onClickListener);
        }
    }

    public CardGroupDividerView(Context context) {
        super(context);
        this.cTE = cTD;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cTE = cTD;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cTE = cTD;
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(d.h.card_divider_view, (ViewGroup) this, true);
        this.cTA = findViewById(d.g.card_divider_top_margin);
        this.mTitle = (TextView) findViewById(d.g.card_divider_tv);
        this.cTB = findViewById(d.g.bottom_line);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        aj.t(this, d.C0108d.cp_bg_line_d);
        aj.t(this.cTA, d.C0108d.cp_bg_line_c);
        aj.r(this.mTitle, d.C0108d.cp_cont_d);
        aj.t(this.cTB, this.cTE);
    }

    public void setTitleText(String str) {
        this.mTitle.setText(str);
    }

    public void i(int i, float f) {
        this.mTitle.setTextSize(i, f);
    }

    public void ake() {
        if (this.cTA.getVisibility() != 8) {
            this.cTA.setVisibility(8);
        }
    }

    public void akf() {
        if (this.cTA.getVisibility() != 0) {
            this.cTA.setVisibility(0);
        }
    }

    public void akg() {
        ake();
        if (this.mTitle.getVisibility() != 8) {
            this.mTitle.setVisibility(8);
        }
        if (this.cTB.getVisibility() != 0) {
            this.cTB.setVisibility(0);
            setDividerColor(cTD);
        }
    }

    public void z(String str, boolean z) {
        if (z) {
            akf();
        } else {
            ake();
        }
        if (TextUtils.isEmpty(str)) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setText(str);
        }
        if (this.cTB.getVisibility() != 0) {
            this.cTB.setVisibility(0);
            setDividerColor(cTC);
        }
    }

    private void setDividerColor(int i) {
        this.cTE = i;
        aj.t(this.cTB, this.cTE);
    }

    public View getBotttomLine() {
        return this.cTB;
    }
}
