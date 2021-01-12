package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class FrsMemberHeaderViewHolder extends TypeAdapter.ViewHolder {
    public View dyW;
    public TextView fei;
    public ImageView iVP;
    public TextView iVQ;
    public TextView iWQ;
    public TextView iWR;
    public LinearLayout iWS;
    public NoPressedLinearLayout iWT;
    public View iWU;
    public TextView iWV;
    public ImageView iWW;
    public ImageView iWX;

    public FrsMemberHeaderViewHolder(View view, View.OnClickListener onClickListener) {
        super(view);
        this.iWQ = (TextView) view.findViewById(R.id.like_btn);
        this.iWR = (TextView) view.findViewById(R.id.lever_tip_view);
        this.iVP = (ImageView) view.findViewById(R.id.header_level_img);
        this.iVQ = (TextView) view.findViewById(R.id.user_level_name);
        this.dyW = view.findViewById(R.id.header_divider_line2);
        this.iWS = (LinearLayout) view.findViewById(R.id.view_experience_score);
        this.fei = (TextView) view.findViewById(R.id.tip_experience_score);
        this.iWT = (NoPressedLinearLayout) view.findViewById(R.id.root_forum_member_header);
        this.iWU = view.findViewById(R.id.header_divider_line3);
        this.iWV = (TextView) view.findViewById(R.id.tip_experience);
        this.iWW = (ImageView) view.findViewById(R.id.love_level_top);
        this.iWX = (ImageView) view.findViewById(R.id.love_level_bg);
        this.iWQ.setOnClickListener(onClickListener);
        this.iVQ.setOnClickListener(onClickListener);
    }
}
