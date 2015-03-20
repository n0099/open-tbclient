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
    TextView aFs;
    LinearLayout aMW;
    TextView aMX;
    TbImageView aMY;
    TextView ahr;
    HeadImageView azr;

    public b(View view) {
        super(view);
        this.aMW = (LinearLayout) view.findViewById(v.frs_locality_big_image_parent);
        this.azr = (HeadImageView) view.findViewById(v.frs_locality_big_iamge_head);
        this.aFs = (TextView) view.findViewById(v.frs_locality_big_iamge_name);
        this.aMX = (TextView) view.findViewById(v.frs_locality_big_iamge_sub);
        this.ahr = (TextView) view.findViewById(v.frs_locality_big_iamge_title);
        this.aMY = (TbImageView) view.findViewById(v.frs_locality_big_iamge_pic);
    }
}
