package com.baidu.tieba.ala.tasklist.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.k.a;
/* loaded from: classes6.dex */
public class AlaTaskListEmptyView extends LinearLayout {
    private ImageView dGv;
    private TextView dGw;
    private TextView dGx;

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
        this.dGv = (ImageView) findViewById(a.g.empty_image);
        this.dGw = (TextView) findViewById(a.g.empty_text);
        this.dGx = (TextView) findViewById(a.g.empty_sub_text);
    }

    public void setParams(int i, int i2, int i3) {
        if (i != -1) {
            this.dGv.setImageResource(i);
        } else {
            this.dGv.setVisibility(8);
        }
        if (i2 != -1) {
            this.dGw.setText(i2);
        } else {
            this.dGw.setVisibility(8);
        }
        if (i3 != -1) {
            this.dGx.setText(i3);
        } else {
            this.dGx.setVisibility(8);
        }
    }
}
