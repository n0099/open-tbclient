package com.baidu.tieba.frs.a;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class b extends x.a {
    TextView aER;
    HeadImageView aJP;
    TextView agd;
    LinearLayout bhH;
    TextView bhI;
    TbImageView bhJ;

    public b(View view) {
        super(view);
        this.bhH = (LinearLayout) view.findViewById(n.f.frs_locality_big_image_parent);
        this.aJP = (HeadImageView) view.findViewById(n.f.frs_locality_big_iamge_head);
        this.aER = (TextView) view.findViewById(n.f.frs_locality_big_iamge_name);
        this.bhI = (TextView) view.findViewById(n.f.frs_app_time);
        this.agd = (TextView) view.findViewById(n.f.frs_locality_big_iamge_title);
        this.bhJ = (TbImageView) view.findViewById(n.f.frs_locality_big_iamge_pic);
    }
}
