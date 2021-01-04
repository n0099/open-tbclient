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
    public View dDI;
    public TextView fiT;
    public ImageView jaw;
    public TextView jax;
    public NoPressedLinearLayout jbA;
    public View jbB;
    public TextView jbC;
    public ImageView jbD;
    public ImageView jbE;
    public TextView jbx;
    public TextView jby;
    public LinearLayout jbz;

    public FrsMemberHeaderViewHolder(View view, View.OnClickListener onClickListener) {
        super(view);
        this.jbx = (TextView) view.findViewById(R.id.like_btn);
        this.jby = (TextView) view.findViewById(R.id.lever_tip_view);
        this.jaw = (ImageView) view.findViewById(R.id.header_level_img);
        this.jax = (TextView) view.findViewById(R.id.user_level_name);
        this.dDI = view.findViewById(R.id.header_divider_line2);
        this.jbz = (LinearLayout) view.findViewById(R.id.view_experience_score);
        this.fiT = (TextView) view.findViewById(R.id.tip_experience_score);
        this.jbA = (NoPressedLinearLayout) view.findViewById(R.id.root_forum_member_header);
        this.jbB = view.findViewById(R.id.header_divider_line3);
        this.jbC = (TextView) view.findViewById(R.id.tip_experience);
        this.jbD = (ImageView) view.findViewById(R.id.love_level_top);
        this.jbE = (ImageView) view.findViewById(R.id.love_level_bg);
        this.jbx.setOnClickListener(onClickListener);
        this.jax.setOnClickListener(onClickListener);
    }
}
