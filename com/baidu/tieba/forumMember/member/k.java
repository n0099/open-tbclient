package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tieba.R;
/* loaded from: classes17.dex */
public class k extends af.a {
    public TextView eqq;
    public ImageView hOc;
    public TextView hOd;
    public TextView hPd;
    public TextView hPe;
    public LinearLayout hPf;
    public NoPressedLinearLayout hPg;
    public View hPh;
    public TextView hPi;
    public ImageView hPj;
    public ImageView hPk;
    public View mDivider;

    public k(View view, View.OnClickListener onClickListener) {
        super(view);
        this.hPd = (TextView) view.findViewById(R.id.like_btn);
        this.hPe = (TextView) view.findViewById(R.id.lever_tip_view);
        this.hOc = (ImageView) view.findViewById(R.id.header_level_img);
        this.hOd = (TextView) view.findViewById(R.id.user_level_name);
        this.mDivider = view.findViewById(R.id.header_divider_line2);
        this.hPf = (LinearLayout) view.findViewById(R.id.view_experience_score);
        this.eqq = (TextView) view.findViewById(R.id.tip_experience_score);
        this.hPg = (NoPressedLinearLayout) view.findViewById(R.id.root_forum_member_header);
        this.hPh = view.findViewById(R.id.header_divider_line3);
        this.hPi = (TextView) view.findViewById(R.id.tip_experience);
        this.hPj = (ImageView) view.findViewById(R.id.love_level_top);
        this.hPk = (ImageView) view.findViewById(R.id.love_level_bg);
        this.hPd.setOnClickListener(onClickListener);
        this.hOd.setOnClickListener(onClickListener);
    }
}
