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
    public int f17246a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f17247b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f17248c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f17249d;

    /* renamed from: e  reason: collision with root package name */
    public View f17250e;

    /* renamed from: f  reason: collision with root package name */
    public View f17251f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f17252g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f17253h;

    public HotRankListManualItemHolder(View view) {
        super(view);
        this.f17246a = 3;
        this.f17247b = null;
        this.f17248c = null;
        this.f17249d = null;
        this.f17250e = null;
        this.f17251f = null;
        this.f17252g = null;
        this.f17253h = null;
        this.f17247b = (TextView) view.findViewById(R.id.topic_module);
        this.f17249d = (TextView) view.findViewById(R.id.topic_desc);
        this.f17248c = (TextView) view.findViewById(R.id.topic_title);
        this.f17252g = (TbImageView) view.findViewById(R.id.topic_pic);
        this.f17250e = view.findViewById(R.id.devide_line_top);
        this.f17251f = view.findViewById(R.id.devide_line_bottom);
        this.f17253h = (LinearLayout) view.findViewById(R.id.topic_manual_item);
    }
}
