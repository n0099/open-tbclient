package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class q extends r.a {
    public View aRs;
    public TextView dCi;
    public TextView dCj;
    public TextView dCk;
    public TextView dCl;
    public RelativeLayout dCm;
    public RelativeLayout dCn;
    public LinearLayout mRootLayout;
    public int mSkinType;

    public q(View view) {
        super(view);
        this.mSkinType = 3;
        this.mRootLayout = (LinearLayout) view.findViewById(d.g.root_member_manager_apply);
        this.aRs = view.findViewById(d.g.manager_apply_line);
        this.dCi = (TextView) view.findViewById(d.g.manager_apply_tip);
        this.dCj = (TextView) view.findViewById(d.g.assist_apply_tip);
        this.dCk = (TextView) view.findViewById(d.g.manager_left_tv);
        this.dCl = (TextView) view.findViewById(d.g.assist_left_tv);
        this.dCm = (RelativeLayout) view.findViewById(d.g.manager_apply_layout);
        this.dCn = (RelativeLayout) view.findViewById(d.g.assist_apply_layout);
    }
}
