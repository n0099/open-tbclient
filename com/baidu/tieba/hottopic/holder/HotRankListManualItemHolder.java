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
    public int f17254a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f17255b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f17256c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f17257d;

    /* renamed from: e  reason: collision with root package name */
    public View f17258e;

    /* renamed from: f  reason: collision with root package name */
    public View f17259f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f17260g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f17261h;

    public HotRankListManualItemHolder(View view) {
        super(view);
        this.f17254a = 3;
        this.f17255b = null;
        this.f17256c = null;
        this.f17257d = null;
        this.f17258e = null;
        this.f17259f = null;
        this.f17260g = null;
        this.f17261h = null;
        this.f17255b = (TextView) view.findViewById(R.id.topic_module);
        this.f17257d = (TextView) view.findViewById(R.id.topic_desc);
        this.f17256c = (TextView) view.findViewById(R.id.topic_title);
        this.f17260g = (TbImageView) view.findViewById(R.id.topic_pic);
        this.f17258e = view.findViewById(R.id.devide_line_top);
        this.f17259f = view.findViewById(R.id.devide_line_bottom);
        this.f17261h = (LinearLayout) view.findViewById(R.id.topic_manual_item);
    }
}
