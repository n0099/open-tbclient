package com.baidu.tieba.hottopic.holder;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class RelateTopicForumItemHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public BarImageView f16808a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f16809b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f16810c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f16811d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f16812e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f16813f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f16814g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f16815h;

    /* renamed from: i  reason: collision with root package name */
    public View f16816i;
    public int j;

    public RelateTopicForumItemHolder(View view) {
        super(view);
        this.j = 3;
        this.f16809b = (TextView) view.findViewById(R.id.forum_name);
        this.f16808a = (BarImageView) view.findViewById(R.id.forum_avatar);
        this.f16811d = (TextView) view.findViewById(R.id.member_num_label);
        this.f16810c = (TextView) view.findViewById(R.id.post_num_label);
        this.f16813f = (TextView) view.findViewById(R.id.member_num);
        this.f16812e = (TextView) view.findViewById(R.id.post_num);
        this.f16814g = (TextView) view.findViewById(R.id.forum_content);
        this.f16815h = (TextView) view.findViewById(R.id.forum_add_love);
        this.f16816i = view.findViewById(R.id.forum_item_divider);
    }
}
