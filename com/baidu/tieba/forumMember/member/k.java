package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class k extends ad.a {
    public TextView eay;
    public ImageView hvb;
    public TextView hvc;
    public TextView hwc;
    public TextView hwd;
    public LinearLayout hwe;
    public NoPressedLinearLayout hwf;
    public View hwg;
    public TextView hwh;
    public ImageView hwi;
    public ImageView hwj;
    public View mDivider;

    public k(View view, View.OnClickListener onClickListener) {
        super(view);
        this.hwc = (TextView) view.findViewById(R.id.like_btn);
        this.hwd = (TextView) view.findViewById(R.id.lever_tip_view);
        this.hvb = (ImageView) view.findViewById(R.id.header_level_img);
        this.hvc = (TextView) view.findViewById(R.id.user_level_name);
        this.mDivider = view.findViewById(R.id.header_divider_line2);
        this.hwe = (LinearLayout) view.findViewById(R.id.view_experience_score);
        this.eay = (TextView) view.findViewById(R.id.tip_experience_score);
        this.hwf = (NoPressedLinearLayout) view.findViewById(R.id.root_forum_member_header);
        this.hwg = view.findViewById(R.id.header_divider_line3);
        this.hwh = (TextView) view.findViewById(R.id.tip_experience);
        this.hwi = (ImageView) view.findViewById(R.id.love_level_top);
        this.hwj = (ImageView) view.findViewById(R.id.love_level_bg);
        this.hwc.setOnClickListener(onClickListener);
        this.hvc.setOnClickListener(onClickListener);
    }
}
