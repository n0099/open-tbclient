package com.baidu.tieba.hottopic.holder;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class HotTopicIntervalItemHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public int f16948a;

    /* renamed from: b  reason: collision with root package name */
    public View f16949b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f16950c;

    public HotTopicIntervalItemHolder(View view) {
        super(view);
        this.f16948a = 3;
        this.f16949b = null;
        this.f16950c = null;
        b(view);
    }

    public final void b(View view) {
        if (view == null) {
            return;
        }
        this.f16949b = view.findViewById(R.id.top_divider_line);
        this.f16950c = (TextView) view.findViewById(R.id.item_theme_title);
    }
}
