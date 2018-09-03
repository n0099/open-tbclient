package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class q extends q.a {
    public View akS;
    public TextView djP;
    public TextView djQ;
    public TextView djR;
    public TextView djS;
    public RelativeLayout djT;
    public RelativeLayout djU;
    public LinearLayout mRootLayout;
    public int mSkinType;

    public q(View view) {
        super(view);
        this.mSkinType = 3;
        this.mRootLayout = (LinearLayout) view.findViewById(f.g.root_member_manager_apply);
        this.akS = view.findViewById(f.g.manager_apply_line);
        this.djP = (TextView) view.findViewById(f.g.manager_apply_tip);
        this.djQ = (TextView) view.findViewById(f.g.assist_apply_tip);
        this.djR = (TextView) view.findViewById(f.g.manager_left_tv);
        this.djS = (TextView) view.findViewById(f.g.assist_left_tv);
        this.djT = (RelativeLayout) view.findViewById(f.g.manager_apply_layout);
        this.djU = (RelativeLayout) view.findViewById(f.g.assist_apply_layout);
    }
}
