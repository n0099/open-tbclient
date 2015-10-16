package com.baidu.tieba.frs;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class dz extends x.a {
    public TextView aPq;
    public LinearLayout aTc;
    public TextView aTg;
    public UserIconBox aTi;
    public HeadImageView aTj;
    public TextView aTm;
    public TextView aTo;
    public LinearLayout aXs;
    public UserIconBox aXt;
    public TextView aYR;
    public TextView aYS;
    public TextView aYT;
    public View aYU;
    public TbImageView aYV;
    public LinearLayout aYW;
    public FrameLayout aYX;

    public dz(View view) {
        super(view);
        this.aTc = (LinearLayout) view.findViewById(i.f.frs_xiaoying_top_container);
        this.aXs = (LinearLayout) view.findViewById(i.f.new_year_color_egg);
        this.aTj = (HeadImageView) view.findViewById(i.f.frs_xiaoying_user_head);
        this.aTi = (UserIconBox) view.findViewById(i.f.frs_xiaoying_tshow_icon_box);
        this.aXt = (UserIconBox) view.findViewById(i.f.frs_xiaoying_user_icon_box);
        this.aYR = (TextView) view.findViewById(i.f.frs_xiaoying_user_name);
        this.aTg = (TextView) view.findViewById(i.f.frs_xiaoying_reply_time);
        this.aPq = (TextView) view.findViewById(i.f.frs_xiaoying_title);
        this.aYS = (TextView) view.findViewById(i.f.frs_xiaoying_abstract_text);
        this.aYT = (TextView) view.findViewById(i.f.frs_xiaoying_location_address);
        this.aYU = view.findViewById(i.f.frs_xiaoying_location_divider);
        this.aTm = (TextView) view.findViewById(i.f.frs_xiaoying_praise_num);
        this.aTo = (TextView) view.findViewById(i.f.frs_xiaoying_reply_num);
        this.aYV = (TbImageView) view.findViewById(i.f.frs_xiaoying_frame_pic);
        this.aYW = (LinearLayout) view.findViewById(i.f.frs_item_user_info_view);
        this.aYX = (FrameLayout) view.findViewById(i.f.frs_xiaoying_video_container);
    }
}
