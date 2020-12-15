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
    public TextView eZp;
    public ImageView iOl;
    public TextView iOm;
    public TextView iPl;
    public TextView iPm;
    public LinearLayout iPn;
    public NoPressedLinearLayout iPo;
    public View iPp;
    public TextView iPq;
    public ImageView iPr;
    public ImageView iPs;
    public View mDivider;

    public k(View view, View.OnClickListener onClickListener) {
        super(view);
        this.iPl = (TextView) view.findViewById(R.id.like_btn);
        this.iPm = (TextView) view.findViewById(R.id.lever_tip_view);
        this.iOl = (ImageView) view.findViewById(R.id.header_level_img);
        this.iOm = (TextView) view.findViewById(R.id.user_level_name);
        this.mDivider = view.findViewById(R.id.header_divider_line2);
        this.iPn = (LinearLayout) view.findViewById(R.id.view_experience_score);
        this.eZp = (TextView) view.findViewById(R.id.tip_experience_score);
        this.iPo = (NoPressedLinearLayout) view.findViewById(R.id.root_forum_member_header);
        this.iPp = view.findViewById(R.id.header_divider_line3);
        this.iPq = (TextView) view.findViewById(R.id.tip_experience);
        this.iPr = (ImageView) view.findViewById(R.id.love_level_top);
        this.iPs = (ImageView) view.findViewById(R.id.love_level_bg);
        this.iPl.setOnClickListener(onClickListener);
        this.iOm.setOnClickListener(onClickListener);
    }
}
