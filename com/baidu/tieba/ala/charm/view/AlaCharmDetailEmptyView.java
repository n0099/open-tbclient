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
    private TextView fRA;
    private TextView fRB;
    private ImageView fRz;

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
        this.fRz = (ImageView) findViewById(a.g.empty_image);
        this.fRA = (TextView) findViewById(a.g.empty_text);
        this.fRB = (TextView) findViewById(a.g.empty_sub_text);
        if (getResources().getConfiguration().orientation == 2) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fRz.getLayoutParams();
            layoutParams.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds20);
            this.fRz.setLayoutParams(layoutParams);
        }
    }

    public void setParams(int i, int i2, int i3) {
        if (i != -1) {
            this.fRz.setImageResource(i);
        } else {
            this.fRz.setVisibility(8);
        }
        if (i2 != -1) {
            this.fRA.setText(i2);
        } else {
            this.fRA.setVisibility(8);
        }
        if (i3 != -1) {
            this.fRB.setText(i3);
        } else {
            this.fRB.setVisibility(8);
        }
    }
}
