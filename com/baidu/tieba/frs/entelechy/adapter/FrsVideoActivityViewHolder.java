package com.baidu.tieba.frs.entelechy.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class FrsVideoActivityViewHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public TextView f15881a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f15882b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f15883c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f15884d;

    /* renamed from: e  reason: collision with root package name */
    public View f15885e;

    /* renamed from: f  reason: collision with root package name */
    public View f15886f;

    public FrsVideoActivityViewHolder(View view) {
        super(view);
        if (view != null) {
            this.f15881a = (TextView) view.findViewById(R.id.video_activity_item_title);
            this.f15882b = (ImageView) view.findViewById(R.id.video_activity_item_tip);
            this.f15883c = (TextView) view.findViewById(R.id.video_activity_item_type);
            this.f15884d = (ImageView) view.findViewById(R.id.video_activity_item_more);
            this.f15885e = view.findViewById(R.id.top_divider_line);
            this.f15886f = view.findViewById(R.id.bottom_divider_line);
        }
    }
}
