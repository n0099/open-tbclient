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
    public ImageView iOj;
    public TextView iOk;
    public TextView iPj;
    public TextView iPk;
    public LinearLayout iPl;
    public NoPressedLinearLayout iPm;
    public View iPn;
    public TextView iPo;
    public ImageView iPp;
    public ImageView iPq;
    public View mDivider;

    public k(View view, View.OnClickListener onClickListener) {
        super(view);
        this.iPj = (TextView) view.findViewById(R.id.like_btn);
        this.iPk = (TextView) view.findViewById(R.id.lever_tip_view);
        this.iOj = (ImageView) view.findViewById(R.id.header_level_img);
        this.iOk = (TextView) view.findViewById(R.id.user_level_name);
        this.mDivider = view.findViewById(R.id.header_divider_line2);
        this.iPl = (LinearLayout) view.findViewById(R.id.view_experience_score);
        this.eZp = (TextView) view.findViewById(R.id.tip_experience_score);
        this.iPm = (NoPressedLinearLayout) view.findViewById(R.id.root_forum_member_header);
        this.iPn = view.findViewById(R.id.header_divider_line3);
        this.iPo = (TextView) view.findViewById(R.id.tip_experience);
        this.iPp = (ImageView) view.findViewById(R.id.love_level_top);
        this.iPq = (ImageView) view.findViewById(R.id.love_level_bg);
        this.iPj.setOnClickListener(onClickListener);
        this.iOk.setOnClickListener(onClickListener);
    }
}
