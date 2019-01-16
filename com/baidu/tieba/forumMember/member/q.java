package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class q extends q.a {
    public View axi;
    public TextView dIY;
    public TextView dIZ;
    public TextView dJa;
    public TextView dJb;
    public RelativeLayout dJc;
    public RelativeLayout dJd;
    public LinearLayout mRootLayout;
    public int mSkinType;

    public q(View view) {
        super(view);
        this.mSkinType = 3;
        this.mRootLayout = (LinearLayout) view.findViewById(e.g.root_member_manager_apply);
        this.axi = view.findViewById(e.g.manager_apply_line);
        this.dIY = (TextView) view.findViewById(e.g.manager_apply_tip);
        this.dIZ = (TextView) view.findViewById(e.g.assist_apply_tip);
        this.dJa = (TextView) view.findViewById(e.g.manager_left_tv);
        this.dJb = (TextView) view.findViewById(e.g.assist_left_tv);
        this.dJc = (RelativeLayout) view.findViewById(e.g.manager_apply_layout);
        this.dJd = (RelativeLayout) view.findViewById(e.g.assist_apply_layout);
    }
}
