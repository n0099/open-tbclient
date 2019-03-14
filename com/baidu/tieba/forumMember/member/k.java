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
    public View aLb;
    public ImageView eUC;
    public TextView eUD;
    public TextView eVC;
    public TextView eVD;
    public LinearLayout eVE;
    public TextView eVF;
    public NoPressedLinearLayout eVG;
    public View eVH;
    public TextView eVI;
    public ImageView eVJ;
    public ImageView eVK;

    public k(View view, View.OnClickListener onClickListener) {
        super(view);
        this.eVC = (TextView) view.findViewById(d.g.like_btn);
        this.eVD = (TextView) view.findViewById(d.g.lever_tip_view);
        this.eUC = (ImageView) view.findViewById(d.g.header_level_img);
        this.eUD = (TextView) view.findViewById(d.g.user_level_name);
        this.aLb = view.findViewById(d.g.header_divider_line2);
        this.eVE = (LinearLayout) view.findViewById(d.g.view_experience_score);
        this.eVF = (TextView) view.findViewById(d.g.tip_experience_score);
        this.eVG = (NoPressedLinearLayout) view.findViewById(d.g.root_forum_member_header);
        this.eVH = view.findViewById(d.g.header_divider_line3);
        this.eVI = (TextView) view.findViewById(d.g.tip_experience);
        this.eVJ = (ImageView) view.findViewById(d.g.love_level_top);
        this.eVK = (ImageView) view.findViewById(d.g.love_level_bg);
        this.eVC.setOnClickListener(onClickListener);
        this.eUD.setOnClickListener(onClickListener);
    }
}
