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
    TextView aDl;
    HeadImageView aHW;
    TextView alu;
    LinearLayout baM;
    TextView baN;
    TbImageView baO;

    public b(View view) {
        super(view);
        this.baM = (LinearLayout) view.findViewById(i.f.frs_locality_big_image_parent);
        this.aHW = (HeadImageView) view.findViewById(i.f.frs_locality_big_iamge_head);
        this.aDl = (TextView) view.findViewById(i.f.frs_locality_big_iamge_name);
        this.baN = (TextView) view.findViewById(i.f.frs_locality_big_iamge_sub);
        this.alu = (TextView) view.findViewById(i.f.frs_locality_big_iamge_title);
        this.baO = (TbImageView) view.findViewById(i.f.frs_locality_big_iamge_pic);
    }
}
