package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class PrivateMgrApplyViewHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public TextView f15942a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f15943b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f15944c;

    /* renamed from: d  reason: collision with root package name */
    public View f15945d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f15946e;

    /* renamed from: f  reason: collision with root package name */
    public int f15947f;

    public PrivateMgrApplyViewHolder(View view) {
        super(view);
        this.f15947f = 3;
        this.f15946e = (LinearLayout) view.findViewById(R.id.root_private_member_apply);
        this.f15945d = view.findViewById(R.id.private_apply_line);
        this.f15942a = (TextView) view.findViewById(R.id.private_apply_tip);
        this.f15943b = (TextView) view.findViewById(R.id.private_left_tv);
        this.f15944c = (RelativeLayout) view.findViewById(R.id.private_apply_layout);
    }
}
