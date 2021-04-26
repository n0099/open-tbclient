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
import d.a.j0.b1.b.c;
import d.a.j0.x.e0.g;
/* loaded from: classes4.dex */
public class CardExtendForumItemHolder extends ItemViewHolder {

    /* renamed from: b  reason: collision with root package name */
    public BarImageView f14997b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f14998c;

    /* renamed from: d  reason: collision with root package name */
    public EntelechyUserLikeButton f14999d;

    /* renamed from: e  reason: collision with root package name */
    public g f15000e;

    /* renamed from: f  reason: collision with root package name */
    public int f15001f;

    public CardExtendForumItemHolder(View view) {
        super(view);
        this.f14997b = null;
        this.f14998c = null;
        this.f14999d = null;
        this.f15001f = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public void b(c cVar) {
        if (cVar != null && (cVar instanceof g)) {
            g gVar = (g) cVar;
            this.f15000e = gVar;
            this.f14997b.setTag(gVar.f62465b);
            this.f14997b.setTag(R.id.tag_forum_name, this.f15000e.f62466c);
            this.f14997b.V(this.f15000e.f62465b, 15, false);
            TextView textView = this.f14998c;
            textView.setText(StringHelper.getFixedText(this.f15000e.f62466c, 4, true) + a().getContext().getResources().getString(R.string.forum));
            this.f14998c.setTag(R.id.tag_forum_name, this.f15000e.f62466c);
            this.f14999d.setTag(R.id.tag_forum_id, Long.valueOf(this.f15000e.f62467d));
            this.f14999d.setTag(R.id.tag_forum_name, this.f15000e.f62466c);
            a().setTag(R.id.tag_forum_id, Long.valueOf(this.f15000e.f62467d));
            a().setTag(R.id.tag_forum_name, this.f15000e.f62466c);
            f(this.f14999d, this.f15000e.f62468e);
            this.f14997b.setOnClickListener(this.f17504a);
            this.f14999d.setOnClickListener(this.f17504a);
            this.f14998c.setOnClickListener(this.f17504a);
            a().setOnClickListener(this.f17504a);
        }
        d(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public ItemViewHolder c(View view) {
        CardExtendForumItemHolder cardExtendForumItemHolder = new CardExtendForumItemHolder(view);
        BarImageView barImageView = (BarImageView) view.findViewById(R.id.forum_avatar);
        cardExtendForumItemHolder.f14997b = barImageView;
        barImageView.setGifIconSupport(false);
        cardExtendForumItemHolder.f14998c = (TextView) view.findViewById(R.id.m_forum_name_textview);
        cardExtendForumItemHolder.f14999d = (EntelechyUserLikeButton) view.findViewById(R.id.forum_add_love);
        return cardExtendForumItemHolder;
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public void d(int i2) {
        if (this.f15001f != i2) {
            SkinManager.setBackgroundColor(a(), R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.f14998c, R.color.CAM_X0105);
            f(this.f14999d, this.f15000e.f62468e);
        }
        this.f15001f = i2;
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
