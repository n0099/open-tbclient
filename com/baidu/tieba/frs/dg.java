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
public class dg extends x.a {
    public TextView aQj;
    public LinearLayout aTV;
    public TextView aTZ;
    public UserIconBox aUb;
    public HeadImageView aUc;
    public TextView aUf;
    public TextView aUh;
    public LinearLayout aXN;
    public UserIconBox aXO;
    public TextView aYR;
    public TextView aYS;
    public TextView aYT;
    public View aYU;
    public TbImageView aYV;
    public LinearLayout aYW;
    public FrameLayout aYX;

    public dg(View view) {
        super(view);
        this.aTV = (LinearLayout) view.findViewById(i.f.frs_xiaoying_top_container);
        this.aXN = (LinearLayout) view.findViewById(i.f.new_year_color_egg);
        this.aUc = (HeadImageView) view.findViewById(i.f.frs_xiaoying_user_head);
        this.aUb = (UserIconBox) view.findViewById(i.f.frs_xiaoying_tshow_icon_box);
        this.aXO = (UserIconBox) view.findViewById(i.f.frs_xiaoying_user_icon_box);
        this.aYR = (TextView) view.findViewById(i.f.frs_xiaoying_user_name);
        this.aTZ = (TextView) view.findViewById(i.f.frs_xiaoying_reply_time);
        this.aQj = (TextView) view.findViewById(i.f.frs_xiaoying_title);
        this.aYS = (TextView) view.findViewById(i.f.frs_xiaoying_abstract_text);
        this.aYT = (TextView) view.findViewById(i.f.frs_xiaoying_location_address);
        this.aYU = view.findViewById(i.f.frs_xiaoying_location_divider);
        this.aUf = (TextView) view.findViewById(i.f.frs_xiaoying_praise_num);
        this.aUh = (TextView) view.findViewById(i.f.frs_xiaoying_reply_num);
        this.aYV = (TbImageView) view.findViewById(i.f.frs_xiaoying_frame_pic);
        this.aYW = (LinearLayout) view.findViewById(i.f.frs_item_user_info_view);
        this.aYX = (FrameLayout) view.findViewById(i.f.frs_xiaoying_video_container);
    }
}
