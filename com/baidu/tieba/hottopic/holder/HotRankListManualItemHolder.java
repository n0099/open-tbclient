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
    public int f16863a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f16864b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f16865c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f16866d;

    /* renamed from: e  reason: collision with root package name */
    public View f16867e;

    /* renamed from: f  reason: collision with root package name */
    public View f16868f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f16869g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f16870h;

    public HotRankListManualItemHolder(View view) {
        super(view);
        this.f16863a = 3;
        this.f16864b = null;
        this.f16865c = null;
        this.f16866d = null;
        this.f16867e = null;
        this.f16868f = null;
        this.f16869g = null;
        this.f16870h = null;
        this.f16864b = (TextView) view.findViewById(R.id.topic_module);
        this.f16866d = (TextView) view.findViewById(R.id.topic_desc);
        this.f16865c = (TextView) view.findViewById(R.id.topic_title);
        this.f16869g = (TbImageView) view.findViewById(R.id.topic_pic);
        this.f16867e = view.findViewById(R.id.devide_line_top);
        this.f16868f = view.findViewById(R.id.devide_line_bottom);
        this.f16870h = (LinearLayout) view.findViewById(R.id.topic_manual_item);
    }
}
