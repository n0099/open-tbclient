package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class k extends q.a {
    public View bHR;
    public ImageView dif;
    public TextView dig;
    public TextView dje;
    public TextView djf;
    public TextView djg;
    public LinearLayout djh;
    public TextView dji;
    public NoPressedLinearLayout djj;
    public View djk;
    public View djl;
    public View djm;
    public TextView djn;
    public TextView djo;

    public k(View view, View.OnClickListener onClickListener) {
        super(view);
        this.dje = (TextView) view.findViewById(f.g.like_btn);
        this.djf = (TextView) view.findViewById(f.g.lever_tip_view);
        this.dif = (ImageView) view.findViewById(f.g.header_level_img);
        this.dig = (TextView) view.findViewById(f.g.user_level_name);
        this.djg = (TextView) view.findViewById(f.g.detail_tip_view);
        this.bHR = view.findViewById(f.g.header_divider_line2);
        this.djh = (LinearLayout) view.findViewById(f.g.view_experience_score);
        this.dji = (TextView) view.findViewById(f.g.tip_experience_score);
        this.djj = (NoPressedLinearLayout) view.findViewById(f.g.root_forum_member_header);
        this.djk = view.findViewById(f.g.divider_top);
        this.djl = view.findViewById(f.g.header_divider_line1);
        this.djm = view.findViewById(f.g.header_divider_line3);
        this.djn = (TextView) view.findViewById(f.g.tip_in_forum);
        this.djo = (TextView) view.findViewById(f.g.tip_experience);
        this.dje.setOnClickListener(onClickListener);
        this.djg.setOnClickListener(onClickListener);
    }
}
