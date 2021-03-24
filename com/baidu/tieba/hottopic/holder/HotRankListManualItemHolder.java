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
    public int f17568a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f17569b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f17570c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f17571d;

    /* renamed from: e  reason: collision with root package name */
    public View f17572e;

    /* renamed from: f  reason: collision with root package name */
    public View f17573f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f17574g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f17575h;

    public HotRankListManualItemHolder(View view) {
        super(view);
        this.f17568a = 3;
        this.f17569b = null;
        this.f17570c = null;
        this.f17571d = null;
        this.f17572e = null;
        this.f17573f = null;
        this.f17574g = null;
        this.f17575h = null;
        this.f17569b = (TextView) view.findViewById(R.id.topic_module);
        this.f17571d = (TextView) view.findViewById(R.id.topic_desc);
        this.f17570c = (TextView) view.findViewById(R.id.topic_title);
        this.f17574g = (TbImageView) view.findViewById(R.id.topic_pic);
        this.f17572e = view.findViewById(R.id.devide_line_top);
        this.f17573f = view.findViewById(R.id.devide_line_bottom);
        this.f17575h = (LinearLayout) view.findViewById(R.id.topic_manual_item);
    }
}
