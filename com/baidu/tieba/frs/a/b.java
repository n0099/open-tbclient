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
    TextView aGr;
    HeadImageView aLn;
    TextView ahk;
    TbImageView blA;
    LinearLayout bly;
    TextView blz;

    public b(View view) {
        super(view);
        this.bly = (LinearLayout) view.findViewById(n.g.frs_locality_big_image_parent);
        this.aLn = (HeadImageView) view.findViewById(n.g.frs_locality_big_iamge_head);
        this.aGr = (TextView) view.findViewById(n.g.frs_locality_big_iamge_name);
        this.blz = (TextView) view.findViewById(n.g.frs_app_time);
        this.ahk = (TextView) view.findViewById(n.g.frs_locality_big_iamge_title);
        this.blA = (TbImageView) view.findViewById(n.g.frs_locality_big_iamge_pic);
    }
}
