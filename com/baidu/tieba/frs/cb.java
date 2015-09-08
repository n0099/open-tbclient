package com.baidu.tieba.frs;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tieba.frs.bv;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
/* loaded from: classes.dex */
public class cb extends x.a {
    public TextView aQj;
    public LinearLayout aTU;
    public LinearLayout aTV;
    public TextView aTW;
    public PlayVoiceBnt aTX;
    public FrsCommonImageLayout aTY;
    public TextView aTZ;
    public TextView aUa;
    public UserIconBox aUb;
    public HeadImageView aUc;
    public TextView aUf;
    public TextView aUh;
    public TextView aUj;
    public LinearLayout aUl;
    public LinearLayout aXN;
    public UserIconBox aXO;
    public TextView aXP;
    public bv.a aXQ;
    public TextView aXR;
    public View aXS;
    public int arr;

    public cb(View view, int i) {
        super(view);
        this.arr = -1;
        this.aTU = (LinearLayout) view.findViewById(i.f.frs_list);
        this.aUl = (LinearLayout) view.findViewById(i.f.frs_item_user_info_view);
        this.aTV = (LinearLayout) view.findViewById(i.f.frs_list_item_top_linear_layout);
        this.aXN = (LinearLayout) view.findViewById(i.f.new_year_color_egg);
        this.aUc = (HeadImageView) view.findViewById(i.f.frs_photo);
        this.aUb = (UserIconBox) view.findViewById(i.f.frs_user_tshow_icon_box);
        this.aXO = (UserIconBox) view.findViewById(i.f.frs_user_icon_box);
        this.aUa = (TextView) view.findViewById(i.f.frs_lv_author);
        this.aTZ = (TextView) view.findViewById(i.f.frs_lv_reply_time);
        this.aQj = (TextView) view.findViewById(i.f.frs_lv_title);
        this.aTW = (TextView) view.findViewById(i.f.abstract_text);
        this.aTX = (PlayVoiceBnt) view.findViewById(i.f.abstract_voice);
        this.aTY = (FrsCommonImageLayout) view.findViewById(i.f.abstract_img_layout);
        this.aUf = (TextView) view.findViewById(i.f.frs_praise_num);
        this.aXP = (TextView) view.findViewById(i.f.action_button);
        this.aUh = (TextView) view.findViewById(i.f.frs_reply_num);
        this.aUj = (TextView) view.findViewById(i.f.frs_more_abstract);
        this.aXR = (TextView) view.findViewById(i.f.frs_item_location_address);
        this.aXS = view.findViewById(i.f.frs_item_location_sep);
        this.aTU.setBackgroundResource(i.c.transparent);
        this.aTU.setPadding(0, i, 0, 0);
    }
}
