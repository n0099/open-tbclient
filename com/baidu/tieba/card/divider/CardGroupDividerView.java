package com.baidu.tieba.card.divider;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class CardGroupDividerView extends LinearLayout {
    private static final int cYZ = e.d.cp_bg_line_c;
    private static final int cZa = e.d.cp_bg_line_c;
    private View cYX;
    private View cYY;
    private int cZb;
    private TextView mTitle;

    public void setTitleClickListener(View.OnClickListener onClickListener) {
        if (this.mTitle != null) {
            this.mTitle.setOnClickListener(onClickListener);
        }
    }

    public CardGroupDividerView(Context context) {
        super(context);
        this.cZb = cZa;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cZb = cZa;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cZb = cZa;
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(e.h.card_divider_view, (ViewGroup) this, true);
        this.cYX = findViewById(e.g.card_divider_top_margin);
        this.mTitle = (TextView) findViewById(e.g.card_divider_tv);
        this.cYY = findViewById(e.g.bottom_line);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        al.j(this, e.d.cp_bg_line_d);
        al.j(this.cYX, e.d.cp_bg_line_c);
        al.h(this.mTitle, e.d.cp_cont_d);
        al.j(this.cYY, this.cZb);
    }

    public void setTitleText(String str) {
        this.mTitle.setText(str);
    }

    public void setTitleTextSize(int i, float f) {
        this.mTitle.setTextSize(i, f);
    }

    private void setDividerColor(int i) {
        this.cZb = i;
        al.j(this.cYY, this.cZb);
    }

    public View getBotttomLine() {
        return this.cYY;
    }
}
