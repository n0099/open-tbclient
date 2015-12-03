package com.baidu.tieba.frs;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tieba.frs.view.FrsPicVoteLayout;
import com.baidu.tieba.frs.view.FrsPicVotePhotoFrame;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class dq extends x.a {
    public TextView aUB;
    public TextView aYC;
    public TextView aYD;
    public UserIconBox aYE;
    public HeadImageView aYF;
    public TextView aYI;
    public TextView aYK;
    public LinearLayout aYO;
    public LinearLayout aYy;
    public TextView aYz;
    public int afY;
    public TextView bck;
    public View bcl;
    public UserIconBox bdA;
    public TextView bee;
    public FrsPicVoteLayout bef;
    public FrsPicVotePhotoFrame beg;
    public FrsPicVotePhotoFrame beh;
    public FrsPicVotePhotoFrame bei;
    public TextView bej;
    public TextView bek;

    public dq(View view) {
        super(view);
        this.afY = 3;
        this.aYO = (LinearLayout) view.findViewById(n.f.frs_item_user_info_view);
        this.aYy = (LinearLayout) view.findViewById(n.f.frs_list_item_top_linear_layout);
        this.aYF = (HeadImageView) view.findViewById(n.f.frs_photo);
        this.aYE = (UserIconBox) view.findViewById(n.f.frs_user_tshow_icon_box);
        this.bdA = (UserIconBox) view.findViewById(n.f.frs_user_icon_box);
        this.aYD = (TextView) view.findViewById(n.f.frs_lv_author);
        this.aYC = (TextView) view.findViewById(n.f.frs_lv_reply_time);
        this.aUB = (TextView) view.findViewById(n.f.frs_lv_title);
        this.aYz = (TextView) view.findViewById(n.f.abstract_text);
        this.aYI = (TextView) view.findViewById(n.f.frs_praise_num);
        this.aYK = (TextView) view.findViewById(n.f.frs_reply_num);
        this.bee = (TextView) view.findViewById(n.f.frs_vote_num);
        this.bck = (TextView) view.findViewById(n.f.frs_item_location_address);
        this.bcl = view.findViewById(n.f.frs_item_location_sep);
        this.bef = (FrsPicVoteLayout) view.findViewById(n.f.vote_img_layout);
        this.beg = (FrsPicVotePhotoFrame) view.findViewById(n.f.frs_pic_vote_photoframe_1);
        this.beh = (FrsPicVotePhotoFrame) view.findViewById(n.f.frs_pic_vote_photoframe_2);
        this.bei = (FrsPicVotePhotoFrame) view.findViewById(n.f.frs_pic_vote_photoframe_3);
        this.bej = (TextView) view.findViewById(n.f.frs_pic_vote_total_option_num);
        this.bek = (TextView) view.findViewById(n.f.frs_pic_vote_now_state);
        view.setBackgroundResource(n.c.transparent);
    }
}
