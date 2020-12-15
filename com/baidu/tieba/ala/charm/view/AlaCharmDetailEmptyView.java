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
    private ImageView gFs;
    private TextView gFt;
    private TextView gFu;

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
        this.gFs = (ImageView) findViewById(a.f.empty_image);
        this.gFt = (TextView) findViewById(a.f.empty_text);
        this.gFu = (TextView) findViewById(a.f.empty_sub_text);
        if (getResources().getConfiguration().orientation == 2) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gFs.getLayoutParams();
            layoutParams.topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds20);
            this.gFs.setLayoutParams(layoutParams);
        }
    }

    public void setParams(int i, int i2, int i3) {
        if (i != -1) {
            this.gFs.setImageResource(i);
        } else {
            this.gFs.setVisibility(8);
        }
        if (i2 != -1) {
            this.gFt.setText(i2);
        } else {
            this.gFt.setVisibility(8);
        }
        if (i3 != -1) {
            this.gFu.setText(i3);
        } else {
            this.gFu.setVisibility(8);
        }
    }
}
