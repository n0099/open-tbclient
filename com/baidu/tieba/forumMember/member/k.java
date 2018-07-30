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
    public View bHR;
    public ImageView dih;
    public TextView dii;
    public TextView djg;
    public TextView djh;
    public TextView dji;
    public LinearLayout djj;
    public TextView djk;
    public NoPressedLinearLayout djl;
    public View djm;
    public View djn;
    public View djo;
    public TextView djp;
    public TextView djq;

    public k(View view, View.OnClickListener onClickListener) {
        super(view);
        this.djg = (TextView) view.findViewById(d.g.like_btn);
        this.djh = (TextView) view.findViewById(d.g.lever_tip_view);
        this.dih = (ImageView) view.findViewById(d.g.header_level_img);
        this.dii = (TextView) view.findViewById(d.g.user_level_name);
        this.dji = (TextView) view.findViewById(d.g.detail_tip_view);
        this.bHR = view.findViewById(d.g.header_divider_line2);
        this.djj = (LinearLayout) view.findViewById(d.g.view_experience_score);
        this.djk = (TextView) view.findViewById(d.g.tip_experience_score);
        this.djl = (NoPressedLinearLayout) view.findViewById(d.g.root_forum_member_header);
        this.djm = view.findViewById(d.g.divider_top);
        this.djn = view.findViewById(d.g.header_divider_line1);
        this.djo = view.findViewById(d.g.header_divider_line3);
        this.djp = (TextView) view.findViewById(d.g.tip_in_forum);
        this.djq = (TextView) view.findViewById(d.g.tip_experience);
        this.djg.setOnClickListener(onClickListener);
        this.dji.setOnClickListener(onClickListener);
    }
}
