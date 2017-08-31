package com.baidu.tieba.card;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.horizonalList.widget.f {
    public EntelechyUserLikeButton bJA;
    private com.baidu.tieba.card.data.e bJB;
    public BarImageView bJy;
    public TextView bJz;
    private int mSkinType;

    public d(View view) {
        super(view);
        this.bJy = null;
        this.bJz = null;
        this.bJA = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void a(com.baidu.tieba.horizonalList.widget.d dVar) {
        if (dVar != null && (dVar instanceof com.baidu.tieba.card.data.e)) {
            this.bJB = (com.baidu.tieba.card.data.e) dVar;
            this.bJy.setTag(this.bJB.forumAvatar);
            this.bJy.setTag(d.h.tag_forum_name, this.bJB.forumName);
            this.bJy.c(this.bJB.forumAvatar, 15, false);
            this.bJz.setText(am.getFixedText(this.bJB.forumName, 4, true) + getView().getContext().getResources().getString(d.l.forum));
            this.bJz.setTag(d.h.tag_forum_name, this.bJB.forumName);
            this.bJA.setTag(d.h.tag_forum_id, Long.valueOf(this.bJB.forumId));
            this.bJA.setTag(d.h.tag_forum_name, this.bJB.forumName);
            getView().setTag(d.h.tag_forum_id, Long.valueOf(this.bJB.forumId));
            getView().setTag(d.h.tag_forum_name, this.bJB.forumName);
            a(this.bJA, this.bJB.isLiked);
            this.bJy.setOnClickListener(this.avj);
            this.bJA.setOnClickListener(this.avj);
            this.bJz.setOnClickListener(this.avj);
            getView().setOnClickListener(this.avj);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public com.baidu.tieba.horizonalList.widget.f ac(View view) {
        d dVar = new d(view);
        dVar.bJy = (BarImageView) view.findViewById(d.h.forum_avatar);
        dVar.bJy.setGifIconSupport(false);
        dVar.bJz = (TextView) view.findViewById(d.h.m_forum_name_textview);
        dVar.bJA = (EntelechyUserLikeButton) view.findViewById(d.h.forum_add_love);
        dVar.dgT = 16908308;
        return dVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.k(getView(), d.e.cp_bg_line_d);
            aj.i(this.bJz, d.e.cp_cont_b);
            a(this.bJA, this.bJB.isLiked);
        }
        this.mSkinType = i;
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(EntelechyUserLikeButton entelechyUserLikeButton, boolean z) {
        if (entelechyUserLikeButton != null) {
            entelechyUserLikeButton.setTag(d.h.forum_follow, Boolean.valueOf(z));
            entelechyUserLikeButton.aQ(z);
        }
    }
}
