package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.d;
/* loaded from: classes5.dex */
public class q extends v.a {
    public View bEU;
    public TextView eVX;
    public TextView eVY;
    public TextView eVZ;
    public TextView eWa;
    public RelativeLayout eWb;
    public RelativeLayout eWc;
    public LinearLayout mRootLayout;
    public int mSkinType;

    public q(View view) {
        super(view);
        this.mSkinType = 3;
        this.mRootLayout = (LinearLayout) view.findViewById(d.g.root_member_manager_apply);
        this.bEU = view.findViewById(d.g.manager_apply_line);
        this.eVX = (TextView) view.findViewById(d.g.manager_apply_tip);
        this.eVY = (TextView) view.findViewById(d.g.assist_apply_tip);
        this.eVZ = (TextView) view.findViewById(d.g.manager_left_tv);
        this.eWa = (TextView) view.findViewById(d.g.assist_left_tv);
        this.eWb = (RelativeLayout) view.findViewById(d.g.manager_apply_layout);
        this.eWc = (RelativeLayout) view.findViewById(d.g.assist_apply_layout);
    }
}
