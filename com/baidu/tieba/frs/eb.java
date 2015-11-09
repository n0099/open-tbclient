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
public class eb extends x.a {
    public TextView aPy;
    public LinearLayout aTk;
    public TextView aTo;
    public UserIconBox aTq;
    public HeadImageView aTr;
    public TextView aTu;
    public TextView aTw;
    public LinearLayout aXB;
    public UserIconBox aXC;
    public TextView aZd;
    public TextView aZe;
    public TextView aZf;
    public View aZg;
    public TbImageView aZh;
    public LinearLayout aZi;
    public FrameLayout aZj;

    public eb(View view) {
        super(view);
        this.aTk = (LinearLayout) view.findViewById(i.f.frs_xiaoying_top_container);
        this.aXB = (LinearLayout) view.findViewById(i.f.new_year_color_egg);
        this.aTr = (HeadImageView) view.findViewById(i.f.frs_xiaoying_user_head);
        this.aTq = (UserIconBox) view.findViewById(i.f.frs_xiaoying_tshow_icon_box);
        this.aXC = (UserIconBox) view.findViewById(i.f.frs_xiaoying_user_icon_box);
        this.aZd = (TextView) view.findViewById(i.f.frs_xiaoying_user_name);
        this.aTo = (TextView) view.findViewById(i.f.frs_xiaoying_reply_time);
        this.aPy = (TextView) view.findViewById(i.f.frs_xiaoying_title);
        this.aZe = (TextView) view.findViewById(i.f.frs_xiaoying_abstract_text);
        this.aZf = (TextView) view.findViewById(i.f.frs_xiaoying_location_address);
        this.aZg = view.findViewById(i.f.frs_xiaoying_location_divider);
        this.aTu = (TextView) view.findViewById(i.f.frs_xiaoying_praise_num);
        this.aTw = (TextView) view.findViewById(i.f.frs_xiaoying_reply_num);
        this.aZh = (TbImageView) view.findViewById(i.f.frs_xiaoying_frame_pic);
        this.aZi = (LinearLayout) view.findViewById(i.f.frs_item_user_info_view);
        this.aZj = (FrameLayout) view.findViewById(i.f.frs_xiaoying_video_container);
    }
}
