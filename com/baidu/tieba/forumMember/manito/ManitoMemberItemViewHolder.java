package com.baidu.tieba.forumMember.manito;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.view.GodHeadImageView;
/* loaded from: classes4.dex */
public class ManitoMemberItemViewHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public GodHeadImageView f14956a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f14957b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f14958c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f14959d;

    /* renamed from: e  reason: collision with root package name */
    public View f14960e;

    /* renamed from: f  reason: collision with root package name */
    public int f14961f;

    public ManitoMemberItemViewHolder(View view) {
        super(view);
        this.f14961f = 3;
        GodHeadImageView godHeadImageView = (GodHeadImageView) view.findViewById(R.id.item_head);
        this.f14956a = godHeadImageView;
        godHeadImageView.setShapeType(0);
        this.f14956a.setShowType(1);
        this.f14956a.setRadius(14);
        this.f14957b = (TextView) view.findViewById(R.id.item_manito_name);
        this.f14958c = (TextView) view.findViewById(R.id.item_manito_intro);
        this.f14959d = (TextView) view.findViewById(R.id.item_manito_fans);
        this.f14960e = view.findViewById(R.id.divider_line);
    }
}
