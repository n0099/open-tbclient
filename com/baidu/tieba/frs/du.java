package com.baidu.tieba.frs;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.view.FrsPicVoteLayout;
import com.baidu.tieba.frs.view.FrsPicVotePhotoFrame;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class du extends y.a {
    public TextView aOG;
    public UserIconBox adH;
    public UserIconBox adI;
    public TextView adg;
    public int aej;
    public LinearLayout bfB;
    public TextView bfC;
    public TextView bfF;
    public HeadImageView bfG;
    public TextView bfK;
    public LinearLayout bfO;
    public TextView bji;
    public TbImageView bkR;
    public View bkX;
    public RelativeLayout bll;
    public TextView blm;
    public FrsPicVoteLayout bln;
    public FrsPicVotePhotoFrame blo;
    public FrsPicVotePhotoFrame blp;
    public FrsPicVotePhotoFrame blq;
    public TextView blr;
    public TextView bls;

    public du(View view) {
        super(view);
        this.aej = 3;
        this.bfO = (LinearLayout) view.findViewById(t.g.frs_item_user_info_view);
        this.bfB = (LinearLayout) view.findViewById(t.g.frs_list_item_top_linear_layout);
        this.bll = (RelativeLayout) view.findViewById(t.g.frs_pic_vote_top_view);
        this.bkR = (TbImageView) view.findViewById(t.g.theme_card_view);
        this.bfG = (HeadImageView) view.findViewById(t.g.frs_photo);
        this.adH = (UserIconBox) view.findViewById(t.g.frs_user_tshow_icon_box);
        this.adI = (UserIconBox) view.findViewById(t.g.frs_user_icon_box);
        this.bfF = (TextView) view.findViewById(t.g.frs_lv_author);
        this.adg = (TextView) view.findViewById(t.g.frs_lv_reply_time);
        this.aOG = (TextView) view.findViewById(t.g.frs_lv_title);
        this.bfC = (TextView) view.findViewById(t.g.abstract_text);
        this.bfK = (TextView) view.findViewById(t.g.frs_reply_num);
        this.blm = (TextView) view.findViewById(t.g.frs_vote_num);
        this.bji = (TextView) view.findViewById(t.g.frs_item_location_address);
        this.bkX = view.findViewById(t.g.frs_item_location_sep);
        this.bln = (FrsPicVoteLayout) view.findViewById(t.g.vote_img_layout);
        this.blo = (FrsPicVotePhotoFrame) view.findViewById(t.g.frs_pic_vote_photoframe_1);
        this.blp = (FrsPicVotePhotoFrame) view.findViewById(t.g.frs_pic_vote_photoframe_2);
        this.blq = (FrsPicVotePhotoFrame) view.findViewById(t.g.frs_pic_vote_photoframe_3);
        this.blr = (TextView) view.findViewById(t.g.frs_pic_vote_total_option_num);
        this.bls = (TextView) view.findViewById(t.g.frs_pic_vote_now_state);
        view.setBackgroundResource(t.d.transparent);
    }
}
