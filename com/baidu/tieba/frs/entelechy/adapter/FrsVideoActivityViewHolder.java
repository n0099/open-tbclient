package com.baidu.tieba.frs.entelechy.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class FrsVideoActivityViewHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public TextView f16076a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f16077b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f16078c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f16079d;

    /* renamed from: e  reason: collision with root package name */
    public View f16080e;

    /* renamed from: f  reason: collision with root package name */
    public View f16081f;

    public FrsVideoActivityViewHolder(View view) {
        super(view);
        if (view != null) {
            this.f16076a = (TextView) view.findViewById(R.id.video_activity_item_title);
            this.f16077b = (ImageView) view.findViewById(R.id.video_activity_item_tip);
            this.f16078c = (TextView) view.findViewById(R.id.video_activity_item_type);
            this.f16079d = (ImageView) view.findViewById(R.id.video_activity_item_more);
            this.f16080e = view.findViewById(R.id.top_divider_line);
            this.f16081f = view.findViewById(R.id.bottom_divider_line);
        }
    }
}
