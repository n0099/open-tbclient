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
    public TextView aPf;
    public LinearLayout aSR;
    public TextView aSS;
    public TextView aSV;
    public TextView aSW;
    public UserIconBox aSX;
    public HeadImageView aSY;
    public TextView aTb;
    public TextView aTd;
    public LinearLayout aTh;
    public TextView aXN;
    public FrsPicVoteLayout aXO;
    public FrsPicVotePhotoFrame aXP;
    public FrsPicVotePhotoFrame aXQ;
    public FrsPicVotePhotoFrame aXR;
    public TextView aXS;
    public TextView aXT;
    public UserIconBox aXi;
    public TextView aXl;
    public View aXm;
    public int apR;

    public da(View view) {
        super(view);
        this.apR = 3;
        this.aTh = (LinearLayout) view.findViewById(i.f.frs_item_user_info_view);
        this.aSR = (LinearLayout) view.findViewById(i.f.frs_list_item_top_linear_layout);
        this.aSY = (HeadImageView) view.findViewById(i.f.frs_photo);
        this.aSX = (UserIconBox) view.findViewById(i.f.frs_user_tshow_icon_box);
        this.aXi = (UserIconBox) view.findViewById(i.f.frs_user_icon_box);
        this.aSW = (TextView) view.findViewById(i.f.frs_lv_author);
        this.aSV = (TextView) view.findViewById(i.f.frs_lv_reply_time);
        this.aPf = (TextView) view.findViewById(i.f.frs_lv_title);
        this.aSS = (TextView) view.findViewById(i.f.abstract_text);
        this.aTb = (TextView) view.findViewById(i.f.frs_praise_num);
        this.aTd = (TextView) view.findViewById(i.f.frs_reply_num);
        this.aXN = (TextView) view.findViewById(i.f.frs_vote_num);
        this.aXl = (TextView) view.findViewById(i.f.frs_item_location_address);
        this.aXm = view.findViewById(i.f.frs_item_location_sep);
        this.aXO = (FrsPicVoteLayout) view.findViewById(i.f.vote_img_layout);
        this.aXP = (FrsPicVotePhotoFrame) view.findViewById(i.f.frs_pic_vote_photoframe_1);
        this.aXQ = (FrsPicVotePhotoFrame) view.findViewById(i.f.frs_pic_vote_photoframe_2);
        this.aXR = (FrsPicVotePhotoFrame) view.findViewById(i.f.frs_pic_vote_photoframe_3);
        this.aXS = (TextView) view.findViewById(i.f.frs_pic_vote_total_option_num);
        this.aXT = (TextView) view.findViewById(i.f.frs_pic_vote_now_state);
        view.setBackgroundResource(i.c.transparent);
    }
}
