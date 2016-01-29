package com.baidu.tieba.frs.b;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class b extends x.a {
    TextView aHk;
    HeadImageView aMs;
    TextView apm;
    LinearLayout bon;
    TextView boo;
    TbImageView bop;

    public b(View view) {
        super(view);
        this.bon = (LinearLayout) view.findViewById(t.g.frs_locality_big_image_parent);
        this.aMs = (HeadImageView) view.findViewById(t.g.frs_locality_big_iamge_head);
        this.aHk = (TextView) view.findViewById(t.g.frs_locality_big_iamge_name);
        this.boo = (TextView) view.findViewById(t.g.frs_app_time);
        this.apm = (TextView) view.findViewById(t.g.frs_locality_big_iamge_title);
        this.bop = (TbImageView) view.findViewById(t.g.frs_locality_big_iamge_pic);
    }
}
