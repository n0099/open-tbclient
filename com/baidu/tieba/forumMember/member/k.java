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
    public View bwn;
    public ImageView cTm;
    public TextView cTn;
    public TextView cUj;
    public TextView cUk;
    public TextView cUl;
    public LinearLayout cUm;
    public TextView cUn;
    public NoPressedLinearLayout cUo;
    public View cUp;
    public View cUq;
    public View cUr;
    public TextView cUs;
    public TextView cUt;

    public k(View view2, View.OnClickListener onClickListener) {
        super(view2);
        this.cUj = (TextView) view2.findViewById(d.g.like_btn);
        this.cUk = (TextView) view2.findViewById(d.g.lever_tip_view);
        this.cTm = (ImageView) view2.findViewById(d.g.header_level_img);
        this.cTn = (TextView) view2.findViewById(d.g.user_level_name);
        this.cUl = (TextView) view2.findViewById(d.g.detail_tip_view);
        this.bwn = view2.findViewById(d.g.header_divider_line2);
        this.cUm = (LinearLayout) view2.findViewById(d.g.view_experience_score);
        this.cUn = (TextView) view2.findViewById(d.g.tip_experience_score);
        this.cUo = (NoPressedLinearLayout) view2.findViewById(d.g.root_forum_member_header);
        this.cUp = view2.findViewById(d.g.divider_top);
        this.cUq = view2.findViewById(d.g.header_divider_line1);
        this.cUr = view2.findViewById(d.g.header_divider_line3);
        this.cUs = (TextView) view2.findViewById(d.g.tip_in_forum);
        this.cUt = (TextView) view2.findViewById(d.g.tip_experience);
        this.cUj.setOnClickListener(onClickListener);
        this.cUl.setOnClickListener(onClickListener);
    }
}
