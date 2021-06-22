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
    public int f15101a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f15102b;

    /* renamed from: c  reason: collision with root package name */
    public View f15103c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f15104d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f15105e;

    public ComplaintBarlordViewHolder(View view) {
        super(view);
        this.f15101a = 3;
        this.f15102b = (RelativeLayout) view.findViewById(R.id.bar_info_complaint_lay);
        this.f15103c = view.findViewById(R.id.info_complaint_diver_top);
        this.f15104d = (TextView) view.findViewById(R.id.bar_info_complaint_tv);
        this.f15105e = (ImageView) view.findViewById(R.id.bar_info_complaint_img);
    }
}
