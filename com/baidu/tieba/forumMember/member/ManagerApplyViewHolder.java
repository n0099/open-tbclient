package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class ManagerApplyViewHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public TextView f15936a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f15937b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f15938c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f15939d;

    /* renamed from: e  reason: collision with root package name */
    public int f15940e;

    public ManagerApplyViewHolder(View view) {
        super(view);
        this.f15940e = 3;
        this.f15939d = (LinearLayout) view.findViewById(R.id.root_member_manager_apply);
        this.f15936a = (TextView) view.findViewById(R.id.assist_apply_tip);
        this.f15937b = (TextView) view.findViewById(R.id.assist_left_tv);
        this.f15938c = (RelativeLayout) view.findViewById(R.id.assist_apply_layout);
    }
}
