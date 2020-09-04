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
    public TextView equ;
    public ImageView hOi;
    public TextView hOj;
    public TextView hPj;
    public TextView hPk;
    public LinearLayout hPl;
    public NoPressedLinearLayout hPm;
    public View hPn;
    public TextView hPo;
    public ImageView hPp;
    public ImageView hPq;
    public View mDivider;

    public k(View view, View.OnClickListener onClickListener) {
        super(view);
        this.hPj = (TextView) view.findViewById(R.id.like_btn);
        this.hPk = (TextView) view.findViewById(R.id.lever_tip_view);
        this.hOi = (ImageView) view.findViewById(R.id.header_level_img);
        this.hOj = (TextView) view.findViewById(R.id.user_level_name);
        this.mDivider = view.findViewById(R.id.header_divider_line2);
        this.hPl = (LinearLayout) view.findViewById(R.id.view_experience_score);
        this.equ = (TextView) view.findViewById(R.id.tip_experience_score);
        this.hPm = (NoPressedLinearLayout) view.findViewById(R.id.root_forum_member_header);
        this.hPn = view.findViewById(R.id.header_divider_line3);
        this.hPo = (TextView) view.findViewById(R.id.tip_experience);
        this.hPp = (ImageView) view.findViewById(R.id.love_level_top);
        this.hPq = (ImageView) view.findViewById(R.id.love_level_bg);
        this.hPj.setOnClickListener(onClickListener);
        this.hOj.setOnClickListener(onClickListener);
    }
}
