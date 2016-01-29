package com.baidu.tieba.frs.b;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class d extends x.a {
    TextView aHk;
    HeadImageView aMs;
    TextView apm;
    LinearLayout bon;
    TbImageView bop;
    TextView boq;
    TextView bor;

    public d(View view) {
        super(view);
        this.bon = (LinearLayout) view.findViewById(t.g.normal_locality_parent);
        this.aMs = (HeadImageView) view.findViewById(t.g.normal_locality_head);
        this.aHk = (TextView) view.findViewById(t.g.normal_locality_name);
        this.boq = (TextView) view.findViewById(t.g.normal_locality_sub);
        this.apm = (TextView) view.findViewById(t.g.normal_locality_title);
        this.bop = (TbImageView) view.findViewById(t.g.normal_locality_pic);
        this.bor = (TextView) view.findViewById(t.g.normal_locality_brief);
    }
}
