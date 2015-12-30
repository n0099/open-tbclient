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
    public TextView aOn;
    public UserIconBox agT;
    public UserIconBox agU;
    public TextView agy;
    public TextView agz;
    public int ahf;
    public TextView bcB;
    public HeadImageView bcC;
    public TextView bcG;
    public LinearLayout bcK;
    public LinearLayout bcx;
    public TextView bcy;
    public TextView bgj;
    public View bgk;
    public TextView bhX;
    public FrsPicVoteLayout bhY;
    public FrsPicVotePhotoFrame bhZ;
    public FrsPicVotePhotoFrame bia;
    public FrsPicVotePhotoFrame bib;
    public TextView bic;
    public TextView bie;

    public dq(View view) {
        super(view);
        this.ahf = 3;
        this.bcK = (LinearLayout) view.findViewById(n.g.frs_item_user_info_view);
        this.bcx = (LinearLayout) view.findViewById(n.g.frs_list_item_top_linear_layout);
        this.bcC = (HeadImageView) view.findViewById(n.g.frs_photo);
        this.agT = (UserIconBox) view.findViewById(n.g.frs_user_tshow_icon_box);
        this.agU = (UserIconBox) view.findViewById(n.g.frs_user_icon_box);
        this.bcB = (TextView) view.findViewById(n.g.frs_lv_author);
        this.agy = (TextView) view.findViewById(n.g.frs_lv_reply_time);
        this.aOn = (TextView) view.findViewById(n.g.frs_lv_title);
        this.bcy = (TextView) view.findViewById(n.g.abstract_text);
        this.agz = (TextView) view.findViewById(n.g.frs_praise_num);
        this.bcG = (TextView) view.findViewById(n.g.frs_reply_num);
        this.bhX = (TextView) view.findViewById(n.g.frs_vote_num);
        this.bgj = (TextView) view.findViewById(n.g.frs_item_location_address);
        this.bgk = view.findViewById(n.g.frs_item_location_sep);
        this.bhY = (FrsPicVoteLayout) view.findViewById(n.g.vote_img_layout);
        this.bhZ = (FrsPicVotePhotoFrame) view.findViewById(n.g.frs_pic_vote_photoframe_1);
        this.bia = (FrsPicVotePhotoFrame) view.findViewById(n.g.frs_pic_vote_photoframe_2);
        this.bib = (FrsPicVotePhotoFrame) view.findViewById(n.g.frs_pic_vote_photoframe_3);
        this.bic = (TextView) view.findViewById(n.g.frs_pic_vote_total_option_num);
        this.bie = (TextView) view.findViewById(n.g.frs_pic_vote_now_state);
        view.setBackgroundResource(n.d.transparent);
    }
}
