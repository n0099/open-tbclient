package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class q extends q.a {
    public View alt;
    public TextView dhb;
    public TextView dhc;
    public TextView dhd;
    public TextView dhe;
    public RelativeLayout dhf;
    public RelativeLayout dhg;
    public LinearLayout mRootLayout;
    public int mSkinType;

    public q(View view) {
        super(view);
        this.mSkinType = 3;
        this.mRootLayout = (LinearLayout) view.findViewById(d.g.root_member_manager_apply);
        this.alt = view.findViewById(d.g.manager_apply_line);
        this.dhb = (TextView) view.findViewById(d.g.manager_apply_tip);
        this.dhc = (TextView) view.findViewById(d.g.assist_apply_tip);
        this.dhd = (TextView) view.findViewById(d.g.manager_left_tv);
        this.dhe = (TextView) view.findViewById(d.g.assist_left_tv);
        this.dhf = (RelativeLayout) view.findViewById(d.g.manager_apply_layout);
        this.dhg = (RelativeLayout) view.findViewById(d.g.assist_apply_layout);
    }
}
