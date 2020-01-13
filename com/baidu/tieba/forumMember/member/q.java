package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class q extends v.a {
    public TextView gjt;
    public TextView gju;
    public RelativeLayout gjv;
    public LinearLayout mRootLayout;
    public int mSkinType;

    public q(View view) {
        super(view);
        this.mSkinType = 3;
        this.mRootLayout = (LinearLayout) view.findViewById(R.id.root_member_manager_apply);
        this.gjt = (TextView) view.findViewById(R.id.assist_apply_tip);
        this.gju = (TextView) view.findViewById(R.id.assist_left_tv);
        this.gjv = (RelativeLayout) view.findViewById(R.id.assist_apply_layout);
    }
}
