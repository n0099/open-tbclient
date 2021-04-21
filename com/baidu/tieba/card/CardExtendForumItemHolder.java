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
import d.b.j0.b1.b.c;
import d.b.j0.x.e0.g;
/* loaded from: classes4.dex */
public class CardExtendForumItemHolder extends ItemViewHolder {

    /* renamed from: b  reason: collision with root package name */
    public BarImageView f14894b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f14895c;

    /* renamed from: d  reason: collision with root package name */
    public EntelechyUserLikeButton f14896d;

    /* renamed from: e  reason: collision with root package name */
    public g f14897e;

    /* renamed from: f  reason: collision with root package name */
    public int f14898f;

    public CardExtendForumItemHolder(View view) {
        super(view);
        this.f14894b = null;
        this.f14895c = null;
        this.f14896d = null;
        this.f14898f = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public void b(c cVar) {
        if (cVar != null && (cVar instanceof g)) {
            g gVar = (g) cVar;
            this.f14897e = gVar;
            this.f14894b.setTag(gVar.f64202b);
            this.f14894b.setTag(R.id.tag_forum_name, this.f14897e.f64203c);
            this.f14894b.W(this.f14897e.f64202b, 15, false);
            TextView textView = this.f14895c;
            textView.setText(StringHelper.getFixedText(this.f14897e.f64203c, 4, true) + a().getContext().getResources().getString(R.string.forum));
            this.f14895c.setTag(R.id.tag_forum_name, this.f14897e.f64203c);
            this.f14896d.setTag(R.id.tag_forum_id, Long.valueOf(this.f14897e.f64204d));
            this.f14896d.setTag(R.id.tag_forum_name, this.f14897e.f64203c);
            a().setTag(R.id.tag_forum_id, Long.valueOf(this.f14897e.f64204d));
            a().setTag(R.id.tag_forum_name, this.f14897e.f64203c);
            f(this.f14896d, this.f14897e.f64205e);
            this.f14894b.setOnClickListener(this.f17211a);
            this.f14896d.setOnClickListener(this.f17211a);
            this.f14895c.setOnClickListener(this.f17211a);
            a().setOnClickListener(this.f17211a);
        }
        d(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public ItemViewHolder c(View view) {
        CardExtendForumItemHolder cardExtendForumItemHolder = new CardExtendForumItemHolder(view);
        BarImageView barImageView = (BarImageView) view.findViewById(R.id.forum_avatar);
        cardExtendForumItemHolder.f14894b = barImageView;
        barImageView.setGifIconSupport(false);
        cardExtendForumItemHolder.f14895c = (TextView) view.findViewById(R.id.m_forum_name_textview);
        cardExtendForumItemHolder.f14896d = (EntelechyUserLikeButton) view.findViewById(R.id.forum_add_love);
        return cardExtendForumItemHolder;
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public void d(int i) {
        if (this.f14898f != i) {
            SkinManager.setBackgroundColor(a(), R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.f14895c, R.color.CAM_X0105);
            f(this.f14896d, this.f14897e.f64205e);
        }
        this.f14898f = i;
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
