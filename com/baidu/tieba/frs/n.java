package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class n extends q.a {
    public TextView dmf;

    public n(View view) {
        super(view);
        this.dmf = (TextView) view.findViewById(d.g.no_data_tips);
    }
}
