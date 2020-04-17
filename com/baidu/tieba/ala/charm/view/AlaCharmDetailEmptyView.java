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
    private ImageView fbU;
    private TextView fbV;
    private TextView fbW;

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
        this.fbU = (ImageView) findViewById(a.g.empty_image);
        this.fbV = (TextView) findViewById(a.g.empty_text);
        this.fbW = (TextView) findViewById(a.g.empty_sub_text);
        if (getResources().getConfiguration().orientation == 2) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fbU.getLayoutParams();
            layoutParams.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds20);
            this.fbU.setLayoutParams(layoutParams);
        }
    }

    public void setParams(int i, int i2, int i3) {
        if (i != -1) {
            this.fbU.setImageResource(i);
        } else {
            this.fbU.setVisibility(8);
        }
        if (i2 != -1) {
            this.fbV.setText(i2);
        } else {
            this.fbV.setVisibility(8);
        }
        if (i3 != -1) {
            this.fbW.setText(i3);
        } else {
            this.fbW.setVisibility(8);
        }
    }
}
