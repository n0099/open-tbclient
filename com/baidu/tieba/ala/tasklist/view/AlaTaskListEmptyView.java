package com.baidu.tieba.ala.tasklist.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
/* loaded from: classes3.dex */
public class AlaTaskListEmptyView extends LinearLayout {
    private ImageView fAY;
    private TextView fAZ;
    private TextView fBa;

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
        this.fAY = (ImageView) findViewById(a.g.empty_image);
        this.fAZ = (TextView) findViewById(a.g.empty_text);
        this.fBa = (TextView) findViewById(a.g.empty_sub_text);
    }

    public void setParams(int i, int i2, int i3) {
        if (i != -1) {
            this.fAY.setImageResource(i);
        } else {
            this.fAY.setVisibility(8);
        }
        if (i2 != -1) {
            this.fAZ.setText(i2);
        } else {
            this.fAZ.setVisibility(8);
        }
        if (i3 != -1) {
            this.fBa.setText(i3);
        } else {
            this.fBa.setVisibility(8);
        }
    }
}
