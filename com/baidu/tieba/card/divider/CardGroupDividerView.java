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
    private static final int ios = R.color.CAM_X0204;
    private static final int iot = R.color.CAM_X0204;
    private View ioq;
    private View ior;
    private int iou;
    private TextView mTitle;

    public void setTitleClickListener(View.OnClickListener onClickListener) {
        if (this.mTitle != null) {
            this.mTitle.setOnClickListener(onClickListener);
        }
    }

    public CardGroupDividerView(Context context) {
        super(context);
        this.iou = iot;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iou = iot;
        init();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iou = iot;
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.card_divider_view, (ViewGroup) this, true);
        this.ioq = findViewById(R.id.card_divider_top_margin);
        this.mTitle = (TextView) findViewById(R.id.card_divider_tv);
        this.ior = findViewById(R.id.bottom_line);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this, R.color.CAM_X0201);
        ap.setBackgroundColor(this.ioq, R.color.CAM_X0204);
        ap.setViewTextColor(this.mTitle, R.color.CAM_X0109);
        ap.setBackgroundColor(this.ior, this.iou);
    }

    public void setTitleText(String str) {
        this.mTitle.setText(str);
    }

    public void setTitleTextSize(int i, float f) {
        this.mTitle.setTextSize(i, f);
    }

    private void setDividerColor(int i) {
        this.iou = i;
        ap.setBackgroundColor(this.ior, this.iou);
    }

    public View getBotttomLine() {
        return this.ior;
    }
}
