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
    public View aLe;
    public ImageView eUo;
    public TextView eUp;
    public TextView eVo;
    public TextView eVp;
    public LinearLayout eVq;
    public TextView eVr;
    public NoPressedLinearLayout eVs;
    public View eVt;
    public TextView eVu;
    public ImageView eVv;
    public ImageView eVw;

    public k(View view, View.OnClickListener onClickListener) {
        super(view);
        this.eVo = (TextView) view.findViewById(d.g.like_btn);
        this.eVp = (TextView) view.findViewById(d.g.lever_tip_view);
        this.eUo = (ImageView) view.findViewById(d.g.header_level_img);
        this.eUp = (TextView) view.findViewById(d.g.user_level_name);
        this.aLe = view.findViewById(d.g.header_divider_line2);
        this.eVq = (LinearLayout) view.findViewById(d.g.view_experience_score);
        this.eVr = (TextView) view.findViewById(d.g.tip_experience_score);
        this.eVs = (NoPressedLinearLayout) view.findViewById(d.g.root_forum_member_header);
        this.eVt = view.findViewById(d.g.header_divider_line3);
        this.eVu = (TextView) view.findViewById(d.g.tip_experience);
        this.eVv = (ImageView) view.findViewById(d.g.love_level_top);
        this.eVw = (ImageView) view.findViewById(d.g.love_level_bg);
        this.eVo.setOnClickListener(onClickListener);
        this.eUp.setOnClickListener(onClickListener);
    }
}
