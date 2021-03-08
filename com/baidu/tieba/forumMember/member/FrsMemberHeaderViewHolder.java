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
    public View dCC;
    public TextView fhW;
    public ImageView jdt;
    public TextView jdu;
    public ImageView jeA;
    public ImageView jeB;
    public TextView jeu;
    public TextView jev;
    public LinearLayout jew;
    public NoPressedLinearLayout jex;
    public View jey;
    public TextView jez;

    public FrsMemberHeaderViewHolder(View view, View.OnClickListener onClickListener) {
        super(view);
        this.jeu = (TextView) view.findViewById(R.id.like_btn);
        this.jev = (TextView) view.findViewById(R.id.lever_tip_view);
        this.jdt = (ImageView) view.findViewById(R.id.header_level_img);
        this.jdu = (TextView) view.findViewById(R.id.user_level_name);
        this.dCC = view.findViewById(R.id.header_divider_line2);
        this.jew = (LinearLayout) view.findViewById(R.id.view_experience_score);
        this.fhW = (TextView) view.findViewById(R.id.tip_experience_score);
        this.jex = (NoPressedLinearLayout) view.findViewById(R.id.root_forum_member_header);
        this.jey = view.findViewById(R.id.header_divider_line3);
        this.jez = (TextView) view.findViewById(R.id.tip_experience);
        this.jeA = (ImageView) view.findViewById(R.id.love_level_top);
        this.jeB = (ImageView) view.findViewById(R.id.love_level_bg);
        this.jeu.setOnClickListener(onClickListener);
        this.jdu.setOnClickListener(onClickListener);
    }
}
