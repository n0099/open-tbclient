package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class PrivateMgrApplyViewHolder extends TypeAdapter.ViewHolder {
    public TextView jcd;
    public TextView jce;
    public RelativeLayout jcf;
    public View mLineView;
    public LinearLayout mRootLayout;
    public int mSkinType;

    public PrivateMgrApplyViewHolder(View view) {
        super(view);
        this.mSkinType = 3;
        this.mRootLayout = (LinearLayout) view.findViewById(R.id.root_private_member_apply);
        this.mLineView = view.findViewById(R.id.private_apply_line);
        this.jcd = (TextView) view.findViewById(R.id.private_apply_tip);
        this.jce = (TextView) view.findViewById(R.id.private_left_tv);
        this.jcf = (RelativeLayout) view.findViewById(R.id.private_apply_layout);
    }
}
