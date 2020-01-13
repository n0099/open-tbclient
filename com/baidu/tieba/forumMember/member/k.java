package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class k extends v.a {
    public ImageView ghK;
    public TextView ghL;
    public TextView giN;
    public TextView giO;
    public LinearLayout giP;
    public TextView giQ;
    public NoPressedLinearLayout giR;
    public View giS;
    public TextView giT;
    public ImageView giU;
    public ImageView giV;
    public View mDivider;

    public k(View view, View.OnClickListener onClickListener) {
        super(view);
        this.giN = (TextView) view.findViewById(R.id.like_btn);
        this.giO = (TextView) view.findViewById(R.id.lever_tip_view);
        this.ghK = (ImageView) view.findViewById(R.id.header_level_img);
        this.ghL = (TextView) view.findViewById(R.id.user_level_name);
        this.mDivider = view.findViewById(R.id.header_divider_line2);
        this.giP = (LinearLayout) view.findViewById(R.id.view_experience_score);
        this.giQ = (TextView) view.findViewById(R.id.tip_experience_score);
        this.giR = (NoPressedLinearLayout) view.findViewById(R.id.root_forum_member_header);
        this.giS = view.findViewById(R.id.header_divider_line3);
        this.giT = (TextView) view.findViewById(R.id.tip_experience);
        this.giU = (ImageView) view.findViewById(R.id.love_level_top);
        this.giV = (ImageView) view.findViewById(R.id.love_level_bg);
        this.giN.setOnClickListener(onClickListener);
        this.ghL.setOnClickListener(onClickListener);
    }
}
