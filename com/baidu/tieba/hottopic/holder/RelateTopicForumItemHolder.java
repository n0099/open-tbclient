package com.baidu.tieba.hottopic.holder;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class RelateTopicForumItemHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public BarImageView f16898a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f16899b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f16900c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f16901d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f16902e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f16903f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f16904g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f16905h;

    /* renamed from: i  reason: collision with root package name */
    public View f16906i;
    public int j;

    public RelateTopicForumItemHolder(View view) {
        super(view);
        this.j = 3;
        this.f16899b = (TextView) view.findViewById(R.id.forum_name);
        this.f16898a = (BarImageView) view.findViewById(R.id.forum_avatar);
        this.f16901d = (TextView) view.findViewById(R.id.member_num_label);
        this.f16900c = (TextView) view.findViewById(R.id.post_num_label);
        this.f16903f = (TextView) view.findViewById(R.id.member_num);
        this.f16902e = (TextView) view.findViewById(R.id.post_num);
        this.f16904g = (TextView) view.findViewById(R.id.forum_content);
        this.f16905h = (TextView) view.findViewById(R.id.forum_add_love);
        this.f16906i = view.findViewById(R.id.forum_item_divider);
    }
}
