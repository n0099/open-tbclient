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
    public int f15744a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f15745b;

    /* renamed from: c  reason: collision with root package name */
    public View f15746c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f15747d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f15748e;

    public ComplaintBarlordViewHolder(View view) {
        super(view);
        this.f15744a = 3;
        this.f15745b = (RelativeLayout) view.findViewById(R.id.bar_info_complaint_lay);
        this.f15746c = view.findViewById(R.id.info_complaint_diver_top);
        this.f15747d = (TextView) view.findViewById(R.id.bar_info_complaint_tv);
        this.f15748e = (ImageView) view.findViewById(R.id.bar_info_complaint_img);
    }
}
