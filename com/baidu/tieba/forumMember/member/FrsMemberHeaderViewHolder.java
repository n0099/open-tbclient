package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class FrsMemberHeaderViewHolder extends TypeAdapter.ViewHolder {
    public View dBb;
    public TextView fgx;
    public ImageView jbK;
    public TextView jbL;
    public TextView jcL;
    public TextView jcM;
    public LinearLayout jcN;
    public NoPressedLinearLayout jcO;
    public View jcP;
    public TextView jcQ;
    public ImageView jcR;
    public ImageView jcS;

    public FrsMemberHeaderViewHolder(View view, View.OnClickListener onClickListener) {
        super(view);
        this.jcL = (TextView) view.findViewById(R.id.like_btn);
        this.jcM = (TextView) view.findViewById(R.id.lever_tip_view);
        this.jbK = (ImageView) view.findViewById(R.id.header_level_img);
        this.jbL = (TextView) view.findViewById(R.id.user_level_name);
        this.dBb = view.findViewById(R.id.header_divider_line2);
        this.jcN = (LinearLayout) view.findViewById(R.id.view_experience_score);
        this.fgx = (TextView) view.findViewById(R.id.tip_experience_score);
        this.jcO = (NoPressedLinearLayout) view.findViewById(R.id.root_forum_member_header);
        this.jcP = view.findViewById(R.id.header_divider_line3);
        this.jcQ = (TextView) view.findViewById(R.id.tip_experience);
        this.jcR = (ImageView) view.findViewById(R.id.love_level_top);
        this.jcS = (ImageView) view.findViewById(R.id.love_level_bg);
        this.jcL.setOnClickListener(onClickListener);
        this.jbL.setOnClickListener(onClickListener);
    }
}
