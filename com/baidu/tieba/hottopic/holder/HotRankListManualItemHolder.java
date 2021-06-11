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
    public int f16849a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f16850b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f16851c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f16852d;

    /* renamed from: e  reason: collision with root package name */
    public View f16853e;

    /* renamed from: f  reason: collision with root package name */
    public View f16854f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f16855g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f16856h;

    public HotRankListManualItemHolder(View view) {
        super(view);
        this.f16849a = 3;
        this.f16850b = null;
        this.f16851c = null;
        this.f16852d = null;
        this.f16853e = null;
        this.f16854f = null;
        this.f16855g = null;
        this.f16856h = null;
        this.f16850b = (TextView) view.findViewById(R.id.topic_module);
        this.f16852d = (TextView) view.findViewById(R.id.topic_desc);
        this.f16851c = (TextView) view.findViewById(R.id.topic_title);
        this.f16855g = (TbImageView) view.findViewById(R.id.topic_pic);
        this.f16853e = view.findViewById(R.id.devide_line_top);
        this.f16854f = view.findViewById(R.id.devide_line_bottom);
        this.f16856h = (LinearLayout) view.findViewById(R.id.topic_manual_item);
    }
}
