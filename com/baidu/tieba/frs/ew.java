package com.baidu.tieba.frs;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.vote.VoteView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ew extends y.a {
    public int aej;
    public TextView bfC;
    public TextView bji;
    public TbImageView bkR;
    public View bkX;
    public RelativeLayout bll;
    public LinearLayout bmh;
    public TextView bmi;
    public TextView bmj;
    public UserIconBox bmk;
    public UserIconBox bml;
    public HeadImageView bmm;
    public TextView bmn;
    public TextView bmo;
    public LinearLayout bmq;
    public VoteView bmr;
    public TextView bms;
    public TextView bmt;
    public TextView title;

    public ew(View view) {
        super(view);
        this.aej = 3;
        this.bmq = (LinearLayout) view.findViewById(t.g.frs_item_user_info_view);
        this.bmh = (LinearLayout) view.findViewById(t.g.frs_list_item_top_linear_layout);
        this.bll = (RelativeLayout) view.findViewById(t.g.frs_text_vote_top_view);
        this.bkR = (TbImageView) view.findViewById(t.g.theme_card_view);
        this.bmm = (HeadImageView) view.findViewById(t.g.frs_photo);
        this.bmk = (UserIconBox) view.findViewById(t.g.frs_user_tshow_icon_box);
        this.bml = (UserIconBox) view.findViewById(t.g.frs_user_icon_box);
        this.bmj = (TextView) view.findViewById(t.g.frs_lv_author);
        this.bmi = (TextView) view.findViewById(t.g.frs_lv_reply_time);
        this.title = (TextView) view.findViewById(t.g.frs_lv_title);
        this.bfC = (TextView) view.findViewById(t.g.abstract_text);
        this.bmn = (TextView) view.findViewById(t.g.frs_reply_num);
        this.bmo = (TextView) view.findViewById(t.g.frs_vote_num);
        this.bji = (TextView) view.findViewById(t.g.frs_item_location_address);
        this.bkX = view.findViewById(t.g.frs_item_location_sep);
        this.bmr = (VoteView) view.findViewById(t.g.vote_view);
        this.bms = (TextView) view.findViewById(t.g.frs_pic_vote_total_option_num);
        this.bmt = (TextView) view.findViewById(t.g.frs_pic_vote_now_state);
    }
}
