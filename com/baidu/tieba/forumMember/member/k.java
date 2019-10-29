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
    public View bhm;
    public ImageView fqV;
    public TextView fqW;
    public TextView frY;
    public TextView frZ;
    public LinearLayout fsa;
    public TextView fsb;
    public NoPressedLinearLayout fsc;
    public View fsd;
    public TextView fse;
    public ImageView fsf;
    public ImageView fsg;

    public k(View view, View.OnClickListener onClickListener) {
        super(view);
        this.frY = (TextView) view.findViewById(R.id.like_btn);
        this.frZ = (TextView) view.findViewById(R.id.lever_tip_view);
        this.fqV = (ImageView) view.findViewById(R.id.header_level_img);
        this.fqW = (TextView) view.findViewById(R.id.user_level_name);
        this.bhm = view.findViewById(R.id.header_divider_line2);
        this.fsa = (LinearLayout) view.findViewById(R.id.view_experience_score);
        this.fsb = (TextView) view.findViewById(R.id.tip_experience_score);
        this.fsc = (NoPressedLinearLayout) view.findViewById(R.id.root_forum_member_header);
        this.fsd = view.findViewById(R.id.header_divider_line3);
        this.fse = (TextView) view.findViewById(R.id.tip_experience);
        this.fsf = (ImageView) view.findViewById(R.id.love_level_top);
        this.fsg = (ImageView) view.findViewById(R.id.love_level_bg);
        this.frY.setOnClickListener(onClickListener);
        this.fqW.setOnClickListener(onClickListener);
    }
}
