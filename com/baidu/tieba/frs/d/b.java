package com.baidu.tieba.frs.d;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class b extends y.a {
    TextView aGp;
    HeadImageView aLx;
    LinearLayout bsc;
    TextView bsd;
    TbImageView bse;
    TextView title;

    public b(View view) {
        super(view);
        this.bsc = (LinearLayout) view.findViewById(t.g.frs_locality_big_image_parent);
        this.aLx = (HeadImageView) view.findViewById(t.g.frs_locality_big_iamge_head);
        this.aGp = (TextView) view.findViewById(t.g.frs_locality_big_iamge_name);
        this.bsd = (TextView) view.findViewById(t.g.frs_app_time);
        this.title = (TextView) view.findViewById(t.g.frs_locality_big_iamge_title);
        this.bse = (TbImageView) view.findViewById(t.g.frs_locality_big_iamge_pic);
    }
}
