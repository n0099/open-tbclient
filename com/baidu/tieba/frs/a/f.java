package com.baidu.tieba.frs.a;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.q;
/* loaded from: classes.dex */
public class f extends am {
    HeadImageView aBk;
    TextView aHH;
    TextView aPA;
    TbImageView aPB;
    TextView aPC;
    TextView aPD;
    LinearLayout aPz;
    TextView aiA;

    public f(View view) {
        super(view);
        this.aPz = (LinearLayout) view.findViewById(q.single_replenish_parent);
        this.aBk = (HeadImageView) view.findViewById(q.single_replenish_locality_head);
        this.aHH = (TextView) view.findViewById(q.single_replenish_locality_name);
        this.aPA = (TextView) view.findViewById(q.single_replenish_locality_sub);
        this.aiA = (TextView) view.findViewById(q.single_replenish_locality_title);
        this.aPB = (TbImageView) view.findViewById(q.single_replenish_locality_pic);
        this.aPC = (TextView) view.findViewById(q.single_replenish_locality_brief);
        this.aPD = (TextView) view.findViewById(q.single_replenish_desc);
    }
}
