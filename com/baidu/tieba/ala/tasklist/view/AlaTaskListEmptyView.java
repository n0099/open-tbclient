package com.baidu.tieba.ala.tasklist.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.q.a;
/* loaded from: classes2.dex */
public class AlaTaskListEmptyView extends LinearLayout {
    private ImageView erH;
    private TextView erI;
    private TextView erJ;

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
        this.erH = (ImageView) findViewById(a.g.empty_image);
        this.erI = (TextView) findViewById(a.g.empty_text);
        this.erJ = (TextView) findViewById(a.g.empty_sub_text);
    }

    public void setParams(int i, int i2, int i3) {
        if (i != -1) {
            this.erH.setImageResource(i);
        } else {
            this.erH.setVisibility(8);
        }
        if (i2 != -1) {
            this.erI.setText(i2);
        } else {
            this.erI.setVisibility(8);
        }
        if (i3 != -1) {
            this.erJ.setText(i3);
        } else {
            this.erJ.setVisibility(8);
        }
    }
}
