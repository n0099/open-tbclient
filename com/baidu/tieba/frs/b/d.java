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
    TextView aKg;
    HeadImageView aPn;
    TextView apE;
    LinearLayout btm;
    TbImageView bto;
    TextView btp;
    TextView btq;

    public d(View view) {
        super(view);
        this.btm = (LinearLayout) view.findViewById(t.g.normal_locality_parent);
        this.aPn = (HeadImageView) view.findViewById(t.g.normal_locality_head);
        this.aKg = (TextView) view.findViewById(t.g.normal_locality_name);
        this.btp = (TextView) view.findViewById(t.g.normal_locality_sub);
        this.apE = (TextView) view.findViewById(t.g.normal_locality_title);
        this.bto = (TbImageView) view.findViewById(t.g.normal_locality_pic);
        this.btq = (TextView) view.findViewById(t.g.normal_locality_brief);
    }
}
