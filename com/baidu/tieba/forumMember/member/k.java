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
    public ImageView fkA;
    public TextView fkB;
    public TextView flA;
    public TextView flB;
    public LinearLayout flC;
    public TextView flD;
    public NoPressedLinearLayout flE;
    public View flF;
    public TextView flG;
    public ImageView flH;
    public ImageView flI;

    public k(View view, View.OnClickListener onClickListener) {
        super(view);
        this.flA = (TextView) view.findViewById(R.id.like_btn);
        this.flB = (TextView) view.findViewById(R.id.lever_tip_view);
        this.fkA = (ImageView) view.findViewById(R.id.header_level_img);
        this.fkB = (TextView) view.findViewById(R.id.user_level_name);
        this.aMY = view.findViewById(R.id.header_divider_line2);
        this.flC = (LinearLayout) view.findViewById(R.id.view_experience_score);
        this.flD = (TextView) view.findViewById(R.id.tip_experience_score);
        this.flE = (NoPressedLinearLayout) view.findViewById(R.id.root_forum_member_header);
        this.flF = view.findViewById(R.id.header_divider_line3);
        this.flG = (TextView) view.findViewById(R.id.tip_experience);
        this.flH = (ImageView) view.findViewById(R.id.love_level_top);
        this.flI = (ImageView) view.findViewById(R.id.love_level_bg);
        this.flA.setOnClickListener(onClickListener);
        this.fkB.setOnClickListener(onClickListener);
    }
}
