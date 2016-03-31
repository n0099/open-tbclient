package com.baidu.tieba.frs;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.view.FrsPicVoteLayout;
import com.baidu.tieba.frs.view.FrsPicVotePhotoFrame;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ec extends x.a {
    public TextView aSh;
    public UserIconBox ahN;
    public UserIconBox ahO;
    public TextView ahr;
    public int aik;
    public LinearLayout bjB;
    public TextView bjC;
    public TextView bjF;
    public HeadImageView bjG;
    public TextView bjK;
    public LinearLayout bjO;
    public TextView bnF;
    public TbImageView bpB;
    public View bpH;
    public RelativeLayout bqe;
    public TextView bqf;
    public FrsPicVoteLayout bqg;
    public FrsPicVotePhotoFrame bqh;
    public FrsPicVotePhotoFrame bqi;
    public FrsPicVotePhotoFrame bqj;
    public TextView bqk;
    public TextView bql;

    public ec(View view) {
        super(view);
        this.aik = 3;
        this.bjO = (LinearLayout) view.findViewById(t.g.frs_item_user_info_view);
        this.bjB = (LinearLayout) view.findViewById(t.g.frs_list_item_top_linear_layout);
        this.bqe = (RelativeLayout) view.findViewById(t.g.frs_pic_vote_top_view);
        this.bpB = (TbImageView) view.findViewById(t.g.theme_card_view);
        this.bjG = (HeadImageView) view.findViewById(t.g.frs_photo);
        this.ahN = (UserIconBox) view.findViewById(t.g.frs_user_tshow_icon_box);
        this.ahO = (UserIconBox) view.findViewById(t.g.frs_user_icon_box);
        this.bjF = (TextView) view.findViewById(t.g.frs_lv_author);
        this.ahr = (TextView) view.findViewById(t.g.frs_lv_reply_time);
        this.aSh = (TextView) view.findViewById(t.g.frs_lv_title);
        this.bjC = (TextView) view.findViewById(t.g.abstract_text);
        this.bjK = (TextView) view.findViewById(t.g.frs_reply_num);
        this.bqf = (TextView) view.findViewById(t.g.frs_vote_num);
        this.bnF = (TextView) view.findViewById(t.g.frs_item_location_address);
        this.bpH = view.findViewById(t.g.frs_item_location_sep);
        this.bqg = (FrsPicVoteLayout) view.findViewById(t.g.vote_img_layout);
        this.bqh = (FrsPicVotePhotoFrame) view.findViewById(t.g.frs_pic_vote_photoframe_1);
        this.bqi = (FrsPicVotePhotoFrame) view.findViewById(t.g.frs_pic_vote_photoframe_2);
        this.bqj = (FrsPicVotePhotoFrame) view.findViewById(t.g.frs_pic_vote_photoframe_3);
        this.bqk = (TextView) view.findViewById(t.g.frs_pic_vote_total_option_num);
        this.bql = (TextView) view.findViewById(t.g.frs_pic_vote_now_state);
        view.setBackgroundResource(t.d.transparent);
    }
}
