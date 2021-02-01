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
    public ImageView jbw;
    public TextView jbx;
    public NoPressedLinearLayout jcA;
    public View jcB;
    public TextView jcC;
    public ImageView jcD;
    public ImageView jcE;
    public TextView jcx;
    public TextView jcy;
    public LinearLayout jcz;

    public FrsMemberHeaderViewHolder(View view, View.OnClickListener onClickListener) {
        super(view);
        this.jcx = (TextView) view.findViewById(R.id.like_btn);
        this.jcy = (TextView) view.findViewById(R.id.lever_tip_view);
        this.jbw = (ImageView) view.findViewById(R.id.header_level_img);
        this.jbx = (TextView) view.findViewById(R.id.user_level_name);
        this.dBb = view.findViewById(R.id.header_divider_line2);
        this.jcz = (LinearLayout) view.findViewById(R.id.view_experience_score);
        this.fgx = (TextView) view.findViewById(R.id.tip_experience_score);
        this.jcA = (NoPressedLinearLayout) view.findViewById(R.id.root_forum_member_header);
        this.jcB = view.findViewById(R.id.header_divider_line3);
        this.jcC = (TextView) view.findViewById(R.id.tip_experience);
        this.jcD = (ImageView) view.findViewById(R.id.love_level_top);
        this.jcE = (ImageView) view.findViewById(R.id.love_level_bg);
        this.jcx.setOnClickListener(onClickListener);
        this.jbx.setOnClickListener(onClickListener);
    }
}
