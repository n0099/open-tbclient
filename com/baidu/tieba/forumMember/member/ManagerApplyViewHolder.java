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
    public TextView f15937a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f15938b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f15939c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f15940d;

    /* renamed from: e  reason: collision with root package name */
    public int f15941e;

    public ManagerApplyViewHolder(View view) {
        super(view);
        this.f15941e = 3;
        this.f15940d = (LinearLayout) view.findViewById(R.id.root_member_manager_apply);
        this.f15937a = (TextView) view.findViewById(R.id.assist_apply_tip);
        this.f15938b = (TextView) view.findViewById(R.id.assist_left_tv);
        this.f15939c = (RelativeLayout) view.findViewById(R.id.assist_apply_layout);
    }
}
