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
import d.b.i0.b1.b.c;
import d.b.i0.x.e0.g;
/* loaded from: classes4.dex */
public class CardExtendForumItemHolder extends ItemViewHolder {

    /* renamed from: b  reason: collision with root package name */
    public BarImageView f14886b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f14887c;

    /* renamed from: d  reason: collision with root package name */
    public EntelechyUserLikeButton f14888d;

    /* renamed from: e  reason: collision with root package name */
    public g f14889e;

    /* renamed from: f  reason: collision with root package name */
    public int f14890f;

    public CardExtendForumItemHolder(View view) {
        super(view);
        this.f14886b = null;
        this.f14887c = null;
        this.f14888d = null;
        this.f14890f = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public void b(c cVar) {
        if (cVar != null && (cVar instanceof g)) {
            g gVar = (g) cVar;
            this.f14889e = gVar;
            this.f14886b.setTag(gVar.f63781b);
            this.f14886b.setTag(R.id.tag_forum_name, this.f14889e.f63782c);
            this.f14886b.W(this.f14889e.f63781b, 15, false);
            TextView textView = this.f14887c;
            textView.setText(StringHelper.getFixedText(this.f14889e.f63782c, 4, true) + a().getContext().getResources().getString(R.string.forum));
            this.f14887c.setTag(R.id.tag_forum_name, this.f14889e.f63782c);
            this.f14888d.setTag(R.id.tag_forum_id, Long.valueOf(this.f14889e.f63783d));
            this.f14888d.setTag(R.id.tag_forum_name, this.f14889e.f63782c);
            a().setTag(R.id.tag_forum_id, Long.valueOf(this.f14889e.f63783d));
            a().setTag(R.id.tag_forum_name, this.f14889e.f63782c);
            f(this.f14888d, this.f14889e.f63784e);
            this.f14886b.setOnClickListener(this.f17203a);
            this.f14888d.setOnClickListener(this.f17203a);
            this.f14887c.setOnClickListener(this.f17203a);
            a().setOnClickListener(this.f17203a);
        }
        d(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public ItemViewHolder c(View view) {
        CardExtendForumItemHolder cardExtendForumItemHolder = new CardExtendForumItemHolder(view);
        BarImageView barImageView = (BarImageView) view.findViewById(R.id.forum_avatar);
        cardExtendForumItemHolder.f14886b = barImageView;
        barImageView.setGifIconSupport(false);
        cardExtendForumItemHolder.f14887c = (TextView) view.findViewById(R.id.m_forum_name_textview);
        cardExtendForumItemHolder.f14888d = (EntelechyUserLikeButton) view.findViewById(R.id.forum_add_love);
        return cardExtendForumItemHolder;
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public void d(int i) {
        if (this.f14890f != i) {
            SkinManager.setBackgroundColor(a(), R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.f14887c, R.color.CAM_X0105);
            f(this.f14888d, this.f14889e.f63784e);
        }
        this.f14890f = i;
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
