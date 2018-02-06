package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class q extends r.a {
    public View aRB;
    public TextView dCr;
    public TextView dCs;
    public TextView dCt;
    public TextView dCu;
    public RelativeLayout dCv;
    public RelativeLayout dCw;
    public LinearLayout mRootLayout;
    public int mSkinType;

    public q(View view) {
        super(view);
        this.mSkinType = 3;
        this.mRootLayout = (LinearLayout) view.findViewById(d.g.root_member_manager_apply);
        this.aRB = view.findViewById(d.g.manager_apply_line);
        this.dCr = (TextView) view.findViewById(d.g.manager_apply_tip);
        this.dCs = (TextView) view.findViewById(d.g.assist_apply_tip);
        this.dCt = (TextView) view.findViewById(d.g.manager_left_tv);
        this.dCu = (TextView) view.findViewById(d.g.assist_left_tv);
        this.dCv = (RelativeLayout) view.findViewById(d.g.manager_apply_layout);
        this.dCw = (RelativeLayout) view.findViewById(d.g.assist_apply_layout);
    }
}
