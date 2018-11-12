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
    public ImageView dxs;
    public TextView dxt;
    public TextView dyA;
    public TextView dyB;
    public TextView dyr;
    public TextView dys;
    public TextView dyt;
    public LinearLayout dyu;
    public TextView dyv;
    public NoPressedLinearLayout dyw;
    public View dyx;
    public View dyy;
    public View dyz;
    public View mDivider;

    public k(View view, View.OnClickListener onClickListener) {
        super(view);
        this.dyr = (TextView) view.findViewById(e.g.like_btn);
        this.dys = (TextView) view.findViewById(e.g.lever_tip_view);
        this.dxs = (ImageView) view.findViewById(e.g.header_level_img);
        this.dxt = (TextView) view.findViewById(e.g.user_level_name);
        this.dyt = (TextView) view.findViewById(e.g.detail_tip_view);
        this.mDivider = view.findViewById(e.g.header_divider_line2);
        this.dyu = (LinearLayout) view.findViewById(e.g.view_experience_score);
        this.dyv = (TextView) view.findViewById(e.g.tip_experience_score);
        this.dyw = (NoPressedLinearLayout) view.findViewById(e.g.root_forum_member_header);
        this.dyx = view.findViewById(e.g.divider_top);
        this.dyy = view.findViewById(e.g.header_divider_line1);
        this.dyz = view.findViewById(e.g.header_divider_line3);
        this.dyA = (TextView) view.findViewById(e.g.tip_in_forum);
        this.dyB = (TextView) view.findViewById(e.g.tip_experience);
        this.dyr.setOnClickListener(onClickListener);
        this.dyt.setOnClickListener(onClickListener);
    }
}
