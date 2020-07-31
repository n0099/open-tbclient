package com.baidu.tieba.card.divider;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class CardGroupDividerView extends LinearLayout {
    private static final int hbp = R.color.cp_bg_line_c;
    private static final int hbq = R.color.cp_bg_line_c;
    private View hbn;
    private View hbo;
    private int hbr;
    private TextView mTitle;

    public void setTitleClickListener(View.OnClickListener onClickListener) {
        if (this.mTitle != null) {
            this.mTitle.setOnClickListener(onClickListener);
        }
    }

    public CardGroupDividerView(Context context) {
        super(context);
        this.hbr = hbq;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hbr = hbq;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hbr = hbq;
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.card_divider_view, (ViewGroup) this, true);
        this.hbn = findViewById(R.id.card_divider_top_margin);
        this.mTitle = (TextView) findViewById(R.id.card_divider_tv);
        this.hbo = findViewById(R.id.bottom_line);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        ao.setBackgroundColor(this, R.color.cp_bg_line_d);
        ao.setBackgroundColor(this.hbn, R.color.cp_bg_line_c);
        ao.setViewTextColor(this.mTitle, R.color.cp_cont_d);
        ao.setBackgroundColor(this.hbo, this.hbr);
    }

    public void setTitleText(String str) {
        this.mTitle.setText(str);
    }

    public void setTitleTextSize(int i, float f) {
        this.mTitle.setTextSize(i, f);
    }

    private void setDividerColor(int i) {
        this.hbr = i;
        ao.setBackgroundColor(this.hbo, this.hbr);
    }

    public View getBotttomLine() {
        return this.hbo;
    }
}
