package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class k extends af.a {
    public TextView eRX;
    public ImageView iDr;
    public TextView iDs;
    public TextView iEr;
    public TextView iEs;
    public LinearLayout iEt;
    public NoPressedLinearLayout iEu;
    public View iEv;
    public TextView iEw;
    public ImageView iEx;
    public ImageView iEy;
    public View mDivider;

    public k(View view, View.OnClickListener onClickListener) {
        super(view);
        this.iEr = (TextView) view.findViewById(R.id.like_btn);
        this.iEs = (TextView) view.findViewById(R.id.lever_tip_view);
        this.iDr = (ImageView) view.findViewById(R.id.header_level_img);
        this.iDs = (TextView) view.findViewById(R.id.user_level_name);
        this.mDivider = view.findViewById(R.id.header_divider_line2);
        this.iEt = (LinearLayout) view.findViewById(R.id.view_experience_score);
        this.eRX = (TextView) view.findViewById(R.id.tip_experience_score);
        this.iEu = (NoPressedLinearLayout) view.findViewById(R.id.root_forum_member_header);
        this.iEv = view.findViewById(R.id.header_divider_line3);
        this.iEw = (TextView) view.findViewById(R.id.tip_experience);
        this.iEx = (ImageView) view.findViewById(R.id.love_level_top);
        this.iEy = (ImageView) view.findViewById(R.id.love_level_bg);
        this.iEr.setOnClickListener(onClickListener);
        this.iDs.setOnClickListener(onClickListener);
    }
}
