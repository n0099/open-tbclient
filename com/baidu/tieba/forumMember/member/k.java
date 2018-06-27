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
    public View bHc;
    public ImageView dfr;
    public TextView dfs;
    public TextView dgA;
    public TextView dgq;
    public TextView dgr;
    public TextView dgs;
    public LinearLayout dgt;
    public TextView dgu;
    public NoPressedLinearLayout dgv;
    public View dgw;
    public View dgx;
    public View dgy;
    public TextView dgz;

    public k(View view, View.OnClickListener onClickListener) {
        super(view);
        this.dgq = (TextView) view.findViewById(d.g.like_btn);
        this.dgr = (TextView) view.findViewById(d.g.lever_tip_view);
        this.dfr = (ImageView) view.findViewById(d.g.header_level_img);
        this.dfs = (TextView) view.findViewById(d.g.user_level_name);
        this.dgs = (TextView) view.findViewById(d.g.detail_tip_view);
        this.bHc = view.findViewById(d.g.header_divider_line2);
        this.dgt = (LinearLayout) view.findViewById(d.g.view_experience_score);
        this.dgu = (TextView) view.findViewById(d.g.tip_experience_score);
        this.dgv = (NoPressedLinearLayout) view.findViewById(d.g.root_forum_member_header);
        this.dgw = view.findViewById(d.g.divider_top);
        this.dgx = view.findViewById(d.g.header_divider_line1);
        this.dgy = view.findViewById(d.g.header_divider_line3);
        this.dgz = (TextView) view.findViewById(d.g.tip_in_forum);
        this.dgA = (TextView) view.findViewById(d.g.tip_experience);
        this.dgq.setOnClickListener(onClickListener);
        this.dgs.setOnClickListener(onClickListener);
    }
}
