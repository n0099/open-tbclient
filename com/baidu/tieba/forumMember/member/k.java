package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class k extends v.a {
    public View aNH;
    public ImageView fpy;
    public TextView fpz;
    public LinearLayout fqA;
    public TextView fqB;
    public NoPressedLinearLayout fqC;
    public View fqD;
    public TextView fqE;
    public ImageView fqF;
    public ImageView fqG;
    public TextView fqy;
    public TextView fqz;

    public k(View view, View.OnClickListener onClickListener) {
        super(view);
        this.fqy = (TextView) view.findViewById(R.id.like_btn);
        this.fqz = (TextView) view.findViewById(R.id.lever_tip_view);
        this.fpy = (ImageView) view.findViewById(R.id.header_level_img);
        this.fpz = (TextView) view.findViewById(R.id.user_level_name);
        this.aNH = view.findViewById(R.id.header_divider_line2);
        this.fqA = (LinearLayout) view.findViewById(R.id.view_experience_score);
        this.fqB = (TextView) view.findViewById(R.id.tip_experience_score);
        this.fqC = (NoPressedLinearLayout) view.findViewById(R.id.root_forum_member_header);
        this.fqD = view.findViewById(R.id.header_divider_line3);
        this.fqE = (TextView) view.findViewById(R.id.tip_experience);
        this.fqF = (ImageView) view.findViewById(R.id.love_level_top);
        this.fqG = (ImageView) view.findViewById(R.id.love_level_bg);
        this.fqy.setOnClickListener(onClickListener);
        this.fpz.setOnClickListener(onClickListener);
    }
}
