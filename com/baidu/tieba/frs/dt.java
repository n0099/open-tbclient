package com.baidu.tieba.frs;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.vote.VoteView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class dt extends x.a {
    public TextView aSS;
    public TextView aXl;
    public View aXm;
    public LinearLayout aYA;
    public VoteView aYB;
    public TextView aYC;
    public TextView aYD;
    public LinearLayout aYr;
    public TextView aYs;
    public TextView aYt;
    public UserIconBox aYu;
    public UserIconBox aYv;
    public HeadImageView aYw;
    public TextView aYx;
    public TextView aYy;
    public TextView aYz;
    public TextView alt;
    public int apR;

    public dt(View view) {
        super(view);
        this.apR = 3;
        this.aYA = (LinearLayout) view.findViewById(i.f.frs_item_user_info_view);
        this.aYr = (LinearLayout) view.findViewById(i.f.frs_list_item_top_linear_layout);
        this.aYw = (HeadImageView) view.findViewById(i.f.frs_photo);
        this.aYu = (UserIconBox) view.findViewById(i.f.frs_user_tshow_icon_box);
        this.aYv = (UserIconBox) view.findViewById(i.f.frs_user_icon_box);
        this.aYt = (TextView) view.findViewById(i.f.frs_lv_author);
        this.aYs = (TextView) view.findViewById(i.f.frs_lv_reply_time);
        this.alt = (TextView) view.findViewById(i.f.frs_lv_title);
        this.aSS = (TextView) view.findViewById(i.f.abstract_text);
        this.aYx = (TextView) view.findViewById(i.f.frs_praise_num);
        this.aYy = (TextView) view.findViewById(i.f.frs_reply_num);
        this.aYz = (TextView) view.findViewById(i.f.frs_vote_num);
        this.aXl = (TextView) view.findViewById(i.f.frs_item_location_address);
        this.aXm = view.findViewById(i.f.frs_item_location_sep);
        this.aYB = (VoteView) view.findViewById(i.f.vote_view);
        this.aYC = (TextView) view.findViewById(i.f.frs_pic_vote_total_option_num);
        this.aYD = (TextView) view.findViewById(i.f.frs_pic_vote_now_state);
    }
}
