package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class q extends aa.a {
    public TextView hkp;
    public TextView hkq;
    public RelativeLayout hkr;
    public LinearLayout mRootLayout;
    public int mSkinType;

    public q(View view) {
        super(view);
        this.mSkinType = 3;
        this.mRootLayout = (LinearLayout) view.findViewById(R.id.root_member_manager_apply);
        this.hkp = (TextView) view.findViewById(R.id.assist_apply_tip);
        this.hkq = (TextView) view.findViewById(R.id.assist_left_tv);
        this.hkr = (RelativeLayout) view.findViewById(R.id.assist_apply_layout);
    }
}
