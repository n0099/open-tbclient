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
    TextView aCf;
    HeadImageView aGQ;
    TextView alz;
    LinearLayout bbf;
    TextView bbg;
    TbImageView bbh;

    public b(View view) {
        super(view);
        this.bbf = (LinearLayout) view.findViewById(i.f.frs_locality_big_image_parent);
        this.aGQ = (HeadImageView) view.findViewById(i.f.frs_locality_big_iamge_head);
        this.aCf = (TextView) view.findViewById(i.f.frs_locality_big_iamge_name);
        this.bbg = (TextView) view.findViewById(i.f.frs_locality_big_iamge_sub);
        this.alz = (TextView) view.findViewById(i.f.frs_locality_big_iamge_title);
        this.bbh = (TbImageView) view.findViewById(i.f.frs_locality_big_iamge_pic);
    }
}
