package com.baidu.tieba.frs;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tieba.frs.bz;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
/* loaded from: classes.dex */
public class cf extends x.a {
    public TextView aPV;
    public LinearLayout aTG;
    public LinearLayout aTH;
    public TextView aTI;
    public PlayVoiceBnt aTJ;
    public FrsCommonImageLayout aTK;
    public TextView aTL;
    public TextView aTM;
    public UserIconBox aTN;
    public HeadImageView aTO;
    public TextView aTR;
    public TextView aTT;
    public TextView aTV;
    public LinearLayout aTX;
    public LinearLayout aXS;
    public UserIconBox aXT;
    public TextView aXU;
    public bz.a aXV;
    public TextView aXW;
    public View aXX;
    public int apH;

    public cf(View view, int i) {
        super(view);
        this.apH = -1;
        this.aTG = (LinearLayout) view.findViewById(i.f.frs_list);
        this.aTX = (LinearLayout) view.findViewById(i.f.frs_item_user_info_view);
        this.aTH = (LinearLayout) view.findViewById(i.f.frs_list_item_top_linear_layout);
        this.aXS = (LinearLayout) view.findViewById(i.f.new_year_color_egg);
        this.aTO = (HeadImageView) view.findViewById(i.f.frs_photo);
        this.aTN = (UserIconBox) view.findViewById(i.f.frs_user_tshow_icon_box);
        this.aXT = (UserIconBox) view.findViewById(i.f.frs_user_icon_box);
        this.aTM = (TextView) view.findViewById(i.f.frs_lv_author);
        this.aTL = (TextView) view.findViewById(i.f.frs_lv_reply_time);
        this.aPV = (TextView) view.findViewById(i.f.frs_lv_title);
        this.aTI = (TextView) view.findViewById(i.f.abstract_text);
        this.aTJ = (PlayVoiceBnt) view.findViewById(i.f.abstract_voice);
        this.aTK = (FrsCommonImageLayout) view.findViewById(i.f.abstract_img_layout);
        this.aTR = (TextView) view.findViewById(i.f.frs_praise_num);
        this.aXU = (TextView) view.findViewById(i.f.action_button);
        this.aTT = (TextView) view.findViewById(i.f.frs_reply_num);
        this.aTV = (TextView) view.findViewById(i.f.frs_more_abstract);
        this.aXW = (TextView) view.findViewById(i.f.frs_item_location_address);
        this.aXX = view.findViewById(i.f.frs_item_location_sep);
        this.aTG.setBackgroundResource(i.c.transparent);
        this.aTG.setPadding(0, i, 0, 0);
    }
}
