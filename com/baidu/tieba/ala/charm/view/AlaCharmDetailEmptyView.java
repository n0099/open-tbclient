package com.baidu.tieba.ala.charm.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class AlaCharmDetailEmptyView extends LinearLayout {
    private ImageView fpC;
    private TextView fpD;
    private TextView fpE;

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
        this.fpC = (ImageView) findViewById(a.g.empty_image);
        this.fpD = (TextView) findViewById(a.g.empty_text);
        this.fpE = (TextView) findViewById(a.g.empty_sub_text);
        if (getResources().getConfiguration().orientation == 2) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fpC.getLayoutParams();
            layoutParams.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds20);
            this.fpC.setLayoutParams(layoutParams);
        }
    }

    public void setParams(int i, int i2, int i3) {
        if (i != -1) {
            this.fpC.setImageResource(i);
        } else {
            this.fpC.setVisibility(8);
        }
        if (i2 != -1) {
            this.fpD.setText(i2);
        } else {
            this.fpD.setVisibility(8);
        }
        if (i3 != -1) {
            this.fpE.setText(i3);
        } else {
            this.fpE.setVisibility(8);
        }
    }
}
