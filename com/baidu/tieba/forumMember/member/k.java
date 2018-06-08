package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class k extends q.a {
    public View bFh;
    public TextView ddA;
    public ImageView ddz;
    public TextView deA;
    public TextView deB;
    public LinearLayout deC;
    public TextView deD;
    public NoPressedLinearLayout deE;
    public View deF;
    public View deG;
    public View deH;
    public TextView deI;
    public TextView deJ;
    public TextView dez;

    public k(View view, View.OnClickListener onClickListener) {
        super(view);
        this.dez = (TextView) view.findViewById(d.g.like_btn);
        this.deA = (TextView) view.findViewById(d.g.lever_tip_view);
        this.ddz = (ImageView) view.findViewById(d.g.header_level_img);
        this.ddA = (TextView) view.findViewById(d.g.user_level_name);
        this.deB = (TextView) view.findViewById(d.g.detail_tip_view);
        this.bFh = view.findViewById(d.g.header_divider_line2);
        this.deC = (LinearLayout) view.findViewById(d.g.view_experience_score);
        this.deD = (TextView) view.findViewById(d.g.tip_experience_score);
        this.deE = (NoPressedLinearLayout) view.findViewById(d.g.root_forum_member_header);
        this.deF = view.findViewById(d.g.divider_top);
        this.deG = view.findViewById(d.g.header_divider_line1);
        this.deH = view.findViewById(d.g.header_divider_line3);
        this.deI = (TextView) view.findViewById(d.g.tip_in_forum);
        this.deJ = (TextView) view.findViewById(d.g.tip_experience);
        this.dez.setOnClickListener(onClickListener);
        this.deB.setOnClickListener(onClickListener);
    }
}
