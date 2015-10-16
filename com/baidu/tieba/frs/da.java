package com.baidu.tieba.frs;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tieba.frs.view.FrsPicVoteLayout;
import com.baidu.tieba.frs.view.FrsPicVotePhotoFrame;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class da extends x.a {
    public TextView aPq;
    public LinearLayout aTc;
    public TextView aTd;
    public TextView aTg;
    public TextView aTh;
    public UserIconBox aTi;
    public HeadImageView aTj;
    public TextView aTm;
    public TextView aTo;
    public LinearLayout aTs;
    public TextView aXY;
    public FrsPicVoteLayout aXZ;
    public UserIconBox aXt;
    public TextView aXw;
    public View aXx;
    public FrsPicVotePhotoFrame aYa;
    public FrsPicVotePhotoFrame aYb;
    public FrsPicVotePhotoFrame aYc;
    public TextView aYd;
    public TextView aYe;
    public int apS;

    public da(View view) {
        super(view);
        this.apS = 3;
        this.aTs = (LinearLayout) view.findViewById(i.f.frs_item_user_info_view);
        this.aTc = (LinearLayout) view.findViewById(i.f.frs_list_item_top_linear_layout);
        this.aTj = (HeadImageView) view.findViewById(i.f.frs_photo);
        this.aTi = (UserIconBox) view.findViewById(i.f.frs_user_tshow_icon_box);
        this.aXt = (UserIconBox) view.findViewById(i.f.frs_user_icon_box);
        this.aTh = (TextView) view.findViewById(i.f.frs_lv_author);
        this.aTg = (TextView) view.findViewById(i.f.frs_lv_reply_time);
        this.aPq = (TextView) view.findViewById(i.f.frs_lv_title);
        this.aTd = (TextView) view.findViewById(i.f.abstract_text);
        this.aTm = (TextView) view.findViewById(i.f.frs_praise_num);
        this.aTo = (TextView) view.findViewById(i.f.frs_reply_num);
        this.aXY = (TextView) view.findViewById(i.f.frs_vote_num);
        this.aXw = (TextView) view.findViewById(i.f.frs_item_location_address);
        this.aXx = view.findViewById(i.f.frs_item_location_sep);
        this.aXZ = (FrsPicVoteLayout) view.findViewById(i.f.vote_img_layout);
        this.aYa = (FrsPicVotePhotoFrame) view.findViewById(i.f.frs_pic_vote_photoframe_1);
        this.aYb = (FrsPicVotePhotoFrame) view.findViewById(i.f.frs_pic_vote_photoframe_2);
        this.aYc = (FrsPicVotePhotoFrame) view.findViewById(i.f.frs_pic_vote_photoframe_3);
        this.aYd = (TextView) view.findViewById(i.f.frs_pic_vote_total_option_num);
        this.aYe = (TextView) view.findViewById(i.f.frs_pic_vote_now_state);
        view.setBackgroundResource(i.c.transparent);
    }
}
