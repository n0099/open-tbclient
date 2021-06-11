package com.baidu.tieba.hottopic.holder;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class HotTopicIntervalItemHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public int f16866a;

    /* renamed from: b  reason: collision with root package name */
    public View f16867b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f16868c;

    public HotTopicIntervalItemHolder(View view) {
        super(view);
        this.f16866a = 3;
        this.f16867b = null;
        this.f16868c = null;
        b(view);
    }

    public final void b(View view) {
        if (view == null) {
            return;
        }
        this.f16867b = view.findViewById(R.id.top_divider_line);
        this.f16868c = (TextView) view.findViewById(R.id.item_theme_title);
    }
}
