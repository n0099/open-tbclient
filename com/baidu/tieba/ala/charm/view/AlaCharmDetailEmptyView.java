package com.baidu.tieba.ala.charm.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.k.a;
/* loaded from: classes6.dex */
public class AlaCharmDetailEmptyView extends LinearLayout {
    private ImageView dFE;
    private TextView dFF;
    private TextView dFG;

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
        this.dFE = (ImageView) findViewById(a.g.empty_image);
        this.dFF = (TextView) findViewById(a.g.empty_text);
        this.dFG = (TextView) findViewById(a.g.empty_sub_text);
        if (getResources().getConfiguration().orientation == 2) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dFE.getLayoutParams();
            layoutParams.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds20);
            this.dFE.setLayoutParams(layoutParams);
        }
    }

    public void setParams(int i, int i2, int i3) {
        if (i != -1) {
            this.dFE.setImageResource(i);
        } else {
            this.dFE.setVisibility(8);
        }
        if (i2 != -1) {
            this.dFF.setText(i2);
        } else {
            this.dFF.setVisibility(8);
        }
        if (i3 != -1) {
            this.dFG.setText(i3);
        } else {
            this.dFG.setVisibility(8);
        }
    }
}
