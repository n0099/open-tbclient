package com.baidu.tieba.hottopic.holder;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class HotRankListManualItemHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public int f16773a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f16774b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f16775c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f16776d;

    /* renamed from: e  reason: collision with root package name */
    public View f16777e;

    /* renamed from: f  reason: collision with root package name */
    public View f16778f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f16779g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f16780h;

    public HotRankListManualItemHolder(View view) {
        super(view);
        this.f16773a = 3;
        this.f16774b = null;
        this.f16775c = null;
        this.f16776d = null;
        this.f16777e = null;
        this.f16778f = null;
        this.f16779g = null;
        this.f16780h = null;
        this.f16774b = (TextView) view.findViewById(R.id.topic_module);
        this.f16776d = (TextView) view.findViewById(R.id.topic_desc);
        this.f16775c = (TextView) view.findViewById(R.id.topic_title);
        this.f16779g = (TbImageView) view.findViewById(R.id.topic_pic);
        this.f16777e = view.findViewById(R.id.devide_line_top);
        this.f16778f = view.findViewById(R.id.devide_line_bottom);
        this.f16780h = (LinearLayout) view.findViewById(R.id.topic_manual_item);
    }
}
