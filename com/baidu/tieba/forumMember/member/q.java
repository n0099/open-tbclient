package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class q extends r.a {
    public View aRq;
    public TextView dCf;
    public TextView dCg;
    public TextView dCh;
    public TextView dCi;
    public RelativeLayout dCj;
    public RelativeLayout dCk;
    public LinearLayout mRootLayout;
    public int mSkinType;

    public q(View view) {
        super(view);
        this.mSkinType = 3;
        this.mRootLayout = (LinearLayout) view.findViewById(d.g.root_member_manager_apply);
        this.aRq = view.findViewById(d.g.manager_apply_line);
        this.dCf = (TextView) view.findViewById(d.g.manager_apply_tip);
        this.dCg = (TextView) view.findViewById(d.g.assist_apply_tip);
        this.dCh = (TextView) view.findViewById(d.g.manager_left_tv);
        this.dCi = (TextView) view.findViewById(d.g.assist_left_tv);
        this.dCj = (RelativeLayout) view.findViewById(d.g.manager_apply_layout);
        this.dCk = (RelativeLayout) view.findViewById(d.g.assist_apply_layout);
    }
}
