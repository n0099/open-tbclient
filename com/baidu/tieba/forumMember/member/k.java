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
    public ImageView gTP;
    public TextView gTQ;
    public TextView gUR;
    public TextView gUS;
    public LinearLayout gUT;
    public TextView gUU;
    public NoPressedLinearLayout gUV;
    public View gUW;
    public TextView gUX;
    public ImageView gUY;
    public ImageView gUZ;
    public View mDivider;

    public k(View view, View.OnClickListener onClickListener) {
        super(view);
        this.gUR = (TextView) view.findViewById(R.id.like_btn);
        this.gUS = (TextView) view.findViewById(R.id.lever_tip_view);
        this.gTP = (ImageView) view.findViewById(R.id.header_level_img);
        this.gTQ = (TextView) view.findViewById(R.id.user_level_name);
        this.mDivider = view.findViewById(R.id.header_divider_line2);
        this.gUT = (LinearLayout) view.findViewById(R.id.view_experience_score);
        this.gUU = (TextView) view.findViewById(R.id.tip_experience_score);
        this.gUV = (NoPressedLinearLayout) view.findViewById(R.id.root_forum_member_header);
        this.gUW = view.findViewById(R.id.header_divider_line3);
        this.gUX = (TextView) view.findViewById(R.id.tip_experience);
        this.gUY = (ImageView) view.findViewById(R.id.love_level_top);
        this.gUZ = (ImageView) view.findViewById(R.id.love_level_bg);
        this.gUR.setOnClickListener(onClickListener);
        this.gTQ.setOnClickListener(onClickListener);
    }
}
