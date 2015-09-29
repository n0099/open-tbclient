package com.baidu.tieba.frs.a;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class f extends x.a {
    TextView aDa;
    HeadImageView aHL;
    TextView alt;
    LinearLayout baB;
    TextView baC;
    TbImageView baD;
    TextView baE;
    TextView baF;

    public f(View view) {
        super(view);
        this.baB = (LinearLayout) view.findViewById(i.f.single_replenish_parent);
        this.aHL = (HeadImageView) view.findViewById(i.f.single_replenish_locality_head);
        this.aDa = (TextView) view.findViewById(i.f.single_replenish_locality_name);
        this.baC = (TextView) view.findViewById(i.f.single_replenish_locality_sub);
        this.alt = (TextView) view.findViewById(i.f.single_replenish_locality_title);
        this.baD = (TbImageView) view.findViewById(i.f.single_replenish_locality_pic);
        this.baE = (TextView) view.findViewById(i.f.single_replenish_locality_brief);
        this.baF = (TextView) view.findViewById(i.f.single_replenish_desc);
    }
}
