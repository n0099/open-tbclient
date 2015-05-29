package com.baidu.tieba.frs;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
/* loaded from: classes.dex */
public class bv extends com.baidu.adp.widget.ListView.am {
    public TextView aKB;
    public TextView aKD;
    public TextView aKF;
    public LinearLayout aKH;
    public LinearLayout aKq;
    public LinearLayout aKr;
    public TextView aKs;
    public PlayVoiceBnt aKt;
    public FrsCommonImageLayout aKu;
    public TextView aKv;
    public TextView aKw;
    public UserIconBox aKx;
    public HeadImageView aKy;
    public bu aOA;
    public TextView aOB;
    public View aOC;
    public LinearLayout aOy;
    public TextView aOz;
    public int ajy;
    public TextView mTitle;

    public bv(View view, int i) {
        super(view);
        this.ajy = -1;
        this.aKq = (LinearLayout) view.findViewById(com.baidu.tieba.q.frs_list);
        this.aKH = (LinearLayout) view.findViewById(com.baidu.tieba.q.frs_item_user_info_view);
        this.aKr = (LinearLayout) view.findViewById(com.baidu.tieba.q.frs_list_item_top_linear_layout);
        this.aOy = (LinearLayout) view.findViewById(com.baidu.tieba.q.new_year_color_egg);
        this.aKy = (HeadImageView) view.findViewById(com.baidu.tieba.q.frs_photo);
        this.aKx = (UserIconBox) view.findViewById(com.baidu.tieba.q.frs_user_tshow_icon_box);
        this.aKw = (TextView) view.findViewById(com.baidu.tieba.q.frs_lv_author);
        this.aKv = (TextView) view.findViewById(com.baidu.tieba.q.frs_lv_reply_time);
        this.mTitle = (TextView) view.findViewById(com.baidu.tieba.q.frs_lv_title);
        this.aKs = (TextView) view.findViewById(com.baidu.tieba.q.abstract_text);
        this.aKt = (PlayVoiceBnt) view.findViewById(com.baidu.tieba.q.abstract_voice);
        this.aKu = (FrsCommonImageLayout) view.findViewById(com.baidu.tieba.q.abstract_img_layout);
        this.aKB = (TextView) view.findViewById(com.baidu.tieba.q.frs_praise_num);
        this.aOz = (TextView) view.findViewById(com.baidu.tieba.q.action_button);
        this.aKD = (TextView) view.findViewById(com.baidu.tieba.q.frs_reply_num);
        this.aKF = (TextView) view.findViewById(com.baidu.tieba.q.frs_more_abstract);
        this.aOB = (TextView) view.findViewById(com.baidu.tieba.q.frs_item_location_address);
        this.aOC = view.findViewById(com.baidu.tieba.q.frs_item_location_sep);
        this.aKq.setBackgroundResource(com.baidu.tieba.n.transparent);
        this.aKq.setPadding(0, i, 0, 0);
    }
}
