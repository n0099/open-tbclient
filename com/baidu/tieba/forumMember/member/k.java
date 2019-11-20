package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class k extends v.a {
    public View bgU;
    public ImageView fqe;
    public TextView fqf;
    public TextView frg;
    public TextView frh;
    public LinearLayout fri;
    public TextView frj;
    public NoPressedLinearLayout frk;
    public View frl;
    public TextView frm;
    public ImageView frn;
    public ImageView fro;

    public k(View view, View.OnClickListener onClickListener) {
        super(view);
        this.frg = (TextView) view.findViewById(R.id.like_btn);
        this.frh = (TextView) view.findViewById(R.id.lever_tip_view);
        this.fqe = (ImageView) view.findViewById(R.id.header_level_img);
        this.fqf = (TextView) view.findViewById(R.id.user_level_name);
        this.bgU = view.findViewById(R.id.header_divider_line2);
        this.fri = (LinearLayout) view.findViewById(R.id.view_experience_score);
        this.frj = (TextView) view.findViewById(R.id.tip_experience_score);
        this.frk = (NoPressedLinearLayout) view.findViewById(R.id.root_forum_member_header);
        this.frl = view.findViewById(R.id.header_divider_line3);
        this.frm = (TextView) view.findViewById(R.id.tip_experience);
        this.frn = (ImageView) view.findViewById(R.id.love_level_top);
        this.fro = (ImageView) view.findViewById(R.id.love_level_bg);
        this.frg.setOnClickListener(onClickListener);
        this.fqf.setOnClickListener(onClickListener);
    }
}
