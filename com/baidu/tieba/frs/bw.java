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
    public LinearLayout aIi;
    public LinearLayout aIj;
    public TextView aIk;
    public PlayVoiceBnt aIl;
    public FrsCommonImageLayout aIm;
    public TextView aIn;
    public TextView aIo;
    public UserIconBox aIp;
    public HeadImageView aIq;
    public TextView aIt;
    public TextView aIv;
    public TextView aIx;
    public LinearLayout aIz;
    public LinearLayout aMo;
    public TextView aMp;
    public bv aMq;
    public TextView aMr;
    public View aMs;
    public int aiy;
    public TextView mTitle;

    public bw(View view, int i) {
        super(view);
        this.aiy = -1;
        this.aIi = (LinearLayout) view.findViewById(com.baidu.tieba.v.frs_list);
        this.aIz = (LinearLayout) view.findViewById(com.baidu.tieba.v.frs_item_user_info_view);
        this.aIj = (LinearLayout) view.findViewById(com.baidu.tieba.v.frs_list_item_top_linear_layout);
        this.aMo = (LinearLayout) view.findViewById(com.baidu.tieba.v.new_year_color_egg);
        this.aIq = (HeadImageView) view.findViewById(com.baidu.tieba.v.frs_photo);
        this.aIp = (UserIconBox) view.findViewById(com.baidu.tieba.v.frs_user_tshow_icon_box);
        this.aIo = (TextView) view.findViewById(com.baidu.tieba.v.frs_lv_author);
        this.aIn = (TextView) view.findViewById(com.baidu.tieba.v.frs_lv_reply_time);
        this.mTitle = (TextView) view.findViewById(com.baidu.tieba.v.frs_lv_title);
        this.aIk = (TextView) view.findViewById(com.baidu.tieba.v.abstract_text);
        this.aIl = (PlayVoiceBnt) view.findViewById(com.baidu.tieba.v.abstract_voice);
        this.aIm = (FrsCommonImageLayout) view.findViewById(com.baidu.tieba.v.abstract_img_layout);
        this.aIt = (TextView) view.findViewById(com.baidu.tieba.v.frs_praise_num);
        this.aMp = (TextView) view.findViewById(com.baidu.tieba.v.action_button);
        this.aIv = (TextView) view.findViewById(com.baidu.tieba.v.frs_reply_num);
        this.aIx = (TextView) view.findViewById(com.baidu.tieba.v.frs_more_abstract);
        this.aMr = (TextView) view.findViewById(com.baidu.tieba.v.frs_item_location_address);
        this.aMs = view.findViewById(com.baidu.tieba.v.frs_item_location_sep);
        this.aIi.setBackgroundResource(com.baidu.tieba.s.transparent);
        this.aIi.setPadding(0, i, 0, 0);
    }
}
