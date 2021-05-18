package com.baidu.tieba.frs.entelechy.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class FrsVideoActivityViewHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public TextView f15391a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f15392b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f15393c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f15394d;

    /* renamed from: e  reason: collision with root package name */
    public View f15395e;

    /* renamed from: f  reason: collision with root package name */
    public View f15396f;

    public FrsVideoActivityViewHolder(View view) {
        super(view);
        if (view != null) {
            this.f15391a = (TextView) view.findViewById(R.id.video_activity_item_title);
            this.f15392b = (ImageView) view.findViewById(R.id.video_activity_item_tip);
            this.f15393c = (TextView) view.findViewById(R.id.video_activity_item_type);
            this.f15394d = (ImageView) view.findViewById(R.id.video_activity_item_more);
            this.f15395e = view.findViewById(R.id.top_divider_line);
            this.f15396f = view.findViewById(R.id.bottom_divider_line);
        }
    }
}
