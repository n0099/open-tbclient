package com.baidu.tieba.frs;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tieba.frs.cf;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
/* loaded from: classes.dex */
public class cl extends x.a {
    public TextView aPf;
    public LinearLayout aSQ;
    public LinearLayout aSR;
    public TextView aSS;
    public PlayVoiceBnt aST;
    public FrsCommonImageLayout aSU;
    public TextView aSV;
    public TextView aSW;
    public UserIconBox aSX;
    public HeadImageView aSY;
    public TextView aTb;
    public TextView aTd;
    public TextView aTf;
    public LinearLayout aTh;
    public LinearLayout aXh;
    public UserIconBox aXi;
    public TextView aXj;
    public cf.a aXk;
    public TextView aXl;
    public View aXm;
    public int apR;

    public cl(View view, int i) {
        super(view);
        this.apR = 3;
        this.aSQ = (LinearLayout) view.findViewById(i.f.frs_list);
        this.aTh = (LinearLayout) view.findViewById(i.f.frs_item_user_info_view);
        this.aSR = (LinearLayout) view.findViewById(i.f.frs_list_item_top_linear_layout);
        this.aXh = (LinearLayout) view.findViewById(i.f.new_year_color_egg);
        this.aSY = (HeadImageView) view.findViewById(i.f.frs_photo);
        this.aSX = (UserIconBox) view.findViewById(i.f.frs_user_tshow_icon_box);
        this.aXi = (UserIconBox) view.findViewById(i.f.frs_user_icon_box);
        this.aSW = (TextView) view.findViewById(i.f.frs_lv_author);
        this.aSV = (TextView) view.findViewById(i.f.frs_lv_reply_time);
        this.aPf = (TextView) view.findViewById(i.f.frs_lv_title);
        this.aSS = (TextView) view.findViewById(i.f.abstract_text);
        this.aST = (PlayVoiceBnt) view.findViewById(i.f.abstract_voice);
        this.aSU = (FrsCommonImageLayout) view.findViewById(i.f.abstract_img_layout);
        this.aTb = (TextView) view.findViewById(i.f.frs_praise_num);
        this.aXj = (TextView) view.findViewById(i.f.action_button);
        this.aTd = (TextView) view.findViewById(i.f.frs_reply_num);
        this.aTf = (TextView) view.findViewById(i.f.frs_more_abstract);
        this.aXl = (TextView) view.findViewById(i.f.frs_item_location_address);
        this.aXm = view.findViewById(i.f.frs_item_location_sep);
        this.aSQ.setBackgroundResource(i.c.transparent);
        this.aSQ.setPadding(0, i, 0, 0);
    }
}
