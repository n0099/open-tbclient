package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class t extends v.a {
    public View bMp;
    public TextView fmg;
    public TextView fmh;
    public RelativeLayout fmi;
    public LinearLayout mRootLayout;
    public int mSkinType;

    public t(View view) {
        super(view);
        this.mSkinType = 3;
        this.mRootLayout = (LinearLayout) view.findViewById(R.id.root_private_member_apply);
        this.bMp = view.findViewById(R.id.private_apply_line);
        this.fmg = (TextView) view.findViewById(R.id.private_apply_tip);
        this.fmh = (TextView) view.findViewById(R.id.private_left_tv);
        this.fmi = (RelativeLayout) view.findViewById(R.id.private_apply_layout);
    }
}
