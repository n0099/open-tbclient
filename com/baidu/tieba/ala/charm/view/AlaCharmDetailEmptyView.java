package com.baidu.tieba.ala.charm.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
/* loaded from: classes10.dex */
public class AlaCharmDetailEmptyView extends LinearLayout {
    private ImageView gRa;
    private TextView gRb;
    private TextView gRc;

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
        LayoutInflater.from(getContext()).inflate(a.g.ala_charm_empty_view, this);
        this.gRa = (ImageView) findViewById(a.f.empty_image);
        this.gRb = (TextView) findViewById(a.f.empty_text);
        this.gRc = (TextView) findViewById(a.f.empty_sub_text);
        if (getResources().getConfiguration().orientation == 2) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gRa.getLayoutParams();
            layoutParams.topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds20);
            this.gRa.setLayoutParams(layoutParams);
        }
    }

    public void setParams(int i, int i2, int i3) {
        if (i != -1) {
            this.gRa.setImageResource(i);
        } else {
            this.gRa.setVisibility(8);
        }
        if (i2 != -1) {
            this.gRb.setText(i2);
        } else {
            this.gRb.setVisibility(8);
        }
        if (i3 != -1) {
            this.gRc.setText(i3);
        } else {
            this.gRc.setVisibility(8);
        }
    }
}
