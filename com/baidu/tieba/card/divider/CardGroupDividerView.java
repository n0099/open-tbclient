package com.baidu.tieba.card.divider;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class CardGroupDividerView extends LinearLayout {
    private static final int cuc = d.C0126d.cp_bg_line_c;
    private static final int cud = d.C0126d.cp_bg_line_c;
    private View cua;
    private View cub;
    private int cue;
    private TextView mTitle;

    public void setTitleClickListener(View.OnClickListener onClickListener) {
        if (this.mTitle != null) {
            this.mTitle.setOnClickListener(onClickListener);
        }
    }

    public CardGroupDividerView(Context context) {
        super(context);
        this.cue = cud;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cue = cud;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cue = cud;
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(d.i.card_divider_view, (ViewGroup) this, true);
        this.cua = findViewById(d.g.card_divider_top_margin);
        this.mTitle = (TextView) findViewById(d.g.card_divider_tv);
        this.cub = findViewById(d.g.bottom_line);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        ak.j(this, d.C0126d.cp_bg_line_d);
        ak.j(this.cua, d.C0126d.cp_bg_line_c);
        ak.h(this.mTitle, d.C0126d.cp_cont_d);
        ak.j(this.cub, this.cue);
    }

    public void setTitleText(String str) {
        this.mTitle.setText(str);
    }

    public void setTitleTextSize(int i, float f) {
        this.mTitle.setTextSize(i, f);
    }

    private void setDividerColor(int i) {
        this.cue = i;
        ak.j(this.cub, this.cue);
    }

    public View getBotttomLine() {
        return this.cub;
    }
}
