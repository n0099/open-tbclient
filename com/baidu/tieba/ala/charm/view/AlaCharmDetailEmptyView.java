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
    private ImageView exc;
    private TextView exd;
    private TextView exe;

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
        this.exc = (ImageView) findViewById(a.g.empty_image);
        this.exd = (TextView) findViewById(a.g.empty_text);
        this.exe = (TextView) findViewById(a.g.empty_sub_text);
        if (getResources().getConfiguration().orientation == 2) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.exc.getLayoutParams();
            layoutParams.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds20);
            this.exc.setLayoutParams(layoutParams);
        }
    }

    public void setParams(int i, int i2, int i3) {
        if (i != -1) {
            this.exc.setImageResource(i);
        } else {
            this.exc.setVisibility(8);
        }
        if (i2 != -1) {
            this.exd.setText(i2);
        } else {
            this.exd.setVisibility(8);
        }
        if (i3 != -1) {
            this.exe.setText(i3);
        } else {
            this.exe.setVisibility(8);
        }
    }
}
