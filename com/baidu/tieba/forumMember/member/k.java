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
    public View bNG;
    public ImageView dnX;
    public TextView dnY;
    public TextView doX;
    public TextView doY;
    public TextView doZ;
    public LinearLayout dpa;
    public TextView dpb;
    public NoPressedLinearLayout dpc;
    public View dpd;
    public View dpe;
    public View dpf;
    public TextView dpg;
    public TextView dph;

    public k(View view, View.OnClickListener onClickListener) {
        super(view);
        this.doX = (TextView) view.findViewById(e.g.like_btn);
        this.doY = (TextView) view.findViewById(e.g.lever_tip_view);
        this.dnX = (ImageView) view.findViewById(e.g.header_level_img);
        this.dnY = (TextView) view.findViewById(e.g.user_level_name);
        this.doZ = (TextView) view.findViewById(e.g.detail_tip_view);
        this.bNG = view.findViewById(e.g.header_divider_line2);
        this.dpa = (LinearLayout) view.findViewById(e.g.view_experience_score);
        this.dpb = (TextView) view.findViewById(e.g.tip_experience_score);
        this.dpc = (NoPressedLinearLayout) view.findViewById(e.g.root_forum_member_header);
        this.dpd = view.findViewById(e.g.divider_top);
        this.dpe = view.findViewById(e.g.header_divider_line1);
        this.dpf = view.findViewById(e.g.header_divider_line3);
        this.dpg = (TextView) view.findViewById(e.g.tip_in_forum);
        this.dph = (TextView) view.findViewById(e.g.tip_experience);
        this.doX.setOnClickListener(onClickListener);
        this.doZ.setOnClickListener(onClickListener);
    }
}
