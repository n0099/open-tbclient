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
    public ImageView gjN;
    public TextView gjO;
    public TextView gkQ;
    public TextView gkR;
    public LinearLayout gkS;
    public TextView gkT;
    public NoPressedLinearLayout gkU;
    public View gkV;
    public TextView gkW;
    public ImageView gkX;
    public ImageView gkY;
    public View mDivider;

    public k(View view, View.OnClickListener onClickListener) {
        super(view);
        this.gkQ = (TextView) view.findViewById(R.id.like_btn);
        this.gkR = (TextView) view.findViewById(R.id.lever_tip_view);
        this.gjN = (ImageView) view.findViewById(R.id.header_level_img);
        this.gjO = (TextView) view.findViewById(R.id.user_level_name);
        this.mDivider = view.findViewById(R.id.header_divider_line2);
        this.gkS = (LinearLayout) view.findViewById(R.id.view_experience_score);
        this.gkT = (TextView) view.findViewById(R.id.tip_experience_score);
        this.gkU = (NoPressedLinearLayout) view.findViewById(R.id.root_forum_member_header);
        this.gkV = view.findViewById(R.id.header_divider_line3);
        this.gkW = (TextView) view.findViewById(R.id.tip_experience);
        this.gkX = (ImageView) view.findViewById(R.id.love_level_top);
        this.gkY = (ImageView) view.findViewById(R.id.love_level_bg);
        this.gkQ.setOnClickListener(onClickListener);
        this.gjO.setOnClickListener(onClickListener);
    }
}
