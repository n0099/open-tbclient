package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tieba.R;
/* loaded from: classes17.dex */
public class q extends af.a {
    public TextView hPJ;
    public TextView hPK;
    public RelativeLayout hPL;
    public LinearLayout mRootLayout;
    public int mSkinType;

    public q(View view) {
        super(view);
        this.mSkinType = 3;
        this.mRootLayout = (LinearLayout) view.findViewById(R.id.root_member_manager_apply);
        this.hPJ = (TextView) view.findViewById(R.id.assist_apply_tip);
        this.hPK = (TextView) view.findViewById(R.id.assist_left_tv);
        this.hPL = (RelativeLayout) view.findViewById(R.id.assist_apply_layout);
    }
}
