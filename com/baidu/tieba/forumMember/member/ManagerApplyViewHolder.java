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
    public TextView f15045a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f15046b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f15047c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f15048d;

    /* renamed from: e  reason: collision with root package name */
    public int f15049e;

    public ManagerApplyViewHolder(View view) {
        super(view);
        this.f15049e = 3;
        this.f15048d = (LinearLayout) view.findViewById(R.id.root_member_manager_apply);
        this.f15045a = (TextView) view.findViewById(R.id.assist_apply_tip);
        this.f15046b = (TextView) view.findViewById(R.id.assist_left_tv);
        this.f15047c = (RelativeLayout) view.findViewById(R.id.assist_apply_layout);
    }
}
