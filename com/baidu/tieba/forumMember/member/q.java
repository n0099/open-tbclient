package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tieba.R;
/* loaded from: classes23.dex */
public class q extends af.a {
    public TextView iEj;
    public TextView iEk;
    public RelativeLayout iEl;
    public LinearLayout mRootLayout;
    public int mSkinType;

    public q(View view) {
        super(view);
        this.mSkinType = 3;
        this.mRootLayout = (LinearLayout) view.findViewById(R.id.root_member_manager_apply);
        this.iEj = (TextView) view.findViewById(R.id.assist_apply_tip);
        this.iEk = (TextView) view.findViewById(R.id.assist_left_tv);
        this.iEl = (RelativeLayout) view.findViewById(R.id.assist_apply_layout);
    }
}
