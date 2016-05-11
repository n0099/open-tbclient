package com.baidu.tieba.frs;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class fe extends y.a {
    public TextView aOG;
    public TextView adG;
    public UserIconBox adH;
    public UserIconBox adI;
    public TextView adg;
    public TextView adj;
    public int aej;
    public LinearLayout bfB;
    public HeadImageView bfG;
    public TextView bfK;
    public TbImageView bkR;
    public LinearLayout bkU;
    public LinearLayout bkV;
    public LinearLayout bkW;
    public TbImageView bmA;
    public LinearLayout bmB;
    public RelativeLayout bmC;
    public FrameLayout bmD;
    public ImageView bmE;
    public TextView bmF;
    public FrameLayout bmx;
    public TextView bmy;
    public View bmz;

    public fe(View view) {
        super(view);
        this.aej = 3;
        this.bfB = (LinearLayout) view.findViewById(t.g.frs_xiaoying_top_container);
        this.bmx = (FrameLayout) view.findViewById(t.g.frs_list_item_top_card);
        this.bkR = (TbImageView) view.findViewById(t.g.xiaoying_theme_card_view);
        this.bfG = (HeadImageView) view.findViewById(t.g.frs_xiaoying_user_head);
        this.adH = (UserIconBox) view.findViewById(t.g.frs_xiaoying_tshow_icon_box);
        this.adI = (UserIconBox) view.findViewById(t.g.frs_xiaoying_user_icon_box);
        this.adG = (TextView) view.findViewById(t.g.frs_xiaoying_user_name);
        this.adg = (TextView) view.findViewById(t.g.frs_xiaoying_reply_time);
        this.aOG = (TextView) view.findViewById(t.g.frs_xiaoying_title);
        this.bmy = (TextView) view.findViewById(t.g.frs_xiaoying_location_address);
        this.bmz = view.findViewById(t.g.frs_xiaoying_location_divider);
        this.adj = (TextView) view.findViewById(t.g.frs_xiaoying_praise_num);
        this.bfK = (TextView) view.findViewById(t.g.frs_xiaoying_reply_num);
        this.bmA = (TbImageView) view.findViewById(t.g.frs_xiaoying_frame_pic);
        this.bmA.setDrawBorder(true);
        this.bmA.setBorderColor(com.baidu.tbadk.core.util.at.getColor(t.d.black_alpha10));
        this.bmA.setBorderWidth(view.getResources().getDimensionPixelSize(t.e.ds1));
        this.bmA.setDefaultBgResource(t.f.pic_bg_video_frs);
        this.bmA.setDefaultResource(0);
        this.bmA.setDefaultErrorResource(0);
        this.bmB = (LinearLayout) view.findViewById(t.g.frs_item_user_info_view);
        this.bkU = (LinearLayout) view.findViewById(t.g.frs_item_base_user_info);
        this.bmC = (RelativeLayout) view.findViewById(t.g.frs_item_user_info_view_base);
        this.bmD = (FrameLayout) view.findViewById(t.g.frs_xiaoying_video_container);
        this.bkV = (LinearLayout) view.findViewById(t.g.frs_item_num);
        this.bkW = (LinearLayout) view.findViewById(t.g.frs_item_loc_view);
        this.bmE = (ImageView) view.findViewById(t.g.frs_xiaoying_play_icon);
        this.bmF = (TextView) view.findViewById(t.g.frs_xiaoying_play_count);
    }
}
