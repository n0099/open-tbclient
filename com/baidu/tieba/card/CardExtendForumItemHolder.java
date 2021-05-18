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
import d.a.k0.b1.b.c;
import d.a.k0.x.e0.g;
/* loaded from: classes4.dex */
public class CardExtendForumItemHolder extends ItemViewHolder {

    /* renamed from: b  reason: collision with root package name */
    public BarImageView f14312b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f14313c;

    /* renamed from: d  reason: collision with root package name */
    public EntelechyUserLikeButton f14314d;

    /* renamed from: e  reason: collision with root package name */
    public g f14315e;

    /* renamed from: f  reason: collision with root package name */
    public int f14316f;

    public CardExtendForumItemHolder(View view) {
        super(view);
        this.f14312b = null;
        this.f14313c = null;
        this.f14314d = null;
        this.f14316f = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public void b(c cVar) {
        if (cVar != null && (cVar instanceof g)) {
            g gVar = (g) cVar;
            this.f14315e = gVar;
            this.f14312b.setTag(gVar.f63189b);
            this.f14312b.setTag(R.id.tag_forum_name, this.f14315e.f63190c);
            this.f14312b.V(this.f14315e.f63189b, 15, false);
            TextView textView = this.f14313c;
            textView.setText(StringHelper.getFixedText(this.f14315e.f63190c, 4, true) + a().getContext().getResources().getString(R.string.forum));
            this.f14313c.setTag(R.id.tag_forum_name, this.f14315e.f63190c);
            this.f14314d.setTag(R.id.tag_forum_id, Long.valueOf(this.f14315e.f63191d));
            this.f14314d.setTag(R.id.tag_forum_name, this.f14315e.f63190c);
            a().setTag(R.id.tag_forum_id, Long.valueOf(this.f14315e.f63191d));
            a().setTag(R.id.tag_forum_name, this.f14315e.f63190c);
            f(this.f14314d, this.f14315e.f63192e);
            this.f14312b.setOnClickListener(this.f16819a);
            this.f14314d.setOnClickListener(this.f16819a);
            this.f14313c.setOnClickListener(this.f16819a);
            a().setOnClickListener(this.f16819a);
        }
        d(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public ItemViewHolder c(View view) {
        CardExtendForumItemHolder cardExtendForumItemHolder = new CardExtendForumItemHolder(view);
        BarImageView barImageView = (BarImageView) view.findViewById(R.id.forum_avatar);
        cardExtendForumItemHolder.f14312b = barImageView;
        barImageView.setGifIconSupport(false);
        cardExtendForumItemHolder.f14313c = (TextView) view.findViewById(R.id.m_forum_name_textview);
        cardExtendForumItemHolder.f14314d = (EntelechyUserLikeButton) view.findViewById(R.id.forum_add_love);
        return cardExtendForumItemHolder;
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public void d(int i2) {
        if (this.f14316f != i2) {
            SkinManager.setBackgroundColor(a(), R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.f14313c, R.color.CAM_X0105);
            f(this.f14314d, this.f14315e.f63192e);
        }
        this.f14316f = i2;
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
