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
    public TextView f15132a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f15133b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f15134c;

    /* renamed from: d  reason: collision with root package name */
    public View f15135d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f15136e;

    /* renamed from: f  reason: collision with root package name */
    public int f15137f;

    public PrivateMgrApplyViewHolder(View view) {
        super(view);
        this.f15137f = 3;
        this.f15136e = (LinearLayout) view.findViewById(R.id.root_private_member_apply);
        this.f15135d = view.findViewById(R.id.private_apply_line);
        this.f15132a = (TextView) view.findViewById(R.id.private_apply_tip);
        this.f15133b = (TextView) view.findViewById(R.id.private_left_tv);
        this.f15134c = (RelativeLayout) view.findViewById(R.id.private_apply_layout);
    }
}
