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
    HeadImageView aIG;
    TextView aPi;
    TextView anH;
    LinearLayout ban;
    TextView bao;
    TbImageView bap;

    public b(View view) {
        super(view);
        this.ban = (LinearLayout) view.findViewById(i.f.frs_locality_big_image_parent);
        this.aIG = (HeadImageView) view.findViewById(i.f.frs_locality_big_iamge_head);
        this.aPi = (TextView) view.findViewById(i.f.frs_locality_big_iamge_name);
        this.bao = (TextView) view.findViewById(i.f.frs_locality_big_iamge_sub);
        this.anH = (TextView) view.findViewById(i.f.frs_locality_big_iamge_title);
        this.bap = (TbImageView) view.findViewById(i.f.frs_locality_big_iamge_pic);
    }
}
