package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class m extends j.a {
    public TextView cJm;

    public m(View view) {
        super(view);
        this.cJm = (TextView) view.findViewById(d.g.no_data_tips);
    }
}
