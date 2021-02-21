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
/* loaded from: classes.dex */
public class CardGroupDividerView extends LinearLayout {
    private static final int iCd = R.color.CAM_X0204;
    private static final int iCe = R.color.CAM_X0204;
    private View iCb;
    private View iCc;
    private int iCf;
    private TextView mTitle;

    public void setTitleClickListener(View.OnClickListener onClickListener) {
        if (this.mTitle != null) {
            this.mTitle.setOnClickListener(onClickListener);
        }
    }

    public CardGroupDividerView(Context context) {
        super(context);
        this.iCf = iCe;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iCf = iCe;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iCf = iCe;
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.card_divider_view, (ViewGroup) this, true);
        this.iCb = findViewById(R.id.card_divider_top_margin);
        this.mTitle = (TextView) findViewById(R.id.card_divider_tv);
        this.iCc = findViewById(R.id.bottom_line);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this, R.color.CAM_X0201);
        ap.setBackgroundColor(this.iCb, R.color.CAM_X0204);
        ap.setViewTextColor(this.mTitle, R.color.CAM_X0109);
        ap.setBackgroundColor(this.iCc, this.iCf);
    }

    public void setTitleText(String str) {
        this.mTitle.setText(str);
    }

    public void setTitleTextSize(int i, float f) {
        this.mTitle.setTextSize(i, f);
    }

    private void setDividerColor(int i) {
        this.iCf = i;
        ap.setBackgroundColor(this.iCc, this.iCf);
    }

    public View getBotttomLine() {
        return this.iCc;
    }
}
