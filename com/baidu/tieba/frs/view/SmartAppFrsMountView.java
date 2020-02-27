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
    private int cRf;
    private String gQZ;
    private ImageOverlayView gQv;
    private List<String> gRa;
    private int gRb;
    private int gRc;
    private int gRd;
    private TextView gRe;
    private ImageView gRf;

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
        bLN();
        bLO();
        bLP();
    }

    public void setData(String str, List<String> list) {
        if (!v.isEmpty(list)) {
            this.gRa = list;
            int size = this.gRa.size();
            int i = size <= 3 ? size : 3;
            this.gQv.k(i, this.cRf, this.cRf, this.gRb, this.gRc, this.gRd);
            this.gQv.setData(this.gRa);
            if (i == 1 && !TextUtils.isEmpty(str)) {
                this.gQZ = aq.Y(str, 10);
                this.gRe.setText(this.gQZ);
                this.gRe.setVisibility(0);
                return;
            }
            this.gRe.setVisibility(8);
        }
    }

    public void onChangeSkinType() {
        if (this.gQv != null) {
            this.gQv.onChangeSkinType();
        }
        am.setViewTextColor(this.gRe, (int) R.color.cp_cont_j);
        am.setImageResource(this.gRf, R.drawable.icon_common_arrow20_right_n);
    }

    private void bLN() {
        this.gRb = l.getDimens(getContext(), R.dimen.tbds5);
        this.gRc = R.color.cp_bg_line_d;
        this.cRf = l.getDimens(getContext(), R.dimen.tbds62);
        this.gRd = l.getDimens(getContext(), R.dimen.tbds14);
        this.gQv = new ImageOverlayView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelOffset(R.dimen.tbds11);
        this.gQv.setLayoutParams(layoutParams);
        addView(this.gQv);
    }

    private void bLO() {
        this.gRe = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelOffset(R.dimen.tbds13);
        this.gRe.setLayoutParams(layoutParams);
        this.gRe.setSingleLine();
        this.gRe.setTextSize(0, getResources().getDimension(R.dimen.tbds36));
        this.gRe.setVisibility(8);
        addView(this.gRe);
    }

    private void bLP() {
        this.gRf = new ImageView(getContext());
        this.gRf.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(this.gRf);
    }
}
