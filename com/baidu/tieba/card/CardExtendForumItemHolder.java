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
    public BarImageView f14215b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f14216c;

    /* renamed from: d  reason: collision with root package name */
    public EntelechyUserLikeButton f14217d;

    /* renamed from: e  reason: collision with root package name */
    public g f14218e;

    /* renamed from: f  reason: collision with root package name */
    public int f14219f;

    public CardExtendForumItemHolder(View view) {
        super(view);
        this.f14215b = null;
        this.f14216c = null;
        this.f14217d = null;
        this.f14219f = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public void b(c cVar) {
        if (cVar != null && (cVar instanceof g)) {
            g gVar = (g) cVar;
            this.f14218e = gVar;
            this.f14215b.setTag(gVar.f63469b);
            this.f14215b.setTag(R.id.tag_forum_name, this.f14218e.f63470c);
            this.f14215b.V(this.f14218e.f63469b, 15, false);
            TextView textView = this.f14216c;
            textView.setText(StringHelper.getFixedText(this.f14218e.f63470c, 4, true) + a().getContext().getResources().getString(R.string.forum));
            this.f14216c.setTag(R.id.tag_forum_name, this.f14218e.f63470c);
            this.f14217d.setTag(R.id.tag_forum_id, Long.valueOf(this.f14218e.f63471d));
            this.f14217d.setTag(R.id.tag_forum_name, this.f14218e.f63470c);
            a().setTag(R.id.tag_forum_id, Long.valueOf(this.f14218e.f63471d));
            a().setTag(R.id.tag_forum_name, this.f14218e.f63470c);
            f(this.f14217d, this.f14218e.f63472e);
            this.f14215b.setOnClickListener(this.f16729a);
            this.f14217d.setOnClickListener(this.f16729a);
            this.f14216c.setOnClickListener(this.f16729a);
            a().setOnClickListener(this.f16729a);
        }
        d(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public ItemViewHolder c(View view) {
        CardExtendForumItemHolder cardExtendForumItemHolder = new CardExtendForumItemHolder(view);
        BarImageView barImageView = (BarImageView) view.findViewById(R.id.forum_avatar);
        cardExtendForumItemHolder.f14215b = barImageView;
        barImageView.setGifIconSupport(false);
        cardExtendForumItemHolder.f14216c = (TextView) view.findViewById(R.id.m_forum_name_textview);
        cardExtendForumItemHolder.f14217d = (EntelechyUserLikeButton) view.findViewById(R.id.forum_add_love);
        return cardExtendForumItemHolder;
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public void d(int i2) {
        if (this.f14219f != i2) {
            SkinManager.setBackgroundColor(a(), R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.f14216c, R.color.CAM_X0105);
            f(this.f14217d, this.f14218e.f63472e);
        }
        this.f14219f = i2;
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
