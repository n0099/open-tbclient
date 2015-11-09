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
public class dv extends x.a {
    public TextView aTl;
    public TextView aXF;
    public View aXG;
    public LinearLayout aYO;
    public TextView aYP;
    public TextView aYQ;
    public UserIconBox aYR;
    public UserIconBox aYS;
    public HeadImageView aYT;
    public TextView aYU;
    public TextView aYV;
    public TextView aYW;
    public LinearLayout aYX;
    public VoteView aYY;
    public TextView aYZ;
    public TextView aZa;
    public TextView alz;
    public int arf;

    public dv(View view) {
        super(view);
        this.arf = 3;
        this.aYX = (LinearLayout) view.findViewById(i.f.frs_item_user_info_view);
        this.aYO = (LinearLayout) view.findViewById(i.f.frs_list_item_top_linear_layout);
        this.aYT = (HeadImageView) view.findViewById(i.f.frs_photo);
        this.aYR = (UserIconBox) view.findViewById(i.f.frs_user_tshow_icon_box);
        this.aYS = (UserIconBox) view.findViewById(i.f.frs_user_icon_box);
        this.aYQ = (TextView) view.findViewById(i.f.frs_lv_author);
        this.aYP = (TextView) view.findViewById(i.f.frs_lv_reply_time);
        this.alz = (TextView) view.findViewById(i.f.frs_lv_title);
        this.aTl = (TextView) view.findViewById(i.f.abstract_text);
        this.aYU = (TextView) view.findViewById(i.f.frs_praise_num);
        this.aYV = (TextView) view.findViewById(i.f.frs_reply_num);
        this.aYW = (TextView) view.findViewById(i.f.frs_vote_num);
        this.aXF = (TextView) view.findViewById(i.f.frs_item_location_address);
        this.aXG = view.findViewById(i.f.frs_item_location_sep);
        this.aYY = (VoteView) view.findViewById(i.f.vote_view);
        this.aYZ = (TextView) view.findViewById(i.f.frs_pic_vote_total_option_num);
        this.aZa = (TextView) view.findViewById(i.f.frs_pic_vote_now_state);
    }
}
