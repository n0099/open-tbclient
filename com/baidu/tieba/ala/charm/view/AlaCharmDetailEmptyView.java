package com.baidu.tieba.ala.charm.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class AlaCharmDetailEmptyView extends LinearLayout {
    private ImageView gwF;
    private TextView gwG;
    private TextView gwH;

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
        this.gwF = (ImageView) findViewById(a.f.empty_image);
        this.gwG = (TextView) findViewById(a.f.empty_text);
        this.gwH = (TextView) findViewById(a.f.empty_sub_text);
        if (getResources().getConfiguration().orientation == 2) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gwF.getLayoutParams();
            layoutParams.topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds20);
            this.gwF.setLayoutParams(layoutParams);
        }
    }

    public void setParams(int i, int i2, int i3) {
        if (i != -1) {
            this.gwF.setImageResource(i);
        } else {
            this.gwF.setVisibility(8);
        }
        if (i2 != -1) {
            this.gwG.setText(i2);
        } else {
            this.gwG.setVisibility(8);
        }
        if (i3 != -1) {
            this.gwH.setText(i3);
        } else {
            this.gwH.setVisibility(8);
        }
    }
}
