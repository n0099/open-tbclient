package com.baidu.tieba.frs;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
/* loaded from: classes.dex */
public class dj extends x.a {
    public TextView aPr;
    public UserIconBox ahI;
    public UserIconBox ahJ;
    public int ahU;
    public TextView ahm;
    public TextView ahn;
    public LinearLayout beO;
    public LinearLayout beP;
    public TextView beQ;
    public PlayVoiceBnt beR;
    public FrsCommonImageLayout beS;
    public TextView beT;
    public HeadImageView beU;
    public TextView beY;
    public TextView bfa;
    public TextView biV;
    public RelativeLayout bkl;
    public LinearLayout bkm;
    public TextView bkn;
    public RelativeLayout bko;
    public LinearLayout bkp;
    public LinearLayout bkq;
    public LinearLayout bkr;
    public View bks;
    public TbImageView bkt;
    public RelativeLayout bku;
    public TbImageView bkv;
    public TextView bkw;

    public dj(View view, int i) {
        super(view);
        this.ahU = 3;
        this.beO = (LinearLayout) view.findViewById(t.g.frs_list);
        this.bko = (RelativeLayout) view.findViewById(t.g.frs_item_user_info_view);
        this.bkp = (LinearLayout) view.findViewById(t.g.frs_item_base_user_info);
        this.beP = (LinearLayout) view.findViewById(t.g.frs_list_item_top_linear_layout);
        this.bkl = (RelativeLayout) view.findViewById(t.g.frs_list_item_top_card);
        this.bkm = (LinearLayout) view.findViewById(t.g.new_year_color_egg);
        this.beU = (HeadImageView) view.findViewById(t.g.frs_photo);
        this.ahI = (UserIconBox) view.findViewById(t.g.frs_user_tshow_icon_box);
        this.ahJ = (UserIconBox) view.findViewById(t.g.frs_user_icon_box);
        this.beT = (TextView) view.findViewById(t.g.frs_lv_author);
        this.ahm = (TextView) view.findViewById(t.g.frs_lv_reply_time);
        this.aPr = (TextView) view.findViewById(t.g.frs_lv_title);
        this.beQ = (TextView) view.findViewById(t.g.abstract_text);
        this.beR = (PlayVoiceBnt) view.findViewById(t.g.abstract_voice);
        this.beS = (FrsCommonImageLayout) view.findViewById(t.g.abstract_img_layout);
        this.ahn = (TextView) view.findViewById(t.g.frs_praise_num);
        this.bkn = (TextView) view.findViewById(t.g.action_button);
        this.beY = (TextView) view.findViewById(t.g.frs_reply_num);
        this.bfa = (TextView) view.findViewById(t.g.frs_more_abstract);
        this.bkq = (LinearLayout) view.findViewById(t.g.frs_item_num);
        this.bkr = (LinearLayout) view.findViewById(t.g.frs_item_loc_view);
        this.biV = (TextView) view.findViewById(t.g.frs_item_location_address);
        this.bks = view.findViewById(t.g.frs_item_location_sep);
        this.beO.setBackgroundResource(t.d.transparent);
        this.beO.setPadding(0, i, 0, 0);
        this.bkt = (TbImageView) view.findViewById(t.g.game_activity_banner);
        this.bkv = (TbImageView) view.findViewById(t.g.app_code_banner);
        this.bkw = (TextView) view.findViewById(t.g.app_code_btn);
        this.bku = (RelativeLayout) view.findViewById(t.g.app_code_wrapper);
    }
}
