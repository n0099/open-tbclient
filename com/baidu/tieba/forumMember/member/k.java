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
    public TextView dwZ;
    public ImageView dwa;
    public TextView dwb;
    public TextView dxa;
    public TextView dxb;
    public LinearLayout dxc;
    public TextView dxd;
    public NoPressedLinearLayout dxe;
    public View dxf;
    public View dxg;
    public View dxh;
    public TextView dxi;
    public TextView dxj;
    public View mDivider;

    public k(View view, View.OnClickListener onClickListener) {
        super(view);
        this.dwZ = (TextView) view.findViewById(e.g.like_btn);
        this.dxa = (TextView) view.findViewById(e.g.lever_tip_view);
        this.dwa = (ImageView) view.findViewById(e.g.header_level_img);
        this.dwb = (TextView) view.findViewById(e.g.user_level_name);
        this.dxb = (TextView) view.findViewById(e.g.detail_tip_view);
        this.mDivider = view.findViewById(e.g.header_divider_line2);
        this.dxc = (LinearLayout) view.findViewById(e.g.view_experience_score);
        this.dxd = (TextView) view.findViewById(e.g.tip_experience_score);
        this.dxe = (NoPressedLinearLayout) view.findViewById(e.g.root_forum_member_header);
        this.dxf = view.findViewById(e.g.divider_top);
        this.dxg = view.findViewById(e.g.header_divider_line1);
        this.dxh = view.findViewById(e.g.header_divider_line3);
        this.dxi = (TextView) view.findViewById(e.g.tip_in_forum);
        this.dxj = (TextView) view.findViewById(e.g.tip_experience);
        this.dwZ.setOnClickListener(onClickListener);
        this.dxb.setOnClickListener(onClickListener);
    }
}
