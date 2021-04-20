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
    public TextView f15603a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f15604b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f15605c;

    /* renamed from: d  reason: collision with root package name */
    public View f15606d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f15607e;

    /* renamed from: f  reason: collision with root package name */
    public int f15608f;

    public PrivateMgrApplyViewHolder(View view) {
        super(view);
        this.f15608f = 3;
        this.f15607e = (LinearLayout) view.findViewById(R.id.root_private_member_apply);
        this.f15606d = view.findViewById(R.id.private_apply_line);
        this.f15603a = (TextView) view.findViewById(R.id.private_apply_tip);
        this.f15604b = (TextView) view.findViewById(R.id.private_left_tv);
        this.f15605c = (RelativeLayout) view.findViewById(R.id.private_apply_layout);
    }
}
