package com.baidu.tieba.frs;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tieba.frs.cv;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
/* loaded from: classes.dex */
public class db extends x.a {
    public TextView aUB;
    public PlayVoiceBnt aYA;
    public FrsCommonImageLayout aYB;
    public TextView aYC;
    public TextView aYD;
    public UserIconBox aYE;
    public HeadImageView aYF;
    public TextView aYI;
    public TextView aYK;
    public TextView aYM;
    public LinearLayout aYx;
    public LinearLayout aYy;
    public TextView aYz;
    public int afY;
    public TextView bck;
    public View bcl;
    public UserIconBox bdA;
    public TextView bdB;
    public RelativeLayout bdC;
    public LinearLayout bdD;
    public LinearLayout bdE;
    public cv.a bdF;
    public RelativeLayout bdy;
    public LinearLayout bdz;

    public db(View view, int i) {
        super(view);
        this.afY = 3;
        this.aYx = (LinearLayout) view.findViewById(n.f.frs_list);
        this.bdC = (RelativeLayout) view.findViewById(n.f.frs_item_user_info_view);
        this.aYy = (LinearLayout) view.findViewById(n.f.frs_list_item_top_linear_layout);
        this.bdy = (RelativeLayout) view.findViewById(n.f.frs_list_item_top_card);
        this.bdz = (LinearLayout) view.findViewById(n.f.new_year_color_egg);
        this.aYF = (HeadImageView) view.findViewById(n.f.frs_photo);
        this.aYE = (UserIconBox) view.findViewById(n.f.frs_user_tshow_icon_box);
        this.bdA = (UserIconBox) view.findViewById(n.f.frs_user_icon_box);
        this.aYD = (TextView) view.findViewById(n.f.frs_lv_author);
        this.aYC = (TextView) view.findViewById(n.f.frs_lv_reply_time);
        this.aUB = (TextView) view.findViewById(n.f.frs_lv_title);
        this.aYz = (TextView) view.findViewById(n.f.abstract_text);
        this.aYA = (PlayVoiceBnt) view.findViewById(n.f.abstract_voice);
        this.aYB = (FrsCommonImageLayout) view.findViewById(n.f.abstract_img_layout);
        this.aYI = (TextView) view.findViewById(n.f.frs_praise_num);
        this.bdB = (TextView) view.findViewById(n.f.action_button);
        this.aYK = (TextView) view.findViewById(n.f.frs_reply_num);
        this.aYM = (TextView) view.findViewById(n.f.frs_more_abstract);
        this.bdD = (LinearLayout) view.findViewById(n.f.frs_item_num);
        this.bdE = (LinearLayout) view.findViewById(n.f.frs_item_loc_view);
        this.bck = (TextView) view.findViewById(n.f.frs_item_location_address);
        this.bcl = view.findViewById(n.f.frs_item_location_sep);
        this.aYx.setBackgroundResource(n.c.transparent);
        this.aYx.setPadding(0, i, 0, 0);
    }
}
