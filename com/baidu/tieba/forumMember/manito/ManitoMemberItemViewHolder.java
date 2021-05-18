package com.baidu.tieba.forumMember.manito;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.view.GodHeadImageView;
/* loaded from: classes4.dex */
public class ManitoMemberItemViewHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public GodHeadImageView f15053a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f15054b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f15055c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f15056d;

    /* renamed from: e  reason: collision with root package name */
    public View f15057e;

    /* renamed from: f  reason: collision with root package name */
    public int f15058f;

    public ManitoMemberItemViewHolder(View view) {
        super(view);
        this.f15058f = 3;
        GodHeadImageView godHeadImageView = (GodHeadImageView) view.findViewById(R.id.item_head);
        this.f15053a = godHeadImageView;
        godHeadImageView.setShapeType(0);
        this.f15053a.setShowType(1);
        this.f15053a.setRadius(14);
        this.f15054b = (TextView) view.findViewById(R.id.item_manito_name);
        this.f15055c = (TextView) view.findViewById(R.id.item_manito_intro);
        this.f15056d = (TextView) view.findViewById(R.id.item_manito_fans);
        this.f15057e = view.findViewById(R.id.divider_line);
    }
}
