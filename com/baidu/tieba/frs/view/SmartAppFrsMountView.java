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
/* loaded from: classes7.dex */
public class SmartAppFrsMountView extends LinearLayout {
    private int cNc;
    private String gOZ;
    private ImageOverlayView gOv;
    private List<String> gPa;
    private int gPb;
    private int gPc;
    private int gPd;
    private TextView gPe;
    private ImageView gPf;

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
        bKl();
        bKm();
        bKn();
    }

    public void setData(String str, List<String> list) {
        if (!v.isEmpty(list)) {
            this.gPa = list;
            int size = this.gPa.size();
            int i = size <= 3 ? size : 3;
            this.gOv.k(i, this.cNc, this.cNc, this.gPb, this.gPc, this.gPd);
            this.gOv.setData(this.gPa);
            if (i == 1 && !TextUtils.isEmpty(str)) {
                this.gOZ = aq.aa(str, 10);
                this.gPe.setText(this.gOZ);
                this.gPe.setVisibility(0);
                return;
            }
            this.gPe.setVisibility(8);
        }
    }

    public void onChangeSkinType() {
        if (this.gOv != null) {
            this.gOv.onChangeSkinType();
        }
        am.setViewTextColor(this.gPe, (int) R.color.cp_cont_j);
        am.setImageResource(this.gPf, R.drawable.icon_common_arrow20_right_n);
    }

    private void bKl() {
        this.gPb = l.getDimens(getContext(), R.dimen.tbds5);
        this.gPc = R.color.cp_bg_line_d;
        this.cNc = l.getDimens(getContext(), R.dimen.tbds62);
        this.gPd = l.getDimens(getContext(), R.dimen.tbds14);
        this.gOv = new ImageOverlayView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelOffset(R.dimen.tbds11);
        this.gOv.setLayoutParams(layoutParams);
        addView(this.gOv);
    }

    private void bKm() {
        this.gPe = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelOffset(R.dimen.tbds13);
        this.gPe.setLayoutParams(layoutParams);
        this.gPe.setSingleLine();
        this.gPe.setTextSize(0, getResources().getDimension(R.dimen.tbds36));
        this.gPe.setVisibility(8);
        addView(this.gPe);
    }

    private void bKn() {
        this.gPf = new ImageView(getContext());
        this.gPf.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(this.gPf);
    }
}
