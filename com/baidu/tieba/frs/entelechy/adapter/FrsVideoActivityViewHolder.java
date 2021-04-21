package com.baidu.tieba.frs.entelechy.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class FrsVideoActivityViewHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public TextView f15889a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f15890b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f15891c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f15892d;

    /* renamed from: e  reason: collision with root package name */
    public View f15893e;

    /* renamed from: f  reason: collision with root package name */
    public View f15894f;

    public FrsVideoActivityViewHolder(View view) {
        super(view);
        if (view != null) {
            this.f15889a = (TextView) view.findViewById(R.id.video_activity_item_title);
            this.f15890b = (ImageView) view.findViewById(R.id.video_activity_item_tip);
            this.f15891c = (TextView) view.findViewById(R.id.video_activity_item_type);
            this.f15892d = (ImageView) view.findViewById(R.id.video_activity_item_more);
            this.f15893e = view.findViewById(R.id.top_divider_line);
            this.f15894f = view.findViewById(R.id.bottom_divider_line);
        }
    }
}
