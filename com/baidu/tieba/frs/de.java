package com.baidu.tieba.frs;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tieba.frs.cy;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
/* loaded from: classes.dex */
public class de extends x.a {
    public TextView aOn;
    public UserIconBox agT;
    public UserIconBox agU;
    public TextView agy;
    public TextView agz;
    public int ahf;
    public FrsCommonImageLayout bcA;
    public TextView bcB;
    public HeadImageView bcC;
    public TextView bcG;
    public TextView bcI;
    public LinearLayout bcw;
    public LinearLayout bcx;
    public TextView bcy;
    public PlayVoiceBnt bcz;
    public TextView bgj;
    public View bgk;
    public TextView bhA;
    public RelativeLayout bhB;
    public LinearLayout bhC;
    public LinearLayout bhD;
    public cy.a bhE;
    public RelativeLayout bhy;
    public LinearLayout bhz;

    public de(View view, int i) {
        super(view);
        this.ahf = 3;
        this.bcw = (LinearLayout) view.findViewById(n.g.frs_list);
        this.bhB = (RelativeLayout) view.findViewById(n.g.frs_item_user_info_view);
        this.bcx = (LinearLayout) view.findViewById(n.g.frs_list_item_top_linear_layout);
        this.bhy = (RelativeLayout) view.findViewById(n.g.frs_list_item_top_card);
        this.bhz = (LinearLayout) view.findViewById(n.g.new_year_color_egg);
        this.bcC = (HeadImageView) view.findViewById(n.g.frs_photo);
        this.agT = (UserIconBox) view.findViewById(n.g.frs_user_tshow_icon_box);
        this.agU = (UserIconBox) view.findViewById(n.g.frs_user_icon_box);
        this.bcB = (TextView) view.findViewById(n.g.frs_lv_author);
        this.agy = (TextView) view.findViewById(n.g.frs_lv_reply_time);
        this.aOn = (TextView) view.findViewById(n.g.frs_lv_title);
        this.bcy = (TextView) view.findViewById(n.g.abstract_text);
        this.bcz = (PlayVoiceBnt) view.findViewById(n.g.abstract_voice);
        this.bcA = (FrsCommonImageLayout) view.findViewById(n.g.abstract_img_layout);
        this.agz = (TextView) view.findViewById(n.g.frs_praise_num);
        this.bhA = (TextView) view.findViewById(n.g.action_button);
        this.bcG = (TextView) view.findViewById(n.g.frs_reply_num);
        this.bcI = (TextView) view.findViewById(n.g.frs_more_abstract);
        this.bhC = (LinearLayout) view.findViewById(n.g.frs_item_num);
        this.bhD = (LinearLayout) view.findViewById(n.g.frs_item_loc_view);
        this.bgj = (TextView) view.findViewById(n.g.frs_item_location_address);
        this.bgk = view.findViewById(n.g.frs_item_location_sep);
        this.bcw.setBackgroundResource(n.d.transparent);
        this.bcw.setPadding(0, i, 0, 0);
    }
}
