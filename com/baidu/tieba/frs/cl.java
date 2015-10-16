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
    public TextView aPq;
    public LinearLayout aTb;
    public LinearLayout aTc;
    public TextView aTd;
    public PlayVoiceBnt aTe;
    public FrsCommonImageLayout aTf;
    public TextView aTg;
    public TextView aTh;
    public UserIconBox aTi;
    public HeadImageView aTj;
    public TextView aTm;
    public TextView aTo;
    public TextView aTq;
    public LinearLayout aTs;
    public LinearLayout aXs;
    public UserIconBox aXt;
    public TextView aXu;
    public cf.a aXv;
    public TextView aXw;
    public View aXx;
    public int apS;

    public cl(View view, int i) {
        super(view);
        this.apS = 3;
        this.aTb = (LinearLayout) view.findViewById(i.f.frs_list);
        this.aTs = (LinearLayout) view.findViewById(i.f.frs_item_user_info_view);
        this.aTc = (LinearLayout) view.findViewById(i.f.frs_list_item_top_linear_layout);
        this.aXs = (LinearLayout) view.findViewById(i.f.new_year_color_egg);
        this.aTj = (HeadImageView) view.findViewById(i.f.frs_photo);
        this.aTi = (UserIconBox) view.findViewById(i.f.frs_user_tshow_icon_box);
        this.aXt = (UserIconBox) view.findViewById(i.f.frs_user_icon_box);
        this.aTh = (TextView) view.findViewById(i.f.frs_lv_author);
        this.aTg = (TextView) view.findViewById(i.f.frs_lv_reply_time);
        this.aPq = (TextView) view.findViewById(i.f.frs_lv_title);
        this.aTd = (TextView) view.findViewById(i.f.abstract_text);
        this.aTe = (PlayVoiceBnt) view.findViewById(i.f.abstract_voice);
        this.aTf = (FrsCommonImageLayout) view.findViewById(i.f.abstract_img_layout);
        this.aTm = (TextView) view.findViewById(i.f.frs_praise_num);
        this.aXu = (TextView) view.findViewById(i.f.action_button);
        this.aTo = (TextView) view.findViewById(i.f.frs_reply_num);
        this.aTq = (TextView) view.findViewById(i.f.frs_more_abstract);
        this.aXw = (TextView) view.findViewById(i.f.frs_item_location_address);
        this.aXx = view.findViewById(i.f.frs_item_location_sep);
        this.aTb.setBackgroundResource(i.c.transparent);
        this.aTb.setPadding(0, i, 0, 0);
    }
}
