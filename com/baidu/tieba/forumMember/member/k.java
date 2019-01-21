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
    public ImageView dHp;
    public TextView dHq;
    public TextView dIo;
    public TextView dIp;
    public TextView dIq;
    public LinearLayout dIr;
    public TextView dIs;
    public NoPressedLinearLayout dIt;
    public View dIu;
    public View dIv;
    public View dIw;
    public TextView dIx;
    public TextView dIy;
    public View mDivider;

    public k(View view, View.OnClickListener onClickListener) {
        super(view);
        this.dIo = (TextView) view.findViewById(e.g.like_btn);
        this.dIp = (TextView) view.findViewById(e.g.lever_tip_view);
        this.dHp = (ImageView) view.findViewById(e.g.header_level_img);
        this.dHq = (TextView) view.findViewById(e.g.user_level_name);
        this.dIq = (TextView) view.findViewById(e.g.detail_tip_view);
        this.mDivider = view.findViewById(e.g.header_divider_line2);
        this.dIr = (LinearLayout) view.findViewById(e.g.view_experience_score);
        this.dIs = (TextView) view.findViewById(e.g.tip_experience_score);
        this.dIt = (NoPressedLinearLayout) view.findViewById(e.g.root_forum_member_header);
        this.dIu = view.findViewById(e.g.divider_top);
        this.dIv = view.findViewById(e.g.header_divider_line1);
        this.dIw = view.findViewById(e.g.header_divider_line3);
        this.dIx = (TextView) view.findViewById(e.g.tip_in_forum);
        this.dIy = (TextView) view.findViewById(e.g.tip_experience);
        this.dIo.setOnClickListener(onClickListener);
        this.dIq.setOnClickListener(onClickListener);
    }
}
