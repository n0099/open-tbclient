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
    public int f16931a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f16932b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f16933c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f16934d;

    /* renamed from: e  reason: collision with root package name */
    public View f16935e;

    /* renamed from: f  reason: collision with root package name */
    public View f16936f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f16937g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f16938h;

    public HotRankListManualItemHolder(View view) {
        super(view);
        this.f16931a = 3;
        this.f16932b = null;
        this.f16933c = null;
        this.f16934d = null;
        this.f16935e = null;
        this.f16936f = null;
        this.f16937g = null;
        this.f16938h = null;
        this.f16932b = (TextView) view.findViewById(R.id.topic_module);
        this.f16934d = (TextView) view.findViewById(R.id.topic_desc);
        this.f16933c = (TextView) view.findViewById(R.id.topic_title);
        this.f16937g = (TbImageView) view.findViewById(R.id.topic_pic);
        this.f16935e = view.findViewById(R.id.devide_line_top);
        this.f16936f = view.findViewById(R.id.devide_line_bottom);
        this.f16938h = (LinearLayout) view.findViewById(R.id.topic_manual_item);
    }
}
