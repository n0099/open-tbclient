package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class q extends aa.a {
    public TextView hkA;
    public TextView hkB;
    public RelativeLayout hkC;
    public LinearLayout mRootLayout;
    public int mSkinType;

    public q(View view) {
        super(view);
        this.mSkinType = 3;
        this.mRootLayout = (LinearLayout) view.findViewById(R.id.root_member_manager_apply);
        this.hkA = (TextView) view.findViewById(R.id.assist_apply_tip);
        this.hkB = (TextView) view.findViewById(R.id.assist_left_tv);
        this.hkC = (RelativeLayout) view.findViewById(R.id.assist_apply_layout);
    }
}
