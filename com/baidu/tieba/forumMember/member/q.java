package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class q extends q.a {
    public View any;
    public TextView dpI;
    public TextView dpJ;
    public TextView dpK;
    public TextView dpL;
    public RelativeLayout dpM;
    public RelativeLayout dpN;
    public LinearLayout mRootLayout;
    public int mSkinType;

    public q(View view) {
        super(view);
        this.mSkinType = 3;
        this.mRootLayout = (LinearLayout) view.findViewById(e.g.root_member_manager_apply);
        this.any = view.findViewById(e.g.manager_apply_line);
        this.dpI = (TextView) view.findViewById(e.g.manager_apply_tip);
        this.dpJ = (TextView) view.findViewById(e.g.assist_apply_tip);
        this.dpK = (TextView) view.findViewById(e.g.manager_left_tv);
        this.dpL = (TextView) view.findViewById(e.g.assist_left_tv);
        this.dpM = (RelativeLayout) view.findViewById(e.g.manager_apply_layout);
        this.dpN = (RelativeLayout) view.findViewById(e.g.assist_apply_layout);
    }
}
