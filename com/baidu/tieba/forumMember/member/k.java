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
    public View aOf;
    public ImageView frL;
    public TextView frM;
    public TextView fsL;
    public TextView fsM;
    public LinearLayout fsN;
    public TextView fsO;
    public NoPressedLinearLayout fsP;
    public View fsQ;
    public TextView fsR;
    public ImageView fsS;
    public ImageView fsT;

    public k(View view, View.OnClickListener onClickListener) {
        super(view);
        this.fsL = (TextView) view.findViewById(R.id.like_btn);
        this.fsM = (TextView) view.findViewById(R.id.lever_tip_view);
        this.frL = (ImageView) view.findViewById(R.id.header_level_img);
        this.frM = (TextView) view.findViewById(R.id.user_level_name);
        this.aOf = view.findViewById(R.id.header_divider_line2);
        this.fsN = (LinearLayout) view.findViewById(R.id.view_experience_score);
        this.fsO = (TextView) view.findViewById(R.id.tip_experience_score);
        this.fsP = (NoPressedLinearLayout) view.findViewById(R.id.root_forum_member_header);
        this.fsQ = view.findViewById(R.id.header_divider_line3);
        this.fsR = (TextView) view.findViewById(R.id.tip_experience);
        this.fsS = (ImageView) view.findViewById(R.id.love_level_top);
        this.fsT = (ImageView) view.findViewById(R.id.love_level_bg);
        this.fsL.setOnClickListener(onClickListener);
        this.frM.setOnClickListener(onClickListener);
    }
}
