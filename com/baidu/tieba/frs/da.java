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
    public TextView aPy;
    public LinearLayout aTA;
    public LinearLayout aTk;
    public TextView aTl;
    public TextView aTo;
    public TextView aTp;
    public UserIconBox aTq;
    public HeadImageView aTr;
    public TextView aTu;
    public TextView aTw;
    public UserIconBox aXC;
    public TextView aXF;
    public View aXG;
    public TextView aYh;
    public FrsPicVoteLayout aYi;
    public FrsPicVotePhotoFrame aYj;
    public FrsPicVotePhotoFrame aYk;
    public FrsPicVotePhotoFrame aYl;
    public TextView aYm;
    public TextView aYn;
    public int arf;

    public da(View view) {
        super(view);
        this.arf = 3;
        this.aTA = (LinearLayout) view.findViewById(i.f.frs_item_user_info_view);
        this.aTk = (LinearLayout) view.findViewById(i.f.frs_list_item_top_linear_layout);
        this.aTr = (HeadImageView) view.findViewById(i.f.frs_photo);
        this.aTq = (UserIconBox) view.findViewById(i.f.frs_user_tshow_icon_box);
        this.aXC = (UserIconBox) view.findViewById(i.f.frs_user_icon_box);
        this.aTp = (TextView) view.findViewById(i.f.frs_lv_author);
        this.aTo = (TextView) view.findViewById(i.f.frs_lv_reply_time);
        this.aPy = (TextView) view.findViewById(i.f.frs_lv_title);
        this.aTl = (TextView) view.findViewById(i.f.abstract_text);
        this.aTu = (TextView) view.findViewById(i.f.frs_praise_num);
        this.aTw = (TextView) view.findViewById(i.f.frs_reply_num);
        this.aYh = (TextView) view.findViewById(i.f.frs_vote_num);
        this.aXF = (TextView) view.findViewById(i.f.frs_item_location_address);
        this.aXG = view.findViewById(i.f.frs_item_location_sep);
        this.aYi = (FrsPicVoteLayout) view.findViewById(i.f.vote_img_layout);
        this.aYj = (FrsPicVotePhotoFrame) view.findViewById(i.f.frs_pic_vote_photoframe_1);
        this.aYk = (FrsPicVotePhotoFrame) view.findViewById(i.f.frs_pic_vote_photoframe_2);
        this.aYl = (FrsPicVotePhotoFrame) view.findViewById(i.f.frs_pic_vote_photoframe_3);
        this.aYm = (TextView) view.findViewById(i.f.frs_pic_vote_total_option_num);
        this.aYn = (TextView) view.findViewById(i.f.frs_pic_vote_now_state);
        view.setBackgroundResource(i.c.transparent);
    }
}
