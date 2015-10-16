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
    public TextView aTd;
    public TextView aXw;
    public View aXx;
    public LinearLayout aYC;
    public TextView aYD;
    public TextView aYE;
    public UserIconBox aYF;
    public UserIconBox aYG;
    public HeadImageView aYH;
    public TextView aYI;
    public TextView aYJ;
    public TextView aYK;
    public LinearLayout aYL;
    public VoteView aYM;
    public TextView aYN;
    public TextView aYO;
    public TextView alu;
    public int apS;

    public dt(View view) {
        super(view);
        this.apS = 3;
        this.aYL = (LinearLayout) view.findViewById(i.f.frs_item_user_info_view);
        this.aYC = (LinearLayout) view.findViewById(i.f.frs_list_item_top_linear_layout);
        this.aYH = (HeadImageView) view.findViewById(i.f.frs_photo);
        this.aYF = (UserIconBox) view.findViewById(i.f.frs_user_tshow_icon_box);
        this.aYG = (UserIconBox) view.findViewById(i.f.frs_user_icon_box);
        this.aYE = (TextView) view.findViewById(i.f.frs_lv_author);
        this.aYD = (TextView) view.findViewById(i.f.frs_lv_reply_time);
        this.alu = (TextView) view.findViewById(i.f.frs_lv_title);
        this.aTd = (TextView) view.findViewById(i.f.abstract_text);
        this.aYI = (TextView) view.findViewById(i.f.frs_praise_num);
        this.aYJ = (TextView) view.findViewById(i.f.frs_reply_num);
        this.aYK = (TextView) view.findViewById(i.f.frs_vote_num);
        this.aXw = (TextView) view.findViewById(i.f.frs_item_location_address);
        this.aXx = view.findViewById(i.f.frs_item_location_sep);
        this.aYM = (VoteView) view.findViewById(i.f.vote_view);
        this.aYN = (TextView) view.findViewById(i.f.frs_pic_vote_total_option_num);
        this.aYO = (TextView) view.findViewById(i.f.frs_pic_vote_now_state);
    }
}
