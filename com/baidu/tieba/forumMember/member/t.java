package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tieba.R;
/* loaded from: classes17.dex */
public class t extends af.a {
    public TextView hPP;
    public TextView hPQ;
    public RelativeLayout hPR;
    public View mLineView;
    public LinearLayout mRootLayout;
    public int mSkinType;

    public t(View view) {
        super(view);
        this.mSkinType = 3;
        this.mRootLayout = (LinearLayout) view.findViewById(R.id.root_private_member_apply);
        this.mLineView = view.findViewById(R.id.private_apply_line);
        this.hPP = (TextView) view.findViewById(R.id.private_apply_tip);
        this.hPQ = (TextView) view.findViewById(R.id.private_left_tv);
        this.hPR = (RelativeLayout) view.findViewById(R.id.private_apply_layout);
    }
}
