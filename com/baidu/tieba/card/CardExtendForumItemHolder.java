package com.baidu.tieba.card;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.ItemViewHolder;
import d.a.o0.c1.b.c;
import d.a.o0.z.e0.g;
/* loaded from: classes4.dex */
public class CardExtendForumItemHolder extends ItemViewHolder {

    /* renamed from: b  reason: collision with root package name */
    public BarImageView f14354b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f14355c;

    /* renamed from: d  reason: collision with root package name */
    public EntelechyUserLikeButton f14356d;

    /* renamed from: e  reason: collision with root package name */
    public g f14357e;

    /* renamed from: f  reason: collision with root package name */
    public int f14358f;

    public CardExtendForumItemHolder(View view) {
        super(view);
        this.f14354b = null;
        this.f14355c = null;
        this.f14356d = null;
        this.f14358f = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public void b(c cVar) {
        if (cVar != null && (cVar instanceof g)) {
            g gVar = (g) cVar;
            this.f14357e = gVar;
            this.f14354b.setTag(gVar.f67312b);
            this.f14354b.setTag(R.id.tag_forum_name, this.f14357e.f67313c);
            this.f14354b.U(this.f14357e.f67312b, 15, false);
            TextView textView = this.f14355c;
            textView.setText(StringHelper.getFixedText(this.f14357e.f67313c, 4, true) + a().getContext().getResources().getString(R.string.forum));
            this.f14355c.setTag(R.id.tag_forum_name, this.f14357e.f67313c);
            this.f14356d.setTag(R.id.tag_forum_id, Long.valueOf(this.f14357e.f67314d));
            this.f14356d.setTag(R.id.tag_forum_name, this.f14357e.f67313c);
            a().setTag(R.id.tag_forum_id, Long.valueOf(this.f14357e.f67314d));
            a().setTag(R.id.tag_forum_name, this.f14357e.f67313c);
            f(this.f14356d, this.f14357e.f67315e);
            this.f14354b.setOnClickListener(this.f16887a);
            this.f14356d.setOnClickListener(this.f16887a);
            this.f14355c.setOnClickListener(this.f16887a);
            a().setOnClickListener(this.f16887a);
        }
        d(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public ItemViewHolder c(View view) {
        CardExtendForumItemHolder cardExtendForumItemHolder = new CardExtendForumItemHolder(view);
        BarImageView barImageView = (BarImageView) view.findViewById(R.id.forum_avatar);
        cardExtendForumItemHolder.f14354b = barImageView;
        barImageView.setGifIconSupport(false);
        cardExtendForumItemHolder.f14355c = (TextView) view.findViewById(R.id.m_forum_name_textview);
        cardExtendForumItemHolder.f14356d = (EntelechyUserLikeButton) view.findViewById(R.id.forum_add_love);
        return cardExtendForumItemHolder;
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public void d(int i2) {
        if (this.f14358f != i2) {
            SkinManager.setBackgroundColor(a(), R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.f14355c, R.color.CAM_X0105);
            f(this.f14356d, this.f14357e.f67315e);
        }
        this.f14358f = i2;
    }

    @SuppressLint({"ResourceAsColor"})
    public final void f(EntelechyUserLikeButton entelechyUserLikeButton, boolean z) {
        if (entelechyUserLikeButton == null) {
            return;
        }
        entelechyUserLikeButton.setTag(R.id.forum_follow, Boolean.valueOf(z));
        entelechyUserLikeButton.h(z);
    }
}
