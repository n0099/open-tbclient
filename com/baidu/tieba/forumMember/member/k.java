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
    public ImageView gjL;
    public TextView gjM;
    public TextView gkO;
    public TextView gkP;
    public LinearLayout gkQ;
    public TextView gkR;
    public NoPressedLinearLayout gkS;
    public View gkT;
    public TextView gkU;
    public ImageView gkV;
    public ImageView gkW;
    public View mDivider;

    public k(View view, View.OnClickListener onClickListener) {
        super(view);
        this.gkO = (TextView) view.findViewById(R.id.like_btn);
        this.gkP = (TextView) view.findViewById(R.id.lever_tip_view);
        this.gjL = (ImageView) view.findViewById(R.id.header_level_img);
        this.gjM = (TextView) view.findViewById(R.id.user_level_name);
        this.mDivider = view.findViewById(R.id.header_divider_line2);
        this.gkQ = (LinearLayout) view.findViewById(R.id.view_experience_score);
        this.gkR = (TextView) view.findViewById(R.id.tip_experience_score);
        this.gkS = (NoPressedLinearLayout) view.findViewById(R.id.root_forum_member_header);
        this.gkT = view.findViewById(R.id.header_divider_line3);
        this.gkU = (TextView) view.findViewById(R.id.tip_experience);
        this.gkV = (ImageView) view.findViewById(R.id.love_level_top);
        this.gkW = (ImageView) view.findViewById(R.id.love_level_bg);
        this.gkO.setOnClickListener(onClickListener);
        this.gjM.setOnClickListener(onClickListener);
    }
}
