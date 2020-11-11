package com.baidu.tieba.card.divider;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class CardGroupDividerView extends LinearLayout {
    private static final int icD = R.color.cp_bg_line_c;
    private static final int icE = R.color.cp_bg_line_c;
    private View icB;
    private View icC;
    private int icF;
    private TextView mTitle;

    public void setTitleClickListener(View.OnClickListener onClickListener) {
        if (this.mTitle != null) {
            this.mTitle.setOnClickListener(onClickListener);
        }
    }

    public CardGroupDividerView(Context context) {
        super(context);
        this.icF = icE;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.icF = icE;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.icF = icE;
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.card_divider_view, (ViewGroup) this, true);
        this.icB = findViewById(R.id.card_divider_top_margin);
        this.mTitle = (TextView) findViewById(R.id.card_divider_tv);
        this.icC = findViewById(R.id.bottom_line);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.icB, R.color.cp_bg_line_c);
        ap.setViewTextColor(this.mTitle, R.color.cp_cont_d);
        ap.setBackgroundColor(this.icC, this.icF);
    }

    public void setTitleText(String str) {
        this.mTitle.setText(str);
    }

    public void setTitleTextSize(int i, float f) {
        this.mTitle.setTextSize(i, f);
    }

    private void setDividerColor(int i) {
        this.icF = i;
        ap.setBackgroundColor(this.icC, this.icF);
    }

    public View getBotttomLine() {
        return this.icC;
    }
}
