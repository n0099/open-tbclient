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
    TextView aDa;
    HeadImageView aHL;
    TextView alt;
    LinearLayout baB;
    TextView baC;
    TbImageView baD;

    public b(View view) {
        super(view);
        this.baB = (LinearLayout) view.findViewById(i.f.frs_locality_big_image_parent);
        this.aHL = (HeadImageView) view.findViewById(i.f.frs_locality_big_iamge_head);
        this.aDa = (TextView) view.findViewById(i.f.frs_locality_big_iamge_name);
        this.baC = (TextView) view.findViewById(i.f.frs_locality_big_iamge_sub);
        this.alt = (TextView) view.findViewById(i.f.frs_locality_big_iamge_title);
        this.baD = (TbImageView) view.findViewById(i.f.frs_locality_big_iamge_pic);
    }
}
