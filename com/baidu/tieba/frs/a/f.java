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
    HeadImageView aBl;
    TextView aHI;
    LinearLayout aPA;
    TextView aPB;
    TbImageView aPC;
    TextView aPD;
    TextView aPE;
    TextView aiA;

    public f(View view) {
        super(view);
        this.aPA = (LinearLayout) view.findViewById(q.single_replenish_parent);
        this.aBl = (HeadImageView) view.findViewById(q.single_replenish_locality_head);
        this.aHI = (TextView) view.findViewById(q.single_replenish_locality_name);
        this.aPB = (TextView) view.findViewById(q.single_replenish_locality_sub);
        this.aiA = (TextView) view.findViewById(q.single_replenish_locality_title);
        this.aPC = (TbImageView) view.findViewById(q.single_replenish_locality_pic);
        this.aPD = (TextView) view.findViewById(q.single_replenish_locality_brief);
        this.aPE = (TextView) view.findViewById(q.single_replenish_desc);
    }
}
