package com.baidu.tieba.hottopic.holder;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class HotTopicIntervalItemHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public int f17565a;

    /* renamed from: b  reason: collision with root package name */
    public View f17566b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f17567c;

    public HotTopicIntervalItemHolder(View view) {
        super(view);
        this.f17565a = 3;
        this.f17566b = null;
        this.f17567c = null;
        b(view);
    }

    public final void b(View view) {
        if (view == null) {
            return;
        }
        this.f17566b = view.findViewById(R.id.top_divider_line);
        this.f17567c = (TextView) view.findViewById(R.id.item_theme_title);
    }
}
