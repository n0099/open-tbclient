package com.baidu.tieba.card.divider;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class CardGroupDividerView extends LinearLayout {
    private static final int bfv = r.d.cp_bg_line_c;
    private static final int bfw = r.d.cp_bg_line_c;
    private TextView aNY;
    private View baR;
    private View bfu;
    private int bfx;

    public void setTitleClickListener(View.OnClickListener onClickListener) {
        if (this.aNY != null) {
            this.aNY.setOnClickListener(onClickListener);
        }
    }

    public CardGroupDividerView(Context context) {
        super(context);
        this.bfx = bfw;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bfx = bfw;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bfx = bfw;
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(r.h.card_divider_view, (ViewGroup) this, true);
        this.baR = findViewById(r.g.card_divider_top_margin);
        this.aNY = (TextView) findViewById(r.g.card_divider_tv);
        this.bfu = findViewById(r.g.bottom_line);
        tm();
    }

    public void tm() {
        ar.l(this, r.d.cp_bg_line_d);
        ar.l(this.baR, r.d.cp_bg_line_c);
        ar.j((View) this.aNY, r.d.cp_cont_d);
        ar.l(this.bfu, this.bfx);
    }

    public void setTitleText(String str) {
        this.aNY.setText(str);
    }

    public void c(int i, float f) {
        this.aNY.setTextSize(i, f);
    }

    public void Pl() {
        if (this.baR.getVisibility() != 8) {
            this.baR.setVisibility(8);
        }
    }

    public void Pm() {
        if (this.baR.getVisibility() != 0) {
            this.baR.setVisibility(0);
        }
    }

    public void Pn() {
        Pl();
        if (this.aNY.getVisibility() != 8) {
            this.aNY.setVisibility(8);
        }
        if (this.bfu.getVisibility() != 0) {
            this.bfu.setVisibility(0);
            setDividerColor(bfw);
        }
    }

    public void y(String str, boolean z) {
        if (z) {
            Pm();
        } else {
            Pl();
        }
        if (TextUtils.isEmpty(str)) {
            this.aNY.setVisibility(8);
        } else {
            this.aNY.setVisibility(0);
            this.aNY.setText(str);
        }
        if (this.bfu.getVisibility() != 0) {
            this.bfu.setVisibility(0);
            setDividerColor(bfv);
        }
    }

    private void setDividerColor(int i) {
        this.bfx = i;
        ar.l(this.bfu, this.bfx);
    }
}
