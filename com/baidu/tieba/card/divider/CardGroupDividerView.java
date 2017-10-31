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
    private static final int bVW = d.C0080d.cp_bg_line_c;
    private static final int bVX = d.C0080d.cp_bg_line_c;
    private View bVU;
    private View bVV;
    private int bVY;
    private TextView mTitle;

    public void setTitleClickListener(View.OnClickListener onClickListener) {
        if (this.mTitle != null) {
            this.mTitle.setOnClickListener(onClickListener);
        }
    }

    public CardGroupDividerView(Context context) {
        super(context);
        this.bVY = bVX;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bVY = bVX;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bVY = bVX;
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(d.h.card_divider_view, (ViewGroup) this, true);
        this.bVU = findViewById(d.g.card_divider_top_margin);
        this.mTitle = (TextView) findViewById(d.g.card_divider_tv);
        this.bVV = findViewById(d.g.bottom_line);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        aj.k(this, d.C0080d.cp_bg_line_d);
        aj.k(this.bVU, d.C0080d.cp_bg_line_c);
        aj.i(this.mTitle, d.C0080d.cp_cont_d);
        aj.k(this.bVV, this.bVY);
    }

    public void setTitleText(String str) {
        this.mTitle.setText(str);
    }

    public void d(int i, float f) {
        this.mTitle.setTextSize(i, f);
    }

    public void aau() {
        if (this.bVU.getVisibility() != 8) {
            this.bVU.setVisibility(8);
        }
    }

    public void aav() {
        if (this.bVU.getVisibility() != 0) {
            this.bVU.setVisibility(0);
        }
    }

    public void aaw() {
        aau();
        if (this.mTitle.getVisibility() != 8) {
            this.mTitle.setVisibility(8);
        }
        if (this.bVV.getVisibility() != 0) {
            this.bVV.setVisibility(0);
            setDividerColor(bVX);
        }
    }

    public void w(String str, boolean z) {
        if (z) {
            aav();
        } else {
            aau();
        }
        if (TextUtils.isEmpty(str)) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setText(str);
        }
        if (this.bVV.getVisibility() != 0) {
            this.bVV.setVisibility(0);
            setDividerColor(bVW);
        }
    }

    private void setDividerColor(int i) {
        this.bVY = i;
        aj.k(this.bVV, this.bVY);
    }

    public View getBotttomLine() {
        return this.bVV;
    }
}
