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
    private int cRh;
    private ImageOverlayView gQJ;
    private String gRn;
    private List<String> gRo;
    private int gRp;
    private int gRq;
    private int gRr;
    private TextView gRs;
    private ImageView gRt;

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
        bLQ();
        bLR();
        bLS();
    }

    public void setData(String str, List<String> list) {
        if (!v.isEmpty(list)) {
            this.gRo = list;
            int size = this.gRo.size();
            int i = size <= 3 ? size : 3;
            this.gQJ.k(i, this.cRh, this.cRh, this.gRp, this.gRq, this.gRr);
            this.gQJ.setData(this.gRo);
            if (i == 1 && !TextUtils.isEmpty(str)) {
                this.gRn = aq.Y(str, 10);
                this.gRs.setText(this.gRn);
                this.gRs.setVisibility(0);
                return;
            }
            this.gRs.setVisibility(8);
        }
    }

    public void onChangeSkinType() {
        if (this.gQJ != null) {
            this.gQJ.onChangeSkinType();
        }
        am.setViewTextColor(this.gRs, (int) R.color.cp_cont_j);
        am.setImageResource(this.gRt, R.drawable.icon_common_arrow20_right_n);
    }

    private void bLQ() {
        this.gRp = l.getDimens(getContext(), R.dimen.tbds5);
        this.gRq = R.color.cp_bg_line_d;
        this.cRh = l.getDimens(getContext(), R.dimen.tbds62);
        this.gRr = l.getDimens(getContext(), R.dimen.tbds14);
        this.gQJ = new ImageOverlayView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelOffset(R.dimen.tbds11);
        this.gQJ.setLayoutParams(layoutParams);
        addView(this.gQJ);
    }

    private void bLR() {
        this.gRs = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelOffset(R.dimen.tbds13);
        this.gRs.setLayoutParams(layoutParams);
        this.gRs.setSingleLine();
        this.gRs.setTextSize(0, getResources().getDimension(R.dimen.tbds36));
        this.gRs.setVisibility(8);
        addView(this.gRs);
    }

    private void bLS() {
        this.gRt = new ImageView(getContext());
        this.gRt.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(this.gRt);
    }
}
