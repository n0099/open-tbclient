package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class q extends q.a {
    public View ass;
    public TextView dxK;
    public TextView dxL;
    public TextView dxM;
    public TextView dxN;
    public RelativeLayout dxO;
    public RelativeLayout dxP;
    public LinearLayout mRootLayout;
    public int mSkinType;

    public q(View view) {
        super(view);
        this.mSkinType = 3;
        this.mRootLayout = (LinearLayout) view.findViewById(e.g.root_member_manager_apply);
        this.ass = view.findViewById(e.g.manager_apply_line);
        this.dxK = (TextView) view.findViewById(e.g.manager_apply_tip);
        this.dxL = (TextView) view.findViewById(e.g.assist_apply_tip);
        this.dxM = (TextView) view.findViewById(e.g.manager_left_tv);
        this.dxN = (TextView) view.findViewById(e.g.assist_left_tv);
        this.dxO = (RelativeLayout) view.findViewById(e.g.manager_apply_layout);
        this.dxP = (RelativeLayout) view.findViewById(e.g.assist_apply_layout);
    }
}
