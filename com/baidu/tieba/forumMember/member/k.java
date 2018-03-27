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
    public View chO;
    public ImageView dAA;
    public TextView dAB;
    public LinearLayout dBA;
    public TextView dBB;
    public NoPressedLinearLayout dBC;
    public View dBD;
    public View dBE;
    public View dBF;
    public TextView dBG;
    public TextView dBH;
    public TextView dBx;
    public TextView dBy;
    public TextView dBz;

    public k(View view, View.OnClickListener onClickListener) {
        super(view);
        this.dBx = (TextView) view.findViewById(d.g.like_btn);
        this.dBy = (TextView) view.findViewById(d.g.lever_tip_view);
        this.dAA = (ImageView) view.findViewById(d.g.header_level_img);
        this.dAB = (TextView) view.findViewById(d.g.user_level_name);
        this.dBz = (TextView) view.findViewById(d.g.detail_tip_view);
        this.chO = view.findViewById(d.g.header_divider_line2);
        this.dBA = (LinearLayout) view.findViewById(d.g.view_experience_score);
        this.dBB = (TextView) view.findViewById(d.g.tip_experience_score);
        this.dBC = (NoPressedLinearLayout) view.findViewById(d.g.root_forum_member_header);
        this.dBD = view.findViewById(d.g.divider_top);
        this.dBE = view.findViewById(d.g.header_divider_line1);
        this.dBF = view.findViewById(d.g.header_divider_line3);
        this.dBG = (TextView) view.findViewById(d.g.tip_in_forum);
        this.dBH = (TextView) view.findViewById(d.g.tip_experience);
        this.dBx.setOnClickListener(onClickListener);
        this.dBz.setOnClickListener(onClickListener);
    }
}
