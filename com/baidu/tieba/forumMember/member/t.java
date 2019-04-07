package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.d;
/* loaded from: classes5.dex */
public class t extends v.a {
    public View bET;
    public TextView eVX;
    public TextView eVZ;
    public RelativeLayout eWb;
    public LinearLayout mRootLayout;
    public int mSkinType;

    public t(View view) {
        super(view);
        this.mSkinType = 3;
        this.mRootLayout = (LinearLayout) view.findViewById(d.g.root_private_member_apply);
        this.bET = view.findViewById(d.g.private_apply_line);
        this.eVX = (TextView) view.findViewById(d.g.private_apply_tip);
        this.eVZ = (TextView) view.findViewById(d.g.private_left_tv);
        this.eWb = (RelativeLayout) view.findViewById(d.g.private_apply_layout);
    }
}
