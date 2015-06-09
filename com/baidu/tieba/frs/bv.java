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
    public TextView aKC;
    public TextView aKE;
    public TextView aKG;
    public LinearLayout aKI;
    public LinearLayout aKr;
    public LinearLayout aKs;
    public TextView aKt;
    public PlayVoiceBnt aKu;
    public FrsCommonImageLayout aKv;
    public TextView aKw;
    public TextView aKx;
    public UserIconBox aKy;
    public HeadImageView aKz;
    public TextView aOA;
    public bu aOB;
    public TextView aOC;
    public View aOD;
    public LinearLayout aOz;
    public int ajy;
    public TextView mTitle;

    public bv(View view, int i) {
        super(view);
        this.ajy = -1;
        this.aKr = (LinearLayout) view.findViewById(com.baidu.tieba.q.frs_list);
        this.aKI = (LinearLayout) view.findViewById(com.baidu.tieba.q.frs_item_user_info_view);
        this.aKs = (LinearLayout) view.findViewById(com.baidu.tieba.q.frs_list_item_top_linear_layout);
        this.aOz = (LinearLayout) view.findViewById(com.baidu.tieba.q.new_year_color_egg);
        this.aKz = (HeadImageView) view.findViewById(com.baidu.tieba.q.frs_photo);
        this.aKy = (UserIconBox) view.findViewById(com.baidu.tieba.q.frs_user_tshow_icon_box);
        this.aKx = (TextView) view.findViewById(com.baidu.tieba.q.frs_lv_author);
        this.aKw = (TextView) view.findViewById(com.baidu.tieba.q.frs_lv_reply_time);
        this.mTitle = (TextView) view.findViewById(com.baidu.tieba.q.frs_lv_title);
        this.aKt = (TextView) view.findViewById(com.baidu.tieba.q.abstract_text);
        this.aKu = (PlayVoiceBnt) view.findViewById(com.baidu.tieba.q.abstract_voice);
        this.aKv = (FrsCommonImageLayout) view.findViewById(com.baidu.tieba.q.abstract_img_layout);
        this.aKC = (TextView) view.findViewById(com.baidu.tieba.q.frs_praise_num);
        this.aOA = (TextView) view.findViewById(com.baidu.tieba.q.action_button);
        this.aKE = (TextView) view.findViewById(com.baidu.tieba.q.frs_reply_num);
        this.aKG = (TextView) view.findViewById(com.baidu.tieba.q.frs_more_abstract);
        this.aOC = (TextView) view.findViewById(com.baidu.tieba.q.frs_item_location_address);
        this.aOD = view.findViewById(com.baidu.tieba.q.frs_item_location_sep);
        this.aKr.setBackgroundResource(com.baidu.tieba.n.transparent);
        this.aKr.setPadding(0, i, 0, 0);
    }
}
