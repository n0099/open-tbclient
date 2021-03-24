package com.baidu.tieba.frs.entelechy.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class FrsVideoActivityViewHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public TextView f16219a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f16220b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f16221c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f16222d;

    /* renamed from: e  reason: collision with root package name */
    public View f16223e;

    /* renamed from: f  reason: collision with root package name */
    public View f16224f;

    public FrsVideoActivityViewHolder(View view) {
        super(view);
        if (view != null) {
            this.f16219a = (TextView) view.findViewById(R.id.video_activity_item_title);
            this.f16220b = (ImageView) view.findViewById(R.id.video_activity_item_tip);
            this.f16221c = (TextView) view.findViewById(R.id.video_activity_item_type);
            this.f16222d = (ImageView) view.findViewById(R.id.video_activity_item_more);
            this.f16223e = view.findViewById(R.id.top_divider_line);
            this.f16224f = view.findViewById(R.id.bottom_divider_line);
        }
    }
}
