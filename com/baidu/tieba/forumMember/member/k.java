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
    public ImageView dHo;
    public TextView dHp;
    public TextView dIn;
    public TextView dIo;
    public TextView dIp;
    public LinearLayout dIq;
    public TextView dIr;
    public NoPressedLinearLayout dIs;
    public View dIt;
    public View dIu;
    public View dIv;
    public TextView dIw;
    public TextView dIx;
    public View mDivider;

    public k(View view, View.OnClickListener onClickListener) {
        super(view);
        this.dIn = (TextView) view.findViewById(e.g.like_btn);
        this.dIo = (TextView) view.findViewById(e.g.lever_tip_view);
        this.dHo = (ImageView) view.findViewById(e.g.header_level_img);
        this.dHp = (TextView) view.findViewById(e.g.user_level_name);
        this.dIp = (TextView) view.findViewById(e.g.detail_tip_view);
        this.mDivider = view.findViewById(e.g.header_divider_line2);
        this.dIq = (LinearLayout) view.findViewById(e.g.view_experience_score);
        this.dIr = (TextView) view.findViewById(e.g.tip_experience_score);
        this.dIs = (NoPressedLinearLayout) view.findViewById(e.g.root_forum_member_header);
        this.dIt = view.findViewById(e.g.divider_top);
        this.dIu = view.findViewById(e.g.header_divider_line1);
        this.dIv = view.findViewById(e.g.header_divider_line3);
        this.dIw = (TextView) view.findViewById(e.g.tip_in_forum);
        this.dIx = (TextView) view.findViewById(e.g.tip_experience);
        this.dIn.setOnClickListener(onClickListener);
        this.dIp.setOnClickListener(onClickListener);
    }
}
