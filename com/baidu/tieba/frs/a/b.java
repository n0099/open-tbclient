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
    HeadImageView aBl;
    TextView aHI;
    LinearLayout aPA;
    TextView aPB;
    TbImageView aPC;
    TextView aiA;

    public b(View view) {
        super(view);
        this.aPA = (LinearLayout) view.findViewById(q.frs_locality_big_image_parent);
        this.aBl = (HeadImageView) view.findViewById(q.frs_locality_big_iamge_head);
        this.aHI = (TextView) view.findViewById(q.frs_locality_big_iamge_name);
        this.aPB = (TextView) view.findViewById(q.frs_locality_big_iamge_sub);
        this.aiA = (TextView) view.findViewById(q.frs_locality_big_iamge_title);
        this.aPC = (TbImageView) view.findViewById(q.frs_locality_big_iamge_pic);
    }
}
