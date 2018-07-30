package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class q extends q.a {
    public View akS;
    public TextView djR;
    public TextView djS;
    public TextView djT;
    public TextView djU;
    public RelativeLayout djV;
    public RelativeLayout djW;
    public LinearLayout mRootLayout;
    public int mSkinType;

    public q(View view) {
        super(view);
        this.mSkinType = 3;
        this.mRootLayout = (LinearLayout) view.findViewById(d.g.root_member_manager_apply);
        this.akS = view.findViewById(d.g.manager_apply_line);
        this.djR = (TextView) view.findViewById(d.g.manager_apply_tip);
        this.djS = (TextView) view.findViewById(d.g.assist_apply_tip);
        this.djT = (TextView) view.findViewById(d.g.manager_left_tv);
        this.djU = (TextView) view.findViewById(d.g.assist_left_tv);
        this.djV = (RelativeLayout) view.findViewById(d.g.manager_apply_layout);
        this.djW = (RelativeLayout) view.findViewById(d.g.assist_apply_layout);
    }
}
