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
    public TextView aPy;
    public LinearLayout aTA;
    public LinearLayout aTj;
    public LinearLayout aTk;
    public TextView aTl;
    public PlayVoiceBnt aTm;
    public FrsCommonImageLayout aTn;
    public TextView aTo;
    public TextView aTp;
    public UserIconBox aTq;
    public HeadImageView aTr;
    public TextView aTu;
    public TextView aTw;
    public TextView aTy;
    public LinearLayout aXB;
    public UserIconBox aXC;
    public TextView aXD;
    public cf.a aXE;
    public TextView aXF;
    public View aXG;
    public int arf;

    public cl(View view, int i) {
        super(view);
        this.arf = 3;
        this.aTj = (LinearLayout) view.findViewById(i.f.frs_list);
        this.aTA = (LinearLayout) view.findViewById(i.f.frs_item_user_info_view);
        this.aTk = (LinearLayout) view.findViewById(i.f.frs_list_item_top_linear_layout);
        this.aXB = (LinearLayout) view.findViewById(i.f.new_year_color_egg);
        this.aTr = (HeadImageView) view.findViewById(i.f.frs_photo);
        this.aTq = (UserIconBox) view.findViewById(i.f.frs_user_tshow_icon_box);
        this.aXC = (UserIconBox) view.findViewById(i.f.frs_user_icon_box);
        this.aTp = (TextView) view.findViewById(i.f.frs_lv_author);
        this.aTo = (TextView) view.findViewById(i.f.frs_lv_reply_time);
        this.aPy = (TextView) view.findViewById(i.f.frs_lv_title);
        this.aTl = (TextView) view.findViewById(i.f.abstract_text);
        this.aTm = (PlayVoiceBnt) view.findViewById(i.f.abstract_voice);
        this.aTn = (FrsCommonImageLayout) view.findViewById(i.f.abstract_img_layout);
        this.aTu = (TextView) view.findViewById(i.f.frs_praise_num);
        this.aXD = (TextView) view.findViewById(i.f.action_button);
        this.aTw = (TextView) view.findViewById(i.f.frs_reply_num);
        this.aTy = (TextView) view.findViewById(i.f.frs_more_abstract);
        this.aXF = (TextView) view.findViewById(i.f.frs_item_location_address);
        this.aXG = view.findViewById(i.f.frs_item_location_sep);
        this.aTj.setBackgroundResource(i.c.transparent);
        this.aTj.setPadding(0, i, 0, 0);
    }
}
