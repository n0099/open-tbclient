package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.d;
/* loaded from: classes5.dex */
public class q extends v.a {
    public View bER;
    public TextView eWk;
    public TextView eWl;
    public TextView eWm;
    public TextView eWn;
    public RelativeLayout eWo;
    public RelativeLayout eWp;
    public LinearLayout mRootLayout;
    public int mSkinType;

    public q(View view) {
        super(view);
        this.mSkinType = 3;
        this.mRootLayout = (LinearLayout) view.findViewById(d.g.root_member_manager_apply);
        this.bER = view.findViewById(d.g.manager_apply_line);
        this.eWk = (TextView) view.findViewById(d.g.manager_apply_tip);
        this.eWl = (TextView) view.findViewById(d.g.assist_apply_tip);
        this.eWm = (TextView) view.findViewById(d.g.manager_left_tv);
        this.eWn = (TextView) view.findViewById(d.g.assist_left_tv);
        this.eWo = (RelativeLayout) view.findViewById(d.g.manager_apply_layout);
        this.eWp = (RelativeLayout) view.findViewById(d.g.assist_apply_layout);
    }
}
