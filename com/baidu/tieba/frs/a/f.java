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
    TextView aCf;
    HeadImageView aGQ;
    TextView alz;
    LinearLayout bbf;
    TextView bbg;
    TbImageView bbh;
    TextView bbi;
    TextView bbj;

    public f(View view) {
        super(view);
        this.bbf = (LinearLayout) view.findViewById(i.f.single_replenish_parent);
        this.aGQ = (HeadImageView) view.findViewById(i.f.single_replenish_locality_head);
        this.aCf = (TextView) view.findViewById(i.f.single_replenish_locality_name);
        this.bbg = (TextView) view.findViewById(i.f.single_replenish_locality_sub);
        this.alz = (TextView) view.findViewById(i.f.single_replenish_locality_title);
        this.bbh = (TbImageView) view.findViewById(i.f.single_replenish_locality_pic);
        this.bbi = (TextView) view.findViewById(i.f.single_replenish_locality_brief);
        this.bbj = (TextView) view.findViewById(i.f.single_replenish_desc);
    }
}
