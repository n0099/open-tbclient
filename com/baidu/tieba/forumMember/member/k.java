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
    public ImageView cTj;
    public TextView cTk;
    public TextView cUg;
    public TextView cUh;
    public TextView cUi;
    public LinearLayout cUj;
    public TextView cUk;
    public NoPressedLinearLayout cUl;
    public View cUm;
    public View cUn;
    public View cUo;
    public TextView cUp;
    public TextView cUq;

    public k(View view2, View.OnClickListener onClickListener) {
        super(view2);
        this.cUg = (TextView) view2.findViewById(d.g.like_btn);
        this.cUh = (TextView) view2.findViewById(d.g.lever_tip_view);
        this.cTj = (ImageView) view2.findViewById(d.g.header_level_img);
        this.cTk = (TextView) view2.findViewById(d.g.user_level_name);
        this.cUi = (TextView) view2.findViewById(d.g.detail_tip_view);
        this.bwn = view2.findViewById(d.g.header_divider_line2);
        this.cUj = (LinearLayout) view2.findViewById(d.g.view_experience_score);
        this.cUk = (TextView) view2.findViewById(d.g.tip_experience_score);
        this.cUl = (NoPressedLinearLayout) view2.findViewById(d.g.root_forum_member_header);
        this.cUm = view2.findViewById(d.g.divider_top);
        this.cUn = view2.findViewById(d.g.header_divider_line1);
        this.cUo = view2.findViewById(d.g.header_divider_line3);
        this.cUp = (TextView) view2.findViewById(d.g.tip_in_forum);
        this.cUq = (TextView) view2.findViewById(d.g.tip_experience);
        this.cUg.setOnClickListener(onClickListener);
        this.cUi.setOnClickListener(onClickListener);
    }
}
