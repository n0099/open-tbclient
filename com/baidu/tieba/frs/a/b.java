package com.baidu.tieba.frs.a;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.q;
/* loaded from: classes.dex */
public class b extends am {
    HeadImageView aBk;
    TextView aHH;
    TextView aPA;
    TbImageView aPB;
    LinearLayout aPz;
    TextView aiA;

    public b(View view) {
        super(view);
        this.aPz = (LinearLayout) view.findViewById(q.frs_locality_big_image_parent);
        this.aBk = (HeadImageView) view.findViewById(q.frs_locality_big_iamge_head);
        this.aHH = (TextView) view.findViewById(q.frs_locality_big_iamge_name);
        this.aPA = (TextView) view.findViewById(q.frs_locality_big_iamge_sub);
        this.aiA = (TextView) view.findViewById(q.frs_locality_big_iamge_title);
        this.aPB = (TbImageView) view.findViewById(q.frs_locality_big_iamge_pic);
    }
}
