package com.baidu.tieba.hottopic.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class d extends x.a {
    public View aIj;
    public int ahU;
    public TbImageView bLY;
    public TextView bLZ;
    public TextView bMa;
    public TextView bMb;
    public LinearLayout bMc;
    public LinearLayout bMd;
    public ImageView bMe;
    public ImageView bMf;
    public TextView bMg;
    public TextView bMh;

    public d(View view) {
        super(view);
        this.ahU = 3;
        this.bLZ = null;
        this.bMa = null;
        this.bMb = null;
        this.aIj = null;
        this.bMc = null;
        this.bMd = null;
        this.bMe = null;
        this.bMf = null;
        this.bMg = null;
        this.bMh = null;
        this.bLY = (TbImageView) view.findViewById(t.g.hot_topic_info_picture);
        this.bLZ = (TextView) view.findViewById(t.g.hot_topic_info_title);
        this.bMa = (TextView) view.findViewById(t.g.hot_topic_info_threadcount);
        this.bMb = (TextView) view.findViewById(t.g.hot_topic_info_abstract);
        this.aIj = view.findViewById(t.g.divider_line);
        this.bMc = (LinearLayout) view.findViewById(t.g.hot_topic_ranking_item);
        this.bMd = (LinearLayout) view.findViewById(t.g.hot_topic_ranking_content);
        this.bMg = (TextView) view.findViewById(t.g.hot_topic_ranklist_title);
        this.bMe = (ImageView) view.findViewById(t.g.ranklist_pic_l);
        this.bMf = (ImageView) view.findViewById(t.g.ranklist_pic_r);
        this.bMh = (TextView) view.findViewById(t.g.hot_topic_look_ranklist);
    }
}
