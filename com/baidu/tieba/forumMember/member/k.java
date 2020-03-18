package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class k extends v.a {
    public ImageView gkI;
    public TextView gkJ;
    public TextView glL;
    public TextView glM;
    public LinearLayout glN;
    public TextView glO;
    public NoPressedLinearLayout glP;
    public View glQ;
    public TextView glR;
    public ImageView glS;
    public ImageView glT;
    public View mDivider;

    public k(View view, View.OnClickListener onClickListener) {
        super(view);
        this.glL = (TextView) view.findViewById(R.id.like_btn);
        this.glM = (TextView) view.findViewById(R.id.lever_tip_view);
        this.gkI = (ImageView) view.findViewById(R.id.header_level_img);
        this.gkJ = (TextView) view.findViewById(R.id.user_level_name);
        this.mDivider = view.findViewById(R.id.header_divider_line2);
        this.glN = (LinearLayout) view.findViewById(R.id.view_experience_score);
        this.glO = (TextView) view.findViewById(R.id.tip_experience_score);
        this.glP = (NoPressedLinearLayout) view.findViewById(R.id.root_forum_member_header);
        this.glQ = view.findViewById(R.id.header_divider_line3);
        this.glR = (TextView) view.findViewById(R.id.tip_experience);
        this.glS = (ImageView) view.findViewById(R.id.love_level_top);
        this.glT = (ImageView) view.findViewById(R.id.love_level_bg);
        this.glL.setOnClickListener(onClickListener);
        this.gkJ.setOnClickListener(onClickListener);
    }
}
