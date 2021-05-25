package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class ComplaintBarlordViewHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public int f14962a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f14963b;

    /* renamed from: c  reason: collision with root package name */
    public View f14964c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f14965d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f14966e;

    public ComplaintBarlordViewHolder(View view) {
        super(view);
        this.f14962a = 3;
        this.f14963b = (RelativeLayout) view.findViewById(R.id.bar_info_complaint_lay);
        this.f14964c = view.findViewById(R.id.info_complaint_diver_top);
        this.f14965d = (TextView) view.findViewById(R.id.bar_info_complaint_tv);
        this.f14966e = (ImageView) view.findViewById(R.id.bar_info_complaint_img);
    }
}
