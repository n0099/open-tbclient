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
    public TextView f15085a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f15086b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f15087c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f15088d;

    /* renamed from: e  reason: collision with root package name */
    public int f15089e;

    public ManagerApplyViewHolder(View view) {
        super(view);
        this.f15089e = 3;
        this.f15088d = (LinearLayout) view.findViewById(R.id.root_member_manager_apply);
        this.f15085a = (TextView) view.findViewById(R.id.assist_apply_tip);
        this.f15086b = (TextView) view.findViewById(R.id.assist_left_tv);
        this.f15087c = (RelativeLayout) view.findViewById(R.id.assist_apply_layout);
    }
}
