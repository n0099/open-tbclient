package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class q extends q.a {
    public View awF;
    public TextView dFB;
    public TextView dFC;
    public TextView dFD;
    public TextView dFE;
    public RelativeLayout dFF;
    public RelativeLayout dFG;
    public LinearLayout mRootLayout;
    public int mSkinType;

    public q(View view) {
        super(view);
        this.mSkinType = 3;
        this.mRootLayout = (LinearLayout) view.findViewById(e.g.root_member_manager_apply);
        this.awF = view.findViewById(e.g.manager_apply_line);
        this.dFB = (TextView) view.findViewById(e.g.manager_apply_tip);
        this.dFC = (TextView) view.findViewById(e.g.assist_apply_tip);
        this.dFD = (TextView) view.findViewById(e.g.manager_left_tv);
        this.dFE = (TextView) view.findViewById(e.g.assist_left_tv);
        this.dFF = (RelativeLayout) view.findViewById(e.g.manager_apply_layout);
        this.dFG = (RelativeLayout) view.findViewById(e.g.assist_apply_layout);
    }
}
