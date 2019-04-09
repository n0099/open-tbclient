package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.d;
/* loaded from: classes5.dex */
public class t extends v.a {
    public View bEU;
    public TextView eVY;
    public TextView eWa;
    public RelativeLayout eWc;
    public LinearLayout mRootLayout;
    public int mSkinType;

    public t(View view) {
        super(view);
        this.mSkinType = 3;
        this.mRootLayout = (LinearLayout) view.findViewById(d.g.root_private_member_apply);
        this.bEU = view.findViewById(d.g.private_apply_line);
        this.eVY = (TextView) view.findViewById(d.g.private_apply_tip);
        this.eWa = (TextView) view.findViewById(d.g.private_left_tv);
        this.eWc = (RelativeLayout) view.findViewById(d.g.private_apply_layout);
    }
}
