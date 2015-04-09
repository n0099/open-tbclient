package com.baidu.tieba.frs.a;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.v;
/* loaded from: classes.dex */
public class f extends am {
    TextView aFA;
    LinearLayout aNn;
    TextView aNo;
    TbImageView aNp;
    TextView aNq;
    TextView aNr;
    TextView ahz;
    HeadImageView azz;

    public f(View view) {
        super(view);
        this.aNn = (LinearLayout) view.findViewById(v.single_replenish_parent);
        this.azz = (HeadImageView) view.findViewById(v.single_replenish_locality_head);
        this.aFA = (TextView) view.findViewById(v.single_replenish_locality_name);
        this.aNo = (TextView) view.findViewById(v.single_replenish_locality_sub);
        this.ahz = (TextView) view.findViewById(v.single_replenish_locality_title);
        this.aNp = (TbImageView) view.findViewById(v.single_replenish_locality_pic);
        this.aNq = (TextView) view.findViewById(v.single_replenish_locality_brief);
        this.aNr = (TextView) view.findViewById(v.single_replenish_desc);
    }
}
