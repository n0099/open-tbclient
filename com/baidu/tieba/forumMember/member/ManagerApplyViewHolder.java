package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class ManagerApplyViewHolder extends TypeAdapter.ViewHolder {
    public TextView jdd;
    public TextView jde;
    public RelativeLayout jdf;
    public LinearLayout mRootLayout;
    public int mSkinType;

    public ManagerApplyViewHolder(View view) {
        super(view);
        this.mSkinType = 3;
        this.mRootLayout = (LinearLayout) view.findViewById(R.id.root_member_manager_apply);
        this.jdd = (TextView) view.findViewById(R.id.assist_apply_tip);
        this.jde = (TextView) view.findViewById(R.id.assist_left_tv);
        this.jdf = (RelativeLayout) view.findViewById(R.id.assist_apply_layout);
    }
}
