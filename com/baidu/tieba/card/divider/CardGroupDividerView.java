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
    private static final int bOX = d.e.cp_bg_line_c;
    private static final int bOY = d.e.cp_bg_line_c;
    private View bOV;
    private View bOW;
    private int bOZ;
    private TextView mTitle;

    public void setTitleClickListener(View.OnClickListener onClickListener) {
        if (this.mTitle != null) {
            this.mTitle.setOnClickListener(onClickListener);
        }
    }

    public CardGroupDividerView(Context context) {
        super(context);
        this.bOZ = bOY;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bOZ = bOY;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bOZ = bOY;
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(d.j.card_divider_view, (ViewGroup) this, true);
        this.bOV = findViewById(d.h.card_divider_top_margin);
        this.mTitle = (TextView) findViewById(d.h.card_divider_tv);
        this.bOW = findViewById(d.h.bottom_line);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        aj.k(this, d.e.cp_bg_line_d);
        aj.k(this.bOV, d.e.cp_bg_line_c);
        aj.i(this.mTitle, d.e.cp_cont_d);
        aj.k(this.bOW, this.bOZ);
    }

    public void setTitleText(String str) {
        this.mTitle.setText(str);
    }

    public void c(int i, float f) {
        this.mTitle.setTextSize(i, f);
    }

    public void YG() {
        if (this.bOV.getVisibility() != 8) {
            this.bOV.setVisibility(8);
        }
    }

    public void YH() {
        if (this.bOV.getVisibility() != 0) {
            this.bOV.setVisibility(0);
        }
    }

    public void YI() {
        YG();
        if (this.mTitle.getVisibility() != 8) {
            this.mTitle.setVisibility(8);
        }
        if (this.bOW.getVisibility() != 0) {
            this.bOW.setVisibility(0);
            setDividerColor(bOY);
        }
    }

    public void B(String str, boolean z) {
        if (z) {
            YH();
        } else {
            YG();
        }
        if (TextUtils.isEmpty(str)) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setText(str);
        }
        if (this.bOW.getVisibility() != 0) {
            this.bOW.setVisibility(0);
            setDividerColor(bOX);
        }
    }

    private void setDividerColor(int i) {
        this.bOZ = i;
        aj.k(this.bOW, this.bOZ);
    }

    public View getBotttomLine() {
        return this.bOW;
    }
}
