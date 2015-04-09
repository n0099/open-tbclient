package com.baidu.tieba.frs.a;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.v;
/* loaded from: classes.dex */
public class d extends am {
    TextView aFA;
    LinearLayout aNn;
    TextView aNo;
    TbImageView aNp;
    TextView aNq;
    TextView ahz;
    HeadImageView azz;

    public d(View view) {
        super(view);
        this.aNn = (LinearLayout) view.findViewById(v.normal_locality_parent);
        this.azz = (HeadImageView) view.findViewById(v.normal_locality_head);
        this.aFA = (TextView) view.findViewById(v.normal_locality_name);
        this.aNo = (TextView) view.findViewById(v.normal_locality_sub);
        this.ahz = (TextView) view.findViewById(v.normal_locality_title);
        this.aNp = (TbImageView) view.findViewById(v.normal_locality_pic);
        this.aNq = (TextView) view.findViewById(v.normal_locality_brief);
    }
}
