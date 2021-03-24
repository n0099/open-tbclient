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
    public BarImageView f15222b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f15223c;

    /* renamed from: d  reason: collision with root package name */
    public EntelechyUserLikeButton f15224d;

    /* renamed from: e  reason: collision with root package name */
    public g f15225e;

    /* renamed from: f  reason: collision with root package name */
    public int f15226f;

    public CardExtendForumItemHolder(View view) {
        super(view);
        this.f15222b = null;
        this.f15223c = null;
        this.f15224d = null;
        this.f15226f = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public void b(c cVar) {
        if (cVar != null && (cVar instanceof g)) {
            g gVar = (g) cVar;
            this.f15225e = gVar;
            this.f15222b.setTag(gVar.f62205b);
            this.f15222b.setTag(R.id.tag_forum_name, this.f15225e.f62206c);
            this.f15222b.W(this.f15225e.f62205b, 15, false);
            TextView textView = this.f15223c;
            textView.setText(StringHelper.getFixedText(this.f15225e.f62206c, 4, true) + a().getContext().getResources().getString(R.string.forum));
            this.f15223c.setTag(R.id.tag_forum_name, this.f15225e.f62206c);
            this.f15224d.setTag(R.id.tag_forum_id, Long.valueOf(this.f15225e.f62207d));
            this.f15224d.setTag(R.id.tag_forum_name, this.f15225e.f62206c);
            a().setTag(R.id.tag_forum_id, Long.valueOf(this.f15225e.f62207d));
            a().setTag(R.id.tag_forum_name, this.f15225e.f62206c);
            f(this.f15224d, this.f15225e.f62208e);
            this.f15222b.setOnClickListener(this.f17525a);
            this.f15224d.setOnClickListener(this.f17525a);
            this.f15223c.setOnClickListener(this.f17525a);
            a().setOnClickListener(this.f17525a);
        }
        d(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public ItemViewHolder c(View view) {
        CardExtendForumItemHolder cardExtendForumItemHolder = new CardExtendForumItemHolder(view);
        BarImageView barImageView = (BarImageView) view.findViewById(R.id.forum_avatar);
        cardExtendForumItemHolder.f15222b = barImageView;
        barImageView.setGifIconSupport(false);
        cardExtendForumItemHolder.f15223c = (TextView) view.findViewById(R.id.m_forum_name_textview);
        cardExtendForumItemHolder.f15224d = (EntelechyUserLikeButton) view.findViewById(R.id.forum_add_love);
        return cardExtendForumItemHolder;
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public void d(int i) {
        if (this.f15226f != i) {
            SkinManager.setBackgroundColor(a(), R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.f15223c, R.color.CAM_X0105);
            f(this.f15224d, this.f15225e.f62208e);
        }
        this.f15226f = i;
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
