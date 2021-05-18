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
    public TextView f15090a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f15091b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f15092c;

    /* renamed from: d  reason: collision with root package name */
    public View f15093d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f15094e;

    /* renamed from: f  reason: collision with root package name */
    public int f15095f;

    public PrivateMgrApplyViewHolder(View view) {
        super(view);
        this.f15095f = 3;
        this.f15094e = (LinearLayout) view.findViewById(R.id.root_private_member_apply);
        this.f15093d = view.findViewById(R.id.private_apply_line);
        this.f15090a = (TextView) view.findViewById(R.id.private_apply_tip);
        this.f15091b = (TextView) view.findViewById(R.id.private_left_tv);
        this.f15092c = (RelativeLayout) view.findViewById(R.id.private_apply_layout);
    }
}
