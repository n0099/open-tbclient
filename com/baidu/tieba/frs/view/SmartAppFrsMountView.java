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
    private int cRg;
    private ImageOverlayView gQx;
    private String gRb;
    private List<String> gRc;
    private int gRd;
    private int gRe;
    private int gRf;
    private TextView gRg;
    private ImageView gRh;

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
        bLP();
        bLQ();
        bLR();
    }

    public void setData(String str, List<String> list) {
        if (!v.isEmpty(list)) {
            this.gRc = list;
            int size = this.gRc.size();
            int i = size <= 3 ? size : 3;
            this.gQx.k(i, this.cRg, this.cRg, this.gRd, this.gRe, this.gRf);
            this.gQx.setData(this.gRc);
            if (i == 1 && !TextUtils.isEmpty(str)) {
                this.gRb = aq.Y(str, 10);
                this.gRg.setText(this.gRb);
                this.gRg.setVisibility(0);
                return;
            }
            this.gRg.setVisibility(8);
        }
    }

    public void onChangeSkinType() {
        if (this.gQx != null) {
            this.gQx.onChangeSkinType();
        }
        am.setViewTextColor(this.gRg, (int) R.color.cp_cont_j);
        am.setImageResource(this.gRh, R.drawable.icon_common_arrow20_right_n);
    }

    private void bLP() {
        this.gRd = l.getDimens(getContext(), R.dimen.tbds5);
        this.gRe = R.color.cp_bg_line_d;
        this.cRg = l.getDimens(getContext(), R.dimen.tbds62);
        this.gRf = l.getDimens(getContext(), R.dimen.tbds14);
        this.gQx = new ImageOverlayView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelOffset(R.dimen.tbds11);
        this.gQx.setLayoutParams(layoutParams);
        addView(this.gQx);
    }

    private void bLQ() {
        this.gRg = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelOffset(R.dimen.tbds13);
        this.gRg.setLayoutParams(layoutParams);
        this.gRg.setSingleLine();
        this.gRg.setTextSize(0, getResources().getDimension(R.dimen.tbds36));
        this.gRg.setVisibility(8);
        addView(this.gRg);
    }

    private void bLR() {
        this.gRh = new ImageView(getContext());
        this.gRh.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(this.gRh);
    }
}
