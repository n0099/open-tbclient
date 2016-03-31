package com.baidu.tieba.frs;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.vote.VoteView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ff extends x.a {
    public int aik;
    public TextView apE;
    public TextView bjC;
    public TextView bnF;
    public TbImageView bpB;
    public View bpH;
    public LinearLayout bqU;
    public TextView bqV;
    public TextView bqW;
    public UserIconBox bqX;
    public UserIconBox bqY;
    public HeadImageView bqZ;
    public RelativeLayout bqe;
    public TextView bra;
    public TextView brb;
    public LinearLayout brc;
    public VoteView brd;
    public TextView bre;
    public TextView brf;

    public ff(View view) {
        super(view);
        this.aik = 3;
        this.brc = (LinearLayout) view.findViewById(t.g.frs_item_user_info_view);
        this.bqU = (LinearLayout) view.findViewById(t.g.frs_list_item_top_linear_layout);
        this.bqe = (RelativeLayout) view.findViewById(t.g.frs_text_vote_top_view);
        this.bpB = (TbImageView) view.findViewById(t.g.theme_card_view);
        this.bqZ = (HeadImageView) view.findViewById(t.g.frs_photo);
        this.bqX = (UserIconBox) view.findViewById(t.g.frs_user_tshow_icon_box);
        this.bqY = (UserIconBox) view.findViewById(t.g.frs_user_icon_box);
        this.bqW = (TextView) view.findViewById(t.g.frs_lv_author);
        this.bqV = (TextView) view.findViewById(t.g.frs_lv_reply_time);
        this.apE = (TextView) view.findViewById(t.g.frs_lv_title);
        this.bjC = (TextView) view.findViewById(t.g.abstract_text);
        this.bra = (TextView) view.findViewById(t.g.frs_reply_num);
        this.brb = (TextView) view.findViewById(t.g.frs_vote_num);
        this.bnF = (TextView) view.findViewById(t.g.frs_item_location_address);
        this.bpH = view.findViewById(t.g.frs_item_location_sep);
        this.brd = (VoteView) view.findViewById(t.g.vote_view);
        this.bre = (TextView) view.findViewById(t.g.frs_pic_vote_total_option_num);
        this.brf = (TextView) view.findViewById(t.g.frs_pic_vote_now_state);
    }
}
