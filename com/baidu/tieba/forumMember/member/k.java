package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tieba.R;
/* loaded from: classes23.dex */
public class k extends af.a {
    public TextView eSV;
    public ImageView iCC;
    public TextView iCD;
    public TextView iDD;
    public TextView iDE;
    public LinearLayout iDF;
    public NoPressedLinearLayout iDG;
    public View iDH;
    public TextView iDI;
    public ImageView iDJ;
    public ImageView iDK;
    public View mDivider;

    public k(View view, View.OnClickListener onClickListener) {
        super(view);
        this.iDD = (TextView) view.findViewById(R.id.like_btn);
        this.iDE = (TextView) view.findViewById(R.id.lever_tip_view);
        this.iCC = (ImageView) view.findViewById(R.id.header_level_img);
        this.iCD = (TextView) view.findViewById(R.id.user_level_name);
        this.mDivider = view.findViewById(R.id.header_divider_line2);
        this.iDF = (LinearLayout) view.findViewById(R.id.view_experience_score);
        this.eSV = (TextView) view.findViewById(R.id.tip_experience_score);
        this.iDG = (NoPressedLinearLayout) view.findViewById(R.id.root_forum_member_header);
        this.iDH = view.findViewById(R.id.header_divider_line3);
        this.iDI = (TextView) view.findViewById(R.id.tip_experience);
        this.iDJ = (ImageView) view.findViewById(R.id.love_level_top);
        this.iDK = (ImageView) view.findViewById(R.id.love_level_bg);
        this.iDD.setOnClickListener(onClickListener);
        this.iCD.setOnClickListener(onClickListener);
    }
}
