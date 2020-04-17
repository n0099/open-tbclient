package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class t extends y.a {
    public TextView gVx;
    public TextView gVy;
    public RelativeLayout gVz;
    public View mLineView;
    public LinearLayout mRootLayout;
    public int mSkinType;

    public t(View view) {
        super(view);
        this.mSkinType = 3;
        this.mRootLayout = (LinearLayout) view.findViewById(R.id.root_private_member_apply);
        this.mLineView = view.findViewById(R.id.private_apply_line);
        this.gVx = (TextView) view.findViewById(R.id.private_apply_tip);
        this.gVy = (TextView) view.findViewById(R.id.private_left_tv);
        this.gVz = (RelativeLayout) view.findViewById(R.id.private_apply_layout);
    }
}
