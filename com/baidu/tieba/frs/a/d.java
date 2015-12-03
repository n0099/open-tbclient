package com.baidu.tieba.frs.a;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class d extends x.a {
    TextView aER;
    HeadImageView aJP;
    TextView agd;
    LinearLayout bhH;
    TbImageView bhJ;
    TextView bhK;
    TextView bhL;

    public d(View view) {
        super(view);
        this.bhH = (LinearLayout) view.findViewById(n.f.normal_locality_parent);
        this.aJP = (HeadImageView) view.findViewById(n.f.normal_locality_head);
        this.aER = (TextView) view.findViewById(n.f.normal_locality_name);
        this.bhK = (TextView) view.findViewById(n.f.normal_locality_sub);
        this.agd = (TextView) view.findViewById(n.f.normal_locality_title);
        this.bhJ = (TbImageView) view.findViewById(n.f.normal_locality_pic);
        this.bhL = (TextView) view.findViewById(n.f.normal_locality_brief);
    }
}
