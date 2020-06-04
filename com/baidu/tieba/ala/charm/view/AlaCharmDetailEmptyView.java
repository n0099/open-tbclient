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
    private ImageView fpN;
    private TextView fpO;
    private TextView fpP;

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
        this.fpN = (ImageView) findViewById(a.g.empty_image);
        this.fpO = (TextView) findViewById(a.g.empty_text);
        this.fpP = (TextView) findViewById(a.g.empty_sub_text);
        if (getResources().getConfiguration().orientation == 2) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fpN.getLayoutParams();
            layoutParams.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds20);
            this.fpN.setLayoutParams(layoutParams);
        }
    }

    public void setParams(int i, int i2, int i3) {
        if (i != -1) {
            this.fpN.setImageResource(i);
        } else {
            this.fpN.setVisibility(8);
        }
        if (i2 != -1) {
            this.fpO.setText(i2);
        } else {
            this.fpO.setVisibility(8);
        }
        if (i3 != -1) {
            this.fpP.setText(i3);
        } else {
            this.fpP.setVisibility(8);
        }
    }
}
