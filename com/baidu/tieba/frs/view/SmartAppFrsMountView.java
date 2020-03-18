package com.baidu.tieba.frs.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes9.dex */
public class SmartAppFrsMountView extends LinearLayout {
    private int cRu;
    private ImageOverlayView gRQ;
    private ImageView gSA;
    private String gSu;
    private List<String> gSv;
    private int gSw;
    private int gSx;
    private int gSy;
    private TextView gSz;

    public SmartAppFrsMountView(Context context) {
        super(context);
        init();
    }

    public SmartAppFrsMountView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public SmartAppFrsMountView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public void init() {
        bMe();
        bMf();
        bMg();
    }

    public void setData(String str, List<String> list) {
        if (!v.isEmpty(list)) {
            this.gSv = list;
            int size = this.gSv.size();
            int i = size <= 3 ? size : 3;
            this.gRQ.k(i, this.cRu, this.cRu, this.gSw, this.gSx, this.gSy);
            this.gRQ.setData(this.gSv);
            if (i == 1 && !TextUtils.isEmpty(str)) {
                this.gSu = aq.Y(str, 10);
                this.gSz.setText(this.gSu);
                this.gSz.setVisibility(0);
                return;
            }
            this.gSz.setVisibility(8);
        }
    }

    public void onChangeSkinType() {
        if (this.gRQ != null) {
            this.gRQ.onChangeSkinType();
        }
        am.setViewTextColor(this.gSz, (int) R.color.cp_cont_j);
        am.setImageResource(this.gSA, R.drawable.icon_common_arrow20_right_n);
    }

    private void bMe() {
        this.gSw = l.getDimens(getContext(), R.dimen.tbds5);
        this.gSx = R.color.cp_bg_line_d;
        this.cRu = l.getDimens(getContext(), R.dimen.tbds62);
        this.gSy = l.getDimens(getContext(), R.dimen.tbds14);
        this.gRQ = new ImageOverlayView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelOffset(R.dimen.tbds11);
        this.gRQ.setLayoutParams(layoutParams);
        addView(this.gRQ);
    }

    private void bMf() {
        this.gSz = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelOffset(R.dimen.tbds13);
        this.gSz.setLayoutParams(layoutParams);
        this.gSz.setSingleLine();
        this.gSz.setTextSize(0, getResources().getDimension(R.dimen.tbds36));
        this.gSz.setVisibility(8);
        addView(this.gSz);
    }

    private void bMg() {
        this.gSA = new ImageView(getContext());
        this.gSA.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(this.gSA);
    }
}
