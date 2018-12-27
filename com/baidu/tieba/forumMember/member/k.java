package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class k extends q.a {
    public ImageView dGF;
    public TextView dGG;
    public TextView dHE;
    public TextView dHF;
    public TextView dHG;
    public LinearLayout dHH;
    public TextView dHI;
    public NoPressedLinearLayout dHJ;
    public View dHK;
    public View dHL;
    public View dHM;
    public TextView dHN;
    public TextView dHO;
    public View mDivider;

    public k(View view, View.OnClickListener onClickListener) {
        super(view);
        this.dHE = (TextView) view.findViewById(e.g.like_btn);
        this.dHF = (TextView) view.findViewById(e.g.lever_tip_view);
        this.dGF = (ImageView) view.findViewById(e.g.header_level_img);
        this.dGG = (TextView) view.findViewById(e.g.user_level_name);
        this.dHG = (TextView) view.findViewById(e.g.detail_tip_view);
        this.mDivider = view.findViewById(e.g.header_divider_line2);
        this.dHH = (LinearLayout) view.findViewById(e.g.view_experience_score);
        this.dHI = (TextView) view.findViewById(e.g.tip_experience_score);
        this.dHJ = (NoPressedLinearLayout) view.findViewById(e.g.root_forum_member_header);
        this.dHK = view.findViewById(e.g.divider_top);
        this.dHL = view.findViewById(e.g.header_divider_line1);
        this.dHM = view.findViewById(e.g.header_divider_line3);
        this.dHN = (TextView) view.findViewById(e.g.tip_in_forum);
        this.dHO = (TextView) view.findViewById(e.g.tip_experience);
        this.dHE.setOnClickListener(onClickListener);
        this.dHG.setOnClickListener(onClickListener);
    }
}
