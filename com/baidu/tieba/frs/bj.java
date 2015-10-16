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
    public LinearLayout aVL;
    public View aVM;
    public HeadImageView aVN;
    public TextView aVO;
    public TextView aVP;
    public TextView aVQ;
    public TextView aVR;
    public TbImageView aVS;
    public TbImageView aVT;
    public TbImageView aVU;
    public TextView aVV;

    public bj(View view) {
        super(view);
        this.aVL = (LinearLayout) view.findViewById(i.f.frs_app_item_parent);
        this.aVN = (HeadImageView) view.findViewById(i.f.frs_app_multi_pic_icon);
        this.aVO = (TextView) view.findViewById(i.f.frs_app_multi_pic_name);
        this.aVP = (TextView) view.findViewById(i.f.frs_app_multi_pic_time);
        this.aVQ = (TextView) view.findViewById(i.f.frs_app_multi_pic_title);
        this.aVR = (TextView) view.findViewById(i.f.frs_app_multi_pic_desc);
        this.aVS = (TbImageView) view.findViewById(i.f.frs_app_multi_pic_left);
        this.aVT = (TbImageView) view.findViewById(i.f.frs_app_multi_pic_center);
        this.aVU = (TbImageView) view.findViewById(i.f.frs_app_multi_pic_right);
        this.aVV = (TextView) view.findViewById(i.f.frs_app_multi_pic_download);
        this.aVM = view.findViewById(i.f.frs_app_multi_pic_container);
    }
}
