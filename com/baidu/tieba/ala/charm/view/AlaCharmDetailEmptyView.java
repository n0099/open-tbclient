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
    private ImageView fUO;
    private TextView fUP;
    private TextView fUQ;

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
        this.fUO = (ImageView) findViewById(a.g.empty_image);
        this.fUP = (TextView) findViewById(a.g.empty_text);
        this.fUQ = (TextView) findViewById(a.g.empty_sub_text);
        if (getResources().getConfiguration().orientation == 2) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fUO.getLayoutParams();
            layoutParams.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds20);
            this.fUO.setLayoutParams(layoutParams);
        }
    }

    public void setParams(int i, int i2, int i3) {
        if (i != -1) {
            this.fUO.setImageResource(i);
        } else {
            this.fUO.setVisibility(8);
        }
        if (i2 != -1) {
            this.fUP.setText(i2);
        } else {
            this.fUP.setVisibility(8);
        }
        if (i3 != -1) {
            this.fUQ.setText(i3);
        } else {
            this.fUQ.setVisibility(8);
        }
    }
}
