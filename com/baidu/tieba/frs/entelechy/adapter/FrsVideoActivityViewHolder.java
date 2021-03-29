package com.baidu.tieba.frs.entelechy.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class FrsVideoActivityViewHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public TextView f16220a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f16221b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f16222c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f16223d;

    /* renamed from: e  reason: collision with root package name */
    public View f16224e;

    /* renamed from: f  reason: collision with root package name */
    public View f16225f;

    public FrsVideoActivityViewHolder(View view) {
        super(view);
        if (view != null) {
            this.f16220a = (TextView) view.findViewById(R.id.video_activity_item_title);
            this.f16221b = (ImageView) view.findViewById(R.id.video_activity_item_tip);
            this.f16222c = (TextView) view.findViewById(R.id.video_activity_item_type);
            this.f16223d = (ImageView) view.findViewById(R.id.video_activity_item_more);
            this.f16224e = view.findViewById(R.id.top_divider_line);
            this.f16225f = view.findViewById(R.id.bottom_divider_line);
        }
    }
}
