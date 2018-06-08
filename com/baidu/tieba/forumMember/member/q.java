package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class q extends q.a {
    public View akT;
    public TextView dfk;
    public TextView dfl;
    public TextView dfm;
    public TextView dfn;
    public RelativeLayout dfo;
    public RelativeLayout dfp;
    public LinearLayout mRootLayout;
    public int mSkinType;

    public q(View view) {
        super(view);
        this.mSkinType = 3;
        this.mRootLayout = (LinearLayout) view.findViewById(d.g.root_member_manager_apply);
        this.akT = view.findViewById(d.g.manager_apply_line);
        this.dfk = (TextView) view.findViewById(d.g.manager_apply_tip);
        this.dfl = (TextView) view.findViewById(d.g.assist_apply_tip);
        this.dfm = (TextView) view.findViewById(d.g.manager_left_tv);
        this.dfn = (TextView) view.findViewById(d.g.assist_left_tv);
        this.dfo = (RelativeLayout) view.findViewById(d.g.manager_apply_layout);
        this.dfp = (RelativeLayout) view.findViewById(d.g.assist_apply_layout);
    }
}
