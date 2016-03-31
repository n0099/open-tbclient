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
    TextView aKg;
    HeadImageView aPn;
    TextView apE;
    LinearLayout btm;
    TextView btn;
    TbImageView bto;

    public b(View view) {
        super(view);
        this.btm = (LinearLayout) view.findViewById(t.g.frs_locality_big_image_parent);
        this.aPn = (HeadImageView) view.findViewById(t.g.frs_locality_big_iamge_head);
        this.aKg = (TextView) view.findViewById(t.g.frs_locality_big_iamge_name);
        this.btn = (TextView) view.findViewById(t.g.frs_app_time);
        this.apE = (TextView) view.findViewById(t.g.frs_locality_big_iamge_title);
        this.bto = (TbImageView) view.findViewById(t.g.frs_locality_big_iamge_pic);
    }
}
