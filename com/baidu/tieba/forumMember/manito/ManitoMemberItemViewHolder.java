package com.baidu.tieba.forumMember.manito;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.view.GodHeadImageView;
/* loaded from: classes4.dex */
public class ManitoMemberItemViewHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public GodHeadImageView f15013a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f15014b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f15015c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f15016d;

    /* renamed from: e  reason: collision with root package name */
    public View f15017e;

    /* renamed from: f  reason: collision with root package name */
    public int f15018f;

    public ManitoMemberItemViewHolder(View view) {
        super(view);
        this.f15018f = 3;
        GodHeadImageView godHeadImageView = (GodHeadImageView) view.findViewById(R.id.item_head);
        this.f15013a = godHeadImageView;
        godHeadImageView.setShapeType(0);
        this.f15013a.setShowType(1);
        this.f15013a.setRadius(14);
        this.f15014b = (TextView) view.findViewById(R.id.item_manito_name);
        this.f15015c = (TextView) view.findViewById(R.id.item_manito_intro);
        this.f15016d = (TextView) view.findViewById(R.id.item_manito_fans);
        this.f15017e = view.findViewById(R.id.divider_line);
    }
}
