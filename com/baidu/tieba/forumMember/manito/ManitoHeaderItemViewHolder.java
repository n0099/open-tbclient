package com.baidu.tieba.forumMember.manito;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class ManitoHeaderItemViewHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public TextView f14954a;

    /* renamed from: b  reason: collision with root package name */
    public int f14955b;

    public ManitoHeaderItemViewHolder(View view) {
        super(view);
        this.f14955b = 3;
        this.f14954a = (TextView) view.findViewById(R.id.manito_header_title);
    }
}
