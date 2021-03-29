package com.baidu.tieba.hottopic.holder;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class HotRankListManualItemHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public int f17569a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f17570b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f17571c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f17572d;

    /* renamed from: e  reason: collision with root package name */
    public View f17573e;

    /* renamed from: f  reason: collision with root package name */
    public View f17574f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f17575g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f17576h;

    public HotRankListManualItemHolder(View view) {
        super(view);
        this.f17569a = 3;
        this.f17570b = null;
        this.f17571c = null;
        this.f17572d = null;
        this.f17573e = null;
        this.f17574f = null;
        this.f17575g = null;
        this.f17576h = null;
        this.f17570b = (TextView) view.findViewById(R.id.topic_module);
        this.f17572d = (TextView) view.findViewById(R.id.topic_desc);
        this.f17571c = (TextView) view.findViewById(R.id.topic_title);
        this.f17575g = (TbImageView) view.findViewById(R.id.topic_pic);
        this.f17573e = view.findViewById(R.id.devide_line_top);
        this.f17574f = view.findViewById(R.id.devide_line_bottom);
        this.f17576h = (LinearLayout) view.findViewById(R.id.topic_manual_item);
    }
}
