package com.baidu.tieba.frs;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
/* loaded from: classes.dex */
public class bw extends com.baidu.adp.widget.ListView.am {
    public LinearLayout aIa;
    public LinearLayout aIb;
    public TextView aIc;
    public PlayVoiceBnt aId;
    public FrsCommonImageLayout aIe;
    public TextView aIf;
    public TextView aIg;
    public UserIconBox aIh;
    public HeadImageView aIi;
    public TextView aIl;
    public TextView aIn;
    public TextView aIp;
    public LinearLayout aIr;
    public LinearLayout aMd;
    public TextView aMe;
    public bv aMf;
    public TextView aMg;
    public View aMh;
    public int aiq;
    public TextView mTitle;

    public bw(View view, int i) {
        super(view);
        this.aiq = -1;
        this.aIa = (LinearLayout) view.findViewById(com.baidu.tieba.v.frs_list);
        this.aIr = (LinearLayout) view.findViewById(com.baidu.tieba.v.frs_item_user_info_view);
        this.aIb = (LinearLayout) view.findViewById(com.baidu.tieba.v.frs_list_item_top_linear_layout);
        this.aMd = (LinearLayout) view.findViewById(com.baidu.tieba.v.new_year_color_egg);
        this.aIi = (HeadImageView) view.findViewById(com.baidu.tieba.v.frs_photo);
        this.aIh = (UserIconBox) view.findViewById(com.baidu.tieba.v.frs_user_tshow_icon_box);
        this.aIg = (TextView) view.findViewById(com.baidu.tieba.v.frs_lv_author);
        this.aIf = (TextView) view.findViewById(com.baidu.tieba.v.frs_lv_reply_time);
        this.mTitle = (TextView) view.findViewById(com.baidu.tieba.v.frs_lv_title);
        this.aIc = (TextView) view.findViewById(com.baidu.tieba.v.abstract_text);
        this.aId = (PlayVoiceBnt) view.findViewById(com.baidu.tieba.v.abstract_voice);
        this.aIe = (FrsCommonImageLayout) view.findViewById(com.baidu.tieba.v.abstract_img_layout);
        this.aIl = (TextView) view.findViewById(com.baidu.tieba.v.frs_praise_num);
        this.aMe = (TextView) view.findViewById(com.baidu.tieba.v.action_button);
        this.aIn = (TextView) view.findViewById(com.baidu.tieba.v.frs_reply_num);
        this.aIp = (TextView) view.findViewById(com.baidu.tieba.v.frs_more_abstract);
        this.aMg = (TextView) view.findViewById(com.baidu.tieba.v.frs_item_location_address);
        this.aMh = view.findViewById(com.baidu.tieba.v.frs_item_location_sep);
        this.aIa.setBackgroundResource(com.baidu.tieba.s.transparent);
        this.aIa.setPadding(0, i, 0, 0);
    }
}
