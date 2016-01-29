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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class fd extends x.a {
    public TextView aPr;
    public TextView ahH;
    public UserIconBox ahI;
    public UserIconBox ahJ;
    public int ahU;
    public TextView ahm;
    public TextView ahn;
    public LinearLayout beP;
    public HeadImageView beU;
    public TextView beY;
    public LinearLayout bkp;
    public LinearLayout bkq;
    public LinearLayout bkr;
    public FrameLayout blS;
    public TextView blT;
    public View blU;
    public TbImageView blV;
    public LinearLayout blW;
    public RelativeLayout blX;
    public FrameLayout blY;
    public ImageView blZ;
    public TextView bma;

    public fd(View view) {
        super(view);
        this.ahU = 3;
        this.beP = (LinearLayout) view.findViewById(t.g.frs_xiaoying_top_container);
        this.blS = (FrameLayout) view.findViewById(t.g.frs_list_item_top_card);
        this.beU = (HeadImageView) view.findViewById(t.g.frs_xiaoying_user_head);
        this.ahI = (UserIconBox) view.findViewById(t.g.frs_xiaoying_tshow_icon_box);
        this.ahJ = (UserIconBox) view.findViewById(t.g.frs_xiaoying_user_icon_box);
        this.ahH = (TextView) view.findViewById(t.g.frs_xiaoying_user_name);
        this.ahm = (TextView) view.findViewById(t.g.frs_xiaoying_reply_time);
        this.aPr = (TextView) view.findViewById(t.g.frs_xiaoying_title);
        this.blT = (TextView) view.findViewById(t.g.frs_xiaoying_location_address);
        this.blU = view.findViewById(t.g.frs_xiaoying_location_divider);
        this.ahn = (TextView) view.findViewById(t.g.frs_xiaoying_praise_num);
        this.beY = (TextView) view.findViewById(t.g.frs_xiaoying_reply_num);
        this.blV = (TbImageView) view.findViewById(t.g.frs_xiaoying_frame_pic);
        this.blV.setDrawBorder(true);
        this.blV.setBorderColor(com.baidu.tbadk.core.util.ar.getColor(t.d.black_alpha10));
        this.blV.setBorderWidth(view.getResources().getDimensionPixelSize(t.e.ds1));
        this.blV.setDefaultBgResource(t.f.pic_bg_video_frs);
        this.blV.setDefaultResource(0);
        this.blW = (LinearLayout) view.findViewById(t.g.frs_item_user_info_view);
        this.bkp = (LinearLayout) view.findViewById(t.g.frs_item_base_user_info);
        this.blX = (RelativeLayout) view.findViewById(t.g.frs_item_user_info_view_base);
        this.blY = (FrameLayout) view.findViewById(t.g.frs_xiaoying_video_container);
        this.bkq = (LinearLayout) view.findViewById(t.g.frs_item_num);
        this.bkr = (LinearLayout) view.findViewById(t.g.frs_item_loc_view);
        this.blZ = (ImageView) view.findViewById(t.g.frs_xiaoying_play_icon);
        this.bma = (TextView) view.findViewById(t.g.frs_xiaoying_play_count);
    }
}
