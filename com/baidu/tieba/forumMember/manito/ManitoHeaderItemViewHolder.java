package com.baidu.tieba.forumMember.manito;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class ManitoHeaderItemViewHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public TextView f15011a;

    /* renamed from: b  reason: collision with root package name */
    public int f15012b;

    public ManitoHeaderItemViewHolder(View view) {
        super(view);
        this.f15012b = 3;
        this.f15011a = (TextView) view.findViewById(R.id.manito_header_title);
    }
}
