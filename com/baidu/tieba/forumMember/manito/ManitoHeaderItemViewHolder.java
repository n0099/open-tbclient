package com.baidu.tieba.forumMember.manito;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class ManitoHeaderItemViewHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public TextView f15574a;

    /* renamed from: b  reason: collision with root package name */
    public int f15575b;

    public ManitoHeaderItemViewHolder(View view) {
        super(view);
        this.f15575b = 3;
        this.f15574a = (TextView) view.findViewById(R.id.manito_header_title);
    }
}
