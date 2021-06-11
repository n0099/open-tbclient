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
import d.a.n0.c1.b.c;
import d.a.n0.z.e0.g;
/* loaded from: classes4.dex */
public class CardExtendForumItemHolder extends ItemViewHolder {

    /* renamed from: b  reason: collision with root package name */
    public BarImageView f14272b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f14273c;

    /* renamed from: d  reason: collision with root package name */
    public EntelechyUserLikeButton f14274d;

    /* renamed from: e  reason: collision with root package name */
    public g f14275e;

    /* renamed from: f  reason: collision with root package name */
    public int f14276f;

    public CardExtendForumItemHolder(View view) {
        super(view);
        this.f14272b = null;
        this.f14273c = null;
        this.f14274d = null;
        this.f14276f = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public void b(c cVar) {
        if (cVar != null && (cVar instanceof g)) {
            g gVar = (g) cVar;
            this.f14275e = gVar;
            this.f14272b.setTag(gVar.f67187b);
            this.f14272b.setTag(R.id.tag_forum_name, this.f14275e.f67188c);
            this.f14272b.U(this.f14275e.f67187b, 15, false);
            TextView textView = this.f14273c;
            textView.setText(StringHelper.getFixedText(this.f14275e.f67188c, 4, true) + a().getContext().getResources().getString(R.string.forum));
            this.f14273c.setTag(R.id.tag_forum_name, this.f14275e.f67188c);
            this.f14274d.setTag(R.id.tag_forum_id, Long.valueOf(this.f14275e.f67189d));
            this.f14274d.setTag(R.id.tag_forum_name, this.f14275e.f67188c);
            a().setTag(R.id.tag_forum_id, Long.valueOf(this.f14275e.f67189d));
            a().setTag(R.id.tag_forum_name, this.f14275e.f67188c);
            f(this.f14274d, this.f14275e.f67190e);
            this.f14272b.setOnClickListener(this.f16805a);
            this.f14274d.setOnClickListener(this.f16805a);
            this.f14273c.setOnClickListener(this.f16805a);
            a().setOnClickListener(this.f16805a);
        }
        d(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public ItemViewHolder c(View view) {
        CardExtendForumItemHolder cardExtendForumItemHolder = new CardExtendForumItemHolder(view);
        BarImageView barImageView = (BarImageView) view.findViewById(R.id.forum_avatar);
        cardExtendForumItemHolder.f14272b = barImageView;
        barImageView.setGifIconSupport(false);
        cardExtendForumItemHolder.f14273c = (TextView) view.findViewById(R.id.m_forum_name_textview);
        cardExtendForumItemHolder.f14274d = (EntelechyUserLikeButton) view.findViewById(R.id.forum_add_love);
        return cardExtendForumItemHolder;
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public void d(int i2) {
        if (this.f14276f != i2) {
            SkinManager.setBackgroundColor(a(), R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.f14273c, R.color.CAM_X0105);
            f(this.f14274d, this.f14275e.f67190e);
        }
        this.f14276f = i2;
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
