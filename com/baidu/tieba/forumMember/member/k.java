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
    public ImageView hiS;
    public TextView hiT;
    public TextView hjU;
    public TextView hjV;
    public LinearLayout hjW;
    public TextView hjX;
    public NoPressedLinearLayout hjY;
    public View hjZ;
    public TextView hka;
    public ImageView hkb;
    public ImageView hkc;
    public View mDivider;

    public k(View view, View.OnClickListener onClickListener) {
        super(view);
        this.hjU = (TextView) view.findViewById(R.id.like_btn);
        this.hjV = (TextView) view.findViewById(R.id.lever_tip_view);
        this.hiS = (ImageView) view.findViewById(R.id.header_level_img);
        this.hiT = (TextView) view.findViewById(R.id.user_level_name);
        this.mDivider = view.findViewById(R.id.header_divider_line2);
        this.hjW = (LinearLayout) view.findViewById(R.id.view_experience_score);
        this.hjX = (TextView) view.findViewById(R.id.tip_experience_score);
        this.hjY = (NoPressedLinearLayout) view.findViewById(R.id.root_forum_member_header);
        this.hjZ = view.findViewById(R.id.header_divider_line3);
        this.hka = (TextView) view.findViewById(R.id.tip_experience);
        this.hkb = (ImageView) view.findViewById(R.id.love_level_top);
        this.hkc = (ImageView) view.findViewById(R.id.love_level_bg);
        this.hjU.setOnClickListener(onClickListener);
        this.hiT.setOnClickListener(onClickListener);
    }
}
