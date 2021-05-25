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
    public TextView f14993a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f14994b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f14995c;

    /* renamed from: d  reason: collision with root package name */
    public View f14996d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f14997e;

    /* renamed from: f  reason: collision with root package name */
    public int f14998f;

    public PrivateMgrApplyViewHolder(View view) {
        super(view);
        this.f14998f = 3;
        this.f14997e = (LinearLayout) view.findViewById(R.id.root_private_member_apply);
        this.f14996d = view.findViewById(R.id.private_apply_line);
        this.f14993a = (TextView) view.findViewById(R.id.private_apply_tip);
        this.f14994b = (TextView) view.findViewById(R.id.private_left_tv);
        this.f14995c = (RelativeLayout) view.findViewById(R.id.private_apply_layout);
    }
}
