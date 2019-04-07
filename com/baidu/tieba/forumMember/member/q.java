package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.d;
/* loaded from: classes5.dex */
public class q extends v.a {
    public View bET;
    public TextView eVW;
    public TextView eVX;
    public TextView eVY;
    public TextView eVZ;
    public RelativeLayout eWa;
    public RelativeLayout eWb;
    public LinearLayout mRootLayout;
    public int mSkinType;

    public q(View view) {
        super(view);
        this.mSkinType = 3;
        this.mRootLayout = (LinearLayout) view.findViewById(d.g.root_member_manager_apply);
        this.bET = view.findViewById(d.g.manager_apply_line);
        this.eVW = (TextView) view.findViewById(d.g.manager_apply_tip);
        this.eVX = (TextView) view.findViewById(d.g.assist_apply_tip);
        this.eVY = (TextView) view.findViewById(d.g.manager_left_tv);
        this.eVZ = (TextView) view.findViewById(d.g.assist_left_tv);
        this.eWa = (RelativeLayout) view.findViewById(d.g.manager_apply_layout);
        this.eWb = (RelativeLayout) view.findViewById(d.g.assist_apply_layout);
    }
}
