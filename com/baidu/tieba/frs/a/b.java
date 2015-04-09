package com.baidu.tieba.frs.a;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.v;
/* loaded from: classes.dex */
public class b extends am {
    TextView aFA;
    LinearLayout aNn;
    TextView aNo;
    TbImageView aNp;
    TextView ahz;
    HeadImageView azz;

    public b(View view) {
        super(view);
        this.aNn = (LinearLayout) view.findViewById(v.frs_locality_big_image_parent);
        this.azz = (HeadImageView) view.findViewById(v.frs_locality_big_iamge_head);
        this.aFA = (TextView) view.findViewById(v.frs_locality_big_iamge_name);
        this.aNo = (TextView) view.findViewById(v.frs_locality_big_iamge_sub);
        this.ahz = (TextView) view.findViewById(v.frs_locality_big_iamge_title);
        this.aNp = (TbImageView) view.findViewById(v.frs_locality_big_iamge_pic);
    }
}
