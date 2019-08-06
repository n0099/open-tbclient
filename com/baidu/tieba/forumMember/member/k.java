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
    public ImageView fpX;
    public TextView fpY;
    public TextView fqX;
    public TextView fqY;
    public LinearLayout fqZ;
    public TextView fra;
    public NoPressedLinearLayout frb;
    public View frc;
    public TextView frd;
    public ImageView fre;
    public ImageView frf;

    public k(View view, View.OnClickListener onClickListener) {
        super(view);
        this.fqX = (TextView) view.findViewById(R.id.like_btn);
        this.fqY = (TextView) view.findViewById(R.id.lever_tip_view);
        this.fpX = (ImageView) view.findViewById(R.id.header_level_img);
        this.fpY = (TextView) view.findViewById(R.id.user_level_name);
        this.aNH = view.findViewById(R.id.header_divider_line2);
        this.fqZ = (LinearLayout) view.findViewById(R.id.view_experience_score);
        this.fra = (TextView) view.findViewById(R.id.tip_experience_score);
        this.frb = (NoPressedLinearLayout) view.findViewById(R.id.root_forum_member_header);
        this.frc = view.findViewById(R.id.header_divider_line3);
        this.frd = (TextView) view.findViewById(R.id.tip_experience);
        this.fre = (ImageView) view.findViewById(R.id.love_level_top);
        this.frf = (ImageView) view.findViewById(R.id.love_level_bg);
        this.fqX.setOnClickListener(onClickListener);
        this.fpY.setOnClickListener(onClickListener);
    }
}
