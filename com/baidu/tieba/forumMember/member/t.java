package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.d;
/* loaded from: classes5.dex */
public class t extends v.a {
    public View bER;
    public TextView eWl;
    public TextView eWn;
    public RelativeLayout eWp;
    public LinearLayout mRootLayout;
    public int mSkinType;

    public t(View view) {
        super(view);
        this.mSkinType = 3;
        this.mRootLayout = (LinearLayout) view.findViewById(d.g.root_private_member_apply);
        this.bER = view.findViewById(d.g.private_apply_line);
        this.eWl = (TextView) view.findViewById(d.g.private_apply_tip);
        this.eWn = (TextView) view.findViewById(d.g.private_left_tv);
        this.eWp = (RelativeLayout) view.findViewById(d.g.private_apply_layout);
    }
}
