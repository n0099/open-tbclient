package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class k extends q.a {
    public ImageView dDR;
    public TextView dDS;
    public TextView dEQ;
    public TextView dER;
    public TextView dES;
    public LinearLayout dET;
    public TextView dEU;
    public NoPressedLinearLayout dEV;
    public View dEW;
    public View dEX;
    public View dEY;
    public TextView dEZ;
    public TextView dFa;
    public View mDivider;

    public k(View view, View.OnClickListener onClickListener) {
        super(view);
        this.dEQ = (TextView) view.findViewById(e.g.like_btn);
        this.dER = (TextView) view.findViewById(e.g.lever_tip_view);
        this.dDR = (ImageView) view.findViewById(e.g.header_level_img);
        this.dDS = (TextView) view.findViewById(e.g.user_level_name);
        this.dES = (TextView) view.findViewById(e.g.detail_tip_view);
        this.mDivider = view.findViewById(e.g.header_divider_line2);
        this.dET = (LinearLayout) view.findViewById(e.g.view_experience_score);
        this.dEU = (TextView) view.findViewById(e.g.tip_experience_score);
        this.dEV = (NoPressedLinearLayout) view.findViewById(e.g.root_forum_member_header);
        this.dEW = view.findViewById(e.g.divider_top);
        this.dEX = view.findViewById(e.g.header_divider_line1);
        this.dEY = view.findViewById(e.g.header_divider_line3);
        this.dEZ = (TextView) view.findViewById(e.g.tip_in_forum);
        this.dFa = (TextView) view.findViewById(e.g.tip_experience);
        this.dEQ.setOnClickListener(onClickListener);
        this.dES.setOnClickListener(onClickListener);
    }
}
