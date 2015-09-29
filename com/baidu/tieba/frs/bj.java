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
    public LinearLayout aVA;
    public View aVB;
    public HeadImageView aVC;
    public TextView aVD;
    public TextView aVE;
    public TextView aVF;
    public TextView aVG;
    public TbImageView aVH;
    public TbImageView aVI;
    public TbImageView aVJ;
    public TextView aVK;

    public bj(View view) {
        super(view);
        this.aVA = (LinearLayout) view.findViewById(i.f.frs_app_item_parent);
        this.aVC = (HeadImageView) view.findViewById(i.f.frs_app_multi_pic_icon);
        this.aVD = (TextView) view.findViewById(i.f.frs_app_multi_pic_name);
        this.aVE = (TextView) view.findViewById(i.f.frs_app_multi_pic_time);
        this.aVF = (TextView) view.findViewById(i.f.frs_app_multi_pic_title);
        this.aVG = (TextView) view.findViewById(i.f.frs_app_multi_pic_desc);
        this.aVH = (TbImageView) view.findViewById(i.f.frs_app_multi_pic_left);
        this.aVI = (TbImageView) view.findViewById(i.f.frs_app_multi_pic_center);
        this.aVJ = (TbImageView) view.findViewById(i.f.frs_app_multi_pic_right);
        this.aVK = (TextView) view.findViewById(i.f.frs_app_multi_pic_download);
        this.aVB = view.findViewById(i.f.frs_app_multi_pic_container);
    }
}
