package com.baidu.tieba.frs.entelechy.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class FrsVideoActivityViewHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public TextView f15294a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f15295b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f15296c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f15297d;

    /* renamed from: e  reason: collision with root package name */
    public View f15298e;

    /* renamed from: f  reason: collision with root package name */
    public View f15299f;

    public FrsVideoActivityViewHolder(View view) {
        super(view);
        if (view != null) {
            this.f15294a = (TextView) view.findViewById(R.id.video_activity_item_title);
            this.f15295b = (ImageView) view.findViewById(R.id.video_activity_item_tip);
            this.f15296c = (TextView) view.findViewById(R.id.video_activity_item_type);
            this.f15297d = (ImageView) view.findViewById(R.id.video_activity_item_more);
            this.f15298e = view.findViewById(R.id.top_divider_line);
            this.f15299f = view.findViewById(R.id.bottom_divider_line);
        }
    }
}
