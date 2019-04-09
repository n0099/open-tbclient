package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tieba.d;
/* loaded from: classes5.dex */
public class k extends v.a {
    public View aLf;
    public ImageView eUp;
    public TextView eUq;
    public TextView eVp;
    public TextView eVq;
    public LinearLayout eVr;
    public TextView eVs;
    public NoPressedLinearLayout eVt;
    public View eVu;
    public TextView eVv;
    public ImageView eVw;
    public ImageView eVx;

    public k(View view, View.OnClickListener onClickListener) {
        super(view);
        this.eVp = (TextView) view.findViewById(d.g.like_btn);
        this.eVq = (TextView) view.findViewById(d.g.lever_tip_view);
        this.eUp = (ImageView) view.findViewById(d.g.header_level_img);
        this.eUq = (TextView) view.findViewById(d.g.user_level_name);
        this.aLf = view.findViewById(d.g.header_divider_line2);
        this.eVr = (LinearLayout) view.findViewById(d.g.view_experience_score);
        this.eVs = (TextView) view.findViewById(d.g.tip_experience_score);
        this.eVt = (NoPressedLinearLayout) view.findViewById(d.g.root_forum_member_header);
        this.eVu = view.findViewById(d.g.header_divider_line3);
        this.eVv = (TextView) view.findViewById(d.g.tip_experience);
        this.eVw = (ImageView) view.findViewById(d.g.love_level_top);
        this.eVx = (ImageView) view.findViewById(d.g.love_level_bg);
        this.eVp.setOnClickListener(onClickListener);
        this.eUq.setOnClickListener(onClickListener);
    }
}
