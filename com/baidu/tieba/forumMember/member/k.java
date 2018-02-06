package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class k extends r.a {
    public View chX;
    public ImageView dAJ;
    public TextView dAK;
    public TextView dBG;
    public TextView dBH;
    public TextView dBI;
    public LinearLayout dBJ;
    public TextView dBK;
    public NoPressedLinearLayout dBL;
    public View dBM;
    public View dBN;
    public View dBO;
    public TextView dBP;
    public TextView dBQ;

    public k(View view, View.OnClickListener onClickListener) {
        super(view);
        this.dBG = (TextView) view.findViewById(d.g.like_btn);
        this.dBH = (TextView) view.findViewById(d.g.lever_tip_view);
        this.dAJ = (ImageView) view.findViewById(d.g.header_level_img);
        this.dAK = (TextView) view.findViewById(d.g.user_level_name);
        this.dBI = (TextView) view.findViewById(d.g.detail_tip_view);
        this.chX = view.findViewById(d.g.header_divider_line2);
        this.dBJ = (LinearLayout) view.findViewById(d.g.view_experience_score);
        this.dBK = (TextView) view.findViewById(d.g.tip_experience_score);
        this.dBL = (NoPressedLinearLayout) view.findViewById(d.g.root_forum_member_header);
        this.dBM = view.findViewById(d.g.divider_top);
        this.dBN = view.findViewById(d.g.header_divider_line1);
        this.dBO = view.findViewById(d.g.header_divider_line3);
        this.dBP = (TextView) view.findViewById(d.g.tip_in_forum);
        this.dBQ = (TextView) view.findViewById(d.g.tip_experience);
        this.dBG.setOnClickListener(onClickListener);
        this.dBI.setOnClickListener(onClickListener);
    }
}
