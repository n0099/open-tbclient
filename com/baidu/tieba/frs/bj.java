package com.baidu.tieba.frs;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class bj extends x.a {
    public LinearLayout aVT;
    public View aVU;
    public HeadImageView aVV;
    public TextView aVW;
    public TextView aVX;
    public TextView aVY;
    public TextView aVZ;
    public TbImageView aWa;
    public TbImageView aWb;
    public TbImageView aWc;
    public TextView aWd;

    public bj(View view) {
        super(view);
        this.aVT = (LinearLayout) view.findViewById(i.f.frs_app_item_parent);
        this.aVV = (HeadImageView) view.findViewById(i.f.frs_app_multi_pic_icon);
        this.aVW = (TextView) view.findViewById(i.f.frs_app_multi_pic_name);
        this.aVX = (TextView) view.findViewById(i.f.frs_app_multi_pic_time);
        this.aVY = (TextView) view.findViewById(i.f.frs_app_multi_pic_title);
        this.aVZ = (TextView) view.findViewById(i.f.frs_app_multi_pic_desc);
        this.aWa = (TbImageView) view.findViewById(i.f.frs_app_multi_pic_left);
        this.aWb = (TbImageView) view.findViewById(i.f.frs_app_multi_pic_center);
        this.aWc = (TbImageView) view.findViewById(i.f.frs_app_multi_pic_right);
        this.aWd = (TextView) view.findViewById(i.f.frs_app_multi_pic_download);
        this.aVU = view.findViewById(i.f.frs_app_multi_pic_container);
    }
}
