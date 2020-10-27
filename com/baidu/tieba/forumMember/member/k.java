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
    public TextView eNg;
    public ImageView iwF;
    public TextView iwG;
    public TextView ixG;
    public TextView ixH;
    public LinearLayout ixI;
    public NoPressedLinearLayout ixJ;
    public View ixK;
    public TextView ixL;
    public ImageView ixM;
    public ImageView ixN;
    public View mDivider;

    public k(View view, View.OnClickListener onClickListener) {
        super(view);
        this.ixG = (TextView) view.findViewById(R.id.like_btn);
        this.ixH = (TextView) view.findViewById(R.id.lever_tip_view);
        this.iwF = (ImageView) view.findViewById(R.id.header_level_img);
        this.iwG = (TextView) view.findViewById(R.id.user_level_name);
        this.mDivider = view.findViewById(R.id.header_divider_line2);
        this.ixI = (LinearLayout) view.findViewById(R.id.view_experience_score);
        this.eNg = (TextView) view.findViewById(R.id.tip_experience_score);
        this.ixJ = (NoPressedLinearLayout) view.findViewById(R.id.root_forum_member_header);
        this.ixK = view.findViewById(R.id.header_divider_line3);
        this.ixL = (TextView) view.findViewById(R.id.tip_experience);
        this.ixM = (ImageView) view.findViewById(R.id.love_level_top);
        this.ixN = (ImageView) view.findViewById(R.id.love_level_bg);
        this.ixG.setOnClickListener(onClickListener);
        this.iwG.setOnClickListener(onClickListener);
    }
}
