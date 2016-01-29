package com.baidu.tieba.frs;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tieba.frs.view.FrsPicVoteLayout;
import com.baidu.tieba.frs.view.FrsPicVotePhotoFrame;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class dv extends x.a {
    public TextView aPr;
    public UserIconBox ahI;
    public UserIconBox ahJ;
    public int ahU;
    public TextView ahm;
    public TextView ahn;
    public LinearLayout beP;
    public TextView beQ;
    public TextView beT;
    public HeadImageView beU;
    public TextView beY;
    public LinearLayout bfc;
    public TextView biV;
    public TextView bkP;
    public FrsPicVoteLayout bkQ;
    public FrsPicVotePhotoFrame bkR;
    public FrsPicVotePhotoFrame bkS;
    public FrsPicVotePhotoFrame bkT;
    public TextView bkU;
    public TextView bkV;
    public View bks;

    public dv(View view) {
        super(view);
        this.ahU = 3;
        this.bfc = (LinearLayout) view.findViewById(t.g.frs_item_user_info_view);
        this.beP = (LinearLayout) view.findViewById(t.g.frs_list_item_top_linear_layout);
        this.beU = (HeadImageView) view.findViewById(t.g.frs_photo);
        this.ahI = (UserIconBox) view.findViewById(t.g.frs_user_tshow_icon_box);
        this.ahJ = (UserIconBox) view.findViewById(t.g.frs_user_icon_box);
        this.beT = (TextView) view.findViewById(t.g.frs_lv_author);
        this.ahm = (TextView) view.findViewById(t.g.frs_lv_reply_time);
        this.aPr = (TextView) view.findViewById(t.g.frs_lv_title);
        this.beQ = (TextView) view.findViewById(t.g.abstract_text);
        this.ahn = (TextView) view.findViewById(t.g.frs_praise_num);
        this.beY = (TextView) view.findViewById(t.g.frs_reply_num);
        this.bkP = (TextView) view.findViewById(t.g.frs_vote_num);
        this.biV = (TextView) view.findViewById(t.g.frs_item_location_address);
        this.bks = view.findViewById(t.g.frs_item_location_sep);
        this.bkQ = (FrsPicVoteLayout) view.findViewById(t.g.vote_img_layout);
        this.bkR = (FrsPicVotePhotoFrame) view.findViewById(t.g.frs_pic_vote_photoframe_1);
        this.bkS = (FrsPicVotePhotoFrame) view.findViewById(t.g.frs_pic_vote_photoframe_2);
        this.bkT = (FrsPicVotePhotoFrame) view.findViewById(t.g.frs_pic_vote_photoframe_3);
        this.bkU = (TextView) view.findViewById(t.g.frs_pic_vote_total_option_num);
        this.bkV = (TextView) view.findViewById(t.g.frs_pic_vote_now_state);
        view.setBackgroundResource(t.d.transparent);
    }
}
