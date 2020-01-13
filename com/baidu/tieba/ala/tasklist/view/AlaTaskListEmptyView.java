package com.baidu.tieba.ala.tasklist.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.r.a;
/* loaded from: classes2.dex */
public class AlaTaskListEmptyView extends LinearLayout {
    private ImageView esS;
    private TextView esT;
    private TextView esU;

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
        this.esS = (ImageView) findViewById(a.g.empty_image);
        this.esT = (TextView) findViewById(a.g.empty_text);
        this.esU = (TextView) findViewById(a.g.empty_sub_text);
    }

    public void setParams(int i, int i2, int i3) {
        if (i != -1) {
            this.esS.setImageResource(i);
        } else {
            this.esS.setVisibility(8);
        }
        if (i2 != -1) {
            this.esT.setText(i2);
        } else {
            this.esT.setVisibility(8);
        }
        if (i3 != -1) {
            this.esU.setText(i3);
        } else {
            this.esU.setVisibility(8);
        }
    }
}
