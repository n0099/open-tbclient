package com.baidu.tieba.frs;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.vote.VoteView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ew extends x.a {
    public int ahU;
    public TextView apm;
    public TextView beQ;
    public TextView biV;
    public View bks;
    public LinearLayout blC;
    public TextView blD;
    public TextView blE;
    public UserIconBox blF;
    public UserIconBox blG;
    public HeadImageView blH;
    public TextView blI;
    public TextView blJ;
    public TextView blK;
    public LinearLayout blL;
    public VoteView blM;
    public TextView blN;
    public TextView blO;

    public ew(View view) {
        super(view);
        this.ahU = 3;
        this.blL = (LinearLayout) view.findViewById(t.g.frs_item_user_info_view);
        this.blC = (LinearLayout) view.findViewById(t.g.frs_list_item_top_linear_layout);
        this.blH = (HeadImageView) view.findViewById(t.g.frs_photo);
        this.blF = (UserIconBox) view.findViewById(t.g.frs_user_tshow_icon_box);
        this.blG = (UserIconBox) view.findViewById(t.g.frs_user_icon_box);
        this.blE = (TextView) view.findViewById(t.g.frs_lv_author);
        this.blD = (TextView) view.findViewById(t.g.frs_lv_reply_time);
        this.apm = (TextView) view.findViewById(t.g.frs_lv_title);
        this.beQ = (TextView) view.findViewById(t.g.abstract_text);
        this.blI = (TextView) view.findViewById(t.g.frs_praise_num);
        this.blJ = (TextView) view.findViewById(t.g.frs_reply_num);
        this.blK = (TextView) view.findViewById(t.g.frs_vote_num);
        this.biV = (TextView) view.findViewById(t.g.frs_item_location_address);
        this.bks = view.findViewById(t.g.frs_item_location_sep);
        this.blM = (VoteView) view.findViewById(t.g.vote_view);
        this.blN = (TextView) view.findViewById(t.g.frs_pic_vote_total_option_num);
        this.blO = (TextView) view.findViewById(t.g.frs_pic_vote_now_state);
    }
}
