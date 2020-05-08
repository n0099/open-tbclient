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
    private ImageView fbZ;
    private TextView fca;
    private TextView fcb;

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
        this.fbZ = (ImageView) findViewById(a.g.empty_image);
        this.fca = (TextView) findViewById(a.g.empty_text);
        this.fcb = (TextView) findViewById(a.g.empty_sub_text);
    }

    public void setParams(int i, int i2, int i3) {
        if (i != -1) {
            this.fbZ.setImageResource(i);
        } else {
            this.fbZ.setVisibility(8);
        }
        if (i2 != -1) {
            this.fca.setText(i2);
        } else {
            this.fca.setVisibility(8);
        }
        if (i3 != -1) {
            this.fcb.setText(i3);
        } else {
            this.fcb.setVisibility(8);
        }
    }
}
