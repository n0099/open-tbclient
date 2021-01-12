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
/* loaded from: classes.dex */
public class CardGroupDividerView extends LinearLayout {
    private static final int iwf = R.color.CAM_X0204;
    private static final int iwg = R.color.CAM_X0204;
    private View iwd;
    private View iwe;
    private int iwh;
    private TextView mTitle;

    public void setTitleClickListener(View.OnClickListener onClickListener) {
        if (this.mTitle != null) {
            this.mTitle.setOnClickListener(onClickListener);
        }
    }

    public CardGroupDividerView(Context context) {
        super(context);
        this.iwh = iwg;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iwh = iwg;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iwh = iwg;
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.card_divider_view, (ViewGroup) this, true);
        this.iwd = findViewById(R.id.card_divider_top_margin);
        this.mTitle = (TextView) findViewById(R.id.card_divider_tv);
        this.iwe = findViewById(R.id.bottom_line);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        ao.setBackgroundColor(this, R.color.CAM_X0201);
        ao.setBackgroundColor(this.iwd, R.color.CAM_X0204);
        ao.setViewTextColor(this.mTitle, R.color.CAM_X0109);
        ao.setBackgroundColor(this.iwe, this.iwh);
    }

    public void setTitleText(String str) {
        this.mTitle.setText(str);
    }

    public void setTitleTextSize(int i, float f) {
        this.mTitle.setTextSize(i, f);
    }

    private void setDividerColor(int i) {
        this.iwh = i;
        ao.setBackgroundColor(this.iwe, this.iwh);
    }

    public View getBotttomLine() {
        return this.iwe;
    }
}
