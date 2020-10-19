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
    public TextView eEK;
    public ImageView ikh;
    public TextView iki;
    public TextView ili;
    public TextView ilj;
    public LinearLayout ilk;
    public NoPressedLinearLayout ill;
    public View ilm;
    public TextView iln;
    public ImageView ilo;
    public ImageView ilp;
    public View mDivider;

    public k(View view, View.OnClickListener onClickListener) {
        super(view);
        this.ili = (TextView) view.findViewById(R.id.like_btn);
        this.ilj = (TextView) view.findViewById(R.id.lever_tip_view);
        this.ikh = (ImageView) view.findViewById(R.id.header_level_img);
        this.iki = (TextView) view.findViewById(R.id.user_level_name);
        this.mDivider = view.findViewById(R.id.header_divider_line2);
        this.ilk = (LinearLayout) view.findViewById(R.id.view_experience_score);
        this.eEK = (TextView) view.findViewById(R.id.tip_experience_score);
        this.ill = (NoPressedLinearLayout) view.findViewById(R.id.root_forum_member_header);
        this.ilm = view.findViewById(R.id.header_divider_line3);
        this.iln = (TextView) view.findViewById(R.id.tip_experience);
        this.ilo = (ImageView) view.findViewById(R.id.love_level_top);
        this.ilp = (ImageView) view.findViewById(R.id.love_level_bg);
        this.ili.setOnClickListener(onClickListener);
        this.iki.setOnClickListener(onClickListener);
    }
}
