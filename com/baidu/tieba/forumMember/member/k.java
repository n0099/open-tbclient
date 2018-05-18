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
    public View bxe;
    public ImageView cUq;
    public TextView cUr;
    public TextView cVn;
    public TextView cVo;
    public TextView cVp;
    public LinearLayout cVq;
    public TextView cVr;
    public NoPressedLinearLayout cVs;
    public View cVt;
    public View cVu;
    public View cVv;
    public TextView cVw;
    public TextView cVx;

    public k(View view2, View.OnClickListener onClickListener) {
        super(view2);
        this.cVn = (TextView) view2.findViewById(d.g.like_btn);
        this.cVo = (TextView) view2.findViewById(d.g.lever_tip_view);
        this.cUq = (ImageView) view2.findViewById(d.g.header_level_img);
        this.cUr = (TextView) view2.findViewById(d.g.user_level_name);
        this.cVp = (TextView) view2.findViewById(d.g.detail_tip_view);
        this.bxe = view2.findViewById(d.g.header_divider_line2);
        this.cVq = (LinearLayout) view2.findViewById(d.g.view_experience_score);
        this.cVr = (TextView) view2.findViewById(d.g.tip_experience_score);
        this.cVs = (NoPressedLinearLayout) view2.findViewById(d.g.root_forum_member_header);
        this.cVt = view2.findViewById(d.g.divider_top);
        this.cVu = view2.findViewById(d.g.header_divider_line1);
        this.cVv = view2.findViewById(d.g.header_divider_line3);
        this.cVw = (TextView) view2.findViewById(d.g.tip_in_forum);
        this.cVx = (TextView) view2.findViewById(d.g.tip_experience);
        this.cVn.setOnClickListener(onClickListener);
        this.cVp.setOnClickListener(onClickListener);
    }
}
