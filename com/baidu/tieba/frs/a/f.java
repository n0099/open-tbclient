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
    TextView aDl;
    HeadImageView aHW;
    TextView alu;
    LinearLayout baM;
    TextView baN;
    TbImageView baO;
    TextView baP;
    TextView baQ;

    public f(View view) {
        super(view);
        this.baM = (LinearLayout) view.findViewById(i.f.single_replenish_parent);
        this.aHW = (HeadImageView) view.findViewById(i.f.single_replenish_locality_head);
        this.aDl = (TextView) view.findViewById(i.f.single_replenish_locality_name);
        this.baN = (TextView) view.findViewById(i.f.single_replenish_locality_sub);
        this.alu = (TextView) view.findViewById(i.f.single_replenish_locality_title);
        this.baO = (TbImageView) view.findViewById(i.f.single_replenish_locality_pic);
        this.baP = (TextView) view.findViewById(i.f.single_replenish_locality_brief);
        this.baQ = (TextView) view.findViewById(i.f.single_replenish_desc);
    }
}
