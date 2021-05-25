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
    public TextView f14988a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f14989b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f14990c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f14991d;

    /* renamed from: e  reason: collision with root package name */
    public int f14992e;

    public ManagerApplyViewHolder(View view) {
        super(view);
        this.f14992e = 3;
        this.f14991d = (LinearLayout) view.findViewById(R.id.root_member_manager_apply);
        this.f14988a = (TextView) view.findViewById(R.id.assist_apply_tip);
        this.f14989b = (TextView) view.findViewById(R.id.assist_left_tv);
        this.f14990c = (RelativeLayout) view.findViewById(R.id.assist_apply_layout);
    }
}
