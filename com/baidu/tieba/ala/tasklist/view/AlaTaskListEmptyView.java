package com.baidu.tieba.ala.tasklist.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class AlaTaskListEmptyView extends LinearLayout {
    private ImageView exq;
    private TextView exr;
    private TextView exs;

    public AlaTaskListEmptyView(Context context) {
        super(context);
        init();
    }

    public AlaTaskListEmptyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public AlaTaskListEmptyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(a.h.ala_task_empty_view, this);
        this.exq = (ImageView) findViewById(a.g.empty_image);
        this.exr = (TextView) findViewById(a.g.empty_text);
        this.exs = (TextView) findViewById(a.g.empty_sub_text);
    }

    public void setParams(int i, int i2, int i3) {
        if (i != -1) {
            this.exq.setImageResource(i);
        } else {
            this.exq.setVisibility(8);
        }
        if (i2 != -1) {
            this.exr.setText(i2);
        } else {
            this.exr.setVisibility(8);
        }
        if (i3 != -1) {
            this.exs.setText(i3);
        } else {
            this.exs.setVisibility(8);
        }
    }
}
