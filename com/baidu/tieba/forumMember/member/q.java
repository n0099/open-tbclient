package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class q extends q.a {
    public View atf;
    public TextView dzc;
    public TextView dzd;
    public TextView dze;
    public TextView dzf;
    public RelativeLayout dzg;
    public RelativeLayout dzh;
    public LinearLayout mRootLayout;
    public int mSkinType;

    public q(View view) {
        super(view);
        this.mSkinType = 3;
        this.mRootLayout = (LinearLayout) view.findViewById(e.g.root_member_manager_apply);
        this.atf = view.findViewById(e.g.manager_apply_line);
        this.dzc = (TextView) view.findViewById(e.g.manager_apply_tip);
        this.dzd = (TextView) view.findViewById(e.g.assist_apply_tip);
        this.dze = (TextView) view.findViewById(e.g.manager_left_tv);
        this.dzf = (TextView) view.findViewById(e.g.assist_left_tv);
        this.dzg = (RelativeLayout) view.findViewById(e.g.manager_apply_layout);
        this.dzh = (RelativeLayout) view.findViewById(e.g.assist_apply_layout);
    }
}
