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
    private ImageView dFE;
    private TextView dFF;
    private TextView dFG;

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
        this.dFE = (ImageView) findViewById(a.g.empty_image);
        this.dFF = (TextView) findViewById(a.g.empty_text);
        this.dFG = (TextView) findViewById(a.g.empty_sub_text);
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
