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
public class es extends x.a {
    public TextView aUB;
    public TextView aYC;
    public UserIconBox aYE;
    public HeadImageView aYF;
    public TextView aYI;
    public TextView aYK;
    public LinearLayout aYy;
    public int afY;
    public UserIconBox bdA;
    public LinearLayout bdD;
    public LinearLayout bdE;
    public LinearLayout bdz;
    public FrameLayout bfe;
    public TextView bff;
    public TextView bfg;
    public View bfh;
    public TbImageView bfi;
    public LinearLayout bfj;
    public RelativeLayout bfk;
    public FrameLayout bfl;
    public ImageView bfm;

    public es(View view) {
        super(view);
        this.afY = 3;
        this.aYy = (LinearLayout) view.findViewById(n.f.frs_xiaoying_top_container);
        this.bfe = (FrameLayout) view.findViewById(n.f.frs_list_item_top_card);
        this.bdz = (LinearLayout) view.findViewById(n.f.new_year_color_egg);
        this.aYF = (HeadImageView) view.findViewById(n.f.frs_xiaoying_user_head);
        this.aYE = (UserIconBox) view.findViewById(n.f.frs_xiaoying_tshow_icon_box);
        this.bdA = (UserIconBox) view.findViewById(n.f.frs_xiaoying_user_icon_box);
        this.bff = (TextView) view.findViewById(n.f.frs_xiaoying_user_name);
        this.aYC = (TextView) view.findViewById(n.f.frs_xiaoying_reply_time);
        this.aUB = (TextView) view.findViewById(n.f.frs_xiaoying_title);
        this.bfg = (TextView) view.findViewById(n.f.frs_xiaoying_location_address);
        this.bfh = view.findViewById(n.f.frs_xiaoying_location_divider);
        this.aYI = (TextView) view.findViewById(n.f.frs_xiaoying_praise_num);
        this.aYK = (TextView) view.findViewById(n.f.frs_xiaoying_reply_num);
        this.bfi = (TbImageView) view.findViewById(n.f.frs_xiaoying_frame_pic);
        this.bfi.setDrawBorder(true);
        this.bfi.setBorderColor(com.baidu.tbadk.core.util.as.getColor(n.c.black_alpha10));
        this.bfi.setBorderWidth(view.getResources().getDimensionPixelSize(n.d.ds1));
        this.bfi.setDefaultBgResource(n.e.pic_bg_video_frs);
        this.bfi.setDefaultResource(0);
        this.bfj = (LinearLayout) view.findViewById(n.f.frs_item_user_info_view);
        this.bfk = (RelativeLayout) view.findViewById(n.f.frs_item_user_info_view_base);
        this.bfl = (FrameLayout) view.findViewById(n.f.frs_xiaoying_video_container);
        this.bdD = (LinearLayout) view.findViewById(n.f.frs_item_num);
        this.bdE = (LinearLayout) view.findViewById(n.f.frs_item_loc_view);
        this.bfm = (ImageView) view.findViewById(n.f.frs_xiaoying_play_icon);
    }
}
