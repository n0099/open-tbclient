package com.baidu.tieba.frs;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class et extends x.a {
    public TextView aOn;
    public TextView agS;
    public UserIconBox agT;
    public UserIconBox agU;
    public TextView agy;
    public TextView agz;
    public int ahf;
    public HeadImageView bcC;
    public TextView bcG;
    public LinearLayout bcx;
    public LinearLayout bhC;
    public LinearLayout bhD;
    public LinearLayout bhz;
    public FrameLayout biY;
    public TextView biZ;
    public View bja;
    public TbImageView bjb;
    public LinearLayout bjc;
    public RelativeLayout bjd;
    public FrameLayout bje;
    public ImageView bjf;

    public et(View view) {
        super(view);
        this.ahf = 3;
        this.bcx = (LinearLayout) view.findViewById(n.g.frs_xiaoying_top_container);
        this.biY = (FrameLayout) view.findViewById(n.g.frs_list_item_top_card);
        this.bhz = (LinearLayout) view.findViewById(n.g.new_year_color_egg);
        this.bcC = (HeadImageView) view.findViewById(n.g.frs_xiaoying_user_head);
        this.agT = (UserIconBox) view.findViewById(n.g.frs_xiaoying_tshow_icon_box);
        this.agU = (UserIconBox) view.findViewById(n.g.frs_xiaoying_user_icon_box);
        this.agS = (TextView) view.findViewById(n.g.frs_xiaoying_user_name);
        this.agy = (TextView) view.findViewById(n.g.frs_xiaoying_reply_time);
        this.aOn = (TextView) view.findViewById(n.g.frs_xiaoying_title);
        this.biZ = (TextView) view.findViewById(n.g.frs_xiaoying_location_address);
        this.bja = view.findViewById(n.g.frs_xiaoying_location_divider);
        this.agz = (TextView) view.findViewById(n.g.frs_xiaoying_praise_num);
        this.bcG = (TextView) view.findViewById(n.g.frs_xiaoying_reply_num);
        this.bjb = (TbImageView) view.findViewById(n.g.frs_xiaoying_frame_pic);
        this.bjb.setDrawBorder(true);
        this.bjb.setBorderColor(com.baidu.tbadk.core.util.as.getColor(n.d.black_alpha10));
        this.bjb.setBorderWidth(view.getResources().getDimensionPixelSize(n.e.ds1));
        this.bjb.setDefaultBgResource(n.f.pic_bg_video_frs);
        this.bjb.setDefaultResource(0);
        this.bjc = (LinearLayout) view.findViewById(n.g.frs_item_user_info_view);
        this.bjd = (RelativeLayout) view.findViewById(n.g.frs_item_user_info_view_base);
        this.bje = (FrameLayout) view.findViewById(n.g.frs_xiaoying_video_container);
        this.bhC = (LinearLayout) view.findViewById(n.g.frs_item_num);
        this.bhD = (LinearLayout) view.findViewById(n.g.frs_item_loc_view);
        this.bjf = (ImageView) view.findViewById(n.g.frs_xiaoying_play_icon);
    }
}
