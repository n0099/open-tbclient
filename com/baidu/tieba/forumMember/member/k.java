package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class k extends v.a {
    public ImageView geB;
    public TextView geC;
    public TextView gfD;
    public TextView gfE;
    public LinearLayout gfF;
    public TextView gfG;
    public NoPressedLinearLayout gfH;
    public View gfI;
    public TextView gfJ;
    public ImageView gfK;
    public ImageView gfL;
    public View mDivider;

    public k(View view, View.OnClickListener onClickListener) {
        super(view);
        this.gfD = (TextView) view.findViewById(R.id.like_btn);
        this.gfE = (TextView) view.findViewById(R.id.lever_tip_view);
        this.geB = (ImageView) view.findViewById(R.id.header_level_img);
        this.geC = (TextView) view.findViewById(R.id.user_level_name);
        this.mDivider = view.findViewById(R.id.header_divider_line2);
        this.gfF = (LinearLayout) view.findViewById(R.id.view_experience_score);
        this.gfG = (TextView) view.findViewById(R.id.tip_experience_score);
        this.gfH = (NoPressedLinearLayout) view.findViewById(R.id.root_forum_member_header);
        this.gfI = view.findViewById(R.id.header_divider_line3);
        this.gfJ = (TextView) view.findViewById(R.id.tip_experience);
        this.gfK = (ImageView) view.findViewById(R.id.love_level_top);
        this.gfL = (ImageView) view.findViewById(R.id.love_level_bg);
        this.gfD.setOnClickListener(onClickListener);
        this.geC.setOnClickListener(onClickListener);
    }
}
