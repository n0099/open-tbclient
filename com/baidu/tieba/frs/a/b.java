package com.baidu.tieba.frs.a;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class b extends x.a {
    HeadImageView aIT;
    TextView aPv;
    TextView amV;
    LinearLayout baI;
    TextView baJ;
    TbImageView baK;

    public b(View view) {
        super(view);
        this.baI = (LinearLayout) view.findViewById(i.f.frs_locality_big_image_parent);
        this.aIT = (HeadImageView) view.findViewById(i.f.frs_locality_big_iamge_head);
        this.aPv = (TextView) view.findViewById(i.f.frs_locality_big_iamge_name);
        this.baJ = (TextView) view.findViewById(i.f.frs_locality_big_iamge_sub);
        this.amV = (TextView) view.findViewById(i.f.frs_locality_big_iamge_title);
        this.baK = (TbImageView) view.findViewById(i.f.frs_locality_big_iamge_pic);
    }
}
