package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class q extends q.a {
    public View acP;
    public TextView cVY;
    public TextView cVZ;
    public TextView cWa;
    public TextView cWb;
    public RelativeLayout cWc;
    public RelativeLayout cWd;
    public LinearLayout mRootLayout;
    public int mSkinType;

    public q(View view2) {
        super(view2);
        this.mSkinType = 3;
        this.mRootLayout = (LinearLayout) view2.findViewById(d.g.root_member_manager_apply);
        this.acP = view2.findViewById(d.g.manager_apply_line);
        this.cVY = (TextView) view2.findViewById(d.g.manager_apply_tip);
        this.cVZ = (TextView) view2.findViewById(d.g.assist_apply_tip);
        this.cWa = (TextView) view2.findViewById(d.g.manager_left_tv);
        this.cWb = (TextView) view2.findViewById(d.g.assist_left_tv);
        this.cWc = (RelativeLayout) view2.findViewById(d.g.manager_apply_layout);
        this.cWd = (RelativeLayout) view2.findViewById(d.g.assist_apply_layout);
    }
}
