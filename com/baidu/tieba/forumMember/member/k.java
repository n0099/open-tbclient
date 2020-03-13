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
    public ImageView gka;
    public TextView gkb;
    public TextView gld;
    public TextView gle;
    public LinearLayout glf;
    public TextView glg;
    public NoPressedLinearLayout glh;
    public View gli;
    public TextView glj;
    public ImageView glk;
    public ImageView gll;
    public View mDivider;

    public k(View view, View.OnClickListener onClickListener) {
        super(view);
        this.gld = (TextView) view.findViewById(R.id.like_btn);
        this.gle = (TextView) view.findViewById(R.id.lever_tip_view);
        this.gka = (ImageView) view.findViewById(R.id.header_level_img);
        this.gkb = (TextView) view.findViewById(R.id.user_level_name);
        this.mDivider = view.findViewById(R.id.header_divider_line2);
        this.glf = (LinearLayout) view.findViewById(R.id.view_experience_score);
        this.glg = (TextView) view.findViewById(R.id.tip_experience_score);
        this.glh = (NoPressedLinearLayout) view.findViewById(R.id.root_forum_member_header);
        this.gli = view.findViewById(R.id.header_divider_line3);
        this.glj = (TextView) view.findViewById(R.id.tip_experience);
        this.glk = (ImageView) view.findViewById(R.id.love_level_top);
        this.gll = (ImageView) view.findViewById(R.id.love_level_bg);
        this.gld.setOnClickListener(onClickListener);
        this.gkb.setOnClickListener(onClickListener);
    }
}
