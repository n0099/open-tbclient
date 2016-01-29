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
/* loaded from: classes.dex */
public class ej extends x.a {
    public TextView aPr;
    public UserIconBox ahI;
    public UserIconBox ahJ;
    public int ahU;
    public TextView ahm;
    public TextView ahn;
    public LinearLayout beO;
    public LinearLayout beP;
    public TextView beQ;
    public TextView beT;
    public HeadImageView beU;
    public TextView beY;
    public TextView biV;
    public RelativeLayout bkl;
    public RelativeLayout bko;
    public LinearLayout bkp;
    public LinearLayout bkq;
    public LinearLayout bkr;
    public View bks;
    public TbImageView blo;
    public TbImageView blp;

    public ej(View view, int i) {
        super(view);
        this.ahU = 3;
        this.beO = (LinearLayout) view.findViewById(t.g.frs_star_interview_list);
        this.beP = (LinearLayout) view.findViewById(t.g.frs_list_star_interview_item_top_linear_layout);
        this.bkl = (RelativeLayout) view.findViewById(t.g.frs_list_star_interview_item_top_card);
        this.bko = (RelativeLayout) view.findViewById(t.g.frs_item_user_info_view);
        this.bkp = (LinearLayout) view.findViewById(t.g.frs_item_base_user_info);
        this.blp = (TbImageView) view.findViewById(t.g.frs_list_star_interview_topimage);
        this.blo = (TbImageView) view.findViewById(t.g.abstract_imge);
        this.beU = (HeadImageView) view.findViewById(t.g.frs_photo);
        this.ahI = (UserIconBox) view.findViewById(t.g.frs_user_tshow_icon_box);
        this.ahJ = (UserIconBox) view.findViewById(t.g.frs_user_icon_box);
        this.beT = (TextView) view.findViewById(t.g.frs_lv_author);
        this.ahm = (TextView) view.findViewById(t.g.frs_lv_reply_time);
        this.aPr = (TextView) view.findViewById(t.g.frs_lv_interview_title);
        this.beQ = (TextView) view.findViewById(t.g.abstract_text);
        this.ahn = (TextView) view.findViewById(t.g.frs_praise_num);
        this.beY = (TextView) view.findViewById(t.g.frs_reply_num);
        this.bkq = (LinearLayout) view.findViewById(t.g.frs_item_num);
        this.bkr = (LinearLayout) view.findViewById(t.g.frs_item_loc_view);
        this.biV = (TextView) view.findViewById(t.g.frs_item_location_address);
        this.bks = view.findViewById(t.g.frs_item_location_sep);
        this.beO.setBackgroundResource(t.d.transparent);
        this.beO.setPadding(0, i, 0, 0);
    }
}
