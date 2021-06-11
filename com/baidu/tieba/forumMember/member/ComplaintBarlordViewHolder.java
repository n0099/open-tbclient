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
    public int f15019a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f15020b;

    /* renamed from: c  reason: collision with root package name */
    public View f15021c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f15022d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f15023e;

    public ComplaintBarlordViewHolder(View view) {
        super(view);
        this.f15019a = 3;
        this.f15020b = (RelativeLayout) view.findViewById(R.id.bar_info_complaint_lay);
        this.f15021c = view.findViewById(R.id.info_complaint_diver_top);
        this.f15022d = (TextView) view.findViewById(R.id.bar_info_complaint_tv);
        this.f15023e = (ImageView) view.findViewById(R.id.bar_info_complaint_img);
    }
}
