package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class k extends aa.a {
    public ImageView hiH;
    public TextView hiI;
    public TextView hjJ;
    public TextView hjK;
    public LinearLayout hjL;
    public TextView hjM;
    public NoPressedLinearLayout hjN;
    public View hjO;
    public TextView hjP;
    public ImageView hjQ;
    public ImageView hjR;
    public View mDivider;

    public k(View view, View.OnClickListener onClickListener) {
        super(view);
        this.hjJ = (TextView) view.findViewById(R.id.like_btn);
        this.hjK = (TextView) view.findViewById(R.id.lever_tip_view);
        this.hiH = (ImageView) view.findViewById(R.id.header_level_img);
        this.hiI = (TextView) view.findViewById(R.id.user_level_name);
        this.mDivider = view.findViewById(R.id.header_divider_line2);
        this.hjL = (LinearLayout) view.findViewById(R.id.view_experience_score);
        this.hjM = (TextView) view.findViewById(R.id.tip_experience_score);
        this.hjN = (NoPressedLinearLayout) view.findViewById(R.id.root_forum_member_header);
        this.hjO = view.findViewById(R.id.header_divider_line3);
        this.hjP = (TextView) view.findViewById(R.id.tip_experience);
        this.hjQ = (ImageView) view.findViewById(R.id.love_level_top);
        this.hjR = (ImageView) view.findViewById(R.id.love_level_bg);
        this.hjJ.setOnClickListener(onClickListener);
        this.hiI.setOnClickListener(onClickListener);
    }
}
