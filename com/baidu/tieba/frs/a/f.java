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
    HeadImageView aIT;
    TextView aPv;
    TextView amV;
    LinearLayout baI;
    TextView baJ;
    TbImageView baK;
    TextView baL;
    TextView baM;

    public f(View view) {
        super(view);
        this.baI = (LinearLayout) view.findViewById(i.f.single_replenish_parent);
        this.aIT = (HeadImageView) view.findViewById(i.f.single_replenish_locality_head);
        this.aPv = (TextView) view.findViewById(i.f.single_replenish_locality_name);
        this.baJ = (TextView) view.findViewById(i.f.single_replenish_locality_sub);
        this.amV = (TextView) view.findViewById(i.f.single_replenish_locality_title);
        this.baK = (TbImageView) view.findViewById(i.f.single_replenish_locality_pic);
        this.baL = (TextView) view.findViewById(i.f.single_replenish_locality_brief);
        this.baM = (TextView) view.findViewById(i.f.single_replenish_desc);
    }
}
