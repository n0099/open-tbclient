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
    public TextView f15050a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f15051b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f15052c;

    /* renamed from: d  reason: collision with root package name */
    public View f15053d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f15054e;

    /* renamed from: f  reason: collision with root package name */
    public int f15055f;

    public PrivateMgrApplyViewHolder(View view) {
        super(view);
        this.f15055f = 3;
        this.f15054e = (LinearLayout) view.findViewById(R.id.root_private_member_apply);
        this.f15053d = view.findViewById(R.id.private_apply_line);
        this.f15050a = (TextView) view.findViewById(R.id.private_apply_tip);
        this.f15051b = (TextView) view.findViewById(R.id.private_left_tv);
        this.f15052c = (RelativeLayout) view.findViewById(R.id.private_apply_layout);
    }
}
