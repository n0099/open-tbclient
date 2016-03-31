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
public class er extends x.a {
    public TextView aSh;
    public UserIconBox ahN;
    public UserIconBox ahO;
    public TextView ahr;
    public TextView ahs;
    public int aik;
    public LinearLayout bjA;
    public LinearLayout bjB;
    public TextView bjC;
    public TextView bjF;
    public HeadImageView bjG;
    public TextView bjK;
    public TextView bnF;
    public RelativeLayout bpA;
    public RelativeLayout bpD;
    public LinearLayout bpE;
    public LinearLayout bpF;
    public LinearLayout bpG;
    public View bpH;
    public TbImageView bqG;
    public TbImageView bqH;

    public er(View view, int i) {
        super(view);
        this.aik = 3;
        this.bjA = (LinearLayout) view.findViewById(t.g.frs_star_interview_list);
        this.bjB = (LinearLayout) view.findViewById(t.g.frs_list_star_interview_item_top_linear_layout);
        this.bpA = (RelativeLayout) view.findViewById(t.g.frs_list_star_interview_item_top_card);
        this.bpD = (RelativeLayout) view.findViewById(t.g.frs_item_user_info_view);
        this.bpE = (LinearLayout) view.findViewById(t.g.frs_item_base_user_info);
        this.bqH = (TbImageView) view.findViewById(t.g.frs_list_star_interview_topimage);
        this.bqG = (TbImageView) view.findViewById(t.g.abstract_imge);
        this.bjG = (HeadImageView) view.findViewById(t.g.frs_photo);
        this.ahN = (UserIconBox) view.findViewById(t.g.frs_user_tshow_icon_box);
        this.ahO = (UserIconBox) view.findViewById(t.g.frs_user_icon_box);
        this.bjF = (TextView) view.findViewById(t.g.frs_lv_author);
        this.ahr = (TextView) view.findViewById(t.g.frs_lv_reply_time);
        this.aSh = (TextView) view.findViewById(t.g.frs_lv_interview_title);
        this.bjC = (TextView) view.findViewById(t.g.abstract_text);
        this.ahs = (TextView) view.findViewById(t.g.frs_praise_num);
        this.bjK = (TextView) view.findViewById(t.g.frs_reply_num);
        this.bpF = (LinearLayout) view.findViewById(t.g.frs_item_num);
        this.bpG = (LinearLayout) view.findViewById(t.g.frs_item_loc_view);
        this.bnF = (TextView) view.findViewById(t.g.frs_item_location_address);
        this.bpH = view.findViewById(t.g.frs_item_location_sep);
        this.bjA.setBackgroundResource(t.d.transparent);
        this.bjA.setPadding(0, i, 0, 0);
    }
}
