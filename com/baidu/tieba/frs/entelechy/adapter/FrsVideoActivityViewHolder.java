package com.baidu.tieba.frs.entelechy.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class FrsVideoActivityViewHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public TextView f15356a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f15357b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f15358c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f15359d;

    /* renamed from: e  reason: collision with root package name */
    public View f15360e;

    /* renamed from: f  reason: collision with root package name */
    public View f15361f;

    public FrsVideoActivityViewHolder(View view) {
        super(view);
        if (view != null) {
            this.f15356a = (TextView) view.findViewById(R.id.video_activity_item_title);
            this.f15357b = (ImageView) view.findViewById(R.id.video_activity_item_tip);
            this.f15358c = (TextView) view.findViewById(R.id.video_activity_item_type);
            this.f15359d = (ImageView) view.findViewById(R.id.video_activity_item_more);
            this.f15360e = view.findViewById(R.id.top_divider_line);
            this.f15361f = view.findViewById(R.id.bottom_divider_line);
        }
    }
}
