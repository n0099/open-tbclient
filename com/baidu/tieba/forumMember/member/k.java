package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tieba.R;
/* loaded from: classes17.dex */
public class k extends ad.a {
    public TextView egJ;
    public ImageView hAN;
    public TextView hAO;
    public TextView hBO;
    public TextView hBP;
    public LinearLayout hBQ;
    public NoPressedLinearLayout hBR;
    public View hBS;
    public TextView hBT;
    public ImageView hBU;
    public ImageView hBV;
    public View mDivider;

    public k(View view, View.OnClickListener onClickListener) {
        super(view);
        this.hBO = (TextView) view.findViewById(R.id.like_btn);
        this.hBP = (TextView) view.findViewById(R.id.lever_tip_view);
        this.hAN = (ImageView) view.findViewById(R.id.header_level_img);
        this.hAO = (TextView) view.findViewById(R.id.user_level_name);
        this.mDivider = view.findViewById(R.id.header_divider_line2);
        this.hBQ = (LinearLayout) view.findViewById(R.id.view_experience_score);
        this.egJ = (TextView) view.findViewById(R.id.tip_experience_score);
        this.hBR = (NoPressedLinearLayout) view.findViewById(R.id.root_forum_member_header);
        this.hBS = view.findViewById(R.id.header_divider_line3);
        this.hBT = (TextView) view.findViewById(R.id.tip_experience);
        this.hBU = (ImageView) view.findViewById(R.id.love_level_top);
        this.hBV = (ImageView) view.findViewById(R.id.love_level_bg);
        this.hBO.setOnClickListener(onClickListener);
        this.hAO.setOnClickListener(onClickListener);
    }
}
