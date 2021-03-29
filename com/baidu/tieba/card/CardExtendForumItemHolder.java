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
import d.b.i0.a1.b.c;
import d.b.i0.x.e0.g;
/* loaded from: classes4.dex */
public class CardExtendForumItemHolder extends ItemViewHolder {

    /* renamed from: b  reason: collision with root package name */
    public BarImageView f15223b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f15224c;

    /* renamed from: d  reason: collision with root package name */
    public EntelechyUserLikeButton f15225d;

    /* renamed from: e  reason: collision with root package name */
    public g f15226e;

    /* renamed from: f  reason: collision with root package name */
    public int f15227f;

    public CardExtendForumItemHolder(View view) {
        super(view);
        this.f15223b = null;
        this.f15224c = null;
        this.f15225d = null;
        this.f15227f = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public void b(c cVar) {
        if (cVar != null && (cVar instanceof g)) {
            g gVar = (g) cVar;
            this.f15226e = gVar;
            this.f15223b.setTag(gVar.f62206b);
            this.f15223b.setTag(R.id.tag_forum_name, this.f15226e.f62207c);
            this.f15223b.W(this.f15226e.f62206b, 15, false);
            TextView textView = this.f15224c;
            textView.setText(StringHelper.getFixedText(this.f15226e.f62207c, 4, true) + a().getContext().getResources().getString(R.string.forum));
            this.f15224c.setTag(R.id.tag_forum_name, this.f15226e.f62207c);
            this.f15225d.setTag(R.id.tag_forum_id, Long.valueOf(this.f15226e.f62208d));
            this.f15225d.setTag(R.id.tag_forum_name, this.f15226e.f62207c);
            a().setTag(R.id.tag_forum_id, Long.valueOf(this.f15226e.f62208d));
            a().setTag(R.id.tag_forum_name, this.f15226e.f62207c);
            f(this.f15225d, this.f15226e.f62209e);
            this.f15223b.setOnClickListener(this.f17526a);
            this.f15225d.setOnClickListener(this.f17526a);
            this.f15224c.setOnClickListener(this.f17526a);
            a().setOnClickListener(this.f17526a);
        }
        d(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public ItemViewHolder c(View view) {
        CardExtendForumItemHolder cardExtendForumItemHolder = new CardExtendForumItemHolder(view);
        BarImageView barImageView = (BarImageView) view.findViewById(R.id.forum_avatar);
        cardExtendForumItemHolder.f15223b = barImageView;
        barImageView.setGifIconSupport(false);
        cardExtendForumItemHolder.f15224c = (TextView) view.findViewById(R.id.m_forum_name_textview);
        cardExtendForumItemHolder.f15225d = (EntelechyUserLikeButton) view.findViewById(R.id.forum_add_love);
        return cardExtendForumItemHolder;
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public void d(int i) {
        if (this.f15227f != i) {
            SkinManager.setBackgroundColor(a(), R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.f15224c, R.color.CAM_X0105);
            f(this.f15225d, this.f15226e.f62209e);
        }
        this.f15227f = i;
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
