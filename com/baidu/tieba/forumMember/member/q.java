package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class q extends q.a {
    public View acO;
    public TextView cUU;
    public TextView cUV;
    public TextView cUW;
    public TextView cUX;
    public RelativeLayout cUY;
    public RelativeLayout cUZ;
    public LinearLayout mRootLayout;
    public int mSkinType;

    public q(View view2) {
        super(view2);
        this.mSkinType = 3;
        this.mRootLayout = (LinearLayout) view2.findViewById(d.g.root_member_manager_apply);
        this.acO = view2.findViewById(d.g.manager_apply_line);
        this.cUU = (TextView) view2.findViewById(d.g.manager_apply_tip);
        this.cUV = (TextView) view2.findViewById(d.g.assist_apply_tip);
        this.cUW = (TextView) view2.findViewById(d.g.manager_left_tv);
        this.cUX = (TextView) view2.findViewById(d.g.assist_left_tv);
        this.cUY = (RelativeLayout) view2.findViewById(d.g.manager_apply_layout);
        this.cUZ = (RelativeLayout) view2.findViewById(d.g.assist_apply_layout);
    }
}
