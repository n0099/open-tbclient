package com.baidu.tieba.frs;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.vote.VoteView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class el extends x.a {
    public int ahf;
    public TextView ahk;
    public TextView bcy;
    public TextView bgj;
    public View bgk;
    public LinearLayout biH;
    public TextView biI;
    public TextView biJ;
    public UserIconBox biK;
    public UserIconBox biL;
    public HeadImageView biM;
    public TextView biN;
    public TextView biO;
    public TextView biP;
    public LinearLayout biQ;
    public VoteView biR;
    public TextView biS;
    public TextView biT;

    public el(View view) {
        super(view);
        this.ahf = 3;
        this.biQ = (LinearLayout) view.findViewById(n.g.frs_item_user_info_view);
        this.biH = (LinearLayout) view.findViewById(n.g.frs_list_item_top_linear_layout);
        this.biM = (HeadImageView) view.findViewById(n.g.frs_photo);
        this.biK = (UserIconBox) view.findViewById(n.g.frs_user_tshow_icon_box);
        this.biL = (UserIconBox) view.findViewById(n.g.frs_user_icon_box);
        this.biJ = (TextView) view.findViewById(n.g.frs_lv_author);
        this.biI = (TextView) view.findViewById(n.g.frs_lv_reply_time);
        this.ahk = (TextView) view.findViewById(n.g.frs_lv_title);
        this.bcy = (TextView) view.findViewById(n.g.abstract_text);
        this.biN = (TextView) view.findViewById(n.g.frs_praise_num);
        this.biO = (TextView) view.findViewById(n.g.frs_reply_num);
        this.biP = (TextView) view.findViewById(n.g.frs_vote_num);
        this.bgj = (TextView) view.findViewById(n.g.frs_item_location_address);
        this.bgk = view.findViewById(n.g.frs_item_location_sep);
        this.biR = (VoteView) view.findViewById(n.g.vote_view);
        this.biS = (TextView) view.findViewById(n.g.frs_pic_vote_total_option_num);
        this.biT = (TextView) view.findViewById(n.g.frs_pic_vote_now_state);
    }
}
