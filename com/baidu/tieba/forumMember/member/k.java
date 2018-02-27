package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class k extends r.a {
    public View chL;
    public ImageView dAx;
    public TextView dAy;
    public View dBA;
    public View dBB;
    public View dBC;
    public TextView dBD;
    public TextView dBE;
    public TextView dBu;
    public TextView dBv;
    public TextView dBw;
    public LinearLayout dBx;
    public TextView dBy;
    public NoPressedLinearLayout dBz;

    public k(View view, View.OnClickListener onClickListener) {
        super(view);
        this.dBu = (TextView) view.findViewById(d.g.like_btn);
        this.dBv = (TextView) view.findViewById(d.g.lever_tip_view);
        this.dAx = (ImageView) view.findViewById(d.g.header_level_img);
        this.dAy = (TextView) view.findViewById(d.g.user_level_name);
        this.dBw = (TextView) view.findViewById(d.g.detail_tip_view);
        this.chL = view.findViewById(d.g.header_divider_line2);
        this.dBx = (LinearLayout) view.findViewById(d.g.view_experience_score);
        this.dBy = (TextView) view.findViewById(d.g.tip_experience_score);
        this.dBz = (NoPressedLinearLayout) view.findViewById(d.g.root_forum_member_header);
        this.dBA = view.findViewById(d.g.divider_top);
        this.dBB = view.findViewById(d.g.header_divider_line1);
        this.dBC = view.findViewById(d.g.header_divider_line3);
        this.dBD = (TextView) view.findViewById(d.g.tip_in_forum);
        this.dBE = (TextView) view.findViewById(d.g.tip_experience);
        this.dBu.setOnClickListener(onClickListener);
        this.dBw.setOnClickListener(onClickListener);
    }
}
