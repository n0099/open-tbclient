package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class q extends q.a {
    public View awG;
    public TextView dIp;
    public TextView dIq;
    public TextView dIr;
    public TextView dIs;
    public RelativeLayout dIt;
    public RelativeLayout dIu;
    public LinearLayout mRootLayout;
    public int mSkinType;

    public q(View view) {
        super(view);
        this.mSkinType = 3;
        this.mRootLayout = (LinearLayout) view.findViewById(e.g.root_member_manager_apply);
        this.awG = view.findViewById(e.g.manager_apply_line);
        this.dIp = (TextView) view.findViewById(e.g.manager_apply_tip);
        this.dIq = (TextView) view.findViewById(e.g.assist_apply_tip);
        this.dIr = (TextView) view.findViewById(e.g.manager_left_tv);
        this.dIs = (TextView) view.findViewById(e.g.assist_left_tv);
        this.dIt = (RelativeLayout) view.findViewById(e.g.manager_apply_layout);
        this.dIu = (RelativeLayout) view.findViewById(e.g.assist_apply_layout);
    }
}
