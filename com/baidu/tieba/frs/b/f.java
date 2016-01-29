package com.baidu.tieba.frs.b;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class f extends x.a {
    TextView aHk;
    HeadImageView aMs;
    TextView apm;
    LinearLayout bon;
    TbImageView bop;
    TextView boq;
    TextView bor;
    TextView bos;

    public f(View view) {
        super(view);
        this.bon = (LinearLayout) view.findViewById(t.g.single_replenish_parent);
        this.aMs = (HeadImageView) view.findViewById(t.g.single_replenish_locality_head);
        this.aHk = (TextView) view.findViewById(t.g.single_replenish_locality_name);
        this.boq = (TextView) view.findViewById(t.g.single_replenish_locality_sub);
        this.apm = (TextView) view.findViewById(t.g.single_replenish_locality_title);
        this.bop = (TbImageView) view.findViewById(t.g.single_replenish_locality_pic);
        this.bor = (TextView) view.findViewById(t.g.single_replenish_locality_brief);
        this.bos = (TextView) view.findViewById(t.g.single_replenish_desc);
    }
}
