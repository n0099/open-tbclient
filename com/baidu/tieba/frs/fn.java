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
public class fn extends x.a {
    public TextView aSh;
    public TextView ahM;
    public UserIconBox ahN;
    public UserIconBox ahO;
    public TextView ahr;
    public TextView ahs;
    public int aik;
    public LinearLayout bjB;
    public HeadImageView bjG;
    public TextView bjK;
    public TbImageView bpB;
    public LinearLayout bpE;
    public LinearLayout bpF;
    public LinearLayout bpG;
    public FrameLayout brj;
    public TextView brk;
    public View brl;
    public TbImageView brm;
    public LinearLayout brn;
    public RelativeLayout bro;
    public FrameLayout brp;
    public ImageView brq;
    public TextView brr;

    public fn(View view) {
        super(view);
        this.aik = 3;
        this.bjB = (LinearLayout) view.findViewById(t.g.frs_xiaoying_top_container);
        this.brj = (FrameLayout) view.findViewById(t.g.frs_list_item_top_card);
        this.bpB = (TbImageView) view.findViewById(t.g.xiaoying_theme_card_view);
        this.bjG = (HeadImageView) view.findViewById(t.g.frs_xiaoying_user_head);
        this.ahN = (UserIconBox) view.findViewById(t.g.frs_xiaoying_tshow_icon_box);
        this.ahO = (UserIconBox) view.findViewById(t.g.frs_xiaoying_user_icon_box);
        this.ahM = (TextView) view.findViewById(t.g.frs_xiaoying_user_name);
        this.ahr = (TextView) view.findViewById(t.g.frs_xiaoying_reply_time);
        this.aSh = (TextView) view.findViewById(t.g.frs_xiaoying_title);
        this.brk = (TextView) view.findViewById(t.g.frs_xiaoying_location_address);
        this.brl = view.findViewById(t.g.frs_xiaoying_location_divider);
        this.ahs = (TextView) view.findViewById(t.g.frs_xiaoying_praise_num);
        this.bjK = (TextView) view.findViewById(t.g.frs_xiaoying_reply_num);
        this.brm = (TbImageView) view.findViewById(t.g.frs_xiaoying_frame_pic);
        this.brm.setDrawBorder(true);
        this.brm.setBorderColor(com.baidu.tbadk.core.util.at.getColor(t.d.black_alpha10));
        this.brm.setBorderWidth(view.getResources().getDimensionPixelSize(t.e.ds1));
        this.brm.setDefaultBgResource(t.f.pic_bg_video_frs);
        this.brm.setDefaultResource(0);
        this.brm.setDefaultErrorResource(0);
        this.brn = (LinearLayout) view.findViewById(t.g.frs_item_user_info_view);
        this.bpE = (LinearLayout) view.findViewById(t.g.frs_item_base_user_info);
        this.bro = (RelativeLayout) view.findViewById(t.g.frs_item_user_info_view_base);
        this.brp = (FrameLayout) view.findViewById(t.g.frs_xiaoying_video_container);
        this.bpF = (LinearLayout) view.findViewById(t.g.frs_item_num);
        this.bpG = (LinearLayout) view.findViewById(t.g.frs_item_loc_view);
        this.brq = (ImageView) view.findViewById(t.g.frs_xiaoying_play_icon);
        this.brr = (TextView) view.findViewById(t.g.frs_xiaoying_play_count);
    }
}
