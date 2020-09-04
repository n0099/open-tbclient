package com.baidu.tieba.ala.charm.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
/* loaded from: classes7.dex */
public class AlaCharmDetailEmptyView extends LinearLayout {
    private ImageView fRD;
    private TextView fRE;
    private TextView fRF;

    public AlaCharmDetailEmptyView(Context context) {
        super(context);
        init();
    }

    public AlaCharmDetailEmptyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public AlaCharmDetailEmptyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(a.h.ala_charm_empty_view, this);
        this.fRD = (ImageView) findViewById(a.g.empty_image);
        this.fRE = (TextView) findViewById(a.g.empty_text);
        this.fRF = (TextView) findViewById(a.g.empty_sub_text);
        if (getResources().getConfiguration().orientation == 2) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fRD.getLayoutParams();
            layoutParams.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds20);
            this.fRD.setLayoutParams(layoutParams);
        }
    }

    public void setParams(int i, int i2, int i3) {
        if (i != -1) {
            this.fRD.setImageResource(i);
        } else {
            this.fRD.setVisibility(8);
        }
        if (i2 != -1) {
            this.fRE.setText(i2);
        } else {
            this.fRE.setVisibility(8);
        }
        if (i3 != -1) {
            this.fRF.setText(i3);
        } else {
            this.fRF.setVisibility(8);
        }
    }
}
