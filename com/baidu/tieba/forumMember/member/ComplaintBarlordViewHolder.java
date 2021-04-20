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
    public int f15574a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f15575b;

    /* renamed from: c  reason: collision with root package name */
    public View f15576c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f15577d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f15578e;

    public ComplaintBarlordViewHolder(View view) {
        super(view);
        this.f15574a = 3;
        this.f15575b = (RelativeLayout) view.findViewById(R.id.bar_info_complaint_lay);
        this.f15576c = view.findViewById(R.id.info_complaint_diver_top);
        this.f15577d = (TextView) view.findViewById(R.id.bar_info_complaint_tv);
        this.f15578e = (ImageView) view.findViewById(R.id.bar_info_complaint_img);
    }
}
