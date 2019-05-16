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
    public View aMY;
    public TextView fkA;
    public ImageView fkz;
    public TextView flA;
    public LinearLayout flB;
    public TextView flC;
    public NoPressedLinearLayout flD;
    public View flE;
    public TextView flF;
    public ImageView flG;
    public ImageView flH;
    public TextView flz;

    public k(View view, View.OnClickListener onClickListener) {
        super(view);
        this.flz = (TextView) view.findViewById(R.id.like_btn);
        this.flA = (TextView) view.findViewById(R.id.lever_tip_view);
        this.fkz = (ImageView) view.findViewById(R.id.header_level_img);
        this.fkA = (TextView) view.findViewById(R.id.user_level_name);
        this.aMY = view.findViewById(R.id.header_divider_line2);
        this.flB = (LinearLayout) view.findViewById(R.id.view_experience_score);
        this.flC = (TextView) view.findViewById(R.id.tip_experience_score);
        this.flD = (NoPressedLinearLayout) view.findViewById(R.id.root_forum_member_header);
        this.flE = view.findViewById(R.id.header_divider_line3);
        this.flF = (TextView) view.findViewById(R.id.tip_experience);
        this.flG = (ImageView) view.findViewById(R.id.love_level_top);
        this.flH = (ImageView) view.findViewById(R.id.love_level_bg);
        this.flz.setOnClickListener(onClickListener);
        this.fkA.setOnClickListener(onClickListener);
    }
}
