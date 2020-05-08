package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class k extends y.a {
    public ImageView gTV;
    public TextView gTW;
    public TextView gUX;
    public TextView gUY;
    public LinearLayout gUZ;
    public TextView gVa;
    public NoPressedLinearLayout gVb;
    public View gVc;
    public TextView gVd;
    public ImageView gVe;
    public ImageView gVf;
    public View mDivider;

    public k(View view, View.OnClickListener onClickListener) {
        super(view);
        this.gUX = (TextView) view.findViewById(R.id.like_btn);
        this.gUY = (TextView) view.findViewById(R.id.lever_tip_view);
        this.gTV = (ImageView) view.findViewById(R.id.header_level_img);
        this.gTW = (TextView) view.findViewById(R.id.user_level_name);
        this.mDivider = view.findViewById(R.id.header_divider_line2);
        this.gUZ = (LinearLayout) view.findViewById(R.id.view_experience_score);
        this.gVa = (TextView) view.findViewById(R.id.tip_experience_score);
        this.gVb = (NoPressedLinearLayout) view.findViewById(R.id.root_forum_member_header);
        this.gVc = view.findViewById(R.id.header_divider_line3);
        this.gVd = (TextView) view.findViewById(R.id.tip_experience);
        this.gVe = (ImageView) view.findViewById(R.id.love_level_top);
        this.gVf = (ImageView) view.findViewById(R.id.love_level_bg);
        this.gUX.setOnClickListener(onClickListener);
        this.gTW.setOnClickListener(onClickListener);
    }
}
