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
    public TextView esz;
    public ImageView hVi;
    public TextView hVj;
    public TextView hWj;
    public TextView hWk;
    public LinearLayout hWl;
    public NoPressedLinearLayout hWm;
    public View hWn;
    public TextView hWo;
    public ImageView hWp;
    public ImageView hWq;
    public View mDivider;

    public k(View view, View.OnClickListener onClickListener) {
        super(view);
        this.hWj = (TextView) view.findViewById(R.id.like_btn);
        this.hWk = (TextView) view.findViewById(R.id.lever_tip_view);
        this.hVi = (ImageView) view.findViewById(R.id.header_level_img);
        this.hVj = (TextView) view.findViewById(R.id.user_level_name);
        this.mDivider = view.findViewById(R.id.header_divider_line2);
        this.hWl = (LinearLayout) view.findViewById(R.id.view_experience_score);
        this.esz = (TextView) view.findViewById(R.id.tip_experience_score);
        this.hWm = (NoPressedLinearLayout) view.findViewById(R.id.root_forum_member_header);
        this.hWn = view.findViewById(R.id.header_divider_line3);
        this.hWo = (TextView) view.findViewById(R.id.tip_experience);
        this.hWp = (ImageView) view.findViewById(R.id.love_level_top);
        this.hWq = (ImageView) view.findViewById(R.id.love_level_bg);
        this.hWj.setOnClickListener(onClickListener);
        this.hVj.setOnClickListener(onClickListener);
    }
}
