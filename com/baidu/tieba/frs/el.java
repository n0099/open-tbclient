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
    public TextView aYz;
    public int afY;
    public TextView agd;
    public TextView bck;
    public View bcl;
    public LinearLayout beN;
    public TextView beO;
    public TextView beP;
    public UserIconBox beQ;
    public UserIconBox beR;
    public HeadImageView beS;
    public TextView beT;
    public TextView beU;
    public TextView beV;
    public LinearLayout beW;
    public VoteView beX;
    public TextView beY;
    public TextView beZ;

    public el(View view) {
        super(view);
        this.afY = 3;
        this.beW = (LinearLayout) view.findViewById(n.f.frs_item_user_info_view);
        this.beN = (LinearLayout) view.findViewById(n.f.frs_list_item_top_linear_layout);
        this.beS = (HeadImageView) view.findViewById(n.f.frs_photo);
        this.beQ = (UserIconBox) view.findViewById(n.f.frs_user_tshow_icon_box);
        this.beR = (UserIconBox) view.findViewById(n.f.frs_user_icon_box);
        this.beP = (TextView) view.findViewById(n.f.frs_lv_author);
        this.beO = (TextView) view.findViewById(n.f.frs_lv_reply_time);
        this.agd = (TextView) view.findViewById(n.f.frs_lv_title);
        this.aYz = (TextView) view.findViewById(n.f.abstract_text);
        this.beT = (TextView) view.findViewById(n.f.frs_praise_num);
        this.beU = (TextView) view.findViewById(n.f.frs_reply_num);
        this.beV = (TextView) view.findViewById(n.f.frs_vote_num);
        this.bck = (TextView) view.findViewById(n.f.frs_item_location_address);
        this.bcl = view.findViewById(n.f.frs_item_location_sep);
        this.beX = (VoteView) view.findViewById(n.f.vote_view);
        this.beY = (TextView) view.findViewById(n.f.frs_pic_vote_total_option_num);
        this.beZ = (TextView) view.findViewById(n.f.frs_pic_vote_now_state);
    }
}
